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
<script type="text/javascript">
var xmlhttp;

function createRequest() {
	if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp = new XMLHttpRequest();
	} else {// code for IE6, IE5
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
}
function callback() {
		if (4 == xmlhttp.readyState) {
			if (200 == xmlhttp.status) {
				document.getElementById("mess").innerHTML = xmlhttp.responseText ;
			}
		} else {
			document.getElementById("mess").innerHTML = "<font color='red'>"
					+ "正在查询...." + "</font>";
		}
	}
function checkUserName() {
	//1.获取请求，创建对象(XMLHttpRequest的对象)
	createRequest();
	//2.建立要连接的URL
	//var uname = document.getElementById("username").value;
	var url = "EnterRoomCheck";
	//3.设置回调函数
	xmlhttp.onreadystatechange = callback;//特殊注意设置回调函数的时候没有括号只写函数名即可
	//4.建立与服务器的连接
	xmlhttp.open("POST", url, true);
	//5.发送请求
	xmlhttp.send(null);

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
						<td class="list1_box1_top_left">退房结账</td>
						<td>&nbsp;</td>
						<td class="list1_box1_top_right">&nbsp;</td>
					</tr>
				</table>
				<form action="payAll" method="post">
					<table border="0" cellpadding="0" cellspacing="0" class="table100"
						width="698" height="121">
						<tr>
							<td height="117" class="list1_box1_main_left">&nbsp;</td>
							<td align="center"><table width="98%" border="0"
									align="center" cellpadding="0" cellspacing="0"
									class="search_box">
									<tr>
										<td align="right">房间号<br></td>


										<td align="left"></td>


										<td width="100"><table>
												<tr>
													<td><div id="mess"></div></td>
													<td><input type="button" onclick="checkUserName();"
														value="获取当前已入住房间" style='font-size:10px'></td>
												</tr>
											</table></td>

										<td align="left"><input type="submit" name="Submit"
											value="查询 " style='font-size:10px'></td>

										<td><br></td>
									</tr>
								</table> <br>
								</form></td>
							<td class="list1_box1_main_right">&nbsp;</td>
						</tr>
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
	<form action="payCon" method="post">
		<table width="98%" border="0" cellspacing="0" cellpadding="0"
			class="marcen" style="margin-left: 1%">
			<tr>
				<td valign="top">
					<table border="0" cellpadding="0" cellspacing="0"
						class="table100 list1_box1_top">
						<tr>
							<td class="list1_box1_top_left">查询列表</td>
							<td>&nbsp;</td>
							<td class="list1_box1_top_right">&nbsp;</td>
						</tr>
					</table>

					<table border="0" cellpadding="0" cellspacing="0" class="table100">
						<tr>
							<td class="list1_box1_main_left">&nbsp;</td>
							<td><table border="0" cellpadding="0" cellspacing="0"
									class="table100 list1_top">

									<tr>
										<td class="list1_top_tr1_td1">数据列表</td>
										<td><table border="0" cellpadding="0" cellspacing="0"
												class="table100">
												<tr>
													<td><a href="payAll">[待结账房间列表]</a></td>
													<td class="list1_top_button"><button type="submit"
															class="list1_top_edit button_Properties1">结账</button>
												</tr>
											</table></td>
										<td class="list1_top_tr1_td3">&nbsp;</td>
									</tr>
								</table>
								<table border="0" cellpadding="0" cellspacing="0"
									class="table100 list1_main">
									<tr>
										<td class="list1_main_td1">&nbsp;</td>
										<td valign="top"><table border="0" cellpadding="0"
												cellspacing="1" class="table100 list1_list1">
												<colgroup span="20"
													style="background: #FFFFFF; text-align: center;">
												</colgroup>
												<tr class="list1_list1_top">
													<td>房间号<br></td>
													<td>房间类型</td>
													<td>额定人数</td>
													<td>房间状态</td>
													<td>开房时间<br></td>
													<td>入住小时数</td>
													<td>会员卡号</td>
													<td>全价</td>
													<td>80%折后价</td>
													<td>实际应付</td>
													<td>操作</td>

												</tr>
												<%=request.getAttribute("msg") %>

											</table></td>
										<td class="list1_main_td3">&nbsp;</td>
									</tr>

								</table>
								<table border="0" cellpadding="0" cellspacing="0"
									class="table100 list1_bottom">
									<tr>
										<td class="list1_bottom_tr1_td1">&nbsp;</td>
										<td><table width="300" border="0" align="right"
												cellpadding="0" cellspacing="0">
												<tr align="center">
													<td><a href="#" class="list1_bottom_pages_links">首页</a>
													</td>
													<td><a href="#" class="list1_bottom_pages_links">上一页</a></td>
													<td><a href="#" class="list1_bottom_pages_links">下一页</a></td>
													<td><a href="#" class="list1_bottom_pages_links">尾页</a></td>
													<td>转到第 <input name="pages" type="text"
														class="list1_bottom_pages_input" id="pages" size="4" /> 页
													</td>
													<td><a href="#" class="list1_bottom_pages_goto_link">转</a></td>
												</tr>
											</table></td>
										<td class="list1_bottom_tr1_td3">&nbsp;</td>
									</tr>
								</table></td>
							<td class="list1_box1_main_right">&nbsp;</td>
						</tr>
					</table>

					<table border="0" cellpadding="0" cellspacing="0"
						class="table100 list1_box1_bottom">
						<tr>
							<td class="list1_box1_bottom_left">&nbsp;</td>
							<td>&nbsp;</td>
							<td class="list1_box1_bottom_right">&nbsp;</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</form>

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