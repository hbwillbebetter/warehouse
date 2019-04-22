package com.remote.procedure.call.v1.test;

import java.net.InetSocketAddress;

import com.remote.procedure.call.v1.client.Client;
import com.remote.procedure.call.v1.server.HelloService;

public class RPCClientTest {
	public static void main(String[] args) throws ClassNotFoundException {
		HelloService remoteProxyObj = Client.getRemoteProxyObj(Class.forName("com.remote.procedure.call.v1.server.HelloService"), new InetSocketAddress("127.0.0.1", 9999));
		System.out.println(remoteProxyObj.sayHello("zs"));
	}
}
