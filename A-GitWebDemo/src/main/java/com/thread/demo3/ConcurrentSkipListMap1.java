package com.thread.demo3;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;


public class ConcurrentSkipListMap1 {
	
	static Map<String, String> map = new ConcurrentSkipListMap<>(Collections.reverseOrder());
	public static void main(String[] args) {
		map.put("a", "abstract");
	    map.put("c", "call");
	    map.put("b", "basic");
	    System.out.println(map.toString());
	}
}
