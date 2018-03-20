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
				<th class="base_th" width="5%" style="background: #65bbed;">是</th>
				<th class="base_th" width="5%" style="background: #65bbed;">否</th>
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
          </colgroup>
			<tr>
				<td>1</td>
				<td>我喜欢社交公关活动。</td>
				<td><input name="question1" type="radio" value="" />是</td>
				<td><input name="question1" type="radio" value="" />否 </td>
			</tr>
			<tr>
				<td>2</td>
				<td>即使是很复杂的问题，一般也难不倒我。</td>
				<td><input name="question2" type="radio" value="" />是</td>
				<td><input name="question2" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>3</td>
				<td>别人与我作对时，我总会想出办法来教训他一顿。</td>
				<td><input name="question3" type="radio" value="" />是</td>
				<td><input name="question3" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>4</td>
				<td>能帮助有困难的人令人快乐。</td>
				<td><input name="question4" type="radio" value="" />是</td>
				<td><input name="question4" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>5</td>
				<td>我一直认为有人控制着我的思想。</td>
				<td><input name="question5" type="radio" value="" />是</td>
				<td><input name="question5" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>6</td>
				<td>通常大多数人怎么说，我就怎么说。</td>
				<td><input name="question6" type="radio" value="" />是</td>
				<td><input name="question6" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>7</td>
				<td>犯点小错没有什么大不了的。</td>
				<td><input name="question7" type="radio" value="" />是</td>
				<td><input name="question7" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>8</td>
				<td>我容易心里烦乱或觉得害怕。</td>
				<td><input name="question8" type="radio" value="" />是</td>
				<td><input name="question8" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>9</td>
				<td>我从来没有与人吵过架。</td>
				<td><input name="question9" type="radio" value="" />是</td>
				<td><input name="question9" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>10</td>
				<td>我做事总是莽撞，冒冒失失。</td>
				<td><input name="question10" type="radio" value="" />是</td>
				<td><input name="question10" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>11</td>
				<td>如果富有，我会购买或收藏刀、剑、枪、炮之类的东西。</td>
				<td><input name="question11" type="radio" value="" />是</td>
				<td><input name="question11" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>12</td>
				<td>相信别人，肯定要吃大亏。</td>
				<td><input name="question12" type="radio" value="" />是</td>
				<td><input name="question12" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>13</td>
				<td>放火焚烧东西给人一种快乐享受。</td>
				<td><input name="question13" type="radio" value="" />是</td>
				<td><input name="question13" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>14</td>
				<td>我感到我处处不如人。</td>
				<td><input name="question14" type="radio" value="" />是</td>
				<td><input name="question14" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>15</td>
				<td>为了钱可以不择手段。</td>
				<td><input name="question15" type="radio" value="" />是</td>
				<td><input name="question15" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>16</td>
				<td>我晚上常常翻来覆去地睡不着。</td>
				<td><input name="question16" type="radio" value="" />是</td>
				<td><input name="question16" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>17</td>
				<td>我能很快和周围的人熟悉起来。</td>
				<td><input name="question17" type="radio" value="" />是</td>
				<td><input name="question17" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>18</td>
				<td>我理解事情总是比别人快一些。</td>
				<td><input name="question18" type="radio" value="" />是</td>
				<td><input name="question18" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>19</td>
				<td>我会给威胁我的人以致命性的打击。</td>
				<td><input name="question19" type="radio" value="" />是</td>
				<td><input name="question19" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>20</td>
				<td>路上遇到有人推车上坡，我会主动帮他一把。</td>
				<td><input name="question20" type="radio" value="" />是</td>
				<td><input name="question20" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>21</td>
				<td>有人一直想陷害我。</td>
				<td><input name="question21" type="radio" value="" />是</td>
				<td><input name="question21" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>22</td>
				<td>我比较在乎大多数人的看法，哪怕为此放弃自己的观点。</td>
				<td><input name="question22" type="radio" value="" />是</td>
				<td><input name="question22" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>23</td>
				<td>“马无夜草不肥，人无外财不富”，事实就是这样。</td>
				<td><input name="question23" type="radio" value="" />是</td>
				<td><input name="question23" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>24</td>
				<td>我的心情常常不稳定，时好时坏。</td>
				<td><input name="question24" type="radio" value="" />是</td>
				<td><input name="question24" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>25</td>
				<td>我从来没有出过什么差错。</td>
				<td><input name="question25" type="radio" value="" />是</td>
				<td><input name="question25" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>26</td>
				<td>我做事往往凭一时冲动，事后却常常发觉不妥。</td>
				<td><input name="question26" type="radio" value="" />是</td>
				<td><input name="question26" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>27</td>
				<td>我经常有真想找人打上一架的念头。</td>
				<td><input name="question27" type="radio" value="" />是</td>
				<td><input name="question27" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>28</td>
				<td>对任何人都不信任，是比较安全的。</td>
				<td><input name="question28" type="radio" value="" />是</td>
				<td><input name="question28" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>29</td>
				<td>不断地偷拿别人的东西，我会感到刺激过瘾。</td>
				<td><input name="question29" type="radio" value="" />是</td>
				<td><input name="question29" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>30</td>
				<td>我总觉得谁都比我强。</td>
				<td><input name="question30" type="radio" value="" />是</td>
				<td><input name="question30" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>31</td>
				<td>我觉得大多数人是为了向上爬而不惜说谎。</td>
				<td><input name="question31" type="radio" value="" />是</td>
				<td><input name="question31" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>32</td>
				<td>我心中的忧虑很多。</td>
				<td><input name="question32" type="radio" value="" />是</td>
				<td><input name="question32" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>33</td>
				<td>我喜欢参加热闹的团体活动（如聚会）。</td>
				<td><input name="question33" type="radio" value="" />是</td>
				<td><input name="question33" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>34</td>
				<td>大家都说我做事情时点子多。</td>
				<td><input name="question34" type="radio" value="" />是</td>
				<td><input name="question34" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>35</td>
				<td>对伤害自己的人绝不能手软。</td>
				<td><input name="question35" type="radio" value="" />是</td>
				<td><input name="question35" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>36</td>
				<td>我同情残疾人。</td>
				<td><input name="question36" type="radio" value="" />是</td>
				<td><input name="question36" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>37</td>
				<td>我总感到有些人在躲避我。</td>
				<td><input name="question37" type="radio" value="" />是</td>
				<td><input name="question37" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>38</td>
				<td>我说话做事喜欢随大流。</td>
				<td><input name="question38" type="radio" value="" />是</td>
				<td><input name="question38" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>39</td>
				<td>只要不被发现，做点坏事也不算什么。</td>
				<td><input name="question39" type="radio" value="" />是</td>
				<td><input name="question39" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>40</td>
				<td>我常常一会儿高兴，一会儿不高兴。</td>
				<td><input name="question40" type="radio" value="" />是</td>
				<td><input name="question40" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>41</td>
				<td>我的头脑中从没有出现过坏的念头。</td>
				<td><input name="question41" type="radio" value="" />是</td>
				<td><input name="question41" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>42</td>
				<td>别人常说我是急性子。</td>
				<td><input name="question42" type="radio" value="" />是</td>
				<td><input name="question42" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>43</td>
				<td>“顺我者昌，逆我者亡”应该成为人生的信条。</td>
				<td><input name="question43" type="radio" value="" />是</td>
				<td><input name="question43" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>44</td>
				<td>我对任何人都抱有戒心。</td>
				<td><input name="question44" type="radio" value="" />是</td>
				<td><input name="question44" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>45</td>
				<td>看到别人受伤害我会感到特别高兴。</td>
				<td><input name="question45" type="radio" value="" />是</td>
				<td><input name="question45" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>46</td>
				<td>无论怎样做，我总是信心不足。</td>
				<td><input name="question46" type="radio" value="" />是</td>
				<td><input name="question46" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>47</td>
				<td>人与人之间总是在互相利用，很少有真诚的友谊。</td>
				<td><input name="question47" type="radio" value="" />是</td>
				<td><input name="question47" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>48</td>
				<td>我心里面老是不踏实。</td>
				<td><input name="question48" type="radio" value="" />是</td>
				<td><input name="question48" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>49</td>
				<td>结交新朋友时，我总是采取主动的态度。</td>
				<td><input name="question49" type="radio" value="" />是</td>
				<td><input name="question49" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>50</td>
				<td>我学新东西比较快。</td>
				<td><input name="question50" type="radio" value="" />是</td>
				<td><input name="question50" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>51</td>
				<td>迟早我会让我的仇人有后悔的时候。</td>
				<td><input name="question51" type="radio" value="" />是</td>
				<td><input name="question51" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>52</td>
				<td>我常被电视中的感人情节所感动。</td>
				<td><input name="question52" type="radio" value="" />是</td>
				<td><input name="question52" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>53</td>
				<td>我有时希望从别人的愤怒中得到快乐。</td>
				<td><input name="question53" type="radio" value="" />是</td>
				<td><input name="question53" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>54</td>
				<td>小组讨论时我常屈从于别人的观点。</td>
				<td><input name="question54" type="radio" value="" />是</td>
				<td><input name="question54" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>55</td>
				<td>“撑死胆大的，饿死胆小的”，这话说得一点没错。</td>
				<td><input name="question55" type="radio" value="" />是</td>
				<td><input name="question55" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>56</td>
				<td>即使是一点小事，也会使自己情绪变得不好。</td>
				<td><input name="question56" type="radio" value="" />是</td>
				<td><input name="question56" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>57</td>
				<td>在商场无论看到多么好的东西，我都不想要。</td>
				<td><input name="question57" type="radio" value="" />是</td>
				<td><input name="question57" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>58</td>
				<td>我总爱追随着别人去干一些事情，很少考虑目的与后果。</td>
				<td><input name="question58" type="radio" value="" />是</td>
				<td><input name="question58" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>59</td>
				<td>假如我身怀武功绝技，我便会闯荡天下。</td>
				<td><input name="question59" type="radio" value="" />是</td>
				<td><input name="question59" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>60</td>
				<td>最安全的，是对谁也不要相信。</td>
				<td><input name="question60" type="radio" value="" />是</td>
				<td><input name="question60" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>61</td>
				<td>异性使用过的物品最具有刺激性。</td>
				<td><input name="question61" type="radio" value="" />是</td>
				<td><input name="question61" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>62</td>
				<td>我常常觉得自己真没用。</td>
				<td><input name="question62" type="radio" value="" />是</td>
				<td><input name="question62" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>63</td>
				<td>人与人交往都是在相互欺骗，以获得好处。</td>
				<td><input name="question63" type="radio" value="" />是</td>
				<td><input name="question63" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>64</td>
				<td>我有很多心事，心里面总是七上八下的。</td>
				<td><input name="question64" type="radio" value="" />是</td>
				<td><input name="question64" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>65</td>
				<td>我结交的朋友很多。</td>
				<td><input name="question65" type="radio" value="" />是</td>
				<td><input name="question65" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>66</td>
				<td>我能在较短时间内学会操作一种从没有使用过的机械。</td>
				<td><input name="question66" type="radio" value="" />是</td>
				<td><input name="question66" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>67</td>
				<td>报复他人后，心里才觉得出了一口气。</td>
				<td><input name="question67" type="radio" value="" />是</td>
				<td><input name="question67" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>68</td>
				<td>听到虐待老人或儿童的报道，我会十分气愤。</td>
				<td><input name="question68" type="radio" value="" />是</td>
				<td><input name="question68" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>69</td>
				<td>我能看见或听见别人感觉不到的奇怪现象。</td>
				<td><input name="question69" type="radio" value="" />是</td>
				<td><input name="question69" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>70</td>
				<td>有的事虽然自己想好了，但别人一说，我就会改变主意。</td>
				<td><input name="question70" type="radio" value="" />是</td>
				<td><input name="question70" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>71</td>
				<td>即便是不太好的事情，大多数人只要能得到好处就会做。</td>
				<td><input name="question71" type="radio" value="" />是</td>
				<td><input name="question71" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>72</td>
				<td>我属于那种容易大喜大悲的人。</td>
				<td><input name="question72" type="radio" value="" />是</td>
				<td><input name="question72" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>73</td>
				<td>无论遭受到多么不幸的打击，我都能不仇恨对方。</td>
				<td><input name="question73" type="radio" value="" />是</td>
				<td><input name="question73" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>74</td>
				<td>工作和学习中，我常常粗心大意。</td>
				<td><input name="question74" type="radio" value="" />是</td>
				<td><input name="question74" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>75</td>
				<td>我喜欢寻求刺激、找点乐，哪怕会挑起事端。</td>
				<td><input name="question75" type="radio" value="" />是</td>
				<td><input name="question75" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>76</td>
				<td>我提防那些对我过分亲近的人。</td>
				<td><input name="question76" type="radio" value="" />是</td>
				<td><input name="question76" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>77</td>
				<td>我喜欢折磨小动物。</td>
				<td><input name="question77" type="radio" value="" />是</td>
				<td><input name="question77" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>78</td>
				<td>在表现好的同事面前，我总感到非常不自在。</td>
				<td><input name="question78" type="radio" value="" />是</td>
				<td><input name="question78" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>79</td>
				<td>“人不利己，天诛地灭”，每个人只有对自己有利的事情才会去做。</td>
				<td><input name="question79" type="radio" value="" />是</td>
				<td><input name="question79" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>80</td>
				<td>我经常失眠，很容易惊醒。</td>
				<td><input name="question80" type="radio" value="" />是</td>
				<td><input name="question80" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>81</td>
				<td>我喜欢交朋友。</td>
				<td><input name="question81" type="radio" value="" />是</td>
				<td><input name="question81" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>82</td>
				<td>我属于善于思考、爱钻研问题的那类人。</td>
				<td><input name="question82" type="radio" value="" />是</td>
				<td><input name="question82" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>83</td>
				<td>谁要是侵犯了我，我不会轻易原谅（放过）他。</td>
				<td><input name="question83" type="radio" value="" />是</td>
				<td><input name="question83" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>84</td>
				<td>有人向我乞讨，我会给他们一点钱。</td>
				<td><input name="question84" type="radio" value="" />是</td>
				<td><input name="question84" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>85</td>
				<td>看到异性受到惊吓，我心里很兴奋。</td>
				<td><input name="question85" type="radio" value="" />是</td>
				<td><input name="question85" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>86</td>
				<td>在人群中，我属于自己没什么主见的那类人。</td>
				<td><input name="question86" type="radio" value="" />是</td>
				<td><input name="question86" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>87</td>
				<td>又想学好，又很难改掉毛病。</td>
				<td><input name="question87" type="radio" value="" />是</td>
				<td><input name="question87" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>88</td>
				<td>只要情绪激动起来，我就很难平静下来。</td>
				<td><input name="question88" type="radio" value="" />是</td>
				<td><input name="question88" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>89</td>
				<td>我从未说过谎话。</td>
				<td><input name="question89" type="radio" value="" />是</td>
				<td><input name="question89" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>90</td>
				<td>稍不如意，我就会发脾气。</td>
				<td><input name="question90" type="radio" value="" />是</td>
				<td><input name="question90" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>91</td>
				<td>当看到别人打群架时，我会上前帮助熟悉的人。</td>
				<td><input name="question91" type="radio" value="" />是</td>
				<td><input name="question91" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>92</td>
				<td>我认为想接近我的人都别有用心。</td>
				<td><input name="question92" type="radio" value="" />是</td>
				<td><input name="question92" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>93</td>
				<td>有人想偷走我的思想和计划。</td>
				<td><input name="question93" type="radio" value="" />是</td>
				<td><input name="question93" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>94</td>
				<td>我很自卑。</td>
				<td><input name="question94" type="radio" value="" />是</td>
				<td><input name="question94" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>95</td>
				<td>不管对别人有没有损害，只要自己痛快就行。</td>
				<td><input name="question95" type="radio" value="" />是</td>
				<td><input name="question95" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>96</td>
				<td>我经常感到悲观失望，觉得活着没啥意思。</td>
				<td><input name="question96" type="radio" value="" />是</td>
				<td><input name="question96" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>97</td>
				<td>即使是初次见面的人，我也能够与他（她）轻松地交谈。</td>
				<td><input name="question97" type="radio" value="" />是</td>
				<td><input name="question97" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>98</td>
				<td>别人都说我脑子好使，反应快。</td>
				<td><input name="question98" type="radio" value="" />是</td>
				<td><input name="question98" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>99</td>
				<td>我总觉得谁都比我强。</td>
				<td><input name="question99" type="radio" value="" />是</td>
				<td><input name="question99" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>100</td>
				<td>看到他人受骗上当，我会觉得很可怜。</td>
				<td><input name="question100" type="radio" value="" />是</td>
				<td><input name="question100" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>101</td>
				<td>假如别人认为我某些事情做法不合适，我很容易放弃。
						</td>
				<td><input name="question101" type="radio" value="" />是</td>
				<td><input name="question101" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>102</td>
				<td>我喜欢参加热闹的团体活动（如聚会）。</td>
				<td><input name="question102" type="radio" value="" />是</td>
				<td><input name="question102" type="radio" value="" />否</td>
			</tr>
			<tr>
				<td>103</td>
				<td>我的心情很容易受到周围（人和事）的影响。</td>
				<td><input name="question103" type="radio" value="" />是</td>
				<td><input name="question103" type="radio" value="" />否</td>
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