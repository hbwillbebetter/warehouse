package com.thread.demo3.queue;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 无界阻塞式队列
 * @author B
 *
 */
public class LinkedBlockingQueue1 {

	//初始化一个阻塞队列
	static LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>();
	
	public static void main(String[] args) {
		
		//创建一个生产者线程
		new Thread(()->{
			for(int i=0; i<100; i++){
				try {
					TimeUnit.MILLISECONDS.sleep(10);
					queue.put("a"+i);//如果满了，则会等待
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}, "p1").start();
		
		//创建五个消费者线程
		for(int i=0; i<5; i++){
			new Thread(()->{
				for(;;){
					//从队列消费
					try {
						System.out.println(Thread.currentThread().getName()+" take-"+queue.take());//如果空了，则等待
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}, "c"+i).start();
		}
		try {
			TimeUnit.SECONDS.sleep(7);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			System.out.println("-------主线程再往队列加一个--------");//往队列再加一个，消费者线程能消费到
			queue.put("a"+1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
