package com.fjh.book.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fjh.book.dao.BookDao;
import com.fjh.domain.BookInsert;

/**
 * Servlet implementation class BookDel
 */
@WebServlet("/BookDel")
public class BookDel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookDel() {
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
	       System.out.println("Ô¤¶©ÐÅÏ¢É¾³ý²Ù×÷");
	       String book = request.getParameter("checkbox");
	       System.out.println(book);
	       BookInsert bi = new BookInsert();
	       bi.setName(book);
	       BookDao bd = new BookDao();
	       bd.deletebook(bi);
	       BookAll ba =new BookAll();
	       ba.doPost(request, response);
	}

}
