package com.fjh.vip.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fjh.domain.vip;
import com.fjh.vip.dao.VipDao;

/**
 * Servlet implementation class Vipall
 */
@WebServlet("/Vipall")//查询全部会员信息
public class Vipall extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Vipall() {
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
		System.out.println("会员信息查询");
		vip v  = new vip();
		v = null;
		VipDao rd = new VipDao();
		ResultSet rs = rd.selectvip2(v);
		String msg = "";
		try {
			while (rs.next()) {
				msg += "<tr><td>" + rs.getString(1) + "</td><td>"+ rs.getString(2) + "</td><td>" + rs.getString(3)
						+ "</td><td>" + rs.getString(4) + "</td><td>"
						+ rs.getString(5) + "</td><td>" + rs.getString(6) + "</td><td>" + rs.getString(7) + "</td><td><input type='checkbox' name='checkbox' value='"+rs.getString(2)+"'></td></tr>";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(msg);
		request.setAttribute("msg", msg);
		// session.setAttribute("msg", msg);
		request.getRequestDispatcher("/mainFramertlist3-3.jsp").forward(request, response);
	}

}
