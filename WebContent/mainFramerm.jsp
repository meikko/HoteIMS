<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<TITLE>我的办公桌</TITLE>
<META http-equiv=Content-Type content="text/html; charset=gb2312" />
<link href="css/body_pic.css" rel="stylesheet" type="text/css"
	media="screen" />
<script language="javascript" src="js/skin.js"></script>
<script language="javascript" src="js/fream_cols.js"></script>
</head>

<body>
	<table width="100%" border="0" cellspacing="0" cellpadding="0"
		class="Current">
		<tr>

			<td width="340"><table width="500" border="0" cellspacing="0"
					cellpadding="0">
					<tr>
						<td width="27" class="Current_logo">&nbsp;</td>
						<td width="400" align="left">欢迎当前用户：<a href="#"></a><%=session.getAttribute("u") %></td>
						<td width="2" align="left"><font></font></td>
					</tr>
				</table></td>
			<td><div class="displa">
					<img src="images/display.gif" onclick="switchBar(this)"
						title="关闭顶部页面" style="cursor: pointer" border="0" />
				</div></td>
		</tr>
	</table>
</body>
</html>