package com.jvm.reflect;

import org.junit.Assert;
import org.junit.Test;

import com.util.ReflectUtils;

public class ReflectTest {

    @Test
    public void testNewInstance() {
        Object object = ReflectUtils.newInstance("com.mengdd.reflect.Example");

        Assert.assertNotNull(object);

    }

    @Test
    public void testGetConstructorInfo() {
        String result = ReflectUtils
                .getPublicConstructorInfo("com.mengdd.reflect.Example");

        System.out
                .println("=============testGetConstructorInfo================");
        System.out.println(result);
        System.out
                .println("===================================================");

        Assert.assertNotNull(result);

    }

    @Test
    public void testFieldInfos() {
        String result = ReflectUtils
                .getDecleardFieldInfo("com.mengdd.reflect.Example");

        System.out.println("=============testFieldInfos================");
        System.out.println(result);
        System.out
                .println("===================================================");

        Assert.assertNotNull(result);
    }

    @Test
    public void testMethodInfos() {
        String result = ReflectUtils
                .getDeclaredMethodInfos("com.mengdd.reflect.Example");

        System.out.println("=============testMethodInfos================");
        System.out.println(result);
        System.out
                .println("===================================================");

        Assert.assertNotNull(result);
    }

    @Test
    public void testPublicStaticInvocation() {
        System.out
                .println("=============test static invocation================");

        try {

            // 静态方法1
            ReflectUtils.invokePublicStaticMethod("com.mengdd.reflect.Example",
                    "printSomething", new Class<?>[] { String.class },
                    new Object[] { "Hello World" });

            // 静态方法2
            Object result1 = ReflectUtils.invokePublicStaticMethod(
                    "com.mengdd.reflect.Example", "add", new Class<?>[] {
                            int.class, Integer.TYPE }, new Object[] { 1, 2 });

            // int.class和Integer.TYPE都行

            Assert.assertEquals(3, result1);

            // 静态方法3
            Object result2 = ReflectUtils.invokePublicStaticMethod(
                    "com.mengdd.reflect.Example", "getPi", new Class<?>[] {},
                    new Object[] {});

            Assert.assertEquals(3.14159, result2);

        }
        catch (Exception e) {
            e.printStackTrace();

            System.out.println("Exception!");
        }

        System.out
                .println("===================================================");
    }

    @Test
    public void testPrivateInvocation() {
        Example example = new Example("1", 5, 0);
        Object secret = null;
        try {
            secret = ReflectUtils.invokePrivateMethod(example, "tellSecret",
                    new Class<?>[] { String.class, Integer.TYPE },
                    new Object[] { "Hello", 2 });
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        String expected = "Hello2Example [mFiledOne=1, mCount=5]";

        Assert.assertEquals(expected, secret);
    }
}

