package com.datastructure.LinkedList.v1.test;

import com.datastructure.LinkedList.v1.LoopNode;

public class TestLoopNode {

	public static void main(String[] args) {
		LoopNode n1 = new LoopNode("1");
		LoopNode n2 = new LoopNode("2");
		LoopNode n3 = new LoopNode("3");
		LoopNode n4 = new LoopNode("4");
		
		n1.after(n2);
		n2.after(n3);
		n3.after(n4);
		System.out.println(n1.next().getData());
		System.out.println(n2.next().getData());
		System.out.println(n3.next().getData());
//		System.out.println(n4.next().getData());
		
		//将n2和n4中间的n3删除
		n1.next().removeNext();
		System.out.println(n2.next().getData());//应该是4，而不是3
		
		
	}

}
