package com.fjh.book.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fjh.book.dao.RuZhuCheckFangkeDao;
import com.fjh.domain.UserManage;

/**
 * Servlet implementation class CheckFangke
 */
@WebServlet("/RuZhuCheckFangke")
public class RuZhuCheckFangke extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RuZhuCheckFangke() {
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
		System.out.println("进行房客查询添加");	    
	    request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String uname = request.getParameter("cname");//得到列名
        String pass = request.getParameter("neirong");//得到列内容
        System.out.println("uname="+uname);
        System.out.println("pass="+pass);
        
        UserManage um = new UserManage();
        um.setUsername(uname);
        um.setNeirong(pass);
        
        RuZhuCheckFangkeDao udc = new RuZhuCheckFangkeDao();
        ResultSet rs = udc.selectfangke(um);
         
        String msg = "";
        try {
			while(rs.next()){
				System.out.println("rs.getString(1)"+rs.getString(1));
				
				msg = msg+="<tr><td>"+rs.getString(1)+"</td>"
						+ "<td>"+rs.getString(2)+"</td>"
						+ "<td>"+rs.getString(3)+"</td>"
						+ "<td>"+rs.getString(4)+"</td>"
						+ "<td>"+rs.getString(5)+"</td>"
						+ "<td>"+rs.getString(6)+"</td>"
						+ "<td>"+rs.getString(7)+"</td>"
						+ "<td>"+rs.getString(8)+"</td>"
						+ "<td>"+rs.getString(9)+"</td>"
						+ "<td>"+rs.getString(10)+"</td><td>"
						+ "<input type='checkbox' name='checkbox' value='"+rs.getString(1)+":"+rs.getString(2)+":"+rs.getString(8)+":"+rs.getString(3)+":"+rs.getString(4)+":"+rs.getString(5)+":"+rs.getString(6)+":"+rs.getString(9)+":"+rs.getString(7)+"' /></td></tr>";
				
			}
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}
	    request.setAttribute("msg", msg);
	    request.getRequestDispatcher("/mainFramertlist1-4.jsp").forward(request, response);
	}

}
