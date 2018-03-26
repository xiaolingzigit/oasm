$.ajaxSetup({
	cache: false //关闭AJAX相应的缓存
});

//格式化时间方法
function timeStamp2String(time){  
    var datetime = new Date();  
    datetime.setTime(time);  
    var year = datetime.getFullYear();  
    var month = datetime.getMonth() + 1 < 10 ? "0" + (datetime.getMonth() + 1) : datetime.getMonth() + 1;  
    var date = datetime.getDate() < 10 ? "0" + datetime.getDate() : datetime.getDate();  
    var hour = datetime.getHours()< 10 ? "0" + datetime.getHours() : datetime.getHours();  
    var minute = datetime.getMinutes()< 10 ? "0" + datetime.getMinutes() : datetime.getMinutes();  
    var second = datetime.getSeconds()< 10 ? "0" + datetime.getSeconds() : datetime.getSeconds();  
    return year + "-" + month + "-" + date+" "+hour+":"+minute+":"+second;
}  
var pageNum=1;
var pageSize = 1;
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
    
    
    //*********************************统一搜索框******************************************

	//出监结构访谈搜索器
	$("#cjjgft_ss_btn").click(function(){
		goPage(1,psize,"cjjgft");
	});
	//出监行为观察搜索器
	$("#cjgc_ss_btn").click(function(){
		goPage(1,psize,"cjrcgc");
	});

	
	//*******************************统一搜索器完成**************************************
});

//获取出监结构访谈数据，放到cj_jgft.jsp页面表格中
function cj_jgft_DataList(gyjq,qh,xm,jhxm,ftzt){
	$.ajax({
		url:"/oasm/dafxView/cjftView_json",
		async:false,
		data:{'num':pageNum,'size':psize,gyjq:gyjq,qh:qh,xm:xm,jhxm:jhxm,ftzt:ftzt},
		dataType:"JSON",
		type:"post",
		success:function(data){
			var tb = ""; //表示追加表格内容
			var count = 1;//序号
			var zt="";//状态
			var cz="";//操作
			var scores=0; //总分
			if(data.cjftvp.length==0){			
				tb+="<tr>";
				tb+="<td colspan='9'>"+nodatatie+"</td>";
				tb+="</tr>";
			}else{
			$.each(data.cjftvp,function(k,v){ //不要调用错传的参数
				//使用js定义两个路径
				var clikrs = "\"/oasm/dafxView/cj_jgftrs?qh="+v.crimNo+"&&ftfs="+v.score+"&&ftsj="+v.lastModif+"\"";
				var cliklb = "\""+v.taskId+"\",\"/oasm/dafxView/cj_jgftlb?qh="+v.crimNo+"\"";
				if(v.status>1){
					zt="已完成"; //状态
					cz="<a href='#' onclick='loadCjftrs(\""+v.taskId+"\","+clikrs+")'>查看详情</a>"; //操作
				}else if(v.status==1){
					zt="未完成";
					cz="<div class='addbutton2' onclick='loadCjftlb("+cliklb+")'>行为观察</div>";
				}
				if(v.score==null){
					scores=0;
				}else{
					scores = v.score;
				}
				
				//表格内容
//				count = k+1;
				count= (pageNum-1)*psize+k+1;
				count = (pageNum-1)*pageSize+1+k;
				tb+="<tr>";
				tb+="<td>"+count+"</td>";
				tb+="<td>"+v.crimNo+"</td>";
				tb+="<td>"+v.xm+"</td>";
				tb+="<td>"+v.gyjq+"</td>";
				tb+="<td>"+timeStamp2String(v.lastModif)+"</td>";
				tb+="<td>"+scores+"</td>";
				tb+="<td>"+v.jhxm+"</td>";
				tb+="<td>"+zt+"</td>";
				tb+="<td>"+cz+"</td>";
				tb+="</tr>";
			});
			}
			$("#cj_jgft_tableData").html(tb); //数据放到出监结构访谈表格数据中
			pageSize = data.page.pageSize;
			pages = data.page.pages;
			total = data.page.total;
			$("#pageSize").html(pageSize);
		 	$("#pages").html(pages);
		}
	});
	
}

//获取出监行为观察数据，放到cj_rcgc.jsp页面表格中
function cj_rcgc_DataList(gyjq,qh,xm,jhxm,gczt){
	$.ajax({
		url:"/oasm/dafxView/cjgcView_json",
		async:false,
		data:{'num':pageNum,'size':psize,gyjq:gyjq,qh:qh,xm:xm,jhxm:jhxm,gczt:gczt},
		dataType:"JSON",
		type:"post",
		success:function(data){
			var tb = ""; //表示追加表格内容
			var count = 1;//序号
			var zt="";//状态
			var cz="";//操作
			var scores=0; //总分
			if(data.cjgcvp.length==0){			
				tb+="<tr>";
				tb+="<td colspan='9'>"+nodatatie+"</td>";
				tb+="</tr>";
			}else{
			$.each(data.cjgcvp,function(k,v){
				//使用js定义两个路径
				var clikrs = "\"/oasm/dafxView/cj_rcgcrs?qh="+v.crimNo+"&&gcfs="+v.score+"&&gcsj="+v.lastModif+"\"";
				var cliklb = "\""+v.taskId+"\","+v.crimNo+",\"/oasm/dafxView/cj_rcgclb?qh="+v.crimNo+"\"";
				if(v.status>1){
					zt="已完成"; //状态
					cz="<a href='#' onclick='loadCjgcrs(\""+v.taskId+"\","+clikrs+")'>查看详情</a>"; //操作
				}else if(v.status==1){
					zt="未完成";
					cz="<div class='addbutton2' onclick='loadCjgclb("+cliklb+")'>行为观察</div>";
				}
				if(v.score==null){
					scores=0;
				}else{
					scores = v.score;
				}
				
				//表格内容
//				count = k+1;
				count= (pageNum-1)*psize+k+1;
				count = (pageNum-1)*pageSize+1+k;
				tb+="<tr>";
				tb+="<td>"+count+"</td>";
				tb+="<td>"+v.crimNo+"</td>";
				tb+="<td>"+v.xm+"</td>";
				tb+="<td>"+v.gyjq+"</td>";
				tb+="<td>"+timeStamp2String(v.lastModif)+"</td>";
				tb+="<td>"+scores+"</td>";
				tb+="<td>"+v.jhxm+"</td>";
				tb+="<td>"+zt+"</td>";
				tb+="<td>"+cz+"</td>";
				tb+="</tr>";
			});
			}
			$("#cj_rcgc_tableData").html(tb); //把数据放到表格中
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
	
	if(clazz=="cjjgft"){
		var gyjq = $("#cjft_ss_selected").val();
		var qh = $("#cjftqh").val().trim();
		var xm = $("#cjftxm").val().trim();
		var jhxm = $("#cjftjhxm").val().trim();
		var ftzt = $("#cjjgft_ss_radio input[type='radio']:checked").val();
		cj_jgft_DataList(gyjq,qh,xm,jhxm,ftzt); //出监结构访谈表格数据
	}
	if(clazz=="cjrcgc"){
		var gyjq = $("#cjgc_ss_selected").val();
		var qh = $("#cjgcqh").val().trim();
		var xm = $("#cjgcxm").val().trim();
		var jhxm = $("#cjgcjhxm").val().trim();
		var gczt = $("#cjgc_ss_radio input[type='radio']:checked").val();
		cj_rcgc_DataList(gyjq,qh,xm,jhxm,gczt);//出监行为观察表格数据
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
