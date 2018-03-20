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
				<li class="current" id="home">主页</li>
				<li id="pggl">评估管理</li>
				<li id="xljz">心理测试</li>
				<li id="tjfx">统计分析</li>
				<li id="zxgl">专项管理</li>
				<!-- <li id="czgz">处置跟踪</li> -->
				<!-- <li id="pggj">评估工具分析</li> -->
				<li id="jygz">矫正项目</li>
				<li id="grmb" class="task">个人任务<!-- <div class="notice" id="main_grrw">6</div> --></li>

			</ul>
		</div>
<!-- 评估管理二级菜单 -->
			<div id="" class="sub_menu_line">
				<div id="pggl2" class="sub_menu_area ulm01 ">
					<ul class="sub_menu_ul">
						<li id="lr_da" class="sub_menu_li">基础信息评估</li>
						<li class="sub_menu_divider">|</li>					
						<li id="lr_rj" class="sub_menu_li">入监评估</li>
						<li class="sub_menu_divider">|</li>
						<li id="bg_rj" class="sub_menu_li">入监评估报告</li>
						<li class="sub_menu_divider">|</li>
						<li id="lr_rc" class="sub_menu_li">日常评估</li>
						<li class="sub_menu_divider">|</li>
						<li id="bg_rc" class="sub_menu_li">日常评估报告</li>
						<li class="sub_menu_divider">|</li>
						<li id="lr_zq" class="sub_menu_li">中期评估</li>
						<li class="sub_menu_divider">|</li>
						<li id="bg_zq" class="sub_menu_li">中期评估报告</li>
						<li class="sub_menu_divider">|</li>
						<li id="lr_cj" class="sub_menu_li">出监评估</li>
						<li class="sub_menu_divider">|</li>
						<li id="bg_cj" class="sub_menu_li">出监评估报告</li>
					</ul>
				<!-- 	<span class="import_btn" >PAD端数据导入</span> -->
				</div>
				<div id="tjfx2" class="sub_menu_area ulm02">
					<ul class="sub_menu_ul">
						<li id="wxqkbh" class="sub_menu_li">危评情况变化</li>
						<li class="sub_menu_divider">|</li>
						<li id="wxcdtj" class="sub_menu_li">危险等级统计</li>
						<li class="sub_menu_divider">|</li>
<!-- 						<li id="wxlbtj" class="sub_menu_li">危险类别统计</li> -->
<!-- 						<li class="sub_menu_divider">|</li> -->
						<li id="zxttj" class="sub_menu_li">罪犯自杀、行凶、脱逃倾向统计</li>
						<li class="sub_menu_divider">|</li>
						<li id="cjzftj" class="sub_menu_li">罪犯出监再犯罪倾向统计</li>
						<li class="sub_menu_divider">|</li>
						<li id="czqktj" class="sub_menu_li">处置情况统计</li>
						<li class="sub_menu_divider">|</li>
						<li id="pgqktj" class="sub_menu_li">评估情况统计</li>
						<li class="sub_menu_divider">|</li>
						<li id="glzftj" class="sub_menu_li">各类罪犯统计</li>
						<li class="sub_menu_divider">|</li>
						<li id="yjtj" class="sub_menu_li">预警统计</li>
						<li class="sub_menu_divider">|</li>
						<li id="wxyzfx" class="sub_menu_li">极高危险罪犯因子分析</li>

					</ul>
				</div>
				<div id="zxgl2" class="sub_menu_area ulm03">
					<ul class="sub_menu_ul">
						<li id="jgfgl" class="sub_menu_li">极高危罪犯管理</li>
						<li class="sub_menu_divider">|</li>
						<li id="gwfgl" class="sub_menu_li">高危罪犯管理</li>
						<li class="sub_menu_divider">|</li>
						<li id="zdfgl" class="sub_menu_li">重点罪犯管理</li>
						<li class="sub_menu_divider">|</li>
						<li id="tsfgl" class="sub_menu_li">特殊罪犯管理</li>
						<li class="sub_menu_divider">|</li>
						<li id="wwfgl" class="sub_menu_li">顽危犯管理</li>
					</ul>
				</div>
				<div id="jygz2" class="sub_menu_area ulm04">
					<ul class="sub_menu_ul">
						<li id="zfxx" class="sub_menu_li">罪犯信息查询</li>
						<li class="sub_menu_divider">|</li>
						<li id="" class="sub_menu_li">团体矫正</li>
						<li class="sub_menu_divider">|</li>
						<li id="" class="sub_menu_li">个别矫正</li>
						<li class="sub_menu_divider">|</li>
						<li id="gzfagz" class="sub_menu_li">矫正项目实施情况</li>
						<li class="sub_menu_divider">|</li>
						<li id="" class="sub_menu_li">典型案例</li>
					</ul>
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

</script>
</body>
<script type="text/javascript"
	src="<c:url value='/resource/js/common.js'/>"></script>
</html>