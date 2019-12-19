package com.jvm.classLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.cnblogs.com/zhengbin/p/5631987.html#_label0
 * @author B
 *
 */
public class ClassLoaderTest {

	public static void main(String[] args) throws ClassNotFoundException {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		Class<?> loadClass = loader.loadClass("com.classLoader.son");
		getSuperClass1(loadClass);
//		System.out.println(loadClass.getSuperclass());;
//		System.out.println(loadClass.getSuperclass().getSimpleName());;
//		System.out.println(loadClass.getSimpleName());;
////		System.out.println(loadClass.getClassLoader());;
////		System.out.println(loadClass.getClassLoader().getParent());;
//		System.out.println();
//		System.out.println();
//		System.out.println();
//		System.out.println("current loader:"+loader);
//		System.out.println("parent loader:"+loader.getParent());
//		System.out.println("grandparent loader:"+loader.getParent().getParent());
//		
//		/**
//		 * out:
//		 * 
//		 *  current loader:sun.misc.Launcher$AppClassLoader@73d16e93
//			parent loader:sun.misc.Launcher$ExtClassLoader@15db9742
//			grandparent loader:null 因为根类装载器在java访问不到，所有返回null
//		 * 
//		 */
		
	}
	
	/**
     * 获取这个类的所有父类
     * @param clazz
     * @return
     */
    public static List<Class<?>> getSuperClass1(Class<?> clazz){
        List<Class<?>> clazzs=new ArrayList<Class<?>>();
        Class<?> suCl=clazz.getSuperclass();
        while(suCl!=null){
            System.out.println(suCl.getName());
            clazzs.add(suCl);
            suCl=suCl.getSuperclass();
        }
        return clazzs;
    }
}
