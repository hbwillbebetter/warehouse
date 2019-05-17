package com.datastructure.Hash.v1;

import java.util.Arrays;

public class HashTable {
	private StuInfo[] data = new StuInfo[100];
	
	/**
	 * 向散列表中添加元素
	 * @param stu
	 */
	public void put(StuInfo stu) {
		//调用散列函数获取存储位置
		int index = stu.hashCode();
		//添加元素
		data[index] = stu;
	}

	@Override
	public String toString() {
		return "HashTable [data=" + Arrays.toString(data) + "]";
	}

	public StuInfo get(StuInfo stuInfo) {
		return data[stuInfo.hashCode()];
	}
	
	
	
}
