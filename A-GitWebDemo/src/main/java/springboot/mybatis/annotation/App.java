package springboot.mybatis.annotation;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@EnableAutoConfiguration(exclude={RedisAutoConfiguration.class})
@SpringBootApplication
@MapperScan("springboot.mybatis.annotation.mapper")
//@MapperScan("springboot.mybatis.*.mapper")//通配符包
//@MapperScan({"springboot.mybatis.demo1","springboot.mybatis.demo2"})//扫描多个包
//@MapperScan({"a.*.mapper","b.*.mapper"})//如果mapper类没有在Spring Boot主程序可以扫描的包或者子包下面,可以这样配置
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
