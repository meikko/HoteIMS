<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>top</title>
<link href="css/body_pic.css" rel="stylesheet" type="text/css"
	media="screen" />
<link rel="alternate stylesheet" href="css/red.css" type="text/css"
	title="red" media="screen, projection" />
<link rel="stylesheet" href="css/green.css" type="text/css"
	title="green" media="screen, projection" />
<link rel="alternate stylesheet" href="css/yellow.css" type="text/css"
	title="yellow" media="screen, projection" />
<script language="javascript" src="js/switcher.js"></script>
<script language="javascript" src="js/mytableright.js"></script>
<script language="javascript" src="js/javascript.js"></script>
<script language="javascript" src="js/scroll.js"></script>
<script language="javascript" src="js/skin.js"></script>
<script language="javascript">
	function ref(){
    parent.location.reload();      
 }
</script>

</head>

<body class="bodybgcol">
	<table width="98%" border="0" cellspacing="0" cellpadding="0"
		class="marcen" style="margin-left: 1%">
		<tr>
			<td valign="top"><table border="0" cellpadding="0"
					cellspacing="0" class="table100 list1_box1_top">
					<tr>
						<td class="list1_box1_top_left">注册会员</td>
						<td>&nbsp;</td>
						<td class="list1_box1_top_right">&nbsp;</td>
					</tr>
				</table>
				<table border="0" cellpadding="0" cellspacing="0" class="table100">
					<form action="vipRegister" method="post">
						<tr>
							<td height="117" class="list1_box1_main_left">&nbsp;</td>
							<td align="center"><table width="98%" border="0"
									align="center" cellpadding="0" cellspacing="0"
									class="search_box">
									<tr>
										<td align="right">姓名</td>
										<td><input type="text" name="name"></td>
										<td align="right">公民身份号码</td>
										<td><input type="text" name="idcard"></td>
									</tr>
									<tr>
										<td align="right">联系电话</td>
										<td><input type="text" name="phone"></td>
										<td align="right">性别<br></td>
										<td><select name="sex">
												<option></option>
												<option value="男">男</option>
												<option value="女">女</option>
										</select></td>
									</tr>
									<tr>
										<td align="right">密码<br></td>
										<td><input type="password" name="password"></td>
										<td align="right"><br></td>
										<td><br></td>
									</tr>
									<tr>
										<td align="right"><br></td>
										<td><br></td>
										<td align="right"><br></td>
										<td></td>
									</tr>
								</table> <input type="submit" name="Submit" value="注册"></td>
							<td class="list1_box1_main_right">&nbsp;</td>
						</tr>
					</form>
				</table>
				<table border="0" cellpadding="0" cellspacing="0"
					class="table100 list1_box1_bottom">
					<tr>
						<td class="list1_box1_bottom_left">&nbsp;</td>
						<td>&nbsp;</td>
						<td class="list1_box1_bottom_right">&nbsp;</td>
					</tr>
				</table></td>
		</tr>
	</table>
	<table width="98%" border="0" cellspacing="0" cellpadding="0"
		class="marcen" style="margin-left: 1%">
		<tr>
			<td valign="top">&nbsp;</td>
		</tr>
	</table>


	<div id=col_r>
		<br />
	</div>
</body>
</html>
