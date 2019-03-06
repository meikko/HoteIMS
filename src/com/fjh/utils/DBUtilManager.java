package com.fjh.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtilManager {
	public static String url;
	private static String username;
	private static String password;
	private static String driverClass;
	
	public static void readPropertiesConfig(){
		InputStream in=DBUtilManager.class.getClassLoader().getResourceAsStream("com/fjh/utils/OracleJdbcManager.properties");
		Properties pro=new Properties();
		try {
			pro.load(in);
		} catch (IOException e) {
			System.out.println(e+"io写入失败");
		}
		
		driverClass=pro.getProperty("driverClass");
		url=pro.getProperty("url");
		username=pro.getProperty("username");
		password=pro.getProperty("password");
	}
	
	public static Connection getconn(){
		Connection conn=null;
		readPropertiesConfig();
		try {
			Class.forName(driverClass);
			conn=DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			System.out.println(e+"数据库连接失败");
		}
		return conn;
	}
	
	public static void closeall(Connection conn, PreparedStatement ps, ResultSet rs){
		try {
			if(conn!=null){			
				conn.close();
			}
			if(ps!=null){
				ps.close();
			}
			if(rs!=null){
				rs.close();
			}
		} catch (SQLException e) {
			System.out.println(e+"数据库关闭异常");
		}
	}	
}
