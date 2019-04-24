package com.datastructure.LinkedList.v3.test;

import com.datastructure.LinkedList.v3.DoubleNode;

public class TestDoubleNode {

	public static void main(String[] args) {
		DoubleNode n1 = new DoubleNode("1");
		DoubleNode n2 = new DoubleNode("2");
		DoubleNode n3 = new DoubleNode("3");
		DoubleNode n4 = new DoubleNode("4");
		
//		System.out.println(n1.getData());
//		n1.after(n2);
//		n2.after(n3);
//		n3.after(n4);
//		System.out.println(n1.pre().getData());//4
//		System.out.println(n1.getData());//1
//		System.out.println(n1.next().getData());//2
//		System.out.println("============");
//		System.out.println(n2.pre().getData());
//		System.out.println(n2.getData());
//		System.out.println(n2.next().getData());
//		System.out.println("============");
//		n1.removeNext();
//		System.out.println(n1.pre().getData());//4
//		System.out.println(n1.getData());//1
//		System.out.println(n1.next().getData());//3
//		n3.removeNext();
//		System.out.println("============");
//		System.out.println(n3.pre().getData());//1
//		System.out.println(n3.getData());//3
//		System.out.println(n3.next().getData());//1
		
		n1.removeNext();//当只有一个节点是删不掉的，因为this.next->this,this.pre->this
		System.out.println(n1.getData());
		
		
	}

}
