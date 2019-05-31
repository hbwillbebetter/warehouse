package com.thread.demo3;

import java.util.ArrayList;
import java.util.List;

//Solution3：给代码逻辑上锁使用线程不安全的集合
public class TicketSeller3 {
	static List<String> tickets = new ArrayList<String>();
	
	static{
		for(int i=0; i<1000; i++) tickets.add("票编号:"+i);
	}
	/**
	 * 不多说了无论如何都可以防止线程安全问题，因为在Solution1中已经提到过了代码的并发问题是一切问题的原因。
	 */
	public static void main(String[] args) {
		TicketSeller3 t = new TicketSeller3();
		for(int i=0;i<10;i++){
			new Thread(()->{
				synchronized(tickets){
					while(tickets.size() > 0){
						
						try {
							Thread.sleep(10);
						} catch (Exception e) {
							e.printStackTrace();
						}
						System.out.println("销售了---"+tickets.remove(0));
					}
				}
				
				
			}).start();
		}
		
		
	}

}
