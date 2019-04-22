package com.remote.procedure.call.v1.server;

public class HelloServiceImpl implements HelloService {

	@Override
	public String sayHello(String name) {
		return "hello:" + name;
	}

}
