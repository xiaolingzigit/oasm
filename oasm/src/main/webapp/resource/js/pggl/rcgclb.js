$(function(){
	$("#xwfileBtn").click(function(){
		var fileDir = getPath(document.getElementById("xwfile"));
		var suffix = fileDir.substr(fileDir.lastIndexOf("."));
		if(""==fileDir){
			$("#xwrepleaceSpan").replaceWith("<span id='xwspanError' style='color:red'>未选择文件</span>");
		}else if(".xls"!=suffix && ".xlsx"!=suffix){
			$("#xwspanError").replaceWith("<span style='color:red'>选择文件必须为.xls格式 或 .xlsx格式</span>");
			$("#xwrepleaceSpan").replaceWith("<span style='color:red'>选择文件必须为.xls格式 或 .xlsx格式</span>");
		}else{
		   $.ajax({
			  url:"/oasm/excelView/xwfileRead", 
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