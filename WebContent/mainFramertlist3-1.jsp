<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>top</title>
<base href="<%=basePath%>">
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

<style type="text/css">
<!--
.STYLE1 {
	font-size: 12px
}
-->
</style>
</head>

<body class="bodybgcol">
	<table width="98%" border="0" cellspacing="0" cellpadding="0"
		class="marcen" style="margin-left: 1%">
		<tr>
			<td valign="top"><table border="0" cellpadding="0"
					cellspacing="0" class="table100 list1_box1_top">
					<tr>
						<td class="list1_box1_top_left STYLE1">查询客房类型</td>
						<td>&nbsp;</td>
						<td class="list1_box1_top_right">&nbsp;</td>
					</tr>
				</table>
				<form action="RoomtypeManage" method="post">
					<table border="0" cellpadding="0" cellspacing="0" class="table100">
						<tr>
							<td class="list1_box1_main_left">&nbsp;</td>
							<td align="center"><table width="98%" border="0"
									align="center" cellpadding="0" cellspacing="0"
									class="search_box">
									<tr>
										<td align="right">类型号</td>
										<td><input type="text" name="textfield" id="textfield"></td>
										<td align="right">类型</td>
										<td><label> <select name="select3" id="select3">
													<option value="0">--请选择--</option>
													<option value="1">单人间</option>
													<option value="2">双人间</option>
													<option value="3">四人间</option>
													<option value="4">家庭套房</option>
													<option value="5">商务房</option>
													<option value="6">豪华房</option>
													<option value="7">总统套房</option>
													
											</select>
										</label></td>
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
					<form action="RoomtypeDel" method="post">
						<tr>
							<td class="list1_box1_main_left">&nbsp;</td>
							<td><table border="0" cellpadding="0" cellspacing="0"
									class="table100 list1_top">
									<tr>
										<td class="list1_top_tr1_td1">数据列表</td>
										<td><table border="0" cellpadding="0" cellspacing="0"
												class="table100">
												<tr>
													<td><a href="SecletTest" onclick="">[房间配置查询列表]</a>
													</td>
													<td class="list1_top_button"><button type="button"
															class="list1_top_edit button_Properties1"
															onclick="window.location.href='RoomtypeAdd'">新增</button>
														<button type="button"
															class="list1_top_refresh button_Properties1">修改</button>
														<button type="button"
															class="list1_top_quit button_Properties1">查看</button> <a
														href="#"><button type="submit"
																class="list1_top_del button_Properties1">删除</button></td>
													</a>
												</tr>
											</table></td>
										<td class="list1_top_tr1_td3">&nbsp;</td>
									</tr>
								</table>
								<table border="0" cellpadding="0" cellspacing="0"
									class="table100 list1_main">
									<tr>
										<td class="list1_main_td1">&nbsp;</td>
										<td valign="top">
											<table border="0" cellpadding="0" cellspacing="1"
												class="table100 list1_list1">
												<colgroup span="10"
													style="background: #FFFFFF; text-align: center;">
												</colgroup>
												<tr class="list1_list1_top">
													<td>类型编号</td>
													<td>类型名称</td>
													<td>额定人数</td>
													<td>价格 <br></td>
													<td>淋浴</td>
													<td>网线 <br></td>
													<td>备注 <br></td>
													<td>操作<br></td>
												</tr>
											<%=request.getAttribute("msg") %>
											</table>
										</td>
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

													<td><%=request.getAttribute("mess") %> <%=request.getAttribute("mess1") %>
														<%=request.getAttribute("mess2") %> <%=request.getAttribute("mess3") %>
														<%=request.getAttribute("mess4") %></td>
													<td>转到第<input name="pages" type="text"
														class="list1_bottom_pages_input" id="pages" size="4" />页
													</td>
													<td><a href="#" class="list1_bottom_pages_goto_link">转</a></td>
												</tr>
											</table></td>
										<td class="list1_bottom_tr1_td3">&nbsp;</td>
									</tr>
								</table></td>
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
				</table>
			</td>
		</tr>
	</table>



	<div id=col_r>
		<br />
	</div>
</body>
</html>
