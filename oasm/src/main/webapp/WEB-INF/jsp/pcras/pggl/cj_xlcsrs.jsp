<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>出监心理测试</title>
</head>
<body>
    <div class="return_btn" >
       <a href="#" onclick="loadnext3('/oasm/dafxView/cj_xlcs')"> <<<  返回 </a>	
    </div>
     <div class="rs_table">
 	<div id="printcontent">
        <div class="rs_table_title"><h1>出监心理测试分析表</h1></div>
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
		   <li class="xx_li02" ></li>
           <li class="xx_li01">得<span>分</span>：</li>
		   <li class="xx_li02" >55</li>	
		   </ul>	
        </div>
 	<div class="header_table">
 			<table rules=none>
			  <tr>
                            <th class="base_th" width="20%">心理测试量表</th>
                            <th class="base_th" width="14%">维度名称</th>
                            <th class="base_th" width="8%">原始分/均分</th>
                            <th class="base_th" width="8%">标准分</th>
                            <th class="base_th" width="40%">判断</th>
                            <th class="base_th" width="10%">得分</th>
                </tr>
		</table>
	</div>
     <div class="lb_content_table3">
		<table width="100%">
          <colgroup>
            <col width="20%">
            <col width="80%">
          </colgroup>
				<!-- <tr class="tjfx_tr01">
					<td class="color01">COPA</td>
					<td>
						<ul>
	<li class="lb_factor4">	PD1外倾	</li><li class="lb_factor_fs3">	4	</li><li class="lb_factor_fs3">	45	</li><li class="lb_factor_judge">		</li><li class="lb_factor_df">		</li>
<li class="lb_factor4">	PD2聪敏	</li><li class="lb_factor_fs3">	7	</li><li class="lb_factor_fs3">	59	</li><li class="lb_factor_judge">		</li><li class="lb_factor_df">		</li>
<li class="lb_factor4">	PD3同情	</li><li class="lb_factor_fs3">	6	</li><li class="lb_factor_fs3">	41	</li><li class="lb_factor_judge">		</li><li class="lb_factor_df">		</li>
<li class="lb_factor4">	PD4从属	</li><li class="lb_factor_fs3">	0	</li><li class="lb_factor_fs3">	32	</li><li class="lb_factor_judge">		</li><li class="lb_factor_df">		</li>
<li class="lb_factor4">	PD5波动	</li><li class="lb_factor_fs3">	0	</li><li class="lb_factor_fs3">	34	</li><li class="lb_factor_judge"></li><li class="lb_factor_df">	3	</li>
<li class="lb_factor4">	PD6冲动	</li><li class="lb_factor_fs3">	0	</li><li class="lb_factor_fs3">	33	</li><li class="lb_factor_judge"></li><li class="lb_factor_df">	3	</li>
<li class="lb_factor4">	PD7戒备	</li><li class="lb_factor_fs3">	0	</li><li class="lb_factor_fs3">	34	</li><li class="lb_factor_judge">		</li><li class="lb_factor_df">		</li>
<li class="lb_factor4">	PD8自卑	</li><li class="lb_factor_fs3">	0	</li><li class="lb_factor_fs3">	36	</li><li class="lb_factor_judge">	</li><li class="lb_factor_df">	3	</li>
<li class="lb_factor4">	PD9焦虑	</li><li class="lb_factor_fs3">	0	</li><li class="lb_factor_fs3">	33	</li><li class="lb_factor_judge"></li><li class="lb_factor_df">	3	</li>
<li class="lb_factor4">	PD10暴力倾向	</li><li class="lb_factor_fs3">	0	</li><li class="lb_factor_fs3">	37	</li><li class="lb_factor_judge"></li><li class="lb_factor_df">	3	</li>
<li class="lb_factor4">	PD11变态心理	</li><li class="lb_factor_fs3">	0	</li><li class="lb_factor_fs3">	41	</li><li class="lb_factor_judge"></li><li class="lb_factor_df">	3	</li>
<li class="lb_factor4">	PD12犯罪思维	</li><li class="lb_factor_fs3">	1	</li><li class="lb_factor_fs3">	38	</li><li class="lb_factor_judge">	犯罪思维35＜T分≤45分</li><li class="lb_factor_df">	3	</li>
	
						</ul>
					</td>
				</tr> -->
				<tr class="tjfx_tr01">
					<td class="color02">
					社会适应性量表
					</td>
					<td>
						<ul>
