package com.design_pattern_23.structural.decorator.v2;

public class Test {

	public static void main(String[] args) {
		Carpenter aCarpenter = new Carpenter();
		Plumber aPlumber = new Plumber();
		
		AWorker aWorker1 = new AWorker(aCarpenter);
		aWorker1.doSomething();
		AWorker aWorker2 = new AWorker(aPlumber);
		aWorker2.doSomething();
		
		System.out.println("----------------------------");
		
		Carpenter bCarpenter = new Carpenter();
		Plumber bPlumber = new Plumber();
		
		BWorker bWorker1 = new BWorker(bCarpenter);
		bWorker1.doSomething();
		BWorker bWorker2 = new BWorker(bPlumber);
		bWorker2.doSomething();
		
		
	}

}
