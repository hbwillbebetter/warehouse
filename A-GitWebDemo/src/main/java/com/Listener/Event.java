package com.Listener;
//事件对象
public class Event {

	private Person person;
	
	public Event(){
		
	}
	public Event(Person person){//用来封装人这个对象
		this.person = person;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	
}
