package com.design_pattern_23.behavior.chain_of_responsibility.v1;


public class Test {
	
	@org.junit.Test
	public void testFilter(){
		
		String msg = "<html>敏感字眼</html>";
		MsgProcessor processor = new MsgProcessor();
		processor.setMessage(msg);
		
		FilterChain f1 = new FilterChain();
		f1.addFilter(new HTMLFilter());
		
		FilterChain f2 = new FilterChain();
		f2.addFilter(new SensitiveFilter());
		
		f1.addFilter(f2);
		
		processor.setFilterChain(f1);
		
		String result = processor.process();
		System.out.println(result);
		
		
	}
	
	
}
