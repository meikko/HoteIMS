package com.fjh.book.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fjh.book.dao.BookDao;

/**
 * Servlet implementation class BookInsert
 */
@WebServlet("/BookInsert")
public class BookInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookInsert() {
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
		System.out.println("预定增加操作");
		response.setContentType("text/html;charset=utf-8");
		String name = request.getParameter("name");
	    String sex = request.getParameter("sex");
	    String idcard = request.getParameter("idcard");
	    String booktime = request.getParameter("booktime");
        String phone = request.getParameter("phone");
        String vipid = request.getParameter("vip");        
        String breakfirst = request.getParameter("breakfirst");
	    String roomid = request.getParameter("select1");
	    //String bookid = "sequence3.nextval";
	    System.out.println(name+sex+idcard+booktime+phone+vipid+breakfirst+roomid);
	    com.fjh.domain.BookInsert b = new com.fjh.domain.BookInsert();
	       
	    b.setName(name);
	    b.setSex(sex);
	    b.setIdcard(idcard);
	    b.setBooktime(booktime);
	    b.setPhone(phone);
	    b.setVipid(vipid);
	    b.setBreakfirst(breakfirst);
	    b.setRoomid(roomid);
	    //b.setBookid(bookid);
	       
	    BookDao bd = new BookDao();
	    bd.bookinsert(b);
	    //request.setAttribute("name", name);
	    request.getRequestDispatcher("/mainFramertlist1-3.jsp").forward(request, response);
	}

}
