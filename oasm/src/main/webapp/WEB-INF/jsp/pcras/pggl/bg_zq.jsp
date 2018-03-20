<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>评估报告</title>
<!-- 分页样式 -->
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resource/css/page.css'/>">

</head>
<body>
	<!--评估报告生成与查询 -->
	<div id="" class="sub-block">
		<!-- 定位栏-->
		<div class="location">
			<div class="location_left">
				<i><font color="#ffffff"><strong>您现在的位置</strong></font></i>
			</div>
			<div class="location_right">
				<strong>&nbsp;&nbsp;评估管理 >><font color="#ff3300">中期评估报告</font></strong>
			</div>
		</div>
		<!-- 功能子块-->
		<div class="main_content">
			<!--选项卡 -->
			<div id="option" class="option_area">
				<ul>
					<li id="zq_bgsc" name="zq_bgsc" class="option_li_current">评估进程及报告查询</li>
					<!-- <li id="zq_bgcx" name="zq_bgcx">评估报告查询</li> -->
					<li id="zq_bgcz" name="zq_bgcz">处置跟踪</li>
					<li id="zq_bghy" name="zq_bghy">监区审核意见</li>
					<li id="zq_bgsp" name="zq_bgsp">危评中心意见</li>
					<!-- <li id="zq_bgfy" name="zq_bgfy">复议</li> -->
				</ul>
			</div>
			<!--可选内容 -->
			<div id="basecontent" class="main_content_base">
			
			</div>
		</div>
	</div>
<!-- 页面内容的js -->
<script type="text/javascript"
	src="<c:url value='/resource/js/pggl/pggl.js'/>"></script>
<!-- <script type="text/javascript" -->
<%-- 	src="<c:url value='/resource/js/page.js'/>"></script> --%>
	
	<script type="text/javascript">
	$(function() {
		$('#basecontent').load("/oasm/pgbgsccxView/zq_bgsc");		
	});
	$('#option li').click(function (event) {
		$(this).addClass('option_li_current').siblings().removeClass('option_li_current');
		switch ($(this).attr("id")) {
			case "zq_bgsc"://中期评估报告生成(评估进程及报告查询)
				$("#basecontent").load("/oasm/pgbgsccxView/zq_bgsc");
				break;
			case "zq_bgcx"://中期评估报告查询
				$("#basecontent").load("/oasm/pgbgsccxView/zq_bgcx");
				break;
			case "zq_bgcz"://中期评估报告处置跟踪
				$("#basecontent").load("/oasm/czgzView/zq_bgcz");
				break;
			case "zq_bgsp"://中期评估报告审核（危评中心意见）
				$("#basecontent").load("/oasm/bgspView/zq_bgsp");
				break;
			case "zq_bghy"://中期评估报告合议（监区审核）
				$("#basecontent").load("/oasm/fyhyView/zq_bghy");
				break;
			case "zq_bgfy"://中期评估报告复议
				$("#basecontent").load("/oasm/fyhyView/zq_bgfy");
				break;
		}
	});
// 	$(function() {
// 		goPage(1, 10);
// 	});
</script>
</body>
</html>