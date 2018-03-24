<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0" />
<title>出监评估系统</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resource/easyui/themes/metro/easyui.css'/>">
<link rel="stylesheet" type="text/css" href="<c:url value='/resource/easyui/themes/icon.css'/>">
<link rel="stylesheet" type="text/css" href="<c:url value='/resource/css/home.css'/>">
<link rel="stylesheet" type="text/css" href="<c:url value='/resource/css/czgz.css'/>">
<link rel="stylesheet" type="text/css" href="<c:url value='/resource/css/co.css'/>">
<!--评估工具样式-->
<link rel="stylesheet" type="text/css" href="<c:url value='/resource/css/pggjgl.css'/>">
<link rel="stylesheet" type="text/css" href="<c:url value='/resource/css/yzfx.css'/>">
<link rel="stylesheet" type="text/css" href="<c:url value='/resource/css/pgbgfx.css'/>">
<link rel="stylesheet" type="text/css" href="<c:url value='/resource/css/fxmb.css'/>">
<!--复议与合议样式-->
<link rel="stylesheet" type="text/css" href="<c:url value='/resource/css/fyhy.css'/>">
<!--教育改造样式-->
<link rel="stylesheet" type="text/css" href="<c:url value='/resource/css/jygz.css'/>">
<!-- 分页样式 -->
<%-- <link rel="stylesheet" type="text/css" href="<c:url value='/resource/css/page.css'/>"> --%>
<!--评估报告样式-->
<link rel="stylesheet" type="text/css" href="<c:url value='/resource/css/pgbg.css'/>">
<!--统计分析样式-->
<link rel="stylesheet" type="text/css" href="<c:url value='/resource/css/tjfx.css'/>">
<!--个人工作任务样式-->
<link rel="stylesheet" type="text/css" href="<c:url value='/resource/css/grrw.css'/>">
<!--个人设置-->
<link rel="stylesheet" type="text/css" href="<c:url value='/resource/css/setting.css'/>">
<!--打印样式-->
<link rel="stylesheet" type="text/css" href="<c:url value='/resource/css/printstyle.css'/>"  media="print">

</head>
<body>
<div class="bg_div">
   <div id="xtPage">
        <div id="" class="user_bar">
        <div style="float:right;"> 
         <div style="float:left">欢迎您，<span style="color:red"><shiro:principal/></span></div>    
         <div style="float:left;margin-left:30px;" id="loginTime" ></div>
         <div  style="float:left;margin-left:30px;margin-right:30px;"><i class="ghlogo"></i> <a  href="#" onclick="loadnext2('/oasm/settingView/setting')" style="color:blue">设置</a></div>
         <div style="float:left;margin-left:30px;margin-right:30px;"> <a  href="<c:url value="/login/logout"/>" style="color:blue">注销</a></div>

        </div>
        </div>
        <i style="width:50px;height:50px" class="ghlogo"></i>
		<div class="header"></div>
		<div id="header_logo"></div>
		<div id="header_xxk">
			<ul class="ul02">
				<!-- <li class="current" id="home">主页</li> -->
				<li class="current" id="pggl">评估管理</li>
				<li id="xljz">心理测试</li>
				<li id="tjfx">再犯罪统计</li>
				<!-- <li id="zxgl">专项管理</li> -->
				<!-- <li id="czgz">处置跟踪</li> -->
				<!-- <li id="pggj">评估工具分析</li> -->
				<li id="jygz">罪犯信息</li>
				<!-- <li id="grmb" class="task">个人任务</li> -->

			</ul>
		</div>
<!-- 评估管理二级菜单 -->
			<div id="" class="sub_menu_line">
				<div id="pggl2" class="sub_menu_area ulm01 ">
					<ul class="sub_menu_ul">
						<li id="lr_cj" class="sub_menu_li">出监评估</li>
						<li class="sub_menu_divider">|</li>
						<li id="bg_cj" class="sub_menu_li">出监评估报告</li>
					</ul>
				<!-- 	<span class="import_btn" >PAD端数据导入</span> -->
				</div>
			</div>
		<!-- 内容 -->
		<div class="content" id="container"></div>

		<p class="footer_font">版权所有：吴晓玲&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;技术支持：吴晓玲</p>
	</div>
		</div>
<script type="text/javascript" src="<c:url value='/resource/js/jquery-1.7.2.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resource/js/my97/WdatePicker.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resource/easyui/jquery.easyui.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resource/easyui/locale/easyui-lang-zh_CN.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resource/echarts/echarts.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resource/echarts/echarts-wordcloud.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resource/js/index.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resource/js/home.js'/>"></script>
		
<script type="text/javascript">
	//二级菜单下加载
	function loadnext2(parm) {
		$('#container').load(parm);
	}
	//选项卡下加载
	function loadnext3(parm) {
		$('#basecontent').load(parm);
	}
</script>

</body>
<script type="text/javascript"
	src="<c:url value='/resource/js/common.js'/>"></script>
</html>