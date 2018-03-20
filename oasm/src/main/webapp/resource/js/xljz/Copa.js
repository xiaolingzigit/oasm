//copa的答题情况
function loadCopa(url) {
	$('#basecontent').load(url);
}
function copa_da_save() {// 如果用户点"暂存"，要提示提交后不能再编辑
	var danxcopa = [];
	$(".lb_option input[type=radio]:checked").each(function(i, n) {
		var copatm = $(n).attr("name"); // copaq1,1;copa2,2;...
		var copayz = $(n).val();
		danxcopa.push(copatm + "," + copayz + ";");
	});
	var modifier = $(".copa_jh").html().toString();// 登记干警号
	var taskId = "dsredsd";// 任务编号
	var answer = danxcopa.toString();// 答题情况
	var status = 2;// 暂存状态2
	var qh = $("#copa_qh").html().toString();// 囚号

	alert(answer);

	saveMTNote(taskId, answer, status);

	// var danxcopa=[];
	// $(".lb_option input[type=radio]:checked").each(function(i,n){
	// var copatm=$(n).attr("name"); //copaq1,1;copa2,2;...
	// var copayz = $(n).val();
	// danxcopa.push(copatm+","+copayz+";");
	// });
	// var jh = $(".copa_jh").html().toString();//登记干警号
	// var taskID="dsredsd";//任务编号
	// var answer=danxcopa.toString();//答题情况
	// var status=1;//暂存状态1
	// var qh=$("#copa_qh").html().toString();//囚号
	//	
	// alert(answer);
	//	
	// $.ajax({
	// url:"/oasm/task/deal",
	// dataType:"JSON",
	// type:"post",
	// data:{taskID:taskID,answer:answer,status:status},
	// success:function(data){
	// alert("已保存copa答题情况" +
	// "+");//2则"提交成功,答题结束"
	//
	// }
	//		
	// });
}
function copa_da_submit() {// 如果用户点"完成"，要提示提交后不能再编辑
	if (confirm("答案提交后将无法修改，是否继续提交？")) {
		var danxcopa = [];
		var inputnum = $(".lb_option input[type=radio]").length;
		var inputhasck = $(".lb_option input[type=radio]:checked").length;
		var inputmck = inputnum / 2;
		if (inputhasck == inputmck) {
			// 全部选中
			$(".lb_option input[type=radio]:checked").each(function(i, n) {
				var copatm = $(n).attr("name"); // copaq1,1;copa2,2;...
				var copayz = $(n).val();
				danxcopa.push(copatm + "," + copayz + ";");
			});
			var jh = $(".copajh").html();
			var taskID = "dsredsd";// 任务编号
			var answer = danxcopa.toString();// 答题情况
			var status = 2;// 提交完成状态2
			var qh = $("#copa_qh").html().toString();// 囚号
			$.ajax({
				url : "/oasm/task/deal",
				dataType : "JSON",
				type : "post",
				data : {
					taskID : taskID,
					answer : answer,
					status : status
				},
				success : function(data) {
					alert("已保存copa答题情况");// 2则"提交成功,答题结束"

				}

			});
		} else {
			alert("已作答" + inputhasck + "题，还有" + (inputmck - inputhasck)
					+ "题未回答。请完成所有题再提交。");
		}
	}
}
