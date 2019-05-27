package com.thread.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
/**
 * 	参考博客：http://www.importnew.com/24055.html--（源代码中文注释）
	参考：https://www.jianshu.com/p/28387056eeb4
 * 我们用一个很简单的例子说说condition的用法：
 * @author B
 *
 */
/**
 * 程序讲解：
 * 开启了两个线程waiter和signaler，waiter线程开始执行的时候由于条件不满足，执行condition.await方法使该线程进入等待状态同时释放锁，
 * signaler线程获取到锁之后更改条件，并通知所有的等待线程后释放锁。
 * 这时，waiter线程获取到锁，并由于signaler线程更改了条件此时相对于waiter来说条件满足，继续执行。
 *
 */
public class AwaitSignal {
    private static ReentrantLock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();
    private static volatile boolean flag = false;

    public static void main(String[] args) {
        Thread waiter = new Thread(new waiter());
        waiter.start();
        Thread signaler = new Thread(new signaler());
        signaler.start();
    }

    static class waiter implements Runnable {

        @Override
        public void run() {
            lock.lock();
            try {
                while (!flag) {
                    System.out.println(Thread.currentThread().getName() + "当前条件不满足等待");
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + "接收到通知条件满足");
            } finally {
                lock.unlock();
            }
        }
    }

    static class signaler implements Runnable {

        @Override
        public void run() {
            lock.lock();
            try {
                flag = true;
                condition.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }
}