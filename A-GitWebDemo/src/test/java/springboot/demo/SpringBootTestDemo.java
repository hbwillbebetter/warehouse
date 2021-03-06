package springboot.demo;

import io.jsonwebtoken.Claims;
import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import springboot.mybatis.commonMapper.App;
import springboot.mybatis.commonMapper.model.User;
import springboot.mybatis.commonMapper.model.User3;
import springboot.mybatis.commonMapper.utils.JsonUtils;
import utils.JwtUtils;

//SpringRunner是继承了SpringJUnit4ClassRunner，这是springboot里面推荐的方法
@RunWith(SpringRunner.class)	//底层用junit SpringJUnit4ClassRunner

//@SpringBootTest指定这是个Spring boot的应用.这里配置的是SpringBoot的启动文件。指定main函数的入口
@SpringBootTest(classes=App.class) //启动整个springboot工程
public class SpringBootTestDemo {

	@Test
	public void testOne(){
		System.out.println("test hello 1");
		TestCase.assertEquals(1, 1);
//		Assert.assertEquals(1, 1); //废弃的方法
	}
	
	@Test
	public void testTwo(){
		System.out.println("test hello 2");
		TestCase.assertEquals(1, 1);
//		Assert.assertEquals(1, 1); //废弃的方法
	}
	
	@Before
	public void testBefore(){
		System.out.println("before");
	}
	
	@After	//一般用于资源的回收利用。
	public void testAfter(){
		System.out.println("after");
	}
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	@Test
	public void test_redis(){
		/*
		 * eyJhbGciOiJIUzI1NiJ9.
		 * eyJzdWIiOiJ4ZGNsYXNzIiwiaWQiOjk5OSwibmFtZSI6Ind3dy54ZGNsYXNzLm5ldCIsImFnZSI6MTAwLCJpYXQiOjE1Nzc0MzU5MTYsImV4cCI6MTU3ODA0MDcxNn0.
		 * PTLXQgLQVcZt7kDerOvv_Jm2rf0oxHzLPSlDLYe9FJs
		 */
		User3 user = new User3();
		user.setAge(1);
		user.setPhone("222");
		user.setPwd("000");
		String str = JsonUtils.obj2String(user);
		stringRedisTemplate.opsForValue().set("str", str);
		System.out.println(str);
	}
	
	@Test
	public void test_GeneJwt(){
		User user = new User();
		user.setId(999L);
		user.setName("www.xdclass.net");
		user.setAge(100L);
		String token = JwtUtils.geneJsonWebToken(user);
		System.out.println(token);
		
	}
	@Test
	public void test_CheckToken(){
		String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ4ZGNsYXNzIiwiaWQiOjk5OSwibmFtZSI6Ind3dy54ZGNsYXNzLm5ldCIsImFnZSI6MTAwLCJpYXQiOjE1Nzc0MzU5MTYsImV4cCI6MTU3ODA0MDcxNn0.PTLXQgLQVcZt7kDerOvv_Jm2rf0oxHzLPSlDLYe9FJs";
		Claims claims = JwtUtils.checkJWT(token);
		if (claims != null) {
			int id = (int) claims.get("id");
			String name = (String) claims.get("name");
			int age = (int) claims.get("age");
			System.out.println(id);
			System.out.println(name);
			System.out.println(age);
		}else {
			System.out.println("非法token");
		}
		
	}
	
	
}
