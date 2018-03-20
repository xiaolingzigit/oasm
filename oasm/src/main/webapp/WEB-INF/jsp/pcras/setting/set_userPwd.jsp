<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>个人信息</title>
</head>
<body>
	<!-- 密码重置 -->
				<div class="option_table3">
								<div class="sub_item">
				<div class="bg_item_title">密码修改</div>
				<div class="bg_sub_line"></div>		
				<div class="userinfo_tb">
				<table style="margin:0 auto;width:60%;">
				<colgroup>
				<col width="32%">
				<col width="68%">
				</colgroup>
						<tr>
							<td  class="xx_td01">
								<font color="#ffffff">输入原密码:</font>
							</td>
							<td width="8%">
								<input type="text"  name="yuan_ma" onblur="check_yuanma()" />
							    <i id="yuan_ma_success"></i>
							    <i id="yuan_ma_error" title="密码不正确"></i>
							</td>
						</tr>
						<tr>
							<td  class="xx_td01">
								<font color="#ffffff">更改密码:</font>
							</td>
							<td >
								<input type="password" name="new_ma" onblur="new_ma_check()" />
								<i id="new_ma_success"></i>
							    <i id="new_ma_warning" title="密码不符合"></i>
							</td>
						</tr>
						<tr>
							<td class="xx_td01">
								<font color="#ffffff">确认密码:</font>
							</td>
							<td>
								<input type="password" onblur="comfir_ma_check()" name="comfir_ma" />
							    <i id="comfir_ma_success"></i>
							    <i id="comfir_ma_error" title="两次密码不一致"></i>
							</td>
						</tr>
						<tr>
							<td colspan="2" style="text-align: center;">
								<!-- <a href="#" onclick="loadnext2('pggl/mmcz')">
									密码重置
								</a> -->
								<button onclick="check_succes_ma()" class="button_submit" >密码提交</button>
							</td>
						</tr>
				</table>
				</div>
				</div>
				</div>
</body>
</html>