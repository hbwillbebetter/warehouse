package com.thread.demo1;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 原子类的不具备可见性
 * @author B
 *
 */
public class AtomicDemo02 {

	private AtomicBoolean atomicBoolean = new AtomicBoolean(true);
	
	public void m1(){
		while(atomicBoolean.get()){
		}
	}
	
	public static void main(String[] args) {
		AtomicDemo02 t = new AtomicDemo02();
		new Thread(()->t.m1(), "t1").start();
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t.atomicBoolean.set(false);
	}

}
