$.ajaxSetup({
	cache: false //关闭AJAX相应的缓存
});
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
});
//*****************************************************************************
var jsonArr2;
function get_Crim_List() {
			post({op : "crimCopInfo",pageNum : pageNum,pageSize : pageSize},
					function(data) {
						if (isEmpty(data)) {
							return;
						}
						jsonArr2 = jQuery.parseJSON(data);
						$("#criminalList tr").remove();
						index_num=1;
						$.each(jsonArr2.info, function(index, content) {
							   $("#criminalList ").append($('<tr/>')
									   .append($('<td/>').html(index_num))
          								.append($('<td/>').html(toShow(content.prison)))
          								.append($('<td/>').html(toShow(content.crimNo)))
          								.append($('<td/>').html(toShow(content.crimName)))
          								.append($('<td/>').html(toShow(content.inTime)))
           								.append($('<td/>').html(toShow("")))
          								.append($('<td/>').html(toShow("")))
 							            .append($('<td/>').html("<a onclick='loadCrimInfo(\""+content.crimNo+"\",\"/oasm/jygzView/zfinfo?qh="+content.crimNo+"&&jcxm="+encodeURI(content.cop1Name)+"\")'>点击进入</a>")));
							   index_num+=1;
							});
						pageSize = jsonArr2.page.pageSize;
   						pages = jsonArr2.page.pages;
   						total = jsonArr2.page.total;
   						$("#pageSize").html(pageSize);
   						$("#pages").html(pages);
   						
			});
	}
function goPage(pageNum1, psize1, clazz1) {
			psize = psize1;
			pageNum = pageNum1;
			clazz = clazz1;
			$("#pageNum").html(pageNum);	
			
			if(clazz=="criminalList"){
				get_Crim_List();
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