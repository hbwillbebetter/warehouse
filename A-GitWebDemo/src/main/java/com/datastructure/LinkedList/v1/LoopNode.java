package com.datastructure.LinkedList.v1;

//一个节点
public class LoopNode {
	String data;//节点数据
	LoopNode next;//下一个节点
	
	public LoopNode(String data){
		this.data = data;
	}
	
	//插入一个节点作为当前节点的下一个节点
	public void after(LoopNode node){
		//获取当前节点的下一个节点，作为下下一个节点
		LoopNode nextNext = this.next;
		//将当前节点的next指向新添加的节点
		this.next = node;
		//将新加入的节点的next指向下下一个节点
		node.next = nextNext;
	}
	
	//删除下一个节点
	public void removeNext(){
		//取出下下一个节点
		LoopNode nextNext = this.next.next;
		//将当前节点的next指向下下一个节点即可
		this.next = nextNext;
	}
	
	//获取下一个节点
	public LoopNode next(){
		return this.next;
	}
	
	//获取节点数据
	public String getData(){
		return this.data;
	}
	
	
}
