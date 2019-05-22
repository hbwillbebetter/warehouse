package com.mysql.lock.v1;


public abstract class AbstractLock implements Lock {
	
	//获取锁资源(模板方法)
	public void getLock(){
		if(tryLock()){
			System.out.println("##获取lock锁的资源##");
		}else {
			//等待
			waitLock();
			//重新获取锁资源
			getLock();
		}
	}
	

	//尝试获取锁资源
	public abstract boolean tryLock();

	//等待
	public abstract void waitLock();
}
