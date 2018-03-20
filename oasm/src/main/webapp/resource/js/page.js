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
    //入监档案分析搜索
    $("#rjss").click(function(){
    	goPage(1,psize,"rjdafx"); 
    });
    //入监结构访谈搜索器
    $("#rjft_ss_btn").click(function(){
    	goPage(1,psize,"rjjgft");
    });
    //入监观察搜索器
	$("#rjxwgc_ss_btn").click(function(){
		goPage(1,psize,"rjrcgc");
	});
	//日常行为观察搜索器
	$("#rcrcgc_ss_btn").click(function(){
		goPage(1,psize,"rcrcgc");
	});
	//中期结构访谈搜索器
	$("#zqjgft_ss_btn").click(function(){
		goPage(1,psize,"zqjgft");
	});
	//中期行为观察搜索器
	$("#zqgc_ss_btn").click(function(){
		goPage(1,psize,"zqrcgc");
	});
	//出监结构访谈搜索器
	$("#cjjgft_ss_btn").click(function(){
		goPage(1,psize,"cjjgft");
	});
	//出监行为观察搜索器
	$("#cjgc_ss_btn").click(function(){
		goPage(1,psize,"cjrcgc");
	});
	//集体访谈
	$("#vjtft_ss_btn").click(function(){
		goPage(1,psize,"vjtft");
	});
	
	//*******************************统一搜索器完成**************************************
});

//入监档案分析
function ajax_rj_dafx(qh,xm){
	$.ajax({
		url:"/oasm/dafxView/rj_dafx_json",
		async:false,
		type:"post",
		data:{num:pageNum,size:psize,qh:qh,xm:xm},//两个参数
		dataType:"JSON",
		success:function(data){
//			console.info(data.dafx);
			var t="";//表格内容
			var count = 1;//序号
			var gw="";//分数大于9为高危
//			var url1="loadnext3('/oasm/dafxView/rj_dafxrs')";
//			var url2="loadnext3('/oasm/dafxView/rj_dafxlb')";
			$.each(data.vdafx,function(k,v){
				var urlrs = "\"/oasm/dafxView/rj_dafxrs?qh="+v.qh+"&&fs="+v.score+"&&sj="+v.lastModif+"\""; //跳转到结果表页面
				var urllb = "\"/oasm/dafxView/rj_dafxlb?qh="+v.qh+"\""; //跳转到补充数据页面
				count=(pageNum-1)*pageSize+1+k;
				if(v.score>9){
					gw="高危"
				}else{gw="非高危"}
				t+="<tr>";
				t+="<td>"+count+"</td>";
				t+="<td>"+v.qh+"</td>";
				t+="<td>"+v.xm+"</td>";
				t+="<td>"+gw+"</td>";
				t+="<td id='datotall'>"+v.score+"</td>";
//				t+="<td><a  href='#' onclick = 'loadDafxrs(\""+v.jcdaid+"\","+urlrs+")' >查看当前</a><span class='fgline'>|</span><a  href='#' onclick = 'loadDafxlb(\""+v.jcdaid+"\","+urllb+")' >信息补充</a></td>";
				t+="<td><a  href='#' onclick = 'loadDafxrs(\""+v.taskId+"\","+urlrs+")' >查看详情</a>";
				t+="</tr>";
			});
			$("#adminTbody").html(t);
			pageSize = data.page.pageSize;
			pages = data.page.pages;
			total = data.page.total;
			$("#pageSize").html(pageSize);
		 	$("#pages").html(pages);
		}
	})
}

