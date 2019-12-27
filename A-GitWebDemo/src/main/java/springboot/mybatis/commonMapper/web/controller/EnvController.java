package springboot.mybatis.commonMapper.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.mybatis.commonMapper.model.JsonData;

@RestController
@RequestMapping("/api/v1")
public class EnvController {
	private Logger logger = LoggerFactory.getLogger(this.getClass()); 

	@Value("${env}")
	private String envInfo;//注入环境信息
	
	/**
	 * 功能描述：获取当前所选环境信息
	 */
	@GetMapping("env")
	public Object env(){
		logger.info("环境信息:"+envInfo);
		return JsonData.buildSuccess(envInfo);
	}
}
