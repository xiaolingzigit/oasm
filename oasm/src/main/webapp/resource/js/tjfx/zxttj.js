$(function(){
	$.ajax({
		url:'/oasm/tjfxView/listTjWxlx',
		type:'post',
		dataType:'json',
		success:function(data){
//			console.info(data);
			//无数据时，return
			if(data == null || data == ''){
				$("#tjzxt").html("<tr><td colspan='16'>无数据</td></tr>");
				return;
			}
			var myChart = echarts.init(document.getElementById('bar'));
			myChart.showLoading();
			
			var a = '';//表格内容
			var zs = 0;//监区总人数
			
			//监狱统计
			var zsjg = 0;//自杀极高
			var zsgd = 0;//自杀高度
			var zszd = 0;//自杀中度
			var zsdd = 0;//自杀低度
			var xxjg = 0;//行凶极高
			var xxgd = 0;//行凶高度
			var xxzd = 0;//行凶中度
			var xxdd = 0;//行凶低度
			var ttjg = 0;//脱逃极高
			var ttgd = 0;//脱逃高度
			var ttzd = 0;//脱逃中度
			var ttdd = 0;//脱逃低度
			var jyzs = 0;//监狱总人数
			
			var ejq = [];//图表监区
			var ezsjg = [];//图表自杀极高
			var ezsgd = [];//图表自杀高度
			var ezszd = [];//图表自杀中度
			var ezsdd = [];//图表自杀低度
			var exxjg = [];//图表行凶极高
			var exxgd = [];//图表行凶高度
			var exxzd = [];//图表行凶中度
			var exxdd = [];//图表行凶低度
			var ettjg = [];//图表脱逃极高
			var ettgd = [];//图表脱逃高度
			var ettzd = [];//图表脱逃中度
			var ettdd = [];//图表脱逃低度
			
			$.each(data,function(k,v){
				
				zs=v.ttdd+v.ttzd+v.ttgd+v.ttjg;
				
				zsjg += v.zsjg; 
				zsgd += v.zsgd; 
				zszd += v.zszd; 
				zsdd += v.zsdd; 
				xxjg += v.xxjg; 
				xxgd += v.xxgd; 
				xxzd += v.xxzd; 
				xxdd += v.xxdd; 
				ttjg += v.ttjg; 
				ttgd += v.ttgd; 
				ttzd += v.ttzd; 
				ttdd += v.ttdd; 
				jyzs += zs;
				
				//图表添加数据
				ejq.push(v.jq);
				ezsjg.push(v.zsjg);
				ezsgd.push(v.zsgd);
				ezszd.push(v.zszd);
				ezsdd.push(v.zsdd);
				exxjg.push(v.xxjg);
				exxgd.push(v.xxgd);
				exxzd.push(v.xxzd);
				exxdd.push(v.xxdd);
				ettjg.push(v.ttjg);
				ettgd.push(v.ttgd);
				ettzd.push(v.ttzd);
				ettdd.push(v.ttdd);
				
				a+="<tr>";
				a+="<td>"+v.jq+"</td>";
				a+="<td>"+v.zsjg+"</td>";
				a+="<td>"+v.zsgd+"</td>";
				a+="<td>"+v.zszd+"</td>";
				a+="<td>"+v.zsdd+"</td>";
				a+="<td>"+v.xxjg+"</td>";
				a+="<td>"+v.xxgd+"</td>";
				a+="<td>"+v.xxzd+"</td>";
				a+="<td>"+v.xxdd+"</td>";
				a+="<td>"+v.ttjg+"</td>";
				a+="<td>"+v.ttgd+"</td>";
				a+="<td>"+v.ttzd+"</td>";
				a+="<td>"+v.ttdd+"</td>";
				a+="<td>"+zs+"</td>";
				a+="</tr>";
			})
			
			ejq.push('监狱');
			ezsjg.push(zsjg);
			ezsgd.push(zsgd);
			ezszd.push(zszd);
			ezsdd.push(zsdd);
			exxjg.push(xxjg);
			exxgd.push(xxgd);
			exxzd.push(xxzd);
			exxdd.push(xxdd);
			ettjg.push(ttjg);
			ettgd.push(ttgd);
			ettzd.push(ttzd);
			ettdd.push(ttdd);

			
			
			a+="<tr>";
			a+="<td>监狱</td>";
			a+="<td>"+zsjg+"</td>";
			a+="<td>"+zsgd+"</td>";
			a+="<td>"+zszd+"</td>";
			a+="<td>"+zsdd+"</td>";
			a+="<td>"+xxjg+"</td>";
			a+="<td>"+xxgd+"</td>";
			a+="<td>"+xxzd+"</td>";
			a+="<td>"+xxdd+"</td>";
			a+="<td>"+ttjg+"</td>";
			a+="<td>"+ttgd+"</td>";
			a+="<td>"+ttzd+"</td>";
			a+="<td>"+ttdd+"</td>";
			a+="<td>"+jyzs+"</td>";
			a+="</tr>";
			
			$("#tjzxt").html(a);
			
			//罪犯自杀、行凶、脱逃倾向统计echarts-----------------------------------------------------------
			option = {
				    tooltip : {
				        trigger: 'axis',
				        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
				            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
				        }
				    },
				    legend: {
				    	data:['自杀极高','自杀高度','自杀中度','自杀低度','行凶极高','行凶高度','行凶中度','行凶低度','脱逃极高','脱逃高度','脱逃中度','脱逃低度']
				    },
				    grid: {
				        left: '3%',
				        right: '4%',
				        bottom: '3%',
				        containLabel: true
				    },
				    xAxis : [
				        {
				            type : 'category',
				            data : ejq
				        }
				    ],
				    yAxis : [
				        {
				            type : 'value'
				        }
				    ],
				    series : [
				        {
				            name:'自杀极高',
				            type:'bar',
				            stack: '自杀倾向',
				            data: ezsjg
				        },
				        {
				            name:'自杀高度',
				            type:'bar',
				            stack: '自杀倾向',
				            data: ezsgd
				        },
				        {
				            name:'自杀中度',
				            type:'bar',
				            stack: '自杀倾向',
				            data: ezszd
				        },
				        {
				            name:'自杀低度',
				            type:'bar',
				            stack: '自杀倾向',
				            data: ezsdd
				        },
				        {
				            name:'行凶极高',
				            type:'bar',
				            stack: '行凶倾向',
				            data: exxjg
				        },
				        {
				            name:'行凶高度',
				            type:'bar',
				            stack: '行凶倾向',
				            data: exxgd
				        },
				        {
				            name:'行凶中度',
				            type:'bar',
				            stack: '行凶倾向',
				            data: exxzd
				        },
				        {
				            name:'行凶低度',
				            type:'bar',
				            stack: '行凶倾向',
				            data: exxdd
				        },
				        {
				            name:'脱逃极高',
				            type:'bar',
				            stack: '脱逃倾向',
				            data: ettjg
				        },
				        {
				            name:'脱逃高度',
				            type:'bar',
				            stack: '脱逃倾向',
				            data: ettgd
				        },
				        {
				            name:'脱逃中度',
				            type:'bar',
				            stack: '脱逃倾向',
				            data: ettzd
				        },
				        {
				            name:'脱逃低度',
				            type:'bar',
				            stack: '脱逃倾向',
				            data: ettdd
				        }
				    ]
				};
			myChart.setOption(option);
			myChart.hideLoading(); // 隐藏加载动画
			
			
			
			
			
			
			
			
			
			
		}
	})
})