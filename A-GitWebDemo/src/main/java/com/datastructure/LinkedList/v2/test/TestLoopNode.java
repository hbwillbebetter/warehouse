package com.datastructure.LinkedList.v2.test;

import com.datastructure.LinkedList.v2.Node;

public class TestLoopNode {

	public static void main(String[] args) {
		Node n1 = new Node("1");
		Node n2 = new Node("2");
		Node n3 = new Node("3");
		Node n4 = new Node("4");
		n1.append(n2).append(n3).append(n4);
		n1.append(new Node("5"));
		System.out.println("============");
		//取下一个节点的数据
		System.out.println(n1.next().next().next().next().getData());
		//判断节点是否是最后一个
		System.out.println(n1.next().next().next().next().isLast());
		n1.show();
//		n2.show();
		n1.next().removeNext();//n3删除了
		n1.show();//1 2 4 5 
		n2.show();//2 4 5
		//插入一个新节点
		Node node = new Node("7");
		n1.next().after(node);
		n1.show();//1 2 7 4 5
		
		
	}

}
