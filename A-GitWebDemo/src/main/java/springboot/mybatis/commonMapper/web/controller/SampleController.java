package springboot.mybatis.commonMapper.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

	@RequestMapping("/test/home")
	public String home(){
		return "xdclass";
	}
}
