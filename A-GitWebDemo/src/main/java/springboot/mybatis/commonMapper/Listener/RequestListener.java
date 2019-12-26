package springboot.mybatis.commonMapper.Listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
/**
 * 3、Servlet3.0的注解自定义原生Listener监听器实战
        简介：监听器介绍和Servlet3.0的注解自定义原生Listener监听器实战

        1、自定义Listener(常用的监听器 servletContextListener、httpSessionListener、servletRequestListener)
            @WebListener
            public class RequestListener implements ServletRequestListener {

            @Override
            public void requestDestroyed(ServletRequestEvent sre) {
                // TODO Auto-generated method stub
                System.out.println("======requestDestroyed========");
            }

            @Override
            public void requestInitialized(ServletRequestEvent sre) {
                System.out.println("======requestInitialized========");
                
            }
 *
 */
@WebListener
public class RequestListener implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
		System.out.println("=======requestDestroyed=======");
	}

	@Override
	public void requestInitialized(ServletRequestEvent arg0) {
		System.out.println("=======requestInitialized=======");
		
	}

}
