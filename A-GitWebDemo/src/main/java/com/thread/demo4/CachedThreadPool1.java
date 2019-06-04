package com.thread.demo4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
/**
 * 注意：未关闭线程池，线程空闲超过60秒，自动销毁
 * @author B
 *
 */
/*
CachedPool的主要特点就是如果新来的一个任务需要这个线程池来执行的话，如果当前线程池没有闲置的线程那么就新启动一个线程，
如果有空闲线程那么就使用其中的一个空闲线程。就是这样的一个有弹性的线程池。默认情况下当一个线程空闲超过60s那么就会销毁，
而且线程数量最大不能超过int类型的最大值或者是计算机内存的大小。以下代码展示了这样的特性：
 */
public class CachedThreadPool1 {

	public static void main(String[] args) throws InterruptedException {
		
		ExecutorService service = Executors.newCachedThreadPool();
		
		System.out.println(service);
		
		for (int i = 0; i < 2; i++) {
			service.execute(()->{
				try {
	                 TimeUnit.MILLISECONDS.sleep(500);
	              } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
				System.out.println(Thread.currentThread().getName());
			});
		}
		
		System.out.println(service);
		TimeUnit.SECONDS.sleep(80);
		
		System.out.println(service);//80s后线程池的线程销毁了。
		
		/**
		 * 	执行结果：
		 * 	java.util.concurrent.ThreadPoolExecutor@4e25154f[Running, pool size = 0, active threads = 0, queued tasks = 0, completed tasks = 0]
			java.util.concurrent.ThreadPoolExecutor@4e25154f[Running, pool size = 2, active threads = 2, queued tasks = 0, completed tasks = 0]
			pool-1-thread-1
			pool-1-thread-2
			java.util.concurrent.ThreadPoolExecutor@4e25154f[Running, pool size = 0, active threads = 0, queued tasks = 0, completed tasks = 2]
		 */
		
	}

}
