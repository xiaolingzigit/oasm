<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
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
	<!--数据采集与排查 -->
	<div class="layer02">
		<div class="search_title">筛选条件：</div>
		<div class="search_area">
			<div style="float:left;" class="search_sub1">
				监区: <select>
					<option value ="">全监</option>
					<option value ="一监区">一监区</option>
					<option value ="一监区">二监区</option>
					<option value ="三监区">三监区</option>
					<option value ="四监区">四监区</option>
					<option value ="五监区">五监区</option>
					<option value ="六监区">六监区</option>
					<option value ="七监区">七监区</option>
					<option value ="八监区">八监区</option>
					<option value ="九监区">九监区</option>
					<option value ="十监区">十监区</option>
					<option value ="十二监区">十二监区</option>
					<option value ="医院监区">医院监区</option>
					<option value ="新犯队">新犯队</option>
					<option value ="出监管区">出监管区</option>
					<option value ="狱政科">狱政科</option>
				</select>
			</div>
			<div style="float:left;" class="search_sub1">
				囚号:<input type="number" />
			</div>
			<div style="float:left;" class="search_sub1">
				罪犯姓名：<input type="text" />
			</div>
			<div style="float:left;" class="search_sub1">
				警号：<input type="number" />
			</div>
			<div style="float:left;" class="search_sub1">
				专管警察：<input type="text" />
			</div>
						<div style="float:left;" class="search_sub1">
				<button class="button_submit2">搜索</button>
			</div>
			<div  class="search_sub2">
				测试状态：<input type="radio" name="csqk" value=""/> 所有 <input type="radio" name="csqk" value=""/> 未开始 <input
					type="radio" name="csqk" value="" /> 未完成 <input type="radio" name="csqk" value=""/> 已完成 <input type="radio" name="csqk" value=""/> 已取消 
			</div>
			
		</div>
	</div>
	<!--心理测试 -->
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
								onclick="loadnext3('/oasm/xljzView/xlcs_xszfbg')">查看详情</a></td>
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
							<td><div class="addbutton2"onclick="loadnext3('/oasm/xljzView/xlcs_xszflb')">
							进入测试</div>
					        </td>
						</table>
					<div id="barcon" class="barcon">
						<div id="barcon1" class="barcon1">
						共2条记录&nbsp;当前1/1页
						</div>
						<div id="barcon2" class="barcon2">
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
					</div>
					<span id="pageSize" style="display: none;"></span>
					<span id="pages" style="display: none;"></span>
					<span id="pageNum" style="display: none;"></span>
			</div>

<!-- 页面内容的js -->
<script type="text/javascript"
	src="<c:url value='/resource/js/pggl/pggl.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/resource/js/page.js'/>"></script>
	
</body>
</html>