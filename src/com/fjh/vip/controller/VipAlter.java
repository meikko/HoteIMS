package com.fjh.vip.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fjh.domain.vip;
import com.fjh.vip.dao.VipDao;

/**
 * Servlet implementation class VipAlter
 */
@WebServlet("/VipAlter")//会员信息修改
public class VipAlter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VipAlter() {
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
        String vipid = request.getParameter("vipid");
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String mima = request.getParameter("mima");
        String phone = request.getParameter("phone");
        String idcard = request.getParameter("idcard");
        System.out.println(vipid);
        vip v = new vip();
        v.setVipid(vipid);
        v.setName(name);
        v.setSex(sex);
        v.setMima(mima);
        v.setPhone(phone);
        v.setIdcard(idcard);
        VipDao vd = new VipDao();
        ResultSet rs = vd.selectvip3(v);
       /* String msg = "";
        request.setAttribute("msg", msg);*/
		request.getRequestDispatcher("/mainFramertlist3-3.jsp").forward(request, response);
	}

}
