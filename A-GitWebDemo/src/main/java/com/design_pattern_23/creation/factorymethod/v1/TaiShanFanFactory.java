package com.design_pattern_23.creation.factorymethod.v1;

public class TaiShanFanFactory implements IFanFactory {

	@Override
	public IFan create() {
		// TODO Auto-generated method stub
		return new TaiShanFan();
	}

}
