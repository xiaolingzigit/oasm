//初始化加载页面
$(function() {
		$('#basecontent').load("/oasm/settingView/set_userInfo");		
	});
	$('#option li').click(function (event) {
		$(this).addClass('option_li_current').siblings().removeClass('option_li_current');
		switch ($(this).attr("id")) {

			case 'set_userInfo': //个人信息
				$("#basecontent").load("/oasm/settingView/set_userInfo");
				break;
			case "set_userPwd"://密码修改
				$("#basecontent").load("/oasm/settingView/set_userPwd");
				break;
		}
	});


//******************************自己修改密码操作*****************************
//验证原密码
function check_yuanma(){
	var ma = $("input[name='yuan_ma']").val();
    var ma_a=0;
	$.ajax({
		url:"/oasm/jyxx/beforePasswordCheck",
		dataType:"JSON",
		type:"post",
		 async: false, //在使用了ajax回调函数的情况加上
		data:{ma:ma},
		success:function(i){
		  if(i==1){
			  $("#yuan_ma_error").removeClass('iconcancel');
			  $("#yuan_ma_success").addClass('iconok');
			  return (ma_a=1);
		  }else{
			  $("#yuan_ma_success").removeClass('iconok');
			  $("#yuan_ma_error").addClass('iconcancel');
			  $("input[name='yuan_ma']").val("");
		  }
		}
	});
	return ma_a;
}
//新密码验证
function new_ma_check(){
	var newma = $("input[name='new_ma']").val();
	var uPassword = /^(\w){3,20}$/;  //匹配密码。英文、数字、下划线
	
	if(uPassword.test(newma)==false){
		$("#new_ma_success").removeClass('iconok');
		$("#new_ma_warning").addClass('iconcancel');
		$("input[name='new_ma']").val("");
		return 0;
	}else{
		$("#new_ma_warning").removeClass('iconcancel');
		$("#new_ma_success").addClass('iconok');
		return 1;
	}
}
//确认密码验证
function comfir_ma_check(){
	var newma = $("input[name='new_ma']").val();
	var comfirma = $("input[name='comfir_ma']").val();
		
	if(newma!=comfirma){
		$("#comfir_ma_success").removeClass("iconok");
		$("#comfir_ma_error").addClass("iconcancel");
		$("input[name='comfir_ma']").val("");
		return 0;
	}else{
		$("#comfir_ma_error").removeClass("iconcancel");	
	    $("#comfir_ma_success").addClass("iconok");
	    return 1;
	}
}

function check_succes_ma(){
	var ma = $("input[name='comfir_ma']").val();
	
	var a = check_yuanma();
	var b = new_ma_check();
	var c = comfir_ma_check();
	
	if(a==1){
		if(b==1){
			if(c==1){
				$.ajax({
					url:"/oasm/jyxx/updateCerrurMa",
					dataType:"JSON",
					type:"post",
					data:{ma:ma},
					success:function(i){
						if(i==1){
							alert("修改密码成功，三秒后跳转到登录页面");
							window.location.href="/oasm/login/login";
						}else{
							alert("修改失败");
						}
					}
				});
			}
		}
	}else{
		$("#yuan_ma_success").removeClass('iconok');
		$("#yuan_ma_error").addClass('iconcancel');
		$("#new_ma_success").removeClass('iconok');
		$("#new_ma_warning").addClass('iconcancel');
		$("#comfir_ma_success").removeClass("iconok");
		$("#comfir_ma_error").addClass("iconcancel");
	}
	
}
