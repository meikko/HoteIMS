package com.fjh.pay.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fjh.domain.Roommsg;
import com.fjh.utils.DBUtilManager;

public class payDao {
	public String selectpayall(){
  	  Connection conn = DBUtilManager.getconn();
  	  Statement st = null;
  	 Statement st1 = null;
  	  ResultSet rs = null;
  	  String sql ="";
  	  //ResultSet rs1 = null;
  	  String msg = "";
  	  try {
			st = conn.createStatement();
			st1 = conn.createStatement();
			int hours=0,quanjia=0,zhejia=0;
			
			 sql ="select distinct rooms.roomid,roomtype.typename, roomtype.customernum,rooms.time, customer.vip,roomtype.price,roomtype.price*0.8, rooms.time from rooms,roomtype,customer where rooms.roomtype = roomtype.type and  rooms.roomid = customer.roomid and state='3'and lidian='1' order by rooms.roomid";
			
			rs = st.executeQuery(sql);
			while(rs.next()){
				String time = rs.getString(8);
				{
				
			    hours = (int)time(gettime(),time);
			    quanjia = hours * rs.getInt(6);
				 zhejia = hours * rs.getInt(7);
				}
				msg += "<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+"入住未结账"+"</td><td>"+rs.getString(4)+"</td><td>"+hours+"</td><td>"+rs.getString(5)+"</td><td>"+quanjia+"元</td>";
				if(rs.getString(5)==null){
					msg += "<td>"+quanjia+"元</td><td>"+quanjia+"元</td><td><input type='checkbox' name='checkbox' value='"+rs.getString(1)+"' /></td></tr>";
					
				}
				else
				{	msg += "<td>"+zhejia+"元</td>";
				if(zhejia<quanjia)
					msg += "<td>"+zhejia+"元</td><td><input type='checkbox' name='checkbox' value='"+rs.getString(1)+"' /></td></tr>";
				else
					msg += "<td>"+quanjia+"元</td><td><input type='checkbox' name='checkbox' value='"+rs.getString(1)+"' /></td></tr>";
				}
				
				
			}
	
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
       finally{
			
		}
  	  
  	  return msg;
    }
	

	public String selectpay(Roommsg room){
		System.out.println(room.getRoomid());
	  	  Connection conn = DBUtilManager.getconn();
	  	  Statement st = null;
	  	 Statement st1 = null;
	  	  ResultSet rs = null;
	  	  String sql ="";
	  	  //ResultSet rs1 = null;
	  	  String msg = "";
	  	  try {
				st = conn.createStatement();
				st1 = conn.createStatement();
				int hours=0,quanjia=0,zhejia=0;
				
				 sql ="select distinct rooms.roomid,roomtype.typename, roomtype.customernum,rooms.time, customer.vip,roomtype.price,roomtype.price*0.8, rooms.time from rooms,roomtype,customer where rooms.roomtype = roomtype.type and  rooms.roomid = customer.roomid and state='3' and rooms.roomid='"+room.getRoomid()+"'and lidian='1' order by rooms.roomid";
			
				rs = st.executeQuery(sql);
				while(rs.next()){
					String time = rs.getString(8);
					{
					
				    hours = (int)time(gettime(),time);
				    quanjia = hours * rs.getInt(6);
					 zhejia = hours * rs.getInt(7);
					}
					msg += "<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+"实际人数无法确定"+"</td><td>"+rs.getString(4)+"</td><td>"+hours+"</td><td>"+rs.getString(5)+"</td><td>"+quanjia+"元</td>";
					if(rs.getString(5)==null){
						msg += "<td>"+quanjia+"元</td><td>"+quanjia+"元</td><td><input type='checkbox' name='checkbox' value='"+rs.getString(1)+"' /></td></tr>";
						
					}
					else
					{	msg += "<td>"+zhejia+"元</td>";
					if(zhejia<quanjia)
						msg += "<td>"+zhejia+"元</td><td><input type='checkbox' name='checkbox' value='"+rs.getString(1)+"' /></td></tr>";
					else
						msg += "<td>"+quanjia+"元</td><td><input type='checkbox' name='checkbox' value='"+rs.getString(1)+"' /></td></tr>";
					}
					
					
				}
		
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
	       finally{
				
			}
	  	  
	  	  return msg;
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
