package com.util;

import java.util.Arrays;

public class MyQueue {
	int[] elements;
	
	//底层使用数组实现
	public MyQueue(){
		elements = new int[0];
	}
	
	//入队
	public void add(int element){
		int[] newArray = new int[elements.length + 1];
		for(int i=0;i<elements.length;i++){
			newArray[i] = elements[i];
		}
		//添加新元素
		newArray[elements.length] = element;
		//替换数组
		elements = newArray;
	}
	
	//出队
	public int poll(){
		if(isEmpty()) throw new RuntimeException("queue is empty!");
		int element = elements[0];
		int[] newArray = new int[elements.length - 1];
		for(int i=0;i<newArray.length;i++){
			newArray[i] = elements[i+1];
		}
		elements = newArray;
		return element;
	}
	
	//查看队列的大小
	public int size(){
		return elements.length;
	}
	
	//队列中元素是否为空
	public boolean isEmpty(){
		return (elements.length == 0) ? true : false;
	}
	
	
	//打印队列
	public void show(){
		System.out.println(Arrays.toString(elements));
	}
	//获取队列头元素
	public int peek() {
		return elements[0];
	}

	
	
}
