package com.mysql.lock.v1.service;

import com.mysql.lock.v1.AbstractLock;

public class MysqlLock extends AbstractLock {

//	private LockMapper mapper;
	
	//所有的线程都往数据库插入主键值相同的数据
	private static final int LOCK_ID = 1;
	
	
	//非阻塞式加锁
	public boolean tryLock() {
		try {
//			mapper.insert(LOCK_ID);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	//让当前线程睡眠一段时间
	public void waitLock() {
		try {
			Thread.currentThread().sleep(10);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//释放锁
	public void unLock(){
//		maper.deleteByPrimaryKey(LOCK_ID);
	}
	
	

}
