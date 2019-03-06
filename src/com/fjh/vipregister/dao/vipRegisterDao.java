package com.fjh.vipregister.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.fjh.domain.EnterInsertbean;
import com.fjh.domain.vip;
import com.fjh.utils.DBUtilManager;

public class vipRegisterDao {
	public String vipregister(vip e){
		Connection conn = DBUtilManager.getconn();
		Statement st = null;
		String vipid = "";
		ResultSet rs = null;
		if(e!=null){
		try {
			st = conn.createStatement();
			String sql = "insert into vip values(sequence2.nextval,'"+e.getName()+"','"+e.getSex()+"','"+e.getMima()+"','"+e.getPhone()+"','"+e.getIdcard()+"','"+e.getTime()+"')";
			System.out.println("sql=" + sql);
			 int a=st.executeUpdate(sql);
			 System.out.println(e.getName()+"已经成功注册为"+a+"会员");
			 sql = "select vipid from vip where idcard = '"+e.getIdcard()+"'";
			 rs =  st.executeQuery(sql);
			 if(rs.next()){
				 vipid = rs.getString(1);
			 }
			
		} catch (SQLException q) {
			q.printStackTrace();
		} finally {
			 try {
				
				 st.close();
				 conn.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				//e1.printStackTrace();
			}
			 
		}
		}
		return vipid;
		 
		}

}
