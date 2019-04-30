package com.datastructure.binaryTree;

public class BinaryTree {
	TreeNode root;

	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}

	public void fontShow() {
		if(root != null){
			root.fontShow();
		}
	}

	public void midShow() {
		if(root != null){
			root.midShow();
		}
	}

	public void afterShow() {
		if(root!= null){
			root.afterShow();
		}
	}
	//非递归前序遍历
	public void fontShow2() {
		if(root != null){
			root.fontShow2();
		}
	}
	//非递归中序遍历
	public void midShow2() {
		if(root != null){
			root.midShow2();
		}
	}
	
	//非递归后序遍历
	public void afterShow2() {
		if(root != null){
			root.afterShow2();
		}
	}

	public TreeNode fontSearch(int data) {
		return root.fontSearch(data);
	}

	public void delete(int i) {
		if(root.data == i){
			root = null;
		}else{
			root.delete(i);
		}
	}

	
	
	
}
