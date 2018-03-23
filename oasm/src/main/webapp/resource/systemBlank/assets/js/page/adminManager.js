//**********************************管理员操作部分*************************************************
//添加管理员前验证
function check_admin_add(){
	var username = $("#add_username").val();
	var uuid=/^[a-zA-Z\d]\w{3,11}[a-zA-Z\d]$/; //4-11个字符、不包含中文
	if(uuid.test(username)==false){
		alert("用户名为4-11个字符、不包含中文");
	}else{
	$.ajax({
	  url:"/oasm/systemAdmin/check_username_add",
	  type:"post",
	  dataType:"JSON",
	  data:{username:username},
	  success:function(i){
		 if(i==0){
			 $("#add_admin_info").replaceWith(" <span id='add_admin_error' style='color:green;' class='glyphicon glyphicon-ok'></span>");
		 }else{
			 $("#add_admin_info").replaceWith("<span  title='用户名已存在' style='color:red;' class='glyphicon glyphicon-remove'></span>");
			 $("#add_admin_error").replaceWith("<span title='用户名已存在' style='color:red;' class='glyphicon glyphicon-remove'></span>");
			 $("#add_username").val("");
		 }
	  }
	});
	}
}
//保存验证后的管理员
function add_admin_save(){
	var username = $("#add_username").val();
	var password = $("#add_passowrd").val();
	
	var pwd=/^[a-zA-Z0-9_-]{4,16}$/; //4到16位（字母，数字，下划线，减号）
	if(pwd.test(password)==false){
		$("#add_pwd_error").replaceWith("<p style='color:red;'>密码4到16位（字母，数字，下划线，减号）组成</p>");
	}else{
	  //调用添加管理员接口
		$.ajax({
			url:"/oasm/systemAdmin/add_admin_count",
			dataType:"JSON",
			type:"post",
			data:{username:username,password:password},
			success:function(i){
			  if(i==1){
				    alert("添加成功");
					$("#add_username").val("");
					$("#add_passowrd").val("");
//					window.close();
			  }else{
				  alert("添加失败");
			  }
			}
		});
	}
}
//**********************************分页部分****************************************************
var pageSize=0;//每页显示行数    
var currentPage_=1;//当前页全局变量，用于跳转时判断是否在相同页，在就不跳，否则跳转。    
function goPage(pno,psize){    
    var itable = document.getElementById("adminInfo");    
    var num = itable.rows.length;//表格所有行数(所有记录数)    
    
    pageSize = psize;//每页显示行数    
    //总共分几页     
    if(num/pageSize > parseInt(num/pageSize)){       
            totalPage=parseInt(num/pageSize)+1; 
       }else{       
           totalPage=parseInt(num/pageSize);       
       }       
    var currentPage = pno;//当前页数    
    currentPage_=currentPage;    
    var startRow = (currentPage - 1) * pageSize+1;     
    var endRow = currentPage * pageSize;    
        endRow = (endRow > num)? num : endRow;        
       //遍历显示数据实现分页    
    for(var i=1;i<(num+1);i++){        
        var irow = itable.rows[i-1];    
        if(i>=startRow && i<=endRow){    
            irow.style.display = "";        
        }else{    
            irow.style.display = "none";    
        }    
    }    
    var tempStr = "共"+num+"条记录 当前"+currentPage+"/"+totalPage+"页";    
     document.getElementById("barcon1").innerHTML = tempStr;    
    if(currentPage>1){    
        jQuery("#firstPage").on("click",function(){   
            goPage(1,psize);    
        }).removeClass("ban");    
        jQuery("#prePage").on("click",function(){    
            goPage(currentPage-1,psize);    
        }).removeClass("ban");       
    }else{    
        jQuery("#firstPage").off("click").addClass("ban");    
        jQuery("#prePage").off("click").addClass("ban");      
    }    
    
    if(currentPage<totalPage){    
        jQuery("#nextPage").on("click",function(){    
            goPage(currentPage+1,psize);    
        }).removeClass("ban")    
        jQuery("#lastPage").on("click",function(){    
            goPage(totalPage,psize);    
        }).removeClass("ban")    
    }else{    
        jQuery("#nextPage").off("click").addClass("ban");    
        jQuery("#lastPage").off("click").addClass("ban");    
    }       
    var tempOption="";    
    for(var i=1;i<=totalPage;i++)    
    {    
        tempOption+='<option value='+i+'>'+i+'</option>'    
    }    
    jQuery("#jumpWhere").html(tempOption);    
    jQuery("#jumpWhere").val(currentPage);    
}
    
    
function jumpPage()    
{    
    var num=parseInt(jQuery("#jumpWhere").val());    
    console.log(pageSize);    
    if(num!=currentPage_)    
    {    
        goPage(num,pageSize);    
    }    
}    
//调用分页的方法
$(function(){
	goPage(1,10);
});

