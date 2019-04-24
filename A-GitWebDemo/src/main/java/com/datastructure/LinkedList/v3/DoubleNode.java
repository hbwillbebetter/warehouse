package com.datastructure.LinkedList.v3;

//循环双向列表
public class DoubleNode {
	//当前节点的上一个节点
	DoubleNode pre = this;
	//当前节点的下一个节点
	DoubleNode next = this;
	//当前节点内容
	String data;
	
	public DoubleNode(String data){
		this.data = data;
	}
	
	//为当前节点追加一个新的节点
	public void after(DoubleNode node){
		//获取当前节点的下一个节点，作为下下一个节点
		DoubleNode nextNext = this.next;
		//指定当前节点的next是新节点
		this.next = node;
		//指定新节点的前一个节点是this
		node.pre = this;
		//指定新节点的next是nextNext
		node.next = nextNext;
		//指定nextNext的pre是新节点
		nextNext.pre = next;
	}
	
	//移除下一个节点
	public void removeNext(){
		//获取当前节点的下下一个节点,作为下一个节点
		DoubleNode nextNode = this.next.next;
		//将当前节点的next指向nextNode
		this.next = nextNode;
		//将nextNode的pre指向this
		nextNode.pre = this;
	}
	
	
	//获取上一个节点
	public DoubleNode pre(){
		return this.pre;
	}
	
	//获取下一个几点
	public DoubleNode next(){
		return this.next;
	}
	
	
	//获取节点的数据
	public String getData(){
		return this.data;
	}
}
