package com.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.log4j.Logger;
/**
 *  在业务预约和后勤报修项目中，登录模块经常需要和微信、微校进行数据的交换，腾讯官方给出的方式使用Http方式，现在总结一下项目中通用的HttpUtils。
	HttpClient最基本的功能就是执行http方法，执行http方法包括了一次或者几次HTTP请求和相应的变化，通常也是通过HttpClient来处理的。
	只要用户提供一个request的对象，HttpClient就会将用户的请求发送到目标服务器上，并且返回一个respone对象，如果没有执行成功将抛出一个异常。
	---
	发送HTTP请求一般可以分为以下步骤
	取得HttpClient对象
	封装http请求
	执行http请求
	处理结果
	其中可以发送的请求类型有GET, HEAD, POST, PUT, DELETE, TRACE 和 OPTIONS
 *
 */
public class HttpUtils {
	
	private static Logger log = Logger.getLogger(HttpUtils.class);
	 //因为请求链接里需要一些特殊字符来拼接参数，这里将它们定义成变量，方便以后修改
	    private static final String URL_PARAM_CONNECT_FLAG = "&";
	    private static final String EMPTY = "";
	 
	//声明一个多线程安全连接管理类变量，关于该类的简单介绍  https://blog.csdn.net/fairytall/article/details/7938692
	//使用这个对象简单来说就是为了不去考虑多线程带来安全的问题
	    private static MultiThreadedHttpConnectionManager connectionManager = null;
	//将参数提取成变量，方便以后修改
	    private static int connectionTimeOut = 25000;
	 
	    private static int socketTimeOut = 25000;
	 
	    private static int maxConnectionPerHost = 20;
	 
	    private static int maxTotalConnections = 20;
	//声明client变量，用于执行请求的
	    private static HttpClient client;
	 
	    static {
	        connectionManager = new MultiThreadedHttpConnectionManager();
	        connectionManager.getParams().setConnectionTimeout(connectionTimeOut);
	        connectionManager.getParams().setSoTimeout(socketTimeOut);
	        connectionManager.getParams().setDefaultMaxConnectionsPerHost(maxConnectionPerHost);
	        connectionManager.getParams().setMaxTotalConnections(maxTotalConnections);
	        client = new HttpClient(connectionManager);
	    }
	 
	    /**
	     * POST方式提交数据
	     *
	     * @param url    待请求的URL
	     * @param params 要提交的数据
	     * @param enc    编码
	     * @return 响应结果
	     * @throws IOException IO异常
	     */
	    public static Map<String, Object> URLPost(String url, Map<String, String> params, String enc){
	        //创建一个Map集合，用于存储返回结果
	        Map<String,Object> result = new HashMap<>();
	        String response = EMPTY;
	        //创建一个请求方式对象
	        PostMethod postMethod = null;
	        try {
	            postMethod = new PostMethod(url);
	            postMethod.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=" + enc);
	            //将请求参数放入postMethod中
	            if(params!=null) {
	                Set<String> keySet = params.keySet();
	                for (String key : keySet) {
	                    String value = params.get(key);
	                    postMethod.addParameter(key, value);
	                }
	            }
	            //执行postMethod
	            int statusCode = client.executeMethod(postMethod);
	            if (statusCode == HttpStatus.SC_OK) {                //HttpStatus.SC_OK就是200，服务器正确处理了请求
	                response = postMethod.getResponseBodyAsString(); //返回字符串格式的结果
	                result.put("status",200);                        //封装状态信息和结果
	                result.put("data",response);
	            } else {
	                result.put("status",postMethod.getStatusCode());
	                result.put("data",null);
	            }
	        } catch (HttpException e) {
	            log.error("请求url:"+url+",发生致命的异常，可能是协议不对或者返回的内容有问题", e);
	            e.printStackTrace();
	        } catch (IOException e) {
	            log.error("请求url:"+url+",发生网络异常", e);
	            e.printStackTrace();
	        } finally {
	            if (postMethod != null) {                           //这里一定要手动释放掉对象
	                postMethod.releaseConnection();
	                postMethod = null;
	            }
	        }
	        return result;
	    }
	 
