package com.algorithm_suanfa.Anagram;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 参考网址：https://blog.csdn.net/Gane_Cheng/article/details/52652705#commentBox（排序图很重要）
 * 
 * 
 * 对字符串进行快速排序，时间复杂度：O(n*logn)
 * @author B
 *
 */
public class CharsQuickSort_char {
	public static final int SIZE = 100;
	
	public static void main(String[] args) {
		
		char a[] = new char[SIZE];
		System.out.println("请输入一个待排序的字符串：");
		Scanner scanner = new Scanner(System.in);
		a = scanner.next().toCharArray();
		System.out.println("排序前:");
        System.out.println(Arrays.toString(a));
        
        //排序
        charsQuickSort(a,0,a.length-1);
        
        System.out.println("排序后:");
        System.out.println(Arrays.toString(a));
		
		
	}
	
	public static void charsQuickSort(char[] a, int left, int right) {
		int p;
		if (left < right) {
			//选出p点对应数组元素的大小，满足永远比左边大，比右边小【第一次分段，目的将第一个基准值/最后一个基准值放到后续左右待排数组的中间，即a[p]】
			p = charsPartition(a,left,right);
			charsQuickSort(a, left, p-1);
			charsQuickSort(a, p+1, right);
			
		}
	}
	
	
	public static int charsPartition(char[] a, int left, int right) {
		char temp;
		int l,r;
		l=left;
		r=right;
		temp = a[l];
		while(l < r){
			while(l<r && a[r]>=temp){
				r--;
			}
			a[l]=a[r];
			while(l<r && a[l]<=temp){
				l++;
			}
			a[r]=a[l];
		}
		a[l]=temp;
		return l;
	}
	/**
	 * 
	 * 注意：
	 * char temp = a[l];
	 * a[l]=a[r];
	 * 上面两行代码不会影响temp值的变化，因为temp被临时存储
	 * 
	 */
	
}
