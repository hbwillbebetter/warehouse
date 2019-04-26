package com.datastructure.sort;

import java.util.Arrays;
//快速排序
public class QuickSort {
	public static void main(String[] args) {
		
		int[] array = {4,6,7,3,5,8,2,2,2,3,7,1};
		System.out.println(Arrays.toString(array));
		quickSort(array, 0, array.length - 1);
		System.out.println(Arrays.toString(array));
		
	} 

	public static void quickSort(int[] array, int start, int end) {
		if(start < end){
			//定义基准值，默认一般选第一个start,而不是array[0]
			int stad = array[start];
			//记录排序的高低指针
			int low = start;
			int hight = end;
			//循环条件，高低位指针重合（low==hight）前，一定是low<hight
			while(low < hight){
				//如果高位指针对应的值，大于基准值stad，高位指针向前移动
				while(low < hight && stad <= array[hight]){//注意stad <= array[hight]必须有相等的情况
					hight--;
				}
				//当遇到高位指针指向的值，小于基准值stad，停止hight指针的移动，先将高位指针hight的值赋值给low指针的值，
				//然后判断low位值<stad,再移动low指针，向后移
				array[low] = array[hight];
				while(low < hight && stad >= array[low]){//注意stad >= array[low]必须有相等的情况
					low++;
				}
				//当遇到low位值大于基准值stad,则将low值赋值给hight位值,停止low指针移动
				array[hight] = array[low];
				//以此往复查找...
			}
			//当指针重合（low==hight）时，将基准值付给low或者hight都一样
			array[low] = stad;
//			System.out.println(Arrays.toString(array));
			//处理所有小的数字
			quickSort(array, start, low);
			//处理所有大的数字
			quickSort(array, low+1, end);
		}
	}
}
