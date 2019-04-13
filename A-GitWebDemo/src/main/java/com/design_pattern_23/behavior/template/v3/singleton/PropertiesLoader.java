package com.design_pattern_23.behavior.template.v3.singleton;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class PropertiesLoader {
	private Properties properties;
	//比尔.普夫单例
	// 私有构造函数，避免被客户端代码使用
	private PropertiesLoader() {
		properties = new Properties();
		try {
			InputStream in = PropertiesLoader.class.getClassLoader().getResourceAsStream("zmn/executePPT_zs.properties");
        	InputStreamReader is = new InputStreamReader(in, "UTF-8");
        	properties.load(is);///加载属性列表
            in.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	private static class LazyBillPugh {
		private static final PropertiesLoader instance = new PropertiesLoader();
		
	}
	public static PropertiesLoader getInstance(){
		return LazyBillPugh.instance;
	}
	
	public String getOneProp(String key){
		return properties.getProperty(key);
	}
}
