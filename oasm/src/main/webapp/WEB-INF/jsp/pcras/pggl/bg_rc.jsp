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
				<strong>&nbsp;&nbsp;评估管理 >><font color="#ff3300">日常评估报告</font></strong>
			</div>
		</div>
		<!-- 功能子块-->
		<div class="main_content">
			<!--选项卡 -->
			<div id="option" class="option_area">
				<ul>
					<li id="rc_bgsc" name="rc_bgsc" class="option_li_current">评估进程及报告查询</li>
					<!-- <li id="rc_bgcx" name="rc_bgcx">评估报告查询</li> -->
					<li id="rc_bgcz" name="rc_bgcz">处置跟踪</li>
					<li id="rc_bghy" name="rc_bghy">监区审核意见</li>
					<li id="rc_bgsp" name="rc_bgsp">危评中心意见</li>
					<!-- <li id="rc_bgfy" name="rc_bgfy">复议</li> -->
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
		$('#basecontent').load("/oasm/pgbgsccxView/rc_bgsc");		
	});
	$('#option li').click(function (event) {
		$(this).addClass('option_li_current').siblings().removeClass('option_li_current');
		switch ($(this).attr("id")) {
			case "rc_bgsc"://日常评估报告生成(评估进程及报告查询)
				$("#basecontent").load("/oasm/pgbgsccxView/rc_bgsc");
				break;
			case "rc_bgcx"://日常评估报告查询
				$("#basecontent").load("/oasm/pgbgsccxView/rc_bgcx");
				break;
			case "rc_bgcz"://日常评估报告处置跟踪
				$("#basecontent").load("/oasm/czgzView/rc_bgcz");
				break;
			case "rc_bgsp"://日常评估报告审核（危评中心意见）
				$("#basecontent").load("/oasm/bgspView/rc_bgsp");
				break;
			case "rc_bghy"://日常评估报告合议（监区审核）
				$("#basecontent").load("/oasm/fyhyView/rc_bghy");
				break;
			case "rc_bgfy"://日常评估报告复议
				$("#basecontent").load("/oasm/fyhyView/rc_bgfy");
				break;
		}
	});
// 	$(function() {
// 		goPage(1, 10);
// 	});
</script>
</body>
</html>