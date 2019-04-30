package com.design_pattern_23.creation.simplefactory.v1;

public class SimpleFactoryMain {

	public static void main(String[] args) {
		IFanFactory simpleFactory = new FanFactory();
		IFan fan = simpleFactory.create(FanType.TableFan);
		fan.swithOn();
		fan.swithOff();
		
		System.out.println("-------------");
		fan = simpleFactory.create(FanType.CeilingFan);
		fan.swithOn();
		fan.swithOff();
	}

}
