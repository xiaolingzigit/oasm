<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>COPA-PI量表</title>
</head>
<body>
    <div class="return_btn" >
       <a href="#" onclick="loadnext3('/oasm/dafxView/rj_copa')"> <<<  返回 </a>	
    </div>
     <div class="rs_table">
        <div class="rs_table_title"><h1>COPA-PI结果表</h1></div>
       <div class="msg_div2">
		   <ul  class="xx_ul">
		   <li class="xx_li01">姓<span>名</span>：</li>
		   <li class="xx_li02">韩方奕</li>
		   <li class="xx_li01">囚<span>号</span>：</li>
		   <li  class="xx_number xx_li02" onclick="loadnext3('/oasm/dafxView/criminalinfo')">1234567890</li>
		   <li class="xx_li01">录入时间：</li>
		   <li class="xx_li02">2017/11/6</li>
		   <li class="xx_li01">监<span>区</span>：</li>
		   <li class="xx_li02">三监区</li>
		   <li class="xx_li01">分监区：</li>
		   <li class="xx_li02">分监区1</li>
		   <li class="xx_li01">专管警察：</li>
		   <li class="xx_li02">王子需</li>
           <li  class="xx_li01">分析结果：</li>
		   <li class="xx_li02" >非高危</li>
           <li class="xx_li01">得<span>分</span>：</li>
		   <li class="xx_li02" >55</li>	
		   </ul>	
        </div>
 		<div class="header_table">
			<table rules=none>
				<tr>
				<th width="4%" >序号</th>
				<th width="55.5%" >题目</th>
				<th width="20%" >是</th>
				<th width="19.5%" >否</th>
				<th width="1%" style="background: #fff;"></th>
				</tr>
			</table>
		</div>

     <div class="lb_content_table2" >
		<table >
          <colgroup>
            <col width="4%">
            <col width="56%">
            <col width="20%">
			<col width="20%">
          </colgroup>
				<tr>
					<td>1</td>
					<td class="lbf">我喜欢社交公关活动。</td>
					<td class="lb_option"><input name="copaq1" type="radio"
						value="1" id="copat1" /> 是</td>
					<td class="lb_option"><input name="copaq1" type="radio"
						value="0" id="copaf1" /> 否</td>
				</tr>
				<tr>
					<td>2</td>
					<td class="lbf">即使是很复杂的问题，一般也难不到我。</td>
					<td class="lb_option"><input name="copaq2" type="radio"
						value="1" id="copat2" /> 是</td>
					<td class="lb_option"><input name="copaq2" type="radio"
						value="0" id="copaf2" /> 否</td>
				</tr>
				<tr>
					<td>3</td>
					<td class="lbf">别人与我作对时，我总会想出办法来教训他一顿。</td>
					<td class="lb_option"><input name="copaq3" type="radio"
						value="1" id="copat3" /> 是</td>
					<td class="lb_option"><input name="copaq3" type="radio"
						value="0" id="copaf3" /> 否</td>
				</tr>
				<tr>
					<td>4</td>
					<td class="lbf">能帮助有困难的人令人快乐。</td>
					<td class="lb_option"><input name="copaq4" type="radio"
						value="1" id="copat4" /> 是</td>
					<td class="lb_option"><input name="copaq4" type="radio"
						value="0" id="copaf4" /> 否</td>
				</tr>
				<tr>
					<td>5</td>
					<td class="lbf">我一直认为有人控制着我的思想。</td>
					<td class="lb_option"><input name="copaq5" type="radio"
						value="1" id="copat5" /> 是</td>
					<td class="lb_option"><input name="copaq5" type="radio"
						value="0" id="copaf5" /> 否</td>
				</tr>
				<tr>
					<td>6</td>
					<td class="lbf">通常大多数人怎么说，我就怎么说。</td>
					<td class="lb_option"><input name="copaq6" type="radio"
						value="1" id="copat6" /> 是</td>
					<td class="lb_option"><input name="copaq6" type="radio"
						value="0" id="copaf6" /> 否</td>
				</tr>
				<tr>
					<td>7</td>
					<td class="lbf">犯点小错，没有什么大不了的。</td>
					<td class="lb_option"><input name="copaq7" type="radio"
						value="1" id="copat7" /> 是</td>
					<td class="lb_option"><input name="copaq7" type="radio"
						value="0" id="copaf7" /> 否</td>
				</tr>
				<tr>
					<td>8</td>
					<td class="lbf">我容易心里烦乱或觉得害怕。</td>
					<td class="lb_option"><input name="copaq8" type="radio"
						value="1" id="copat8" /> 是</td>
					<td class="lb_option"><input name="copaq8" type="radio"
						value="0" id="copaf8" /> 否</td>
				</tr>
				<tr>
					<td>9</td>
					<td class="lbf">我从来没有和人吵过架。</td>
					<td class="lb_option"><input name="copaq9" type="radio"
						value="1" id="copat9" /> 是</td>
					<td class="lb_option"><input name="copaq9" type="radio"
						value="0" id="copaf9" /> 否</td>
				</tr>
				<tr>
					<td>10</td>
					<td class="lbf">我做事总是莽撞，冒冒失失。</td>
					<td class="lb_option"><input name="copaq10" type="radio"
						value="1" id="copat10" /> 是</td>
					<td class="lb_option"><input name="copaq10" type="radio"
						value="0" id="copaf10" /> 否</td>
				</tr>
				<tr>
					<td>11</td>
					<td class="lbf">如果富有，我会购买或收藏刀、剑、枪、炮之类的东西。</td>
					<td class="lb_option"><input name="copaq11" type="radio"
						value="1" id="copat11" /> 是</td>
					<td class="lb_option"><input name="copaq11" type="radio"
						value="0" id="copaf11" /> 否</td>
				</tr>
				<tr>
					<td>12</td>
					<td class="lbf">相信别人，肯定要吃大亏。</td>
					<td class="lb_option"><input name="copaq12" type="radio"
						value="1" id="copat12" /> 是</td>
					<td class="lb_option"><input name="copaq12" type="radio"
						value="0" id="copaf12" /> 否</td>
				</tr>
				<tr>
					<td>13</td>
					<td class="lbf">放火焚烧给人一种快乐的享受。</td>
					<td class="lb_option"><input name="copaq13" type="radio"
						value="1" id="copat13" /> 是</td>
					<td class="lb_option"><input name="copaq13" type="radio"
						value="0" id="copaf13" /> 否</td>
				</tr>
				<tr>
					<td>14</td>
					<td class="lbf">我感到处处不如人。</td>
					<td class="lb_option"><input name="copaq14" type="radio"
						value="1" id="copat14" /> 是</td>
					<td class="lb_option"><input name="copaq14" type="radio"
						value="0" id="copaf14" /> 否</td>
				</tr>
				<tr>
					<td>15</td>
					<td class="lbf">为了钱可以不择手段。</td>
					<td class="lb_option"><input name="copaq15" type="radio"
						value="1" id="copat15" /> 是</td>
					<td class="lb_option"><input name="copaq15" type="radio"
						value="0" id="copaf15" /> 否</td>
				</tr>
				<tr>
					<td>16</td>
					<td class="lbf">我晚上常常翻来覆去地睡不着。</td>
					<td class="lb_option"><input name="copaq16" type="radio"
						value="1" id="copat16" /> 是</td>
					<td class="lb_option"><input name="copaq16" type="radio"
						value="0" id="copaf16" /> 否</td>
				</tr>
				<tr>
					<td>17</td>
					<td class="lbf">我能很快和周围的人熟悉起来。</td>
					<td class="lb_option"><input name="copaq17" type="radio"
						value="1" id="copat17" /> 是</td>
					<td class="lb_option"><input name="copaq17" type="radio"
						value="0" id="copaf17" /> 否</td>
				</tr>
				<tr>
					<td>18</td>
					<td class="lbf">我理解事情总是比别人快一些。</td>
					<td class="lb_option"><input name="copaq18" type="radio"
						value="1" id="copat18" /> 是</td>
					<td class="lb_option"><input name="copaq18" type="radio"
						value="0" id="copaf18" /> 否</td>
				</tr>
				<tr>
					<td>19</td>
					<td class="lbf">我会给威胁我的人以致命性地打击。</td>
					<td class="lb_option"><input name="copaq19" type="radio"
						value="1" id="copat19" /> 是</td>
					<td class="lb_option"><input name="copaq19" type="radio"
						value="0" id="copaf19" /> 否</td>
				</tr>
				<tr>
					<td>20</td>
					<td class="lbf">路上遇到有人推车上坡，我会主动帮他一把。</td>
					<td class="lb_option"><input name="copaq20" type="radio"
						value="1" id="copat20" /> 是</td>
					<td class="lb_option"><input name="copaq20" type="radio"
						value="0" id="copaf20" /> 否</td>
				</tr>
				<tr>
					<td>21</td>
					<td class="lbf">有人一直想陷害我。</td>
					<td class="lb_option"><input name="copaq21" type="radio"
						value="1" id="copat21" /> 是</td>
					<td class="lb_option"><input name="copaq21" type="radio"
						value="0" id="copaf21" /> 否</td>
				</tr>
				<tr>
					<td>22</td>
					<td class="lbf">我比较在乎大多数人的看法，哪怕为此放弃自己的观点。</td>
					<td class="lb_option"><input name="copaq22" type="radio"
						value="1" id="copat22" /> 是</td>
					<td class="lb_option"><input name="copaq22" type="radio"
						value="0" id="copaf22" /> 否</td>
				</tr>
				<tr>
					<td>23</td>
					<td class="lbf">“马无夜草不肥，人无外财不富”，事实就是这样。</td>
					<td class="lb_option"><input name="copaq23" type="radio"
						value="1" id="copat23" /> 是</td>
					<td class="lb_option"><input name="copaq23" type="radio"
						value="0" id="copaf23" /> 否</td>
				</tr>
				<tr>
					<td>24</td>
					<td class="lbf">我的心情常常不稳定，时好时坏。</td>
					<td class="lb_option"><input name="copaq24" type="radio"
						value="1" id="copat24" /> 是</td>
					<td class="lb_option"><input name="copaq24" type="radio"
						value="0" id="copaf24" /> 否</td>
				</tr>
				<tr>
					<td>25</td>
					<td class="lbf">我从来没有出过什么差错。</td>
					<td class="lb_option"><input name="copaq25" type="radio"
						value="1" id="copat25" /> 是</td>
					<td class="lb_option"><input name="copaq25" type="radio"
						value="0" id="copaf25" /> 否</td>
				</tr>
				<tr>
					<td>26</td>
					<td class="lbf">我做事往往凭一时冲动，事后却常常发觉不妥。</td>
					<td class="lb_option"><input name="copaq26" type="radio"
						value="1" id="copat26" /> 是</td>
					<td class="lb_option"><input name="copaq26" type="radio"
						value="0" id="copaf26" /> 否</td>
				</tr>
				<tr>
					<td>27</td>
					<td class="lbf">我经常有真想找人打上一架的念头。</td>
					<td class="lb_option"><input name="copaq27" type="radio"
						value="1" id="copat27" /> 是</td>
					<td class="lb_option"><input name="copaq27" type="radio"
						value="0" id="copaf27" /> 否</td>
				</tr>
				<tr>
					<td>28</td>
					<td class="lbf">对任何人都不信任，是比较安全的。</td>
					<td class="lb_option"><input name="copaq28" type="radio"
						value="1" id="copat28" /> 是</td>
					<td class="lb_option"><input name="copaq28" type="radio"
						value="0" id="copaf28" /> 否</td>
				</tr>
				<tr>
					<td>29</td>
					<td class="lbf">不断地偷拿别人的东西，我感到刺激过瘾。</td>
					<td class="lb_option"><input name="copaq29" type="radio"
						value="1" id="copat29" /> 是</td>
					<td class="lb_option"><input name="copaq29" type="radio"
						value="0" id="copaf29" /> 否</td>
				</tr>
				<tr>
					<td>30</td>
					<td class="lbf">我总觉得谁都比我强。</td>
					<td class="lb_option"><input name="copaq30" type="radio"
						value="1" id="copat30" /> 是</td>
					<td class="lb_option"><input name="copaq30" type="radio"
						value="0" id="copaf30" /> 否</td>
				</tr>
				<tr>
					<td>31</td>
					<td class="lbf">我觉得大多数人是为了向上爬而不惜说谎。</td>
					<td class="lb_option"><input name="copaq31" type="radio"
						value="1" id="copat31" /> 是</td>
					<td class="lb_option"><input name="copaq31" type="radio"
						value="0" id="copaf31" /> 否</td>
				</tr>
				<tr>
					<td>32</td>
					<td class="lbf">我心中的忧虑很多。</td>
					<td class="lb_option"><input name="copaq32" type="radio"
						value="1" id="copat32" /> 是</td>
					<td class="lb_option"><input name="copaq32" type="radio"
						value="0" id="copaf32" /> 否</td>
				</tr>
				<tr>
					<td>33</td>
					<td class="lbf">我喜欢参加热闹的团体活动（如聚会）。</td>
					<td class="lb_option"><input name="copaq33" type="radio"
						value="1" id="copat33" /> 是</td>
					<td class="lb_option"><input name="copaq33" type="radio"
						value="0" id="copaf33" /> 否</td>
				</tr>
				<tr>
					<td>34</td>
					<td class="lbf">大家都说我做事情时点子多。</td>
					<td class="lb_option"><input name="copaq34" type="radio"
						value="1" id="copat34" /> 是</td>
					<td class="lb_option"><input name="copaq34" type="radio"
						value="0" id="copaf34" /> 否</td>
				</tr>
				<tr>
					<td>35</td>
					<td class="lbf">对伤害自己的人决不能手软。</td>
					<td class="lb_option"><input name="copaq35" type="radio"
						value="1" id="copat35" /> 是</td>
					<td class="lb_option"><input name="copaq35" type="radio"
						value="0" id="copaf35" /> 否</td>
				</tr>
				<tr>
					<td>36</td>
					<td class="lbf">我同情残疾人。</td>
					<td class="lb_option"><input name="copaq36" type="radio"
						value="1" id="copat36" /> 是</td>
					<td class="lb_option"><input name="copaq36" type="radio"
						value="0" id="copaf36" /> 否</td>
				</tr>
				<tr>
					<td>37</td>
					<td class="lbf">我总感到有些人在躲避我。</td>
					<td class="lb_option"><input name="copaq37" type="radio"
						value="1" id="copat37" /> 是</td>
					<td class="lb_option"><input name="copaq37" type="radio"
						value="0" id="copaf37" /> 否</td>
				</tr>
				<tr>
					<td>38</td>
					<td class="lbf">我说话做事喜欢随大流。</td>
					<td class="lb_option"><input name="copaq38" type="radio"
						value="1" id="copat38" /> 是</td>
					<td class="lb_option"><input name="copaq38" type="radio"
						value="0" id="copaf38" /> 否</td>
				</tr>
				<tr>
					<td>39</td>
					<td class="lbf">只要不被发现，做点坏事也不算什么。</td>
					<td class="lb_option"><input name="copaq39" type="radio"
						value="1" id="copat39" /> 是</td>
					<td class="lb_option"><input name="copaq39" type="radio"
						value="0" id="copaf39" /> 否</td>
				</tr>
				<tr>
					<td>40</td>
					<td class="lbf">我常常一会儿高兴，一会儿不高兴。</td>
					<td class="lb_option"><input name="copaq40" type="radio"
						value="1" id="copat40" /> 是</td>
					<td class="lb_option"><input name="copaq40" type="radio"
						value="0" id="copaf40" /> 否</td>
				</tr>
				<tr>
					<td>41</td>
					<td class="lbf">我的头脑中从来没有出现过坏的念头。</td>
					<td class="lb_option"><input name="copaq41" type="radio"
						value="1" id="copat41" /> 是</td>
					<td class="lb_option"><input name="copaq41" type="radio"
						value="0" id="copaf41" /> 否</td>
				</tr>
				<tr>
					<td>42</td>
					<td class="lbf">别人常说我是急性子。</td>
					<td class="lb_option"><input name="copaq42" type="radio"
						value="1" id="copat42" /> 是</td>
					<td class="lb_option"><input name="copaq42" type="radio"
						value="0" id="copaf42" /> 否</td>
				</tr>
				<tr>
					<td>43</td>
					<td class="lbf">“顺我者昌，逆我者亡”，应该成为人生的信条。</td>
					<td class="lb_option"><input name="copaq43" type="radio"
						value="1" id="copat43" /> 是</td>
					<td class="lb_option"><input name="copaq43" type="radio"
						value="0" id="copaf43" /> 否</td>
				</tr>
				<tr>
					<td>44</td>
					<td class="lbf">我对任何人都抱有戒心。</td>
					<td class="lb_option"><input name="copaq44" type="radio"
						value="1" id="copat44" /> 是</td>
					<td class="lb_option"><input name="copaq44" type="radio"
						value="0" id="copaf44" /> 否</td>
				</tr>
				<tr>
					<td>45</td>
					<td class="lbf">看到别人受伤害，我会感到特别高兴。</td>
					<td class="lb_option"><input name="copaq45" type="radio"
						value="1" id="copat45" /> 是</td>
					<td class="lb_option"><input name="copaq45" type="radio"
						value="0" id="copaf45" /> 否</td>
				</tr>
				<tr>
					<td>46</td>
					<td class="lbf">无论怎样做，我总是信心不足。</td>
					<td class="lb_option"><input name="copaq46" type="radio"
						value="1" id="copat46" /> 是</td>
					<td class="lb_option"><input name="copaq46" type="radio"
						value="0" id="copaf46" /> 否</td>
				</tr>
				<tr>
					<td>47</td>
					<td class="lbf">人与人之间总是在互相利用，很少有真诚的友谊。</td>
					<td class="lb_option"><input name="copaq47" type="radio"
						value="1" id="copat47" /> 是</td>
					<td class="lb_option"><input name="copaq47" type="radio"
						value="0" id="copaf47" /> 否</td>
				</tr>
				<tr>
					<td>48</td>
					<td class="lbf">我心里面老是不踏实。</td>
					<td class="lb_option"><input name="copaq48" type="radio"
						value="1" id="copat48" /> 是</td>
					<td class="lb_option"><input name="copaq48" type="radio"
						value="0" id="copaf48" /> 否</td>
				</tr>
				<tr>
					<td>49</td>
					<td class="lbf">结交新朋友时，我总是采取主动的态度。</td>
					<td class="lb_option"><input name="copaq49" type="radio"
						value="1" id="copat49" /> 是</td>
					<td class="lb_option"><input name="copaq49" type="radio"
						value="0" id="copaf49" /> 否</td>
				</tr>
				<tr>
					<td>50</td>
					<td class="lbf">我学新东西比较快。</td>
					<td class="lb_option"><input name="copaq50" type="radio"
						value="1" id="copat50" /> 是</td>
					<td class="lb_option"><input name="copaq50" type="radio"
						value="0" id="copaf50" /> 否</td>
				</tr>
				<tr>
					<td>51</td>
					<td class="lbf">迟早我会让我的仇人有后悔的时候。</td>
					<td class="lb_option"><input name="copaq51" type="radio"
						value="1" id="copat51" /> 是</td>
					<td class="lb_option"><input name="copaq51" type="radio"
						value="0" id="copaf51" /> 否</td>
				</tr>
				<tr>
					<td>52</td>
					<td class="lbf">我常被电视中的感人情节所感动。</td>
					<td class="lb_option"><input name="copaq52" type="radio"
						value="1" id="copat52" /> 是</td>
					<td class="lb_option"><input name="copaq52" type="radio"
						value="0" id="copaf52" /> 否</td>
				</tr>
				<tr>
					<td>53</td>
					<td class="lbf">我有时希望从别人的愤怒中得到快乐。</td>
					<td class="lb_option"><input name="copaq53" type="radio"
						value="1" id="copat53" /> 是</td>
					<td class="lb_option"><input name="copaq53" type="radio"
						value="0" id="copaf53" /> 否</td>
				</tr>
				<tr>
					<td>54</td>
					<td class="lbf">小组讨论时我常屈从于别人的观点。</td>
					<td class="lb_option"><input name="copaq54" type="radio"
						value="1" id="copat54" /> 是</td>
					<td class="lb_option"><input name="copaq54" type="radio"
						value="0" id="copaf54" /> 否</td>
				</tr>
				<tr>
					<td>55</td>
					<td class="lbf">“撑死胆大的，饿死胆小的”，这话说得一点没错。</td>
					<td class="lb_option"><input name="copaq55" type="radio"
						value="1" id="copat55" /> 是</td>
					<td class="lb_option"><input name="copaq55" type="radio"
						value="0" id="copaf55" /> 否</td>
				</tr>
				<tr>
					<td>56</td>
					<td class="lbf">即使是一点小事，也会使自己的情绪变得不好。</td>
					<td class="lb_option"><input name="copaq56" type="radio"
						value="1" id="copat56" /> 是</td>
					<td class="lb_option"><input name="copaq56" type="radio"
						value="0" id="copaf56" /> 否</td>
				</tr>
				<tr>
					<td>57</td>
					<td class="lbf">在商场无论看到多么好的东西，我都不想要。</td>
					<td class="lb_option"><input name="copaq57" type="radio"
						value="1" id="copat57" /> 是</td>
					<td class="lb_option"><input name="copaq57" type="radio"
						value="0" id="copaf57" /> 否</td>
				</tr>
				<tr>
					<td>58</td>
					<td class="lbf">我总爱追随着别人去干一些事情，很少考虑目的与后果。</td>
					<td class="lb_option"><input name="copaq58" type="radio"
						value="1" id="copat58" /> 是</td>
					<td class="lb_option"><input name="copaq58" type="radio"
						value="0" id="copaf58" /> 否</td>
				</tr>
				<tr>
					<td>59</td>
					<td class="lbf">假如我身怀武功绝技，我便会闯荡天下。</td>
					<td class="lb_option"><input name="copaq59" type="radio"
						value="1" id="copat59" /> 是</td>
					<td class="lb_option"><input name="copaq59" type="radio"
						value="0" id="copaf59" /> 否</td>
				</tr>
				<tr>
					<td>60</td>
					<td class="lbf">最安全的，是对谁也不要相信。</td>
					<td class="lb_option"><input name="copaq60" type="radio"
						value="1" id="copat60" /> 是</td>
					<td class="lb_option"><input name="copaq60" type="radio"
						value="0" id="copaf60" /> 否</td>
				</tr>
				<tr>
					<td>61</td>
					<td class="lbf">异性使用过的物品最具有刺激性。</td>
					<td class="lb_option"><input name="copaq61" type="radio"
						value="1" id="copat61" /> 是</td>
					<td class="lb_option"><input name="copaq61" type="radio"
						value="0" id="copaf61" /> 否</td>
				</tr>
				<tr>
					<td>62</td>
					<td class="lbf">我常常觉得自己真没用。</td>
					<td class="lb_option"><input name="copaq62" type="radio"
						value="1" id="copat62" /> 是</td>
					<td class="lb_option"><input name="copaq62" type="radio"
						value="0" id="copaf62" /> 否</td>
				</tr>
				<tr>
					<td>63</td>
					<td class="lbf">人与人交往都是在相互欺骗，以获得好处。</td>
					<td class="lb_option"><input name="copaq63" type="radio"
						value="1" id="copat63" /> 是</td>
					<td class="lb_option"><input name="copaq63" type="radio"
						value="0" id="copaf63" /> 否</td>
				</tr>
				<tr>
					<td>64</td>
					<td class="lbf">我有很多心事，心里总是七上八下的。</td>
					<td class="lb_option"><input name="copaq64" type="radio"
						value="1" id="copat64" /> 是</td>
					<td class="lb_option"><input name="copaq64" type="radio"
						value="0" id="copaf64" /> 否</td>
				</tr>
				<tr>
					<td>65</td>
					<td class="lbf">我结交的朋友很多。</td>
					<td class="lb_option"><input name="copaq65" type="radio"
						value="1" id="copat65" /> 是</td>
					<td class="lb_option"><input name="copaq65" type="radio"
						value="0" id="copaf65" /> 否</td>
				</tr>
				<tr>
					<td>66</td>
					<td class="lbf">我能在较强短的时间内，学会操作一种从没有使用过的机械。</td>
					<td class="lb_option"><input name="copaq66" type="radio"
						value="1" id="copat66" /> 是</td>
					<td class="lb_option"><input name="copaq66" type="radio"
						value="0" id="copaf66" /> 否</td>
				</tr>
				<tr>
					<td>67</td>
					<td class="lbf">报复他人后，心里才觉得出了一口气。</td>
					<td class="lb_option"><input name="copaq67" type="radio"
						value="1" id="copat67" /> 是</td>
					<td class="lb_option"><input name="copaq67" type="radio"
						value="0" id="copaf67" /> 否</td>
				</tr>
				<tr>
					<td>68</td>
					<td class="lbf">听到虐待老人或儿童的报道，我会十会气愤。</td>
					<td class="lb_option"><input name="copaq68" type="radio"
						value="1" id="copat68" /> 是</td>
					<td class="lb_option"><input name="copaq68" type="radio"
						value="0" id="copaf68" /> 否</td>
				</tr>
				<tr>
					<td>69</td>
					<td class="lbf">我能看见或听见别人感觉不到的奇怪现象。</td>
					<td class="lb_option"><input name="copaq69" type="radio"
						value="1" id="copat69" /> 是</td>
					<td class="lb_option"><input name="copaq69" type="radio"
						value="0" id="copaf69" /> 否</td>
				</tr>
				<tr>
					<td>70</td>
					<td class="lbf">有的事虽然自己想好了，但别人一说，我就会改变主意。</td>
					<td class="lb_option"><input name="copaq70" type="radio"
						value="1" id="copat70" /> 是</td>
					<td class="lb_option"><input name="copaq70" type="radio"
						value="0" id="copaf70" /> 否</td>
				</tr>
				<tr>
					<td>71</td>
					<td class="lbf">即使是不太好的事情，大多数人只要能得到好处就会做。</td>
					<td class="lb_option"><input name="copaq71" type="radio"
						value="1" id="copat71" /> 是</td>
					<td class="lb_option"><input name="copaq71" type="radio"
						value="0" id="copaf71" /> 否</td>
				</tr>
				<tr>
					<td>72</td>
					<td class="lbf">我属于那种容易大喜大悲的人。</td>
					<td class="lb_option"><input name="copaq72" type="radio"
						value="1" id="copat72" /> 是</td>
					<td class="lb_option"><input name="copaq72" type="radio"
						value="0" id="copaf72" /> 否</td>
				</tr>
				<tr>
					<td>73</td>
					<td class="lbf">无论遭受到多么不幸的打击，我都能不仇恨对方。</td>
					<td class="lb_option"><input name="copaq73" type="radio"
						value="1" id="copat73" /> 是</td>
					<td class="lb_option"><input name="copaq73" type="radio"
						value="0" id="copaf73" /> 否</td>
				</tr>
				<tr>
					<td>74</td>
					<td class="lbf">工作和学习中，我常常粗心大意。</td>
					<td class="lb_option"><input name="copaq74" type="radio"
						value="1" id="copat74" /> 是</td>
					<td class="lb_option"><input name="copaq74" type="radio"
						value="0" id="copaf74" /> 否</td>
				</tr>
				<tr>
					<td>75</td>
					<td class="lbf">我喜欢寻求刺激、找点乐，哪怕会挑起事端。</td>
					<td class="lb_option"><input name="copaq75" type="radio"
						value="1" id="copat75" /> 是</td>
					<td class="lb_option"><input name="copaq75" type="radio"
						value="0" id="copaf75" /> 否</td>
				</tr>
				<tr>
					<td>76</td>
					<td class="lbf">我提防那些对我过分亲近的人。</td>
					<td class="lb_option"><input name="copaq76" type="radio"
						value="1" id="copat76" /> 是</td>
					<td class="lb_option"><input name="copaq76" type="radio"
						value="0" id="copaf76" /> 否</td>
				</tr>
				<tr>
					<td>77</td>
					<td class="lbf">我喜欢折磨小动物。</td>
					<td class="lb_option"><input name="copaq77" type="radio"
						value="1" id="copat77" /> 是</td>
					<td class="lb_option"><input name="copaq77" type="radio"
						value="0" id="copaf77" /> 否</td>
				</tr>
				<tr>
					<td>78</td>
					<td class="lbf">在表现好的同事面前，我总感到非常不自在。</td>
					<td class="lb_option"><input name="copaq78" type="radio"
						value="1" id="copat78" /> 是</td>
					<td class="lb_option"><input name="copaq78" type="radio"
						value="0" id="copaf78" /> 否</td>
				</tr>
				<tr>
					<td>79</td>
					<td class="lbf">“人不利已，天诛地灭”，每个人只有对自己有利的事情才会去做。</td>
					<td class="lb_option"><input name="copaq79" type="radio"
						value="1" id="copat79" /> 是</td>
					<td class="lb_option"><input name="copaq79" type="radio"
						value="0" id="copaf79" /> 否</td>
				</tr>
				<tr>
					<td>80</td>
					<td class="lbf">我经常失眠，很容易惊醒。</td>
					<td class="lb_option"><input name="copaq80" type="radio"
						value="1" id="copat80" /> 是</td>
					<td class="lb_option"><input name="copaq80" type="radio"
						value="0" id="copaf80" /> 否</td>
				</tr>
				<tr>
					<td>81</td>
					<td class="lbf">我喜欢交朋友。</td>
					<td class="lb_option"><input name="copaq81" type="radio"
						value="1" id="copat81" /> 是</td>
					<td class="lb_option"><input name="copaq81" type="radio"
						value="0" id="copaf81" /> 否</td>
				</tr>
				<tr>
					<td>82</td>
					<td class="lbf">我属于善于思考、爱钻研的那类人。</td>
					<td class="lb_option"><input name="copaq82" type="radio"
						value="1" id="copat82" /> 是</td>
					<td class="lb_option"><input name="copaq82" type="radio"
						value="0" id="copaf82" /> 否</td>
				</tr>
				<tr>
					<td>83</td>
					<td class="lbf">谁要是侵犯了我，我不会轻易原谅（放过）他。</td>
					<td class="lb_option"><input name="copaq83" type="radio"
						value="1" id="copat83" /> 是</td>
					<td class="lb_option"><input name="copaq83" type="radio"
						value="0" id="copaf83" /> 否</td>
				</tr>
				<tr>
					<td>84</td>
					<td class="lbf">有人向我乞讨，我会给他们一点钱。</td>
					<td class="lb_option"><input name="copaq84" type="radio"
						value="1" id="copat84" /> 是</td>
					<td class="lb_option"><input name="copaq84" type="radio"
						value="0" id="copaf84" /> 否</td>
				</tr>
				<tr>
					<td>85</td>
					<td class="lbf">看到异性受到惊吓，我心里很兴奋。</td>
					<td class="lb_option"><input name="copaq85" type="radio"
						value="1" id="copat85" /> 是</td>
					<td class="lb_option"><input name="copaq85" type="radio"
						value="0" id="copaf85" /> 否</td>
				</tr>
				<tr>
					<td>86</td>
					<td class="lbf">在人群中，我属于自己没有什么主见的那类人。</td>
					<td class="lb_option"><input name="copaq86" type="radio"
						value="1" id="copat86" /> 是</td>
					<td class="lb_option"><input name="copaq86" type="radio"
						value="0" id="copaf86" /> 否</td>
				</tr>
				<tr>
					<td>87</td>
					<td class="lbf">又想学好，又很难改掉毛病。</td>
					<td class="lb_option"><input name="copaq87" type="radio"
						value="1" id="copat87" /> 是</td>
					<td class="lb_option"><input name="copaq87" type="radio"
						value="0" id="copaf87" /> 否</td>
				</tr>
				<tr>
					<td>88</td>
					<td class="lbf">只要情绪激动起来，我就很难平静下来。</td>
					<td class="lb_option"><input name="copaq88" type="radio"
						value="1" id="copat88" /> 是</td>
					<td class="lb_option"><input name="copaq88" type="radio"
						value="0" id="copaf88" /> 否</td>
				</tr>
				<tr>
					<td>89</td>
					<td class="lbf">我从未说过谎话。</td>
					<td class="lb_option"><input name="copaq89" type="radio"
						value="1" id="copat89" /> 是</td>
					<td class="lb_option"><input name="copaq89" type="radio"
						value="0" id="copaf89" /> 否</td>
				</tr>
				<tr>
					<td>90</td>
					<td class="lbf">稍不如意，我就会发脾气。</td>
					<td class="lb_option"><input name="copaq90" type="radio"
						value="1" id="copat90" /> 是</td>
					<td class="lb_option"><input name="copaq90" type="radio"
						value="0" id="copaf90" /> 否</td>
				</tr>
				<tr>
					<td>91</td>
					<td class="lbf">当看到别人打群架时，我会上前帮助熟悉的人。</td>
					<td class="lb_option"><input name="copaq91" type="radio"
						value="1" id="copat91" /> 是</td>
					<td class="lb_option"><input name="copaq91" type="radio"
						value="0" id="copaf91" /> 否</td>
				</tr>
				<tr>
					<td>92</td>
					<td class="lbf">我认为想接近我的人都别有用心。</td>
					<td class="lb_option"><input name="copaq92" type="radio"
						value="1" id="copat92" /> 是</td>
					<td class="lb_option"><input name="copaq92" type="radio"
						value="0" id="copaf92" /> 否</td>
				</tr>
				<tr>
					<td>93</td>
					<td class="lbf">有人想偷想我的思想和计划。</td>
					<td class="lb_option"><input name="copaq93" type="radio"
						value="1" id="copat93" /> 是</td>
					<td class="lb_option"><input name="copaq93" type="radio"
						value="0" id="copaf93" /> 否</td>
				</tr>
				<tr>
					<td>94</td>
					<td class="lbf">我很自卑。</td>
					<td class="lb_option"><input name="copaq94" type="radio"
						value="1" id="copat94" /> 是</td>
					<td class="lb_option"><input name="copaq94" type="radio"
						value="0" id="copaf94" /> 否</td>
				</tr>
				<tr>
					<td>95</td>
					<td class="lbf">不管对别人有没有损害，只要自己痛快就行。</td>
					<td class="lb_option"><input name="copaq95" type="radio"
						value="1" id="copat95" /> 是</td>
					<td class="lb_option"><input name="copaq95" type="radio"
						value="0" id="copaf95" /> 否</td>
				</tr>
				<tr>
					<td>96</td>
					<td class="lbf">我经常感到悲观失望，觉得活着没啥意思。</td>
					<td class="lb_option"><input name="copaq96" type="radio"
						value="1" id="copat96" /> 是</td>
					<td class="lb_option"><input name="copaq96" type="radio"
						value="0" id="copaf96" /> 否</td>
				</tr>
				<tr>
					<td>97</td>
					<td class="lbf">即使是初次见面的人，我也能与他（她）轻松地交谈。</td>
					<td class="lb_option"><input name="copaq97" type="radio"
						value="1" id="copat97" /> 是</td>
					<td class="lb_option"><input name="copaq97" type="radio"
						value="0" id="copaf97" /> 否</td>
				</tr>
				<tr>
					<td>98</td>
					<td class="lbf">别人都说我脑子好使，反应快。</td>
					<td class="lb_option"><input name="copaq98" type="radio"
						value="1" id="copat98" /> 是</td>
					<td class="lb_option"><input name="copaq98" type="radio"
						value="0" id="copaf98" /> 否</td>
				</tr>
				<tr>
					<td>99</td>
					<td class="lbf">我总觉得谁都比我强。</td>
					<td class="lb_option"><input name="copaq99" type="radio"
						value="1" id="copat99" /> 是</td>
					<td class="lb_option"><input name="copaq99" type="radio"
						value="0" id="copaf99" /> 否</td>
				</tr>
				<tr>
					<td>100</td>
					<td class="lbf">看到他人受骗上当，我会觉得很可怜。</td>
					<td class="lb_option"><input name="copaq100" type="radio"
						value="1" id="copat100" /> 是</td>
					<td class="lb_option"><input name="copaq100" type="radio"
						value="0" id="copaf100" /> 否</td>
				</tr>
				<tr>
					<td>101</td>
					<td class="lbf">假如别人认为我某些事情做法不合适，我很容易放弃。</td>
					<td class="lb_option"><input name="copaq101" type="radio"
						value="1" id="copat101" /> 是</td>
					<td class="lb_option"><input name="copaq101" type="radio"
						value="0" id="copaf101" /> 否</td>
				</tr>
				<tr>
					<td>102</td>
					<td class="lbf">我喜欢参加热闹的团体活动（如聚会）。</td>
					<td class="lb_option"><input name="copaq102" type="radio"
						value="1" id="copat102" /> 是</td>
					<td class="lb_option"><input name="copaq102" type="radio"
						value="0" id="copaf102" /> 否</td>
				</tr>
				<tr>
					<td>103</td>
					<td class="lbf">我的心情很容易受到周围（人和事）的影响。</td>
					<td class="lb_option"><input name="copaq103" type="radio"
						value="1" id="copat103" /> 是</td>
					<td class="lb_option"><input name="copaq103" type="radio"
						value="0" id="copaf103" /> 否</td>
				</tr>
				<tr>
					<td>104</td>
					<td class="lbf">在我认识的长辈里，个个我都喜欢。</td>
					<td class="lb_option"><input name="copaq104" type="radio"
						value="1" id="copat104" /> 是</td>
					<td class="lb_option"><input name="copaq104" type="radio"
						value="0" id="copaf104" /> 否</td>
				</tr>
				<tr>
					<td>105</td>
					<td class="lbf">我对某些问题很敏感，只要一提就会发火。</td>
					<td class="lb_option"><input name="copaq105" type="radio"
						value="1" id="copat105" /> 是</td>
					<td class="lb_option"><input name="copaq105" type="radio"
						value="0" id="copaf105" /> 否</td>
				</tr>
				<tr>
					<td>106</td>
					<td class="lbf">和别人相处时，我总怕被别人利用。</td>
					<td class="lb_option"><input name="copaq106" type="radio"
						value="1" id="copat106" /> 是</td>
					<td class="lb_option"><input name="copaq106" type="radio"
						value="0" id="copaf106" /> 否</td>
				</tr>
				<tr>
					<td>107</td>
					<td class="lbf">我说话做事喜欢随大流。</td>
					<td class="lb_option"><input name="copaq107" type="radio"
						value="1" id="copat107" /> 是</td>
					<td class="lb_option"><input name="copaq107" type="radio"
						value="0" id="copaf107" /> 否</td>
				</tr>
				<tr>
					<td>108</td>
					<td class="lbf">我一个人干工作时，总是担心自己会失败。</td>
					<td class="lb_option"><input name="copaq108" type="radio"
						value="1" id="copat108" /> 是</td>
					<td class="lb_option"><input name="copaq108" type="radio"
						value="0" id="copaf108" /> 否</td>
				</tr>
				<tr>
					<td>109</td>
					<td class="lbf">我常常为自己的将来而心烦忧虑。</td>
					<td class="lb_option"><input name="copaq109" type="radio"
						value="1" id="copat109" /> 是</td>
					<td class="lb_option"><input name="copaq109" type="radio"
						value="0" id="copaf109" /> 否</td>
				</tr>
				<tr>
					<td>110</td>
					<td class="lbf">我爱开玩笑，在许多场合都有说有笑。</td>
					<td class="lb_option"><input name="copaq110" type="radio"
						value="1" id="copat110" /> 是</td>
					<td class="lb_option"><input name="copaq110" type="radio"
						value="0" id="copaf110" /> 否</td>
				</tr>
				<tr>
					<td>111</td>
					<td class="lbf">我有爱思考问题的习惯。</td>
					<td class="lb_option"><input name="copaq111" type="radio"
						value="1" id="copat111" /> 是</td>
					<td class="lb_option"><input name="copaq111" type="radio"
						value="0" id="copaf111" /> 否</td>
				</tr>
				<tr>
					<td>112</td>
					<td class="lbf">别人常说我是急性子。</td>
					<td class="lb_option"><input name="copaq112" type="radio"
						value="1" id="copat112" /> 是</td>
					<td class="lb_option"><input name="copaq112" type="radio"
						value="0" id="copaf112" /> 否</td>
				</tr>
				<tr>
					<td>113</td>
					<td class="lbf">看到年老体弱的人上车，我会主动让座。</td>
					<td class="lb_option"><input name="copaq113" type="radio"
						value="1" id="copat113" /> 是</td>
					<td class="lb_option"><input name="copaq113" type="radio"
						value="0" id="copaf113" /> 否</td>
				</tr>
				<tr>
					<td>114</td>
					<td class="lbf">如果大家都同意办某件事，那我也会表示同意。</td>
					<td class="lb_option"><input name="copaq114" type="radio"
						value="1" id="copat114" /> 是</td>
					<td class="lb_option"><input name="copaq114" type="radio"
						value="0" id="copaf114" /> 否</td>
				</tr>
				<tr>
					<td>115</td>
					<td class="lbf">我学新东西比较快。</td>
					<td class="lb_option"><input name="copaq115" type="radio"
						value="1" id="copat115" /> 是</td>
					<td class="lb_option"><input name="copaq115" type="radio"
						value="0" id="copaf115" /> 否</td>
				</tr>
				<tr>
					<td>116</td>
					<td class="lbf">我的心情很容易转变，变化无常。</td>
					<td class="lb_option"><input name="copaq116" type="radio"
						value="1" id="copat116" /> 是</td>
					<td class="lb_option"><input name="copaq116" type="radio"
						value="0" id="copaf116" /> 否</td>
				</tr>
				<tr>
					<td>117</td>
					<td class="lbf">受到批评时，哪怕是冤枉的，我也觉得是在关心我。</td>
					<td class="lb_option"><input name="copaq117" type="radio"
						value="1" id="copat117" /> 是</td>
					<td class="lb_option"><input name="copaq117" type="radio"
						value="0" id="copaf117" /> 否</td>
				</tr>
				<tr>
					<td>118</td>
					<td class="lbf">通常我想做什么就去做，属于沉不住气的那种类型。</td>
					<td class="lb_option"><input name="copaq118" type="radio"
						value="1" id="copat118" /> 是</td>
					<td class="lb_option"><input name="copaq118" type="radio"
						value="0" id="copaf118" /> 否</td>
				</tr>
				<tr>
					<td>119</td>
					<td class="lbf">世上有很多不可信任的人。</td>
					<td class="lb_option"><input name="copaq119" type="radio"
						value="1" id="copat119" /> 是</td>
					<td class="lb_option"><input name="copaq119" type="radio"
						value="0" id="copaf119" /> 否</td>
				</tr>
				<tr>
					<td>120</td>
					<td class="lbf">即使是一点小事，也会使自己情绪变得不好。</td>
					<td class="lb_option"><input name="copaq120" type="radio"
						value="1" id="copat120" /> 是</td>
					<td class="lb_option"><input name="copaq120" type="radio"
						value="0" id="copaf120" /> 否</td>
				</tr>
				<tr>
					<td>121</td>
					<td class="lbf">在大众场合，我总是很少说话，以免被别人笑话。</td>
					<td class="lb_option"><input name="copaq121" type="radio"
						value="1" id="copat121" /> 是</td>
					<td class="lb_option"><input name="copaq121" type="radio"
						value="0" id="copaf121" /> 否</td>
				</tr>
				<tr>
					<td>122</td>
					<td class="lbf">即使我非常高兴时，也总是伴有一种大祸临头的恐惧。</td>
					<td class="lb_option"><input name="copaq122" type="radio"
						value="1" id="copat122" /> 是</td>
					<td class="lb_option"><input name="copaq122" type="radio"
						value="0" id="copaf122" /> 否</td>
				</tr>


			</table>
            </div> 
            <div class="lb_zf">总得分：<span>88</span></div> 
			<div style="text-align: center; padding-bottom:10px">
			
				  <button style="font-size: 20px;">下载</button>
				  <button style="font-size: 20px;">打印</button>
                  
                </div>
            </div>

  
    
</body>
</html>