<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
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

	<div class="layer02">
		<div class="search_title">筛选条件：</div>
<!-- 		<div class="search_area">
			<div style="float: left;" class="search_sub1">
				监区: <select id="cjgc_ss_selected">
					<option value="出监管区">出监管区</option>
				</select>
			</div>
			<div style="float: left;" class="search_sub1">
				囚号:<input type="text" id="cjgcqh" />
			</div>
			<div style="float: left;" class="search_sub1">
				罪犯姓名：<input type="text" id="cjgcxm"/>
			</div>
			<div style="float: left;" class="search_sub1">
				专管警察：<input type="text" id="cjgcjhxm"/>
			</div>
			<div style="float: left;" class="search_sub1">
				<button class="button_submit2" id="cjgc_ss_btn">搜索</button>
			</div>
			<div class="search_sub2" id="cjgc_ss_radio">
				观察状态：
				    <input type="radio" name="wcqk" value="" id="status_all" checked/> <label for="status_all">全部 </label>
				    <input type="radio" name="wcqk" value="4" id="status_4" /><label for="status_4">已完成</label>
				    <input type="radio" name="wcqk" value="3" id="status_3" /><label for="status_3">未完成</label>
				    <input type="radio" name="wcqk" value="1" id="status_1" /><label for="status_3">未开始</label>
				    <input type="radio" name="wcqk" value="10" id="status_10" /><label for="status_10">已取消</label>
				</div>
		</div> -->
				 		<div class="search_area">
			<fieldset class="instruct">
				<table class="search_tb">
					<tr>
						<th>监&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;区</th>
						<td><select id="cjgc_ss_selected" class="search_tb_select">
						<option value="十监区">十监区</option>
					<option value="出监管区">出监管区</option>
				</select></td>
						<th>囚&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号</th>
						<td><input type="text" id="cjgcqh" class="search_tb_input" /></td>
						<th>罪&nbsp;&nbsp;犯&nbsp;&nbsp;姓&nbsp;&nbsp;名</th>
						<td><input type="text" id="cjgcxm" class="search_tb_input" /></td>
						<th>警&nbsp;&nbsp;察&nbsp;&nbsp;姓&nbsp;&nbsp;名</th>
						<td><input type="text" id="cjgcjhxm" class="search_tb_input" /></td>
					</tr>
					<tr>
						<th>观&nbsp;&nbsp;察&nbsp;&nbsp;状&nbsp;&nbsp;态</th>
						<td colspan="5" id="cjgc_ss_radio"><input type="radio" name="wcqk" value="" id="status_all" checked/> <label for="status_all">全部 </label>
				    <input type="radio" name="wcqk" value="4" id="status_4" /><label for="status_4">已完成</label>
				    <input type="radio" name="wcqk" value="3" id="status_3" /><label for="status_3">未完成</label>
				    <input type="radio" name="wcqk" value="1" id="status_1" /><label for="status_1">未开始</label>
				    <input type="radio" name="wcqk" value="10" id="status_10" /><label for="status_10">已取消</label></td>
						<td><button class="button_submit2" id="cjgc_ss_btn">&nbsp;搜&nbsp;&nbsp;索&nbsp;</button></td>
					</tr>
					</table>
			</fieldset>
		</div>
		</div>
		<!--日常观察 -->
		<div id="rcgctab" class="option_table3">
			<table class="content_table" width="100%">
			<colgroup>										
							<col width="5%">
							<col width="12%">
							<col width="15%">
							<col  width="9%">
							<col width="18%">
							<col width="9%">
							<col width="10%">
							<col width="8%">							
							<col width="10%">
						</colgroup>
				<thead>
				  <tr>
					<th class="base_th">序号</th>
					<th class="base_th">囚号</th>
					<th class="base_th">罪犯姓名</th>
					<th class="base_th">监区</th>
					<th class="base_th">录入时间</th>
					<th class="base_th">得分</th>
					<th class="base_th">专管警察</th>
					<th class="base_th">观察状态</th>
					<th class="base_th">操作</th>
				  </tr>
				</thead>
				<tbody id="cj_rcgc_tableData">
				  <!-- page.js拼接的出监行为观察数据 -->
				   <c:forEach items="${viewcjxwgcList}" var="cjxw" varStatus="status">
							<tr>
								<td>${status.count }</td>
								<td>${cjxw.crimNo }</td>
								<td>${cjxw.xm }</td>
								<td>${cjxw.gyjq }</td>
								<td><fmt:formatDate type="date" value="${cjxw.lastModif }" /></td>
								<td>${cjxw.score }</td>
								<td>${cjxw.jhxm }</td>
								<td>${cjxw.status }</td>
								</tr>
							</c:forEach>
				</tbody>
			</table>
			<!-- 分页 -->
					<div id="barcon" class="barcon">
						<div id="barcon1" class="barcon1">
						</div>
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
					<span id="pageSize" style="display: none;"></span>
					<span id="pages" style="display: none;"></span>
					<span id="pageNum" style="display: none;"></span>
		</div>

<!-- 页面内容的js -->
<script type="text/javascript"
	src="<c:url value='/resource/js/pggl/Cjxwgc.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/resource/js/page.js'/>"></script>
<script type="text/javascript">
$(function(){
	goPage(1,10,"cjrcgc");
    });
</script>
</body>
</html>