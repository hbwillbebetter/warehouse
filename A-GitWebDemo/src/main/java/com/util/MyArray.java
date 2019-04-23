package com.util;

import java.util.Arrays;

import javax.management.RuntimeErrorException;

public class MyArray {
	int[] elements;
	
	//数组初始化
	public MyArray() {
		this.elements = new int[0];
	}
	
	//增加一个元素
	public void add(int element){
		//数组扩容
		int[] newArray = new int[elements.length + 1];
		//将原数组拷贝至新数组
		for(int i=0; i<elements.length; i++){
			newArray[i] = elements[i];
		}
		//添加目标元素到新数组的末尾
		newArray[newArray.length - 1] = element;
		//将新数组引用指向原数组
		elements = newArray;
	}
	
	//删除数组中的元素
	public void delete(int index){
		if(index < 0 || index > elements.length - 1){
			throw new RuntimeException("删除元素时下标越界！");
		}
		//创建一个新数组，长度为原数组长度-1
		int[] newArray = new int[elements.length - 1];
		//遍历新数组，删除下标之前的元素正常拷贝到新数组，
		for(int i=0; i<newArray.length; i++){
			if(i < index){
				newArray[i] = elements[i];
			}else{
				newArray[i] = elements[i+1];
			}
		}
		//最后，将新数组的引用指向原数组
		elements = newArray;
	}
	
	//访问指定下标的元素
	public int get(int index){
		if(index < 0 || index > elements.length - 1){
			throw new RuntimeException("访问下标越界！");
		}
		return elements[index];
		
	}
	// 插入一个元素到指定位置
	public void insert(int index, int element){
		if(index < 0 || index > elements.length - 1){
			throw new RuntimeException("插入时下标越界！");
		}
		int[] newArray = new int[elements.length + 1];
		for(int i=0; i<elements.length; i++){
			if(i < index){
				newArray[i] = elements[i];
			}else{
				newArray[i+1] = elements[i];
			}
		}
		//最后插入新元素到指定位置
		newArray[index] = element;
		elements = newArray;
	}
	// 替换指定位置的元素
	public void set(int index, int element){
		if(index < 0 || index > elements.length - 1){
			throw new RuntimeException("要替换的下标越界！");
		}
		elements[index] = element;
	}
	
	
	//获取数组的大小
	public int size(){
		return elements.length;
	}
	
	
	//打印数组
	public void show(){
		System.out.println(Arrays.toString(elements));
	}
	
	//线性查找
	public int search(int target){
		int index = -1;
		for(int i=0; i<elements.length; i++){
			if(elements[i] == target){
				index = i;
				return index;
			}
		}
		return index;
	}
	
	//针对有序数组，使用二分法查找
	public int binarySearch(int target){
		//记录开始位置
		int begin = 0;
		//记录结束位置
		int end = elements.length - 1;
		//记录中间位置
		int mid = (begin + end) / 2;
		while(true){
			if(begin > end){
				break;
			}
			//刚好中间位置的就是目标元素
			if(target == elements[mid]){
				return mid;
			}else{
				if(elements[mid] > target){//左边
					end = mid - 1;
				}else{
					begin = mid + 1;
				}
			}
			//中间位置每次后都是变化的,取出新的中间位置
			mid = (begin + end) / 2;
		}
		return -1;//没有找到
		
	}
	
	
	
	
}
