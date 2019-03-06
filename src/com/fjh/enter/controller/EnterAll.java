package com.fjh.enter.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fjh.domain.EnterInsertbean;
import com.fjh.enter.dao.EnterDao;

/**
 * Servlet implementation class EnterAlla
 */
@WebServlet("/EnterAll")
public class EnterAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnterAll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("进入全员信息查询");
        EnterInsertbean  e = new EnterInsertbean();
        e = null;
        EnterDao ed = new  EnterDao();
        ResultSet rs = ed.selectenter();
        String msg ="";
        try {
			while(rs.next()){
				   msg+= "<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getString(7)+"</td><td>"+rs.getString(8)+"</td><td>"+rs.getString(9)+"</td><td>"+rs.getString(10)+"</td><td>"+rs.getString(11)+"</td></tr>";
			  }
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		System.out.println(msg);
		request.setAttribute("msg", msg);
		request.getRequestDispatcher("/mainFramertlist1-1.jsp").forward(request, response);
	}

}
