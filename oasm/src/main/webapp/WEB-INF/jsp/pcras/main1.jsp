<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0" />
<title>危险评估系统</title>
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
				<li class="current" id="home">主页</li>
				<li id="pggl">评估管理</li>
				<li id="xljz">心理测试</li>
				<li id="tjfx">统计分析</li>
				<li id="zxgl">专项管理</li>
				<!-- <li id="czgz">处置跟踪</li> -->
				<!-- <li id="pggj">评估工具分析</li> -->
				<li id="jygz">矫正项目</li>
				<li id="grmb">个人任务</li>
			</ul>
		</div>
<!-- 评估管理二级菜单 -->
		 <div id="line" class="line">
			<div id="pggl2" style="clear: both; display: none;">
				<div style="float: left;">
					<ul class="ulmenu ulm01 ">
						<!-- <li id="sjcjpc">专项数据采集与排查&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|</li>
						<li id="gzrwgl">评估工作任务管理&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|</li>
						<li id="pgbgsccx">评估报告生成及查询&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|</li>
						<li id="gwysgl">高危以上罪犯管理&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|</li>
							<li id="fyhy">复议与合议</li> -->
						<li id="lr_rj">入监评估录入</li>
						<li>|</li>
						<li id="bg_rj">入监评估报告</li>
						<li>|</li>
						<li id="lr_rc">日常评估录入</li>
						<li>|</li>
						<li id="bg_rc">日常评估报告</li>
						<li>|</li>
						<li id="lr_zq">中期评估录入</li>
						<li>|</li>
						<li id="bg_zq">中期评估报告</li>
						<li>|</li>
						<li id="lr_cj">出监评估录入</li>
						<li>|</li>
						<li id="bg_cj">出监评估报告</li>
						
					</ul>
					
				</div>
				<span class="addbutton3" >PAD端数据导入</span>
				<img src="<c:url value='/resource/images/dhbottom.png'/>" class="dhbottom">
			</div>
		</div>
		<!-- 心理矫治二级菜单 -->
 <div id="xljzline" class="line">
			<div id="xljz2" style="clear: both; display: none;">
				<div style="float: left;">
					<ul class="ulmenu ulm02">
						<li id="xlcs">心理测试&nbsp;&nbsp;&nbsp;|</li>
					</ul>
				</div>
				<img src="<c:url value='/resource/images/dhbottom.png'/>" class="dhbottom">
			</div>
		</div>
		<!-- 处置跟踪二级菜单 -->
		<div id="czgzline" class="line">
			<div id="czgz2" style="clear: both; display: none;">
				<div style="float: left;">
					<ul class="ulmenu ulm02">
						<li id="czgz">处置跟踪&nbsp;&nbsp;&nbsp;|</li>
						<li id="czdcsjk">处置对策数据库&nbsp;&nbsp;&nbsp;</li>
					</ul>
				</div>
				<img src="<c:url value='/resource/images/dhbottom.png'/>" class="dhbottom">
			</div>
		</div>
		<!-- 统计分析二级菜单 -->
		<div id="tjfxline" class="line">
			<div id="tjfx2" style="clear: both; display: none;">
				<div style="float: left;">
					<ul class="ulmenu ulm03">
						<li id="wxqkbh">危评情况变化</li>
						<li>|</li>
						<li id="wxcdtj">危险程度统计</li>
						<li>|</li>
						<li id="wxlbtj">危险类别统计</li>
						<li>|</li>
						<li id="pgqktj">评估情况统计</li>
						<li>|</li>
						<li id="glzftj">各类罪犯统计</li>
						<li>|</li>
						<li id="yjtj">预警统计</li>

					</ul>
				</div>
				<img src="<c:url value='/resource/images/dhbottom.png'/>" class="dhbottom">
			</div>
		</div>
		<!-- 评估工具管理二级菜单 -->
		<div id="pggjline" class="line">
			<div id="pggj2" style="clear: both; display: none;">
				<div style="float: left;">
					<ul class="ulmenu ulm04">
						<li id="lbfx">量表分析&nbsp;&nbsp;&nbsp;|</li>
				<!-- 		<li id="yzfx">因子分析&nbsp;&nbsp;&nbsp;|</li>
						<li id="pgbgfx">评估报告分析&nbsp;&nbsp;&nbsp;</li> -->
					</ul>
				</div>

				<img src="<c:url value='/resource/images/dhbottom.png'/>" class="dhbottom">
			</div>
		</div>
	<!-- 专项管理二级菜单 -->
		<div id="zxglline" class="line">
			<div id="zxgl2" style="clear: both; display: none;">
				<div style="float: left;">
					<ul class="ulmenu ulm02">
					<li id="jgfgl">极高危罪犯管理</li>
						<li>|</li>
						<li id="gwfgl">高危罪犯管理</li>
						<li>|</li>
						<li id="zdfgl">重点罪犯管理</li>
						<li>|</li>
						<li id="tsfgl">特殊罪犯管理</li>
						<li>|</li>
						<li id="wwfgl">顽危犯管理</li>
					</ul>
				</div>

				<img src="<c:url value='/resource/images/dhbottom.png'/>" class="dhbottom">
			</div>
		</div>
		<!-- 教育改造二级菜单 -->
		<div id="jygzline" class="line">
			<div id="jygz2" style="clear: both; display: none;">
				<div style="float: left;">
					<ul class="ulmenu ulm05">
						<li id="zfxx">罪犯信息查询</li>
						<li>|</li>
						<li id="gzfagz">改造方案实施情况跟踪</li>
						<li>|</li>
					</ul>
				</div>

				<img src="<c:url value='/resource/images/dhbottom.png'/>" class="dhbottom">
			</div>
		</div>
		<!-- 内容 -->
		<div class="content" id="container"></div>

		<p class="footer_font">版权所有：广东省监狱管理局&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;技术支持：北明软件有限公司</p>
	</div>
		</div>
	
	<script type="text/javascript" src="<c:url value='/resource/js/jquery-1.7.2.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resource/js/my97/WdatePicker.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resource/easyui/jquery.easyui.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resource/easyui/locale/easyui-lang-zh_CN.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resource/echarts/echarts.min.js'/>"></script>
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

	function loadnext5() {
		$("#xljz").addClass('current').siblings().removeClass('current');
		$("#container").load("/oasm/xljzView/xlcs");
		 var ej1=document.getElementById("pggl2");
         var menuarea=document.getElementById("line");
	        ej1.style.display="none";menuarea.style.height="0px";
	}
	function loadnext6(b1,b2,b3,parm) {
		$("#"+b1).addClass('current').siblings().removeClass('current');
		$("#container").load(parm+b2);
		window.setTimeout(function() {
			 /*$("#"+b3).addClass('option_li_current').siblings().removeClass('option_li_current');
			    $('#basecontent').load(parm+b3);*/
			    $('#'+b3).click()
		}, 100)
	}
 
	function loadnext7(qh,taskID, rwlx) {
		switch (rwlx) {
		case "rj_jgft":
			$("#pggl").click();
			$("#" + rwlx).click();
			$('#basecontent').load("/oasm/dafxView/rj_jgftlb");
			break;
		case "rj_rcgc":
			$("#pggl").click();
			window.setTimeout(function(){
				$("#rj_rcgc").addClass('option_li_current').siblings().removeClass('option_li_current');
				$("#basecontent").load("/oasm/dafxView/criminalinfo");
			},50)
			break;
		}
	}
</script>
<script type="text/javascript">
	//加载因子分析面板
	function loadyzPage(url) {
		$('#container').load(url);
	}
	//重新跳转为分析面板
	function loadfxmb(url) {
		$('#container').load(url);
	}

// 	$(function(){
//      $("#loginTime").html("登录时间: "+timeStamp2String(new Date()));
//    });
</script>
</body>
</html>