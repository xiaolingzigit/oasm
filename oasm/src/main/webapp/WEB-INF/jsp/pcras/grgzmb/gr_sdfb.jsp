<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>个人任务</title>
</head>
<body>

	<div class="layer02">
		<div class="add_sub1">
			<span>任 务：</span> <select id='taskTypeOp' class="info_select">
				<option value='inRep'>入监评估</option>
				<option value='dyRep'>日常评估</option>
				<option value='mdRep'>中期评估</option>
				<option value='otRep'>出监评估</option>
			</select>
		</div>
		<div class="add_sub1">
			<span>完成期限：</span> <input id="deadline" type="text"
				class="select_time" maxLength="10"
				onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
		</div>
		<div class="add_sub1">
			<span>评估对象：</span>
			<!-- <textarea class="task_area3" id="crimNo"></textarea> -->
			<button id="sa_c_btn">添加</button>
			<span style="margin-left: 15px">已选<span id="crim_amount"
				class="">0</span>人
			</span>
		</div>

		<div class="add_sub2">
			<button id='publish' class="button_submit">确认发布</button>
		</div>
		<!-- 			<div class="add_sub1">
				<span>任务依据：</span>
				<textarea id="taskBasis" class="task_area1" /></textarea>
			</div> -->
		<div class="add_sub1" style="clear: both; width: 95%">
			<span>备注：</span>
			<textarea id="taskDescrib" class="task_area2" /></textarea>
		</div>
		<!--  <div class="add_sub1">
				<span>任务执行人：</span>
				<button style="vertical-align: top" id="sa_p_btn">选择执行人</button><span class="task_area1" id="excutor"></span></div> -->
		<span class="task_area1" id="excutor"></span>

		<div class="addtask_r" id="search_police" style="display: none">
			<div class="title_bar">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;警察检索</div>
			<table class="addtask_r_w .search_cap">
				<tr>
					<td>监区:</td>
					<td><select>
							<option value="">全监</option>
							<option value="一监区">一监区</option>
							<option value="一监区">二监区</option>
							<option value="三监区">三监区</option>
							<option value="四监区">四监区</option>
							<option value="五监区">五监区</option>
							<option value="六监区">六监区</option>
							<option value="七监区">七监区</option>
							<option value="八监区">八监区</option>
							<option value="九监区">九监区</option>
							<option value="十监区">十监区</option>
							<option value="十二监区">十二监区</option>
							<option value="医院监区">医院监区</option>
							<option value="新犯队">新犯队</option>
							<option value="出监管区">出监管区</option>
							<option value="狱政科">狱政科</option>
					</select></td>
					<td>分监区:</td>
					<td><select>
							<option value="">全分监区</option>
							<option value="分监区1">分监区1</option>
							<option value="分监区2">分监区2</option>
							<option value="分监区3">分监区3</option>
					</select></td>
				</tr>
				<tr>
					<td>警号:</td>
					<td><input type="text" id="" /></td>
					<td>姓名:</td>
					<td><input type="text" id="" /></td>
				</tr>
				<tr>
					<td colspan="4" style="text-align: center"><button>检索</button></td>
				</tr>
			</table>
			<div class="addtask_r_w" style="background: #fff;">
				<table style="width: 100%">
					<colgroup>
						<col width="4%">
						<col width="32%">
						<col width="32%">
						<col width="32%">
					</colgroup>
					<tr>
						<th></th>
						<th>监区</th>
						<th>警号</th>
						<th>姓名</th>
					</tr>
				</table>
			</div>
			<div class="addtask_r_w search_cap_rs">
				<table id="police_tb" style="text-align: center; width: 100%">
					<colgroup>
						<col width="4%">
						<col width="32%">
						<col width="32%">
						<col width="32%">
					</colgroup>
					<tr>
						<td><input type="radio" name="policeinfo" id="" value="" /></td>
						<td>三监区</td>
						<td>1000001</td>
						<td>干警1</td>
					</tr>
					<tr>
						<td><input type="radio" name="policeinfo" id="" value="" /></td>
						<td>三监区</td>
						<td>1023654</td>
						<td>干警10</td>
					</tr>
				</table>
			</div>
			<span id="jc_sjzl"></span>&nbsp; <span>每页15条</span>&nbsp; <span
				id="jc_btn0"></span>
			<!--  <span  id="jc_pageSizeSet">设置</span>&nbsp;           -->
			<button id="jc_btn1">首页</button>
			<button id="jc_btn2">上一页</button>
			<button id="jc_btn3">下一页</button>
			<button id="jc_btn4">尾页</button>
			&nbsp; <span>转到&nbsp;</span> <input id="jc_changePage" type="text"
				size="1" maxlength="4" /> <span>页&nbsp;</span>
			<button id="jc_btn5">跳转</button>
			<!-- <div><button>添加选中</button></div> -->
		</div>
	</div>
	<!-- table -->
	<div class="layer02" id="search_criminal" style="display: none">
		<div class="search_title">罪犯检索：</div>
		<div class="search_area">
			<fieldset class="instruct">
				<legend>基础信息</legend>
				<table class="search_tb">
					<tr>
						<th>监&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;区</th>
						<td><select id="prison" class="search_tb_select">
								<option value="">全监</option>
								<option value="一监区">一监区</option>
								<option value="一监区">二监区</option>
								<option value="三监区">三监区</option>
								<option value="四监区">四监区</option>
								<option value="五监区">五监区</option>
								<option value="六监区">六监区</option>
								<option value="七监区">七监区</option>
								<option value="八监区">八监区</option>
								<option value="九监区">九监区</option>
								<option value="十监区">十监区</option>
								<option value="十二监区">十二监区</option>
								<option value="医院监区">医院监区</option>
								<option value="新犯队">新犯队</option>
								<option value="出监管区">出监管区</option>
								<option value="狱政科">狱政科</option>
						</select></td>
						<th>囚&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号</th>
						<td><input type="text" id="crimNo" class="search_tb_input" /></td>
						<th>罪&nbsp;&nbsp;犯&nbsp;&nbsp;姓&nbsp;&nbsp;名</th>
						<td><input type="text" id="crimName" class="search_tb_input" /></td>
					</tr>
					<tr>
						<th>警察查找类型</th>
						<td><select id="copType" class="search_tb_select">
								<!-- 所有all/专管zg/协管xg -->
								<option value="zg">专管</option>
								<option value="xg">协管</option>
						</select></td>
						<th>警&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号</th>
						<td><input type="text" id="copAllNo" class="search_tb_input" /></td>
						<th>警&nbsp;&nbsp;察&nbsp;&nbsp;姓&nbsp;&nbsp;名</th>
						<td><input type="text" id="copAllName"
							class="search_tb_input" /></td>
					</tr>
					<tr>
						<td colspan="6">
							<button class="button_submit3" id='getCrimCopInfo'>&nbsp;搜&nbsp;&nbsp;索&nbsp;</button>
						</td>
					</tr>
				</table>
			</fieldset>
		</div>

		<div style="background: #e0e0e0; clear: both; width: 100%;">
			<div class="addtask_r_w">
				<table style="width: 100%" id=''>
					<colgroup>
						<col width="5%">
						<col width="13%">
						<col width="13%">
						<col width="13%">
						<col width="13%">
						<col width="13%">
						<col width="13%">
						<col width="13%">
					</colgroup>
					<tr>
						<th><input type="checkbox" id="selectall"
							class='common_checkbox' value="" /></th>
						<th>监区</th>
						<th>囚号</th>
						<th>姓名</th>
						<th>入监时间</th>
						<th>出监时间</th>
						<th>专管警察</th>
						<th>协教警察</th>
					</tr>
				</table>
			</div>
			<div class="addtask_r_w search_cap_rs">
				<table id="criminal_tb" style="text-align: center; width: 100%">
					<colgroup>
						<col width="5%">
						<col width="13%">
						<col width="13%">
						<col width="13%">
						<col width="13%">
						<col width="13%">
						<col width="13%">
						<col width="13%">
					</colgroup>

				</table>
			</div>
			<div id="barcon" class="barcon">
				<span id="barcon1" class="barcon1"></span> <span id="barcon2"
					class="barcon2">
					<ul class="paging_ul">
						<li><button id="firstPage">首页</button></li>
						<li><button id="prePage">上一页</button></li>
						<li><button id="nextPage">下一页</button></li>
						<li><button id="lastPage">尾页</button></li>
						<li><select id="jumpWhere" style="width: 50px; height: 30px;"></select></li>
						<li><button id="jumpPage" onclick="jumpPage()">跳转</button></li>
					</ul>
				</span> <span id="pageSize" style="display: none;"></span> <span id="pages"
					style="display: none;"></span> <span id="pageNum"
					style="display: none;"></span>
			</div>
		</div>
	</div>
	<div id="show_task" class="layer02">
		<span class="show_task" style="margin-left: 20px;">查看近期发布任务</span><span
			class="auxiliary_prompt">展开↓</span>
	</div>
	<div class="content_table" id="have_assigned" style="display: none">
		<table width="100%" id='currTaskTable'>
			<tr>
				<th class="base_th" width="8%">序号</th>
				<th class="base_th" width="10%">囚号</th>
				<th class="base_th" width="8%">姓名</th>
				<th class="base_th" width="8%">监区</th>
				<th class="base_th" width="8%">入监时间</th>
				<th class="base_th" width="10%">任务类型</th>
				<th class="base_th" width="10%">完成期限</th>
				<th class="base_th" width="8%">任务人</th>
			</tr>
			<tr>
				<td class="base_th">无信息</td>
				<td class="base_th">...</td>
				<td class="base_th">...</td>
				<td class="base_th">...</td>
				<td class="base_th">...</td>
				<td class="base_th">...</td>
				<td class="base_th">...</td>
				<td class="base_th">...</td>
			</tr>
		</table>
		<div class="fenye">
			<ul class="fenye-ul">
				<li>共2页</li>
				<li>首页</li>
				<li>上一页</li>
				<li class="fenye-li01">1</li>
				<li class="fenye-li02">2</li>
				<li>下一页</li>
				<li>尾页</li>
				<li>转到第 <input type="text" /> 页
				</li>
			</ul>
		</div>
	</div>
	<!-- 发布任务的分页 -->
	<script type="text/javascript"
		src="<c:url value='/resource/js/grgzmb/grgzmb.js'/>"></script>
	<script type="text/javascript">
		$(function() {
			goPage(1, 15, 'grsdfb');
		});
		$("#getCrimCopInfo").click(function() {
			goPage(1, 15, 'grsdfb');
			getCrimCopInfo();
		});
	</script>
</body>
</html>
