<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>日常危险性评估报告</title>

</head>

<body>
<!-- 功能子块-->
	
	<div class="main_content">
	<div id="printcontent">
			<div class="bg_title">罪犯日常危险性评估报告<span class="bgid" id="">NO.${taskId }</span></div>
		<div class="bg_item">
		<div class="bg_item_title">罪犯基础信息</div>
		<div class="bg_sub_line"></div>		
		<ul class="bg_ul">
		<li class="bg_li bg_li_w1"><span class="bg_item1">监狱</span><span class="bg_item2" id="">${rcjbxx.jy }</span></li>
		  <li class="bg_li bg_li_w1"><span class="bg_item1">监区</span><span class="bg_item2" id="rjpgjq">${rcjbxx.jq }</span></li>
		  <li class="bg_li bg_li_w1"><span class="bg_item1">囚号</span><span class="bg_item2" id="rjpgqh" >${rcjbxx.qh }</span></li>
		  <li class="bg_li bg_li_w1"><span class="bg_item1">姓名</span><span class="bg_item2" id="rjpgxm">${rcjbxx.xm }</span></li>
		  <li class="bg_li bg_li_w1"><span class="bg_item1">性别</span><span class="bg_item2" id="">${rcjbxx.xb }</span></li>
		  <li class="bg_li bg_li_w1"><span class="bg_item1">别名</span><span class="bg_item2" id=""></span>${rcjbxx.bm }</li>
		  <li class="bg_li bg_li_w1"><span class="bg_item1">出生日期</span><span class="bg_item2" id=""><fmt:formatDate type="date" value="${rcjbxx.csrq }" /></span></li>
		  <li class="bg_li bg_li_w1"><span class="bg_item1">年龄</span><span class="bg_item2" id="">${rcjbxx.nl }</span></li>
		  <li class="bg_li bg_li_w1"><span class="bg_item1">国籍/籍贯</span><span class="bg_item2" id="">${rcjbxx.gj }</span></li>
		  <li class="bg_li bg_li_w1"><span class="bg_item1">民族</span><span class="bg_item2" id="">${rcjbxx.mz }</span></li>
		  <li class="bg_li bg_li_w1"><span class="bg_item1">文化程度</span><span class="bg_item2" id="">${rcjbxx.whcd }</span></li>
		  <li class="bg_li bg_li_w1"><span class="bg_item1">政治面貌</span><span class="bg_item2" id="">${rcjbxx.zzmm }</span></li>
		</ul>
		</div>
		<div class="bg_item">
		<div class="bg_item_title">评估结果</div>
		<div class="bg_sub_line"></div>		
		<ul class="bg_ul">
		<li class="bg_li  bg_li_w1"><span class="bg_item1">评估时间</span><span class="bg_item2" id="rcpgrq" id="">${pgsj }</span></li>
		<li class="bg_li  bg_li_w1"><span class="bg_item1">评估分数</span><span class="bg_item2 bg_fs" id="rcpgfs" id="">${rcpgfs }</span></li>
		<li class="bg_li  bg_li_w1"><span class="bg_item1">危险等级</span><span class="bg_item2" id="rcpgwxdj"  id="">${rcwxdj }</span></li>
		</ul>
		<table class="bg_tb">
		<tr><th rowspan="4" class="ztsize">危险<br>类型<br>分析<th>危险类型</th><th>得分</th><th>危险类型倾向</th></tr>
		<c:forEach items="${wxlxReport}" var="re">
		  <tr>
		     <td>${re.wxlx}</td><td class="bg_fs">${re.fs }</td><td class="bg_rs">${re.dj }</td>
		  </tr>
		</c:forEach>
		</table>
		</div>

		<div class="bg_item">
			<div class="bg_item_title">危险性评估分析</div>
			<div class="bg_sub_line"></div>
				<div class="bg_li_w3">
					${report}
				</div>
		</div>
		<div class="bg_item">
		<div class="bg_item_title">详细信息</div>
		<div class="bg_sub_line"></div>		
		<ul class="bg_ul">
		<li class="bg_li bg_li_w1" ><span class="bg_item1">捕前职业</span><span class="bg_item2" id="">${rcxxxx.bqzy }</span></li>
	  	  <li class="bg_li bg_li_w2"><span class="bg_item1">证件类型</span><span class="bg_item2" id="">${rcxxxx.zjlx }</span></li>
		  <li class="bg_li bg_li_w1"><span class="bg_item1">身高（cm）</span><span class="bg_item2" id="" >${rcxxxx.sg }</span></li>
		  <li class="bg_li bg_li_w1"><span class="bg_item1">体重（kg）</span><span class="bg_item2" id="" >${rcxxxx.tz }</span></li>
		  <li class="bg_li bg_li_w1"><span class="bg_item1">婚姻状况</span><span class="bg_item2" id="" >${rcxxxx.htzk }</span></li>
		  <li class="bg_li bg_li_w3"><span class="bg_item1">户籍住址</span><span class="bg_item2" id="" >${rcxxxx.hjdz }</span></li>
		  <li class="bg_li bg_li_w3"><span class="bg_item1">家庭住址</span><span class="bg_item2" id="" >${rcxxxx.jtzz }</span></li>
		</ul>
		<div class="bg_item_title2">家庭关系</div>
		<ul class="bg_ul">
		  <li class="bg_li bg_li_w1"><span class="bg_item1">婚姻关系</span><span class="bg_item2" id="" >${rcxxxx.hygx }</span></li>
		  <li class="bg_li bg_li_w1"><span class="bg_item1">家庭支持</span><span class="bg_item2" id="" >${rcxxxx.jtzc }</span></li>
		  <li class="bg_li bg_li_w1"><span class="bg_item1">家庭变故</span><span class="bg_item2" id="" >${rcxxxx.jtbg }</span></li>
		  <li class="bg_li bg_li_w1"><span class="bg_item1">未成年犯家庭状况</span><span class="bg_item2" id="" >${rcxxxx.wcnfjtzk }</span></li>
		  <li class="bg_li bg_li_w1"><span class="bg_item1">是否独生子女</span><span class="bg_item2" id="" >${rcxxxx.sfdszn }</span></li>
		</ul>
		<div class="bg_item_title2">主要亲属</div>
		<table class="bg_tb">
		<tr><th>称谓</th><th>姓名</th><th>出生年月</th><th>政治面貌</th><th>工 作 单 位 及 职 务</th></tr>
		<tr><td>/</td><td>/</td><td>/</td><td>/</td><td>/</td></tr>
		<tr><td>/</td><td>/</td><td>/</td><td>/</td><td>/</td></tr>
		<tr><td>/</td><td>/</td><td>/</td><td>/</td><td>/</td></tr>
		</table>
		<div class="bg_item_title2">犯罪判决情况</div>
        <ul class="bg_ul">
		  <li class="bg_li bg_li_w1"><span class="bg_item1">罪名</span><span class="bg_item2" id="">${rcxxxx.zmmc }</span></li>
          <li class="bg_li bg_li_w2"><span class="bg_item1">刑期</span><span class="bg_item2" id="">${xq }</span></li>
		  <li class="bg_li bg_li_w1"><span class="bg_item1">入监日期</span><span class="bg_item2" id=""><fmt:formatDate type="date" value="${rcxxxx.rjrq }" /></span></li>
		  <li class="bg_li bg_li_w1"><span class="bg_item1">剥夺政治权利期限</span><span class="bg_item2" id="">${bznx }</span></li>
		  <li class="bg_li bg_li_w1"><span class="bg_item1">是否驱除出境</span><span class="bg_item2" id="">${rcxxxx.qzcj}</span></li>
          <li class="bg_li bg_li_w1"><span class="bg_item1">罚金（元）</span><span class="bg_item2" id="">${rcxxxx.fz }</span></li>
          <li class="bg_li bg_li_w1"><span class="bg_item1">没收财产情况</span><span class="bg_item2" id="">${rcxxxx.mscc }</span></li>
          <li class="bg_li bg_li_w3"><span class="bg_item1">犯罪事实</span><span class="bg_item3" id="">${rcxxxx.fzss }</span></li>
		</ul>
		</div>
		<div class="bg_item">
		<div class="bg_item_title">危险性相关因子信息</div>
		<div class="bg_sub_line"></div>		
		<ul class="bg_ul">
		  <li class="bg_li bg_li_w1"><span class="bg_item1">罪名分类</span><span class="bg_item2" id="">${rcxxxx.zmfl}</span></li>
		  <li class="bg_li bg_li_w1"><span class="bg_item1">刑期变动类别</span><span class="bg_item2" id="">${rcxxxx.bdlb }</span></li>
		  <li class="bg_li bg_li_w1"><span class="bg_item1">是否限制减刑</span><span class="bg_item2" id="">${rcxxxx.xzjx }</span></li>
		  <li class="bg_li bg_li_w1"><span class="bg_item1">案犯类别</span><span class="bg_item2" id="">${rcxxxx.aflb }</span></li>
		  <li class="bg_li bg_li_w1"><span class="bg_item1">分押类别</span><span class="bg_item2" id="">${rcxxxx.fylx }</span></li>
		  <li class="bg_li bg_li_w1"><span class="bg_item1">共同犯罪参与类型</span><span class="bg_item2" id="">${rcxxxx.gtfzlx }</span></li>
		  <li class="bg_li bg_li_w1"><span class="bg_item1">重控性质1</span><span class="bg_item2" id="">${rcxxxx.zkxz1 }</span></li>
		  <li class="bg_li bg_li_w1"><span class="bg_item1">重控性质2</span><span class="bg_item2" id="">${rcxxxx.zkxz2 }</span></li>
		  <li class="bg_li bg_li_w1"><span class="bg_item1">重控类别</span><span class="bg_item2" id="">${rcxxxx.zklb }</span></li>
		  <li class="bg_li bg_li_w1"><span class="bg_item1">认罪服判类型</span><span class="bg_item2" id="">${rcxxxx.rzlb }</span></li>
		  <li class="bg_li bg_li_w1"><span class="bg_item1">既往刑罚次数</span><span class="bg_item2" id="">${rcxxxx.xfcs }</span></li>
		  <li class="bg_li bg_li_w1"><span class="bg_item1">分管等级</span><span class="bg_item2" id="">${rcxxxx.hfgdj }</span></li>
