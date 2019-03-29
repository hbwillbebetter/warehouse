package com.design_pattern_23.behavior.template.v2;


public class CurdMain {
	
	public static void main(String[] args) throws Exception {
		Student student = new Student();
		student.setId(2);
		InsertCurdMain insertMain = new InsertCurdMain();
		insertMain.insertEntity(student);
		
		//...
		//deleteCurdMain待实现自己的CURD
		
		
	}

	
}
