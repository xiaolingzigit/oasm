<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>因子管理与维护</title>
</head>
<body>
	<ol class="breadcrumb">
		<li><a href="#">工具管理与维护</a></li>
		<li class="active">量表启用管理</li>
	</ol>
	<!-- 选项卡 -->
	<div class="tabbable" id="tabs-96849">
		<ul class="nav nav-tabs">
			<li class="active"><a href="#panel-744409" data-toggle="tab">配置列表</a>
			</li>
			<li><a href="#panel-23970" data-toggle="tab">添加配置</a></li>
		</ul>
		<div class="tab-content">
			<div class="tab-pane active" id="panel-744409">
				<div style="margin-top: 20px;"></div>
				<div class="">
				   <label for="name">新增罪犯默认量表配置:</label>
				   <select id="currentScale"></select> <!-- 拼接的选择框 -->
				   &nbsp;&nbsp;&nbsp;&nbsp;
				   <label class="radio-inline">是否全局统一使用同一个量表配置:</label>
				   <label class="radio-inline">
				   <input type="radio" name="globalId" value="yes" checked="true"/>是 &nbsp;&nbsp;&nbsp;&nbsp;	
				   </label>
  			       <label class="radio-inline">
  			       <input type="radio" name="globalId" value="no"/>否
  			       </label>
				   <input type="button" onclick="save_conf_currScale()" class="btn btn-success" value="保存配置"/>
				</div>
				<!-- 配置列表部分 -->
				<div class="table-responsive">
					<table class="table table-hover table-bordered">
						<thead>
							<tr>
								<th>序号</th>
								<th>配置名称</th>
								<th>入监访谈量表</th>
								<th>入监观察量表</th>
								<th>日常观察量表</th>
								<th>中期访谈量表</th>
								<th>中期观察量表</th>
								<th>出监访谈量表</th>
								<th>出监观察量表</th>
								<th>创建时间</th>
								<th>启用人</th>
								<th>状态</th>
							</tr>
						</thead>
						<tbody id="scale_conf_list">
						   <!-- 使用ajax拼接到页面 -->
						</tbody>
					</table>
				</div>
			</div>
			<!-- 配置量表部分 -->
			<div class="tab-pane" id="panel-23970">
				<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h4 class="modal-title" id="myModalLabel">添加配置</h4>
							</div>
							<div class="modal-body">
								<form class="form-inline" role="form">
									<div class="form-group-left">
									<div class="f_l">
										<label for="name">配置名称:</label>
										<input type="text" class="form-control-left" onblur="check_confName()"  name="confName" placeholder="请输入配置名称">
									</div>
									<div id="input_settingName" class="tips"></div>
									</div>
									<div class="form-group-left" style="clear:both">
					                   <label for="name">配置说明:</label><br>
					                   <textarea id="conf_remark_add" class="form-control-left" cols="60" rows="3"></textarea>
					                </div>
									<div class="form-group-left">
									    <label for="name">选择量表:</label>
									    <div class="form-group-left"><span>1、入监评估量表</span></div>
									    <div class="form-group">
									       <strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;入监结构访谈量表:</strong>
									       <select class="form-control-left" id="rjft_scale_list">
							                      <option value="" selected="false" disabled="true">请选择量表</option>
						                    </select>
									    </div>
									    
									    <div class="form-group">
									       <strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;入监行为观察量表:</strong>
									       <select class="form-control-left" id="rjgc_scale_list">
							                      <option value="" selected="false" disabled="true">请选择量表</option>
						                    </select>
									    </div>
									    
									    <div class="form-group-left"><span>2、日常评估量表</span></div>
									    <div class="form-group">
									       <strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;日常行为观察量表:</strong>
									       <select class="form-control-left" id="rcgc_scale_list">
							                      <option value="" selected="false" disabled="true">请选择量表</option>
						                    </select>
									    </div>
									    
									    <div class="form-group-left"><span>3、中期评估量表</span></div>
									    <div class="form-group" >
									       <strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;中期结构访谈量表:</strong>
									       <select class="form-control-left" id="zqft_scale_list">
							                      <option value="" selected="false" disabled="true">请选择量表</option>
						                    </select>
									    </div>
									    <div class="form-group">
									       <strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;中期行为观察量表:</strong>
									       <select class="form-control-left" id="zqgc_scale_list">
							                      <option value="" selected="false" disabled="true">请选择量表</option>
						                    </select>
									    </div>
									    
									    <div class="form-group-left"><span>4、出监评估量表</span></div>
									    <div class="form-group">
									       <strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;出监结构访谈量表:</strong>
									       <select class="form-control-left" id="cjft_scale_list">
							                      <option value="" selected="false" disabled="true">请选择量表</option>
						                    </select>
									    </div>
									    <div class="form-group">
									       <strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;出监行为观察量表:</strong>
									       <select class="form-control-left" id="cjgc_scale_list">
							                      <option value="" selected="false" disabled="true">请选择量表</option>
						                    </select>
									    </div>
									    <div class="form-group">
									        <label class="radio-inline">
									           <strong>配置生效状态</strong>
									        </label>
									        <label class="radio-inline">
                                                   <input type="radio"  name="status" value="1" checked>暂不启用
                                            </label>
                                            <label class="radio-inline" >
                                                   <input type="radio" name="status"  value="2"> 立即启用
                                            </label>
									    </div>
									</div>
								</form>
							</div>
							<div class="modal-footer">	
								<button type="button" onclick="save_scale_conf()" class="btn btn-primary">保存</button>
							</div>
						</div>

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
</body>
</html>