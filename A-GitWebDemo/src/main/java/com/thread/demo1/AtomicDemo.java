package com.thread.demo1;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 原子类 具有原子性，但两个原子类的方法之间不具备原子性
 * 
 * @author dingyu
 *
 */
public class AtomicDemo {
    private AtomicInteger count = new AtomicInteger();

    public void m1() {
        for (int i = 0; i < 100; i++) {            
            count.incrementAndGet();
            //两个原子类的方法之间不具备原子性
            count.incrementAndGet();
        
        }
    }
}