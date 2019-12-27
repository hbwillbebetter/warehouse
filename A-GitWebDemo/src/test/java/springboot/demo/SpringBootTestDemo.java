package springboot.demo;

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
import springboot.mybatis.commonMapper.model.User3;
import springboot.mybatis.commonMapper.utils.JsonUtils;

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
		User3 user = new User3();
		user.setAge(1);
		user.setPhone("222");
		user.setPwd("000");
		String str = JsonUtils.obj2String(user);
		stringRedisTemplate.opsForValue().set("str", str);
		System.out.println(str);
	}
	
	
}
