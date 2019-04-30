package com.design_pattern_23.creation.factorymethod.v1;

//工厂方法客户类
public class ClientMain {

	//客户类只和工厂打交道
	public static void main(String[] args) {
		
		IFanFactory fanFactory = new QiangShanFanFactory();
		//使用工厂方法创建一个墙扇
		IFan fan = fanFactory.create();
		fan.switchOn();
		fan.switchOff();
		
		//优点：满足solid原则，对扩展开放，对修改关闭，如果新加一个产品，直接new这个新产品的工厂，再创建这个新工厂对应的产品对象
		//缺陷：没添加一个产品，就附加创建一个这个产品对应的工厂，工程类过多...
		
		
		//好处：
		/**
		 * 1.客户和产品的制造逻辑解耦
		 * 2.遵循ocp(开发关闭原则)，新需求无需修改代码
		 * 3.易于单元测试
		 * 		3.1 没有switch（of if/else)
		 * 4.公共制造逻辑可以抽取到抽象类
		 * 		4.1 例如BaseFanFactory
		 */
		
	}

}
