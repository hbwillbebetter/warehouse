package com.datastructure.tree.binaryTree.v1;

public class TestBinaryTree {
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.insert(50);
		bt.insert(20);
        bt.insert(80);
        bt.insert(10);
        bt.insert(30);
        bt.insert(60);
        bt.insert(90);
        bt.insert(25);
        bt.insert(85);
        bt.insert(100);
        //前序遍历二叉树
        bt.preOrder(bt.getRoot());
        System.out.println();
        //中序遍历
        bt.infixOrder(bt.getRoot());
        
	}
}
