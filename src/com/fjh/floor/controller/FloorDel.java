package com.fjh.floor.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fjh.floor.dao.FloorDao;

/**
 * Servlet implementation class FloorDel
 */
@WebServlet("/FloorDel")
public class FloorDel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FloorDel() {
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
	     response.setCharacterEncoding("utf-8");
	     System.out.println("Â¥²ãÉ¾³ýÌá½»");
	     String floor = request.getParameter("checkbox");
	     System.out.println(floor);
	     com.fjh.domain.floor f = new com.fjh.domain.floor();
	     f.setFloor(floor);
	     FloorDao fd = new FloorDao();
	     fd.deletefloor(f);
	     floor f1 = new floor();
	     f1.doPost(request, response);
	}

}
