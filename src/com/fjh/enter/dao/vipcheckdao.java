package com.fjh.enter.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.fjh.utils.DBUtilManager;

public class vipcheckdao {
	public String vipcheck(String vip){
		System.out.println("会员卡验证..");
		Connection conn = DBUtilManager.getconn();
		String msg="该VIP不存在！建议注册会员享受优质服务;";
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			String sql = "select * from vip Where idcard = '"+vip+"'";
			System.out.println("sql=" + sql);
			rs = st.executeQuery(sql);
			while(rs.next()){
				msg = "VIP卡验证通过！";				
			}
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			
		}
		
		return msg;
	}
}
