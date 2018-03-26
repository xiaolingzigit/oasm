<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>罪犯信息</title>
</head>
<body>
   <!--评估报告生成及查询-->
	<div id="" class="sub-block">
		<!-- 定位栏-->
		<div class="location">
			<div class="location_left">
				<i><font color="#ffffff"><strong>您现在的位置</strong></font></i>
			</div>
			<div class="location_right">
				<strong>&nbsp;&nbsp;罪犯信息 >><font color="#ff3300">罪犯信息查询</font></strong>
			</div>
		</div>
		<!-- 功能子块-->
		<div class="main_content">
			<div id="basecontent" class="main_content_base">
				<!--罪犯信息查询-->
			<div class="layer02">
				<div class="search_title">筛选条件：</div>
		 		<div class="search_area">
				<fieldset class="instruct">
				<table class="search_tb">
				<colgroup>
				<col width="10%">
				<col width="10%">
				<col width="10%">
				<col width="10%">
				<col width="10%">
				<col width="10%">
				<col width="10%">
				<col width="10%">
				<col width="10%">
				<col width="10%">
				</colgroup>
					<tr>
						<th>监&nbsp;区</th>
						<td><select id="criminal_jq" class="search_tb_select">
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
						<th>囚&nbsp;号</th>
						<td><input type="text" id="criminal_qh" class="search_tb_input" /></td>
						<th>罪&nbsp;犯&nbsp;姓&nbsp;名</th>
						<td><input type="text" id="criminal_xm" class="search_tb_input" /></td>
						<th>入&nbsp;监&nbsp;时&nbsp;间</th>
						<td><input type="text" class="select_time search_tb_input"
							id="criminal_enterTime" maxLength="10"
							onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" /></td>
						<th>警&nbsp;察&nbsp;姓&nbsp;名</th>
						<td><input type="text" id="police_xm" class="search_tb_input" /></td>
						<td><button class="button_submit2" id="criminal_ss_btn">搜&nbsp;索</button></td>
					</tr>
					<!-- <tr>
				    	<th>危&nbsp;&nbsp;险&nbsp;&nbsp;等&nbsp;&nbsp;级</th>
						<td colspan="4" id="criminal_wxdj">
					<input type="radio" name="wxdj" value="" id="wxdj_all" checked/> <label for="wxdj_all">全部 </label>
				    <input type="radio" name="wxdj" value="极高度危险" id="wxdj_j" /><label for="wxdj_j">极高度危险</label>
				    <input type="radio" name="wxdj" value="高度危险" id="wxdj_g" /><label for="wxdj_g">高度危险</label>
				    <input type="radio" name="wxdj" value="中度危险" id="wxdj_z" /><label for="wxdj_z">中度危险</label>
				    <input type="radio" name="wxdj" value="低度危险" id="wxdj_d" /><label for="wxdj_d">低度危险</label>
				    </td>
				    	<th>危&nbsp;&nbsp;险&nbsp;&nbsp;类&nbsp;&nbsp;型</th>
						<td colspan="3" id="criminal_wxlx">
					<input type="radio" name="wxlx" value="" id="wxlx_all" checked/> <label for="wxlx_all">全部 </label>
				    <input type="radio" name="wxlx" value="4" id="wxlx_zs" /><label for="wxlx_zs">自杀</label>
				    <input type="radio" name="wxlx" value="3" id="wxlx_xx" /><label for="wxlx_xx">行凶</label>
				    <input type="radio" name="wxlx" value="1" id="wxlx_tt" /><label for="wxlx_tt">脱逃</label>
				    <input type="radio" name="wxlx" value="10" id="wxlx_zf" /><label for="wxlx_zf">再犯罪</label></td>
				    
						<td><button class="button_submit2" id="criminal_ss_btn">&nbsp;搜&nbsp;&nbsp;索&nbsp;</button></td>
					</tr> -->
					</table>
			</fieldset>

		</div>
		</div>
						<!-- table -->
						<br> <br>
						<div class="content_table">
							<table width="100%">
								<tr>
									<th class="base_th" width="5%">序号</th>
									<th class="base_th" width="10%">监区</th>
									<th class="base_th" width="10%">囚号</th>
									<th class="base_th" width="10%">罪犯姓名</th>
									<th class="base_th" width="10%">入监时间</th>
									<!-- <th class="base_th" width="10%">危险等级</th>
									<th class="base_th" width="10%">危险评分</th> -->
									<th class="base_th" width="10%">详细个人信息</th>
								</tr>
						<tbody id="criminalList">
						<c:forEach items="${jbxxList}" var="zf" varStatus="status">
								<tr>
									<td>${status.count }</td>
								 	<td>${zf.jq }</td>
									<td>${zf.qh }</td>
									<td>${zf.xm }</td>
									<td><fmt:formatDate type="date" value="${zf.bgxxxx.rjrq }" /></td>
								
									<td><a href ="#"  onclick="loadnext3('/oasm/jygzView/zfinfo?qh=${zf.qh }')">点击进入</a></td>
								</tr>
							</c:forEach>
							<!-- ajax 入监集体结构性访谈数据 -->
							
						</tbody>
						</table>
						<!-- TODO -->
			<div id="barcon" class="barcon">
				<span id="barcon1" class="barcon1"></span>
					<span id="barcon2" class="barcon2">
						<ul class="paging_ul">
							<li><a id="firstPage">首页</a></li>
								<li><a id="prePage">上一页</a></li>
								<li><a id="nextPage">下一页</a></li>
								<li><a id="lastPage">尾页</a></li>
								<li><select id="jumpWhere"
									style="width: 50px; height: 30px;"></select></li>
								<li><a id="jumpPage" onclick="jumpPage()">跳转</a></li>
						</ul>
					</span>
					<span id="pageSize" style="display: none;"></span>
					<span id="pages" style="display: none;"></span>
					<span id="pageNum" style="display: none;"></span>
					</div>
				</div>
				</div>
				</div>
<!-- 页面内容的js -->
<script type="text/javascript"
		src="<c:url value='/resource/js/jquery-1.7.2.min.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/resource/js/jzxm/crimInfo.js'/>"></script>
	<script type="text/javascript"
		src="<c:url value='/resource/js/jzxm/criminallist.js'/>"></script>
	<script type="text/javascript">
	$(function(){
			$("#sele").change(function(){
				showPage($(this).val());
			});
			 goPage(1,10,'criminalList');
	});
      
   /*    function showZfxxxx(url){
      	$("#basecontent").load(url);
      } */
</script>

</body>
</html>