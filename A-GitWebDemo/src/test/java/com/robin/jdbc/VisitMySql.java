package com.robin.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;


public class VisitMySql {

    // 连接对象
    private Connection conn;
    // 传递sql语句
    private Statement stt;
    // 结果集
    private ResultSet set;

    // 查询
    public void Select() {
        try {
            // 获取连接
            conn = DBHerpel.getConnection();
            if (conn == null)
                return;
            // 定义sql语句
            String Sql = "select params from BOS_TaskInfo_zs where taskId = 25733";
            // 执行sql语句
            stt = conn.createStatement();
            // 返回结果集
            set = stt.executeQuery(Sql);
            // 获取数据
            while (set.next()) {

//                System.out.println("用户名:" + set.getString(1) + "\t密码:"
//                        + set.getString(2));
            	String paramsStr = set.getString(1);
            	System.out.println(paramsStr);
//            	paramsStr = null;
//            	paramsStr = " ";
            	Map<String,Object> updataMap = new HashMap<String, Object>();
				JSONObject jsonObject = JSONObject.parseObject(paramsStr);
				if (jsonObject != null) {
					String type = jsonObject.getString("type");
					String tables = jsonObject.getString("tables");
					updataMap.put("taskId", 25733+"");
					updataMap.put("type", type);
					updataMap.put("tables", tables);
				}else {
					//按照正常原有的夜间跑批
					System.out.println(jsonObject);
				}
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            // 释放资源
            try {
                set.close();
                conn.close();
            } catch (Exception e2) {
                // TODO: handle exception
            }

        }
    }

}