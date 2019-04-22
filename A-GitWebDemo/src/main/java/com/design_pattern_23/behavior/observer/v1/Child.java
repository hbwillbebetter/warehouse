package com.design_pattern_23.behavior.observer.v1;

import java.util.ArrayList;
import java.util.List;

public class Child implements Runnable {
	private String name;//Child的名字
	//持有监听器对象引用
	private List<WakenUpListener> WakenUpListeners = new ArrayList<>();
	
	public Child() {
		
	}

	public Child(String name) {
		this.name = name;
	}

	public void addListener(WakenUpListener listener){
		WakenUpListeners.add(listener);
	}
	
	@Override
	public void run() {
		System.out.println("小孩:"+this.name+",正在睡觉...");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("小孩:"+this.name+",刚醒...");
		
		wakeUp();//一旦小孩醒了，监听者应该做相应的动作
	}

	private void wakeUp() {
		for(WakenUpListener listener : WakenUpListeners){
			//监听者做相应的动作
			listener.actionToWakenUp(new WakenUpEvent(System.currentTimeMillis(), "床", this));
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