<!-- 		  <li class="bg_li bg_li_w1"><span class="bg_item1">近两年奖扣分类别</span><span class="bg_item2" id="">--</span></li>
		  <li class="bg_li bg_li_w1"><span class="bg_item1">近两年奖扣分原因</span><span class="bg_item2" id="">--</span></li>
		  <li class="bg_li bg_li_w1"><span class="bg_item1">近两年奖扣分分值</span><span class="bg_item2" id="">--</span></li>
 -->		  <li class="bg_li bg_li_w1"><span class="bg_item1">是否“三无”罪犯</span><span class="bg_item2" id="">${rcxxxx.sfsw }</span></li>
		  <li class="bg_li bg_li_w1"><span class="bg_item1">是否三假罪犯</span><span class="bg_item2" id="">${rcxxxx.sfsj }</span></li>
		  <li class="bg_li bg_li_w1"><span class="bg_item1">劳动能力</span><span class="bg_item2" id="">${rcxxxx.ldnl }</span></li>
		  <li class="bg_li bg_li_w1"><span class="bg_item1">疾病类别</span><span class="bg_item2" id="">${rcxxxx.jblb }</span></li>
		  <li class="bg_li bg_li_w1"><span class="bg_item1">狱内立案案件性质</span><span class="bg_item2" id=""></span></li>
		  <li class="bg_li bg_li_w1"><span class="bg_item1">狱内立案案件类别</span><span class="bg_item2" id="">${rcxxxx.ynsalb }</span></li>
		  <li class="bg_li bg_li_w1"><span class="bg_item1">同案犯去向</span><span class="bg_item2" id="">${rcxxxx.tafqx }</span></li>
		</ul>
		</div>
		<div class="bg_item">
		<div class="bg_item_title">特别关注信息</div>
		<div class="bg_sub_line"></div>		
		<ul class="bg_ul">
