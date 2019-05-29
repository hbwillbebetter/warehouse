package com.thread.demo1;

/**
 * 重入锁
 * 同线程内一个同步方法可以去调用另一个同步方法（重入锁 还有一种重入锁就是子类调用父类的同步方法）
 * @author B
 *
 */
public class I {

	private synchronized void m1(){
		System.out.println("m1 start");
		m2();
		System.out.println("m1 end");
	}
	private synchronized void m2(){
		System.out.println("m2 start");
		System.out.println("m2 end");
	}
	
	public static void main(String[] args) {
		I i = new I();
		new Thread(()->i.m1()).start();
	}
	
}
