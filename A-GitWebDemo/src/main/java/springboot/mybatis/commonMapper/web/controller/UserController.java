package springboot.mybatis.commonMapper.web.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.mybatis.commonMapper.model.JsonData;
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
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserService service;
	
	@GetMapping("log")
	public Object testLog(){
		logger.debug("this is debug level");
		logger.info("this is info level");
		logger.warn("this is warn level");
		logger.error("this is error level");
		return JsonData.buildSuccess();
	}
	
	//分页插件
	/**
     * 商品分页功能(集成mybatis的分页插件pageHelper实现)
     * 
     * @param currentPage    :当前页数
     * @param pageSize        :每页显示的总记录数
     * @return
     */
    @RequestMapping("/itemsPage/{currentPage}/{pageSize}")
    public List<User> itemsPage(@PathVariable("currentPage") int currentPage,@PathVariable("pageSize") int pageSize){
        return service.findItemByPage(currentPage, pageSize);
    }
	
	@RequestMapping("/listUsers")
	public List<User> listUser(){
		return service.listUsers();
	}
	@RequestMapping("/getUserById/{id}")
	public User getUserById(@PathVariable Long id){
		return service.getUserById(id);
	}
	
	@RequestMapping("/insertUser")
    public int insertUser(){
		int count=0;
		User user = null;
		for(int i=1; i<=50; i++){
			user = new User();
			user.setName("名字:"+i);
			user.setAge((long) i);
			count += service.insertUser(user);
		}
        return count;
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
    //测试事务
    @GetMapping("/add_account")
    public Object addAccount(){
    	int id = service.addAccount();
        return JsonData.buildSuccess(id);
    }
    
	
}
