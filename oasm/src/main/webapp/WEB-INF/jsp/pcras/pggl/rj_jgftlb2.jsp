<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<%@taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>结构性访谈列表</title>

</head>
<body>
	<div class="return_btn">
	  <a href="#" onclick="loadnext3('/oasm/dafxView/rj_jgft')">《 返回</a>	
	</div>
	<div class="rs_table">
		<div class="rs_table_title">
			<h1>结构性访谈量表</h1>
			<span class="hiderjjgftlb" style="display: none;"></span>
		</div>
		<div class="msg_div">
		   <ul  class="xx_ul">
		   <li class="xx_li01">姓<span>名</span>：</li>
		   <li class="xx_li02">${zyryObjct.xm }</li>
		   <li class="xx_li01">囚<span>号</span>：</li>
		   <li id="xx_number" class="xx_number xx_li02" onclick="loadnext3('/oasm/dafxView/criminalinfo')">${zyryObjct.qh }</li>
		   <li class="xx_li01">入监时间：</li>
		   <li class="xx_li02"><fmt:formatDate type="date" value="${zyryObjct.sj}" /></li>
		   <li class="xx_li01">监<span>区</span>：</li>
		   <li class="xx_li02">${zyryObjct.gyjq }</li>
		   <li class="xx_li01">分监区：</li>
		   <li class="xx_li02"></li>
		   <li class="xx_li01">专管警察：</li>
		   <li class="xx_li02">${jyxx.jhxm}<strong id="hidezgjc" style="display: none;"><shiro:principal/></strong></li>
		   </ul>
		</div>

		<div class="header_table">
			<table rules=none>
				<tr>
				    <th style="width:1%;background:#FFF"></th>
					<th class="base_th" width="10%">选择</th>
					<th class="base_th" width="37.6%">因子</th>
					<th style="width:1%;background:#FFF"></th>
					<th class="base_th" width="10%">选择</th>
					<th class="base_th" width="37.6%">因子</th>
					<th style="width:1.9%;background:#FFF"></th>

				</tr>
			</table>
		</div>
		<div id="rjjgft_dtqk_yz" class="lb_content_table" >
          <ul>
              <!-- 罗列因子 -->
		  </ul>
		</div>
		<div style="text-align: center; padding-bottom: 10px">
			<button onclick="rj_jgftda_save()" style="font-size: 20px;">保存</button>
			<button style="font-size: 20px;">提交</button>
			<button style="font-size: 20px;">下载</button>
			<button style="font-size: 20px;">打印</button>

		</div>
				<fieldset class="instruct">
			<legend>指导语</legend>
			<p>
				<strong><u>量表说明</u></strong>
			</p>
			<p>&nbsp;&nbsp;该结构性访谈量表仅适用于罪犯的入监评估，日常排查和中期评估等三个阶段，出监评估不可使用此量表做结构性访谈。</p>
			<p>
				<strong><u>注意事项</u></strong>
			</p>
			<p>&nbsp;&nbsp;请认真分析每一因子，应根据真实情况勾选</p>

		</fieldset>
	</div>
<script >
setTimeout(function(){$('.lb_checkbox1 input').click(function (event) {
	var typ=$(this).attr("type");
	var nam=$(this).attr("name");

	if(typ=="radio"){

	$("input[name="+ nam +"]").parent().next().removeClass('factor_selected');
	}
	//$(this).parent().next().toggleClass( "factor_selected").siblings().removeClass('current');

	$(this).parent().next().toggleClass( "factor_selected");

});},1200);
</script>
</body>
</html>