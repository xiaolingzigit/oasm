<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://shiro.apache.org/tags" prefix="sh" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>监狱管理员后台</title>
<!-- BOOTSTRAP STYLES-->
<link
	href="<c:url value='/resource/systemBlank/assets/css/bootstrap.css'/>"
	rel="stylesheet" />
<!-- FONTAWESOME STYLES-->
<link
	href="<c:url value='/resource/systemBlank/assets/css/font-awesome.css'/>"
	rel="stylesheet" />
<!-- CUSTOM STYLES-->
<link
	href="<c:url value='/resource/systemBlank/assets/css/custom.css'/>"
	rel="stylesheet" />
<link
	href="<c:url value='/resource/systemBlank/assets/css/bootstrapValidator.css'/>"
	rel="stylesheet" />
<link
	href="<c:url value='/resource/systemBlank/assets/css/pageSetting.css'/>"
	rel="stylesheet" />
	<!-- 分页css -->
<link
	href="<c:url value='/resource/systemBlank/assets/css/page.css'/>"
	rel="stylesheet" />
	<!--通用样式 -->
<link
	href="<c:url value='/resource/systemBlank/assets/css/common.css'/>"
	rel="stylesheet" />
<link
	href="<c:url value='/resource/systemBlank/assets/css/load.css'/>"
	rel="stylesheet" />
