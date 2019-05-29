package com.thread.demo1;

public class WaitAndNotyifyDemo {
	
	private volatile int count = 0;
	final Object obj = new Object();
	
	public void m1(){
		synchronized (obj) {
			System.out.println("m1 start");
			for(int i=0; i<10; i++){
				count++;
				System.out.println(count);
				if (count == 5) {
					obj.notify();
					try {
						obj.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			System.out.println("m1 end");
		}
		
	}
	
	
	public void m2(){
		synchronized (obj) {
			System.out.println("m2 start");
			if(count != 5){
				try {
					System.out.println("m2 等待中,已释放锁!");
					obj.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			obj.notify();
			System.out.println("m2 end");
			
		}
	}
	
	
	
	public static void main(String[] args) {
		WaitAndNotyifyDemo t = new WaitAndNotyifyDemo();
		new Thread(() -> t.m2()).start();
		new Thread(() -> t.m1()).start();
	}

}
