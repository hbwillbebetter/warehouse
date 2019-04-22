package com.design_pattern_23.behavior.chain_of_responsibility.v1;

public class MsgProcessor {
	
	FilterChain filterChain;
	String message;
	
	public FilterChain getFilterChain() {
		return filterChain;
	}

	public void setFilterChain(FilterChain filterChain) {
		this.filterChain = filterChain;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	public String process(){
		return filterChain.doFilter(message);
	}
	
	
}
