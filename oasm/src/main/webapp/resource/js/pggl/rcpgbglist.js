$.ajaxSetup({
	cache: false //关闭AJAX相应的缓存
});
var pageNum=1;
var pageSize = 10;
var total = 1;//总记录数
var pages = 1;//总页数
var psize=10;//每页的数量
var clazz="";
var find="";//搜索内容
var nodatatie="<div class='not_data'>暂无数据</div>";//无查询结果的提示
$(function(){
	$("#firstPage").click(function(){ 
		$("#prePage").addClass("ban");
	    $("#firstPage").addClass("ban"); 
		if(pageNum==1){
		}else{
	        goPage(1,psize,clazz); 
	        $("#nextPage").removeClass("ban");
	    	$("#lastPage").removeClass("ban");
		}
    });
    
    $("#lastPage").click(function(){
//		console.info("lastPage "+pageNum+"----"+pages)
        if(pageNum==pages){
        }else{
        	goPage(pages,psize,clazz); 
        	$("#nextPage").addClass("ban");    
    	    $("#lastPage").addClass("ban");
    	    $("#firstPage").removeClass("ban");    
    	    $("#prePage").removeClass("ban");
        }
    });
    
    $("#prePage").click(function(){  
    	if(pageNum>1){
    		if(pageNum-1 == 1){
    	    	$("#firstPage").addClass("ban");    
        	    $("#prePage").addClass("ban");
    	    }
	        goPage(pageNum-1,psize,clazz);    
	    	$("#nextPage").removeClass("ban");
	    	$("#lastPage").removeClass("ban");
    	}else{
    		$("#firstPage").addClass("ban");    
    	    $("#prePage").addClass("ban");
    	}
    });
    
    $("#nextPage").click(function(){
//     	console.info("pageNum "+pageNum+" nextPage "+pages+" psize "+psize);
    	if(pageNum<pages){
    		if(pageNum+1 == 10){
    	    	$("#nextPage").addClass("ban");    
        	    $("#lastPage").addClass("ban");
    	    }
    		goPage(pageNum+1,psize,clazz); 
	    	$("#firstPage").removeClass("ban");    
    	    $("#prePage").removeClass("ban");
    	    
    	}else{
    		$("#nextPage").addClass("ban");    
    	    $("#lastPage").addClass("ban");
    	}
    });
    

 // *********************************统一搜索框******************************************
      //日常报告
      $("#rcpg_ss_btn").click(function(){
     	 goPage(1, psize, "rcpgbg");
      });
	//*******************************统一搜索器完成**************************************
});

//日常评估报告
function rcpgList(gyjq,qh,xm,jhxm,eval,stat){
	$.ajax({
		url:"/oasm/pgbgView/getViewPgbg",
		type:"post",
		async:false,
		dataType:"JSON",
		data:{pageNum : pageNum,pageSize : pageSize,type : 'dyRep',
			gyjq:gyjq,qh:qh,xm:xm,jhxm:jhxm,eval:eval,stat:stat},
		success:function(data){
			var a = '';
			var count = 1;//序号
			if(null!=data.page.result){
				$.each(data.page.result,function(k,v){
					count=(pageNum-1)*pageSize+1+k;
					var st = '';
					switch (v.status) {
					// 1未开始，2锁定中，3暂存，4已完成(不能再编辑)，10已取消
					case 1:
						st = "未开始";
						break;
					case 2:
						st = "锁定中";
						break;
					case 3:
						st = "暂存";
						break;
					case 4:
						st = "已完成";
						break;
					case 10:
						st = "已取消";
						break;
					}

					a += "<tr>";
					a += "<td>" + count + "</td>";// 当前行号
					a += "<td style='display:none'>"+ v.taskId + "</td>";// 任务id
					a += "<td>" + v.crimNo + "</td>";// 囚号
					a += "<td>" + v.xm + "</td>";// 姓名
					a += "<td>" + v.gyjqmc + "</td>";// 监区
					if(null==v.score){
						a += "<td>无</td>";// 分数
					}else{
						a += "<td>" + v.score + "</td>";// 分数
					}
					if(null==v.levl){
						a += "<td>无</td>";// 等级
					}else{
						a += "<td>" + v.levl + "</td>";// 等级
					}
					a += "<td>" + v.deadline + "</td>";// 完成期限
					a += "<td>" + v.lastModif + "</td>";// 最后修改时间
					// a+="<td>"+v.type+"</td>";//类型
					a += "<td>" + v.jhxm + "</td>";// 警察姓名
					a += "<td>" + v.xjxm + "</td>";// 协教姓名
					// a+="<td>"+v.stat+"</td>";//报告表状态
					a += "<td>" + st + "</td>";// 任务表状态
					var rcbgurl = "\"/oasm/pgbgsccxView/pgbg_rc?qh="+v.crimNo+"&&taskId="+v.taskId+"\""; //日常评估报告url
					if (v.status == 4) {
						a += "<td><a class='cs-a' onclick='loadrcbgPage(\""+v.status+"\",\""+v.taskId+"\","+rcbgurl+")'>查看报告</a></td></tr>";
					} else {
						a += "<td><a class='cs-a' onclick='loadrcbgPage(\""+v.status+"\",\""+v.taskId+"\","+rcbgurl+")'>查看进度</a></td></tr>";
					}
				});
			}else{
				a+="<tr>";
				a+="<td>无数据</td><td>...</td><td>...</td><td>...</td><td>...</td><td>...</td><td>...</td><td>...</td><td>...</td><td>...</td><td>...</td><td>无操作数据</td>";
				a+="</tr>";
			}
			
			$("#rcbglist").html(a);
			//分页
			pageSize = data.page.pageSize;
			pages = data.page.pages;
			total = data.page.total;
			$("#pageSize").html(pageSize);
		 	$("#pages").html(pages);
		
		}
	});
}

//区分每次进入的是那个页面
function goPage(pageNum1,psize1,clazz1){
	psize=psize1;
	pageNum=pageNum1;
	clazz=clazz1;
	$("#pageNum").html(pageNum);
	
	if(clazz=="rcpgbg"){
		var gyjq = $("#rcpg_ss_selected").val();
		var qh = $("#rcpgqh").val();
		var xm = $("#rcpgxm").val();
		var jhxm = $("#rcpgjc").val();
		var eval = $("#rcpg_ss_radio input[name='wxdj']:checked").val();
		var stat = $("#rcpg_ss_staRadio input[name='pgStatus']:checked").val();
		rcpgList(gyjq,qh,xm,jhxm,eval,stat);
	}
	//记录数据
	var tempStr = "共"+total+"条记录 当前"+pageNum+"/"+pages+"页";    
    document.getElementById("barcon1").innerHTML = tempStr;    
//    console.info(tempStr);
    
    //下拉
    var tempOption="";    
    for(var i=1;i<=pages;i++)    
    {    
        tempOption+='<option value='+i+'>'+i+'</option>'    
    }    
    $("#jumpWhere").html(tempOption);    
    $("#jumpWhere").val(pageNum);  
}

//跳转
function jumpPage()    
{    
    var num=parseInt($("#jumpWhere").val());    
    if(num!=pageNum)    
    {    
        goPage(num,pageSize,clazz);    
    }    
}


