<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<%@taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>出监档案补充表</title>

</head>
<body>
  <div class="return_btn" >
       <a href="#" onclick="loadnext3('/oasm/dafxView/cj_dafx')">《 返回</a>	
    </div>
     <div class="rs_table">
     <div id="printpage">
        <div class="rs_table_title">
           <h1>出监档案补充表</h1>
        </div>
		<div class="msg_div">
		   <ul  class="xx_ul">
		   <li class="xx_li01">姓<span>名</span>：</li>
		   <li class="xx_li02">刘安</li>
		   <li class="xx_li01">囚<span>号</span>：</li>
		   <li  id="cjdafxqh"class="xx_number xx_li02" onclick="loadnext3('/oasm/dafxView/criminalinfo')">4465382476</li>
		   <li class="xx_li01">入监时间：</li>
		   <li class="xx_li02">2011-09-07</li>
		   <li class="xx_li01">监<span>区</span>：</li>
		   <li class="xx_li02">七监区</li>
		   <li class="xx_li01">分监区：</li>
		   <li class="xx_li02"></li>
		   <li class="xx_li01">专管警察：</li>
		   <li class="xx_li02">文金郸
		      <strong id="hidecjdadjjc"><shiro:principal/></strong>
		   </li>
		   </ul>
		</div>
		<div class="header_table">
			<table >
				<tr>
					<th class="base_th" width="3%">序号</th>
					<th class="base_th" width="40.5%">档案信息项</th>
					<th class="base_th" width="55.5%">对应实际情况</th>
					<th style="width: 1%; background: #FFF"></th>
				</tr>
			</table>
		</div>
		<div class="lb_content_table2">
			<table width="100%">
				<colgroup>
					<col width="3%">
					<col width="40.5%">
					<col width="55.5%">
				</colgroup>
				<tr>
					<td>1</td>
					<td>犯罪种类</td>
					<td class="lb_td04"><ul class="yz_li">
	<li><input id="yz1"	 value="yz1" type="radio" 	name="wd1" />	<label for="yz1">	淫欲型犯罪	</label></li>
<li><input id="yz2"	 value="yz2" type="radio"	name="wd1" />	<label for="yz2">	经济财产型犯罪	</label></li>
<li><input id="yz3"	 value="yz3" type="radio"	name="wd1" />	<label for="yz3">	暴力型犯罪	</label></li>
<li><input id="yz4"	 value="yz4" type="radio"	name="wd1" />	<label for="yz4">	毒品型（无吸毒史）犯罪	</label></li>
<li><input id="yz5"	 value="yz5" type="radio"	name="wd1" />	<label for="yz5">	有组织犯罪涉黑	</label></li>
<li><input id="yz6"	 value="yz6" type="radio"	name="wd1" />	<label for="yz6">	有组织犯罪涉恐	</label></li>
<li><input id="yz7"	 value="yz7" type="radio"	name="wd1" />	<label for="yz7">	邪教犯罪	</label></li>
<li><input id="yz8"	 value="yz8" type="radio"	name="wd2" />	<label for="yz8">	危安型犯罪	</label></li>
<li><input id="yz9"	 value="yz9" type="radio"	name="wd2" />	<label for="yz9">	诈骗型犯罪	</label></li>
<li><input id="yz10"	 value="yz10" type="radio"	name="wd2" />	<label for="yz10">	毒品型（有吸毒史）犯罪	</label></li>
<li><input id="yz11"	 value="yz11" type="radio"	name="wd2" />	<label for="yz11">	 非职务犯罪及以上各类犯罪	</label></li>
	
						</ul></td>
				</tr>
				<tr>
					<td>2</td>
					<td>出监前身体精神情况</td>
					<td class="lb_td04"><ul class="yz_li">
							<li><input id="yz26"	 value="yz26" type="radio"	name="wd8" />	<label for="yz26">	患有一般疾病	</label></li>
<li><input id="yz27"	 value="yz27" type="radio"	name="wd8" />	<label for="yz27">	患有长期慢性疾病	</label></li>
<li><input id="yz28"	 value="yz28" type="radio"	name="wd8" />	<label for="yz28">	患有严重疾病	</label></li>
<li><input id="yz29"	 value="yz29" type="radio"	name="wd8" />	<label for="yz29">	患有身体残疾	</label></li>
<li><input id="yz30"	 value="yz30" type="radio"	name="wd8" />	<label for="yz30">	患有精神疾病的	</label></li>
							
						</ul></td>
				</tr>

			</table>
		</div>
		</div>
		<div style="text-align: center; padding-bottom: 10px">
			<button style="font-size: 20px;">保存</button>
			<button style="font-size: 20px;">提交</button>
			<button style="font-size: 20px;">下载</button>
			<button style="font-size: 20px;" onClick="printdiv('printcontent')">打印</button>

		</div>
				<fieldset class="instruct">
			<legend>指导语</legend>
			<p>&nbsp;&nbsp;请根据罪犯真实情况勾选</p>

		</fieldset>
	</div>
<script type="text/javascript" src="<c:url value='/resource/js/printpage.js'/>"></script>
<script>
	setTimeout(function() {
		$('.lb_td04 input').click(
				function(event) {
					var typ = $(this).attr("type");
					var nam = $(this).attr("name");

					if (typ == "radio") {

						$("input[name=" + nam + "]").next()
								.removeClass('factor_selected');
					}
					//$(this).parent().next().toggleClass( "factor_selected").siblings().removeClass('current');

					$(this).next().toggleClass("factor_selected");

				});
	}, 1200);
</script>
</body>
</html>