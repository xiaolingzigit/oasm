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
				<strong>&nbsp;&nbsp;统计分析 >><font color="#ff3300">罪犯出监再犯罪倾向统计</font></strong>
			</div>
		</div>
		<div class="main_content">

			<!-- table -->
			<!-- <div id="bar" style="width: 100%; height: 300px; padding-top: 10px"></div> -->
			<div class="base_table">
				<h4>罪犯出监再犯罪倾向统计表</h4>
				<!--<span class="base_liebiao" ></span>-->
				<table width="100%">
					<tr>
						<th class="base_th" width="10%" >监区</th>
						<th class="base_th" width="20%" >极高度倾向</th>
						<th class="base_th" width="20%" >高度倾向</th>
						<th class="base_th" width="20%" >中度倾向</th>
						<th class="base_th" width="20%" >低度倾向</th>
						<!-- <th class="base_th" width="10%" >总人数</th> -->
					</tr>
					<!-- <tr>
						<th class="base_th" width="10%">人数</th>
						<th class="base_th" width="10%">占比</th>
						<th class="base_th" width="10%">人数</th>
						<th class="base_th" width="10%">占比</th>
						<th class="base_th" width="10%">人数</th>
						<th class="base_th" width="10%">占比</th>
						<th class="base_th" width="10%">人数</th>
						<th class="base_th" width="10%">占比</th>
					</tr> -->
					<tbody id="tjcjzf">
						<c:forEach items="${tjzfz}" var="zfz" varStatus="status">
							<tr>
								<td>${zfz.jq }</td>
								<td>${zfz.jg }</td>
								<td>${zfz.gd }</td>
								<td>${zfz.zd }</td>
								<td>${zfz.dd }</td>
								<%-- <td>${zfz.jg }+${zfz.gd }+${zfz.zd }+${zfz.dd }</td> TODO 计算总人数--%>
								</tr>
							</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>