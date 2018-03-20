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
	<div id="" class="sub-block">
		<!-- 定位栏-->
		<div class="location">
			<div class="location_left">
				<i><font color="#ffffff"><strong>您现在的位置</strong></font></i>
			</div>
			<div class="location_right">
				<strong>&nbsp;&nbsp;评估管理 >><font color="#ff3300">中期评估录入</font></strong>
			</div>
		</div>
		<!-- 功能子块-->
		<div class="main_content">
			<!--选项卡 -->
			<div id="option" class="option_area">
				<ul>
					<li id="zq_jgft" name="zq_jgft" class="option_li_current">结构性访谈</li>
					<li id="zq_rcgc" name="zq_rcgc">行为观察</li>
	                <li id="zq_xlcs" name="zq_xlcs">心理测试数据导入</li>

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
<script type="text/javascript"
	src="<c:url value='/resource/js/page.js'/>"></script>
	<script type="text/javascript">
	$(function() {
		$('#basecontent').load("/oasm/dafxView/zq_jgft");		
	});
	$('#option li').click(function (event) {
		$(this).addClass('option_li_current').siblings().removeClass('option_li_current');
		switch ($(this).attr("id")) {
			case "zq_jgft"://中期结构性访谈
				$("#basecontent").load("/oasm/dafxView/zq_jgft");
				break;
			case "zq_rcgc"://中期日常观察
				$("#basecontent").load("/oasm/dafxView/zq_rcgc");
				break;
			case "zq_xlcs"://中期心理测试 
				$("#basecontent").load("/oasm/dafxView/zq_xlcs");
				break;

		}
	});
	
</script>
</body>
</html>