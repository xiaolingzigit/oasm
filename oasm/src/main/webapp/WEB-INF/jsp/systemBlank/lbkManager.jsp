<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>量表库管理与维护</title>
</head>
<body>
	<ol class="breadcrumb">
		<li><a href="#">工具管理与维护</a></li>
		<li class="active">量表库管理与维护</li>
	</ol>
	<!-- 量表选项卡 -->
	<div id="lbkxxk_aaa" class="tabbable" id="tabs-96849">
		<ul class="nav nav-tabs">
			<li class="active"><a href="#panel-744409" data-toggle="tab">已启用量表查询</a>
			</li>
			<li><a href="#panel-23970" data-toggle="tab">量表创建管理</a></li>
		</ul>
		<div class="tab-content">
			<div class="tab-pane active" id="panel-744409">
				<!-- 添加量表遮罩部分 -->
				<div class="modal fade" id="modal-container-757756" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">×</button>
								<h4 class="modal-title" id="myModalLabel">添加量表</h4>
							</div>
							<div class="modal-body">
								<form class="form-horizontal" role="form">
									<div class="form-group">
										<label for="name">量表编号:</label> <input type="text"
											class="form-control-right" placeholder="请输入量表编号">
									</div>
									<div class="form-group">
										<label for="name">信&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;度:</label>
										<input type="text" class="form-control-left" placeholder="">
										<label for="name">效&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;度:</label>
										<input type="text" class="form-control-left" placeholder="">
									</div>
									<div class="form-group">
										<label for="name">研&nbsp;制&nbsp;者:</label> <input type="text"
											class="form-control-right" placeholder="请输入研制者"> <label
											for="name">使用监狱:</label> <input type="text"
											class="form-control-right" placeholder="请输入使用监狱">
									</div>
									<div class="form-group">
										<label for="name">说明:</label>
										<textarea class="form-control-left" rows="3"></textarea>
										<label for="name">备份:</label>
										<textarea class="form-control-left" rows="3"></textarea>
									</div>
								</form>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">关闭</button>
								<button type="button" class="btn btn-primary">保存</button>
							</div>
						</div>

					</div>
				</div>
				<!-- 量表添加结束 -->
