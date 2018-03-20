<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>专项管理</title>
<!-- 分页样式 -->
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resource/css/page.css'/>">

</head>
<body>
	<!--顽危犯撤销 -->
				<div class="layer02">
		<div class="search_title">筛选条件：</div>
		<div class="search_area">
			<div style="float:left;" class="search_sub1">
				监区: <select>
					<option value="">全监</option>
					<option value="一监区">一监区</option>
					<option value="一监区">二监区</option>
					<option value="三监区">三监区</option>
					<option value="四监区">四监区</option>
					<option value="五监区">五监区</option>
					<option value="六监区">六监区</option>
					<option value="七监区">七监区</option>
					<option value="八监区">八监区</option>
					<option value="九监区">九监区</option>
					<option value="十监区">十监区</option>
					<option value="十二监区">十二监区</option>
					<option value="医院监区">医院监区</option>
					<option value="新犯队">新犯队</option>
					<option value="出监管区">出监管区</option>
					<option value="狱政科">狱政科</option>
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
			<div class="search_sub2">
				<span style="margin-left:20px">危险等级：
				</span><input type="radio" name="wxdj" value="" /> 全部 
				<input type="radio" name="wxdj" value="" /> 极高危险
				<input type="radio" name="wxdj" value="" /> 高度危险
				<input type="radio" name="wxdj" value="" /> 中度危险 
				<input type="radio" name="wxdj" value="" />低度危险
				<span style="margin-left:20px">撤销情况：
				</span><input type="radio" name="wxdj" value="" /> 全部 
				<input type="radio" name="wxdj" value="" /> 未撤销
				<input type="radio" name="wxdj" value="" /> 撤销中
			</div>
		</div>
		</div>
				<!--顽危犯认定 -->
				<div id="zftab" class="option_table3">
					<table class="content_table" width="100%">
								<tr>
									<th class="base_th" width="5%">序号</th>
									<th class="base_th" width="10%">监区</th>
									<th class="base_th" width="10%">囚号</th>
									<th class="base_th" width="10%">罪犯姓名</th>
									<th class="base_th" width="10%">入监时间</th>
									<th class="base_th" width="10%">危险等级</th>
									<th class="base_th" width="10%">危险评分</th>
									<th class="base_th" width="10%">专管警察</th>
									<th class="base_th" width="10%">撤销状态</th>
									<th class="base_th" width="10%">操作</th>
								</tr>
								<tr>
									<td>1</td>
									<td>第十监区</td>
									<td>6546545454</td>
									<td>周伟权</td>
									<td>2017-07-07</td>
									<td>高度危险</td>
									<td>68</td>
									<td>刘瑾言</td>
									<td>未撤销</td>
									<td><div class="addbutton2"onclick="loadnext3('/oasm/zxglView/wwf_undolr')">
							                         撤销</div>
									</td>
								</tr>
								<tr>
									<td>2</td>
									<td>第十监区</td>
									<td>6546545454</td>
									<td>李汝友</td>
									<td>2017-07-07</td>
									<td>高度危险</td>
									<td>68</td>
									<td>刘瑾言</td>
									<td>未撤销</td>
									<td><div class="addbutton2"onclick="loadnext3('/oasm/zxglView/wwf_undolr')">
							                         撤销</div>
									</td>
								</tr>
								<tr>
									<td>1</td>
									<td>第十监区</td>
									<td>6546545454</td>
									<td>周斌</td>
									<td>2017-07-07</td>
									<td>高度危险</td>
									<td>68</td>
									<td>刘瑾言</td>
									<td>撤销中</td>
									<td><a href="#" onclick="loadnext3('/oasm/zxglView/wwf_undors')">查看详情</a>
									</td>
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
				
				</div>
<!-- 页面内容的js -->
<script type="text/javascript"
	src="<c:url value='/resource/js/pggl/pggl.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/resource/js/page.js'/>"></script>
</body>
</html>
