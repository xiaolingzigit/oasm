<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" /> 
<title>403-您的权限不足-</title>
<style type="text/css">
*{margin:0;padding:0}
body{font-family:"微软雅黑";background:#DAD9D7}
img{border:none}
a *{cursor:pointer}
ul,li{list-style:none}
table{table-layout:fixed;}
table tr td{word-break:break-all; word-wrap:break-word;}

a{text-decoration:none;outline:none}
a:hover{text-decoration:underline}
.cf:after{content: ".";display: block;height: 0;font-size: 0;clear:both;visibility: hidden;}
.cf{zoom: 1;clear:both}

.bg{width:100%;background:url("<c:url value='/resource/img/01.jpg'/>") no-repeat center top #DAD9D7;position:absolute;top:0;left:0;height:600px;overflow:hidden}
.cont{margin:0 auto;width:500px;line-height:20px;}
.c1{height:360px;text-align:center}
.c1 .img1{margin-top:180px}
.c1 .img2{margin-top:165px}
.font
{
color:#999;
font-family : 微软雅黑,宋体;
font-size : 150px;
font-style:italic;
position:relative;
top:100px;
left:130px;
}
.cont h2{text-align:center;color:#555;font-size:18px;font-weight:normal;height:35px}
.c2{height:35px;text-align:center}
.c2 a{display:inline-block;margin:0 4px;font-size:14px;height:23px;color:#626262;padding-top:1px;text-decoration:none;text-align:left}
.c2 a:hover{color:#626262;text-decoration:none;}
.c2 a.home{width:70px;background:url(<c:url value="/resource/img/02.png"/>);padding-left:30px}
.c2 a.home:hover{background:url(<c:url value="/resource/img/02.png"/>) 0 -24px}
.c2 a.home:active{background:url(<c:url value="/resource/img/02.png"/>) 0 -48px}
.c2 a.re{width:70px;background:url(<c:url value="/resource/img/03.png"/>);padding-left:30px}
.c2 a.re:hover{background:url(<c:url value="/resource/img/03.png"/>) 0 -24px}
.c2 a.re:active{background:url(<c:url value="/resource/img/03.png"/>) 0 -48px}
.c2 a.sr{width:160px;background:url(<c:url value="/resource/img/04.png"/>);padding-left:28px}
.c2 a.sr:hover{background:url(<c:url value="/resource/img/04.png"/>) 0 -24px}
.c2 a.sr:active{background:url(<c:url value="/resource/img/04.png"/>) 0 -48px}
.c3{height:180px;text-align:center;color:#999;font-size:12px}
#bf{position:absolute;top:269px;left:0;width:100%}
.bf1{margin:0 auto;width:99px;padding-left:32px}
.bd{height:600px;overflow:hidden}
#box{position:absolute;top:165px;left:0;width:100%;text-align:center}
.bf1{margin:0 auto;width:99px;padding-left:32px}
</style>
<script type="text/javascript" src="resource/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
jQuery(function(){
	jQuery(".re").bind("click",function(){
    	 window.history.go(-1);
      });
  });
</script>
</head>
<body>
<div class="bg">
	<div class="cont">
	    <font class="font">403</font>
		<div class="c1">
		   <img src='<c:url value="/resource/img/01.png"/>' class="img1" />
	    </div>
		 <h2>哎呀......您的权限不足啦！</h2>
		<div class="c2"><a class="re">返回页面</a><a href="index.jsp" class="home">更换用户</a></div>
		<div class="c3"><a href="http://www.shejicool.com" class="c3">系统</a>提醒您 - 您请求访问的页面权限不足</div>
	</div>
</div>
</body>
</html>