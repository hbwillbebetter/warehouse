package com.design_pattern_23.creation.simple_factory.factorymethod.v1;

public class PaiFengShanFan implements IFan {

	@Override
	public void switchOn() {
		System.out.println("switchOn PaiFengShanFan ...");
	}

	@Override
	public void switchOff() {
		System.out.println("switchOff PaiFengShanFan ...");

	}

}
