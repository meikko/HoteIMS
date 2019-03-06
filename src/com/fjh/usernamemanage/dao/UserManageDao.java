package com.fjh.usernamemanage.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.fjh.domain.Roomtype;
import com.fjh.domain.UserBean;
import com.fjh.domain.UserManage;
import com.fjh.utils.DBUtilManager;

public class UserManageDao {
	
	public ResultSet selectusername(UserManage um){
		Connection conn = DBUtilManager.getconn();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			String sql = "select * from usertable where "+um.getUsername()+"='"+um.getNeirong()+"'";
			System.out.println("sql=" + sql);
			rs = st.executeQuery(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
		}
		return rs;
		}
	public  void addUser(UserBean ub){
		Connection conn = DBUtilManager.getconn();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			String sql = "insert into usertable(username,mima,nicheng,youxiang,quan,time,isonline)values('"+ub.getUname()+"','"+ub.getUpass()+"','"+ub.getNicheng()+"','"+ub.getYouxiang()+"','"+ub.getQuan()+"','','') ";
			System.out.println(sql);
			int a = st.executeUpdate(sql);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			 try {			 
				 st.close();
				 conn.close();
			} catch (SQLException e1) {
				 
				e1.printStackTrace();
			}
	  
		}		
		
		
	}
        
}
