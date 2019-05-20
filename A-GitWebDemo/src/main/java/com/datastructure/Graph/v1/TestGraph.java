package com.datastructure.Graph.v1;

import java.util.Arrays;

public class TestGraph {

	public static void main(String[] args) {
		Vertex v1 = new Vertex("A");
		Vertex v2 = new Vertex("B");
		Vertex v3 = new Vertex("C");
		Vertex v4 = new Vertex("D");
		Vertex v5 = new Vertex("E");
		
		//新创建一个图
		Graph graph = new Graph(5);
		graph.addVertex(v1);
		graph.addVertex(v2);
		graph.addVertex(v3);
		graph.addVertex(v4);
		graph.addVertex(v5);
		
		
		//添加边
		graph.addEdge("A", "B");
		graph.addEdge("A", "C");
		graph.addEdge("B", "C");
		graph.addEdge("B", "D");
		graph.addEdge("B", "E");
		
		//遍历二维数组
		for(int[] a: graph.adjMat){
			System.out.println(Arrays.toString(a));
		}
		//深度优先搜索
		graph.dfs();
		System.out.println("===================");
		//广度优先搜索
		graph.bfs();
		
	}

}
