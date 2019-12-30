package net.xdclass.xdvideo.controller;

import net.xdclass.xdvideo.config.WeChatConfig;
import net.xdclass.xdvideo.mapper.VideoMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@Autowired
	private WeChatConfig weChatConfig;
	
	@RequestMapping("test_config")
	public String testConfig(){
		System.out.println(weChatConfig.getAppId());
		return "hello xdclass.net";
	}
	
	@Autowired
	private VideoMapper videoMapper;
	
	@RequestMapping("test_db")
	public Object testDB(){
		return videoMapper.findAll();
	}
	
}
