$(function(){
	//出监再犯罪统计
	$.ajax({
		url:"/oasm/tjfxView/listTjZfz",
		dataType:"json",
		type:"post",
		success:function(data){
			//无数据时，return
			if(data == null || data == ''){
				$("#tjcjzf").html("<tr><td colspan='10'>无数据</td></tr>");
				return;
			}
			// 基于准备好的dom，初始化echarts实例
			var myChart = echarts.init(document.getElementById('bar'));
			myChart.showLoading();
			
			var a = '';//表格内容
			var zs = 0;//总人数
			
			var jg = 0;//极高
			var gd = 0;//高度
			var zd = 0;//中度
			var dd = 0;//低度
			var jy = 0;//监狱总人数
			
			var ejq = [];//图表监区
			var ejg = [];//图表极高
			var egd = [];//图表高度
			var ezd = [];//图表中度
			var edd = [];//图表低度
			
			
			$.each(data,function(k,v){
//				console.info(v)
				zs=v.jg+v.gd+v.zd+v.dd;
				
				jg += v.jg;
				gd += v.gd;
				zd += v.zd;
				dd += v.dd;
				jy += zs;
				
				//图表添加数据
				ejq.push(v.jq);
				ejg.push(v.jg);
				egd.push(v.gd);
				ezd.push(v.zd);
				edd.push(v.dd);
				
				a+="<tr>";
				a+="<td>"+v.jq+"</td>";
				a+="<td>"+v.jg+"</td>";
				a+="<td>"+(v.jg / zs * 100).toFixed(2)+"%</td>";
				a+="<td>"+v.gd+"</td>";
				a+="<td>"+(v.gd / zs * 100).toFixed(2)+"%</td>";
				a+="<td>"+v.zd+"</td>";
				a+="<td>"+(v.zd / zs * 100).toFixed(2)+"%</td>";
				a+="<td>"+v.dd+"</td>";
				a+="<td>"+(v.dd / zs * 100).toFixed(2)+"%</td>";
				a+="<td>"+zs+"</td>";
				a+="</tr>";
			})
			
			//添加监狱数据
			ejq.push('监狱');
			ejg.push(jg);
			egd.push(gd);
			ezd.push(zd);
			edd.push(dd);
			
			a+="<tr>";
			a+="<td>监狱</td>";
			a+="<td>"+(jg / jy * 100).toFixed(2)+"%</td>";
			a+="<td>"+jg+"</td>";
			a+="<td>"+(gd / jy * 100).toFixed(2)+"%</td>";
			a+="<td>"+gd+"</td>";
			a+="<td>"+(zd / jy * 100).toFixed(2)+"%</td>";
			a+="<td>"+zd+"</td>";
			a+="<td>"+(dd / jy * 100).toFixed(2)+"%</td>";
			a+="<td>"+dd+"</td>";
			a+="<td>"+jy+"</td>";
			a+="</tr>";
			
			$("#tjcjzf").html(a);
			
			//出监再犯罪统计echarts-----------------------------------------------------------
			option = {
				    tooltip : {
				        trigger: 'axis',
				        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
				            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
				        }
				    },
				    legend: {
				    	data:['极高','高度','中度','低度']
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
				            name:'极高',
				            type:'bar',
//				            barWidth : 5,
				            data: ejg
				        },
				        {
				            name:'高度',
				            type:'bar',
				            data: egd
				        },
				        {
				            name:'中度',
				            type:'bar',
				            data: ezd
				        },
				        {
				            name:'低度',
				            type:'bar',
				            data: edd
				        }
				    ]
				};
			myChart.setOption(option);
			myChart.hideLoading(); // 隐藏加载动画
		}
	});
})






