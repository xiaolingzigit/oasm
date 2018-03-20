<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>日常观察</title>
</head>
<body>
    <div class="return_btn" >
       <a href="#" onclick="loadnext2('/oasm/dafxView/sjcjpc')"> <<< 返回 </a>	
    </div>
     <div class="rs_table">
        <div class="rs_table_title"><h1>行为观察结果表</h1></div>
        <div class="table_msg" >
              <table>
               <tr>
				<td class="xx_td01">姓名</td>
				<td class="xx_td02">xx</td>
				<td class="xx_td01">囚号</td>
				<td  class="xx_td02 xx_number" onclick="loadnext1('pggl/criminalinfo')" >6546545454</td>
               </tr>
			   <tr>
				<td class="xx_td01">监区</td>
				<td class="xx_td02">三监区</td>
				<td class="xx_td01">分析时间</td>
				<td class="xx_td02">2017-07-01</td>
               </tr>
               <tr>
				<td  class="xx_td01">排查结果</td>
				<td class="xx_td02" >非高危</td>
				<td class="xx_td01">评估分数</td>
				<td class="xx_td02" >9</td>
               </tr>
               </table>
 
        </div>
            <div class="base_table cs-table">
	<table width="100%">
			<tr>
                            <th class="base_th" width="5%">序号</th>
                            <th class="base_th" width="10%">题目</th>
                            <th class="base_th" width="20%">回答情况</th>
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
					<td>1</td><td>服从管教情况</td>
					<td class="lb_td04" style="text-align: left;">
					<br><input name="question1" type="radio" value="" />服从管教，在改造中积极面对的（0分）
					<br><input name="question1" type="radio" value="" />基本能服从管教（1分）
					<br><input name="question1" type="radio" value="" />对管教阳奉阴违的（5分）
					<br><input name="question1" type="radio" value="" />对抗管教的（8分）</td>
				</tr>
				<tr>
					<td>2</td><td>互监组情况</td>
					<td class="lb_td04" style="text-align: left;">
					<br><input name="question2" type="radio" value="" />能遵守互监组规定的（0分）
					<br><input name="question2" type="radio" value="" />脱离互监组，独自行动进入小房小室（6分）</td>
				</tr>
				<tr>
					<td>3</td><td>警囚矛盾</td>
					<td class="lb_td04" style="text-align: left;">
					<br><input name="question8" type="radio" value="" />无（0分）
					<br><input name="question8" type="radio" value="" />有（5分）</td>
				</tr>
				<tr>
					<td>4</td><td>与他犯矛盾</td>
					<td class="lb_td04" style="text-align: left;">
					<br><input name="question9" type="radio" value="" />好（0分）
					<br><input name="question9" type="radio" value="" />一般（1分）
					<br><input name="question9" type="radio" value="" />较差的（5分）</td>
				</tr>
				<tr>
					<td>5</td><td>自杀言行情况（可多选）</td>
					<td class="lb_td04" style="text-align: left;">
					<br><input name="question17" type="checkbox" value="" />无或未发现的（0分）
					<br><input name="question17" type="checkbox" value="" />在不同场合谈论有关生死言论的（8分）
					<br><input name="question17" type="checkbox" value="" />精神恍惚异常的（8分）
					<br><input name="question17" type="checkbox" value="" />刑期长，失去改造信心，对人对事反应冷淡的（8分）
					<br><input name="question17" type="checkbox" value="" />经常感到家人或自己可怜，常思虑发呆，长时间给家人写       信或看家人相片的（8分）
					<br><input name="question17" type="checkbox" value="" />常常感到被家人或其他人抛弃，犯罪让自己无地自容，有自罪自责思想（8分）
					<br><input name="question17" type="checkbox" value="" />有自杀妄想或被害妄想、指令性幻听、强制性思维等精神病性现象（8分）
					<br><input name="question17" type="checkbox" value="" />发生亲人去世等重大生活事件，有严重的躯体和心理创伤或发生其他重大希望破灭的（8分）
					<br><input name="question17" type="checkbox" value="" />经常出现哭泣的现象（8分）
					<br><input name="question17" type="checkbox" value="" />有意存储药物或私藏私制违禁品利器、刀片、绳索等自杀工具的（8分）
					<br><input name="question17" type="checkbox" value="" />写遗书、独自流泪、悲观厌世、物品无故送他人、无缘无故整理个人物品；向亲人或要好的同改交代后事；（8分）
					<br><input name="question17" type="checkbox" value="" />有吞食异物等自伤自残行为（8分）
					<br><input name="question17" type="checkbox" value="" />有其他异常自杀言行（8分）
					<br><input name="question17" type="checkbox" value="" />抑郁情绪严重或长期有严重抑郁症，而情绪突然好转的或自杀未遂的（10分）
					
					</tr>

				<tr>
					<td>6</td><td>行凶言行情况（可多选）</td>
					<td class="lb_td04" style="text-align: left;">
					<br><input name="question18" type="checkbox" value="" />无或未发现的（0分）
					<br><input name="question18" type="checkbox" value="" />心胸狭隘、疑心较重，或者性情冲动、暴躁，不顾后果的（3分）
					<br><input name="question18" type="checkbox" value="" />被告发或懦弱无能被欺凌的（3分）
					<br><input name="question18" type="checkbox" value="" />受到不公正处罚，抵触情绪强烈的（5分）
					<br><input name="question18" type="checkbox" value="" />公开表示仇恨或攻击报复（对他犯、他人、干警、政府、政党）气愤言语激烈，情绪明显的（8分）
					<br><input name="question18" type="checkbox" value="" />利用劳动工具、利器伤人或私藏利器的（8分）
					<br><input name="question18" type="checkbox" value="" />哄监闹事、打架斗殴行为（8分）
					<br><input name="question18" type="checkbox" value="" />拒绝听从干警命令、严重对抗警察、暴力袭警、有发生冲突、行凶、伤害、劫持人质、纵火等行为的（10分）
					<br><input name="question18" type="checkbox" value="" />有其他异常行凶言行（8分）
					
					</tr>
				<tr>
					<td>7</td><td>脱逃言行情况（可多选）</td>
					<td class="lb_td04" style="text-align: left;">
                    <br><input name="question19" type="checkbox" value="" />无或未发现的（0分）
					<br><input name="question19" type="checkbox" value="" />打听地形、了解交通（5分）
					<br><input name="question19" type="checkbox" value="" />故意摆脱监管的（5分）
					<br><input name="question19" type="checkbox" value="" />了解到重要人员长期失去联系或无人照看的、或发生重大变故的（7分）
					<br><input name="question19" type="checkbox" value="" />伪装疾病，有外诊诉求（7分）
					<br><input name="question19" type="checkbox" value="" />观察并打听民警的值班时间，窥探监狱民警管理和警戒设施方面的漏洞（8分）
					<br><input name="question19" type="checkbox" value="" />集体活动时脱离互监组回小组或到其他场所等（8分）
					<br><input name="question19" type="checkbox" value="" />私藏现金、便服、证件、绳索、铁器等违禁物品的（8分）
					<br><input name="question19" type="checkbox" value="" />有重大余罪、漏罪被发现而出现焦虑、紧张表现的（8分）
					<br><input name="question19" type="checkbox" value="" />感到自己或家人受到严重威胁（8分）
					<br><input name="question19" type="checkbox" value="" />在外有重要事项未完成，迫切想要完成（8分）
					<br><input name="question19" type="checkbox" value="" />密谋脱逃（包括聚会密议、准备工具、私穿便服）或有其他脱逃行为的（10分）
					<br><input name="question19" type="checkbox" value="" />有其他异常脱逃言行（8分）
                    
                </tr>
		</table>
            </div> 
			<div style="text-align: center; padding-bottom:10px">
			
				  <button style="font-size: 20px;">下载</button>
				  <button style="font-size: 20px;">打印</button>
                  
                </div>
            </div>

    </div>
</body>
</html>