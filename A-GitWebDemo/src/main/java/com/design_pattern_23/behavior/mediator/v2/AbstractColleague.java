package com.design_pattern_23.behavior.mediator.v2;

/**
 * 抽象同事类
 * @author B
 *
 */
public abstract class AbstractColleague {  
    protected int number;  
  
    public int getNumber() {  
        return number;  
    }  
  
    public void setNumber(int number){  
        this.number = number;  
    }  
    //注意这里的参数不再是同事类，而是一个中介者  
    public abstract void setNumber(int number, AbstractMediator am);  
} 