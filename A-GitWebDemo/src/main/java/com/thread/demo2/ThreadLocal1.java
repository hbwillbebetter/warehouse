package com.thread.demo2;


/**
 * ThreadLocal 线程局部变量  每个线程中的这个变量归自己线程管
 * ThreadLocal用空间换时间（不需要加锁），而synchronized、lock等都是时间换空间
 * Hibernate底层大量用这个，因为效率更高，不可避免的是牺牲掉一些内存等资源。
 * 
 * @author B
 *
 */
public class ThreadLocal1 {

	private ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
	
	public void m1(){
		System.out.println(Thread.currentThread().getName()+" "+threadLocal.get());
	}
	
	public void m2(){
		threadLocal.set(888);
		System.out.println(Thread.currentThread().getName()+" "+threadLocal.get());
	}
	
	public static void main(String[] args) {
		ThreadLocal1 t = new ThreadLocal1();
		new Thread(()->t.m2(), "t1").start();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new Thread(()->t.m1(), "t2").start();
		
	}

}
