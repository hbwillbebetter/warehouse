package com.design_pattern_23.behavior.observer.v1;

public class Test {

	public static void main(String[] args) {
		Child c = new Child("babyA");
		c.addListener(new Dad());
		c.addListener(new GrandFather());
		new Thread(c).start();
	}

}
