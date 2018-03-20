<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>数据备份和还原</title>
</head>
<body>
	<ol class="breadcrumb">
		<li><a href="#">数据备份和还原</a></li>
		<li class="active">数据备份</li>
	</ol>
	<!-- 延时加载样式 -->
    <div id = "test_mask_2" class="test_mask"></div>
	<div class="panel panel-info">
		<div class="panel-heading">
			<h3 class="panel-title">手动备份</h3>
		</div>
		<div class="panel-body">
			<font style="color:red">*为了系统用户本地电脑安全，请选择手动输入数据备份路径*</font>
		</div>
		<ul class="list-group">
           <li class="list-group-item">盘符:<select id="diskPath"><option value="C:\" selected="selected">C:\</option><option value="D:\">D:\</option><option value="E:\">E:\</option></select></li>
           <li class="list-group-item">目录:<input type="text" id="dirPath"  placeholder="请输入目录" style="width: 70%;height: 30px;"/></li>
           <li class="list-group-item">确定备份路径:<input type="text" readonly="readonly" name="endPath" style="width: 80%;height: 30px;"/> </li>
           <li class="list-group-item">授权:超级管理员账号:<input type="text"/>&nbsp;&nbsp;密码:<input type="password"/>&nbsp;&nbsp;授权码:<input type="password"/></li>
           <li class="list-group-item"><button onclick="backupFile()" class="btn btn-info">开始备份</button></li>
        </ul>
	</div>
	
	<!-- system modal start -->
	<div id="ycf-alert" class="modal">
		<div class="modal-dialog modal-sm">
			<div class="modal-content" id="tipContent">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">×</span><span class="sr-only">Close</span>
					</button>
					<h5 class="modal-title">
						<i class="fa fa-exclamation-circle"></i> [Title]
					</h5>
				</div>
				<div class="modal-body small">
					<p>[Message]</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary ok"
						data-dismiss="modal">[BtnOk]</button>
					<button type="button" class="btn btn-default cancel"
						data-dismiss="modal">[BtnCancel]</button>
				</div>
			</div>
		</div>
	</div>
	<!-- system modal end -->
	<script type="text/javascript">
		var xhr = new XMLHttpRequest();
		xhr.open("get", "<c:url value='/resource/systemBlank/assets/js/page/backupDB.js'/>", true);
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