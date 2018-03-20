<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>档案分析</title>
<!-- 分页样式 -->
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resource/css/page.css'/>">
<!-- 页面内容的js -->
<script type="text/javascript"
	src="<c:url value='/resource/js/pggl/pggl.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/resource/js/page.js'/>"></script>
<script type="text/javascript">
	$(function() {
		var li = document.getElementsByClassName('option_area')[0]
				.getElementsByTagName('li');
		var div = document.getElementsByClassName('option_table');
		for (var i = 0; i < li.length; i++) {
			//给每个li自定义一个属性，记录下标
			li[i].setAttribute('data-i', i);

			li[i].onclick = function() {
				$('#childpage').css({
					'display' : 'none'
				});
				$('#childpage').text("加载中...");
				//先将所有div隐藏
				for (var j = 0; j < div.length; j++) {
					div[j].style.display = 'none';
					li[j].className = '';
				}

				//将当前对应下标的div显示出来
				var index = this.getAttribute('data-i');
				div[index].style.display = 'block';
				this.className = 'option_li_current';
			}
		}
	});
	$(function() {
		goPage(1, 10);
	});
</script>

</head>
<body>
	<!--数据采集与排查 -->
	<div id="" class="sub-block">
		<!-- 定位栏-->
		<div class="location">
			<div class="location_left">
				<i><font color="#ffffff"><strong>您现在的位置</strong></font></i>
			</div>
			<div class="location_right">
				<strong>&nbsp;&nbsp;评估管理 >><font color="#ff3300">专项数据采集与排查</font></strong>
			</div>
		</div>
		<!-- 功能子块-->
		<div class="main_content">
			<!--选项卡 -->
			<div id="option" class="option_area">
				<ul>
					<li id="dafx" name="dafx" class="option_li_current">档案分析</li>
					<li id="jgft" name="jgft">结构性访谈</li>
					<li id="jgft" name="jgft">出监访谈</li>
					<li id="rcgc" name="rcgc">行为观察</li>
					<li id="rcgc" name="rcgc">出监观察</li>
					<li id="xlcs" name="xlcs">心理测试</li>
	                <li id="zhsx" name="zhsx">综合筛选</li>
					<li id="zspc" name="zspc">自杀排查</li>
					<li id="xxpc" name="xxpc">行凶排查</li>
					<li id="ttpc" name="ttpc">脱逃排查</li>
					<li id="zfpc" name="zfpc">再犯罪排查</li>
				</ul>
			</div>
			<!--可选内容 -->
			<div id="basecontent" class="main_content_base">
				<!--档案分析 -->
				<div id="dafxtab" class="option_table">
					<table class="content_table" width="100%">
						<thead>
							<tr>
								<th width="5%">序号</th>
								<th width="10%">囚号</th>
								<th width="10%">罪犯姓名</th>
								<th width="10%">信息类型</th>
								<th width="10%">评估分数</th>
								<th width="10%">详细信息</th>
							</tr>
						</thead>
						<tbody id="adminTbody">
							<c:forEach varStatus="status" items="${dafxList}" var="da">
						   <tr>
							 <td>${status.count }</td>
							 <td>${da.qh }</td>
							 <td>${da.zsxm }</td>
							 <td>档案分析</td>
							 <td id="datotall">${da.dafxfz }</td>
							 <td><a href="#" onclick="loadnext18(${da.qh},'/oasm/dafxView/dafxrs2');">点击进入</a></td>
						     <td style="display: none;" id="dabgscsj"><fmt:formatDate value="${da.bgscsj }" pattern="yyyy-MM-dd"/>  </td>
						  </tr>
						    </c:forEach>
						  </tbody>
						</table>
