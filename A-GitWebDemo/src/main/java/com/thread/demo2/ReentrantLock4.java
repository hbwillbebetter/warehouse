package com.thread.demo2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * ReentrantLock对synchronized的扩展 ： 可以指定公平锁，哪个线程等待时间长，哪个先执行
 * 在构造函数中放入ture参数
 * @author B
 *
 */
public class ReentrantLock4 {
	
	/**
	 * 构造函数：
	 * 参数 boolean
		 * false : 非公平锁
		 * true : 公平锁
	 * 如果不传参，默认使用非公平锁
	 */
	
	private Lock lock = new ReentrantLock(true);
	
	public void m1(){
		for(int i=0; i<20; i++){
			try {
				lock.lock();
				Thread.sleep(30);
				System.out.println(Thread.currentThread().getName()+" "+i);
			} catch (Exception e) {
				e.printStackTrace();
			} finally{
				lock.unlock();
			}
		}
	}
	
	public static void main(String[] args) {
		ReentrantLock4 t = new ReentrantLock4();
		new Thread(()->t.m1(), "t1").start();
		new Thread(()->t.m1(), "t2").start();
		
		
	}

}
