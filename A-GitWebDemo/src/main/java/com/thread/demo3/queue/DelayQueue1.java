package com.thread.demo3.queue;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
/**
 * 
 往DelayQueue里加的元素是按时间排好序的，该队列是无界的。另外元素要实现Delayed接口，而Delayed接口又继承了Comparable接口，
所以该类元素需要实现compareTo()方法；并且每个元素记载着自己还有多长时间才能被拿走，还要实现getDelay()方法。
 *
 */
public class DelayQueue1 {
	static DelayQueue<MyTask> tasks = new DelayQueue<>();
	
	static class MyTask implements Delayed {//实现Delayed接口
		long runningTime;
		String name;
		public MyTask(long runningTime, String name) {
			this.runningTime = runningTime;
			this.name = name;
		}

		@Override
		public int compareTo(Delayed o) {
			if (this.getDelay(TimeUnit.MILLISECONDS) < o.getDelay(TimeUnit.MILLISECONDS)) {
				return -1;
			}else if (this.getDelay(TimeUnit.MILLISECONDS) > o.getDelay(TimeUnit.MILLISECONDS)) {
				return 1;
			}else 
				return 0;
		}

		@Override
		public long getDelay(TimeUnit unit) {
			return unit.convert(runningTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
		}
		
		@Override
		public String toString() {
			return name + "---" + runningTime;
		}
	}
	
	public static void main(String[] args) {
		long now = System.currentTimeMillis();
		MyTask t1 = new MyTask(now + 1000, "task1"); //1 s 后执行 //②	  	2
		MyTask t2 = new MyTask(now + 2000, "task2"); //2 s后执行  //④		4
		MyTask t3 = new MyTask(now + 1500, "task3"); //1.5s后执行 //③		3
		MyTask t4 = new MyTask(now + 500, "task4"); //0.5s后执行 //①     	1
		MyTask t5 = new MyTask(now + 2500, "task5"); //2.5s后执行 //⑤       	5
		
		
		tasks.put(t1);
		tasks.put(t2);
		tasks.put(t3);
		tasks.put(t4);
		tasks.put(t5);
		System.out.println(tasks);
		for (int i=0; i<5; i++) {
            try {
                System.out.println(tasks.take().toString()); //按放进去的顺序拿出
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
		
		
		
		
		
	}
}
