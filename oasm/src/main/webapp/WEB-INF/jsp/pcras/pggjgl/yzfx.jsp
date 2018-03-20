<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0" />
<title>因子分析</title>
</head>
<body>
  <div id="yzfxPage" >
        <!-- 定位栏-->
		<div class="location">
			<div class="location_left"><i><font  color="#ffffff"><strong>您现在的位置</strong></font></i></div>
			<div class="location_right">
				<strong>&nbsp;&nbsp;评估工具 >><font color="#ff3300">因子分析</font></strong>
			</div>
		</div>
		<div id="yzkfxys">
			<span>因子库分析</span>
			<hr style=" height:2px;border:none;border-top:2px ridge #185598;" />
		</div>
		<div class="tpdiv">
			<div class="tpdiv_yx">
			    <span>高危因子热点图</span>
				<img src="<c:url value='/resource/images/gxt_01.png'/>" alt="...">
			</div>
			<div class="tpdiv_yc">
			    <span>档案分析因子关系图</span>
				<img src="<c:url value='/resource/images/gxt_03.png'/>" alt="...">
			</div>
		</div>
		<div class="tpdiv">
			<div class="tpdiv_yx">
			    <span>自杀因子热点图</span>
				<img src="<c:url value='/resource/images/gxt_01.png'/>" alt="...">
			</div>
			<div class="tpdiv_yc">
			    <span>逃脱因子热点图</span>
				<img src="<c:url value='/resource/images/gxt_01.png'/>" alt="...">
			</div>
		</div>
		<div class="tpdiv">	    
			<div class="tpdiv_yx">
			    <span>行凶因子热点图</span>
				<img src="<c:url value='/resource/images/gxt_01.png'/>" alt="...">
			</div>
			<div class="tpdiv_yc">
			    <span>再犯罪因子热点图</span>
				<img src="<c:url value='/resource/images/gxt_01.png'/>" alt="...">
			</div>
		</div>

		<!--因子量表部分-->
		<div id="lbyzxs">
			<span>量表因子系数</span>
			<hr style=" height:2px;border:none;border-top:2px ridge #185598;" />
		</div>
		<div id="zhyzlb">
		    <span>综合评估量表</span>
			<table>
				<thead>
					<tr>
						<td>危险类型</td>
						<td>因子特质</td>
						<td>数据项</td>
						<td>因子</td>
						<td>相关因子</td>
						<td>相关系数</td>
						<td>当前权重</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>自杀</td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td>逃脱</td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td>行凶</td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td>再犯罪</td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
				</tbody>
			</table>
		</div>
		<div id="zsAndxx">
			<div class="yzAndlb">	
			    <span>自杀评估量表</span>	    
				<table>
				<thead>
					<tr>
						<td>危险类型</td>
						<td>因子特质</td>
						<td>数据项</td>
						<td>因子</td>
						<td>相关因子</td>
						<td>相关系数</td>
						<td>当前权重</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>自杀</td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td>逃脱</td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td>行凶</td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td>再犯罪</td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
				</tbody>
			</table>
			</div>
			<div class="yzAndlb">	
			    <span>行凶评估量表</span>		    
				<table>
				<thead>
					<tr>
						<td>危险类型</td>
						<td>因子特质</td>
						<td>数据项</td>
						<td>因子</td>
						<td>相关因子</td>
						<td>相关系数</td>
						<td>当前权重</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>自杀</td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td>逃脱</td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td>行凶</td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td>再犯罪</td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
				</tbody>
			</table>
			</div>
		</div>
		<div id="ttAndzfz">
			<div class="yzAndlb">
			    <span>脱逃评估量表</span>
				<table>
				<thead>
					<tr>
						<td>危险类型</td>
						<td>因子特质</td>
						<td>数据项</td>
						<td>因子</td>
						<td>相关因子</td>
						<td>相关系数</td>
						<td>当前权重</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>自杀</td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td>逃脱</td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td>行凶</td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td>再犯罪</td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
				</tbody>
			</table>
			</div>
			<div class="yzAndlb">	
			    <span>再犯罪评估量表</span>		    
				<table>
				<thead>
					<tr>
						<td>危险类型</td>
						<td>因子特质</td>
						<td>数据项</td>
						<td>因子</td>
						<td>相关因子</td>
						<td>相关系数</td>
						<td>当前权重</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>自杀</td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td>逃脱</td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td>行凶</td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td>再犯罪</td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
				</tbody>
			</table>
			</div>
		</div>
	</div>
</body>
</html>