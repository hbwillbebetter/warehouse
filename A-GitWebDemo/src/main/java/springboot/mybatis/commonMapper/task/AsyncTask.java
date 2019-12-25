package springboot.mybatis.commonMapper.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@Async	//标记为异步类
public class AsyncTask {

//	@Async
	public void task1() throws InterruptedException{
		long begin = System.currentTimeMillis();
		Thread.sleep(1000L);
		long end = System.currentTimeMillis();
		System.out.println("任务1耗时="+(end-begin));
	}
	
//	@Async
	public void task2() throws InterruptedException{
		long begin = System.currentTimeMillis();
		Thread.sleep(2000L);
		long end = System.currentTimeMillis();
		System.out.println("任务2耗时="+(end-begin));
	}
	
//	@Async
	public void task3() throws InterruptedException{
		long begin = System.currentTimeMillis();
		Thread.sleep(3000L);
		long end = System.currentTimeMillis();
		System.out.println("任务3耗时="+(end-begin));
	}
}
