package com.fjh.roomtype.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.fjh.domain.Roomtype;
import com.fjh.domain.RoomtypeAdds;
import com.fjh.utils.DBUtilManager;
import com.sun.org.apache.regexp.internal.RESyntaxException;



public class RoomtypeDao {

	public ResultSet selectroomtype(Roomtype r){
	Connection conn = DBUtilManager.getconn();
	Statement st = null;
	ResultSet rs = null;
	if(r!=null){
	try {
		st = conn.createStatement();
		String sql = "select * from roomtype where type='" + r.getType() + "'";
		System.out.println("sql=" + sql);
		rs = st.executeQuery(sql);
		
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		
	}
	}
	else{
		try {
			st = conn.createStatement();
			String sql = "select * from roomtype";
			System.out.println("sql=" + sql);
			rs = st.executeQuery(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
		}
		
	}
	  return rs;
	}
	
	public void deleteroomtype(Roomtype r){
		Connection conn = DBUtilManager.getconn();
		Statement st = null;
			
		try {
			st = conn.createStatement();
			String sql = "delete from roomtype where type = '"+r.getType()+"'";
			System.out.println("sql=" + sql);
			int a=st.executeUpdate(sql);
			System.out.println("成功删除"+a+"条记录");
			 			
		} catch (SQLException q) {
			System.out.println("该类型的房间已存在，无法删除该类型。");
			//q.printStackTrace();
		} finally {
			 try {			 
				 st.close();
				 conn.close();
			} catch (SQLException e1) {
				 
				e1.printStackTrace();
			}
	  
		}		
	}
	  //房间类型注册。。。
	  public void addroomtype(RoomtypeAdds rdd){
		  
		   Statement st = null;
		   ResultSet rs = null;
		   Connection conn = DBUtilManager.getconn();
		   
		   try {
			st = conn.createStatement();
			String sql = "insert into roomtype(type,typename,customernum,price,bath,reticle,mark)values("+rdd.getType()+",'"+rdd.getTypename()+"',"+rdd.getCustomernum()+","+rdd.getPrice()+",'"+rdd.getBath()+"','"+rdd.getReticle()+"','"+rdd.getMark()+"') "; 
			System.out.println("sqladd="+sql);
			int num = st.executeUpdate(sql);// 返回的是更新的行数
		    if (num > 0) {
			         System.out.println("房间类型成功注册了" + num + "条数据");
		   	 
		 }					
			
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



