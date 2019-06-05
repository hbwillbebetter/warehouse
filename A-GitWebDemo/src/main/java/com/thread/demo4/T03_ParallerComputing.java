package com.thread.demo4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class T03_ParallerComputing {

	static class MyTask implements Callable<List<Integer>> {
		int start,end;
		public MyTask(int s, int e) {
			this.start = s;
			this.end = e;
		}

		@Override
		public List<Integer> call() throws Exception {
			List<Integer> r = getPrime(start, end);
			return r;
		}

	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		long start = System.currentTimeMillis();
		List<Integer> results = getPrime(1, 200000); 
		long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println("单线程总数:"+results.size());
		
		final int cpuCoreNum = 4;
		ExecutorService service = Executors.newFixedThreadPool(cpuCoreNum);
		
		MyTask t1 = new MyTask(1, 80000); //1-5 5-10 10-15 15-20
	    MyTask t2 = new MyTask(80001, 130000);
	    MyTask t3 = new MyTask(130001, 170000);
	    MyTask t4 = new MyTask(170001, 200000);
		
	    Future<List<Integer>> f1 = service.submit(t1);
	    Future<List<Integer>> f2 = service.submit(t2);
	    Future<List<Integer>> f3 = service.submit(t3);
	    Future<List<Integer>> f4 = service.submit(t4);
	    start = System.currentTimeMillis();
	    List<Integer> list = new ArrayList<Integer>();
	    list.addAll(f1.get());
	    list.addAll(f2.get());
	    list.addAll(f3.get());
	    list.addAll(f4.get());
	    end = System.currentTimeMillis();
	    System.out.println(end-start);
	    System.out.println("线程池总数:"+list.size());
	    
	    
		
	}
	
	/**
	 * 判断是否为质数
	 * @param num
	 * @return
	 */
	static boolean isPrime(int num) {
		for (int i = 2; i <= num / 2; i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}
	
	/**
	 * 获得质数集合
	 * @param start
	 * @param end
	 * @return
	 */
	static List<Integer> getPrime(int start, int end) {
		List<Integer> results = new ArrayList<>();
		for (int i = start; i <= end; i++) {
			if (isPrime(i))
				results.add(i);
		}

		return results;
	}
	
	

}
