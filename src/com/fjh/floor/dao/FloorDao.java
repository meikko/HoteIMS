package com.fjh.floor.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.fjh.domain.floor;
import com.fjh.utils.DBUtilManager;

public class FloorDao {
	public ResultSet selectfloor(){
         Connection conn = DBUtilManager.getconn();
         Statement st = null ;
         ResultSet rs = null;
         
         try {
			st=conn.createStatement();
			String sql= "select * from floor order by floorid";
			rs=st.executeQuery(sql);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally{
			
		}
         return rs;
	}
	public void deletefloor(floor f){
		Connection conn = DBUtilManager.getconn();
		Statement st = null;
		
		try {
			st = conn.createStatement();
			String sql = "delete floor where floor ='"+f.getFloor()+"'";
			System.out.println(sql);
			int a = st.executeUpdate(sql);
			System.out.println("成功删除"+a+"条记录");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		 finally {
			 try {			 
				 st.close();
				 conn.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
         
       
	
