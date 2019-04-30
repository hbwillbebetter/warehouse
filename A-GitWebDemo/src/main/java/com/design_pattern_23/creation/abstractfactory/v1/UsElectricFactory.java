package com.design_pattern_23.creation.abstractfactory.v1;

public class UsElectricFactory implements IElectricFactory {

	@Override
	public IFan createFan() {
		return new UsFan();
	}

	@Override
	public ITubeLight createTubeLight() {
		return new UsTubeLight();
	}
	
	//add other 产品家族....
}
