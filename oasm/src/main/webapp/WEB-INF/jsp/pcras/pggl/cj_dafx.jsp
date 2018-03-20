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

</head>
<body>
	<!--数据采集与排查 -->
				<!--档案分析 -->	  
                <div class="layer02">
		<div class="search_title">筛选条件：</div>
		<div class="search_area">
			<div style="float:left;" class="search_sub1">
				监区: <select>
					<option value="出监管区">出监管区</option>

				</select>
			</div>
			<div style="float:left;" class="search_sub1">
				囚号:<input type="text" />
			</div>
			<div style="float:left;" class="search_sub1">
				罪犯姓名：<input type="text" />
			</div>
			<div style="float:left;" class="search_sub1">
				专管警察：<input type="text" />
			</div>
			<div style="float:left;" class="search_sub1">
				<button class="button_submit2">搜索</button>
			</div>
			<div class="search_sub3">
			</div>
		</div>
</div>
				<div id="dafxtab" class="option_table3">
					<table class="content_table" width="100%">
						<thead>
							<tr>
								<th width="5%">序号</th>
								<th width="10%">囚号</th>
								<th width="10%">罪犯姓名</th>
								<th width="10%">分析情况</th>
								<th width="10%">分析得数</th>
								<th width="10%">详细信息</th>
							</tr>
						</thead>
						<tbody id="adminTbody">
							<c:forEach varStatus="status" items="${dafxList}" var="da">
								<tr>
									<td>${status.count }</td>
									<td>${da.qh }</td>
									<td>${da.zsxm }</td>
									<td>非高危</td>
									<td id="datotall">${da.dafxfz }</td>
									<td><a href="#"
										onclick="loadnext3(${da.qh},'/oasm/dafxView/cj_dafxrs');">点击进入</a></td>
									<td style="display: none;" id="dabgscsj"><fmt:formatDate
											value="${da.bgscsj }" pattern="yyyy-MM-dd" /></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<!-- 					<div class="fenye"> -->
					<!-- 						<ul class="fenye-ul"> -->
					<!-- 							<li>共<a style="color: red;">2</a>个记录 -->
					<!-- 							</li> -->
					<!-- 							<li>共2页</li> -->
					<!-- 							<li>首页</li> -->
					<!-- 							<li>上一页</li> -->
					<!-- 							<li class="fenye-li01">1</li> -->
					<!-- 							<li class="fenye-li02">2</li> -->
					<!-- 							<li>下一页</li> -->
					<!-- 							<li>尾页</li> -->
					<!-- 							<li>转到第 <input type="text" /> 页 -->
					<!-- 							</li> -->
					<!-- 						</ul> -->
					<!-- 					</div> -->
					<div id="barcon" class="barcon">
						<div id="barcon1" class="barcon1"></div>
						<div id="barcon2" class="barcon2">
							<ul>
								<li><a id="firstPage">首页</a></li>
								<li><a id="prePage">上一页</a></li>
								<li><a id="nextPage">下一页</a></li>
								<li><a id="lastPage">尾页</a></li>
								<li><select id="jumpWhere"
									style="width: 50px; height: 30px;"></select></li>
								<li><a id="jumpPage" onclick="jumpPage()">跳转</a></li>
							</ul>
						</div>
					</div>

					</div>
<!-- 页面内容的js -->
<script type="text/javascript"
	src="<c:url value='/resource/js/pggl/pggl.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/resource/js/page.js'/>"></script>
					
</body>
</html>