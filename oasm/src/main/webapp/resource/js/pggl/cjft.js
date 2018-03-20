//出监访谈导入excel文件，出监观察导入excel文件，之后所有操作都在这里
//出监访谈导入excel文件
$(function(){
	$("#cjftfileBtn").click(function(){
		var fileDir = getPath(document.getElementById("cjftfile"));
		alert(fileDir);
		var suffix = fileDir.substr(fileDir.lastIndexOf("."));
		if(""==fileDir){
			$("#cjftrepleaceSpan").replaceWith("<span id='cjftspanError' style='color:red'>未选择文件</span>");
		}else if(".xls"!=suffix && ".xlsx"!=suffix){
			$("#cjftspanError").replaceWith("<span style='color:red'>选择文件必须为.xls格式 或 .xlsx格式</span>");
			$("#cjftrepleaceSpan").replaceWith("<span style='color:red'>选择文件必须为.xls格式 或 .xlsx格式</span>");
		}else{
		   $.ajax({
			  url:"/oasm/excelView/cjftfileRead", 
			  type:"post",
			  dataType:"JSON",
			  data:{file:fileDir},
			  success:function(data){
				  alert("aaa");
			  }
		   });
		}
	});
});

//出监观察导入excel文件
$(function(){
	$("#cjgcfileBtn").click(function(){
		var fileDir = getPath(document.getElementById("cjgcfile"));
		alert(fileDir);
		var suffix = fileDir.substr(fileDir.lastIndexOf("."));
		if(""==fileDir){
			$("#cjgcrepleaceSpan").replaceWith("<span id='cjgcspanError' style='color:red'>未选择文件</span>");
		}else if(".xls"!=suffix && ".xlsx"!=suffix){
			$("#cjgcspanError").replaceWith("<span style='color:red'>选择文件必须为.xls格式 或 .xlsx格式</span>");
			$("#cjgcrepleaceSpan").replaceWith("<span style='color:red'>选择文件必须为.xls格式 或 .xlsx格式</span>");
		}else{
		   $.ajax({
			  url:"/oasm/excelView/cjgcfileRead", 
			  type:"post",
			  dataType:"JSON",
			  data:{file:fileDir},
			  success:function(data){
				  alert("aaa");
			  }
		   });
		}
	});
});


//公用获取浏览器获取安全路径方法
function getPath(obj) {
	 if (obj) {
	  if (window.navigator.userAgent.indexOf("MSIE") >= 1) {
	   obj.select();
	   return document.selection.createRange().text;
	  } else if (window.navigator.userAgent.indexOf("Firefox") >= 1) {
	   if (obj.files) {
	    return obj.files.item(0).getAsDataURL();
	   }
	   return obj.value;
	  }
	  return obj.value;
	 }
	}