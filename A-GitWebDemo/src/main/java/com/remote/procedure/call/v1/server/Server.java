package com.remote.procedure.call.v1.server;

public interface Server {
	public void start() throws Exception;//服务启动
	
	public void register(Class service, Class serviceImpl);//服务注册
	
	public void stop();//服务关闭
}
