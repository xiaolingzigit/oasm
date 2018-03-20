<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>超级管理员添加管理员页面</title>
</head>
<body>
	<ol class="breadcrumb">
		<li><a href="#">首页</a></li>
		<li class="active">超级管理员操作</li>
	</ol>
	<!-- 添加管理员按钮 -->
	<div style="margin-top: 20px;">
		<a href="#modal-container-815572" data-toggle="modal"> <input
			type="button" class="btn btn-success" value="添加管理员" />
		</a>
	</div>
	<!-- 搜索框暂时失效 -->
<!--      <form class="well form-search"> -->
<!-- 		<input type="text" name="key" class="input-medium search-query"> -->
<!-- 		<button type="button" onclick="sousouManager()" class="btn"><i class="icon-search"></i> 搜索</button> -->
<!-- 	 </form> -->
	<!-- 已存在用户列表 -->
	<div class="table-responsive">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>序号</th>
					<th>用户名</th>
					<th>管理员级别</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody id="adminInfo">
				<c:forEach items="${listAdmin}" var="am" varStatus="status">
				<tr>
						<td>${status.count }</td>
						<td class="userquery">${am.username }</td>
						<td><c:if test="${am.status==1}">普通管理员</c:if></td>
						<td>
						   <a onclick="update_by_superadmin(${am.id},'${am.username }')"   data-toggle="modal"> 
						       <span title="编辑" class="glyphicon glyphicon-edit"></span>
						   </a>
						   &nbsp;&nbsp;&nbsp;&nbsp;
						   <a onclick="delect_by_superadmin(${am.id})"><span title="删除" class="glyphicon glyphicon-trash"></span></a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<!-- 分页 -->
	<div id="barcon" class="barcon">
		<div id="barcon1" class="barcon1"></div>
		<div id="barcon2" class="barcon2">
			<ul>
				<li><a id="firstPage" class="btn btn-default">首页</a></li>
				<li><a id="prePage" class="btn btn-default">上一页</a></li>
				<li><a id="nextPage" class="btn btn-default">下一页</a></li>
				<li><a id="lastPage" class="btn btn-default">尾页</a></li>
				<li><select id="jumpWhere" style="width: 50px; height: 30px;"></select></li>
				<li><a id="jumpPage" onclick="jumpPage()"
					class="btn btn-default">跳转</a></li>
			</ul>
		</div>
	</div>
	<!-- 添加管理员遮罩栏 -->
	<div class="modal fade" id="modal-container-815572" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">添加管理员</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" role="form">
						<div class="form-group">
							<label for="name">用户名:</label> <input type="text"
								id="add_username" name="username" onblur="check_admin_add()"
								class="form-control-left" placeholder="添加用户名"> <span
								id="add_admin_info"></span>
						</div>
						<div class="form-group">
							<label for="name">密&nbsp;&nbsp;&nbsp;码:</label> <input
								type="password" name="password" id="add_passowrd"
								class="form-control-left" placeholder="添加密码"> <span
								id="add_pwd_error"></span>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary"
						onclick="add_admin_save()">保存</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 修改管理员遮罩栏 -->
	<div class="modal fade" id="modal-container-48510" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
							<h4 class="modal-title" id="myModalLabel">
								修改管理员
							</h4>
						</div>
						<div class="modal-body">
						   <form class="form-inline" role="form">
						      <input type="text" readonly="readonly" name="hide_admin_id" style="display: none;"/>
                              <div class="form-group">
                                <label for="name">用户名:</label>
                                 <input type="text" class="form-control-left" id="update_admincount_username" onblur="admincheck_count_checkuser()" maxlength="11"/>
                                 <span id="admin_count_checksuccess" style="color:green;display: none;float:right"  class="glyphicon glyphicon-ok"></span>
                                 <span id="admin_count_checkexsist" title='用户名已存在' style="color:red;display:none;float:right" class="glyphicon glyphicon-remove"></span>
                                 <span id="admin_count_checkerror" title='用户名不符合' style="color:red;display:none;float:right" class="glyphicon glyphicon-remove"></span>
                              </div>
                              <div class="form-group">
                                <label for="name">密&nbsp;&nbsp;码&nbsp;:</label>
                                <input type="text" class="form-control-left" onblur="admincheck_count_checkpwd()" id="update_admincount_password" maxlength="16"/>
                                <span id="admin_pwd_checksuccess" style="color:green;display: none;float:right"  class="glyphicon glyphicon-ok"></span>
                                 <span id="admin_pwd_checkerror" title='用户名不符合' style="color:red;display:none;float:right" class="glyphicon glyphicon-remove"></span>
                              </div>
                           </form>
						</div>
						<div class="modal-footer">
							 <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
							 <button type="button" id="admin_count_update" class="btn btn-primary">确认修改</button>
						</div>
					</div>
			</div>
	  </div>
<!-- 	  <script type="text/javascript"> -->
<!-- // var head= document.getElementsByTagName('head')[0]; -->
<!-- // var script= document.createElement('script'); -->
<!-- // script.type= 'text/javascript'; -->
<%-- // script.src= "<c:url value='/resource/systemBlank/assets/js/page/adminManager.js'/>"; --%>
<!-- // head.appendChild(script);  -->
<!-- </script> -->
<script type="text/javascript">
var xhr = new XMLHttpRequest();
xhr.open("get", "<c:url value='/resource/systemBlank/assets/js/page/adminManager.js'/>", true);
xhr.onreadystatechange = function(){
    if (xhr.readyState == 4){
        if (xhr.status >= 200 && xhr.status < 300 || xhr.status == 304){
            var script = document.createElement ("script");
            script.type = "text/javascript";
            script.text = xhr.responseText;
            document.body.appendChild(script);
        }
    }
};
xhr.send(null);
</script>
</body>
</html>