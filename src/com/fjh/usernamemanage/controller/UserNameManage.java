package com.fjh.usernamemanage.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fjh.utils.DBUtilManager;

/**
 * Servlet implementation class UserNameManage
 */
@WebServlet("/UserNameManage")
public class UserNameManage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserNameManage() {
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
		String msg = "";
        //String mess = "";
        // String mess1 = "";
        //String mess2 = "";
        //String mess3 = "";
        //String mess4 = "";
        
        int pageSize = 3; 
        int pageNow = 1; 
        int rowCount = 0; 
        int pageCount = 0; 
        
        String spageNow = request.getParameter("pageNowok");
        if(spageNow!=null){
        	pageNow = Integer.parseInt(spageNow);
        }
         
        Statement st = null;
		ResultSet rs = null;
		Connection conn = DBUtilManager.getconn();
	     
		try {
			String sql = "select count(*) from usertable";
			st = conn.prepareStatement(sql);
			rs = st.executeQuery(sql);
			if(rs.next()){
			    rowCount = rs.getInt(1);
			    System.out.println("rowCount="+rowCount);
			} 
			
			if(rowCount%pageSize==0){
			     pageCount = rowCount/pageSize;
			     System.out.println("pageCount="+pageCount);
			}else{     
			    pageCount = rowCount/pageSize+1;
			    System.out.println("pageCount====="+pageCount);
			}
		String sql2 = "select * from(select rownum num ,a.* from(select * from usertable) a  )b";	
        st = conn.prepareStatement(sql2);
        rs = st.executeQuery(sql2);
         
        while(rs.next()){       	        
            System.out.println("rs.getString(2)"+rs.getString(2));
            System.out.println("rs.getString(3)="+rs.getString(3));
            System.out.println("rs.getString(4)="+rs.getString(4));
            System.out.println("rs.getString(5)="+rs.getString(5));
            System.out.println("rs.getString(6)="+rs.getString(6));     
              
            msg += "<tr><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getString(6)+"</td><td><input type='checkbox' name='checkbox' value='"+rs.getString(2)+"' /></td></tr>";
            System.out.println(msg);
        }
        request.setAttribute("msg", msg);
 
        
     
        request.getRequestDispatcher("/mainFramertlist3-5.jsp").forward(request, response);
        
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}
	}

}
