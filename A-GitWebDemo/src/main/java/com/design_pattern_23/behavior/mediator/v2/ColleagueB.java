package com.design_pattern_23.behavior.mediator.v2;

/**
 * 具体同事类B
 *
 */
public class ColleagueB extends AbstractColleague{  
  
    @Override  
    public void setNumber(int number, AbstractMediator am) {  
        this.number = number;  
        am.BaffectA();  
    }  
} 