<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>详细版评估报告</title>
</head>
<body>
    <div>
        <div class="base_right_top">
            <div class="location_left"> <i>您现在的位置：</i>
            </div>
            <ul class="base_ul03">
                <li>入监评估</li>
                <li>>></li>
                <li>评估报告查询</li>
                <li>>></li>
                <li style="color:red;">入监评估报告</li>
            </ul>
        </div>
        <div class="base_right_bom">
            <div class="cs-jc-title">入监评估报告</div>
            <div class="cs-item">
                <div class="cs-item-title">犯罪基础信息</div>
                <ul class="cs-ul">
                    <li class="cs-li">
                        <span class="cs-item-1">姓名</span><span class="cs-item-2">张三</span>
                    </li>
                    <li class="cs-li">
                        <span class="cs-item-1">囚号</span><span class="cs-item-2">12922349087</span>
                    </li>
                    <li class="cs-li">
                        <span class="cs-item-1">刑期</span><span class="cs-item-2">1年2月</span>
                    </li>
                    <li class="cs-li">
                        <span class="cs-item-1">罪名</span><span class="cs-item-2">破坏交通设施罪</span>
                    </li>
                    <li class="cs-li">
                        <span class="cs-item-1">评估时间</span><span class="cs-item-2">2016-08至2017-06</span>
                    </li>                   
					<li class="cs-li"><span class="cs-item-1">评估总分</span><span
						class="cs-item-2" style="color:red;font-size:150%;">156</span></li>
                    <li class="cs-li">
                        <span class="cs-item-1">个性特点</span><span class="cs-item-2">外向开朗</span>
                    </li>
                    <li class="cs-li">
                        <span class="cs-item-1">行为特征</span><span class="cs-item-2">适应性较差</span>
                    </li>
                </ul>
            </div>
            			<div class="cs-item cs-item-l">
				<div class="cs-item-title">评分
				<div style="float:right;">评估总分：<span style="color:red;font-size:250%;">156</span></div>
				</div>
				<div class="cs-sub-line"></div>
				<div>
					<table class="cs-tb-w cs-tb-cl" style="text-align: center;width:100%">
						<tr>
							<th>档案分析得分</th>
							<th>结构性访谈得分</th>
							<th>行为观察得分</th>
							<th>新收押罪犯量表得分</th>
							<th>COPA-PI量表得分</th>
							<th>SCL90量表得分</th>
							<th>综合筛选得分</th>
							<th>专项排查得分</th>
							<th>总分</th>
							<th>标准分</th>
						</tr>
						<tr style="background: #d7dcdf; color: #000000">
							<td>15</td>
							<td>34</td>
							<td>67</td>
							<td>10</td>
							<td>30</td>
							<td>67</td>
							<td>10</td>
							<td>30</td>
							<td>156</td>
							<td>67</td>
						</tr>
					</table>
				</div>
			</div>
            <div class="cs-item">
                <div class="cs-item-title">犯罪危险等级及类型</div>
                <ul class="cs-ul">
                    <li class="cs-s-li">
                        <div class="cs-li"><span class="cs-item-1">危险等级</span><span class="cs-item-2">极高危险</span></div>
                        <div class="cs-li"><span class="cs-item-1">危险类型</span><span class="cs-item-2">自杀</span></div>
                    </li>
                    <li class="cs-s-li">
                        <!-- <div class="chart-box">
                            <img src="images/imgs/1.png" style="width:100%;" />
                        </div> -->
                    </li>
                </ul>
            </div>
             
          <div class="cs-item">
                <div class="cs-item-title">危险等级变化</div>
                <div class="cs-sub-line"></div>
                <div class="cs-sub-item">
  
                    <div>
                        <ul class="cs-ul">
                            <li class="cs-s-li"> 

	                            <div id="line1" style="width: 900px; height: 300px;"></div>
	                            
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
                            </li>
							
                        </ul>
                    </div>
                  </div>
				</div>

            <div class="cs-item">
                <div class="cs-item-title">综合评估报告</div>
                <div class="cs-sub-line"></div>
                <div class="cs-sub-item">
               
                    <div>
                        <ul class="cs-ul">
                            <li class="cs-li"><span class="cs-item-1">绝对分数</span><span class="cs-item-2">30</span>
                            </li>
							<li class="cs-li"><span class="cs-item-1">评估分数</span><span class="cs-item-2">1.25</span>
                            </li>
                            <li class="cs-li"><span class="cs-item-1">危险等级</span><span class="cs-item-2">高度危险</span>
                            </li>
                            <li class="cs-li"><span class="cs-item-1">危险倾向</span><span class="cs-item-2">自杀与脱逃</span>
							</li>
							<li class="cs-li"><span class="cs-item-1">数据解释</span><span>整体数据具有较高的自杀及脱逃危险性……</span>
                            </li>
                        </ul>
                  </div>  
                  </div>
				</div>

               <div class="cs-item">
                <div class="cs-item-title">专项评估报告</div>
                <div class="cs-sub-line"></div>
                <div class="cs-sub-item">
                    
                    <div>
                        <ul class="cs-ul">
                            <li class="cs-li"><span class="cs-item-1">自杀倾向绝对分数</span><span class="cs-item-2">25</span>
                            </li>
							<li class="cs-li"><span class="cs-item-1">评估分数</span><span class="cs-item-2">1.25</span>
                            </li>
                            <li class="cs-li"><span class="cs-item-1">危险等级</span><span class="cs-item-2">高度危险</span>
                            </li>
					    </ul>

                        <ul class="cs-ul">
                            <li class="cs-li"><span class="cs-item-1">脱逃倾向绝对分数</span><span class="cs-item-2">27</span>
                            </li>
							<li class="cs-li"><span class="cs-item-1">评估分数</span><span class="cs-item-2">1.30</span>
                            </li>
                            <li class="cs-li"><span class="cs-item-1">危险等级</span><span class="cs-item-2">高度危险</span>
                            </li>
                        </ul>

						<ul class="cs-ul">
							 <li class="cs-li"><span class="cs-item-1">行凶倾向绝对分数</span><span class="cs-item-2">28</span>
                            </li>
							<li class="cs-li"><span class="cs-item-1">评估分数</span><span class="cs-item-2">1.25</span>
                            </li>
                            <li class="cs-li"><span class="cs-item-1">危险等级</span><span class="cs-item-2">高度危险</span>
                            </li>
                        </ul>

						<ul class="cs-ul">
							 <li class="cs-li"><span class="cs-item-1">危险类别判断</span><span class="cs-item-2">自杀</span>
                            </li>
							<li class="cs-li"><span class="cs-item-1">数据解释</span><span>整体数据自杀性危险性较高</span>
                            </li>
                        </ul>
                    </div>
                  </div>
				 </div> 


           



            <div class="cs-item">
                <div class="cs-item-title">危险成因及罪犯异常信息</div>
                <div class="cs-sub-line"></div>
                <div class="cs-sub-item">
                    <div class="cs-sub-item-title">稳定特质危险因素</div>
                    <div>
                        <ul class="cs-ul">
                            <li class="cs-li"><span class="cs-item-1">预警原因</span><span class="cs-item-2">打架</span>
                            </li>
                            <li class="cs-li"><span class="cs-item-1">预警类型</span><span class="cs-item-2">/</span>
                            </li>
                            <li class="cs-li"><span class="cs-item-1">预警时间</span><span class="cs-item-2">2017-07-08</span>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="cs-sub-item">
                    <div class="cs-sub-item-title">稳定特质详细信息</div>
                    <div>
                        <ul class="cs-ul">
                            <li class="cs-li"><span class="cs-item-1">出生年月</span><span class="cs-item-2">/</span></li>
                            <li class="cs-li"><span class="cs-item-1">年龄</span><span class="cs-item-2">/</span></li>
                            <li class="cs-li"><span class="cs-item-1">性别</span><span class="cs-item-2">/</span></li>
                            <li class="cs-li"><span class="cs-item-1">国籍</span><span class="cs-item-2">/</span></li>
                            <li class="cs-li"><span class="cs-item-1">籍贯</span><span class="cs-item-2">/</span></li>
                            <li class="cs-li"><span class="cs-item-1">民族</span><span class="cs-item-2">/</span></li>
                            <li class="cs-li"><span class="cs-item-1">职务</span><span class="cs-item-2">/</span></li>
                            <li class="cs-li"><span class="cs-item-1">学历</span><span class="cs-item-2">/</span></li>
                            <li class="cs-li"><span class="cs-item-1">特殊才能</span><span class="cs-item-2">/</span></li>
                            <li class="cs-li"><span class="cs-item-1">身体健康状况</span><span class="cs-item-2">/</span></li>
                        </ul>
                    </div>
                    <div class="cs-li">
                        <ul class="cs-sh-ul-container">
                            <li class="cs-sh-li-o cs-sh-li-o-1">
                                <span class="cs-item-1">主要社会关系</span>
                            </li>
                            <li class="cs-sh-li-o cs-sh-li-o-2">
                                <div class="cs-sh-ul-box">
                                    <ul class="cs-sh-ul">
                                        <li>关系</li>
                                        <li>姓名</li>
                                        <li>出生年月</li>
                                        <li>政治面貌</li>
                                        <li>单位、职务或职业</li>
                                    </ul>
                                </div>
                                <div class="cs-sh-d"></div>
                                <div class="cs-sh-d"></div>
                                <div class="cs-sh-d"></div>
                            </li>
                        </ul>
                    </div>
                    <div class="cs-li">
                        <ul class="cs-ul">
                            <li class="cs-li cs-li-1">
                                <span class="cs-item-1">成长经历</span>
                                <span class="cs-item-2">/</span>
                            </li>
                        </ul>
                    </div>
                    <div>
                        <ul class="cs-ul">
                            <li class="cs-li"><span class="cs-item-1">罪名</span><span class="cs-item-2">/</span></li>
                            <li class="cs-li"><span class="cs-item-1">犯罪类型</span><span class="cs-item-2">/</span></li>
                            <li class="cs-li"><span class="cs-item-1">案情</span><span class="cs-item-2">/</span></li>
                            <li class="cs-li"><span class="cs-item-1">原判刑期</span><span class="cs-item-2">/</span></li>
                            <li class="cs-li"><span class="cs-item-1">未成年违法情况</span><span class="cs-item-2">/</span></li>
                            <li class="cs-li"><span class="cs-item-1">经济状况</span><span class="cs-item-2">/</span></li>
                            <li class="cs-li"><span class="cs-item-1">居住条件</span><span class="cs-item-2">/</span></li>
                            <li class="cs-li"><span class="cs-item-1">居住环境</span><span class="cs-item-2">/</span></li>
                            <li class="cs-li"><span class="cs-item-1">交往的对象</span><span class="cs-item-2">/</span></li>
                            <li class="cs-li"><span class="cs-item-1">交往的方式</span><span class="cs-item-2">/</span></li>
                            <li class="cs-li"><span class="cs-item-1">有无与违法犯罪人员交往</span><span class="cs-item-2">/</span></li>
                        </ul>
                    </div>
                    <div class="cs-sub-line"></div>
                    <div class="cs-sub-item-title">可变特质危险因素</div>
                    <div>
                        <ul class="cs-ul">
                            <li class="cs-li"><span class="cs-item-1">预警原因</span><span class="cs-item-2">打架</span></li>
                            <li class="cs-li"><span class="cs-item-1">预警类型</span><span class="cs-item-2">/</span></li>
                            <li class="cs-li"><span class="cs-item-1">预警时间</span><span class="cs-item-2">2017-07-08</span></li>
                        </ul>
                    </div>
                    <div class="cs-sub-item-title">可变特质详细信息</div>
                    <div>
                        <ul class="cs-ul">
                            <li class="cs-li"><span class="cs-item-1">亲情关系</span><span class="cs-item-2">/</span></li>
                            <li class="cs-li"><span class="cs-item-1">家庭结构</span><span class="cs-item-2">/</span></li>
                            <li class="cs-li"><span class="cs-item-1">家庭变故</span><span class="cs-item-2">/</span></li>
                            <li class="cs-li"><span class="cs-item-1">反社会的价值观</span><span class="cs-item-2">/</span></li>
                            <li class="cs-li"><span class="cs-item-1">对犯罪的看法</span><span class="cs-item-2">/</span></li>
                            <li class="cs-li"><span class="cs-item-1">情绪稳定性</span><span class="cs-item-2">/</span></li>
                            <li class="cs-li"><span class="cs-item-1">认知状况</span><span class="cs-item-2">/</span></li>
                            <li class="cs-li"><span class="cs-item-1">性格缺陷</span><span class="cs-item-2">/</span></li>
                            <li class="cs-li"><span class="cs-item-1">成瘾类型</span><span class="cs-item-2">/</span></li>
                            <li class="cs-li"><span class="cs-item-1">成瘾程度</span><span class="cs-item-2">/</span></li>
                            <li class="cs-li"><span class="cs-item-1">身体健康状况</span><span class="cs-item-2">/</span></li>
                            <li class="cs-li"><span class="cs-item-1">疾病分级鉴别</span><span class="cs-item-2">/</span></li>

                        </ul>
                    </div>
                    <div class="cs-li">
                        <ul class="cs-sh-ul-container">
                            <li class="cs-sh-li-o cs-sh-li-o-1 cs-g-li">
                                <span class="cs-item-1">诊断以及跟踪管理情况</span>
                            </li>
                            <li class="cs-sh-li-o cs-sh-li-o-2 cs-div-b">
                                <div class="cs-div-l">
                                    <span>最新诊断情况</span>
                                    <a class="cs-load-text">下载选中</a>
                                </div>
                                <div>
                                    <input type="checkbox" checked="checked" />
                                    <span>2017-07-08</span>
                                    <a>点击查看</a>
                                </div>
                                <div class="cs-div-l">
                                    <span>历史诊断及跟踪情况查询及下载</span>
                                    <a class="cs-load-text">下载选中</a>
                                </div>
                                <div>
                                    <input type="checkbox" checked="checked" />
                                    <span>2017-07-08</span>
                                    <a>点击查看</a>
                                </div>
                                <div>
                                    <input type="checkbox" checked="checked" />
                                    <span>2017-07-08</span>
                                    <a>点击查看</a>
                                </div>
                            </li>
                        </ul>
                    </div>
                    <div class="cs-li">
                        <ul class="cs-sh-ul-container">
                            <li class="cs-sh-li-o cs-sh-li-o-1 cs-g-li">
                                <span class="cs-item-1">就诊记录</span>
                                <div class="cs-lk-b"><a class="cs-lk">按日查看</a></div>
                                <div class="cs-lk-b"><a class="cs-lk">选择某日/某段时间下载</a></div>
                            </li>
                            <li class="cs-sh-li-o cs-sh-li-o-2 cs-div-b">
                                <div class="cs-div-l">
                                    <span>就诊记录</span>
                                    <a class="cs-load-text">下载选中</a>
                                </div>
                                <div>
                                    <input type="checkbox" checked="checked" />
                                    <span>2017-07-08</span>
                                    <a>点击查看</a>
                                </div>

                                <div>
                                    <input type="checkbox" checked="checked" />
                                    <span>2017-07-08</span>
                                    <a>点击查看</a>
                                </div>
                                <div>
                                    <input type="checkbox" checked="checked" />
                                    <span>2017-07-08</span>
                                    <a>点击查看</a>
                                </div>
                                <div>
                                    <input type="checkbox" />
                                    <span>2017-07-08</span>
                                    <a>点击查看</a>
                                </div>
                            </li>
                        </ul>
                    </div>
                    <div class="cs-sub-line"></div>
                    <div class="cs-sub-item-title">日常改造危险因素</div>
                    <div>
                        <ul class="cs-ul">
                            <li class="cs-li"><span class="cs-item-1">预警原因</span><span class="cs-item-2">打架</span></li>
                            <li class="cs-li"><span class="cs-item-1">预警类型</span><span class="cs-item-2">/</span></li>
                            <li class="cs-li"><span class="cs-item-1">预警时间</span><span class="cs-item-2">2017-07-08</span></li>
                        </ul>
                    </div>
                    <div class="cs-sub-item-title">日常改造危异常行为</div>
                    <div>
                        <div class="cs-sub-item-title-2">异常/阳性预警信息</div>
                        <ul class="cs-ul">
                            <li class="cs-li"><span class="cs-item-1">预警原因</span><span class="cs-item-2">打架</span></li>
                            <li class="cs-li"><span class="cs-item-1">预警类型</span><span class="cs-item-2">/</span></li>
                            <li class="cs-li"><span class="cs-item-1">预警时间</span><span class="cs-item-2">2017-07-08</span></li>
                        </ul>
                    </div>

                    <div class="cs-sub-item-title-2">
                        <span>日常改造记录表</span>
                        <span class="cs-sp-b">
                            <a>记录按日查询</a>
                            <a>选择某日/某段时间</a>
                            <a>选择下载</a>
                        </span>
                    </div>
                    <div>
                        <div class="cs-tb-w cs-tb-cl">
                            <ul class="cs-tb-ul">
                                <li class="cs-tb-tr cs-tb-tr-1"></li>
                                <li class="cs-tb-tr"><span>日期</span></li>
                                <li class="cs-tb-tr"><span>是否异常</span></li>
                                <li class="cs-tb-tr"><span>异常内容</span></li>
                                <li class="cs-tb-tr"><span>操作</span></li>
                            </ul>
                        </div>
                        <div class="cs-tb-w cs-tb-lt">
                            <ul class="cs-tb-ul">
                                <li class="cs-tb-tr cs-tb-tr-1">
                                    <input type="checkbox" />
                                </li>
                                <li class="cs-tb-tr">
                                    <span>2017-05-11</span>
                                </li>
                                <li class="cs-tb-tr"><span></span></li>
                                <li class="cs-tb-tr"><span></span></li>
                                <li class="cs-tb-tr cs-mg">
                                    <a class="js-lk">查看详细</a>
                                    <a>下载</a>
                                </li>
                            </ul>
                            <div class="cs-dt">
                                <div>
                                    <ul class="cs-ul cs-ul-1">
                                        <li class="cs-li"><span class="cs-item-1">日期</span><span class="cs-item-2">2017-01-01</span></li>
                                        <li class="cs-li"><span class="cs-item-1">警号</span><span class="cs-item-2">/</span></li>
                                        <li class="cs-li"><span class="cs-item-1">警察姓名</span><span class="cs-item-2">/</span></li>
                                    </ul>
                                </div>
                                <div class="cs-d-ul ds-dc-d">
                                    <ul class="cs-ul-cl">
                                        <li class="cs-ci">名称</li>
                                        <li class="cs-ci">是否异常</li>
                                        <li class="cs-ci">备注</li>
                                    </ul>
                                </div>

                                <div class="cs-d-ul cs-d-b">
                                    <ul class="cs-ul-cl">
                                        <li class="cs-ci"><span>学习</span></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                    </ul>
                                </div>
                                <div class="cs-d-ul cs-d-b">
                                    <ul class="cs-ul-cl">
                                        <li class="cs-ci"><span>劳动</span></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                    </ul>
                                </div>
                                <div class="cs-d-ul cs-d-b">
                                    <ul class="cs-ul-cl">
                                        <li class="cs-ci"><span>认罪悔罪</span></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                    </ul>
                                </div>
                                <div class="cs-d-ul cs-d-b">
                                    <ul class="cs-ul-cl">
                                        <li class="cs-ci"><span>遵规守纪</span></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                    </ul>
                                </div>
                                <div class="cs-d-ul cs-d-b">
                                    <ul class="cs-ul-cl">
                                        <li class="cs-ci"><span>会见通信</span></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                    </ul>
                                </div>
                                <div class="cs-d-ul cs-d-b">
                                    <ul class="cs-ul-cl">
                                        <li class="cs-ci"><span>人机关系</span></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                    </ul>
                                </div>

                            </div>
                        </div>
                        <div class="cs-tb-w cs-tb-lt">
                            <ul class="cs-tb-ul">
                                <li class="cs-tb-tr cs-tb-tr-1">
                                    <input type="checkbox" />
                                </li>
                                <li class="cs-tb-tr">
                                    <span>2017-04-28</span>
                                </li>
                                <li class="cs-tb-tr"><span></span></li>
                                <li class="cs-tb-tr"><span></span></li>
                                <li class="cs-tb-tr cs-mg">
                                    <a class="js-lk">查看详细</a>
                                    <a>下载</a>
                                </li>
                            </ul>
                            <div class="cs-dt">
                                <div>
                                    <ul class="cs-ul cs-ul-1">
                                        <li class="cs-li"><span class="cs-item-1">日期</span><span class="cs-item-2">2017-01-01</span></li>
                                        <li class="cs-li"><span class="cs-item-1">警号</span><span class="cs-item-2">/</span></li>
                                        <li class="cs-li"><span class="cs-item-1">警察姓名</span><span class="cs-item-2">/</span></li>
                                    </ul>
                                </div>
                                <div class="cs-d-ul ds-dc-d">
                                    <ul class="cs-ul-cl">
                                        <li class="cs-ci">名称</li>
                                        <li class="cs-ci">是否异常</li>
                                        <li class="cs-ci">备注</li>
                                    </ul>
                                </div>

                                <div class="cs-d-ul cs-d-b">
                                    <ul class="cs-ul-cl">
                                        <li class="cs-ci"><span>学习</span></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                    </ul>
                                </div>
                                <div class="cs-d-ul cs-d-b">
                                    <ul class="cs-ul-cl">
                                        <li class="cs-ci"><span>劳动</span></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                    </ul>
                                </div>
                                <div class="cs-d-ul cs-d-b">
                                    <ul class="cs-ul-cl">
                                        <li class="cs-ci"><span>认罪悔罪</span></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                    </ul>
                                </div>
                                <div class="cs-d-ul cs-d-b">
                                    <ul class="cs-ul-cl">
                                        <li class="cs-ci"><span>遵规守纪</span></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                    </ul>
                                </div>
                                <div class="cs-d-ul cs-d-b">
                                    <ul class="cs-ul-cl">
                                        <li class="cs-ci"><span>会见通信</span></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                    </ul>
                                </div>
                                <div class="cs-d-ul cs-d-b">
                                    <ul class="cs-ul-cl">
                                        <li class="cs-ci"><span>人机关系</span></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                    </ul>
                                </div>

                            </div>
                        </div>
                        <div class="cs-tb-w cs-tb-lt">
                            <ul class="cs-tb-ul">
                                <li class="cs-tb-tr cs-tb-tr-1">
                                    <input type="checkbox" />
                                </li>
                                <li class="cs-tb-tr">
                                    <span>2017-07-08</span>
                                </li>
                                <li class="cs-tb-tr"><span></span></li>
                                <li class="cs-tb-tr"><span></span></li>
                                <li class="cs-tb-tr cs-mg">
                                    <a class="js-lk">查看详细</a>
                                    <a>下载</a>
                                </li>
                            </ul>
                            <div class="cs-dt">
                                <div>
                                    <ul class="cs-ul cs-ul-1">
                                        <li class="cs-li"><span class="cs-item-1">日期</span><span class="cs-item-2">2017-01-01</span></li>
                                        <li class="cs-li"><span class="cs-item-1">警号</span><span class="cs-item-2">/</span></li>
                                        <li class="cs-li"><span class="cs-item-1">警察姓名</span><span class="cs-item-2">/</span></li>
                                    </ul>
                                </div>
                                <div class="cs-d-ul ds-dc-d">
                                    <ul class="cs-ul-cl">
                                        <li class="cs-ci">名称</li>
                                        <li class="cs-ci">是否异常</li>
                                        <li class="cs-ci">备注</li>
                                    </ul>
                                </div>

                                <div class="cs-d-ul cs-d-b">
                                    <ul class="cs-ul-cl">
                                        <li class="cs-ci"><span>学习</span></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                    </ul>
                                </div>
                                <div class="cs-d-ul cs-d-b">
                                    <ul class="cs-ul-cl">
                                        <li class="cs-ci"><span>劳动</span></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                    </ul>
                                </div>
                                <div class="cs-d-ul cs-d-b">
                                    <ul class="cs-ul-cl">
                                        <li class="cs-ci"><span>认罪悔罪</span></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                    </ul>
                                </div>
                                <div class="cs-d-ul cs-d-b">
                                    <ul class="cs-ul-cl">
                                        <li class="cs-ci"><span>遵规守纪</span></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                    </ul>
                                </div>
                                <div class="cs-d-ul cs-d-b">
                                    <ul class="cs-ul-cl">
                                        <li class="cs-ci"><span>会见通信</span></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                    </ul>
                                </div>
                                <div class="cs-d-ul cs-d-b">
                                    <ul class="cs-ul-cl">
                                        <li class="cs-ci"><span>人机关系</span></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                    </ul>
                                </div>

                            </div>
                        </div>
                    </div>
                    <div class="cs-sub-line"></div>
                    <div class="cs-sub-item-title">日常观察异常</div>
                    <div>
                        <div class="cs-sub-item-title-2">异常/阳性预警信息</div>
                        <ul class="cs-ul">
                            <li class="cs-li"><span class="cs-item-1">预警原因</span><span class="cs-item-2">打架</span></li>
                            <li class="cs-li"><span class="cs-item-1">预警类型</span><span class="cs-item-2">/</span></li>
                            <li class="cs-li"><span class="cs-item-1">预警时间</span><span class="cs-item-2">2017-07-08</span></li>
                        </ul>
                    </div>

                    <div class="cs-sub-item-title-2">
                        <span>日常观察表</span>
                        <span class="cs-sp-b">
                            <a>记录按日查询</a>
                            <a>选择某日/某段时间</a>
                            <a>选择下载</a>
                        </span>
                    </div>
                    <div>
                        <div class="cs-tb-w cs-tb-cl">
                            <ul class="cs-tb-ul">
                                <li class="cs-tb-tr cs-tb-tr-1"></li>
                                <li class="cs-tb-tr"><span>日期</span></li>
                                <li class="cs-tb-tr"><span>是否异常</span></li>
                                <li class="cs-tb-tr"><span>异常内容</span></li>
                                <li class="cs-tb-tr"><span>操作</span></li>
                            </ul>
                        </div>
                        <div class="cs-tb-w cs-tb-lt">
                            <ul class="cs-tb-ul">
                                <li class="cs-tb-tr cs-tb-tr-1">
                                    <input type="checkbox" />
                                </li>
                                <li class="cs-tb-tr">
                                    <span>2017-05-11</span>
                                </li>
                                <li class="cs-tb-tr"><span></span></li>
                                <li class="cs-tb-tr"><span></span></li>
                                <li class="cs-tb-tr cs-mg">
                                    <a class="js-lk">查看详细</a>
                                    <a>下载</a>
                                </li>
                            </ul>
                            <div class="cs-dt">
                                <div>
                                    <ul class="cs-ul cs-ul-1">
                                        <li class="cs-li"><span class="cs-item-1">日期</span><span class="cs-item-2">2017-01-01</span></li>
                                        <li class="cs-li"><span class="cs-item-1">警号</span><span class="cs-item-2">/</span></li>
                                        <li class="cs-li"><span class="cs-item-1">警察姓名</span><span class="cs-item-2">/</span></li>
                                    </ul>
                                </div>
                                <div class="cs-d-ul ds-dc-d">
                                    <ul class="cs-ul-cl cs-ul-cl-4">
                                        <li class="cs-ci">情绪</li>
                                        <li class="cs-ci">是否异常</li>
                                        <li class="cs-ci">是否完成生成任务</li>
                                        <li class="cs-ci">是否生病</li>
                                    </ul>
                                </div>

                                <div class="cs-d-ul cs-d-b">
                                    <ul class="cs-ul-cl cs-ul-cl-4">
                                        <li class="cs-ci"><span>愤怒</span></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                    </ul>
                                </div>
                                <div class="cs-d-ul cs-d-b">
                                    <ul class="cs-ul-cl cs-ul-cl-4">
                                        <li class="cs-ci"><span>恐惧</span></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                    </ul>
                                </div>
                                <div class="cs-d-ul cs-d-b">
                                    <ul class="cs-ul-cl cs-ul-cl-4">
                                        <li class="cs-ci"><span>悲哀</span></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                    </ul>
                                </div>
                                <div class="cs-d-ul cs-d-b">
                                    <ul class="cs-ul-cl cs-ul-cl-4">
                                        <li class="cs-ci"><span>平静</span></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                    </ul>
                                </div>
                                <div class="cs-d-ul cs-d-b">
                                    <ul class="cs-ul-cl cs-ul-cl-4">
                                        <li class="cs-ci"><span>欢喜</span></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                    </ul>
                                </div>

                            </div>
                        </div>
                        <div class="cs-tb-w cs-tb-lt">
                            <ul class="cs-tb-ul">
                                <li class="cs-tb-tr cs-tb-tr-1">
                                    <input type="checkbox" />
                                </li>
                                <li class="cs-tb-tr">
                                    <span>2016-02-14</span>
                                </li>
                                <li class="cs-tb-tr"><span></span></li>
                                <li class="cs-tb-tr"><span></span></li>
                                <li class="cs-tb-tr cs-mg">
                                    <a class="js-lk">查看详细</a>
                                    <a>下载</a>
                                </li>
                            </ul>
                            <div class="cs-dt">
                                <div>
                                    <ul class="cs-ul cs-ul-1">
                                        <li class="cs-li"><span class="cs-item-1">日期</span><span class="cs-item-2">2017-01-01</span></li>
                                        <li class="cs-li"><span class="cs-item-1">警号</span><span class="cs-item-2">/</span></li>
                                        <li class="cs-li"><span class="cs-item-1">警察姓名</span><span class="cs-item-2">/</span></li>
                                    </ul>
                                </div>
                                <div class="cs-d-ul ds-dc-d">
                                    <ul class="cs-ul-cl cs-ul-cl-4">
                                        <li class="cs-ci">情绪</li>
                                        <li class="cs-ci">是否异常</li>
                                        <li class="cs-ci">是否完成生产任务</li>
                                        <li class="cs-ci">是否生病</li>
                                    </ul>
                                </div>

                                <div class="cs-d-ul cs-d-b">
                                    <ul class="cs-ul-cl cs-ul-cl-4">
                                        <li class="cs-ci"><span>愤怒</span></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                    </ul>
                                </div>
                                <div class="cs-d-ul cs-d-b">
                                    <ul class="cs-ul-cl cs-ul-cl-4">
                                        <li class="cs-ci"><span>恐惧</span></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                    </ul>
                                </div>
                                <div class="cs-d-ul cs-d-b">
                                    <ul class="cs-ul-cl cs-ul-cl-4">
                                        <li class="cs-ci"><span>悲哀</span></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                    </ul>
                                </div>
                                <div class="cs-d-ul cs-d-b">
                                    <ul class="cs-ul-cl cs-ul-cl-4">
                                        <li class="cs-ci"><span>平静</span></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                    </ul>
                                </div>
                                <div class="cs-d-ul cs-d-b">
                                    <ul class="cs-ul-cl cs-ul-cl-4">
                                        <li class="cs-ci"><span>欢喜</span></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                    </ul>
                                </div>

                            </div>
                        </div>
                        <div class="cs-tb-w cs-tb-lt">
                            <ul class="cs-tb-ul">
                                <li class="cs-tb-tr cs-tb-tr-1">
                                    <input type="checkbox" />
                                </li>
                                <li class="cs-tb-tr">
                                    <span>2017-05-11</span>
                                </li>
                                <li class="cs-tb-tr"><span></span></li>
                                <li class="cs-tb-tr"><span></span></li>
                                <li class="cs-tb-tr cs-mg">
                                    <a class="js-lk">查看详细</a>
                                    <a>下载</a>
                                </li>
                            </ul>
                            <div class="cs-dt">
                                <div>
                                    <ul class="cs-ul cs-ul-1">
                                        <li class="cs-li"><span class="cs-item-1">日期</span><span class="cs-item-2">2017-01-01</span></li>
                                        <li class="cs-li"><span class="cs-item-1">警号</span><span class="cs-item-2">/</span></li>
                                        <li class="cs-li"><span class="cs-item-1">警察姓名</span><span class="cs-item-2">/</span></li>
                                    </ul>
                                </div>
                                <div class="cs-d-ul ds-dc-d">
                                    <ul class="cs-ul-cl cs-ul-cl-4">
                                        <li class="cs-ci">情绪</li>
                                        <li class="cs-ci">是否异常</li>
                                        <li class="cs-ci">是否完成生产任务</li>
                                        <li class="cs-ci">是否生病</li>
                                    </ul>
                                </div>

                                <div class="cs-d-ul cs-d-b">
                                    <ul class="cs-ul-cl cs-ul-cl-4">
                                        <li class="cs-ci"><span>愤怒</span></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                    </ul>
                                </div>
                                <div class="cs-d-ul cs-d-b">
                                    <ul class="cs-ul-cl cs-ul-cl-4">
                                        <li class="cs-ci"><span>恐惧</span></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                    </ul>
                                </div>
                                <div class="cs-d-ul cs-d-b">
                                    <ul class="cs-ul-cl cs-ul-cl-4">
                                        <li class="cs-ci"><span>悲哀</span></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                    </ul>
                                </div>
                                <div class="cs-d-ul cs-d-b">
                                    <ul class="cs-ul-cl cs-ul-cl-4">
                                        <li class="cs-ci"><span>平静</span></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                    </ul>
                                </div>
                                <div class="cs-d-ul cs-d-b">
                                    <ul class="cs-ul-cl cs-ul-cl-4">
                                        <li class="cs-ci"><span>欢喜</span></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                    </ul>
                                </div>

                            </div>
                        </div>

                    </div>
                    <div class="cs-sub-item-title">异常狱情</div>
                    <div>
                        <div class="cs-sub-item-title-2">异常/阳性预警信息</div>
                        <ul class="cs-ul">
                            <li class="cs-li"><span class="cs-item-1">预警原因</span><span class="cs-item-2">打架</span></li>
                            <li class="cs-li"><span class="cs-item-1">预警类型</span><span class="cs-item-2">/</span></li>
                            <li class="cs-li"><span class="cs-item-1">预警时间</span><span class="cs-item-2">2017-07-08</span></li>
                        </ul>
                    </div>
                    <div class="cs-sub-item-title-2">
                        <span>狱情记录表</span>
                        <span class="cs-sp-b">
                            <a>记录按日查询</a>
                            <a>选择某日/某段时间</a>
                            <a>选择下载</a>
                        </span>
                    </div>
                    <div>
                        <div class="cs-tb-w cs-tb-cl">
                            <ul class="cs-tb-ul">
                                <li class="cs-tb-tr cs-tb-tr-1"></li>
                                <li class="cs-tb-tr"><span>日期</span></li>
                                <li class="cs-tb-tr"><span>是否异常</span></li>
                                <li class="cs-tb-tr"><span>异常内容</span></li>
                                <li class="cs-tb-tr"><span>操作</span></li>
                            </ul>
                        </div>
                        <div class="cs-tb-w cs-tb-lt">
                            <ul class="cs-tb-ul">
                                <li class="cs-tb-tr cs-tb-tr-1">
                                    <input type="checkbox" />
                                </li>
                                <li class="cs-tb-tr">
                                    <span>2017-05-11</span>
                                </li>
                                <li class="cs-tb-tr"><span></span></li>
                                <li class="cs-tb-tr"><span></span></li>
                                <li class="cs-tb-tr cs-mg">
                                    <a class="js-lk">查看详细</a>
                                    <a>下载</a>
                                </li>
                            </ul>
                            <div class="cs-dt">
                                <div>
                                    <ul class="cs-ul cs-ul-1">
                                        <li class="cs-li"><span class="cs-item-1">日期</span><span class="cs-item-2">2017-01-01</span></li>
                                        <li class="cs-li"><span class="cs-item-1">警号</span><span class="cs-item-2">/</span></li>
                                        <li class="cs-li"><span class="cs-item-1">警察姓名</span><span class="cs-item-2">/</span></li>
                                    </ul>
                                </div>
                                <div class="cs-d-ul ds-dc-d">
                                    <ul class="cs-ul-cl cs-ul-cl-4">
                                        <li class="cs-ci">事项</li>
                                        <li class="cs-ci">信息录入</li>
                                        <li class="cs-ci">是否异常</li>
                                        <li class="cs-ci">备注</li>
                                    </ul>
                                </div>

                                <div class="cs-d-ul cs-d-b">
                                    <ul class="cs-ul-cl cs-ul-cl-4">
                                        <li class="cs-ci"><span>重大形势政策调整</span></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                    </ul>
                                </div>
                                <div class="cs-d-ul cs-d-b">
                                    <ul class="cs-ul-cl cs-ul-cl-4">
                                        <li class="cs-ci"><span>刑期变动情况</span></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                    </ul>
                                </div>
                                <div class="cs-d-ul cs-d-b">
                                    <ul class="cs-ul-cl cs-ul-cl-4">
                                        <li class="cs-ci"><span>改造表现</span></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                    </ul>
                                </div>
                                <div class="cs-d-ul cs-d-b">
                                    <ul class="cs-ul-cl cs-ul-cl-4">
                                        <li class="cs-ci"><span>奖惩情况</span></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                    </ul>
                                </div>
                                <div class="cs-d-ul cs-d-b">
                                    <ul class="cs-ul-cl cs-ul-cl-4">
                                        <li class="cs-ci"><span>处遇等级</span></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                    </ul>
                                </div>
                                <div class="cs-d-ul cs-d-b">
                                    <ul class="cs-ul-cl cs-ul-cl-4">
                                        <li class="cs-ci"><span>自伤自残</span></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                    </ul>
                                </div>
                                <div class="cs-d-ul cs-d-b">
                                    <ul class="cs-ul-cl cs-ul-cl-4">
                                        <li class="cs-ci"><span>打架</span></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                    </ul>
                                </div>
                                <div class="cs-d-ul cs-d-b">
                                    <ul class="cs-ul-cl cs-ul-cl-4">
                                        <li class="cs-ci"><span>离婚</span></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                    </ul>
                                </div>
                                <div class="cs-d-ul cs-d-b">
                                    <ul class="cs-ul-cl cs-ul-cl-4">
                                        <li class="cs-ci"><span>家人病重病危病故</span></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                    </ul>
                                </div>
                                <div class="cs-d-ul cs-d-b">
                                    <ul class="cs-ul-cl cs-ul-cl-4">
                                        <li class="cs-ci"><span>自身突发重症疾病</span></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                    </ul>
                                </div>
                                <div class="cs-d-ul cs-d-b">
                                    <ul class="cs-ul-cl cs-ul-cl-4">
                                        <li class="cs-ci"><span>不吃饭超过一天</span></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <div class="cs-tb-w cs-tb-lt">
                            <ul class="cs-tb-ul">
                                <li class="cs-tb-tr cs-tb-tr-1">
                                    <input type="checkbox" />
                                </li>
                                <li class="cs-tb-tr">
                                    <span>2017-05-21</span>
                                </li>
                                <li class="cs-tb-tr"><span></span></li>
                                <li class="cs-tb-tr"><span></span></li>
                                <li class="cs-tb-tr cs-mg">
                                    <a class="js-lk">查看详细</a>
                                    <a>下载</a>
                                </li>
                            </ul>
                            <div class="cs-dt">
                                <div>
                                    <ul class="cs-ul cs-ul-1">
                                        <li class="cs-li"><span class="cs-item-1">日期</span><span class="cs-item-2">2017-01-01</span></li>
                                        <li class="cs-li"><span class="cs-item-1">警号</span><span class="cs-item-2">/</span></li>
                                        <li class="cs-li"><span class="cs-item-1">警察姓名</span><span class="cs-item-2">/</span></li>
                                    </ul>
                                </div>
                                <div class="cs-d-ul ds-dc-d">
                                    <ul class="cs-ul-cl cs-ul-cl-4">
                                        <li class="cs-ci">事项</li>
                                        <li class="cs-ci">信息录入</li>
                                        <li class="cs-ci">是否异常</li>
                                        <li class="cs-ci">备注</li>
                                    </ul>
                                </div>

                                <div class="cs-d-ul cs-d-b">
                                    <ul class="cs-ul-cl cs-ul-cl-4">
                                        <li class="cs-ci"><span>重大形势政策调整</span></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                    </ul>
                                </div>
                                <div class="cs-d-ul cs-d-b">
                                    <ul class="cs-ul-cl cs-ul-cl-4">
                                        <li class="cs-ci"><span>刑期变动情况</span></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                    </ul>
                                </div>
                                <div class="cs-d-ul cs-d-b">
                                    <ul class="cs-ul-cl cs-ul-cl-4">
                                        <li class="cs-ci"><span>改造表现</span></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                    </ul>
                                </div>
                                <div class="cs-d-ul cs-d-b">
                                    <ul class="cs-ul-cl cs-ul-cl-4">
                                        <li class="cs-ci"><span>奖惩情况</span></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                    </ul>
                                </div>
                                <div class="cs-d-ul cs-d-b">
                                    <ul class="cs-ul-cl cs-ul-cl-4">
                                        <li class="cs-ci"><span>处遇等级</span></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                    </ul>
                                </div>
                                <div class="cs-d-ul cs-d-b">
                                    <ul class="cs-ul-cl cs-ul-cl-4">
                                        <li class="cs-ci"><span>自伤自残</span></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                    </ul>
                                </div>
                                <div class="cs-d-ul cs-d-b">
                                    <ul class="cs-ul-cl cs-ul-cl-4">
                                        <li class="cs-ci"><span>打架</span></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                    </ul>
                                </div>
                                <div class="cs-d-ul cs-d-b">
                                    <ul class="cs-ul-cl cs-ul-cl-4">
                                        <li class="cs-ci"><span>离婚</span></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                    </ul>
                                </div>
                                <div class="cs-d-ul cs-d-b">
                                    <ul class="cs-ul-cl cs-ul-cl-4">
                                        <li class="cs-ci"><span>家人病重病危病故</span></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                    </ul>
                                </div>
                                <div class="cs-d-ul cs-d-b">
                                    <ul class="cs-ul-cl cs-ul-cl-4">
                                        <li class="cs-ci"><span>自身突发重症疾病</span></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                    </ul>
                                </div>
                                <div class="cs-d-ul cs-d-b">
                                    <ul class="cs-ul-cl cs-ul-cl-4">
                                        <li class="cs-ci"><span>不吃饭超过一天</span></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <div class="cs-tb-w cs-tb-lt">
                            <ul class="cs-tb-ul">
                                <li class="cs-tb-tr cs-tb-tr-1">
                                    <input type="checkbox" />
                                </li>
                                <li class="cs-tb-tr">
                                    <span>2017-02-11</span>
                                </li>
                                <li class="cs-tb-tr"><span></span></li>
                                <li class="cs-tb-tr"><span></span></li>
                                <li class="cs-tb-tr cs-mg">
                                    <a class="js-lk">查看详细</a>
                                    <a>下载</a>
                                </li>
                            </ul>
                            <div class="cs-dt">
                                <div>
                                    <ul class="cs-ul cs-ul-1">
                                        <li class="cs-li"><span class="cs-item-1">日期</span><span class="cs-item-2">2017-01-01</span></li>
                                        <li class="cs-li"><span class="cs-item-1">警号</span><span class="cs-item-2">/</span></li>
                                        <li class="cs-li"><span class="cs-item-1">警察姓名</span><span class="cs-item-2">/</span></li>
                                    </ul>
                                </div>
                                <div class="cs-d-ul ds-dc-d">
                                    <ul class="cs-ul-cl cs-ul-cl-4">
                                        <li class="cs-ci">事项</li>
                                        <li class="cs-ci">信息录入</li>
                                        <li class="cs-ci">是否异常</li>
                                        <li class="cs-ci">备注</li>
                                    </ul>
                                </div>

                                <div class="cs-d-ul cs-d-b">
                                    <ul class="cs-ul-cl cs-ul-cl-4">
                                        <li class="cs-ci"><span>重大形势政策调整</span></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                    </ul>
                                </div>
                                <div class="cs-d-ul cs-d-b">
                                    <ul class="cs-ul-cl cs-ul-cl-4">
                                        <li class="cs-ci"><span>刑期变动情况</span></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                    </ul>
                                </div>
                                <div class="cs-d-ul cs-d-b">
                                    <ul class="cs-ul-cl cs-ul-cl-4">
                                        <li class="cs-ci"><span>改造表现</span></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                    </ul>
                                </div>
                                <div class="cs-d-ul cs-d-b">
                                    <ul class="cs-ul-cl cs-ul-cl-4">
                                        <li class="cs-ci"><span>奖惩情况</span></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                    </ul>
                                </div>
                                <div class="cs-d-ul cs-d-b">
                                    <ul class="cs-ul-cl cs-ul-cl-4">
                                        <li class="cs-ci"><span>处遇等级</span></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                    </ul>
                                </div>
                                <div class="cs-d-ul cs-d-b">
                                    <ul class="cs-ul-cl cs-ul-cl-4">
                                        <li class="cs-ci"><span>自伤自残</span></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                    </ul>
                                </div>
                                <div class="cs-d-ul cs-d-b">
                                    <ul class="cs-ul-cl cs-ul-cl-4">
                                        <li class="cs-ci"><span>打架</span></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                    </ul>
                                </div>
                                <div class="cs-d-ul cs-d-b">
                                    <ul class="cs-ul-cl cs-ul-cl-4">
                                        <li class="cs-ci"><span>离婚</span></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                    </ul>
                                </div>
                                <div class="cs-d-ul cs-d-b">
                                    <ul class="cs-ul-cl cs-ul-cl-4">
                                        <li class="cs-ci"><span>家人病重病危病故</span></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                    </ul>
                                </div>
                                <div class="cs-d-ul cs-d-b">
                                    <ul class="cs-ul-cl cs-ul-cl-4">
                                        <li class="cs-ci"><span>自身突发重症疾病</span></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                    </ul>
                                </div>
                                <div class="cs-d-ul cs-d-b">
                                    <ul class="cs-ul-cl cs-ul-cl-4">
                                        <li class="cs-ci"><span>不吃饭超过一天</span></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--  -->
                    <div class="cs-sub-item-title">狱情排查系统异常</div>
                    <div>
                        <div class="cs-sub-item-title-2">异常/阳性预警信息</div>
                        <ul class="cs-ul">
                            <li class="cs-li"><span class="cs-item-1">预警原因</span><span class="cs-item-2">打架</span></li>
                            <li class="cs-li"><span class="cs-item-1">预警类型</span><span class="cs-item-2">/</span></li>
                            <li class="cs-li"><span class="cs-item-1">预警时间</span><span class="cs-item-2">2017-07-08</span></li>
                        </ul>
                    </div>

                    <div class="cs-sub-item-title-2">
                        <span>狱情排查表</span>
                        <span class="cs-sp-b">
                            <a>记录按日查询</a>
                            <a>选择某日/某段时间</a>
                            <a>选择下载</a>
                        </span>
                    </div>
                    <div>
                        <div class="cs-tb-w cs-tb-cl">
                            <ul class="cs-tb-ul">
                                <li class="cs-tb-tr cs-tb-tr-1"></li>
                                <li class="cs-tb-tr"><span>日期</span></li>
                                <li class="cs-tb-tr"><span>是否异常</span></li>
                                <li class="cs-tb-tr"><span>异常内容</span></li>
                                <li class="cs-tb-tr"><span>操作</span></li>
                            </ul>
                        </div>
                        <div class="cs-tb-w cs-tb-lt">
                            <ul class="cs-tb-ul">
                                <li class="cs-tb-tr cs-tb-tr-1">
                                    <input type="checkbox" />
                                </li>
                                <li class="cs-tb-tr">
                                    <span>2017-05-11</span>
                                </li>
                                <li class="cs-tb-tr"><span></span></li>
                                <li class="cs-tb-tr"><span></span></li>
                                <li class="cs-tb-tr cs-mg">
                                    <a class="js-lk">查看详细</a>
                                    <a>下载</a>
                                </li>
                            </ul>
                            <div class="cs-dt">
                                <div>
                                    <ul class="cs-ul cs-ul-1">
                                        <li class="cs-li"><span class="cs-item-1">日期</span><span class="cs-item-2">2017-01-01</span></li>
                                        <li class="cs-li"><span class="cs-item-1">警号</span><span class="cs-item-2">/</span></li>
                                        <li class="cs-li"><span class="cs-item-1">警察姓名</span><span class="cs-item-2">/</span></li>
                                    </ul>
                                </div>
                                <div class="cs-d-ul ds-dc-d">
                                    <ul class="cs-ul-cl">
                                        <li class="cs-ci">名称</li>
                                        <li class="cs-ci">是否异常</li>
                                        <li class="cs-ci">备注</li>
                                    </ul>
                                </div>

                                <div class="cs-d-ul cs-d-b">
                                    <ul class="cs-ul-cl">
                                        <li class="cs-ci"><span>罪犯心理状况、思想波动</span></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                    </ul>
                                </div>
                                <div class="cs-d-ul cs-d-b">
                                    <ul class="cs-ul-cl">
                                        <li class="cs-ci"><span>劳改改造现场</span></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                    </ul>
                                </div>
                                <div class="cs-d-ul cs-d-b">
                                    <ul class="cs-ul-cl">
                                        <li class="cs-ci"><span>生活、教育心矫</span></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                    </ul>
                                </div>
                                <div class="cs-d-ul cs-d-b">
                                    <ul class="cs-ul-cl">
                                        <li class="cs-ci"><span>会见</span></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                    </ul>
                                </div>
                                <div class="cs-d-ul cs-d-b">
                                    <ul class="cs-ul-cl">
                                        <li class="cs-ci"><span>身体状况</span></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                    </ul>
                                </div>

                            </div>
                        </div>
                        <div class="cs-tb-w cs-tb-lt">
                            <ul class="cs-tb-ul">
                                <li class="cs-tb-tr cs-tb-tr-1">
                                    <input type="checkbox" />
                                </li>
                                <li class="cs-tb-tr">
                                    <span>2017-05-21</span>
                                </li>
                                <li class="cs-tb-tr"><span></span></li>
                                <li class="cs-tb-tr"><span></span></li>
                                <li class="cs-tb-tr cs-mg">
                                    <a class="js-lk">查看详细</a>
                                    <a>下载</a>
                                </li>
                            </ul>
                            <div class="cs-dt">
                                <div>
                                    <ul class="cs-ul cs-ul-1">
                                        <li class="cs-li"><span class="cs-item-1">日期</span><span class="cs-item-2">2017-01-01</span></li>
                                        <li class="cs-li"><span class="cs-item-1">警号</span><span class="cs-item-2">/</span></li>
                                        <li class="cs-li"><span class="cs-item-1">警察姓名</span><span class="cs-item-2">/</span></li>
                                    </ul>
                                </div>
                                <div class="cs-d-ul ds-dc-d">
                                    <ul class="cs-ul-cl">
                                        <li class="cs-ci">名称</li>
                                        <li class="cs-ci">是否异常</li>
                                        <li class="cs-ci">备注</li>
                                    </ul>
                                </div>

                                <div class="cs-d-ul cs-d-b">
                                    <ul class="cs-ul-cl">
                                        <li class="cs-ci"><span>罪犯心理状况、思想波动</span></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                    </ul>
                                </div>
                                <div class="cs-d-ul cs-d-b">
                                    <ul class="cs-ul-cl">
                                        <li class="cs-ci"><span>劳改改造现场</span></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                    </ul>
                                </div>
                                <div class="cs-d-ul cs-d-b">
                                    <ul class="cs-ul-cl">
                                        <li class="cs-ci"><span>生活、教育心矫</span></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                    </ul>
                                </div>
                                <div class="cs-d-ul cs-d-b">
                                    <ul class="cs-ul-cl">
                                        <li class="cs-ci"><span>会见</span></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                    </ul>
                                </div>
                                <div class="cs-d-ul cs-d-b">
                                    <ul class="cs-ul-cl">
                                        <li class="cs-ci"><span>身体状况</span></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                    </ul>
                                </div>

                            </div>
                        </div>
                        <div class="cs-tb-w cs-tb-lt">
                            <ul class="cs-tb-ul">
                                <li class="cs-tb-tr cs-tb-tr-1">
                                    <input type="checkbox" />
                                </li>
                                <li class="cs-tb-tr">
                                    <span>2015-11-11</span>
                                </li>
                                <li class="cs-tb-tr"><span></span></li>
                                <li class="cs-tb-tr"><span></span></li>
                                <li class="cs-tb-tr cs-mg">
                                    <a class="js-lk">查看详细</a>
                                    <a>下载</a>
                                </li>
                            </ul>
                            <div class="cs-dt">
                                <div>
                                    <ul class="cs-ul cs-ul-1">
                                        <li class="cs-li"><span class="cs-item-1">日期</span><span class="cs-item-2">2017-01-01</span></li>
                                        <li class="cs-li"><span class="cs-item-1">警号</span><span class="cs-item-2">/</span></li>
                                        <li class="cs-li"><span class="cs-item-1">警察姓名</span><span class="cs-item-2">/</span></li>
                                    </ul>
                                </div>
                                <div class="cs-d-ul ds-dc-d">
                                    <ul class="cs-ul-cl">
                                        <li class="cs-ci">名称</li>
                                        <li class="cs-ci">是否异常</li>
                                        <li class="cs-ci">备注</li>
                                    </ul>
                                </div>

                                <div class="cs-d-ul cs-d-b">
                                    <ul class="cs-ul-cl">
                                        <li class="cs-ci"><span>罪犯心理状况、思想波动</span></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                    </ul>
                                </div>
                                <div class="cs-d-ul cs-d-b">
                                    <ul class="cs-ul-cl">
                                        <li class="cs-ci"><span>劳改改造现场</span></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                    </ul>
                                </div>
                                <div class="cs-d-ul cs-d-b">
                                    <ul class="cs-ul-cl">
                                        <li class="cs-ci"><span>生活、教育心矫</span></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                    </ul>
                                </div>
                                <div class="cs-d-ul cs-d-b">
                                    <ul class="cs-ul-cl">
                                        <li class="cs-ci"><span>会见</span></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                    </ul>
                                </div>
                                <div class="cs-d-ul cs-d-b">
                                    <ul class="cs-ul-cl">
                                        <li class="cs-ci"><span>身体状况</span></li>
                                        <li class="cs-ci"></li>
                                        <li class="cs-ci"></li>
                                    </ul>
                                </div>

                            </div>
                        </div>

                    </div>
                </div>
            </div>
            <div class="cs-item cs-item-l">
                <div class="cs-item-title">管控对策</div>
                <div class="cs-item-he">各部门管控意见</div>
                <div class="cs-li"><span class="cs-item-1">分押意见</span><span class="cs-item-2"></span></div>
                <div class="cs-li"><span class="cs-item-1">狱政管理部</span><span class="cs-item-2"></span></div>
                <div class="cs-li"><span class="cs-item-1">劳动改造部</span><span class="cs-item-2"></span></div>
                <div class="cs-li"><span class="cs-item-1">教育改造部</span><span class="cs-item-2"></span></div>
                <div class="cs-li"><span class="cs-item-1">心理矫治部</span><span class="cs-item-2"></span></div>
                <div class="cs-li"><span class="cs-item-1">狱内侦查部</span><span class="cs-item-2"></span></div>
                <div class="cs-li"><span class="cs-item-1">刑罚执行部</span><span class="cs-item-2"></span></div>
                <div class="cs-li"><span class="cs-item-1">生活卫生部</span><span class="cs-item-2"></span></div>
            </div>
            <div class="cs-item cs-item-l">
                <div class="cs-item-title">人工操作记录</div>
                <div>
				<table class="cs-tb-w cs-tb-cl" style="text-align:center">
				<tr >
				<th>警号</th>
				<th>警察</th>
				<th>时间</th>
				<th>封存记录</th>
				<th>修改项</th>
				<th>修前值</th>
				<th>修后值</th>
				</tr>
				<tr style=" background:#d0d0d0;color:#000000">
				<td> 4165296</td>
				<td>王维 </td>
				<td>2016/08/01 </td>
				<td>/ </td>
				<td> 危险等级</td>
				<td>低度 </td>
                <td>中度</td>
				</tr>
				<tr style=" background:#d0d0d0;color:#000000">
				<td> 4165296</td>
				<td>王维 </td>
				<td>2016/09/01 </td>
				<td>/ </td>
				<td> 危险等级</td>
				<td>中度 </td>
                <td>高度</td>
				</tr>
				<tr style=" background:#d0d0d0;color:#000000">
				<td> 4165296</td>
				<td>王维 </td>
				<td>2017/03/01 </td>
				<td>/ </td>
				<td> 危险等级</td>
				<td>高度 </td>
                <td>中度</td>
				</tr>
				</table>
                </div>
       
            </div>
        </div>
    </div>
</body>
</html>