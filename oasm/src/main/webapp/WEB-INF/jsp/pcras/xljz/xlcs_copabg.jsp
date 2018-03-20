<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>COPA-PI量表</title>

</head>
<body>
	<div class="return_btn">
		<a href="#" onclick="goBack()">&laquo;&laquo;返回</a>
	</div>
	<div class="rs_table">
	<div id="printcontent">
	
		<div class="rs_table_title">
			<h1>罪犯个性分测验(1.0正式版)测试报告</h1>
		</div>
		<div class="msg_div3">
			<table>
				<tr>
					<td class="xx_td05">姓<span>名</span>：
					</td>
					<td class="xx_td06">韩方奕</td>
					<td class="xx_td05">囚<span>号</span>：
					</td>
					<td class="xx_td06 xx_number"
						onclick="getCrimDetails()">1234567890</td>
					<td class="xx_td05">监<span>区</span>：
					</td>
					<td class="xx_td06">三监区</td>
					<td class="xx_td05">分监区：</td>
					<td class="xx_td06">分监区1</td>
				</tr>
				<tr>
					<td class="xx_td05">年<span>龄</span>：
					</td>
					<td class="xx_td06">51</td>
					<td class="xx_td05">性<span>别</span>：
					</td>
					<td class="xx_td06">男</td>
					<td class="xx_td05">婚姻状况：</td>
					<td class="xx_td06">已婚</td>
					<td class="xx_td05">文化程度：</td>
					<td class="xx_td06">大学</td>
				</tr>
				<tr>
					<td class="xx_td05">罪<span>名</span>：
					</td>
					<td colspan="3" class="xx_td06">合同诈骗、诈骗、合同诈骗</td>
					<td class="xx_td05">剩余刑期：</td>
					<td colspan="3" class="xx_td06">13年00个月06天</td>
				</tr>
				<tr>
					<td>测试时间：</td>
					<td colspan="3" class="xx_td06">2017/11/6</td>
					<td>测试得分：</td>
					<td colspan="3" class="xx_td06">88</td>
				</tr>
			</table>
		</div>
		<div class="header_table">
			<h3>测试结果</h3>
		</div>
		<div class="xlcs_dimension_table">
			<table id='copaDimTable'>
				<tr>
					<th>维度名称</th>
					<th>原始分</th>
					<th>标准分</th>
					<th>T&nbsp;值</th>
					<th>维度名称</th>
					<th>原始分</th>
					<th>标准分</th>
					<th>T&nbsp;值</th>
				</tr>
				<tr>
					<td class="xlcs_td01 "><span class="xlcs_dimension01">PD1</span><span
						class="xlcs_dimension02">外倾</span></td>
					<td>4</td>
					<td>45</td>
					<td class="xlcs_td01"><span class="xlcs_dimension01">PD2</span><span
						class="xlcs_dimension02">聪敏</span></td>
					<td>7</td>
					<td>59</td>
				</tr>
				<tr>
					<td class="xlcs_td01"><span class="xlcs_dimension01">PD3</span><span
						class="xlcs_dimension02">同情</span></td>
					<td>6</td>
					<td>41</td>
					<td class="xlcs_td01"><span class="xlcs_dimension01">PD4</span><span
						class="xlcs_dimension02">从属</span></td>
					<td>0</td>
					<td>32</td>
				</tr>
				<tr>
					<td class="xlcs_td01"><span class="xlcs_dimension01">PD5</span><span
						class="xlcs_dimension02">波动</span></td>
					<td>0</td>
					<td>34</td>
					<td class="xlcs_td01"><span class="xlcs_dimension01">PD6</span><span
						class="xlcs_dimension02">冲动</span></td>
					<td>0</td>
					<td>33</td>
				</tr>
				<tr>
					<td class="xlcs_td01"><span class="xlcs_dimension01">PD7</span><span
						class="xlcs_dimension02">戒备</span></td>
					<td>0</td>
					<td>34</td>
					<td class="xlcs_td01"><span class="xlcs_dimension01">PD8</span><span
						class="xlcs_dimension02">自卑</span></td>
					<td>0</td>
					<td>36</td>
				</tr>
				<tr>
					<td class="xlcs_td01"><span class="xlcs_dimension01">PD9</span><span
						class="xlcs_dimension02">焦虑</span></td>
					<td>0</td>
					<td>33</td>
					<td class="xlcs_td01"><span class="xlcs_dimension01">PD10</span><span
						class="xlcs_dimension02">暴力倾向</span></td>
					<td>0</td>
					<td>37</td>
				</tr>
				<tr>
					<td class="xlcs_td01"><span class="xlcs_dimension01">PD11</span><span
						class="xlcs_dimension02">变态心理</span></td>
					<td>0</td>
					<td>41</td>
					<td class="xlcs_td01"><span class="xlcs_dimension01">PD12</span><span
						class="xlcs_dimension02">犯罪思维</span></td>
					<td>1</td>
					<td>38</td>
				</tr>
				<tr>
					<td class="xlcs_td01"><span class="xlcs_dimension01">L</span><span
						class="xlcs_dimension02">说谎指标</span></td>
					<td>1</td>
					<td>1</td>
					<td class="xlcs_td01"><span class="xlcs_dimension01">S</span><span
						class="xlcs_dimension02">认真指标</span></td>
					<td>0</td>
					<td>0</td>
				</tr>
			</table>
		</div>
		<div class="header_table">
			<h3>结果分析</h3>
		</div>
		<div class="xlcs_dimension_fx3" id='copaResult'>无分析结果...</div>
		<div class="header_table">
			<h3>对个人建议</h3>
		</div>
		<div class="xlcs_dimension_fx2" id='toPerson'>无内容...</div>
		<div class="header_table">
			<h3>教育建议</h3>
		</div>
		<div class="xlcs_dimension_fx2" id='eduSuggest'>无内容...</div>
		<a href="#" onclick="reviewCopaTest()" class="lbrs_link">查看答题记录>>></a>
