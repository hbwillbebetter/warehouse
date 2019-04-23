package com.datastructure.Stack;

import com.util.MyStack;

public class TestMyStack {

	public static void main(String[] args) {
		//栈--先进后出--FILO
		MyStack stack = new MyStack();
		//向栈中添加元素--push
//		System.out.println(stack.size());
		stack.push(3);
//		System.out.println(stack.size());
		stack.push(4);
//		System.out.println(stack.size());
		stack.push(5);
		System.out.println(stack.size());
		System.out.println("===================分割线==================");
		System.out.println(stack.peek()+"----peek");
		System.out.println("===================分割线==================");
		System.out.println(stack.pop());
		System.out.println(stack.peek()+"----peek");
		System.out.println(stack.pop());
		System.out.println(stack.peek()+"----peek");
//		System.out.println(stack.pop());
		System.out.println("===================分割线==================");
//		System.out.println(stack.pop());
		System.out.println(stack.size());
		System.out.println(stack.isEmpty());
		
		
		
		
	}

}
