package com.design_pattern_23.behavior.observer.v1;

public interface WakenUpListener {//唤醒监听器接口
	
	public void actionToWakenUp(WakenUpEvent e);//唤醒之后，调用者应该对事件对象做的动作
	
}
