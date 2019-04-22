package com.design_pattern_23.behavior.chain_of_responsibility.v2;

public class SensitiveFilter implements Filter {

	@Override
	public void doFilter(Request request, Response response,
			FilterChain filterChain) {
		String requestStr = request.getRequestStr().replace("敏感", "幸福")+"---SensitiveFilter()";
		request.setRequestStr(requestStr);
		
		filterChain.doFilter(request, response, filterChain);
		
		String responseStr = response.getResponseStr()+"---SensitiveFilter()";
		response.setResponseStr(responseStr);
	}

	
}
