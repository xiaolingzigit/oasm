<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>档案分析结果</title>
</head>
<body>
  <div class="return_btn" >
       <a href="#" onclick="loadnext2('/oasm/dafxView/sjcjpc')"> <<< 返回 </a>	
    </div>
     <div class="rs_table">
        <div class="rs_table_title"><h1>档案分析结果表</h1></div>
        <div class="table_msg" >
               <table border="1" bordercolor="#a0c6e5" style="border-collapse:collapse;">
               <tr>
				<td class="xx_td01">监狱</td>
				<td>惠州监狱</td>
				<td class="xx_td01">监区</td>
				<td id="da1"></td>
               </tr>
               <tr>
				<td class="xx_td01">囚号</td>
<!-- 				 onclick="loadnext1('pggl/criminalinfo')" -->
				<td id="da2" style="color:#a0c6e5;text-decoration:underline;cursor:pointer;">6546545454</td>
				<td class="xx_td01">姓名</td>
				<td id="da3"></td>
               </tr>
               <tr>
				<td  class="xx_td01">分析时间</td>
				<td id="da4" ></td>
				<td class="xx_td01">评估分数</td>
				<td id="da5"></td>
               </tr>
               </table>
 
        </div>
            <div class="base_table cs-table">
                <table width="100%" >
                        <tr>
                            <th class="base_th" width="5%">序号</th>
                            <th class="base_th" width="10%">档案判定项</th>
                            <th class="base_th" width="10%">实际情况</th>
                            <th class="base_th" width="5%">得分情况</th>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td class="lb_td01" >婚姻状况</td>
                            <td class="lb_td02" id="d1"></td>
                            <td id="lb_value1"></td>
                        </tr>
                        <tr>
                            <td>2</td>
                            <td class="lb_td01">累惯犯</td>
                            <td class="lb_td02" id="d2"></td>
                            <td id="lb_value2"></td>
                        </tr>
                        <tr>
                            <td>3</td>
                            <td class="lb_td01">四史情况</td>
                            <td class="lb_td02" id="d3"></td>
                            <td id="lb_value3"></td>
                        </tr>
                        <tr>
                            <td>4</td>
                            <td class="lb_td01">前科劣迹情况</td>
                            <td class="lb_td02"  id="d4"></td>
                            <td id="lb_value4"></td>
                        </tr>
                        <tr>
                            <td>5</td>
                            <td class="lb_td01">刑期</td>
                            <td class="lb_td02" id="d5"></td>
                            <td id="lb_value5"></td>
                        </tr>
                        <tr>
                            <td>6</td>
                            <td class="lb_td01">剩余刑期</td>
                            <td class="lb_td02" id="d6"></td>
                            <td id="lb_value6"></td>
                        </tr>
                        <tr>
                            <td>7</td>
                            <td class="lb_td01">已服刑期</td>
                            <td class="lb_td02" id="d7"></td>
                            <td id="lb_value7"></td>
                        </tr>
                        <tr>

                            <td>8</td>
                            <td class="lb_td01">已服刑期比例</td>
                            <td class="lb_td02" id="d8"></td>
                            <td id="lb_value8"></td>
                        </tr>
                        <tr>
                            <td>9</td>
                            <td class="lb_td01">案犯类别</td>
                            <td class="lb_td02" id="d9"></td>
                            <td id="lb_value9"></td>
                        </tr>
                        <tr>
                            <td>10</td>
                            <td class="lb_td01">有无上诉 </td>
                            <td class="lb_td02" id="d10"></td>
                            <td id="lb_value10"></td>
                        </tr>
                        <tr>
                            <td>11</td>
                            <td class="lb_td01">终审情况</td>
                            <td class="lb_td02" id="d11"></td>
                            <td id="lb_value11"></td>
                        </tr>
                        <tr>
                            <td>12</td>
                            <td class="lb_td01">罚金</td>
                            <td class="lb_td02" id="d12"></td>
                            <td id="lb_value12"></td>
                        </tr>
                        <tr>
                            <td>13</td>
                            <td class="lb_td01">没收财产 </td>
                            <td class="lb_td02" id="d13"></td>
                            <td id="lb_value13"></td>
                        </tr>
                        <tr>
                            <td>14</td>
                            <td class="lb_td01">罚金交纳记录</td>
                            <td class="lb_td02" id="d14"></td>
                            <td id="lb_value14"></td>
                        </tr>
                        <tr>
                            <td>15</td>
                            <td class="lb_td01">分押类型</td>
                            <td class="lb_td02" id="d15"></td>
                            <td id="lb_value15"></td>
                        </tr>
                        <tr>
                            <td>16</td>
                            <td class="lb_td01">减刑尺度</td>
                            <td class="lb_td02" id="d16"></td>
                            <td id="lb_value16"></td>
                        </tr>
                        <tr>
                            <td>17</td>
                            <td class="lb_td01">老残病</td>
                            <td class="lb_td02" id="d17"></td>
                            <td id="lb_value17"></td>
                        </tr>
                        <tr>
                            <td>18</td>
                            <td class="lb_td01">入监年龄</td>
                            <td class="lb_td02" id="d18"></td>
                            <td id="lb_value18"></td>
                        </tr>

                        <tr>
                            <td>评估总分</td>
                            <td class="lb_td01"></td>
                            <td class="lb_td02"></td>
                            <td class="lb_td03"></td>
                        </tr>
                </table>

                <a href = "#" onclick="loadnext1('pggl/dafxlb')" style="size:12px;margin-left: 85%">档案分析判定准则>>></a>
            </div>
			<div style="text-align: center; padding-bottom:10px">
				  <button style="font-size: 20px;">下载</button>
				  <button style="font-size: 20px;">打印</button>
                </div>
     </div>
</body>
</html>