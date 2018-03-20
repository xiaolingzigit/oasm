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
				<strong>&nbsp;&nbsp;评估管理 >><font color="#ff3300">基础信息评估</font></strong>
			</div>
		</div>
		<!-- 功能子块-->
		<div class="main_content">
			<!--选项卡 -->
			<div id="option" class="option_area">
				<ul>
					<li id="rj_dafx" name="rj_dafx" class="option_li_current">基础信息评估</li>
					<li id="rj_dadr" name="rj_dadr" onclick="ShowDiv('MyDiv','fade')">基础信息导入</li>
				</ul>
			</div>
			<!--可选内容 -->
			<div id="basecontent" class="main_content_base">
			
			</div>
		</div>
	</div>
<div id="fade" class="popup_mask">  
</div>  
 <div id="MyDiv" class="popup_content">    
			<div class="title_bar">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;添加待基础信息导入罪犯   <span class="close" onclick="CloseDiv('MyDiv','fade')">关闭</span>  
  </div>
  <div class="add_criminfo" >
			<table >
			<colgroup>
			<col width="31%">
			<col width="31%">
			<col width="31%">
			<col width="7%">
			</colgroup>
				<tr>
                  <th>囚号</th>
                  <th>罪犯姓名</th>
                  <th>专管警察警号</th>
                  <th></th>
				</tr>
				<tbody id="criminfo_tb">
				<tr>
				<td><input type="text" class="criminal_no" /></td>
				<td><input type="text" class="criminal_name" /></td>
				<td><input type="text" class="police_no" /></td>
				<td class='remove_tr cancel'><a  title='移除'></a></td>
				</tr>
				<tr>
				<td><input type="text" class="criminal_no" /></td>
				<td><input type="text" class="criminal_name" /></td>
				<td><input type="text" class="police_no" /></td>
				<td class='remove_tr cancel'><a  title='移除'></a></td>
				</tr>
				<tr>
				<td><input type="text" class="criminal_no" /></td>
				<td><input type="text" class="criminal_name" /></td>
				<td><input type="text" class="police_no" /></td>
				<td class='remove_tr cancel'><a  title='移除'></a></td>
				</tr>
				</tbody>
				</table>
				<button id="add_row">添加行</button>
				</div>
				<div style="text-align:center"><button id='import_criminfo' class="button_submit">基础信息导入及评估</button></div>
			</div> 

<!-- 页面内容的js -->
<script type="text/javascript"
	src="<c:url value='/resource/js/pggl/pggl.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/resource/js/page.js'/>"></script>
	
	<script type="text/javascript">
	$(function() {
		$('#basecontent').load("/oasm/dafxView/rj_dafx");		
	});
	$('#option li').click(function (event) {
		$(this).addClass('option_li_current').siblings().removeClass('option_li_current');
		switch ($(this).attr("id")) {

			case 'rj_dafx': //入监档案分析
				$("#basecontent").load("/oasm/dafxView/rj_dafx");
				break;
/* 			case "rj_dadr"://档案导入
				$("#basecontent").load("/oasm/dafxView/rj_dadr");
				break; */

		}
	});
</script>
<script type="text/javascript">  
//弹出隐藏层  
function ShowDiv(show_div,bg_div){  
 document.getElementById(show_div).style.display='block';  
 document.getElementById(bg_div).style.display='block' ;  
 var bgdiv = document.getElementById(bg_div);  
 bgdiv.style.width = document.body.scrollWidth;   
 // bgdiv.style.height = $(document).height();  
 $("#"+bg_div).height($(document).height());  
};  
//关闭弹出层  
function CloseDiv(show_div,bg_div)  
{  
 document.getElementById(show_div).style.display='none';  
 document.getElementById(bg_div).style.display='none';  
 $("#rj_dafx").addClass('option_li_current').siblings().removeClass('option_li_current');
 $("#basecontent").load("/oasm/dafxView/rj_dafx");
}; 

</script> 
<script>
//增加行
	 var tr="";
	tr+="<tr>";
	tr+="<td><input type='text' class='criminal_no' /></td>";
	tr+="<td><input type='text' class='criminal_name' /></td>";
    tr+="<td><input type='text' class='police_no' /></td>";
	tr+="<td class='remove_tr cancel'><a  title='移除'></a></td>";
	tr+="</tr>";
$("#add_row").click(function(event){

	$("#criminfo_tb").append(tr);
	$(".remove_tr").click(function(event){
		$(this).parents("tr").remove();
	});
});
//移除行
$(".remove_tr").click(function(event){
	$(this).parents("tr").remove();
});
//档案导入
$("#import_criminfo").click(function(event){
	var add_qh="";
	var add_qm="";
	var add_jh="";
	var add_value="";
	$("#criminfo_tb tr").each(function(){
		 add_qh=$(this).find("input").eq(0).val();
		 add_qm=$(this).find("input").eq(1).val();
		 add_jh=$(this).find("input").eq(2).val();
		 add_value+=add_qh+","+add_qm+","+add_jh+";";
	});
	alert(add_value);
	$("#criminfo_tb").html(tr);
	$("#criminfo_tb").append(tr);
	$("#criminfo_tb").append(tr);
	
});
</script>	
</body>
</html>