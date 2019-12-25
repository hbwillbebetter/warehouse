package springboot.mybatis.commonMapper.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.mybatis.commonMapper.model.JsonData;
import springboot.mybatis.commonMapper.task.AsyncTask;

@RestController
@RequestMapping("/api/async")
public class AsyncTaskController {

	@Autowired
	private AsyncTask task;
	
	@GetMapping("/task")
	public JsonData exeTask() throws InterruptedException{
		long begin = System.currentTimeMillis();
		task.task1();
		task.task2();
		task.task3();
		long end = System.currentTimeMillis();
		long total = end-begin;
		System.out.println("执行总耗时="+total);
		return JsonData.buildSuccess(total);
		
	}
}
