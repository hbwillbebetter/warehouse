package com.thread.demo3;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

/*
 *CopyOnWriteArrayList在多线程环境下，写时效率低，读时效率高，适合写少读多的环境，比如事件监听器。
 *
 *写时复制：添加元素的时候，会把这个容器复制一份，在复制的那份后面加一个新的，将引用指向复制的那份。
 *读的时候不用加锁，适合写的很少，读的特别多的时候。 
 *
 **/
public class CopyOnWriteList1 {

	public static void main(String[] args) {
		List<String> list = 
//				new ArrayList<String>();//会出现并发问题，最后size<100000,运行时间0.2秒多
//				new Vector<>();//size 100000,运行时间0.2秒多
				new CopyOnWriteArrayList<>();//size 100000,运行时间4.5秒 ,因为一直在“复制”，“写” 效率很低
		Random random = new Random();
		Thread[] ths = new Thread[100];
		for (int i = 0; i < ths.length; i++) {
			ths[i] = new Thread(()->{
				for(int j=0;j<1000;j++){ //起100个线程，每个线程向容器中加1000个数（最终应该是10万个数）
					list.add(UUID.randomUUID().toString());
				}
			});
		}
		runAddComputeTime(ths);
		System.out.println(list.size());
		
	}

	private static void runAddComputeTime(Thread[] ths) {
		long start = System.currentTimeMillis();
		Arrays.asList(ths).forEach(e->e.start());
		//阻塞等待所有线程运行完
		Arrays.asList(ths).forEach(t->{
			try {
				t.join();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		long end = System.currentTimeMillis();
		System.out.println(end-start);
	}

}
