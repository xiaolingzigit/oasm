<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>危险评估系统后台登陆页面</title>
<link href="<c:url value='/resource/systemBlank/assets/css/adminLogin.css'/>" rel="stylesheet">
</head>
<body>
<div id="login">
<h1>出监评估系统后台管理</h1>	
	<form  method="post" id="adminBlankForm">
		<p id="errorInfo"></p>
		<p><input type="text" name="username" id="user" placeholder="用户名" title="4-11个字符、不包含中文"></p>
		<p><input type="password" name="password" id="pwd" placeholder="密码" title="4到16位（字母，数字，下划线，减号）"></p>
		<p><input type="button" id="adminSubmit" onclick="checkAdmin()" value="登录"></p>
	</form>
</div>
<script src="<c:url value='/resource/systemBlank/assets/js/jquery-1.10.2.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resource/systemBlank/assets/js/page/adminLogin.js'/>"></script>
</body>
</html>