package springboot.mybatis.xml.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import springboot.mybatis.annotation.entity.Demo;
import springboot.mybatis.xml.entity.User;

/**
 * User表mapper接口
 * @author B
 *
 */
@Mapper//  该注解一定要加，否则无法映射到mybatis的***.xml(src/main/resources/mapper/*.xml)局部配置文件
public interface UserMapper {
	
	List<User> findAll();
	
	void addUser(User user);
}
