package com.datastructure.sort;

import java.util.Arrays;

//归并排序
public class mergeSort {

	public static void main(String[] args) {
		int[] arr = {8,5,6,5,0,2,1,4};
		System.out.println(Arrays.toString(arr));
		mergeSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
		
	}
	
	private static void mergeSort(int[] arr, int low, int hight) {
		//记录中间位置
		int mid = (low + hight)/2;
		if(low < hight){
			//递归划分左右两边数组
			mergeSort(arr, low, mid);
			mergeSort(arr, mid+1, hight);
			//待划分的左右两个数组有序后，将两个有序的数组合并到一个新数组
			merge(arr, low, mid, hight);
		}
	}

//	public static void main(String[] args) {
//		int[] arr = {0,2,4,1,3,5,5,6,8};//0 2 4有序，1 3 5 6 8有序，认为两个有序的数组
//		merge(arr, 0, 2, arr.length - 1);
//	}
	
	
	public static void merge(int[] arr, int low, int mid, int hight) {
		//创建一个临时数组，存放两个数组合并后的内容
		int[] temp = new int[hight - low + 1];
		int i=low;//记录第一个数组的下标
		int j=mid+1;//记录第二个数组的下标
		int index=0;//记录新创建的临时数组的下标
		while(i <= mid && j<=hight){
			//将小的数组复制给新的数组，新数组的下标移动index++
			if(arr[i] <= arr[j]){
				temp[index++] = arr[i++];
			}else{
				temp[index++] = arr[j++];
			}
		}
		//上面while循环，跳出的条件是，某一个数组的数据已经提取完毕
		//将未提取完毕的数组，都添加到新数组中
		while(i <= mid){
			temp[index++] = arr[i++];
		}
		while(j <= hight){
			temp[index++] = arr[j++];
		}
		//把临时数组的数据，存入到原数组
		for(int k=0; k<temp.length; k++){
			arr[low+k] = temp[k];
		}
	}

}
