package com.design_pattern_23.behavior.strategy.v1;

import java.util.Arrays;
import java.util.List;

import com.design_pattern_23.behavior.strategy.SortingType;

public class SortingMainV1 {

	public static void main(String[] args) {
		List list = Arrays.asList(new Integer[]{ 44, 5, 3, 5, 5, 64, 3 });
		SortingManagerV1 sm = new SortingManagerV1(list);
		
		// Sorting using merge sort
		sm.sortListBasedOnType(SortingType.MERGE_SORT);
		
		System.out.println();
		
		// Sorting using quick sort
		sm.sortListBasedOnType(SortingType.QUICK_SORT);
		
		System.out.println();
		
		// Sorting using quick sort
		sm.sortListBasedOnType(SortingType.HEAP_SORT);
		
		System.out.println();
		
	}

}
