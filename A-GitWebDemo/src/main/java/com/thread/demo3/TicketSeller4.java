package com.thread.demo3;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

//Solution4：使用并发集合不加锁
public class TicketSeller4 {
	static Queue<String> tickets = new ConcurrentLinkedQueue<>();
	
	static{
		for(int i=0; i<1000; i++) tickets.add("票编号:"+i);
	}
/**
 * 首先说并发的集合是线程安全的，而且效率高因为使用了局部锁，这样的话只在取值的时候加了锁，而且如果是以下标来取值的话
 * 还可以同时取走多个地方的值这样的话效率就大大提高。而且这里使用一种取值然后再判断的逻辑巧妙的避免了下标越界的错误，而前面的案例中都是先判断再取值，这样就造成了线程不安全
 */
	public static void main(String[] args) {
		TicketSeller4 t = new TicketSeller4();
		for(int i=0;i<10;i++){
			new Thread(()->{
				while(true){
					
					String s = tickets.poll();
					if(s == null) break;
					System.out.println("销售了---"+s);
				}
				
				
			}).start();
		}
		
		
	}

}
