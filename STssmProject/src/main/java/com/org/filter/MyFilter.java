package com.org.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.bean.User;

public class MyFilter  implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		HttpServletRequest request=(HttpServletRequest)req;
		
		HttpServletResponse response=(HttpServletResponse)resp;
		
		HttpSession session=request.getSession();
		
		User user=(User)session.getAttribute("user");
		
		String loginjsp=request.getContextPath()+"/login.jsp";
		
		
		StringBuffer url=request.getRequestURL();
		
		System.out.println(url.toString());
		
		if(user!=null) {
			
			chain.doFilter(request, response);
		}else if(url.toString().contains("/login.jsp")) {
			
			chain.doFilter(request, response);
		}else if(url.toString().contains("/res/")) {
			
			chain.doFilter(request, response);
		}else if(url.toString().contains("login.do")) {
			
			chain.doFilter(request, response);
		}else {
			
			response.sendRedirect(loginjsp);
		}
		
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
