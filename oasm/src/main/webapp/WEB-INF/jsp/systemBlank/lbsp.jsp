<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>量表审批管理</title>
</head>
<body>
	<ol class="breadcrumb">
		<li><a href="#">工具管理与维护</a></li>
		<li class="active">量表审批管理</li>
	</ol>
	<!-- 选项卡 -->
	<div class="tabbable" id="tabs-96849">
		<ul class="nav nav-tabs">
			<li class="active"><a href="#panel-744409" data-toggle="tab">审批列表</a></li>
<!-- 			<li><a href="#panel-23970" data-toggle="tab">添加维度</a></li> -->
		</ul>
		<div class="tab-content">
			<div class="tab-pane active" id="panel-744409">
				
				
				
				<!-- 配置列表部分 -->
				<div class="table-responsive">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>序号</th>
								<th>量表配置表编号</th>
								<th>报批人</th>
								<th>报批时间</th>
								<th>审批人</th>
								<th>审批时间</th>
								<th>启用人</th>
								<th>审批状态</th>
								<th>摘要</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>1</td>
								<td>配置1</td>
								<td>报批人1号</td>
								<td>2017-9-9</td>
								<td>审批人1号</td>
								<td>2017-9-10</td>
								<td>启用人1号</td>
								<td>已通过</td>
								<td>摘要说明</td>
							</tr>
							<tr>
								<td>2</td>
								<td>配置2</td>
								<td>报批人2号</td>
								<td>2017-9-9</td>
								<td>审批人2号</td>
								<td>2017-9-10</td>
								<td>启用人2号</td>
								<td>未通过</td>
								<td>摘要说明</td>
							</tr>
							<tr>
								<td>3</td>
								<td>配置3</td>
								<td>报批人3号</td>
								<td>2017-9-9</td>
								<td>审批人3号</td>
								<td>2017-9-10</td>
								<td>启用人3号</td>
								<td>已通过</td>
								<td>摘要说明</td>
							</tr>
						
						
						
<%-- 							<c:forEach items="${lbbzlist}" varStatus="status" var="bz"> --%>
<!-- 								<tr> -->
<%-- 									<td>${status.count}</td> --%>
<%-- 									<td>${bz.rjlbid}</td> --%>
<%-- 									<td>${bz.rclbid}</td> --%>
<%-- 									<td>${bz.zqlbid}</td> --%>
<%-- 									<td>${bz.cjlbid}</td> --%>
<%-- 									<td><fmt:formatDate type="date" value="${bz.qysj}"/></td> --%>
<%-- 									<td>${bz.qyr}</td> --%>
<!-- 									<td> -->
<%-- 										<c:if test="${bz.zt==0}"> --%>
<!-- 											未启用 -->
<%-- 										</c:if> --%>
<%-- 										<c:if test="${bz.zt==1}"> --%>
<!-- 											已启用 -->
<%-- 										</c:if> --%>
<!-- 									</td> -->
<!-- 								</tr> -->
<%-- 							</c:forEach> --%>
						</tbody>
					</table>
				</div>
			</div>
			<div class="tab-pane" id="panel-23970">
				<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h4 class="modal-title" id="myModalLabel">添加配置</h4>
							</div>
							<div class="modal-body">
								<form class="form-inline" role="form">
									<div class="form-group">
										<label for="name">选择入监量表:</label>
										<select class="form-control-left" id="xzrjlb">
                                              <option>请选择维度</option>
                                              <option>2</option>
                                          </select>
									</div>
									<div class="form-group">
										<label for="name">选择日常量表:</label> 
										<select class="form-control-left" id="xzrclb">
                                              <option>请选择维度</option>
                                              <option>2</option>
                                          </select>
									</div>
									<div class="form-group">
										<label for="name">选择中期量表:</label>
										<select class="form-control-left" id="xzzqlb">
                                              <option>请选择维度</option>
                                              <option>2</option>
                                          </select> 
									</div>
									<div class="form-group">
										<label for="name">选择出监量表:</label>
										<select class="form-control-left" id="xzcjlb">
                                              <option>请选择维度</option>
                                              <option>5</option>
                                          </select> 
									</div>
								</form>
							</div>
							<div class="modal-footer">	
								<button type="button" class="btn btn-primary">保存</button>
							</div>
						</div>

					</div>
			</div>
		</div>
	</div>
	<!-- 
	<script type="text/javascript">
		var xhr = new XMLHttpRequest();
		xhr.open("get", "<c:url value='/resource/systemBlank/assets/js/page/lbUse.js'/>", true);
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
	 -->
</body>
</html>