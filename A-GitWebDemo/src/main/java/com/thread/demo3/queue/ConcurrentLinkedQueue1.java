package com.thread.demo3.queue;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * ConcurrentLinkedQueue 并发队列（内部加锁的）
 *
 */
public class ConcurrentLinkedQueue1 {

	public static void main(String[] args) {
		Queue<String> queue = new ConcurrentLinkedDeque<String>();//还有双端队列 ...Deque
		for (int i = 0; i < 10; i++) {
			//类似于add方法，如果是ArrayQueue,add方法可能会抛异常，但是offer方法不会抛出异常，返回boolean类型即是否添加成功
			boolean isSucc = queue.offer("a"+i);
		}
		System.out.println(queue);
		System.out.println("队列原始大小:"+queue.size());
		//poll方法表示从队列头拿出一个删掉；peek方法表示从头上拿出一个用不删。
		String poll = queue.poll();
		System.out.println("poll "+poll + "后的队列大小为: "+queue.size());
		System.out.println("再次查看队列:"+queue);
		String peek = queue.peek();
		System.out.println("peek "+peek + "后的队列大小为: "+queue.size());
		System.out.println("再次查看队列:"+queue);
		
		
	}

}
