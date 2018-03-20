function loadCjgclb(taskId,qh,url){
	$('#basecontent').load(url,function(){
		cjgcScale(taskId); //加载出监观察量表
		cjgcycyqData(qh); //加载出监观察异常狱情数据
	});
}
function cjgcScale(taskId){
	$.ajax({
    	url:"/oasm/ztk/cjxwgc_start_question",
    	type:"post",
    	dataType:"JSON",
    	data:{taskId:taskId},
    	success:function(data){
   	     var dl="";
	   	 var fn="";
		 var split="@";
    	  if(null!=data&&""!=data){
    		  var dataJSON = JSON.parse(data);
 				 var ai = "@";
 				 var cdimName="";
 				 var fcount=0;
 				 dl+="<input type='hidden' class='hidde_taskId' value='"+taskId+"'/>";
 				 dl+="<ul>";
 				$.each(dataJSON,function(k,v){
 					if(v.dimName!=cdimName){
 					cdimName=v.dimName;
 					fn+="</ul></div></div>";
 					
 				    fcount=0;
 					dl+="<li class='dimension_li' id='"+v.dimId+"'>"+v.dimName+"(<span class='sfn'>0</span>/<span>n</span>)<input type='hidden' class='hidetask_Id' value='"+taskId+"'/></li>"; //维度
 					fn+="<div class='sub_factor hide'><div class='lb_options'><ul>";
 						$.each(v.options,function(m,n){
 							if(v.type==1){							
 							fn+="<li><input type='radio' name='"+v.dimId+"' id='"+n.factorId+"' class='rjxwgc_radio_value' value='"+n.factorId+"' /><span style='display:none'>"+(n.fscore*n.qz)+ai+v.dimName+"</span>";
 							fn+="<label for='"+n.factorId+"'>"+n.factorName+"</label></li>";
 							}else{
 							fn+="<li><input type='checkbox' name='"+v.dimId+"' id='"+n.factorId+"' class='rjxwgc_checkbox_value' value='"+n.factorId+"' /><span style='display:none'>"+(n.fscore*n.qz)+ai+v.dimName+"</span>";
 							fn+="<label for='"+n.factorId+"'>"+n.factorName+"</label></li>";	
 							}
 						   fcount+=1;
 						});
 				
 					}else{
 						$.each(v.options,function(m,n){
 							
 							if(v.type==1){
 							fn+="<li ><input type='radio' name='"+v.dimId+"' id='"+n.factorId+"' class='rjxwgc_radio_value' value='"+n.factorId+"' /><span style='display:none'>"+(n.fscore*n.qz)+ai+v.dimName+"</span>";
 							fn+="<label for='"+n.factorId+"'>"+n.factorName+"</label></li>";
 							}else{
 							fn+="<li><input type='checkbox' name='"+v.dimId+"' id='"+n.factorId+"' class='rjxwgc_checkbox_value' value='"+n.factorId+"' /><span style='display:none'>"+(n.fscore*n.qz)+ai+v.dimName+"</span>";
 							fn+="<label for='"+n.factorId+"'>"+n.factorName+"</label></li>";	
 							}
 							fcount+=1;
 						});
 					}
 					dl=dl.replace("<span>n</span>","<span>"+fcount+"</span>");
 					
 				});
 				fn+="</ul></div></div>";
 				dl+="</ul>";
 			//console.info(tr.replace("</ul></td></tr>",""));
 				$("#dim_symbol").html(dl.replace("class='dimension_li'","class='dimension_li dimension_current'"));
 				$("#dim_symbol").after(fn.replace("</ul></div>","").replace("hide",""));
    	  }else{
    		  alert("该任务编号没有绑定量表");
    	  }
    	}
    });
}//end
function cjgcycyqData(qh){
	//异常狱情部分
	$.ajax({
		url:"/oasm/lbk/ycyqpc",
		type:"post",
		dataType:"JSON",
		data:{qh:qh},
		success:function(data){
			var s="";
		  $.each(data,function(k,v){
			  s+="<div class='ycyqxx_title'>异常狱情信息"+(k+1)+"</div>";
			  s+="<hr class='lb_divider'/>";
			  s+="<table>";
			  s+="<tr class='ycyqxx_trj'>";
			  s+="<td class='ycyqxx_td01'>发生时间</td>";
			  s+="<td class='ycyqxx_td02'>"+timeStamp2String(v.fssj)+"</td>";
			  s+="<td class='ycyqxx_td01'>排查类别</td>";
			  s+="<td class='ycyqxx_td03'>"+v.zljb+"</td>";
			  s+="<td class='ycyqxx_td01'>狱情变化</td>";
			  s+="<td class='ycyqxx_td04'>"+v.sjjsm+"</td>";
			  s+="</tr>";
			  s+="<tr class='ycyqxx_trx'>";
			  s+="<td class='ycyqxx_td01'>狱情描述</td>";
			  s+="<td colspan='5'>"+v.yqms+"</td>";
			  s+="</tr>";
			  s+="<tr class='ycyqxx_trx'>";
			  s+="<td class='ycyqxx_td01'>异常情况分析</td>";
			  s+="<td colspan='5'>"+v.yqfx+"</td>";
			  s+="</tr></table>";
		  });
		  $(".matching_table").html(s);
		  if(s!=""){
			  $(".matching_table").show();
			  $("#cj_select_da_list").css("width","70%");
		  }
		}
	});
}//end
	  
