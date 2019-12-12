package com.util;

import org.junit.Test;

public class MyStringUtils {

	@Test
	public void test_substring(){
		
		String s = "hello123baby";
		System.out.println(s.substring(3));//截得指定位置及之后[]
		System.out.println(s.substring(0,2));//截得指定前后位置之间，[)
	}
	
	@Test
	public void test_indexof(){
		
		String s = "hello,12,3baby";
		System.out.println(s.indexOf(12));
		System.out.println(s.indexOf(","));//获取指定字符串所在的开始位置
		System.out.println(s.indexOf(1, 2));
		System.out.println(s.indexOf(",", 6));//从指定位置开始，找特定字符串，如果找到则返回其位置。
	}
	
}
