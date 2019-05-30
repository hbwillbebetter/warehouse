package com.thread.demo2;

import java.util.LinkedList;

/**
 * 使用wait和notifyAll实现消费者生产者模式
 * @author B
 *
 */
public class ProduceConsumer {

	private final LinkedList<Integer> list = new LinkedList<>();
	private final int Max = 10;
	private int count = 0;
	
	//放
	public synchronized void put(Integer i){
		//满了不能放
		while(this.list.size() == Max){//wait大多数情况和while一起用
			try {
				this.wait();// 如果满了我就释放锁，并且等待
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		count++;
		list.add(i);// 生产一个
		System.out.println(Thread.currentThread().getName()+" 放"+i);
		//唤醒取线程
		this.notifyAll();// 叫醒消费者可以消费啦
	}
	//取
	public synchronized int get(){
		//集合为空，不能取
		while(this.list.size() == 0){
			try {
				this.wait();// 如果集合为空，不能消费，释放锁，等着
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		count--;
		Integer value = list.removeFirst();
		//唤醒放线程
		this.notifyAll();// 叫醒生产者，可以继续生产啦
		return value;
	}
	
	
	public static void main(String[] args) {
		ProduceConsumer pc = new ProduceConsumer();
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
