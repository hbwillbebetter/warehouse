package com.callback.v1;

/**
 * 中国电信
 * @author B
 *
 */
public class ChinaTelecom {

	private ServiceProvider sp;//callback接口作为属性
	
	public void setSp(ServiceProvider sp){
		this.sp = sp;
	}
	
	/**
	 * 初始化
	 */
	public void init(){
		System.out.println("Welcome,this is ChinaTelecom!");
//		System.out.println(this.getClass().getSimpleName()+"合作方:"+sp.getClass().getSimpleName());
		sp.customHint();
	}
	
}