<!-- 		<li class="bg_li3 bg_li_w4" id="spationinfo1">涉毒</li> -->
<!-- 		<li class="bg_li3 bg_li_w4" id="spationinfo2">涉枪</li> -->
<!-- 		<li class="bg_li3 bg_li_w4" id="spationinfo3">涉黑</li> -->
<!-- 		<li class="bg_li3 bg_li_w4" id="spationinfo4">涉恶</li> -->
<!-- 		<li class="bg_li3 bg_li_w4" id="spationinfo5">吸毒史</li> -->
<!-- 		<li class="bg_li3 bg_li_w4" id="spationinfo6">脱逃史</li> -->
<!-- 		<li class="bg_li3 bg_li_w4" id="spationinfo7">自杀史</li> -->
<!-- 		<li class="bg_li3 bg_li_w4" id="spationinfo8">袭警史</li> -->
<!-- 		<li class="bg_li3 bg_li_w4" id="spationinfo9">入监身份不明</li> -->
<!-- 		<li class="bg_li3 bg_li_w4" id="spationinfo10">累犯</li> -->
<!-- 		<li class="bg_li3 bg_li_w4" id="spationinfo11">惯犯</li> -->
<!-- 		<li class="bg_li3 bg_li_w4" id="spationinfo12">“两乱”犯</li> -->
<!-- 		<li class="bg_li3 bg_li_w4" id="spationinfo13">非法刊物案犯</li> -->
<!-- 		<li class="bg_li3 bg_li_w4" id="spationinfo14">知密犯</li> -->
<!-- 		<li class="bg_li3 bg_li_w4" id="spationinfo15">职务犯罪</li> -->
<!-- 		<li class="bg_li3 bg_li_w4" id="spationinfo16">港澳台犯</li> -->
<!-- 		<li class="bg_li3 bg_li_w4" id="spationinfo17">华侨</li> -->
<!-- 		<li class="bg_li3 bg_li_w4" id="spationinfo18">外籍犯</li> -->
<!-- 		<li class="bg_li3 bg_li_w4" id="spationinfo19">省内流窜作案</li> -->
<!-- 		<li class="bg_li3 bg_li_w4" id="spationinfo20">跨省流窜作案</li> -->
<!-- 		<li class="bg_li3 bg_li_w4" id="spationinfo21">跨国流窜作案</li> -->
<!-- 		<li class="bg_li3 bg_li_w4" id="spationinfo22">各省特别关注案犯</li> -->
		</ul>
		</div>
		<div class="bg_item">
		<div class="bg_item_title">危险性评估得分情况汇总表</div>
		<div class="bg_sub_line"></div>	
      <div class="bg_item2 bg_item2_w" >
		<table class="bg_tb">
		<tr>
		<th class="td_title" >基础信息评估</th>
		<td class="td_content">	
		<table class="bg_tb2" >
		<tr class="yz_tr"><th>因子</th><th>分数</th></tr>
		<tr id="rcdaaddbefore" style="display: none">
		<td></td><td></td>
		</tr>
		</table>
		</td>
		</tr>		
		</table>
		<div class="yz_tr bg_rs_left">
	                  基础信息评估总分：<font class="bg_fs" id="rcdafxzf"></font>
		</div>
		</div>
		<div class="bg_item2 bg_item2_w" >
		<table class="bg_tb">
		<tr><th class="td_title" >结构性访谈</th>
		<td class="td_content">
		<table class="bg_tb2" >
		<tr class="yz_tr"><th>因子</th><th>分数</th></tr>
		<tr id="rcftdcaddbefore" style="display: none">
		<td></td><td></td>
		</tr>
		</table>
		</td>
		</tr>		
		</table>
		<div class="yz_tr bg_rs_left">
	                  结构性访谈总分：<font class="bg_fs" id="rcftdczf"></font>
		</div>
		</div>
		<div class="bg_item2 bg_item2_w" >
		<table class="bg_tb">
		<tr><th class="td_title" >行为观察</th>		
		<td class="td_content">
		<table class="bg_tb2" >
		<tr class="yz_tr"><th>因子</th><th>分数</th></tr>
		<tr id="rcxwgcaddbefore" style="display: none">
		<td></td><td></td>
		</tr>
		</table>
		</td>
		</tr>		
		</table>
		<div class="yz_tr bg_rs_left">
	                  行为观察总分：<font class="bg_fs" id="rcxwgczf"></font>
		</div>
		</div>
		<div class="bg_item2 bg_item2_w">
		<table class="bg_tb">
		<tr><th class="td_title" >心理测试</th>
		<td class="td_content">
		<table class="bg_tb2" >
		<colgroup>
		<col width="20%">
		<col width="10%">
		<col width="30%">
		<col width="30%">
		<col width="10%">
		</colgroup>
		<tr class="yz_tr"><th>测试名称</th><th>T值</th><th>因子</th><th>维度</th><th>分数</th></tr>
		<tr id="rcxladdbefore" style="display: none">
		<td></td><td></td><td></td><td></td><td></td>
		</tr>
		</table>
		</td>
		</tr>		
		</table>
		<div class="yz_tr bg_rs_left">
	                  心理测试总分：<font class="bg_fs" id="xlcszf" ></font>
		</div>
		</div>
		</div>
       <div class="bg_item">
       <div class="bg_item_title"> 危险等级变化</div>
       <div class="bg_sub_line"></div>
				<div id="line1" style="width: 98.5%; height: 300px;"></div>
       </div>
		<div class="bg_item">
			<div class="bg_item_title">罪犯历史评估报告</div>
			<div class="bg_sub_line"></div>
				<table class="bg_tb">
				<tr><th>评估时间</th><th>评估阶段</th><th>危险等级</th><th>操作</th></tr>
				<tr><td>/</td><td>/</td><td>/</td><td><a href="#" onclick="loadnext3('/oasm/pgbgsccxView/pgbg_rc')">查看</a></td></tr>
				<tr><td>/</td><td>/</td><td>/</td><td><a href="#" onclick="loadnext3('/oasm/pgbgsccxView/pgbg_rc')">查看</a></td></tr>
				<tr><td>/</td><td>/</td><td>/</td><td><a href="#" onclick="loadnext3('/oasm/pgbgsccxView/pgbg_rc')">查看</a></td></tr>
				</table>
			</div>
		<div class="bg_item">
			<div class="bg_item_title">处置对策</div>
			<div class="bg_sub_line"></div>
				<table class="bg_tb">
					<tr class="czdc_tr01">
						<th colspan="2">罪犯危险性评估中心</th>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">分类关押</td>
						<td class="czdc_td02"></td>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">管控措施</td>
						<td class="czdc_td02"></td>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">教育改造方案</td>
						<td class="czdc_td02"></td>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">劳动改造方案</td>
						<td class="czdc_td02"></td>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">刑罚执行方案</td>
						<td class="czdc_td02"></td>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">是否适用假释、暂予监外执行</td>
						<td class="czdc_td02"></td>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">安置帮教建议</td>
						<td class="czdc_td02"></td>
					</tr>
				</table>
				<table class="bg_tb">
					<tr class="czdc_tr01">
						<th colspan="2">教育改造部</th>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">分类关押</td>
						<td class="czdc_td02"></td>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">管控措施</td>
						<td class="czdc_td02"></td>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">教育改造方案</td>
						<td class="czdc_td02"></td>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">劳动改造方案</td>
						<td class="czdc_td02"></td>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">刑罚执行方案</td>
						<td class="czdc_td02"></td>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">是否适用假释、暂予监外执行</td>
						<td class="czdc_td02"></td>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">安置帮教建议</td>
						<td class="czdc_td02"></td>
					</tr>
				</table>
				<table class="bg_tb">
					<tr class="czdc_tr01">
						<th colspan="2">心理矫治办公室主任</th>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">分类关押</td>
						<td class="czdc_td02"></td>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">管控措施</td>
						<td class="czdc_td02"></td>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">教育改造方案</td>
						<td class="czdc_td02"></td>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">劳动改造方案</td>
						<td class="czdc_td02"></td>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">刑罚执行方案</td>
						<td class="czdc_td02"></td>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">是否适用假释、暂予监外执行</td>
						<td class="czdc_td02"></td>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">安置帮教建议</td>
						<td class="czdc_td02"></td>
					</tr>
				</table>
				<table class="bg_tb">
					<tr class="czdc_tr01">
						<th colspan="2">矫正与刑务办公室</th>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">分类关押</td>
						<td class="czdc_td02"></td>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">管控措施</td>
						<td class="czdc_td02"></td>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">教育改造方案</td>
						<td class="czdc_td02"></td>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">劳动改造方案</td>
						<td class="czdc_td02"></td>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">刑罚执行方案</td>
						<td class="czdc_td02"></td>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">是否适用假释、暂予监外执行</td>
						<td class="czdc_td02"></td>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">安置帮教建议</td>
						<td class="czdc_td02"></td>
					</tr>
				</table>
				<table class="bg_tb">
					<tr class="czdc_tr01">
						<th colspan="2">指挥中心</th>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">分类关押</td>
						<td class="czdc_td02"></td>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">管控措施</td>
						<td class="czdc_td02"></td>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">教育改造方案</td>
						<td class="czdc_td02"></td>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">劳动改造方案</td>
						<td class="czdc_td02"></td>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">刑罚执行方案</td>
						<td class="czdc_td02"></td>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">是否适用假释、暂予监外执行</td>
						<td class="czdc_td02"></td>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">安置帮教建议</td>
						<td class="czdc_td02"></td>
					</tr>
				</table>
			<table class="bg_tb">
					<tr class="czdc_tr01">
						<th colspan="2">狱政管理办公室</th>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">分类关押</td>
						<td class="czdc_td02"></td>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">管控措施</td>
						<td class="czdc_td02"></td>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">教育改造方案</td>
						<td class="czdc_td02"></td>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">劳动改造方案</td>
						<td class="czdc_td02"></td>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">刑罚执行方案</td>
						<td class="czdc_td02"></td>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">是否适用假释、暂予监外执行</td>
						<td class="czdc_td02"></td>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">安置帮教建议</td>
						<td class="czdc_td02"></td>
					</tr>
				</table>
			<table class="bg_tb">
					<tr class="czdc_tr01">
						<th colspan="2">劳动改造与安全生产办公室</th>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">分类关押</td>
						<td class="czdc_td02"></td>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">管控措施</td>
						<td class="czdc_td02"></td>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">教育改造方案</td>
						<td class="czdc_td02"></td>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">劳动改造方案</td>
						<td class="czdc_td02"></td>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">刑罚执行方案</td>
						<td class="czdc_td02"></td>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">是否适用假释、暂予监外执行</td>
						<td class="czdc_td02"></td>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">安置帮教建议</td>
						<td class="czdc_td02"></td>
					</tr>
				</table>
		</div>
		<div class="bg_item">
			<div class="bg_item_title">监区审核意见</div>
			<div class="bg_sub_line"></div>
				<div class="bg_li_w3">
					<span>王冰冰</span><span>2017-09-28</span>
					<p>同意。罪犯日常改造表现基本稳定、有较多积极行为，同意其危险程度等级为中度危险。</p>
				</div>
			</div>
		<div class="bg_item">
			<div class="bg_item_title">监狱危评中心意见</div>
			<div class="bg_sub_line"></div>
				<div class="bg_li_w3">
					<span>肖育龄</span><span>2017-09-28</span>
						<p>同意。确认该罪犯危险程度等级为中度危险。</p>
				</div>
			</div>
		<div class="bg_item">
			<div class="bg_item_title">省局意见</div>
			<div class="bg_sub_line"></div>
				<div class="bg_li_w3">
					<p>无</p>
				</div>
			</div>
