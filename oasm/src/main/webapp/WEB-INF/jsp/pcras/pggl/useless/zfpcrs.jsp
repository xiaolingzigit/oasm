<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>再犯罪排查</title>
</head>
<body>
   <div class="return_btn" >
       <a href="#" onclick="loadnext2('/oasm/dafxView/sjcjpc')">《 返回</a>	
    </div>
     <div class="rs_table">
        <div class="rs_table_title"><h1>综合筛选量表</h1></div>
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
		<table style="width:100%">
                        <tr>
                            <th class="base_th" width="10%">序号</th>
                            <th class="base_th" width="40%">条目</th>
                            <th class="base_th" width="10%">完全没有</th>
                            <th class="base_th" width="10%">偶尔</th>
                            <th class="base_th" width="10%">有时</th>
                            <th class="base_th" width="10%">经常</th>
                            <th class="base_th" width="10%">总是如此</th>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>想到我的一生，我经常怀疑我为什么活着</td>
                            <td><input type="radio" name="0"></input></td>
                            <td><input type="radio" name="0"></input></td>
                            <td><input type="radio" name="0"></input></td>
                            <td><input type="radio" name="0"></input></td>
                            <td><input type="radio" name="0"></input></td>
                        </tr>
                        <tr>
                            <td>2</td>
                            <td>如果可以选择，宁愿自己不要出生到这个世界</td>
                            <td><input type="radio" name="1"></input></td>
                            <td><input type="radio" name="1"></input></td>
                            <td><input type="radio" name="1"></input></td>
                            <td><input type="radio" name="1"></input></td>
                            <td><input type="radio" name="1"></input></td>
                        </tr>
                        <tr>
                            <td>3</td>
                            <td>我感觉死虽然可怕，但活着更痛苦</td>
                            <td><input type="radio" name="2"></input></td>
                            <td><input type="radio" name="2"></input></td>
                            <td><input type="radio" name="2"></input></td>
                            <td><input type="radio" name="2"></input></td>
                            <td><input type="radio" name="2"></input></td>
                        </tr>
                        <tr>
                            <td>4</td>
                            <td>常常觉得没有朋友，很孤独</td>
                            <td><input type="radio" name="3"></input></td>
                            <td><input type="radio" name="3"></input></td>
                            <td><input type="radio" name="3"></input></td>
                            <td><input type="radio" name="3"></input></td>
                            <td><input type="radio" name="3"></input></td>
                        </tr>
                        <tr>
                            <td>5</td>
                            <td>我有很多心事</td>
                            <td><input type="radio" name="4"></input></td>
                            <td><input type="radio" name="4"></input></td>
                            <td><input type="radio" name="4"></input></td>
                            <td><input type="radio" name="4"></input></td>
                            <td><input type="radio" name="4"></input></td>
                        </tr>
                        <tr>
                            <td>6</td>
                            <td>我觉得死忙会减轻痛苦</td>
                            <td><input type="radio" name="5"></input></td>
                            <td><input type="radio" name="5"></input></td>
                            <td><input type="radio" name="5"></input></td>
                            <td><input type="radio" name="5"></input></td>
                            <td><input type="radio" name="5"></input></td>
                        </tr>
                        <tr>
                            <td>7</td>
                            <td>我最近经常会想“为什么只有我这样，大家都不会？”</td>
                            <td><input type="radio" name="6"></input></td>
                            <td><input type="radio" name="6"></input></td>
                            <td><input type="radio" name="6"></input></td>
                            <td><input type="radio" name="6"></input></td>
                            <td><input type="radio" name="6"></input></td>
                        </tr>
                        <tr>
                            <td>8</td>
                            <td>我觉得这世界不值得我再继续生活下去</td>
                            <td><input type="radio" name="7"></input></td>
                            <td><input type="radio" name="7"></input></td>
                            <td><input type="radio" name="7"></input></td>
                            <td><input type="radio" name="7"></input></td>
                            <td><input type="radio" name="7"></input></td>
                        </tr>
                        <tr>
                            <td>9</td>
                            <td>我感觉很孤独，无法忍受</td>
                            <td><input type="radio" name="8"></input></td>
                            <td><input type="radio" name="8"></input></td>
                            <td><input type="radio" name="8"></input></td>
                            <td><input type="radio" name="8"></input></td>
                            <td><input type="radio" name="8"></input></td>
                        </tr>
                        <tr>
                            <td>10</td>
                            <td>有时一些无关紧要的念头缠住我，使我好多天都感觉不安</td>
                            <td><input type="radio" name="9"></input></td>
                            <td><input type="radio" name="9"></input></td>
                            <td><input type="radio" name="9"></input></td>
                            <td><input type="radio" name="9"></input></td>
                            <td><input type="radio" name="9"></input></td>
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