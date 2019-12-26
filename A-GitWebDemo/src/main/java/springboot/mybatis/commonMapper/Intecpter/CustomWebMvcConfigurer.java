package springboot.mybatis.commonMapper.Intecpter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * https://www.cnblogs.com/wangjunwei/p/11421343.html
 * 笔记
、SpringBoot2.X自定义拦截器实战及新旧配置对比(核心知识)
    简介: 讲解拦截器使用，Spingboot2.x新版本配置拦截拦截器和旧版本SpringBoot配置拦截器区别讲解
    
    1、@Configuration
        继承WebMvcConfigurationAdapter(SpringBoot2.X之前旧版本)

        SpringBoot2.X 新版本配置拦截器 implements WebMvcConfigurer

    2、自定义拦截器 HandlerInterceptor
        preHandle：调用Controller某个方法之前
        postHandle：Controller之后调用，视图渲染之前，如果控制器Controller出现了异常，则不会执行此方法
        afterCompletion：不管有没有异常，这个afterCompletion都会被调用，用于资源清理
    
    3、按照注册顺序进行拦截，先注册，先被拦截

    拦截器不生效常见问题：
        1）是否有加@Configuration
        2）拦截路径是否有问题 **  和 * 
        3）拦截器最后路径一定要 “/**”， 如果是目录的话则是 /*/
/*
    Filter
        是基于函数回调 doFilter()，而Interceptor则是基于AOP思想
        Filter在只在Servlet前后起作用，而Interceptor够深入到方法前后、异常抛出前后等

        依赖于Servlet容器即web应用中，而Interceptor不依赖于Servlet容器所以可以运行在多种环境。
    
        在接口调用的生命周期里，Interceptor可以被多次调用，而Filter只能在容器初始化时调用一次。
        
        Filter和Interceptor的执行顺序
         
        过滤前->拦截前->action执行->拦截后->过滤后
        
        =======requestInitialized=======
		LoginIntercepter----->preHandle
		TwoIntercepter----->preHandle
		 controller -->account2
		TwoIntercepter----->postHandle
		LoginIntercepter----->postHandle
		TwoIntercepter----->afterCompletion
		LoginIntercepter----->afterCompletion
		=======requestDestroyed=======
        
 */
@Configuration
public class CustomWebMvcConfigurer implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//注册刚才加的LoginInterceptor。并制定拦截的路径
		registry.addInterceptor(new LoginIntercepter()).addPathPatterns("/api2/*/**");
		registry.addInterceptor(new TwoIntercepter()).addPathPatterns("/api2/*/**");
		//.excludePathPatterns("/api2/v1/**")	链式操作排除拦截路径exclude
		WebMvcConfigurer.super.addInterceptors(registry);
		
	}

	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
