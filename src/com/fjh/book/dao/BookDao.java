package com.fjh.book.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.fjh.domain.BookInsert;
import com.fjh.domain.floor;
import com.fjh.utils.DBUtilManager;

public class BookDao {
	public void bookinsert(BookInsert b){
		Connection conn = DBUtilManager.getconn();
		Statement st = null;
		if(b!=null){
		try {
			st = conn.createStatement();
			String sql = "insert into book values(sequence3.nextval,'"+b.getName()+"','"+b.getIdcard()+"','"+b.getBooktime()+"','"+b.getRoomid()+"','"+b.getPhone()+"','"+b.getVipid()+"','"+b.getSex()+"','"+b.getBreakfirst()+"','未入住')";
		    System.out.println(sql);
		    int a = st.executeUpdate(sql);
		    System.out.println("成功预定"+a+"人");
		    sql = "update rooms set state = '2' where roomid='"+b.getRoomid()+"'";
			   int i= st.executeUpdate(sql);
			    System.out.println("状态已更改"+i);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			 try {				
				 st.close();
				 conn.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				//e1.printStackTrace();
			}
			 
		}
		
	}
		
	}
	  public void deletebook(BookInsert bi){
		  Connection conn = DBUtilManager.getconn();
		  Statement st = null;
		  try {
			st = conn.createStatement();
			String sql = "delete book where name = '"+bi.getName()+"'";
			System.out.println(sql);
			int a = st.executeUpdate(sql);
			System.out.println("成功删除"+a+"条记录");
			 sql = "update rooms set state = '0' where roomid='"+bi.getRoomid()+"'";
			   int i= st.executeUpdate(sql);
			    System.out.println(bi.getRoomid()+"状态已更改为空闲"+i);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			 try {			 
				 st.close();
				 conn.close();
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
		}
		  
		  
	  }
}
