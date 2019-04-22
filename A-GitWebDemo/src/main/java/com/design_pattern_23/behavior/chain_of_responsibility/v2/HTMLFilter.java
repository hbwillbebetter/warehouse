package com.design_pattern_23.behavior.chain_of_responsibility.v2;

public class HTMLFilter implements Filter {

	@Override
	public void doFilter(Request request, Response response,
			FilterChain filterChain) {
		String requestStr = request.getRequestStr().replace('<', '[').replace(">", "]")+"---HTMLFilter()";
		request.setRequestStr(requestStr);
		
		filterChain.doFilter(request, response, filterChain);
		
		String responseStr = response.getResponseStr()+"---HTMLFilter()";
		response.setResponseStr(responseStr);
	}

	
}
