package com.design_pattern_23.creation.simple_factory.simplefactory.v3;

public class QiangShanFan implements IFan {

	@Override
	public void switchOn() {
		System.out.println("switchOn QiangShanFan ...");
	}

	@Override
	public void switchOff() {
		System.out.println("switchOff QiangShanFan ...");
	}

}