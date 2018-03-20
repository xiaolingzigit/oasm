<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>个人任务</title>

</head>
<body>

				<div id="wjbptab" class="option_table3">
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
								<th class="base_th" width="10%">警号</th>
								<th class="base_th" width="10%">接收人姓名</th>
								<!--  <th class="base_th" width="10%">囚号</th>
                    <th class="base_th" width="10%">罪犯姓名</th> -->
								<th class="base_th" width="10%">发送时间</th>
								<th class="base_th" width="10%">文件名称</th>
								<th class="base_th" width="10%">详细信息</th>
							</tr>
							<tr>
								<td>1</td>
								<td>第十监区</td>
								<td>526237823629</td>
								<td>王甫</td>
								<td>2017-07-07</td>
								<td>2014年09月重点犯情况</td>

								<td><a href="#">点击进入</a></td>
							</tr>
							<tr>
								<td>2</td>
								<td>第十监区</td>
								<td>526237823629</td>
								<td>王甫</td>
								<td>2017-07-07</td>
								<td>2015年09月顽危犯情况</td>
								<td><a href="#">点击进入</a></td>
							</tr>
							<tr>
								<td>3</td>
								<td>第十监区</td>
								<td>526237823629</td>
								<td>王甫</td>
								<td>2017-07-07</td>
								<td>2016年09月极高危险罪犯情况</td>
								<td><a href="#">点击进入</a></td>
							</tr>
						</table>

					</div>
			<div id="barcon" class="barcon">
				<span id="barcon1" class="barcon1">共3条记录&nbsp;当前1/1页</span>
					<span id="barcon2" class="barcon2">
						<ul class="paging_ul">
							<li><a id="firstPage">首页</a></li>
								<li><a id="prePage">上一页</a></li>
								<li><a id="nextPage">下一页</a></li>
								<li><a id="lastPage">尾页</a></li>
								<li><select id="jumpWhere"
									style="width: 50px; height: 30px;"></select></li>
								<li><a id="jumpPage" onclick="jumpPage()">跳转</a></li>
						</ul>
					</span>
					<span id="pageSize" style="display: none;"></span>
					<span id="pages" style="display: none;"></span>
					<span id="pageNum" style="display: none;"></span>

				</div>
<script type="text/javascript" src="<c:url value='/resource/js/grgzmb/grgzmb.js'/>"></script>
</body>
</html>
