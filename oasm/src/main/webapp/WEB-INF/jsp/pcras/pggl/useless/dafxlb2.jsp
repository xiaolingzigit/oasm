<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>档案分析量表</title>
</head>
<body>
  <div class="return_btn" >
       <a href="#" onclick="loadnext2('/oasm/dafxView/sjcjpc')">《 返回</a>	
    </div>
     <div class="rs_table">
        <div class="rs_table_title"><h1>档案分析量表</h1></div>
        <div class="table_msg" >
		<div id="" class="" style="float:left;margin-left:30%;">
			囚号:<input type="text" name="">
		</div>
		<div id="" class="" style="margin-left:60%;" >
			姓名:<input type="text" name="">
		</div>

 
        </div>
   <fieldset class="instruct">
	<legend>指导语</legend>
<p><strong><u>量表说明</u></strong></p>
<p>&nbsp;&nbsp;该档案分析量表仅适用于罪犯的入监评估，日常排查和中期评估等三个阶段，出监评估不可使用此量表做档案分析。</p>
<p><strong><u>注意事项</u></strong></p>
<p>&nbsp;&nbsp;请认真阅读每一道题目，应根据真实情况作答；每一道题目皆为必答题，不要有遗漏。</p>

	</fieldset>
            <div class="base_table cs-table">
 			<table width="100%">
			  <tr>
                            <th class="base_th" width="5%">序号</th>
                            <th class="base_th" width="10%">题目</th>
                            <th class="base_th" width="20%">选项</th>
                </tr>
		</table>
	</div>
     <div class="base_table cs-table" style="overflow-x: auto; overflow-y: auto; height: 500px;">
		<table>
          <colgroup>
            <col width="5%">
            <col width="10%">
            <col width="20%">
          </colgroup>
	
				<tr>
					<td>1</td>
					<td>犯罪种类</td>
					<td class="lb_td04" style="text-align: left;">
					<br><input name="question1" type="radio" value="" />职务犯罪和过失犯罪（0分）
					<br><input name="question1" type="radio" value="" />其他犯罪（2分）
					<br><input name="question1" type="radio" value="" />判处10年以上暴力型严重犯罪的（4分）
					<br><input name="question1" type="radio" value="" />诈骗类犯罪（6分）
					<br><input name="question1" type="radio" value="" />邪教、危安型（组织邪教犯罪、宗教极端势力、暴力恐怖势力、危害国家安全罪等）（8分）</td>
				</tr>
				<tr>

				<tr>
					<td>2</td>
					<td>剩余刑期</td>
					<td class="lb_td04" style="text-align: left;">
					<br><input name="question6" type="radio" value="" />1年以下（1分）
					<br><input name="question6" type="radio" value="" />1年以上5年以下（2分）
					<br><input name="question6" type="radio" value="" />5年以上10年以下（3分）
					<br><input name="question6" type="radio" value="" />10年以上15年以下（4分）
					<br><input name="question6" type="radio" value="" />15年以上20年以下（5分）
					<br><input name="question6" type="radio" value="" /> 无期或死缓（8分）
					<br><input name="question6" type="radio" value="" />死缓限制减刑（10分
					<br><input name="question6" type="radio" value="" /> 终身监禁（10分）</td>
				</tr>
				<tr>
					<td>3</td>
					<td>年龄</td>
					<td class="lb_td04" style="text-align: left;">
					<br><input name="question7" type="radio" value="" />30岁以下（3分）
					<br><input name="question7" type="radio" value="" />30-59岁（2分）
					<br><input name="question7" type="radio" value="" />60岁以上（1分）</td>
				</tr>
				<tr>
					<td>4</td>
					<td>入监前文化</td>
					<td class="lb_td04" style="text-align: left;">
					<br><input name="question8" type="radio" value="" />高中以上文化（1分）
					<br><input name="question8" type="radio" value="" />小学和初中（2分）
					<br><input name="question8" type="radio" value="" />文盲（3分）</td>
				</tr>

				<tr>
					<td>5</td>
					<td>主从犯</td>
					<td class="lb_td04" style="text-align: left;">
					<br><input name="question12" type="radio" value="" />从犯（1分）
					<br><input name="question12" type="radio" value="" />主犯（3分）</td>
				</tr>
				<tr>
					<td>6</td>
					<td>犯罪状态</td>
					<td class="lb_td04" style="text-align: left;">
					<br><input name="question13" type="checkbox" value="" /> 过失犯罪（0分）
						
					<br><input name="question13" type="checkbox" value="" />未遂或中止（1分）
					<br><input name="question13" type="checkbox" value="" />故意犯罪（3分）</td>
				</tr>
				<tr>
					<td>7</td>
					<td>流窜犯</td>
					<td class="lb_td04" style="text-align: left;">
					<br><input name="question14" type="radio" value="" />否（0分）
					<br><input name="question14" type="radio" value="" />未婚（1分）
					<br><input name="question14" type="radio" value="" />省内或省外流窜犯（1分）
					<br><input name="question14" type="radio" value="" />省内逃犯（3分）
					<br><input name="question14" type="radio" value="" />省外（包括网上、国外）逃犯（5分）</td>
				</tr>
				<tr>
					<td>8</td>
					<td>累惯犯</td>
					<td class="lb_td04" style="text-align: left;">
					<br><input name="question15" type="radio" value="" />否（0分）
					<br><input name="question15" type="radio" value="" />累犯或惯犯（3分）</td>
				</tr>

				<tr>
					<td>9</td>
					<td>前科</td>
					<td class="lb_td04" style="text-align: left;">
					<br><input name="question18" type="radio" value="" />无（0分）
					<br><input name="question18" type="radio" value="" />劳教或监狱服刑1次（3分）
					<br><input name="question18" type="radio" value="" />监狱服刑2次或以上（5分）</td>
				</tr>

				<tr>
					<td>10</td>
					<td> 一审后是否上诉</td>
					<td class="lb_td04" style="text-align: left;">
					<br><input name="question18" type="radio" value="" />未上诉（0分）
					<br><input name="question18" type="radio" value="" />上诉（1分）</td>
				</tr>
				<tr>
					<td>11</td>
					<td>军警经历或特殊技能情况</td>
					<td class="lb_td04" style="text-align: left;">
					<br><input name="question21" type="radio" value="" />无（0分）
					<br><input name="question21" type="radio" value="" />有（5分）</td>
				</tr>
				<tr>
					<td>12</td>
					<td>三假罪犯</td>
					<td class="lb_td04" style="text-align: left;">
					<br><input name="question22" type="radio" value="" />否（0分）
					<br><input name="question22" type="radio" value="" />自报姓名（3分）
					<br><input name="question22" type="radio" value="" />“三假”罪犯（5分）</td>
				</tr>
				<tr>
					<td>13</td>
					<td>现身体精神情况</td>
					<td class="lb_td04" style="text-align: left;">
					<br><input name="question23" type="radio" value="" />身体健康（0分）
					<br><input name="question23" type="radio" value="" />患有一般疾病（1分）
					<br><input name="question23" type="radio" value="" />身体残疾，患有严重心理问题或疑似精神异常的（5分）
					<br><input name="question23" type="radio" value="" />患有严重疾病或患有精神疾病发病期（7分）</td>
				</tr>
				<tr>
					<td>14</td>
					<td>减刑、假释和其他奖励情况</td>
					<td class="lb_td04" style="text-align: left;">
					<br><input name="question24" type="radio" value="" />减刑、假释通过并符合预期（0分）
					<br><input name="question24" type="radio" value="" />获得表扬或记功等同等级的奖励（1分）
					<br><input name="question24" type="radio" value="" />减刑通过不符合预期（2分）
					<br><input name="question24" type="radio" value="" />假释被驳回或减刑裁定长期未下达（3分）
					<br><input name="question24" type="radio" value="" />无减刑、假释或其他奖励情况（5分）
					<br><input name="question24" type="radio" value="" />减刑被撤案或驳回（7分）</td>
				</tr>
				<tr>
					<td>15</td>
					<td>违纪、扣分、行政处罚和集训管理情况</td>
					<td class="lb_td04" style="text-align: left;">
					<br><input name="question25" type="radio" value="" />无违纪扣分的（0分）
					<br><input name="question25" type="radio" value="" />有违纪行为一个月内一次扣2分或累计扣2分的（1分）
					<br><input name="question25" type="radio" value="" />连续6个月内累计扣4分以上（包含4分）或被一次性扣3分以上（包含3分）（3分）					
					<br><input name="question25" type="radio" value="" />单独关押、加戴戒具和集训管理（8分）
					<br><input name="question25" type="radio" value="" />给予警告以上处罚的（包括警告、记过、禁闭）（10分）</td>
				</tr>
				<tr>
					<td>16</td>
					<td>三课学习</td>
					<td class="lb_td04" style="text-align: left;">
					<br><input name="question26" type="radio" value="" />及格以上（0分）
					<br><input name="question26" type="radio" value="" />不及格（3分）</td>
				</tr>
				<tr>
					<td>17</td>
					<td>劳动生产情况</td>
					<td class="lb_td04" style="text-align: left;">
					<br><input name="question27" type="radio" value="" />完成或超额完成劳动任务（0分）
					<br><input name="question27" type="radio" value="" />当月完不成劳动任务的（1分）
					<br><input name="question27" type="radio" value="" />连续2个月完不成劳动任务（3分）					
					<br><input name="question27" type="radio" value="" />连续3个月完不成劳动任务（5分）</td>
				</tr>
			</table>
            </div> 
			<div style="text-align: center; padding-bottom:10px">
			      <button style="font-size: 20px;">保存</button>
				  <button style="font-size: 20px;">提交</button>
				  <button style="font-size: 20px;">下载</button>
				  <button style="font-size: 20px;">打印</button>
                  
                </div>
            </div>

    </div>
</body>
</html>