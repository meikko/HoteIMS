package com.fjh.roommsg.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fjh.domain.Roommsg;
import com.fjh.roommsg.dao.RoommsgDao;

/**
 * Servlet implementation class RoomsgDel
 */
@WebServlet("/RoomsgDel")
public class RoomsgDel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoomsgDel() {
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
        System.out.println("¿Í·¿É¾³ý²Ù×÷");
        String rooms = request.getParameter("checkbox");
        Roommsg rsg = new Roommsg();
        rsg.setRoomid(rooms);
        RoommsgDao rd = new RoommsgDao();
        rd.deleteRoomsg(rsg);
        Roommsgall rall = new Roommsgall();
        rall.doPost(request, response);
	}

}
