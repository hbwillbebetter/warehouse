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
 * 这个线程池中只有一个线程，那么你可能回会问这与单个线程有什么区别呢？: - ) 原因就是它可以被复用！
 * 它的使用场景就是当我们需要保证任务执行的先后顺序的时候就可以使用它。
 */
public class SingleThreadPool {

	public static void main(String[] args) throws InterruptedException {
		ExecutorService service = Executors.newSingleThreadExecutor();
		
		for (int i = 0; i < 2; i++) {
			service.execute(()->{
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName());
			});
		}
		
		System.out.println(service);
		
		
	}

}
