<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>入监评估报告</title>
</head>
<body>
  <div>
		<div class="base_right_bom">
			<div>
				<div class="cs-jc-title"
					style="float: left; text-align: center; margin-left: 350px">入监评估报告(简版)</div>
				<div style="float: left; text-align: center; margin-left: 90px">
					<a href="#" onclick="loadnext2('/oasm/pgbgsccxView/pgbg_rj2')"><font size=""
						color="#6699ff">查看详细版</font></a>
				</div>
				<div style="float: left; margin-left: 25px; margin-right: 10px">
					<a href="#" title="下载"><img src="<c:url value='/resource/images/download.png'/>"
						width="20" height="18" border="0" alt="下载"></a>
				</div>
				<div style="">
					<a href="#" title="打印" onClick="printdiv('pgbg')"><img
						src="<c:url value='/resource/images/print.png'/>" width="20" height="18" border="0" alt="打印"></a>
				</div>
			</div>

			<div class="cs-item">
				<div class="cs-item-title">犯罪基础信息</div>
				
				<ul class="cs-ul">
					<li class="cs-li"><span class="cs-item-1">姓名</span><span
						class="cs-item-2">张三</span></li>
					<li class="cs-li"><span class="cs-item-1">囚号</span><span
						class="cs-item-2">12922349087</span></li>
					<li class="cs-li"><span class="cs-item-1">刑期</span><span
						class="cs-item-2">1年2月</span></li>
					<li class="cs-li"><span class="cs-item-1">罪名</span><span
						class="cs-item-2">破坏交通设施罪</span></li>				
					<li class="cs-li"><span class="cs-item-1">评估时间</span><span
						class="cs-item-2">2016-08至2017-06</span></li>
					<li class="cs-li"><span class="cs-item-1">评估总分</span><span
						class="cs-item-2" style="color:red;font-size:150%;">156</span></li>
					<li class="cs-li"><span class="cs-item-1">个性特点</span><span
						class="cs-item-2">外向开朗</span></li>
					<li class="cs-li"><span class="cs-item-1">行为特征</span><span
						class="cs-item-2">适应性较差</span></li>
				</ul>
			</div>
			<div class="cs-item cs-item-l">
				<div class="cs-item-title">评分
				<div style="float:right;">评估总分：<span style="color:red;font-size:250%;">156</span></div>
				</div>
				<div class="cs-sub-line"></div>
				<div>
					<table class="cs-tb-w cs-tb-cl" style="text-align: center;width:100%">
						<tr>
							<th>档案分析得分</th>
							<th>结构性访谈得分</th>
							<th>行为观察得分</th>
							<th>新收押罪犯量表得分</th>
							<th>COPA-PI量表得分</th>
							<th>SCL90量表得分</th>
							<th>综合筛选得分</th>
							<th>专项排查得分</th>
							<th>总分</th>
							<th>标准分</th>
						</tr>
						<tr style="background: #d7dcdf; color: #000000">
							<td>15</td>
							<td>34</td>
							<td>67</td>
							<td>10</td>
							<td>30</td>
							<td>67</td>
							<td>10</td>
							<td>30</td>
							<td>156</td>
							<td>67</td>

						</tr>

					</table>
				</div>

			</div>
			<div class="cs-item">
				<div class="cs-item-title">犯罪危险等级及类型</div>
				<ul class="cs-ul">
					<li class="cs-s-li">
						<div class="cs-li">
							<span class="cs-item-1">危险等级</span><span class="cs-item-2">极高危险</span>
						</div>
						<div class="cs-li">
							<span class="cs-item-1">危险类型</span><span class="cs-item-2">自杀</span>
						</div>
					</li>
				</ul>
			</div>

			<div class="cs-item">
				<div class="cs-item-title">综合评估报告</div>
				<div class="cs-sub-line"></div>
				<div class="cs-sub-item">

					<div>
						<ul class="cs-ul">
							<li class="cs-li"><span class="cs-item-1">绝对分数</span><span
								class="cs-item-2">30</span></li>
							<li class="cs-li"><span class="cs-item-1">评估分数</span><span
								class="cs-item-2">1.25</span></li>
							<li class="cs-li"><span class="cs-item-1">危险等级</span><span
								class="cs-item-2">高度危险</span></li>
							<li class="cs-li"><span class="cs-item-1">危险倾向</span><span
								class="cs-item-2">自杀与脱逃</span></li>
							<li class="cs-li"><span class="cs-item-1">数据解释</span><span>整体数据自杀性危险性较高</span>
							</li>
							
						</ul>
					</div>
				</div>
			</div>
			<div class="cs-item">
				<div class="cs-item-title">专项评估报告</div>
				<div class="cs-sub-line"></div>
				<div class="cs-sub-item">

					<div>
						<div id="" class="">分项解释</div>
						<ul class="cs-ul">
							<li class="cs-li"><span class="cs-item-1">自杀倾向绝对分数</span><span
								class="cs-item-2">25</span></li>
							<li class="cs-li"><span class="cs-item-1">评估分数</span><span
								class="cs-item-2">1.25</span></li>
							<li class="cs-li"><span class="cs-item-1">危险等级</span><span
								class="cs-item-2">高度危险</span></li>
							<li class="cs-li"><span class="cs-item-1">数据解释</span><span
								class="cs-item-2"></span></li>
						</ul>

						<ul class="cs-ul">
							<li class="cs-li"><span class="cs-item-1">脱逃倾向绝对分数</span><span
								class="cs-item-2">27</span></li>
							<li class="cs-li"><span class="cs-item-1">评估分数</span><span
								class="cs-item-2">1.30</span></li>
							<li class="cs-li"><span class="cs-item-1">危险等级</span><span
								class="cs-item-2">高度危险</span></li>
							<li class="cs-li"><span class="cs-item-1">数据解释</span><span
								class="cs-item-2"></span></li>
						</ul>

						<ul class="cs-ul">
							<li class="cs-li"><span class="cs-item-1">行凶倾向绝对分数</span><span
								class="cs-item-2">28</span></li>
							<li class="cs-li"><span class="cs-item-1">评估分数</span><span
								class="cs-item-2">1.25</span></li>
							<li class="cs-li"><span class="cs-item-1">危险等级</span><span
								class="cs-item-2">高度危险</span></li>
							<li class="cs-li"><span class="cs-item-1">数据解释</span><span
								class="cs-item-2"></span></li>
						</ul>
						<div id="" class="">总体解释</div>
						<ul class="cs-ul">
							<li class="cs-li"><span class="cs-item-1">危险类别判断</span><span
								class="cs-item-2">自杀</span></li>
							<li class="cs-li"><span class="cs-item-1">数据解释</span><span>整体数据自杀性危险性较高</span>
							</li>
						</ul>
					</div>
				</div>
			</div>

		</div>
	</div>
</body>
</html>