</div>
		<div class="end_of_paper">
			<button>下载</button>
			<button onClick="printdiv('printcontent')">打印</button>
		</div>
	</div>
<script type="text/javascript" src="<c:url value='/resource/js/printpage.js'/>"></script>


	<script type="text/javascript">
		$(document).ready(function() {

			var basicInfo = listArr[currIdx];
			//设置头部基本信息
			$("#crimName").html(basicInfo.crimName);
			$("#crimNo").html(basicInfo.crimNo);
			$("#testTime").html(formatDate(basicInfo.lastModif, 'yyyy-MM-dd'));
			$("#prison").html(basicInfo.prisonName);
			$("#subPrison").html(basicInfo.subPrisonName);

			//获取做题记录并恢复
			getTestNote(basicInfo.taskId, function(data) {
				if (isEmpty(data)) {
					return;
				}

				var jsonData = jQuery.parseJSON(data).result;

				var map = jsonData.dimResultMap;
				if (map != null) {
					$("#copaDimTable tr:not(:first)").remove();
					$("#copaResult").empty();
					$("#toPerson").empty();
					$("#eduSuggest").empty();
				}

				copaLineCounter = 0;
				$.each(map, function(key, jsonLine) {
					appendCopaLine(jsonLine);
					addCopaAnlysis(jsonLine);
				});
			});

		});

		var row;
		var copaLineCounter = 0;
		function appendCopaLine(line) {
			if (line != null) {
				if (/说谎指标|认真指标/.test(line.dimName)) {
					row += "<td class='xlcs_td01'><span class='xlcs_dimension01'>"
							+ line.dim
							+ "</span><span class='xlcs_dimension02'>&nbsp;["
							+ line.dimName
							+ "]</span></td><td>"
							+ line.total
							+ "</td><td>-</td><td>-</td>";
				} else {
					row += "<td class='xlcs_td01'><span class='xlcs_dimension01'>"
							+ line.dim
							+ "</span><span class='xlcs_dimension02'>&nbsp;["
							+ line.dimName
							+ "]</span></td><td>"
							+ line.total
							+ "</td><td>"
							+ line.zVal
							+ "</td><td>"
							+ line.tVal
							+ "</td>";
				}
			}

			if (copaLineCounter++ % 2 != 0) {
				$("#copaDimTable").append($('<tr/>').html(row));
				row = "";
			}
		}

		function addCopaAnlysis(data) {
			if (data == null) {
				return;
			}
			var exp = data.levelExpr;

			var line = "<div class='xlcs_fx'><p><b><span>" + data.dim
					+ "&nbsp;" + data.dimName + "</span>：</b><span>"
					+ exp.level + "。" + exp.explain + "</p></div>";

			$("#copaResult").append($('<div class="xlcs_fx" />').html(line));

			if (exp.eval != null && exp.eval.trim().length > 0) {
				$("#toPerson").append(
						$('<p />').html("&hearts;&nbsp;&nbsp;" + exp.eval));
			}

			if (exp.suggest != null && exp.suggest.trim().length > 0) {
				$("#eduSuggest").append(
						$('<p />').html("<b>♦</b>&nbsp;&nbsp;" + exp.suggest));
			}

		}
	</script>
</body>

</html>