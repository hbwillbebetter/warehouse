package com.design_pattern_23.creation.simple_factory.factorymethod.v1;

public class DiaoShanFanFactory implements IFanFactory {

	@Override
	public IFan create() {
		return new DiaoShanFan();
	}

}
