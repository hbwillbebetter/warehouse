package com.jvm.v1.string;

public class _1String_intern {

	public static void main(String[] args) {
		String s1 = "Hello";
		String s2 = "Hello";
		String s3 = "Hel" + "lo";
		String s4 = "Hel" + new String("lo");
//		String s4 = ("Hel" + new String("lo")).intern();
		String s5 = new String("Hello");
		String s6 = s5.intern();
		String s7 = "H";
		String s8 = "ello";
		String s9 = s7 + s8;
		          
		System.out.println(s1 == s2);  // true
		System.out.println(s1 == s3);  // true
		System.out.println(s1 == s4);  // false
		System.out.println(s1 == s9);  // false
		System.out.println(s4 == s5);  // false
		System.out.println(s1 == s6);  // true--字符串常量池--相等--引用相同
		System.out.println(s5 == s6);  // false--对象引用和字符串常量池引用不同
//		System.out.println(s1 == s6);  // true
	}

}
