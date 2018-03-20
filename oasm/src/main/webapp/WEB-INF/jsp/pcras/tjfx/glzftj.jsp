<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>各类罪犯统计</title>

</head>
<body>
   <!--各类罪犯统计 -->
	<div id="" class="sub-block">
		<!-- 定位栏-->
		<div class="location">
			<div class="location_left">
				<i><font color="#ffffff"><strong>您现在的位置</strong></font></i>
			</div>
			<div class="location_right">
				<strong>&nbsp;&nbsp;统计分析 >><font color="#ff3300">各类犯罪统计</font></strong>
			</div>
		</div>
		<!-- 功能子块-->
		<div class="main_content">
			<!--选项卡 -->
			<div id="option" class="option_area">
				<ul>
					<li id="tj_glzf" name="tj_glzf" class="option_li_current">各类罪犯</li>
					<li id="tj_zdf" name="tj_zdftj">重点犯</li>
					<li id="tj_wwf" name="tj_wwf">顽危犯</li>
					<li id="tj_waf" name="tj_waf">危安犯</li>
					<li id="tj_jsbf" name="tj_jsbf">精神病犯</li>
					<li id="tj_wjf" name="tj_wjf">外籍犯</li>

				</ul>
			</div>
			<!--可选内容 -->
			<div id="basecontent" class="main_content_base">

			</div>
		</div>
	</div>
<script type="text/javascript">
	$(function() {
		$('#basecontent').load("/oasm/tjfxView/tj_glzf");		
	});
	$('#option li').click(function (event) {
		$(this).addClass('option_li_current').siblings().removeClass('option_li_current');
		switch ($(this).attr("id")) {

			case 'tj_glzf': //各类罪犯
				$("#basecontent").load("/oasm/tjfxView/tj_glzf");
				break;
			case "tj_zdf"://重点犯
				$("#basecontent").load("/oasm/tjfxView/tj_zdf");
				break;
			case "tj_wwf"://顽危犯
				$("#basecontent").load("/oasm/tjfxView/tj_wwf");
				break;
			case "tj_waf"://危安犯
				$("#basecontent").load("/oasm/tjfxView/tj_waf");
				break;
			case "tj_jsbf"://精神病犯
				$("#basecontent").load("/oasm/tjfxView/tj_jsbf");
				break;
			case "tj_wjf"://外籍犯
				$("#basecontent").load("/oasm/tjfxView/tj_wjf");
				break;
		}
	});
</script>
					
</body>

</html>