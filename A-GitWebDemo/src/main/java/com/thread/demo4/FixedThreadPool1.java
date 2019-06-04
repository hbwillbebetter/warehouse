package com.thread.demo4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 注意：未关闭线程池，线程不会销毁
 * @author B
 *
 */
/*
1.整个程序new了一个5个线程的线程池，使用for循环向这个线程池抛了5个任务。它的执行原则是哪一个线程空闲就由哪个线程来执行这个任务。
	所以我们看到的线程池的线程序号是不固定的乱序的，但是它有个规则就是先执行完任务的线程会在新线程到来时优先分配到任务。

2.线程池shutdown之后程序不会立刻停止而是要等待的所有线程都执行完毕之后再停止服务，所以我们看到的就是Runningà Shutting downà Terminated

3.线程池的任务大体上分为两类，等待就绪队列与已完成任务的队列。通过输出结果我们可以看出在开始有5个正在执行的任务1个任务驻留在就绪队列等待执行，
	在执行结束后我们的已执行队列中就会有6个元素。
 */
public class FixedThreadPool1 {

	public static void main(String[] args) throws InterruptedException {
		ExecutorService service = Executors.newFixedThreadPool(5);
		System.out.println(service);
		for(int i=0; i<6; i++){
			service.submit(()->{
				try {
					TimeUnit.MILLISECONDS.sleep(200);
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName());
			});
		}
		System.out.println(service);
		
		service.shutdown();	
		System.out.println(service.isTerminated());//线程池是否结束		false
		System.out.println(service.isShutdown());//是否关闭线程池		true
		System.out.println(service);
		
		TimeUnit.SECONDS.sleep(5);
		
		System.out.println(service.isTerminated());// true
		System.out.println(service.isShutdown());//true 
		System.out.println(service);
		
		//关闭线程池后，继续添加任务会抛出异常错误：rejectedExecution
//		service.submit(()->{
//			try {
//				TimeUnit.MILLISECONDS.sleep(200);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			System.out.println(Thread.currentThread().getName());
//		});
	}

}
