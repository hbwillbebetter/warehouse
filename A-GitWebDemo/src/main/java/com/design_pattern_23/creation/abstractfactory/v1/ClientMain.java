package com.design_pattern_23.creation.abstractfactory.v1;

//抽象工厂客户类
public class ClientMain {

	//客户类只和工厂打交道
	public static void main(String[] args) {
		
		//国产
		IElectricFactory electricFactory = new ChinaElectricFactory();
		IFan fan = electricFactory.createFan();
		fan.switchOn();
		fan.switchOff();
		ITubeLight tubeLight = electricFactory.createTubeLight();
		tubeLight.switchOn();
		tubeLight.controlLight();
		tubeLight.switchOff();
		
		System.out.println("====================================");
		//美产
		IElectricFactory electricFactory2 = new UsElectricFactory();
		IFan fan2 = electricFactory2.createFan();
		fan2.switchOn();
		fan2.switchOff();
		ITubeLight tubeLight2 = electricFactory2.createTubeLight();
		tubeLight2.switchOn();
		tubeLight2.controlLight();
		tubeLight2.switchOff();
		
		/**
		 * 1.工厂接口只负责生成各种工厂、产品接口只负责定义要生成的产品具有的功能
		 * 2.不同风格的工厂（中国电器工厂、美国电器工厂）实现工厂接口（IElectricFactory）定义各自创建产品的功能，
		 * 这样的产品具有中国风格（中国风格风扇、中国风格日光灯）/美国风格（美国风格风扇、美国风格日光灯）
		 * 3.不同风格的产品（中国风扇、美国风扇，以及 中国日光灯、美国日光灯）实现产品接口（IFan、ITubeLight）定义各自产品所具有的功能
		 */
		
		/**
		 * 好处：
		 * 
		 * 1.解耦
		 *  	1.1 客户代码和具体产品解耦
		 * 		1.2 产品家族之间解耦
		 * 2.比工厂模式更高层的设计模式
		 * 3.标准化产品构造流程
		 * 4.易于替换产品家族
		 */
		
		
		
		
	}

}
