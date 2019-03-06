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
 * Servlet implementation class Roomtypeall
 */
@WebServlet("/Roomtypeall")
public class Roomtypeall extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Roomtypeall() {
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
		System.out.println("已进入全员查询");
		//HttpSession session = request.getSession();
		Roomtype r = new Roomtype();
		r = null;
		RoomtypeDao rd = new RoomtypeDao();
        ResultSet rs = rd.selectroomtype(r);
        String msg = "";
        try {
			while(rs.next()) {				
				msg += "<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getString(6)+"</td><td>"+rs.getString(7)+"</td><td><input type='checkbox' name='checkbox' value='"+rs.getString(1)+"' /></td></tr>";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(msg);
		request.setAttribute("msg", msg);
		//session.setAttribute("msg", msg);
		request.getRequestDispatcher("/mainFramertlist3-1.jsp").forward(request, response);
	}

}
