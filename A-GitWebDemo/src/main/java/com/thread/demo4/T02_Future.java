package com.thread.demo4;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;


/*
Future将来的结果
Future常与Callable联合使用，Future可以获得Callable执行后的返回值。如果想新建一个线程执行一个这个Callable中的call方法而且获得返回值的话我们可以使用以下的思路。

方案一：new Thread(new FutureTask(一个实现了Callable的类的对象)---构造方法传入).start();使用FutureTask来接收任务的返回值。

方案二：new一个线程池然后然后提交Callable的实现的对象(submit(new Callablec(){//实现类}))。使用Future来获得Callable的返回值。具体实现如下：
 */
public class T02_Future {
	/*
	 * FutureTask implements RunnableFuture
	 * 
	 * RunnableFuture<V> extends Runnable, Future<V>
	 */
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		FutureTask<Integer> task = new FutureTask<>(new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				TimeUnit.MILLISECONDS.sleep(200);
				return 1000;
			}
		});
//		FutureTask<Integer> task = new FutureTask<>(()->{
//			TimeUnit.SECONDS.sleep(1);
//			return 1000;
//		});
		new Thread(task).start();
		
		System.out.println(task.get());//阻塞
		System.out.println("--------------------------------");
		//*******************************
		
		ExecutorService service = Executors.newFixedThreadPool(5);
		Future<Integer> f = service.submit(()->{
			TimeUnit.MILLISECONDS.sleep(200);
			return 1;
		});
		
		System.out.println(f.get());//阻塞
		System.out.println(f.isDone());
		
		
		
		
		
		
		
	}

}
