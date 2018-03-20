<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link href="<c:url value='/resource/css/bootstrap.css'/>"
	rel="stylesheet" />
<link href="<c:url value='/resource/css/page.css'/>"
	rel="stylesheet" />
<link
	href="<c:url value='/resource/assets/css/bootstrap-responsive.css'/>"
	rel="stylesheet" />
<link href="<c:url value='/resource/assets/css/custom.css'/>"
	rel="stylesheet" />


</head>
<body>
	<div class="table-responsive">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>员工号</th>
					<th>姓名</th>
					<th>职位</th>
					<th>联系</th>
					<th>部门人</th>
					<th>薪资</th>
					<th>奖金</th>
					<th>部门号</th>
				</tr>
			</thead>
			<tbody id="adminTbody">
				<c:forEach items="${emp}" var="e">
					<tr>
						<td>${e.empno }</td>
						<td>${e.ename }</td>
						<td>${e.job }</td>
						<td>${e.mgr }</td>
						<td>${e.hiredate }</td>
						<td>${e.sal }</td>
						<td>${e.comm }</td>
						<td>${e.deptno }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div id="barcon" class="barcon" >    
          <div id="barcon1" class="barcon1"></div>    
           <div id="barcon2" class="barcon2">    
            <ul>    
                <li><a id="firstPage" class="btn btn-default">首页</a></li>    
                <li><a id="prePage" class="btn btn-default">上一页</a></li>    
                <li><a id="nextPage" class="btn btn-default">下一页</a></li>    
                <li><a id="lastPage" class="btn btn-default">尾页</a></li>    
                <li><select id="jumpWhere" style="width: 50px;height: 30px;"></select></li>    
                <li><a id="jumpPage" onclick="jumpPage()" class="btn btn-default">跳转</a></li>    
            </ul>    
         </div>    
      </div>
	</div>
<script src="<c:url value='/resource/assets/js/jquery-1.10.2.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/resource/js/page.js'/>"></script>
<script src="<c:url value='/resource/assets/js/custom.js'/>"></script>
<script type="text/javascript">
 jQuery(function(){
	 goPage(1,5);
  });
</script>
</body>
</html>