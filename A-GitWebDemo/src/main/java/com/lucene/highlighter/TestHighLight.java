package com.lucene.highlighter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.highlight.Formatter;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.SimpleFragmenter;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
import org.wltea.analyzer.lucene.IKAnalyzer;

import com.lucene.curd.Article;
import com.lucene.curd.LuceneUtils;

public class TestHighLight {
	public static void main(String[] args) {
		String keywords = "中";
		List<Article> list = findIndex(keywords, 0, 10);
	}
	
	/**
     * 查询是通过IndexSearch提供的(分页)
     */
	public static List<Article> findIndex(String keywords, int start, int count) {
//		Analyzer analyzer = new IKAnalyzer();
		Analyzer analyzer = LuceneUtils.getAnalyzer();
        try {
            IndexSearcher indexSearcher = LuceneUtils.getIndexSearcher();

            // ===========================================================
            // 这里是第二种query方式，不是termQuery
            QueryParser queryParser = new MultiFieldQueryParser(
                    LuceneUtils.getMatchVersion(), new String[] { "title",
                            "content" }, analyzer);
            Query query = queryParser.parse(keywords);
            TopDocs topDocs = indexSearcher.search(query, 100);
            System.out.println("总记录数：" + topDocs.totalHits);

            /**
             * 添加设置文字高亮begin 使用lucene自带的高亮器进行高亮显示
             */
            // html页面高亮显示的格式化，默认是<b></b>
            Formatter formatter = new SimpleHTMLFormatter("<font color='red'><b>", "</b></font>");
            //执行查询条件，因为高亮的值就是查询条件
            QueryScorer scorer = new QueryScorer(query);
            Highlighter highlighter = new Highlighter(formatter, scorer);
            
            //设置文字摘要，此时摘要大小
            int fragmentSize  = 100;
            SimpleFragmenter fragmenter = new SimpleFragmenter(fragmentSize);
            highlighter.setTextFragmenter(fragmenter);
            /** 添加设置文字高亮end */
            // 表示返回的结果集
            // 表示返回的结果集
            ScoreDoc[] scoreDocs = topDocs.scoreDocs;
            List<Article> list = new ArrayList<Article>();
            int min = Math.min(scoreDocs.length, start+count);
            for(int i= start; i < min; i++){
            	 //System.out.println("相关度得分：" + scoreDocs[i].score);
                // 获取查询结果的文档的惟一编号，只有获取惟一编号，才能获取该编号对应的数据
            	int doc = scoreDocs[i].doc;
                // 使用编号，获取真正的数据
                Document document = indexSearcher.doc(doc);
                
                /** 获取文字高亮的信息 begin */
                // 获取文字的高亮，一次只能获取一个字段高亮的结果，如果获取不到，返回null值
                // 高亮之后的title
                // 注意：如果这个字段当中没有包含搜索关键字，你对这个字段的值进行高亮，返回的是null
            	String title = highlighter.getBestFragment(analyzer, "title", document.get("title"));
            	// 如果null表示没有高亮的结果，如果高亮的结果，应该将原值返回
            	if(title == null){
            		title = document.get("title");
            		if(title != null && title.length() > fragmentSize){
            			//截串，从0开始
            			title = title.substring(0, fragmentSize);
            		}
            	}
            	System.out.println("-----------title:" + title);
            	// 高亮之后的content
                // 注意：如果这个字段当中没有包含搜索关键字，你对这个字段的值进行高亮，返回的是null
                String content = highlighter.getBestFragment(
                        analyzer, "content",
                        document.get("content"));
                // 如果null表示没有高亮的结果，如果高亮的结果，应该将原值返回
                if (content == null) {
                	content = document.get("content");
                	if (content != null && content.length() > fragmentSize) {
                		// 截串，从0开始
                		content = content.substring(0, fragmentSize);
                	}
                }
                System.out.println("--------content:" + content);
                /** 获取文字高亮的信息 end */
                Article article = new Article();
                article.setId(Integer.parseInt(document.get("id")));
                article.setAuthor(document.get("author"));
                article.setLink(document.get("link"));
                article.setTitle(title);//高亮之后的
                article.setContent(content);//高亮之后的
                list.add(article);
            }
            return list;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
	}
}
