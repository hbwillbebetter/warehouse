package com.design_pattern_23.structural.decorator.v2;
//木工
public class Carpenter implements Worker {

	@Override
	public void doSomething() {
		System.out.println("修理门窗");
	}

}