<li class="lb_factor4">	社会适应因子	</li><li class="lb_factor_fs3">	9	</li><li class="lb_factor_fs3">	42	</li><li class="lb_factor_judge">	社会适应因子40＜T＜60	</li><li class="lb_factor_df">	3	</li>
						</ul>
					</td>
				</tr>
				<!-- <tr class="tjfx_tr01">
					<td class="color03">
					SCL-90
					</td>
					<td>
						<ul>
<li class="lb_factor4">	总分	</li><li class="lb_factor_fs3">	160	</li><li class="lb_factor_fs3">	/	</li><li class="lb_factor_judge">	总分>160分，阳性项目数>43项，有2项因子，2≤T＜3</li><li class="lb_factor_df">	5	</li>
<li class="lb_factor4">	总均分	</li><li class="lb_factor_fs3">	1.78	</li><li class="lb_factor_fs3">	/	</li><li class="lb_factor_judge">		</li><li class="lb_factor_df">		</li>
<li class="lb_factor4">	阴性项目数	</li><li class="lb_factor_fs3">	43	</li><li class="lb_factor_fs3">	/	</li><li class="lb_factor_judge">		</li><li class="lb_factor_df">		</li>
<li class="lb_factor4">	阳性项目数	</li><li class="lb_factor_fs3">	47	</li><li class="lb_factor_fs3">	/	</li><li class="lb_factor_judge">		</li><li class="lb_factor_df">		</li>
<li class="lb_factor4">	阳性症状均分	</li><li class="lb_factor_fs3">	2.49	</li><li class="lb_factor_fs3">	/	</li><li class="lb_factor_judge">		</li><li class="lb_factor_df">		</li>
<li class="lb_factor4">	躯体化	</li><li class="lb_factor_fs3">	26	</li><li class="lb_factor_fs3">	2.17	</li><li class="lb_factor_judge">	</li><li class="lb_factor_df">		</li>
<li class="lb_factor4">	强迫状态	</li><li class="lb_factor_fs3">	21	</li><li class="lb_factor_fs3">	2.1	</li><li class="lb_factor_judge">	</li><li class="lb_factor_df">		</li>
<li class="lb_factor4">	人际关系敏感	</li><li class="lb_factor_fs3">	16	</li><li class="lb_factor_fs3">	1.78	</li><li class="lb_factor_judge">		</li><li class="lb_factor_df">		</li>
<li class="lb_factor4">	抑郁	</li><li class="lb_factor_fs3">	26	</li><li class="lb_factor_fs3">	2	</li><li class="lb_factor_judge">		</li><li class="lb_factor_df">		</li>
<li class="lb_factor4">	焦虑	</li><li class="lb_factor_fs3">	14	</li><li class="lb_factor_fs3">	1.4	</li><li class="lb_factor_judge">		</li><li class="lb_factor_df">		</li>
<li class="lb_factor4">	敌对	</li><li class="lb_factor_fs3">	8	</li><li class="lb_factor_fs3">	1.33	</li><li class="lb_factor_judge">		</li><li class="lb_factor_df">		</li>
<li class="lb_factor4">	恐怖	</li><li class="lb_factor_fs3">	8	</li><li class="lb_factor_fs3">	1.14	</li><li class="lb_factor_judge">		</li><li class="lb_factor_df">		</li>
<li class="lb_factor4">	偏执	</li><li class="lb_factor_fs3">	8	</li><li class="lb_factor_fs3">	1.33	</li><li class="lb_factor_judge">	</li><li class="lb_factor_df">		</li>
<li class="lb_factor4">	精神病性	</li><li class="lb_factor_fs3">	17	</li><li class="lb_factor_fs3">	1.7	</li><li class="lb_factor_judge"></li><li class="lb_factor_df">	</li>
<li class="lb_factor4">	其它	</li><li class="lb_factor_fs3">	16	</li><li class="lb_factor_fs3">	2.29	</li><li class="lb_factor_judge">		</li><li class="lb_factor_df">		</li>

						</ul>
					</td>
				</tr> -->
			</table>

            </div> 
          <div class="lb_zf">总得分：<span>70</span></div>
</div>
		<div class="end_of_paper">
			<button>下载</button>
			<button onClick="printdiv('printcontent')">打印</button>
		</div>
	</div>
<script type="text/javascript" src="<c:url value='/resource/js/printpage.js'/>"></script>


    
</body>
</html>