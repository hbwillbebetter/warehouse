package com.thread.demo1;
/**
 * volatile关键字   每个线程都有自己的一小块内存，执行的时候会把变量copy过来，修改了后在写回对象，
 * 执行m1方法的线程把 running读到内存里，与此同时主线程也把running读到内存，并进行修改，写回对象为false
 * 但是执行m1的线程里的内存一直都是true啊（因为太忙了没空去刷新）所以会形成死循环，volatile就是当running改了之后
 * 立马去通知其他线程，你们记得去主存刷新一下，一刷新，running为false，退出while循环。
 *
 */
public class VolatileDemo {

	private volatile  boolean running = true;
	
	public void m1(){
		System.out.println("m1 start");
		while(running){
			
		}
		
		System.out.println("m1 end");
	}
	
	
	public static void main(String[] args) {
		VolatileDemo t = new VolatileDemo();
		
		new Thread(()->t.m1()).start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t.running = false;
		
		
		
	}

}
