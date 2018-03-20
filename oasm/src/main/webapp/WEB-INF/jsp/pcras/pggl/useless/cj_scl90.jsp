<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>档案分析</title>
<!-- 分页样式 -->
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resource/css/page.css'/>">
<!-- 页面内容的js -->
<script type="text/javascript"
	src="<c:url value='/resource/js/pggl/pggl.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/resource/js/page.js'/>"></script>


</head>
<body>
	<!--数据采集与排查 -->
				<!--scl90 -->
				<div id="xlcstab" class="option_table3">
					<table class="content_table" width="100%">
						<tr>
							<th class="base_th" width="5%">序号</th>
							<th class="base_th" width="10%">囚号</th>
							<th class="base_th" width="10%">罪犯姓名</th>
							<th class="base_th" width="10%">采集时间</th>
							<th class="base_th" width="10%">信息类型</th>
							<th class="base_th" width="10%">评估分数</th>
							<th class="base_th" width="10%">详细信息</th>
						</tr>
						<tr>
							<td>1</td>
							<td>6546545454</td>
							<td>xx</td>
							<td>2017-07-07</td>
							<td>scl90量表</td>
							<td>9</td>
							<td><a href="#"
								onclick="loadnext3('/oasm/dafxView/cj_scl90rs')">点击进入</a></td>
						</tr>
						<tr>
							<td>2</td>
							<td>6546545454</td>
							<td>xx</td>
							<td>2017-07-07</td>
							<td>scl90量表</td>
							<td>9</td>
							<td><a href="#"
								onclick="loadnext3('/oasm/dafxView/cj_scl90rs')">点击进入</a></td>
						</tr>
					</table>
					<div class="fenye">
						<ul class="fenye-ul">
							<li>共<a style="color: red;">2</a>个记录
							</li>
							<li>共2页</li>
							<li>首页</li>
							<li>上一页</li>
							<li class="fenye-li01">1</li>
							<li class="fenye-li02">2</li>
							<li>下一页</li>
							<li>尾页</li>
							<li>转到第 <input type="text" /> 页
							</li>
						</ul>
					</div>
					<div class="addbutton"
						onclick="loadnext3('/oasm/dafxView/cj_scl90lb')">
						<i>添加</i>
					</div>
				</div>

</body>
</html>