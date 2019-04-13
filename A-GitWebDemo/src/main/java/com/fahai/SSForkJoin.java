package com.fahai;

import java.io.File;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.atomic.AtomicInteger;

public class SSForkJoin extends RecursiveTask<List<Map<String,Object>>> {
	private List<String> datas;
	private AtomicInteger atomicInteger;

	public SSForkJoin(List<String> datas, AtomicInteger atomicInteger) {
		this.datas = datas;
		this.atomicInteger = atomicInteger;
	}
	
	@Override
    protected List<Map<String,Object>> compute() {
    	//设置块大小
    	
        //如果任务足够小就计算任务
        boolean canCompute = datas.size() <= 1;
        if (canCompute) {
        	List<Map<String,Object>> lm = new ArrayList<Map<String,Object>>();
        	Map<String,Object> resultMap = new HashMap<>();
            List<String> yichangCompanys = ssRun(datas);//业务逻辑
            resultMap.put("nameList", yichangCompanys);
            resultMap.put("dataSize", datas.size());
            lm.add(resultMap);
            return lm;
        } else {
            // 如果任务大于阈值，就分裂成两个子任务计算
            long middle = datas.size() / 2;
            List<String> leftList = new ArrayList<>();
            List<String> rightList = new ArrayList<>();

            long i = 0;
            for (String data : datas) {
                if (i < middle) {
                    leftList.add(data);
                } else {
                    rightList.add(data);
                }
                i++;
            }

            SSForkJoin leftTask = new SSForkJoin(leftList, atomicInteger);
            SSForkJoin rightTask = new SSForkJoin(rightList, atomicInteger);

            // 执行子任务
            invokeAll(leftTask,rightTask);

            List<Map<String,Object>> lm = new ArrayList<Map<String,Object>>();

            List<Map<String,Object>> leftResult = leftTask.join();
            List<Map<String,Object>> rightResult = rightTask.join();
            lm.addAll(leftResult);
            lm.addAll(rightResult);
            return lm;
        }
    }

	private List<String> ssRun(List<String> lists) {
		final List<String> exceptionCompanys = new ArrayList<String>();
		for(String value : lists){
			
			System.out.println(URLDecoder.decode(value));
			
		}
  			
  		return exceptionCompanys;
	}
	
	
}
