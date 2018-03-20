<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>入监危险性评估报告</title>

</head>

<body>
<!-- 功能子块-->
	<div class="base_right_bom" >
	<div id="printcontent">
		<div class="bg_title">矫正项目实施方案与跟踪</div>
		<div class="bg_item">
		<div class="bg_item_title">罪犯基础信息</div>
		<div class="bg_sub_line"></div>		
		<ul class="bg_ul">
		<li class="bg_li bg_li_w1"><span class="bg_item1">监狱</span><span class="bg_item2" id="">惠州监狱</span></li>
		<li class="bg_li bg_li_w1"><span class="bg_item1">监区</span><span class="bg_item2" id="rjpgjq">三监区</span></li>
		<li class="bg_li bg_li_w1"><span class="bg_item1">囚号</span><span class="bg_item2" id="rjpgqh" >4413031123</span></li>
		<li class="bg_li bg_li_w1"><span class="bg_item1">姓名</span><span class="bg_item2" id="rjpgxm">吴伦珍</span></li>
		<li class="bg_li bg_li_w1"><span class="bg_item1">性别</span><span class="bg_item2" id="">男</span></li>
		<li class="bg_li bg_li_w1"><span class="bg_item1">别名</span><span class="bg_item2" id="">无</span></li>
		<li class="bg_li bg_li_w1"><span class="bg_item1">出生日期</span><span class="bg_item2" id="">1977/8/7</span></li>
		<li class="bg_li bg_li_w1"><span class="bg_item1">年龄</span><span class="bg_item2" id=""></span>40</li>
		<li class="bg_li bg_li_w1"><span class="bg_item1">国籍</span><span class="bg_item2" id="">广东省惠州市</span></li>
		<li class="bg_li bg_li_w1"><span class="bg_item1">民族</span><span class="bg_item2" id="">汉族</span></li>
		<li class="bg_li bg_li_w1"><span class="bg_item1">文化程度</span><span class="bg_item2" id="">高中</span></li>
		<li class="bg_li bg_li_w1"><span class="bg_item1">政治面貌</span><span class="bg_item2" id="">群众</span></li>
		</ul>
		</div>
		<div class="bg_item">
			<div class="bg_item_title">改造教育建议</div>
			<div class="bg_sub_line"></div>
				<div class="bg_li_w3">
					     <p>1.加强交流与沟通，平时要注意观察和了解，，一旦遭受刺激或挫折，要及时对其进行心理疏导和渲泄，鼓励多参加集体社交活动。</p>
     <p>2.注意正确利用聪明、善于应变的特点。</p>
     <p>3.一旦发生事件，后果可能会很严重。注意培养同情心和和爱心，增强责任感。</p>
     <p>4.有可能是非正规团体的首领首领或意外事件的实施者，注意预防监控。比较固执己见，改造难度较大。</p>
     <p>5.注意正确利用沉着、平稳的特点。</p>
     <p>6.注意正确利用理智、细致的优点。</p>
     <p>7.注意正确利用坦诚幼稚、城府不深、坦诚幼稚的特点。</p>
					</div>
		</div>
		<div class="bg_item" id="gzsq">
			<div class="bg_item_title">矫治实施情况</div>
			<div class="bg_sub_line"></div>
				<textarea id="gzqk" class="gzqk_textarea" readonly="readonly">罪犯日常情绪受外界环境的影响不明显，反应比较轻微，且较容易恢复平静。性情倾向于平稳和成熟些，面对生活中的各种困难和挫折，处理能力相对比较好。日常改造表现基本稳定、有较多积极行为，危险等级为中度危险。</textarea>
				<button  id="modify_gzqk" class="ms_btn" >编辑</button><button id="save_gzqk" style="display:none"  class="ms_btn">保存</button>
		</div>
</div>
		<div style="text-align: center; padding-bottom: 10px">
			<button style="font-size: 20px;" id="download">下载</button>
			<button style="font-size: 20px;" onClick="printdiv('printcontent')">打印</button>
		</div>
	</div>
<script type="text/javascript" src="<c:url value='/resource/js/printpage.js'/>"></script>
<script type="text/javascript">
$(function(){
	$("#modify_gzqk").click(function(){
		$("#gzqk").removeAttr("readonly");
		$("#save_gzqk").css("display","block");
		 $("#modify_gzqk").css("display","none");
	});
	$("#save_gzqk").click(function(){
		$("#gzqk").attr("readonly","readonly");
		$("#save_gzqk").css("display","none");
		 $("#modify_gzqk").css("display","block");
	});
	
});
	</script>
	
</body>

</html>