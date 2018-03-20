<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>档案分析结果</title>
</head>
<body>
  <div class="return_btn" >
       <a href="#" onclick="loadnext3('/oasm/dafxView/rj_dafx')"> <<< 返回 </a>	
    </div>
     <div class="rs_table">
 	<div id="printcontent">
        <div class="rs_table_title"><h1>基础信息评估结果表</h1></div>
       <div class="msg_div2">
		   <ul  class="xx_ul">
		   <li class="xx_li01">姓<span>名</span>：</li>
		   <li class="xx_li02">${zyryObjct.xm}</li>
		   <li class="xx_li01">囚<span>号</span>：</li>
		   <li  class="xx_number xx_li02" onclick="loadnext3('/oasm/dafxView/criminalinfo')">${zyryObjct.qh}</li>
		   <li class="xx_li01">录入时间：</li>
		   <li class="xx_li02">${dasj }</li>
		   <li class="xx_li01">监<span>区</span>：</li>
		   <li class="xx_li02">${zyryObjct.gyjq }</li>
		   <li class="xx_li01">分监区：</li>
		   <li class="xx_li02">无数据</li>
		   <li class="xx_li01">专管警察：</li>
		   <li class="xx_li02">${jyxx.jhxm}</li>
           <li  class="xx_li01">分析结果：</li>
		   <li class="xx_li02" >
		      <%--  <c:if test="${dafs>10}">高危</c:if>
		       <c:if test="${dafs<=10}">非高危</c:if> --%>
		   </li>
           <li class="xx_li01">得<span>分</span>：</li>
		   <li class="xx_li02" >${dafs }</li>	
		   </ul>	
        </div>
            <div class="base_table cs-table">
                <table width="100%" >
                        <thead>
                           <tr>
                            <th class="base_th" width="5%">序号</th>
                            <th class="base_th" width="10%">基础信息判定项</th>
                            <th class="base_th" width="10%">实际情况</th>
                            <th class="base_th" width="5%">得分情况</th>
                         </tr>
                        </thead>
                        <tbody id="dafx_tableData">
                           <!--拼接回来的档案分析数据 -->
                        </tbody>
                        <tfoot id="dafx_tFootData">
                          <!-- jiao -->
                        </tfoot>
                </table>

                <a href = "#" onclick="loadnext1('pggl/dafxlb')" style="size:12px;margin-left: 85%">基础信息评估判定准则>>></a>
            </div>
</div>
		<div class="end_of_paper">
			<button>下载</button>
			<button onClick="printdiv('printcontent')">打印</button>
		</div>
	</div>
<script type="text/javascript" src="<c:url value='/resource/js/printpage.js'/>"></script>

</body>
</html>