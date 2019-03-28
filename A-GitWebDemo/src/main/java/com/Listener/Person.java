package com.Listener;

//事件源
public class Person {
	
	//定义空的事件监听器
	private PersonListener personListener;
	
	public void registerListener(PersonListener personListener){
		this.personListener = personListener;
	}
	
	
	public void run(){
		//前置操作
		if(personListener != null){
			//获取当前事件对象
			Event event = new Event(this);
			this.personListener.listenerRun(event);
		}
		System.out.println("人可以奔跑!");
	}
	
	public void eat(){
		//前置操作
		if(personListener != null){
			//获取当前事件对象
			Event event = new Event(this);
			this.personListener.listenerEat(event);
		}
		System.out.println("人可以吃东西!");
	}
	
	
}
