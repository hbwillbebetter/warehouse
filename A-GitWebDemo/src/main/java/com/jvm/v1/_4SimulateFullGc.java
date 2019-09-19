package com.jvm.v1;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * 
 * created by: gaoxingliang@outlook.com
 * created:2016年3月20日
 */

/**
 * java -XX:+UseSerialGC -Xms200M -Xmx200M -Xmn32m -XX:SurvivorRatio=8 -XX:+PrintGCDetails -XX:MaxPermSize=10M - jar .\gc.jar
 * 
 * -XX:+UseSerialGC -Xms200M -Xmx200M -Xmn32m -XX:SurvivorRatio=8 -XX:+PrintGCDetails -XX:MaxPermSize=10M
 * @author gxl
 *
 */
/**
 * 承接上文：
 * String.intern 会拷贝实例到永久代中.
 * 
 * 在jdk1.7 不会,所以可以加载class来模拟:
 *
 */
public class _4SimulateFullGc
{
    public static void main(String[] args)
    {
        //模拟fullgc场景
        //持久代空间不足
        //class 加载信息
        //需要cglib + asm (http://forge.ow2.org/projects/asm/)
        while (true)
        {
            Enhancer en = new Enhancer();
            en.setSuperclass(OOMObject.class);
            en.setUseCache(false);
            en.setCallback(new MethodInterceptor()
            {

                @Override
                public Object intercept(Object arg0, Method arg1, Object[] arg2,
                        MethodProxy arg3) throws Throwable
                {
                    // TODO Auto-generated method stub
                    return null;
                }
            });
            en.create();
        }
    }
    static class OOMObject
    {

    }
}
