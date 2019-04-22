package com.remote.procedure.call.v1.test;

import com.remote.procedure.call.v1.server.HelloService;
import com.remote.procedure.call.v1.server.HelloServiceImpl;
import com.remote.procedure.call.v1.server.Server;
import com.remote.procedure.call.v1.server.ServiceCenter;

public class RPCServerTest {
	public static void main(String[] args) throws Exception {
		Server server = new ServiceCenter(9999);
		server.register(HelloService.class, HelloServiceImpl.class);
		server.start();
	}
}
