package com.thread.demo1;

/**
 * voliatile 不能保证原子性 不能替换synchronized
 * 
 * @author dingyu
 *
 */
public class VolatileDemo02 {

	private volatile int count = 0;
	
	public void m1(){
		
		for(int i=0; i<1000; i++){
			count++;
		}
		
	}
	
	public static void main(String[] args) {
		VolatileDemo02 t = new VolatileDemo02();
		for(int i=0;i<10;i++){
			new Thread(()->t.m1()).start();
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(t.count);
		
	}

}
