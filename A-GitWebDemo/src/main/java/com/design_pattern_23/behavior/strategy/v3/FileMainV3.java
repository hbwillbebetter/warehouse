package com.design_pattern_23.behavior.strategy.v3;

import java.io.File;


public class FileMainV3 {

	public static void main(String[] args) {
		File file = new File("a.txt");
		TxtFileStrategy txtFileStrategy = new TxtFileStrategy();
		FileManagerV3 fm = new FileManagerV3(file, txtFileStrategy);
		fm.readFile();
		fm.writeFile();
		System.out.println("****************");
		
		CsvFileStrategy csvFileStrategy = new CsvFileStrategy();
		fm.setFile(new File("b.csv"));
		fm.setFileStrategy(csvFileStrategy);
		fm.readFile();
		fm.writeFile();
		System.out.println("****************");
		
		ExcelFileStrategy excelFileStrategy = new ExcelFileStrategy();
		fm.setFile(new File("c.xlsx"));
		fm.setFileStrategy(excelFileStrategy);
		fm.readFile();
		fm.writeFile();
	}

}
