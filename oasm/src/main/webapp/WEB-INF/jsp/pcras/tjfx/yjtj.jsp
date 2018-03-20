<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>预警统计</title>
</head>
<body>
		<!-- 定位栏-->
		<div class="location">
			<div class="location_left">
				<i><font color="#ffffff"><strong>您现在的位置</strong></font></i>
			</div>
			<div class="location_right">
				<strong>&nbsp;&nbsp;统计分析 >><font color="#ff3300">预警统计</font></strong>
			</div>
		</div>
				<!-- 功能子块-->
				<div class="base_table">
					
					<h3>
						<font color="#66ccff">预警类型比例图</font>
					</h3>
					<div id="yjqk_pie" style="margin:0 auto;width:100%;height:430px;"></div>
					<br>
	<!-- 			<table width="100%" cellspacing="0" cellpadding="0" style="display:none;">
							<tr >
								<th width="15%">个人信息（囚号）</th>
                                <th width="10%">罪犯姓名</th>
								<th width="10%">所属监区</th>
								<th width="25%">预警原因</th>
								<th width="20%">预警类型</th>
								<th width="20%">预警时间</th>
							</tr>
							<tr>
								<td>0118260201</td>
								<td>周一</td>
								<td>第一监区</td>
								<td>涉枪</td>
								<td style="color: red;">稳定特质阳性</td>
								<td>2017-06-02 15:10:10</td>
							</tr>
							<tr>
								<td>9118260201</td>
								<td>王二</td>
								<td>第一监区</td>
								<td>自杀</td>
								<td style="color: red;">可变特质阳性</td>
								<td>2017-06-02 15:10:10</td>
							</tr>
							<tr >
								<td>6118260201</td>
								<td>李三</td>
								<td>第二监区</td>
								<td>打架</td>
								<td style="color: red;">可变特质阳性</td>
								<td>2017-06-02 15:10:10</td>
							</tr>
							<tr>
								<td>2118260201</td>
								<td>康四</td>
								<td>第二监区</td>
								<td>会见异常</td>
								<td style="color: red;">日常改造阳性</td>
								<td>2017-06-02 15:10:10</td>
							</tr>
							<tr>
								<td>1118260201</td>
								<td>刘五</td>
								<td>第二监区</td>
								<td>袭警</td>
								<td style="color: red;">日常改造异常</td>
								<td>2017-06-02 15:10:10</td>
							</tr>
							<tr >
								<td>1318260201</td>
								<td>张六</td>
								<td>第二监区</td>
								<td>自身突发重症疾病</td>
								<td style="color: red;">日常狱情阳性</td>
								<td>2017-06-02 15:10:10</td>
							</tr>
							<tr>
								<td>3418260201</td>
								<td>黄七</td>
								<td>第三监区</td>
								<td>人际关系恶劣</td>
								<td style="color: red;">日常狱情异常</td>
								<td>2017-06-02 15:10:10</td>
							</tr>
							<tr>
								<td>5418260201</td>
								<td>吴八</td>
								<td>第三监区</td>
								<td>再犯罪评估分数过高</td>
								<td style="color: red;">极高危险</td>
								<td>2017-06-02 15:10:10</td>
							</tr>
							<tr>
								<td>5418260201</td>
								<td>肖九</td>
								<td>第三监区</td>
								<td>专项评估分数过高</td>
								<td style="color: red;">极高危险</td>
								<td>2017-06-02 15:10:10</td>
							</tr>
							<tr>
								<td>9418260201</td>
								<td>方十</td>
								<td>第三监区</td>
								<td>综合评估分数过高</td>
								<td style="color: red;">极高危险</td>
								<td>2017-06-02 15:10:10</td>
							</tr>
						</table>
					<div class="fenye" style="display:none;">
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
					</div> -->	
				</div>
<script type="text/javascript">
var charts1 = echarts.init(document.getElementById('yjqk_pie'));
var option1 ={
    tooltip : {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
   legend: {
        orient: 'horizontal',
  	    x: 'center',
  	    y: 'bottom',
        data: ['极高危险预警','高度危险预警','基础信息异常预警']
    },
    series : [
        {
            name: '预警情况',
            type: 'pie',
            radius : '60%',
            center: ['50%', '50%'],
			 label: {
				normal: {
					textStyle: {
						fontSize : 18
					}
				 }
       		},
            data:[
                 {value:22, name:'极高危险预警',
				itemStyle:{
					normal:{color:'#ff0000'}
				}
			},
				{value:100, name:'高度危险预警',
				itemStyle:{
					normal:{color:'#fc7e18'}
				}
			},
				{value:300, name:'基础信息异常预警',
				itemStyle:{
					normal:{color:'#4169E1'}
				}
			}
              ],
            itemStyle: {

                emphasis: {
                    shadowBlur: 10,
                    shadowOffsetX: 0,
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
            }
        }
    ]
};

charts1.setOption(option1);
</script>
</body>
</html>