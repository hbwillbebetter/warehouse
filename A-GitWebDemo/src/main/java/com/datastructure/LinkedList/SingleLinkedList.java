package com.datastructure.LinkedList;

import org.junit.Test;

/**
 * ①、单向链表的具体实现
 * @author B
 *
 */
public class SingleLinkedList {
	
	private int size;//链表节点的个数
	private Node head;//头节点
	
	public SingleLinkedList(){
		size = 0;
		head = null;
	}
	
	private class Node {
		private Object data;//每个节点的数据
		private Node next;//每个节点指向下一个节点的连接
		
		public Node(Object data){
			this.data = data;
		}
	}
	
	//在链表头添加元素
	public Object addHead(Object obj){
		Node newHead = new Node(obj);
		if(size == 0){
			head = newHead;
		}else {
			newHead.next = head;
			head = newHead;
		}
		size++;
		return obj;
	}
	
	//在链表头删除元素
	public Object deleteHead(){
		Object obj = head.data;
		head = head.next;
		size--;
		return obj;
	}
	
	//查找指定元素，找到了返回节点的Node，找不到返回null
	public Node find(Object obj){
		Node currNode = head;
		int tempSize = size;
		while (tempSize > 0) {
			if(currNode.data.equals(obj)){
				return currNode;
			}else {
				currNode = currNode.next;
			}
			tempSize--;
		}
		return null;
		
	}
	
	//删除指定的元素，删除成功返回true
	public boolean delete(Object obj){
		if(size == 0){
			return false;
		}
		Node currNode = head;
		Node previousNode = head;
		while(!currNode.data.equals(obj)){
			if(currNode.next == null){
				return false;
			}else{
				previousNode = currNode;
				currNode = currNode.next;
			}
		}
		//如果删除的节点是第一个节点
		if(currNode == head){
			head = currNode.next;
			size--;
		}else{
			//如删除的节点不是第一个
			previousNode.next = currNode.next;
			size--;
		}
		return true;
		
	}
	
	//判断链表是否为空
	public boolean isEmpty(){
		return (size == 0);
	}
	
	//显示节点信息
	public void display(){
		if(size > 0){
			Node node = head;
			int tmpsize = size;
			if(tmpsize == 1){
				System.out.println("["+node.data+"]");
				return;
				
			}
			while(tmpsize > 0){
				if(node.equals(head)){
					System.out.print("["+head.data+"->");
				}else if(node.next == null){
					System.out.print(node.data+"]");
				}else{
					System.out.print(node.data+"->");
				}
				node = node.next;
				tmpsize--;
			}
			System.out.println();
		}else {//如果链表一个节点都没有，直接打印[]
			System.out.println("[]");
		}
	}
	
	@Test
	public void testSingleLinkedList(){
	    SingleLinkedList singleList = new SingleLinkedList();
	    singleList.addHead("A");
	    singleList.addHead("B");
	    singleList.addHead("C");
	    singleList.addHead("D");
	    //打印当前链表信息
	    singleList.display();
	    //删除C
	    singleList.delete("C");
	    singleList.display();
	    //查找B
	    System.out.println(singleList.find("B"));
	}
	
	
	
}
