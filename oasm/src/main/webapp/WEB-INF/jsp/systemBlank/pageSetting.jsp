<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>警员管理</title>
<script type="text/javascript">
var head= document.getElementsByTagName('head')[0];
var script= document.createElement('script');
script.type= 'text/javascript';
script.src= "<c:url value='/resource/systemBlank/assets/js/page/addJyxx.js'/>";
head.appendChild(script); 
</script>
</head>

<body>
	<div class="tabbable" id="tabs-46753">
		<ol class="breadcrumb">
			<li><a href="#">警员信息</a></li>
			<li class="active">警察信息列表</li>
		</ol>
		<ul class="nav nav-tabs">
			<li class="active"><a href="#panel-863824" data-toggle="tab">警察信息列表</a></li>
			<li><a href="#panel-876962" data-toggle="tab">添加警察信息</a></li>
			<li><a href="#panel-266911" data-toggle="tab">添加职务信息</a></li>
		</ul>
		<div class="tab-content">
			<div class="tab-pane active" id="panel-863824">
				<!-- 警员信息列表 开始-->
				<div class="table-responsive">
					<table class="table table-bordered" id="jcxx_list">
						<caption>警察信息列表</caption>
						<!-- 				  <form action="" role="form"> -->
						<!-- 				      <div class="form-group"> -->
						<!-- 				        <input type="text" class="form-control-left" placeholder="请输入内容"/> -->
						<!-- 				        <input type="submit" class="btn btn-default" value="搜索"/> -->
						<!-- 				      </div> -->
						<!-- 				   </form> -->
						<thead>
							<tr>
								<th>序号</th>
								<th>警号</th>
								<th>姓名</th>
								<th>职务</th>
								<th>所属监区</th>
								<th>所属分监区</th>
								<th>创建时间</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${jyxxList}" var="jy" varStatus="status">
								<tr>
									<td>${status.count }</td>
									<td>${jy.jh}</td>
									<td>${jy.xm }</td>
									<td>${jy.groupMan.gmname }</td>
									<td>${jy.jq }</td>
									<td>${jy.xjq }</td>
									<td><fmt:formatDate type="date" value="${jy.cjsj }" /></td>
									<td><a id="jy_update_modal"
										onclick="jy_update_modal(${jy.jh},'${jy.xm }','${jy.jq }','${jy.xjq }')"
										class="btn btn-info btn-lg" data-toggle="modal" title="编辑">
											<span class="glyphicon glyphicon-pencil" />
									</a> &nbsp;&nbsp; <a href="#" onclick="jy_delect(${jy.jh})"
										class="btn btn-info btn-lg" title="删除"> <span
											class="glyphicon glyphicon-trash" />
									</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div style="float: right;">
						<ul class="pagination pagination-lg">
							<li><a>当前第${page.pageNum}页&nbsp;&nbsp;共${page.pages}页&nbsp;&nbsp;共${page.total}条数据</a></li>
							<li><a href="#"
								onclick="showPage('${pageContext.request.contextPath}/systemAdmin/jyxxSetting')">首页</a></li>
							<c:forEach items="${nums}" var="p">
								<li><a href="#"
									onclick="showPage('${pageContext.request.contextPath}/systemAdmin/jyxxSetting?number=${p}')">${p}</a></li>
							</c:forEach>
							<li><a href="#"
								onclick="showPage('${pageContext.request.contextPath}/systemAdmin/jyxxSetting?number=${page.pages}')">末页</a></li>
							<li><select style="height: 48px" id="sele">
									<option>请选择</option>
									<c:forEach var="pl" begin="1" end="${page.pages}">
										<option
											value="${pageContext.request.contextPath}/systemAdmin/jyxxSetting?number=${pl}">${pl}</option>
									</c:forEach>
							</select></li>
						</ul>
					</div>

				</div>
				<!-- 警员信息列表结束 -->
			</div>
			<script type="text/javascript">
				$(function(){
					$("#sele").change(function(){
						showPage($(this).val());
					})
				})
			</script>
			<!-- 第二选项卡 -->
			<div class="tab-pane" id="panel-876962">
				<div class="panel panel-success">
					<div class="panel-heading">
						<h3 class="panel-title">使用EXCEL方式</h3>
					</div>
					<div class="panel-body">
						<input type="text" id="file_name" readonly="readonly" /> <a
							href="javascript:void(0);" class="toSee" id="toSee"> 浏览 <input
							type="file" id="file">
						</a>
					</div>
				</div>

				<div class="panel panel-info">
					<div class="panel-heading">手动方式</div>
					<div class="panel-body">
						<form role="form" id="jy_list_form">
							<div class="form-group">
								<label for="name">选择角色:</label> <select
									class="form-control-right" id="zrid">
									<option value="" selected="true" disabled="true">请选择角色</option>
								</select> <label for="name">选择职务:</label> <select
									class="form-control-right" id="zw_select">
									<option value="" selected="true" disabled="true">请选择职务</option>
								</select><span id="zw_select_null"></span>
							</div>
							<div class="form-group" id="add_jq_div">
								<label for="name">添加监区:</label> <input type="text"
									class="form-control-right" name="jq" placeholder="请输入监区名称">
							</div>
							<div class="form-group" id="add_xjq_div">
								<label for="name">添加分监区:</label> <input type="text"
									class="form-control-right" name="xjq" placeholder="请输入分监区名称">
							</div>
							<div class="form-group" id="add_jh_div">
								<label for="name">添加警号:</label> <input type="text"
									class="form-control-right" name="jh" maxlength="7"
									placeholder="请输入警号"> <span id="jh_add_check"></span>
							</div>
							<div class="form-group" id="add_xm_div">
								<label for="name">添加姓名:</label> <input type="text"
									class="form-control-right" name="xm" maxlength="7"
									placeholder="请输入姓名"> <span id="xm_add_check"></span>
							</div>
							<div class="form-group" id="add_ma_div">
								<label for="name">添加密码:</label> <input type="text"
									class="form-control-right" name="ma" maxlength="16"
									placeholder="请输入密码"> <span id="ma_add_check"></span>
							</div>
							<div class="form-group">
								<input type="reset" class="btn btn-warning" value="重置" /> <input
									type="button" id="jyxx_info_add" class="btn btn-success"
									value="添加" />
							</div>
						</form>
					</div>
				</div>
			</div>
			<!-- 第三选项卡 -->
			<div class="tab-pane" id="panel-266911">
				<form role="form" class="zw_list_form">
					<div class="form-group">
						<label for="name">选择角色:</label> <select class="form-control-right"
							id="role_zw_add">
							<option value="" selected="true" disabled="true">请选择角色</option>
						</select> <span id="role_zw_required"></span>
					</div>
					<div class="form-group">
						<label for="name">添加职务:</label> <input type="text"
							class="form-control-right" name="zwname" maxlength="20"
							placeholder="职务名称">
					</div>
					<div class="form-group">
						<input type="reset" class="btn btn-warning" value="重置" /> <input
							type="button" id="jyxx_zw_add" class="btn btn-success" value="添加" />
					</div>
				</form>
			</div>
		</div>
	</div>

	<!-- 弹幕栏 -->
	<div class="modal fade" id="modal-container-819013" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">修改警员信息</h4>
				</div>
				<div class="modal-body">
					<form role="form" id="jy_update_form">
						<div class="form-group">
							<label for="name">选择角色:</label> <select
								class="form-control-right" id="update_zrid">
								<option value="" selected="true" disabled="true">请选择角色</option>
							</select> <label for="name">选择职务:</label> <select
								class="form-control-right" id="zw_select_update">
								<option value="" selected="true" disabled="true">请选择职务</option>
							</select><span id="zw_select_update_null"></span>
						</div>
						<div class="form-group">
							<label for="name">修改监区:</label> <input id="update_jq_data"
								type="text" class="form-control-right" name="jq"> <span
								id="jq_update_null"></span>
						</div>
						<div class="form-group">
							<label for="name">修改分监区名称:</label> <input type="text"
								class="form-control-right" name="xjq" id="update_xjq_data">
							<span id="xjq_update_null"></span>
						</div>
						<div class="form-group">
							<label for="name">修改警号:</label> <input type="text"
								id="update_jh_data" class="form-control-right" name="jh"
								maxlength="7" readonly="readonly"> <span
								id="jh_update_check"></span>
						</div>
						<div class="form-group">
							<label for="name">修改姓名:</label> <input type="text"
								id="update_xm_data" class="form-control-right" name="xm"
								maxlength="7"> <span id="xm_update_check"></span>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal" id="jyxx_close_btn">关闭</button>
					<button type="button" class="btn btn-primary" id="jyxx_update_btn">确认修改</button>
				</div>
			</div>
		</div>
	</div>

	<!-- system modal start -->
	<div id="ycf-alert" class="modal">
		<div class="modal-dialog modal-sm">
			<div class="modal-content" id="contentData">
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
</body>
</html>