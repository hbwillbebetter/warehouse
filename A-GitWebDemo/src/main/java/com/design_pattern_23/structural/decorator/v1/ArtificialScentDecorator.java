package com.design_pattern_23.structural.decorator.v1;

public class ArtificialScentDecorator extends Decorator {

	public ArtificialScentDecorator(BakeryComponent bakeryComponent) {
		super(bakeryComponent);
		this.name="Artificial Scent";
		this.price=3.0;
	}

}
