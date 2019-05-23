package com.design_pattern_23.creation.prototype.v2;

import java.util.HashMap;
import java.util.Map;

public class PrototypeManager {
	
	//用来记录原型的编号和原型实例大的对应关系
	private static Map<String, Prototype> map = new HashMap<String, Prototype>();
	
	//私有化构造方法，避免外部创建实例
	private PrototypeManager(){}
	
	/**
	 * 根据原型编号，从原型管理器中移除某个原型注册
	 * @param prototypeId
	 */
	public static synchronized void removePrototype(String prototypeId){
		map.remove(prototypeId);
	}
	/**
	 * 根据某个原型编号 对应 的原型示例
	 * @return
	 * @throws Exception 
	 */
	public static synchronized Prototype getPrototype(String prototypeId) throws Exception {
		Prototype prototype = map.get(prototypeId);
		if(prototype == null){
			throw new Exception("您希望获取的原型还没有注册或已被销毁");
		}
		
		return prototype;
	}
	
	/**
	 * 向原型管理器添加或者修改某个原型注册
	 * @param prototype
	 */
	public synchronized static void setPrototype(String prototypeId, Prototype prototype) {
		map.put(prototypeId, prototype);
	};
	
	
	
}