</div>
		<div class="end_of_paper">
			<button>下载</button>
			<button onClick="printdiv('printcontent')">打印</button>
		</div>
	</div>
<script type="text/javascript" src="<c:url value='/resource/js/printpage.js'/>"></script>
<script >

$('.czdc_tr01').click(function (event) {
	$(this).parent().find('.czdc_tr02').toggle(500);    

});
</script>	                            
							<script type="text/javascript">
								// 基于准备好的dom，初始化echarts实例
								var myChart = echarts.init(document.getElementById('line1'));
								var option2 = {
									title: {
									        text: '危险等级变化图',
									        subtext: '【0~40 低度危险】，【41~80 中度危险】，【81~107 高度危险】，【108以上极高危险】',
									        x: 'center'
									    },
									    tooltip: {
									        trigger: 'axis'
									    },
									    legend: {
									        data:['危险等级']
									    },
									    grid: {
									        left: '3%',
									        right: '4%',
									        bottom: '3%',
									        containLabel: true
									    },
									    toolbox: {
									        feature: {
									            saveAsImage: {}
									        }
									    },
									    xAxis: {
									        type: 'category',
									        boundaryGap: false,
									        data: ['2016.08.01','2016.09.01','2016.12.01','2017.03.01','2017.04.01','2017.05.01','2017.06.01']
									    },
									    yAxis: {
									        name : '危险值(分)',
									        type: 'value'
									    },
									    series: [
									        {
									            name:'危险指数',
									            type:'line',
									            stack: '总量',
									            data:[10, 30, 96, 84, 120, 101, 80]
									        }
									    ]
									};
								myChart.setOption(option2);
                                window.addEventListener("resize",function(){
                                    myChart.resize();
                                             });
								</script>
</body>

</html>