package com.design_pattern_23.structural.decorator.v1;

public class CherryDecorator extends Decorator {

	public CherryDecorator(BakeryComponent bakeryComponent) {
		super(bakeryComponent);
		this.name = "Cherry";
		this.price = 2.0;
	}

}
