package com.design_pattern_23.structural.decorator.v1;

public class Util {
	public static void printProductDetails(BakeryComponent bComponent) {
		String out = "Item: " + bComponent.getName() + ", " + "Price: " + bComponent.getPrice();
		System.out.println(out);
	}
}
