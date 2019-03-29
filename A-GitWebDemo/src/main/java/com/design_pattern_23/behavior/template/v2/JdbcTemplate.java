package com.design_pattern_23.behavior.template.v2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * 本质上来说，模板方法设计模式是一个比较容易而且很好理解的模式，在使用这种模式的时候我们要注意几点：

1. 保护抽象类中定义算法顺序的方法不被子类修改。

2. 分离可变及不可变部分，让子类自己决定可变部分的实现。

3. 让算法的具体实现对子类开放，对其他类关闭。
 * @author B
 *
 */

public abstract class JdbcTemplate {

	/**
	 * @Autowired 注释，它可以对类成员变量、方法及构造函数进行标注，完成自动装配的工作。 
	 * 通过 @Autowired的使用来消除 set ，get方法。
	 * 在使用@Autowired之前，我们对一个bean配置起属性时，是这用用的
		<property name="属性名" value=" 属性值"/>    
		通过这种方式来，配置比较繁琐，而且代码比较多。在Spring 2.5 引入了 @Autowired 注释
	 */
//	@Autowired
//	private DataSource dataSource;
	private static DruidDataSource dataSource;
	private Connection connection;
	protected PreparedStatement statement;
	protected ResultSet resultSet;
	
	static{
		dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/bigdata");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
	}
	public final void dbOperation(String sql, Object entity) throws SQLException{
		getStatement(sql);
		curd(entity);//可变部分
		releaseResources();
	}
	protected abstract void curd(Object entity) throws SQLException;
	
	private void getStatement(String sql) throws SQLException {
		
		connection = dataSource.getConnection();
		this.statement = connection.prepareStatement(sql);
	}

	private void releaseResources() throws SQLException {
		if(resultSet != null)
			resultSet.close();
		if(statement != null)
			statement.close();
		if(connection != null)
			connection.close();
	}
}
