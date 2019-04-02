package com.design_pattern_23.structural.decorator.v1;

public class CreamDecorator extends Decorator {

	public CreamDecorator(BakeryComponent bakeryComponent) {
		super(bakeryComponent);
		this.name = "Cream";
		this.price = 1.0;
	}

}
