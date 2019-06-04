package com.thread.demo2;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * 
 *绑架案，目的未来钱来赎人
 *张三团伙绑架了小乔，放言要1000万来赎人
 *
 *张三团伙和大乔同时到达约定地点，然后一手交钱，一手交人
 *
 */
public class Exchange1 {
	
	public static void main(String[] args) {
		Exchanger<String> exchanger = new Exchanger<>();
		
		ExecutorService services = Executors.newCachedThreadPool();
		//张三团伙
		services.execute(new Runnable() {
			@Override
			public void run() {
				try {
					String returnStr = exchanger.exchange("小乔");
					System.out.println("绑架者用小乔换回:"+returnStr);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		//小乔家人
		services.execute(new Runnable() {
			@Override
			public void run() {
				try {
					String returnStr = exchanger.exchange("1000万");
					System.out.println("大乔用1000万赎回:"+returnStr);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		services.shutdown();
		
		
	}

}
