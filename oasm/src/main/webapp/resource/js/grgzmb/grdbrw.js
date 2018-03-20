var pageNum = 1;// 当前页数
var pageSize = 10;
var total = 1;// 总记录数
var pages = 1;// 总页数
var psize = 10;// 每页的数量

$(document).ready(function() {
	$("#taskToDoTable tr:not(:first)").remove();
	getMsg(pageNum, psize);

	// 首页
	$("#firstPage").click(function() {
		getMsg(1, psize);
	});

	// 末页
	$("#lastPage").click(function() {
		// console.info("lastPage "+pageNum+"----"+pages)
		getMsg(pages, psize);
	});
	// 上一页
	$("#prePage").click(function() {
		if (pageNum > 0) {
			if (pageNum == 1) {
				$("#firstPage").addClass("ban");
				$("#prePage").addClass("ban");
			}
			getMsg(pageNum, psize);
			$("#nextPage").removeClass("ban");
			$("#lastPage").removeClass("ban");
		} else {
			$("#firstPage").addClass("ban");
			$("#prePage").addClass("ban");
		}
	});

	// 下一页
	$("#nextPage").click(function() {
		// console.info("pageNum "+pageNum+" nextPage "+pages+" psize "+psize);
		getMsg(pageNum, psize);
	});

	// 下拉
	var tempOption = "";
	for (var i = 1; i <= pages; i++) {
		tempOption += '<option value=' + i + '>' + i + '</option>'
	}
	$("#jumpWhere").html(tempOption);
});

// 跳转
function jumpPage() {
	var num = parseInt($("#jumpWhere").val());
	if (num != pageNum) {
		getMsg(num, psize);
	}
}

function getMsg(n, s) {
	post(
			{
				op : "taskGetTodo",
				num : n,
				size : s
			},
			function(respData) {
				if (isEmpty(respData)) {
					return;
				}
				var json = jQuery.parseJSON(respData);

				listArr = json.data;
				if (listArr == null || listArr.length == 0) {
					for (i = 0; i < 4; i++) {
						$("#taskToDoTable").append($("<tr />")
							.html(
									"<td class='base_th' >"+ (i == 0 ? "无结果": "...")
									+ "<td class='base_th'></td><td class='base_th'></td><td class='base_th'></td><td class='base_th'></td><td class='base_th'></td><td class='base_th'></td><td class='base_th'>"
									+ (i == 0 ? "无操作": "...")+ "</td>")
							);
					}
					return;
				}
				var txt = '';
				var a = 1;
				$.each(listArr, function(index, content) {
					a = (n - 1) * 10 + 1 + index;
					// $("#taskToDoTable").append($('<tr/>')
					// .append($('<td/>').html(index + 1))
					// .append($('<td/>').html(toShow(content.taskType)))
					// .append($('<td/>').html(toShow(content.crimNo)))
					// .append($('<td/>').html(toShow(content.crimName)))
					// .append($('<td/>').html(toShow(formatDate(content.crtime,'yyyy-MM-dd
					// HH:mm'))))
					// .append($('<td/>').toShow(formatDate(content.crtime,'yyyy-MM-dd
					// HH:mm'))))
					// .append($('<td/>').html(toShow(content.cop1Name)))
					// .append($('<td/>').html(toShow(content.statusName))));
					txt += "<tr>";
					txt += "<td>" + a + "</td>";
					txt += "<td>" + toShow(content.taskType) + "</td>";
					txt += "<td>" + toShow(content.crimNo) + "</td>";
					txt += "<td>" + toShow(content.crimName) + "</td>";
					txt += "<td>"
							+ toShow(formatDate(content.crtime,
									'yyyy-MM-dd HH:mm')) + "</td>";
					txt += "<td>"
							+ toShow(formatDate(content.crtime,
									'yyyy-MM-dd HH:mm')) + "</td>";
					txt += "<td>" + toShow(content.cop1Name) + "</td>";
					txt += "<td>" + toShow(content.statusName) + "</td>";
					txt += "</tr>";
				});
				$("#dbrw").html(txt);
				// console.info(json.page);

				// 记录数据
				var tempStr = "共" + json.page.total + "条记录 当前"
						+ json.page.pageNum + "/" + json.page.pages + "页";
				document.getElementById("barcon1").innerHTML = tempStr;
				// console.info(tempStr);

				// $("#jumpWhere").val(pageNum);

				// console.info(s+" "+n+" "+pageNum);
				pageNum = json.page.pageNum;
				pages = json.page.pages;
				$("#pageNum").html(pageNum);
				$("#gr_dbrw_sz").html(json.page.total);
			});
}
