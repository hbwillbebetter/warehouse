package com.thread.condition;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.junit.Test;

/**
 * 参考：https://blog.csdn.net/yyd19921214/article/details/49737061
 * lock()与lockInterruptibly()的区别
 * lock 与 lockInterruptibly比较区别在于：
lock 优先考虑获取锁，待获取锁成功后，才响应中断。
lockInterruptibly 优先考虑响应中断，而不是响应锁的普通获取或重入获取。

详细区别：
	1.ReentrantLock.lockInterruptibly允许在等待时由其它线程调用等待线程的Thread.interrupt方法来中断等待线程的等待而直接返回，
这时不用获取锁，而会抛出一个InterruptedException。 
	2.ReentrantLock.lock方法不允许Thread.interrupt中断,即使检测到Thread.isInterrupted,一样会继续尝试获取锁，失败则继续休眠。
只是在最后获取锁成功后再把当前线程置为interrupted状态,然后再中断线程。
 * 
 * 这里使用的是lock()方法，在主程序中执行test3()方法后回发现，即使执行了interrupt()方法也没有反应。
将注释代码取消掉，我们会发现，程序要求捕捉该异常
 * @author B
 *
 */
public class lock_lockInterruptibly extends Thread{
	
	@Test
	public void test3() throws Exception{
	    final Lock lock=new ReentrantLock();
	    lock.lock();
	    Thread.sleep(1000);
	    Thread t1=new Thread(new Runnable(){
	        @Override
	        public void run() {
	            lock.lock();
//	        	try {
//					lock.lockInterruptibly();
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
	            System.out.println(Thread.currentThread().getName()+" interrupted.");
	        }
	    });
	    t1.start();
	    Thread.sleep(1000);
	    t1.interrupt();
	    Thread.sleep(1000000);
	}
}
