<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>档案分析</title>
<!-- 分页样式 -->
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resource/css/page.css'/>">

</head>
<body>
	<!--心理测试 -->
	<div class="layer02">
		<div class="search_title">筛选条件：</div>
		<div class="search_area_l">
			<fieldset class="instruct">
				<legend>基础信息</legend>
				<table class="search_tb">
					<tr>
						<th>监&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;区</th>
						<td><select id="prison" class="search_tb_select">
								<option value="">全监</option>
								<option value="一监区">一监区</option>
								<option value="二监区">二监区</option>
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
						<th>警察检索范围</th>
						<td><select id="copType" class="search_tb_select">
								<option value="all">所有</option>
								<option value="zg">专管警察</option>
								<option value="xg">协管警察</option>
								<option value="zxr">任务执行人</option>
						</select></td>
					</tr>
					<tr>
						<th>囚&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号</th>
						<td><input type="text" id="crimNo" class="search_tb_input" /></td>
						<th>警&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号</th>
						<td><input type="text" id="copAllNo" class="search_tb_input" /></td>
					</tr>
					<tr>
						<th>罪&nbsp;&nbsp;犯&nbsp;&nbsp;姓&nbsp;&nbsp;名</th>
						<td><input type="text" id="crimName" class="search_tb_input" /></td>
						<th>警&nbsp;&nbsp;察&nbsp;&nbsp;姓&nbsp;&nbsp;名</th>
						<td><input type="text" id="copAllNames"
							class="search_tb_input" /></td>
					</tr>
				</table>
			</fieldset>
		</div>
		<div class="search_area_r">
			<fieldset class="instruct">
				<legend>任务信息</legend>
				<table class="search_tb2">
					<tr>
						<th>任&nbsp;务&nbsp;发&nbsp;布&nbsp;人</th>
						<td><input type="text" id="creator" class="search_tb_input" /></td>
						<th>&nbsp;&nbsp;&nbsp;&nbsp;任&nbsp;务&nbsp;状&nbsp;态</th>
						<td><select id="status" class="search_tb_select">
								<option value="">所有</option>
								<option value="1">未开始</option>
								<option value="3">未完成</option>
								<option value="4">已完成</option>
								<option value="10">已取消</option>
						</select></td>
					</tr>
					<tr>
						<th>任务发布时间</th>
						<td colspan="3"><input type="text"
							class="select_time search_tb_input" id="crTimeStart"
							maxLength="10" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
							至 <input type="text" class="select_time search_tb_input"
							id="crTimeEnd" maxLength="10"
							onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" /></td>
					</tr>
					<tr>
						<th>任务修改时间</th>
						<td colspan="3"><input type="text"
							class="select_time search_tb_input" id="lastModifStart"
							maxLength="10" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
							至 <input type="text" class="select_time search_tb_input"
							id="lastModifEnd" maxLength="10"
							onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" /></td>
					</tr>
					<tr>
						<th>任务截止时间</th>
						<td colspan="3"><input type="text"
							class="select_time search_tb_input" id="deadlineStart"
							maxLength="10" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"
							class="search_tb_input" /> 至 <input type="text"
							class="select_time search_tb_input" id="deadlineEnd"
							maxLength="10" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" /></td>
						<td><div class="search_sub3">
								<button class="button_submit2" id='bt_scl90search'>&nbsp;搜&nbsp;&nbsp;索&nbsp;</button>
							</div></td>
					</tr>

				</table>
			</fieldset>
		</div>

	</div>
	<!--scl90 -->
	<div id="xlcstab" class="option_table3">

		<table id='scl90table' class="content_table" width="100%">
			<tr>
				<th class="base_th" width="8%">序号</th>
				<th class="base_th" width="10%">囚号</th>
				<th class="base_th" width="8%">姓名</th>
				<th class="base_th" width="8%">监区</th>
				<th class="base_th" width="10%">完成期限</th>
				<th class="base_th" width="15%">测试时间</th>
				<th class="base_th" width="8%">得分</th>
				<th class="base_th" width="8%">专管警察</th>
				<th class="base_th" width="8%">测试状态</th>
				<th class="base_th" width="10%">操作</th>
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
				<td class="base_th">...</td>
				<td class="base_th">无操作</td>
			</tr>
			<tr>
				<td class="base_th">...</td>
				<td class="base_th"></td>
				<td class="base_th"></td>
				<td class="base_th"></td>
				<td class="base_th"></td>
				<td class="base_th"></td>
				<td class="base_th"></td>
				<td class="base_th"></td>
				<td class="base_th"></td>
				<td class="base_th"></td>
			</tr>
			<tr>
				<td class="base_th">...</td>
				<td class="base_th"></td>
				<td class="base_th"></td>
				<td class="base_th"></td>
				<td class="base_th"></td>
				<td class="base_th"></td>
				<td class="base_th"></td>
				<td class="base_th"></td>
				<td class="base_th"></td>
				<td class="base_th"></td>
			</tr>
			<tr>
				<td class="base_th">...</td>
				<td class="base_th"></td>
				<td class="base_th"></td>
				<td class="base_th"></td>
				<td class="base_th"></td>
				<td class="base_th"></td>
				<td class="base_th"></td>
				<td class="base_th"></td>
				<td class="base_th"></td>
				<td class="base_th"></td>
			</tr>
			<tr>
				<td class="base_th">...</td>
				<td class="base_th"></td>
				<td class="base_th"></td>
				<td class="base_th"></td>
				<td class="base_th"></td>
				<td class="base_th"></td>
				<td class="base_th"></td>
				<td class="base_th"></td>
				<td class="base_th"></td>
				<td class="base_th"></td>
			</tr>
		</table>
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
	</div>

	</div>

	<!-- 页面内容的js -->
	<script type="text/javascript"
		src="<c:url value='/resource/js/xljz/xlpage.js'/>"></script>
	<script type="text/javascript">
$(function(){
	goPage(1,15,"scl90");
    });
</script>
</body>
</html>