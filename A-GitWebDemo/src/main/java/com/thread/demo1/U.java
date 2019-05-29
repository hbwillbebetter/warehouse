package com.thread.demo1;

/**
 * 对业务写代码进行加锁，对读代码不进行加锁，会产生脏读
 * @author B
 *
 */
public class U {

	private String name;
	private double banlance;
	
	private synchronized void set(String name, double banlance){
		this.name = name;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.banlance = banlance;
	}
	
	
	public static void main(String[] args) {
		U t = new U();
		new Thread(()->t.set("zhangsan", 500)).start();
		System.out.println(t.banlance);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(t.banlance);
	}

}
