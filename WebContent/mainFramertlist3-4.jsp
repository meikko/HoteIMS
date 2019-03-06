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
						<td class="list1_box1_top_left">查询条件</td>
						<td>&nbsp;</td>
						<td class="list1_box1_top_right">&nbsp;</td>
					</tr>
				</table>

				<form action="RoommsgManage" method="post">
					<table border="0" cellpadding="0" cellspacing="0" class="table100">
						<tr>
							<td class="list1_box1_main_left">&nbsp;</td>
							<td align="center"><table width="98%" border="0"
									align="center" cellpadding="0" cellspacing="0"
									class="search_box">
									<tr>
										<td align="right">房间号</td>
										<td><input type="text" name="textfield"></td>
										<td align="right">状态<br></td>
										<td><select name="combobox2">
												<option></option>
												<option value="0">空闲</option>
												<option value="1">清理中</option>
												<option value="2">已预订</option>
												<option value="3">已入住</option>
										</select></td>
									</tr>


									<tr>
										<td align="right">&nbsp;</td>
										<td>&nbsp;</td>
										<td align="right">&nbsp;</td>
										<td>&nbsp;</td>
									</tr>
								</table> <input type="submit" name="Submit" value="查询"></td>
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
								<form action="RoomsgDel" method="post">
									<tr>
										<td class="list1_top_tr1_td1">数据列表</td>
										<td><table border="0" cellpadding="0" cellspacing="0"
												class="table100">
												<tr>
													<td><a href="Roommsgall">[所有房间查询列表]</a></td>
													<td class="list1_top_button"><button type="button"
															class="list1_top_edit button_Properties1">新增</button>
														<button type="button"
															class="list1_top_refresh button_Properties1">修改</button>
														<button type="button"
															class="list1_top_quit button_Properties1">查看</button>
														<button type="submit"
															class="list1_top_del button_Properties1">删除</button></td>
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
											<colgroup span="7"
												style="background: #FFFFFF; text-align: center;">
											</colgroup>
											<tr class="list1_list1_top">
												<td>客房编号</td>
												<td>类型</td>
												<td>状态</td>
												<td>楼层</td>
												<td>价格</td>
												<td>操作</td>

											</tr>
											<%=request.getAttribute("msg") %>
										</table></td>
									<td class="list1_main_td3">&nbsp;</td>
								</tr>
							</table>
							</form>
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
