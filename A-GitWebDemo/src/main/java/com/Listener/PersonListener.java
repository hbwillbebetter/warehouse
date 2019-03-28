package com.Listener;

//事件监听器,需要接受事件对象
public interface PersonListener {
	public void listenerRun(Event event);
	public void listenerEat(Event event);
}
