<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>评估报告分析</title>
</head>
<body>
  <div id="pgbgfxPage">
        <!-- 定位栏-->
		<div class="location">
			<div class="location_left"><i><font  color="#ffffff"><strong>您现在的位置</strong></font></i></div>
			<div class="location_right">
				<strong>&nbsp;&nbsp;评估工具 >><font color="#ff3300">量表分析</font></strong>
			</div>
		</div>
		<div class="base_right_bom">
            <span class="base_query">高级查询</span>
            <div class="bse_hunt">
                <span class="bse_hunt_top">搜索器</span>

                <div style="clear:both;">

                    <!-- pull_down_one -->
                    <div class="pull_down_one pull-down-two">
                        <ul>
                     
                          <li>
                              <i class="zhengjian">监区</i>
                          
                              <span>
                              <select >
                              <option>第一监区</option>
                             <option>第二监区</option>
                             <option>第三监区</option>
                             <option>第四监区</option>
							 <option>第五监区</option>
                             <option>第六监区</option>
                             <option>第七监区</option>
                             <option>第八监区</option>
                                  </select>
                              </span>
                          </li>
                      
                           <li>
                                <i class="zhengjian">囚号</i>
                                <span><input type="text" /></span>
                            </li>

                            <li>
                                <i class="zhengjian">罪犯姓名</i>
                                <span><input type="text" /></span>
                            </li>
                            <li>
                                <i class="zhengjian">评估时间</i>
                                <span>
                                    <ul class="syn_time">
                                        <input type="text" cssClass="Wdate" maxLength="10" style="width:95%;font-size: 16px;font-family: "微软雅黑";" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
                                    </ul>                        
                                </span>
                            </li>
                        </ul>
                        <button class="base_button" style="margin-top:10px;">搜索</button>
                    </div>
                    <div style="clear:both;">
                        <div class="cs-sx"><span>添加筛选条件</span></div>
                        <div>
                            <ul class="cs-ss-ul">
                                <li class="cs-s-li-b-1">
                                    <span>危险等级：</span>
                                </li>
                                <li class="cs-s-li-b-2">
                                    <ul class="cs-ss-sub-ul">
                                        <li class="cs-ss-sub-li">
                                            <label>
                                                <input type="checkbox" />
                                                <span>极高危险</span>
                                            </label>
                                        </li>
                                        <li class="cs-ss-sub-li">
                                            <label>
                                                <input type="checkbox" />
                                                <span>高度危险</span>
                                            </label>
                                        </li>
                                        <li class="cs-ss-sub-li">
                                            <label>
                                                <input type="checkbox" />
                                                <span>中度危险</span>
                                            </label>
                                        </li>
                                        <li class="cs-ss-sub-li">
                                            <label>
                                                <input type="checkbox" />
                                                <span>低度危险</span>
                                            </label>
                                        </li>
                                    </ul>
                                </li>
                            </ul>
                        </div>
         
                        <div>
                            <ul class="cs-ss-ul">
                                <li class="cs-s-li-b-1">
                                    <span>危险类别：</span>
                                </li>
                                <li class="cs-s-li-b-2">
                                    <ul class="cs-ss-sub-ul">
                                        <li class="cs-ss-sub-li">
                                            <label>
                                                <input type="checkbox" />
                                                <span>自杀</span>
                                            </label>
                                        </li>
                                        <li class="cs-ss-sub-li">
                                            <label>
                                                <input type="checkbox" />
                                                <span>行凶</span>
                                            </label>
                                        </li>
                                        <li class="cs-ss-sub-li">
                                            <label>
                                                <input type="checkbox" />
                                                <span>逃脱</span>
                                            </label>
                                        </li>
										 <li class="cs-ss-sub-li">
                                            <label>
                                                <input type="checkbox" />
                                                <span>再犯罪</span>
                                            </label>
                                        </li>
                                    </ul>
                                </li>
                            </ul>
                        </div>
                    </div>
                                    </div> 

            </div>

            <!-- table -->

            <div class="base_table cs-table">
                <span class="base_liebiao"></span>
                <table width="100%">
                    <tr>
                        <th class="base_th" width="5%">序号</th>
                        <th class="base_th" width="10%">囚号</th>
                        <th class="base_th" width="10%">罪犯姓名</th>
                        <th class="base_th" width="10%">监区</th>
                        <th class="base_th" width="10%">危险等级</th>
                        <th class="base_th" width="10%">综合分数</th>
                        <th class="base_th" width="10%">自杀分数</th>
                        <th class="base_th" width="10%">脱逃分数</th>
                        <th class="base_th" width="10%">行凶分数</th>
                        <th class="base_th" width="10%">再犯罪分数</th>
                        <th class="base_th" width="10%">评估报告及分析</th>
                    </tr>
                    <tr>
                        <td>1</td>
                       <!--  <td>广州监狱</td>
                       <td>第十监区</td> -->
                       <!--  <td>1100021</td> -->
                        <td>6546545454</td>
                        <td>xx</td>
                        <td>第一监区</td>
                        <td>极高危险</td>
                        <td>140</td>
						<td> 50</td>
                        <td>30</td>
                        <td>50</td>
                        <td>10</td>
                        <td>
                            <a href="#" onclick="loadnext2('/oasm/pggjglView/fxmb')">查看及分析</a>
                        </td>
                    </tr>
                    <tr>
                        <td>2</td>
                       <!--  <td>广州监狱</td>
                       <td>第十监区</td> -->
                       <!--  <td>1100021</td> -->
                        <td>6546545454</td>
                        <td>xx</td>
                        <td>第一监区</td>
                        <td>高度危险</td>
                        <td>90</td>
						<td>20</td>
                        <td>30</td>
                        <td>30</td>
                        <td>10</td>
                        <td>
                            <a href="#" onclick="loadnext2('/oasm/pggjglView/fxmb')">查看及分析</a>
                        </td>
                    </tr>
                </table>

            </div>

            <div class="fenye">
                <ul class="ul05">
                    <li>共2页</li>
                    <li>首页</li>
                    <li>上一页</li>
                    <li class="fenye-li01">1</li>
                    <li class="fenye-li02">2</li>
                    <li>下一页</li>
                    <li>尾页</li>
                    <li>
                        转到第
                        <input type="text" /> 页
                    </li>
                </ul>
            </div>
        </div>
	</div>
</body>
</html>