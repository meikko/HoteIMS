package com.fjh.login.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fjh.domain.UserBean;
import com.fjh.utils.DBUtilManager;


public class loginDao {
	public boolean isExistByName(UserBean u) {
		boolean isExist = false;
		Connection conn = DBUtilManager.getconn();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			String sql = "select * from usertable where username='" + u.getUname() + "'and mima='"+u.getUpass()+"'";
			System.out.println("sql=" + sql);
			rs = st.executeQuery(sql);
			if (rs.next()) {
				isExist = true;
				u.setUname(rs.getString("username"));
				u.setUpass(rs.getString("mima"));
				u.setNicheng(rs.getString("nicheng"));
				u.setQuan(rs.getString("quan"));
				u.setTime(rs.getString("time"));
			}
			sql = "update usertable set time = '"+gettime()+"',isonline = 'ÊÇ' where username='"+u.getUname()+"'";
			st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		System.out.println(isExist);
		return isExist;
	}
	public String gettime() {
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String s = sdf.format(now);
		return s;
	}
	
}
