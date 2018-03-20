<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>SCL-90量表</title>
</head>
<body>
	<div class="return_btn">
		<a href="#" onclick="goBack()">&laquo;&laquo;返回</a>
	</div>
	<div id="printcontent">
	<div class="rs_table">
		<div class="rs_table_title">
			<h1>90项症状清单测试报告</h1>
		</div>
		<div class="msg_div3">
			<table>
				<tr>
					<td class="xx_td05">姓<span>名</span>：
					</td>
					<td class="xx_td06" id='crimName'></td>
					<td class="xx_td05">囚<span>号</span>：
					</td>
					<td class="xx_td06 xx_number" id='crimNo' onclick="getCrimDetails()"></td>
					<td class="xx_td05">监<span>区</span>：
					</td>
					<td class="xx_td06" id='prison'></td>
					<td class="xx_td05">分监区：</td>
					<td class="xx_td06" id='subPrison'></td>
				</tr>
				<tr>
					<td class="xx_td05">年<span>龄</span>：
					</td>
					<td class="xx_td06" id='age'></td>
					<td class="xx_td05">性<span>别</span>：
					</td>
					<td class="xx_td06" id='gender'>男</td>
					<td class="xx_td05">婚姻状况：</td>
					<td class="xx_td06" id='maritalStatus'></td>
					<td class="xx_td05">文化程度：</td>
					<td class="xx_td06" id='eduDegree'></td>
				</tr>
				<tr>
					<td class="xx_td05">罪<span>名</span>：
					</td>
					<td colspan="3" class="xx_td06" id='charge'></td>
					<td class="xx_td05">剩余刑期：</td>
					<td colspan="3" class="xx_td06" id='remaining'></td>
				</tr>
				<tr>
					<td>测试时间：</td>
					<td colspan="3" class="xx_td06" id='testTime'></td>
				</tr>
			</table>
		</div>
		<div class="header_table">
			<h3>测试结果</h3>
		</div>
		<div class="xlcs_dimension_table">
			<table id='scl90FactorTable'>
				<tr>
					<th>维度名称</th>
					<th>平均分</th>
					<th>标准分</th>
					<th>参考诊断</th>
					<th>均分±标准差</th>
				</tr>
				<tbody>
					<tr>
						<td class="xlcs_td01 ">总分</td>
						<td>160</td>
						<td>/</td>
						<td>/</td>
						<td>129.96±38.76</td>
					</tr>
					<tr>
						<td class="xlcs_td01 ">总均分</td>
						<td>1.78</td>
						<td>/</td>
						<td>/</td>
						<td>1.44±0.43</td>
					</tr>
					<tr>
						<td class="xlcs_td01 ">阴性项目数</td>
						<td>43</td>
						<td>/</td>
						<td>/</td>
						<td>24.92±18.41</td>
					</tr>
					<tr>
						<td class="xlcs_td01 ">阳性项目数</td>
						<td>47</td>
						<td>/</td>
						<td>/</td>
						<td>65.08±18.33</td>
					</tr>
					<tr>
						<td class="xlcs_td01 ">阳性症状均分</td>
						<td>2.49</td>
						<td>/</td>
						<td>/</td>
						<td>2.60±0.59</td>
					</tr>
					<tr>
						<td class="xlcs_td01 ">躯体化</td>
						<td>26</td>
						<td>2.17</td>
						<td>轻</td>
						<td>1.37±0.48</td>
					</tr>
					<tr>
						<td class="xlcs_td01 ">强迫状态</td>
						<td>21</td>
						<td>2.10</td>
						<td>轻</td>
						<td>1.62±0.58</td>
					</tr>
					<tr>
						<td class="xlcs_td01 ">人际关系敏感</td>
						<td>16</td>
						<td>1.78</td>
						<td>轻</td>
						<td>1.65±0.51</td>
					</tr>
					<tr>
						<td class="xlcs_td01 ">抑郁</td>
						<td>26</td>
						<td>2.00</td>
						<td>轻</td>
						<td>1.50±0.59</td>
					</tr>
					<tr>
						<td class="xlcs_td01 ">焦虑</td>
						<td>14</td>
						<td>1.40</td>
						<td>无</td>
						<td>1.39±0.43</td>
					</tr>
					<tr>
						<td class="xlcs_td01 ">敌对</td>
						<td>8</td>
						<td>1.33</td>
						<td>无</td>
						<td>1.48±0.56</td>
					</tr>
					<tr>
						<td class="xlcs_td01 ">恐怖</td>
						<td>8</td>
						<td>1.14</td>
						<td>无</td>
						<td>1.23±0.41</td>
					</tr>
					<tr>
						<td class="xlcs_td01 ">偏执</td>
						<td>8</td>
						<td>1.33</td>
						<td>无</td>
						<td>1.43±0.57</td>
					</tr>
					<tr>
						<td class="xlcs_td01 ">精神病性</td>
						<td>17</td>
						<td>1.70</td>
						<td>轻</td>
						<td>1.29±0.42</td>
					</tr>
					<tr>
						<td class="xlcs_td01 ">其它</td>
						<td>16</td>
						<td>2.29</td>
						<td>轻</td>
						<td></td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="header_table">
			<h3>结果分析</h3>
		</div>
		<div class="xlcs_dimension_fx2" id='result'>无内容...</div>
		<a  href="#"  onclick="reviewScl90test()"
			class="lbrs_link">查看答题记录>>></a>
