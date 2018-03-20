<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>评估报告及生成</title>
</head>
<body>
			<!--评估报告生成-->
			<div id="bgsctab" class="option_table3">
<div class="layer02">
		<div class="search_title">筛选条件：</div>
					<div class="search_area">
			<fieldset class="instruct">
				<table class="search_tb">
					<tr>
						<th>监&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;区</th>
						<td><select id="zqpgbg_ss_selected" class="search_tb_select">
					<option value="">全监</option>
					<option value="一监区">一监区</option>
					<option value="二监区">二监区</option>
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
						<td><input type="text" id="zqbgqh" class="search_tb_input" /></td>
						<th>罪&nbsp;&nbsp;犯&nbsp;&nbsp;姓&nbsp;&nbsp;名</th>
						<td><input type="text" id="zqbgxm" class="search_tb_input" /></td>
						<th>警&nbsp;&nbsp;察&nbsp;&nbsp;姓&nbsp;&nbsp;名</th>
						<td><input type="text" id="zqbgjhxm" class="search_tb_input" /></td>
					</tr>
					<tr>
						<th>评&nbsp;&nbsp;估&nbsp;&nbsp;状&nbsp;&nbsp;态</th>
						<td colspan="2" id="zqbg_ss_statRadio"><input type="radio" name="wcqk" value="" id="status_all" checked/> <label for="status_all">全部 </label>
				    <input type="radio" name="wcqk" value="4" id="status_4" /><label for="status_4">已完成</label>
				    <input type="radio" name="wcqk" value="3" id="status_3" /><label for="status_3">未完成</label>
				    <input type="radio" name="wcqk" value="1" id="status_1" /><label for="status_1">未开始</label>
				    <input type="radio" name="wcqk" value="10" id="status_10" /><label for="status_10">已取消</label></td>
				    	<th>危&nbsp;&nbsp;险&nbsp;&nbsp;等&nbsp;&nbsp;级</th>
						<td colspan="2" id="zqbg_ss_radio">
					<input type="radio" name="wxdj" value="" id="wxdj_all" checked/> <label for="wxdj_all">全部 </label>
				    <input type="radio" name="wxdj" value="极高度危险" id="wxdj_j" /><label for="wxdj_j">极高度危险</label>
				    <input type="radio" name="wxdj" value="高度危险" id="wxdj_g" /><label for="wxdj_g">高度危险</label>
				    <input type="radio" name="wxdj" value="中度危险" id="wxdj_z" /><label for="wxdj_z">中度危险</label>
				    <input type="radio" name="wxdj" value="低度危险" id="wxdj_d" /><label for="wxdj_d">低度危险</label>
				    </td>
						<td><button class="button_submit2" id="zqbg_ss_btn">&nbsp;搜&nbsp;&nbsp;索&nbsp;</button></td>
					</tr>
					</table>
			</fieldset>
		</div>
		</div>
				<div class="content_table">
					<table width="100%">
					  <thead>
					    <tr>
						<!--<th class="base_th" width="5%"></th> -->
							<th class="base_th" width="5%">行号</th>
							<th class="base_th" width="8%">囚号</th>
							<th class="base_th" width="6%">罪犯姓名</th>
							<th class="base_th" width="6%">监区</th>
							<th class="base_th" width="6%">评估总分</th>
							<th class="base_th" width="8%">危险等级</th>
							<th class="base_th" width="8%">完成期限</th>
							<th class="base_th" width="7%">最后修改时间</th>
<!-- 							<th class="base_th" width="7%">任务类型</th> -->
							<th class="base_th" width="7%">专管警察</th>
							<th class="base_th" width="7%">协教警察</th>
							<th class="base_th" width="7%">评估状态</th>
							<th class="base_th" width="9%">操作</th>
						</tr>
					  </thead>
					  <tbody id="zqbglist">
							<!-- 中期报告列表在pgbglist.js中拼接 -->
					  </tbody>
					</table>
				</div>

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
						<span id="pageSize" style="display: none;"></span>
					    <span id="pages" style="display: none;"></span>
					    <span id="pageNum" style="display: none;"></span>
					</div>
			</div>
<script type="text/javascript" src="<c:url value='/resource/js/pggl/zqpgbglist.js'/>"></script>
<script type="text/javascript">
$(function(){
	goPage(1,10,'zqpgbg');
    });
</script>
<script type="text/javascript" src="<c:url value='/resource/js/pggl/pgbg.js'/>"></script>
</body>
</html>