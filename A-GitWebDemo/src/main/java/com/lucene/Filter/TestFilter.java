package com.lucene.Filter;

import java.io.File;
import java.io.IOException;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.Filter;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.NumericRangeFilter;
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

public class TestFilter {
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

		/**
		 * 1:需要根据那个字段进行过滤
		 * 
		 * 2:字段对应的最小值
		 * 
		 * 3:字段对应的最大值
		 * 
		 * 4:是否包含最小值
		 * 
		 * 5：是否包含最大值...
		 * 
		 * 
		 */
		// filter 是一个抽象类，定义不同的filter 相当于是不同的过滤规则...
		Filter filter = NumericRangeFilter
				.newIntRange("id", 1, 25, true, true);

		TopDocs topDocs = indexSearcher.search(query, filter, 100);
		System.out.println("总记录数：" + topDocs.totalHits);
        //表示返回的结果集
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;
        for(ScoreDoc scoreDoc : scoreDocs){
        	System.out.println("相关得分:"+scoreDoc.score);
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