</div>
		<div class="end_of_paper">
			<button>下载</button>
			<button onClick="printdiv('printcontent')">打印</button>
		</div>
	</div>
<script type="text/javascript" src="<c:url value='/resource/js/printpage.js'/>"></script>

</body>

<script type="text/javascript">
	$(document).ready(
			function() {

				$("#scl90FactorTable tr:not(:first)").remove();
				$("#result").empty();

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

					appendLine("总分", jsonData.total, "-", "-", "-");
					appendLine("总均分", jsonData.gpa, "-", "-", "-");
					appendLine("阴性项目数",
							jsonData.qstSize - jsonData.postiveSize, "-", "-",
							"-");
					appendLine("阳性项目数", jsonData.postiveSize, "-", "-", "-");
					appendLine("阳性症状均分", jsonData.postiveGpa, "-", "-", "-");

					
					$.each(jsonData.factorResultMap, function(index, jsonLine) {
						appendFactorLine(jsonLine);
					});
					
				});

			});

	function appendLine(name, gpa, std, level, reference) {
		$("#scl90FactorTable").append(
				$('<tr/>').append($('<td/>').html(name)).append(
						$('<td/>').html(gpa)).append($('<td/>').html(std))
						.append($('<td/>').html(level)).append(
								$('<td/>').html(reference)));
	}

	function appendFactorLine(data) {
		if (data == null) {
			return;
		}
		//data=factorJsonObj
		if (data.factor == "第十因子") {
			appendLine(data.factor, data.factorGpa, "-", "-", "-");
		} else {
			appendLine(data.factor, data.factorGpa, data.zVal, data.psdLevel,
					data.factorNorm.gpa + "±" + data.factorNorm.std);
			addAnlysis(data);
		}
	}

	function addAnlysis(data) {
		var expr = data.levelExpr;
		if (expr == null) {
			return;
		}

		var line = "<p><span><B>【" + data.factor + "】</B> </span><br>&nbsp&nbsp<B>解释</B>："
				+ expr.explain;

		if (expr.suggest != null && expr.suggest.trim().length > 0) {
			line += "<br>&nbsp&nbsp<B>建议</B>：" + expr.suggest;
		}

		line += "</p><br>";
		$("#result").append($('<div class="xlcs_fx" />').html(line));

	}
</script>

</html>