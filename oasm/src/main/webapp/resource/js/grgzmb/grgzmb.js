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


var jsonArr;
function getCrimCopInfo() {
			post({op : "crimCopInfo",
				pageNum:pageNum,
				pageSize:pageSize,
				
				prison : $("#prison").val(),	
				crimNo : $("#crimNo").val(),
				crimName : $("#crimName").val(),
				copRange : $("#copType").val(),
				copNo : $("#copAllNo").val(),//所有all/专管zg/协管xg
				copName : $("#copAllName").val()
			
			},
					function(data) {
						if (isEmpty(data)) {
							return;
						}
						jsonArr = jQuery.parseJSON(data);
						//$("#criminal_tb tr:not(:first)").remove();
						$("#criminal_tb tr").remove();
						$.each(jsonArr.info, function(index, content) {
							   $("#criminal_tb").append($('<tr class="criminal_tb_tr"/>')
          								.append($('<td/>').html("<input type='checkbox' id='' value='' class='common_checkbox'/>"))
          								.append($('<td class="c_td"/>').html(toShow(content.prison)))
          								.append($('<td class="c_td"/>').html(toShow(content.crimNo)))
          								.append($('<td class="c_td"/>').html(toShow(content.crimName)))
          								.append($('<td class="c_td"/>').html(toShow(content.inTime)))
          								.append($('<td class="c_td"/>').html(toShow(content.outTime)))
          								.append($('<td class="c_td"/>').html(toShow(content.cop1Name)))
          								.append($('<td class="c_td"/>').html(toShow(content.cop2Name))));
							});
						pageSize = jsonArr.page.pageSize;
   						pages = jsonArr.page.pages;
   						total = jsonArr.page.total;
   						$("#pageSize").html(pageSize);
   						$("#pages").html(pages);
   						select_criminal();
			});
	}
