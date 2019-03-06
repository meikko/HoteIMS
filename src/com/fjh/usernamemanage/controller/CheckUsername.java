package com.fjh.usernamemanage.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fjh.domain.UserManage;
import com.fjh.usernamemanage.dao.UserManageDao;

/**
 * Servlet implementation class CheckUsername
 */
@WebServlet("/CheckUsername")
public class CheckUsername extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckUsername() {
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
		System.out.println("");
	    request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String uname = request.getParameter("uname");//得到列名
        String pass = request.getParameter("neirong");//得到列内容
        System.out.println("uname="+uname);
        System.out.println("pass="+pass);
        
        UserManage um = new UserManage();
        um.setUsername(uname);
        um.setNeirong(pass);
        
        UserManageDao ud = new UserManageDao();
        ResultSet rs = ud.selectusername(um);
        //System.out.println("rs.getString(2)="+rs.getString("username"));
        String msg = "";
        try {
			while(rs.next()){
				msg = "<tr><td>"+rs.getString("username")+"</td><td>"+rs.getString("mima")+"</td><td>"+rs.getString("nicheng")+"</td><td>"+rs.getString("youxiang")+"</td><td>"+rs.getString("quan")+"</td><td><input type='checkbox' name='checkbox' value='"+rs.getString("username")+"' /></td></tr>";
				
			}
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}
	    request.setAttribute("msg", msg);
	    request.getRequestDispatcher("/mainFramertlist3-5.jsp").forward(request, response);}

}
