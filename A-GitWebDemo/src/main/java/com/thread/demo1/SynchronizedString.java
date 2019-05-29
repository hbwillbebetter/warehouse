package com.thread.demo1;

import java.util.concurrent.TimeUnit;
/**
 * 不要锁字符串常量
 */
public class SynchronizedString {

	private String s1 = "hello";
    private String s2 = "hello";

    public void m1() {
        synchronized (s1) {
            while(true) {
            	System.out.println("s1..");
            	try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
            }
        }
    }

    public void m2() {
        synchronized (s2) {
            System.out.println("m2 start");
        }
    }

    public static void main(String[] args) {
        SynchronizedString synchronizedString = new SynchronizedString();
        new Thread(()->synchronizedString.m1()).start();
        new Thread(()->synchronizedString.m2()).start();
    }
}
