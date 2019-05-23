package com.design_pattern_23.creation.prototype.v1;

public class ConcretePrototype2 implements Prototype {
	//最简单的克隆，新建一个自身对象，由于没有属性就不再复制值了
	public Prototype clone(){
		ConcretePrototype2 prototype = new ConcretePrototype2();
		return prototype;
	}
}
