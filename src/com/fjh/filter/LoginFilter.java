package com.fjh.filter;

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

import com.fjh.domain.UserBean;


public class LoginFilter implements Filter {
    
public void init(FilterConfig ag0) throws ServletException {
	 
		
	}

public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain filterChain) throws IOException, ServletException {
	        HttpServletRequest request1 = (HttpServletRequest)servletRequest;
	        HttpServletResponse response1 = (HttpServletResponse)servletResponse;
	        HttpSession session = request1.getSession();
	        UserBean u = (UserBean)session.getAttribute("up");
	        if(u==null){
	        	System.out.println("µ¡¡¥Ω¯»Î");	        	
	            //request1.getRequestDispatcher("/login.jsp").forward(request1, response1);
	            response1.sendRedirect("login.jsp?error=filter");
	        	return ;
	        }
	        filterChain.doFilter(request1, response1);
	}

public void destroy() {	 
		
	}	

}
