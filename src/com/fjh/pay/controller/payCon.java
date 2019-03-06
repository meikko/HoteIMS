package com.fjh.pay.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fjh.domain.pay;
import com.fjh.pay.dao.jiezhangDao;

/**
 * Servlet implementation class payCon
 */
@WebServlet("/payCon")
public class payCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public payCon() {
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
		System.out.println("进入正式结账");
        String rid = request.getParameter("checkbox");
        System.out.println(rid);
        jiezhangDao jd = new jiezhangDao();
        
        pay p = new pay();
        
        p=jd.jiezhang(rid);
      
        request.setAttribute("roomid",p.getRoomid());
        request.setAttribute("hours",p.getHours() );
        request.setAttribute("vipcard",p.getVipcard() );
        request.setAttribute("roomtype",p.getRoomtype());
        request.setAttribute("quanjia",p.getQuanjia());
        request.setAttribute("zhejia",p.getZhejia() );
        request.getRequestDispatcher("/paylist.jsp").forward(request, response);
	}

}