function goPage(pageNum1, psize1, clazz1) {
			psize = psize1;
			pageNum = pageNum1;
			clazz = clazz1;
			$("#pageNum").html(pageNum);	
			
			if(clazz=="grsdfb"){
				getCrimCopInfo();
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

//************************显示囚犯与警察关系结束***********************************************************
		

		$("#search_police").hide();
		/* $("#search_criminal").hide();		
		$("#have_assigned").hide(); */
		/* 		$("#sa_btn").click(function(){
		 $(".addtask_r").toggle(1000);
		 }); */
		$("#sa_c_btn").click(function() {
			getCrimCopInfo();
			
			if ($("#search_criminal").css("display") == "none") {
				$("#search_police").hide();
				$("#search_criminal").show(1000);
			} else {
				$("#search_police").hide();
				$("#search_criminal").hide(1000);
			}
		});

		$("#sa_p_btn").toggle(function() {
			$("#search_criminal").hide();
			$("#search_police").show(1000);
		}, function() {
			$("#search_criminal").hide();
			$("#search_police").hide(1000);
		});
		
		$("#show_task").click(function() {
			if ($("#have_assigned").css("display") == "none") {
				$("#have_assigned").show();
				$(".auxiliary_prompt").html("收起↑");
			} else {
				$("#have_assigned").hide();
				$(".auxiliary_prompt").html("展开↓");
			}
		});
		
		var assess_criminalNo = "";
		function select_criminal(){
		$('#criminal_tb .common_checkbox').click(function() {
			if($(this).attr("checked")=="checked"){
			$(this).parents("tr").css("background", "#ffff80");
			value = $(this).parents("tr").find("td").eq(2).html() + ";";
			$("#crimNo").html($("#crimNo").html().replace(value, ""));
			$("#crimNo").append(value);
			assess_criminalNo = assess_criminalNo.replace(value, "");
			assess_criminalNo += value;
			$("#crim_amount").html((assess_criminalNo.length) / 11);
			}else{
				$(this).parents("tr").css("background", "#fff");
				value = $(this).parents("tr").find("td").eq(2).html() + ";";
				$("#crimNo").html($("#crimNo").html().replace(value, ""));
				assess_criminalNo = assess_criminalNo.replace(value, "");
				$("#crim_amount").html((assess_criminalNo.length) / 11);
			}
		});
		$('.c_td').click(function() {
			//$(this).find("input").prop("checked","checked");
				if($(this).parent("tr").find("input").attr("checked")!="checked"){
			$(this).parent("tr").find("input").prop("checked","checked");
			$(this).parent("tr").css("background", "#ffff80");
			value = $(this).parent("tr").find("td").eq(2).html() + ";";
			$("#crimNo").html($("#crimNo").html().replace(value, ""));
			$("#crimNo").append(value);
			assess_criminalNo = assess_criminalNo.replace(value, "");
			assess_criminalNo += value;
			$("#crim_amount").html((assess_criminalNo.length) / 11);
			}else{
				$(this).parent("tr").css("background", "#fff");
				$(this).parent("tr").find("input").prop("checked","");
				value = $(this).parent("tr").find("td").eq(2).html() + ";";
				$("#crimNo").html($("#crimNo").html().replace(value, ""));
				assess_criminalNo = assess_criminalNo.replace(value, "");
				$("#crim_amount").html((assess_criminalNo.length) / 11);
			}
		});
		}
		$("#police_tb tr").click(function() {
					var jc_jq = $(this).find("td").eq(1).html();
					var jc_no = $(this).find("td").eq(2).html();
					var jc_name = $(this).find("td").eq(3).html();
					if (confirm("确认执行人：【" + jc_jq + "】-【" + jc_no + "】-【"
							+ jc_name + "】")) {
						$("#modifier").html(jc_no + ";");
					}
				});

		$("#selectall").click(function() {
			//alert(this.checked);  
			if ($(this).is(':checked')) {
				$('.criminal_tb_tr').each(function() {
					$(this).find("input").prop("checked", true);
					$(this).css("background", "#ffff80");
					value = $(this).find("td").eq(2).html() + ";";
					$("#crimNo").html($("#crimNo").html().replace(value, ""));
					$("#crimNo").append(value);
					assess_criminalNo = assess_criminalNo.replace(value, "");
					assess_criminalNo += value;
					$("#crim_amount").html((assess_criminalNo.length) / 11);

				});
			} else {
				$('.criminal_tb_tr').each(function() {
					$(this).find("input").prop("checked", false);
					$(this).css("background", "#fff");
					value = $(this).find("td").eq(2).html() + ";";
					$("#crimNo").html($("#crimNo").html().replace(value, ""));
					assess_criminalNo = assess_criminalNo.replace(value, "");
					$("#crim_amount").html((assess_criminalNo.length) / 11);
				});
			}

		});
		$("#publish").click(function(event) {
							/* 					var crimNo = $("#crimNo").val(); */
							var crimNo = assess_criminalNo;
							var taskType = $('#taskTypeOp option:selected')
									.val();
							var taskBasis = ""//$('#taskBasis').val();
							var taskDescrib = $('#taskDescrib').val();
							var deadline = $('#deadline').val();
							var excutor = $('#excutor').val();
							var status = 1;

							addTask(crimNo,taskType,taskBasis,taskDescrib,deadline,excutor,status,
									function(data) {
										alert(data);
										$("#currTaskTable tr:not(:first)").remove();
										if (data != null&& data.indexOf("成功") >= 0) {
											var taskType = "Rep";
											var taskId = "";
											var prison = "";
											var crimNo = "";
											var crimName = "";
											var copRange = "";// 所有all/专管zg/协管xg/任务执行人zxr
											var copNo = "";
											var copName = "";
											var creator = "";
											var crTimeStart = formatDate(new Date(), "yyyy-MM-dd");
											var crTimeEnd = formatDate(new Date(),"yyyy-MM-dd HH:mm:ss");
											var deadlineStart = "";
											var deadlineEnd = "";
											var lastModifStart = "";
											var lastModifEnd = "";
											//var status = "1";
											//var taskBasis = "";
											//var taskDescrib = "";

				getTaskListWithTypeLike(taskType,taskId,prison,crimNo,crimName,copRange,
										copNo,copName,creator,crTimeStart,crTimeEnd,deadlineStart,
										deadlineEnd,lastModifStart,lastModifEnd,status,taskBasis,
										askDescrib,function(respData) {

														if (isEmpty(respData)) {
															return;
														}

														listArr = jQuery
																.parseJSON(respData);
														if (listArr == null
																|| listArr.length == 0) {
															for (i = 0; i < 1; i++) {
																$("#currTaskTable").append(
																$("<tr />").html("<td class='base_th' >"+ (i == 0 ? "无结果": "...")
																+ "<td class='base_th'></td><td class='base_th'></td><td class='base_th'></td><td class='base_th'></td><td class='base_th'></td><td class='base_th'></td><td class='base_th'></td><td class='base_th'>"
																+ (i == 0 ? "无操作": "...")+ "</td>"));
															}

															return;
														}

		                            $.each(listArr,function(index,content) {
                                   $("#currTaskTable")
                                      .append($('<tr/>')
                                      .append($('<td/>').html(index + 1))
                                      .append($('<td/>').html(toShow(content.crimNo)))
                                      .append($('<td/>').html(toShow(content.crimName)))
									  .append($('<td/>').html(toShow(content.prisonName)))
									  .append($('<td/>').html(toShow(content.inTime)))
									  .append($('<td/>').html(toShow(content.taskType)))
									  .append($('<td/>').html(toShow(formatDate(content.deadline,'yyyy-MM-dd'))))
									  .append($('<td/>').html(toShow(content.cop1Name))));
									});
								});

								} else {
									for (i = 0; i < 3; i++) {
										$("#currTaskTable").append(
												$("<tr />").html("<td class='base_th' >"+ (i == 0 ? "无结果": "...")
												+ "<td class='base_th'></td><td class='base_th'></td><td class='base_th'></td><td class='base_th'></td><td class='base_th'></td><td class='base_th'></td><td class='base_th'>"
												+ (i == 0 ? "无操作": "...")+ "</td>"));
											}
										}

									});
							$("#search_criminal").hide();
							$(".auxiliary_prompt").html("收起↑");
							$("#have_assigned").show();
						});
