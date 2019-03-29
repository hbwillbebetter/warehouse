package com.design_pattern_23.behavior.template.v1;

public class TemplateMethodMain {
	public static void main(String[] args) {
		DatabaseDataParser databaseDataParser = new DatabaseDataParser();
		databaseDataParser.process();
		System.out.println("********************");
		CSVDataParser csvDataParser = new CSVDataParser();
		csvDataParser.process();
		
		
	}
	
}
