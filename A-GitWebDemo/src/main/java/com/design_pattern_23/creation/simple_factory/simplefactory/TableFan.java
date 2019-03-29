package com.design_pattern_23.creation.simple_factory.simplefactory;

public class TableFan implements IFan {

	@Override
	public void swithOn() {
		System.out.println("The TableFan is swithed on ...");

	}

	@Override
	public void swithOff() {
		System.out.println("The TableFan is swithed off ...");

	}

}
