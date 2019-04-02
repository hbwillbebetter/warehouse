package com.design_pattern_23.structural.decorator.v1;

public class DecoratorMain {

	public static void main(String[] args) {
		//先创建一个简单的Cake Base
		CakeBase cakeBase = new CakeBase();
		Util.printProductDetails(cakeBase);
		
		//在蛋糕上添加奶油
		CreamDecorator creamCake = new CreamDecorator(cakeBase);
		Util.printProductDetails(creamCake);
		
		//在蛋糕上添加樱桃
		CherryDecorator cherryCake = new CherryDecorator(creamCake);
		Util.printProductDetails(cherryCake);
		
		//再添加香味
		ArtificialScentDecorator scentCake = new ArtificialScentDecorator(cherryCake);
		Util.printProductDetails(scentCake);
		
		//最后在蛋糕上添加名片
		NameCardDecorator nameCardCake = new NameCardDecorator(scentCake);
		Util.printProductDetails(nameCardCake);
		
		System.out.println("**************************");
		
		//糕点
		PastryBase pastryBase = new PastryBase();
		Util.printProductDetails(pastryBase);
		
		//在糕点上添加奶油和樱桃
		CreamDecorator creamPastry = new CreamDecorator(pastryBase);
		CherryDecorator cherryPastry = new CherryDecorator(creamPastry);
		Util.printProductDetails(cherryPastry);
		
		
	}

}
