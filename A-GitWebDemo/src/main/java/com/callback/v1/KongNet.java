package com.callback.v1;

/**
 * 详解Java回调机制 (Callback) 讲解+实例
 * http://www.ej38.com/showinfo/java-197426.html
 * 
 * java回调函数，看完就懂
 * https://www.cnblogs.com/yangmin86/p/7090882.html
 * @author B
 *
 */

public class KongNet implements ServiceProvider {

	@Override
	public void customHint() {
		System.out.println("优惠活动已经开启，即日起登录空中网就有好礼送！详情见网站公告。");
	}
	
	public void init(){
		ChinaTelecom ct = new ChinaTelecom();
		ct.setSp(this);//告诉ChinaTelecom这是哪家sp
		ct.init();
	}
	
	public static void main(String[] args) {
		KongNet sp = new KongNet();
		sp.init();
	}

}
