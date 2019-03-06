package com.fjh.domain;


public class UserBean {
	
	private String uname;
	private String upass;	
	private String nicheng;
	private String youxiang;
	private String quan;
	private String isonline;
	private String time="未传进日期";
	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}


	public UserBean() {

	}
	
	
	public String getNicheng() {
		return nicheng;
	}


	public void setNicheng(String nicheng) {
		this.nicheng = nicheng;
	}


	public String getYouxiang() {
		return youxiang;
	}


	public void setYouxiang(String youxiang) {
		this.youxiang = youxiang;
	}


	public String getQuan() {
		return quan;
	}


	public void setQuan(String quan) {
		this.quan = quan;
	}


	public String getIsonline() {
		return isonline;
	}


	public void setIsonline(String isonline) {
		this.isonline = isonline;
	}


	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpass() {
		return upass;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}
	
	
}
