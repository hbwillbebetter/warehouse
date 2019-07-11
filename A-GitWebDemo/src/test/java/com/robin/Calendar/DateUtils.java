package com.robin.Calendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

/**
 * 获取前一天日期字符串
 * @author B
 *
 */
public class DateUtils {

	@Test
	public void getDay() {
		String day = "1970-01-01";
		Calendar c = Calendar.getInstance();
		Date date = null;
		try {
			date = new SimpleDateFormat("yy-MM-dd").parse(day);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		c.setTime(date);
		int day1 = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day1 - 1);

		String dayAfter = new SimpleDateFormat("yyyy-MM-dd")
				.format(c.getTime());
		System.out.println(dayAfter);
	}
	
	//获取日期中的小时（24小时制）
	@Test
	public void getHour() throws InterruptedException{
		String hour = new SimpleDateFormat("HH").format(new Date());
		System.out.println(hour);
		int hourInt = Integer.parseInt(hour);
		while(true){
			if (hourInt >= 21 && hourInt <= 23) {
				System.out.println(hourInt);
				Thread.sleep(1000);
				hour = new SimpleDateFormat("HH").format(new Date());
				hourInt = Integer.parseInt(hour);
			}else {
				System.out.println(hourInt);
				break;
			}
		}
	}
	
	
	

}