<!--      GOOGLE FONTS -->
<!--     <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' /> -->
</head>
<body>
	<div id="wrapper">
		<div class="navbar navbar-inverse navbar-fixed-top">
			<div class="adjust-nav">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".sidebar-collapse">
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#"><img style="height: 36px;"
						alt="监狱管理局"
						src="<c:url value='/resource/systemBlank/assets/img/blankLogo.png'/>">出监评估后台系统</a>
				</div>
				<div class="navbar-collapse collapse">
					<ul class="nav navbar-nav navbar-right">
						<!-- <li><a href="#">帮助中心</a></li> -->
						<li class="dropdown">
                           <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                                                              个人中心
                           <b class="caret"></b>
                           </a>
                        <ul class="dropdown-menu">
                           <!-- 有最终管理员权限才能显示 -->
                           <li><a href="javaScript:void(0);" onclick="showPage('${pageContext.request.contextPath}/systemAdmin/adminManager')">添加管理员</a></li>
                           <li class="divider"></li>
                           <li><a href="#modal-container-714946"  data-toggle="modal">修改密码</a></li>
                           <li class="divider"></li>
                           <li><a href="#">设置</a></li>
                       </ul>
                        </li>
                        <li><a href="<c:url value='/systemAdmin/logout'/>">退出登录</a></li>
					</ul>
				</div>

			</div>
		</div>
		
		<!-- 修改当前密码遮罩栏 -->
		<div class="modal fade" id="modal-container-714946" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
							<h4 class="modal-title" id="myModalLabel">
								修改密码
							</h4>
						</div>
						<div class="modal-body">
							<form class="form-inline" role="form">
                                 <div class="form-group">
                                    <label for="name">原&nbsp;密&nbsp;码&nbsp;:</label>
                                    <input type="text" class="form-control-left" id="admin_last_password" onblur="checkLastPwd()" maxlength="16" placeholder="请输入原密码"/>
                                     <span id="last_pwd_success" style="color:green;display: none;float:right"  class="glyphicon glyphicon-ok"></span>
                                    <span id="last_pwd_error" title='原密码不正确' style="color:red;display:none;float:right" class="glyphicon glyphicon-remove"></span>
                                 </div>
                                 <div class="form-group">
                                    <label for="name">新&nbsp;密&nbsp;码&nbsp;:</label>
                                    <input type="password" class="form-control-left" id="admin_next_password" onblur="checkNewPwd()" maxlength="16" placeholder="请输入新密码"/>
                                    <span id="new_pwd_success" style="color:green;display: none;float:right"  class="glyphicon glyphicon-ok"></span>
                                    <span id="new_pwd_error" title='4到16位（字母，数字，下划线，减号）' style="color:red;display:none;float:right" class="glyphicon glyphicon-remove"></span>
                                 </div>
                                 <div class="form-group">
                                    <label for="name">确认密码:</label>
                                    <input type="password" class="form-control-left" id="admin_comform_passowrd" onblur="checkComformPwd()" maxlength="16" placeholder="请输入确认密码"/>
                                    <span id="comform_pwd_success" style="color:green;display: none;float:right"  class="glyphicon glyphicon-ok"></span>
                                    <span id="comform_pwd_error" title='两次密码不一致' style="color:red;display:none;float:right" class="glyphicon glyphicon-remove"></span>
                                 </div>
                            </form>
						</div>
						<div class="modal-footer">
							 <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
							  <button type="button" id="admin_newpwd_btn"  class="btn btn-primary">保存</button>
						</div>
					</div>
					
				</div>
				
			</div>
		<!-- /. NAV TOP  -->
		<nav class="navbar-default navbar-side" role="navigation">
		<div class="sidebar-collapse">
			<ul class="nav" id="main-menu">
				<li id="admin_header_img" class="text-center user-image-back">
				<span>欢迎您:<strong class="strong_username">${sessionScope.username }</strong> </span>
				<img src="<c:url value='/resource/systemBlank/assets/img/find_user.png'/>"
					class="img-responsive" />
				</li>

				<li>
					<!-- 如果想要新开窗口就不需要onclick使用异步加载页面，可以直接用a标签跳转 --> <a
					href="javaScript:void(0);"
					onclick="showPage('${pageContext.request.contextPath}/systemAdmin/jyxxSetting')"><i
						class="fa fa-desktop "></i>警员管理</a>
				</li>
				<!-- <li><a href="javaScript:void(0);"
					onclick="showPage('${pageContext.request.contextPath}/systemAdmin/zfIDcard')"><i
						class="fa fa-desktop "></i>罪犯标识卡</a>
				</li> -->
				<!--  <li><a href="#"><i class="fa fa-edit "></i>数据自动导入设置<span
						class="fa arrow"></span></a>
					<ul class="nav nav-second-level">
						<li><a href="javaScript:void(0);" onclick="showPage('${pageContext.request.contextPath}/systemAdmin/dataInput')">时间设置</a></li>
						<li><a href="#">检索新数据</a></li>
						<li><a href="#">导入前备份</a></li>
					</ul></li>-->
				<li><a href="#"><i class="fa fa-edit "></i>工具管理与维护<span class="fa arrow"></span></a>
					<ul class="nav nav-second-level">
					   <li><a href="javaScript:void(0);" onclick="showPage('${pageContext.request.contextPath}/yzk/yzManager')">因子库管理与维护</a></li>
					   <li><a href="javaScript:void(0);" onclick="showPage('${pageContext.request.contextPath}/lbk/lbkManager')">量表库管理与维护</a></li>
					   <li><a href="javaScript:void(0);" onclick="showPage('${pageContext.request.contextPath}/lbbz/lbUse')">量表启用管理</a></li>
					   <li><a href="javaScript:void(0);" onclick="showPage('${pageContext.request.contextPath}/lbbz/lbsp')">量表审批管理</a></li>
					</ul>
				</li>
				<!-- <li><a href="javaScript:void(0);" onclick="showPage('${pageContext.request.contextPath}/systemAdmin/backupDB')"><i  class="fa fa-qrcode "></i>数据备份与还原</a></li>
				<li><a href="#"><i class="fa fa-table "></i>扩容</a></li> -->
			</ul>

		</div>

		</nav>
		<!-- /. NAV SIDE  -->
		<div id="page-wrapper">
			<div id="page-inner">
				<div class="row">
					<div class="col-md-12" id="content">
						<ol class="breadcrumb">
							<li><a href="#">首页</a></li>
							<!-- <li class="active">系统日志</li> -->
						</ol>
						
						<!-- 系统日志 -->
						<!-- <form class="form-horizontal-left" role="form">
						    <div class="form-group-left">
						        <label>操作人:</label>
						        <input type="text" class="form-control-left" id="createBy" placeholder="操作人">
						        <label>操作记录:</label>
						        <input type="text" class="form-control-left" id="description" placeholder="操作记录">
						        <label>操作时间:</label>
						        <input type="text" class="form-control-left" id="createDate" placeholder="格式yyyy-MM-dd HH" maxLength="20" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH'})" />
						        <button type="button" class="btn btn-success" onclick="logReach()">&nbsp;&nbsp;搜&nbsp;&nbsp;索&nbsp;&nbsp;</button>
						    </div>
						</form>
						<div class="table-responsive">
							<table class="table table-bordered table-hover" style="word-break:break-all; word-wrap:break-all;">
								<caption>后台管理操作日志</caption>
								<thead>
									<tr>
										<th>编号</th>
										<th>操作记录</th>
										<th>操作方法</th>
										<th>请求参数(加密)</th>
										<th>请求IP(IPV4/IPV6)</th>
										<th>操作人</th>
										<th>操作时间</th>
									</tr>
								</thead>
								<tbody id="sysLogData"> -->
									<!-- 拼接回来的日志 -->
							<!--	</tbody>
							</table>
							<div id="barcon" class="barcon">
						<div id="barcon1" class="barcon1">
						</div>-->
						<!-- 分页 -->
						<!--<div id="barcon2" class="barcon2">
							<ul>
								<li><a id="firstPage">首页</a></li>
								<li><a id="prePage">上一页</a></li>
								<li><a id="nextPage">下一页</a></li>
								<li><a id="lastPage">尾页</a></li>
								<li><select id="jumpWhere"
									style="width: 50px; height: 30px;"></select></li>
								<li><a id="jumpPage" onclick="jumpPage()">跳转</a></li>
							</ul>
						</div>
						<span id="pageSize" style="display: none;"></span>
					    <span id="pages" style="display: none;"></span>
					    <span id="pageNum" style="display: none;"></span>
					</div>
						</div>
					</div> -->
					<nav class="navbar-fixed text-center">
						<p>&copy;版权所有&nbsp;&nbsp;吴晓玲&nbsp;&nbsp;技术支持&nbsp;&nbsp;吴晓玲</p>
					</nav>
				</div>
				<!-- /. ROW  -->
				<hr />

				<!-- /. ROW  -->
			</div>
			<!-- /. PAGE INNER  -->
		</div>
		<!-- /. PAGE WRAPPER  -->
	</div>
	<!-- /. WRAPPER  -->
	<!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
	<!-- JQUERY SCRIPTS -->
	<script
		src="<c:url value='/resource/systemBlank/assets/js/jquery-1.10.2.js'/>"></script>
	<!-- BOOTSTRAP SCRIPTS -->
	<script
		src="<c:url value='/resource/systemBlank/assets/js/bootstrap.min.js'/>"></script>
	<!-- METISMENU SCRIPTS -->
	<script
		src="<c:url value='/resource/systemBlank/assets/js/jquery.metisMenu.js'/>"></script>
	<!-- CUSTOM SCRIPTS -->
	<script
		src="<c:url value='/resource/systemBlank/assets/js/custom.js'/>"></script>
	<!-- 验证 -->
	<script
		src="<c:url value='/resource/systemBlank/assets/js/bootstrapValidator.js'/>"></script>
	<!-- ajax加载无刷新的页面js -->
	<script
		src="<c:url value='/resource/systemBlank/assets/js/page/home.js'/>"></script>
		
   <!-- 管理员首页 -->
   <script
		src="<c:url value='/resource/systemBlank/assets/js/page/adminBlank.js'/>"></script>
	<script
		src="<c:url value='/resource/systemBlank/assets/js/page/load-min.js'/>"></script>
		
	<script type="text/javascript" src="<c:url value='/resource/js/my97/WdatePicker.js'/>"></script>
</body>
</html>
