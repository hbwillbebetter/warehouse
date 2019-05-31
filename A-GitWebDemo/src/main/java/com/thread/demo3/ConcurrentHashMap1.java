package com.thread.demo3;

import java.util.Arrays;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

/**
 * tips：Map和Set本质上是一样的，只是Set只有key，没有value，所以下面谈到的Map可以替换成Set。

  在不加锁的情况下，可以用：HashMap、TreeMap、LinkedHashMap。想加锁可以用Hashtable（用的非常少）。

  在并发量不是很高的情况下，可以用Collections.synchronizedXxx()方法，在该方法中传一个不加锁的容器（如Map），它返回一个加了锁的容器（容器中的所有方法加锁）！

   在并发性比较高的情况下，用ConcurrentHashMap ，如果并发性高且要排序的情况下，用ConcurrentSkipListMap。
 *
 */
public class ConcurrentHashMap1 {
	
	public static void main(String[] args) {
		 Map<String,String> map = new ConcurrentHashMap<>();//1237 1214
//       Map<String,String> map = new ConcurrentSkipListMap<>(); //同TreeMap，插入时效率比较低。查快 1768 1980
//       Map<String,String> map = new Hashtable<>();//1327 1326

//		 Map<String,String> map = new HashMap<>();
//       Map<String,String> map = new TreeMap<>();  //插入时要排序，所以插入可能会比较慢
		 Random r = new Random();
		 Thread[] ths = new Thread[100];
		 CountDownLatch latch = new CountDownLatch(ths.length);//门闩计数器  100
		 long start = System.currentTimeMillis();//开始时间
		 for (int i = 0; i < ths.length; i++) {
			ths[i] = new Thread(()->{
				for(int j=0;j<10000;j++){//向map中加入1万个随机字符串key、value
					map.put(UUID.randomUUID().toString(), "");
				}
				latch.countDown();//每执行一个线程，就countdown一次
			});
		}
		Arrays.asList(ths).forEach(e -> e.start());//所有线程启动
		try {
			latch.await(); //主线程在这等着，直到countdown到0
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		long end = System.currentTimeMillis();//结束时间
		System.out.println(end-start);//程序执行时间
		System.out.println(map.size());//打印size
	}
}
