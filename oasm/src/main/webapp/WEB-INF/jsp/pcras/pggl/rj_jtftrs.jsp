<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>集体结构性访谈</title>
</head>
<body>
    <div class="return_btn" >
       <a href="#" onclick="loadnext3('/oasm/dafxView/rj_jgft')"> <<< 返回 </a>	
    </div>
     <div class="rs_table">
 	<div id="printcontent">
        <div class="rs_table_title"><h1>集体结构性访谈结果表</h1></div>
        <div class="msg_div2">
		   <ul  class="xx_ul">
		   <li class="xx_li01">姓<span>名</span>：</li>
		   <li class="xx_li02">${zyryObjct.xm }</li>
		   <li class="xx_li01">囚<span>号</span>：</li>
		   <li  class="xx_number xx_li02" onclick="loadnext3('/oasm/dafxView/criminalinfo?qh=${zyryObjct.qh }')">${zyryObjct.qh }</li>
		   <li class="xx_li01">录入时间：</li>
		   <li class="xx_li02">${ftsj}</li>
		   <li class="xx_li01">监<span>区</span>：</li>
		   <li class="xx_li02">${zyryObjct.gyjq }</li>
		   <li class="xx_li01">分监区：</li>
		   <li class="xx_li02">无数据</li>
		   <li class="xx_li01">专管警察：</li>
		   <li class="xx_li02">${jyxx.jhxm}</li>
           <li  class="xx_li01">分析结果：</li>
		   <li class="xx_li02" ></li>
           <li class="xx_li01">得<span>分</span>：</li>
		   <li class="xx_li02" >${ftfs}</li>	
		   </ul>	
        </div>
       		<div class="header_table">
			<table rules=none>
			  <tr>
			                <th style="width:2.5%;background:#FFF"></th>
                            <th class="base_th" width="40.5%">所选因子</th>
                            <th class="base_th" width="7%">得分</th>
                             <th style="width:2%;background:#FFF"></th>
                            <th class="base_th" width="40%">所选因子</th>
                            <th class="base_th" width="7%">得分</th>
                            <th style="width:1%;background:#FFF"></th>
                </tr>
		</table>

	</div>
    		<div class="lb_content_table" >
			<ul >
				<!-- 拼接回来的因子和分数 -->
			</ul>

		</div> 
			<div class="lb_zf">总得分：<span></span></div>
</div>
		<div class="end_of_paper">
			<button>下载</button>
			<button onClick="printdiv('printcontent')">打印</button>
		</div>
	</div>
<script type="text/javascript" src="<c:url value='/resource/js/printpage.js'/>"></script>

</body>
</html>