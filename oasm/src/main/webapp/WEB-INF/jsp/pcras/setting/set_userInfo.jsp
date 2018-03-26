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
	<!--个人信息管理 -->
	<div class="option_table3">
		<div class="sub_item">
			<div class="bg_item_title">基本信息</div>
			<div class="bg_sub_line"></div>
			<div class="userinfo_tb">
				<table>
					<colgroup>
						<col width="30%">
						<col width="18%">
						<col width="52%">
					</colgroup>
					<tr>
						<td rowspan="5"><img
							src="<c:url value='/resource/images/police_icon2.jpg'/>"
							width="100%"></td>
						<td class="title_td">警号：</td>
						<td><span>${jh }</span></td>
					</tr>
					<tr>
						<td class="title_td">姓名：</td>
						<td><span>${xm }</span></td>
					</tr>
					<tr>
						<td class="title_td">职务：</td>
						<td><span>${zw }</span></td>
					</tr>
					<tr>
						<td class="title_td">负责监区：</td>
						<td><span id="user_jq">${jq }</span></td>
					</tr>
					<tr>
						<td class="title_td">负责罪犯：</td>
						<td><span id="user_criminal">${cnum }</span>人</td>
					</tr>
				</table>
			</div>
		</div>
		<div class="sub_item">
			<div class="bg_item_title">其他信息</div>
			<div class="bg_sub_line"></div>
			<div class="userinfo_tb">
				<table width="100%" id="other_info">
					<col width="18%">
					<col width="32%">
					<col width="18%">
					<col width="32%">
					<tr>
						<td class="title_td">出生年月：</td>
						<td><span id="user_birth"></span> <input type="text"
							id="modify_birth" class="edit_model"
							onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" /> <fmt:formatDate
								type="date" value="${jyxx.sr }" /></td>
						<td class="title_td">联系电话：</td>
						<td><span id="user_mobile"></span><input type="text"
							id="modify_mobile" class="edit_model" />${jyxx.dh }</td>
					</tr>
					<tr>
						<td class="title_td">电子邮箱：</td>
						<td colspan="3"><span id="user_email"></span><input
							type="text" id="modify_email" class="edit_model" />${jyxx.dzyj }</td>
					</tr>
					<tr>
						<td class="title_td">通讯地址：</td>
						<td colspan="3"><span id="user_addr"></span><input
							type="text" id="modify_email" class="edit_model" />${jyxx.dz }</td>
					</tr>
				</table>
				<!-- <button id="modify_info">编辑</button> -->
				<button id="modify_cancel" class="edit_model">取消</button>
				<button id="modify_save" class="edit_model">保存</button>
			</div>
		</div>

		<div class="sub_item">
			<div class="bg_item_title">安全信息</div>
			<div class="bg_sub_line"></div>
			<div class="userinfo_tb">
				<table width="100%">
					<colgroup>
						<col width="20%">
						<col width="80%">
					</colgroup>
					<tr>
						<td class="title_td">上次登录时间：</td>
						<td><span id="user_lastlogin"></span>
						<fmt:formatDate type="date" value="${jyxx.scdlsj }" /></td>
					</tr>
					<tr>
						<td class="title_td">密码：</td>
						<td><button id="set_pwd">修改</button></td>
					</tr>
				</table>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$("#modify_info").click(function() {
			$("#other_info span").each(function() {
				$(this).next().val($(this).html());
			});
			$("#other_info span").addClass("edit_model");
			$("#other_info input").removeClass("edit_model");
			$("#modify_save").removeClass("edit_model");
			$("#modify_cancel").removeClass("edit_model");
			$(this).addClass("edit_model");
		});
		$("#modify_save").click(function() {
			$("#other_info input").each(function() {
				$(this).prev().html($(this).val());
			});
			$("#other_info input").addClass("edit_model");
			$("#other_info span").removeClass("edit_model");
			$("#modify_info").removeClass("edit_model");
			$("#modify_cancel").addClass("edit_model");
			$(this).addClass("edit_model");
		});
		$("#modify_cancel").click(function() {
			$("#other_info input").addClass("edit_model");
			$("#other_info span").removeClass("edit_model");
			$("#modify_info").removeClass("edit_model");
			$("#modify_save").addClass("edit_model");
			$(this).addClass("edit_model");
		});
		$('#set_pwd').click(
				function(event) {
					$('#set_userPwd').addClass('option_li_current').siblings()
							.removeClass('option_li_current');
					$("#basecontent").load("/oasm/settingView/set_userPwd");

				});
	</script>
</body>
</html>