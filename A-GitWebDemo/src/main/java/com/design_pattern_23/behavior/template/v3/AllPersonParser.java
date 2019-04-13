package com.design_pattern_23.behavior.template.v3;

import com.design_pattern_23.behavior.template.v3.enumType.EnvType;

public class AllPersonParser extends PersonParser {
	private EnvType type;
	
	public AllPersonParser(EnvType type) {
		this.type = type;
	}
	@Override
	protected void getInputData() {
		super.readConf(this.type);
		System.out.println("个人全量数据获取completed!");
		
	}

	@Override
	protected void checkInputData() {
		System.out.println("个人全量数据校验completed!");
		
	}

	@Override
	protected void initEmptyFile() {
		System.out.println("个人全量数据初始化empty文件completed!");
		
	}

	@Override
	protected void processData() {
		System.out.println("个人全量数据正在处理...");
		
	}

	@Override
	protected void writeData2File() {
		System.out.println("个人全量数据写入文件completed!");
	}

}
