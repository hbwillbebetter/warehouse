package com.datastructure.recursive.test;

import org.apache.log4j.Logger;

public class TestRecursive {
	private static Logger log = Logger.getLogger(TestRecursive.class);
	public static void main(String[] args){
		print(3);
	}
	//递归
	public static void print(int i){
		if(i > 0){
			System.out.println(i);
			print(i - 1);
			System.out.println("haha"+i);
		}
	}

}
