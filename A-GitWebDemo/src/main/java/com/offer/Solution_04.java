package com.offer;

import java.util.Iterator;

//[剑指offer] 替换空格
//https://blog.csdn.net/weiwei121451070/article/details/81742418
/**
 *  题目描述
	请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
	
	解题思路
	很简单，从后往前遍历就对了。
 * @author B
 *
 */
public class Solution_04 {

	public static void main(String[] args) {
		StringBuffer str = new StringBuffer("We Are Happy");
		String res = new Solution_04().replaceSpace(str);
		System.out.println("结果："+res);
		
	}
	public String replaceSpace(StringBuffer str) {
		StringBuffer buffer = new StringBuffer();
		int len = str.length() - 1;
		for(int i=len; i>=0; i--){
			char cha = str.charAt(i);
			if(cha == ' '){
				buffer.append("02%");
			}else {
				buffer.append(cha);
			}
		}
		
		return buffer.reverse().toString();
	}
	
	public String replaceSpace01(StringBuffer str) {
		String s = str.toString();
		return s.replaceAll(" ", "%20");
	}

}
