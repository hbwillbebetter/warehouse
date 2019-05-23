package com.design_pattern_23.creation.prototype.v1;

//抽象原型（Prototype）角色
public interface Prototype {
	
	/**
     * 克隆自身的方法
     * @return 一个从自身克隆出来的对象
     */
	public Prototype clone();
}
