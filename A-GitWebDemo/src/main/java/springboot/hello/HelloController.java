package springboot.hello;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Service
@RestController
public class HelloController {
	@RequestMapping("/")
	public String hello(){
		return "Greetings from Spring Boot!";
	}

}
