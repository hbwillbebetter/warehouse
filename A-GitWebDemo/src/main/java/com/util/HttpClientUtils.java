package com.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;



/**
 * @author yb
 * @createTime 2019/11/4
 * @description HttpClientUtil请求工具类
 */
public class HttpClientUtils {
	public static void main(String[] args) {
		String prefix = "http://29.2.99.89:10865";//开发接口地址
		Map<String, String> param = new HashMap<String, String>();
		param.put("batchNo", "123");
		ObjectMapper mapper = new ObjectMapper();
		String p = null;
		try {
			p = mapper.writeValueAsString(param);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String result = HttpClientUtils.sendPost(prefix, p);
	}

    /**
     * 标准的post方式提交
     */
    public static String sendPost(String url, String param) {
    	  OutputStreamWriter out = null;
    	  BufferedReader in = null;
    	  String result = "";
    	  try {
    	   URL realUrl = new URL(url);
    	   // 打开和URL之间的连接
    	   URLConnection conn = realUrl.openConnection();

    	   // 设置通用的请求属性

    	   conn.setRequestProperty("accept", "*/*");
    	   conn.setRequestProperty("connection", "Keep-Alive");
    	   conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");

    	   // 发送POST请求必须设置如下两行
    	   conn.setDoOutput(true);
    	   conn.setDoInput(true);

    	   // 1.获取URLConnection对象对应的输出流
    	   // out = new PrintWriter(conn.getOutputStream());
    	   // 2.中文有乱码的需要将PrintWriter改为如下
    	   if (param != null && param.length() > 1) {
    	    out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
    	    // 发送请求参数
    	    System.out.println("param=" + param);
    	    out.write(param);
    	    // flush输出流的缓冲
    	    out.flush();
    	   }
    	   // 定义BufferedReader输入流来读取URL的响应
    	   in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
    	   String line;
    	   while ((line = in.readLine()) != null) {
    	    result += line;
    	   }

    	  } catch (Exception e) {
    	   System.out.println("发送 POST 请求出现异常！" + e);
    	   e.printStackTrace();
    	  }
    	  // 使用finally块来关闭输出流、输入流
    	  finally {
    	   try {
    	    if (out != null) {
    	     out.close();
    	    }
    	    if (in != null) {
    	     in.close();
    	    }
    	   } catch (IOException ex) {
    	    ex.printStackTrace();
    	   }
    	  }
    	  System.out.println("post推送结果：" + result);
    	  return result;
    	 }

}
