package com.datastructure.tree.heap.v1;

public class Heap {
	private Node[] heapArray;
	private int maxSize;
	private int currentSize;
	
	public Heap(int max){
		this.maxSize = max;
		currentSize = 0;
		heapArray = new Node[this.maxSize];
	}
	
	public boolean isEmpty() {
        return (currentSize == 0)? true : false;
    }
     
    public boolean isFull() {
        return (currentSize == maxSize)? true : false;
    }
    
    public boolean insert(int key){
    	if(isFull()){
    		return false;
    	}
    	//新插入一个节点，对应索引编号currentSize
    	Node newNode = new Node(key);
    	heapArray[currentSize] = newNode;
    	adjustUp(currentSize++);
    	return true;
    }
    
    //插入数据，向上调整
    private void adjustUp(int index) {
    	int parent = (index-1)/2;
    	//保留index值到bottom中
    	Node bottom = heapArray[index];
    	//循环向上调整
    	while (index > 0 && bottom.getData() > heapArray[parent].getData()) {//循环调整的条件，index > 0(不能无限调整下去) && 插入新值大于父节点就做调整
			//子节点值替换为父节点值
    		heapArray[index] = heapArray[parent];
    		//循环调整index的位置
    		index = parent;
    		//调整index后，parent位置重新计算
    		parent = (parent - 1) / 2;
		}
    	//前面调整完毕，再将保留的bottom赋给index位置节点
    	heapArray[index] = bottom;
	}
    
    public Node remove(){
    	Node root = heapArray[0];
    	//将数组最后一个节点放置数组第一个
    	heapArray[0] = heapArray[--currentSize];
    	adjustDown(0);
    	return root;
    }
    
    //删除根节点，向下调整
	public void adjustDown(int index) {
		Node top = heapArray[index];
		int largeChildIndex;
		/**
		 * 堆的定义：n个关键字序列array[0，...，n-1]，当且仅当满足下列要求：(0 <= i <= (n-1)/2)
　　　　　　① array[i] <= array[2*i + 1] 且 array[i] <= array[2*i + 2]； 称为小根堆；
　　　　　　② array[i] >= array[2*i + 1] 且 array[i] >= array[2*i + 2]； 称为大根堆；
		 */
		//循环向下调整,而且是根节点和最大权值的子节点（前面非叶子节点，最后一次是叶子节点）调整，所有循环条件是:index < currentSize/2
		while(index < (currentSize+1 - 1)/2){//while node has at least one child ????????????????????
			int leftChildIndex = 2 * index + 1;
			int rightChildIndex = 2 * index + 2;
			//find large child
			/**
			 *TODO 这段代码是有问题的
			 */
			if(rightChildIndex < currentSize && //rightChild exists? ??????????????????????
					heapArray[leftChildIndex].getData() < heapArray[rightChildIndex].getData() ){
				largeChildIndex = rightChildIndex;
			}else{
				largeChildIndex = leftChildIndex;
			}
			//待调整的权值<子节点最大索引的权值，继续调整，否则：终止循环
			if(top.getData() >= heapArray[largeChildIndex].getData()){
				break;
			}
			//如果largeChildIndex的权值 > 变量index（循环关键变量）位置权值，则将largeChildIndex权值赋给index位置
			heapArray[index] = heapArray[largeChildIndex];
			index = largeChildIndex;//index位置调整
		}
		//最后一次调整
		heapArray[index] = top;
	}

	public void displayHeap(){
    	for(int i=0; i<currentSize; i++){
    		System.out.print(heapArray[i].getData()+" ");
    	}
    	System.out.println();
    }

}
