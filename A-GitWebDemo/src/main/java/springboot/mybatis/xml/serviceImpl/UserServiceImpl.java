package springboot.mybatis.xml.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.mybatis.xml.entity.User;
import springboot.mybatis.xml.mapper.UserMapper;
import springboot.mybatis.xml.service.UserService;

/**
 * user服务接口实现类
 * @author B
 *
 */
@Service//  该注解一定要写，否则无法注册bean
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;//  注入mapper
	
	@Override
	public List<User> findAll() {
		return userMapper.findAll();
	}

	@Override
	public void addUser(User user) {
		userMapper.addUser(user);
	}

}
