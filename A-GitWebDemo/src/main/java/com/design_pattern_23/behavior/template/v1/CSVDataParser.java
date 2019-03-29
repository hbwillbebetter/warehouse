package com.design_pattern_23.behavior.template.v1;

public class CSVDataParser extends DataParser {

	@Override
	protected void readData() {
		System.out.println("Reading data from csv file");
	}

	@Override
	protected void processData() {
		System.out.println("Looping through loaded csv file");
	}

}
