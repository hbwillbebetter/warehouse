package com.design_pattern_23.behavior.observer.v1;

public class GrandFather implements WakenUpListener {

	@Override
	public void actionToWakenUp(WakenUpEvent e) {
		long time = e.getTime();
		String location = e.getLocation();
		Child child = e.getChild();
		System.out.println("爷爷在时间:"+time+",来到:"+location+"边,哄小孩:"+child.getName()+"玩..");
	}

}
