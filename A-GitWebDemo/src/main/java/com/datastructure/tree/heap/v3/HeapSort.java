package com.datastructure.tree.heap.v3;

import java.util.Arrays;

public class HeapSort {
	
	public static void main(String[] args) {
//		int[] arr = new int[] {9,6,8,7,0,1,10,4,2};
		int[] arr = new int[] {87, 63, 78, 45, 17, 65, 53, 9, 32};
//		int[] arr = new int[] {2,1};
//		int[] arr = new int[] {2};
		heapSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void heapSort(int[] arr) {
		//开始位置是最后一个非叶子节点，即最后一个节点的父节点
		int start = (arr.length-1-1)/2;
		//调整为大顶堆
		for(int i=start;i>=0;i--) {
			maxHeap(arr, arr.length, i);
		}
		//先把数组中的第0个和堆中的最后一个数交换位置，再把前面的处理为大顶堆
		for(int i=arr.length-1;i>0;i--) {
			int temp = arr[0];
			arr[0]=arr[i];
			arr[i]=temp;
			maxHeap(arr, i, 0);
		}
	}
	
	public static void maxHeap(int[] arr,int size,int index) {
		//左子节点
		int leftNode = 2*index+1;
		//右子节点
		int rightNode = 2*index+2;
		int max = index;
		//和两个子节点分别对比，找出最大的节点
		if(leftNode<size&&arr[leftNode]>arr[max]) {
			max=leftNode;
		}
		if(rightNode<size&&arr[rightNode]>arr[max]) {
			max=rightNode;
		}
		//交换位置
		if(max!=index) {//找到需要与之调整的子节点；（如果max=index：表明当前节点index已经比它的左右子节点值都要大，满足堆的性质，无需调整了。）
			int temp=arr[index];
			arr[index]=arr[max];
			arr[max]=temp;
			//交换位置以后，可能会破坏之前排好的堆，所以，之前的排好的堆需要重新调整
			maxHeap(arr, size, max);
		}
	}

}

