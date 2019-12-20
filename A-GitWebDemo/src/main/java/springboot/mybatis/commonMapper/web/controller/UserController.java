package springboot.mybatis.commonMapper.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.mybatis.commonMapper.model.User;
import springboot.mybatis.commonMapper.service.UserService;

/***
 * @PathVariable是spring3.0的一个新功能：接收请求路径中占位符的值
 * @PathVariable("xxx")
 * 通过 @PathVariable 可以将URL中占位符参数{xxx}绑定到处理器类的方法形参中@PathVariable(“xxx“)
 * 
 * 如：请求路径：http://localhost:8080/hello/show5/1/james
 * @RequestMapping("/{id}/{name}")
 *	public ModelAndView test5(@PathVariable("id") Long ids ,@PathVariable("name") String names)
 */
@RestController
public class UserController {

	@Autowired
	private UserService service;
	
	@RequestMapping("/listUsers")
	public List<User> listUser(){
		return service.listUsers();
	}
	@RequestMapping("/getUserById/{id}")
	public User getUserById(@PathVariable Long id){
		return service.getUserById(id);
	}
	
	@PostMapping("/insertUser")
    public int insertUser(User user){
        return service.insertUser(user);
    }
    @PostMapping("/updateUser/{id}/{name}")
    public int updateUser(@PathVariable("id") Long id,@PathVariable("name") String name){
    	User user = new User();
    	user.setId(id);
    	user.setName(name);
    	user.setAge(100L);//默认设置
        return service.updateUser(user);
    }
    @GetMapping("/deleteUser/{id}")
    public int deleteUser(@PathVariable Long id){
        return service.deleteUser(id);
    }
	
}
