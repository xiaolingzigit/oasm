<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>新收押罪犯量表</title>
</head>
<body>
  <div class="return_btn" >
       <a href="#" onclick="loadnex3('/oasm/dafxView/rj_xszf')">《 返回</a>	
    </div>
     <div class="rs_table">
        <div class="rs_table_title"><h1>新收押罪犯量表结果表</h1></div>
        <div class="table_msg" >
                <table>
               <tr>
				<td class="xx_td01">姓名</td>
				<td class="xx_td02">xx</td>
				<td class="xx_td01">囚号</td>
				<td  class="xx_td02 xx_number" onclick="loadnext3('/oasm/dafxView/criminalinfo')" >6546545454</td>
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
		<table style="width:100%">

			<tr>
				<th class="base_th" width="5%" style="background: #65bbed;">序号</th>
				<th class="base_th" width="10%" style="background: #65bbed;">题目</th>
				<th class="base_th" width="5%" style="background: #65bbed;">同意</th>
				<th class="base_th" width="5%" style="background: #65bbed;">基本同意</th>
				<th class="base_th" width="5%" style="background: #65bbed;">不确定</th>
				<th class="base_th" width="5%" style="background: #65bbed;">基本同意</th>
				<th class="base_th" width="5%" style="background: #65bbed;">不同意</th>
			</tr>
		</table>
	</div>
     <div class="base_table cs-table" style="overflow-x: auto; overflow-y: auto; height: 500px;">

		<table>
        <colgroup>
            <col width="5%">
            <col width="10%">
            <col width="5%">
			<col width="5%">
			<col width="5%">
			<col width="5%">
			<col width="5%">
        </colgroup>
			<tr>
				<td>1</td>
				<td>我从没骗过别人</td>
				<td><input name="question1" type="radio" value="" /></td>
				<td><input name="question1" type="radio" value="" /></td>
				<td><input name="question1" type="radio" value="" /></td>
				<td><input name="question1" type="radio" value="" /></td>
				<td><input name="question1" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>2</td>
				<td>要想过得好，就要靠关系和后台</td>
				<td><input name="question2" type="radio" value="" /></td>
				<td><input name="question2" type="radio" value="" /></td>
				<td><input name="question2" type="radio" value="" /></td>
				<td><input name="question2" type="radio" value="" /></td>
				<td><input name="question2" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>3</td>
				<td>尽快花点钱找点关系，想办法早点出去</td>
				<td><input name="question3" type="radio" value="" /></td>
				<td><input name="question3" type="radio" value="" /></td>
				<td><input name="question3" type="radio" value="" /></td>
				<td><input name="question3" type="radio" value="" /></td>
				<td><input name="question3" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>4</td>
				<td>我的心情容易受环境影响</td>
				<td><input name="question4" type="radio" value="" /></td>
				<td><input name="question4" type="radio" value="" /></td>
				<td><input name="question4" type="radio" value="" /></td>
				<td><input name="question4" type="radio" value="" /></td>
				<td><input name="question4" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>5</td>
				<td>我容易被一些意外的小事所烦恼</td>
				<td><input name="question5" type="radio" value="" /></td>
				<td><input name="question5" type="radio" value="" /></td>
				<td><input name="question5" type="radio" value="" /></td>
				<td><input name="question5" type="radio" value="" /></td>
				<td><input name="question5" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>6</td>
				<td>劳动改造谈不上学习技术</td>
				<td><input name="question6" type="radio" value="" /></td>
				<td><input name="question6" type="radio" value="" /></td>
				<td><input name="question6" type="radio" value="" /></td>
				<td><input name="question6" type="radio" value="" /></td>
				<td><input name="question6" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>7</td>
				<td>牢都坐了，没必要再去拼命劳动</td>
				<td><input name="question7" type="radio" value="" /></td>
				<td><input name="question7" type="radio" value="" /></td>
				<td><input name="question7" type="radio" value="" /></td>
				<td><input name="question7" type="radio" value="" /></td>
				<td><input name="question7" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>8</td>
				<td>我与朋友经常保持联系</td>
				<td><input name="question8" type="radio" value="" /></td>
				<td><input name="question8" type="radio" value="" /></td>
				<td><input name="question8" type="radio" value="" /></td>
				<td><input name="question8" type="radio" value="" /></td>
				<td><input name="question8" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>9</td>
				<td>我与家人经常保持联系</td>
				<td><input name="question9" type="radio" value="" /></td>
				<td><input name="question9" type="radio" value="" /></td>
				<td><input name="question9" type="radio" value="" /></td>
				<td><input name="question9" type="radio" value="" /></td>
				<td><input name="question9" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>10</td>
				<td>现在很想打人</td>
				<td><input name="question10" type="radio" value="" /></td>
				<td><input name="question10" type="radio" value="" /></td>
				<td><input name="question10" type="radio" value="" /></td>
				<td><input name="question10" type="radio" value="" /></td>
				<td><input name="question10" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>11</td>
				<td>犯人组长总是喜欢小题大作</td>
				<td><input name="question11" type="radio" value="" /></td>
				<td><input name="question11" type="radio" value="" /></td>
				<td><input name="question11" type="radio" value="" /></td>
				<td><input name="question11" type="radio" value="" /></td>
				<td><input name="question11" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>12</td>
				<td>我实在难以忍受与其他罪犯挤在一起</td>
				<td><input name="question12" type="radio" value="" /></td>
				<td><input name="question12" type="radio" value="" /></td>
				<td><input name="question12" type="radio" value="" /></td>
				<td><input name="question12" type="radio" value="" /></td>
				<td><input name="question12" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>13</td>
				<td>我感到自己已经是个彻底的失败者</td>
				<td><input name="question13" type="radio" value="" /></td>
				<td><input name="question13" type="radio" value="" /></td>
				<td><input name="question13" type="radio" value="" /></td>
				<td><input name="question13" type="radio" value="" /></td>
				<td><input name="question13" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>14</td>
				<td>我对今后的生活已经完全失去了希望</td>
				<td><input name="question14" type="radio" value="" /></td>
				<td><input name="question14" type="radio" value="" /></td>
				<td><input name="question14" type="radio" value="" /></td>
				<td><input name="question14" type="radio" value="" /></td>
				<td><input name="question14" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>15</td>
				<td>谁跟我过不去，我就让谁没好日子过</td>
				<td><input name="question15" type="radio" value="" /></td>
				<td><input name="question15" type="radio" value="" /></td>
				<td><input name="question15" type="radio" value="" /></td>
				<td><input name="question15" type="radio" value="" /></td>
				<td><input name="question15" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>16</td>
				<td>有仇不报非君子</td>
				<td><input name="question16" type="radio" value="" /></td>
				<td><input name="question16" type="radio" value="" /></td>
				<td><input name="question16" type="radio" value="" /></td>
				<td><input name="question16" type="radio" value="" /></td>
				<td><input name="question16" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>17</td>
				<td>惊险的场面常使我兴奋不已</td>
				<td><input name="question17" type="radio" value="" /></td>
				<td><input name="question17" type="radio" value="" /></td>
				<td><input name="question17" type="radio" value="" /></td>
				<td><input name="question17" type="radio" value="" /></td>
				<td><input name="question17" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>18</td>
				<td>我喜欢看惊险小说（或电影）</td>
				<td><input name="question18" type="radio" value="" /></td>
				<td><input name="question18" type="radio" value="" /></td>
				<td><input name="question18" type="radio" value="" /></td>
				<td><input name="question18" type="radio" value="" /></td>
				<td><input name="question18" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>19</td>
				<td>适当的时候生一场病，对自己是件好事</td>
				<td><input name="question19" type="radio" value="" /></td>
				<td><input name="question19" type="radio" value="" /></td>
				<td><input name="question19" type="radio" value="" /></td>
				<td><input name="question19" type="radio" value="" /></td>
				<td><input name="question19" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>20</td>
				<td>有时候多亏生病，自己才避开了很多麻烦</td>
				<td><input name="question20" type="radio" value="" /></td>
				<td><input name="question20" type="radio" value="" /></td>
				<td><input name="question20" type="radio" value="" /></td>
				<td><input name="question20" type="radio" value="" /></td>
				<td><input name="question20" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>21</td>
				<td>我从来都不对别人的事评头论足</td>
				<td><input name="question21" type="radio" value="" /></td>
				<td><input name="question21" type="radio" value="" /></td>
				<td><input name="question21" type="radio" value="" /></td>
				<td><input name="question21" type="radio" value="" /></td>
				<td><input name="question21" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>22</td>
				<td>人无横财不富，马无夜草不肥</td>
				<td><input name="question22" type="radio" value="" /></td>
				<td><input name="question22" type="radio" value="" /></td>
				<td><input name="question22" type="radio" value="" /></td>
				<td><input name="question22" type="radio" value="" /></td>
				<td><input name="question22" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>23</td>
				<td>一个人只要有了权，就会很快弄到钱</td>
				<td><input name="question23" type="radio" value="" /></td>
				<td><input name="question23" type="radio" value="" /></td>
				<td><input name="question23" type="radio" value="" /></td>
				<td><input name="question23" type="radio" value="" /></td>
				<td><input name="question23" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>24</td>
				<td>有权不用，过期作废</td>
				<td><input name="question24" type="radio" value="" /></td>
				<td><input name="question24" type="radio" value="" /></td>
				<td><input name="question24" type="radio" value="" /></td>
				<td><input name="question24" type="radio" value="" /></td>
				<td><input name="question24" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>25</td>
				<td>遇到挫折，我不知怎么办才好</td>
				<td><input name="question25" type="radio" value="" /></td>
				<td><input name="question25" type="radio" value="" /></td>
				<td><input name="question25" type="radio" value="" /></td>
				<td><input name="question25" type="radio" value="" /></td>
				<td><input name="question25" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>26</td>
				<td>有时明知是胡思乱想，自己却控制不住</td>
				<td><input name="question26" type="radio" value="" /></td>
				<td><input name="question26" type="radio" value="" /></td>
				<td><input name="question26" type="radio" value="" /></td>
				<td><input name="question26" type="radio" value="" /></td>
				<td><input name="question26" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>27</td>
				<td>只要完成劳动任务就行了，再多做也没用</td>
				<td><input name="question27" type="radio" value="" /></td>
				<td><input name="question27" type="radio" value="" /></td>
				<td><input name="question27" type="radio" value="" /></td>
				<td><input name="question27" type="radio" value="" /></td>
				<td><input name="question27" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>28</td>
				<td>服刑人员做的产品，难以保证质量</td>
				<td><input name="question28" type="radio" value="" /></td>
				<td><input name="question28" type="radio" value="" /></td>
				<td><input name="question28" type="radio" value="" /></td>
				<td><input name="question28" type="radio" value="" /></td>
				<td><input name="question28" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>29</td>
				<td>我与家人感情一直很好，很稳定</td>
				<td><input name="question29" type="radio" value="" /></td>
				<td><input name="question29" type="radio" value="" /></td>
				<td><input name="question29" type="radio" value="" /></td>
				<td><input name="question29" type="radio" value="" /></td>
				<td><input name="question29" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>30</td>
				<td>被捕以来，我曾得到过朋友或单位的帮助</td>
				<td><input name="question30" type="radio" value="" /></td>
				<td><input name="question30" type="radio" value="" /></td>
				<td><input name="question30" type="radio" value="" /></td>
				<td><input name="question30" type="radio" value="" /></td>
				<td><input name="question30" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>31</td>
				<td>我很想大叫或摔东西</td>
				<td><input name="question31" type="radio" value="" /></td>
				<td><input name="question31" type="radio" value="" /></td>
				<td><input name="question31" type="radio" value="" /></td>
				<td><input name="question31" type="radio" value="" /></td>
				<td><input name="question31" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>32</td>
				<td>看到不顺眼的人，就想教训他一顿</td>
				<td><input name="question32" type="radio" value="" /></td>
				<td><input name="question32" type="radio" value="" /></td>
				<td><input name="question32" type="radio" value="" /></td>
				<td><input name="question32" type="radio" value="" /></td>
				<td><input name="question32" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>33</td>
				<td>我对未来感到灰心、悲观、失望，活下去感到很累</td>
				<td><input name="question33" type="radio" value="" /></td>
				<td><input name="question33" type="radio" value="" /></td>
				<td><input name="question33" type="radio" value="" /></td>
				<td><input name="question33" type="radio" value="" /></td>
				<td><input name="question33" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>34</td>
				<td>我运气不好，也不相信今后会交好运</td>
				<td><input name="question34" type="radio" value="" /></td>
				<td><input name="question34" type="radio" value="" /></td>
				<td><input name="question34" type="radio" value="" /></td>
				<td><input name="question34" type="radio" value="" /></td>
				<td><input name="question34" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>35</td>
				<td>做人不能太心慈手软</td>
				<td><input name="question35" type="radio" value="" /></td>
				<td><input name="question35" type="radio" value="" /></td>
				<td><input name="question35" type="radio" value="" /></td>
				<td><input name="question35" type="radio" value="" /></td>
				<td><input name="question35" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>36</td>
				<td>曾经失去的，要加倍要回来</td>
				<td><input name="question36" type="radio" value="" /></td>
				<td><input name="question36" type="radio" value="" /></td>
				<td><input name="question36" type="radio" value="" /></td>
				<td><input name="question36" type="radio" value="" /></td>
				<td><input name="question36" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>37</td>
				<td>能得到别人得不到的东西，冒点风险也值得</td>
				<td><input name="question37" type="radio" value="" /></td>
				<td><input name="question37" type="radio" value="" /></td>
				<td><input name="question37" type="radio" value="" /></td>
				<td><input name="question37" type="radio" value="" /></td>
				<td><input name="question37" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>38</td>
				<td>经常冒险可以提高一个人的应变能力</td>
				<td><input name="question38" type="radio" value="" /></td>
				<td><input name="question38" type="radio" value="" /></td>
				<td><input name="question38" type="radio" value="" /></td>
				<td><input name="question38" type="radio" value="" /></td>
				<td><input name="question38" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>39</td>
				<td>我发觉周围的病犯都过得挺好</td>
				<td><input name="question39" type="radio" value="" /></td>
				<td><input name="question39" type="radio" value="" /></td>
				<td><input name="question39" type="radio" value="" /></td>
				<td><input name="question39" type="radio" value="" /></td>
				<td><input name="question39" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>40</td>
				<td>我曾经因为生病而避免被别人责骂</td>
				<td><input name="question40" type="radio" value="" /></td>
				<td><input name="question40" type="radio" value="" /></td>
				<td><input name="question40" type="radio" value="" /></td>
				<td><input name="question40" type="radio" value="" /></td>
				<td><input name="question40" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>41</td>
				<td>我从不谈论别人的是非</td>
				<td><input name="question41" type="radio" value="" /></td>
				<td><input name="question41" type="radio" value="" /></td>
				<td><input name="question41" type="radio" value="" /></td>
				<td><input name="question41" type="radio" value="" /></td>
				<td><input name="question41" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>42</td>
				<td>想在社会上混出名堂，没有哥们义气不行</td>
				<td><input name="question42" type="radio" value="" /></td>
				<td><input name="question42" type="radio" value="" /></td>
				<td><input name="question42" type="radio" value="" /></td>
				<td><input name="question42" type="radio" value="" /></td>
				<td><input name="question42" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>43</td>
				<td>定罪量刑都是法院说了算，不服也没办法</td>
				<td><input name="question43" type="radio" value="" /></td>
				<td><input name="question43" type="radio" value="" /></td>
				<td><input name="question43" type="radio" value="" /></td>
				<td><input name="question43" type="radio" value="" /></td>
				<td><input name="question43" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>44</td>
				<td>钱也赔了还要坐牢，真是赔了夫人又折兵</td>
				<td><input name="question44" type="radio" value="" /></td>
				<td><input name="question44" type="radio" value="" /></td>
				<td><input name="question44" type="radio" value="" /></td>
				<td><input name="question44" type="radio" value="" /></td>
				<td><input name="question44" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>45</td>
				<td>我不知道为什么经常感到头痛头昏</td>
				<td><input name="question45" type="radio" value="" /></td>
				<td><input name="question45" type="radio" value="" /></td>
				<td><input name="question45" type="radio" value="" /></td>
				<td><input name="question45" type="radio" value="" /></td>
				<td><input name="question45" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>46</td>
				<td>我总感到自己有病，可又说不清</td>
				<td><input name="question46" type="radio" value="" /></td>
				<td><input name="question46" type="radio" value="" /></td>
				<td><input name="question46" type="radio" value="" /></td>
				<td><input name="question46" type="radio" value="" /></td>
				<td><input name="question46" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>47</td>
				<td>监狱劳动报酬太低了，提不起精神</td>
				<td><input name="question47" type="radio" value="" /></td>
				<td><input name="question47" type="radio" value="" /></td>
				<td><input name="question47" type="radio" value="" /></td>
				<td><input name="question47" type="radio" value="" /></td>
				<td><input name="question47" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>48</td>
				<td>监狱劳动保护是形式，所以不必当真</td>
				<td><input name="question48" type="radio" value="" /></td>
				<td><input name="question48" type="radio" value="" /></td>
				<td><input name="question48" type="radio" value="" /></td>
				<td><input name="question48" type="radio" value="" /></td>
				<td><input name="question48" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>49</td>
				<td>烦闷的时候，得到过警官、他犯的安慰和帮助</td>
				<td><input name="question49" type="radio" value="" /></td>
				<td><input name="question49" type="radio" value="" /></td>
				<td><input name="question49" type="radio" value="" /></td>
				<td><input name="question49" type="radio" value="" /></td>
				<td><input name="question49" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>50</td>
				<td>遇到困难时，我会向警官寻求帮助</td>
				<td><input name="question50" type="radio" value="" /></td>
				<td><input name="question50" type="radio" value="" /></td>
				<td><input name="question50" type="radio" value="" /></td>
				<td><input name="question50" type="radio" value="" /></td>
				<td><input name="question50" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>51</td>
				<td>看什么都不顺眼，都觉得烦</td>
				<td><input name="question51" type="radio" value="" /></td>
				<td><input name="question51" type="radio" value="" /></td>
				<td><input name="question51" type="radio" value="" /></td>
				<td><input name="question51" type="radio" value="" /></td>
				<td><input name="question51" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>52</td>
				<td>警官处理某些事情有失公平</td>
				<td><input name="question52" type="radio" value="" /></td>
				<td><input name="question52" type="radio" value="" /></td>
				<td><input name="question52" type="radio" value="" /></td>
				<td><input name="question52" type="radio" value="" /></td>
				<td><input name="question52" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>53</td>
				<td>管理太严太紧张了，有机会真想发泄一下</td>
				<td><input name="question53" type="radio" value="" /></td>
				<td><input name="question53" type="radio" value="" /></td>
				<td><input name="question53" type="radio" value="" /></td>
				<td><input name="question53" type="radio" value="" /></td>
				<td><input name="question53" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>54</td>
				<td>我常幻想一个人死的方式</td>
				<td><input name="question54" type="radio" value="" /></td>
				<td><input name="question54" type="radio" value="" /></td>
				<td><input name="question54" type="radio" value="" /></td>
				<td><input name="question54" type="radio" value="" /></td>
				<td><input name="question54" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>55</td>
				<td>我觉得自己是别人的负担，我死了别人会过得更好</td>
				<td><input name="question55" type="radio" value="" /></td>
				<td><input name="question55" type="radio" value="" /></td>
				<td><input name="question55" type="radio" value="" /></td>
				<td><input name="question55" type="radio" value="" /></td>
				<td><input name="question55" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>56</td>
				<td>我活得太累了，总想找个机会早些自我结束</td>
				<td><input name="question56" type="radio" value="" /></td>
				<td><input name="question56" type="radio" value="" /></td>
				<td><input name="question56" type="radio" value="" /></td>
				<td><input name="question56" type="radio" value="" /></td>
				<td><input name="question56" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>57</td>
				<td>拒绝过我的人，也要让他尝尝被拒绝的滋味</td>
				<td><input name="question57" type="radio" value="" /></td>
				<td><input name="question57" type="radio" value="" /></td>
				<td><input name="question57" type="radio" value="" /></td>
				<td><input name="question57" type="radio" value="" /></td>
				<td><input name="question57" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>58</td>
				<td>人若犯我，我一定也会给他点颜色瞧瞧</td>
				<td><input name="question58" type="radio" value="" /></td>
				<td><input name="question58" type="radio" value="" /></td>
				<td><input name="question58" type="radio" value="" /></td>
				<td><input name="question58" type="radio" value="" /></td>
				<td><input name="question58" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>59</td>
				<td>宁愿担些风险，也不想错过任何机会</td>
				<td><input name="question59" type="radio" value="" /></td>
				<td><input name="question59" type="radio" value="" /></td>
				<td><input name="question59" type="radio" value="" /></td>
				<td><input name="question59" type="radio" value="" /></td>
				<td><input name="question59" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>60</td>
				<td>我对禁止的东西，特别想弄个明白</td>
				<td><input name="question60" type="radio" value="" /></td>
				<td><input name="question60" type="radio" value="" /></td>
				<td><input name="question60" type="radio" value="" /></td>
				<td><input name="question60" type="radio" value="" /></td>
				<td><input name="question60" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>61</td>
				<td>遇到解决不了的困难时，我会突然生些莫名其妙的病</td>
				<td><input name="question61" type="radio" value="" /></td>
				<td><input name="question61" type="radio" value="" /></td>
				<td><input name="question61" type="radio" value="" /></td>
				<td><input name="question61" type="radio" value="" /></td>
				<td><input name="question61" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>62</td>
				<td>犯人一旦生病，警官的管理和要求就会宽松多了</td>
				<td><input name="question62" type="radio" value="" /></td>
				<td><input name="question62" type="radio" value="" /></td>
				<td><input name="question62" type="radio" value="" /></td>
				<td><input name="question62" type="radio" value="" /></td>
				<td><input name="question62" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>63</td>
				<td>我从未有过非分的念头</td>
				<td><input name="question63" type="radio" value="" /></td>
				<td><input name="question63" type="radio" value="" /></td>
				<td><input name="question63" type="radio" value="" /></td>
				<td><input name="question63" type="radio" value="" /></td>
				<td><input name="question63" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>64</td>
				<td>劳动、训练、学习已经够累了，管别人干什么</td>
				<td><input name="question64" type="radio" value="" /></td>
				<td><input name="question64" type="radio" value="" /></td>
				<td><input name="question64" type="radio" value="" /></td>
				<td><input name="question64" type="radio" value="" /></td>
				<td><input name="question64" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>65</td>
				<td>规矩太多了，令人不痛快</td>
				<td><input name="question65" type="radio" value="" /></td>
				<td><input name="question65" type="radio" value="" /></td>
				<td><input name="question65" type="radio" value="" /></td>
				<td><input name="question65" type="radio" value="" /></td>
				<td><input name="question65" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>66</td>
				<td>管它是对是错，只要对自己有利就行</td>
				<td><input name="question66" type="radio" value="" /></td>
				<td><input name="question66" type="radio" value="" /></td>
				<td><input name="question66" type="radio" value="" /></td>
				<td><input name="question66" type="radio" value="" /></td>
				<td><input name="question66" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>67</td>
				<td>我总是睡不好</td>
				<td><input name="question67" type="radio" value="" /></td>
				<td><input name="question67" type="radio" value="" /></td>
				<td><input name="question67" type="radio" value="" /></td>
				<td><input name="question67" type="radio" value="" /></td>
				<td><input name="question67" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>68</td>
				<td>有时候我感到脑子突然一片空白，什么都想不起来</td>
				<td><input name="question68" type="radio" value="" /></td>
				<td><input name="question68" type="radio" value="" /></td>
				<td><input name="question68" type="radio" value="" /></td>
				<td><input name="question68" type="radio" value="" /></td>
				<td><input name="question68" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>69</td>
				<td>完不成劳动产值时，跟别人买一点也行</td>
				<td><input name="question69" type="radio" value="" /></td>
				<td><input name="question69" type="radio" value="" /></td>
				<td><input name="question69" type="radio" value="" /></td>
				<td><input name="question69" type="radio" value="" /></td>
				<td><input name="question69" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>70</td>
				<td>劳动改造与思想教育没什么关系</td>
				<td><input name="question70" type="radio" value="" /></td>
				<td><input name="question70" type="radio" value="" /></td>
				<td><input name="question70" type="radio" value="" /></td>
				<td><input name="question70" type="radio" value="" /></td>
				<td><input name="question70" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>71</td>
				<td>我能够经常得到别人的关心和帮助</td>
				<td><input name="question71" type="radio" value="" /></td>
				<td><input name="question71" type="radio" value="" /></td>
				<td><input name="question71" type="radio" value="" /></td>
				<td><input name="question71" type="radio" value="" /></td>
				<td><input name="question71" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>72</td>
				<td>我与周围的大多数人能够做到互相关心</td>
				<td><input name="question72" type="radio" value="" /></td>
				<td><input name="question72" type="radio" value="" /></td>
				<td><input name="question72" type="radio" value="" /></td>
				<td><input name="question72" type="radio" value="" /></td>
				<td><input name="question72" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>73</td>
				<td>我感到烦躁或愤怒时，很想找人发泄</td>
				<td><input name="question73" type="radio" value="" /></td>
				<td><input name="question73" type="radio" value="" /></td>
				<td><input name="question73" type="radio" value="" /></td>
				<td><input name="question73" type="radio" value="" /></td>
				<td><input name="question73" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>74</td>
				<td>当我针对你时，你的灾难就开始了</td>
				<td><input name="question74" type="radio" value="" /></td>
				<td><input name="question74" type="radio" value="" /></td>
				<td><input name="question74" type="radio" value="" /></td>
				<td><input name="question74" type="radio" value="" /></td>
				<td><input name="question74" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>75</td>
				<td>我常想与死有关的问题</td>
				<td><input name="question75" type="radio" value="" /></td>
				<td><input name="question75" type="radio" value="" /></td>
				<td><input name="question75" type="radio" value="" /></td>
				<td><input name="question75" type="radio" value="" /></td>
				<td><input name="question75" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>76</td>
				<td>现实的一切让我心灰意冷，内心很苦闷</td>
				<td><input name="question76" type="radio" value="" /></td>
				<td><input name="question76" type="radio" value="" /></td>
				<td><input name="question76" type="radio" value="" /></td>
				<td><input name="question76" type="radio" value="" /></td>
				<td><input name="question76" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>77</td>
				<td>我感到前途一片黑暗、困难重重</td>
				<td><input name="question77" type="radio" value="" /></td>
				<td><input name="question77" type="radio" value="" /></td>
				<td><input name="question77" type="radio" value="" /></td>
				<td><input name="question77" type="radio" value="" /></td>
				<td><input name="question77" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>78</td>
				<td>把得罪过我的人收拾以后，心里才感到舒服</td>
				<td><input name="question78" type="radio" value="" /></td>
				<td><input name="question78" type="radio" value="" /></td>
				<td><input name="question78" type="radio" value="" /></td>
				<td><input name="question78" type="radio" value="" /></td>
				<td><input name="question78" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>79</td>
				<td>不收拾伤害过我的人，心里就不平衡</td>
				<td><input name="question79" type="radio" value="" /></td>
				<td><input name="question79" type="radio" value="" /></td>
				<td><input name="question79" type="radio" value="" /></td>
				<td><input name="question79" type="radio" value="" /></td>
				<td><input name="question79" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>80</td>
				<td>为达到目的不冒险是不行的</td>
				<td><input name="question80" type="radio" value="" /></td>
				<td><input name="question80" type="radio" value="" /></td>
				<td><input name="question80" type="radio" value="" /></td>
				<td><input name="question80" type="radio" value="" /></td>
				<td><input name="question80" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>81</td>
				<td>管它三七二十一，搏一搏再说</td>
				<td><input name="question81" type="radio" value="" /></td>
				<td><input name="question81" type="radio" value="" /></td>
				<td><input name="question81" type="radio" value="" /></td>
				<td><input name="question81" type="radio" value="" /></td>
				<td><input name="question81" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>82</td>
				<td>我曾以头痛或肚痛为理由，避开过很多麻烦</td>
				<td><input name="question82" type="radio" value="" /></td>
				<td><input name="question82" type="radio" value="" /></td>
				<td><input name="question82" type="radio" value="" /></td>
				<td><input name="question82" type="radio" value="" /></td>
				<td><input name="question82" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>83</td>
				<td>生了病就应该减少相应的任务和责任</td>
				<td><input name="question83" type="radio" value="" /></td>
				<td><input name="question83" type="radio" value="" /></td>
				<td><input name="question83" type="radio" value="" /></td>
				<td><input name="question83" type="radio" value="" /></td>
				<td><input name="question83" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>84</td>
				<td>我心里从来没有过任何不好的想法</td>
				<td><input name="question84" type="radio" value="" /></td>
				<td><input name="question84" type="radio" value="" /></td>
				<td><input name="question84" type="radio" value="" /></td>
				<td><input name="question84" type="radio" value="" /></td>
				<td><input name="question84" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>85</td>
				<td>有钱就有尊严</td>
				<td><input name="question85" type="radio" value="" /></td>
				<td><input name="question85" type="radio" value="" /></td>
				<td><input name="question85" type="radio" value="" /></td>
				<td><input name="question85" type="radio" value="" /></td>
				<td><input name="question85" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>86</td>
				<td>宁愿用不太正当的方式谋取利益，也不愿失掉机会</td>
				<td><input name="question86" type="radio" value="" /></td>
				<td><input name="question86" type="radio" value="" /></td>
				<td><input name="question86" type="radio" value="" /></td>
				<td><input name="question86" type="radio" value="" /></td>
				<td><input name="question86" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>87</td>
				<td>我常常感到手或脚发重</td>
				<td><input name="question87" type="radio" value="" /></td>
				<td><input name="question87" type="radio" value="" /></td>
				<td><input name="question87" type="radio" value="" /></td>
				<td><input name="question87" type="radio" value="" /></td>
				<td><input name="question87" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>88</td>
				<td>总觉得浑身没劲，什么都不想做</td>
				<td><input name="question88" type="radio" value="" /></td>
				<td><input name="question88" type="radio" value="" /></td>
				<td><input name="question88" type="radio" value="" /></td>
				<td><input name="question88" type="radio" value="" /></td>
				<td><input name="question88" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>89</td>
				<td>参加劳动就是为了拿成绩减刑，与思想认识无关</td>
				<td><input name="question89" type="radio" value="" /></td>
				<td><input name="question89" type="radio" value="" /></td>
				<td><input name="question89" type="radio" value="" /></td>
				<td><input name="question89" type="radio" value="" /></td>
				<td><input name="question89" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>90</td>
				<td>参加劳动有助于掌握实用技能</td>
				<td><input name="question90" type="radio" value="" /></td>
				<td><input name="question90" type="radio" value="" /></td>
				<td><input name="question90" type="radio" value="" /></td>
				<td><input name="question90" type="radio" value="" /></td>
				<td><input name="question90" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>91</td>
				<td>我经常参加集体活动</td>
				<td><input name="question91" type="radio" value="" /></td>
				<td><input name="question91" type="radio" value="" /></td>
				<td><input name="question91" type="radio" value="" /></td>
				<td><input name="question91" type="radio" value="" /></td>
				<td><input name="question91" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>92</td>
				<td>我常常感到自己孤立无援</td>
				<td><input name="question92" type="radio" value="" /></td>
				<td><input name="question92" type="radio" value="" /></td>
				<td><input name="question92" type="radio" value="" /></td>
				<td><input name="question92" type="radio" value="" /></td>
				<td><input name="question92" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>93</td>
				<td>看不顺眼的东西，要搬走或毁掉</td>
				<td><input name="question93" type="radio" value="" /></td>
				<td><input name="question93" type="radio" value="" /></td>
				<td><input name="question93" type="radio" value="" /></td>
				<td><input name="question93" type="radio" value="" /></td>
				<td><input name="question93" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>94</td>
				<td>撑死胆大的，饿死胆小的</td>
				<td><input name="question94" type="radio" value="" /></td>
				<td><input name="question94" type="radio" value="" /></td>
				<td><input name="question94" type="radio" value="" /></td>
				<td><input name="question94" type="radio" value="" /></td>
				<td><input name="question94" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>95</td>
				<td>我已经失去了继续活下去的勇气</td>
				<td><input name="question95" type="radio" value="" /></td>
				<td><input name="question95" type="radio" value="" /></td>
				<td><input name="question95" type="radio" value="" /></td>
				<td><input name="question95" type="radio" value="" /></td>
				<td><input name="question95" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>96</td>
				<td>我曾想过各种自杀的场景</td>
				<td><input name="question96" type="radio" value="" /></td>
				<td><input name="question96" type="radio" value="" /></td>
				<td><input name="question96" type="radio" value="" /></td>
				<td><input name="question96" type="radio" value="" /></td>
				<td><input name="question96" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>97</td>
				<td>谁敢惹我，我一定饶不了他</td>
				<td><input name="question97" type="radio" value="" /></td>
				<td><input name="question97" type="radio" value="" /></td>
				<td><input name="question97" type="radio" value="" /></td>
				<td><input name="question97" type="radio" value="" /></td>
				<td><input name="question97" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>98</td>
				<td>因为胆子大，自己曾得到过别人得不到的好处</td>
				<td><input name="question98" type="radio" value="" /></td>
				<td><input name="question98" type="radio" value="" /></td>
				<td><input name="question98" type="radio" value="" /></td>
				<td><input name="question98" type="radio" value="" /></td>
				<td><input name="question98" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>99</td>
				<td>我从不生气</td>
				<td><input name="question99" type="radio" value="" /></td>
				<td><input name="question99" type="radio" value="" /></td>
				<td><input name="question99" type="radio" value="" /></td>
				<td><input name="question99" type="radio" value="" /></td>
				<td><input name="question99" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>100</td>
				<td>小鱼就应该被大鱼吃掉，社会也是这样</td>
				<td><input name="question100" type="radio" value="" /></td>
				<td><input name="question100" type="radio" value="" /></td>
				<td><input name="question100" type="radio" value="" /></td>
				<td><input name="question100" type="radio" value="" /></td>
				<td><input name="question100" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>101</td>
				<td>不走捷径，难以成功</td>
				<td><input name="question101" type="radio" value="" /></td>
				<td><input name="question101" type="radio" value="" /></td>
				<td><input name="question101" type="radio" value="" /></td>
				<td><input name="question101" type="radio" value="" /></td>
				<td><input name="question101" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>102</td>
				<td>我很难专心思考一个问题</td>
				<td><input name="question102" type="radio" value="" /></td>
				<td><input name="question102" type="radio" value="" /></td>
				<td><input name="question102" type="radio" value="" /></td>
				<td><input name="question102" type="radio" value="" /></td>
				<td><input name="question102" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>103</td>
				<td>我总感到烦躁不安，心神不定</td>
				<td><input name="question103" type="radio" value="" /></td>
				<td><input name="question103" type="radio" value="" /></td>
				<td><input name="question103" type="radio" value="" /></td>
				<td><input name="question103" type="radio" value="" /></td>
				<td><input name="question103" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>104</td>
				<td>服刑人员应该自觉接受劳动改造</td>
				<td><input name="question104" type="radio" value="" /></td>
				<td><input name="question104" type="radio" value="" /></td>
				<td><input name="question104" type="radio" value="" /></td>
				<td><input name="question104" type="radio" value="" /></td>
				<td><input name="question104" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>105</td>
				<td>爱护公物、尊重劳动是应该的</td>
				<td><input name="question105" type="radio" value="" /></td>
				<td><input name="question105" type="radio" value="" /></td>
				<td><input name="question105" type="radio" value="" /></td>
				<td><input name="question105" type="radio" value="" /></td>
				<td><input name="question105" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>106</td>
				<td>有些问题得靠武力来解决</td>
				<td><input name="question106" type="radio" value="" /></td>
				<td><input name="question106" type="radio" value="" /></td>
				<td><input name="question106" type="radio" value="" /></td>
				<td><input name="question106" type="radio" value="" /></td>
				<td><input name="question106" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>107</td>
				<td>弱肉强食，强者为王，不能给别人骑在头上</td>
				<td><input name="question107" type="radio" value="" /></td>
				<td><input name="question107" type="radio" value="" /></td>
				<td><input name="question107" type="radio" value="" /></td>
				<td><input name="question107" type="radio" value="" /></td>
				<td><input name="question107" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>108</td>
				<td>我实在没有勇气再去面对亲朋好友</td>
				<td><input name="question108" type="radio" value="" /></td>
				<td><input name="question108" type="radio" value="" /></td>
				<td><input name="question108" type="radio" value="" /></td>
				<td><input name="question108" type="radio" value="" /></td>
				<td><input name="question108" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>109</td>
				<td>我现在对任何事情都失去了兴趣</td>
				<td><input name="question109" type="radio" value="" /></td>
				<td><input name="question109" type="radio" value="" /></td>
				<td><input name="question109" type="radio" value="" /></td>
				<td><input name="question109" type="radio" value="" /></td>
				<td><input name="question109" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>110</td>
				<td>我迟早会让得罪过我的人付出代价</td>
				<td><input name="question110" type="radio" value="" /></td>
				<td><input name="question110" type="radio" value="" /></td>
				<td><input name="question110" type="radio" value="" /></td>
				<td><input name="question110" type="radio" value="" /></td>
				<td><input name="question110" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>111</td>
				<td>假若有人伤害了我，我一定让他不好过</td>
				<td><input name="question111" type="radio" value="" /></td>
				<td><input name="question111" type="radio" value="" /></td>
				<td><input name="question111" type="radio" value="" /></td>
				<td><input name="question111" type="radio" value="" /></td>
				<td><input name="question111" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>112</td>
				<td>富贵险中求</td>
				<td><input name="question112" type="radio" value="" /></td>
				<td><input name="question112" type="radio" value="" /></td>
				<td><input name="question112" type="radio" value="" /></td>
				<td><input name="question112" type="radio" value="" /></td>
				<td><input name="question112" type="radio" value="" /></td>
			</tr>
			<tr>
				<td>113</td>
				<td>越惊险，感到越刺激</td>
				<td><input name="question113" type="radio" value="" /></td>
				<td><input name="question113" type="radio" value="" /></td>
				<td><input name="question113" type="radio" value="" /></td>
				<td><input name="question113" type="radio" value="" /></td>
				<td><input name="question113" type="radio" value="" /></td>
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