<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'paylist.jsp' starting page</title>

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
		<font size="6"><%=request.getAttribute("roomid") %>的账单</font><font
			size="5"><br> <br></font>
		<form
			action="/HotelMS/servlet/PayDate?roomid=<%=request.getAttribute("roomid") %>"
			method="post">
			<table width="400" border="1">
				<tbody>
					<tr>
						<td><font size="5">&nbsp;房间编号：</font></td>
						<td><font size="5">&nbsp;<%=request.getAttribute("roomid") %></font></td>
					</tr>
					<tr>
						<td><font size="5">&nbsp;房价类型：</font></td>
						<td><font size="5">&nbsp; <%=request.getAttribute("roomtype") %></font></td>
					</tr>
					<tr>
						<td><font size="5">&nbsp;会员卡号：</font></td>
						<td><font size="5">&nbsp;<%=request.getAttribute("vipcard") %></font></td>
					</tr>
					<tr>
						<td><font size="5">&nbsp;时间合计：</font></td>
						<td><font size="5">&nbsp; <%=request.getAttribute("hours") %>小时
						</font></td>
					</tr>
					<tr>
						<td><font size="5">&nbsp;全价：</font></td>
						<td><font size="5">&nbsp;<%=request.getAttribute("quanjia") %>元
						</font></td>
					</tr>
					<tr>
						<td><font size="5">&nbsp;80%折后价：</font></td>
						<td><font size="5">&nbsp;</font><font color="#ff0000"
							size="5"><strong><%=request.getAttribute("zhejia") %></strong></font><font
							size="5">元</font></td>
					</tr>
					<tr>
						<td><font size="5">&nbsp;</font></td>
						<td><font size="5">&nbsp;</font></td>
					</tr>
					<tr>
						<td><font size="5">&nbsp;</font></td>
						<td><font size="5">&nbsp;</font></td>
					</tr>
				</tbody>
			</table>
			<input type="submit" name="button1" value="结账">
		</form>
</body>
</html>
