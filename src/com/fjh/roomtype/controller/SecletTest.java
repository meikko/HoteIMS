package com.fjh.roomtype.controller;

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
 * Servlet implementation class SecletTest
 */
@WebServlet("/SecletTest")
public class SecletTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SecletTest() {
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
        String mess = "";
        String mess1 = "";
        String mess2 = "";
        String mess3 = "";
        String mess4 = "";
        
        int pageSize = 6; 
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
			String sql = "select count(*) from roomtype";
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
		String sql2 = "select * from(select rownum num ,a.* from(select * from roomtype order by type ) a  )b where b.num>=("+pageNow+"-1)*"+pageSize+"+1 and b.num<="+pageNow+"*"+pageSize+" ";	
        st = conn.prepareStatement(sql2);
        rs = st.executeQuery(sql2);
         
        while(rs.next()){       	        
            System.out.println("rs.getString(2)"+rs.getString(2));
            System.out.println("rs.getString(3)="+rs.getString(3));
            System.out.println("rs.getString(4)="+rs.getString(4));
            System.out.println("rs.getString(5)="+rs.getString(5));
            System.out.println("rs.getString(6)="+rs.getString(6));
            System.out.println("rs.getString(7)="+rs.getString(7));
            System.out.println("rs.getString(8)="+rs.getString(8));
              
            msg += "<tr><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getString(6)+"</td><td>"+rs.getString(7)+"</td><td>"+rs.getString(8)+"</td><td><input type='checkbox' name='checkbox' value='"+rs.getString(2)+"' /></td></tr>";
            System.out.println(msg);
        }
        request.setAttribute("msg", msg);
 
        mess += "<a href =servlet/SecletTest?pageNowok=1>首页</a>";
        System.out.println(mess);
        request.setAttribute("mess", mess);
        //上一页
        if(pageNow!=1)
  
        mess1 += "<a href = servlet/SecletTest?pageNowok="+(pageNow-1)+">上一页</a>";	
        System.out.println(mess1);
        request.setAttribute("mess1", mess1);
        //显示超链接
        for(int i = pageNow; i<=pageNow+2;i++){
  
        mess2 += "<a href= servlet/SecletTest?pageNowok="+i+">"+i+"</a>";
        System.out.println(mess2);
        request.setAttribute("mess2", mess2);
        }
        //下一页
        if(pageNow!=pageCount)
  
        mess3 += "<a href = servlet/SecletTest?pageNowok="+(pageNow+1)+">下一页</a>";	
        System.out.println(mess3);
        request.setAttribute("mess3", mess3);
        //尾页
  
        mess4 += "<a href =servlet/SecletTest?pageNowok="+pageCount+">尾页</a>";
        System.out.println(mess4);
        request.setAttribute("mess4", mess4);
      
        //跳转页
        
        
        request.getRequestDispatcher("/mainFramertlist3-1.jsp").forward(request, response);
        
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}
	}

}
