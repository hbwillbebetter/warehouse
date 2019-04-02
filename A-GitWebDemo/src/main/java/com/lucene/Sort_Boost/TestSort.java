package com.lucene.Sort_Boost;

import java.io.File;
import java.io.IOException;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.SortField;
import org.apache.lucene.search.SortField.Type;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.junit.Test;

import com.lucene.curd.Article;
import com.lucene.curd.ArticleUtils;
import com.lucene.curd.Constant;
import com.lucene.curd.LuceneUtils;

public class TestSort {
	@Test
	public void testSort() throws Exception{
		Directory directory = FSDirectory.open(new File(Constant.FILEURL));
		IndexReader indexReader = DirectoryReader.open(directory);

		IndexSearcher indexSearcher = new IndexSearcher(indexReader);
		
		String fields[] = { "content" };

		QueryParser queryParser = new MultiFieldQueryParser(
		        LuceneUtils.getMatchVersion(), fields,
		        LuceneUtils.getAnalyzer());
		// 不同的规则构造不同的子类..
		// title:keywords ，content:keywords
		Query query = queryParser.parse("第一");
		Sort sort = new Sort();
		// 升序
		// SortField sortField=new SortField("id", Type.INT);
		// 降序
		SortField sortField = new SortField("id", Type.INT, true);

		// 设置排序的字段...
		sort.setSort(sortField);
		TopDocs topDocs = indexSearcher.search(query, 100, sort);
		//注意：String类型和Int类型在比较排序的时候不同
		//例如：Int：123>23
//		     String:”123”<“23”
		System.out.println("总记录数：" + topDocs.totalHits);
        //表示返回的结果集
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;
        for(ScoreDoc scoreDoc : scoreDocs){
//        	System.out.println("相关得分:"+scoreDoc.score);
        	int doc = scoreDoc.doc;
        	Document document = indexSearcher.doc(doc);
            Article article = ArticleUtils.documentToArticle(document);
            System.out.println(article.getId());
            System.out.println(article.getAuthor());
            System.out.println(article.getTitle());
            System.out.println(article.getContent());
            System.out.println(article.getLink());
        }
        
        
	}
}
