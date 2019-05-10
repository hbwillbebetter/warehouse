package com.datastructure.tree.threadedBinaryTree.v1;

/**
 * 参考网址：https://blog.csdn.net/UncleMing5371/article/details/54176252#commentsedit
 * @author B
 *
 */
public class TestThreadedBinaryTree {

	public static void main(String[] args) {
		//创建一颗线索二叉树
		ThreadedBinaryTree bt = new ThreadedBinaryTree();
		//创建根节点
		ThreadedNode root = new ThreadedNode("A");
		bt.setRoot(root);
		//创建第二层
		ThreadedNode L2 = new ThreadedNode("B");
		ThreadedNode R2 = new ThreadedNode("C");
		root.setLeftNode(L2);
		root.setRightNode(R2);
		//创建第三层
		ThreadedNode L3 = new ThreadedNode("D");
		ThreadedNode R3 = new ThreadedNode("E");
		ThreadedNode L4 = new ThreadedNode("F");
		ThreadedNode R4 = new ThreadedNode("G");
		L2.setLeftNode(L3);
		L2.setRightNode(R3);
		R2.setLeftNode(L4);
		R2.setRightNode(R4);
		//创建第四层
		ThreadedNode L5 = new ThreadedNode("H");
		ThreadedNode R5 = new ThreadedNode("I");
		L3.setLeftNode(L5);
		L3.setRightNode(R5);
		
		//中序遍历树
		bt.midShow();
		System.out.println("===============");
		
		//前序查找---此过程要是在线索化二叉树后进行遍历，可能存在死循环。
		ThreadedNode resultNode = bt.frontSearch("L");
		System.out.println(resultNode);
		
		//删除子树
		bt.delete("H");
		
		//线索化二叉树
		bt.threadNodes();
		//遍历线索化二叉树
		bt.iteratorThreadedTree();
		
		
		
		
		
	}

}
