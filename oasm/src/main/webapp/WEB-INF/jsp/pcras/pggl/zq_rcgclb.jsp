<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>行为观察量表</title>

</head>
<body>
  <div class="return_btn" >
       <a href="#" onclick="loadnext3('/oasm/dafxView/zq_rcgc')">《 返回</a>	
    </div>
     <div class="rs_table">
        <div class="rs_table_title">
            <h1>行为观察量表</h1>
            <span class="zqxwgclbhide"></span>
         </div>
		<div class="msg_div">
		   <ul  class="xx_ul">
		   <li class="xx_li01">姓<span>名</span>：</li>
		   <li class="xx_li02">${zqzylb.xm }</li>
		   <li class="xx_li01">囚<span>号</span>：</li>
		   <li  id="zqrcgcqh" class="xx_number xx_li02" onclick="loadnext3('/oasm/dafxView/criminalinfo?qh=${zqzylb.qh }')">${zqzylb.qh }</li>
		   <li class="xx_li01">入监时间：</li>
		   <li class="xx_li02"><fmt:formatDate type="date" value="${zqzylb.sj}" /></li>
		   <li class="xx_li01">监<span>区</span>：</li>
		   <li class="xx_li02">${zqzylb.gyjq }</li>
		   <li class="xx_li01">分监区：</li>
		   <li class="xx_li02"></li>
		   <li class="xx_li01">专管警察：</li>
		   <li class="xx_li02">${zqlbjyxx.jhxm }</li>
		    <li id="hidden_zqgcjh" style="display:none;">${zqlbjyxx.jh}</li>
		   </ul>
		</div>

<div  style="float:left;width:70%" id="zq_select_yz_da">

<!-- 		<div class="header_table">
			<table >
				<tr>
					<th class="base_th" width="3%">序号</th>
					<th class="base_th" width="20.5%">维度</th>
					<th class="base_th" width="75.5%">因子</th>
					<th style="width: 1%; background: #FFF"></th>
				</tr>
			</table>
		</div>
			<div class="lb_content_table2">
							<table width="100%">
				<colgroup>
					<col width="3%">
					<col width="20.5%">
					<col width="75.5%">
				</colgroup>
    <tbody  id="zq_xwgc_datm" >
      
             中期行为观察因子
</tbody>
</table>
     </div>  -->
     			<div class="dim_candidate">
				<div id="dim_symbol">
					<!-- 拼接回来的因子和维度 -->
				</div>
			</div>
		</div> 
  </div> 
  <div  class="matching_table" style="overflow-x: auto; overflow-y: auto; height: 500px;">
     <!-- 此处显示中期观察的异常狱情 -->
  </div>    
			<div style="clear:both;text-align: center; padding-bottom:10px">
			      <button onclick="zqxwgc_da_save()" style="font-size: 20px;">保存</button>
				  <button style="font-size: 20px;">提交</button>
				  <button style="font-size: 20px;">下载</button>
				  <button style="font-size: 20px;">打印</button>
                  
                </div>
                
           <fieldset class="instruct">
	<legend>指导语</legend>
<p><strong><u>量表说明</u></strong></p>
<p>&nbsp;&nbsp;该行为观察量表仅适用于罪犯的入监评估，日常排查和中期评估等三个阶段，出监评估不可使用此量表做行为观察。</p>
<p><strong><u>注意事项</u></strong></p>
<p>&nbsp;&nbsp;请认真分析每一因子，应根据真实情况勾选。</p>

	</fieldset>
            </div>
<script >
setTimeout(function() {
	$('.sub_factor input').click(
			function(event) {
				var typ = $(this).attr("type");
				var nam = $(this).attr("name");

				if (typ == "radio") {

					$("input[name=" + nam + "]").siblings("label")
							.removeClass('factor_selected');
				}
				//$(this).parent().next().toggleClass( "factor_selected").siblings().removeClass('current');

				if ($(this).is(":checked")) {
					$(this).siblings("label").addClass(
							"factor_selected");
					//$("#"+$(this).attr('name')+"_symbol").addClass("has_done");
					//alert($(this).parents(".lb_options").find(":checked").length);
				} else {
					$(this).siblings("label").removeClass(
							"factor_selected");
				}
				$("#" + $(this).attr("name")).find(".sfn")
						.html(
								$(this).parents(".lb_options").find(
										":checked").length);
			});
	$(".dimension_li").click(
			function() {
				$(this).addClass("dimension_current").siblings()
						.removeClass("dimension_current");
				var now_index = $(this).index();
				$(".sub_factor").addClass("hide");
				$(".sub_factor").eq(now_index).removeClass("hide");
			});
}, 1200);
$(".matching_table").hide();
$("#zq_select_yz_da").css("width","100%");
</script>

</body>
</html>