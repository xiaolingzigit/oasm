$(function() {
	// 基于准备好的dom，初始化echarts实例
	var myChart = echarts.init(document.getElementById('bar'));

	// 指定图表的配置项和数据
	var option = {
		title : {
			text : '危险类别统计', // 标题文本内容
		},
		tooltip : {
			trigger : 'axis',
			axisPointer : { // 坐标轴指示器，坐标轴触发有效
				type : 'shadow' // 默认为直线，可选为：'line' | 'shadow'
			}
		},
		legend : {
			data : [ "自杀", "行凶", "脱逃", "再犯罪" ]
		},
		grid : {
			left : '3%',
			right : '4%',
			bottom : '3%',
			containLabel : true
		},
		yAxis : {
			type : 'value'
		},
		xAxis : {
			type : 'category',
			data : [ '一监区', '二监区', '三监区', '四监区', '五监区', '六监区', '七监区', '八监区',
					'九监区', '十监区', '十二监区', '医院监区', '出监管区', '新犯队', '狱政科' ]
		},
		series : [ {
			name : '自杀',
			type : 'bar',
			stack : '总量',
			label : {
				normal : {
					show : true,
					position : 'insideRight'
				}
			},
			data : [ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ]
		}, {
			name : '行凶',
			type : 'bar',
			stack : '总量',
			label : {
				normal : {
					show : true,
					position : 'insideRight'
				}
			},
			data : [ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ]
		}, {
			name : '脱逃',
			type : 'bar',
			stack : '总量',
			label : {
				normal : {
					show : true,
					position : 'insideRight'
				}
			},
			data : [ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ]
		}, {
			name : '再犯罪',
			type : 'bar',
			stack : '总量',
			label : {
				normal : {
					show : true,
					position : 'insideRight'
				}
			},
			data : [ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ]

		} ]
	};
	myChart.showLoading();
	myChart.setOption(option);

	// console.info('进入wxlvtj.jsp;tjfxView#getVTjwxlx方法');
	// 显示高危险倾向列表
	$.ajax({
		url : '/oasm/tjfxView/getVTjwxlx',
		type : 'post',
		dataType : 'json',
		success : function(data) {
			// console.info(data);
			var text = '';
			// data=null;
			if (data == null || data == '') {
				myChart.hideLoading(); // 隐藏加载动画
				text = "<tr><td colspan='10' >无数据</td></tr>";
				$("#tjwxlx").html(text);
				return;
			}
			//表格数据
			var zsl = 0;//总人数
			var zssl = 0;//自杀人数
			var xxsl = 0;//行凶人数
			var ttsl = 0;//脱逃人数
			var zfzsl = 0;//再犯罪人数
			// 图表数据
			var jq = [];// 监区
			var zsnum = [];// 自杀数量
			var xxnum = [];// 行凶数量
			var ttnum = [];// 脱逃数量
			var zfznum = [];// 再犯罪数量
			// 遍历监区
			$.each(data, function(k, v) {
				zsl += v.zsl;
				zssl += v.zssl;
				xxsl += v.xxsl;
				ttsl += v.ttsl;
				zfzsl += v.zfzsl;

				jq.push(v.gyjq);
				zsnum.push(v.zssl);
				xxnum.push(v.xxsl);
				ttnum.push(v.ttsl);
				zfznum.push(v.zfzsl);

				text += "<tr>";
				text += "<td>" + v.gyjq + "</td>";
				text += "<td>" + v.zsl + "</td>";
				text += "<td style='color:red'>" + (v.zssl / v.zsl * 100).toFixed(2) + "%</td>";
				text += "<td class='js-rg-btn1'>" + v.zssl + "</td>";
				text += "<td style='color:red'>" + (v.xxsl / v.zsl * 100).toFixed(2) + "%</td>";
				text += "<td class='js-rg-btn2'>" + v.xxsl + "</td>";
				text += "<td style='color:red'>" + (v.ttsl / v.zsl * 100).toFixed(2) + "%</td>";
				text += "<td class='js-rg-btn3'>" + v.ttsl + "</td>";
				text += "<td style='color:red'>" + (v.zfzsl / v.zsl * 100).toFixed(2) + "%</td>";
				text += "<td class='js-rg-btn4'>" + v.zfzsl + "</td>";
				text += "</tr>";
			})
			// 全监区
			text += "<tr>";
			text += "<td>全监</td>";
			text += "<td>" + zsl + "</td>";
			text += "<td style='color:red'>" + (zssl / zsl * 100).toFixed(2) + "%</td>";
			text += "<td class='js-rg-btn1'>" + zssl + "</td>";
			text += "<td style='color:red'>" + (xxsl / zsl * 100).toFixed(2) + "%</td>";
			text += "<td class='js-rg-btn2'>" + xxsl + "</td>";
			text += "<td style='color:red'>" + (ttsl / zsl * 100).toFixed(2) + "%</td>";
			text += "<td class='js-rg-btn3'>" + ttsl + "</td>";
			text += "<td style='color:red'>" + (zfzsl / zsl * 100).toFixed(2) + "%</td>";
			text += "<td class='js-rg-btn4'>" + zfzsl + "</td>";
			text += "</tr>";

			$("#tjwxlx").html(text);
			// ------------------------------------------------------------------
			// 加载echarts
			// console.info('加载危险类型统计echarts')
			// console.info(jq);
			// console.info(zsnum);
			// console.info(xxnum);
			// console.info(ttnum);
			// console.info(zfznum);
			myChart.hideLoading(); // 隐藏加载动画
			myChart.setOption({
				xAxis : {
					type : 'category',
					data : jq
				},
				series : [ {
					name : '自杀',
					type : 'bar',
					stack : '总量',
					label : {
						normal : {
							show : true,
							position : 'insideRight'
						}
					},
					data : zsnum
				}, {
					name : '行凶',
					type : 'bar',
					stack : '总量',
					label : {
						normal : {
							show : true,
							position : 'insideRight'
						}
					},
					data : xxnum
				}, {
					name : '脱逃',
					type : 'bar',
					stack : '总量',
					label : {
						normal : {
							show : true,
							position : 'insideRight'
						}
					},
					data : ttnum
				}, {
					name : '再犯罪',
					type : 'bar',
					stack : '总量',
					label : {
						normal : {
							show : true,
							position : 'insideRight'
						}
					},
					data : zfznum
				} ]
			});
		}
	});
})