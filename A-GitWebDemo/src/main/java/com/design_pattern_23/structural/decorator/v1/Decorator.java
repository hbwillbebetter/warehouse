package com.design_pattern_23.structural.decorator.v1;

public abstract class Decorator implements BakeryComponent {
	private BakeryComponent bakeryComponent = null;
	
	protected String name = "Undefined Decorator";
	protected double price = 0.0;
	
	public Decorator(BakeryComponent bakeryComponent) {
		this.bakeryComponent = bakeryComponent;
	}

	@Override
	public String getName() {
		return this.bakeryComponent.getName() + ", " + this.name;
	}

	@Override
	public double getPrice() {
		return this.bakeryComponent.getPrice() + this.price;
	}

}
