package com.thread.threadLocal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.catalina.Session;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * 应用场景：最常见的ThreadLocal使用场景为 用来解决 数据库连接、Session管理等。
 * @author B
 *
 */
public class impl {
	//数据库连接
	private static final DruidDataSource dataSource;
	static{
		dataSource = new DruidDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/bigdata");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
	}
	private static ThreadLocal<Connection> connectionHolder = new ThreadLocal<Connection>(){
		@Override
		protected Connection initialValue() {
			System.out.println("调用1111111111");
			try {
//				return DriverManager.getConnection("db_url");
				return dataSource.getConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
	};
	public static Connection getConnection(){
		return connectionHolder.get();
	}
	
	//session管理
	/*private static final ThreadLocal threadSession = new ThreadLocal<>();
	
	public static Session getSession() throws InfrastructureException {
	    Session s = (Session) threadSession.get();
	    try {
	        if (s == null) {
	            s = getSessionFactory().openSession();
	            threadSession.set(s);
	        }
	    } catch (HibernateException ex) {
	        throw new InfrastructureException(ex);
	    }
	    return s;
	}*/
	
	
	
	
	public static void main(String[] args) {
		final impl im = new impl();
		Connection connection = im.getConnection();
		System.out.println(connection);
		System.out.println("************************");
		Connection connection2 = im.getConnection();
		System.out.println(connection2);
		System.out.println("************************");
		Connection connection3 = im.getConnection();
		System.out.println(connection3);
		
		
	}
	

}
