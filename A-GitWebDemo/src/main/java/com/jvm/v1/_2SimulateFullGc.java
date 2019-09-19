package com.jvm.v1;
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
public class _2SimulateFullGc
{
    public static void main(String[] args)
    {
        //模拟fullgc场景
        //老年代空间不足
        //按照上面的参数推算:老年代大小: 200 -32m = 168M


        byte [] MAXOBJ = new byte [1024 * 1024 * 100]; // 100M

        byte [] MAXOBJ2 = new byte [1024 * 1024 * 70]; // 60M
        MAXOBJ = null;

        byte [] MAXOBJ3 = new byte [1024 * 1024 * 100]; // 60M
    }
}
