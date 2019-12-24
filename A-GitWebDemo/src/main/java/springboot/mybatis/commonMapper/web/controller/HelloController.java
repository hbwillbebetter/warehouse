package springboot.mybatis.commonMapper.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

	@RequestMapping("/hello")
	public String hello(HttpServletRequest request, 
			@RequestParam(value="name", required=false, defaultValue="springboot-thymeleaf") String name){
		request.setAttribute("name", name);
		return "hello";
	}
}
