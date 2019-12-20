package springboot.mybatis.commonMapper;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//https://www.cnblogs.com/yanfei1819/p/10876339.html
//@MapperScan("springboot.mybatis.commonMapper.mapper")
@SpringBootApplication
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
