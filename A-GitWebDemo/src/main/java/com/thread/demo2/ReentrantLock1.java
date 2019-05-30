package com.thread.demo2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * Reentrant 再进入
 * ReentrantLock 一个可重入互斥Lock具有与使用synchronized方法和语句访问的隐式监视锁相同的基本行为和语义，但具有扩展功能。（从jdk1.8中文版复制而来）
 * 可以完成synchronized相同的作用，但必须手动释放锁
 *
 */
public class ReentrantLock1 {

	private Lock lock = new ReentrantLock();
	
	public void m1(){
		try {
			lock.lock();//手动上锁，功能和synchronized(this)类似，锁定的是堆上的对象
			for (int i = 0; i < 20; i++)
				System.out.println("m1 " + i);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("m1 start");
		} finally{
			lock.unlock();//手动解锁
			System.out.println("m1 end");
		}
	}
	public void m2(){
		try {
			lock.lock();
			for (int i = 0; i < 20; i++)
				System.out.println("m2 " + i);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("m2 start");
		} finally{
			lock.unlock();//手动解锁
			System.out.println("m2 end");
		}
	}
	
	public static void main(String[] args) {
		ReentrantLock1 t = new ReentrantLock1();
		new Thread(()->t.m1()).start();
		new Thread(()->t.m2()).start();
	}

}
