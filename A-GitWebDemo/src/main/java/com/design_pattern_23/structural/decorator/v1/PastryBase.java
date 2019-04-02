package com.design_pattern_23.structural.decorator.v1;


public class PastryBase implements BakeryComponent {
	private String name="Pastry Base";
	private double price = 20.0;
	
	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public double getPrice() {
		return this.price;
	}

}
