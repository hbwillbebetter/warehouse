package com.robin.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;


public class VisitMySql {
	
	public static void main(String[] args){
        
        //实例化对象
        VisitMySql vs = new VisitMySql();
       //调用查询方法
        vs.Select();
    }

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
            String Sql = "select params from BOS_TaskInfo where taskId = 2961";
            // 执行sql语句
            stt = conn.createStatement();
            // 返回结果集
            set = stt.executeQuery(Sql);
            // 获取数据
            while (set.next()) {

            	String paramsStr = set.getString(1);
            	System.out.println(paramsStr);
            	Map<String, Object> rdMap = parseRD(paramsStr);
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
    //解析实时任务type=RD
    private static Map<String, Object> parseRD(String params) {
		Map<String, Object> map = new HashMap<String, Object>();
		Set<String> personSet = new HashSet<String>();
		List<Map<String, Object>> companyBaseListMaps = new ArrayList<Map<String,Object>>();
		List<Map<String, Object>> personBaseListMaps = new ArrayList<Map<String,Object>>();
		try {
			JSONObject paramsJsonObject = JSONObject.parseObject(params);
			if (paramsJsonObject != null) {
				String type = paramsJsonObject.getString("type");
				String isSmall = paramsJsonObject.getString("isSmall");
				//解析master
				JSONArray master = paramsJsonObject.getJSONArray("master");
				if(master.size()>0){
				  for(int i=0;i<master.size();i++){
				    JSONObject job = master.getJSONObject(i);  // 遍历 jsonarray 数组，把每一个对象转成 json 对象
				    // 得到 每个对象中的属性值
				    String name = (String) job.get("name");
				    String certno = (String) job.get("certno");
				    if (StringUtils.isNotBlank(name) && StringUtils.isNotBlank(certno)) {
				    	personSet.add(name.trim()+"\001"+certno.trim());//TODO
					}
				  }
				}
				//解析company
				JSONArray company = paramsJsonObject.getJSONArray("latitude");
				if(company.size()>0){
				  for(int i=0;i<company.size();i++){
					Map<String, Object> cmap = new HashMap<String, Object>();
				    JSONObject job = company.getJSONObject(i);  // 遍历 jsonarray 数组，把每一个对象转成 json 对象
				    // 得到 每个对象中的属性值
				    String key = (String) job.get("key");
				    String isAll = (String) job.get("isAll");
				    String startTime = (String) job.get("startTime");
				    String endTime = (String) job.get("endTime");
				    if (StringUtils.isNotBlank(key) && StringUtils.isNotBlank(isAll)) {
				    	cmap.put("key", key);
				    	cmap.put("isAll", isAll);
				    	if ("1".equals(isAll)) {//历史数据
				    		cmap.put("startTime", "19700101");
							cmap.put("endTime", "20190917");//注意，当前业务日期减一天
						}else {
							cmap.put("startTime", startTime);
							cmap.put("endTime", endTime);
						}
					}
				    companyBaseListMaps.add(cmap);
				  }
				}
				//解析person
				JSONArray person = paramsJsonObject.getJSONArray("personal");
				if(person.size()>0){
					for(int i=0;i<person.size();i++){
						Map<String, Object> pmap = new HashMap<String, Object>();
						JSONObject job = person.getJSONObject(i);  // 遍历 jsonarray 数组，把每一个对象转成 json 对象
						// 得到 每个对象中的属性值
						String key = (String) job.get("key");
						String isAll = (String) job.get("isAll");
						String startTime = (String) job.get("startTime");
						String endTime = (String) job.get("endTime");
						if (StringUtils.isNotBlank(key) && StringUtils.isNotBlank(isAll)) {
							pmap.put("key", key);
							pmap.put("isAll", isAll);
							if ("1".equals(isAll)) {//历史数据
								pmap.put("startTime", "19700101");
								pmap.put("endTime", "20190917");//注意，当前业务日期减一天
							}else {
								pmap.put("startTime", startTime);
								pmap.put("endTime", endTime);
							}
						}
						personBaseListMaps.add(pmap);
					}
				}
				map.put("type", type);//请求类型
				map.put("isSmall", isSmall);//大小企业（0:大企业--只要企业数据，1:小企业--企业数据和个人数据都要）
				map.put("personMd", personSet);//个人名单
				map.put("companyWd", companyBaseListMaps);//企业维度信息
				map.put("personWd", personBaseListMaps);//个人维度信息
			}else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}
		return map;
	}

}