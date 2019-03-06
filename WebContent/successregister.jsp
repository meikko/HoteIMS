<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'success.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<div align="center">
		<font size="7" color="#0080ff"><strong><%=request.getAttribute("name") %>已成功注册为会员！</strong></font><br>
		<font size="5"><strong><br>您的会员卡号为：<br> <br>
				<font color="#ff0000" size="7"><%=request.getAttribute("id") %></font><br></strong></font>
	</div>
	<div align="center">
		<br> <br> <a href="/HotelMS/mainFramertlist1-2.jsp">继续注册</a><br>
	</div>
</body>
</html>
