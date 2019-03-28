package com.Listener;

public class MyPersonListener implements PersonListener {

	@Override
	public void listenerRun(Event event) {
		Person person = event.getPerson();//获取事件源对象
		System.out.println("奔跑前，积极投入健身中，健身使我变得更健康!!!");
	}

	@Override
	public void listenerEat(Event event) {
		Person person = event.getPerson();//获取事件源对象
		System.out.println("吃东西前，先洗个手，个人卫生要做到最好!!!");
	}

}
