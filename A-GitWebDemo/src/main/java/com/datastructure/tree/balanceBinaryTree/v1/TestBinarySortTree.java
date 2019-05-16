package com.datastructure.tree.balanceBinaryTree.v1;

//平衡二叉树的旋转
public class TestBinarySortTree {

	public static void main(String[] args) {
//		int[] arr = new int[] {8,9,6,7,5,4};//需要右旋转一次
//		int[] arr = new int[] {2,4,1,5,3,6};//需要左旋转一次
//		int[] arr = new int[] {8,5,9,4,6,7};//双旋转，先左旋转，后右旋转
		int[] arr = new int[] {4,1,7,6,5,8};//双旋转，先右旋转，后左旋转
		//创建一颗二叉排序树
		BinarySortTree bst = new BinarySortTree();
		//循环添加
		for(int i:arr) {
			bst.add(new Node(i));
		}
		//查看树的高度
		System.out.println(bst.root.height());
		System.out.println("-----");
		//查看树中的值
		bst.cenShow();
	}

}
