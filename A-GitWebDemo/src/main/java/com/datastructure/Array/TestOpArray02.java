package com.datastructure.Array;

import java.util.Arrays;

public class TestOpArray02 {

	public static void main(String[] args) {
		int[] arr1 = {0,2,3,3,5,6,9};
		int[] arr2 = {1,4,6,7,11,13,15,17,19};
		merge1(arr1, arr2);
		
	}
	
	public static String merge1(int[] a, int[] b){
		int[] result = new int[a.length + b.length];
		int k = 0;
		int i = 0;
		int j = 0;
		while(i < a.length && j < b.length){
			if(a[i] <= b[j]){
				result[k++] = a[i++];
			}else{
				result[k++] = b[j++];
			}
		}
		//上面一个while循环走完，至少有一个数组已经执行完成，则需要将另外一个没执行完的数组项，添加到新的数组。
		while(i < a.length){
			result[k++] = a[i++];
		}
		
		while(j < b.length){
			result[k++] = b[j++];
		}
		
		System.out.println(Arrays.toString(result));
		
		return Arrays.toString(result);
		
	}
	
	public static String merge2(int[] a, int[] b){
		int[] result = new int[a.length + b.length];
		int k = 0;
		int i = 0;
		int j = 0;
		
		while(true){
			while(i < a.length && a[i] <= b[j]){
				result[k++] = a[i++];
			}
			//上一步循环比较后，如果有数组已经完成，则将另一个数组其余项直接追加到新数组后
			if(i == a.length){
				for(;j<b.length;j++){
					result[k++] = b[j];
				}
			}
			while(j < b.length && a[i]>b[j]){
				result[k++] = b[j++];
			}
			//上一步循环比较后，如果有数组已经完成，则将另一个数组其余项直接追加到新数组后
			if(j == b.length){
				for(;i<a.length;i++){
					result[k++] = a[i];
				}
			}
			if(i == a.length && j == b.length){
				break;
			}
		}
		System.out.println(Arrays.toString(result));
		
		return Arrays.toString(result);
	}
	

}
