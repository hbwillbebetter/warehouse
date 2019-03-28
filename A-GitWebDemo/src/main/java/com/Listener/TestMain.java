package com.Listener;

public class TestMain {

	public static void main(String[] args) {
		Person person = new Person();
		person.registerListener(new MyPersonListener());
		person.run();
		person.eat();
		
		
	}

}
