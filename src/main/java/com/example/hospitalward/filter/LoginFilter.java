package com.example.hospitalward.filter;

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
 * 
 * @ClassName:  LoginFilter   
 * @Description:TODO描述：   放行一些没有登录可访问的url，拦截没有登录时不能访问的url
 * @author: 刘及光
 * @date:   2018年10月6日 上午8:55:53
 */
@WebFilter("/*")
public class LoginFilter implements Filter {
	
	/**
	 * 销毁
	 */
	public void destroy() {
	}

	/**
	 * 放行一些没有登录可访问的url，拦截没有登录时不能访问的url
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req =(HttpServletRequest) request;
		HttpServletResponse resp =(HttpServletResponse) response;
		String uri=req.getRequestURI();
		//包含"login"字符串的地址放行
		if (uri.contains("login")) {
			chain.doFilter(request, response);
		}//对验证码图片地址访问放行
		else if (uri.contains("ImgCodeServlet")) {
			chain.doFilter(request, response);
		}
		//管理员登录地址放行
		else if (uri.contains("AdminServlet")) {
			chain.doFilter(request, response);
		}//静态资源地址放行
		else if (uri.contains("asset")) {
			chain.doFilter(request, response);
		}else if (uri.contains("introduce")) {
			chain.doFilter(request, response);
		}
		//验证码ajax检验放行
		else if (uri.contains("VerifyServlet")) {
			chain.doFilter(request, response);
		}
		//其他地址
		else {
			//查看是否登录
			Object person = req.getSession().getAttribute("person");
			//没有登录，返回登录页
			if (person==null) {
				resp.sendRedirect(req.getContextPath()+"/login.jsp");
			}else {
				//登录放行
				chain.doFilter(request, response);
			}
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
