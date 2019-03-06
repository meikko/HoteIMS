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
	function vipcheck() {
		if (4 == xmlhttp.readyState) {
			if (200 == xmlhttp.status) {
				document.getElementById("vipmess").innerHTML ="<font color='#ff0000'>"+ xmlhttp.responseText + "</font>";
			}
		} else {
			document.getElementById("vipmess").innerHTML = "<font color='red'>"
					+ "正在验证...." + "</font>";
		}
	}
function checkUserName() {
	//1.获取请求，创建对象(XMLHttpRequest的对象)
	createRequest();
	//2.建立要连接的URL
	//var uname = document.getElementById("username").value;
	var url = "EnterRoomidcheck";
	//3.设置回调函数
	xmlhttp.onreadystatechange = callback;//特殊注意设置回调函数的时候没有括号只写函数名即可
	//4.建立与服务器的连接
	xmlhttp.open("POST", url, true);
	//5.发送请求
	xmlhttp.send(null);

}
function checkvip() {
	//1.获取请求，创建对象(XMLHttpRequest的对象)
	createRequest();
	//2.建立要连接的URL
	var url = "vipcheck?vip="+document.getElementById("vip").value;
	//3.设置回调函数
	xmlhttp.onreadystatechange = vipcheck; //特殊注意设置回调函数的时候没有括号只写函数名即可
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
						<td class="list1_box1_top_left">预定登记</td>
						<td>&nbsp;</td>
						<td class="list1_box1_top_right">&nbsp;</td>
					</tr>
				</table>
				<form action="BookInsert" method="post">
					<table border="0" cellpadding="0" cellspacing="0" class="table100"
						width="698" height="121">
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
										<td align="right">预定时间</td>
										<td><input type="text" name="booktime"></td>
										<td align="right">性别</td>
										<td><select name="sex">
												<option>--请选择--</option>
												<option>男</option>
												<option>女</option>
										</select></td>
									</tr>
									<tr>
										<td align="right">房间号</td>
										<td><table>
												<tr>
													<td><div id="mess"></div></td>
													<td><input type="button" onclick="checkUserName()"
														value="获取当前空闲房间" style='font-size:10px'></td>
												</tr>
											</table></td>
										<td align="right">电话号码</td>
										<td><input type="text" name="phone"></td>
									</tr>
									<tr>
										<td align="right">会员号</td>
										<td><input type="text" name="vip" id="vip"
											onblur="checkvip()"></td>
										<td align="right">是否提供早餐</td>
										<td><select name="breakfirst">
												<option>是</option>
												<option>否</option>
										</select></td>
									</tr>
									<tr>
										<td>
										<td><div id="vipmess"></div></td>
										</td>
									</tr>

								</table> <input type="submit" name="Submit" value="预定"></td>
							<td class="list1_box1_main_right">&nbsp;</td>
						</tr>
					</table>
				</form>
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
								<form action="BookDel" method="post">
									<tr>
										<td class="list1_top_tr1_td1">数据列表</td>
										<td><table border="0" cellpadding="0" cellspacing="0"
												class="table100">
												<tr>
													<td><a href="BookAll">[预订登记全员列表]</a></td>
													<td class="list1_top_button">
														<button type="submit"
															class="list1_top_del button_Properties1">删除</button>
													</td>
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
												<td>序列号<br></td>
												<td>姓名</td>
												<td>身份证号</td>
												<td>预定时间</td>
												<td>房间号</td>
												<td>电话号码</td>
												<td>会员卡号</td>
												<td>性别<br></td>
												<td>是否有早餐</td>
												<td>是否转入住</td>
												<td>操作</td>
											</tr>
											<%=request.getAttribute("msg") %>

										</table></td>
									<td class="list1_main_td3">&nbsp;</td>
								</tr>
								</form>
							</table>
							<table border="0" cellpadding="0" cellspacing="0"
								class="table100 list1_bottom">
								<tr>
									<td class="list1_bottom_tr1_td1">&nbsp;</td>
									<td><table width="300" border="0" align="right"
											cellpadding="0" cellspacing="0">
											<tr align="center">
												<td><a>首页</a></td>
												<td><a href="" class="list1_bottom_pages_links">上一页</a></td>
												<td><a href="" class="list1_bottom_pages_links">下一页</a></td>
												<td><a href="" class="list1_bottom_pages_links">尾页</a></td>
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
