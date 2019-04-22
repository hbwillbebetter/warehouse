package com.remote.procedure.call.v1.client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {
	
	@SuppressWarnings("unchecked")
	public static <T> T getRemoteProxyObj(Class serviceInterface, InetSocketAddress address){
		
		return (T) Proxy.newProxyInstance(serviceInterface.getClassLoader(), new Class<?>[]{serviceInterface}, new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				Socket socket = new Socket();
				socket.connect(address);
				//发送序列化流
				ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
				//接口名、方法名、参数类型、参数列表
				output.writeUTF(serviceInterface.getName());
				System.out.println("客户端发送:"+serviceInterface.getName());
				output.writeUTF(method.getName());
				System.out.println("客户端发送:"+method.getName());
				output.writeObject(method.getParameterTypes());
				System.out.println("客户端发送:"+method.getParameterTypes().toString());
				output.writeObject(args);
				System.out.println("客户端发送:"+args.toString());
				//等待服务器端处理...
				ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
				Object result = input.readObject();
				return result;
			}
		});
		
		
		
	}
}
