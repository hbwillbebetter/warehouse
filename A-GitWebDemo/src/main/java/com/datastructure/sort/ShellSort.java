package com.datastructure.sort;

import java.util.Arrays;
//希尔排序---------设定步长的插入排序
public class ShellSort {
	public static void main(String[] args) {
		int[] arr = {9,6,7,3,5,8,2,3,7};
		System.out.println(Arrays.toString(arr));
		shellSort(arr);
		System.out.println(Arrays.toString(arr));
	} 

	public static void shellSort(int[] arr) {
		int k =0;
		//外层循环--需要每轮遍历的步长，边界值：步长step>0
		for(int step=arr.length / 2; step>0; step /= 2){
			k++;
			//遍历每一轮中的所有元素,并做相应步长的插入排序
			for(int i = step; i<arr.length; i++){
				int j = i;
				int temp = arr[j];
				while(j-step>=0 && temp < arr[j-step]){
					arr[j] = arr[j-step];
					j -= step;
				}
				arr[j] = temp;
			}
			System.out.println("第"+k+"轮："+Arrays.toString(arr));
		}
		
	}
	
	public static void shellSort2(int[] arr) {
		int k = 1;
		// 遍历所有的步长
		for (int d = arr.length / 2; d > 0; d /= 2) {
			// 遍历所有有元素
			for (int i = d; i < arr.length; i++) {
				// 遍历本组中所有的元素
				for (int j = i - d; j >= 0; j -= d) {
					// 如果当前元素大于加上步长后的那个元素
					if (arr[j] > arr[j + d]) {
						int temp = arr[j];
						arr[j] = arr[j + d];
						arr[j + d] = temp;
					}
				}
			}
			System.out.println("第" + k + "次排序结果：" + Arrays.toString(arr));
			k++;
		}
	}
}
