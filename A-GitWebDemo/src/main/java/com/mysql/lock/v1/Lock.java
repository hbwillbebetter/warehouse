package com.mysql.lock.v1;

public interface Lock {
	//获取锁资源
	void getLock();
	//等待
	void waitLock();
	//释放锁
	void unLock();
}
