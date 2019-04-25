package com.datastructure.sort;

import java.util.Arrays;

//冒泡排序
public class BubbleSort {

	public static void main(String[] args) {
		
		int[] array = {9,6,7,3,5,8,2,7,1};
		System.out.println(Arrays.toString(array));
		bubbleSort(array);
		System.out.println(Arrays.toString(array));
		
	}
	
	public static void bubbleSort(int[] array) {
		//外层控制排序的轮数（两个数，只需要一轮比较；三个数，只需要两轮比较；得出n个数只需要n-1轮比较，默认第一个数是不需要排的）
		for(int i=0; i<array.length-1; i++){
			//内层控制相邻元素比较，大的放右边;每一轮过后需要两两比较的数据-1
			for(int j=0; j<array.length-1-i; j++){
				if(array[j] > array[j+1]){//交换位置
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
		
	}

}
