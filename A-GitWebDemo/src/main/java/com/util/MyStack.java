package com.util;
//数组实现栈
public class MyStack {
	int[] elements;
	
	public MyStack(){
		elements = new int[0];
	}
	
	//栈中添加元素
	public void push(int element){
		//创建一个新的数组，长度为原长度+1
		int[] newArray = new int[elements.length + 1];
		//遍历原数组,并拷贝元素至新的数组
		for(int i=0;i<elements.length;i++){
			newArray[i] = elements[i];
		}
		//添加新元素到新数组的最后位置
		newArray[elements.length] = element;
		//将新数组复制给原数组
		elements = newArray;
	}
	
	//栈中取出元素
	public int pop(){
		if(isEmpty()) throw new RuntimeException("栈为空，不能取数据");
		//取数组最后一个元素
		int element = elements[elements.length - 1];
		int[] newArray = new int[elements.length - 1];
		//遍历新数组
		for(int i=0; i<newArray.length;i++){
			newArray[i] = elements[i];
		}
		//将新数组赋值原数组
		elements = newArray;
		return element;
	}
	
	//查看栈顶元素
	public int peek(){
		if(isEmpty()) throw new RuntimeException("栈为空，不能查看数据");
		return elements[elements.length - 1];
	}
	
	
	//查看栈的大小
	public int size(){
		return elements.length;
	}
	
	//栈中元素是否为空
	public boolean isEmpty(){
		return (elements.length == 0) ? true : false;
	}

	
	
	
	
}