//****************************分页结束*********************************
//******************************修改管理员信息部分***********************************
function update_by_superadmin(id,username){
	$("input[name='hide_admin_id']").val(id);
	$("#update_admincount_username").val(username);
	$("#adminInfo tr td a").attr("href","#modal-container-48510")
}
//检验账号-0-在用户框内容改变之后执行
function admincheck_count_checkuser(){
	var uname = $("#update_admincount_username").val();
	var uuid=/^[a-zA-Z\d]\w{3,11}[a-zA-Z\d]$/; //4-11个字符、不包含中文
	var check = 0;
	if(uuid.test(uname)==false){
		$("#admin_count_checksuccess").css('display','none');
	    $("#admin_count_checkexsist").css('display','none');
		$("#admin_count_checkerror").css('display','block');
		return check;
	}else{
		//先执行一次验证
		$.ajax({
		  url:"/oasm/systemAdmin/check_username_add",
		  dataType:"JSON",
		  type:"post",
		  async: false, //在使用了ajax回调函数需要返回的情况加上
		  data:{username:uname},
		  success:function(i){
			 if(i==1){
				 $("#admin_count_checkerror").css('display','none');
					$("#admin_count_checksuccess").css('display','none');
					$("#admin_count_checkexsist").css('display','block');
					return check;
			 }else{
				$("#admin_count_checkerror").css('display','none');
				$("#admin_count_checkexsist").css('display','none');
				$("#admin_count_checksuccess").css('display','block');
				return (check=1);
			 }
		  }
		});
		return check;
	}
	
}
//校验密码 --在密码框内容改变之后执行
function admincheck_count_checkpwd(){
	var pwd = $("#update_admincount_password").val();
	var pawd=/^[a-zA-Z0-9_-]{4,16}$/; //4到16位（字母，数字，下划线，减号）
	if(pawd.test(pwd)==false){
		$("#admin_pwd_checksuccess").css('display','none');
		$("#admin_pwd_checkerror").css('display','block');
		return 0;
	}else{
		$("#admin_pwd_checkerror").css('display','none');
		$("#admin_pwd_checksuccess").css('display','block');
		return 1;
	}
}


$(function(){
	
	//调用的方法
	$("#admin_count_update").click(function(){
	  var checka = admincheck_count_checkuser();
	  var checkb= admincheck_count_checkpwd();
	  
	//修改的属性
		var id = $("input[name='hide_admin_id']").val();
		var username = $("#update_admincount_username").val();
		var password = $("#update_admincount_password").val();
	  
	  alert("用户名"+id+" "+username+" "+password);
	  
	  if(checka==1){
		  if(checkb==1){
			  $.ajax({
				 url:"/oasm/systemAdmin/superAdmin_update_password",
				 dataType:"JSON",
				 type:"post",
				 data:{id:id,username:username,password:password},
				 success:function(i){
					 if(i==1){
						 alert("修改成功");
						 $("#update_admincount_username").val("");
						 $("#update_admincount_password").val("");
					 }else{
						 alert("修改异常");
					 }
				 }
			  });
		  }
	  }else{
		  $("#admin_count_checksuccess").css('display','none');
		  $("#admin_count_checkexsist").css('display','none');
		  $("#admin_count_checkerror").css('display','block');
		  $("#admin_pwd_checksuccess").css('display','none');
		  $("#admin_pwd_checkerror").css('display','block');
		  
	  }
	});
});

//********************************逻辑删除管理员部分**********************************
function delect_by_superadmin(id){
	if(!confirm("确认要删除？")){ 
		window.event.returnValue = false; 
	}else{
		$.ajax({
			url:"/oasm/systemAdmin/superAdmin_delete_password",
			dataType:"JSON",
			type:"post",
			data:{id:id},
			success:function(i){
				if(i==1){
					window.location.reload();
				}else{
					alert("删除失败");
				}
			}
			
		});
	}
}
