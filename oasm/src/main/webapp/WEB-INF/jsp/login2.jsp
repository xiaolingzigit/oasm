<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>欢迎您进入登陆页面</title>
 <style>
 html {  
  height:100%;  
} 
 body{
  background:#163676;
 /* background-image:url(<c:url value='/resource/images/login_bg.png'/>);
 background-repeat:no-repeat;
 background-size:100% 100%;
 position: relative;*/
 }

 .form_div{
 background:#fff;
 margin:0 auto;
 height:50%;
 width:50%;
/* margin-top:200px;*/
 top: 28%;
 left:28%;
 background-image:url(<c:url value='/resource/images/form_bg.png'/>);
 background-repeat:no-repeat;
 background-size:100% 100%;
position:absolute;

 }
 .table_div{
 height:50%;
 width:40%;
 /*margin-top:200px;
 margin-left:400px;*/
      left: 50%;
     top: 48%;
 position:absolute;
 }
 .login_table{
 height:100%;
 width:98%;
 
 }
 .login_table td{
 height:98%;
 }
.login_tr{
 font-size: 26px;
    width:100%;
    height:40%;
}
.login-tr2{
     height:30%;
}
 .td01{
text-align: right;
 width:30%;
 }
 .td02{
 width:70%;
 color: #4687DF;
 
 }
  .td02 input{
 width:90%;
 height:90%;
 color: #4687DF;
 font-size: 23px;
 }
  .sub{
     width:40%;
     height:100%;
     text-align:center;
     letter-spacing:2px;
     line-height:25px;
     border:none;
     color:#FFFFFF;
     cursor:pointer;
      font-size: 20px;
     background-image: url(<c:url value='/resource/images/icon_7.png'/>);
     background-repeat: repeat-x;
    }
 .btn{
     width:40%;
     height:100%;
     text-align:center;
     letter-spacing:2px;
     line-height:25px;
     border:none;
     color:#FFFFFF;
     cursor:pointer;
     background-image: url(<c:url value='/resource/images/icon_7.png'/>);
     background-repeat: repeat-x;
     font-size: 20px;
    }
 .foot_div{
 /*margin-top:15%;*/
width:100%;
text-align:center;
 }
 </style>
</head>
<body>

<div class="form_div">
<div class="table_div">
<form id="loginForm" method="post">
<%session.setAttribute("name","123");%>
<span id="loginInfo"></span><span id="loginBlank"></span><span id="loginManager"></span>
<table class="login_table">
<tr class="login_tr"><td class="td01">账&nbsp;&nbsp;号：</td><td class="td02"><input type="text" name="jh" /></td></tr>
<tr class="login_tr"><td class="td01">密&nbsp;&nbsp;码：</td><td class="td02"><input type="password" name="ma" /></td></tr>
<tr class="login_tr"><td></td><td></td></tr>
<tr class="login_tr2"><td colspan="2">
<div style="margin-left:30%"><input type="reset" name="" class="btn" value="重置" />
<input type="button" name="" id="loginSub" class="sub" value="登录"/></div>
</td>
</tr>
</table>
</form>
</div>
</div>
 <div class="foot_div"><p >版权所有：广东省监狱管理局&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;技术支持：北明软件有限公司</p></div>

 <script type="text/javascript" src="<c:url value='/resource/js/jquery-1.7.2.min.js'/>"></script>
  <script type="text/javascript" src="<c:url value='/resource/js/login/login.js'/>"></script>

</body>

</html>