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
				<strong>&nbsp;&nbsp;评估管理 >><font color="#ff3300">出监评估录入</font></strong>
			</div>
		</div>
		<!-- 功能子块-->
		<div class="main_content">
			<!--选项卡 -->
			<div id="option" class="option_area">
				<ul>
					<!-- <li id="cj_dafx" name="cj_dafx" class="option_li_current">档案分析</li> -->
					<li id="cj_jgft" name="cj_jgft" >结构性访谈</li>
					<!-- <li id="cj_rcgc" name="cj_rcgc">行为观察</li> -->
                   <!-- <li id="cj_xlcs" name="cj_xlcs">心理测试数据导入</li> -->
                   <li id="cj_shsy" name="cj_shsy">心理测试</li>
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
		$('#basecontent').load("/oasm/dafxView/cj_jgft");		
	});
	$('#option li').click(function (event) {
		$(this).addClass('option_li_current').siblings().removeClass('option_li_current');
		switch ($(this).attr("id")) {

		/* 	case 'cj_dafx': //出监档案分析
				$("#basecontent").load("/oasm/dafxView/cj_dafx");
				break; */
			case "cj_jgft"://出监结构性访谈
				$("#basecontent").load("/oasm/dafxView/cj_jgft");
				break;
			case "cj_rcgc"://出监日常观察
				$("#basecontent").load("/oasm/dafxView/cj_rcgc");
				break;
			/* case "cj_xlcs"://出监心理测试
				$("#basecontent").load("/oasm/dafxView/cj_xlcs");
				break; */
			case "cj_shsy"://出监社会适应性量表
				$("#basecontent").load("/oasm/dafxView/cj_shsy");
				break;
		/*	case "cj_copa"://出监copa 
				$("#basecontent").load("/oasm/dafxView/cj_copa");
				break;
			case "cj_scl90"://出监scl90
				$("#basecontent").load("/oasm/dafxView/cj_scl90");
				break;*/
		}
	});
	
</script>
</body>
</html>