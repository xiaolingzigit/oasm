<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>专项管理</title>
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
				<strong>&nbsp;&nbsp;专项管理 >><font color="#ff3300">特殊罪犯管理</font></strong>
			</div>
		</div>
		<!-- 功能子块-->
		<div class="main_content">
			<!--选项卡 -->
			<div id="option" class="option_area">
				<ul>
					<li id="wafgl" name="wafgl" class="option_li_current">危安犯</li>
					<li id="hivfgl" name="hivfgl">艾滋病犯</li>
					<li id="xjfgl" name="xjfgl">邪教犯</li>
					<li id="wjfgls" name="wjfgl">外籍犯</li>
					<li id="jsbfgl" name="jsbfgl">精神病犯</li>	
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
		$('#basecontent').load("/oasm/zxglView/wafgl");		
	});
	$('#option li').click(function (event) {
		$(this).addClass('option_li_current').siblings().removeClass('option_li_current');
		switch ($(this).attr("id")) {

			case 'wafgl': //危安犯管理
				$("#basecontent").load("/oasm/zxglView/wafgl");
				break;
			case "hivfgl"://艾滋病犯管理
				$("#basecontent").load("/oasm/zxglView/hivfgl");
				break;
			case "xjfgl"://邪教犯管理
				$("#basecontent").load("/oasm/zxglView/xjfgl");
				break;
			case "wjfgl"://外籍犯管理
				$("#basecontent").load("/oasm/zxglView/wjfgl");
				break;
			case 'jsbfgl': //精神病犯管理
				$("#basecontent").load("/oasm/zxglView/jsbfgl");
				break;
		}
	});
</script>
</body>
</html>