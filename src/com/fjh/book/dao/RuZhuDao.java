package com.fjh.book.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fjh.domain.RoomtypeAdds;
import com.fjh.domain.YuDing;
import com.fjh.utils.DBUtilManager;

public class RuZhuDao {
	
	//房客入住注册。。。
	  public void fangkeruzhu(YuDing yd){
		  
		   Statement st = null;
		   ResultSet rs = null;
		   //Statement st2 = null;
		   Statement st1 = null;
		   ResultSet rs1 = null;
		   Connection conn = DBUtilManager.getconn();
		   
		   try {
			st = conn.createStatement();
			st1 = conn.createStatement();
			//st2 = conn.createStatement();
			System.out.println("yd.getId()"+yd.getId());
			System.out.println("yd.getEnterState()="+yd.getEnterstate());
			String sql2 = "Update book Set enterstate = '"+yd.getEnterstate()+"' where bookid = "+yd.getId()+" ";
			
			String sql = "insert into customer(id,name,sex,idcard,entertime,exittime,roomid,phone,breakfirst,vip,lidian)values(sequence1.nextval,'"+yd.getNamee()+"','"+yd.getSex()+"','"+yd.getIdcard()+"','"+gettime()+"',null,'"+yd.getRoomid()+"','"+yd.getPhone()+"','"+yd.getBreakfirst()+"','"+yd.getVip()+"','1') "; 
			System.out.println("sqlruzhu="+sql);
			System.out.println("sql2="+sql2);		
			int num = st.executeUpdate(sql);// 返回的是更新的行数
		   if (num > 0) {
			         System.out.println("房客更改注册了" + num + "条数据");	   				         
		 }	
		    int num1 = st1.executeUpdate(sql2);// 返回的是更新的行数
		    if (num1 > 0) {
			         System.out.println("房客成功更改注册了" + num + "条数据");	   				         
		 }	
		    sql = "update rooms set state = '3',time = '"+gettime()+"' where roomid='"+yd.getRoomid()+"'";
		   int i= st.executeUpdate(sql);
		    System.out.println("状态已更改"+i);
			
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
	  public String gettime() {
			Date now = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String s = sdf.format(now);
			return s;
		}
}