<!-- 					<div class="fenye"> -->
<!-- 						<ul class="fenye-ul"> -->
<!-- 							<li>共<a style="color: red;">2</a>个记录 -->
<!-- 							</li> -->
<!-- 							<li>共2页</li> -->
<!-- 							<li>首页</li> -->
<!-- 							<li>上一页</li> -->
<!-- 							<li class="fenye-li01">1</li> -->
<!-- 							<li class="fenye-li02">2</li> -->
<!-- 							<li>下一页</li> -->
<!-- 							<li>尾页</li> -->
<!-- 							<li>转到第 <input type="text" /> 页 -->
<!-- 							</li> -->
<!-- 						</ul> -->
<!-- 					</div> -->
            <div id="barcon" class="barcon">    
          <div id="barcon1" class="barcon1"></div>    
           <div id="barcon2" class="barcon2">    
            <ul>    
                <li><a id="firstPage">首页</a></li>    
                <li><a id="prePage">上一页</a></li>    
                <li><a id="nextPage">下一页</a></li>    
                <li><a id="lastPage">尾页</a></li>    
                <li><select id="jumpWhere" style="width: 50px;height: 30px;"></select></li>    
                <li><a id="jumpPage" onclick="jumpPage()">跳转</a></li>    
            </ul>    
         </div>  
      </div>
       <div class="addbutton" onclick="loadnext16('/oasm/dafxView/dafxlb2')">
						<i>添加</i>
		</div>  
				</div>
				<!--结构性访谈 -->
				<div id="jgfttab" class="option_table">
					<table class="content_table" width="100%">
						<tr>
							<th class="base_th" width="5%">序号</th>
							<th class="base_th" width="10%">囚号</th>
							<th class="base_th" width="10%">罪犯姓名</th>
							<th class="base_th" width="10%">采集时间</th>
							<th class="base_th" width="10%">信息类型</th>
							<th class="base_th" width="10%" >评估分数</th>
							<th class="base_th" width="10%">详细信息</th>
						</tr>
						<tr>
							<td>1</td>
							<td>6546545454</td>
							<td>陈文斌</td>
							<td>2017-07-07</td>
							<td>结构性访谈</td>
							<td>9</td>
							<td><a href="#" onclick="loadnext11('/oasm/dafxView/jgftrs')">点击进入</a>
							</td>
						</tr>
						<tr>
							<td>2</td>
							<td>6546545454</td>
							<td>王富贵</td>
							<td>2017-07-07</td>
							<td>结构性访谈</td>
							<td>9</td>
							<td><a href="#" onclick="loadnext11('/oasm/dafxView/jgftrs')">点击进入</a>
							</td>
						</tr>
					</table>
					<div class="fenye">
						<ul class="fenye-ul">
							<li>共<a style="color: red;">2</a>个记录
							</li>
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
					<div class="addbutton" onclick="loadnext11('/oasm/dafxView/jgftlb')">
						<i>添加</i>
					</div>
				</div>
				<!--出监访谈 -->
				<div id="cjfttab" class="option_table">
					<table class="content_table" width="100%">
						<tr>
							<th class="base_th" width="5%">序号</th>
							<th class="base_th" width="10%">囚号</th>
							<th class="base_th" width="10%">罪犯姓名</th>
							<th class="base_th" width="10%">采集时间</th>
							<th class="base_th" width="10%">信息类型</th>
							<th class="base_th" width="10%" >评估分数</th>
							<th class="base_th" width="10%">详细信息</th>
						</tr>
						<tr>
							<td>1</td>
							<td>6546545454</td>
							<td>陈文斌</td>
							<td>2017-07-07</td>
							<td>出监访谈</td>
							<td>9</td>
							<td><a href="#" onclick="loadnext11('/oasm/dafxView/cjftrs')">点击进入</a>
							</td>
						</tr>
						<tr>
							<td>2</td>
							<td>6546545454</td>
							<td>王富贵</td>
							<td>2017-07-07</td>
							<td>出监访谈</td>
							<td>9</td>
							<td><a href="#" onclick="loadnext11('/oasm/dafxView/cjftrs')">点击进入</a>
							</td>
						</tr>
					</table>
					<div class="fenye">
						<ul class="fenye-ul">
							<li>共<a style="color: red;">2</a>个记录
							</li>
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
					<div class="addbutton" onclick="loadnext11('/oasm/dafxView/cjftlb')">
						<i>添加</i>
					</div>
				</div>

				<!--行为观察 -->
				<div id="rcgctab" class="option_table">
					<table class="content_table" width="100%">
						<tr>
							<th class="base_th" width="5%">序号</th>
							<th class="base_th" width="10%">囚号</th>
							<th class="base_th" width="10%">罪犯姓名</th>
							<th class="base_th" width="10%">导入时间</th>
							<th class="base_th" width="10%">信息类型</th>
							<th class="base_th" width="10%" >评估分数</th>
							<th class="base_th" width="10%">详细信息</th>
						</tr>
						<tr>
							<td>1</td>
							<td>6546545454</td>
							<td>刘家窑</td>
							<td>2017-07-07</td>
							<td>行为观察</td>
							<td>9</td>
							<td><a href="#" onclick="loadnext12('/oasm/dafxView/rcgcrs')">点击进入</a>
							</td>
						</tr>
						<tr>
							<td>2</td>
							<td>6546545454</td>
							<td>方通</td>
							<td>2017-07-07</td>
							<td>行为观察</td>
							<td>9</td>
							<td><a href="#" onclick="loadnext12('/oasm/dafxView/rcgcrs')">点击进入</a>
							</td>
						</tr>
					</table>
					<div class="fenye">
						<ul class="fenye-ul">
							<li>共<a style="color: red;">2</a>个记录
							</li>
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
					<div class="addbutton" onclick="loadnext12('/oasm/dafxView/rcgclb')">
						<i>添加</i>
					</div>

				</div>
				<!--出监观察 -->
				<div id="cjgctab" class="option_table">
					<table class="content_table" width="100%">
						<tr>
							<th class="base_th" width="5%">序号</th>
							<th class="base_th" width="10%">囚号</th>
							<th class="base_th" width="10%">罪犯姓名</th>
							<th class="base_th" width="10%">导入时间</th>
							<th class="base_th" width="10%">信息类型</th>
							<th class="base_th" width="10%" >评估分数</th>
							<th class="base_th" width="10%">详细信息</th>
						</tr>
						<tr>
							<td>1</td>
							<td>6546545454</td>
							<td>刘家窑</td>
							<td>2017-07-07</td>
							<td>出监观察</td>
							<td>9</td>
							<td><a href="#" onclick="loadnext12('/oasm/dafxView/cjgcrs')">点击进入</a>
							</td>
						</tr>
						<tr>
							<td>2</td>
							<td>6546545454</td>
							<td>方通</td>
							<td>2017-07-07</td>
							<td>出监观察</td>
							<td>9</td>
							<td><a href="#" onclick="loadnext12('/oasm/dafxView/cjgcrs')">点击进入</a>
							</td>
						</tr>
					</table>
					<div class="fenye">
						<ul class="fenye-ul">
							<li>共<a style="color: red;">2</a>个记录
							</li>
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
					<div class="addbutton" onclick="loadnext12('/oasm/dafxView/cjgclb')">
						<i>添加</i>
					</div>

				</div>
				<!--心理测试 -->
				<div id="xlcstab" class="option_table">
					<table class="content_table" width="100%">
						<tr>
							<th class="base_th" width="5%">序号</th>
							<th class="base_th" width="10%">囚号</th>
							<th class="base_th" width="10%">罪犯姓名</th>
							<th class="base_th" width="10%">采集时间</th>
							<th class="base_th" width="10%">信息类型</th>
							<th class="base_th" width="10%" >评估分数</th>
							<th class="base_th" width="10%">详细信息</th>
						</tr>
						<tr>
							<td>1</td>
							<td>6546545454</td>
							<td>周易</td>
							<td>2017-07-07</td>
							<td>COPA-PI量表</td>
							<td>9</td>
							<td><a href="#" onclick="loadnext13('/oasm/dafxView/copars')">点击进入</a></td>
						</tr>
						<tr>
							<td>2</td>
							<td>6546545454</td>
							<td>林芝市</td>
							<td>2017-07-07</td>
							<td>COPA-PI量表</td>
							<td>9</td>
							<td><a href="#" onclick="loadnext13('/oasm/dafxView/copars')">点击进入</a></td>
						</tr>
					</table>
					<div class="fenye">
						<ul class="fenye-ul">
							<li>共<a style="color: red;">2</a>个记录
							</li>
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
					<div class="addbutton" onclick="loadnext13('/oasm/dafxView/copalb')">
						<i>添加</i>
					</div>
					<table class="content_table" width="100%">
						<tr>
							<th class="base_th" width="5%">序号</th>
							<th class="base_th" width="10%">囚号</th>
							<th class="base_th" width="10%">罪犯姓名</th>
							<th class="base_th" width="10%">采集时间</th>
							<th class="base_th" width="10%">信息类型</th>
							<th class="base_th" width="10%" >评估分数</th>
							<th class="base_th" width="10%">详细信息</th>
						</tr>
						<tr>
							<td>1</td>
							<td>6546545454</td>
							<td>xx</td>
							<td>2017-07-07</td>
							<td>scl90量表</td>
							<td>9</td>
							<td><a href="#" onclick="loadnext13('/oasm/dafxView/scl90rs')">点击进入</a></td>
						</tr>
						<tr>
							<td>2</td>
							<td>6546545454</td>
							<td>xx</td>
							<td>2017-07-07</td>
							<td>scl90量表</td>
							<td>9</td>
							<td><a href="#" onclick="loadnext13('/oasm/dafxView/scl90rs')">点击进入</a></td>
						</tr>
					</table>
					<div class="fenye">
						<ul class="fenye-ul">
							<li>共<a style="color: red;">2</a>个记录
							</li>
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
					<div class="addbutton" onclick="loadnext13('/oasm/dafxView/scl90lb')"><i>添加</i></div>
				</div>
				<!--综合筛选 -->
				<div id="zhsxtab" class="option_table">
					<table class="content_table" width="100%">
						<tr>
							<th class="base_th" width="5%">序号</th>
							<th class="base_th" width="10%">囚号</th>
							<th class="base_th" width="10%">罪犯姓名</th>
							<th class="base_th" width="10%">创建时间</th>
							<th class="base_th" width="10%">信息类型</th>
							<th class="base_th" width="10%" >评估分数</th>
							<th class="base_th" width="10%">详细信息</th>
						</tr>
						<tr>
							<td>1</td>
							<td>6546545454</td>
							<td>彭飞</td>
							<td>2017-07-07</td>
							<td>综合筛选</td>
							<td>9</td>
							<td><a href="#" onclick="loadnext14('/oasm/dafxView/zhsxrs')">点击进入</a>
							</td>
						</tr>
						<tr>
							<td>2</td>
							<td>6546545454</td>
							<td>杨府山</td>
							<td>2017-07-07</td>
							<td>综合筛选</td>
							<td>9</td>
							<td><a href="#" onclick="loadnext14('/oasm/dafxView/zhsxrs')">点击进入</a>
							</td>
						</tr>
					</table>
					<div class="fenye">
						<ul class="fenye-ul">
							<li>共<a style="color: red;">2</a>个记录
							</li>
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
					<div class="addbutton" onclick="loadnext14('/oasm/dafxView/zhsxlb')">
						<i>添加</i>
					</div>

				</div>
                <!--自杀排查 -->
				<div id="zspc" class="option_table">
					<table class="content_table" width="100%">
						<tr>
							<th class="base_th" width="5%">序号</th>
							<th class="base_th" width="10%">囚号</th>
							<th class="base_th" width="10%">罪犯姓名</th>
							<th class="base_th" width="10%">创建时间</th>
							<th class="base_th" width="10%">信息类型</th>
							<th class="base_th" width="10%" >评估分数</th>
							<th class="base_th" width="10%">详细信息</th>
						</tr>
						<tr>
							<td>1</td>
							<td>6546545454</td>
							<td>xx</td>
							<td>2017-07-07</td>
							<td>自杀排查</td>
							<td>9</td>
							<td><a href="#" onclick="loadnext15('/oasm/dafxView/zspcrs')">点击进入</a>
							</td>
						</tr>
						<tr>
							<td>2</td>
							<td>6546545454</td>
							<td>xx</td>
							<td>2017-07-07</td>
							<td>自杀排查</td>
							<td>9</td>
							<td><a href="#" onclick="loadnext15('/oasm/dafxView/zspcrs')">点击进入</a>
							</td>
						</tr>
					</table>
					<div class="fenye">
						<ul class="fenye-ul">
							<li>共<a style="color: red;">2</a>个记录
							</li>
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
					<div class="addbutton" onclick="loadnext15('/oasm/dafxView/zspclb')">
						<i>添加</i>
					</div>
				</div>
				<!--行凶排查 -->
				<div id="xxpc" class="option_table">
					<table class="content_table" width="100%">
						<tr>
							<th class="base_th" width="5%">序号</th>
							<th class="base_th" width="10%">囚号</th>
							<th class="base_th" width="10%">罪犯姓名</th>
							<th class="base_th" width="10%">创建时间</th>
							<th class="base_th" width="10%">信息类型</th>
							<th class="base_th" width="10%" >评估分数</th>
							<th class="base_th" width="10%">详细信息</th>
						</tr>
						<tr>
							<td>1</td>
							<td>6546545454</td>
							<td>xx</td>
							<td>2017-07-07</td>
							<td>行凶排查</td>
							<td>9</td>
							<td><a href="#" onclick="loadnext15('/oasm/dafxView/xxpcrs')">点击进入</a>
							</td>
						</tr>
						<tr>
							<td>2</td>
							<td>6546545454</td>
							<td>xx</td>
							<td>2017-07-07</td>
							<td>行凶排查</td>
							<td>9</td>
							<td><a href="#" onclick="loadnext15('/oasm/dafxView/xxpcrs')">点击进入</a>
							</td>
						</tr>
					</table>
					<div class="fenye">
						<ul class="fenye-ul">
							<li>共<a style="color: red;">2</a>个记录
							</li>
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
					<div class="addbutton" onclick="loadnext15('/oasm/dafxView/xxpclb')">
						<i>添加</i>
					</div>
				</div>
				<!--脱逃排查 -->
				<div id="ttpc" class="option_table">
					<table class="content_table" width="100%">
						<tr>
							<th class="base_th" width="5%">序号</th>
							<th class="base_th" width="10%">囚号</th>
							<th class="base_th" width="10%">罪犯姓名</th>
							<th class="base_th" width="10%">创建时间</th>
							<th class="base_th" width="10%">信息类型</th>
							<th class="base_th" width="10%" >评估分数</th>
							<th class="base_th" width="10%">详细信息</th>
						</tr>
						<tr>
							<td>1</td>
							<td>6546545454</td>
							<td>xx</td>
							<td>2017-07-07</td>
							<td>脱逃排查</td>
							<td>9</td>
							<td><a href="#" onclick="loadnext16('/oasm/dafxView/ttpcrs')">点击进入</a>
							</td>
						</tr>
						<tr>
							<td>2</td>
							<td>6546545454</td>
							<td>xx</td>
							<td>2017-07-07</td>
							<td>脱逃排查</td>
							<td>9</td>
							<td><a href="#" onclick="loadnext16('/oasm/dafxView/ttpcrs')">点击进入</a>
							</td>
						</tr>
					</table>
					<div class="fenye">
						<ul class="fenye-ul">
							<li>共<a style="color: red;">2</a>个记录
							</li>
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
					<div class="addbutton" onclick="loadnext16('/oasm/dafxView/ttpclb')">
						<i>添加</i>
					</div>
				</div>
				<!--再犯罪排查 -->
				<div id="zfpc" class="option_table">
					<table class="content_table" width="100%">
						<tr>
							<th class="base_th" width="5%">序号</th>
							<th class="base_th" width="10%">囚号</th>
							<th class="base_th" width="10%">罪犯姓名</th>
							<th class="base_th" width="10%">创建时间</th>
							<th class="base_th" width="10%">信息类型</th>
							<th class="base_th" width="10%" >评估分数</th>
							<th class="base_th" width="10%">详细信息</th>
						</tr>
						<tr>
							<td>1</td>
							<td>6546545454</td>
							<td>xx</td>
							<td>2017-07-07</td>
							<td>再犯罪排查</td>
							<td>9</td>
							<td><a href="#" onclick="loadnext17('/oasm/dafxView/zfpcrs')">点击进入</a>
							</td>
						</tr>
						<tr>
							<td>2</td>
							<td>6546545454</td>
							<td>xx</td>
							<td>2017-07-07</td>
							<td>再犯罪排查</td>
							<td>9</td>
							<td><a href="#" onclick="loadnext17('/oasm/dafxView/zfpcrs')">点击进入</a>
							</td>
						</tr>
					</table>
					<div class="fenye">
						<ul class="fenye-ul">
							<li>共<a style="color: red;">2</a>个记录
							</li>
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
                <div class="addbutton"
						onclick="loadnext17('/oasm/dafxView/zfpclb')">
						<i>添加</i>
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