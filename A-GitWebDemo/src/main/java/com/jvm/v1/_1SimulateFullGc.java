package com.jvm.v1;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * created by: gaoxingliang@outlook.com
 * created:2016年3月20日
 */

/**
 * java -XX:+UseSerialGC -Xms200M -Xmx200M -Xmn32m -XX:SurvivorRatio=8 -XX:+PrintGCDetails - jar .\gc.jar
 * 
 * -XX:+UseSerialGC -Xms200M -Xmx200M -Xmn32m -XX:SurvivorRatio=8 -XX:+PrintGCDetails
 * @author gxl
 *
 */
public class _1SimulateFullGc
{
    public static void main(String[] args)
    {
        //模拟fullgc场景
        //场景1 使用System.gc
        List<Object> l = new ArrayList<Object>();
        for (int i =0; i< 100;i++)
        {
            l.add(new byte[1024*1024 ]);
            if (i % 10 ==0)
            {
                System.gc();
            }
        }

    }
}
