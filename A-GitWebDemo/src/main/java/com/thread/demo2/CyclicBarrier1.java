package com.thread.demo2;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class CyclicBarrier1 {

	/**
	 * 参数parties设置参与者数量，count用于计数，每次都会递减；而成员变量parties的值一直不会变，用于reset。
	 * 
	 * barrierAction允许传入一个实现了Runnable的对象，当调用await方法使count的数量递减到0时，首先会执行此Runnable的对象。
	 * 
	 * 
	 * int getNumberWaiting() 返回在屏障处等待的线程数目。
	 */
	private final CyclicBarrier cb = new CyclicBarrier(3,new Runnable() {
		
		@Override
		public void run() {
			System.out.println("人员全部到齐，拍照留恋..."+Thread.currentThread().getName());
		}
	});
	
	public void m(int user){
		try {
			Random r = new Random();
			//模拟每个人来的时间不一样
			Thread.sleep((long)(Math.random()*1000));
			System.out.println("【"+user+"】"+"到达聚餐地点,当前已有:"+(cb.getNumberWaiting() +1 )+"人-----"+Thread.currentThread().getName());
			//阻塞
			cb.await();
			if (user == 1) {
				System.out.println("拍照结束，开始吃饭...");
			}
			TimeUnit.MILLISECONDS.sleep(200);
			System.out.println("【"+user+"】"+"吃饭完毕，准备回家...");
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		CyclicBarrier1 t = new CyclicBarrier1();
		for (int i = 0; i < 3; i++) {
			final int user = i+1;
			new Thread(()->t.m(user)).start();
		}
	}
	/**
	 方法摘要

	 int	await()   在所有参与者都已经在此 barrier 上调用 await 方法之前，将一直等待。

	 int	await(long timeout, TimeUnit unit)    在所有参与者都已经在此屏障上调用 await 方法之前将一直等待,或者超出了指定的等待时间。

	 int	getNumberWaiting()   返回当前在屏障处等待的参与者数目。

	 int	getParties()   返回要求启动此 barrier 的参与者数目。

	 boolean	isBroken()   查询此屏障是否处于损坏状态。

	 void	reset()  将屏障重置为其初始状态。
	 *
	 */

}
