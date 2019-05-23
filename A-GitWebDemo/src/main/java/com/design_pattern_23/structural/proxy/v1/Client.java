package com.design_pattern_23.structural.proxy.v1;

public class Client {
	/**
	 * 　在代理模式中的角色：

　　●　　抽象对象角色：声明了目标对象和代理对象的共同接口，这样一来在任何可以使用目标对象的地方都可以使用代理对象。

　　●　　目标对象角色：定义了代理对象所代表的目标对象。

　　●　　代理对象角色：代理对象内部含有目标对象的引用，从而可以在任何时候操作目标对象；代理对象提供一个与目标对象相同的接口，
	       以便可以在任何时候替代目标对象。代理对象通常在客户端调用传递给目标对象之前或之后，执行某个操作，而不是单纯地将调用传递给目标对象。
	 * 
	 * 从上面的例子可以看出代理对象将客户端的调用委派给目标对象，在调用目标对象的方法之前跟之后都可以执行特定的操作。
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		AbstractObject obj = new ProxyObject();
		obj.operation();
		
	}
	
}
