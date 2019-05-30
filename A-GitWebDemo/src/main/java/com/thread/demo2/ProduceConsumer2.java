package com.thread.demo2;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * 使用Condition 完成生产者消费者模式
 * condition 可以精确线程的 await和signal/signalAll
 * @author B
 *
 */
public class ProduceConsumer2 {

	private final LinkedList<Integer> list = new LinkedList<>();
	private final int Max = 10;
	private int count = 0;
	private final Lock lock = new ReentrantLock();
	private final Condition p = lock.newCondition();//生产者
	private final Condition c = lock.newCondition();//消费者
	
	public void put(Integer i){
		try {
			lock.lock();
			while(this.list.size() == Max){
				try {
					p.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			list.add(i);
			System.out.println(Thread.currentThread().getName()+" 放"+i);
			count++;
			c.signalAll();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			lock.unlock();
		}
	}
	
	public Integer get(){
		Integer value = null;
		try {
			lock.lock();
			while(this.list.size() == 0){
				try {
					c.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			value = list.removeFirst();
			count--;
			p.signalAll();
			return value;
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			lock.unlock();
		}
		return value;
	}
	
	
	public static void main(String[] args) {
		ProduceConsumer2 pc = new ProduceConsumer2();
		for (int i = 0; i < 2; i++) {
			new Thread(()-> {
				for (int j = 0; j < 10; j++) {
					pc.put(j);
				}
			}, "p"+i).start();;
			
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("集合大小："+pc.list.size());
		for (int i = 0; i < 3; i++) {
			new Thread(()-> {
				for (int j = 0; j < 10; j++) {
					int value = pc.get();
					System.out.println(Thread.currentThread().getName()+" 取"+value);
				}
			}, "c"+i).start();;
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("集合大小："+pc.list.size());
		
		
		
		
		
		
		
		
	}

}
