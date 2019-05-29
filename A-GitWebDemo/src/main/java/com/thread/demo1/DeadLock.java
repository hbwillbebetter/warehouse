package com.thread.demo1;
/**
 * 模拟一个简单的死锁
 * @author B
 *
 */
public class DeadLock {

	private Object o1 = new Object();
	private Object o2 = new Object();
	
	public void m1(){
		synchronized (o1) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (o2) {
				System.out.println(Thread.currentThread().getName()+": 如果出现这句话则没有死锁!");
			}
		}
	}
	
	public void m2(){
		synchronized (o2) {
			synchronized (o1) {
				System.out.println(Thread.currentThread().getName()+": 如果出现这句话则没有死锁!");
			}
		}
	}
	
	public static void main(String[] args) {
		DeadLock t = new DeadLock();
		new Thread(()->t.m1(),"t1").start();
		new Thread(()->t.m2(),"t2").start();
	}

}
