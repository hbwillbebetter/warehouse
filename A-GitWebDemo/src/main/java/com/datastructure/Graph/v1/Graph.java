package com.datastructure.Graph.v1;

/**
 * 图所在类
 * @author B
 *
 */
public class Graph {
	//一个图，多个顶点
	private Vertex[] vertexs;
	//顶点数组存放顶点，标识图中顶点的下标
	private int currSize = 0;
	//用一个二维数组，来表示邻接矩阵（存储每个顶点间的连通性）
	int[][] adjMat;
	
	public Graph(int maxSize){
		vertexs = new Vertex[maxSize];
		//初始化邻接矩阵
		adjMat = new int[maxSize][maxSize];
	}
	/**
	 * 向图中增加一个顶点
	 * @param v1
	 */
	public void addVertex(Vertex v1) {
		//设置每个顶点，自己和和自己是联通的
		adjMat[currSize][currSize] = 1;
		vertexs[currSize++] = v1;
	}
	
	//添加边
	public void addEdge(String v1, String v2) {
		//记录参数1的下标位置
		int index1 = 0;
		//记录参数2的下标位置
		int index2 = 0;
		for(int i=0; i<currSize; i++){
			if (vertexs[i].getValue().equals(v1)) {
				index1 = i;
				break;
			}
		}
		for(int i=0; i<currSize; i++){
			if (vertexs[i].getValue().equals(v2)) {
				index2 = i;
				break;
			}
		}
		//设置顶点v1,v2是联通的
		adjMat[index1][index2] = 1;
		adjMat[index2][index1] = 1;
		
	}
	
	
	
	
	
}