	//这个方法与上面相同，只不过请求参数是json格式的
	    public static Map<String, Object> URLPost(String url, String json, String enc){
	 
	        Map<String,Object> result = new HashMap<>();
	        String response = EMPTY;
	        PostMethod postMethod = null;
	        try {
	            postMethod = new PostMethod(url);
	            RequestEntity se = new StringRequestEntity(json, "application/json", "UTF-8");
	            postMethod.setRequestEntity(se);
	            //执行postMethod
	            int statusCode = client.executeMethod(postMethod);
	            if (statusCode == HttpStatus.SC_OK) {
	                response = postMethod.getResponseBodyAsString();
	                result.put("status",200);
	                result.put("data",response);
	            } else {
	                result.put("status",postMethod.getStatusCode());
	                result.put("data",null);
	            }
	        } catch (HttpException e) {
	            log.error("发生致命的异常，可能是协议不对或者返回的内容有问题", e);
	            e.printStackTrace();
	        } catch (IOException e) {
	            log.error("发生网络异常", e);
	            e.printStackTrace();
	        } finally {
	            if (postMethod != null) {
	                postMethod.releaseConnection();
	                postMethod = null;
	            }
	        }
	        return result;
	    }
	 
	    /**
	     * GET方式提交数据
	     *
	     * @param url    待请求的URL
	     * @param params 要提交的数据
	     * @param enc    编码
	     * @return 响应结果
	     * @throws IOException IO异常
	     */
	    public static String URLGet(String url, Map<String, String> params, String enc) {
	 
	        String response = EMPTY;
	        GetMethod getMethod = null;
	        StringBuffer strtTotalURL = new StringBuffer(EMPTY);
	 
	        if (strtTotalURL.indexOf("?") == -1) {          //返回结果是-1代表没有找到该字符串，那么就在url后面拼接一个问号
	            strtTotalURL.append(url).append("?").append(getUrl(params, enc));
	        } else {
	            strtTotalURL.append(url).append("&").append(getUrl(params, enc));
	        }
	        
	        try {
	            getMethod = new GetMethod(strtTotalURL.toString());
	            getMethod.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=" + enc);
	            //执行getMethod
	            int statusCode = client.executeMethod(getMethod);
	            if (statusCode == HttpStatus.SC_OK) {
	                response = getMethod.getResponseBodyAsString();
	            } else {
	                response=null;
	            }
	        } catch (HttpException e) {
	            log.error("发生致命的异常，可能是协议不对或者返回的内容有问题", e);
	            e.printStackTrace();
	        } catch (IOException e) {
	            log.error("发生网络异常", e);
	            e.printStackTrace();
	        } finally {
	            if (getMethod != null) {
	                getMethod.releaseConnection();
	                getMethod = null;
	            }
	        }
	 
	        return response;
	    }
	 
	    /**
	     * 据Map生成URL字符串
	     *
	     * @param map      Map
	     * @param valueEnc URL编码
	     * @return URL
	     */
	    private static String getUrl(Map<String, String> map, String valueEnc) {
	 
	        if (null == map || map.keySet().size() == 0) {
	            return (EMPTY);
	        }
	        StringBuffer url = new StringBuffer();
	        Set<String> keys = map.keySet();
	        for (Iterator<String> it = keys.iterator(); it.hasNext(); ) {
	            String key = it.next();
	            if (map.containsKey(key)) {
	                String val = map.get(key);
	                String str = val != null ? val : EMPTY;
	                try {
	                    str = URLEncoder.encode(str, valueEnc);
	                } catch (UnsupportedEncodingException e) {
	                    e.printStackTrace();
	                }
	                url.append(key).append("=").append(str).append(URL_PARAM_CONNECT_FLAG);
	            }
	        }
	        String strURL = EMPTY;
	        strURL = url.toString();
	//这是为了保证  “&”符号后面一定有参数，如果“&”后面没有东西就把“&”去掉
	        if (URL_PARAM_CONNECT_FLAG.equals(EMPTY + strURL.charAt(strURL.length() - 1))) {
	            strURL = strURL.substring(0, strURL.length() - 1);
	        }
	 
	        return (strURL);
	    }
	}

