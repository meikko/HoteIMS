package com.fjh.usernamemanage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UsernameAdd
 */
@WebServlet("/UsernameAdd")
public class UsernameAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsernameAdd() {
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
		System.out.println("进入用户增加页面");
        String msg = "<form action='/HotelMS/servlet/UsernameAddSub' method='post'><tr><td align='center'><input type='text' name='uname'></td><td align='center'><input type='text' name='pass'></td><td align='center'><input type='text' name='nicheng'></td><td align='center'><input type='text' name='email'></td><td align='center'><input type='text' name='popedom'></td><td align='center'><input name='add' type='submit' value='提交'></td></tr></form>";
        System.out.println(msg);
        request.setAttribute("msg", msg);
		request.getRequestDispatcher("/mainFramertlist3-5.jsp").forward(request, response);
	}

}
