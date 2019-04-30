package com.design_pattern_23.creation.simplefactory.v1;

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
