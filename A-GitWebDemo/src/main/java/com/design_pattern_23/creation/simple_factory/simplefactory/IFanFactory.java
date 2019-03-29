package com.design_pattern_23.creation.simple_factory.simplefactory;

//产品工厂生产产品
public interface IFanFactory {
	IFan create(FanType type);
}
