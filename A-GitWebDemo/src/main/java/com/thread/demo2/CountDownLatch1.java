package com.thread.demo2;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch 类位于 java.util.concurrent 包下，利用它可以实现类似计数器的功能。比如有
一个任务 A，它要等待其他 4 个任务执行完毕之后才能执行，此时就可以利用 CountDownLatch
来实现这种功能了。
 *
 */
public class CountDownLatch1 {

	
	final CountDownLatch latch = new CountDownLatch(2);
	
	public void m1(){
		System.out.println(Thread.currentThread().getName()+" start");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+" end");
		latch.countDown();
	}
	public void m2(){
		System.out.println(Thread.currentThread().getName()+" start");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+" end");
		latch.countDown();
	}
	
	
	public static void main(String[] args) {
		CountDownLatch1 t = new CountDownLatch1();
		System.out.println("等待所有子线程执行完!");
		new Thread(()->t.m1(),"t1").start();
		new Thread(()->t.m2(),"t2").start();
		try {
			t.latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("所有子线程执行完毕!");
	}

}
