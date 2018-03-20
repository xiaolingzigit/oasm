<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0" />
<title>量表分析</title>
</head>
<body>
	<div id="" class="sub-block">
		<!-- 定位栏-->
		<div class="location">
			<div class="location_left">
				<i><font color="#ffffff"><strong>您现在的位置</strong></font></i>
			</div>
			<div class="location_right">
				<strong>&nbsp;&nbsp;评估工具 >><font color="#ff3300">量表分析</font></strong>
			</div>
		</div>

		<!--选项卡-->
		<div class="main_content">
			<div id="option" class="option_area">
				<ul>
					<li id="xxdfx" name="xxdfx" class="option_li_current">量表信效度分析</li>
					<li id="lbyz" name="lbyz">量表因子分析</li>
				</ul>
			</div>
			<div id="basecontent" class="main_content_base_pggj">
				<!--量表信效度分析部分-->
				<div id="lbfxcharts" class="option_table">
					<div id="xindu"></div>
					<div id="xiaodu"></div>
				</div>
				<!--量表因子分析-->
				<div id="lbyztable" class="option_table">
					<div id="lbyzfx">
						<!--入监评估阶段量表开始-->
						<div id="zhnamediv">
							<div id="zhpglb">入监评估阶段</div>
							<div id="zhpglb_sx">
								<div id="wdtz">档案分析</div>
								<div id="kbtz">结构性访谈</div>
								<div id="xltz">行为观察</div>
								<div id="xwtz">心理测试</div>
							</div>
						</div>
						<div id="zhdatadiv">
							<div id="leftzhdatatable">
								<table>
									<thead>
										<tr>
											<td>自杀维度</td>
											<td>行凶维度</td>
											<td>逃脱维度</td>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>0.2</td>
											<td>0.1</td>
											<td>0.2</td>
										</tr>
										<tr>
											<td>0.3</td>
											<td>0.4</td>
											<td>0.5</td>
										</tr>
										<tr>
											<td>0.2</td>
											<td>0.1</td>
											<td>0.3</td>
										</tr>
										<tr>
											<td>0.1</td>
											<td>0.3</td>
											<td>0.3</td>
										</tr>
										<tr>
											<td>0.5</td>
											<td>0.5</td>
											<td>0.5</td>
										</tr>
										<tr>
											<td>0.4</td>
											<td>0.4</td>
											<td>0.5</td>
										</tr>
										<tr>
											<td>0.5</td>
											<td>0.5</td>
											<td>0.5</td>
										</tr>
										<tr>
											<td>0.3</td>
											<td>0.4</td>
											<td>0.5</td>
										</tr>
									</tbody>
								</table>
							</div>
							<div id="rightzhdataimg">
								<img src="<c:url value='/resource/images/gwzfhx_03.png'/>">
								<span>因子分析</span>
							</div>
						</div>
					</div>
					<div id="lbyzfx">
						<!--日常评估阶段量表开始-->
						<div id="zhnamediv">
							<div id="zhpglb">日常评估阶段</div>
							<div id="zhpglb_sx">
								<div id="wdtz">档案分析</div>
								<div id="kbtz">结构性访谈</div>
								<div id="xltz">行为观察</div>
								<div id="xwtz">心理测试</div>
							</div>
						</div>
						<div id="zhdatadiv">
							<div id="leftzhdatatable">
								<table>
									<thead>
										<tr>
											<td>自杀维度</td>
											<td>行凶维度</td>
											<td>逃脱维度</td>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>0.2</td>
											<td>0.1</td>
											<td>0.2</td>
										</tr>
										<tr>
											<td>0.3</td>
											<td>0.4</td>
											<td>0.5</td>
										</tr>
										<tr>
											<td>0.2</td>
											<td>0.1</td>
											<td>0.3</td>
										</tr>
										<tr>
											<td>0.1</td>
											<td>0.3</td>
											<td>0.3</td>
										</tr>
										<tr>
											<td>0.5</td>
											<td>0.5</td>
											<td>0.5</td>
										</tr>
										<tr>
											<td>0.4</td>
											<td>0.4</td>
											<td>0.5</td>
										</tr>
										<tr>
											<td>0.5</td>
											<td>0.5</td>
											<td>0.5</td>
										</tr>
										<tr>
											<td>0.3</td>
											<td>0.4</td>
											<td>0.5</td>
										</tr>
									</tbody>
								</table>
							</div>
							<div id="rightzhdataimg">
								<img src="<c:url value='/resource/images/gwzfhx_03.png'/>">
								<span>因子分析</span>
							</div>
						</div>
					</div>
					<div id="lbyzfx">
						<!--中期评估阶段量表开始-->
						<div id="zhnamediv">
							<div id="zhpglb">中期评估阶段</div>
							<div id="zhpglb_sx">
								<div id="wdtz">档案分析</div>
								<div id="kbtz">结构性访谈</div>
								<div id="xltz">行为观察</div>
								<div id="xwtz">心理测试</div>
							</div>
						</div>
						<div id="zhdatadiv">
							<div id="leftzhdatatable">
								<table>
									<thead>
										<tr>
											<td>自杀维度</td>
											<td>行凶维度</td>
											<td>逃脱维度</td>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>0.2</td>
											<td>0.1</td>
											<td>0.2</td>
										</tr>
										<tr>
											<td>0.3</td>
											<td>0.4</td>
											<td>0.5</td>
										</tr>
										<tr>
											<td>0.2</td>
											<td>0.1</td>
											<td>0.3</td>
										</tr>
										<tr>
											<td>0.1</td>
											<td>0.3</td>
											<td>0.3</td>
										</tr>
										<tr>
											<td>0.5</td>
											<td>0.5</td>
											<td>0.5</td>
										</tr>
										<tr>
											<td>0.4</td>
											<td>0.4</td>
											<td>0.5</td>
										</tr>
										<tr>
											<td>0.5</td>
											<td>0.5</td>
											<td>0.5</td>
										</tr>
										<tr>
											<td>0.3</td>
											<td>0.4</td>
											<td>0.5</td>
										</tr>
									</tbody>
								</table>
							</div>
							<div id="rightzhdataimg">
								<img src="<c:url value='/resource/images/gwzfhx_03.png'/>">
								<span>因子分析</span>
							</div>
						</div>
					</div>
					<div id="lbyzfx">
						<!--出监评估阶段量表开始-->
						<div id="zhnamediv">
							<div id="zhpglb">出监评估阶段</div>
							<div id="zhpglb_sx">
								<div id="wdtz">档案分析</div>
								<div id="kbtz">结构性访谈</div>
								<div id="xltz">行为观察</div>
								<div id="xwtz">心理测试</div>
							</div>
						</div>
						<div id="zhdatadiv">
							<div id="leftzhdatatable">
								<table>
									<thead>
										<tr>
											<td>自杀维度</td>
											<td>行凶维度</td>
											<td>逃脱维度</td>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>0.2</td>
											<td>0.1</td>
											<td>0.2</td>
										</tr>
										<tr>
											<td>0.3</td>
											<td>0.4</td>
											<td>0.5</td>
										</tr>
										<tr>
											<td>0.2</td>
											<td>0.1</td>
											<td>0.3</td>
										</tr>
										<tr>
											<td>0.1</td>
											<td>0.3</td>
											<td>0.3</td>
										</tr>
										<tr>
											<td>0.5</td>
											<td>0.5</td>
											<td>0.5</td>
										</tr>
										<tr>
											<td>0.4</td>
											<td>0.4</td>
											<td>0.5</td>
										</tr>
										<tr>
											<td>0.5</td>
											<td>0.5</td>
											<td>0.5</td>
										</tr>
										<tr>
											<td>0.3</td>
											<td>0.4</td>
											<td>0.5</td>
										</tr>
									</tbody>
								</table>
							</div>
							<div id="rightzhdataimg">
								<img src="<c:url value='/resource/images/gwzfhx_03.png'/>">
								<span>因子分析</span>
							</div>
						</div>
					</div>

				</div>
			</div>
		</div>


	</div>
	<!--信度视图-->
	<script type="text/javascript">
		var alkChart = echarts.init(document.getElementById('xindu'));
		option = {
			title : {
				text : '近期使用的各类量表信度',
				left : "5px",
				top : "10px"

			},
			tooltip : {},
			legend : {
				orient : 'vertical',
				x : '0px',
				y : '180px',
				data : [ '自杀评估量表', '逃脱专项评估量表', '行凶专项评估量表', '综合评估量表' ]
			},
			radar : {
				// shape: 'circle',
				name : {
					textStyle : {
						color : '#333',
						backgroundColor : '#fff',
						borderRadius : 3,
						padding : [ 3, 5 ]
					}
				},
				indicator : [ {
					name : '重测信度',
					max : 1
				}, {
					name : '复本信度',
					max : 1
				}, {
					name : '分半信度',
					max : 1
				}, {
					name : '同质性信度',
					max : 1
				}, {
					name : '评估者信度',
					max : 1
				} ]
			},
			series : [ {
				name : '信度 vs 效度',
				type : 'radar',
				// areaStyle: {normal: {}},
				data : [

				{
					value : [ 0.29, 0.11, 0.25, 0.31, 0.13 ],
					name : '自杀评估量表'
				}, {
					value : [ 0.25, 0.12, 0.24, 0.32, 0.16 ],
					name : '逃脱专项评估量表'
				}, {
					value : [ 0.1, 0.13, 0.28, 0.35, 0.41 ],
					name : '行凶专项评估量表'
				}, {
					value : [ 0.15, 0.13, 0.21, 0.35, 0.21 ],
					name : '综合评估量表'
				} ]
			} ]
		};
		alkChart.setOption(option);
	</script>
	<!--效度视图-->
	<script type="text/javascript">
		var xiaoCharts = echarts.init(document.getElementById('xiaodu'));
		option = {
			title : {
				text : '近期使用的各类量表效度',
				left : "0px",
				top : "10px",

			},
			tooltip : {},
			legend : {
				orient : 'vertical',
				x : '0px',
				y : '230px',
				data : [ '自杀评估量表', '逃脱专项评估量表', '行凶专项评估量表', '综合评估量表' ]
			},
			radar : {
				// shape: 'circle',
				name : {
					textStyle : {
						color : '#333',
						backgroundColor : '#999',
						borderRadius : 3,
						padding : [ 3, 5 ]
					}
				},
				indicator : [ {
					name : '内容效度',
					max : 1
				}, {
					name : '构念效度',
					max : 1
				}, {
					name : '效标关联效度',
					max : 1
				}, {
					name : '其他效度',
					max : 1
				} ]
			},
			series : [ {
				name : '效度',
				type : 'radar',
				// areaStyle: {normal: {}},
				data : [

				{
					value : [ 0.29, 0.1, 0.25, 0.13 ],
					name : '自杀评估量表'
				}, {
					value : [ 0.25, 0.12, 0.24, 0.16 ],
					name : '逃脱专项评估量表'
				}, {
					value : [ 0.25, 0.33, 0.42, 0.62 ],
					name : '行凶专项评估量表'
				}, {
					value : [ 0.24, 0.21, 0.43, 0.63 ],
					name : '综合评估量表'
				} ]
			} ]
		};
		xiaoCharts.setOption(option);
	</script>
	<script>
		$(function() {
			var li = document.getElementsByClassName('option_area')[0]
					.getElementsByTagName('li');
			var div = document.getElementsByClassName('option_table');
			for (var i = 0; i < li.length; i++) {
				//给每个li自定义一个属性，记录下标
				li[i].setAttribute('data-i', i);

				li[i].onclick = function() {
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
		});
	</script>
</body>
</html>