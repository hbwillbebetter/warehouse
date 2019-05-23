package com.design_pattern_23.behavior.mediator.v2;

/**
 * 抽象中介者类
 * @author B
 *
 */
public abstract class AbstractMediator {
	
    protected AbstractColleague A;  
    protected AbstractColleague B;  
      
    public AbstractMediator(AbstractColleague a, AbstractColleague b) {  
        A = a;  
        B = b;  
    }  
  
    public abstract void AaffectB();  
      
    public abstract void BaffectA();  
  
}  