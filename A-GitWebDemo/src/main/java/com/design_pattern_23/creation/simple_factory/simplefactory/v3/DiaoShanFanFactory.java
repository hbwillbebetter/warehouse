package com.design_pattern_23.creation.simple_factory.simplefactory.v3;

public class DiaoShanFanFactory implements IFanFactory {

	@Override
	public IFan create() {
		return new DiaoShanFan();
	}

}