<!-- 				<div style="margin-top: 20px;"> -->
<!-- 					<a href="#modal-container-757756" data-toggle="modal"> <input -->
<!-- 						type="button" class="btn btn-success" value="添加量表" /> -->
<!-- 					</a> -->
<!-- 				</div> -->
				<!-- 量表列表部分 -->
				<div class="table-responsive">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>序号</th>
								<th>量表编号</th>
								<th>研制者</th>
								<th>创建时间</th>
								<th>说明</th>
								<th>状态</th>
								<th>详情</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${lbkList }" var="lbk" varStatus="status">
								<tr>
									<td>${status.count }</td>
									<td>${lbk.name }</td>
									<td>${lbk.researher }</td>
									<td><fmt:formatDate type="both" value="${lbk.crTime }" /></td>
									<td>${lbk.remark }</td>
									<td><c:if test="${lbk.status==2}">
											<span title="必须有一个为开启状态" class="glyphicon glyphicon-heart"></span>已启用
										</c:if> <c:if test="${lbk.status==1}">
											<a onclick="update_start('${lbk.scaleId }')" href="#"><span
												title="必须有一个为开启状态" class="glyphicon glyphicon-lock"></span>未启用</a>
										</c:if></td>
									<td><a href="#" class="lookupRelat" onclick="lookupScale('${lbk.scaleId }')"  data-toggle="modal">查看详情</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
			<!-- 添加量表部分 -->
			<div class="tab-pane" id="panel-23970">
				<form class="form-horizontal" role="form" style="margin-left: 20px;">
					<div class="form-group">
					 <div class="f_l">
						<label for="name">量表名称:</label> <input type="text"
							class="form-control-left" id="scale_grow_name" name="name" onblur="check_scale_name()"
							placeholder="请输入量表名称">
							</div>
							<div id="input_lbName" class="tips"></div>
					</div>
					<div class="form-group">
						<label class="radio-inline">量表类型:</label> <label
							class="radio-inline"> <input type="radio" name="type"
							value="AA" checked>入监结构访谈
						</label> <label class="radio-inline"> <input type="radio"
							name="type" value="AB">入监行为观察
						</label>
						</label> <label class="radio-inline"> <input type="radio"
							name="type" value="BA">日常行为观察
						</label>
						</label> <label class="radio-inline"> <input type="radio"
							name="type" value="CA">中期结构访谈
						</label>
						</label> <label class="radio-inline"> <input type="radio"
							name="type" value="CB">中期行为观察
						</label>
						</label> <label class="radio-inline"> <input type="radio"
							name="type" value="DA">出监结构访谈
						</label>
						</label> <label class="radio-inline"> <input type="radio"
							name="type" value="DB">出监行为观察
						</label>
					</div>
					<div class="form-group">
					    <label for="name">研&nbsp;制&nbsp;者:</label>
					    <input type="text" class="form-control-left" name="researher" placeholder="请输入量表研制者">
					</div>
					<div class="form-group">
					     <label for="name"  class="input_name">量表说明:</label>
					     <textarea id="scale_remark_add" class="form-control-left" cols="80" rows="3"></textarea>
					</div>
					<div class="form-group">
					   <label for="name">问题归属:</label>
						   <select id="all_org_question" class="form-control-left">
							   <option value="" selected="true" disabled="true">所有监狱</option>
							   <option value="4400">广东省监狱管理局</option>
							   <option value="4413">惠州监狱</option>
							   <option value="4450">女子监狱</option>
							   <option value="4480">未成年犯管教所</option>
						   </select>
					</div>
					<!-- 添加问题时折叠框部分 -->
					<div class="from-group">
						<div class="panel-group" id="accordion">
							<!-- 拼接问题 -->
						</div>
					</div>

					<div class="form-group">
						<input type="button" class="btn btn-default" id="ylxg_lb"  data-toggle="modal" value="量表预览" /> <input
							type="reset" class="btn btn-warning" value="重新生成" /> <input
							type="button" onclick="btn_grow_scale()" class="btn btn-success" value="生成量表" />
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- 量表预览效果 -->
	<div class="modal fade" id="modal-container-768471"  role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog" style="width: 800px;">
					<div class="modal-content">
						<div class="modal-header">
							 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
							<h4 class="modal-title" id="myModalLabel">
								量表预览效果图
							</h4>
						</div>
						<div class="modal-body" id="lb_browder">
						<table class="table table-bordered" style="text-align:center">
						<colgroup>
						<col width="10%">
						<col width="20%">
						<col width="19%">
						<col width="8%">
						<col width="19%">
						<col width="17%">
						<col width="7%">
						</colgroup>
							<thead>
								<tr>
									<th style="text-align:center;">问题编号</th>
									<th style="text-align:center;">问题名称</th>
									<th style="text-align:center;">维度</th>
									<th style="text-align:center;">选项号</th>
									<th style="text-align:center;">选项内容</th>
									<th style="text-align:center;">因子名称</th>
									<th style="text-align:center;">权重</th>
								</tr>
							</thead>
							<tbody></tbody>
						</table>
				</div>
						<div class="modal-footer">
							 <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button> 
						</div>
					</div>
					
				</div>
				
	  </div>
	
	<!-- system modal start -->
	<div id="ycf-alert" class="modal">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">
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
		xhr
				.open(
						"get",
						"<c:url value='/resource/systemBlank/assets/js/page/lbManager.js'/>",
						true);
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4) {
				if (xhr.status >= 200 && xhr.status < 300 || xhr.status == 304) {
					var script = document.createElement("script");
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