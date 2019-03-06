package com.fjh.roommsg.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.fjh.domain.Roommsg;
import com.fjh.domain.Roomtype;
import com.fjh.utils.DBUtilManager;

public class RoommsgDao {
	public ResultSet selectroommsg(Roommsg r){
		Connection conn = DBUtilManager.getconn();
		Statement st = null;
		ResultSet rs = null;
	
		
		 if(r.getState()==null){
			try {
				st = conn.createStatement();
				String sql = "select roomid,typename,statename,Floor,price from state,rooms,roomtype Where state.stateid = rooms.state And rooms.roomtype = roomtype.type and roomid ='" + r.getRoomid()+ "'";
				System.out.println("sql=" + sql);
				rs = st.executeQuery(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				
			}
		}
		else {
			
			try {
				st = conn.createStatement();
				String sql = "select roomid,typename,statename,Floor,price from state,rooms,roomtype Where state.stateid = rooms.state And rooms.roomtype = roomtype.type and state ='" + r.getState()+ "'";
				System.out.println("sql=" + sql);
				rs = st.executeQuery(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				
			}
		}
		
		
			
			
		return rs;
	}
	
	public ResultSet selectroommsg2(Roommsg r){
		Connection conn = DBUtilManager.getconn();
		Statement st = null;
		ResultSet rs = null;
	  System.out.println("查询全员");
		if(r==null){
			try {
				st = conn.createStatement();
				String sql = "select roomid,typename,statename,Floor,price from state,rooms,roomtype Where state.stateid = rooms.state And rooms.roomtype = roomtype.type";
				System.out.println("sql=" + sql);
				rs = st.executeQuery(sql);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				
			}
		}
		return rs;
	}
	public void deleteRoomsg(Roommsg rsg){
		Connection conn = DBUtilManager.getconn();
		Statement st = null;
		try {
			st = conn.createStatement();
			String sql = "delete rooms where roomid = '"+rsg.getRoomid()+"'";
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
