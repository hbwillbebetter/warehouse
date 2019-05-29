package com.thread.demo1;
/**
 * 同一个资源，同步和非同步的方法可以同时调用
 * @author B
 *
 */
public class Y {
	public synchronized void m1() {
        System.out.println(Thread.currentThread().getName() + " m1 begin---------");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " m1 end---------");
    }
	public void m2() {
        System.out.println(Thread.currentThread().getName() + " m2 begin---------");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " m2 end---------");
    }
	
	public static void main(String[] args) {
		Y t = new Y();
		new Thread(()->t.m1(),"t1").start();
		new Thread(()->t.m2(),"t2").start();
	}
}
