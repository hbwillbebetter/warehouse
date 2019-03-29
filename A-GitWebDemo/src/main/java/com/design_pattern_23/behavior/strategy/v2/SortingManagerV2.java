package com.design_pattern_23.behavior.strategy.v2;

import java.util.List;

public class SortingManagerV2 {
	
	List<Integer> list;
	SortingStrategy sortingStrategy;
	
	public SortingManagerV2(List<Integer> list, SortingStrategy sortingStrategy){
		this.list = list;
		this.sortingStrategy = sortingStrategy;
	}
	
	public void sortList() {
		System.out.println("===================================");
		System.out.println("Sorting List based on Type");
		System.out.println("===================================");
		this.sortingStrategy.sort(list);
	}

	public List<Integer> getList() {
		return list;
	}

	public void setList(List<Integer> list) {
		this.list = list;
	}

	public SortingStrategy getSortingStrategy() {
		return sortingStrategy;
	}

	public void setSortingStrategy(SortingStrategy sortingStrategy) {
		this.sortingStrategy = sortingStrategy;
	}
	
	
	
	
}
