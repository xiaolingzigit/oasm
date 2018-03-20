<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>中期危险性评估报告</title>


</head>

<body>
<!-- 功能子块-->
	
	<div class="main_content">
			<div class="cs-jc-title">罪犯中期危险性评估报告</div>
			<div class="cs-item">				
				<ul class="cs-ul">
					<li class="cs-li"><span class="cs-item-1">囚号</span><span
						class="cs-item-2" id="zqpgqh"></span></li>
					<li class="cs-li"><span class="cs-item-1">姓名</span><span
						class="cs-item-2" id="zqpgxm"></span></li>
					<li class="cs-li"><span class="cs-item-1">罪名</span><span
						class="cs-item-2"></span></li>
					<li class="cs-li"><span class="cs-item-1">刑期</span><span
						class="cs-item-2"></span></li>				
					<li class="cs-li"><span class="cs-item-1">监区</span><span
						class="cs-item-2" id="zqpgjq"></span></li>
					<li class="cs-li"><span class="cs-item-1">评估日期</span><span
						class="cs-item-2" id="zqpgrq"></span></li>
					<li class="cs-li"><span class="cs-item-1">评估分数</span><span
						class="cs-item-2" id="zqpgfs"></span></li>
					<li class="cs-li"><span class="cs-item-1">危险等级</span><span
						class="cs-item-2" id="zqpgwxdj"></span></li>
					
				</ul>
			</div>
            <div class="cs-item cs-item-l">
				<div>
					<table class="cs-tb-w cs-tb-cl" style="text-align: center;line-height: 22px;width:100%;">
						<tr style="color: #ffffff">
							<td rowspan="4" width="10%" ><strong><a class="ztsize">危险</br>类型</br>分析</strong></td>
							<td width="40%">危险类型</td>
							<td width="20%">分数</td>
							<td width="20%">危险类型程度</td>
						</tr>
						<tr class="trcolor">
							<td>自杀</td>
							<td><font id="zqzsfs" class="dfcolor"></font></td>
							<td><font id="zqzslx" class="dfcolor"></font></td>
						</tr>
						<tr class="trcolor">
							<td>脱逃</td>
							<td><font id="zqttfs" class="dfcolor"></font></td>
							<td><font id="zqttlx" class="dfcolor"></font></td>
						</tr>
						<tr class="trcolor">
							<td>行凶</td>
							<td><font id="zqkgfs" class="dfcolor"></font></td>
							<td><font id="zqkglx" class="dfcolor"></font></td>
						</tr>
					</table>
					
				</div>
			</div>
			<div class="cs-item cs-item-l">
				<div>
					<table class="cs-tb-w cs-tb-cl" style="text-align: center;line-height: 22px;width:100%;">
						<tr style="color: #ffffff">
							<td rowspan="30" width="10%" ><strong><a class="ztsize">档</br>案</br>分</br>析</a></strong></td>
							<td width="60%">因子</td>
							<td width="20%">分数</td>
						</tr>
						<tr id="zqdaaddbefore">
							<td></td>
							<td></td>
						</tr>
					</table>
					<div style="margin-left: 75%;">
						<a><strong>档案分析总分：<font id="zqdafxzf" color="FF0000">&nbsp;&nbsp;&nbsp;&nbsp;</font></strong></a>
					</div>
				</div>
				</div>

				<div class="cs-item cs-item-l">
				<div>
					<table class="cs-tb-w cs-tb-cl" style="text-align: center;line-height: 22px;width:100%;">
						<tr>
							<td rowspan="30" width="10%"><strong><a class="ztsize">访</br>谈</br>调</br>查</a></strong></td>
							<td width="60%">因子</td>
							<td width="20%">分数</td>
						</tr>
						<tr id="zqftdcaddbefore">
							<td></td>
							<td></td>
						</tr>
					</table>
					<div style="margin-left: 75%;">
							<a><strong>访谈调查总分：<font  id="zqftdczf" color="FF0000">&nbsp;&nbsp;&nbsp;&nbsp;</font></strong></a>
					</div>
				</div>
				</div>

				<div class="cs-item cs-item-l">
				<div>
					<table class="cs-tb-w cs-tb-cl" style="text-align: center;line-height: 22px;width:100%;">
						<tr>
							<td rowspan="30" width="10%"><strong><a class="ztsize">行</br>为</br>观</br>察</a></strong></td>
							<td width="60%">因子</td>
							<td width="20%">分数</td>
						</tr>
						<tr id="zqxwgcaddbefore">
							<td></td>
							<td></td>
						</tr>

					</table>
					<div style="margin-left: 75%;">
							<a><strong>行为观察总分：<font id="zqxwgczf" color="FF0000">&nbsp;&nbsp;&nbsp;&nbsp;</font></strong></a>
						</div>
				</div>
				</div>

				<div class="cs-item cs-item-l">
				<div>
					<table class="cs-tb-w cs-tb-cl" style="text-align: center;line-height: 22px;width:100%;">
						<tr>
							<td rowspan="30" width="10%"><strong><a class="ztsize">心</br>理</br>测</br>试</a></strong></td>
							<td width="60%">因子</td>
							<td width="20%">分数</td>
						</tr>
						<tr id="zqxlceaddbefore">
							<td></td>
							<td></td>
						</tr>
					</table>
					<div style="margin-left: 75%;">
							<a><strong>心理测试总分：<font id="zqxlcezf" color="FF0000">&nbsp;&nbsp;&nbsp;&nbsp;</font></strong></a>
						</div>
				</div>
				</div>
				<div class="cs-item">
                <div class="cs-item-title">危险等级变化</div>
                <div class="cs-sub-line"></div>
                <div class="cs-sub-item">
                  <div id="line1" style="width: 98.5%; height: 300px;"></div>
                  </div>
				</div>
				<div class="cs-item cs-item-l">
                <div class="cs-item-title">人工操作记录</div>
               <div class="cs-sub-line"></div>
                <div>
				<table class="cs-tb-w cs-tb-cl" style="text-align:center;width: 98.5%;">
				<tr>
				<th>警号</th>
				<th>警察</th>
				<th>时间</th>
				<th>修改项</th>
				<th>修前值</th>
				<th>修后值</th>
				</tr>
				<tr class="trcolor">
				<td> 4165296</td>
				<td>王维 </td>
				<td>2016/08/01 </td>
				<td> 危险等级</td>
				<td>低度 </td>
                <td>中度</td>
				</tr>
				<tr class="trcolor">
				<td> 4165296</td>
				<td>王维 </td>
				<td>2016/09/01 </td>
				<td> 危险等级</td>
				<td>中度 </td>
                <td>高度</td>
				</tr>
				<tr class="trcolor">
				<td> 4165296</td>
				<td>王维 </td>
				<td>2017/03/01 </td>
				<td> 危险等级</td>
				<td>高度 </td>
                <td>中度</td>
				</tr>
				</table>
                </div>
       
            </div>

            	<div class="cs-item cs-item-l">
                <div class="cs-item-title">危险性评估分析</div>
                <div class="cs-sub-line"></div>
                <div>
				<div  style="width: 98.5%;">
                  罪犯日常情绪受外界环境的影响不明显，反应比较轻微，且较容易恢复平静。性情倾向于平稳和成熟些，面对生活中的各种困难和挫折，处理能力相对比较好。日常改造表现基本稳定、有较多积极行为，危险程度等级为中度危险。
				</div>
                </div>
       
            </div>
				<div class="cs-item cs-item-l">
                <div class="cs-item-title">处置对策</div>
                <div class="cs-sub-line"></div>
			<div class="lb_content_table2" style="height: 250px">
				<table>
					<tr class="czdc_tr01">
						<th colspan="2">罪犯危险性评估中心</th>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">分类关押</td>
						<td class="czdc_td02"></td>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">管控措施</td>
						<td class="czdc_td02"></td>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">教育改造方案</td>
						<td class="czdc_td02"></td>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">劳动改造方案</td>
						<td class="czdc_td02"></td>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">刑罚执行方案</td>
						<td class="czdc_td02"></td>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">是否适用假释、暂予监外执行</td>
						<td class="czdc_td02"></td>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">安置帮教建议</td>
						<td class="czdc_td02"></td>
					</tr>
				</table>
				<table>
					<tr class="czdc_tr01">
						<th colspan="2">教育改造部</th>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">分类关押</td>
						<td class="czdc_td02"></td>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">管控措施</td>
						<td class="czdc_td02"></td>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">教育改造方案</td>
						<td class="czdc_td02"></td>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">劳动改造方案</td>
						<td class="czdc_td02"></td>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">刑罚执行方案</td>
						<td class="czdc_td02"></td>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">是否适用假释、暂予监外执行</td>
						<td class="czdc_td02"></td>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">安置帮教建议</td>
						<td class="czdc_td02"></td>
					</tr>
				</table>
				<table>
					<tr class="czdc_tr01">
						<th colspan="2">心理矫治办公室主任</th>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">分类关押</td>
						<td class="czdc_td02"></td>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">管控措施</td>
						<td class="czdc_td02"></td>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">教育改造方案</td>
						<td class="czdc_td02"></td>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">劳动改造方案</td>
						<td class="czdc_td02"></td>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">刑罚执行方案</td>
						<td class="czdc_td02"></td>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">是否适用假释、暂予监外执行</td>
						<td class="czdc_td02"></td>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">安置帮教建议</td>
						<td class="czdc_td02"></td>
					</tr>
				</table>
				<table>
					<tr class="czdc_tr01">
						<th colspan="2">矫正与刑务办公室</th>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">分类关押</td>
						<td class="czdc_td02"></td>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">管控措施</td>
						<td class="czdc_td02"></td>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">教育改造方案</td>
						<td class="czdc_td02"></td>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">劳动改造方案</td>
						<td class="czdc_td02"></td>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">刑罚执行方案</td>
						<td class="czdc_td02"></td>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">是否适用假释、暂予监外执行</td>
						<td class="czdc_td02"></td>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">安置帮教建议</td>
						<td class="czdc_td02"></td>
					</tr>
				</table>
				<table>
					<tr class="czdc_tr01">
						<th colspan="2">指挥中心</th>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">分类关押</td>
						<td class="czdc_td02"></td>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">管控措施</td>
						<td class="czdc_td02"></td>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">教育改造方案</td>
						<td class="czdc_td02"></td>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">劳动改造方案</td>
						<td class="czdc_td02"></td>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">刑罚执行方案</td>
						<td class="czdc_td02"></td>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">是否适用假释、暂予监外执行</td>
						<td class="czdc_td02"></td>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">安置帮教建议</td>
						<td class="czdc_td02"></td>
					</tr>
				</table>
				<table>
					<tr class="czdc_tr01">
						<th colspan="2">狱政管理办公室</th>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">分类关押</td>
						<td class="czdc_td02"></td>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">管控措施</td>
						<td class="czdc_td02"></td>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">教育改造方案</td>
						<td class="czdc_td02"></td>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">劳动改造方案</td>
						<td class="czdc_td02"></td>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">刑罚执行方案</td>
						<td class="czdc_td02"></td>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">是否适用假释、暂予监外执行</td>
						<td class="czdc_td02"></td>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">安置帮教建议</td>
						<td class="czdc_td02"></td>
					</tr>
				</table>
				<table>
					<tr class="czdc_tr01">
						<th colspan="2">劳动改造与安全生产办公室</th>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">分类关押</td>
						<td class="czdc_td02"></td>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">管控措施</td>
						<td class="czdc_td02"></td>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">教育改造方案</td>
						<td class="czdc_td02"></td>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">劳动改造方案</td>
						<td class="czdc_td02"></td>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">刑罚执行方案</td>
						<td class="czdc_td02"></td>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">是否适用假释、暂予监外执行</td>
						<td class="czdc_td02"></td>
					</tr>
					<tr class="czdc_tr02">
						<td class="czdc_td01">安置帮教建议</td>
						<td class="czdc_td02"></td>
					</tr>
				</table>

			</div>
