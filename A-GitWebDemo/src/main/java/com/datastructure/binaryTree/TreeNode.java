package com.datastructure.binaryTree;

import java.util.Stack;

public class TreeNode {
	//节点的权
	int data;
	//左子节点
	TreeNode leftNode;
	//右子节点
	TreeNode rightNode;
	boolean isFirst;//节点是否被访问过
	
	public TreeNode(int data) {
		this.data = data;
	}
	
	public TreeNode getLeftNode() {
		return leftNode;
	}
	public void setLeftNode(TreeNode leftNode) {
		this.leftNode = leftNode;
	}
	public TreeNode getRightNode() {
		return rightNode;
	}
	public void setRightNode(TreeNode rightNode) {
		this.rightNode = rightNode;
	}
	//前序遍历
	public void fontShow() {
		//遍历当前节点内容
		System.out.println(this.data);
		//左子节点
		if(leftNode != null){
			leftNode.fontShow();
		}
		//右子节点
		if(rightNode != null){
			rightNode.fontShow();
		}
		
	}
	//非递归前序遍历
	public void fontShow2() {
		Stack<TreeNode> stack = new Stack<>();
		TreeNode currNode = this;
		while(currNode != null || !stack.isEmpty()){
			if(currNode != null){
				System.out.print(currNode.data+" ");
				stack.push(currNode);
				currNode = currNode.leftNode;
			}else{
				//查看栈顶元素
				currNode = stack.peek();
				//弹出栈顶元素
				stack.pop();
				//将当前节点指向右子节点
				currNode = currNode.rightNode;
			}
			
		}
	}
	//中序遍历
	public void midShow() {
		//先遍历左子节点
		if(leftNode != null){
			leftNode.midShow();
		}
		System.out.println(this.data);
		//最后遍历右子节点
		if(rightNode != null){
			rightNode.midShow();
		}
	}
	//非递归中序遍历
	public void midShow2() {
		Stack<TreeNode> stack = new Stack<>();
		TreeNode currNode = this;
		while(currNode != null || !stack.isEmpty()){
			if(currNode != null){
				stack.push(currNode);
				currNode =  currNode.leftNode;
			}else{
				//查看栈顶元素
				currNode = stack.peek();
				System.out.println(currNode.data);
				stack.pop();
				currNode = currNode.rightNode;
			}
		}
		
	}
	
	//后序遍历
	public void afterShow() {
		//先左子节点
		if(leftNode != null){
			leftNode.afterShow();
		}
		//再右子节点
		if(rightNode != null){
			rightNode.afterShow();
		}
		//最后根节点
		System.out.println(this.data);
		
	}
	//非递归后序遍历
	public void afterShow2() {
		Stack<TreeNode> stack = new Stack<>();
		TreeNode currNode = this;
		while(currNode != null || !stack.isEmpty()){
			if(currNode != null){//将最左子树添加完毕
				currNode.isFirst = true;
				stack.push(currNode);
				currNode = currNode.leftNode;
			}else{//和中序遍历相似，先输出左结点，但是做结点输出完毕之后，不能直接将根结点弹出，而是必须先将右结点弹出，
				currNode = stack.peek();
				stack.pop();
				if(currNode.isFirst){
					currNode.isFirst = false;
					stack.push(currNode);
					currNode = currNode.rightNode;
				}else{
					System.out.println(currNode.data);
					currNode = null;
				}
				
			}
		}
	}
	//前序查找(根-左子节点-右子节点)
	public TreeNode fontSearch(int data) {
		TreeNode target = null;
		//先判断当前节点
		if(this.data == data){
			return this;
		}else{
			//左子儿子,递归查找
			if(leftNode != null){
				target = leftNode.fontSearch(data);
			}
			//如果左子儿子递归找到了
			if(target != null){
				return target;
			}
			//如果左子儿子递归未找到，则递归查找右子儿子
			if(rightNode != null){
				target = rightNode.fontSearch(data);
			}
		}
		
		return target;
		
	}
	//删除指定子树
	public void delete(int i) {
		//记录父节点
		TreeNode parent = this;
		//判断左儿子
		if(parent.leftNode !=null && parent.leftNode.data == i){
			parent.leftNode = null;
			return;
		}
		//判断右儿子
		if(parent.rightNode !=null && parent.rightNode.data == i){
			parent.rightNode = null;
			return;
		}
		//递归删除左儿子
		parent = leftNode;
		if(parent != null){
			parent.delete(i);
		}
		//递归删除右儿子
		parent = rightNode;
		if(parent != null){
			parent.delete(i);
		}
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
