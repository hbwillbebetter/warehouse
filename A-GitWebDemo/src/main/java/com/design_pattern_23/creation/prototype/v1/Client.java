package com.design_pattern_23.creation.prototype.v1;

/**
 * 简单形式的原型模式--客户端测试类
 * @author B
 *
 */
public class Client {
	/**
     * 持有需要使用的原型接口对象
     */
	Prototype prototype;
	/**
     * 构造方法，传入需要使用的原型接口对象
     */
	public Client(Prototype prototype){
		this.prototype = prototype;
	}
	
	public void operation(){
		//需要创建原型接口的对象
		Prototype clonePrototype = prototype.clone();
		System.out.println("原型对象拷贝完毕:"+clonePrototype.getClass().getName());
	}
	
	public static void main(String[] args) {
		Client client = new Client(new ConcretePrototype2());
		client.operation();
	}

}
