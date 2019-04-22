package com.remote.procedure.call.v1.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class ServiceCenter implements Server {
	
	private int port;
	public static final HashMap<String, Class> serviceRegiser = new HashMap<>();
	
	public ServiceCenter(int port) {
		this.port = port;
	}

	@Override
	public void start() throws Exception {
		try {
			ServerSocket server = new ServerSocket();
			server.bind(new InetSocketAddress(port));
			System.out.println("server is running！");
			Socket socket = server.accept();//等待客户端连接...
			ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
			//严格接收客户端传递来的参数
			String serviceName = input.readUTF();
			System.out.println("服务器端接收-"+serviceName);
			String methodName = input.readUTF();
			System.out.println("服务器端接收-"+methodName);
			Class[] parameterTypes = (Class[]) input.readObject();
			System.out.println("服务器端接收-"+parameterTypes.toString());
			Object[] args = (Object[]) input.readObject();
			System.out.println("服务器端接收-"+args.toString());
			//根据客户提供的接口，在map中找到与之对应的具体接口
			Class serviceClass = serviceRegiser.get(serviceName);
			//找到具体接口后，执行指定方法，如果有返回值，则将返回值发送给客户端
			Method method = serviceClass.getMethod(methodName, parameterTypes);
			Object result = method.invoke(serviceClass.newInstance(), args);
			//将返回值发送客户端
			ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
			output.writeObject(result);
			Thread.sleep(600000);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}

	@Override
	public void register(Class service, Class serviceImpl) {
		serviceRegiser.put(service.getName(), serviceImpl);
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}
	
}
