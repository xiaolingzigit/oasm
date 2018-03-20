<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0" />
<title>阳性因子</title>
</head>
<body>
   <div id="" class="sub-block">
		<div class="main_content">
			<div class="yztable_line">
				<div class="yzlbtable">
				<div class="yztable_title">
					<span>阳性因子列表</span>
					<a href="#" onclick="loadfxmb('/oasm/pggjglView/fxmb')" title="关闭">x</a>
				</div>
				<table>
					<thead>
						<tr>
							<td>
							  <select size="1">
								 <option>按建立时间排序</option>
							  </select>
							</td>
							<td>
							  <select size="1">
								 <option>因子来源</option>
							  </select>
							</td>
							<td>建立警察警号</td>
							<td>建立警察姓名</td>
							<td>危险类别</td>
							<td>危险因子</td>
							<td>
								<select size="1">
									<option>本监狱是否在用</option>
								</select>
							</td>
							<td>案例</td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>2017-01-14</td>
							<td>某监狱</td>
							<td>1234567</td>
							<td>刘能</td>
							<td>自杀</td>
							<td>有遗书</td>
							<td>是</td>
							<td><a href="#" onclick="loadal(pggjgl/alxq)" title="进入案例详情">案例详情</a></td>
						</tr>
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td>脱逃</td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td>行凶</td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
					</tbody>
				</table>
			</div>
			</div>

			<!--案例列表-->
			<div id="al_line">
				<div altable id="altatble">
					<div id="altable_title">
					  <span>案例列表</span>
					  <a href="#" onclick="">x</a>
				    </div>
				    <table>
				    	<thead>
						<tr>
						    <td>序号</td>
							<td>囚号</td>
							<td>罪犯姓名</td>
							<td>监区</td>
							<td>危险等级</td>
							<td>自杀分数</td>
							<td>逃脱分数</td>
							<td>行凶分数</td>
							<td>再犯罪分数</td>
							<td>评估报告及分析</td>
						</tr>
					   </thead>
					   <tbody>
					   	 <tr>
					   	 	<td>1</td>
					   	 	<td>4230942394</td>
					   	 	<td>王五</td>
					   	 	<td>十一监区</td>
					   	 	<td>极高危险</td>
					   	 	<td>85</td>
					   	 	<td>50</td>
					   	 	<td>47</td>
					   	 	<td>23</td>
					   	 	<td><a onclick="">查看详情</a></td>
					   	 </tr>
					   	 <tr>
					   	 	<td>2</td>
					   	 	<td></td>
					   	 	<td></td>
					   	 	<td></td>
					   	 	<td></td>
					   	 	<td></td>
					   	 	<td></td>
					   	 	<td></td>
					   	 	<td></td>
					   	 	<td></td>
					   	 </tr>
					   	 <tr>
					   	 	<td>3</td>
					   	 	<td></td>
					   	 	<td></td>
					   	 	<td></td>
					   	 	<td></td>
					   	 	<td></td>
					   	 	<td></td>
					   	 	<td></td>
					   	 	<td></td>
					   	 	<td></td>
					   	 </tr>
					   	 <tr>
					   	 	<td>4</td>
					   	 	<td></td>
					   	 	<td></td>
					   	 	<td></td>
					   	 	<td></td>
					   	 	<td></td>
					   	 	<td></td>
					   	 	<td></td>
					   	 	<td></td>
					   	 	<td></td>
					   	 </tr>
					   </tbody>
				    </table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>