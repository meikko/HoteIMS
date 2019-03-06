package com.fjh.pay.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fjh.domain.pay;
import com.fjh.utils.DBUtilManager;

public class jiezhangDao {
	public pay jiezhang(String roomid){
		
	  	  Connection conn = DBUtilManager.getconn();
	  	 pay p =new pay();
	  	  Statement st = null;	  	
	  	  ResultSet rs = null;
	  	  String sql ="";	  	 
	  	  String msg = "";
	  	int hours=0,quanjia=0,zhejia=0;
	  	  try {
				st = conn.createStatement();				
				 sql ="select distinct rooms.roomid,roomtype.typename, roomtype.customernum,rooms.time, customer.vip,roomtype.price,roomtype.price*0.8, rooms.time from rooms,roomtype,customer where rooms.roomtype = roomtype.type and  rooms.roomid = customer.roomid and state='3'and rooms.roomid='"+roomid+"' order by customer.vip ";				
				System.out.println(sql);
				 rs = st.executeQuery(sql);
				if(rs.next()){
					String time = rs.getString(8);
				    hours = (int)time(gettime(),time);
					quanjia = hours * rs.getInt(6);
				    zhejia = hours * rs.getInt(7);	
				    p.setRoomid(rs.getString(1));
				    p.setRoomtype(rs.getString(2));
				    p.setVipcard(rs.getString(5));
				    p.setQuanjia(quanjia+"");
				    if(rs.getString(5)==null)
				    p.setZhejia(quanjia+"");
				    else
				    p.setZhejia(zhejia+"");
				    p.setHours(hours+"");
				    p.setVipcard(rs.getString(5));
				}
		
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
	       finally{
				
			}
	  	  
	  	  return p;
	    }
	public String gettime() {
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String s = sdf.format(now);
		return s;
	}
	public  long time(String nowtime,String datetime){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		   java.util.Date now = null;
		   java.util.Date date = null;
		try {
			now = df.parse(nowtime);
			if(datetime!=null)
			date =df.parse(datetime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		   long l=now.getTime()-date.getTime();
		   long day=l/(24*60*60*1000);
		   long hour=(l/(60*60*1000)-day*24);
		   long min=((l/(60*1000))-day*24*60-hour*60);
		   long s=(l/1000-day*24*60*60-hour*60*60-min*60);
		   long hours = day*24+hour;
		   System.out.println(""+day+"天"+hour+"小时"+min+"分"+s+"秒  入住了"+hours);
		   return hours;
		}
}
