package com.fjh.floor.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fjh.floor.dao.FloorDao;

/**
 * Servlet implementation class floor
 */
@WebServlet("/floor")
public class floor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public floor() {
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
		 System.out.println("½øÈëÂ¥²ã²éÑ¯");
         /* floor f= new floor();
         f = null;*/
         FloorDao fd=new FloorDao();
         ResultSet rs = fd.selectfloor();
         String msg="";
         try {
				while(rs.next()){
					msg+="<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td><input type='checkbox' name='checkbox' value='"+rs.getString(1)+"' /></td></tr>";
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			System.out.println(msg);
         request.setAttribute("msg", msg);
         request.getRequestDispatcher("/mainFramertlist3-2.jsp").forward(request, response);
	}

}
