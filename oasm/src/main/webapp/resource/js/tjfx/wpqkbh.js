

function getWPQK(sj1,sj2){
	$.ajax({
		url:'/oasm/tjfxView/getWpqkbh',
		type:'get',
		async:false,
		data:{'sj1':sj1,'sj2':sj2},
		dataType:'json',
		success:function(data){
			if(data == null || data ==''){return ;};
//			console.info("data:"+data.list1);
//			var eval=eval(data.list1);
//			console.info(eval);
			var aa = "";
			var sj1jg= 0;
			var sj2jg= 0;
			var sj1gd= 0;
			var sj2gd= 0;
			var sj1zd= 0;
			var sj2zd= 0;
			var sj1dd= 0;
			var sj2dd= 0;
			$.each(data.list1,function(a,b){
//				console.info(b);
				$.each(data.list2,function(c,d){
//					console.info(d)
					if(b.jq==d.jq){
//						console.info(d.jq)
						sj1jg+=b.jg;
						sj2jg+=d.jg;
						sj1gd+=b.gd;
						sj2gd+=d.gd;
						sj1zd+=b.zd;
						sj2zd+=d.zd;
						sj1dd+=b.dd;
						sj2dd+=d.dd;
						aa+="<tr>";
						aa+="<th>"+b.jq+"</th>";//监区
						aa+="<td class='tjfx_td01'>"+b.jg+"</td>";//时间1总数
						aa+="<td class='tjfx_td02'>"+(d.jg-b.jg)+"</td>";//新增
						aa+="<td class='tjfx_td03'>"+d.jg+"</td>";//时间2总数
						aa+="<td class='tjfx_td04'>0</td>";//顽危犯人数
						aa+="<td class='tjfx_td05'>0</td>";//重点犯人数
						aa+="<td class='tjfx_td01'>"+b.gd+"</td>";//时间1总数
						aa+="<td class='tjfx_td02'>"+(d.gd-b.gd)+"</td>";//新增
						aa+="<td class='tjfx_td03'>"+d.gd+"</td>";//时间2总数
						aa+="<td class='tjfx_td04'>0</td>";//顽危犯人数
						aa+="<td class='tjfx_td05'>0</td>";//重点犯人数
						aa+="<td class='tjfx_td01'>"+b.zd+"</td>";//时间1总数
						aa+="<td class='tjfx_td02'>"+(d.zd-b.zd)+"</td>";//新增
						aa+="<td class='tjfx_td03'>"+d.zd+"</td>";//时间2总数
						aa+="<td class='tjfx_td01'>"+b.dd+"</td>";//时间1总数
						aa+="<td class='tjfx_td02'>"+(d.dd-b.dd)+"</td>";//新增
						aa+="<td class='tjfx_td03'>"+d.dd+"</td>";//时间2总数
						aa+="<td class='tjfx_td06'>"+(d.jg+d.gd+d.zd+d.dd)+"</td>";//监区总数（中期）
						aa+="</tr>";
					}
				})
//				console.info(a);
			})
			
			aa+="<tr>";
			aa+="<th>监狱总数</th>";
			aa+="<td class='tjfx_td01'>"+sj1jg+"</td>";//时间1总数
			aa+="<td class='tjfx_td02'>"+(sj2jg-sj1jg)+"</td>";//新增
			aa+="<td class='tjfx_td03'>"+sj2jg+"</td>";//时间2总数
			aa+="<td class='tjfx_td04'>0</td>";//顽危犯人数
			aa+="<td class='tjfx_td05'>0</td>";//重点犯人数
			aa+="<td class='tjfx_td01'>"+sj1gd+"</td>";//时间1总数
			aa+="<td class='tjfx_td02'>"+(sj2gd-sj1gd)+"</td>";//新增
			aa+="<td class='tjfx_td03'>"+sj2gd+"</td>";//时间2总数
			aa+="<td class='tjfx_td04'>0</td>";//顽危犯人数
			aa+="<td class='tjfx_td05'>0</td>";//重点犯人数
			aa+="<td class='tjfx_td01'>"+sj1zd+"</td>";//时间1总数
			aa+="<td class='tjfx_td02'>"+(sj2zd-sj1zd)+"</td>";//新增
			aa+="<td class='tjfx_td03'>"+sj2zd+"</td>";//时间2总数
			aa+="<td class='tjfx_td01'>"+sj1dd+"</td>";//时间1总数
			aa+="<td class='tjfx_td02'>"+(sj2dd-sj1dd)+"</td>";//新增
			aa+="<td class='tjfx_td03'>"+sj2dd+"</td>";//时间2总数
			aa+="<td class='tjfx_td06'>"+(sj2jg+sj2gd+sj2zd+sj2dd)+"</td>";//监区总数（中期）
			aa+="</tr>";
			
			aa+="<tr>";
			aa+="<th>占监狱总数比例</th>";
			aa+="<td></td>";
			aa+="<td></td>";
			aa+="<td>"+(sj2jg/(sj2jg+sj2gd+sj2zd+sj2dd)*100).toFixed(2)+"%</td>";
			aa+="<td></td>";
			aa+="<td></td>";
			aa+="<td></td>";
			aa+="<td></td>";
			aa+="<td>"+(sj2gd/(sj2jg+sj2gd+sj2zd+sj2dd)*100).toFixed(2)+"%</td>";
			aa+="<td></td>";
			aa+="<td></td>";
			aa+="<td></td>";
			aa+="<td></td>";
			aa+="<td>"+(sj2zd/(sj2jg+sj2gd+sj2zd+sj2dd)*100).toFixed(2)+"%</td>";
			aa+="<td></td>";
			aa+="<td></td>";
			aa+="<td>"+(sj2dd/(sj2jg+sj2gd+sj2zd+sj2dd)*100).toFixed(2)+"%</td>";
			aa+="<td></td>";
			aa+="</tr>";
			
//			console.info(a);
			$("#wxqklist").html(aa);
		}
	})
}


$(function(){
//	$('body').addClass('loaded');
//	alert("危评情况变化页面");
	 //昨天的时间
	var day1 = new Date();
	day1.setTime(day1.getTime()-24*60*60*1000);
	var s1 = day1.getFullYear()+"-" + (day1.getMonth()+1) + "-" + day1.getDate();//昨天日期
	
	var s2=new Date().toLocaleDateString().replace(new RegExp('/','gm'), "-");//今天日期
	
//	console.info(s1);
	var test = '2017-11-30';
	getWPQK(test,test);
//	getWPQK(s1,s2);
	
	//默认查询日期区间
	$("#date1").val(s1);
	$("#date2").val(s2);
	
	$(".button_submit2").click(function(){
		var val1=$("#date1").val();
		var val2=$("#date2").val();
		var d1 = new Date(val1);
		var d2 = new Date(val2);
		var d = new Date();
		var first = new Date();
		$.ajax({
			url:'/oasm/tjfxView/getTopDate',
			type:'get',
			async:false,
			dataType:'json',
			success:function(data){
				console.info("data: "+data)
				first = new Date(data);//最早的评估报告的时间
			}
		});
//		console.info("d1-------"+d1);
		if(first<=d1){
//			console.info("d2-------  "+d2);
			if(d2<=d){
				if(d1<=d2){
					getWPQK(val1,val2);
				}else{
					alert("开始时间不能大于结束时间");
				}
			}else{
				alert("结束时间能为未来日期");
			}
		}else{
			alert("开始时间不能早于："+first.toLocaleDateString().replace(new RegExp('/','gm'), "-")+"\n请重新选择。");
		}
//		console.info(val1+"***"+val2);
	});
	
});