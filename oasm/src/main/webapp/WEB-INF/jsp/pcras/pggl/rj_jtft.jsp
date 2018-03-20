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
		<div class="search_title">筛选条件：</div>
 		<div class="search_area">
			<fieldset class="instruct">
				<table class="search_tb">
					<tr>
						<th>监&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;区</th>
						<td><select id="rjjtftjq" class="search_tb_select">
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
						<td><input type="text" id="vjtftqh" class="search_tb_input" /></td>
						<th>罪&nbsp;&nbsp;犯&nbsp;&nbsp;姓&nbsp;&nbsp;名</th>
						<td><input type="text" id="vjtftxm" class="search_tb_input" /></td>
						<th>警&nbsp;&nbsp;察&nbsp;&nbsp;姓&nbsp;&nbsp;名</th>
						<td><input type="text" id="vjtftjcxm" class="search_tb_input" /></td>
					</tr>
					<tr>
						<th>数&nbsp;&nbsp;据&nbsp;&nbsp;状&nbsp;&nbsp;态</th>
						<td colspan="5" id="rjjtft_ss_searchRadio"><input type="radio" name="wcqk" value="" id="status_all" checked/> <label for="status_all">全部 </label>
				    <input type="radio" name="wcqk" value="4" id="status_4" /><label for="status_4">已导入</label>
				    <input type="radio" name="wcqk" value="3" id="status_3" /><label for="status_3">未导入</label>
                       </td>
						<td><button class="button_submit2" id="rjjtft_ss_btn">&nbsp;搜&nbsp;&nbsp;索&nbsp;</button></td>
<!-- 						<td colspan="5" id="vjtft_searchRadio">
							<input type="radio" name="wcqk" value="" id="status_all" checked/> <label for="status_all">全部 </label>
						    <input type="radio" name="wcqk" value="4" id="status_4" /><label for="status_4">已完成</label>
						    <input type="radio" name="wcqk" value="3" id="status_3" /><label for="status_3">未完成</label>
						    <input type="radio" name="wcqk" value="1" id="status_1" /><label for="status_1">未完成</label>
						    <input type="radio" name="wcqk" value="10" id="status_10" /><label for="status_10">已取消</label></td>
						<td><button class="button_submit2" id="vjtft_ss_btn">&nbsp;搜&nbsp;&nbsp;索&nbsp;</button></td> -->
					</tr>
					</table>
			</fieldset>
		</div>
		</div>
				<!--结构性访谈 -->
				<div id="jgfttab" class="option_table3">
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
						<tr>
							<th class="base_th">序号</th>
							<th class="base_th">囚号</th>
							<th class="base_th">罪犯姓名</th>
							<th class="base_th">监区</th>
							<th class="base_th">导入时间</th>
							<th class="base_th">分析得分</th>
							<th class="base_th">专管警察</th>
							<th class="base_th">数据状态</th>							
							<th class="base_th">操作</th>
						</tr>
						<tbody id="rjjtft">
							<!-- ajax 入监集体结构性访谈数据 -->
						</tbody>
<!-- 				<tbody> -->
<!-- 				<tr> -->
<!-- 					<td>1</td> -->
<!-- 					<td>4413020056</td> -->
<!-- 					<td>杨国昌</td> -->
<!-- 					<td>新犯队</td> -->
<!-- 					<td>2017-8-17</td> -->
<!-- 					<td>17</td> -->
<!-- 					<td>王泉澍</td> -->
<!-- 					<td>已访谈</td> -->
<!-- 					<td><a href='#' -->
<!-- 						onclick='loadnext3("/oasm/dafxView/rj_jtftrs")'>查看详情</a></td> -->
<!-- 					</td> -->
<!-- 				</tr> -->
<!-- 				<tr> -->
<!-- 					<td>2</td> -->
<!-- 					<td>4409042787</td> -->
<!-- 					<td>罗卓良</td> -->
<!-- 					<td>新犯队</td> -->
<!-- 					<td></td> -->
<!-- 					<td></td> -->
<!-- 					<td>王泉澍</td> -->
<!-- 					<td>未访谈</td> -->
<!-- 					<td><div class='addbutton2' -->
<!-- 							onclick='loadDafxlb("/oasm/dafxView/rj_jtftlb")'>开始访谈</div></td> -->
<!-- 					</td> -->
<!-- 				</tr> -->
<!-- 				<tr> -->
<!-- 					<td>3</td> -->
<!-- 					<td>4413020920</td> -->
<!-- 					<td>蔡育文</td> -->
<!-- 					<td>新犯队</td> -->
<!-- 					<td>2017-8-17</td> -->
<!-- 					<td>17</td> -->
<!-- 					<td>王泉澍</td> -->
<!-- 					<td>已访谈</td> -->
<!-- 					<td><a href='#' onclick='loadnext3("/oasm/dafxView/rj_jtftrs")'>查看详情</a></td> -->
<!-- 				</tr> -->
<!-- 				<tr> -->
<!-- 					<td>4</td> -->
<!-- 					<td>4413021534</td> -->
<!-- 					<td>温瑞强</td> -->
<!-- 					<td>新犯队</td> -->
<!-- 					<td></td> -->
<!-- 					<td></td> -->
<!-- 					<td>王泉澍</td> -->
<!-- 					<td>未访谈</td> -->
<!-- 					<td><div class='addbutton2' onclick='loadDafxlb("/oasm/dafxView/rj_jtftlb")'>开始访谈</div></td> -->
<!-- 				</tr> -->
<!-- 			</tbody> -->
						</table>
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
	src="<c:url value='/resource/js/pggl/pggl.js'/>"></script>
	<script type="text/javascript"
		src="<c:url value='/resource/js/pggl/rjjtftlist.js'/>"></script>
	<script type="text/javascript">
       $(function(){
	      goPage(1,10,'rjjtft');
      });
</script>

</body>
</html>