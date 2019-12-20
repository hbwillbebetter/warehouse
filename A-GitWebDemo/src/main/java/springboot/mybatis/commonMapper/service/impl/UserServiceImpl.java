package springboot.mybatis.commonMapper.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.mybatis.commonMapper.dao.UserMapper;
import springboot.mybatis.commonMapper.model.User;
import springboot.mybatis.commonMapper.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
    private UserMapper userMapper;

	@Override
	public int insertUser(User user) {
		return userMapper.insert(user);
	}

	@Override
	public int updateUser(User user) {
		return userMapper.updateByPrimaryKey(user);
	}
	
	@Override
	public int deleteUser(Long id) {
		return userMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<User> listUsers() {
		return userMapper.selectAll();
	}

	@Override
	public User getUserById(Long id) {
		return userMapper.selectByPrimaryKey(id);
	}

	

}
