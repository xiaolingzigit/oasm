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
	<!--数据采集与排查 -->
				<!--档案分析 -->
	<div class="layer02">
		<div class="search_title">筛选条件：</div>
			<div style="float: left;" class="search_sub1" >
				囚号:<input type="text" id="rjqh"/>
			</div>
			<div style="float: left;" class="search_sub1">
				罪犯姓名：<input type="text"  id="rjxm"/>
			</div>
			<div style="float: left;" class="search_sub1">
				<button class="button_submit2" id="rjss">搜索</button>
			</div>
			<div class="search_sub3">
				
			</div>
		</div>
	</div>
	<div id="dafxtab" class="option_table3">
					<table class="content_table" width="100%">
						<thead>
							<tr>
								<th width="5%">序号</th>
								<th width="10%">囚号</th>
								<th width="10%">罪犯姓名</th>
								<th width="10%">分析情况</th>
								<th width="10%">分析得分</th>
								<th width="10%">详细信息</th>
							</tr>
						</thead>
						<tbody id="adminTbody">
							<!-- ajax返回列表 	page.js -->
						</tbody>
					</table>
						
					<div id="barcon" class="barcon">
						<div id="barcon1" class="barcon1">
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
					
<script type="text/javascript">
$(function(){
	goPage(1,10,'rjdafx');
    });
</script>
</body>
</html>