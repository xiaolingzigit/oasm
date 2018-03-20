<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>罪犯信息</title>
</head>
<body>
	<!--极高危罪犯管理-->
	<div id="" class="sub-block">
		<!-- 定位栏-->
		<div class="location">
			<div class="location_left">
				<i><font color="#ffffff"><strong>您现在的位置</strong></font></i>
			</div>
			<div class="location_right">
				<strong>&nbsp;&nbsp;专项管理 >><font color="#ff3300">极高危罪犯信息查询</font></strong>
			</div>
		</div>
		<!-- 功能子块-->
		<div class="main_content">
			<div id="basecontent" class="main_content_base">
				<div class="layer02">
		<div class="search_title">筛选条件：</div>
		<div class="search_area">
			<div style="float:left;" class="search_sub1">
				监区: <select>
					<option value="">全监</option>
					<option value="一监区">一监区</option>
					<option value="一监区">二监区</option>
					<option value="三监区">三监区</option>
					<option value="四监区">四监区</option>
					<option value="五监区">五监区</option>
					<option value="六监区">六监区</option>
					<option value="七监区">七监区</option>
					<option value="八监区">八监区</option>
					<option value="九监区">九监区</option>
					<option value="十监区">十监区</option>
					<option value="十二监区">十二监区</option>
					<option value="医院监区">医院监区</option>
					<option value="新犯队">新犯队</option>
					<option value="出监管区">出监管区</option>
					<option value="狱政科">狱政科</option>
				</select>
			</div>
			<div style="float:left;" class="search_sub1">
				囚号:<input type="text" />
			</div>
			<div style="float:left;" class="search_sub1">
				罪犯姓名：<input type="text" />
			</div>
			<div style="float:left;" class="search_sub1">
				专管警察：<input type="text" />
			</div>
			<div style="float:left;" class="search_sub1">
				<button class="button_submit2">搜索</button>
			</div>
						<div class="search_sub2">
				备案状态：
				<input type="radio" name="baStatus" id="baStatus_all" value="" /><label for="baStatus_all">全部</label>
				<input type="radio" name="baStatus" id="baStatus_1" value="" /><label for="baStatus_1">已备案</label>
				<input type="radio" name="baStatus" id="baStatus_0" value="" /><label for="baStatus_0">未备案</label>
			</div>
		</div>
		</div>
				<!--极高危罪犯名单列表 -->
				<div id="zftab" class="option_table3">
					<table class="content_table" width="100%">
								<tr>
								    <th class="base_th" width="5%"><input type="checkbox" class="common_checkbox" id="selectAll" value=""/></th>
									<th class="base_th" width="5%">序号</th>
									<th class="base_th" width="10%">监区</th>
									<th class="base_th" width="10%">囚号</th>
									<th class="base_th" width="10%">罪犯姓名</th>
									<th class="base_th" width="10%">入监时间</th>
									<th class="base_th" width="10%">危险评分</th>
									<th class="base_th" width="10%">专管警察</th>
									<th class="base_th" width="10%">详细个人信息</th>
									<th class="base_th" width="10%">备案状态</th>
									<!-- <th class="base_th" width="10%">操作</th>	 -->								
								</tr>
								<tbody id="jgwzfList">
								<tr>
								<td><input type="checkbox" class="common_checkbox" id="" value=""/></td>
									<td>1</td>
									<td>第十监区</td>
									<td>6546545454</td>
									<td>周伟权</td>
									<td>2017-07-07</td>
									<td>68</td>
									<td>刘瑾言</td>
									<td><a href="#" onclick="loadnext3('/oasm/jygzView/zfinfo')">点击进入</a>
									</td>
									<td><div class="addbutton2">
							                    备案</div>
									</td>
	<!-- 								<td><a href="#" onclick="loadnext3('/oasm/zxglView/jgf_bars')">查看备案</a>
									</td> -->
								</tr>
								<tr>
								<td class="pass"></td>
									<td>2</td>
									<td>第十监区</td>
									<td>6546545454</td>
									<td>李汝友</td>
									<td>2017-07-07</td>
									<td>68</td>
									<td>刘瑾言</td>
									<td><a href="#" onclick="loadnext3('/oasm/jygzView/zfinfo')">点击进入</a>
									</td>
									<td>已备案
									</td>
<!-- 									<td><div class="addbutton2"onclick="loadnext3('/oasm/zxglView/jgf_balr')">
							                    备案</div> -->
									</td>
								</tr>
								<tr>
								<td><input type="checkbox"  class="common_checkbox" id="" value=""/></td>
									<td>3</td>
									<td>第十监区</td>
									<td>6546545454</td>
									<td>周斌</td>
									<td>2017-07-07</td>
									<td>68</td>
									<td>刘瑾言</td>
									<td><a href="#" onclick="loadnext3('/oasm/jygzView/zfinfo')">点击进入</a>
									</td>
									<td><div class="addbutton2">
							                    备案</div>
									</td>
<!-- 									<td><div class="addbutton2"onclick="loadnext3('/oasm/zxglView/jgf_balr')">
							                    备案</div> -->
									</td>
								</tr>
								</tbody>
							</table>
					<button>备案选中</button>
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
			
			</div>
		</div>
	</div>
	<script type="text/javascript">
			$("#selectAll").click(function() {
			//alert(this.checked);  
			if ($(this).is(':checked')) {
				$('#jgwzfList tr').each(function() {
					$(this).find("input").prop("checked", "checked");
				});
			} else {
				$('#jgwzfList tr').each(function() {
					$(this).find("input").prop("checked", "");
				});
			}

		});
    </script>
</body>
</html>