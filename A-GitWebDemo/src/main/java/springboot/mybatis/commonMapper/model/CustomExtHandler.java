package springboot.mybatis.commonMapper.model;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.druid.support.logging.Log;

@RestControllerAdvice //异常处理指定类	@RestControllerAdvice=@ControllerAdvice+@ResponseBody
//@ControllerAdvice
public class CustomExtHandler {

	private static final Logger Log = LoggerFactory.getLogger(CustomExtHandler.class);
	
//	//捕获全局异常，处理所有不可告知的异常
//	@ExceptionHandler(value=Exception.class)
////	@ResponseBody
//	Object handleException(Exception e,HttpServletRequest request){
//		Log.error("url {}, msg{}",request.getRequestURL(),e.getMessage());
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("code", 100);
//		map.put("msg", e.getMessage());
//		map.put("url", request.getRequestURL());
//		return map;
//	}
	
	//处理自定义异常
	@ExceptionHandler(value=MyException.class)
	Object handleException(MyException e,HttpServletRequest request){
//		//进行页面跳转
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.setViewName("error");//返回的前台自定义异常界面
//		modelAndView.addObject("msg", e.getMsg());
//		return modelAndView;
		
		//返回json数据，由前端去判断加载什么页面
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", e.getCode());
		map.put("msg", e.getMsg());
		map.put("url", request.getRequestURL());
		return map;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
