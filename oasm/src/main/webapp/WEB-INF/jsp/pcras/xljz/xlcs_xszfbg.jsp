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
     <div class="rs_table">
 	<div id="printcontent">
        <div class="rs_table_title"><h1>新收押罪犯管教量表测试报告</h1></div>
       <div class="msg_div3">	
		   <table>
		   <tr>
 		   <td class="xx_td05">姓<span>名</span>：</td> <td class="xx_td06">韩方奕</td>
            <td class="xx_td05">囚<span>号</span>：</td><td  class="xx_td06 xx_number" onclick="loadnext3('/oasm/dafxView/criminatdnfo')">1234567890</td>
		   <td class="xx_td05">监<span>区</span>：</td><td class="xx_td06">三监区</td>
		   <td class="xx_td05">分监区：</td><td class="xx_td06">分监区1</td>
		   </tr>
		   <tr>
		   <td class="xx_td05">年<span>龄</span>：</td><td  class="xx_td06">51</td>			
 		   <td class="xx_td05">性<span>别</span>：</td><td  class="xx_td06">男</td>
		   <td class="xx_td05">婚姻状况：</td><td class="xx_td06">已婚</td>
		   <td class="xx_td05">文化程度：</td><td class="xx_td06">大学</td>	
		   </tr>
		   <tr>
		   <td class="xx_td05">罪<span>名</span>：</td><td colspan="3" class="xx_td06">合同诈骗、诈骗、合同诈骗</td>	
		   <td class="xx_td05">剩余刑期：</td><td colspan="3" class="xx_td06">13年00个月06天</td>
		   </tr>
		   <tr>
		   <td >测试时间：</td><td colspan="3" class="xx_td06">2017/11/6</td>
           <td>测试得分：</td><td colspan="3" class="xx_td06">88</td>
		   </tr>
		   </table>
        </div>
 	<div class="header_table">
 	<h3>测试结果</h3>
	</div>
     <div class="xlcs_dimension_table">
		<table >
				<tr>
					<th>维度名称</th>
					<th>原始分</th>
					<th>标准分</th>
				</tr>
				<tbody>
				<tr><td class="xlcs_td01 ">思想偏差</td><td>39</td><td>67</td></tr>    
				<tr><td class="xlcs_td01 ">情绪波动</td><td>27</td><td>49</td></tr>    
				<tr><td class="xlcs_td01 ">劳动态度</td><td>25</td><td>75*</td></tr>
				<tr><td class="xlcs_td01 ">社会支持</td><td>33</td><td>87*</td></tr>
				<tr><td class="xlcs_td01 ">攻击对抗</td><td>27</td><td>60</td></tr>   
				<tr><td class="xlcs_td01 ">自伤自残</td><td>37</td><td>74</td></tr>   
				<tr><td class="xlcs_td01 ">怀恨报复</td><td>20</td><td>61</td></tr>    
				<tr><td class="xlcs_td01 ">险冲动</td><td>14</td><td>38</td></tr>    
				<tr><td class="xlcs_td01 ">伪病意向</td><td>9</td><td>42</td></tr>   

</tbody>
</table>

            </div> 
 <div class="header_table">
 	<h3>综合评估</h3>
	</div>
     <div class="xlcs_dimension_fx2">
      <div class="xlcs_fx"><p><span> 1、危险程度:</span>危险倾向性明显</p></div>
      <div class="xlcs_fx"><p><span> 2、恶性程度:</span>恶性倾向性明显</p></div>
      <div class="xlcs_fx"><p><span> 3、改造难度:</span>较大</p></div>     
      </div> 
        <a href = "#" onclick="loadnext3('/oasm/xljzView/xlcs_xszfrs')" class="lbrs_link" >查看回答情况>>></a>         
</div>
		<div class="end_of_paper">
			<button>下载</button>
			<button onClick="printdiv('printcontent')">打印</button>
		</div>
	</div>
<script type="text/javascript" src="<c:url value='/resource/js/printpage.js'/>"></script>

    
</body>
</html>