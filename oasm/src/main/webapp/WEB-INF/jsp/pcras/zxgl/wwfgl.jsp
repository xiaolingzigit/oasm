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
	<!--顽危犯管理 -->
	<div id="" class="sub-block">
		<!-- 定位栏-->
		<div class="location">
			<div class="location_left">
				<i><font color="#ffffff"><strong>您现在的位置</strong></font></i>
			</div>
			<div class="location_right">
				<strong>&nbsp;&nbsp;专项管理 >><font color="#ff3300">顽危罪犯管理</font></strong>
			</div>
		</div>
		<!-- 功能子块-->
		<div class="main_content">
			<!--选项卡 -->
			<div id="option" class="option_area">
				<ul>
					<li id="wwf_xx" name="wwf_xx" class="option_li_current">顽危犯名单</li>
					<li id="wwf_add" name="wwf_add">顽危犯认定</li>
					<li id="wwf_undo" name="wwf_undo">顽危犯撤销</li>
			</ul>
			</div>
			<!--可选内容 -->
			<div id="basecontent" class="main_content_base">
			<div class="not_data">暂无数据</div>
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
//		$('#basecontent').load("/oasm/zxglView/wwf_xx");		
	});
	$('#option li').click(function (event) {
		$(this).addClass('option_li_current').siblings().removeClass('option_li_current');
//		switch ($(this).attr("id")) {

//			case "wwf_xx": //顽危犯名单
//				$("#basecontent").load("/oasm/zxglView/wwf_xx");
//				break;
//			case "wwf_add"://顽危犯认定
//				$("#basecontent").load("/oasm/zxglView/wwf_add");
//				break;
//			case "wwf_undo"://顽危犯撤销
//				$("#basecontent").load("/oasm/zxglView/wwf_undo");
//				break;
//		}
	});
</script>
</body>
</html>