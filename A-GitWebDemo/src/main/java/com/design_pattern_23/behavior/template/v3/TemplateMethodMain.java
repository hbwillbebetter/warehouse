package com.design_pattern_23.behavior.template.v3;


import org.apache.log4j.Logger;

import com.design_pattern_23.behavior.template.v3.enumType.EnvType;

public class TemplateMethodMain {
	private static Logger log = Logger.getLogger(TemplateMethodMain.class);
	public static void main(String[] args) {
		DataParser allCompany = new AllCompanyParser.AllCompanyParserBuilder(EnvType.PROD, "createTime")
		.serviceTime("20190410")
		.startTime("19700101")
		.endTime("20190410")
		.searchTypeName("pname")
		.build();
		allCompany.process();
		System.out.println();
		log.info("********************");
		DataParser allCompany2 = new AllCompanyParser.AllCompanyParserBuilder(EnvType.TEST, "sortTime")
		.serviceTime("20190410")
		.startTime("19700101")
		.endTime("20190410")
		.searchTypeName("pname")
		.build();
		allCompany2.process();
		System.out.println();
		System.out.println("********************");
		DataParser allPerson = new AllPersonParser(EnvType.DEV);
		allPerson.process();
		System.out.println();
		
		
		
		
	}
	
}
