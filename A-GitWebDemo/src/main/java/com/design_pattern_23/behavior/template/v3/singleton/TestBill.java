package com.design_pattern_23.behavior.template.v3.singleton;

public class TestBill {
	public static void main(String[] args) {
		PropertiesLoader instance = PropertiesLoader.getInstance();
		String v = instance.getOneProp("esDangerMemory");
		System.out.println(v);
		PropertiesLoader instance2 = PropertiesLoader.getInstance();
		String v2 = instance2.getOneProp("esDangerMemory");
		System.out.println(v2);
	}
}
