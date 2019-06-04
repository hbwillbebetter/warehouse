package com.thread.demo4;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/*
 * 
public ScheduledFuture<?> scheduleAtFixedRate(Runnable command,
                                                  long initialDelay,
                                                  long period,
                                                  TimeUnit unit)
initialDelay：在开始多少单位时间的时候执行第一个任务。

Period：每隔多长时间执行下一个任务。

Unit：时间的单位。

它的底层基于DelayedWorkQueue。                                                 
 * 
 */
public class ScheduledThreadPool1 {
	
	//以下代码展示了已启动就开始执行的而且步幅为0.5s的线程执行方式：
	public static void main(String[] args) {
		ScheduledExecutorService service = Executors.newScheduledThreadPool(4);
	     service.scheduleAtFixedRate(()->{
	         try {
	              TimeUnit.MILLISECONDS.sleep(new Random().nextInt(1000));
	          } catch (InterruptedException e) {
	             e.printStackTrace();
	         }
	           System.out.println(Thread.currentThread().getName());
	       }, 0, 500, TimeUnit.MILLISECONDS);
		
		
		
		
	}

}
