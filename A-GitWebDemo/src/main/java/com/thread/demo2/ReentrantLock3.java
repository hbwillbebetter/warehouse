package com.thread.demo2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock对synchronized的扩展：可以被其他线程打断
 * 因为m1方法一直占着锁，m2永远不可能得到锁，既然得不到锁，我们关闭m2就好了，这时候得用lockInterruptibly方法
 * 
 * 注意synchronized不响应中断，线程执行到synchronized(this)，会一致傻傻的等着。
 * @author B
 *
 */
public class ReentrantLock3 {

	private Lock lock = new ReentrantLock();
	
	public void m1(){
		lock.lock();
		try {
			System.out.println("m1 start");
			while(true){
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			lock.unlock();//手动释放锁
			System.out.println("m1 end");
		}
	}
	
	public void m2(){
		try {
			System.out.println("m2 start");
			lock.lockInterruptibly();//可被打断
		} catch (InterruptedException e) {
			System.out.println("m2 被打断了..");
			e.printStackTrace();
		} finally{
			if (lock.tryLock()) {
				System.out.println("m2 拿到锁");
				lock.unlock();
			}
			System.out.println("m2 end");
		}
		
	}
	public static void main(String[] args) {
		ReentrantLock3 t = new ReentrantLock3();
		Thread t1 = new Thread(()->t.m1());
		t1.start();
		Thread t2 = new Thread(()->t.m2());
		t2.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//主线程打断t2(因为t2线程永远得不到锁)
		t2.interrupt();
	}
	
	
	
	
	

}
