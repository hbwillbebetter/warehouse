package com.design_pattern_23.behavior.strategy.v3;

import java.io.File;

public class CsvFileStrategy implements FileStrategy {

	@Override
	public void readFile(File file) {
		System.out.println("read file using csv");
	}

	@Override
	public void writeFile(File file) {
		System.out.println("write file using csv");
	}

}
