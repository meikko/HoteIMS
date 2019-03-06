package com.fjh.roomtype.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fjh.domain.RoomtypeAdds;
import com.fjh.roomtype.dao.RoomtypeDao;

/**
 * Servlet implementation class RoomtypeAddSub
 */
@WebServlet("/RoomtypeAddSub")
public class RoomtypeAddSub extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoomtypeAddSub() {
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
		System.out.println("进入添加提交");
        
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String type = request.getParameter("type");
        String typename = request.getParameter("typename");
        String customernum = request.getParameter("customernum");
        String price = request.getParameter("price");
        String bath = request.getParameter("bath");
        String reticle = request.getParameter("reticle");
        String mark = request.getParameter("mark");
        
        RoomtypeAdds rdd = new RoomtypeAdds();
        rdd.setType(type);
        rdd.setTypename(typename);
        rdd.setCustomernum(customernum);
        rdd.setPrice(price);
        rdd.setBath(bath);
        rdd.setReticle(reticle);
        rdd.setMark(mark);
        
        RoomtypeDao rddd = new RoomtypeDao();
        rddd.addroomtype(rdd);
        
        SecletTest st = new SecletTest();
        st.doPost(request, response);
	}

}
