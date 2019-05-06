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
        System.out.println();
        //查找节点
        Node findNode = bt.find(50);
        System.out.println(findNode);
        //查找最小值
        Node minNode = bt.findMin();
        System.out.println(minNode);
        //查找最大值
        Node maxNode = bt.findMax();
        System.out.println(maxNode);
//        boolean delFlag = bt.delete(10);//删除叶子节点
//        boolean delFlag = bt.delete(30);//删除节点只有一个子节点
        boolean delFlag = bt.delete(80);//删除节点有两个子节点
        System.out.println(delFlag);
        //中序遍历
        bt.infixOrder(bt.getRoot());
        System.out.println();
        
        
        
	}
}
