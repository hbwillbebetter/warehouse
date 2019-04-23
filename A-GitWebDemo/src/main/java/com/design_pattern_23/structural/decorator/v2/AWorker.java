package com.design_pattern_23.structural.decorator.v2;

public class AWorker implements Worker {

	private Worker worker;
	
	public AWorker() {
	}
	public AWorker(Worker worker) {
		this.worker = worker;
	}
	
	@Override
	public void doSomething() {
		System.out.println("我是A公司的员工");
		worker.doSomething();//调用子类自己的
	}

}
