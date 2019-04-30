package com.design_pattern_23.creation.simple_factory.simplefactory.v1;

public class FanFactory implements IFanFactory {

	@Override
	public IFan create(FanType type) {
		switch (type) {
		case TableFan:
			return new TableFan();
		case CeilingFan:
			return new CeilingFan();
		case ExhaustFan:
			return new ExhaustFan();
		default:
			return new TableFan();
		}
	}

}
