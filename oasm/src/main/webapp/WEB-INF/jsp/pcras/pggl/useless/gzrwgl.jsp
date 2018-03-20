<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>工作任务管理</title>
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

	<div id="" class="sub-block">
		<!-- 定位栏-->
		<div class="location">
			<div class="location_left">
				<i><font color="#ffffff"><strong>您现在的位置</strong></font></i>
			</div>
			<div class="location_right">
				<strong>&nbsp;&nbsp;评估管理 >><font color="#ff3300">工作任务管理</font></strong>
			</div>
		</div>
		<div class="main_content">
			<div id="option" class="option_area">
				<ul>
					<li id="zdfb" name="zdfb" class="option_li_current">自动发布任务</li>
					<li id="sdfb" name="sdfb">手动发布任务</li>
					<li id="dbrw" name="dbrw">待办任务</li>
					<li id="wjsp" name="wjsp">文件审批</li>
					<li id="wjbp" name="wjbp">文件报批</li>
					<li id="gzwcd" name="gzwcd">评估工作完成度</li>
				</ul>
			</div>
			<div id="basecontent" class="main_content_base">
				<div id="zdfbtab" class="option_table">

					<div id="" class="">
						<div>
							<div class="pull_down_one pull-down-two" style="height:145px;">
								<div style="margin-top: 10px;margin-bottom:10px;">
									<strong>&nbsp;&nbsp;入监评估工作自动发布设置：</strong>
								</div>
								<ul>
									<li><i class="zhengjian">罪犯入监后</i> <span><input
											type="text" /></span>个工作日内</li>
									<li><i class="zhengjian">档案分析量表选择：</i> <span><select>
												<option>scl90</option>
												<option>copa</option>
												<option>新收押罪犯管教量表</option>
												<option>4</option>
										</select></span></li>

									<li><i class="zhengjian">综合评估量表选择：</i> <span><select>
												<option>scl90</option>
												<option>copa</option>
												<option>新收押罪犯管教量表</option>
												<option>4</option>
										</select></span></li>
									<li><i class="zhengjian">专项评估量表选择：</i> <span><select>
												<option>scl90</option>
												<option>copa</option>
												<option>新收押罪犯管教量表</option>
												<option>4</option>
										</select></span></li>
									<li><span><input type="checkbox" /><i
											class="zhengjian">是否自动发布</i></span></li>

								</ul>
					
							</div>
