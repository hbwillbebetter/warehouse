package com.db.connect_poll;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.junit.Test;

public class DataSourceTest {
    
    @Test
    public void c3p0DataSourceTest_query() {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            //获取数据库连接
            conn = JdbcUtils_C3P0.getConnection();
            System.out.println(conn.toString());
            String sql = "select * from zgy_htmlcontent where SuccessId=? limit 1";
            st = conn.prepareStatement(sql);
            st.setString(1, "d6e1653b-add4-416d-b324-aa8401181633");
            rs = st.executeQuery();
            if(rs.next()){
            	String rq = rs.getDate("PostDate")+"";
            	if ("null".equals(rq)) {
					System.out.println("yes");
					return;
				}else {
					//获取日期
					rq = rq.replaceAll("-", "").replaceAll("/", "");
				}
            	//日期比较
                System.out.println(rq);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            //释放资源
            JdbcUtils_C3P0.release(conn, st, rs);
        }
    }
    @Test
    public void c3p0DataSourceTest_insert() {
    	Connection conn = null;
    	PreparedStatement st = null;
    	ResultSet rs = null;
    	try{
    		//获取数据库连接
    		conn = JdbcUtils_C3P0.getConnection();
    		String sql = "insert into test1(name) values(?)";
    		st = conn.prepareStatement(sql);
    		st.setString(1, "gacl");
    		st.executeUpdate();
    		//获取数据库自动生成的主键
    		rs = st.getGeneratedKeys();
    		if(rs.next()){
    			System.out.println(rs.getInt(1));
    		}
    	}catch (Exception e) {
    		e.printStackTrace();
    	}finally{
    		//释放资源
    		JdbcUtils_C3P0.release(conn, st, rs);
    	}
    }
}