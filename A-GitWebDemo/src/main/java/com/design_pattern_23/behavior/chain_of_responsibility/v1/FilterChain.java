package com.design_pattern_23.behavior.chain_of_responsibility.v1;

import java.util.ArrayList;
import java.util.List;

public class FilterChain implements Filter {
	
	private List<Filter> filters = new ArrayList<>();
	
	@Override
	public String doFilter(String str) {
		
		for(Filter f : filters){
			str = f.doFilter(str);
		}
		return str;
	}
	
	//把函数的返回值设为FilterChain，返回this,就能方便链式编写代码
	public FilterChain addFilter(Filter filter){
		filters.add(filter);
		return this;
	}

}
