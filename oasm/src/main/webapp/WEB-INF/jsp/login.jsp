<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>欢迎登陆危险评估系统</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resource/css/login.css'/>" />
</head>
<body>

<div id="login_title">
<div class="ghlogo"></div><h1>广东省监狱罪犯危险性评估系统</h1>
</div>
<div id="login">
<form id="loginForm" method="post">
            	<%session.setAttribute("name","123");%>
		<span id="loginInfo"></span><span id="loginBlank"></span><span id="loginManager"></span>
		<p><span class="user">账号</span>：<input type="text" name="jh" id="user"></p>
		<p><span class="pwd">密码</span>：<input type="password" name="ma" id="pwd"  ></p>
		<p ><input type="reset" class="btn"  value="重置"><input type="button" class="sub" id="loginSub" value="登录"></p>
	</form>
	
</div>
<div class="copyright"><p >版权所有：广东省监狱管理局&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;技术支持：北明软件有限公司</p></div>
<script type="text/javascript" src="<c:url value='/resource/js/jquery-1.7.2.min.js'/>"></script>
  <script type="text/javascript" src="<c:url value='/resource/js/login/login.js'/>"></script>
</body>
</html>