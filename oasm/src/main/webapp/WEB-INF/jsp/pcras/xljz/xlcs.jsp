<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>心理测试</title>
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
				<strong>&nbsp;&nbsp;心理测试 >><font color="#ff3300">社会适应性量表</font></strong>
			</div>
		</div>
		<!-- 功能子块-->
		<div class="main_content">
			<!--选项卡 -->
			<div id="option" class="option_area">
				<ul>
					<!-- <li id="xlcs_xszf" name="xlcs_xszf" class="option_li_current">新收押罪犯量表</li>
	                <li id="xlcs_scl90" name="xlcs_scl90">SCL90</li>
					<li id="xlcs_copa" name="xlcs_copa">COPA-PI</li> -->
					<li id="xlcs_shsy" name="xlcs_shsy" class="option_li_current">社会适应性量表</li>
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
		$('#basecontent').load("/oasm/xljzView/xlcs_shsy");		
	});
	
	$('#option li').click(function (event) {
		$(this).addClass('option_li_current').siblings().removeClass('option_li_current');
		switch ($(this).attr("id")) {
		/* 	case "xlcs_xszf"://新收押罪犯量表
				setRootPage("/oasm/xljzView/xlcs_xszf");
				break;
			case "xlcs_copa"://copa 
				setRootPage("/oasm/xljzView/xlcs_copa");
				break;
			case "xlcs_scl90"://scl90
				setRootPage("/oasm/xljzView/xlcs_scl90");
				break; */
			case "xlcs_shsy"://社会适应性量表
				setRootPage("/oasm/xljzView/xlcs_shsy");
				break;
		}
	});
</script>
	
</body>
</html>