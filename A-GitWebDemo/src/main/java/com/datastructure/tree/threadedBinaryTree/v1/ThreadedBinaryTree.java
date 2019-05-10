package com.datastructure.tree.threadedBinaryTree.v1;

public class ThreadedBinaryTree {
	
	//根节点
	ThreadedNode root;
	//前驱节点
	ThreadedNode pre;
	
	public ThreadedNode getRoot() {
		return root;
	}
	public void setRoot(ThreadedNode root) {
		this.root = root;
	}
	//中序遍历
	public void midShow() {
		if (root != null) {
			root.midShow();
		}
	}
	public void threadNodes() {
		threadNodes(root);
	}
	//线索化node
	private void threadNodes(ThreadedNode node) {
		if(node == null){
			return;
		}
		//处理左子树
		threadNodes(node.leftNode);
		System.out.println("#########################处理节点("+node.value+")之间的关系start#########################");
		if(node.leftNode == null){
			//让当前节点的指针指向前驱节点
			node.leftNode = pre;
			//改变当前节点的左指针类型
			node.leftType = 1;
		}
		if (pre!=null && pre.rightNode == null) {//前驱节点存在，且不含右子树
			//前驱节点的右指针指向当前节点
			pre.rightNode = node;
			//改变前驱节点的右指针类型
			pre.rightType = 1;
		}
		//每处理完一个节点，当前节点是下一个节点的前驱节点，即将当前节点指向前驱节点
		pre = node;
		System.out.println("#########################处理节点("+node.value+")之间的关系end#########################");
		//处理右子树
		threadNodes(node.rightNode);
	}
	//迭代遍历线索二叉树
	public void iteratorThreadedTree() {
		//用于存储临时节点
		ThreadedNode node = root;
		while(node != null){
			//查找左子树,直到遇到leftType==1停止
			while(node.leftType == 0){
				node = node.leftNode;
			}
			//打印节点信息
			System.out.print(node.value+" ");
			while (node.rightType == 1) {
				node = node.rightNode;
				System.out.print(node.value + " ");
			}
			//替换当前遍历节点
			node = node.rightNode;
		}
		System.out.println();
	}
	//前序查找
	public ThreadedNode frontSearch(String i) {
		return root.frontSearch(i);
	}
	//删除子树
	public void delete(String i) {
		if(root.value == i){
			root = null;
		}else{
			root.delete(i);
		}
	}
	
	
	
	
}
