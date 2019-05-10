package com.datastructure.tree.threadedBinaryTree.v1;

public class ThreadedNode {
	//节点的权
	String value;
	//左儿子
	ThreadedNode leftNode;
	//右儿子
	ThreadedNode rightNode;
	//标识指针类型
	int leftType;
	int rightType;
	
	public ThreadedNode(String value){
		this.value = value;
	}
	
	public ThreadedNode getLeftNode() {
		return leftNode;
	}
	public void setLeftNode(ThreadedNode leftNode) {
		this.leftNode = leftNode;
	}
	public ThreadedNode getRightNode() {
		return rightNode;
	}
	public void setRightNode(ThreadedNode rightNode) {
		this.rightNode = rightNode;
	}
	//中序遍历数
	public void midShow() {
		if(leftNode != null) {
			leftNode.midShow();
		}
		System.out.print(value+" ");
		if(rightNode != null){
			rightNode.midShow();
		}
	}
	//前序查找,如果已经提取线索化二叉树了，可能存在死循环
	public ThreadedNode frontSearch(String i) {
		ThreadedNode target = null;
		//对比当前节点的值
		if(this.value == i){
			return this;
			//当前节点的值不是要查找的节点
		}else{
			//查找左儿子
			if (leftNode != null) {
				//有可能找到，也可能查不到，查不到的话，target还是一个null
				target = leftNode.frontSearch(i);
			}
			//如果不为空，说明在左儿子中已经找到
			if(target != null){
				return target;
			}
			//查找右儿子
			if(rightNode != null){
				target = rightNode.frontSearch(i);
			}
			
		}
		
		return target;
	}
	//删除子树
	public void delete(String i) {
		//保留父节点信息
		ThreadedNode parent = this;
		//判断左儿子
		if(        parent.leftNode!=null && parent.leftNode.value == i){
			parent.leftNode = null;
			return;
		}
		//判断右儿子
		if(parent.rightNode!=null && parent.rightNode.value == i){
			parent.rightNode = null;
			return;
		}
		//递归删除左子树
		parent = parent.leftNode;
		if(parent != null){
			parent.delete(i);
		}
		//递归删除右子树
		if(parent!= null){
			parent = parent.rightNode;
		}
		if(parent != null){
			parent.delete(i);
		}
		
	}
	
	
}
