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

var pageNum = 1;
var pageSize = 10;
var total = 1;// 总记录数
var pages = 1;// 总页数
var psize = 10;
var clazz = "";
var find = "";// 搜索内容

// 分页
$(function() {
	$("#firstPage").click(function() {
		$("#prePage").addClass("ban");
		$("#firstPage").addClass("ban");
		if (pageNum == 1) {
		} else {
			goPage(1, psize, clazz);
			$("#nextPage").removeClass("ban");
			$("#lastPage").removeClass("ban");
		}
	});

	$("#lastPage").click(function() {
		// console.info("lastPage "+pageNum+"----"+pages)
		if (pageNum == pages) {
		} else {
			goPage(pages, psize, clazz);
			$("#nextPage").addClass("ban");
			$("#lastPage").addClass("ban");
			$("#firstPage").removeClass("ban");
			$("#prePage").removeClass("ban");
		}
	});

	$("#prePage").click(function() {
		if (pageNum > 1) {
			if (pageNum - 1 == 1) {
				$("#firstPage").addClass("ban");
				$("#prePage").addClass("ban");
			}
			goPage(pageNum - 1, psize, clazz);
			$("#nextPage").removeClass("ban");
			$("#lastPage").removeClass("ban");
		} else {
			$("#firstPage").addClass("ban");
			$("#prePage").addClass("ban");
		}
	});

	$("#nextPage").click(function() {
		// console.info("pageNum "+pageNum+" nextPage "+pages+" psize "+psize);
		if (pageNum < pages) {
			if (pageNum + 1 == 10) {
				$("#nextPage").addClass("ban");
				$("#lastPage").addClass("ban");
			}
			goPage(pageNum + 1, psize, clazz);
			$("#firstPage").removeClass("ban");
			$("#prePage").removeClass("ban");

		} else {
			$("#nextPage").addClass("ban");
			$("#lastPage").addClass("ban");
		}
	});
	
	// *********************************统一搜索框******************************************
    //出监报告搜索器
    $("#cjbg_ss_btn").click(function(){
   	 goPage(1, psize, "cjpgbg");
    });
});

//出监评估报告
function cjpgList(jq,crimno,crimname,jcxm,wxdj,cjzt){
//	console.info("cjpgList---------------")
	$.ajax({
		url:"/oasm/pgbgView/getViewPgbg",
		type:"post",
		dataType:"JSON",
		async:false,
		data:{pageNum : pageNum,pageSize : pageSize,type:"otRep",
			 gyjq:jq,qh:crimno,xm:crimname,jhxm:jcxm,eval:wxdj,stat:cjzt},
	    success:function(data){
	    	var a = "";
	    	if(null!=data.viewPgbg&&""!=data.viewPgbg){
	    		$.each(data.viewPgbg,function(k,v){
		    		k=(pageNum-1)*pageSize+1+k;
					var st = '';
					var b = "";
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
					a += "<td>" + k + "</td>";// 当前行号
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
					var cjbgurl = "\"/oasm/pgbgsccxView/pgbg_cj?qh="+v.crimNo+"&&taskId="+v.taskId+"\""; //中期评估报告url
					if (v.status == 4) {
						a += "<td><a class='cs-a' onclick='loadcjbgPage(\""+v.status+"\",\""+v.taskId+"\","+cjbgurl+")'>查看报告</a></td></tr>";
					} else {
						a += "<td><a class='cs-a' onclick='loadcjbgPage(\""+v.status+"\",\""+v.taskId+"\","+cjbgurl+")'>查看进度</a></td></tr>";
					}
		    	});
	    	}else{
	    		a+="<tr>";
				a+="<td>无数据</td><td>...</td><td>...</td><td>...</td><td>...</td><td>...</td><td>...</td><td>...</td><td>...</td><td>...</td><td>...</td><td>无操作数据</td>";
				a+="</tr>";
	    	}
	    	$("#cjbglist").html(a);
			pageSize = data.page.pageSize;
			pages = data.page.pages;
			total = data.page.total;
			$("#pageSize").html(pageSize);
			$("#pages").html(pages);
	    }
	});
}

//条件
function goPage(pageNum1, psize1, clazz1) {
	psize = psize1;
	pageNum = pageNum1;
	clazz = clazz1;
	$("#pageNum").html(pageNum);
	if(clazz="cjpgbg"){
		var jq = $("#cjbg_ss_selected").val();
		var crimno = $("#cjbgqh").val();
		var crimname = $("#cjbgxm").val();
		var jcxm = $("#cjbgjhxm").val();
		var wxdj = $("#cjbg_ss_radio input[name='wxdj']:checked").val();
		var cjzt = $("#cjbg_ss_statRadio input[name='pgStatus']:checked").val();
		console.info(jq,crimno,crimname,jcxm,wxdj,cjzt);
		cjpgList(jq,crimno,crimname,jcxm,wxdj,cjzt);
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
