package com.fjh.book.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fjh.book.dao.RuZhuDao;
import com.fjh.domain.YuDing;

/**
 * Servlet implementation class RuZhu
 */
@WebServlet("/RuZhu")
public class RuZhu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RuZhu() {
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
		System.out.println("开始进行入住操作");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String allmessage = request.getParameter("checkbox");
        System.out.println(allmessage);
        String ruzhu = "入住";
        //拆分
        String[] allmes = allmessage.split(":");
        YuDing yd = new YuDing();
        yd.setId(allmes[0]);
        yd.setNamee(allmes[1]);
        yd.setSex(allmes[2]);
        yd.setIdcard(allmes[3]);
        yd.setEntertime(allmes[4]);
        yd.setRoomid(allmes[5]);
        yd.setPhone(allmes[6]);
        yd.setBreakfirst(allmes[7]);
        yd.setVip(allmes[8]);
        yd.setEnterstate(ruzhu);
        
        RuZhuDao rz = new RuZhuDao();
        rz.fangkeruzhu(yd);
        
        request.getRequestDispatcher("/mainFramertlist1-4.jsp").forward(request, response);
        
        //YdchangeRz ydd = new YdchangeRz();
        //ydd.doPost(request, response);
	}

}
