package com.design_pattern_23.creation.prototype.v2;

public class ConcretePrototype1 implements Prototype {
	
	private String name;
	
	 //最简单的克隆，新建一个自身对象，由于没有属性就不再复制值了
	@Override
	public Prototype clone(){
		ConcretePrototype1 prototype = new ConcretePrototype1();
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
		return "ConcretePrototype1 [name=" + name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		ConcretePrototype1 other = (ConcretePrototype1) obj;
//		if (name == null) {
//			if (other.name != null)
//				return false;
//		} else if (!name.equals(other.name))
//			return false;
//		return true;
//	}
	
	
	
}
