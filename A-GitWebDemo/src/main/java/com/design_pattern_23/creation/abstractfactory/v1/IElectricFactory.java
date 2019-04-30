package com.design_pattern_23.creation.abstractfactory.v1;

//工厂接口
public interface IElectricFactory {

	//定义各种电器设备的创建
	public IFan createFan();
	
	public ITubeLight createTubeLight();
	
	
}
