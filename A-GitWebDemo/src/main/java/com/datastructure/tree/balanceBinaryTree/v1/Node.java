package com.datastructure.tree.balanceBinaryTree.v1;


public class Node {
	int value;
	Node left;
	Node right;
	
	public Node(int value) {
		this.value=value;
	}

	/**
	 * 向子树中添加节点
	 * @param node
	 */
	public void add(Node node) {
		if(node==null) {
			return;
		}
		//判断传入的节点的值比当前子树的根节点的值大还是小
		//添加的节点比当前节点的值更小
		if(node.value<this.value) {
			//如果左节点为空
			if(this.left==null) {
				this.left=node;
			//如果不为空
			}else {
				this.left.add(node);
			}
		}else {
			if(this.right==null) {
				this.right=node;
			}else {
				this.right.add(node);
			}
		}
		//查询平衡性，每添加一个新节点，得判断是否需要调整（旋转），使得树满足平衡性
		//进行右旋转
		if(leftHight() - rightHight() >= 2){
			if (left !=null && left.leftHight()<left.rightHight()) {
				//左子树左旋转一次
				left.leftRotate();
			}
			//单旋转，进行一次右旋转
			rightRotate();
		}
		//进行左旋转
		if (leftHight() - rightHight() <= -2) {
			if(right!=null && right.leftHight()>right.rightHight()){
				//右子树右旋转一次
				right.rightRotate();
			}
			//单旋转，进行一次左旋转
			leftRotate();
		}
	}
	/**
	 * 左旋转---根据右旋转的对称性
	 */
	private void leftRotate() {
		//创建一个新节点，值等于当前节点
		Node newNode = new Node(value);
		//将当前节点的左子树设置为新节点的左子树
		newNode.left = left;
		//将当前节点右子树的左子树设置为新节点的右子树
		newNode.right = right.left;
		//将当前节点设置为右子节点
		value = right.value;
		//将当前节点的右子树设置为当前节点的右子树的右子树
		right = right.right;
		//将新创建的节点，设置为当前节点的左子树
		left = newNode;
	}
	/**
	 * 右旋转
	 */
	private void rightRotate() {
		//创建一个新节点，值等于当前节点
		Node newNode = new Node(value);
		//将当前节点的右子树设置为新节点的右子树
		newNode.right = right;
		//将当前节点左子树的右子树设置为新节点的左子树
		newNode.left = left.right;
		//将当前节点设置为左子节点
		value = left.value;
		//将当前节点的左子树设置为当前节点的左子树的左子树
		left = left.left;
		//将新创建的节点，设置为当前节点的右子树
		right = newNode;
	}

	/**
	 * 获取右子树的高度
	 * @return
	 */
	private int rightHight() {
		if(right==null){
			return 0;
		}
		return right.height();
	}

	/**
	 * 获取左子树的高度
	 * @return
	 */
	private int leftHight() {
		if (left == null) {
			return 0;
		}
		return left.height();
	}

	/**
	 * 中序遍历
	 * @param node
	 */
	public void midShow(Node node) {
		if(node==null) {
			return;
		}
		midShow(node.left);
		System.out.print(node.value+" ");
		midShow(node.right);
	}

	/**
	 * 查找节点
	 * @param value2
	 */
	public Node search(int value) {
		if(this.value==value) {
			return this;
		}else if(value<this.value) {
			if(left==null) {
				return null;
			}
			return left.search(value);
		}else{
			if(right==null) {
				return null;
			}
			return right.search(value);
		}
	}

	/**
	 * 搜索父节点
	 * @param value
	 * @return
	 */
	public Node searchParent(int value) {
		if((this.left!=null&&this.left.value==value)||(this.right!=null&&this.right.value==value)) {
			return this;
		}else {
			if(this.value>value&&this.left!=null) {
				return this.left.searchParent(value);
			}else if(this.value<value&&this.right!=null){
				return this.right.searchParent(value);
			}
			return null;
		}
	}
	/**
	 * 返回当前节点的高度
	 * @return
	 */
	public int height() {
		return Math.max((left==null)?0:left.height(), (right==null)?0:right.height())+1;
	}
}
