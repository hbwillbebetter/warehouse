package springboot.mybatis.commonMapper.web.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springboot.mybatis.commonMapper.config.WeChatConfig;
import springboot.mybatis.commonMapper.model.JsonData;

@RestController
@RequestMapping("/api/v1/wechat")
public class TestWeChatController {
	
	@Autowired
	private WeChatConfig weChatConfig;
	
	@RequestMapping("test_config")
	public JsonData testConfig(){
		System.out.println(weChatConfig.getAppId());
		return JsonData.buildSuccess(weChatConfig.getAppId());
	}
	
	/**
	 * 拼装扫一扫登录url
	 * @throws UnsupportedEncodingException 
	 */
	@GetMapping("login_url")
	public JsonData loginUrl(@RequestParam(value = "access_page",required = true) String accessPage) throws UnsupportedEncodingException{
		String redirectUrl = weChatConfig.getOpenRedirectUrl();//获取开放平台重定向地址
		String callbackUrl = URLEncoder.encode(redirectUrl,"GBK");//进行编码
		String qrcodeUrl = String.format(weChatConfig.getOpenQrcodeUrl(), weChatConfig.getOpenAppid(),callbackUrl,accessPage);
		
		return JsonData.buildSuccess(qrcodeUrl);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
