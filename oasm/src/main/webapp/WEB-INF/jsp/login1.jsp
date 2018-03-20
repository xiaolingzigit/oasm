<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>欢迎您进入登陆页面</title>
 <link rel="stylesheet" type="text/css" href="<c:url value='/resource/css/login.css'/>" />
</head>
<body>
    <div class="log-bg">
        <img src="<c:url value='/resource/images/login_bg.png'/>" alt="" />
     <!--     <div class="txt-pos">
            <p><strong>广 东 省 监 狱 罪 犯</strong><br/>
                <span><strong>危 险 性 评 估 系 统</strong></span>
            </p>
        </div>-->
        <div class="log-form">
            <form id="loginForm" method="post">
            	<%session.setAttribute("name","123");%>
               <span id="loginInfo"></span><span id="loginBlank"></span><span id="loginManager"></span>
                <table   cellpadding="8" cellspacing="0" style="border-collapse:collapse "  >
                    <tr class=log-tr>
                        <td class="log-td"><label for="inp1">账 号：</label></td>
                        <td colspan="2" style="text-align: left"><input type="text" name="jh"></td>
                    </tr>
                    <tr class=log-tr>
                        <td class="log-td"><label for="inp2">密 码：</label></td>
                        <td colspan="2" style="text-align: left"><input type="password" name="ma" ></td>
                    </tr>
                    <tr class="log-tr2">
                        
                        <td></td>
                        <td><input type="reset" name="" class="btn" value="重 置" style="width: 100%;height: 40px;font-size: 20px;" /></td>
                        <td><input type="button" name="" id="loginSub" class="sub" value="登 录" style="width: 100%;height: 40px;font-size: 20px;"/></td>
                    </tr>
                    </table>
            </form>
        </div>
 <p class="log-bot">版权所有：广东省监狱管理局&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;技术支持：北明软件有限公司</p>
    </div>
 <script type="text/javascript" src="<c:url value='/resource/js/jquery-1.7.2.min.js'/>"></script>
  <script type="text/javascript" src="<c:url value='/resource/js/login/login.js'/>"></script>
</body>

</html>