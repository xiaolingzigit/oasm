<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>个人任务</title>
</head>
<body>
	<div id="dafxgztab" class="option_table3">
		<div id="" class="">
			<div>
				<div class="layer02">

					<h2>
						<font size="" color="#6699cc">开始档案分析</font>
					</h2>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<div style="margin: 0 auto; width: 400px; height: 100px;">
						<button class="button_submit" style="margin-top: 10px;">GO</button>

						<div id="upfilediv">
							<form id="upfileForm" method="POST" enctype="multipart/form-data">
								<span>文件上传</span> <input type="file" id="upfile" name="upfile" />
								<span id="repleacespan"></span>
							</form>
							<input type="button" value="提交选中文件" id="selectBtn"
								name="selectBtn" />
						</div>
					</div>

				</div>
			</div>

		</div>

	</div>
	<script type="text/javascript" src="<c:url value='/resource/js/grgzmb/grgzmb.js'/>"></script>
</body>
</html>
