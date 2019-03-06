package com.fjh.usernamemanage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fjh.domain.UserBean;
import com.fjh.usernamemanage.dao.UserManageDao;

/**
 * Servlet implementation class UsernameAddSub
 */
@WebServlet("/UsernameAddSub")
public class UsernameAddSub extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsernameAddSub() {
        super();
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
		System.out.println("进入用户增加程序");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String uname = request.getParameter("uname");
        String pass = request.getParameter("pass");
        String nicheng = request.getParameter("nicheng");
        String email = request.getParameter("email");
        String popedom = request.getParameter("popedom");
         
        UserBean ub = new UserBean();
        ub.setUname(uname);
        ub.setUpass(pass);
        ub.setNicheng(nicheng);
        ub.setYouxiang(email);
        ub.setQuan(popedom);
        
        UserManageDao umd = new UserManageDao();
        umd.addUser(ub);
        
        UsernameAdd ua = new UsernameAdd();
        ua.doPost(request, response);
	}

}
