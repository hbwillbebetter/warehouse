package com.thread.demo1;

import java.util.concurrent.TimeUnit;

/**
 * 锁是锁在堆内存的那个对象上，而不是引用
 * @author B
 *
 */
public class ChangeReference {
	
	private Object obj = new Object();
	
	public void m1(){
		//锁o
		synchronized (obj) {
			while(true){
				
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName());
				
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		ChangeReference t = new ChangeReference();
		
		new Thread(() -> t.m1(),"t1").start();
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t.obj = new Object();
		new Thread(() -> t.m1(),"t2").start();
		
	}
}
