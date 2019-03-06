package com.fjh.vip.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fjh.domain.vip;
import com.fjh.vip.dao.VipDao;

/**
 * Servlet implementation class VipDel
 */
@WebServlet("/VipDel")//删除会员
public class VipDel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VipDel() {
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
        System.out.println("执行会员删除操作");
        String name = request.getParameter("checkbox");
        System.out.println(name);
        vip v= new vip();
        v.setName(name);
        VipDao vd = new VipDao();
        vd.deletevip(v);
        Vipall v1 = new Vipall();
        v1.doPost(request, response);
	}

}
