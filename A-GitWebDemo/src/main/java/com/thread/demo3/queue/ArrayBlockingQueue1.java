package com.thread.demo3.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class ArrayBlockingQueue1 {

	static BlockingQueue<String> strs = new ArrayBlockingQueue<>(10);
	
	public static void main(String[] args) {
		
		for(int i=0; i<10; i++){
			try {
				strs.put("a"+i);// put 满了，就会等待，程序阻塞
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		try {
//			strs.add("aaaa");//已经满了，再往里面加就抛异常
//			strs.put("aaaa");//发现满了，就会等待，程序阻塞
//			boolean flag = strs.offer("aaaa");//不会抛异常，但是加不进去，返回是否添加成功
			boolean flag = strs.offer("aaaa", 1, TimeUnit.SECONDS);//1秒钟后加不进去，就不往里面加了
			System.out.println(flag);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(strs);
		
	}

}
