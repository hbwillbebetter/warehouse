package com.datastructure.sort;

import java.util.Arrays;
//插入排序
public class InsertSort {
	public static void main(String[] args) {
		int[] array = {9,6,7,3,5,8,2,3,7};
		System.out.println(Arrays.toString(array));
		insertSort(array);
		System.out.println(Arrays.toString(array));
		
	} 

	public static void insertSort(int[] array) {
		//一共需要进行array.length-1轮，第一轮默认第一个有序
		for(int i=1; i<array.length; i++){
			//记录需要比较的位置
			int j=i;//这个j就是即将要比较，待插入的元素的起始下标
			int temp = array[j];//记录待插入的元素
			//先将待插入的元素和左边有序的数组最大位置的元素进行比较，如果满足temp<array[j-1],则循环依次和左边比较，位置从大到小
			while(j > 0 && temp < array[j-1]){
				//前一个位置元素，往后挪一位
				array[j] = array[j-1];
				j--;
			}
			//最后插入待排序的元素
			array[j] = temp;
		}
		
	}
}
