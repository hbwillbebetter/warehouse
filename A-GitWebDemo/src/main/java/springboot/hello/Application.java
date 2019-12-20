package springboot.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//如果没有配置数据源（jdbc、redis）可以除外
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class,RedisAutoConfiguration.class})
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		//http://localhost:8080
		SpringApplication.run(Application.class, args);
	}
}
