package springboot.mybatis.commonMapper.Intecpter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
//定义login的拦截器
import org.springframework.web.servlet.ModelAndView;

public class LoginIntercepter implements HandlerInterceptor {

	/**
	 * 进入controller方法之前
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		System.out.println("LoginIntercepter----->preHandle");
		String token = request.getParameter("access_token");
		/*
		 * https://blog.csdn.net/TimerBin/article/details/90295451
		 * 下面注释如果放开，getOutputStream() has already been called for this response  翻译过来是“getOutputStream 已经被要求做出这种回应”，
		 * 普通话说就是response.getOutputStream()  已经用过了不能再次使用。
		 */
//		response.getWriter().print("fail");
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

	/**
	 * 调用完controller之后，视图渲染之前
	 */
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("LoginIntercepter----->postHandle");
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	/**
	 * 整个完成之后，通常用于资源清理
	 */
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("LoginIntercepter----->afterCompletion");
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
	
}
