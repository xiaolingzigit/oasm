<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>个人任务</title>

</head>
<body>
  <div id="" class="sub-block">
		<!-- 定位栏-->
		<div class="location">
			<div class="location_left">
				<i><font color="#ffffff"><strong>您现在的位置</strong></font></i>
			</div>
			<div class="location_right">
				<strong>&nbsp;&nbsp;个人任务 >><font color="#ff3300">个人工作任务</font></strong>
			</div>
		</div>
		<div class="main_content">
			<div id="option" class="option_area">
				<ul>
				    <li id="gr_dbrw" name="gr_dbrw" class="option_li_current task">待办任务 <div class="notice2" id="gr_dbrw_sz"></div></li>
					<li id="gr_sdfb" name="gr_sdfb">发布任务</li>
					<li id="gr_wjsp" name="gr_wjsp" class="task">文件审核<div class="notice2" id="gr_wjsp_sz">3</div></li>
					<li id="gr_wjbp" name="gr_wjbp">文件报批</li>
				<!-- 	<li id="dafxgz" name="dafxgz">档案分析工作</li> -->
				</ul>
			</div>
			<div id="basecontent" class="main_content_base">
			</div>
		</div>
	</div>
	<script type="text/javascript" src="<c:url value='/resource/js/grgzmb/grgzmb.js'/>"></script>
<script type="text/javascript">
	$(function() {
		$('#basecontent').load("/oasm/gzrwglView/gr_dbrw");		
	});
	$('#option li').click(function (event) {
		$(this).addClass('option_li_current').siblings().removeClass('option_li_current');
		switch ($(this).attr("id")) {

			case 'gr_dbrw': //个人待办任务
				$("#basecontent").load("/oasm/gzrwglView/gr_dbrw");
				break;
			case "gr_sdfb"://个人手动发布任务
				$("#basecontent").load("/oasm/gzrwglView/gr_sdfb");
				break;
			case "gr_wjsp"://个人文件审核
				$("#basecontent").load("/oasm/gzrwglView/gr_wjsp");
				break;
			case "gr_wjbp"://个人文件报批
				$("#basecontent").load("/oasm/gzrwglView/gr_wjbp");
				break;
			case "dafxgz"://档案分析工作
				$("#basecontent").load("/oasm/gzrwglView/dafxgz");
				break;
		}
	});
</script>
</body>
</html>
