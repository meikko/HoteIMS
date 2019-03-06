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
 * Servlet implementation class RoomtypeManage
 */
@WebServlet("/RoomtypeManage")
public class RoomtypeManage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoomtypeManage() {
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
		// HttpSession session = request.getSession();
        String type = request.getParameter("textfield");
        String typename = request.getParameter("select3");
        System.out.println(type+typename);
        Roomtype r = new Roomtype();
        if(!type.equals("") || type!=null||typename.equals("0"))
          r.setType(type);
        if(!typename.equals("0")){
          r.setType(typename);                          
        }
        System.out.println(r.getType());
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
		
		request.setAttribute("msg", msg);
		request.getRequestDispatcher("/mainFramertlist3-1.jsp").forward(request, response);
	}

}
