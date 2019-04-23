package com.fahai.forkjoin;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.io.FileUtils;


//测试少鹏报告服务，多线程
public class TestReportServiceMain {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		List<String> lines = FileUtils.readLines(new File("/home/usr/local/boscApp/logs/test.txt"), "UTF-8");
		List<String> lines = FileUtils.readLines(new File("H:/浙商银行/data/source/CUSTLIST/test.txt"), "UTF-8");
		List<String> urls = new ArrayList<String>();
		for(String line : lines){
			if (line == null || "".equals(line.trim())) {
				continue;
			}
			String company = line;
			company = URLEncoder.encode(company.trim());
			String url = "http://192.168.35.77/bosc-report/getOtherData?reportType=SSXSQYQD&companyName="+company+"&type=BA&serviceTime=20190411";
			urls.add(url);
		}
		
		AtomicInteger atomicInteger=new AtomicInteger(1);
		ForkJoinPool forkjoinPool = new ForkJoinPool(10);
		SSForkJoin task = new SSForkJoin(urls, atomicInteger);
		List<Map<String,Object>> resultMap = new ArrayList<Map<String,Object>>();
		resultMap = forkjoinPool.invoke(task);
		
	}
	

}
