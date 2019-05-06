package com.datastructure.tree.binaryTree.v1;

public class BinaryTree implements Tree {
	//根节点
	public Node root;
	
	public Node getRoot() {
		return root;
	}

	@Override
	public Node find(int key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int key) {
		// TODO Auto-generated method stub
		return false;
	}
	
	//插入一个新节点
	public boolean insert(int data) {
		/**
		 * 要插入节点，必须先找到插入的位置。与查找操作相似，由于二叉搜索树的特殊性，待插入的节点也需要从根节点开始进行比较，
		 * 小于根节点则与根节点左子树比较，反之则与右子树比较，直到左子树为空或右子树为空，则插入到相应为空的位置，
		 * 在比较的过程中要注意保存父节点的信息 及 待插入的位置是父节点的左子树还是右子树，才能插入到正确的位置。
		 */
		Node newNode = new Node(data);
		if(root == null){//不存在根节点
			root = newNode;
			return true;
		}else{//根节点已经存在
			Node current = root;
			Node parentNode = null;
			while(current != null){
				parentNode = current;
				//将当前节点的值和待插入的值比较
				if(data < current.data){//比较左子树
					current = current.leftChild;
					if(current == null){//左子节点为空，直接插入新节点到当前节点
						parentNode.leftChild = newNode;
						return true;
					}
				}else{//比较右子树
					current = current.rightChild;
					if(current == null){//右子节点为空，直接插入新节点到当前节点
						parentNode.rightChild = newNode;
						return true;
					}
				}
			}
		}
		return false;
	}

	//中序遍历
	public void infixOrder(Node current) {
		if(current != null){
			infixOrder(current.leftChild);
			System.out.print(current.data+" ");
			infixOrder(current.rightChild);
		}
	}

	//前序遍历
	public void preOrder(Node current) {
		if(current != null){
			System.out.print(current.data+" ");
			preOrder(current.leftChild);
			preOrder(current.rightChild);
		}
	}

	@Override
	public void postOrder(Node current) {
		// TODO Auto-generated method stub

	}

	@Override
	public Node findMax() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node findMin() {
		// TODO Auto-generated method stub
		return null;
	}

}
