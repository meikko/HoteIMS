<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
<link rel="shortcut icon" href="images/favicon.ico" >
    <base href="<%=basePath%>">
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登录页-优选酒店后台</title>
<script>
var _hmt = _hmt || [];
(function() {
  var hm = document.createElement("script");
  hm.src = "https://hm.baidu.com/hm.js?006e757e7d56e5ff4c2e7c13d4f01744";
  var s = document.getElementsByTagName("script")[0]; 
  s.parentNode.insertBefore(hm, s);
})();
</script>
<style>
a{text-decoration:none} 
</style>
<script src="js/jquery-1.8.0.min.js" type="text/javascript" ></script>


<link rel="stylesheet" type="text/css" href="css/register.css"/>

<style type="text/css">
<!--
.STYLE1 {
	font-size: 50px;
	font-family: "楷体";
	color: #66FFFF;
}
-->
</style>
</head>
<body>


<div class='signup_container'>
    <h1 class='signup_title'>用户登录</h1>
    <img src='images/people.png' id='admin'/>
    <div id="signup_forms" class="signup_forms clearfix">
            <form class="signup_form_form" id="signup_form" method="post" action="LoginServlet" data-secure-action="" data-secure-ajax-action="">
                    <div class="form_row first_row">
                        <label for="signup_email">请输入用户名</label>
                        <input type="text" name="username" placeholder="请输入用户名" id="signup_name" data-required="required">
                    </div>
                    <div class="form_row">
                        <label for="signup_password">请输入密码</label>
                        <input type="password" name="password" placeholder="请输入密码" id="signup_password" data-required="required">
                    </div>        
    </div>
        <div class="login-btn-set"><div class='rem'>记住我</div><input type="submit" class="login-btn" value=""></input></div>
     			</form>
    GitHub: <a target="_blank" href="https://github.com/SocttsTiger/HoteIMS.git">github.com/SocttsTiger/HoteIMS</a><br><br>
    Copyright &copy; 2018-2019 &nbsp;JUNHAN.FANG<br>All Rights Reserved<br><br>
	<a target="_blank" href="http://www.miitbeian.gov.cn/">辽ICP备19001415号</a>&nbsp;&nbsp;
	<a target="_blank" href="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=21020402000738">辽公网安备21020402000738号</a>    
</div>

</body>

<script type="text/javascript">

$(function(){

    $('.rem').click(function(){
        $(this).toggleClass('selected');
    })

    $('#signup_select').click(function(){
        $('.form_row ul').show();
        event.cancelBubble = true;
    })

    $('#d').click(function(){
        $('.form_row ul').toggle();
        event.cancelBubble = true;
    })

    $('body').click(function(){
        $('.form_row ul').hide();
    })

    $('.form_row li').click(function(){
        var v  = $(this).text();
        $('#signup_select').val(v);
        $('.form_row ul').hide();
    })


})


</script>

</html>

<script> 
//取出传回来的参数error并与false比较
  var errorio ='<%=request.getParameter("error")%>'; 
  if(errorio=='false'){
	  alert("用户名或密码错误！");
  	}   
  
  if(errorio=='filter'){
	   alert("身份校验失败，请重新登录！");
	}
</script>