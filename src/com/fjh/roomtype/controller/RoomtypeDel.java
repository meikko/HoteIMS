package com.fjh.roomtype.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fjh.domain.Roomtype;
import com.fjh.roomtype.dao.RoomtypeDao;

/**
 * Servlet implementation class RoomtypeDel
 */
@WebServlet("/RoomtypeDel")
public class RoomtypeDel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoomtypeDel() {
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
		System.out.println("É¾³ýÌá½»");
		String type = request.getParameter("checkbox");
        System.out.println(type);
		Roomtype r = new Roomtype();
		r.setType(type);
		 
		RoomtypeDao rd = new RoomtypeDao();
		rd.deleteroomtype(r);
		//Roomtypeall rta = new Roomtypeall();
		//rta.doPost(request, response);
		SecletTest st = new SecletTest();
		st.doPost(request, response);
	}

}
