package com.datastructure.tree.binaryTree.v1;

public class Node {
	int data;//数据
	Node leftChild;//左子节点的引用
	Node rightChild;//右子节点的引用
	
	public Node(int data){
		this.data = data;
	}
	
	public Node getLeftChild() {
		return leftChild;
	}
	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}
	public Node getRightChild() {
		return rightChild;
	}
	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}
	
	//打印节点内容
    public void display(){
        System.out.println(data);
    }
	
	
	
}
