<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<%@taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>症状自评量表(SCL-90)</title>

</head>
<body>
	<div class="return_btn">
		<a href="#" onclick="goBack()()">&laquo;&laquo;返回</a>
	</div>
	<div class="rs_table">
		<div class="rs_table_title">
			<h1>症状自评量表(SCL-90)</h1>
		</div>
		<!-- <strong id="hidescltaskid"><shiro:principal /></strong> -->
		<div class="msg_div">
			<ul class="xx_ul">
				<li class="xx_li01">姓<span>名</span>：
				</li>
				<li class="xx_li02" id='crimName'>韩方奕</li>
				<li class="xx_li01">囚<span>号</span>：
				</li>
				<li id="crimNo" class="xx_number xx_li02" onclick="getCrimDetails()">1234567890</li>
				<li class="xx_li01">测试时间：</li>
				<li class="xx_li02" id='testTime'>2017/11/6</li>
				<li class="xx_li01">监<span>区</span>：
				</li>
				<li class="xx_li02" id='prison'>三监区</li>
				<li class="xx_li01">分监区：</li>
				<li class="xx_li02" id='subPrison'>分监区1</li>
				<li class="xx_li01">警察姓名：<span class="scl_jh"
					style="display: none;"><shiro:principal /></span></li>
				<li class="xx_li02" id='modifierName'>王子需</li>
			</ul>
		</div>
		<div class="lb_content_table2">
			<table>
				<colgroup>
					<col width="4%">
					<col width="46%">
					<col width="10%">
					<col width="10%">
					<col width="10%">
					<col width="10%">
					<col width="10%">
				</colgroup>
				<tr>
					<th>序号</th>
					<th>题目</th>
					<th >没有</th>
					<th>很轻</th>
					<th>中等</th>
					<th>偏重</th>
					<th>严重</th>
				</tr>
				<tbody class="psychologicalTests_scale_paper">
				<tr>
					<td>1</td>
					<td class="lbf">头痛</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq1"
						value="0" id="sclq1_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq1"
						value="1" id="sclq1_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq1"
						value="2" id="sclq1_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq1"
						value="3" id="sclq1_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq1"
						value="4" id="sclq1_5"></td>
				</tr>
				<tr>
					<td>2</td>
					<td class="lbf">神经过敏，心中不踏实</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq2"
						value="0" id="sclq2_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq2"
						value="1" id="sclq2_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq2"
						value="2" id="sclq2_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq2"
						value="3" id="sclq2_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq2"
						value="4" id="sclq2_5"></td>

				</tr>
				<tr>
					<td>3</td>
					<td class="lbf">头脑中有不必要的想法或字句盘旋</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq3"
						value="0" id="sclq3_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq3"
						value="1" id="sclq3_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq3"
						value="2" id="sclq3_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq3"
						value="3" id="sclq3_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq3"
						value="4" id="sclq3_5"></td>

				</tr>
				<tr>
					<td>4</td>
					<td class="lbf">头晕或晕倒</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq4"
						value="0" id="sclq4_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq4"
						value="1" id="sclq4_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq4"
						value="2" id="sclq4_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq4"
						value="3" id="sclq4_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq4"
						value="4" id="sclq4_5"></td>

				</tr>
				<tr>
					<td>5</td>
					<td class="lbf">对异性的兴趣减退</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq5"
						value="0" id="sclq5_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq5"
						value="1" id="sclq5_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq5"
						value="2" id="sclq5_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq5"
						value="3" id="sclq5_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq5"
						value="4" id="sclq5_5"></td>
				</tr>
				<tr>
					<td>6</td>
					<td class="lbf">对旁人责备求全</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq6"
						value="0" id="sclq6_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq6"
						value="1" id="sclq6_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq6"
						value="2" id="sclq6_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq6"
						value="3" id="sclq6_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq6"
						value="4" id="sclq6_5"></td>
				</tr>
				<tr>
					<td>7</td>
					<td class="lbf">感到别人能控制您的思想</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq7"
						value="0" id="sclq7_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq7"
						value="1" id="sclq7_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq7"
						value="2" id="sclq7_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq7"
						value="3" id="sclq7_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq7"
						value="4" id="sclq7_5"></td>
				</tr>
				<tr>
					<td>8</td>
					<td class="lbf">责怪别人制造麻烦</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq8"
						value="0" id="sclq8_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq8"
						value="1" id="sclq8_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq8"
						value="2" id="sclq8_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq8"
						value="3" id="sclq8_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq8"
						value="4" id="sclq8_5"></td>
				</tr>
				<tr>
					<td>9</td>
					<td class="lbf">忘性大</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq9"
						value="0" id="sclq9_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq9"
						value="1" id="sclq9_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq9"
						value="2" id="sclq9_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq9"
						value="3" id="sclq9_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq9"
						value="4" id="sclq9_5"></td>
				</tr>
				<tr>
					<td>10</td>
					<td class="lbf">担心自己的衣饰整齐及仪态的端正</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq10"
						value="0" id="sclq10_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq10"
						value="1" id="sclq10_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq10"
						value="2" id="sclq10_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq10"
						value="3" id="sclq10_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq10"
						value="4" id="sclq10_5"></td>
				</tr>
				<tr>
					<td>11</td>
					<td class="lbf">容易烦恼和激动</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq11"
						value="0" id="sclq11_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq11"
						value="1" id="sclq11_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq11"
						value="2" id="sclq11_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq11"
						value="3" id="sclq11_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq11"
						value="4" id="sclq11_5"></td>
				</tr>
				<tr>
					<td>12</td>
					<td class="lbf">胸痛</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq12"
						value="0" id="sclq12_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq12"
						value="1" id="sclq12_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq12"
						value="2" id="sclq12_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq12"
						value="3" id="sclq12_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq12"
						value="4" id="sclq12_5"></td>
				</tr>
				<tr>
					<td>13</td>
					<td class="lbf">害怕空旷的场所或街道</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq13"
						value="0" id="sclq13_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq13"
						value="1" id="sclq13_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq13"
						value="2" id="sclq13_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq13"
						value="3" id="sclq13_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq13"
						value="4" id="sclq13_5"></td>
				</tr>
				<tr>
					<td>14</td>
					<td class="lbf">感到自己的精力下降，活动减慢</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq14"
						value="0" id="sclq14_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq14"
						value="1" id="sclq14_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq14"
						value="2" id="sclq14_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq14"
						value="3" id="sclq14_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq14"
						value="4" id="sclq14_5"></td>
				</tr>
				<tr>
					<td>15</td>
					<td class="lbf">想结束自己的生命</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq15"
						value="0" id="sclq15_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq15"
						value="1" id="sclq15_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq15"
						value="2" id="sclq15_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq15"
						value="3" id="sclq15_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq15"
						value="4" id="sclq15_5"></td>
				</tr>
				<tr>
					<td>16</td>
					<td class="lbf">听到旁人听不到的声音</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq16"
						value="0" id="sclq16_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq16"
						value="1" id="sclq16_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq16"
						value="2" id="sclq16_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq16"
						value="3" id="sclq16_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq16"
						value="4" id="sclq16_5"></td>
				</tr>
				<tr>
					<td>17</td>
					<td class="lbf">发抖</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq17"
						value="0" id="sclq17_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq17"
						value="1" id="sclq17_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq17"
						value="2" id="sclq17_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq17"
						value="3" id="sclq17_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq17"
						value="4" id="sclq17_5"></td>
				</tr>
				<tr>
					<td>18</td>
					<td class="lbf">感到大多数人都不可信任</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq18"
						value="0" id="sclq18_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq18"
						value="1" id="sclq18_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq18"
						value="2" id="sclq18_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq18"
						value="3" id="sclq18_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq18"
						value="4" id="sclq18_5"></td>
				</tr>
				<tr>
					<td>19</td>
					<td class="lbf">胃口不好</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq19"
						value="0" id="sclq19_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq19"
						value="1" id="sclq19_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq19"
						value="2" id="sclq19_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq19"
						value="3" id="sclq19_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq19"
						value="4" id="sclq19_5"></td>
				</tr>
				<tr>
					<td>20</td>
					<td class="lbf">容易哭泣</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq20"
						value="0" id="sclq20_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq20"
						value="1" id="sclq20_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq20"
						value="2" id="sclq20_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq20"
						value="3" id="sclq20_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq20"
						value="4" id="sclq20_5"></td>
				</tr>
				<tr>
					<td>21</td>
					<td class="lbf">同异性相处时感到害羞不自在</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq21"
						value="0" id="sclq21_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq21"
						value="1" id="sclq21_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq21"
						value="2" id="sclq21_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq21"
						value="3" id="sclq21_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq21"
						value="4" id="sclq21_5"></td>
				</tr>
				<tr>
					<td>22</td>
					<td class="lbf">感到受骗，中了圈套或有人想抓住您</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq22"
						value="0" id="sclq22_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq22"
						value="1" id="sclq22_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq22"
						value="2" id="sclq22_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq22"
						value="3" id="sclq22_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq22"
						value="4" id="sclq22_5"></td>
				</tr>
				<tr>
					<td>23</td>
					<td class="lbf">无缘无故地突然感到害怕</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq23"
						value="0" id="sclq23_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq23"
						value="1" id="sclq23_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq23"
						value="2" id="sclq23_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq23"
						value="3" id="sclq23_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq23"
						value="4" id="sclq23_5"></td>
				</tr>
				<tr>
					<td>24</td>
					<td class="lbf">自己不能控制地大发脾气</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq24"
						value="0" id="sclq24_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq24"
						value="1" id="sclq24_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq24"
						value="2" id="sclq24_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq24"
						value="3" id="sclq24_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq24"
						value="4" id="sclq24_5"></td>
				</tr>
				<tr>
					<td>25</td>
					<td class="lbf">怕单独出门</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq25"
						value="0" id="sclq25_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq25"
						value="1" id="sclq25_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq25"
						value="2" id="sclq25_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq25"
						value="3" id="sclq25_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq25"
						value="4" id="sclq25_5"></td>
				</tr>
				<tr>
					<td>26</td>
					<td class="lbf">经常责怪自己</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq26"
						value="0" id="sclq26_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq26"
						value="1" id="sclq26_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq26"
						value="2" id="sclq26_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq26"
						value="3" id="sclq26_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq26"
						value="4" id="sclq26_5"></td>
				</tr>
				<tr>
					<td>27</td>
					<td class="lbf">腰痛</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq27"
						value="0" id="sclq27_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq27"
						value="1" id="sclq27_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq27"
						value="2" id="sclq27_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq27"
						value="3" id="sclq27_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq27"
						value="4" id="sclq27_5"></td>
				</tr>
				<tr>
					<td>28</td>
					<td class="lbf">感到难以完成任务</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq28"
						value="0" id="sclq28_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq28"
						value="1" id="sclq28_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq28"
						value="2" id="sclq28_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq28"
						value="3" id="sclq28_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq28"
						value="4" id="sclq28_5"></td>
				</tr>
				<tr>
					<td>29</td>
					<td class="lbf">感到孤独</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq29"
						value="0" id="sclq29_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq29"
						value="1" id="sclq29_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq29"
						value="2" id="sclq29_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq29"
						value="3" id="sclq29_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq29"
						value="4" id="sclq29_5"></td>
				</tr>
				<tr>
					<td>30</td>
					<td class="lbf">感到苦闷</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq30"
						value="0" id="sclq30_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq30"
						value="1" id="sclq30_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq30"
						value="2" id="sclq30_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq30"
						value="3" id="sclq30_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq30"
						value="4" id="sclq30_5"></td>
				</tr>
				<tr>
					<td>31</td>
					<td class="lbf">过分担忧</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq31"
						value="0" id="sclq31_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq31"
						value="1" id="sclq31_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq31"
						value="2" id="sclq31_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq31"
						value="3" id="sclq31_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq31"
						value="4" id="sclq31_5"></td>
				</tr>
				<tr>
					<td>32</td>
					<td class="lbf">对事物不感兴趣</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq32"
						value="0" id="sclq32_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq32"
						value="1" id="sclq32_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq32"
						value="2" id="sclq32_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq32"
						value="3" id="sclq32_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq32"
						value="4" id="sclq32_5"></td>
				</tr>
				<tr>
					<td>33</td>
					<td class="lbf">感到害怕</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq33"
						value="0" id="sclq33_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq33"
						value="1" id="sclq33_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq33"
						value="2" id="sclq33_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq33"
						value="3" id="sclq33_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq33"
						value="4" id="sclq33_5"></td>
				</tr>
				<tr>
					<td>34</td>
					<td class="lbf">您的感情容易受到伤害</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq34"
						value="0" id="sclq34_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq34"
						value="1" id="sclq34_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq34"
						value="2" id="sclq34_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq34"
						value="3" id="sclq34_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq34"
						value="4" id="sclq34_5"></td>
				</tr>
				<tr>
					<td>35</td>
					<td class="lbf">旁人能知道您的私下想法</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq35"
						value="0" id="sclq35_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq35"
						value="1" id="sclq35_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq35"
						value="2" id="sclq35_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq35"
						value="3" id="sclq35_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq35"
						value="4" id="sclq35_5"></td>
				</tr>
				<tr>
					<td>36</td>
					<td class="lbf">感到别人不理解您不同情您</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq36"
						value="0" id="sclq36_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq36"
						value="1" id="sclq36_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq36"
						value="2" id="sclq36_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq36"
						value="3" id="sclq36_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq36"
						value="4" id="sclq36_5"></td>
				</tr>
				<tr>
					<td>37</td>
					<td class="lbf">感到人们对您不友好，不喜欢您</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq37"
						value="0" id="sclq37_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq37"
						value="1" id="sclq37_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq37"
						value="2" id="sclq37_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq37"
						value="3" id="sclq37_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq37"
						value="4" id="sclq37_5"></td>
				</tr>
				<tr>
					<td>38</td>
					<td class="lbf">做事必须做得很慢以保证做得正确</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq38"
						value="0" id="sclq38_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq38"
						value="1" id="sclq38_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq38"
						value="2" id="sclq38_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq38"
						value="3" id="sclq38_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq38"
						value="4" id="sclq38_5"></td>
				</tr>
				<tr>
					<td>39</td>
					<td class="lbf">心跳得很厉害</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq39"
						value="0" id="sclq39_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq39"
						value="1" id="sclq39_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq39"
						value="2" id="sclq39_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq39"
						value="3" id="sclq39_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq39"
						value="4" id="sclq39_5"></td>
				</tr>
				<tr>
					<td>40</td>
					<td class="lbf">恶心或胃部不舒服</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq40"
						value="0" id="sclq40_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq40"
						value="1" id="sclq40_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq40"
						value="2" id="sclq40_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq40"
						value="3" id="sclq40_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq40"
						value="4" id="sclq40_5"></td>
				</tr>
				<tr>
					<td>41</td>
					<td class="lbf">感到比不上他人</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq41"
						value="0" id="sclq41_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq41"
						value="1" id="sclq41_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq41"
						value="2" id="sclq41_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq41"
						value="3" id="sclq41_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq41"
						value="4" id="sclq41_5"></td>
				</tr>
				<tr>
					<td>42</td>
					<td class="lbf">肌肉酸痛</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq42"
						value="0" id="sclq42_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq42"
						value="1" id="sclq42_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq42"
						value="2" id="sclq42_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq42"
						value="3" id="sclq42_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq42"
						value="4" id="sclq42_5"></td>
				</tr>
				<tr>
					<td>43</td>
					<td class="lbf">感到有人在监视您谈论您</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq43"
						value="0" id="sclq43_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq43"
						value="1" id="sclq43_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq43"
						value="2" id="sclq43_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq43"
						value="3" id="sclq43_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq43"
						value="4" id="sclq43_5"></td>
				</tr>
				<tr>
					<td>44</td>
					<td class="lbf">难以入睡</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq44"
						value="0" id="sclq44_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq44"
						value="1" id="sclq44_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq44"
						value="2" id="sclq44_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq44"
						value="3" id="sclq44_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq44"
						value="4" id="sclq44_5"></td>
				</tr>
				<tr>
					<td>45</td>
					<td class="lbf">做事必须反复检查</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq45"
						value="0" id="sclq45_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq45"
						value="1" id="sclq45_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq45"
						value="2" id="sclq45_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq45"
						value="3" id="sclq45_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq45"
						value="4" id="sclq45_5"></td>
				</tr>
				<tr>
					<td>46</td>
					<td class="lbf">难以做出决定</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq46"
						value="0" id="sclq46_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq46"
						value="1" id="sclq46_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq46"
						value="2" id="sclq46_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq46"
						value="3" id="sclq46_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq46"
						value="4" id="sclq46_5"></td>
				</tr>
				<tr>
					<td>47</td>
					<td class="lbf">怕乘电车公共汽车地铁或火车</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq47"
						value="0" id="sclq47_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq47"
						value="1" id="sclq47_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq47"
						value="2" id="sclq47_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq47"
						value="3" id="sclq47_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq47"
						value="4" id="sclq47_5"></td>
				</tr>
				<tr>
					<td>48</td>
					<td class="lbf">呼吸有困难</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq48"
						value="0" id="sclq48_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq48"
						value="1" id="sclq48_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq48"
						value="2" id="sclq48_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq48"
						value="3" id="sclq48_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq48"
						value="4" id="sclq48_5"></td>
				</tr>
				<tr>
					<td>49</td>
					<td class="lbf">一阵阵发冷或发热</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq49"
						value="0" id="sclq49_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq49"
						value="1" id="sclq49_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq49"
						value="2" id="sclq49_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq49"
						value="3" id="sclq49_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq49"
						value="4" id="sclq49_5"></td>
				</tr>
				<tr>
					<td>50</td>
					<td class="lbf">因为感到害怕而避开某些东西场合或活动</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq50"
						value="0" id="sclq50_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq50"
						value="1" id="sclq50_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq50"
						value="2" id="sclq50_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq50"
						value="3" id="sclq50_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq50"
						value="4" id="sclq50_5"></td>
				</tr>
				<tr>
					<td>51</td>
					<td class="lbf">脑子变空了</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq51"
						value="0" id="sclq51_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq51"
						value="1" id="sclq51_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq51"
						value="2" id="sclq51_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq51"
						value="3" id="sclq51_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq51"
						value="4" id="sclq51_5"></td>
				</tr>
				<tr>
					<td>52</td>
					<td class="lbf">身体发麻或刺痛</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq52"
						value="0" id="sclq52_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq52"
						value="1" id="sclq52_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq52"
						value="2" id="sclq52_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq52"
						value="3" id="sclq52_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq52"
						value="4" id="sclq52_5"></td>
				</tr>
				<tr>
					<td>53</td>
					<td class="lbf">喉咙有梗塞感</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq53"
						value="0" id="sclq53_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq53"
						value="1" id="sclq53_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq53"
						value="2" id="sclq53_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq53"
						value="3" id="sclq53_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq53"
						value="4" id="sclq53_5"></td>
				</tr>
				<tr>
					<td>54</td>
					<td class="lbf">感到前途没有希望</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq54"
						value="0" id="sclq54_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq54"
						value="1" id="sclq54_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq54"
						value="2" id="sclq54_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq54"
						value="3" id="sclq54_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq54"
						value="4" id="sclq54_5"></td>
				</tr>
				<tr>
					<td>55</td>
					<td class="lbf">不能集中注意力</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq55"
						value="0" id="sclq55_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq55"
						value="1" id="sclq55_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq55"
						value="2" id="sclq55_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq55"
						value="3" id="sclq55_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq55"
						value="4" id="sclq55_5"></td>
				</tr>
				<tr>
					<td>56</td>
					<td class="lbf">感到身体的某一部分软弱无力</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq56"
						value="0" id="sclq56_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq56"
						value="1" id="sclq56_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq56"
						value="2" id="sclq56_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq56"
						value="3" id="sclq56_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq56"
						value="4" id="sclq56_5"></td>
				</tr>
				<tr>
					<td>57</td>
					<td class="lbf">感到紧张或容易紧张</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq57"
						value="0" id="sclq57_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq57"
						value="1" id="sclq57_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq57"
						value="2" id="sclq57_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq57"
						value="3" id="sclq57_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq57"
						value="4" id="sclq57_5"></td>
				</tr>
				<tr>
					<td>58</td>
					<td class="lbf">感到手或脚发重</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq58"
						value="0" id="sclq58_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq58"
						value="1" id="sclq58_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq58"
						value="2" id="sclq58_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq58"
						value="3" id="sclq58_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq58"
						value="4" id="sclq58_5"></td>
				</tr>
				<tr>
					<td>59</td>
					<td class="lbf">想到死亡的事</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq59"
						value="0" id="sclq59_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq59"
						value="1" id="sclq59_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq59"
						value="2" id="sclq59_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq59"
						value="3" id="sclq59_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq59"
						value="4" id="sclq59_5"></td>
				</tr>
				<tr>
					<td>60</td>
					<td class="lbf">吃得太多</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq60"
						value="0" id="sclq60_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq60"
						value="1" id="sclq60_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq60"
						value="2" id="sclq60_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq60"
						value="3" id="sclq60_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq60"
						value="4" id="sclq60_5"></td>
				</tr>
				<tr>
					<td>61</td>
					<td class="lbf">当别人看着您或谈论您时感到不自在</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq61"
						value="0" id="sclq61_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq61"
						value="1" id="sclq61_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq61"
						value="2" id="sclq61_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq61"
						value="3" id="sclq61_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq61"
						value="4" id="sclq61_5"></td>
				</tr>
				<tr>
					<td>62</td>
					<td class="lbf">有一些不属于您自己的想法</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq62"
						value="0" id="sclq62_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq62"
						value="1" id="sclq62_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq62"
						value="2" id="sclq62_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq62"
						value="3" id="sclq62_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq62"
						value="4" id="sclq62_5"></td>
				</tr>
				<tr>
					<td>63</td>
					<td class="lbf">有想打人或伤害他人的冲动</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq63"
						value="0" id="sclq63_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq63"
						value="1" id="sclq63_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq63"
						value="2" id="sclq63_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq63"
						value="3" id="sclq63_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq63"
						value="4" id="sclq63_5"></td>
				</tr>
				<tr>
					<td>64</td>
					<td class="lbf">醒得太早</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq64"
						value="0" id="sclq64_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq64"
						value="1" id="sclq64_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq64"
						value="2" id="sclq64_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq64"
						value="3" id="sclq64_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq64"
						value="4" id="sclq64_5"></td>
				</tr>
				<tr>
					<td>65</td>
					<td class="lbf">必须反复洗手点数</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq65"
						value="0" id="sclq65_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq65"
						value="1" id="sclq65_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq65"
						value="2" id="sclq65_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq65"
						value="3" id="sclq65_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq65"
						value="4" id="sclq65_5"></td>
				</tr>
				<tr>
					<td>66</td>
					<td class="lbf">睡得不稳不深</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq66"
						value="0" id="sclq66_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq66"
						value="1" id="sclq66_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq66"
						value="2" id="sclq66_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq66"
						value="3" id="sclq66_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq66"
						value="4" id="sclq66_5"></td>
				</tr>
				<tr>
					<td>67</td>
					<td class="lbf">有想摔坏或破坏东西的想法</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq67"
						value="0" id="sclq67_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq67"
						value="1" id="sclq67_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq67"
						value="2" id="sclq67_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq67"
						value="3" id="sclq67_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq67"
						value="4" id="sclq67_5"></td>
				</tr>
				<tr>
					<td>68</td>
					<td class="lbf">有一些别人没有的想法</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq68"
						value="0" id="sclq68_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq68"
						value="1" id="sclq68_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq68"
						value="2" id="sclq68_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq68"
						value="3" id="sclq68_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq68"
						value="4" id="sclq68_5"></td>
				</tr>
				<tr>
					<td>69</td>
					<td class="lbf">感到对别人神经过敏</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq69"
						value="0" id="sclq69_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq69"
						value="1" id="sclq69_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq69"
						value="2" id="sclq69_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq69"
						value="3" id="sclq69_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq69"
						value="4" id="sclq69_5"></td>
				</tr>
				<tr>
					<td>70</td>
					<td class="lbf">在商店或电影院等人多的地方感到不自在</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq70"
						value="0" id="sclq70_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq70"
						value="1" id="sclq70_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq70"
						value="2" id="sclq70_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq70"
						value="3" id="sclq70_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq70"
						value="4" id="sclq70_5"></td>
				</tr>
				<tr>
					<td>71</td>
					<td class="lbf">感到任何事情都很困难</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq71"
						value="0" id="sclq71_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq71"
						value="1" id="sclq71_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq71"
						value="2" id="sclq71_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq71"
						value="3" id="sclq71_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq71"
						value="4" id="sclq71_5"></td>
				</tr>
				<tr>
					<td>72</td>
					<td class="lbf">一阵阵恐惧或惊恐</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq72"
						value="0" id="sclq72_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq72"
						value="1" id="sclq72_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq72"
						value="2" id="sclq72_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq72"
						value="3" id="sclq72_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq72"
						value="4" id="sclq72_5"></td>
				</tr>
				<tr>
					<td>73</td>
					<td class="lbf">感到公共场合吃东西很不舒服</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq73"
						value="0" id="sclq73_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq73"
						value="1" id="sclq73_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq73"
						value="2" id="sclq73_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq73"
						value="3" id="sclq73_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq73"
						value="4" id="sclq73_5"></td>
				</tr>
				<tr>
					<td>74</td>
					<td class="lbf">经常与人争论</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq74"
						value="0" id="sclq74_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq74"
						value="1" id="sclq74_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq74"
						value="2" id="sclq74_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq74"
						value="3" id="sclq74_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq74"
						value="4" id="sclq74_5"></td>
				</tr>
				<tr>
					<td>75</td>
					<td class="lbf">单独一人时神经很紧张</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq75"
						value="0" id="sclq75_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq75"
						value="1" id="sclq75_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq75"
						value="2" id="sclq75_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq75"
						value="3" id="sclq75_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq75"
						value="4" id="sclq75_5"></td>
				</tr>
				<tr>
					<td>76</td>
					<td class="lbf">别人对您的成绩没有做出恰当的评价</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq76"
						value="0" id="sclq76_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq76"
						value="1" id="sclq76_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq76"
						value="2" id="sclq76_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq76"
						value="3" id="sclq76_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq76"
						value="4" id="sclq76_5"></td>
				</tr>
				<tr>
					<td>77</td>
					<td class="lbf">即使和别人在一起也感到孤单</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq77"
						value="0" id="sclq77_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq77"
						value="1" id="sclq77_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq77"
						value="2" id="sclq77_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq77"
						value="3" id="sclq77_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq77"
						value="4" id="sclq77_5"></td>
				</tr>
				<tr>
					<td>78</td>
					<td class="lbf">感到坐立不安心神不定</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq78"
						value="0" id="sclq78_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq78"
						value="1" id="sclq78_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq78"
						value="2" id="sclq78_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq78"
						value="3" id="sclq78_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq78"
						value="4" id="sclq78_5"></td>
				</tr>
				<tr>
					<td>79</td>
					<td class="lbf">感到自己没有什么价值</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq79"
						value="0" id="sclq79_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq79"
						value="1" id="sclq79_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq79"
						value="2" id="sclq79_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq79"
						value="3" id="sclq79_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq79"
						value="4" id="sclq79_5"></td>
				</tr>
				<tr>
					<td>80</td>
					<td class="lbf">感到熟悉的东西变成陌生或不像是真的</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq80"
						value="0" id="sclq80_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq80"
						value="1" id="sclq80_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq80"
						value="2" id="sclq80_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq80"
						value="3" id="sclq80_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq80"
						value="4" id="sclq80_5"></td>
				</tr>
				<tr>
					<td>81</td>
					<td class="lbf">大叫或摔东西</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq81"
						value="0" id="sclq81_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq81"
						value="1" id="sclq81_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq81"
						value="2" id="sclq81_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq81"
						value="3" id="sclq81_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq81"
						value="4" id="sclq81_5"></td>
				</tr>
				<tr>
					<td>82</td>
					<td class="lbf">害怕会在公共场合晕倒</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq82"
						value="0" id="sclq82_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq82"
						value="1" id="sclq82_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq82"
						value="2" id="sclq82_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq82"
						value="3" id="sclq82_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq82"
						value="4" id="sclq82_5"></td>
				</tr>
				<tr>
					<td>83</td>
					<td class="lbf">感到别人想占您的便宜</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq83"
						value="0" id="sclq83_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq83"
						value="1" id="sclq83_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq83"
						value="2" id="sclq83_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq83"
						value="3" id="sclq83_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq83"
						value="4" id="sclq83_5"></td>
				</tr>
				<tr>
					<td>84</td>
					<td class="lbf">为一些有关性的想法而很苦恼</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq84"
						value="0" id="sclq84_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq84"
						value="1" id="sclq84_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq84"
						value="2" id="sclq84_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq84"
						value="3" id="sclq84_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq84"
						value="4" id="sclq84_5"></td>
				</tr>
				<tr>
					<td>85</td>
					<td class="lbf">您认为应该因为自己的过错而受到惩罚</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq85"
						value="0" id="sclq85_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq85"
						value="1" id="sclq85_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq85"
						value="2" id="sclq85_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq85"
						value="3" id="sclq85_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq85"
						value="4" id="sclq85_5"></td>
				</tr>
				<tr>
					<td>86</td>
					<td class="lbf">感到要很快把事情做完</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq86"
						value="0" id="sclq86_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq86"
						value="1" id="sclq86_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq86"
						value="2" id="sclq86_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq86"
						value="3" id="sclq86_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq86"
						value="4" id="sclq86_5"></td>
				</tr>
				<tr>
					<td>87</td>
					<td class="lbf">感到自己的身体有问题</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq87"
						value="0" id="sclq87_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq87"
						value="1" id="sclq87_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq87"
						value="2" id="sclq87_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq87"
						value="3" id="sclq87_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq87"
						value="4" id="sclq87_5"></td>
				</tr>
				<tr>
					<td>88</td>
					<td class="lbf">从未感到和其他人很亲近</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq88"
						value="0" id="sclq88_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq88"
						value="1" id="sclq88_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq88"
						value="2" id="sclq88_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq88"
						value="3" id="sclq88_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq88"
						value="4" id="sclq88_5"></td>
				</tr>
				<tr>
					<td>89</td>
					<td class="lbf">感到自己有罪</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq89"
						value="0" id="sclq89_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq89"
						value="1" id="sclq89_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq89"
						value="2" id="sclq89_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq89"
						value="3" id="sclq89_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq89"
						value="4" id="sclq89_5"></td>
				</tr>
				<tr>
					<td>90</td>
					<td class="lbf">感到自己的脑子有毛病</td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq90"
						value="0" id="sclq90_1"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq90"
						value="1" id="sclq90_2"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq90"
						value="2" id="sclq90_3"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq90"
						value="3" id="sclq90_4"></td>
					<td class="lb_option"><input class="common_checkbox" type="radio" name="sclq90"
						value="4" id="sclq90_5"></td>
				</tr>
