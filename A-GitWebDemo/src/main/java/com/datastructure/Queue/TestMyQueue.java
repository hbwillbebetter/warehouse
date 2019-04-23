package com.datastructure.Queue;

import com.util.MyQueue;

public class TestMyQueue {

	public static void main(String[] args) {
		MyQueue queue = new MyQueue();
		//入队列
		queue.add(9);
		queue.add(8);
		queue.add(7);
		queue.show();
		System.out.println(queue.poll());
		System.out.println("============");
		queue.show();
		System.out.println(queue.poll());
		System.out.println("============");
		queue.show();
		
	}

}
