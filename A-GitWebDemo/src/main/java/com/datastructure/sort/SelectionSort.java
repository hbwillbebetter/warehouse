package com.datastructure.sort;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		int[] array = {9,6,7,3,5,8,2,7,1};
		System.out.println(Arrays.toString(array));
		selectionSort(array);
		System.out.println(Arrays.toString(array));

	}
	
	
	private static void selectionSort(int[] arr) {
		int out,in,min;
		for(out = 0; out < arr.length-1; out++){//紫红色的毛巾给最矮的人
			min = out;
			for(in = out+1; in < arr.length; in++){
				if (arr[in] < arr[min]) {
					min = in;
				}
			}
			//每一趟只交换一次
			swap(out,min,arr);
		}
	}
	
	private static void swap(int one, int two, int[] arr) {
//		int temp = arr[two];
//		arr[two] = arr[one];
//		arr[one] = temp;
		
		int temp = arr[one];
		arr[one] = arr[two];
		arr[two] = temp;
	}



}