<hr style="height: 2px; border-top: 2px dotted #185598;" />
			<div class="pull_down_one pull-down-two" style="height:145px;">
								<div style="margin-top: 10px">
									<strong>&nbsp;&nbsp;日常评估工作自动发布设置：</strong>
								</div>
								<ul>
									<li><i class="zhengjian">罪犯入监后</i> <span><input
											type="text" /></span>个工作日内</li>


									<li><i class="zhengjian">结构性访谈量表选择：</i> <span><select>
												<option>scl90</option>
												<option>copa</option>
												<option>新收押罪犯管教量表</option>
												<option>4</option>
										</select></span></li>
									<li><i class="zhengjian">日常观察量表选择：</i> <span><select>
												<option>scl90</option>
												<option>copa</option>
												<option>新收押罪犯管教量表</option>
												<option>4</option>
										</select></span></li>
									<li><i class="zhengjian">心理测试量表选择：</i> <span><select>
												<option>scl90</option>
												<option>copa</option>
												<option>新收押罪犯管教量表</option>
												<option>4</option>
										</select></span></li>
									<li><span><input type="checkbox" /><i
											class="zhengjian">是否自动发布</i></span></li>

								</ul>
							</div>
							<hr style="height: 2px; border-top: 2px dotted #185598;" />
							<div class="pull_down_one pull-down-two" style="height:145px;">
								<div style="margin-top: 10px">
									<strong>&nbsp;&nbsp;中期评估工作自动发布设置：</strong>
								</div>
								<ul>
									<li><i class="zhengjian">罪犯入监后</i> <span><input
											type="text" /></span>个工作日内</li>


									<li><i class="zhengjian">综合评估量表选择：</i> <span><select>
												<option>scl90</option>
												<option>copa</option>
												<option>新收押罪犯管教量表</option>
												<option>4</option>
										</select></span></li>
									<li><i class="zhengjian">专项评估量表选择：</i> <span><select>
												<option>scl90</option>
												<option>copa</option>
												<option>新收押罪犯管教量表</option>
												<option>4</option>
										</select></span></li>

									<li><span><input type="checkbox" /><i
											class="zhengjian">是否自动发布</i></span></li>

								</ul>
							</div>
							<hr style="height: 2px; border-top: 2px dotted #185598;" />
							<div class="pull_down_one pull-down-two" style="height:145px;">
								<div style="margin-top: 10px">
									<strong>&nbsp;&nbsp;出监评估工作自动发布设置：</strong>
								</div>
								<ul>
									<li><i class="zhengjian">罪犯出监前</i> <span><input
											type="text" /></span>个工作日内</li>


									<li><i class="zhengjian">再犯罪评估量表选择：</i> <span><select>
												<option>scl90</option>
												<option>copa</option>
												<option>新收押罪犯管教量表</option>
												<option>4</option>
										</select></span></li>

									<li><span><input type="checkbox" /><i
											class="zhengjian">是否自动发布</i></span></li>

								</ul>
							</div>

						</div>
						<div align=center>
							<button class="base_button"
								style="margin-top: 3px; margin-bottom: 5px;">保存设置</button>
						</div>
					</div>


					<!-- table -->

					<div class="content_table">
						<table width="100%">
							<tr>
								<th class="base_th" width="5%">序号</th>
								<th class="base_th" width="5%">监区</th>
								<th class="base_th" width="10%">任务</th>
								<th class="base_th" width="10%">警号</th>
								<th class="base_th" width="10%">警察姓名</th>
								<th class="base_th" width="10%">发布时间↓</th>
								<th class="base_th" width="10%">截止时间↓</th>
								<th class="base_th" width="10%">完成情况</th>
								<th class="base_th" width="10%">详细信息</th>
							</tr>
							<tr>
								<td>1</td>
								<td>第十监区</td>
								<td>入监评估</td>
								<td>526237823629</td>
								<td>王甫</td>
								<td>2017-07-07</td>
								<td>2017-07-20</td>
								<td>暂未完成</td>

								<td><a href="#">点击进入</a></td>
							</tr>
							<tr>
								<td>2</td>
								<td>第十监区</td>
								<td>入监评估</td>
								<td>526237823629</td>
								<td>刘备</td>
								<td>2017-07-07</td>
								<td>2017-07-20</td>
								<td>暂未完成</td>
								<td><a href="#")">点击进入</a></td>
							</tr>
							<tr>
								<td>1</td>
								<td>第十监区</td>
								<td>入监评估</td>
								<td>526237823629</td>
								<td>张帆</td>
								<td>2017-07-07</td>
								<td>2017-07-20</td>
								<td>暂未完成</td>
								<td><a href="#">点击进入</a></td>
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

				<div id="sdfbtab" class="option_table">
					<div id="" class="">
						<div>
							<div class="layer02">
								<ul>
									<li><i class="zhengjian">第一步：评估阶段选择</i> <span> <select>
												<!-- 								<option>基础评估</option>
								 -->
												<option>入监评估</option>
												<option>日常评估</option>
												<option>中期评估</option>
												<option>出监评估</option>
										</select>
									</span></li>

									<li><img src="<c:url value='/resource/images/arrow_right.jpg'/>" width="20"
										height="16" border="0" alt=""></li>
									<li><i class="zhengjian">第二步：评估类型选择</i> <span><select>
												<option>日常观察</option>
												<option>结构性访谈</option>
												<option>心理测试</option>
												<option>综合评估</option>
												<option>专项评估</option>
										</select></span></li>
									<li><img src="<c:url value='/resource/images/arrow_right.jpg'/>" width="20"
										height="16" border="0" alt=""></li>
									<li><i class="zhengjian">第三步：评估工具选择</i> <span><select>
												<option>scl90</option>
												<option>copa</option>
												<option>新收押罪犯管教量表</option>
												<option>4</option>
										</select></span></li>
									<li><img src="<c:url value='/resource/images/arrow_right.jpg'/>" width="20"
										height="16" border="0" alt=""></li>
									<li><i class="zhengjian">第四步：</i> <span>
											<button>添加罪犯</button>
									</span></li>
									<li><img src="<c:url value='/resource/images/arrow_right.jpg'/>" width="20"
										height="16" border="0" alt=""></li>
									<li><i class="zhengjian">第五步：设置完成时间</i> <span
										class="timeset"> <input type="text" cssClass="Wdate"
											maxLength="10" style="font-size: 16px; font-family:"
											微软雅黑";" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
									</span></li>

								</ul>

							</div>
							<div style="clear: both; padding: 0 0 0 40%">
								<button class="button_submit" style="margin-top: 10px;">确认发布</button>
							</div>

						</div>

					</div>

					<!-- table -->
					<br> <br>
					<div class="content_table">
						<table width="100%">
							<tr>
								<th class="base_th" width="5%">序号</th>
								<th class="base_th" width="5%">监区</th>
								<th class="base_th" width="10%">任务</th>
								<th class="base_th" width="10%">警号</th>
								<th class="base_th" width="10%">警察姓名</th>
								<th class="base_th" width="10%">发布时间↓</th>
								<th class="base_th" width="10%">截止时间↓</th>
								<th class="base_th" width="10%">完成情况</th>
								<th class="base_th" width="10%">详细信息</th>
							</tr>
							<tr>
								<td>1</td>
								<td>第十监区</td>
								<td>入监评估</td>
								<td>526237823629</td>
								<td>王甫</td>
								<td>2017-07-07</td>
								<td>2017-07-20</td>
								<td>暂未完成</td>

								<td><a href="#">点击进入</a></td>
							</tr>
							<tr>
								<td>2</td>
								<td>第十监区</td>
								<td>入监评估</td>
								<td>526237823629</td>
								<td>刘备</td>
								<td>2017-07-07</td>
								<td>2017-07-20</td>
								<td>暂未完成</td>
								<td><a href="#">点击进入</a></td>
							</tr>
							<tr>
								<td>1</td>
								<td>第十监区</td>
								<td>入监评估</td>
								<td>526237823629</td>
								<td>张帆</td>
								<td>2017-07-07</td>
								<td>2017-07-20</td>
								<td>暂未完成</td>
								<td><a href="#">点击进入</a></td>
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

				<div id="dbrwtab" class="option_table">
					<div id="" class="">
						<div>
							<div class="layer02">

								<h3>
									<font size="" color="#ff0033">待办任务</font>
								</h3>
							</div>

						</div>

					</div>

					<!-- table -->
					<br> <br>
					<div class="content_table">
						<table width="100%">
							<tr>
								<th class="base_th" width="5%">序号</th>
								<th class="base_th" width="10%">任务发布人</th>
								<th class="base_th" width="10%">发布时间</th>
								<th class="base_th" width="10%">任务内容</th>
								<th class="base_th" width="10%">任务截止时间</th>
								<th class="base_th" width="10%">任务对象</th>
							</tr>
							<tr>
								<td>1</td>
								<td>王甫</td>
								<td>2017-07-07</td>
								<td>结构性访谈</td>
								<td>2017-08-07</a></td>
								<td><a href="#">查看</a></td>
							</tr>
							<tr>
								<td>2</td>
								<td>王甫</td>
								<td>2017-07-07</td>
								<td>日常观察</td>
								<td>2017-08-07</a></td>
								<td><a href="#">查看</a></td>
							</tr>
							<tr>
								<td>3</td>
								<td>王甫</td>
								<td>2017-07-07</td>
								<td>自杀排查</td>
								<td>2017-08-07</a></td>
								<td><a href="#">查看</a></td>
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
				<div id="wjsptab" class="option_table">
					<div id="" class="">
						<div>
							<div class="layer02">

								<h3>
									<font size="" color="#ff0033">待审批文件</font>
								</h3>
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
								<th class="base_th" width="10%">发送人姓名</th>
								<th class="base_th" width="10%">发送时间</th>
								<th class="base_th" width="10%">文件名称</th>
								<th class="base_th" width="10%">详细信息</th>
								<th class="base_th" width="10%">文件下载</th>
							</tr>
							<tr>
								<td>1</td>
								<td>第十监区</td>
								<td>王甫</td>
								<td>2017-07-07</td>
								<td>2014年09月高危犯情况</td>
								<td><a href="#">审批</a></td>
								<td><a href="#">下载</a></td>
							</tr>
							<tr>
								<td>2</td>
								<td>第十监区</td>
								<td>王甫</td>
								<td>2017-07-07</td>
								<td>2015年09月高危犯情况</td>
								<td><a href="#">审批</a></td>
								<td><a href="#">下载</a></td>
							</tr>
							<tr>
								<td>1</td>
								<td>第十监区</td>
								<td>王甫</td>
								<td>2017-07-07</td>
								<td>2016年09月高危犯情况</td>
								<td><a href="#">审批</a></td>
								<td><a href="#">下载</a></td>
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
					<div id="" class="" style="margin-top: 20px">
						<div>
							<div class="layer02">

								<h3>
									<font size="" color="#00cc00">已审批文件</font>
								</h3>
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
								<th class="base_th" width="10%">发送人姓名</th>
								<!--  <th class="base_th" width="10%">囚号</th>
                    <th class="base_th" width="10%">罪犯姓名</th> -->
								<th class="base_th" width="10%">发送时间</th>
								<th class="base_th" width="10%">文件名称</th>
								<th class="base_th" width="10%">详细信息</th>
								<th class="base_th" width="10%">文件下载</th>
							</tr>
							<tr>
								<td>1</td>
								<td>第十监区</td>
								<td>王甫</td>
								<td>2017-07-07</td>
								<td>2014年09月高危犯情况</td>
								<td><a href="#">查看详情</a></td>
								<td><a href="#">下载</a></td>
							</tr>
							<tr>
								<td>2</td>
								<td>第十监区</td>
								<td>王甫</td>
								<td>2017-07-07</td>
								<td>2015年09月高危犯情况</td>
								<td><a href="#">查看详情</a></td>
								<td><a href="#">下载</a></td>
							</tr>
							<tr>
								<td>1</td>
								<td>第十监区</td>
								<td>王甫</td>
								<td>2017-07-07</td>
								<td>2016年09月高危犯情况</td>
								<td><a href="#">查看详情</a></td>
								<td><a href="#">下载</a></td>
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
				<div id="wjbptab" class="option_table">
					<div id="" class="">
						<div>
							<div class="layer02">
								<div style="margin-top: 20px">
									报批罪犯类型：<select><option value="高危以上罪犯">高危以上罪犯</option>
										<option value="顽危犯">顽危犯</option>
										<option value="重点犯">重点犯
										<option></select>
									<div style="margin-top: 20px">
										报批文件选择：<input type="file" />
									</div>
									</br> </br>
									<div style="margin-top: 20px">
										报批接收人： 输入其姓名<input type="text" />
									</div>
								</div>
								<div align=center style="clear: both;"></div>



							</div>
							<div style="clear: both; padding: 0 0 0 40%">
								<button class="button_submit" style="margin-bottom: 20px;">确认提交</button>
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
								<th class="base_th" width="10%">接收人姓名</th>
								<!--  <th class="base_th" width="10%">囚号</th>
                    <th class="base_th" width="10%">罪犯姓名</th> -->
								<th class="base_th" width="10%">发送时间</th>
								<th class="base_th" width="10%">罪犯类型</th>
								<th class="base_th" width="10%">文件名称</th>
								<th class="base_th" width="10%">详细信息</th>
							</tr>
							<tr>
								<td>1</td>
								<td>第十监区</td>
								<td>王甫</td>
								<td>2017-07-07</td>
								<td>重点犯</td>
								<td>2014年09月重点犯情况</td>

								<td><a href="#">点击进入</a></td>
							</tr>
							<tr>
								<td>2</td>
								<td>第十监区</td>
								<td>王甫</td>
								<td>2017-07-07</td>
								<td>顽危犯</td>
								<td>2015年09月顽危犯情况</td>
								<td><a href="#">点击进入</a></td>
							</tr>
							<tr>
								<td>1</td>
								<td>第十监区</td>
								<td>王甫</td>
								<td>2017-07-07</td>
								<td>高危以上罪犯</td>
								<td>2016年09月极高危险罪犯情况</td>
								<td><a href="#">点击进入</a></td>
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
				<div id="gzwcdtab" class="option_table">
					<div id="" class="">
						<div>
							<div class="layer02">
								<ul>
									<!--   <li>
                                <i class="zhengjian">监狱</i>
                                <span><input type="text" /></span>
                            </li> -->
									<li><i class="zhengjian">监区</i> <span> <select>
                                      
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


									<li><i class="zhengjian">警号</i> <span><input
											type="text" /></span></li>

									<li><i class="zhengjian">专管警察姓名</i> <span><input
											type="text" /></span></li>
									<li><i class="zhengjian">任务发布时间</i> <span class="timeset">
											<input type="text" cssClass="Wdate" maxLength="10"
											style="font-size: 16px; font-family:"
											微软雅黑";" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
									</span></li>
									</li>

								</ul>
							</div>
							<div style="clear: both; padding: 0 0 0 40%">
								<button class="button_submit" style="margin-top: 10px;">搜索</button>
							</div>

						</div>

					</div>

					<!-- table -->
					<br> <br>
					<div class="content_table">
						<table width="100%">
							<tr>
								<th class="base_th" width="5%">序号</th>
								<th class="base_th" width="5%">监区</th>
								<th class="base_th" width="10%">任务</th>
								<th class="base_th" width="10%">警号</th>
								<th class="base_th" width="10%">警察姓名</th>
								<!--  <th class="base_th" width="10%">囚号</th>
                    <th class="base_th" width="10%">罪犯姓名</th> -->
								<th class="base_th" width="10%">发布时间</th>
								<th class="base_th" width="10%">截止时间</th>
								<th class="base_th" width="10%">完成情况</th>
								<th class="base_th" width="10%">详细信息</th>
							</tr>
							<tr>
								<td>1</td>
								<td>第十监区</td>
								<td>结构性访谈</td>
								<td>526237823629</td>
								<td>王甫</td>
								<!--  <td>6546545454</td>
                    <td>xx</td> -->
								<td>2017-07-07</td>
								<td>2017-08-07</td>
								<td>暂未完成</td>

								<td><a href="#" onclick="loadnext2('/oasm/gzrwglView/xq_rc')">点击进入</a></td>
							</tr>
							<tr>
								<td>2</td>
								<td>第十监区</td>
								<td>心理测试</td>
								<td>526237823629</td>
								<td>刘备</td>
								<!--  <td>6546545454</td>
                    <td>xx</td> -->
								<td>2017-07-07</td>
								<td>2017-08-07</td>
								<td>暂未完成</td>
								<td><a href="#" onclick="loadnext2('/oasm/gzrwglView/xq_rc')">点击进入</a></td>
							</tr>
							<tr>
								<td>1</td>
								<td>第十监区</td>
								<td>行为观察</td>
								<td>526237823629</td>
								<td>张帆</td>
								<!--  <td>6546545454</td>
                    <td>xx</td> -->
								<td>2017-07-07</td>
								<td>2017-08-07</td>
								<td>暂未完成</td>
								<td><a href="#" onclick="loadnext2('/oasm/gzrwglView/xq_rc')">点击进入</a></td>
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
				                <!--子页面区 -->
				<div id="childpage" class="">
				
			    </div>

			</div>
		</div>
	</div>

</body>

</html>