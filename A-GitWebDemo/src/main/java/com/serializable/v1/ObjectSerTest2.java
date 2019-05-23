package com.serializable.v1;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 参考：https://bbs.csdn.net/topics/390155251/
 * 先执行ObjectSerTest1类型
 * 再执行（ObjectSerTest2）本类，即可以证明--static 成员属性count，是不能被序列化的
 * @author B
 *
 */
public class ObjectSerTest2{


	
	public static void main(String args[]){
		
		try {

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