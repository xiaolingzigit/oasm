 $.ajaxSetup({
	cache: false //关闭AJAX相应的缓存
});

var pageNum = 1;
var pageSize = 15;
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
});
//*****************************************************************************
 
       /**
		 * 获取任务/记录列表
		 * 
		 * @param taskId
		 *            任务ID
		 * @param onSuccess
		 *            回调函数
		 */
		function copaSearch() {
			var taskType = "copaMt";
			var taskId = "";
			var prison = $("#prison").val();
			var crimNo = $("#crimNo").val();
			var crimName = $("#crimName").val();
			var copRange = $("#copType").val();// 所有all/专管zg/协管xg/任务执行人zxr
			var copNo = $("#copAllNo").val();
			var copName = $("#copAllNames").val();
			var creator = $("#creator").val();
			var crTimeStart = $("#crTimeStart").val();
			var crTimeEnd = $("#crTimeEnd").val();
			var deadlineStart = $("#deadlineStart").val();
			var deadlineEnd = $("#deadlineEnd").val();
			var lastModifStart = $("#lastModifStart").val();
			var lastModifEnd = $("#lastModifEnd").val();
			var status = $("#status").val();
			var taskBasis = "";
			var taskDescrib = "";
			getTaskList(taskType, taskId, prison, crimNo, crimName, copRange,
					copNo, copName, creator, crTimeStart, crTimeEnd,
					deadlineStart, deadlineEnd, lastModifStart, lastModifEnd,
					status, taskBasis, taskDescrib,pageNum,pageSize, function(respData) {
					$("#copaTable tr:not(:first)").remove();
					
					if (isEmpty(respData)) {
						return;
					}
					
					listData = jQuery.parseJSON(respData);
					
					listArr = listData.list;
					if (listArr == null || listArr.length == 0) {
						for (i = 0; i < 4; i++) {
							$("#copaTable").append($("<tr />").html("<td class='base_th' >"+ (i == 0 ? "无结果": "...")
							+ "<td class='base_th'></td><td class='base_th'></td><td class='base_th'></td><td class='base_th'></td><td class='base_th'></td><td class='base_th'></td><td class='base_th'></td><td class='base_th'></td><td class='base_th'>"
							+ (i == 0 ? "无操作": "...")
							+ "</td>"));
						}
						return;
					}
					
					$.each(listArr, function(index, content) {
						var link;
						if(content.status< 4){
							link = "<div class='addbutton2' onclick=\"loadCopaTest('"+index+"')\">进入测试</div>";
						}else if(content.status==4){
							link = "<a  href='#'  onclick=\"loadCopaReport('"+index+"')\">查看报告</div>";
						}else{// if(content.status==10){
							link = "<div class='addbutton2' onclick=\"loadCopaTest('"+index+"')\">查看记录</div>";
						}
						
						 $("#copaTable").append($('<tr/>')  
					                .append($('<td/>').html(index + 1)) 
					                .append($('<td/>').html(toShow(content.crimNo)))              
					                .append($('<td/>').html(toShow(content.crimName)))  
					                .append($('<td/>').html(toShow(content.prisonName))) 
					                .append($('<td/>').html(toShow(formatDate(content.deadline,'yyyy-MM-dd')))) 
					                .append($('<td/>').html(toShow(formatDate(content.lastModif,'yyyy-MM-dd HH:mm')))) 
					                .append($('<td/>').html(toShow(content.score))) 
					                .append($('<td/>').html(toShow(content.cop1Name))) 
					                .append($('<td/>').html(toShow(content.statusName))) 
					                .append($('<td/>').html(link)));  										
					});
				        pageSize = listData.page.pageSize;
						pages = listData.page.pages;
						total = listData.page.total;
						$("#pageSize").html(pageSize);
						$("#pages").html(pages);
				});
		}
