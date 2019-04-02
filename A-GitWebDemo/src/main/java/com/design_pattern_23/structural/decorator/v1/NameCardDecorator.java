package com.design_pattern_23.structural.decorator.v1;

public class NameCardDecorator extends Decorator {

	public NameCardDecorator(BakeryComponent bakeryComponent) {
		super(bakeryComponent);
		this.name = "Name Card";
		this.price = 4.0;
	}

	@Override
	public String getName() {
		return super.getName() + "(Please Collect your discount card for "+this.price+")";
	}

}
