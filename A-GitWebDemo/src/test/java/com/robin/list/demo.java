package com.robin.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class demo {

	public static void main(String[] args) {
//		ArrayList<String> ls = new ArrayList<>();
//		LinkedList<String> ll = new LinkedList<String>();
//		ll.add("fff");
//		ll.get(0);
//		
//		ls.add("a");
//		ls.add("b");
//		ls.add("c");
//		ls.add(1, "222");
//		System.out.println(ls);
//		int a = 20;
//		int b = (a << 1);
//		System.out.println(b);
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < 100; i++) {
			map.put("张三_"+i, i);
		}
		System.out.println(map);
		Set<String> set = new HashSet<String>();
		set.add("a");
		
		Hashtable<String, Integer> table = new Hashtable<>();
		table.put("aa", 1);
	}

}
