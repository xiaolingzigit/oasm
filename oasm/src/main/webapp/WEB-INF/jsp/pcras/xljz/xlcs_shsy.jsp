<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>社会适应性量表</title>
<!-- 分页样式 -->
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resource/css/page.css'/>">

</head>
<body>
	<!--心理测试 -->
	<div class="layer02">
		<div class="search_title">筛选条件：</div>
		<div class="search_area">
		<fieldset class="instruct">
				<table class="search_tb">
					<tr>
						<th>监&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;区</th>
						<td><select id="cjft_ss_selected" class="search_tb_select">
								<option value="十监区">十监区</option>
								<option value="出监管区">出监管区</option>
						</select></td>
						<th>囚&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号</th>
						<td><input type="text" id="cjftqh" class="search_tb_input" /></td>
						<th>罪&nbsp;&nbsp;犯&nbsp;&nbsp;姓&nbsp;&nbsp;名</th>
						<td><input type="text" id="cjftxm" class="search_tb_input" /></td>
						<th>警&nbsp;&nbsp;察&nbsp;&nbsp;姓&nbsp;&nbsp;名</th>
						<td><input type="text" id="cjftjhxm" class="search_tb_input" /></td>
					</tr>
					<tr>
						<th>测&nbsp;&nbsp;试&nbsp;&nbsp;情&nbsp;&nbsp;况</th>
						<td colspan="3" id="cjjgft_ss_radio">
						<input type="radio" name="csqk" value="" /> 
							<label for="status_all">全部 </label>
						<input type="radio" name="csqk"value="" />
							<label for="status_4">已测试</label> 
						<input type="radio" name="csqk" value="" />
							<label for="status_3">未完成</label> 
			
						<td><button class="button_submit2" id="cjjgft_ss_btn">&nbsp;搜&nbsp;&nbsp;索&nbsp;</button></td>
					</tr>
				</table>
			</fieldset>	
		</div>
	</div>
	<!--社会适应性量表 -->
	<div id="xlcstab" class="option_table3">
		<table class="content_table" width="100%">
			<tr>
				<th class="base_th" width="5%">序号</th>
				<th class="base_th" width="10%">囚号</th>
				<th class="base_th" width="10%">罪犯姓名</th>
				<th class="base_th" width="10%">监区</th>
				<th class="base_th" width="10%">测试时间</th>
				<th class="base_th" width="10%">测试得分</th>
				<th class="base_th" width="10%">专管警察</th>
				<th class="base_th" width="10%">测试状态</th>
				<th class="base_th" width="10%">操作</th>
			</tr>
			<tr>
				<td>1</td>
				<td>6546545454</td>
				<td>周易</td>
				<td>三监区</td>
				<td>2017-07-07</td>
				<td>9</td>
				<td>王峰</td>
				<td>已测试</td>
				<td><a href="#"
					onclick="loadnext3('/oasm/xljzView/xlcs_shsyrs')">查看详情</a></td>
			</tr>
			<tr>
				<td>2</td>
				<td>6546545454</td>
				<td>林芝市</td>
				<td>三监区</td>
				<td>无</td>
				<td>无</td>
				<td>王峰</td>
				<td>未测试</td>
				<td><div class="addbutton2"
						onclick="loadnext3('/oasm/xljzView/xlcs_shsylb')">进入测试</div></td>
		</table>
		<div id="barcon" class="barcon">
			<div id="barcon1" class="barcon1">共2条记录&nbsp;当前1/1页</div>
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
		<span id="pageSize" style="display: none;"></span> <span id="pages"
			style="display: none;"></span> <span id="pageNum"
			style="display: none;"></span>
	</div>

	<!-- 页面内容的js -->
	<script type="text/javascript"
		src="<c:url value='/resource/js/pggl/pggl.js'/>"></script>
	<script type="text/javascript"
		src="<c:url value='/resource/js/page.js'/>"></script>

</body>
</html>