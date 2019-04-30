package com.design_pattern_23.creation.simple_factory.simplefactory.v2;

public class ClientMain {

	//客户类只和工厂打交道
	public static void main(String[] args) {
		
		IFanFactory fanFactory = new FanFactory();
		IFan fan = fanFactory.create(FanType.DiaoShanFan);
		fan.switchOn();
		fan.switchOff();
		
	}

}
