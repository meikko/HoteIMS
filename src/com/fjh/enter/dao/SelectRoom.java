package com.fjh.enter.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.fjh.utils.DBUtilManager;

public class SelectRoom {
	public String selectroom(){
		System.out.println("aaa");
		Connection conn = DBUtilManager.getconn();
		String msg="<select name='select1'>";
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			String sql = "select roomid from rooms Where   state ='0' order by roomid";//0.¿ÕÏÐ
			System.out.println("sql=" + sql);
			rs = st.executeQuery(sql);
			while(rs.next()){
				msg += "<option value='"+rs.getString(1)+"'>"+rs.getString(1)+"</option>";
				
			}
			msg += "</select>";
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			
		}
		
		return msg;
	}
	public String selectroom1(){
		Connection conn = DBUtilManager.getconn();
		String msg="<select name='select1'>";
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			String sql = "select roomid from rooms Where   state ='3' order by roomid";//3.ÒÑÈë×¡
			System.out.println("sql=" + sql);
			rs = st.executeQuery(sql);
			while(rs.next()){
				msg += "<option value='"+rs.getString(1)+"'>"+rs.getString(1)+"</option>";
				
			}
			msg += "</select>";
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			
		}
		
		return msg;
	}

}
