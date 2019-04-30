package com.design_pattern_23.creation.simple_factory.simplefactory.v2;

public class FanFactory implements IFanFactory {

	@Override
	public IFan create(FanType type) {
		switch (type) {
		case TaiShanFan:
			return new TaiShanFan();
		case DiaoShanFan:
			return new DiaoShanFan();
		case PaiFengShanFan:
			return new PaiFengShanFan();
		default:
			return new TaiShanFan();
		}
	}

}
