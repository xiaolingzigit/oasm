	//修改密码操作username_update_password
	//验证原始密码
	function checkLastPwd(){
		var username = $(".strong_username").html();
		var password = $("#admin_last_password").val();
		//ajax在回调函数不是返回而是赋值
		var admin_a=0;
		$.ajax({
		  url:"/oasm/systemAdmin/check_last_pwd",
		  type:"post",
		  async: false, //在使用了ajax回调函数的情况加上
		  dataType:"JSON",
		  data:{username:username,password:password},
		  success:function(i){
			 
			 if(i==1){
				 $("#last_pwd_error").css('display','none');
				 $("#last_pwd_success").css('display','block');
				return (admin_a=1);
				 
			 }else{
				 $("#last_pwd_success").css('display','none');
				 $("#last_pwd_error").css('display','block');
				 $("#admin_last_password").val("");
			 }
		  }
		});
		return admin_a;
	}
	//验证新密码
	function checkNewPwd(){
		var NewPassowrd = $("#admin_next_password").val();
		var pawd=/^[a-zA-Z0-9_-]{4,16}$/; //4到16位（字母，数字，下划线，减号）
		if(pawd.test(NewPassowrd)==false){
			 $("#new_pwd_success").css('display','none');
			 $("#new_pwd_error").css('display','block');
			 $("#admin_next_password").val("");
			 return 0;
		}else{
			 $("#new_pwd_error").css('display','none');
			 $("#new_pwd_success").css('display','block');
			 return 1;
		}
		
	}
	//验证确认密码
	function checkComformPwd(){
		var password = $("#admin_comform_passowrd").val();
		var NewPassowrd = $("#admin_next_password").val();
		
		if(NewPassowrd!=password){
			 $("#comform_pwd_success").css('display','none');
			 $("#comform_pwd_error").css('display','block');
			 $("#admin_comform_passowrd").val("");
			 return 0;
		}else{
			$("#comform_pwd_error").css('display','none');
			$("#comform_pwd_success").css('display','block');
			return 1;
			}
	}

   //所有的条件满足之后执行修改密码操作
	$(function(){
		$("#admin_newpwd_btn").click(function(){
			var username = $(".strong_username").html(); //用户名
			var password = $("#admin_comform_passowrd").val(); //修改的密码
			
 			var a =checkLastPwd();
 			var b =checkNewPwd();
 			var c =checkComformPwd();
 			
			if(a==1){
				if(b==1){
					if(c==1){
						//成功执行修改密码操作
						$.ajax({
							 url:"/oasm/systemAdmin/username_update_password",
							 type:"post",
							 dataType:"JSON",
							 data:{username:username,password:password},
							 success:function(i){
								 if(i==1){
									 alert("密码已修改，自动返回到登录页面");
									 window.location.href="/oasm/systemAdmin/adminLogin";
								 }else{
									 alert("修改异常");
								 }
							 }
						});
					}
				}
				
			}else{
				 $("#last_pwd_success").css('display','none');
				 $("#last_pwd_error").css('display','block');
				$("#new_pwd_success").css('display','none');
				 $("#new_pwd_error").css('display','block');
				$("#comform_pwd_success").css('display','none');
				 $("#comform_pwd_error").css('display','block');
			}
		});
	});
	
	//超级管理员给管理员修改密码
	
