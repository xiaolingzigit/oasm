<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>罪犯个人面板</title>
</head>
<body>
<div class="zfxx_left">
<div class="zfxx_title">罪犯基础信息</div>
<hr class="divider">
<div class="avatar" ></div>
<div class="zfxx_tb">
<table>
<tr>
<td class="zfxx_td01">罪犯姓名：</td>
<td class="zfxx_td02">${grxx.xm }</td>
</tr>
<tr>
<td class="zfxx_td01">囚号：</td>
<td class="zfxx_td02 xx_number" onclick="loadnext3('/oasm/dafxView/criminalinfo?qh=${grxx.qh }')">${grxx.qh }</td>
</tr>
<tr>
<td class="zfxx_td01">监区：</td>
<td class="zfxx_td02">${grxx.jq }</td>
</tr>
<tr>
<td class="zfxx_td01">专管警察：</td>
<td class="zfxx_td02">${jcxm }</td>
</tr>
<tr>
<td class="zfxx_td01">入监时间：</td>
<td class="zfxx_td02"><fmt:formatDate type="date" value="${xxxx.rjrq }" /></td>
</tr>
<tr>
<td class="zfxx_td01">年龄：</td>
<td class="zfxx_td02">${grxx.nl }</td>
</tr>
<tr>
<td class="zfxx_td01">文化程度：</td>
<td class="zfxx_td02">${grxx.whcd }</td>
</tr>
<tr>
<td class="zfxx_td01">捕前职业：</td>
<td class="zfxx_td02">${xxxx.bqzy }</td>
</tr>
<tr>
<td class="zfxx_td01">罪名：</td>
<td class="zfxx_td02">${xxxx.zmmc }</td>
</tr>
<tr>
<td class="zfxx_td01">刑期：</td>
<td class="zfxx_td02">${xq }</td>
</tr>
<tr>
<td class="zfxx_td01">户籍地：</td>
<td class="zfxx_td02">${xxxx.hjdz }</td>
</tr>
<tr>
<td class="zfxx_td01">同案犯去向：</td>
<td class="zfxx_td02">${xxxx.tafqx }</td>
</tr>
<tr>
<td class="zfxx_td01">主要亲属：</td>
<td class="zfxx_td02">--</td>
</tr>
<tr>
<td class="zfxx_td01">体貌突出特征：</td>
<td class="zfxx_td02">/</td>
</tr>
<tr>
<td class="zfxx_td01">心理特征：</td>
<td class="zfxx_td02">/</td>
</tr>
<tr>
<td class="zfxx_td01">主要犯罪情节手段：</td>
<td class="zfxx_td02">${xxxx.zmfl }</td>
</tr>
<tr>
<td class="zfxx_td01">有无前科：</td>
<td class="zfxx_td02">/</td>
</tr>
<tr>
<td class="zfxx_td01">是否团伙犯罪：</td>
<td class="zfxx_td02">/</td>
</tr>
<tr>
<td class="zfxx_td01">现处遇等级：</td>
<td class="zfxx_td02">/</td>
</tr>
<tr>
<td class="zfxx_td01">近二年内奖励情况：</td>
<td class="zfxx_td02">/</td>
</tr>
<tr>
<td class="zfxx_td01">近二年内处罚情况：</td>
<td class="zfxx_td02">/</td>
</tr>
<tr>
<td class="zfxx_td01">是否重点犯（A\B\C类）：</td>
<td class="zfxx_td02">/</td>
</tr>
</table>
</div>
</div>
<div class="zfxx_center">
<div class="zfxx_title">罪犯个人危险性因子</div>
<hr class="divider">
<div id="" style="top:30px;width: 99%; height: 600px;">
<div id="wordcloud11" style="width: 100%; height: 100%;"></div>
</div>
<div class="zfxx_title">罪犯个人危险类型程度</div>
<hr class="divider">
		<div class="zfxx_wxlx" id="zf_grwxlx">
		   <!-- 暂时拼接 -->
		</div>
		<div class="zfxx_title">罪犯个人危险等级变化</div>
<hr class="divider">
<div id="" style="top:30px;width: 99%; height: 300px;margin-top:15px;margin-bottom:20px;background:#578ebe;border-radius:8px;float:left;border:1px solid #c00;">
<div id="line1" style="width: 100%; height: 100%;"></div>
</div>

</div>
<div class="zfxx_right">
<div class="zfsj_tb1">
<span>罪犯个人评估报告</span>
<table style="table-layout: fixed;">
<thead><tr class="zfsj_tr01"><th>报告编号</th><th>得分</th><th>评估时间</th><th>操作</th></tr></thead>
<tbody id="zf_grpgbg">
   <!-- 拼接的个人评估报告 -->
</tbody>
</table>
</div>
<div class="zfsj_tb2">
<span>罪犯个人异常狱情</span>
<table>
<thead><tr class="zfsj_tr01"><th>发生时间</th><th>排查类别</th><th>狱情变化</th><th>操作</th></tr></thead>
<tbody id="zf_grycyq">
      <!-- 拼接回来的异常狱情数据 -->
</tbody>
</table>
</div>
<div class="zfsj_tb3">
<span>罪犯个人预警情况</span>
<table>
<thead><tr class="zfsj_tr01"><th>预警时间</th><th>预警类别</th><th>预警原因</th><th>操作</th></tr></thead>
<tbody id="zf_gryjqk">
    <!-- 拼接个人预警情况 -->
</tbody>
</table>
</div>
<div class="zfsj_tb4">
<span>罪犯个人基础信息评估</span>
<table style="table-layout: fixed;">
<thead><tr class="zfsj_tr01"><th>分析编号</th><th>得分</th><th>分析时间</th><th>操作</th></tr></thead>
<tbody id="zf_grjcxxpg">
  <!-- 拼接回来的基础信息评估 -->
</tbody>
</table>
</div>
<div class="zfsj_tb5">
<span>罪犯个人结构访谈</span>
<table style="table-layout: fixed;">
<thead><tr class="zfsj_tr01"><th>访谈编号</th><th>得分</th><th>访谈时间</th><th>操作</th></tr></thead>
<tbody id="zf_grjgft">
  <!-- 拼接个人结构访谈 -->
</tbody>
</table>
</div>
<div class="zfsj_tb6">
<span>罪犯个人行为观察</span>
<table style="table-layout: fixed;">
<thead><tr class="zfsj_tr01"><th>观察编号</th><th>得分</th><th>观察时间</th><th>操作</th></tr></thead>
<tbody id="zf_grxwgc">
  <!-- 拼接个人行为观察 -->
</tbody>
</table>
</div>
<div class="zfsj_tb7">
<span>罪犯个人心理测试</span>
<table style="table-layout: fixed;">
<thead><tr class="zfsj_tr01"><th>测试报告编号</th><th>得分</th><th>出具时间</th><th>操作</th></tr></thead>
<tbody id="zf_grxlce">
   <!-- 拼接个人心理测试 -->
</tbody>
</table>
</div>
</div>

<script type="text/javascript" src="<c:url value='/resource/echarts/echarts.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resource/echarts/echarts-wordcloud.js'/>"></script>
</body>
</html>