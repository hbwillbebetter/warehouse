package com.offer;

//[剑指offer] 二维数组中的查找
//https://blog.csdn.net/weiwei121451070/article/details/81742418
public class Solution_03 {

	public static void main(String[] args) {
		int[][] arr = {
				{0,1,2,5},
				{2,3,4,7},
				{4,4,4,8},
				{5,7,7,9}};
//		int[][] arr = new int[4][4];
//		System.out.println(arr[0].length-1);//类比一维数组的最大下标
//		System.out.println(arr.length-1);//类比二维数组最大的行标
		
		boolean flag = new Solution_03().Find(8, arr);
		System.out.println("找到与否："+flag);
		
	}
	public boolean Find(int target, int [][] array) {
		if(array.length ==0 || array[0].length == 0){
			return false;
		}
		int m = array[0].length - 1;
		int n = 0;//定义行标从0开始
		int temp = array[n][m];
		while (target != temp) {
			/**
			 * n决定是否跨行：查找到了最后一行，不能再让行标下移，不然就出了边界，所以n < array.length-1
			 * m决定行左移：查找到了第一列，不能再让列标左移,不然就出了边界，所以 m > 0
			 */
			if(n < array.length - 1 && m > 0){
				if(target < temp){
					m--;
				}else if(target > temp) {
					n++;
				}
				temp = array[n][m];
			}else{
				return false;
			}
		}
		System.out.println(temp+"---行标:"+n+",---列标:"+m);
		return true;
	}

}
