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
 * Servlet implementation class VipManage
 */
@WebServlet("/VipManage")//模糊查询会员信息
public class VipManage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VipManage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		System.out.println("姓名" + name + "电话" + tel);
		vip v = new vip();
		
		if (!name.equals("") || name != null ||tel.equals("")) {
			v.setName(name);
			System.out.println(v.getName());
		}else{
			v.setName(null);
		}
		if (!tel.equals("") || tel != null ) {
			v.setPhone(tel);
			System.out.println(v.getPhone());
		}
		VipDao rd = new VipDao();
		ResultSet rs = rd.selectvip(v);
		String msg = "";
		try {
			while (rs.next()) {
				msg += "<tr><td>" + rs.getString(1) + "</td><td>"
						+ rs.getString(2) + "</td><td>" + rs.getString(3)
						+ "</td><td>" + rs.getString(4) + "</td><td>"
						+ rs.getString(5) + "</td><td>" + rs.getString(6)
						+ "</td><td>" + rs.getString(7) + "</td></tr>";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("msg", msg);
		request.getRequestDispatcher("/mainFramertlist3-3.jsp").forward(request, response);
	}

}
