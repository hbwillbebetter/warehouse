package com.remote.procedure.call.v2.server;

public class HelloServiceImpl implements HelloService {

	@Override
	public String sayHi(String name) {
		return "hi,"+name ;
	}

}
