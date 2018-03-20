<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link  href="<c:url value='/resource/css/loader.css'/>"/>
<title>危评情况变化</title>
</head>

<body>
	<!-- 危评情况变化  -->
	<div id="" class="sub-block">
		<!-- 定位栏-->
		<div class="location">
			<div class="location_left">
				<i><font color="#ffffff"><strong>您现在的位置</strong></font></i>
			</div>
			<div class="location_right">
				<strong>&nbsp;&nbsp;统计分析 >><font color="#ff3300">危评情况变化</font></strong>
			</div>
		</div>
		<div class="main_content">
			<div class="layer02">
				<div class="search_title">筛选条件：</div>
				<div class="search_area">
					<div style="float: left;" class="search_sub1">
						开始时间（时间1）：<input type="text"  maxLength="10"
							style="font-size: 16px; font-family:" name="sj1"
							微软雅黑";" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" id="date1"/>
					</div>
					<div style="float: left;" class="search_sub1">
						结束时间（时间2）：<input type="text"  maxLength="10"
							style="font-size: 16px; font-family:" name="sj2"
							微软雅黑";" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" id="date2"/>
					</div>
					<div style="float: left;" class="search_sub1">
						<button class="button_submit2">搜索</button>
					</div>
				</div>
			</div>
			<div class="tj_content_table">
        <table >
           <tr >
                <td colspan=18><h1>危 评 情 况 变 化 表</h1></td>
              </tr> 
          <tr>
            <th rowspan="2" style="width: 10%">监 区</th>
            <th colspan="5" style="width: 25%">极 高 危 险</th>
            <th colspan="5" style="width: 25%">高 度 危 险</th>
            <th colspan="3" style="width: 15%">中 度 危 险</th>
            <th colspan="3" style="width: 15%">低 度 危 险</th>
            <th rowspan="2" style="width: 10%">监区总数（中期）</th>

          </tr>
          <tr>
            <th>时间1总数</th>
            <th>新增</th>
            <th>时间2总数</th>
            <th>顽危犯人数</th>
            <th>重点犯人数</th>
            <th>时间1总数</th>
            <th>新增</th>
            <th>时间2总数</th>
            <th>顽危犯人数</th>
            <th>重点犯人数</th>
            <th>时间1总数</th>
            <th>新增</th>
            <th>时间2总数</th>
            <th>时间1总数</th>
            <th>新增</th>
            <th>时间2总数</th>

          </tr><!-- ajax危评情况变化数据 -->
          <tbody id="wxqklist">
          </tbody>
          <!-- 精神病start -->
          <!-- 
          <tr>
            <th style="background-color: yellow">精神病</th>
            <td></td>
            <td></td>
            <td>0</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td>0</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td>0</td>
            <td></td>
            <td></td>
            <td>0</td>
            <td></td>
          </tr>
          <tr>
            <th style="background-color: yellow">除精神病总数</th>
            <td>5</td>
            <td>0</td>
            <td>5</td>
            <td>0</td>
            <td>0</td>
            <td>22</td>
            <td>0</td>
            <td>22</td>
            <td>0</td>
            <td>0</td>
            <td>318</td>
            <td>0</td>
            <td>318</td>
            <td>559</td>
            <td>0</td>
            <td>559</td>
            <td>904</td>
          </tr>
          <tr>
            <th style="background-color: yellow">占监狱总数比例</th>
            <td></td>
            <td></td>
            <td>0%</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td>0%</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td>0%</td>
            <td></td>
            <td></td>
            <td>0%</td>
            <td></td>
          </tr>
           -->
          <!-- 精神病end -->
          
          <!--  
          <tr>
            <td></td>
            <td colspan="3">极高危险</td>
            <td colspan="3">高度危险</td>
            <td colspan="3">中度危险</td>
            <td colspan="3">低度危险</td>
            <td colspan="3">精神病犯总数</td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td></td>
            <td colspan="3">5</td>
            <td colspan="3">22</td>
            <td colspan="3">318</td>
            <td colspan="3">559</td>
            <td colspan="3">0</td>
            <td></td>
            <td></td>
          </tr>
          -->
          
        </table>
			</div>
		</div>
	</div>
	
	<script type="text/javascript" src="<c:url value="/resource/js/tjfx/wpqkbh.js"/>"></script>
	
</body>
</html>