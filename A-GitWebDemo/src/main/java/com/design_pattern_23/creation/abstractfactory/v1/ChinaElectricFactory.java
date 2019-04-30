package com.design_pattern_23.creation.abstractfactory.v1;

public class ChinaElectricFactory implements IElectricFactory {

	@Override
	public IFan createFan() {
		return new ChinaFan();
	}

	@Override
	public ITubeLight createTubeLight() {
		return new ChinaTubeLight();
	}

	//add other 产品家族....
}
