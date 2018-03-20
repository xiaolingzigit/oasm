<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>因子管理与维护</title>
</head>
<body>
	<ol class="breadcrumb">
		<li><a href="#">工具管理与维护</a></li>
		<li class="active">因子库管理与维护</li>
	</ol>
	<!-- 选项卡 -->
	<div class="tabbable" id="tabs-96849">
		<ul class="nav nav-tabs">
			<li class="active"><a href="#panel-744409" data-toggle="tab">维度因子关系管理</a>
			</li>
			<li><a href="#panel-23970" data-toggle="tab">添加元素</a></li>
			<li><a href="#panel-23971" data-toggle="tab">问题管理</a></li>
		</ul>
		<div class="tab-content">
			<div class="tab-pane active" id="panel-744409">
				<!-- 添加维度与因子关系遮罩栏 -->
				<div class="modal fade" id="modal-container-218260" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
							<h4 class="modal-title" id="myModalLabel">
								添加因子和维度关系
							</h4>
						</div>
						<div class="modal-body">
							<form class="form-inline" role="form">
							    <div class="form-group">
							    <div class="f_l">
									<label for="name">选择维度:</label>
									<select id="select_dim_id" class="form-control">
							           <option value="" selected="true" disabled="true">请选择维度</option>
						           </select>
						           </div>
						           <div id="input_dim" class="tips"></div>
								</div>
							
								<div class="form-group">
								<div class="f_l">
										<label for="name">因子名称:</label>
										 <input type="text" class="form-control" name="fzname"  onblur="check_yzname()" placeholder="请输入名称">
								</div>
								<div id="input_yz" class="tips"></div>
								</div>
									<div class="form-group">
										<label for="name">分&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;值:</label> <input type="text"
											class="form-control" name="fScore" value="1" readonly="readonly">
									</div>
									<div class="form-group">
									   <label for="name" class="input_name">描&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;述:</label>
									   <textarea id="remarkname" class="form-control-left" rows="3"></textarea> 
									   
									</div>
							 </form>
						</div>
						<div class="modal-footer">
							 <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button> 
							 <button type="button" onclick="yz_name_save()" class="btn btn-primary">保存</button>
						</div>
					</div>
					
				</div>
			</div>
				
				<!-- 添加因子按钮 -->
				<div style="margin-top: 20px;">
					<a href="#modal-container-218260" data-toggle="modal">
					<input type="button" class="btn btn-success" value="添加维度与因子关系" />
					</a>
				</div>
				<!-- 因子列表部分 -->
				<div class="table-responsive">
					<table class="table table-striped table-hover">
					<colgroup>
					<col width="8%">
					<col width="8%">
					<col width="17%">
					<col width="8%">
					<col width="29%">
					<col width="10%">
					<col width="10%">
					<col width="10%">
					</colgroup>
						<thead>
							<tr>
								<th>序号</th>
								<th>维度编码</th>
								<th>维度名称</th>
								<th>因子编码</th>
								<th>因子名称</th>
								<th>分数</th>
								<th>创建人</th>
								<th>创建时间</th>
							</tr>
						</thead>
						<tbody class="dim_factor_list">
							<c:forEach items="${dafList}" var="daf" varStatus="status">
								<tr>
									<td>${status.count}</td>
									<td>${daf.dimId}</td>
									<td><span class="dimval">${daf.tdmin.dimName}</span><span class="modify_btn" name="${daf.dimId }@${daf.fId}" onclick="modify_dafrelation(this)">修改</span></td>
									<td>${daf.fId}</td>
									<td><span class="factorval">${daf.tfactor.name}</span><span  class="modify_btn" name="${daf.fId}" onclick="modify_fname(this)">修改</span></td>
									<td>${daf.tfactor.fScore}</td>
									<td>${daf.creator}</td>
									<td><fmt:formatDate type="both" value="${daf.crTime}" /></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
			<!-- 第二选项卡 -->
			<div class="tab-pane" id="panel-23970">
			     <!-- 添加部分 -->
                 <div class="panel panel-success">
					<div class="panel-heading" data-toggle="collapse" data-parent="#panel-43511" href="#panel-element-374839">
						 <span class="panel-title">手动添加元素</span>
					</div>
					<div id="panel-element-374839" class="panel-collapse collapse in">
						<div class="panel-body">
						    <ul class="list-group">
                                <li class="list-group-item">
                                     <label for="name">元素编号:</label>
                                     <input type="text" maxlength="28" name="ysid" id="ysIdValue"/>&nbsp;&nbsp;
                                     <label for="name">元素名称:</label>
                                     <input type="text" name="ysmc" id="ysmcValue"/>&nbsp;&nbsp;
                                     <label for="name">元素用途:</label>
                                     <select class="form-control-left" id="ysytValue">
                                             <option value="1">作为因子</option>
                                             <option value="2" selected="selected">作为维度</option>
                                             <option value="3">作为因子或者维度</option>
                                     </select>
                                </li>
                                <li class="list-group-item">
                                     <label for="name">元素特质:</label>
                                     <select class="form-control-left" id="ystzValue">
                                             <option value="无" selected="selected">无</option>
                                             <option value="内在需求-稳定特质">内在需求-稳定特质</option>
                                             <option value="内在需求-可变特质">内在需求-可变特质</option>
                                             <option value="环境刺激-日常改造行为">环境刺激-日常改造行为</option>
                                             <option value="环境刺激-异常狱情">环境刺激-异常狱情</option>
                                      </select>
                                      <label for="name">启用状态:</label>
                                      <input type="text" value="启用" readonly="readonly"/>
                                       &nbsp;&nbsp;&nbsp;&nbsp;<button class="btn btn-info" onclick="saveYsk()">添加</button>
                                 </li>
                                 <li class="list-group-item">
                                     <label for="name">说明:</label>
                                     <textarea class="form-control" id="ysksmValue" rows="3"></textarea>
                                 </li>
                             </ul>
						</div>
					</div>
				</div>
                 <!-- 搜索器部分 -->
				<div class="panel panel-success">
					<div class="panel-heading" data-toggle="collapse" data-parent="#panel-442067" href="#panel-element-922308">
						 <span class="panel-title">检索器</span>
					</div>
					<div id="panel-element-922308" class="panel-collapse collapse in">
						<div class="panel-body">
							<ul class="list-group">
                                <li class="list-group-item">
                                    <label for="name">元素编号:</label>
                                    <input type="text" id="ysbhQuery"/>   
                                    <label for="name">元素名称:</label>
                                    <input type="text" id="ysmcQuery"/>
                                    <label for="name">元素特质:</label>
                                    <select id="yssxQuery">
                                         <option value="" disabled="true" selected="selected">请选择...</option>
                                         <option value="无">无</option>
                                         <option value="内在需求-稳定特质">内在需求-稳定特质</option>
                                         <option value="内在需求-可变特质">内在需求-可变特质</option>
                                         <option value="环境刺激-日常改造行为">环境刺激-日常改造行为</option>
                                         <option value="环境刺激-异常狱情">环境刺激-异常狱情</option>
                                    </select>
                                    <label for="name">元素用途:</label>
                                    <select id="ytxzQuery">
                                        <option value="">请选择...</option>
                                        <option value="1">作为因子</option>
                                        <option value="2">作为维度</option>
                                        <option value="3">作为维度或者因子</option>
                                    </select>
                                    <label for="name">因子总频次:</label>
                                    <input type="text" id="yzzpcQuery"/>                                                        
                                </li>
                                <li class="list-group-item">
                                    <label for="name">自杀相关频次:</label>
                                    <input type="text" id="zsxgpcQuery"/>
                                    <label for="name">逃脱相关频次:</label>
                                    <input type="text" id="ttxgpcQuery"/>
                                    <label for="name">行凶相关频次:</label>
                                    <input type="text" id="xxxgpcQuery"/>
                                    <label for="name">再犯罪相关频次:</label>
                                    <input type="text" id="zfzxgpcQuery"/>
                                </li>
                                <li class="list-group-item">
                                    <label for="name">创建时间:</label>
                                    <input type="text" id="cjsj1Query" placeholder="格式yyyy-MM-dd" maxLength="10" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
                                    <label for="name">至</label>
                                    <input type="text" id="cjsj2Query" placeholder="格式yyyy-MM-dd" maxLength="10" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
                                </li>
                                <li class="list-group-item">
                                    <label for="name">修改时间:</label>
                                    <input type="text" id="xgsj1Query"  placeholder="格式yyyy-MM-dd" maxLength="10" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
                                    <label for="name">至</label>
                                    <input type="text" id="xgsj2Query" placeholder="格式yyyy-MM-dd" maxLength="10" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
                                    &nbsp;&nbsp;&nbsp;&nbsp;<button onclick="queryBtn()" class="btn btn-info">检索</button>
                                </li>
                            </ul>
						</div>
					</div>
				</div>
				<!-- 表格显示数据部分 -->
				<div>
				    <table class="table table-hover">
                       <caption>元素总览表</caption>
                       <thead>
                             <tr>
                                 <th>序号</th><th>元素编号</th><th>元素名称</th><th>元素特质</th><th>用途性质</th><th>因子总频次</th><th>自杀相关频次</th><th>行凶相关频次</th>
                                 <th>脱逃相关频次</th><th>再犯罪相关频次</th><th>创建时间</th><th>创建者编号</th><th>修改时间</th><th>修改者编号</th><th>操作</th>
                             </tr>
                       </thead>
                       <tbody id="tyskTableData">
                             <!-- 拼接因子使用 -->
                       </tbody>
                    </table>
					<!-- 分页 -->
                    <div id="barcon" class="barcon">
						<div id="barcon1" class="barcon1"></div>
						<div id="barcon2" class="barcon2">
							<ul>
								<li><a id="firstPage">首页</a></li>
								<li><a id="prePage">上一页</a></li>
								<li><a id="nextPage">下一页</a></li>
								<li><a id="lastPage">尾页</a></li>
								<li><select id="jumpWhere" style="width: 50px; height: 30px;"></select></li>
								<li><a id="jumpPage" onclick="jumpPage()">跳转</a></li>
							</ul>
						</div>
						<span id="pageSize" style="display: none;"></span>
					    <span id="pages" style="display: none;"></span>
					    <span id="pageNum" style="display: none;"></span>
					</div>
				</div>
				<!-- 第二选项卡修改框 -->
				<a href="#modal-container-622390" data-toggle="modal" id="cfzlk" ></a>
				<div class="modal fade" id="modal-container-622390" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
						     <span class="modal-title">修改元素</span>
						</div>
						<div class="modal-body">
						     <ul class="list-group">
                                 <li class="list-group-item">
							         <input type="hidden" readonly="readonly" id="ysidUpdate"/>
							         <label>元素编号</label>
							         <input type="text" id="ysbhUpdate"/>
							         <label>元素名称</label>
							         <input type="text" id="ysmcUpdate"/>
                                 </li>
                                 <li class="list-group-item">
                                     <label>元素特质</label>
                                     <select id="yssxUpdate">
                                         <option value="无">无</option>
                                         <option value="内在需求-稳定特质">内在需求-稳定特质</option>
                                         <option value="内在需求-可变特质">内在需求-可变特质</option>
                                         <option value="环境刺激-日常改造行为">环境刺激-日常改造行为</option>
                                         <option value="环境刺激-异常狱情">环境刺激-异常狱情</option>
                                    </select>
                                    <label for="name">元素用途:</label>
                                    <select id="ytxzUpdate">
                                        <option value="1">作为因子</option>
                                        <option value="2">作为维度</option>
                                        <option value="3">作为维度或者因子</option>
                                    </select>
                                 </li>
                             </ul>
						</div>
						<div class="modal-footer">
							 <button type="button" class="btn btn-default" id="closeUpdateYSK" data-dismiss="modal">关闭</button> 
							 <button type="button" class="btn btn-primary" onclick="saveUpdateYSK()">保存</button>
						</div>
					</div>
				</div>
			</div>
				
			</div>
			<!-- 问题选项卡 -->
			<div class="tab-pane" id="panel-23971">
			     <form class="form-horizontal" role="form" style="margin: 20px 20px;">
			        <div class="form-group-left">
						<label for="name">选择监狱:</label>
						   <select id="select_org_question" class="form-control-left">
							   <option value="" selected="true" disabled="true">请选择监狱</option>
							   <option value="4400">广东省监狱管理局</option>
							   <option value="4413">惠州监狱</option>
							   <option value="4450">女子监狱</option>
							   <option value="4480">未成年犯管教所</option>
						   </select>
					</div>
			        <div class="form-group-left">
						<label for="name">选择维度:</label>
						   <select id="select_dim_question" class="form-control-left">
							   <option value="" selected="true" disabled="true">请选择维度</option>
						   </select>
						   (<span style="color:red">变更维度将清空选项内容</span>)
					</div>
					
					<div class="form-group-left">
					   <label for="name" class="input_name">填写问题:</label>
					   <textarea id="quest_context" class="form-control-left"  cols="80" rows="3"></textarea>
					</div>
					<div class="form-group-left">
					   <label for="name">问题类型:</label>
					   <input type="radio" name="type" class="form-control-left" checked="checked" value="1"/>单选
					   <input type="radio" name="type" class="form-control-left" value="2"/>多选
					</div>
					<div class="form-group-left">
					   <label for="name" class="input_name">判断依据:</label>
					   <textarea id="booleanTrue" class="form-control-left"  cols="80" rows="3"></textarea>
					</div>
					<div class="form-group-left">
					<div class="f_l">
					   <label for="name">选项内容:</label>
					   <input type="text" name="options" class="form-control-left" id="input_option_content" placeholder="选项名称"/>
					   <input type="button" onclick="copy_factorname()" class="copy_factorname" value="="/><label for="name">因子:</label>
					   <select class="form-control-left" id="select_factor_question">
					      <option  value="" selected="true" disabled="true">请选择因子</option>
					   </select>
					   <input type="button" id="insert_wenti_yz" class="btn btn-success" value="添加问题选项"/>
					   </div>
					   <div id="input_options" class="tips"></div>
					</div>
					<div class="form-group-left" style="clear:both">
					  <div style="width:650px;height:150px;overflow-y:auto; border: 1px solid #000;margin-top:10px; ">
					     <span id="wenti_yz_select"></span>
					  </div>
					  <button type="button" onclick="resh_options()" class="btn btn-info btn-sm">
                          <span class="glyphicon glyphicon-refresh"></span>清除选项内容
                      </button>
					</div>
					<div class="form-group-left">
					   <button type="button" onclick="wenti_yz_select_save()" style="margin:10px 550px;" class="btn btn-success">保存</button>
					</div>
			     </form>
			</div>
		</div>
	</div>
	
	<!-- system modal start -->
	<div id="ycf-alert" class="modal">
		<div class="modal-dialog modal-sm">
			<div class="modal-content" id="yskContent">
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
		xhr.open("get", "<c:url value='/resource/systemBlank/assets/js/page/yzManager.js'/>", true);
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