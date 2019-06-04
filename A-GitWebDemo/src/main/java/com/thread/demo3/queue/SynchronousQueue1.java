package com.thread.demo3.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
/*
 * SynchronizedQueue （特殊的TransferQueue，容量为0）
 * 
 * 扔在队列的东西必须被消费者马上消费掉，否则就会出问题
 */
public class SynchronousQueue1 {

	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<String> queue = new SynchronousQueue<>();
//		new Thread(new Runnable() {//创建一个消费者
//			@Override
//			public void run() {
//				try {
//					System.out.println(queue.take());
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//		}).start();
		queue.put("bbb");// put阻塞，等待消费者消费，内部调用的是transfer()
		
//		boolean flag = queue.offer("bbb"); // 不报错，offer不进去
//		System.out.println(flag);
		
//		queue.add("bbb");// 报错，add不进去
		
		System.out.println(queue.size());// 0
		
//		new Thread(new Runnable() {//后启动一个消费者
//			@Override
//			public void run() {
//				try {
//					System.out.println("----");
//					System.out.println(queue.take());
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//		}).start();
	}

}