//集体访谈（rj_jtft.jsp）
function ajax_jtft(gyjq,qh,xm,jhxm,zt){
	console.info("rj_jtft.jsp#ajax_jtft");
	$.ajax({
		url:"/oasm/vjtftController/getVJtft",
		async:false,
		data:{'num':pageNum,'size':psize,gyjq:gyjq,qh:qh,xm:xm,jhxm:jhxm,zt:zt},
		dataType:"JSON",
		type:"post",
		success:function(data){
			var t="";//表格内容
			var count = 1;//序号
			var zt="";//状态
			var cz="";//操作
			var scores="";
//			console.info(data);
			//没有数据时报错
			if(data.jtft==null || data.page==null){
				return;
			}
				console.info(data.jtft);
			$.each(data.jtft,function(k,v){
				count = k+1;
				count= (pageNum-1)*psize+k+1;
				//跳转连接
				var clik = "{jtftid:\""+v.jtftid+"\",qh:\""+v.qh+"\",xm:\""+v.xm+"\",gyjq:\""+v.gyjq+"\",jh:\""+v.jh+"\",jhxm:\""+v.jhxm+"\"}"; //拼接地址jhxm
				if(Number(v.zt)==4){
					zt="已完成";
					cz="<a href='#' onclick='loadnext3(\"/oasm/dafxView/rj_jtftrs\")'>查看详情</a>"
//						cz="<a href='#' onclick='loadnext3(\"/oasm/dafxView/rj_jtftrs\")'>查看详情</a>"
				}else if(Number(v.zt)==1){
					zt="未访谈";
//					cz="<div class='addbutton2' onclick='loadDafxlb(\"/oasm/dafxView/rj_jtftlb\")'>开始访谈</div>";
					cz="<div class='addbutton2' onclick='loadDafxlb(\"/oasm\/dafxView\/rj_jtftlb\","+clik+")'>开始访谈</div>";
				};
				if(v.zfs==null){
					scores=0;
				}else{
					scores = v.zfs;
				}
				t+="<tr>";
				t+="<td>"+count+"</td>";
				t+="<td>"+v.qh+"</td>";
				t+="<td>"+v.xm+"</td>";
				t+="<td>"+v.gyjq+"</td>";
				t+="<td>"+timeStamp2String(v.sj)+"</td>";
				t+="<td>"+scores+"</td>";
				t+="<td>"+v.jhxm+"</td>";
				t+="<td>"+zt+"</td>";
				t+="<td>"+cz+"</td>";
				t+="</tr>";
			});
			$("#vjtft").html(t);
			pageSize = data.page.pageSize;
			pages = data.page.pages;
			total = data.page.total;
//			console.info(data.page);
			$("#pageSize").html(pageSize);
		 	$("#pages").html(pages);
		}
	})
}



//入监结构性访谈,放到rj_jgft.jsp页面中
function ajax_rj_jgft(gyjq,qh,xm,jhxm,fttype){
	$.ajax({
		url:"/oasm/dafxView/rj_jgft_json",
		async:false,
		data:{'num':pageNum,'size':psize,gyjq:gyjq,qh:qh,xm:xm,jhxm:jhxm,status:fttype},
		dataType:"JSON",
		type:"post",
		success:function(data){
			var t="";//表格内容
			var count = 1;//序号
			var zt="";//状态
			var cz="";//操作
			var scores="";
			if(data.viewrjjgft.length==0){			
				t+="<tr>";
				t+="<td colspan='9'>"+nodatatie+"</td>";
				t+="</tr>";
			}else{
			$.each(data.viewrjjgft,function(k,v){
				count = (pageNum-1)*pageSize+1+k;
				//跳转连接
				var clik = "\"/oasm/dafxView/rj_jgftrs?qh="+v.crimNo+"&&ftfs="+v.score+"&&ftsj="+v.lastModif+"\""; //拼接地址
				if(Number(v.status)>1){
					zt="已完成";
					cz="<a href='#' onclick='loadRjjgftRs(\""+v.taskId+"\","+clik+")'>查看详情</a>";
				}else if(Number(v.status)==1){
					zt="未完成";
					cz="<div class='addbutton2' onclick='loadRjjgft(\""+v.taskId+"\",\"/oasm/dafxView/rj_jgftlb?qh="+v.crimNo+"\")'>开始访谈</div>";
				};
				if(v.score==null){
					scores=0;
				}else{
					scores = v.score;
				}
				
				t+="<tr>";
				t+="<td>"+count+"</td>";
				t+="<td>"+v.crimNo+"</td>";
				t+="<td>"+v.xm+"</td>";
				t+="<td>"+v.gyjq+"</td>";
				t+="<td>"+timeStamp2String(v.lastModif)+"</td>";
				t+="<td>"+scores+"</td>";
				t+="<td>"+v.jhxm+"</td>";
				t+="<td>"+zt+"</td>";
				t+="<td>"+cz+"</td>";
				t+="</tr>";
			});}
			$("#rjjgft").html(t);
			pageSize = data.page.pageSize;
			pages = data.page.pages;
			total = data.page.total;
//			console.info(data.page);
			$("#pageSize").html(pageSize);
		 	$("#pages").html(pages);
		}
	})
}

