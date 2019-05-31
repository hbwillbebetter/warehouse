package com.thread.demo3;

import java.util.ArrayList;
import java.util.List;


/**
 * 场景
 * 有N张火车票，每张票都有一个编号
 * 同时有10个窗口对外售票
 * 请写一个模拟程序
 * 分析下面的程序可能会产生哪些问题？
 * 重复销售？超量销售？
 *
 */
//Solution1：使用线程不安全的集合而且不上锁
public class TicketSeller1 {
	static List<String> tickets = new ArrayList<String>();
	
	static{
		for(int i=0; i<1000; i++) tickets.add("票编号:"+i);
	}
	/**
	 * 为了使得问题呈现的效果明显我们加上了睡眠时间。此程序会出现的问题：

总的来说会有两个点出现问题：

①程序逻辑的线程不安全，有可能有多个线程涌入while循环中这是造成并发问题的根本。这个原因会导致在size为1的时候涌入很多的线程进而执行多次删除操作下标越界。

②集合的线程不安全，remove的方法本来就不是线程安全的。为了说明问题我，我们把remove方法放大：

可以看出如果两个线程同时执行remove方法的话，由于index一样所以他们的remove的返回值就会得到同一个oldValue。也就是重复卖出。
	 */
	public static void main(String[] args) {
		TicketSeller1 t = new TicketSeller1();
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
