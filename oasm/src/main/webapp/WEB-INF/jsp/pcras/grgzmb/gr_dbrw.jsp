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
		<div id="" class="">
			<div>
				<div class="layer02">
					<h3>
						<font size="" color="#ff0033">待办任务</font>
					</h3>
				</div>
			</div>
		</div>

		<!-- table -->
		<br>
		<div class="content_table">
			<table width="100%" id='taskToDoTable'>
			           <colgroup>										
							<col width="5%">
							<col width="14%">
							<col width="12%">
							<col width="15%">
							<col width="15%">
							<col width="15%">
							<col width="12%">
							<col width="10%">
						</colgroup>
				<tr>

					<th class="base_th" width="8%">序号</th>
					<th class="base_th" width="10%">任务类型</th>
					<th class="base_th" width="8%">囚号</th>
					<th class="base_th" width="8%">测评对象</th>
					<th class="base_th" width="10%">发布时间</th>
					<th class="base_th" width="10%">完成期限</th>
					<th class="base_th" width="8%">任务人</th>
					<th class="base_th" width="8%">任务状态</th>

				</tr>
				<tbody id ="dbrw"></tbody>
			</table>
		</div>

		<br/>
		<div id="barcon" class="barcon">
			<span id="barcon1" class="barcon1">共3条记录&nbsp;当前1/1页</span> 
			<span id="barcon2" class="barcon2">
				<ul class="paging_ul">
					<li><a id="firstPage">首页</a></li>&nbsp;
					<li><a id="prePage">上一页</a></li>&nbsp;
					<li><a id="nextPage">下一页</a></li>&nbsp;
					<li><a id="lastPage">尾页</a></li>&nbsp;
					<li><select id="jumpWhere" style="width: 50px; height: 30px;"></select></li>
					<li><a id="jumpPage" onclick="jumpPage()">跳转</a></li>
				</ul>
			</span> 
			<span id="pageSize" style="display: none;"></span> 
			<span id="pages" style="display: none;"></span> 
			<span id="pageNum"	style="display: none;"></span>

		</div>


		<script type="text/javascript"
			src="<c:url value='/resource/js/grgzmb/grgzmb.js'/>"></script>
		<script type="text/javascript"
			src="<c:url value='/resource/js/pggl/rcgc.js'/>"></script>
		<script type="text/javascript" 
			src="<c:url value='/resource/js/grgzmb/grdbrw.js'/>"></script>
</body>

</html>
