package com.design_pattern_23.creation.simple_factory.simplefactory.v3;

public class TaiShanFanFactory implements IFanFactory {

	@Override
	public IFan create() {
		// TODO Auto-generated method stub
		return new TaiShanFan();
	}

}
