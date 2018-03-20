$.ajaxSetup({
	cache: false //关闭AJAX相应的缓存
});

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

//四大评估关键字查询---入监评估
$(function(){
	$(".button_submit").click(function(){
		var qh=$("input[name='rjqh']").val();
		var zsxm=$("input[name='rjzsxm']").val();
		var qhcheck=/^[0-9]*$/;
		if(qh==""||qh==null){
			$(".nullsousuo").replaceWith("<span style='color:red;'>请输入任意囚号</span>");
		}else if(qhcheck.test(qh)==false){
			$(".nullsousuo").replaceWith("<span style='color:red;'>请确保囚号为数字</span>");
		}
		else{
			$(".nullsousuo").remove();
			$.ajax({
				url:"/oasm/pgbgsccxView/selectRjKey",
				dataType:"JSON",
				type:"post",
				data:{qh:qh,zsxm:zsxm},
				success:function(data){
					$(".content_table").show();
					var s="";
					s+="<tr>";
					var i=1;
					$.each(data,function(k,v){
					s+="<td>"+(i++)+"</td>";
					s+="<td>"+v.jq+"</td>";
					s+="<td>"+v.qh+"</td>";
					s+="<td>"+v.zsxm+"</td>";
					s+="<td>"+timeStamp2String(v.sj)+"</td>";
					s+="<td>"+v.wxdj+"</td>";
					s+="<td>"+v.zf+"</td>";
//					s+="<td><a onclick='loadrjbgPage("+v.qh+",'/oasm/pgbgsccxView/pgbg_rj')'>进入报告</a></td>";
					s+="</tr>"
					});
					$("#pgbgxq").html(s);
				}
			});
		}
	});
});

//日常评估