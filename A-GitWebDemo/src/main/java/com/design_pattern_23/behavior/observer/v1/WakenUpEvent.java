package com.design_pattern_23.behavior.observer.v1;

public class WakenUpEvent {
	private long time;//小孩醒得（事件）的时间
	private String location;//小孩所在位置
	private Child child;//事件源
	
	public WakenUpEvent(long time, String location, Child child) {
		super();
		this.time = time;
		this.location = location;
		this.child = child;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Child getChild() {
		return child;
	}
	public void setChild(Child child) {
		this.child = child;
	}
	
	
}
