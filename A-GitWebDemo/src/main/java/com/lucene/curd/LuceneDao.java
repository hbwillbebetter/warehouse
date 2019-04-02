package com.lucene.curd;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.login.Configuration;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.queryparser.flexible.core.util.StringUtils;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;

/**
 * 相关度得分：
 * 内容一样，搜索关键字一样，得分也是一样的
 * 我们可以人工干预得分，就是通过ArticleUtils类中的titleField.setBoost(4f);这样
 * 得分跟搜索关键字在文章当中出现的频率、次数、位置有关系
 * @author chenchi
 *
 */
public class LuceneDao {
    /**
     * 增删改索引都是通过IndexWriter对象来完成
     */
    public void addIndex(Article article) {
        try {
            IndexWriter indexWriter = LuceneUtils.getIndexWriter();
            indexWriter.addDocument(ArticleUtils.articleToDocument(article));
            indexWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 删除索引，根据字段对应的值删除
     * @param fieldName
     * @param fieldValue
     * @throws IOException 
     */
    public void deleteIndex(String fieldName, String fieldValue) throws IOException {
        IndexWriter indexWriter = LuceneUtils.getIndexWriter();
        //使用词条删除
        Term term = new Term(fieldName, fieldValue);
        indexWriter.deleteDocuments(term);
        indexWriter.close();
    }

    /**
     * 先删除符合条件的记录，再创建一个新的纪录
     * @param fieldName
     * @param fieldValue
     * @param article
     * @throws IOException
     */
    public void updateIndex(String fieldName, String fieldValue, Article article) throws IOException {
        IndexWriter indexWriter = LuceneUtils.getIndexWriter();
        
        Term term = new Term(fieldName, fieldValue);
        Document doc = ArticleUtils.articleToDocument(article);
        /**
         * 1.设置更新的条件
         * 2.设置更新的内容和对象
         */
        indexWriter.updateDocument(term, doc);
        indexWriter.close();
    }

    /**
     * 查询是通过IndexSearch提供的(分页)
     */
    public List<Article> findIndex(String keywords, int start, int count) {
        try {
            IndexSearcher indexSearcher = LuceneUtils.getIndexSearcher();
            
            //===========================================================
            //这里是第二种query方式，不是termQuery
            QueryParser queryParser = new MultiFieldQueryParser(
                    LuceneUtils.getMatchVersion(), new String[] { "title",
                            "content" }, LuceneUtils.getAnalyzer());
            Query query = queryParser.parse(keywords);
            TopDocs topDocs = indexSearcher.search(query, 100);
            System.out.println("总记录数：" + topDocs.totalHits);
            //表示返回的结果集
            ScoreDoc[] scoreDocs = topDocs.scoreDocs;
            List<Article> list = new ArrayList<Article>();
            
            int min = Math.min(scoreDocs.length, start + count);
            for (int i = start; i < min; i++) {
                System.out.println("相关度得分："+scoreDocs[i].score);
                //获取查询结果的文档的惟一编号，只有获取惟一编号，才能获取该编号对应的数据
                int doc = scoreDocs[i].doc;
                //使用编号，获取真正的数据
                Document document = indexSearcher.doc(doc);
                Article article = ArticleUtils.documentToArticle(document);
                list.add(article);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}