package com.datastructure.tree.haffmanTree.v1;

public class Node implements Comparable<Node> {
	//权值
	int value;
	//左节点
	Node left;
	//右节点
	Node right;
	
	public Node(int value){
		this.value = value;
	}

	//节点降序排列
	@Override
	public int compareTo(Node node) {
		return -(this.value-node.value);
	}

	@Override
	public String toString() {
		return "Node [value=" + value + "]";
	}
	
	
	
}
