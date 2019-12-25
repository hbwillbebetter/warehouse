package springboot.mybatis.commonMapper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

//https://www.cnblogs.com/yanfei1819/p/10876339.html
//@MapperScan(basePackages={"springboot.mybatis.commonMapper.dao"})
@SpringBootApplication	//一个注解顶下面三个(TODO 好像会报错，未解决)
//@SpringBootConfiguration
//@EnableAutoConfiguration
//@Component
@EnableAsync	//开启异步任务
@EnableScheduling //开启定时任务
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	
	//配置mybatis的分页插件pageHelper
//    @Bean
//    public PageHelper pageHelper(){
//        PageHelper pageHelper = new PageHelper();
//        Properties properties = new Properties();
//        properties.setProperty("offsetAsPageNum","true");
//        properties.setProperty("rowBoundsWithCount","true");
//        properties.setProperty("reasonable","true");
//        properties.setProperty("dialect","mysql");    //配置mysql数据库的方言
//        pageHelper.setProperties(properties);
//        return pageHelper;
//    }
	
}
