package com.datastructure.Graph.v1;

/**
 * 顶点类
 * @author B
 *
 */
public class Vertex {
	
	private String value;
	//顶点是否访问过
	public boolean visited;
	
	public Vertex(String value){
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "Vertex [value=" + value + "]";
	}
	
	
}
