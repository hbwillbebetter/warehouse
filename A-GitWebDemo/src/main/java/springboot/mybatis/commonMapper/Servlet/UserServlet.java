package springboot.mybatis.commonMapper.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 2、Servlet3.0的注解自定义原生Servlet实战
    讲解：使用 Servlet3.0的注解自定义原生Servlet和Listener
        1、自定义原生Servlet

            @WebServlet(name = "userServlet",urlPatterns = "/test/customs")
            public class UserServlet extends HttpServlet{

                 @Override
                 public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                     resp.getWriter().print("custom sevlet");
                     resp.getWriter().flush();
                     resp.getWriter().close();
                 }

                 @Override
                 protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                     this.doGet(req, resp);
                 }
            }
 *
 */
@WebServlet(name="userServlet",urlPatterns="/api/v1/test/customs")
public class UserServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		writer.print("customs servlet");
		writer.flush();
		writer.close();
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
	
	
	
	
}
