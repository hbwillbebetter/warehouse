package com.mysql.lock.v1.service.test;

import java.util.Random;

import org.junit.Test;

import com.mysql.lock.v1.Lock;
import com.mysql.lock.v1.service.MysqlLock;

public class MysqlTest {
	
//	private OrderNumGenerator orderNumGenerator = new OrderNumGenerator();
	
	private Lock lock;
	//实际中使用lock锁
//	private java.util.concurrent.locks.Lock lock = new ReentrantLock();
	
	
	@Test
	public void testGetOrderNumber(){
		lock = new MysqlLock();
		System.out.println("####生成唯一订单号###");
		for (int i = 0; i < 50; i++) {
			new Thread(new Runnable(){
				public void run() {
					getNumber();
				}
				
			}).start();
		}
	}
	
	//获取订单
	public void getNumber(){
		try {
			//获取锁资源
			lock.getLock();
//			String number = orderNumGenerator.getNumber();
			int number = new Random().nextInt();
			System.out.println(Thread.currentThread().getName()+ ",生成订单号:" + number);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			lock.unLock();
		}
		
		
	}
	
	
	
	
	
}
