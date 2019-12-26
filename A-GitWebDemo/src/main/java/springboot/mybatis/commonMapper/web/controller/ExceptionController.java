package springboot.mybatis.commonMapper.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.mybatis.commonMapper.model.MyException;
import springboot.mybatis.commonMapper.model.User2;
/**
 * https://www.cnblogs.com/wangjunwei/tag/%E5%B0%8FD%E8%AF%BE%E5%A0%82/default.html?page=5
 * 
 * https://www.cnblogs.com/wangjunwei/p/11415680.html
 * 4、SpringBoot2.x配置全局异常实战
    讲解：服务端异常讲解和SpringBoot配置全局异常实战

        1、默认异常测试  int i = 1/0，不友好
        
        2、异常注解介绍
            @ControllerAdvice 如果是返回json数据 则用 RestControllerAdvice,就可以不加 @ResponseBody
            
            //捕获全局异常,处理所有不可知的异常
            @ExceptionHandler(value=Exception.class)
 *
 */
@RestController
public class ExceptionController {

	@RequestMapping(value="/api/v1/test_ext")
	public Object index(){
		int i = 1/0;
		return new User2("zs", "123");
	}
	
	/**
	 * 功能描述：模拟自定义异常
	 */
	@RequestMapping("/api/v1/myext")
	public Object myext(){
		throw new MyException("499", "my ext异常!");
	}
	
}
