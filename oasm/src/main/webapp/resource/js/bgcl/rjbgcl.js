$.ajaxSetup({
	cache: false //关闭AJAX相应的缓存
});

//格式化时间方法
function timeStamp2String(time) {
	var datetime = new Date();
	datetime.setTime(time);
	var year = datetime.getFullYear();
	var month = datetime.getMonth() + 1 < 10 ? "0" + (datetime.getMonth() + 1)
			: datetime.getMonth() + 1;
	var date = datetime.getDate() < 10 ? "0" + datetime.getDate() : datetime
			.getDate();
	var hour = datetime.getHours() < 10 ? "0" + datetime.getHours() : datetime
			.getHours();
	var minute = datetime.getMinutes() < 10 ? "0" + datetime.getMinutes()
			: datetime.getMinutes();
	var second = datetime.getSeconds() < 10 ? "0" + datetime.getSeconds()
			: datetime.getSeconds();
	return year + "-" + month + "-" + date + " " + hour + ":" + minute + ":"
			+ second;
}
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
     //入监报告处置跟踪
     $("#rjpg_ss_btn").click(function() {
	       goPage(1, psize, clazz);
      });
     //入监报告合议
     $("#rjpgHy_ss_btn").click(function() {
	       goPage(1, psize, clazz);
      });
     //入监报告危评意见
     $("#rjpgWp_ss_btn").click(function() {
	       goPage(1, psize, clazz);
      });
 
     
});


//*********************************统一跳转******************************************
//处置跟踪//合议//审批
function loadBgcl(url,id){
	$('#basecontent').load(url);
}





// 入监显示评估处置跟踪列表
function czgzList(gyjq,qh,xm,jhxm,eval,czgz,type) {
//	console.info('rjbgcl.js/function rjpgCzgzList');
//	console.info({pageNum : pageNum,pageSize : pageSize,type : 'inRep',
//		   gyjq:gyjq,qh:qh,xm:xm,jhxm:jhxm,eval:eval,stat:4,czgz:czgz,hy:0,wpyj:0});
//	
	$.ajax({
				url : "/oasm/pgbgView/listViewPgbgAndTCzsh",
				type : "post",
				async : false,
				dataType : "JSON",
				data : {pageNum : pageNum,pageSize : pageSize,type : type,
					   gyjq:gyjq,qh:qh,xm:xm,jhxm:jhxm,eval:eval,stat:4,czgz:czgz,hy:0,wpyj:0},
				success : function(data) {
//					console.info(data);
					var a = '';//填充
					var jd = '';//阶段
					if(data != null && null != data.result && "" != data.result){
						$.each(data.result,function(k, v) {
//							k = 1+k;
							k=(pageNum-1)*pageSize+1+k;
							a += "<tr>";
							a += "<td>" + k + "</td>";// 当前行号
							a += "<td  style='display: none'>"+ v.taskId + "</td>";// 任务id
							a += "<td>" + v.crimNo + "</td>";// 囚号
							a += "<td>" + v.xm + "</td>";// 姓名
							a += "<td>" + v.gyjqmc + "</td>";// 监区
							a += "<td>" + v.lastModif + "</td>";// 生成时间
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
							a += "<td>" + v.jhxm + "</td>";// 警察姓名
							
							//处理跳转连接
							switch (type){
								case "inRep":
									jd = 'rj';
									break;
								case "dyRep":
									jd = 'rc';
									break;
								case "mdRep":
									jd = 'zq';
									break;
								case "otRep":
									jd = 'cj';
									break;
							}
							
							if(v.tczsh != null && v.tczsh.czlrsj != null){
								a += "<td>已处置</td>";// 处置状态
								a += "<td><a href=\"#\" onclick=\"loadBgcl('/oasm/czgzView/"+jd+"_bgczrs?task_id=" +v.taskId+ "')\">查看详情</a></td>";
							}else{
								a += "<td>未处置</td>";// 处置状态
								a += "<td><div class=\"addbutton2\" onclick=\"loadBgcl('/oasm/czgzView/"+jd+"_bgczlr?task_id=" +v.taskId+ "')\">意见录入</div>";
							}
						});
						//赋值
						$("#ajax_rjczgz").html(a);
						
						pageSize = data.pageSize;
						pages = data.pages;
						total = data.total;
						$("#pageSize").html(pageSize);
					 	$("#pages").html(pages);
						
					}else{
						a+="<tr>";
						a+="<td colspan='10'>无数据</td>";
						a+="</tr>";
						$("#ajax_rjczgz").html(a);
					}
					
				}
			});
}


