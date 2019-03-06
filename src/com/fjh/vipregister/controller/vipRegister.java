package com.fjh.vipregister.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fjh.domain.vip;
import com.fjh.vipregister.dao.vipRegisterDao;

/**
 * Servlet implementation class vipRegister
 */
@WebServlet("/vipRegister")
public class vipRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public vipRegister() {
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
        String sex = request.getParameter("sex");
        String idcard = request.getParameter("idcard");
        String mima = request.getParameter("password");
        String phone = request.getParameter("phone");
       
        System.out.println(name+sex+idcard);
        vip e = new vip();
        e.setName(name);
        e.setSex(sex);
        e.setIdcard(idcard);       
        e.setPhone(phone);
        e.setMima(mima);
        e.setTime(gettime());
        vipRegisterDao vr = new vipRegisterDao();
       String vipid =  vr.vipregister(e);
        request.setAttribute("name", name);
        request.setAttribute("id", vipid);
        request.getRequestDispatcher("/successregister.jsp").forward(request, response);
	}
	
	public String gettime() {
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String s = sdf.format(now);
		return s;
	
	}

}
