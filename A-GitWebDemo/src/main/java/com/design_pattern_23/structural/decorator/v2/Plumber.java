package com.design_pattern_23.structural.decorator.v2;
//水管工人
public class Plumber implements Worker {

	@Override
	public void doSomething() {
		System.out.println("修理水管");
	}

}
