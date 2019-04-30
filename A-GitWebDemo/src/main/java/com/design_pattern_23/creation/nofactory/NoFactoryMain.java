package com.design_pattern_23.creation.nofactory;

public class NoFactoryMain {
	public static void main(String[] args) {
		TableFan tableFan = new TableFan();
		tableFan.switchOn();
	}
}
class TableFan {
	public void switchOn() {
		System.out.println("The TableFan is switched on ...");
	}
}