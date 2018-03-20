<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>评估报告及生成</title>
</head>
<body>
  <script>
	var li = document.getElementsByClassName('option_area')[0].getElementsByTagName('li');
	var div = document.getElementsByClassName('option_table');
	for(var i=0;i<li.length;i++)
	{
		//给每个li自定义一个属性，记录下标
		li[i].setAttribute('data-i',i);

		li[i].onclick = function(){
            $('#childpage').css({
	            'display':'none'
	        });
			$('#childpage').text("加载中...");
			//先将所有div隐藏
			for(var j=0;j<div.length;j++){
				div[j].style.display = 'none';
				li[j].className = '';
			}

			//将当前对应下标的div显示出来
			var index = this.getAttribute('data-i');
			div[index].style.display = 'block';
			this.className = 'option_li_current';
		}
	}
	</script>

	<!--评估报告生成及查询-->
	<div id="" class="sub-block">
		<!-- 定位栏-->
		<div class="location">
			<div class="location_left">
				<i><font color="#ffffff"><strong>您现在的位置</strong></font></i>
			</div>
			<div class="location_right">
				<strong>&nbsp;&nbsp;评估管理 >><font color="#ff3300">评估报告生成及查询</font></strong>
			</div>
		</div>
		<!-- 功能子块-->
		<div class="main_content">
			<div id="option" class="option_area">
				<ul>
					<li id="bgsc" name="dafx" class="option_li_current">评估报告生成</li>
					<li id="bgcx" name="jgft">评估报告查询</li>
				</ul>
			</div>
			<div id="basecontent" class="main_content_base">
				<!--评估报告生成-->
				<div id="bgsctab" class="option_table">
					<div id="" class="">
						<div>
							<div class="layer02">

								<h2>
									<font size="" color="#ff0033">待评估罪犯列表</font>
								</h2>
								<span><small><font color="#919191">&nbsp;说明：数据完整，或缺失数据项已忽略</font></small></span>
								<div style="padding-left:90%">
 
									<button class="button_submit" style="padding:1px 1px 1px 1px;">一键生成选中</button>
								</div>
							</div>

						</div>

					</div>

					<!-- table -->
					<br> <br>
					<div class="content_table">
						<table width="100%">
							<tr>
								<th class="base_th" width="5%"></th>
								<th class="base_th" width="5%">序号</th>
								<th class="base_th" width="8%">监区</th>
								<th class="base_th" width="4%">囚号</th>
								<th class="base_th" width="8%">罪犯姓名</th>
								<th class="base_th" width="10%">评估报告类型↓</th>
								<!-- <th class="base_th" width="8%">预警原因</th>
                        <th class="base_th" width="8%">预警类型</th> -->
								<th class="base_th" width="9%">评估报告人工校正</th>
								<!--  <th class="base_th" width="8%">备案情况</th>
                        <th class="base_th" width="8%">多级反馈</th>
                        <th class="base_th" width="10%">处置跟踪</th>
                                               -->
							</tr>
							<tr>
								<td><input type=checkbox></td>
								<td>1</td>
								<td>第一监区</td>
								<td>6546545454</td>
								<td>李四</td>
								<td>入监评估</td>
								<!--  <td>涉枪</td>
                        <td>阳性预警</td> -->
								<td><a class="cs-a" href="#"
									onclick="loadnext2('/oasm/pgbgsccxView/pgbg_rj1')">操作</a></td>
								<!-- <td>成功</td>
                        <td>通过</td>
                        <td>详细信息</td> -->

							</tr>
							<tr>
								<td><input type=checkbox></td>
								<td>2</td>
								<td>第一监区</td>
								<td>6546545454</td>
								<td>xx</td>
								<td>入监评估</td>
								<!--   <td>xx</td>
                        <td>阳性预警</td> -->
								<td><a class="cs-a" href="#"
									onclick="loadnext2('/oasm/pgbgsccxView/pgbg_rj1')">操作</a></td>
								<!-- <td>成功</td>
                        <td>通过</td>
                        <td>详细信息</td> -->
							</tr>
							<tr>
								<td><input type=checkbox></td>
								<td>3</td>
								<td>第一监区</td>
								<td>6546545454</td>
								<td>xx</td>
								<td>入监评估</td>
								<!-- <td>涉毒</td>
                        <td>阳性预警</td> -->
								<td><a class="cs-a" href="#"
									onclick="loadnext2('/oasm/pgbgsccxView/pgbg_rj1')">操作</a></td>
								<!-- <td>成功</td>
                        <td>通过</td>
                        <td>详细信息</td> -->
							</tr>

						</table>


					</div>

					<div class="fenye">
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
				<!--评估报告查询-->
				<div id="bgcxtab" class="option_table">
					<div id="" class="">
						<div>
							<div class="layer02">

								<ul>
									<!--   <li>
                                <i class="zhengjian">监狱</i>
                                <span><input type="text" /></span>
                            </li> -->
									<li><i class="zhengjian">监区</i> <span>
									<select>
                                     <option>全监</option>
									 <option>一监区</option>
									 <option>二监区</option>
									 <option>三监区</option>
									 <option>四监区</option>
									 <option>五监区</option>
									 <option>六监区</option>
									 <option>七监区</option>
									 <option>八监区</option>
									 <option>九监区</option>
									 <option>十监区</option>
									</select>
									</span></li>


									<li><i class="zhengjian">囚号</i> <span><input
											type="text" /></span></li>

									<li><i class="zhengjian">罪犯姓名</i> <span><input
											type="text" /></span></li>
									<li><i class="zhengjian">评估开始时间</i> <span class="timeset">
											<input type="text" cssClass="Wdate" maxLength="10"
											style="font-size: 16px; font-family:"
											微软雅黑";" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
									</span></li>
									<li><i class="zhengjian">评估结束时间</i> <span class="timeset">
											<input type="text" cssClass="Wdate" maxLength="10"
											style="font-size: 16px; font-family:"
											微软雅黑";" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
									</span></li>
								</ul>
								<button class="button_submit" style="margin-top: 10px;">搜索</button>
							</div>
							<br> <br> <br>
							<div style="clear: both;">
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
								<div>
									<ul class="layer02">
										<li class="cs-s-li-b-1"><span>危险类别：</span></li>
										<li class="cs-s-li-b-2">
											<ul class="layer02">
												<li class="cs-ss-sub-li"><label> <input
														type="checkbox" /> <span>自杀</span>
												</label></li>
												<li class="cs-ss-sub-li"><label> <input
														type="checkbox" /> <span>行凶</span>
												</label></li>
												<li class="cs-ss-sub-li"><label> <input
														type="checkbox" /> <span>逃脱</span>
												</label></li>

											</ul>
										</li>
									</ul>
								</div>

							</div>

						</div>

						<!-- table -->
						<br> <br>
						<div class="content_table">
							<table width="100%">
								<tr>
									<th class="base_th" width="5%">序号</th>
									<th class="base_th" width="10%">监区</th>
									<th class="base_th" width="10%">囚号</th>
									<th class="base_th" width="10%">罪犯姓名</th>
									<th class="base_th" width="10%">评估更新时间</th>
									<th class="base_th" width="10%">危险程度</th>
									<th class="base_th" width="10%">危险总评分</th>
									<th class="base_th" width="3%">档案分析得分</th>
									<th class="base_th" width="3%">结构性访谈得分</th>
									<th class="base_th" width="3%">行为观察得分</th>
									<th class="base_th" width="3%">心理测试总得分</th>
									<th class="base_th" width="6%">预警原因</th>
									<th class="base_th" width="10%">详细信息</th>
								</tr>
								<tr>
									<td>1</td>
									<td>第十监区</td>
									<td>6546545454</td>
									<td>xx</td>
									<td>2017-07-07</td>
									<td>中度危险</td>
									<td>68</td>
									<td>12</td>
									<td>12</td>
									<td>23</td>
									<td>43</td>
									<td>档案异常</td>
									<td><a href="#" onclick="loadnext2('/oasm/pgbgsccxView/pgbg_rj1')">点击进入</a>
									</td>
								</tr>
								<tr>
									<td>2</td>
									<td>第十监区</td>
									<td>6546545454</td>
									<td>xx</td>
									<td>2017-07-07</td>
									<td>中度危险</td>
									<td>68</td>
									<td>12</td>
									<td>12</td>
									<td>23</td>
									<td>43</td>
									<td>档案异常</td>
									<td><a href="#" onclick="loadnext2('/oasm/pgbgsccxView/pgbg_rj1')">点击进入</a>
									</td>
								</tr>
								<tr>
									<td>1</td>
									<td>第十监区</td>
									<td>6546545454</td>
									<td>xx</td>
									<td>2017-07-07</td>
									<td>中度危险</td>
									<td>68</td>
									<td>12</td>
									<td>12</td>
									<td>23</td>
									<td>43</td>
									<td>档案异常</td>
									<td><a href="#" onclick="loadnext2('/oasm/pgbgsccxView/pgbg_rj1')">点击进入</a>
									</td>
								</tr>
							</table>


						</div>

						<div class="fenye">
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
				<!--子页面区 -->
				<div id="childpage" class=""></div>

			</div>
		</div>
</body>
</html>