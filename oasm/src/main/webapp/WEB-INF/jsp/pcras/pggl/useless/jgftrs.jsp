<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>结构性访谈</title>
</head>
<body>
    <div class="return_btn" >
       <a href="#" onclick="loadnext2('/oasm/dafxView/sjcjpc')"> <<< 返回 </a>	
    </div>
     <div class="rs_table">
        <div class="rs_table_title"><h1>结构性访谈结果表</h1></div>
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
 			<table width="100%" >
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
					<td>1</td>
					<td>既往史情况（可多选）</td>
					<td class="lb_td04" style="text-align: left;">
					<br><input name="question20" type="checkbox" value="" />无（0分）
					<br><input name="question20" type="checkbox" value="" />药物滥用史（包括注射、吸食）（3分）
					<br><input name="question20" type="checkbox" value="" />有酗酒史（3分）
					<br><input name="question20" type="checkbox" value="" />有网瘾史（3分）
					<br><input name="question20" type="checkbox" value="" />有赌博史（5分）
					<br><input name="question20" type="checkbox" value="" />有吸毒史（5分）
					<br><input name="question20" type="checkbox" value="" />受欺凌史（7分）
					<br><input name="question20" type="checkbox" value="" />受欺凌史（7分）
					<br><input name="question20" type="checkbox" value="" />流浪史（7分）
					<br><input name="question20" type="checkbox" value="" />严重暴力行为史（7分）
					<br><input name="question20" type="checkbox" value="" />自伤自残史（8分）
					<br><input name="question20" type="checkbox" value="" />预谋脱逃史（8分）
					<br><input name="question20" type="checkbox" value="" />脱逃、袭警、自杀史（8分）</td>
				</tr>
				<tr>
					<td>2</td>
					<td>独生子女</td>
					<td class="lb_td04" style="text-align: left;">
					<br><input name="question18" type="radio" value="" />否（1分）
					<br><input name="question18" type="radio" value="" />是（3分）</td>
				</tr>
				<tr>
					<td>3</td>
					<td>宗教思想</td>
					<td class="lb_td04" style="text-align: left;">
					<br><input name="question12" type="radio" value="" />无宗教信仰（0分）
					<br><input name="question12" type="radio" value="" />利用宗教做不符合规定的事情（5分）
					<br><input name="question12" type="radio" value="" />邪教（7分）</td>
				</tr>
				<tr>
					<td>4</td>
					<td>犯罪归因</td>
					<td class="lb_td04" style="text-align: left;">
					<br><input name="question7" type="radio" value="" />自己原因导致的犯罪（1分）
					<br><input name="question7" type="radio" value="" />他人原因导致的犯罪（3分）
					<br><input name="question7" type="radio" value="" />社会原因导致的犯罪（5分）</td>
				</tr>	
				<tr>
					<td>5</td>
					<td>对本次犯罪行为和判决的认识情况（可多选）</td>
					<td class="lb_td04" style="text-align: left;">
					<br><input name="question8" type="checkbox" value="" />认罪悔罪（0分）
					<br><input name="question8" type="checkbox" value="" />基本接受（3分）
					<br><input name="question8" type="checkbox" value="" />认为量刑过重（5分）
					<br><input name="question8" type="checkbox" value="" />仇恨司法机关人员（包括警察、检察官和法官）（6分） 
					<br><input name="question8" type="checkbox" value="" />自认无罪或被冤枉（8分）</td>
				</tr>											
				<tr>
					<td>6</td>
					<td>减刑认识</td>
					<td class="lb_td04" style="text-align: left;">
					<br><input name="question1" type="radio" value="" />有减刑意愿（0分）
					<br><input name="question1" type="radio" value="" />刑期短无减刑机会（1分）
					<br><input name="question1" type="radio" value="" />不知道（5分）
					<br><input name="question1" type="radio" value="" />不想减刑（7分）
					<br><input name="question1" type="radio" value="" />因违纪扣分或完不成劳动任务而无减刑希望的（8分）</td>
				</tr>
				<tr>

				<tr>
					<td>7</td>
					<td>申诉情况</td>
					<td class="lb_td04" style="text-align: left;">
					<br><input name="question6" type="radio" value="" />无申诉（0分）
					<br><input name="question6" type="radio" value="" />有申诉（3分）</td>
				</tr>
				<tr>
					<td>8</td>
					<td>疾病、伤残对生活、劳动的影响</td>
					<td class="lb_td04" style="text-align: left;">
					<br><input name="question21" type="radio" value="" />无影响（0分）
					<br><input name="question21" type="radio" value="" />影响较小（3分）
					<br><input name="question21" type="radio" value="" />影响较大（5分）</td>
				</tr>
				<tr>
					<td>9</td>
					<td>饮食情况</td>
					<td class="lb_td04" style="text-align: left;">
					<br><input name="question22" type="radio" value="" />正常（0分）
					<br><input name="question22" type="radio" value="" />一般或1天不吃（3分）
					<br><input name="question22" type="radio" value="" />较差或2天不吃不喝的（5分）
					<br><input name="question22" type="radio" value="" />差或3天不吃不喝的（8分）
					<br><input name="question22" type="radio" value="" />绝食（10分）</td>
				</tr>
				
				<tr>
					<td>10</td>
					<td>睡眠情况</td>
					<td class="lb_td04" style="text-align: left;">
					<br><input name="question23" type="radio" value="" />正常（0分）
					<br><input name="question23" type="radio" value="" />一般或1天不睡觉（3分）
					<br><input name="question23" type="radio" value="" />较差或2天不睡觉（5分）
					<br><input name="question23" type="radio" value="" />差或3天以上不睡觉（10分）</td>
				</tr>
				<tr>
					<td>11</td>
					<td>婚姻关系</td>
					<td class="lb_td04" style="text-align: left;">
					<br><input name="question14" type="radio" value="" />未婚或已婚，与妻子关系好（0分）
					<br><input name="question14" type="radio" value="" />离异或丧偶（2分）
					<br><input name="question14" type="radio" value="" />已婚，与妻子关系不好（3分）
					<br><input name="question14" type="radio" value="" />正在离婚纠缠（7分）
					</td>
				</tr>	
				<tr>
					<td>12</td>
					<td>家庭支持</td>
					<td class="lb_td04" style="text-align: left;">
					<br><input name="question15" type="radio" value="" />有固定家属会见、亲情电话、书信或汇款（0分）
					<br><input name="question15" type="radio" value="" />有支持但不希望家人来会见或汇款（1分）					
					<br><input name="question15" type="radio" value="" />3个月内无家属会见、亲情电话、书信或汇款（3分）
					<br><input name="question15" type="radio" value="" />半年内无家属会见、亲情电话、书信或汇款（5分）
					<br><input name="question15" type="radio" value="" />一年内无家属会见、亲情电话、书信或汇款（7分）
					<br><input name="question15" type="radio" value="" />三无人员（8分）</td>
				</tr>
			
				<tr>
					<td>13</td>
					<td>服刑期间家庭变故（可多选）</td>
					<td class="lb_td04" style="text-align: left;">
					<br><input name="question13" type="checkbox" value="" />无（0分）
					<br><input name="question13" type="checkbox" value="" />不了解（3分）	
					<br><input name="question13" type="checkbox" value="" />一般变故（包括妻子失业、子女辍学、直系亲属犯罪服刑、直系亲属间财产和债务纠纷、以及主要亲属无人照顾等）（6分）
						
					<br><input name="question13" type="checkbox" value="" />重大变故（包括主要亲属过世、直系亲属突发严重疾病、直系亲属不知去向等）（8分）</td>
				</tr>
				<tr>
					<td>14</td>
					<td>诉求</td>
					<td class="lb_td04" style="text-align: left;">
					<br><input name="question24" type="radio" value="" />无或提出合理诉求，已妥善解决的（0分）
					<br><input name="question24" type="radio" value="" />提出无理诉求，经解释后，态度能接受的（3分）
					<br><input name="question24" type="radio" value="" />提出合理诉求，但长时间没有解决的（6分）
					<br><input name="question24" type="radio" value="" />提出无理诉求，经解释后，但仍旧纠缠的（8分）</td>
				</tr>
				<tr>
					<td>15</td>
					<td>调动意愿</td>
					<td class="lb_td04" style="text-align: left;">
					<br><input name="question25" type="radio" value="" />无调动意愿（0分）
					<br><input name="question25" type="radio" value="" />有外调及监区调动意愿（3分）
					<br><input name="question25" type="radio" value="" />外调及监区调动意愿强烈（5分）</td>
				</tr>
				<tr>
					<td>16</td>
					<td>最关心之事或目前困扰</td>
					<td class="lb_td04" style="text-align: left;">
					<br><input name="question26" type="radio" value="" />无（0分）
					<br><input name="question26" type="radio" value="" />其他（3分）
					<br><input name="question26" type="radio" value="" />家人健康（3分）
					<br><input name="question26" type="radio" value="" />事业或经济纠纷问题（3分）
					<br><input name="question26" type="radio" value="" />家庭经济无依靠（5分）
					<br><input name="question26" type="radio" value="" />服刑改造（5分）
					<br><input name="question26" type="radio" value="" />生理疾病问题（7分）
					<br><input name="question26" type="radio" value="" />夫妻关系情况变化（7分）
					<br><input name="question26" type="radio" value="" />子女上学或无人照顾情况（7分）
					<br><input name="question26" type="radio" value="" />受人轻视排斥或虐待情况（7分）
					</td>
				</tr>
				<tr>
					<td>17</td>
					<td>余罪、漏罪情况</td>
					<td class="lb_td04" style="text-align: left;">
					<br><input name="question27" type="radio" value="" />无（0分）
					<br><input name="question27" type="radio" value="" />余罪、漏罪调查期间（7分）
					<br><input name="question27" type="radio" value="" />可能存在重大余罪、漏罪暴露者（8分）</td>
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