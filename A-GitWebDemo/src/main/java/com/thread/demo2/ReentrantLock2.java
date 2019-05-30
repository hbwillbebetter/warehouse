package com.thread.demo2;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * ReentrantLock对synchronized的扩展之tryLock()
 * @author B
 *
 */
public class ReentrantLock2 {

	private Lock lock = new ReentrantLock();
	
	public void m1(){
		lock.lock();// 一直锁着，不手动释放， 和synchronized(this)类似，锁定的是堆的对象
	}
	
	public void m2(){
		boolean flag = lock.tryLock();// 如果别的进程锁着就返回false，如果没锁返回true
		// 我们可以根据有没有锁来执行自己的逻辑，而不需要等着锁的释放，更加灵活
		if (flag) {
			System.out.println("已经获得锁!");
		}else {
			System.out.println("未获得锁!");
		}
		
	}
	public void m22(){
		try {
			//尝试一段时间获取锁
			boolean flag = lock.tryLock(5, TimeUnit.SECONDS);
			// 我们可以根据有没有锁来执行自己的逻辑，而不需要等着锁的释放，更加灵活
			if (flag) {
				System.out.println("已经获得锁!");
			}else {
				System.out.println("未获得锁!");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static void main(String[] args) {
		ReentrantLock2 t = new ReentrantLock2();
		new Thread(()->t.m1()).start();
		new Thread(()->t.m2()).start();
	}
}
