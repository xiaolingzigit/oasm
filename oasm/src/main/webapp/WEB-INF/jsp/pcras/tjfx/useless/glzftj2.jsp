<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>各类罪犯统计</title>
<script>
		var li = document.getElementsByClassName('option_area')[0]
				.getElementsByTagName('li');
		var div = document.getElementsByClassName('option_table');
		for (var i = 0; i < li.length; i++) {
			//给每个li自定义一个属性，记录下标
			li[i].setAttribute('data-i', i);

			li[i].onclick = function() {
				$('#childpage').css({
					'display' : 'none'
				});
				$('#childpage').text("加载中...");
				//先将所有div隐藏
				for (var j = 0; j < div.length; j++) {
					div[j].style.display = 'none';
					li[j].className = '';
				}

				//将当前对应下标的div显示出来
				var index = this.getAttribute('data-i');
				div[index].style.display = 'block';
				this.className = 'option_li_current';
			}
		}
	</script>
	<script type="text/javascript">
						// 基于准备好的dom，初始化echarts实例
						var myChart = echarts.init(document
								.getElementById('bar'));

						// 指定图表的配置项和数据
						var option = {
							title : {
								text : '各监区各类型犯人比例图', //标题文本内容
							},
							tooltip : {
								trigger : 'axis',
								axisPointer : { // 坐标轴指示器，坐标轴触发有效
									type : 'shadow' // 默认为直线，可选为：'line' | 'shadow'
								}
							},
							legend : {
								data : [ '重点犯', '顽危犯', '新疆犯', '其他犯人' ]
							},
							grid : {
								left : '3%',
								right : '4%',
								bottom : '3%',
								containLabel : true
							},
							yAxis : {
								type : 'value'
							},
							xAxis : {
								type : 'category',
								data : [ '第一监区', '第二监区', '第三监区', '第四监区',
										'第五监区', '第六监区', '第七监区', '第八监区', '第九监区',
										'第十监区' ]
							},
							series : [
									{
										name : '重点犯',
										type : 'bar',
										stack : '总量',
										label : {
											normal : {
												show : true,
												position : 'insideRight'
											}
										},
										data : [ 10, 10, 10, 10, 10, 10, 10,
												10, 10, 10 ]
									},
									{
										name : '顽危犯',
										type : 'bar',
										stack : '总量',
										label : {
											normal : {
												show : true,
												position : 'insideRight'
											}
										},
										data : [ 15, 15, 15, 15, 15, 15, 15,
												15, 15, 15 ]
									},
									{
										name : '新疆犯',
										type : 'bar',
										stack : '总量',
										label : {
											normal : {
												show : true,
												position : 'insideRight'
											}
										},
										data : [ 20, 20, 20, 20, 20, 20, 20,
												20, 20, 20 ]
									},
									{
										name : '其他犯人',
										type : 'bar',
										stack : '总量',
										label : {
											normal : {
												show : true,
												position : 'insideRight'
											}
										},
										data : [ 355, 455, 255, 155, 355, 455,
												255, 155, 355, 155 ]
									} ]
						};
						myChart.setOption(option);
					</script>
					<script type="text/javascript">
						// 基于准备好的dom，初始化echarts实例
						var myChart1 = echarts.init(document
								.getElementById('bar1'));

						// 指定图表的配置项和数据
						var option1 = {
							title : {
								text : '各监区重点犯比例图', //标题文本内容
							},
							tooltip : {
								trigger : 'axis',
								axisPointer : { // 坐标轴指示器，坐标轴触发有效
									type : 'shadow' // 默认为直线，可选为：'line' | 'shadow'
								}
							},
							legend : {
								data : [ '重点犯' ]
							},
							grid : {
								left : '3%',
								right : '4%',
								bottom : '3%',
								containLabel : true
							},
							yAxis : {
								type : 'value'
							},
							xAxis : {
								type : 'category',
								data : [ '第一监区', '第二监区', '第三监区', '第四监区',
										'第五监区', '第六监区', '第七监区', '第八监区', '第九监区',
										'第十监区' ]
							},
							series : [ {
								name : '重点犯',
								type : 'bar',
								stack : '总量',
								label : {
									normal : {
										show : true,
										position : 'insideRight'
									}
								},
								data : [ 8, 10, 11, 7, 10, 6, 8, 12, 5, 11 ]
							} ]
						};
						myChart1.setOption(option1);
					</script>
			<script type="text/javascript">
						// 基于准备好的dom，初始化echarts实例
						var myChart2 = echarts.init(document
								.getElementById('bar2'));

						// 指定图表的配置项和数据
						var option2 = {
							title : {
								text : '各监区顽危犯比例图', //标题文本内容
							},
							tooltip : {
								trigger : 'axis',
								axisPointer : { // 坐标轴指示器，坐标轴触发有效
									type : 'shadow' // 默认为直线，可选为：'line' | 'shadow'
								}
							},
							legend : {
								data : [ '顽危犯' ]
							},
							grid : {
								left : '3%',
								right : '4%',
								bottom : '3%',
								containLabel : true
							},
							yAxis : {
								type : 'value'
							},
							xAxis : {
								type : 'category',
								data : [ '第一监区', '第二监区', '第三监区', '第四监区',
										'第五监区', '第六监区', '第七监区', '第八监区', '第九监区',
										'第十监区' ]
							},
							series : [ {
								name : '顽危犯',
								type : 'bar',
								stack : '总量',
								label : {
									normal : {
										show : true,
										position : 'insideRight'
									}
								},
								data : [ 8, 10, 11, 7, 10, 6, 8, 12, 5, 11 ]
							} ]
						};
						myChart2.setOption(option2);
					</script>
			<script type="text/javascript">
						// 基于准备好的dom，初始化echarts实例
						var myChart3 = echarts.init(document
								.getElementById('bar3'));

						// 指定图表的配置项和数据
						var option3 = {
							title : {
								text : '各监区新疆犯比例图', //标题文本内容
							},
							tooltip : {
								trigger : 'axis',
								axisPointer : { // 坐标轴指示器，坐标轴触发有效
									type : 'shadow' // 默认为直线，可选为：'line' | 'shadow'
								}
							},
							legend : {
								data : [ '新疆犯' ]
							},
							grid : {
								left : '3%',
								right : '4%',
								bottom : '3%',
								containLabel : true
							},
							yAxis : {
								type : 'value'
							},
							xAxis : {
								type : 'category',
								data : [ '第一监区', '第二监区', '第三监区', '第四监区',
										'第五监区', '第六监区', '第七监区', '第八监区', '第九监区',
										'第十监区' ]
							},
							series : [ {
								name : '新疆犯',
								type : 'bar',
								stack : '总量',
								label : {
									normal : {
										show : true,
										position : 'insideRight'
									}
								},
								data : [ 8, 10, 11, 7, 10, 6, 8, 12, 5, 11 ]
							} ]
						};
						myChart3.setOption(option3);
					</script>
					
		<script type="text/javascript">
						// 基于准备好的dom，初始化echarts实例
						var myChart4 = echarts.init(document
								.getElementById('bar4'));

						// 指定图表的配置项和数据
						var option4 = {
							title : {
								text : '各监区精神病犯比例图', //标题文本内容
							},
							tooltip : {
								trigger : 'axis',
								axisPointer : { // 坐标轴指示器，坐标轴触发有效
									type : 'shadow' // 默认为直线，可选为：'line' | 'shadow'
								}
							},
							legend : {
								data : [ '精神病犯' ]
							},
							grid : {
								left : '3%',
								right : '4%',
								bottom : '3%',
								containLabel : true
							},
							yAxis : {
								type : 'value'
							},
							xAxis : {
								type : 'category',
								data : [ '第一监区', '第二监区', '第三监区', '第四监区',
										'第五监区', '第六监区', '第七监区', '第八监区', '第九监区',
										'第十监区' ]
							},
							series : [ {
								name : '精神病犯',
								type : 'bar',
								stack : '总量',
								label : {
									normal : {
										show : true,
										position : 'insideRight'
									}
								},
								data : [ 8, 10, 11, 7, 10, 6, 8, 12, 5, 11 ]
							} ]
						};
						myChart4.setOption(option4);
					</script>
					
	  <script type="text/javascript">
						// 基于准备好的dom，初始化echarts实例
						var myChart5 = echarts.init(document
								.getElementById('bar5'));

						// 指定图表的配置项和数据
						var option5 = {
							title : {
								text : '各监区外籍犯比例图', //标题文本内容
							},
							tooltip : {
								trigger : 'axis',
								axisPointer : { // 坐标轴指示器，坐标轴触发有效
									type : 'shadow' // 默认为直线，可选为：'line' | 'shadow'
								}
							},
							legend : {
								data : [ '外籍犯' ]
							},
							grid : {
								left : '3%',
								right : '4%',
								bottom : '3%',
								containLabel : true
							},
							yAxis : {
								type : 'value'
							},
							xAxis : {
								type : 'category',
								data : [ '第一监区', '第二监区', '第三监区', '第四监区',
										'第五监区', '第六监区', '第七监区', '第八监区', '第九监区',
										'第十监区' ]
							},
							series : [ {
								name : '外籍犯',
								type : 'bar',
								stack : '总量',
								label : {
									normal : {
										show : true,
										position : 'insideRight'
									}
								},
								data : [ 8, 10, 11, 7, 10, 6, 8, 12, 5, 11 ]
							} ]
						};
						myChart5.setOption(option5);
					</script>
					
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
					<li id="dafx" name="dafx" class="option_li_current">各类罪犯</li>
					<li id="rcgc" name="rcgc">重点犯</li>
					<li id="xlcs" name="xlcs">顽危犯</li>
					<li id="zhsx" name="zhsx">危安犯</li>
					<li id="zspc" name="zspc">精神病犯</li>
					<li id="xxpc" name="xxpc">外籍犯</li>

				</ul>
			</div>
			<!--可选内容 -->
			<div id="basecontent" class="main_content_base">
				<!--各类罪犯 -->
				<div id="dafxtab" class="option_table">
					<!-- <span class="base_query">各监区重点犯情况</span> -->


					<div id="bar" style="width: 100%; height: 300px; padding-top: 10px"></div>
					<script type="text/javascript">
						// 基于准备好的dom，初始化echarts实例
						var myChart = echarts.init(document
								.getElementById('bar'));

						// 指定图表的配置项和数据
						var option = {
							title : {
								text : '各监区各类型犯人比例图', //标题文本内容
							},
							tooltip : {
								trigger : 'axis',
								axisPointer : { // 坐标轴指示器，坐标轴触发有效
									type : 'shadow' // 默认为直线，可选为：'line' | 'shadow'
								}
							},
							legend : {
								data : [ '重点犯', '顽危犯', '危安犯', '其他犯人' ]
							},
							grid : {
								left : '3%',
								right : '4%',
								bottom : '3%',
								containLabel : true
							},
							yAxis : {
								type : 'value'
							},
							xAxis : {
								type : 'category',
								data : [ '一监区', '二监区', '三监区', '四监区',
										'五监区', '六监区', '七监区', '八监区', '九监区',
										'十监区', '十二监区', '医院监区', '新犯队',
										'出监管区','狱政科' ]
							},
							series : [
									{
										name : '重点犯',
										type : 'bar',
										stack : '总量',
										label : {
											normal : {
												show : true,
												position : 'insideRight'
											}
										},
										data : [ 0, 0, 0, 0, 0, 0, 0,
												0, 0, 0, 0, 0,
												0, 0, 0 ]
									},
									{
										name : '顽危犯',
										type : 'bar',
										stack : '总量',
										label : {
											normal : {
												show : true,
												position : 'insideRight'
											}
										},
										data : [ 0, 0, 0, 0, 0, 0, 0,
												0, 0, 0, 0, 0,
												0, 0, 0  ]
									},
									{
										name : '危安犯',
										type : 'bar',
										stack : '总量',
										label : {
											normal : {
												show : true,
												position : 'insideRight'
											}
										},
										data : [ 0, 0, 0, 0, 0, 0, 0,
												0, 0, 0, 0, 0,
												0, 0, 0  ]
									},
									{
										name : '其他犯人',
										type : 'bar',
										stack : '总量',
										label : {
											normal : {
												show : true,
												position : 'insideRight'
											}
										},
										data : [  0, 0, 0, 0, 0, 0, 0,
												0, 0, 0, 0, 0,
												0, 0, 0  ]
									} ]
						};
						myChart.setOption(option);
					</script>
					<div class="base_table">
						<!--<span class="base_liebiao" ></span>-->
						<table width="100%">
							<tr>
								<th class="base_th" width="10%">监区</th>
								<th class="base_th" width="10%">总人数</th>
								<th class="base_th" width="10%">重点犯比例</th>
								<th class="base_th" width="10%">重点犯人数</th>
								<th class="base_th" width="10%">顽危犯比例</th>
								<th class="base_th" width="10%">顽危犯人数</th>
								<th class="base_th" width="10%">危安犯比例</th>
								<th class="base_th" width="10%">危安犯人数</th>
								<th class="base_th" width="10%">精神病犯比例</th>
								<th class="base_th" width="10%">精神病犯人数</th>
								<!--<th class="base_th" width="10%">报告分析</th>-->
							</tr>
							<tr>
								<td>一监区</td>
								<td>0</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn2"><a href="#">0</a></td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn3"><a href="#">0</a></td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn4"><a href="#">0</a></td>
							</tr>

							<tr>
								<td>二监区</td>
								<td>0</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn2"><a href="#">0</a></td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn3"><a href="#">0</a></td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn4"><a href="#">0</a></td>
							</tr>


							<tr>
								<td>三监区</td>
								<td>398</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn2"><a href="#">0</a></td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn3"><a href="#">0</a></td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn4"><a href="#">0</a></td>
							</tr>

							<tr>
								<td>四监区</td>
								<td>0</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn2"><a href="#">0</a></td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn3"><a href="#">0</a></td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn4"><a href="#">0</a></td>
							</tr>
							<tr>
								<td>五监区</td>
								<td>0</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn2"><a href="#">0</a></td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn3"><a href="#">0</a></td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn4"><a href="#">0</a></td>
							</tr>
							<tr>
								<td>六监区</td>
								<td>0</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn2"><a href="#">0</a></td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn3"><a href="#">0</a></td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn4"><a href="#">0</a></td>
							</tr>
							<tr>
								<td>七监区</td>
								<td>0</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn2"><a href="#">0</a></td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn3"><a href="#">0</a></td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn4"><a href="#">0</a></td>
							</tr>
							<tr>
								<td>八监区</td>
								<td>0</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn2"><a href="#">0</a></td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn3"><a href="#">0</a></td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn4"><a href="#">0</a></td>
							</tr>
							<tr>
								<td>九监区</td>
								<td>0</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn2"><a href="#">0</a></td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn3"><a href="#">0</a></td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn4"><a href="#">0</a></td>
							</tr>


							<tr>
								<td>十监区</td>
								<td>0</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn2"><a href="#">0</a></td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn3"><a href="#">0</a></td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn4"><a href="#">0</a></td>
							</tr>
							<tr>
								<td>十二监区</td>
								<td>0</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn2"><a href="#">0</a></td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn3"><a href="#">0</a></td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn4"><a href="#">0</a></td>
							</tr>
							<tr>
								<td>医院监区</td>
								<td>0</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn2"><a href="#">0</a></td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn3"><a href="#">0</a></td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn4"><a href="#">0</a></td>
							</tr>
							<tr>
								<td>新犯队</td>
								<td>308</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn2"><a href="#">0</a></td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn3"><a href="#">0</a></td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn4"><a href="#">0</a></td>
							</tr>
							<tr>
								<td>出监管区</td>
								<td>198</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn2"><a href="#">0</a></td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn3"><a href="#">0</a></td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn4"><a href="#">0</a></td>
							</tr>
							<tr>
								<td>狱政科</td>
								<td>0</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn2"><a href="#">0</a></td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn3"><a href="#">0</a></td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn4"><a href="#">0</a></td>
							</tr>
                            <tr>
								<td>全监</td>
								<td>904</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn2"><a href="#">0</a></td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn3"><a href="#">0</a></td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn4"><a href="#">0</a></td>
							</tr>

						</table>
					</div>
				</div>

				<!--重点犯 -->
				<div id="rcgctab" class="option_table">
					<!-- <span class="base_query">各监区重点犯情况</span> -->

					<!-- table -->
					<div id="bar1"
						style="width: 1000px; height: 300px; padding-top: 10px"></div>
					<script type="text/javascript">
						// 基于准备好的dom，初始化echarts实例
						var myChart1 = echarts.init(document
								.getElementById('bar1'));

						// 指定图表的配置项和数据
						var option1 = {
							title : {
								text : '各监区重点犯比例图', //标题文本内容
							},
							tooltip : {
								trigger : 'axis',
								axisPointer : { // 坐标轴指示器，坐标轴触发有效
									type : 'shadow' // 默认为直线，可选为：'line' | 'shadow'
								}
							},
							legend : {
								data : [ '重点犯' ]
							},
							grid : {
								left : '3%',
								right : '4%',
								bottom : '3%',
								containLabel : true
							},
							yAxis : {
								type : 'value'
							},
							xAxis : {
								type : 'category',
								data : ['一监区', '二监区', '三监区', '四监区',
										'五监区', '六监区', '七监区', '八监区', '九监区',
										'十监区', '十二监区', '医院监区', '新犯队',
										'出监管区','狱政科' ]
							},
							series : [ {
								name : '重点犯',
								type : 'bar',
								stack : '总量',
								label : {
									normal : {
										show : true,
										position : 'insideRight'
									}
								},
								data : [ 0, 0, 0, 0, 0, 0, 0,
												0, 0, 0, 0, 0,
												0, 0, 0 ]
							} ]
						};
						myChart1.setOption(option1);
					</script>
					<div class="base_table">
						<!--<span class="base_liebiao" ></span>-->
						<table width="100%">
							<tr>
								<th class="base_th" width="30%">监区</th>
								<th class="base_th" width="25%">总人数</th>
								<th class="base_th" width="20%">重点犯比例</th>
								<th class="base_th" width="25%">重点犯人数</th>

								<!--<th class="base_th" width="10%">报告分析</th>-->
							</tr>
							<tr>
								<td>一监区</td>
								<td>0</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
							</tr>

							<tr>
								<td>二监区</td>
								<td>0</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
							</tr>


							<tr>
								<td>三监区</td>
								<td>398</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
							</tr>

							<tr>
								<td>四监区</td>
								<td>0</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
							</tr>
							<tr>
								<td>五监区</td>
								<td>0</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
							</tr>
							<tr>
								<td>六监区</td>
								<td>0</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
							</tr>
							<tr>
								<td>七监区</td>
								<td>0</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
							</tr>
							<tr>
								<td>八监区</td>
								<td>0</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
							</tr>
							<tr>
								<td>九监区</td>
								<td>0</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
							</tr>


							<tr>
								<td>十监区</td>
								<td>0</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
							</tr>
							<tr>
								<td>十二监区</td>
								<td>0</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
							</tr>
							<tr>
								<td>医院监区</td>
								<td>0</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
							</tr>
							<tr>
								<td>新犯队</td>
								<td>308</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
							</tr>
							<tr>
								<td>出监管区</td>
								<td>198</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
							</tr>
							<tr>
								<td>狱政科</td>
								<td>0</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
							</tr>

                            <tr>
								<td>全监</td>
								<td>904</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
							</tr>

						</table>
					</div>
					<!-- <div class="addbutton" onclick="loadnext1('pggl/xszflb')"><i>添加</i></div> -->


				</div>
				<!--顽危犯 -->
				<div id="xlcstab" class="option_table">
					<span class="base_query">各监区顽危犯情况</span>

					<!-- table -->
					<div id="bar2"
						style="width: 1000px; height: 300px; padding-top: 10px"></div>
					<script type="text/javascript">
						// 基于准备好的dom，初始化echarts实例
						var myChart2 = echarts.init(document
								.getElementById('bar2'));

						// 指定图表的配置项和数据
						var option2 = {
							title : {
								text : '各监区顽危犯比例图', //标题文本内容
							},
							tooltip : {
								trigger : 'axis',
								axisPointer : { // 坐标轴指示器，坐标轴触发有效
									type : 'shadow' // 默认为直线，可选为：'line' | 'shadow'
								}
							},
							legend : {
								data : [ '顽危犯' ]
							},
							grid : {
								left : '3%',
								right : '4%',
								bottom : '3%',
								containLabel : true
							},
							yAxis : {
								type : 'value'
							},
							xAxis : {
								type : 'category',
								data : ['一监区', '二监区', '三监区', '四监区',
										'五监区', '六监区', '七监区', '八监区', '九监区',
										'十监区', '十二监区', '医院监区', '新犯队',
										'出监管区','狱政科' ]
							},
							series : [ {
								name : '顽危犯',
								type : 'bar',
								stack : '总量',
								label : {
									normal : {
										show : true,
										position : 'insideRight'
									}
								},
								data : [  0, 0, 0, 0, 0, 0, 0,
												0, 0, 0, 0, 0,
												0, 0, 0]
							} ]
						};
						myChart2.setOption(option2);
					</script>
					<div class="base_table">
						<!--<span class="base_liebiao" ></span>-->
						<table width="100%">
							<tr>
								<th class="base_th" width="30%">监区</th>
								<th class="base_th" width="25%">总人数</th>
								<th class="base_th" width="20%">顽危犯比例</th>
								<th class="base_th" width="25%">顽危犯人数</th>

								<!--<th class="base_th" width="10%">报告分析</th>-->
							</tr>
							<tr>
								<td>一监区</td>
								<td>0</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
							</tr>

							<tr>
								<td>二监区</td>
								<td>0</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
							</tr>


							<tr>
								<td>三监区</td>
								<td>398</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
							</tr>

							<tr>
								<td>四监区</td>
								<td>0</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
							</tr>
							<tr>
								<td>五监区</td>
								<td>0</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
							</tr>
							<tr>
								<td>六监区</td>
								<td>0</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
							</tr>
							<tr>
								<td>七监区</td>
								<td>0</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
							</tr>
							<tr>
								<td>八监区</td>
								<td>0</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
							</tr>
							<tr>
								<td>九监区</td>
								<td>0</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
							</tr>


							<tr>
								<td>十监区</td>
								<td>0</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
							</tr>
							<tr>
								<td>十二监区</td>
								<td>0</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
							</tr>
							<tr>
								<td>医院监区</td>
								<td>0</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
							</tr>
							<tr>
								<td>新犯队</td>
								<td>308</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
							</tr>
							<tr>
								<td>出监管区</td>
								<td>198</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
							</tr>
							<tr>
								<td>狱政科</td>
								<td>0</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
							</tr>
                            <tr>
								<td>全监</td>
								<td>904</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
							</tr>

						</table>

					</div>


				</div>
				<!--新疆犯 -->
				<div id="zhsxtab" class="option_table">
					<span class="base_query">各监区危安犯情况</span>

					<!-- table -->
					<div id="bar3"
						style="width: 1000px; height: 300px; padding-top: 10px"></div>
					<script type="text/javascript">
						// 基于准备好的dom，初始化echarts实例
						var myChart3 = echarts.init(document
								.getElementById('bar3'));

						// 指定图表的配置项和数据
						var option3 = {
							title : {
								text : '各监区危安犯比例图', //标题文本内容
							},
							tooltip : {
								trigger : 'axis',
								axisPointer : { // 坐标轴指示器，坐标轴触发有效
									type : 'shadow' // 默认为直线，可选为：'line' | 'shadow'
								}
							},
							legend : {
								data : [ '危安犯' ]
							},
							grid : {
								left : '3%',
								right : '4%',
								bottom : '3%',
								containLabel : true
							},
							yAxis : {
								type : 'value'
							},
							xAxis : {
								type : 'category',
								data : [ '一监区', '二监区', '三监区', '四监区',
										'五监区', '六监区', '七监区', '八监区', '九监区',
										'十监区', '十二监区', '医院监区', '新犯队',
										'出监管区','狱政科' ]
							},
							series : [ {
								name : '危安犯',
								type : 'bar',
								stack : '总量',
								label : {
									normal : {
										show : true,
										position : 'insideRight'
									}
								},
								data : [ 0, 0, 0, 0, 0, 0, 0,
												0, 0, 0, 0, 0,
												0, 0, 0]
							} ]
						};
						myChart3.setOption(option3);
					</script>
					<div class="base_table">
						<!--<span class="base_liebiao" ></span>-->
						<table width="100%">
							<tr>
								<th class="base_th" width="30%">监区</th>
								<th class="base_th" width="25%">总人数</th>
								<th class="base_th" width="20%">危安犯比例</th>
								<th class="base_th" width="25%">危安犯人数</th>

								<!--<th class="base_th" width="10%">报告分析</th>-->
							</tr>
							<tr>
								<td>一监区</td>
								<td>0</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
							</tr>

							<tr>
								<td>二监区</td>
								<td>0</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
							</tr>


							<tr>
								<td>三监区</td>
								<td>398</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
							</tr>

							<tr>
								<td>四监区</td>
								<td>0</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
							</tr>
							<tr>
								<td>五监区</td>
								<td>0</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
							</tr>
							<tr>
								<td>六监区</td>
								<td>0</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
							</tr>
							<tr>
								<td>七监区</td>
								<td>0</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
							</tr>
							<tr>
								<td>八监区</td>
								<td>0</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
							</tr>
							<tr>
								<td>九监区</td>
								<td>0</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
							</tr>


							<tr>
								<td>十监区</td>
								<td>0</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
							</tr>
							<tr>
								<td>十二监区</td>
								<td>0</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
							</tr>
							<tr>
								<td>医院监区</td>
								<td>0</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
							</tr>
							<tr>
								<td>新犯队</td>
								<td>308</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
							</tr>
							<tr>
								<td>出监管区</td>
								<td>198</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
							</tr>
							<tr>
								<td>狱政科</td>
								<td>0</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
							</tr>
                            <tr>
								<td>全监</td>
								<td>904</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
							</tr>

						</table>

					</div>


				</div>
				<!--精神病犯 -->
				<div id="zspc" class="option_table">
					<span class="base_query">各监区精神病犯情况</span>

					<!-- table -->
					<div id="bar4"
						style="width: 1000px; height: 300px; padding-top: 10px"></div>
					<script type="text/javascript">
						// 基于准备好的dom，初始化echarts实例
						var myChart4 = echarts.init(document
								.getElementById('bar4'));

						// 指定图表的配置项和数据
						var option4 = {
							title : {
								text : '各监区精神病犯比例图', //标题文本内容
							},
							tooltip : {
								trigger : 'axis',
								axisPointer : { // 坐标轴指示器，坐标轴触发有效
									type : 'shadow' // 默认为直线，可选为：'line' | 'shadow'
								}
							},
							legend : {
								data : [ '精神病犯' ]
							},
							grid : {
								left : '3%',
								right : '4%',
								bottom : '3%',
								containLabel : true
							},
							yAxis : {
								type : 'value'
							},
							xAxis : {
								type : 'category',
								data : [  '一监区', '二监区', '三监区', '四监区',
										'五监区', '六监区', '七监区', '八监区', '九监区',
										'十监区', '十二监区', '医院监区', '新犯队',
										'出监管区','狱政科']
							},
							series : [ {
								name : '精神病犯',
								type : 'bar',
								stack : '总量',
								label : {
									normal : {
										show : true,
										position : 'insideRight'
									}
								},
								data : [0, 0, 0, 0, 0, 0, 0,
												0, 0, 0, 0, 0,
												0, 0, 0]
							} ]
						};
						myChart4.setOption(option4);
					</script>
					<div class="base_table">
						<!--<span class="base_liebiao" ></span>-->
						<table width="100%">
							<tr>
								<th class="base_th" width="30%">监区</th>
								<th class="base_th" width="25%">总人数</th>
								<th class="base_th" width="20%">精神病犯比例</th>
								<th class="base_th" width="25%">精神病犯人数</th>

								<!--<th class="base_th" width="10%">报告分析</th>-->
							</tr>
							<tr>
								<td>一监区</td>
								<td>0</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
							</tr>

							<tr>
								<td>二监区</td>
								<td>0</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
							</tr>


							<tr>
								<td>三监区</td>
								<td>398</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
							</tr>

							<tr>
								<td>四监区</td>
								<td>0</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
							</tr>
							<tr>
								<td>五监区</td>
								<td>0</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
							</tr>
							<tr>
								<td>六监区</td>
								<td>0</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
							</tr>
							<tr>
								<td>七监区</td>
								<td>0</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
							</tr>
							<tr>
								<td>八监区</td>
								<td>0</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
							</tr>
							<tr>
								<td>九监区</td>
								<td>0</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
							</tr>


							<tr>
								<td>十监区</td>
								<td>0</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
							</tr>
							<tr>
								<td>十二监区</td>
								<td>0</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
							</tr>
							<tr>
								<td>医院监区</td>
								<td>0</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
							</tr>
							<tr>
								<td>新犯队</td>
								<td>308</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
							</tr>
							<tr>
								<td>出监管区</td>
								<td>198</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
							</tr>
							<tr>
								<td>狱政科</td>
								<td>0</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
							</tr>
                            <tr>
								<td>全监</td>
								<td>904</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
							</tr>

						</table>

					</div>


					<!-- <div class="addbutton" onclick="loadnext1('pggl/zspclb')"><i>添加</i></div> -->
				</div>
				<!--外籍犯 -->
				<div id="xxpc" class="option_table">
					<span class="base_query">各监区外籍犯情况</span>

					<!-- table -->
					<div id="bar5"
						style="width: 1000px; height: 300px; padding-top: 10px"></div>
					<script type="text/javascript">
						// 基于准备好的dom，初始化echarts实例
						var myChart5 = echarts.init(document
								.getElementById('bar5'));

						// 指定图表的配置项和数据
						var option5 = {
							title : {
								text : '各监区外籍犯比例图', //标题文本内容
							},
							tooltip : {
								trigger : 'axis',
								axisPointer : { // 坐标轴指示器，坐标轴触发有效
									type : 'shadow' // 默认为直线，可选为：'line' | 'shadow'
								}
							},
							legend : {
								data : [ '外籍犯' ]
							},
							grid : {
								left : '3%',
								right : '4%',
								bottom : '3%',
								containLabel : true
							},
							yAxis : {
								type : 'value'
							},
							xAxis : {
								type : 'category',
								data : [ '一监区', '二监区', '三监区', '四监区',
										'五监区', '六监区', '七监区', '八监区', '九监区',
										'十监区', '十二监区', '医院监区', '新犯队',
										'出监管区','狱政科']
							},
							series : [ {
								name : '外籍犯',
								type : 'bar',
								stack : '总量',
								label : {
									normal : {
										show : true,
										position : 'insideRight'
									}
								},
								data : [ 0, 0, 0, 0, 0, 0, 0,
												0, 0, 0, 0, 0,
												0, 0, 0]
							} ]
						};
						myChart5.setOption(option5);
					</script>
					<div class="base_table">
						<!--<span class="base_liebiao" ></span>-->
						<table width="100%">
							<tr>
								<th class="base_th" width="30%">监区</th>
								<th class="base_th" width="25%">总人数</th>
								<th class="base_th" width="20%">外籍犯比例</th>
								<th class="base_th" width="25%">外籍犯人数</th>

								<!--<th class="base_th" width="10%">报告分析</th>-->
							</tr>
							<tr>
								<td>一监区</td>
								<td>0</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
							</tr>

							<tr>
								<td>二监区</td>
								<td>0</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
							</tr>


							<tr>
								<td>三监区</td>
								<td>398</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
							</tr>

							<tr>
								<td>四监区</td>
								<td>0</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
							</tr>
							<tr>
								<td>五监区</td>
								<td>0</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
							</tr>
							<tr>
								<td>六监区</td>
								<td>0</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
							</tr>
							<tr>
								<td>七监区</td>
								<td>0</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
							</tr>
							<tr>
								<td>八监区</td>
								<td>0</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
							</tr>
							<tr>
								<td>九监区</td>
								<td>0</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
							</tr>


							<tr>
								<td>十监区</td>
								<td>0</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
							</tr>
							<tr>
								<td>十二监区</td>
								<td>0</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
							</tr>
							<tr>
								<td>医院监区</td>
								<td>0</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
							</tr>
							<tr>
								<td>新犯队</td>
								<td>308</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
							</tr>
							<tr>
								<td>出监管区</td>
								<td>198</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
							</tr>
							<tr>
								<td>狱政科</td>
								<td>0</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
							</tr>
                            <tr>
								<td>全监</td>
								<td>904</td>
								<td style="color: red">0%</td>
								<td class="js-rg-btn1"><a href="#">0</a></td>
							</tr>

						</table>

					</div>


				</div>

				<!--子页面区 -->
				<div id="childpage" class=""></div>
			</div>
		</div>
	</div>

</body>

</html>