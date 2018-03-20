function loadZqftlb(taskId,url){
	$('#basecontent').load(url,function(){
		zqftScale(taskId); //加载中期访谈所需量表
	});
}
function zqftScale(taskId){
	$.ajax({
		url:"/oasm/ztk/zqjgft_start_question",
		dataType:"JSON",
		type:"post",
		data:{taskId:taskId},
		success:function(data){
			if(data!=null&&data!=""){
				var dataJSON = JSON.parse(data);
				var tr = "";
				var syli="";
				var ai = "@";
				  $.each(dataJSON,function(k,v){
						tr+="<div class='sub_q hide'>";
					    tr+="<div class='lb_question'>"+(k+1)+"."+v.qName+"<input type='hidden' class='hidetask_id' value='"+taskId+"'/></div>"; //量表序列
					    tr+="<div class='lb_options'><ul>";
					    syli+="<li class='symbol_li_l' id='lbq"+v.qId+"_symbol'>"+(k+1)+"</li>";
					    $.each(v.options,function(m,n){
					     if(v.type==1){
					    	 tr+="<li><input id='"+n.factorId+"' class='save_question_record_radio' value='"+v.dimId+"'	 type='radio' name='lbq"+v.qId+"' />"; //因子
					    	 tr+="<span style='display:none'>"+(n.fscore*n.qz)+ai+v.dimName+"</span>";
							 tr+="<label for='"+n.factorId+"'>"+n.factorName+"</label>";
							 tr+="</li>";
					     }else{
					    	 tr+="<li><input id='"+n.factorId+"' class='save_question_record_checkbox' value='"+v.dimId+"'	 type='checkbox' name='lbq"+v.qId+"' />";
					    	 tr+="<span style='display:none'>"+(n.fscore*n.qz)+ai+v.dimName+"</span>";
					    	 tr+="<label for='"+n.factorId+"'>"+n.factorName+"</label>";
							 tr+="</li>";
					     }
					    });
					    tr+="</ul></div>";
					    tr+="<fieldset class='lb_judge'><legend>判断依据</legend><p>"+v.qRemark+"</p ></fieldset>"; //问题判断依据
					    tr+="</div>";
					  });
					tr=tr.replace("hide");
				   $("#question_area").html(tr);
				   $("#question_symbol").html(syli);
			}else{
				alert("该罪犯的任务没有绑定量表，请先绑定量表");
			}
			
		}
	});
}//end
	
//保存中期结构访谈答题记录
function zqjgft_da_save(){
	var radio_option="";
	var checkbox_option="";
	var radio_score = 0;
	var checkbox_score = 0;
	$(".save_question_record_radio:checked").each(function(i,n){
		var fId = $(n).attr('id'); //拿到因子编号
		var faName = $(n).next("span").next("label").text(); //拿到因子的名称
		var dimId = $(n).val(); //拿到维度编号
		var scdim = $(n).next("span").eq(0).text().split("@"); //因子分数+维度名称
		var fscore = scdim[0];
		var dimName = scdim[1];
		radio_score+=parseFloat(fscore); //单选的分数
		radio_option+=fId+"#"+faName+"#"+dimId+"#"+dimName+"#"+fscore+"@@";
	});
	
	$(".save_question_record_checkbox:checked").each(function(i,n){
		var fId = $(n).attr('id');
		var faName = $(n).next("span").next("label").text(); //拿到因子的名称
		var dimId = $(n).val(); //拿到维度编号
		var scdim = $(n).next("span").eq(0).text().split("@"); //因子分数+维度名称
		var fscore = scdim[0];
		var dimName = scdim[1];
		checkbox_score+=parseFloat(fscore); //多选的分数
		checkbox_option+=fId+"#"+faName+"#"+dimId+"#"+dimName+"#"+fscore+"@@";
	});
	var score = radio_score+checkbox_score; //总分
	var answer = checkbox_option+radio_option;
	var taskId = $(".hidetask_id").val(); 
	var raletjh = $("#hidezqjgft_jh").text().trim();
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

//中期结构访谈答题记录结果表
function loadZqftrs(taskId,url){
	$('#basecontent').load(url,function(){
		zqftData(taskId); //调用加载中期访谈答题记录数据
	});
}
function zqftData(taskId){
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
					var col=0;
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
	