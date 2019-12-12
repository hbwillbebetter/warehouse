package com.algorithm_suanfa.nextWeek;

import java.util.Arrays;
public class TestQuickSort {
	public static void main(String[] args) {
		int[] a = { 57, 68, 59, 52, 72, 28, 96, 33, 24, 19 };
		System.out.println("排序前:");
		System.out.println(Arrays.toString(a));

		//排序
		charsQuickSort(a,0,a.length-1);

		System.out.println("排序后:");
		System.out.println(Arrays.toString(a));
	}

	private static void charsQuickSort(int[] a, int left, int right) {
		if (left < right) {
			int p = quickSort(a,left,right);
			charsQuickSort(a, left, p-1);
			charsQuickSort(a, p+1, right);
		}
	}

	private static int quickSort(int[] a, int left, int right) {
		int temp;
		int l,r;
		l = left;
		r = right;
		temp = a[l];
		while(l < r){
			while(a[r]>=temp && l<r){
				r--;
			}
			a[l]=a[r];
			while(a[l]<=temp && l<r){
				l++;
			}
			a[r]=a[l];
		}
		a[l] = temp;
		return l;
	}
}

