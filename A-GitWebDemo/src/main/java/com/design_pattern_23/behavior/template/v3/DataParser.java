package com.design_pattern_23.behavior.template.v3;

import com.design_pattern_23.behavior.template.v3.enumType.EnvType;

public abstract class DataParser {
	
	public static final String charsetName = "UTF-8";
	public static final String confDir = "zmn";
	private static volatile boolean initConfFlag = false;
	public final void process(){
		readConf(null);
		initEsClusterInfo();
		getInputData();
		checkInputData();
		initEmptyFile();
		processData();
		writeData2File();
		
	}
	
	//implemented by subclass
	//get input data
	protected abstract void getInputData();
	//check Input data
	protected abstract void checkInputData();
	//init empty file
	protected abstract void initEmptyFile();
	//process data
	protected abstract void processData();
	//data to file
	protected abstract void writeData2File();
	
	//same for all subclass
	//read conf
	protected abstract void readConf(EnvType type);
	//init Es Cluster info
	private void initEsClusterInfo() {
		System.out.println("init es cluster info completed!");
	}
	
}
