package com.thread.demo3.queue;

import java.util.concurrent.LinkedTransferQueue;
/**
 * 
适用场景：消费者先启动，生产者生产一个东西的时候，不扔在队列里，而是直接去找有没有消费者，有的话直接扔给消费者，若没有消费者线程，调用transfer()方法就会阻塞，调用add()、offer()、put()方法不会阻塞。
TransferQueue适用于更高的并发情况
 *
 */
/*消费者先启动，生产者生产一个东西的时候，不扔在队列里，而是直接去找有没有消费者，有的话直接扔给消费者，
若没有消费者线程，调用transfer()方法就会阻塞，调用add()、offer()、put()方法不会阻塞。*/
public class TransferQueue1 {

	public static void main(String[] args) throws InterruptedException {
		LinkedTransferQueue<String> queue = new LinkedTransferQueue<>();
		
		new Thread(()->{//先启动一个消费者
			try {
				System.out.println(queue.take());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}).start();
		queue.transfer("aaa");
//		queue.put("aaaa");// add, offer
//		new Thread(()->{//如果使用transfer（），消费者在生产者后启动，拿不到aaa,程序阻塞;如果put()/add()/offer(),则不会阻塞
//			try {
//				System.out.println(queue.take());
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}).start(); 
		
		
	}

}
