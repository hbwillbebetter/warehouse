package com.algorithm_suanfa.Anagram;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.datastructure.sort.QuickSort;

/**
 * 有效的字母异位词
 * 
 * 
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
	示例 1:
	
	输入: s = "anagram", t = "nagaram"
	输出: true
	
	示例 2:
	
	输入: s = "rat", t = "car"
	输出: false
	
	说明:
	你可以假设字符串只包含小写字母
 * 
 * 
 * @author B
 *
 */
public class Solution_1 {
	
	public static void main(String[] args) {
		String s = "rat";
		String t = "tar";
		map(s,t);
		quickSort(s,t);
	}
	
	private static void quickSort(String s, String t) {
		char[] s1 = s.toCharArray();
		char[] t1 = t.toCharArray();
		CharsQuickSort_char.charsQuickSort(s1,0,s1.length-1);
		CharsQuickSort_char.charsQuickSort(t1,0,t1.length-1);
		if (Arrays.toString(s1).equals(Arrays.toString(t1))) {
			System.out.println(true);
		}else {
			System.out.println(false);
		}
	}

	private static void map(String s, String t) {
		boolean flag = isAnagram(s,t);
		System.out.println(flag);
	}

	/**
	 * map计数，再比较两个map是否相等
	 * @param s
	 * @param t
	 * @return boolean
	 */
	private static boolean isAnagram(String s, String t) {
		if (s == null && t== null) {
			return true;
		}
		if (s == null || t == null) {
			return false;
		}
		Map<String, Integer> map1 = new HashMap<String, Integer>();
		Map<String, Integer> map2 = new HashMap<String, Integer>();
		for(int i=0;i<s.length();i++){
			char cha = s.charAt(i);
			String charStr = String.valueOf(cha);
			if (map1.containsKey(charStr)) {
				map1.put(charStr, map1.get(charStr)+1);
			}else {
				map1.put(charStr, 1);
			}
		}
		for(int i=0;i<t.length();i++){
			char cha = t.charAt(i);
			String charStr = String.valueOf(cha);
			if (map2.containsKey(charStr)) {
				map2.put(charStr, map2.get(charStr)+1);
			}else {
				map2.put(charStr, 1);
			}
		}
		if (map1.equals(map2)) {
			return true;
		}else {
			return false;
		}
	}
	
	
	
}
