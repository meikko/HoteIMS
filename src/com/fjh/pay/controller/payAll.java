package com.fjh.pay.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fjh.domain.Roommsg;
import com.fjh.pay.dao.payDao;

/**
 * Servlet implementation class payAll
 */
@WebServlet("/payAll")
public class payAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public payAll() {
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
		String rid = request.getParameter("select1");
		Roommsg room = new Roommsg();
		room.setRoomid(rid);
		System.out.println(room.getRoomid());
		if(rid==null||rid.equals("")){
		 System.out.println("已进入支付全员查询");
		  //HttpSession session = request.getSession();
		
            String msg = "";
          payDao pd = new payDao();
          msg = pd.selectpayall();
			System.out.println(msg);
			request.setAttribute("msg", msg);
			//session.setAttribute("msg", msg);
			request.getRequestDispatcher("/mainFramertlist1-5.jsp").forward(request, response);
		}
		else{
			 System.out.println("进入房间号查询");
			 String msg = "";
	          payDao pd = new payDao();
	          msg = pd.selectpay(room);
				System.out.println(msg);
				request.setAttribute("msg", msg);				
				request.getRequestDispatcher("/mainFramertlist1-5.jsp").forward(request, response);
			
		}
	}

}
