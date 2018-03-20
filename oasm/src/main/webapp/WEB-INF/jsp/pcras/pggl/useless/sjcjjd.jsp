<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>评估数据采集阶段</title>
<!-- 分页样式 -->
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resource/css/page.css'/>">
<!-- 页面内容的js -->
<script type="text/javascript"
	src="<c:url value='/resource/js/pggl/pggl.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/resource/js/page.js'/>"></script>
<script type="text/javascript">
$(function () {
var btn1=document.getElementById('btn_rj');
var jd1=document.getElementById("rjjd1");
var jd11=document.getElementById('rjjd2');
btn1.onmouseover=function(){jd1.style.display="none";jd11.style.display="block";}
btn1.onmouseout=function(){jd11.style.display="none";jd1.style.display="block";}
var btn2=document.getElementById('btn_rc');
var jd2=document.getElementById("rcjd1");
var jd21=document.getElementById('rcjd2');
btn2.onmouseover=function(){jd2.style.display="none";jd21.style.display="block";}
btn2.onmouseout=function(){jd21.style.display="none";jd2.style.display="block";}
var btn3=document.getElementById('btn_zq');
var jd3=document.getElementById("zqjd1");
var jd31=document.getElementById('zqjd2');
btn3.onmouseover=function(){jd3.style.display="none";jd31.style.display="block";}
btn3.onmouseout=function(){jd31.style.display="none";jd3.style.display="block";}
var btn4=document.getElementById('btn_cj');
var jd4=document.getElementById("cjjd1");
var jd41=document.getElementById('cjjd2');
btn4.onmouseover=function(){jd4.style.display="none";jd41.style.display="block";}
btn4.onmouseout=function(){jd41.style.display="none";jd4.style.display="block";}
});
</script>
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
				<strong>&nbsp;&nbsp;评估管理 >>专项数据采集与排查>><font color="#ff3300">评估阶段选择</font></strong>
			</div>
		</div>
		<div style="margin:0 auto;width:50%;height:400px;text-align:center;">
			<div style="width:100%;height:50%;clear:both;">
				<div id="btn_rj"  class="btn_pgjd" style="float:left;width:50%;height:100%;border-right:1px solid #F00;border-bottom:1px solid #F00; border-radius: 8px 8px 0 0;">
				<div id="rjjd1" " style="width:100%;height:100%;font-size:150%;">
					<br><br><br>入监阶段
				</div>
				<div id="rjjd2" class="option_pgjd" style="display:none;width:100%;height:100%;">
					<ul>
					<li onclick="loadnext2('pggl/rj_dafx')">档案分析</li>
                    <li onclick="loadnext2('pggl/rj_jgft')">结构性访谈</li>
					<li onclick="loadnext2('pggl/rj_rcgc')">行为观察</li>
					<li onclick="loadnext2('pggl/rj_xszf')">新收押罪犯量表</li>
					<li onclick="loadnext2('pggl/rj_scl90')">症状自评量表(SCL-90)</li>
					<li onclick="loadnext2('pggl/rj_copa')">copa-pi</li>
					</ul>
				</div>
				</div>
				<div id="btn_rc" class="btn_pgjd" style="float:left;width:49%;height:100%;">
				<div id="rcjd1" " style="width:100%;height:100%;font-size:150%;">
					<br><br><br>日常阶段
				</div>
				<div id="rcjd2" class="option_pgjd" style="display:none;width:100%;height:100%;">
					<ul>
					<li onclick="loadnext2('pggl/rc_rcgc')">行为观察</li>
					</ul>
				</div>

                </div>
			</div>
			<div style="width:100%;height:50%;clear:both;">
				<div id="btn_zq" class="btn_pgjd" style="float:left;width:50%;height:100%;">
				<div id="zqjd1" " style="width:100%;height:100%;font-size:150%;">
					<br><br><br>中期阶段
				</div>
				<div id="zqjd2" class="option_pgjd" style="display:none;width:100%;height:100%;">
					<ul>
					<li onclick="loadnext2('pggl/zq_dafx')">档案分析</li>
                    <li onclick="loadnext2('pggl/zq_jgft')">结构性访谈</li>
					<li onclick="loadnext2('pggl/zq_rcgc')">行为观察</li>
					<li onclick="loadnext2('pggl/zq_scl90')">症状自评量表(SCL-90)</li>
					<li onclick="loadnext2('pggl/zq_copa')">copa-pi</li>
					</ul>
				</div>
				</div>
				<div id="btn_cj" class="btn_pgjd" style="float:left;width:49%;height:100%;border-left:1px solid #F00;border-top:1px solid #F00;">
				<div id="cjjd1" " style="width:100%;height:100%;font-size:150%;">
					<br><br><br>出监阶段
				</div>
				<div id="cjjd2" class="option_pgjd" style="display:none;width:100%;height:100%;">
					<ul>
					<li onclick="loadnext2('pggl/cj_dafx')">档案分析</li>
                    <li onclick="loadnext2('pggl/cj_jgft')">结构性访谈</li>
					<li onclick="loadnext2('pggl/cj_rcgc')">行为观察</li>
					<li onclick="loadnext2('pggl/cj_xszf')">新收押罪犯量表</li>
					<li onclick="loadnext2('pggl/cj_scl90')">症状自评量表(SCL-90)</li>
					<li onclick="loadnext2('pggl/cj_copa')">copa-pi</li>
					<li onclick="loadnext2('pggl/cj_shsy')">社会适应性量表</li>
					</ul>
				</div>
				</div>
			</div>
		</div>
	</div>
</body>

</html>
</html>