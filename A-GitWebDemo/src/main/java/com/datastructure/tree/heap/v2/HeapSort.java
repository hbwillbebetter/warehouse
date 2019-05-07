package com.datastructure.tree.heap.v2;

public class HeapSort {

	//构建大根堆，将array看做二叉树的顺序存储结构
	public int[] buildMaxHeap(int[] array) {
		//从最后一个节点array.length-1的父节点（array.length-1-1)/2开始，直到根节点，反复调整堆
		int count = 0;
		for(int i=(array.length-1-1)/2; i>=0; i--){
			adjustUpToDown(array,i,array.length);
			count++;
			System.out.print("构建过程,第"+count+"次：");
			display(array);
		}
		return array;
	}
	
	//根/双亲节点自上向下调整
	private void adjustUpToDown(int[] array, int index, int length) {
		//保留待调整双亲节点的值
		int temp = array[index];
		//双亲节点最大的子节点下标
		int max = index;
		//双亲节点的左子节点
		int left = 2 * index + 1;
		//双亲节点的右子节点
		int right = 2 * index + 2;
		//获取最大的子节点下标
		if(left < length && array[left] > array[max]){
			max = left;
		}
		if(right < length && array[right] > array[max]){
			max = right;
		}
		while (max != index) {//找到需要与之调整的子节点；（如果max=index：表明当前节点index已经比它的左右子节点值都要大，满足堆的性质，无需调整了。）
			//循环跳出条件:不需调整，则跳出循环
			if(array[max] <= temp){
				break;
			}
			//子节点最大的值替换双亲节点
			array[index] = array[max];
			//原双亲节点的指针移向下一个双亲节点largeChildIndex
			index = max;
			//被调整的值放入最终位置
			array[index] = temp;
			//双亲节点的左子节点
			left = 2 * index + 1;
			//双亲节点的右子节点
			right = 2 * index + 2;
			if(right >= length){
				break;
			}
			//获取最大的子节点下标
			if(left < length && array[left] > array[max]){
				max = left;
			}
			if(right < length && array[right] > array[max]){
				max = right;
			}
		}
		
	}

	//打印数组元素
	public void display(int[] array) {
		for(int i: array){
			System.out.print(i+" ");
		}
		System.out.println();
	}
	
	
	//删除堆顶元素
	public int[] deleteMax(int[] array) {
		if(array.length < 1){
			throw new RuntimeException("数组为空，不能删除堆顶元素!");
		}
		int[] newArray = new int[array.length - 1];
		//将堆的最后一个元素替换到堆顶元素，数组长度建一
		array[0] = array[array.length - 1];
		
		for(int i=0; i<newArray.length; i++){
			newArray[i] = array[i];
		}
		array = newArray;
		if(array.length > 0){
			//对此时的根节点进行向下调整
			adjustUpToDown(array, 0, array.length);
		}
		return array;
	}

	//向大根堆插入数据---子节点自下向上调整
	public int[] insert(int[] array, int data) {
		int[] newArray = new int[array.length + 1];
		for(int i=0; i<array.length; i++){
			newArray[i] = array[i];
		}
		//数据插入大根堆的最后
		newArray[array.length] = data;
		array = newArray;
		//需要调整节点的位置
		int k = array.length - 1;
		//双亲节点
		int parent = (k - 1) / 2;
		while(k >0 && data > array[parent]){
			//双亲节点下调
			array[k] = array[parent];
			//待调整的位置执行双亲节点
			k = parent;
			//同时计算下一个parent的位置
			parent = (parent - 1) / 2;
			
		}
		array[k] = data;
		return array;
	}
	
	//堆排序
	public void heapSort(int[] array) {
		array = buildMaxHeap(array);//构建堆完毕后，堆顶即为最大元素
		for(int i=array.length-1; i>0; i--){
			//将堆顶、堆底元素互换,即得到当前最大元素正确的排序位置
			int temp = array[0];
			array[0] = array[i];
			array[i] = temp;
			adjustUpToDown(array, 0, i);//整理，剩余的元素整理成堆
			System.out.print("堆排序过程：");
			display(array);
		}
	}
	
	

}