//入监日常观察,放到rj_rcgc.jsp页面表格中
function ajax_rj_rcgc(gyjq,qh,xm,jhxm,gctype){
	$.ajax({
		url:"/oasm/dafxView/rj_rcgc_json",
		async:false,
		data:{'num':pageNum,'size':psize,gyjq:gyjq,qh:qh,xm:xm,jhxm:jhxm,gctype:gctype},
		dataType:"JSON",
		type:"post",
		success:function(data){
			var tb = ""; //表示追加表格内容
			var count = 1;//序号
			var zt="";//状态
			var cz="";//操作
			var scores="";
			if(data.viewrjxwgc.length==0){			
				tb+="<tr>";
				tb+="<td colspan='9'>"+nodatatie+"</td>";
				tb+="</tr>";
			}else{
			$.each(data.viewrjxwgc,function(k,v){
			   //
				var clik = "\"/oasm/dafxView/rj_rcgcrs?qh="+v.crimNo+"&&gcfs="+v.score+"&&gcsj="+v.lastModif+"\"";
				if(v.status>1){
					zt="已完成";
					cz="<a href='#' onclick='loadRjgcrs(\""+v.taskId+"\","+clik+")'>查看详情</a>";
				}else if(v.status==1){
					zt="未完成";
					//\"/oasm/dafxView/rj_rcgclb?qh=\"
					cz="<div class='addbutton2' onclick='loadRcgc(\""+v.taskId+"\","+v.crimNo+",\"/oasm/dafxView/rj_rcgclb?qh="+v.crimNo+"\")'>行为观察</div>";
				};
				if(v.score==null){
					scores=0;
				}else{
					scores = v.score;
				}
				//
				
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
			$("#rjjgft").html(tb);
			pageSize = data.page.pageSize;
			pages = data.page.pages;
			total = data.page.total;
			$("#pageSize").html(pageSize);
		 	$("#pages").html(pages);
		}
	})
}

//获取日常观察的列表数据，放到rc_rcgc.jsp页面表格中
function rc_rcgc_DataList(gyjq,qh,xm,jhxm,gczt){
	$.ajax({
		url:"/oasm/dafxView/rclrView_json",
		async:false,
		data:{'num':pageNum,'size':psize,gyjq:gyjq,qh:qh,xm:xm,jhxm:jhxm,gczt:gczt},
		dataType:"JSON",
		type:"post",
		success:function(data){
//			console.info(data.rcvp);
			var tb = ""; //表示追加表格内容
			var count = 1;//序号
			var zt="";//状态
			var cz="";//操作
			var scores=0; //总分
			if(data.rcvp.length==0){			
				tb+="<tr>";
				tb+="<td colspan='9'>"+nodatatie+"</td>";
				tb+="</tr>";
			}else{
			$.each(data.rcvp,function(k,v){
				//使用js定义两个路径
				var clikrs = "\"/oasm/dafxView/rc_rcgcrs?qh="+v.crimNo+"&&gcfs="+v.score+"&&gcsj="+v.lastModif+"\"";
				var cliklb = "\""+v.taskId+"\","+v.crimNo+",\"/oasm/dafxView/rc_rcgclb?qh="+v.crimNo+"\"";
				if(v.status>1){
					zt="已完成"; //状态
					cz="<a href='#' onclick='loadRcgcrs(\""+v.taskId+"\","+clikrs+")'>查看详情</a>"; //操作
				}else if(v.status==1){
					zt="未完成";
					cz="<div class='addbutton2' onclick='loadRcgclb("+cliklb+")'>行为观察</div>";
				}
				if(v.score==null){
					scores=0;
				}else{
					scores = v.score;
				}
				
				//表格内容
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
			$("#rc_rcgc_tableData").html(tb);
			pageSize = data.page.pageSize;
			pages = data.page.pages;
			total = data.page.total;
			$("#pageSize").html(pageSize);
		 	$("#pages").html(pages);
		}
	});
}

//获取中期结构访谈数据，放到zq_jgft.jsp表格中
function zq_jgft_DataList(gyjq,qh,xm,jhxm,ftzt){
	$.ajax({
		url:"/oasm/dafxView/zqftView_json",
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
			if(data.zqftvp.length==0){			
				tb+="<tr>";
				tb+="<td colspan='9'>"+nodatatie+"</td>";
				tb+="</tr>";
			}else{
			$.each(data.zqftvp,function(k,v){
				//使用js定义两个路径
				var clikrs = "\"/oasm/dafxView/zq_jgftrs?qh="+v.crimNo+"&&ftfs="+v.score+"&&ftsj="+v.lastModif+"\"";
				var cliklb = "\""+v.taskId+"\",\"/oasm/dafxView/zq_jgftlb?qh="+v.crimNo+"\"";
				if(v.status>1){
					zt="已完成"; //状态
					cz="<a href='#' onclick='loadZqftrs(\""+v.taskId+"\","+clikrs+")'>查看详情</a>"; //操作
				}else if(v.status==1){
					zt="未完成";
					cz="<div class='addbutton2' onclick='loadZqftlb("+cliklb+")'>开始访谈</div>";
				}
				if(v.score==null){
					scores=0;
				}else{
					scores = v.score;
				}
				
				//表格内容
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
			$("#zq_jgft_tableData").html(tb);
			pageSize = data.page.pageSize;
			pages = data.page.pages;
			total = data.page.total;
			$("#pageSize").html(pageSize);
		 	$("#pages").html(pages);
		}
		
	});
}

//获取中期行为观察数据，放到zq_rcgc.jsp页面表格中
function zq_rcgc_DataList(gyjq,qh,xm,jhxm,gczt){
	$.ajax({
		url:"/oasm/dafxView/zqgcView_json",
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
			if(data.zqgcvp.length==0){			
				tb+="<tr>";
				tb+="<td colspan='9'>"+nodatatie+"</td>";
				tb+="</tr>";
			}else{
			$.each(data.zqgcvp,function(k,v){
				//使用js定义两个路径
				var clikrs = "\"/oasm/dafxView/zq_rcgcrs?qh="+v.crimNo+"&&gcfs="+v.score+"&&gcsj="+v.lastModif+"\"";
				var cliklb = "\""+v.taskId+"\","+v.crimNo+",\"/oasm/dafxView/zq_rcgclb?qh="+v.crimNo+"\"";
				if(v.status>1){
					zt="已完成"; //状态
					cz="<a href='#' onclick='loadZqgcrs(\""+v.taskId+"\","+clikrs+")'>查看详情</a>"; //操作
				}else if(v.status==1){
					zt="未完成";
					cz="<div class='addbutton2' onclick='loadZqgclb("+cliklb+")'>行为观察</div>";
				}
				if(v.score==null){
					scores=0;
				}else{
					scores = v.score;
				}
				
				//表格内容
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
			$("#zq_xwgc_tableData").html(tb); //把数据放到表格中
			//分页
			pageSize = data.page.pageSize;
			pages = data.page.pages;
			total = data.page.total;
			$("#pageSize").html(pageSize);
		 	$("#pages").html(pages);
		}
	});
}

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
	
	if(clazz=="rjdafx"){
		var qh = $("#rjqh").val().trim();
    	var xm = $("#rjxm").val().trim();
		ajax_rj_dafx(qh,xm); //档案分析表格数据
	}
	if(clazz=="rjjgft"){
		var gyjq = $("#gyjq").val();
		var qh = $("#rjqh").val().trim();
		var xm = $("#rjxm").val().trim();
		var jhxm = $("#jhxm").val().trim();
		var fttype = $("#searchRadio input[type='radio']:checked").val();
		ajax_rj_jgft(gyjq,qh,xm,jhxm,fttype);//入监结构访谈表格数据
	}
	if(clazz=="rjrcgc"){
		var gyjq = $("#rj_xwgc_ssqselect").val();
		var qh = $("#rjxwqh").val().trim();
		var xm = $("#rjxwxm").val().trim();
		var jhxm = $("#rjxwjhxm").val().trim();
		var gctype = $("#rjxwgc_radio_val input[type='radio']:checked").val();
		ajax_rj_rcgc(gyjq,qh,xm,jhxm,gctype);//入监行为观察表格数据
	}
	if(clazz=="rcrcgc"){
		var gyjq = $("#rcrcgc_ss_selected").val();
		var qh = $("#rcgcqh").val().trim();
		var xm = $("#rcgcxm").val().trim();
		var jhxm = $("#rcgcjhxm").val().trim();
		var gczt = $("#rcrcgc_radio_checked input[type='radio']:checked").val();
		rc_rcgc_DataList(gyjq,qh,xm,jhxm,gczt);//日常行为观察表格数据
	}
	if(clazz=="zqjgft"){
		var gyjq = $("#zqjgft_ss_select").val();
		var qh = $("#zqftqh").val().trim();
		var xm = $("#zqftxm").val().trim();
		var jhxm = $("#zqftjhxm").val().trim();
		var ftzt = $("#zqjgft_ss_radio input[type='radio']:checked").val();
		zq_jgft_DataList(gyjq,qh,xm,jhxm,ftzt);//中期结构访谈表格数据
	}
	if(clazz=="zqrcgc"){
		var gyjq = $("#zqgc_ss_selected").val();
		var qh = $("#zqgcqh").val().trim();
		var xm = $("#zqgcxm").val().trim();
		var jhxm = $("#zqgcjhxm").val().trim();
		var gczt = $("#zqgc_ss_radio input[type='radio']:checked").val();
		zq_rcgc_DataList(gyjq,qh,xm,jhxm,gczt); //中期行为观察表格数据 
	}
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
	
	if(clazz=="vjtft"){//集体访谈
		var gyjq = $("#vjtftjq").val();
		var qh = $("#vjtftqh").val().trim();
		var xm = $("#vjtftxm").val().trim();
		var jhxm = $("#vjtftjcxm").val().trim();
		var zt = $("#vjtft_searchRadio input[type='radio']:checked").val();
		ajax_jtft(gyjq,qh,xm,jhxm,zt);
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
