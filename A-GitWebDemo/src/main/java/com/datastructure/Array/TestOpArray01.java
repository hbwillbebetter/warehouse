package com.datastructure.Array;

import com.util.MyArray;

public class TestOpArray01 {

	public static void main(String[] args) {
		MyArray array = new MyArray();
//		array.remove(1);
		System.out.println(array.size());
		array.show();
		array.add(1);
		array.add(2);
		array.add(3);
		array.add(4);
		array.show();
		System.out.println(array.size());
		System.out.println(array.get(0));
		array.insert(2, 10);
		array.show();
		array.set(3, 8);
		array.show();
		System.out.println(array.search(4));
		array = new MyArray();
		array.add(1);
		array.add(2);
		array.add(3);
		array.add(4);
		array.add(5);
		array.add(6);
		array.add(7);
		array.add(8);
		array.show();
		System.out.println(array.binarySearch(5));
	}

}
