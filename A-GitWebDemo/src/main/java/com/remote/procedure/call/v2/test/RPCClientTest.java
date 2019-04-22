package com.remote.procedure.call.v2.test;

import java.net.InetSocketAddress;

import com.remote.procedure.call.v2.client.Client;
import com.remote.procedure.call.v2.server.HelloService;

public class RPCClientTest {
	public static void main(String[] args) throws ClassNotFoundException {
		HelloService service = Client.getRemoteProxyObj(
				Class.forName("com.remote.procedure.call.v2.server.HelloService" ) , 
				new InetSocketAddress("127.0.0.1", 9999)) ;
		System.out.println( service.sayHi("zs")  ) ;
	}
}
