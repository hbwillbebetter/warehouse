package com.design_pattern_23.behavior.template.v2;

import java.sql.SQLException;

/**
 * 以上是一个典型的JDBC实现，我们先来看看使用JDBC操作数据库需要经过哪些步骤：

	1. 获取数据库连接
	
	2. 通过数据库连接得到Statement对象
	
	3. 使用Statement对象进行增删改查
	
	4. 处理异常
	
	5. 关闭连接释放资源
	
	
	我们再来区分一下这些步骤中，哪些是可变部分，哪些是不可变部分：
	
	1. 获取数据库连接（不可变）
	
	2. 通过数据库连接得到Statement对象（不可变）
	
	3. 使用Statement对象进行增删改查（可变）
	
	4. 处理异常（不可变）
	
	5. 关闭连接释放资源（不可变）
	
	我们可以看到，在5个步骤中，4个是不可变的，只有一个步骤是可变的，让我对代码加一些图形注释，这样就更直观了：
 * @author B
 *
 */
public class InsertCurdMain extends JdbcTemplate {
	

	public void insertEntity(Student student) throws Exception {
        /*final String SQL = "insert into student (id,studentNumber,firstName,lastName,gender,age,className,major) values (?,?,?,?,?,?,?,?)";*/
        final String SQL = "insert into student (id) values (?)";
        this.dbOperation(SQL, student);
    }
	
	@Override
	protected void curd(Object entity) throws SQLException{
		Student student = (Student) entity;
        statement.setInt(1, student.getId());
        /*statement.setString(2, student.getStudentNumber());
        statement.setString(3, student.getFirstName());
        statement.setString(4, student.getLastName());
        statement.setString(5, student.getGender());
        statement.setInt(6, student.getAge());
        statement.setString(7, student.getClassName());
        statement.setString(8, student.getMajor());*/
        statement.execute();
	}
	
}
