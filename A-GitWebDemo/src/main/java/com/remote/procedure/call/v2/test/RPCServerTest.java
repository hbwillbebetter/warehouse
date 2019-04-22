package com.remote.procedure.call.v2.test;
import com.remote.procedure.call.v2.server.HelloService;
import com.remote.procedure.call.v2.server.HelloServiceImpl;
import com.remote.procedure.call.v2.server.Server;
import com.remote.procedure.call.v2.server.ServerCenter;
public class RPCServerTest {
	public static void main(String[] args) {
		//开启一个线程
		new Thread(new Runnable() {
			@Override
			public void run() {
				//服务中心
				Server server = new ServerCenter(9999);
				//将HelloService接口及实现类 注册到 服务中心
				server.register(HelloService.class, HelloServiceImpl.class);
				server.start(); 
			}
		}).start();//start()
	}
}
