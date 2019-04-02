package com.design_pattern_23.structural.decorator.v1;

public class CakeBase implements BakeryComponent {
	
	private String name = "Cake Base";
	private double price = 200.0;
	
	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public double getPrice() {
		return this.price;
	}

}