//出监行为观察保存操作
function cjxwgc_da_save(){
	var radio_option="";
	var checkbox_option="";
	var radio_score = 0;
	var checkbox_score = 0;
	$(".rjxwgc_radio_value:checked").each(function(m,n){
		var fId = $(n).val(); //因子编号
		var fName = $(n).parent("li").children("label").text(); //因子名称
		var dimId = $(n).attr("name"); //维度编号
		var spfd = $(n).next("span").text().trim().split("@");
		var fscore = spfd[0]; //因子分数
		var dimName = spfd[1]; //维度名称
		radio_score+=parseFloat(fscore); //单选部分的分数
		radio_option+=fId+"#"+fName+"#"+dimId+"#"+dimName+"#"+fscore+"@@";
	});
	
	$(".rjxwgc_checkbox_value:checked").each(function(m,n){
		var fId = $(n).val(); //因子编号
		var fName = $(n).parent("li").children("label").text(); //因子名称
		var dimId = $(n).attr("name"); //维度编号
		var spfd = $(n).next("span").text().trim().split("@");
		var fscore = spfd[0];
		var dimName = spfd[1];
		checkbox_score+=parseFloat(fscore);
		checkbox_option+=fId+"#"+fName+"#"+dimId+"#"+dimName+"#"+fscore+"@@";
	});
	var score = radio_score+checkbox_score;
	var taskId = $(".hidde_taskId").val(); //获取任务编号
	var raletjh = $("#hidden_cjgcjh").text().trim(); //关联的警号
	var answer = checkbox_option+radio_option; //回答的问题
	
	//执行保存答案操作
	$.ajax({
		url:"/oasm/ztk/addNoteAnswer",
		type:"post",
		dataType:"JSON",
		data:{taskId:taskId,answer:answer,score:score,raletjh:raletjh},
		success:function(i){
			if(i==1){
				alert("保存成功");
			}else{
				alert("保存失败，请稍后重试...");
			}
		}
	});
}

function loadCjgcrs(taskId,url){
	$('#basecontent').load(url,function(){
		cjgcrsData(taskId); //加载出监行为观察答题记录
	});
}
function cjgcrsData(taskId){
	$.ajax({
		url:"/oasm/ztk/getNoteRecord",
		type:"post",
		dataType:"JSON",
		data:{taskId:taskId},
		success:function(data){
			if(null!=data.answer&&""!=data.answer){
					var jsonData = JSON.parse(data.answer);
					var a = "";
					var b = 0;
					var col = 0;
					$.each(jsonData,function(k,v){
						if(col%2==0){
							a+="<tr>";
							a+="<td class='border_line1'>"+v.fName+"</td>";
							a+="<td class='border_line2 bg_fs'>"+v.score+"</td>"
							a+="<td></td>";
							b=v.scores;
						}else{
							a+="<td class='border_line1'>"+v.fName+"</td>";
							a+="<td class='border_line2 bg_fs'>"+v.score+"</td>"
							a+="</tr>";
							b=v.scores;							
						}
						col+=1;
					});
					if(col%2==0){
						a+="</tr>";
					}
					$(".lb_content_table tbody").eq(1).append(a);
					$(".lb_zf span").html(b);
			}else{
				alert("异常，系统异常");
			}
		}
	});
}//end	
	