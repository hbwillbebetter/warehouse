package com.lucene.Analyzer;

import java.io.IOException;
import java.io.StringReader;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.cjk.CJKAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.util.Version;
import org.wltea.analyzer.lucene.IKAnalyzer;

public class TestAnalyzer {

    public static void main(String[] args) {
        //单字分词器
//        Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_44);
        //二分法分词器
        //Analyzer analyzer = new CJKAnalyzer(Version.LUCENE_44);
        
        //第三方的中文分词器，庖丁分词，中文分词，特点：扩展新的词，自定义停用词
        Analyzer analyzer = new IKAnalyzer();
        String text = "腾讯网(www.QQ.com)是中国浏览量最大的中文门户网站,是腾讯公司推出的集新闻信息、互动社区、娱乐产品和基础服务为一体的大型综合门户网站。腾讯网服务于全球华人...";
        try {
            testAnalyzer(analyzer, text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 分词器的作用
     * 
     * @throws IOException
     */
    public static void testAnalyzer(Analyzer analyzer, String text)
            throws IOException {
        System.out.println("当前使用的分词器：" + analyzer.getClass().getSimpleName());
        TokenStream tokenStream = analyzer.tokenStream("content",
                new StringReader(text));
        tokenStream.addAttribute(CharTermAttribute.class);
        //这里不写这一句，会报空指针异常
        tokenStream.reset();
        while (tokenStream.incrementToken()) {
            CharTermAttribute charTermAttribute = tokenStream
                    .getAttribute(CharTermAttribute.class);
            System.out.println(new String(charTermAttribute.toString()));
        }
    }
}
