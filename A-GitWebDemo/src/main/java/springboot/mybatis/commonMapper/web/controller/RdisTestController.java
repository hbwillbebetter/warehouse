package springboot.mybatis.commonMapper.web.controller;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.mybatis.commonMapper.model.JsonData;
import springboot.mybatis.commonMapper.model.User3;
import springboot.mybatis.commonMapper.utils.JsonUtils;
import springboot.mybatis.commonMapper.utils.RedisClient;

//springboot整合redis	https://www.cnblogs.com/qdhxhz/p/9054071.html
@RestController
@RequestMapping("/api/v1/redis")
public class RdisTestController {

    
    //得到redis封装类
    @Autowired
    private RedisClient redis;
    
    //添加字符串
    @GetMapping(value="add")
    public Object add(){
         
        redis.set("username", "xddddddd");
        return JsonData.buildSuccess();
        
    }
    
    //通过key值得到value字符串
    @GetMapping(value="get")
    public Object get(){
        
        String value = redis.get("username");
        return JsonData.buildSuccess(value);
        
    }
    
    //将对象通过工具类转成String类型，存入redis中
    @GetMapping(value="save_user")
    public Object saveUser(){
    	User3 user = new User3(1, "abc", "11", new Date());
        String userStr = JsonUtils.obj2String(user);
        boolean flag = redis.set("base:user:11", userStr);
        return JsonData.buildSuccess(flag);
        
    }
    
    //通过key值得到value值，让后将value转为对象
    @GetMapping(value="find_user")
    public Object findUser(){

        String userStr = redis.get("base:user:11");
        User3 user = JsonUtils.string2Obj(userStr, User3.class);
        return JsonData.buildSuccess(user);
        
    }        
}