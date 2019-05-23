package com.design_pattern_23.behavior.mediator.v2;

/**
 * 使用中介者模式---客户端测试类
 * @author B
 *
 */
public class Client {  
    public static void main(String[] args){  
        AbstractColleague collA = new ColleagueA();  
        AbstractColleague collB = new ColleagueB();  
        
        //让中介者知道要调停的同事有谁：A和B
        AbstractMediator am = new Mediator(collA, collB);  
          
        System.out.println("==========通过设置A影响B==========");  
        /**
         * 先给A赋值，然后再让中介者调停它(A)和同事B的关系---也就是即A对B的影响（具体是：
         * 先拿到A的值，然后乘以100作为参数传给同事B，这样B也就拿到了自己的值）
         */
        collA.setNumber(1000, am);  
        System.out.println("collA的number值为："+collA.getNumber());  
        System.out.println("collB的number值为A的10倍："+collB.getNumber());  
  
        System.out.println("==========通过设置B影响A==========");  
        collB.setNumber(1000, am);  
        System.out.println("collB的number值为："+collB.getNumber());  
        System.out.println("collA的number值为B的0.1倍："+collA.getNumber());  
          
    }
    /**
     * 虽然代码比较长，但是还是比较容易理解的，其实就是把原来处理对象关系的代码重新封装到一个中介类中，通过这个中介类来处理对象间的关系。

	中介者模式的优点:
		1.适当地使用中介者模式可以避免同事类之间的过度耦合，使得各同事类之间可以相对独立地使用。
		2.使用中介者模式可以将对象间一对多的关联转变为一对一的关联，使对象间的关系易于理解和维护。
		3.使用中介者模式可以将对象的行为和协作进行抽象，能够比较灵活的处理对象间的相互作用。
	适用场景:
	       在面向对象编程中，一个类必然会与其他的类发生依赖关系，完全独立的类是没有意义的。一个类同时依赖多个类的情况也相当普遍，既然存在这样的情况，
	       说明，一对多的依赖关系有它的合理性，适当的使用中介者模式可以使原本凌乱的对象关系清晰，但是如果滥用，则可能会带来反的效果。
	       一般来说，只有对于那种同事类之间是网状结构的关系，才会考虑使用中介者模式。
	   
	       可以将网状结构变为星状结构，使同事类之间的关系变的清晰一些。
	       中介者模式是一种比较常用的模式，也是一种比较容易被滥用的模式。对于大多数的情况，同事类之间的关系不会复杂到混乱不堪的网状结构，
	       因此，大多数情况下，将对象间的依赖关系封装的同事类内部就可以的，没有必要非引入中介者模式。滥用中介者模式，只会让事情变的更复杂。
       
       
       
       
       
       
       
     */
    
}  