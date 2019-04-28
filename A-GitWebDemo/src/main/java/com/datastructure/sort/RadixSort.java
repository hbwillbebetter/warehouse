package com.datastructure.sort;

import java.util.Arrays;

import com.util.MyQueue;

//基数排序----最大数的位数----个、十、百、千...位-----桶的设计（数组/队列实现），里面存储的是数据个数，后面还会根据这个个数不为0，遍历桶，然后冲二维数组或者队列取出数据-----仅适用于数字的排序
public class RadixSort {

	public static void main(String[] args) {
		int[] arr = {16,5,134,64,57,99,30,645};
		int d = 1;
		for(int i=0; i<arr.length; i++){
			int temp = (arr[i]+"").length();
			if(temp > d){
				d = temp;
			}
		}
		System.out.println(Arrays.toString(arr));
		RadixSort2(arr, d);
		System.out.println(Arrays.toString(arr));
	}
	
	//优秀，使用队列结构取代二维数组，毕竟取数据也是先进先出，这样会优化空间
	public static void RadixSort2(int[] arr, int d) {//d -- 最大数的位数
		MyQueue[] queue = new MyQueue[10];//编号0-9的队列记录各自桶下挂的数据
		for(int i=0; i<queue.length; i++){
			queue[i] = new MyQueue();
		}
		//最大数的位数，决定了要排序几轮()
		for(int i=0,n=1; i<d; i++,n *=10){//记录遍历n，是为了每轮对n求余，得到余数和桶编号的对应关系，如余数2->对应编号为2的桶
			//遍历数组
			for(int j=0; j<arr.length; j++){
				//获取余数
				int ys = arr[j] / n % 10;
				//将当前桶编号的数据装入队列
				queue[ys].add(arr[j]);
			}
			//重新赋值给原数组的时候，记录原数组下标的编号
			int index = 0;
			//取出二维数组中的数据
			for(int j=0; j<queue.length; j++){
				//遍历取不为空的队列，遍历每个桶下挂数据的个数，查看个数，如果为0快速跳过
				while(!queue[j].isEmpty()){
					arr[index++] = queue[j].poll();
				}
			}
		}
	}
	
	
	//一般，使用二维数据会浪费很多空间
	public static void RadixSort(int[] arr, int d) {//d -- 最大数的位数
		//创建一个定长数组，下标从0-9，每个元素记录桶放入数据的次数，放一个数据，次数++
		int[] bucket = new int[10];
		//创建一个二维数组，行对应桶的下标，每行的一维数组记录落入当前桶的数据，二维数组中的一维数组最大长度为参数排序的所有数据个数
		int[][] temp = new int[bucket.length][arr.length];
		//最大数的位数，决定了要排序几轮()
		for(int i=0,n=1; i<d; i++,n *=10){//记录遍历n，是为了每轮对n求余，得到余数和桶编号的对应关系，如余数2->对应编号为2的桶
			//遍历数组
			for(int j=0; j<arr.length; j++){
				//获取余数
				int ys = arr[j] / n % 10;
				//将当前数据装入二维数组
				temp[ys][bucket[ys]] = arr[j];
				//装入一个数据，记录次数
				bucket[ys]++;
			}
			//重新赋值给原数组的时候，记录原数组下标的编号
			int index = 0;
			//取出二维数组中的数据
			for(int j=0; j<10; j++){
				//直接取bucket，遍历每个桶下挂数据的个数，查看个数，如果为0快速跳过
				if(bucket[j] != 0){
					for(int m=0; m<bucket[j]; m++){
						arr[index++] = temp[j][m];
					}
					//当前桶取完后，重置当前桶下挂数据的个数为0
					bucket[j] = 0;
				}
			}
		}
	}

}
