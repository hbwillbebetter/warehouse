package com.thread.demo4;

import java.util.concurrent.Executor;
/*
 * 执行器，这是一个接口，内部维护了一个方法execute它负责执行一项任务。参数为Runnable，方法的具体实现由我们自己来执行。
 * 如下面的代码，我们既可以使用单纯的方法调用也可以新启一个新的线程去执行Runnable的run方法。
 * */
public class T01_MyExecutor implements Executor {

	public static void main(String[] args) {
		
		new T01_MyExecutor().execute(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("hello world");
			}
		});
	}

	@Override
	public void execute(Runnable command) {
		
		new Thread(command).start();
//		command.run();
	}

}
