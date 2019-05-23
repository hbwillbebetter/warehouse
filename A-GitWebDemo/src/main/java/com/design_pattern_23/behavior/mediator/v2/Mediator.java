package com.design_pattern_23.behavior.mediator.v2;

/**
 * 具体中介者实现类
 *
 */
public class Mediator extends AbstractMediator {  
  
    public Mediator(AbstractColleague a, AbstractColleague b) {  
        super(a, b);  
    }  
  
    //处理A对B的影响  
    public void AaffectB() {  
        int number = A.getNumber();  
        B.setNumber(number*100);  
    }  
  
    //处理B对A的影响  
    public void BaffectA() {  
        int number = B.getNumber();
        A.setNumber(number/100);  
    }  
}  