package com.datastructure.tree.huffmanCode.v1;

public class Node implements Comparable<Node> {
	//节点数据，如字符'a'-->97
	Byte data;
	//节点权值,如字符'a'出现的次数
	int weight;
	//左节点
	Node left;
	//右节点
	Node right;
	
	//初始化节点
	public Node(Byte data, int weight){
		this.data = data;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", weight=" + weight + "]";
	}

	/**
	 * 节点排序，需要降序--(对出现的次数)
	 */
	@Override
	public int compareTo(Node o) {
		return -(this.weight - o.weight);
	}
	
	
	
}
