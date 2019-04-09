package com.datastructure.LinkedList;

import org.junit.Test;

public class OrderLinkedList {
    private Node head;
    
    private class Node{
        private int data;
        private Node next;
        
        public Node(int data){
            this.data = data;
        }
    }

    public OrderLinkedList(){
        head = null;
    }
    
    //插入节点，并按照从小打到的顺序排列
    public void insert(int value){
        Node node = new Node(value);
        Node pre = null;
        Node current = head;
        while(current != null && value > current.data){//遍历已排序好的链表
        	System.out.println(0);
            pre = current;
            current = current.next;
        }
        if(pre == null){
        	System.out.println(1);
            head = node;
            head.next = current;
        }else{
        	System.out.println(2);
            pre.next = node;
            node.next = current;
        }
    }
    
    //删除头节点
    public void deleteHead(){
        head = head.next;
    }
    
    public void display(Node head){
        Node current = head;
        while(current != null){
            System.out.print(current.data+" ");
            current = current.next;
        }
        System.out.println("");
    }
    
    @Test
    public void testOrderLinkedList(){
    	OrderLinkedList orderList = new OrderLinkedList();
    	orderList.insert(1);
    	orderList.insert(3);
    	orderList.insert(2);
    	System.out.println(orderList.head);
    	display(orderList.head);
    }
    
}
