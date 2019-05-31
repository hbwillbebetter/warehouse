package com.thread.demo3;

import java.util.Vector;

//Solution2：使用集合Vector但是代码逻辑不加锁

/**
 * 
代码上的逻辑与solution1是一样的，但是Vector集合是线程安全的，所以它只会出现程序逻辑不安全带来的并发问题。
也就是会出现有可能有多个线程涌入while循环中这是造成并发问题的根本。这个原因会导致在size为1的时候涌入很多的线程进而执行多次删除操作下标越界。
但是绝对不会出现卖出同一张票的情况。我们把remove的代码放大：

这是一个同步的方法，每一个线程过来如果得不到锁得话都会陷入等待。虽然都是remove(0)但是当下一个线程来到的时候0位置已经是一个全新的元素。

 */
public class TicketSeller2 {
	static Vector<String> tickets = new Vector<String>();
	
	static{
		for(int i=0; i<1000; i++) tickets.add("票编号:"+i);
	}
	public static void main(String[] args) {
		TicketSeller2 t = new TicketSeller2();
		for(int i=0;i<10;i++){
			new Thread(()->{
				while(tickets.size() > 0){
					
					try {
						Thread.sleep(10);
					} catch (Exception e) {
						e.printStackTrace();
					}
					System.out.println("销售了---"+tickets.remove(0));
				}
				
				
			}).start();
		}
		
		
	}

}
