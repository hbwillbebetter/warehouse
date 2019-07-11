package com.robin.demo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class demo1 {

	public static void main(String[] args) {
		String tomorrowDateStr = new SimpleDateFormat("yyyyMMdd").format(new Date());
		while(tomorrowDateStr.compareTo("20190617") <= 0){
			System.out.println("ok1");
			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			tomorrowDateStr = new SimpleDateFormat("yyyyMMdd").format(new Date());
		}
		System.out.println("ok2");
	}

}
