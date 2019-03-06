package com.fjh.login.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fjh.domain.UserBean;
import com.fjh.login.dao.loginDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		Date date = new Date(); 
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		System.out.println("登录时间："+dateFormat.format(date));
		HttpSession session = request.getSession();
		String  uname = request.getParameter("username");
		String pass = request.getParameter("password");
		UserBean u = new UserBean();
		u.setUname(uname);
	    u.setUpass(pass);
	    //System.out.println(u.getTime());	
		session.setAttribute("up",u);
	    loginDao ld = new loginDao();
	    if(ld.isExistByName(u)==true){
	    	String msg = u.getNicheng()+"  "+u.getQuan()+"  (上次登陆时间 "+u.getTime()+")";
	    	session.setAttribute("u",msg);	    	    		    	
	    	request.getRequestDispatcher("/index.jsp").forward(request, response);
	    }else{
	    	//request.getRequestDispatcher("/login.jsp").forward(request, response);
	    	response.sendRedirect("login.jsp?error=false");
	    }
	}

}
