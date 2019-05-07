package com.datastructure.tree.heap.v1;

public class Node {
	//节点权值
	private int data;
	
	public Node(int data){
		this.data = data;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "Node [data=" + data + "]";
	}
	
}
