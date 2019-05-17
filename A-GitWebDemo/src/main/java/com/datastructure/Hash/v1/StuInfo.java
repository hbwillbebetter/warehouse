package com.datastructure.Hash.v1;

public class StuInfo {
	private int age;
	private int count;
	
	public StuInfo(int age, int count){
		this.age = age;
		this.count = count;
	}
	public StuInfo(int age) {
		this.age = age;
	}
	/**
	 * 散列函数
	 */
	public int hashCode() {
		return age%10;
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "StuInfo [age=" + age + ", count=" + count + "]";
	}
	
}
