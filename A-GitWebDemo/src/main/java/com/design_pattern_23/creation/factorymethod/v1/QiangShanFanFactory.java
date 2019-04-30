package com.design_pattern_23.creation.factorymethod.v1;

public class QiangShanFanFactory implements IFanFactory {

	@Override
	public IFan create() {
		return new QiangShanFan();
	}

}
