package com.thread.demo2;

import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier
	一个同步辅助类，它允许一组线程互相等待，直到到达某个公共屏障点 (common barrier point)。在涉及一组固定大小的线程的程序中，这些线程必须不时地互相等待，
	此时 CyclicBarrier 很有用。因为该 barrier 在释放等待线程后可以重用，所以称它为循环 的 barrier。
	CyclicBarrier 支持一个可选的 Runnable 命令，在一组线程中的最后一个线程到达之后（但在释放所有线程之前），该命令只在每个屏障点运行一次。
	若在继续所有参与线程之前更新共享状态，此屏障操作 很有用。
 * 
 * 
 * 参考：https://www.2cto.com/kf/201405/298357.html
 * 实例：(同事们一起聚餐时， 等所有人全部到达饭店后，才能开吃)
 * @author B
 *
 */
public class CyclicBarrier2 {

	public static void main(String[] args) {
		
		final CyclicBarrier cb = new CyclicBarrier(5);
		CyclicBarrier2 t = new CyclicBarrier2();
		
		for (int i = 1; i <= 5; i++) {
	        new Thread("同事" + i){
	            public void run() {
	                try {
	                	Thread.sleep((long)(Math.random()*5000));
                		System.out.println("第" + (cb.getNumberWaiting() + 1) + "位到达：" + this.getName());
	                    cb.await();
	                } catch (Exception e) {
	                    e.printStackTrace();
	                } 
	                System.out.println("========" + this.getName() + "==============");
	            };
	        }.start();
	    }
		
		
		
		
		
	}

}
