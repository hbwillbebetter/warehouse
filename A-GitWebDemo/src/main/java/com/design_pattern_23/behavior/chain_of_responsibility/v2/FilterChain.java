package com.design_pattern_23.behavior.chain_of_responsibility.v2;

import java.util.ArrayList;
import java.util.List;

public class FilterChain implements Filter {
	
	private List<Filter> filters = new ArrayList<>();
	private int index = 0;//记录执行到第几个filter
	
	@Override
	public void doFilter(Request request, Response response,
			FilterChain filterChain) {
		if(index == filters.size()) return;
		Filter filter = filters.get(index);
		index++;
		filter.doFilter(request, response, filterChain);
	}


	//把函数的返回值设为FilterChain，返回this,就能方便链式编写代码
	public FilterChain addFilter(Filter filter){
		filters.add(filter);
		return this;
	}

}