//		$(document).ready(function(){
//			copaSearch();
//		});
//	
//************************************scl部分**********************************************		
//		$(document).ready(function() {
//			scl90Search();
//		});
		/**
		 * 获取任务/记录列表
		 * 
		 * @param taskId
		 *            任务ID
		 * @param onSuccess
		 *            回调函数
		 */
		function scl90Search() {
			var taskType = "scl90Mt";
			var taskId = "";
			var prison = $("#prison").val();
			var crimNo = $("#crimNo").val();
			var crimName = $("#crimName").val();
			var copRange = $("#copType").val();// 所有all/专管zg/协管xg/任务执行人zxr
			var copNo = $("#copAllNo").val();
			var copName = $("#copAllNames").val();
			var creator = $("#creator").val();
			var crTimeStart = $("#crTimeStart").val();
			var crTimeEnd = $("#crTimeEnd").val();
			var deadlineStart = $("#deadlineStart").val();
			var deadlineEnd = $("#deadlineEnd").val();
			var lastModifStart = $("#lastModifStart").val();
			var lastModifEnd = $("#lastModifEnd").val();
			var status = $("#status").val();
			var taskBasis = "";
			var taskDescrib = "";
            var num=pageNum;
            var size=pageSize;
			$("#scl90table tr:not(:first)").remove();
			
			getTaskList(taskType,taskId,prison,crimNo,crimName,copRange,
					copNo,copName,creator,crTimeStart,crTimeEnd,deadlineStart,
					deadlineEnd,lastModifStart,lastModifEnd,status,taskBasis,
					taskDescrib,num,size,function(respData) {
						
					if (isEmpty(respData)) {
							return;
						}

						listData = jQuery.parseJSON(respData);
						
						listArr = listData.list;
						if (listArr == null || listArr.length == 0) {
							for (i = 0; i < 4; i++) {
								$("#scl90table").append($("<tr />").html("<td class='base_th' >"+ (i == 0 ? "无结果": "...")
								+ "<td class='base_th'></td><td class='base_th'></td><td class='base_th'></td><td class='base_th'></td><td class='base_th'></td><td class='base_th'></td><td class='base_th'></td><td class='base_th'></td><td class='base_th'>"
								+ (i == 0 ? "无操作": "...")
								+ "</td>"));
							}

							return;
						}

						$.each(listArr,function(index, content) {
	                                 console.info(content.crimName);
									var link;
									if (content.status < 4) {
										link = "<div class='addbutton2' onclick=\"loadScl90test('"
												+ index
												+ "')\">进入测试</div>";
									} else if (content.status == 4) {
										link = "<a  href='#'  onclick=\"loadScl90report('"
												+ index
												+ "')\">查看报告</div>";
									} else {// if(content.status==10){
										link = "<div class='addbutton2' onclick=\"loadScl90test('"
												+ index
												+ "')\">查看记录</div>";
									}
	
									$("#scl90table").append($('<tr/>')  
					                .append($('<td/>').html(index + 1)) 
					                .append($('<td/>').html(toShow(content.crimNo)))              
					                .append($('<td/>').html(toShow(content.crimName)))  
					                .append($('<td/>').html(toShow(content.prisonName))) 
					                .append($('<td/>').html(toShow(formatDate(content.deadline,'yyyy-MM-dd')))) 
					                .append($('<td/>').html(toShow(formatDate(content.lastModif,'yyyy-MM-dd HH:mm')))) 
					                .append($('<td/>').html(toShow(content.score))) 
					                .append($('<td/>').html(toShow(content.cop1Name))) 
					                .append($('<td/>').html(toShow(content.statusName))) 
					                .append($('<td/>').html(link)));  										
								});
						pageSize = listData.page.pageSize;
   						pages = listData.page.pages;
   						total = listData.page.total;
   						$("#pageSize").html(pageSize);
   						$("#pages").html(pages);
					});
		}
		
		
//**************************统一搜索框**********************************************
		$("#bt_scl90search").click(function() {
			scl90Search();
		});
		$("#bt_copaSearch").click(function() {
			copaSearch();
		});
//************************************************************************
		function goPage(pageNum1, psize1, clazz1) {
			psize = psize1;
			pageNum = pageNum1;
			clazz = clazz1;
			$("#pageNum").html(pageNum);	
			
			if(clazz=="copapi"){
				copaSearch();
			}else if(clazz=="scl90"){
				scl90Search();
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
