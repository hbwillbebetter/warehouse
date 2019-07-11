package com.callback.v1;

/**
 * 与中国电信合作的sp实现此接口即可
 * @author B
 *
 */
public interface ServiceProvider {

	/**
	 * sp可以自定义提示
	 */
	public void customHint();
}
