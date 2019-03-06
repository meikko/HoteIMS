package com.fjh.enter.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fjh.enter.dao.vipcheckdao;

/**
 * Servlet implementation class vipcheck
 */
@WebServlet("/vipcheck")
public class vipcheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public vipcheck() {
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
		String vip = request.getParameter("vip");		
		String vipmess = "";
		System.out.println("≤Èª·‘±ø®∫≈");
		vipcheckdao vc = new vipcheckdao();
		vipmess=vc.vipcheck(vip);
 		PrintWriter out1 = response.getWriter();
		out1.print(vipmess);
		out1.flush();
		out1.close();
	}

}
