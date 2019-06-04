package com.thread.demo4;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

/*
 * 
这个线程池设计的思想就与MapReduce极其相似，将一个大的任务分解成一个个小的任务当多个线程来执行。
然后将计算的结果汇总得到最终结果。这也是用到了递归的思想。
其中它的任务分为两种:
	一种没有返回值是RecursiveAction，
	一种有返回值RecursiveTask。常常用于大量数据的运算以下为示例代码：
 */
public class ForkJoinPool1 {
	
	static int[] nums = new int[1000000];
	static final int MAX_NUM = 50000;//最大划分快
	static Random random = new Random();
	
	static{
		for (int i = 0; i < nums.length; i++) {
			nums[i] = random.nextInt(100);
		}
		System.out.println(Arrays.stream(nums).sum());
	}
	
//	static class AddTask extends RecursiveAction {
//		int start,end;
//		
//		public AddTask(int s, int e) {
//			this.start = s;
//			this.end = e;
//		}
//
//		@Override
//		protected void compute() {
//			
//			if (end - start <= MAX_NUM) {
//				long sum = 0;
//				for (int i = start; i < end; i++) {
//					sum += nums[i];
//				}
//				System.out.println("from:" + start + " to:" + end + " = " + sum);
//			}else {
//				int middle = start + (end - start) / 2;
//				AddTask subTask1 = new AddTask(start, middle);
//				AddTask subTask2 = new AddTask(middle, end);
//				subTask1.fork();
//				subTask2.fork();
//				
//			}
//			
//			
//		}
//		
//	}
	
	static class AddTask extends RecursiveTask<Long> {
		int start,end;
		
		public AddTask(int s, int e) {
			this.start = s;
			this.end = e;
		}

		@Override
		protected Long compute() {
			
			if (end - start <= MAX_NUM) {
				long sum = 0;
				for (int i = start; i < end; i++) {
					sum += nums[i];
				}
				return sum;
			}else {
				int middle = start + (end - start) / 2;
				AddTask subTask1 = new AddTask(start, middle);
				AddTask subTask2 = new AddTask(middle, end);
				subTask1.fork();
				subTask2.fork();
				return subTask1.join() + subTask2.join();
			}
			
			
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		
		ForkJoinPool fjp = new ForkJoinPool();
		AddTask task = new AddTask(0, nums.length);
		fjp.execute(task);
		
		long result = task.join();
		System.out.println(result);
		System.in.read();
		
		
	}

}
