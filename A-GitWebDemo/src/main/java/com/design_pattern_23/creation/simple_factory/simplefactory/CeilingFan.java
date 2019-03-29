package com.design_pattern_23.creation.simple_factory.simplefactory;

public class CeilingFan implements IFan {

	@Override
	public void swithOn() {
		System.out.println("The CeilingFan is swithed on ...");
	}

	@Override
	public void swithOff() {
		System.out.println("The CeilingFan is swithed off ...");
	}

}