</div>
		<div class="cs-item cs-item-l">
			<div class="cs-item-title">合议意见</div>
			<div class="cs-sub-line"></div>
			<div>
				<div style="width: 98.5%;">
					<span>王冰冰</span><span>2017-09-28</span>
					<p>同意。罪犯日常改造表现基本稳定、有较多积极行为，同意其危险程度等级为中度危险。</p>
				</div>
				<span>王威伟</span><span>2017-09-29</span>
				<p>同意。罪犯日常改造表现基本稳定、有较多积极行为，同意其危险程度等级为中度危险。</p>
			</div>
		</div>
	<div class="cs-item cs-item-l">
				<div class="cs-item-title">审批意见</div>
				<div class="cs-sub-line"></div>
				<div>
					<div style="width: 98.5%;">
						<span>肖育龄</span><span>2017-09-28</span>
						<p>同意。确认该罪犯危险程度等级为中度危险。</p></div>
				</div>
			</div>
			<div class="cs-item cs-item-l">
				<div class="cs-item-title">复议意见</div>
				<div class="cs-sub-line"></div>
				<div>
					<div style="width: 98.5%;">
						<p>无</p></div>
				</div>
			</div>
		<div style="text-align: center; padding-bottom: 10px">
			<button style="font-size: 20px;">下载</button>
			<button style="font-size: 20px;">打印</button>
		</div>
	</div>
