<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>出监结构性访谈</title>
</head>
<body>
	<div class="return_btn">
		<a href="#" onclick="loadnext3('/oasm/dafxView/cj_jgft')"> <<< 返回
		</a>
	</div>
	<div class="rs_table">
		<div id="printcontent">
			<div class="rs_table_title">
				<h1>出监结构性访谈结果表</h1>
			</div>
			<div class="msg_div2">
				<ul class="xx_ul">
					<li class="xx_li01">姓<span>名</span>：
					</li>
					<li class="xx_li02">${cjftzyry.xm }</li>
					<li class="xx_li01">囚<span>号</span>：
					</li>
					<li class="xx_li02">${cjftzyry.qh }</li>
					<li class="xx_li01">录入时间：</li>
					<li class="xx_li02">${ftsj }</li>
					<li class="xx_li01">监<span>区</span>：
					</li>
					<li class="xx_li02">${cjftzyry.gyjq }</li>
					<li class="xx_li01">分监区：</li>
					<li class="xx_li02">无数据</li>
					<li class="xx_li01">专管警察：</li>
					<li class="xx_li02">${cjftjyxx.jhxm }</li>
					<li class="xx_li01">分析结果：</li>
					<li class="xx_li02"></li>
					<li class="xx_li01">得<span>分</span>：
					</li>
					<li class="xx_li02">${ftfs }</li>
				</ul>
			</div>

		 
				<!-- 			<ul>
			  拼接回来的出监结构访谈答题因子
			</ul> -->
				<div class="base_table cs-table">
					<table width="100%">
						<tr>
							<th class="base_th" width="5%">序号</th>
							<th class="base_th" width="10%">题目</th>
							<th class="base_th" width="20%">选项</th>
						</tr>
					</table>
				</div>
				<div class="base_table cs-table"
					style="overflow-x: auto; overflow-y: auto; height: 500px;">
					<table>
						<colgroup>
							<col width="5%">
							<col width="10%">
							<col width="20%">
						</colgroup>
						<tr>
							<td>1</td>
							<td>认罪悔罪</td>
							<td class="lb_td04" style="text-align: left;"><br> <input
								name="question1" type="radio" value="" />服从法院判决，认罪悔罪，民事赔偿及罚金等履行完毕<br>
								<input name="question1" type="radio" value="" />认罪服判，但未履行或部分履行民事赔偿责任及罚金<br>
								<input name="question1" type="radio" value="" />认为判决偏重或其他不恰当的，有申诉或控告的意愿<br>
								<input name="question1" type="radio" value="" />不认罪、服判，服刑期间有上访缠诉、申诉控告等行为
							
						</tr>
						<tr>
							<td>2</td>
							<td>婚姻状况</td>
							<td class="lb_td04" style="text-align: left;"><br> <input
								name="question6" type="radio" value="" />未婚或已婚且关系稳定 <br> <input
								name="question6" type="radio" value="" />已婚，婚姻关系不太稳定 <br>
								<input name="question6" type="radio" value="" />离异或丧偶</td>
						</tr>
						<tr>
							<td>3</td>
							<td>家庭经济</td>
							<td class="lb_td04" style="text-align: left;"><br> <input
								name="question7" type="radio" value="" />好 <br> <input
								name="question7" type="radio" value="" />较好 <br> <input
								name="question7" type="radio" value="" />一般 <br> <input
								name="question7" type="radio" value="" />较差 <br> <input
								name="question7" type="radio" value="" />差</td>
						</tr>
						<tr>
							<td>4</td>
							<td>亲情关系</td>
							<td class="lb_td04" style="text-align: left;"><br> <input
								name="question8" type="radio" value="" />亲情关系稳定 <br> <input
								name="question8" type="radio" value="" />亲情关系一般 <br> <input
								name="question8" type="radio" value="" />亲情关系较差 <br> <input
								name="question8" type="radio" value="" />三无人员</td>
						</tr>
						<tr>
							<td>5</td>
							<td>就业前景情况</td>
							<td class="lb_td04" style="text-align: left;"><br> <input
								name="question12" type="radio" value="" />有就业计划，完全有把握就业 <br>
								<input name="question12" type="radio" value="" />有就业计划，基本有把握就业，预期收入基本满足需要<br>
								<input name="question12" type="radio" value="" />无就业计划，希望找到工作，但没有把握<br>
								<input name="question12" type="radio" value="" />刑满释放不能找到工作或根本不想找到工作</td>
						</tr>
						<tr>
							<td>6</td>
							<td>社会环境及关系</td>
							<td class="lb_td04" style="text-align: left;"><br> <input
								name="question13" type="checkbox" value="" />社会环境及社会关系好，对其安置就业有帮助的<br>
								<input name="question13" type="checkbox" value="" />社会环境及社会关系一般，对其安置就业有较大影响的<br>
								<input name="question13" type="checkbox" value="" />社会环境及社会关系很差，不利其安置就业</td>
						</tr>
					</table>
				</div>
				<div style="text-align: center; padding-bottom:10px">
					<button style="font-size: 20px;">下载</button>
					<button style="font-size: 20px;">打印</button>
				</div>
			  
		</div>
		<script type="text/javascript"
			src="<c:url value='/resource/js/printpage.js'/>"></script>
</body>
</html>