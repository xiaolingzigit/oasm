<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>危险类别统计</title>
</head>
<body>
	<div id="" class="sub-block">
		<!-- 定位栏-->
		<div class="location">
			<div class="location_left">
				<i><font color="#ffffff"><strong>您现在的位置</strong></font></i>
			</div>
			<div class="location_right">
				<strong>&nbsp;&nbsp;统计分析 >><font color="#ff3300">危险类别统计</font></strong>
			</div>
		</div>
		<div class="main_content">
		<div class="search_title">统计条件：</div>
			<div class="layer02" style="display: none">
				<div class="statistical_search_option">
					<ul>
						<li class="statisticaltype_now">时段</li>
						<li>国籍/籍贯</li>
						<li>特定人群</li>
					</ul>
				</div>
				<div class="statistical_search_area">
					<div class="sub_search_area">
								<table class="tjsetting_tb">
								<colgroup>
									<col width="10%">
									<col width="70%">
									<col width="20%">
								</colgroup>
									<tr>
										<th>评估时间段</th>
										<td><input type="text"
											class="select_time search_tb_input" id="StartTime"
											maxLength="10" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"
											class="search_tb_input" /> 至 <input type="text"
											class="select_time search_tb_input" id="EndTime"
											maxLength="10" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" /></td>
										<td><div class="search_sub3">
												<button class="button_submit2" id='date_statistical_generate'>&nbsp;生&nbsp;&nbsp;成&nbsp;</button>
											</div></td>
									</tr>
								</table>
						</div>
					<!-- 国籍/籍贯 -->
					<div class="sub_search_area">
					<table class="tjsetting_tb">
								<colgroup>
									<col width="10%">
									<col width="70%">
									<col width="20%">
								</colgroup>
					<tr><th>国籍：</th><td>
					<ul id="JG" class="tjsetting_category">
										<li><input type="radio" name="country" value="global"
											id="global" checked="checked" /><label for="global">全部
										</label></li>
										<li><input type="radio" name="country" value="China"
											id="China" /><label for="China">国内 </label></li>
										<li><input type="radio" name="country" value="foreign"
											id="foreign"><label for="foreign">外籍 </label></li>
										<li><input type="radio" name="country" value="998"
											id="998"><label for="998">无国籍</label></li>
										<li><input type="radio" name="country" value="999"
											id="999"><label for="999">国籍不明</label></li>
									</ul>
								</td>
							<td><div class="search_sub3">
												<button class="button_submit2" id='date_statistical_generate'>&nbsp;生&nbsp;&nbsp;成&nbsp;</button>
						</div></td>
							</tr>
						<tr id="JG_sub"></tr>
						</table>
					</div>
					<!-- 特定人群 -->
					<div class="sub_search_area">
							<table class="tjsetting_tb">
								<colgroup>
									<col width="10%">
									<col width="70%">
									<col width="20%">
								</colgroup>
								<tr>
									<th><span>筛选条件：</span></th>
									<td><ul id="info_source" class="tjsetting_category"> <li><input type="radio"
											name="info_source" value="source1" id="source1"> <label
											for="source1"> 共同犯罪参与类型 </label></li> <li><input type="radio"
											name="info_source" value="ZGJC" id="ZGJC"> <label
											for="ZGJC"> 专管警察 </label></li> <li><input type="radio"
											name="info_source" value="CSRQ" id="CSRQ"> <label
											for="CSRQ"> 年龄 </label></li> <li><input type="radio"
											name="info_source" value="source3" id="source3"> <label
											for="source3"> 罪名 </label></li> <li><input type="radio"
											name="info_source" value="source4" id="source4"> <label
											for="source4"> 证件 </label></li> <li><input type="radio"
											name="info_source" value="FYLX" id="FYLX"> <label
											for="FYLX"> 分押类型 </label></li> <li><input type="radio"
											name="info_source" value="MZ" id="MZ"> <label
											for="MZ"> 民族 </label></li> <li><input type="radio" name="info_source"
											value="source8" id="source8"><label for="source8">
												犯罪事实 </label></li> <li><input type="radio" name="info_source" value="BQWHCD"
											id="BQWHCD"><label for="BQWHCD"> 捕前文化程度 </label></li> <li><input
											type="radio" name="info_source" value="XFCS" id="XFCS"><label
											for="XFCS"> 既往刑罚次数 </label></li> <li><input type="radio"
											name="info_source" value="source11" id="source11"><label
											for="source11"> 特别关注 </label></li>
									</ul></td>
									<td>
										<div class="search_sub3">
											<button class="button_submit2" id='date_statistical_generate'>&nbsp;生&nbsp;&nbsp;成&nbsp;</button>
										</div>
									</td>
								</tr>
							
						<tr><td>	<!-- 							<div>
							<span>匹配数据类型：</span>
							<span><input type="radio"
							name="data_type" id="number" /><label for="number">数值</label><input type="radio"
							name="data_type" id="char" /><label for="char">字符</label><input type="radio"
							name="data_type" id="date" /><label for="date">日期</label> 
							</span>
							</div> --></td></tr>
							<tr id="source_sub"></tr>
					</table>		
					</div>
				</div>
			</div>	
			<!-- table -->
			<div id="bar" style="width: 100%; height: 300px; padding-top: 10px"></div>
			<div class="base_table">
			<h4>危险类别统计表</h4>
				<!--<span class="base_liebiao" ></span>-->
				<table width="100%">
					<tr>
						<th class="base_th" width="5%">监区</th>
						<th class="base_th" width="4%">总人数</th>
						<th class="base_th" width="9%">高自杀比例</th>
						<th class="base_th" width="9%">高自杀人数</th>
						<th class="base_th" width="8%">高行凶比例</th>
						<th class="base_th" width="8%">高行凶人数</th>
						<th class="base_th" width="8%">高脱逃比例</th>
						<th class="base_th" width="8%">高脱逃人数</th>
						<th class="base_th" width="8%">高再犯罪比例</th>
						<th class="base_th" width="8%">高再犯罪人数</th>
						<!--<th class="base_th" width="10%">报告分析</th>-->
					</tr>
					<!-- wxlbtj.js插入数据 -->
					<tbody id="tjwxlx"></tbody>
				</table>
			</div>
		</div>
	</div>

<script type="text/javascript" src="<c:url value="/resource/js/tjfx/wxlbtj.js"/>"></script>
	<script type="text/javascript"
		src="<c:url value="/resource/js/tjfx/tjsetting.js"/>"></script>
</body>
</html>