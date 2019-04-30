package com.design_pattern_23.creation.abstractfactory.v1;

public class ChinaFan implements IFan {

	@Override
	public void switchOn() {
		System.out.println("switchOn chinaFan..");
	}

	@Override
	public void switchOff() {
		System.out.println("switchOff chinaFan..");
	}

}
