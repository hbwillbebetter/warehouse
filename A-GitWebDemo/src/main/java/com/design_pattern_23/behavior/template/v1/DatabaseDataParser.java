package com.design_pattern_23.behavior.template.v1;

public class DatabaseDataParser extends DataParser {

	@Override
	protected void readData() {
		System.out.println("Reading data from DB");
		
	}

	@Override
	protected void processData() {
		System.out.println("Looping through records in DB");
		
	}

}
