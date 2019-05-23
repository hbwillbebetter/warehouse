package com.design_pattern_23.creation.prototype.v2;

public class ConcretePrototype2 implements Prototype {
	
	private String name;
	
	//最简单的克隆，新建一个自身对象，由于没有属性就不再复制值了
	@Override
	public Prototype clone(){
		ConcretePrototype2 prototype = new ConcretePrototype2();
		return prototype;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String toString() {
		return "ConcretePrototype2 [name=" + name + "]";
	}
	
}
