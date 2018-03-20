<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>数据导入</title>
<!-- 使用了XHR请求子页面的script没法处理，使用append的方式 -->
<script type="text/javascript">
var head= document.getElementsByTagName('head')[0];
var script= document.createElement('script');
script.type= 'text/javascript';
script.src= "<c:url value='/resource/systemBlank/assets/js/page/dataInput.js'/>";
head.appendChild(script); 
</script>
</head>
<body>
  <!-- 延时加载样式 -->
  <div id = "test_mask_2" class="test_mask">
  </div>
  <!-- 延时加载完成 -->
  <ol class="breadcrumb">
		<li><a href="#">数据自动导入设置</a></li>
		<li class="active">时间设置</li>
  </ol>
  <div><input type="button" id="data_btn_input"  class="btn btn-default" value="启动囚犯量表配置"/></div>
  <div style="margin-left: 20px;">
    <form class="form-horizontal" role="form" enctype="multipart/form-data">
     <div class="form-group">
        <label class="sr-only" for="inputfile">文件输入</label>
        <input type="file" id="inputfile">
        <input type="button" class="btn btn-info" id="inputCPbtn" value="导入囚号与警察关系"/>
     </div>
    </form>
  </div>
  
  <!-- system modal start -->
	<div id="ycf-alert" class="modal">
		<div class="modal-dialog modal-sm">
			<div class="modal-content" style="width:600px;">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">×</span><span class="sr-only">Close</span>
					</button>
					<h5 class="modal-title">
						<i class="fa fa-exclamation-circle"></i> [Title]
					</h5>
				</div>
				<div class="modal-body small">
					<p>[Message]</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary ok"
						data-dismiss="modal">[BtnOk]</button>
					<button type="button" class="btn btn-default cancel"
						data-dismiss="modal">[BtnCancel]</button>
				</div>
			</div>
		</div>
	</div>
	<!-- system modal end -->
</body>
   
</html>