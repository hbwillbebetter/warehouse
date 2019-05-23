package com.serializable.v1;

import java.io.*;

/**
 * 参考：https://bbs.csdn.net/topics/390155251/
 * 静态成员属于类级别的，所以不能序列化
这里的不能序列化的意思，是序列化信息中不包含这个静态成员域
你这个测试成功，是因为你都在同一个机器（而且是同一个进程），因为你这个jvm已经把count加载进来了，
所以你获取的是加载好的count，如果你是传到另一台机器或者你关掉程序重写写个程序读入test.obj，
此时因为别的机器或新的进程是重新加载count的，所以count信息就是初始时的信息。
 * @author B
 *
 */
class Student1 implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private transient String password;
	/**
	 * 流(FileInputStream)未实现Serializable接口，那么不能被序列化和反序列化，java.io.NotSerializableException: java.io.FileInputStream;
	 * 如果想序列化和反序列化，此属性必须注释为transient,则跳过此属性
	 */
	private FileInputStream fis;
	private static int count = 0;

	public Student1(String name, String password) {
		try {
			fis = new FileInputStream("readme.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("调用Student的带参的构造方法");
		this.name = name;
		this.password = password;
		count++;
	}

	public String toString() {
		return "人数: " + count + " 姓名: " + name + " 密码: " + password;
//		return "人数: " + count + " 姓名: " + name + " 密码: " + password+" fis: "+fis;
	}
}

public class ObjectSerTest1 {
	public static void main(String args[]) {
		try {

			FileOutputStream fos = new FileOutputStream("test.obj");
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			Student1 s1 = new Student1("张三", "12345");
			Student1 s2 = new Student1("王五", "54321");

			oos.writeObject(s1);
			oos.writeObject(s2);

			oos.close();

			FileInputStream fis = new FileInputStream("test.obj");
			ObjectInputStream ois = new ObjectInputStream(fis);

			Student1 s3 = (Student1) ois.readObject();
			Student1 s4 = (Student1) ois.readObject();

			System.out.println(s3);
			System.out.println(s4);

			ois.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
	}
}

