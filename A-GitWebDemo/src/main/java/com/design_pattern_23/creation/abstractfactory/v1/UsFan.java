package com.design_pattern_23.creation.abstractfactory.v1;

public class UsFan implements IFan {

	@Override
	public void switchOn() {
		System.out.println("switchOn UsFan..");
	}

	@Override
	public void switchOff() {
		System.out.println("switchOff UsFan..");
	}

}