//入监显示评估合议列表
function hyList(gyjq,qh,xm,jhxm,eval,hy,type) {
//	console.info('rjbgcl.js/function rjpgHyList');
	$.ajax({
				url : "/oasm/pgbgView/listViewPgbgAndTCzsh",
				type : "post",
				async : false,
				dataType : "JSON",
				data : {pageNum : pageNum,pageSize : pageSize,type : type,
					   gyjq:gyjq,qh:qh,xm:xm,jhxm:jhxm,eval:eval,stat:4,czgz:1,hy:hy,wpyj:0},
				success : function(data) {
//					console.info(data);
					var a = '';
					var jd = '';//阶段
					if(data != null && data.result != null && data.result != ""){
						$.each(data.result,function(k, v) {
//							k = 1+k;
							k=(pageNum-1)*pageSize+1+k;
							a += "<tr>";
							a += "<td>" + k + "</td>";// 当前行号
							a += "<td  style='display: none'>"+ v.taskId + "</td>";// 任务id
							a += "<td>" + v.crimNo + "</td>";// 囚号
							a += "<td>" + v.xm + "</td>";// 姓名
							a += "<td>" + v.gyjqmc + "</td>";// 监区
							a += "<td>" + v.lastModif + "</td>";// 生成时间
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
							a += "<td>" + v.jhxm + "</td>";// 警察姓名
							
							//处理跳转连接
							switch (type){
								case "inRep":
									jd = 'rj';
									break;
								case "dyRep":
									jd = 'rc';
									break;
								case "mdRep":
									jd = 'zq';
									break;
								case "otRep":
									jd = 'cj';
									break;
							}
							
							if(v.tczsh != null && v.tczsh.jqshsj != null){
								a += "<td>已处置</td>";// 处置状态
								a += "<td><a href=\"#\" onclick=\"loadBgcl('/oasm/fyhyView/"+jd+"_bghyrs?task_id=" +v.taskId+ "')\">查看详情</a></td>";
							}else{
								a += "<td>未处置</td>";// 处置状态
								a += "<td><div class=\"addbutton2\" onclick=\"loadBgcl('/oasm/fyhyView/"+jd+"_bghylr?task_id=" +v.taskId+ "')\">意见录入</div>";
							}
							});
						//赋值
						$("#ajax_hy").html(a);
						pageSize = data.pageSize;
						pages = data.pages;
						total = data.total;
						$("#pageSize").html(pageSize);
					 	$("#pages").html(pages);
					}else{
						a+="<tr>";
						a+="<td colspan='10' >无数据</td>";
						a+="</tr>";
						$("#ajax_hy").html(a);
					}
					
				}
			});
}


