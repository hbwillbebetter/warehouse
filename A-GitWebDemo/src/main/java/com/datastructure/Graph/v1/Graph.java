package com.datastructure.Graph.v1;

import com.util.MyQueue;
import com.util.MyStack;

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
	private MyStack stack = new MyStack();
	private MyQueue queue = new MyQueue();
	//记录当前遍历的下标
	private int currentIndex;
	
	
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
//		adjMat[currSize][currSize] = 1;
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
	/**
	 * 深度优先搜索算法遍历图
	 */
	public void dfs() {
		//设置第一个顶点为已访问
		vertexs[0].visited = true;
		//将第0个顶点加入到栈中（再这里将顶点的下标放入栈中）
		stack.push(0);
		//打印顶点值
		System.out.println(vertexs[0].getValue());
		//当前遍历的下标
		currentIndex = 0;
		while (!stack.isEmpty()) {
			for(int i = currentIndex+1; i<currSize; i++){
				//如两个顶点是联通的，且下一个顶点还是未访问过的
				if(adjMat[currentIndex][i] == 1 && vertexs[i].visited == false){
					//设置下一个顶点为已访问
					vertexs[i].visited = true;
					//打印顶点
					System.out.println(vertexs[i].getValue());
					//将下一个顶点加入到栈中
					stack.push(i);
				}
			}
			//如果当前遍历的下标（本轮）遍历完，则移除栈顶元素
			int pop = stack.pop();
			if (!stack.isEmpty()) {
				//重置当前遍历的下标为新的栈顶元素下标
				currentIndex = stack.peek();
			}
		}
	}
	/**
	 * 广度优先搜索算法遍历图
	 */
	public void bfs() {
		//先重置所有顶点为未访问状态
		for(int i=0; i<vertexs.length; i++){
			vertexs[i].visited = false;
		}
		//设置第一个顶点为已访问
		vertexs[0].visited = true;
		//将第0个顶点加入到队列中（再这里将顶点的下标放入队列中）
		//打印顶点值
		System.out.println(vertexs[0].getValue());
		queue.add(0);
		while(!queue.isEmpty()){
			for(int i=currentIndex+1; i<currSize; i++){
				if (adjMat[currentIndex][i] == 1 && vertexs[i].visited == false) {
					//打印顶点值
					System.out.println(vertexs[i].getValue());
					vertexs[i].visited = true;
					queue.add(i);
				}
			}
			//当前轮遍历完成后，移除队列头
			queue.poll();
			if (!queue.isEmpty()) {
				//查看新的队列头,重置当前遍历的下标为新的队列头元素下标
				currentIndex = queue.peek();
			}
		}
		
	}
	
	
	
	
	
	
	
	
	
	
}
