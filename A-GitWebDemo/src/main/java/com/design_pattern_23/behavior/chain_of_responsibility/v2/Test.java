package com.design_pattern_23.behavior.chain_of_responsibility.v2;

/**
 * 
一、目标

1.用Filter模拟处理Request、Response

2.思路细节技巧：

(1)Filter的doFilter方法改为doFilter(Request,Resopnse,FilterChain),有FilterChain引用，为利用FilterChain调用下一个Filter做准备

(2)FilterChain继承Filter,这样，FilterChain既是FilterChain又是Filter,那么FilterChain就可以调用Filter的方法doFilter(Request,Resopnse,FilterChain)

(3)FilterChain的doFilter(Request,Resopnse,FilterChain)中，有index标记了执行到第几个Filter,当所有Filter执行完后request处理后，就会return,以倒序继续执行response处理
 *
 */
public class Test {
	
	@org.junit.Test
	public void testFilter(){
		
		String msg = "<html>敏感字眼</html>";
		
		Request request = new Request();
		request.setRequestStr(msg);
		Response response = new Response();
		response.setResponseStr("response--------");
		
		FilterChain fc = new FilterChain();
		fc.addFilter(new HTMLFilter()).addFilter(new SensitiveFilter());
		
		fc.doFilter(request, response, fc);
		
		System.out.println(request.getRequestStr());
		System.out.println(response.getResponseStr());
		
		
	}
	
	
}
