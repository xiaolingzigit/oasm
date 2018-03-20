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
	<div id="sdfbtab" class="option_table3">
		<div id="" class="">
			<div>
				<div class="searchBar">
					<B>检索>>></B> <br> <br> &nbsp;监区： <select id='prisonOp'>
						<option value='第一监区'>第一监区</option>
						<option value='第二监区'>第二监区</option>
						<option value='第三监区'>第三监区</option>
						<option value='第四监区'>第四监区</option>
						<option value='第五监区'>第五监区</option>

					</select> &nbsp;分监区：<select id='subPrisonOp'>
						<option value='第一分监区'>第一分监区</option>
						<option value='第二分监区'>第二分监区</option>
						<option value='第三分监区'>第三分监区</option>
						<option value='第四分监区'>第四分监区</option>
						<option value='第五分监区'>第五分监区</option>

					</select> &nbsp;囚号：<input type="text" name="crimNo" /> &nbsp;囚犯姓名：<input
						type="text" name="crimName" /> <input type="button"
						value="&nbsp;检&nbsp;索&nbsp;"
						style="position: absolute; right: 100px;" />
				</div>

				<div class="layer02">

					任务类型: <select id='taskTypeOp'>
						<option value='fileAnlys'>档案分析</option>
						<option value='inRep'>入监评估</option>
						<option value='inTk'>入监结构性访谈</option>
						<option value='inAct'>入监行为观察</option>

						<option value='dyRep'>日常评估</option>
						<option value='dyAct'>日常行为观察</option>

						<option value='mdRep'>中期评估</option>
						<option value='mdTk'>中期结构性访谈</option>
						<option value='mdAct'>中期行为观察</option>

						<option value='otRep'>出监评估</option>
						<option value='otTk'>出监结构性访谈</option>
						<option value='otAct'>出监行为观察</option>

						<option value='inMt'>入监心理测试</option>
						<option value='otMt'>社会适应性心理测试</option>
						<option value='scl90Mt'>SCL-90心理测试</option>
						<option value='copaMt'>COPA-PI心理测试</option>
					</select> 囚号：<input type="text" id="crimNo" /><br> 任务依据：<input
						type="text" id="taskBasis" /><br> 任务描述：<input type="text"
						name="taskDescrib" /><br> 完成期限： <span class="timeset">
						<input type="text" cssClass="Wdate" maxLength="10"
						style="font-size: 16px; font-family:"
						微软雅黑";" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
					</span>
				</div>
				<div style="clear: both; padding: 0 0 0 40%">
					<button id='publish' class="button_submit"
						style="margin-top: 10px;">确认发布</button>
				</div>

			</div>

		</div>

		<!-- table -->
		<br> <br>
		<div class="content_table">
			<table width="100%">
				<tr>
					<th class="base_th" width="5%">序号</th>
					<th class="base_th" width="5%">监区</th>
					<th class="base_th" width="10%">任务</th>
					<th class="base_th" width="10%">警号</th>
					<th class="base_th" width="10%">警察姓名</th>
					<th class="base_th" width="10%">发布时间↓</th>
					<th class="base_th" width="10%">截止时间↓</th>
					<th class="base_th" width="10%">完成情况</th>
					<th class="base_th" width="10%">详细信息</th>
				</tr>
				<tr>
					<td>1</td>
					<td>第十监区</td>
					<td>入监评估</td>
					<td>526237823629</td>
					<td>王甫</td>
					<td>2017-07-07</td>
					<td>2017-07-20</td>
					<td>暂未完成</td>

					<td><a href="#">点击进入</a></td>
				</tr>
				<tr>
					<td>2</td>
					<td>第十监区</td>
					<td>入监评估</td>
					<td>526237823629</td>
					<td>刘备</td>
					<td>2017-07-07</td>
					<td>2017-07-20</td>
					<td>暂未完成</td>
					<td><a href="#")">点击进入</a></td>
				</tr>
				<tr>
					<td>1</td>
					<td>第十监区</td>
					<td>入监评估</td>
					<td>526237823629</td>
					<td>张帆</td>
					<td>2017-07-07</td>
					<td>2017-07-20</td>
					<td>暂未完成</td>
					<td><a href="#">点击进入</a></td>
				</tr>
			</table>

		</div>

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

	<script type="text/javascript"
		src="<c:url value='/resource/js/common.js'/>"></script>
	<script type="text/javascript"
		src="<c:url value='/resource/js/grgzmb/grgzmb.js'/>"></script>
	<script type="text/javascript">
	
		
	
	
		$("#publish").click(
				function(event) {
					var crimNo = $("#");
					var taskType = $('#taskTypeOp option:selected').val();
					var taskBasis = "手动发起任务";
					var taskDescrib = "做scl90测试";
					var deadline = "2017-12-24 01:13:20";
					var status = 2;

					addTask(crimNo, taskType, taskBasis, taskDescrib, deadline,
							status);
				});
	</script>
</body>
</html>
