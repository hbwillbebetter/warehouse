package springboot.mybatis.commonMapper.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import springboot.mybatis.annotation.entity.Demo;
import springboot.mybatis.commonMapper.model.User;

/**
 * User表mapper接口
 * @author B
 *
 */
/**
 * @Mapper注解说明：
 * 注解不加，则一定需要添加启动类对mapper接口类所在包扫描，否则报错
 * 注解加了，启动类对mapper接口类所在包扫描则不是必须的。
 * 
 * 映射到mybatis的***.xml(src/main/resources/mapper/*.xml)局部配置文件）。
 *
 */
@Mapper
public interface UserMapper extends tk.mybatis.mapper.common.Mapper<User> {
	
//	List<User> findAll();
//	
//	void addUser(User user);
}
