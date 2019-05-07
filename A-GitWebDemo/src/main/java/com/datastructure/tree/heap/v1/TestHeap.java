package com.datastructure.tree.heap.v1;

public class TestHeap {

	public static void main(String[] args) {
		Heap heap = new Heap(3);
		heap.insert(1);
		heap.insert(2);
		heap.insert(3);
		heap.remove();
		heap.displayHeap();
		
	}

}
