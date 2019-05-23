package com.design_pattern_23.behavior.mediator.v2;

/**
 * 具体同事类A
 *
 */
class ColleagueA extends AbstractColleague{  
  
    public void setNumber(int number, AbstractMediator am) {  
        this.number = number;  
        am.AaffectB();  
    }  
} 