</tbody>
			</table>
			  <div class="paper_paging"> 
    共<span id="rows_number"></span>题
  <span id="spanFirst">第一页</span> 
  <button id="spanPre">上一页</button> 
  <button id="spanNext">下一页</button> 
  <span id="spanLast">最后一页</span> 第<span id="spanPageNum"></span>页/共<span id="spanTotalPage"></span>页
  </div>
   <div class="answer_progress">
  <ul><li class="symbol_li" id="sclq1_symbol">	1</li>
<li class="symbol_li" id="sclq2_symbol">	2</li>
<li class="symbol_li" id="sclq3_symbol">	3</li>
<li class="symbol_li" id="sclq4_symbol">	4</li>
<li class="symbol_li" id="sclq5_symbol">	5</li>
<li class="symbol_li" id="sclq6_symbol">	6</li>
<li class="symbol_li" id="sclq7_symbol">	7</li>
<li class="symbol_li" id="sclq8_symbol">	8</li>
<li class="symbol_li" id="sclq9_symbol">	9</li>
<li class="symbol_li" id="sclq10_symbol">	10</li>
<li class="symbol_li" id="sclq11_symbol">	11</li>
<li class="symbol_li" id="sclq12_symbol">	12</li>
<li class="symbol_li" id="sclq13_symbol">	13</li>
<li class="symbol_li" id="sclq14_symbol">	14</li>
<li class="symbol_li" id="sclq15_symbol">	15</li>
<li class="symbol_li" id="sclq16_symbol">	16</li>
<li class="symbol_li" id="sclq17_symbol">	17</li>
<li class="symbol_li" id="sclq18_symbol">	18</li>
<li class="symbol_li" id="sclq19_symbol">	19</li>
<li class="symbol_li" id="sclq20_symbol">	20</li>
<li class="symbol_li" id="sclq21_symbol">	21</li>
<li class="symbol_li" id="sclq22_symbol">	22</li>
<li class="symbol_li" id="sclq23_symbol">	23</li>
<li class="symbol_li" id="sclq24_symbol">	24</li>
<li class="symbol_li" id="sclq25_symbol">	25</li>
<li class="symbol_li" id="sclq26_symbol">	26</li>
<li class="symbol_li" id="sclq27_symbol">	27</li>
<li class="symbol_li" id="sclq28_symbol">	28</li>
<li class="symbol_li" id="sclq29_symbol">	29</li>
<li class="symbol_li" id="sclq30_symbol">	30</li>
<li class="symbol_li" id="sclq31_symbol">	31</li>
<li class="symbol_li" id="sclq32_symbol">	32</li>
<li class="symbol_li" id="sclq33_symbol">	33</li>
<li class="symbol_li" id="sclq34_symbol">	34</li>
<li class="symbol_li" id="sclq35_symbol">	35</li>
<li class="symbol_li" id="sclq36_symbol">	36</li>
<li class="symbol_li" id="sclq37_symbol">	37</li>
<li class="symbol_li" id="sclq38_symbol">	38</li>
<li class="symbol_li" id="sclq39_symbol">	39</li>
<li class="symbol_li" id="sclq40_symbol">	40</li>
<li class="symbol_li" id="sclq41_symbol">	41</li>
<li class="symbol_li" id="sclq42_symbol">	42</li>
<li class="symbol_li" id="sclq43_symbol">	43</li>
<li class="symbol_li" id="sclq44_symbol">	44</li>
<li class="symbol_li" id="sclq45_symbol">	45</li>
<li class="symbol_li" id="sclq46_symbol">	46</li>
<li class="symbol_li" id="sclq47_symbol">	47</li>
<li class="symbol_li" id="sclq48_symbol">	48</li>
<li class="symbol_li" id="sclq49_symbol">	49</li>
<li class="symbol_li" id="sclq50_symbol">	50</li>
<li class="symbol_li" id="sclq51_symbol">	51</li>
<li class="symbol_li" id="sclq52_symbol">	52</li>
<li class="symbol_li" id="sclq53_symbol">	53</li>
<li class="symbol_li" id="sclq54_symbol">	54</li>
<li class="symbol_li" id="sclq55_symbol">	55</li>
<li class="symbol_li" id="sclq56_symbol">	56</li>
<li class="symbol_li" id="sclq57_symbol">	57</li>
<li class="symbol_li" id="sclq58_symbol">	58</li>
<li class="symbol_li" id="sclq59_symbol">	59</li>
<li class="symbol_li" id="sclq60_symbol">	60</li>
<li class="symbol_li" id="sclq61_symbol">	61</li>
<li class="symbol_li" id="sclq62_symbol">	62</li>
<li class="symbol_li" id="sclq63_symbol">	63</li>
<li class="symbol_li" id="sclq64_symbol">	64</li>
<li class="symbol_li" id="sclq65_symbol">	65</li>
<li class="symbol_li" id="sclq66_symbol">	66</li>
<li class="symbol_li" id="sclq67_symbol">	67</li>
<li class="symbol_li" id="sclq68_symbol">	68</li>
<li class="symbol_li" id="sclq69_symbol">	69</li>
<li class="symbol_li" id="sclq70_symbol">	70</li>
<li class="symbol_li" id="sclq71_symbol">	71</li>
<li class="symbol_li" id="sclq72_symbol">	72</li>
<li class="symbol_li" id="sclq73_symbol">	73</li>
<li class="symbol_li" id="sclq74_symbol">	74</li>
<li class="symbol_li" id="sclq75_symbol">	75</li>
<li class="symbol_li" id="sclq76_symbol">	76</li>
<li class="symbol_li" id="sclq77_symbol">	77</li>
<li class="symbol_li" id="sclq78_symbol">	78</li>
<li class="symbol_li" id="sclq79_symbol">	79</li>
<li class="symbol_li" id="sclq80_symbol">	80</li>
<li class="symbol_li" id="sclq81_symbol">	81</li>
<li class="symbol_li" id="sclq82_symbol">	82</li>
<li class="symbol_li" id="sclq83_symbol">	83</li>
<li class="symbol_li" id="sclq84_symbol">	84</li>
<li class="symbol_li" id="sclq85_symbol">	85</li>
<li class="symbol_li" id="sclq86_symbol">	86</li>
<li class="symbol_li" id="sclq87_symbol">	87</li>
<li class="symbol_li" id="sclq88_symbol">	88</li>
<li class="symbol_li" id="sclq89_symbol">	89</li>
<li class="symbol_li" id="sclq90_symbol">	90</li>
  </ul>
  </div>
		</div>
		<div class="end_of_paper">
			<button onclick="scl90save()" style="font-size: 20px;">&nbsp;暂&nbsp;存&nbsp;</button>&nbsp;
			<button onclick="scl90submit()" style="font-size: 20px;">&nbsp;提&nbsp;交&nbsp;</button>&nbsp;
			<button style="font-size: 20px;">&nbsp;下&nbsp;载&nbsp;</button>&nbsp;
			<button style="font-size: 20px;">&nbsp;打&nbsp;印&nbsp;</button>

		</div>
		<fieldset class="instruct">
			<legend>指导语</legend>
			下面有90条测验项目，列出了有些人可能会有的问题，请仔细地阅读每一条，然后根据最近一星期以内，
			您的实际感觉，选择适合的答案点击，请注意不要漏题。
		</fieldset>
	</div>
	<script type="text/javascript"
		src="<c:url value='/resource/js/common.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/resource/js/xljz/paper.js'/>"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			var basicInfo = listArr[currIdx];
			//设置头部基本信息
			$("#crimName").html(basicInfo.crimName);
			$("#crimNo").html(basicInfo.crimNo);
			$("#testTime").html(formatDate(basicInfo.lastModif,'yyyy-MM-dd'));
			$("#prison").html(basicInfo.prisonName);
			$("#subPrison").html(basicInfo.subPrisonName);
			$("#modifierName").html(basicInfo.cop1Name);

			//获取做题记录并恢复
			getTestNote(basicInfo.taskId, function(data) {
				if (isEmpty(data)) {
					return;
				}

				var jsonData = jQuery.parseJSON(data);
				$.each(jsonData.answer, function(index, content) {
					setRadioSelected(content.name, content.val);
					//$("#"+content.name).parent().parent().find(".lbf").css("background", " #7accf8");
				});
				$(":checked").parent("td").css("background", "#ffff80");
			    /* $(":checked").parent().parent().find(".lbf").css("background", " #7accf8"); */
			    $(':checked').each(function(){
			    	$("#"+$(this).attr('name')+"_symbol").addClass("has_done");
			    });		
			});

		});

		$("#crimNo").click(function(event) {
			getCrimDetails();
		});
	</script>
</body>
</html>