package com.design_pattern_23.behavior.strategy.v2;

import java.util.Arrays;
import java.util.List;

public class SortingMainV2 {

	public static void main(String[] args) {
		List list = Arrays.asList(new Integer[]{ 44, 5, 3, 5, 5, 64, 3 });
		
		QuickSortStrategy qs = new QuickSortStrategy();
		SortingManagerV2 sm = new SortingManagerV2(list, qs);
		sm.sortList();
		
		System.out.println();
		
		MergeSortStrategy ms = new MergeSortStrategy();
		sm.setSortingStrategy(ms);
		sm.sortList();
		
		System.out.println();
		
		HeapSortStrategy hs = new HeapSortStrategy();
		sm.setSortingStrategy(hs);
		sm.sortList();
		
		System.out.println();
		
	}

}
