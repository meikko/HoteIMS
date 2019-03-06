<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel="shortcut icon" href="images/favicon.ico" >
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"
	src="mainFramerb.html" />
<title>优选酒店管理系统</title>
<!-- <script language="javascript" src="js/welcom.js"></script> -->
</head>

<frameset rows="83,*" cols="*" frameborder="no" border="0"
	framespacing="0" id="txt">
	<!--这一块是页面顶部  -->
	<frame src="topFrame.html" name="topFrame" scrolling="No"
		noresize="noresize" id="topFrame" title="topFrame" />
	<frameset cols="192,8,*" frameborder="no" border="0" framespacing="0"
		id="mainFrame">
		<frameset rows="40,*" cols="*" frameborder="no" border="0"
			framespacing="0">
			<!--这一块是左侧菜单  -->
			<frame src="mainFramelt.html" name="mainFramelt" scrolling="no"
				noresize id="mainFramelt" title="mainFramelt" />
			<frame src="mainFramelb.html" name="mainFramelb" scrolling="no"
				noresize id="mainFramelb" title="mainFramelb" />
		</frameset>

		<frame src="mainFramem.html" name="mainFramem" scrolling="no"
			noresize="noresize" id="mainFramem" title="mainFramem" />

		<frameset rows="31,*,26" cols="*" frameborder="no" border="0"
			framespacing="0">
			<!--这一块是锁屏界面  -->
			<frame src="mainFramerm.jsp" name="mainFramerm" scrolling="no"
				noresize="noresize" id="mainFramerm" title="mainFramerm" />
			<!--这一块是业务1-1  -->
			<frame src="mainFramertlist1-1.jsp" name="mainFramert"
				scrolling="yes" noresize="noresize" id="mainFramert"
				title="mainFramert" />
			<!--这一块是页面底部  -->
			<frame src="mainFramerb.html" name="mainFramerb" scrolling="no"
				noresize="noresize" id="mainFramerb" title="mainFramerb" />
		</frameset>
	</frameset>

</frameset>
<noframes>
	<body></body>

</noframes>
</html>
