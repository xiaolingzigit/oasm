<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>评估报告及生成</title>
</head>
<body>
		<!--评估报告查询-->
		<div id="bgcxtab" class="option_table">
			<div id="" class="">
				<div>
					<div class="layer02">

						<ul>
							<li><i class="zhengjian">监区</i> <span> <select style="width: 100px;height: 23px;">
										<option>三监区</option>
								</select>
							</span></li>


							<li><i class="zhengjian">囚号</i> <span><input id="rjqh" name="rjqh"
									type="text" style="width: 100px; height: 23px;" /></span></li>

							<li><i class="zhengjian">罪犯姓名</i> <span><input id="rjzsxm" name="rjzsxm"
									type="text" style="width: 100px;height: 23px;" /></span></li>
<!-- 							<li><i class="zhengjian">评估开始时间</i> <span class="timeset"> -->
<!-- 									<input type="text" cssClass="Wdate" maxLength="10" -->
<!-- 									style="font-size: 16px; font-family:" -->
<!-- 									微软雅黑";" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" /> -->
<!-- 							</span></li> -->
<!-- 							<li><i class="zhengjian">评估结束时间</i> <span class="timeset"> -->
<!-- 									<input type="text" cssClass="Wdate" maxLength="10" -->
<!-- 									style="font-size: 16px; font-family:" -->
<!-- 									微软雅黑";" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" /> -->
<!-- 							</span></li> -->
						</ul>
						<button class="button_submit" style="margin-top: 10px;">搜索</button>
						&nbsp;&nbsp;&nbsp;&nbsp;<span class="nullsousuo"></span>
					</div>
					<br> <br> <br>
					<div style="clear: both;display: none;">
						<div style="background: #ffcc00; width: 100px">
							<span><font size="" color="#ffffff">添加筛选条件</font></span>
						</div>
						<div>
							<ul class="layer02">
								<li class="cs-s-li-b-1"><span>危险等级：</span></li>
								<li class="cs-s-li-b-2">
									<ul class="layer02">
										<li class="cs-ss-sub-li"><label> <input
												type="checkbox" /> <span>极高危险</span>
										</label></li>
										<li class="cs-ss-sub-li"><label> <input
												type="checkbox" /> <span>高度危险</span>
										</label></li>
										<li class="cs-ss-sub-li"><label> <input
												type="checkbox" /> <span>中度危险</span>
										</label></li>
										<li class="cs-ss-sub-li"><label> <input
												type="checkbox" /> <span>低度危险</span>
										</label></li>
									</ul>
								</li>
							</ul>
						</div>
<!-- 						<div> -->
<!-- 							<ul class="layer02"> -->
<!-- 								<li class="cs-s-li-b-1"><span>危险类别：</span></li> -->
<!-- 								<li class="cs-s-li-b-2"> -->
<!-- 									<ul class="layer02"> -->
<!-- 										<li class="cs-ss-sub-li"><label> <input -->
<!-- 												type="checkbox" /> <span>自杀</span> -->
<!-- 										</label></li> -->
<!-- 										<li class="cs-ss-sub-li"><label> <input -->
<!-- 												type="checkbox" /> <span>行凶</span> -->
<!-- 										</label></li> -->
<!-- 										<li class="cs-ss-sub-li"><label> <input -->
<!-- 												type="checkbox" /> <span>逃脱</span> -->
<!-- 										</label></li> -->

<!-- 									</ul> -->
<!-- 								</li> -->
<!-- 							</ul> -->
<!-- 						</div> -->

					</div>

				</div>

				<!-- table -->
				<br> <br>
				<div class="content_table">
					<table width="100%">
						<thead>
						  <tr>
							<th class="base_th" width="5%">序号</th>
							<th class="base_th" width="10%">监区</th>
							<th class="base_th" width="10%">囚号</th>
							<th class="base_th" width="10%">罪犯姓名</th>
							<th class="base_th" width="10%">评估更新时间</th>
							<th class="base_th" width="10%">危险等级</th>
							<th class="base_th" width="10%">危险总评分</th>
<!-- 							<th class="base_th" width="3%">档案分析得分</th> -->
<!-- 							<th class="base_th" width="3%">结构性访谈得分</th> -->
<!-- 							<th class="base_th" width="3%">行为观察得分</th> -->
<!-- 							<th class="base_th" width="3%">心理测试总得分</th> -->
<!-- 							<th class="base_th" width="6%">预警原因</th> -->
<!-- 							<th class="base_th" width="10%">详细信息</th> -->
						</tr>
						</thead>
						<tbody id="pgbgxq">
<!-- 						  <tr> -->
<!-- 							<td>1</td> -->
<!-- 							<td>第十监区</td> -->
<!-- 							<td>6546545454</td> -->
<!-- 							<td>xx</td> -->
<!-- 							<td>2017-07-07</td> -->
<!-- 							<td>中度危险</td> -->
<!-- 							<td>68</td> -->
<!-- 							<td>12</td> -->
<!-- 							<td>12</td> -->
<!-- 							<td>23</td> -->
<!-- 							<td>43</td> -->
<!-- 							<td>档案异常</td> -->
<!-- 							<td><a href="#" -->
<!-- 								onclick="loadnext3('/oasm/pgbgsccxView/pgbg_rj')">点击进入</a></td> -->
<!-- 						  </tr> -->
						</tbody>
						
					</table>


				</div>

				<div class="fenye" style="display: none;">
					<ul class="fenye-ul">
						<li>共2页</li>
						<li>首页</li>
						<li>上一页</li>
						<li class="fenye-li01">1</li>
						<li class="fenye-li02">2</li>
						<li>下一页</li>
						<li>尾页</li>
						<li>转到第 <input type="text" /> 页
						</li>
					</ul>
				</div>
			</div>
		</div>
<script type="text/javascript" src="<c:url value='/resource/js/pggl/key.js' />"></script>
</body>
</html>