package com.datastructure.tree.binaryTree.v1;

public class BinaryTree implements Tree {
	//根节点
	public Node root;
	
	public Node getRoot() {
		return root;
	}
	
	/**
	 * 1.当查找的值比当前节点值大，则搜索右子树
	 * 2.当查找的值和当前节点值相等，则停止搜索（终止条件）
	 * 3.当查找的值比当前节点小，则搜索左子树
	 */
	public Node find(int key) {
		Node currNode = root;
		while(currNode != null){
			if(key > currNode.data){//当前值比查找值小，搜索右子树
				currNode = currNode.rightChild;
			}else if(key < currNode.data){//当前值比查找值大，搜索左子树
				currNode = currNode.leftChild;
			}else{
				return currNode;
			}
		}
		return null;//遍历完整个树没找到，返回null
	}

	/**
	 * 删除节点是二叉搜索树中最复杂的，删除节点有三种情况
	 * 1.该节点是叶子节点（没有子节点）---该节点是左子节点还是右子节点，得有属性标识
	 * 2.该节点有一个节点
	 * 3.该节点有两个节点
	 */
	public boolean delete(int key) {
		Node current = root;
		Node parent = root;
		boolean isLeftChild = false;
		//待删除的节点不存在，返回false
		while(current.data != key){
			parent = current;
			if(current.data > key){//找左子节点
				isLeftChild = true;
				current = current.leftChild;
			}else {//找右子节点
				isLeftChild = false;
				current = current.rightChild;
			}
			if(current == null){//找不到待删除的节点
				return false;
			}
		}
		
		if(current.leftChild == null && current.rightChild == null){//情况1：删除节点是叶子节点---找到待删除的节点，并确定该节点是叶子节点
			if(current == root){//待删除的叶子节点是根节点
				root = null;
			}else if(isLeftChild) {//待删除的叶子节点是左子节点
				parent.leftChild = null;
			}else {//待删除的叶子节点是右子节点
				parent.rightChild = null;
			}
			return true;
		}else if(current.leftChild != null && current.rightChild == null){//情况2：删除节点是左子节点
			if(current == root){
				root = current.leftChild;
			}else if(isLeftChild){
				parent.leftChild = current.leftChild;
			}else {
				parent.rightChild = current.leftChild;
			}
			return true;
		}else if(current.leftChild == null && current.rightChild != null){//情况2：删除节点是右子子节点
			if(current == root){
				root = current.rightChild;
			}else if(isLeftChild){
				parent.leftChild = current.rightChild;
			}else {
				parent.rightChild = current.rightChild;
			}
			return true;
		}else{//情况3：删除节点有两个子节点
			Node successor = getSuccessor(current);
			if (current == root) {
				root = successor;
			}else if(isLeftChild){
				parent.leftChild = successor;
			}else {
				parent.rightChild = successor;
			}
			//将删除节点的左子树---转嫁给---后继节点的左子树
			successor.leftChild = current.leftChild;
			return true;
		}
	}
	
	//获取后继节点
	public Node getSuccessor(Node delNode) {
		//记录后继节点的父节点信息
		Node successorParent = delNode;
		//记录后继节点
		Node successor = delNode;
		//记录当前节点
		Node current = delNode.rightChild;
		while (current != null) {
			//查找后继节点，并保留后继节点父节点信息
			successorParent = successor;
			successor = current;
			current = current.leftChild;
		}
		//如果后继节点不是待删除节点的右子节点，则继续处理，否则，直接返回后继节点
		if(delNode.rightChild != successor){
			//首先后继节点的父节点的左子节点指向后继节点的右子节点
			successorParent.leftChild = successor.rightChild;
			//将待删除节点的右子树--全部转嫁给--后继节点的右子树
			successor.rightChild = delNode.rightChild;
		}
		return successor;
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

	/**
	 * 找最大值，首先找根节点的右子节点，然后再找右子节点的右子节点，直到找到没有右子节点的节点，这个节点的权值就是最大值
	 */
	public Node findMax() {
		Node currNode = root;
		Node maxNode = currNode;
		while(currNode != null){
			maxNode = currNode;
			currNode = currNode.rightChild;
		}
		return maxNode;
	}

	/**
	 * 要找最小值，首先找根节点的左子节点，然后再找左子节点的左子节点，直到找到没有左子节点的节点，这个节点的权值就是最小值
	 */
	public Node findMin() {
		Node currNode = root;
		Node minNode = currNode;
		while(currNode != null){
			minNode = currNode;
			currNode = currNode.leftChild;
		}
		return minNode;
	}

}
