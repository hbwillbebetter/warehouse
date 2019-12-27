package springboot.mybatis.commonMapper.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;

import springboot.mybatis.commonMapper.dao.UserMapper;
import springboot.mybatis.commonMapper.model.User;
import springboot.mybatis.commonMapper.service.UserService;
import utils.PageBean;

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

	@Override
	public List<User> findItemByPage(int currentPage,int pageSize) {
        //设置分页信息，分别是当前页数和每页显示的总记录数【记住：必须在mapper接口中的方法执行之前设置该分页信息】
        PageHelper.startPage(currentPage, pageSize);
        
        List<User> allItems = userMapper.selectAll();        //全部商品
        int countNums = allItems.size();           //总记录数
        PageBean<User> pageData = new PageBean<>(currentPage, pageSize, countNums);
        pageData.setItems(allItems);
        return pageData.getItems();
    }

	@Override
	/*
	 * https://www.cnblogs.com/wangjunwei/p/11425485.html
	 * 支持当前事务，如果当前没有事务，就新建一个事务,最常见的选择。(non-Javadoc)
	 * @see springboot.mybatis.commonMapper.service.UserService#addAccount()
	 */
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
	public int addAccount() {
		User user = new User();
		user.setAge(88L);
		user.setName("测试事务啦");
		userMapper.insert(user);
		int i=19/0;//异常的代码
		return 0;
	}

	

}
