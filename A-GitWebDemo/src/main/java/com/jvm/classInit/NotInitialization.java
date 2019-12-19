package com.jvm.classInit;

/**
 * https://www.cnblogs.com/ITtangtang/p/3978102.html
 * @author B
 *
 */
public class NotInitialization {

	public static void main(String[] args) {
		//以下均是被动引用
		/***
		 * 1.对于静态字段，只有直接定义这个字段的类才会被初始化,因此，通过子类来调用父类的静态字段，
		 * 只会触发父类的初始化,但是这是要看不同的虚拟机的不同实现。
		 * 
		 */
//		System.out.println(SubClass.value);
		/**
		 * 2.此处不会引起SuperClass的初始化，但是却触发了【[Ltest.SuperClass】的初始化，
		 * 通过arr.toString()可以看出，对于用户代码来说，这不是一个合法的类名称，它是由虚拟机自动生成的，
		 * 直接继承于Object的子类，创建动作由字节码指令newarray触发,此时数组越界检查也会伴随数组对象的所有调用过程，
		 * 越界检查并不是封装在数组元素访问的类中，而是封装在数组访问的xaload,xastore字节码指令中.
		 */
//		SuperClass[] arr = new SuperClass[10];
//		System.out.println(arr.toString());
		/***
		 * 3.对常量ConstClass.value 的引用实际都被转化为NotInitialization类对自身常量池的引用，
		 * 这两个类被编译成class后不存在任何联系。
		 */
		System.out.println(ConstClass.value);
	}
	
}
class ConstClass {
	static {
		System.out.println("---ConstClass init");
	}
	public static final String value = "hello world";
}

class SuperClass {
	static {
		System.out.println("---SuperClass init");
	}
	public static int value = 123;
}
class SubClass extends SuperClass {
	static {
		System.out.println("---SubClass init");
	}
//	public static int value = 20;
}
