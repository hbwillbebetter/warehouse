package com.datastructure.tree.heap.v2;

public class TestMaxHeap {

	public static void main(String[] args) {
		HeapSort hs = new HeapSort();
//		int[] array = {87};
		int[] array = {87,45,78,32,17,65,53,9,122};
		System.out.print("初始化数组：");
		hs.display(array);
		
		System.out.println("构建大根堆：");
		hs.buildMaxHeap(array);
		
		System.out.println("删除堆顶元素后：");
		array = hs.deleteMax(array);
		hs.display(array);
		
		int key = 63;
		array = hs.insert(array, key);
		System.out.println("插入元素"+key+"：");
		hs.display(array);
		
 		hs.heapSort(array);
		System.out.print("大根堆排序结果：");
		hs.display(array);
		
	}

}
