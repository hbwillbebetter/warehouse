package com.design_pattern_23.behavior.template.v3.utils;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Maps;

public class PropertyUtils {
	
	/**
	 * @param fileName	相对路径 ./zmn/dev/xxx.properties
	 * @return 
	 */
	public static Map<String, String> readProp2Map(String fileName) {
		Map<String, String> proMap = Maps.newHashMap();
        Properties props = new Properties();
        try {
            InputStream in = PropertyUtils.class.getClassLoader().getResourceAsStream(fileName);
            InputStreamReader isr = new InputStreamReader(in, "UTF-8");
            props.load(isr);
            Enumeration en = props.propertyNames();
            while (en.hasMoreElements()) {
                String key = (String) en.nextElement();
                String value = props.getProperty(key);
                proMap.put(key, value.trim());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return proMap;
    }
	/**
	 * 
	 * @param fileName
	 * @param prefixString 以xxx前缀开头，如:c-shixin=partyTitle,partyType
	 * @return {shixin=partyTitle,partyType}
	 */
	public static Map<String, String> readProp2Map(String fileName, String prefixString) {
		Map<String, String> proMap = Maps.newHashMap();
		Properties props = new Properties();
		try {
			InputStream in = PropertyUtils.class.getClassLoader().getResourceAsStream(fileName);
        	InputStreamReader isr = new InputStreamReader(in, "UTF-8");
			props.load(isr);
			Enumeration en = props.propertyNames();
			while (en.hasMoreElements()) {
				String key = (String) en.nextElement();
				if(key != null && key.startsWith(prefixString)){
					String value = props.getProperty(key);
					//注意，key处理了
					proMap.put(key.replaceFirst(prefixString, ""), value.trim());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return proMap;
	}
	/**
	 * input : shixin=partyTitle,partyType
	 * @param fileName
	 * @return {shixin=[partyTitle,partyType]}
	 */
	public static Map<String, String[]> readProp2MapArray(String fileName) {
		Map<String, String[]> proMap = Maps.newHashMap();
		Properties props = new Properties();
		try {
			InputStream in = PropertyUtils.class.getClassLoader().getResourceAsStream(fileName);
			InputStreamReader isr = new InputStreamReader(in, "UTF-8");
			props.load(isr);
			Enumeration en = props.propertyNames();
			while (en.hasMoreElements()) {
				String key = (String) en.nextElement();
				if(key != null){
					String value = props.getProperty(key).trim();
					String[] vArray = value.split(",");
					proMap.put(key, vArray);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return proMap;
	}
	
	public static Properties readProp(String fileName) {
		Properties props = new Properties();
		try {
			InputStream in = PropertyUtils.class.getClassLoader().getResourceAsStream(fileName);
			InputStreamReader isr = new InputStreamReader(in, "UTF-8");
			props.load(isr);
			Enumeration en = props.propertyNames();
			while (en.hasMoreElements()) {
				String key = (String) en.nextElement();
				String value = props.getProperty(key).trim();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return props;
	}
	
	/**
	 * @param properties
	 */
	public static List<Object> showKeys(Properties properties) {
		List<Object> ls = new ArrayList<>();
		Enumeration<?> enu = properties.propertyNames();
		while (enu.hasMoreElements()) {
			Object key = enu.nextElement();
			ls.add(key);
			System.out.println(key);
		}
		return ls;
	}
 
	/**
	 * @param properties
	 */
	public static List<Object> showValues(String confName) {
		Properties properties = PropertyUtils.readProp(confName);
		System.out.println("#################################"+confName+"#####################################");
		List<Object> ls = new ArrayList<>();
		Enumeration<Object> enu = properties.elements();
		while (enu.hasMoreElements()) {
			Object value = enu.nextElement();
			ls.add(value);
//			System.out.println(value);
		}
		return ls;
	}
 
	/**
	 * @param properties
	 */
	public static void showKeysAndValues(Properties properties) {
		Iterator<Entry<Object, Object>> it = properties.entrySet().iterator();
		while (it.hasNext()) {
			Entry<Object, Object> entry = it.next();
			Object key = entry.getKey();
			Object value = entry.getValue();
			System.out.println("key   :" + key);
			System.out.println("value :" + value);
			System.out.println("---------------");
		}
	} 
	
	
	
}
