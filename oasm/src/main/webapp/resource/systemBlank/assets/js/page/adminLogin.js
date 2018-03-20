function checkAdmin(){
  var username = $("#user").val();
	var password = $("#pwd").val();
	
	var uuid=/^[a-zA-Z\d]\w{3,11}[a-zA-Z\d]$/; //4-11个字符、不包含中文
	
	var pawd=/^[a-zA-Z0-9_-]{4,16}$/; //4到16位（字母，数字，下划线，减号）
	
	if(uuid.test(username)==false){
		$("#errorInfo").replaceWith("<p id='notUser' style='color:red;'>用户名不符合</p>");
	}else if(pawd.test(password)==false){
		$("#errorInfo").replaceWith("<p style='color:red;'>密码不符合</p>");
		$("#notUser").replaceWith("<p style='color:red;'>密码不符合</p>");
	}else{
		$.ajax({
			url:"/oasm/systemAdmin/adminCheck",
			dataType:"JSON",
			type:"post",
			data:{username:username,password:password},
			success:function(i){
				if(i<1){
					$("#errorInfo").replaceWith("<p style='color:red;'>密码不符合</p>");
				}else{
					window.location.href="/oasm/systemAdmin/adminBlank";
				}
			}
		});
	}

}
