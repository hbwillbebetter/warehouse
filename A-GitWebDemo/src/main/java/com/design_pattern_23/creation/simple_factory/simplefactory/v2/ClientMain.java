package com.design_pattern_23.creation.simple_factory.simplefactory.v2;

//简单工厂客户类
public class ClientMain {

	//客户类只和工厂打交道
	public static void main(String[] args) {
		
		IFanFactory fanFactory = new FanFactory();
		IFan fan = fanFactory.create(FanType.DiaoShanFan);
		fan.switchOn();
		fan.switchOff();
		
		/**
		 * 优点：
		 * 1.产品制造流程集中到工厂，客户只和工厂打交道
		 * 		1.1 易于变更
		 * 		1.2 易于优化
		 * 
		 */
		
		//缺点：
		/*
		 * 违反solid原则，当需要创建一个新的产品，就得修改工厂方法(create---switch(or if/else))，
		 * 可以试着用v3的工厂方法进行改进，让子类自己决定使用哪个实例
		 */
		
	}

}
