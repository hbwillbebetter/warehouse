package com.design_pattern_23.behavior.chain_of_responsibility.v1;

public class HTMLFilter implements Filter {

	@Override
	public String doFilter(String str) {
		return str.replaceAll("<", "[").replaceAll(">", "]");
	}

}
