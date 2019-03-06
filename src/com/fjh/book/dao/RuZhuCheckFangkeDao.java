package com.fjh.book.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.fjh.domain.UserManage;
import com.fjh.utils.DBUtilManager;

public class RuZhuCheckFangkeDao {
	
	public ResultSet selectfangke(UserManage um){
		Connection conn = DBUtilManager.getconn();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			String sql = "select * from book where "+um.getUsername()+"='"+um.getNeirong()+"'";
			System.out.println("sql=" + sql);
			rs = st.executeQuery(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
		}
		return rs;
		}

}