<script >
$(function(){
    $('.czdc_tr02').hide();   
});

$('.czdc_tr01').click(function (event) {
	$(this).parent().find('.czdc_tr02').toggle(500);    

});
</script>	                            
							<script type="text/javascript">
								// 基于准备好的dom，初始化echarts实例
								var myChart = echarts.init(document.getElementById('line1'));
								var option2 = {
									title: {
									        text: '危险等级变化图',
									        subtext: '【0~40 低度危险】，【41~80 中度危险】，【81~107 高度危险】，【108以上极高危险】',
									        x: 'center'
									    },
									    tooltip: {
									        trigger: 'axis'
									    },
									    legend: {
									        data:['危险程度']
									    },
									    grid: {
									        left: '3%',
									        right: '4%',
									        bottom: '3%',
									        containLabel: true
									    },
									    toolbox: {
									        feature: {
									            saveAsImage: {}
									        }
									    },
									    xAxis: {
									        type: 'category',
									        boundaryGap: false,
									        data: ['2016.08.01','2016.09.01','2016.12.01','2017.03.01','2017.04.01','2017.05.01','2017.06.01']
									    },
									    yAxis: {
									        name : '危险值(分)',
									        type: 'value'
									    },
									    series: [
									        {
									            name:'危险指数',
									            type:'line',
									            stack: '总量',
									            data:[10, 30, 96, 84, 120, 101, 80]
									        }
									    ]
									};
								myChart.setOption(option2);
                                window.addEventListener("resize",function(){
                                    myChart.resize();
                                             });
								</script>
</body>

</html>