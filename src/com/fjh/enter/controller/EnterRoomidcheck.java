package com.fjh.enter.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fjh.enter.dao.SelectRoom;

/**
 * Servlet implementation class EnterRoomidcheck
 */
@WebServlet("/EnterRoomidcheck")//查已入住
public class EnterRoomidcheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnterRoomidcheck() {
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
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/plain;charset=utf-8");
		String uname = request.getParameter("y");
		//System.out.println("uname=" + uname);
		String mess = "";
		SelectRoom sr = new SelectRoom();
		mess = sr.selectroom();
		System.out.println(mess);
		PrintWriter out = response.getWriter();
		out.print(mess);
		out.flush();
		out.close();
	}

}
