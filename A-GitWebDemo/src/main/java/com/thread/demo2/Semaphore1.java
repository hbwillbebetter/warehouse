package com.thread.demo2;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
/**
 * 控制线程并发数、起到限流作用
 * 
 * 场景：针对稀缺资源--如数据库连接池---可以限制并发访问数
 * @author Administrator
 *
 */
public class Semaphore1 {
	
	//定义信号量
	private final Semaphore semaphore = new Semaphore(3);
	
	public void m1(){
		try {
			//首先申请信号量
			semaphore.acquire();
			System.out.println("【"+Thread.currentThread().getName()+"】 即将买票");
			TimeUnit.MILLISECONDS.sleep(1000);
			System.out.println("【"+Thread.currentThread().getName()+"】 已经买票");
			TimeUnit.MILLISECONDS.sleep(1000);
			System.out.println("【"+Thread.currentThread().getName()+"】 离开...");
			TimeUnit.MILLISECONDS.sleep(1000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally{
			//释放信号量
			semaphore.release();
		}
		
		
		
	}
	
	
	public static void main(String[] args) {
		Semaphore1 t = new Semaphore1();
		for (int i = 0; i < 20; i++) {
			new Thread(()->t.m1(), "用户:"+(i+1)).start();
		}
		
		
	}
	
	
	
	
	
	
	
	
	
}
