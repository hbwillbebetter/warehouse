package com.design_pattern_23.behavior.strategy.v3;

import java.io.File;

public class FileManagerV3 {
	
	File file;
	FileStrategy fileStrategy;
	public FileManagerV3(File file, FileStrategy fileStrategy){
		this.file = file;
		this.fileStrategy = fileStrategy;
	}
	
	public void readFile() {
		System.out.println("===================================");
		System.out.println("read File based on Type");
		System.out.println("===================================");
		this.fileStrategy.readFile(file);
	}
	
	public void writeFile() {
		System.out.println("===================================");
		System.out.println("write File based on Type");
		System.out.println("===================================");
		this.fileStrategy.writeFile(file);
	}
	
	public File getFile() {
		return file;
	}
	
	public void setFile(File file) {
		this.file = file;
	}
	
	public FileStrategy getFileStrategy() {
		return fileStrategy;
	}
	
	public void setFileStrategy(FileStrategy fileStrategy) {
		this.fileStrategy = fileStrategy;
	}
	
	
}
