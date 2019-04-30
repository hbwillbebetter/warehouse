package com.datastructure.binaryTree;

public class TestBinaryTree {

	public static void main(String[] args) {
		BinaryTree bTree = new BinaryTree();
		//创建根节点
		TreeNode root = new TreeNode(1);
		//设置根节点
		bTree.setRoot(root);
		//创建左子节点
		TreeNode left1 = new TreeNode(2);
		root.setLeftNode(left1);
		//创建右子节点
		TreeNode right1 = new TreeNode(3);
		root.setRightNode(right1);
		//创建第二层
		left1.setLeftNode(new TreeNode(4));
		left1.setRightNode(new TreeNode(5));
		
		right1.setLeftNode(new TreeNode(6));
		right1.setRightNode(new TreeNode(7));
		
		//前序遍历
		bTree.fontShow();
		System.out.println("###");
		bTree.fontShow2();
		System.out.println("==============");
		//中序遍历
		bTree.midShow();
		System.out.println("---");
		bTree.midShow2();
		System.out.println("==============");
		//后序遍历
		bTree.afterShow();
		System.out.println("@@@");
		bTree.afterShow2();
		System.out.println("==============");
		//前序查找
		TreeNode result = bTree.fontSearch(4);
		System.out.println(result == left1.leftNode);
		System.out.println("==============");
		//删除子树
		bTree.delete(2);
		bTree.fontShow();
		
	}

}
