package com.design_pattern_23.behavior.chain_of_responsibility.v2;

public interface Filter {
	
	public void doFilter(Request request, Response response, FilterChain filterChain); 
}
