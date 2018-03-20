<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>入监档案补充表</title>

</head>
<body>
  <div class="return_btn" >
       <a href="#" onclick="loadnext3('/oasm/dafxView/rj_dafx')">《 返回</a>	
    </div>
     <div class="rs_table">
        <div class="rs_table_title">
           <h1>入监档案补充表</h1>
        </div>
		<div class="msg_div">
		   <ul  class="xx_ul">
		   <li class="xx_li01">姓<span>名</span>：</li>
		   <li class="xx_li02">${zyryObjct.xm}</li>
		   <li class="xx_li01">囚<span>号</span>：</li>
		   <li  id="rjdafxqh"class="xx_number xx_li02" onclick="loadnext3('/oasm/dafxView/criminalinfo')">${zyryObjct.qh }</li>
		   <li class="xx_li01">入监时间：</li>
		   <li class="xx_li02"><fmt:formatDate type="date" value="${zyryObjct.sj}" /></li>
		   <li class="xx_li01">监<span>区</span>：</li>
		   <li class="xx_li02">${zyryObjct.gyjq }</li>
		   <li class="xx_li01">分监区：</li>
		   <li class="xx_li02">无数据</li>
		   <li class="xx_li01">专管警察：</li>
		   <li class="xx_li02">${jyxx.jhxm }</li>
		   <li id="hide_dafxjh" style="display:none;">${jyxx.jh}</li>
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
				<thead>
				 <colgroup>
					<col width="3%">
					<col width="40.5%">
					<col width="55.5%">
				  </colgroup>
				</thead>
				<tbody id="dafx_tableData">
				   <!-- 把因子和维度暂时存在json文件中 -->
				</tbody>

			</table>
		</div>
		<div style="text-align: center; padding-bottom: 10px">
			<button style="font-size: 20px;" onclick="da_wdyz_save()">保存</button>
			<button style="font-size: 20px;">提交</button>
			<button style="font-size: 20px;">下载</button>
			<button style="font-size: 20px;">打印</button>

		</div>
				<fieldset class="instruct">
			<legend>指导语</legend>
			<p>&nbsp;&nbsp;请根据罪犯真实情况勾选</p>

		</fieldset>
	</div>
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