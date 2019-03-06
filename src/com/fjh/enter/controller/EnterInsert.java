package com.fjh.enter.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fjh.domain.EnterInsertbean;
import com.fjh.enter.dao.EnterDao;

/**
 * Servlet implementation class EnterInsert
 */
@WebServlet("/EnterInsert")
public class EnterInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnterInsert() {
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
		 response.setContentType("text/html;charset=utf-8");
		 String name = request.getParameter("name");
         String sex = request.getParameter("select");
         String idcard = request.getParameter("idcard");
         String room = request.getParameter("select1");
         String phone = request.getParameter("phone");
         String vip = request.getParameter("vip");        
         String breakfirst = request.getParameter("select2");
         System.out.println(name+sex+idcard);
         EnterInsertbean e = new EnterInsertbean();
         e.setName(name);
         e.setSex(sex);
         e.setIdcard(idcard);
         e.setRoomid(room);
         e.setPhone(phone);
         e.setVip(vip);
         e.setBreakfirst(breakfirst);
         EnterDao ed = new EnterDao();
         String msg = ed.enterinsert(e);
         if(msg.equals("入住成功")){
         request.setAttribute("name", name);
         request.getRequestDispatcher("/success.jsp").forward(request, response);
         }
         else{
        	 request.setAttribute("vip", msg);
         request.getRequestDispatcher("/mainFramertlist1-1.jsp").forward(request, response); 
         }
	}

}
