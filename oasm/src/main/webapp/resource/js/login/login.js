$.ajaxSetup({
	cache: false //关闭AJAX相应的缓存
});

$(function(){
	$("#loginSub").click(function(){
		var jh = $("input[name='jh']").val();
		var ma = $("input[name='ma']").val();
		
		var uJh = /^[0-9]{7}$/;  //匹配7位数警号
		
		var uPassword = /^(\w){3,20}$/;  //匹配密码。英文、数字、下划线
		
		if(uJh.test(jh)==false){
			//<span style="color:red;margin-left: 150px;">*用户名不正确</span>
			$("#loginInfo").replaceWith("<span id='falseUser' style='color:red;margin-left: 150px;'>*用户名为7位数警号</span>");
		}else if(uPassword.test(ma)==false){
			//防止输入了账号不输入密码
			$("#loginInfo").replaceWith("<span style='color:red;margin-left: 20px;'>*密码为3-16位英文、数字、下划线组合</span>");
			$("#falseUser").replaceWith("<span style='color:red;margin-left: 20px;'>*密码为3-16位英文、数字、下划线组合</span>");
		}else{
			$("#loginInfo").remove();
			$("#falseUser").remove();
//			$.ajax({
//				url:"/oasm/jyxx/checkMa",
//				type:"post",
//				dataTYpe:"JSON",
//				data:{jh:jh},
//				success:function(i){
//					if(i<1){
//						$("#loginBlank").replaceWith("<span style='color:red;margin-left: 150px;'>*用户不存在</span>");
//					}else{
						$.ajax({
							url:"/oasm/login/loginCheck",
							dataType:"JSON",
							type:"post",
							data:$("#loginForm").serialize(),
							success:function(i){
								if(i<1){
									$("#loginManager").replaceWith("<span style='color:red;margin-left: 150px;'>*用户名或密码错误</span>");
								}else{
									location.href="/oasm/home/main";
//									alert("登录成功");
								}
							}
						});
//					}
				}
			});
//		}
//	});
});

