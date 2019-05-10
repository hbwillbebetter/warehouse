package com.datastructure.tree.huffmanTree.v1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TestHaffmanTree {

	public static void main(String[] args) {
		int[] arr = {3,7,8,29,5,11,23,14};
		Node node = createHuffmanTree(arr);
		System.out.println(node.toString());
		cenOrder(node);
		System.out.println();
		cenOrder2(node);
	}
	
	//创建霍夫曼树
	private static Node createHuffmanTree(int[] arr) {
		//集合装所有节点,集合需要满足动态增删节点，所以选则List
		List<Node> nodes = new ArrayList<>();
		for(int i : arr){
			Node node = new Node(i);
			nodes.add(node);
		}
		//当集合中有且只有一个节点的时候不需要调整，否则每次都需要调整
		while(nodes.size() > 1){
			//节点降序排列
			Collections.sort(nodes);
			//从集合取最小的两个节点，组成一个带根节点的二叉树
			Node left = nodes.get(nodes.size()-2);
			Node right = nodes.get(nodes.size()-1);
			Node parent = new Node(left.value+right.value);
			parent.left = left;
			parent.right = right;
			//集合移除这两个节点，并将新的二叉树加入集合
			nodes.remove(left);
			nodes.remove(right);
			nodes.add(parent);
		}
		return nodes.get(0);
	}
	
	//层次遍历
	public static void cenOrder(Node root) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while (!queue.isEmpty()) {
			root = queue.poll();
			System.out.print(root.value+" ");
			if(root.left != null){
				queue.add(root.left);
			}
			if(root.right != null){
				queue.add(root.right);
			}
		}
		
	}
	//层次遍历二叉树，并分层打印
	public static void cenOrder2(Node root) {
		Queue<Node> queue = new ArrayDeque<Node>();
		queue.add(root);
		int currentLevel = 1;//记录当前层需要打印的节点个数
		int nextLevel = 0;//记录下一层需要打印的节点个数
		while (!queue.isEmpty()) {
			Node temp = queue.poll();
			System.out.print(temp.value+" ");
			//当前层打印节点后，自减一
			currentLevel--;
			if(temp.left != null){
				queue.add(temp.left);
				nextLevel++;
			}
			if(temp.right != null){
				queue.add(temp.right);
				nextLevel++;
			}
			//如果当前层没有需要打印的节点
			if(currentLevel == 0){
				//换行输出
				System.out.println();
				//将下一层需要打印的节点个数，指向当前层的个数
				currentLevel = nextLevel;
				//重置下一层的个数
				nextLevel = 0;
			}
		}
		
	}

}
