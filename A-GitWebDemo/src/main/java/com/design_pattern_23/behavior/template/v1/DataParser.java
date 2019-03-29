package com.design_pattern_23.behavior.template.v1;

/**
 * 本质上来说，模板方法设计模式是一个比较容易而且很好理解的模式，在使用这种模式的时候我们要注意几点：

1. 保护抽象类中定义算法顺序的方法不被子类修改。

2. 分离可变及不可变部分，让子类自己决定可变部分的实现。

3. 让算法的具体实现对子类开放，对其他类关闭。
 * @author B
 *
 */
public abstract class DataParser {

	public final void process(){
		readData();
		processData();
		writeData();
	}
	
	//implemented by subclass
	protected abstract void readData();
	protected abstract void processData();

	// same for all subclass
	private void writeData() {
		System.out.println("data writing csv...");
	}
	
}
