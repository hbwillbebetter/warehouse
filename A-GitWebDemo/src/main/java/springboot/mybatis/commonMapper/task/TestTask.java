package springboot.mybatis.commonMapper.task;

import java.util.Date;
import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
//https://www.cnblogs.com/wangjunwei/p/11426757.html
@Component
public class TestTask {

//	@Scheduled(fixedRate=2000) //两秒执行一次
//	@Scheduled(cron="*/1 * * * * *") //每秒执行一次
//	@Scheduled(fixedDelay=2000) //两秒执行一次
	@Scheduled(fixedRateString="2000") //字符串形式	两秒执行一次
	public void task1() throws InterruptedException{
		Thread.sleep(4000L);
		System.out.println("当前时间:"+new Date());
	}
	
	
	
	
	
	
	
}
