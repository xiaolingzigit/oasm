<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>各类罪犯统计</title>
					
</head>
<body>

				<!--危安犯 -->
				<div id="zhsxtab" class="option_table3">
					<!-- <span class="base_query">各监区危安犯情况</span> -->

					<!-- table -->
					<div id="bar3"
						style="width: 100%; height: 300px; padding-top: 10px"></div>

					<div class="base_table">
					<h4>危安犯统计表</h4>
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
</body>

</html>