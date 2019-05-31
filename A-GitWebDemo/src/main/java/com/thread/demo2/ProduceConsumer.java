package com.thread.demo2;

import java.util.LinkedList;

/**
 * 使用wait和notifyAll实现消费者生产者模式
 * @author B
 *
 */
public class ProduceConsumer<T> {

	private final LinkedList<T> list = new LinkedList<>();
	private final int Max = 10;
	private int count = 0;
	
	//放
	public synchronized void put(T i){
		//满了不能放
		/**
		 * 为什么是while？
			有下面的一个场景，当消费者消费的阈值不满足条件那么它将会被wait阻塞。此时还有其的9个消费者也处于阻塞状态。
			当notifyAll的时候我们希望的是让生产者来生产元素，但是这时候被唤醒的消费者会继续去消费，代码会从wait()处直接向下执行。
			如果是一个if判断，再加上这时的集合中没有元素那么此时一定会出异常。但是如果使用的是while的话那么被唤醒的消费者就会循环检测发现不满足条件就继续阻塞。整个程序顺利进行。
		 * 
		 * 
		 * //想想为什么用while而不是用if？
		 * 如果用if：比如集合已经存放9个元素，此时有两个线程在this.wait()被唤醒，这时两个线程都不做再一次的判断，而对count++,这就超过list的容量啦。。。
		 */
		while(this.list.size() == Max){//wait大多数情况和while一起用
			try {
				this.wait();// 如果满了我就释放锁，并且等待
				//...
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		count++;
		list.add(i);// 生产一个
		//唤醒取线程
		this.notifyAll();// 叫醒消费者可以消费啦
	}
	//取
	public synchronized T get(){
		//集合为空，不能取
		while(this.list.size() == 0){
			try {
				this.wait();// 如果集合为空，不能消费，释放锁，等着
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		count--;
		T value = list.removeFirst();
		//唤醒放线程
		this.notifyAll();// 叫醒生产者，可以继续生产啦
		return value;
	}
	
	
	public static void main(String[] args) {
		ProduceConsumer<String> pc = new ProduceConsumer<>();
		for (int i = 0; i < 2; i++) {
			new Thread(()-> {
				for (int j = 0; j < 10; j++) {
					pc.put(Thread.currentThread().getName() + " " + j);
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
					System.out.println(pc.get());
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
