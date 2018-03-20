<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>插入警察信息</title>
</head>
<body>
   <form action="${pageContext.request.contextPath}/jyxx/testAop" method="post">
      警号：<input type="text" value="" name="jh"/>
     警察姓名:<input type="text" value="" name="jcxm"/>
     <input type="submit" value="提交"/>
   </form>
</body>
</html>