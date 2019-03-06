package com.fjh.vip.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.fjh.domain.vip;
import com.fjh.utils.DBUtilManager;

public class VipDao {
	public ResultSet selectvip(vip v) {//会员查询
		Connection conn = DBUtilManager.getconn();
		Statement st = null;
		ResultSet rs = null;
       System.out.println(v.getName()+v.getPhone());
		if (v.getName().equals("")) {//根据电话查
			try {
				st = conn.createStatement();
				String sql = "select * from vip Where phone ='" + v.getPhone()+ "'";
				System.out.println("sql=" + sql);
				rs = st.executeQuery(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				
			}
		} 
		else {

			try {//根据姓名模糊查
				st = conn.createStatement();
				String sql = "select * from vip where name like '%"+v.getName()+"%'";
				System.out.println("sql=" + sql);
				rs = st.executeQuery(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				
			}
		}

		return rs;
	}

	public ResultSet selectvip2(vip v) {//全员查
		Connection conn = DBUtilManager.getconn();
		Statement st = null;
		ResultSet rs = null;
		System.out.println("查询全员");
		if (v == null) {
			try {
				st = conn.createStatement();
				String sql = "select * from vip ";
				System.out.println("sql=" + sql);
				rs = st.executeQuery(sql);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				

			}
		}
		return rs;
	}


	public ResultSet selectvip3(vip v) {//修改
		Connection conn = DBUtilManager.getconn();
		Statement st = null;
		ResultSet rs = null;
		System.out.println("修改会员信息");
			try {
				st = conn.createStatement();
				String sql = "Update vip Set  name='"+v.getName() +"',sex='"+v.getSex()+"' , mima = '"+v.getMima()+"' , phone = '"+v.getPhone()+"' , idcard = '"+v.getIdcard()+"'    Where vipid ="+v.getVipid()+"";
				System.out.println("sql=" + sql);
				int num = st.executeUpdate(sql);
			    if (num > 0) {
				         System.out.println("会员已经修改了" + num + "条数据");
			   	 
			 }					
	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {			 
					 st.close();
					 conn.close();
				} catch (SQLException e1) {
					 
					e1.printStackTrace();
				}
	
			}
		
		return rs;
	}
	

    public void deletevip(vip v){//删除
    	Connection conn = DBUtilManager.getconn();
    	Statement st = null;
    	    try {
				st = conn.createStatement();
		        String sql = "delete vip where name = '"+v.getName()+"'";
				System.out.println(sql);
				  int a = st.executeUpdate(sql);
				
				System.out.println("成功删除"+a+"条记录");
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			finally {
				
			}		
    	   
    	   
       }


}