//操作日志加分
//var pageNum=1;
//var pageSize = 20;
//var total = 1;//总记录数
//var pages = 1;//总页数
//var psize=10;//每页的数量
//var clazz="";
//var find="";//搜索内容
//
//$(function(){
//	$("#firstPage").click(function(){ 
//		$("#prePage").addClass("ban");
//	    $("#firstPage").addClass("ban"); 
//		if(pageNum==1){
//		}else{
//	        goPage(1,psize,clazz); 
//	        $("#nextPage").removeClass("ban");
//	    	$("#lastPage").removeClass("ban");
//		}
//    });
//    
//    $("#lastPage").click(function(){
////		console.info("lastPage "+pageNum+"----"+pages)
//        if(pageNum==pages){
//        }else{
//        	goPage(pages,psize,clazz); 
//        	$("#nextPage").addClass("ban");    
//    	    $("#lastPage").addClass("ban");
//    	    $("#firstPage").removeClass("ban");    
//    	    $("#prePage").removeClass("ban");
//        }
//    });
//    
//    $("#prePage").click(function(){  
//    	if(pageNum>1){
//    		if(pageNum-1 == 1){
//    	    	$("#firstPage").addClass("ban");    
//        	    $("#prePage").addClass("ban");
//    	    }
//	        goPage(pageNum-1,psize,clazz);    
//	    	$("#nextPage").removeClass("ban");
//	    	$("#lastPage").removeClass("ban");
//    	}else{
//    		$("#firstPage").addClass("ban");    
//    	    $("#prePage").addClass("ban");
//    	}
//    });
//    $("#nextPage").click(function(){
////     	console.info("pageNum "+pageNum+" nextPage "+pages+" psize "+psize);
//    	if(pageNum<pages){
//    		if(pageNum+1 == 10){
//    			$("#nextPage").addClass("ban");    
//    			$("#lastPage").addClass("ban");
//    		}
//    		goPage(pageNum+1,psize,clazz); 
//    		$("#firstPage").removeClass("ban");    
//    		$("#prePage").removeClass("ban");
//    		
//    	}else{
//    		$("#nextPage").addClass("ban");    
//    		$("#lastPage").addClass("ban");
//    	}
//    });
//});
//
//
// function adminLog(createBy,description,createDate){
//	 $.ajax({
//			url:"/oasm/systemAdmin/logInof", 
//			dataType:"JSON",
//			type:"post",
//			async:false,
//			data:{pageNum:pageNum,pageSize:pageSize,createBy:createBy,description:description,createDate:createDate},
//			success:function(result){
//				var td = "";
//				var count = 0;
//				console.info(result.info.length);
//				if(result.info.length>0){
//					$.each(result.info,function(l,g){
//						 count = (pageNum-1)*pageSize+1+l;
//						 td+="<tr>";
//						 td+="<td>"+count+"</td>";
//						 td+="<td>"+g.description+"</td>";
//						 td+="<td>"+g.method+"</td>";
//						 td+="<td>"+g.params+"</td>";
//						 td+="<td>"+g.requireIP+"</td>";
//						 td+="<td>"+g.createBy+"</td>";
//						 td+="<td>"+g.createDate+"</td>";
//						 td+="</tr>";
//					  });
//				}else{
//					 td+="<tr>";
//					 td+="<td>无数据</td>";
//					 td+="<td>...</td>";
//					 td+="<td>...</td>";
//					 td+="<td>...</td>";
//					 td+="<td>...</td>";
//					 td+="<td>...</td>";
//					 td+="<td>无数据</td>";
//					 td+="</tr>";
//				}
//			    $("#sysLogData").html(td);
//			    pageSize = result.page.pageSize;
//				pages = result.page.pages;
//				total = result.page.total;
//				$("#pageSize").html(pageSize);
//			 	$("#pages").html(pages);
//			}
//		});
// }
// 
// function goPage(pageNum1,psize1,clazz1){
//		psize=psize1;
//		pageNum=pageNum1;
//		clazz=clazz1;
//		$("#pageNum").html(pageNum);
//		
//		if(clazz=="adminLog"){
//			var createBy = $("#createBy").val().trim();
//			var description = $("#description").val().trim();
//			var createDate = $("#createDate").val().trim();
//			adminLog(createBy,description,createDate);
//		}
//		
//		//记录数据
//		var tempStr = "共"+total+"条记录 当前"+pageNum+"/"+pages+"页";    
//	    document.getElementById("barcon1").innerHTML = tempStr;    
////	    console.info(tempStr);
//	    
//	    //下拉
//	    var tempOption="";    
//	    for(var i=1;i<=pages;i++)    
//	    {    
//	        tempOption+='<option value='+i+'>'+i+'</option>'    
//	    }    
//	    $("#jumpWhere").html(tempOption);    
//	    $("#jumpWhere").val(pageNum);  
// }
// 
////跳转
// function jumpPage()    
// {    
//     var num=parseInt($("#jumpWhere").val());    
//     if(num!=pageNum)    
//     {    
//         goPage(num,pageSize,clazz);    
//     }    
// }
// //页面分页调用
// $(function(){
//		goPage(1,20,"adminLog"); 
//});
//
// //日志搜索器
// function logReach(){
//	 goPage(1,psize,"adminLog"); 
// }