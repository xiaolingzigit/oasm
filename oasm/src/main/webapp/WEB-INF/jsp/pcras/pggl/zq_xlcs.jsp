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
<div class="layer02">
上传导入数据：<input type="file"  id=""/>
</div>
	<div class="layer02">
		<div class="search_title">筛选条件：</div>

				<div class="search_area">
			<fieldset class="instruct">
				<table class="search_tb">
					<tr>
						<th>监&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;区</th>
						<td><select id="zqxlcs_ss_selected" class="search_tb_select">
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
				</select></td>
						<th>囚&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号</th>
						<td><input type="text" id="zqxlcsqh" class="search_tb_input" /></td>
						<th>罪&nbsp;&nbsp;犯&nbsp;&nbsp;姓&nbsp;&nbsp;名</th>
						<td><input type="text" id="zqxlcsxm" class="search_tb_input" /></td>
						<th>警&nbsp;&nbsp;察&nbsp;&nbsp;姓&nbsp;&nbsp;名</th>
						<td><input type="text" id="zqxlcsjhxm" class="search_tb_input" /></td>
					</tr>
					<tr>
						<th>测&nbsp;&nbsp;试&nbsp;&nbsp;状&nbsp;&nbsp;态</th>
						<td colspan="5" id="zqxlcs_ss_radio"><input type="radio" name="wcqk" value="" id="status_all" checked/> <label for="status_all">全部 </label>
				    <input type="radio" name="wcqk" value="4" id="status_4" /><label for="status_4">已完成</label>
				    <input type="radio" name="wcqk" value="3" id="status_3" /><label for="status_3">未完成</label>
				    <input type="radio" name="wcqk" value="1" id="status_1" /><label for="status_1">未开始</label>
				    <input type="radio" name="wcqk" value="10" id="status_10" /><label for="status_10">已取消</label></td>
						<td><button class="button_submit2" id="zqxlcs_ss_btn">&nbsp;搜&nbsp;&nbsp;索&nbsp;</button></td>
					</tr>
					</table>
			</fieldset>
		</div>
		</div>
				<!--心理测试 -->
				<div id="xlcstab" class="option_table3">
					<table class="content_table" width="100%">
						<tr>
							<th class="base_th" width="5%">序号</th>
							<th class="base_th" width="10%">囚号</th>
							<th class="base_th" width="10%">罪犯姓名</th>
							<th class="base_th" width="10%">监区</th>
							<th class="base_th" width="10%">copa-pi得分</th>
							<th class="base_th" width="10%">scl-90得分</th>
							<th class="base_th" width="10%">专管警察</th>
							<th class="base_th" width="10%">测试状态</th>							
							<th class="base_th" width="10%">操作</th>
						</tr>
						<tr>
							<td>1</td>
							<td>6546545454</td>
							<td>周易</td>
							<td>三监区</td>
                             <td>9</td>
							<td>9</td>
							<td>王峰</td>
							<td>已完成</td>
							<td><a href="#"
								onclick="loadnext3('/oasm/dafxView/zq_xlcsrs')">查看详情</a></td>
						</tr>
						<tr>
							<td>2</td>
							<td>6546545454</td>
							<td>林芝市</td>
							<td>三监区</td>
                                                        <td>无</td>
							<td>无</td>
							<td>王峰</td>
							<td>未完成</td>
							<!-- <td><div class="addbutton2"onclick="loadnext5()">
							前往测试</div>
					        </td> -->
					        <td><a href="#"
								onclick="loadnext3('/oasm/dafxView/rj_xlcsrs')">查看详情</a></td>
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