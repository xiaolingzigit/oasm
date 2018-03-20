//档案分析视图数据显示因子和分数结果表
function loadDafxrs(jcdaId,url){
	console.info(jcdaId);
	$.ajax({
		url:"/oasm/ztk/getDafxRecord",
		type:"post",
		dataType:"JSON",
		data:{jcdaId:jcdaId},
		success:function(data){
			if(null!=data&&""!=data){
				$('#basecontent').load(url);
				setTimeout(function () { //设置先加载页面再延时加载数据
					var jgJSON = JSON.parse(data.answer);
					var tb = "";
					var tbs = "";
					$.each(jgJSON,function(k,v){
						tb+="<tr>";
						if(null!=v.yz&&null!=v.fs){
							tb+="<td>"+(k+1)+"</td>";
							tb+="<td class='lb_td01'>"+v.wd+"</td>";
							tb+="<td class='lb_td02'>"+v.yz+"</td>";
							tb+="<td class='lb_value'>"+v.fs+"</td>";
						}else{
							//暂不显示
						}
						tb+="</tr>";
						tbs="<td>评估总分</td><td></td><td></td><td style='color:#F00'>"+data.score+"</td>";
					});
                    $("#dafx_tableData").html(tb);
                    $("#dafx_tFootData").html(tbs);
				},2000);
			}else{
				alert("没有进行匹配规则");
			}
		}
	});
	
}

//加载档案分析补充量表
var daId = "";
function loadDafxlb(url,params){
	$.ajax({
		url:"/oasm/resource/json/dafx.json", //使用json文件加载数据，注意json数据格式
		type:"get",
		dataType:"JSON",
		async : true
	}).done(function(data){
		$('#basecontent').load(url);
		var tb = "";
		var ai = "@";
		setTimeout(function () {
		$.each(data,function(k,v){
          tb+="<tr>";
          tb+="<td>"+(k+1)+"</td>";
          tb+="<td>"+v.dimName+"</td>";
          tb+="<td class='lb_td04'><ul class='yz_li'>";
          $.each(v.yz,function(m,n){
        	  tb+="<li><input id='"+n.fId+"' value='"+n.fId+"' type='radio' name='"+v.dimId+"' /><label for='"+n.fId+"'>"+n.fName+"<span style='display:none'>"+v.dimName+ai+n.fscore+"</span></label></li>"; 
          });
          tb+="</ul></td>";
          tb+="</tr>";
		});
		$("#dafx_tableData").html(tb);
		
//		console.info(params);
		$("#hide_jtftid").html(params.jtftid);
		$("#qfxm").html(params.xm);
		$("#qfqh").html(params.qh);
		$("#qfjq").html(params.gyjq);
		$("#jcxm").html(params.jhxm);
		$("#hide_jh").html(params.jh);
		
		
		},1000);
	});
//	daId=jcdaid;
}


function da_wdyz_save(){
	var jcdaid = daId;
	var radio_option = "";
	var scores = 0;
	var raletjh = $("#hide_dafxjh").text().trim(); //需要登记题目的警号
	$("#dafx_tableData input[type='radio']:checked").each(function(m,n){
		var fId = $(n).val(); //因子编号
		var fName = $(n).next("label").text().trim(); //因子名
		var spdimName = $(n).next("label").children().text().trim().split("@");
		var dimId = $(n).attr("name"); //维度编号
		var dimName = spdimName[0]; //维度名
		var fscore = spdimName[1]; //因子分
		scores+=parseFloat(fscore); //总分数
		radio_option+=fId+"#"+fName+"#"+dimId+"#"+dimName+"#"+fscore+"@@";
	});
//	console.info(jcdaid+" "+radio_option+" "+scores+" "+raletjh);
}