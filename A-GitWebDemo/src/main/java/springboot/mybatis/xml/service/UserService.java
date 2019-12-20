package springboot.mybatis.xml.service;

import java.util.List;

import springboot.mybatis.xml.entity.User;

/**
 * user服务接口
 * @author B
 *
 */
public interface UserService {
	/**
	 * 查询所有用户信息
	 * @return
	 */
	List<User> findAll();
	/**
	 * 添加用户
	 * @param user
	 */
	void addUser(User user);
}
