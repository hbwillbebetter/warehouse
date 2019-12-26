package springboot.mybatis.commonMapper.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义Filter
使用servlet3.0的注解配置我们的自定义Filter
3、自定义Filter
            1）使用Servlet3.0的注解进行配置
            2）启动类里面增加 @ServletComponentScan，进行扫描
            3）新建一个Filter类，implements Filter，并实现对应的接口
            4) @WebFilter 标记一个类为filter，被spring进行扫描 
                urlPatterns：拦截规则，支持正则

            6）控制chain.doFilter的方法的调用，来实现是否通过放行
               不放行，web应用resp.sendRedirect("/index.html");
                场景：权限控制、用户登录(非前端后端分离场景)等
 *
 *	拦截器、过滤器两者的本质区别：拦截器（Interceptor）是基于Java的反射机制，而过滤器（Filter）是基于函数回调。
 *	从灵活性上说拦截器功能更强大些，Filter能做的事情，都能做，而且可以在请求前，请求后执行，比较灵活。
 *	Filter主要是针对URL地址做一个编码的事情、过滤掉没用的参数、安全校验（比较泛的，比如登录不登录之类），太细的话，还是建议用interceptor。
 *	不过还是根据不同情况选择合适的。
 *
 * @WebFilter是spring3.0的一个注解。
 * urlPatterns:要拦截的url。 /*是拦截所有的请求。这里配置的是/api/*拦截api开头的下面的所有请求。
 */
//@WebFilter(urlPatterns="/api/*", filterName="loginFilter")
public class LoginFilter implements Filter {
	/**
	 * 容器被销毁的时候调用
	 */
	@Override
	public void destroy() {
		System.out.println("destroy loginFilter");
		
	}

	/**
	 * 核心的处理业务的方法
	 * 请求被拦截的时候进行调用
	 */
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain filterChain) throws IOException, ServletException {
		System.out.println("doFilter loginFilter");
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String username = request.getParameter("username");
		if ("zs".equals(username)) {
			filterChain.doFilter(request, response);
		}else {
			response.sendRedirect("/index.html");//重定向页面 resources/static目录下面的静态页面
			return;//拦截
		}
		
	}
	/**
	 * 容器加载的时候调用
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("init loginFilter");
		
	}

}