//显示入监评估危评列表
function wpList(gyjq,qh,xm,jhxm,eval,wp,type) {
//	console.info('rjbgcl.js/function rjpgHyList');
	$.ajax({
				url : "/oasm/pgbgView/listViewPgbgAndTCzsh",
				type : "post",
				async : false,
				dataType : "JSON",
				data : {pageNum : pageNum,pageSize : pageSize,type : type,
					   gyjq:gyjq,qh:qh,xm:xm,jhxm:jhxm,eval:eval,stat:4,czgz:1,hy:1,wpyj:wp},
				success : function(data) {
//					console.info(data);
					var a = '';
					var jd = '';//阶段
					if(data != null && null != data.result && "" != data.result){
						$.each(data.result,function(k, v) {
//							k = 1+k;
							k=(pageNum-1)*pageSize+1+k;
							a += "<tr>";
							a += "<td>" + k + "</td>";// 当前行号
							a += "<td  style='display: none'>"+ v.taskId + "</td>";// 任务id
							a += "<td>" + v.crimNo + "</td>";// 囚号
							a += "<td>" + v.xm + "</td>";// 姓名
							a += "<td>" + v.gyjqmc + "</td>";// 监区
							a += "<td>" + v.lastModif + "</td>";// 生成时间
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
							a += "<td>" + v.jhxm + "</td>";// 警察姓名
							
							//处理跳转连接
							switch (type){
								case "inRep":
									jd = 'rj';
									break;
								case "dyRep":
									jd = 'rc';
									break;
								case "mdRep":
									jd = 'zq';
									break;
								case "otRep":
									jd = 'cj';
									break;
							}
							
							if(v.tczsh != null && v.tczsh.wpclsj != null){
								a += "<td>已处置</td>";// 处置状态
								a += "<td><a href=\"#\" onclick=\"loadBgcl('/oasm/fyhyView/"+jd+"_bghyrs?task_id=" +v.taskId+ "')\">查看详情</a></td>";
							}else{
								a += "<td>未处置</td>";// 处置状态
								a += "<td><div class=\"addbutton2\" onclick=\"loadBgcl('/oasm/fyhyView/"+jd+"_bghylr?task_id=" +v.taskId+ "')\">意见录入</div>";
							}
						});
						
						//赋值
						$("#ajax_wpyj").html(a);
						
						pageSize = data.pageSize;
						pages = data.pages;
						total = data.total;
						$("#pageSize").html(pageSize);
					 	$("#pages").html(pages);
						
					}else{
						a+="<tr>";
						a+="<td colspan='10'>无数据</td>";
						a+="</tr>";
						$("#ajax_wpyj").html(a);
					}
					
				}
			});
}



//条件
function goPage(pageNum1, psize1, clazz1) {
	psize=psize1;
	pageNum=pageNum1;
	clazz=clazz1;
	$("#pageNum").html(pageNum);
	
	var jd = clazz.substring(0,2);	//阶段
	var type = clazz.substring(2);	//报告类型

	//处置跟踪
	if (jd == "cz") {
		var gyjq = $("#rjpg_ss_selected").val();
		var qh = $("#rjpgqh").val();
		var xm = $("#rjpgxm").val();
		var jhxm = $("#rjpgjc").val();
		var eval = $("#rjpg_ss_radio input[name='wxdj']:checked").val();
		var czgz = $("#rjpg_ss_radio input[name='czgz']:checked").val();//处置情况
		czgzList(gyjq,qh,xm,jhxm,eval,czgz,type);  
	}
	//合议
	if (jd == "hy") {
		var gyjq = $("#rjpgHy_ss_selected").val();
		var qh = $("#rjpgHyqh").val();
		var xm = $("#rjpgHyxm").val();
		var jhxm = $("#rjpgHyjc").val();
		var eval = $("#rjpgHy_ss_radio input[name='wxdj']:checked").val();
		var hy = $("#rjpgHy_ss_radio input[name='hy']:checked").val();//合议情况
		hyList(gyjq,qh,xm,jhxm,eval,hy,type);  
	}
	//危评
	if (jd == "wp") {
		var gyjq = $("#rjpgWp_ss_selected").val();
		var qh = $("#rjpgWpqh").val();
		var xm = $("#rjpgWpxm").val();
		var jhxm = $("#rjpgWpjc").val();
		var eval = $("#rjpgWp_ss_radio input[name='wxdj']:checked").val();
		var wp = $("#rjpgWp_ss_radio input[name='wp']:checked").val();//危评情况
		wpList(gyjq,qh,xm,jhxm,eval,wp,type);  
	}
	
	
	// 记录数据
	var tempStr = "共" + total + "条记录 当前" + pageNum + "/" + pages + "页";
	document.getElementById("barcon1").innerHTML = tempStr;
	// console.info(tempStr);

	// 下拉
	var tempOption = "";
	for (var i = 1; i <= pages; i++) {
		tempOption += '<option value=' + i + '>' + i + '</option>'
	}
	$("#jumpWhere").html(tempOption);
	$("#jumpWhere").val(pageNum);
}

//跳转
function jumpPage() {
	var num = parseInt($("#jumpWhere").val());
	if (num != pageNum) {
		goPage(num, pageSize, clazz);
	}
}
