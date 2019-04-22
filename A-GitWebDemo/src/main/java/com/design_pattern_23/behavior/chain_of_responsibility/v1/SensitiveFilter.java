package com.design_pattern_23.behavior.chain_of_responsibility.v1;

public class SensitiveFilter implements Filter {

	@Override
	public String doFilter(String str) {
		return str.replaceAll("敏感", "幸福");
	}

}
