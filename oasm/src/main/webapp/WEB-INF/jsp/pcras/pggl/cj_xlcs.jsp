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
						<td><select id="cjxlcs_ss_selected" class="search_tb_select">
						<option value="十监区">十监区</option>
					<option value="出监管区">出监管区</option>
				</select></td>
						<th>囚&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号</th>
						<td><input type="text" id="cjxlcsqh" class="search_tb_input" /></td>
						<th>罪&nbsp;&nbsp;犯&nbsp;&nbsp;姓&nbsp;&nbsp;名</th>
						<td><input type="text" id="cjxlcsxm" class="search_tb_input" /></td>
						<th>警&nbsp;&nbsp;察&nbsp;&nbsp;姓&nbsp;&nbsp;名</th>
						<td><input type="text" id="cjxlcsjhxm" class="search_tb_input" /></td>
					</tr>
					<tr>
						<th>测&nbsp;&nbsp;试&nbsp;&nbsp;状&nbsp;&nbsp;态</th>
						<td colspan="5" id="cjxlcs_ss_radio"><input type="radio" name="wcqk" value="" id="status_all" checked/> <label for="status_all">全部 </label>
				    <input type="radio" name="wcqk" value="4" id="status_4" /><label for="status_4">已完成</label>
				    <input type="radio" name="wcqk" value="3" id="status_3" /><label for="status_3">未完成</label>
				    <input type="radio" name="wcqk" value="1" id="status_1" /><label for="status_1">未开始</label>
				    <input type="radio" name="wcqk" value="10" id="status_10" /><label for="status_10">已取消</label></td>
						<td><button class="button_submit2" id="cjxlcs_ss_btn">&nbsp;搜&nbsp;&nbsp;索&nbsp;</button></td>
					</tr>
					</table>
			</fieldset>
		</div>
		</div>
				<!--心理测试 -->
				<div id="xlcstab" class="option_table3">
					<table class="content_table" width="100%">
					<tbody id="cjxlcsList">
						<tr>
						    <th><input type="checkbox" class="common_checkbox" id="selectAll"></th>
							<th class="base_th" width="5%">序号</th>
							<th class="base_th" width="10%">囚号</th>
							<th class="base_th" width="10%">罪犯姓名</th>
							<th class="base_th" width="10%">监区</th>
							<th class="base_th" width="10%">社会适应得分</th>
							<th class="base_th" width="10%">copa-pi得分</th>
							<th class="base_th" width="10%">scl-90得分</th>
							<th class="base_th" width="10%">专管警察</th>
							<th class="base_th" width="10%">测试状态</th>							
							<th class="base_th" width="10%">操作</th>
						</tr>
						<tr>
						    <td><input type="checkbox" class="common_checkbox" id="" value=""/></td>					
							<td>1</td>
							<td>6546545454</td>
							<td>周易</td>
							<td>三监区</td>
                            <td>9</td>
							<td>9</td>
							<td>9</td>
							<td>王峰</td>
							<td>已完成</td>
							<td><a href="#"
								onclick="loadnext3('/oasm/dafxView/cj_xlcsrs')">查看详情</a></td>
						</tr>
						<tr>
							<td><input type="checkbox" class="common_checkbox" id="" value=""/></td>					
							<td>2</td>
							<td>6546545454</td>
							<td>林芝市</td>
							<td>三监区</td>
                                                        <td>无</td>
							<td>无</td>
							<td>无</td>
							<td>王峰</td>
							<td>未完成</td>
							<!-- <td><div class="addbutton2"onclick="loadnext5()">
							前往测试</div>
					        </td> -->
					        <td><a href="#"
								onclick="loadnext3('/oasm/dafxView/rj_xlcsrs')">查看详情</a></td>
					        </tr>
					        </tbody>
						</table>
					<div id="barcon" class="barcon">
						<div id="barcon1" class="barcon1">
						共2条记录&nbsp;当前1/1页
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
	src="<c:url value='/resource/js/pggl/pggl.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/resource/js/page.js'/>"></script>
	<script type="text/javascript">
			$("#selectAll").click(function() {
			//alert(this.checked);  
			if ($(this).is(':checked')) {
				$('#cjxlcsList tr').each(function() {
					$(this).find("input").prop("checked", "checked");
				});
			} else {
				$('#cjxlcsList tr').each(function() {
					$(this).find("input").prop("checked", "");
				});
			}

		});
    </script>
</body>
</html>