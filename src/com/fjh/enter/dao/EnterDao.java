package com.fjh.enter.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;





import com.fjh.domain.EnterInsertbean;
import com.fjh.domain.Roomtype;
import com.fjh.utils.DBUtilManager;

public class EnterDao {
	
	public String enterinsert(EnterInsertbean e){
		Connection conn = DBUtilManager.getconn();
		Statement st = null;
		String msg = "入住成功";
		if(e!=null){
		try {
			st = conn.createStatement();
			String sql = "insert into customer values(sequence2.nextval,'"+e.getName()+"','"+e.getSex()+"','"+e.getIdcard()+"','"+gettime()+"',null,'"+e.getRoomid()+"','"+e.getPhone()+"','"+e.getBreakfirst()+"','"+e.getVip()+"','1')";
			System.out.println("sql=" + sql);
			 int a=st.executeUpdate(sql);
			 System.out.println("成功入住"+a+"人");
			sql = "update rooms set state='3',time ='"+gettime()+"' where roomid='"+e.getRoomid()+"'";
			st.executeUpdate(sql);
		
			
		} catch (SQLException q) {
			q.printStackTrace();
			msg = "会员卡号不正确";
			System.out.println(msg);
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
		
		 return msg;
		}
	public ResultSet selectenter(){
		Connection conn = DBUtilManager.getconn();
		Statement st =null;
		ResultSet rs = null;
		try {
			st=conn.createStatement();
			String sql = "select * from customer where lidian = '1'";
			rs = st.executeQuery(sql);
			System.out.println(sql);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
			 
		
		return rs ;
		
	}
	public String gettime() {
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String s = sdf.format(now);
		return s;
	}
		
}
