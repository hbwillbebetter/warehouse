package com.design_pattern_23.structural.decorator.v2;

public class BWorker implements Worker {

	private Worker worker;
	
	public BWorker(){}
	public BWorker(Worker worker){
		this.worker = worker;
	}
	
	@Override
	public void doSomething() {
		System.out.println("我是B公司的员工");
		worker.doSomething();
	}

}
