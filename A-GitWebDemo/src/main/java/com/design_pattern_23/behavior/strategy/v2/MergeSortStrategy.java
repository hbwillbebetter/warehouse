package com.design_pattern_23.behavior.strategy.v2;

import java.util.List;

public class MergeSortStrategy implements SortingStrategy {

	@Override
	public void sort(List<Integer> list) {
		System.out.println("Sorting List using merge sort");
	}

}
