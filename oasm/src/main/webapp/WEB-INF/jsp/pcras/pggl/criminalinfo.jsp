<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>罪犯基本信息</title>
</head>
<body>

	<div class="cs-im-nogg">

		<div class="cs-item">
			<div class="return_btn">
			</div>
			<div class="cs-item-title">罪犯基础信息</div>
			<ul class="cs-ul">
				<li class="cs-li"><span class="cs-item-1">囚号</span><span
					class="cs-item-2">${jbxx.qh}</span></li>
				<li class="cs-li"><span class="cs-item-1">姓名</span><span
					class="cs-item-2">${jbxx.xm }</span></li>
				<li class="cs-li"><span class="cs-item-1">性别</span><span
					class="cs-item-2">${jbxx.xb }</span></li>
				<li class="cs-li"><span class="cs-item-1">民族</span><span
					class="cs-item-2">${jbxx.mz }</span></li>
				<li class="cs-li"><span class="cs-item-1">捕前面貌</span><span
					class="cs-item-2">${jbxx.zzmm }</span></li>
				<li class="cs-li"><span class="cs-item-1">入监年龄</span><span
					class="cs-item-2">${jbxx.nl }</span></li>
				<li class="cs-li"><span class="cs-item-1">家庭住址</span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">身份证号</span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">户籍住址</span><span
					class="cs-item-2">${xxxx.hjdz }</span></li>
				<li class="cs-li"><span class="cs-item-1">户口分类</span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">入监前派出所</span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">籍贯</span><span
					class="cs-item-2">${jbxx.gj}</span></li>
				<li class="cs-li"><span class="cs-item-1">身份明否</span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">婚姻状况</span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">真实姓名</span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">出生地</span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">家庭状况</span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">捕前单位</span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">原学校</span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">犯罪事实</span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">捕前职务</span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">团伙人数</span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">犯罪日期</span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">犯罪时成年否</span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">团伙犯罪</span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">同案犯现状</span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">同案犯姓名</span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">前科劣迹情况</span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">劣迹记录次数</span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">前科次数</span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">前科劣迹记录次数</span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">判决机关</span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">判决机关</span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">判决字号</span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">原判罪名</span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">录政年限</span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">止日</span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">起日</span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">刑期</span><span
					class="cs-item-2">${xq}</span></li>
				<li class="cs-li"><span class="cs-item-1">剩余刑期</span><span
					class="cs-item-2">${xq}</span></li>
				<li class="cs-li"><span class="cs-item-1">原案犯类别</span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">已服刑期</span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">现案犯类别</span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">已服刑期比例</span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">已服刑期比例(比原判)</span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">原判剥政</span><span
					class="cs-item-2">${bznx }</span></li>
				<li class="cs-li"><span class="cs-item-1">原判刑期止日</span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">原判刑期起日</span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">原判刑期</span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">起诉机关</span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">逮捕日期 </span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">终审机关 </span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">罚金 </span><span
					class="cs-item-2">${xxxx.fz }</span></li>
				<li class="cs-li"><span class="cs-item-1">起诉字号 </span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">逮捕机关 </span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">终审字号 </span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">没收财产 </span><span
					class="cs-item-2">${xxxx.mscc }</span></li>
				<li class="cs-li"><span class="cs-item-1">罚金交纳 </span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">终审情况 </span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">一审机关 </span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">有无上诉 </span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">羁押日期 </span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">一审字号 </span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">执行书下达日期 </span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">罚金交纳金额 </span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">收押类别 </span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">调入日期 </span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">何处调来 </span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">入监日期 </span><span
					class="cs-item-2"><fmt:formatDate type="date" value="${xxxx.rjrq }" /></span></li>
				<li class="cs-li"><span class="cs-item-1">队别 </span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">分管等级 </span><span
					class="cs-item-2">${xxxx.hfgdj }</span></li>
				<li class="cs-li"><span class="cs-item-1">勤杂分工 </span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">分押类型 </span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">常留/暂押 </span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">考核分 </span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">减刑尺度 </span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">监管干警 </span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">床位号 </span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">监舍号 </span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">互监组号 </span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">婚姻状况（现） </span><span
					class="cs-item-2">${xxxx.htzk }</span></li>
				<li class="cs-li"><span class="cs-item-1">在押现状 </span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">亲情电话 </span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">在押档案号 </span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">主联系人电话 </span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">调入年龄 </span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">前科情况 </span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">特殊收押信息 </span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">住址所在地 </span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">邮政编码 </span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">减刑间隔(天) </span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">劳动岗位 </span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">户籍所在地 </span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">特殊离监信息 </span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">劣迹情况 </span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">减刑情况 </span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">最后减刑日期 </span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">刑罚变动情况 </span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">前科劣迹情况 </span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">特殊收押离监信息 </span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">卡片录入时间 </span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">重控类别 </span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">有无未领物品 </span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">奖惩情况 </span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">刑罚变动简况 </span><span
					class="cs-item-2"></span></li>
				<li class="cs-li"><span class="cs-item-1">看守所 </span><span
					class="cs-item-2"></span></li>
			</ul>
		</div>
	</div>

</body>