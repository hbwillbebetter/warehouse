package com.shell;

import java.util.ArrayList;
import java.util.List;


public class StartUpShell {
	private static String dirDir;//应用目录
	private static String shellDir;//shell脚本目录
	private static List<Integer> ports = new ArrayList<Integer>();
	private static String command;

	static{
		//redis-集群
		//应用目录
		dirDir = "/home/app/redis/redis-cluster";
		//脚本目录
		shellDir = "/home/app/redis/redis-cluster/script";
		//执行端口
		int startPort = 7001;
		int endPort = 7006;
		for (int i = startPort; i <= endPort; i++) {
			ports.add(i);
		}
		
		
		
	}
	public static void main(String[] args) {
		
		//启动命令所在位置
		//start.sh--启动脚本
		command = "/home/app/redis/redis-cluster/src/redis-server";
		start();
		
		
		//stop.sh---停止脚本
		command = "/home/app/redis/redis-cluster/src/redis-server";
		stop();
		
		
		//restart.sh--自动重启
		command = "/home/app/redis/redis-cluster/src/redis-server";
		restart();
		
		
		//client.sh--客户端连接
		command = "/home/app/redis/redis-cluster/src/redis-server";
		Client();
		
		
		
	}

	private static void Client() {
		// TODO Auto-generated method stub
		
	}

	private static void restart() {
		// TODO Auto-generated method stub
		
	}

	private static void stop() {
		// TODO Auto-generated method stub
		
	}

	private static void start() {
		
	}

}
