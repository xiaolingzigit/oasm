//scl90答题情况
function loadScl(url){
	$('#basecontent').load(url);
}





function scl_da_save(){
	var danxscl=[];
	var jh = $(".scl_jh").html().toString();//登记干警号
	$(".lb_option input[type=radio]:checked").each(function(i,n){
		var scltm=$(n).attr("name"); //sclq1,0;sclq2,1;
		var sclyz = $(n).val();
		danxscl.push(scltm+","+sclyz+";");
	});
	var taskID="deshfj";//任务ID
	var answer=danxscl.toString();//scl答题情况
	var status=1;//暂存状态
	var qh=$("#scl_qh").html().toString();//囚号
	console.log(answer);
	$.ajax({
		url:"/oasm/task/deal",
		dataType:"JSON",
		type:"post",
		data:{taskID:taskID,answer:answer,status:status},
		success:function(data){
			alert("已保存scl90答题情况");
		}
		
	});
}
function scl_da_submit(){

	 if(confirm("答案提交后将无法修改，是否继续提交？"))
	 {
	var danxscl=[];
	var inputnum=$(".lb_option input[type=radio]").length;
	var inputhasck=$(".lb_option input[type=radio]:checked").length;
	var inputmck=inputnum/5;
	if(inputhasck==inputmck){

				//全部选中
		$(".lb_option input[type=radio]:checked").each(function(i,n){
			var scltm=$(n).attr(name);
			var sclyz=$(n).val();
			danxscl.push(scltm+","+sclyz+";");
		});
		var taskID="fhjsskfj";//任务编号
		var answer=danxscl.toString();//答题情况
		var status=2;//提交状态
		var qh=$("#scl_qh").html().toString();//囚号
		console.log(answer);
		$.ajax({
			url:"/oasm/task/deal",
			dataType:"JSON",
			type:"post",
			data:{taskID:taskID,answer:answer,status:status},
			success:function(data){
				alert("成功提交scl-90测试情况，答题结束");
			}
		});
		
	}else{
		alert("已作答"+inputhasck+"题，还有"+(inputmck-inputhasck)+"题未答。请完成所有题再提交。");
		}
}
	}