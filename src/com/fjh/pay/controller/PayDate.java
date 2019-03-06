package com.fjh.pay.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fjh.pay.dao.payDatechange;

/**
 * Servlet implementation class PayDate
 */
@WebServlet("/PayDate")
public class PayDate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayDate() {
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
		 System.out.println("进入结账处理阶段");
		 String rid = request.getParameter("roomid");
		 System.out.println(rid);
		 payDatechange pd = new payDatechange();
		 pd.updatedate(rid);
		 request.setAttribute("roomid", rid);
		 request.getRequestDispatcher("/jiezhang.jsp").forward(request, response);
	}

}
