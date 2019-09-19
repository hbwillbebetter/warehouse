package com.Calendar;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

/**
 * 参考网址：https://www.jianshu.com/p/222509e6ad80
 * @author B
 *
 */
public class SplitDate {
	
	
	@Test
	public void timeSplitByWeek() {
	    // 1.开始时间 2019-06-09 13:16:04
	    Long startTime = 1560057364000L;
	    // 2.结束时间 2019-07-09 13:16:04
	    Long endTime = 1562649364000L;
	    // 3.开始时间段区间集合
	    List<Long> beginDateList = new ArrayList<Long>();
	    // 4.结束时间段区间集合
	    List<Long> endDateList = new ArrayList<Long>();
	    // 5.调用工具类
	    MyUtils.getIntervalTimeByWeek(startTime, endTime, beginDateList, endDateList);
	    // 6.打印输出
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    for (int i = 0; i < beginDateList.size(); i++) {
	        Long beginStr = beginDateList.get(i);
	        Long endStr = endDateList.get(i);
	        String begin1 = sdf.format(new Date(beginStr));
	        String end1 = sdf.format(new Date(endStr));
	        System.out.println("第" + i + "段时间区间:" + begin1 + "-------" + end1);
	    }
	}
	
	@Test
	public void timeSplitByMonth() {
	    // 1.开始时间 2017-02-03 13:16:04
	    Long startTime = 1486098964000L;
	    // 2.结束时间 2019-07-03 13:16:05
	    Long endTime = 1562130965000L;
	    // 3.开始时间段区间集合
	    List<Long> beginDateList = new ArrayList<Long>();
	    // 4.结束时间段区间集合
	    List<Long> endDateList = new ArrayList<Long>();
	    // 5.调用工具类
	    MyUtils.getIntervalTimeByMonth(startTime, endTime, beginDateList, endDateList);
	    // 6.打印输出
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    for (int i = 0; i < beginDateList.size(); i++) {
	        Long beginStr = beginDateList.get(i);
	        Long endStr = endDateList.get(i);
	        String begin1 = sdf.format(new Date(beginStr));
	        String end1 = sdf.format(new Date(endStr));
	        System.out.println("第" + i + "段时间区间:" + begin1 + "-------" + end1);
	    }
	}
	
	@Test
	public void timeSplitByQuarter() {
	    // 1.开始时间 2018-12-09 13:16:04
	    Long startTime = 1544332564000L;
	    // 2.结束时间 2019-12-09 13:16:04
	    Long endTime = 1575868564000L;
	    // 3.开始时间段区间集合
	    List<Long> beginDateList = new ArrayList<Long>();
	    // 4.结束时间段区间集合
	    List<Long> endDateList = new ArrayList<Long>();
	    // 5.调用工具类
	    MyUtils.getIntervalTimeByQuarter(startTime, endTime, beginDateList, endDateList);
	    // 6.打印输出
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    for (int i = 0; i < beginDateList.size(); i++) {
	        Long beginStr = beginDateList.get(i);
	        Long endStr = endDateList.get(i);
	        String begin1 = sdf.format(new Date(beginStr));
	        String end1 = sdf.format(new Date(endStr));
	        System.out.println("第" + i + "段时间区间:" + begin1 + "-------" + end1);
	    }
	}
	
	
	
	
}
