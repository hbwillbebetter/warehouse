package com.thread.demo1;
/**
 * 
 * 如果执行同步方法中出现异常，那么就会自动释放锁，如果不想释放锁，加上try catch
 * @author B
 *
 */
public class ReleaseLock {

	private int count = 0;
	private int i = 0;
	
	public synchronized void m1(){
		while(true){
			System.out.println(Thread.currentThread().getName()+" "+count++);
			if (count % 10 == 0) {
				i = 1 / 0;
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		ReleaseLock t = new ReleaseLock();
		new Thread(()->t.m1(),"t1").start();
		new Thread(()->t.m1(),"t2").start();
		
	}

}
