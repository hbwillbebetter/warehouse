package springboot.mybatis.xml.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.mybatis.annotation.entity.Demo;
import springboot.mybatis.annotation.mapper.DemoMapper;
import springboot.mybatis.xml.entity.User;
import springboot.mybatis.xml.service.UserService;

/**
 * user控制器
 * @author B
 *
 */
@RestController//  此注解指明该控制器直接返回数据，而不进行页面跳转
@RequestMapping("/user")//定义路由信息
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/findAll")//则次路由信息应该是/user/findAll
	public List<User> findAll(){
		return userService.findAll();
	}
	
	@RequestMapping("/addUser")//则次路由信息应该是/user/findAll
	public String addUser(){
		User user = new User();
		user.setName("张三丰");
		user.setAge(20);
		userService.addUser(user);
		return user.toString();
	}
	
}
