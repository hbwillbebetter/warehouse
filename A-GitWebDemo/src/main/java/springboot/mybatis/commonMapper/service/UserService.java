package springboot.mybatis.commonMapper.service;

import java.util.List;

import springboot.mybatis.commonMapper.model.User;


public interface UserService {
	
	int insertUser(User user);
	int updateUser(User user);
	int deleteUser(Long id);
	List<User> listUsers();
	User getUserById(Long id);
	//分页功能
	List<User> findItemByPage(int currentPage,int pageSize);
}
