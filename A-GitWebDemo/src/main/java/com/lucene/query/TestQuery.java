package com.lucene.query;

import org.apache.commons.lang3.StringUtils;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.BooleanClause.Occur;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.FuzzyQuery;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.MatchAllDocsQuery;
import org.apache.lucene.search.NumericRangeQuery;
import org.apache.lucene.search.PhraseQuery;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.WildcardQuery;
import org.apache.lucene.util.Version;
import org.junit.Test;
import org.wltea.analyzer.lucene.IKAnalyzer;

import com.lucene.curd.LuceneUtils;

/**
 * 
 * indexSearcher.searcher(Query )
 * 
 * Query 是一个查询，条件，不同的子类相当于不同的查询规则
 * 
 * 我们可以扩展..
 * 
 * @author Administrator
 * 
 */
public class TestQuery {
    public static void main(String[] args) throws Exception {

        // testQuery();
        /**
         *  第一种查询，TermQuery
         *  这是关键字查询
         *  如果按照author查，因为author没有分词，所以查"马化腾"可以查询出来
         *  如果按照content查，因为content分词了，如果是单字分词器，只能通过某一个字查出来，比如"中"
         */
        //Query query=new TermQuery(new Term("content","中"));

        /**
         *  第二种查询：字符串搜索..
         *  使用查询字符串：QueryParser+ MultiFieldQueryParser的查询方式
         *  1、QueryParser：只在一个字段中查询
         *  2、MultiFieldQueryParser：可以在多个字段查询
         *  用来查询可以分词的字段，只要你输入的一段文本中包含分词，就会检索出来
         */
//         String[] fields={"content"};
//         
//         QueryParser queryParser=new
//         MultiFieldQueryParser(LuceneUtils.getMatchVersion(),fields,LuceneUtils.getAnalyzer());
//         Query query=queryParser.parse("中文");
        

        /**
         *  第三种查询：查询所有..
         */
//         Query query=new MatchAllDocsQuery();

        /**
         *  第四种查询：范围查询，可以使用此查询来替代过滤器...
         */
        // 我们完成一种需求有两种方式，我们推荐用这种...性能比filter要高

//         Query query=NumericRangeQuery.newIntRange("id", 1, 10, true, true);

        /**
         *  第五种查询：通配符。。。
         */
        // ?代表单个任意字符，* 代表多个任意字符...
//         Query query=new WildcardQuery(new Term("content", "一*"));

        /**
         *  第六种查询：模糊查询..。。。
         */
        // author String
        /*
         * 1:需要根据查询的条件
         * 
         * 2:最大可编辑数 取值范围0,1,2 允许我的查询条件的值，可以错误（或缺少）几个字符...
         * 
         */
//         Query query = new FuzzyQuery(new Term("author", "马化"), 1);
        /**
         * 
         * 第七种查询:短语查询
         * 
         */
//         PhraseQuery query=new PhraseQuery();
        // //(1)直接指定角标...
//         query.add(new Term("title","jumps"),0);
//         query.add(new Term("title","dog"),6);

        // (2)设置两个短语之间的最大间隔数...
        // //设置间隔数范围越大，它被匹配的结果就越多，性能也就越慢..
//         query.add(new Term("title","dog"));
//         query.add(new Term("title","jumps"));
//         query.setSlop(30);

        // 第八种查询:布尔查询
        BooleanQuery query = new BooleanQuery();
        // id 1~10
        Query query1 = NumericRangeQuery.newIntRange("id", 1, 30, true, true);

        Query query2 = NumericRangeQuery.newIntRange("id", 1, 10, true, true);

        // select * from table where title=? or content=?

        // 必须满足第一个条件...
        query.add(query1, Occur.MUST);

        // 可以满足第二个条件
        query.add(query2, Occur.SHOULD);
        testQuery(query);
    }
    
    /**
     * 其中， 布尔查询很重要，可以实现像京东、淘宝上面的多级检索的效果，示例代码如下：
     * @throws ParseException 
     */
    @Test
    public void testBooleanQuery(String projId, String belongTo, String queryString) throws ParseException{
    	IKAnalyzer ikAnalyzer = new IKAnalyzer();
    	//封装查询条件(使用BooleanQuery对象，连接多个查询条件)
        BooleanQuery query = new BooleanQuery();
        //条件一（所属单位）
        if(StringUtils.isNotBlank(projId)){
            //词条查询
            TermQuery query1 = new TermQuery(new Term("projId", projId));
            //Occur.SHOULD相当于or
            query.add(query1, Occur.MUST);//Occur.MUST相当与sql语句的and
        }
        //条件二（图纸类别）
        if(StringUtils.isNotBlank(belongTo)){
            //词条查询
            TermQuery query2 = new TermQuery(new Term("belongTo", belongTo));
            query.add(query2, Occur.MUST);//相当与sql语句的and
        }
        
        //条件三（文件名称和文件描述）
        if(StringUtils.isNotBlank(queryString)){
            //多个字段进行检索的时候，查询使用QueryPaser
            //要是直接new QueryParser()，也可以，但是只能查询一个字段
            QueryParser queryParser = new MultiFieldQueryParser(Version.LUCENE_CURRENT,new String[]{"fileName","comment"},ikAnalyzer);
            Query query3 = queryParser.parse(queryString);
            query.add(query3, Occur.MUST);//相当与sql语句的and
        }
    	
    	
    	
    }

    public static void testQuery(Query query) throws Exception {
        IndexSearcher indexSearcher = LuceneUtils.getIndexSearcher();
        TopDocs topDocs = indexSearcher.search(query, 100);
        System.out.println("总记录数：" + topDocs.totalHits);
        for (ScoreDoc scoreDoc : topDocs.scoreDocs) {
        	int docId = scoreDoc.doc;
        	System.out.println("******************");
        	System.out.println("文档编号："+docId);
            Document document = indexSearcher.doc(docId);
            System.out.println(document.get("id"));
            System.out.println(document.get("title"));
            System.out.println(document.get("content"));
            System.out.println(document.get("author"));
            System.out.println(document.get("link"));
        }

    }

}
