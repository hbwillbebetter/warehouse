package com.jvm.v1;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * created by: gaoxingliang@outlook.com
 * created:2016年3月20日
 */

/**
 * 参考网址：https://blog.csdn.net/scugxl/article/details/50935863
 * java -XX:+UseSerialGC -Xms200M -Xmx200M -Xmn32m -XX:SurvivorRatio=8 -XX:+PrintGCDetails -XX:MaxPermSize=10M - jar .\gc.jar
 * 
 * -XX:+UseSerialGC -Xms200M -Xmx200M -Xmn32m -XX:SurvivorRatio=8 -XX:+PrintGCDetails -XX:MaxPermSize=10M
 * @author gxl
 *
 */
//方式 在jdk6 上:
public class _3SimulateFullGc
{
    public static void main(String[] args)
    {
        //模拟fullgc场景
        //持久代空间不足
        List<String> list = new ArrayList<String>();
        int i = 0;
        while (true)
        {
            list.add(String.valueOf("ABCD:"  + i ++).intern());
        }
    }
}
