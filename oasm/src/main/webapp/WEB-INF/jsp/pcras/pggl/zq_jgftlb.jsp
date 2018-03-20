<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<%@taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>结构性访谈量表</title>

</head>
<body>
  <div class="return_btn" >
       <a href="#" onclick="loadnext3('/oasm/dafxView/zq_jgft')">《 返回</a>	
    </div>
	<div class="rs_table">
		<div class="rs_table_title">
			<h1>结构性访谈量表</h1>
			<span class="zqjgftlbhide"></span>
		</div>
		<div class="msg_div">
		   <ul  class="xx_ul">
		   <li class="xx_li01">姓<span>名</span>：</li>
		   <li class="xx_li02">${zqzyftlb.xm }</li>
		   <li class="xx_li01">囚<span>号</span>：</li>
		   <li  id="zqjgftqh"class="xx_number xx_li02" onclick="loadnext3('/oasm/dafxView/criminalinfo?qh=${zqzyftlb.qh }')">${zqzyftlb.qh }</li>
		   <li class="xx_li01">入监时间：</li>
		   <li class="xx_li02"><fmt:formatDate type="date" value="${zqzyftlb.sj}" /></li>
		   <li class="xx_li01">监<span>区</span>：</li>
		   <li class="xx_li02">${zqzyftlb.gyjq }</li>
		   <li class="xx_li01">分监区：</li>
		   <li class="xx_li02"></li>
		   <li class="xx_li01">专管警察：</li>
		   <li class="xx_li02">${zqftlbjyxx.jhxm }</li>
		   <li id="hidezqjgft_jh" style="display:none;">${zqftlbjyxx.jh}</li>
		   </ul>
		</div>
		<div class="lb_content_table2">
		<div style="width:80%;float:left">
		<div id="question_area">

</div>
<div class="lastanext"><button id="last" >上一题</button><button id="next" >下一题</button></div>
</div>
<div style="width:20%;float:left">
<div class="answer_progress">
  <ul  id="question_symbol">
</ul>
</div>
</div>
</div>
		<div class="end_of_paper">
			<button onclick="zqjgft_da_save()">保存</button>
			<button>提交</button>
			<button>下载</button>
			<button>打印</button>

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
<script>
	setTimeout(function() {
		$('.lb_options input').click(
				function(event) {
					var typ = $(this).attr("type");
					var nam = $(this).attr("name");

					if (typ == "radio") {

						$("input[name=" + nam + "]").siblings("label")
								.removeClass('factor_selected');
					}
					//$(this).parent().next().toggleClass( "factor_selected").siblings().removeClass('current');

					if($(this).is(":checked")){
						$(this).siblings("label").addClass("factor_selected");					
					$("#"+$(this).attr('name')+"_symbol").addClass("has_done");
}else{
	$(this).siblings("label").removeClass("factor_selected");					
    $(this).parents("ul").find("input").each(function(){
    	if($(this).is(":checked")){
        	$("#"+$(this).attr('name')+"_symbol").addClass("has_done");
    		return false;
    	}else{
    	$("#"+$(this).attr('name')+"_symbol").removeClass("has_done");
    	}

});
	}
});
		  $(".symbol_li_l").click(function(){
			  var now_index=$(this).index();
			  $(".sub_q").addClass("hide");
			  $(".sub_q").eq(now_index).removeClass("hide");
			  
		  });
	}, 1200);
</script>
<script type="text/javascript">	
$("#next").click(function(){
	var len=$(".sub_q").length;
	$(".sub_q").each(function(){
	if($(this).css("display")!="none")
	        if($(this).index()==(len-1)){
	          alert("this is the last one");
	          return false;
	}else{
	     $(this).addClass("hide");
	  $(this).next().removeClass("hide");
	return false;

	}
	});
	  });
	  $("#last").click(function(){
	var len=$(".sub_q").length;
	$(".sub_q").each(function(){
	if($(this).css("display")!="none")
	        if($(this).index()==0){
	          alert("this is the first one");
	          return false;
	}else{
	     $(this).addClass("hide");
	  $(this).prev().removeClass("hide");
	return false;

	}
	});
	  });

</script>
</body>
</html>