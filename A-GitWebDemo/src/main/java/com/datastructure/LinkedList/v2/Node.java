package com.datastructure.LinkedList.v2;

//一个节点
public class Node {
	String data;//节点数据
	Node next;//下一个节点
	
	public Node(String data){
		this.data = data;
	}
	
	//为节点追加新的节点
	public Node append(Node node){
		//当前节点
		Node curNode = this;
		while(true){
			//取出下一个节点
			Node nextNode = curNode.next;
			if(nextNode == null){
				break;
			}
			//赋值给当前节点（实现了当前节点移动）
			curNode = nextNode;
		}
		//把需要追加的节点，追加到当前节点的下一个节点
		curNode.next = node;
		return this;
	}
	
	//插入一个节点作为当前节点的下一个节点
	public void after(Node node){
		//获取当前节点的下一个节点，作为下下一个节点
		Node nextNext = this.next;
		//将当前节点的next指向新添加的节点
		this.next = node;
		//将新加入的节点的next指向下下一个节点
		node.next = nextNext;
	}
	
	//删除下一个节点
	public void removeNext(){
		//取出下下一个节点
		Node nextNext = this.next.next;
		//将当前节点的next指向下下一个节点即可
		this.next = nextNext;
	}
	
	//显示所有节点信息
	public void show(){
		Node curNode = this;
		while(true){
			System.out.print(curNode.getData()+" ");
			//取出下一个节点
			curNode = curNode.next;
			//如果是最后一个节点
			if(curNode == null){
				break;
			}
		}
		System.out.println();
		
	}
	
	//获取下一个节点
	public Node next(){
		return this.next;
	}
	
	//获取节点数据
	public String getData(){
		return this.data;
	}
	
	//是否是最后一个节点
	public boolean isLast(){
		return (this.next == null) ? true : false;
	}
	
}
