package com.datastructure.recursive.test;

public class TestFebonacci {

	public static void main(String[] args) {
		//斐波那契数列: 1 1 2 3 5 8 13
		System.out.println(febonacci(7));
	}
	
	public static int febonacci(int n){
		if(n == 1 || n== 2){
			return 1;
		}else{
			return febonacci(n-2) + febonacci(n-1);
		}
	}

}
