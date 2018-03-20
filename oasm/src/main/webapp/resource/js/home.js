$.ajaxSetup({
	cache : false
//关闭AJAX相应的缓存
});
//为0字符串
function isZero(obj){
	if(null!==obj&&obj!==undefined &&obj!==''){
		return true;
	}else{
		return false;
	}
}

$(function() {
	//极高危险类型列表
	$.ajax({
		url : '/oasm/tjfxView/getVPgbgWxlx',
		type : 'post',
		dataType : 'json',
		success : function(data) {
//			console.info(data);
			var text = '';
			if (data == '' || data == null) {
				text += "<tr>";
				text += "<td colspan='8'><div class='not_data'>无极高危险罪犯</div></td>";
				text += "</tr>";
				$("#homeList").html(text);
				return;
			};
			//格式化时间（yyyy/mm/dd）--------------------
			var ymd='';
			var myDate = new Date();
			ymd += myDate.getFullYear()+'/';    //获取完整的年份(4位,1970-????)
			if(myDate.getMonth()<10){
				ymd += '0'+(myDate.getMonth()+1)+'/';
			}else{
				ymd += (myDate.getMonth()+1)+'/';       //获取当前月份(0-11,0代表1月))
			};
			if(myDate.getDate()<10){
				ymd += '0'+myDate.getDate();
			}else{
				ymd += myDate.getDate();        //获取当前日(1-31)
			};
			//--------------------
			$.each(data, function(k, v) {
				//处理空值
				if(v.zs == null || v.zs == ''){v.zs='--'};
				if(v.xx == null || v.xx == ''){v.xx='--'};
				if(v.tt == null || v.tt == ''){v.tt='--'};
				if(v.zfz == null || v.zfz == ''){v.zfz='--'};
				
				if (v.crTime == ymd) {// 1天内的报告显示红色
					text += "<tr style='color:red'>";
				} else {
					text += "<tr>";
				};
				text += "<td style=\"display: none\">" + v.taskId + "</td>";
				text += "<td>" + v.gyjq + "</td>";
				text += "<td>" + v.crimNo + "</td>";
				text += "<td>" + v.xm + "</td>";
				text += "<td>" + v.zs + "</td>";
				text += "<td>" + v.xx + "</td>";
				text += "<td>" + v.tt + "</td>";
				text += "<td>" + v.zfz + "</td>";
				text += "<td>" + v.crTime + "</td>";
				text += "</tr>";
			})
			$("#homeList").html(text);
		}
	});
});

	//首页饼图
	$.ajax({
		url : '/oasm/tjfxView/listVTjwxcd',
		dataType : 'json',
		type : 'post',
		async : false,
		success : function(data) {
			if(data == null || data == ''){return;}
//			console.info(data);
			var jg=0;
			var gd=0;
			var zd=0;
			var dd=0;
			$.each(data,function(k,v){
				switch(v.gyjqmc)
				{
				case '一监区':
					echarts2(v);
					break;
				case '二监区':
					echarts3(v);
					break;
				case '三监区':
					echarts4(v);
					break;
				case '四监区':
					echarts5(v);
					break;
				case '五监区':
					echarts6(v);
					break;
				case '六监区':
					echarts7(v);
					break;
				case '七监区	':
					echarts8(v);
					break;
				case '八监区':
					echarts9(v);
					break;
				case '九监区':
					echarts10(v);
					break;
				case '十监区':
					echarts11(v);
					break;
				case '十二监区':
					echarts12(v);
					break;
				case '出监管区':
					echarts13(v);
				case '新犯队':
//					echarts14(v);
					break;
				case '医院':
					echarts15(v);
					break;
				case '狱政科':
					echarts16(v);
					break;
				default:
					break;
				}
				//'监狱':
				jg+=v.jgdwx;
				gd+=v.gdwx;
				zd+=v.zdwx;
				dd+=v.ddwx;
			});
			j1 = "{\"gyjqmc\": \"监狱\", \"jgdwx\": "+jg+", \"gdwx\": "+gd+", \"zdwx\": "+zd+", \"ddwx\": "+dd+"}";
			echarts1(JSON.parse(j1));
		}
	});

function echarts1 (data){
	if(data == null || data == ''){return};
//	console.info(data);
	var charts1 = echarts.init(document.getElementById('djfb_pie1'));
	var option1 = {
		title : {
			text : '监狱',
			x : 'center'
		},
		tooltip : {
			trigger : 'item',
			formatter : "{a} <br/>{b} : {c} ({d}%)"
		},
		// legend: {
		//     orient: 'vertical',
		//    	x: 'left',
		//     data: ['极高危险','高度危险','中度危险','低度危险','未评估']
		// },
		series : [ {
			name : '危险等级',
			type : 'pie',
			radius : '60%',
			center : [ '50%', '50%' ],
			label : {
				normal : {
					textStyle : {
						fontSize : 18
					}
				}
			},
			data : [ {
				value : data.gdwx,
				name : '高度危险',
				itemStyle : {
					normal : {
						color : '#fc7e18'
					}
				}
			}, {
				value : data.zdwx,
				name : '中度危险',
				itemStyle : {
					normal : {
						color : '#FFC300'
					}
				}
			}, {
				value : data.ddwx,
				name : '低度危险',
				itemStyle : {
					normal : {
						color : '#4169E1'
					}
				}
			} , {
				value : data.jgdwx,
				name : '极高危险',
				itemStyle : {
					normal : {
						color : '#ff0000'
					}
				}
			} ],
			itemStyle : {

				emphasis : {
					shadowBlur : 10,
					shadowOffsetX : 0,
					shadowColor : 'rgba(0, 0, 0, 0.5)'
				}
			}
		}]
	};

	charts1.setOption(option1);

};

function echarts2 (data){
//	console.info('home.js#echarts2');
//	console.info(data);
	if(data == null || data == ''){return};
	var charts2 = echarts.init(document.getElementById('djfb_pie2'));
	var option2 = {
		title : {
			text : '一监区',
			x : 'center'
		},
		tooltip : {
			trigger : 'item',
			formatter : "{a} <br/>{b} : {c} ({d}%)"
		},
		// legend: {
		//     orient: 'vertical',
		//    	x: 'left',
		//     data: ['极高危险','高度危险','中度危险','低度危险','未评估']
		// },
		series : [ {
			name : '危险等级',
			type : 'pie',
			radius : '60%',
			center : [ '50%', '50%' ],
			label : {
				normal : {
					textStyle : {
						fontSize : 18
					}
				}
			},
			data : [ {
				value : data.gdwx,
				name : '高度危险',
				itemStyle : {
					normal : {
						color : '#fc7e18'
					}
				}
			}, {
				value : data.zdwx,
				name : '中度危险',
				itemStyle : {
					normal : {
						color : '#FFC300'
					}
				}
			}, {
				value : data.ddwx,
				name : '低度危险',
				itemStyle : {
					normal : {
						color : '#4169E1'
					}
				}
			},  {
				value : data.jgdwx,
				name : '极高危险',
				itemStyle : {
					normal : {
						color : '#ff0000'
					}
				}
			} ],
			itemStyle : {
				emphasis : {
					shadowBlur : 10,
					shadowOffsetX : 0,
					shadowColor : 'rgba(0, 0, 0, 0.5)'
				}
			}
		} ]
	};

	charts2.setOption(option2);

};

function echarts3 (data){
	if(data == null || data == ''){return}
	var charts3 = echarts.init(document.getElementById('djfb_pie3'));
	var option3 = {
		title : {
			text : '二监区',
			x : 'center'
		},
		tooltip : {
			trigger : 'item',
			formatter : "{a} <br/>{b} : {c} ({d}%)"
		},
		// legend: {
		//     orient: 'vertical',
		//    	x: 'left',
		//     data: ['极高危险','高度危险','中度危险','低度危险','未评估']
		// },
		series : [ {
			name : '危险等级',
			type : 'pie',
			radius : '60%',
			center : [ '50%', '50%' ],
			label : {
				normal : {
					textStyle : {
						fontSize : 18
					}
				}
			},
			data : [ {
				value : data.gdwx,
				name : '高度危险',
				itemStyle : {
					normal : {
						color : '#fc7e18'
					}
				}
			}, {
				value : data.zdwx,
				name : '中度危险',
				itemStyle : {
					normal : {
						color : '#FFC300'
					}
				}
			}, {
				value : data.ddwx,
				name : '低度危险',
				itemStyle : {
					normal : {
						color : '#4169E1'
					}
				}
			}, {
				value : data.jgdwx,
				name : '极高危险',
				itemStyle : {
					normal : {
						color : '#ff0000'
					}
				}
			} ],
			itemStyle : {
				emphasis : {
					shadowBlur : 10,
					shadowOffsetX : 0,
					shadowColor : 'rgba(0, 0, 0, 0.5)'
				}
			}
		} ]
	};

	charts3.setOption(option3);
	window.addEventListener("resize", function() {
		charts3.resize();
	});
};

function echarts4 (data){
	if(data == null || data == ''){return};

	var charts4 = echarts.init(document.getElementById('djfb_pie4'));
	// var charts2 = echarts.init(document.getElementById('djfb_pie2'));
	var option4 = {
		title : {
			text : '三监区',
			x : 'center'
		},
		tooltip : {
			trigger : 'item',
			formatter : "{a} <br/>{b} : {c} ({d}%)"
		},
		// legend: {
		//     orient: 'vertical',
		//    	x: 'left',
		//     data: ['极高危险','高度危险','中度危险','低度危险','未评估']
		// },
		series : [ {
			name : '危险等级',
			type : 'pie',
			radius : '60%',
			center : [ '50%', '50%' ],
			label : {
				normal : {
					textStyle : {
						fontSize : 18
					}
				}
			},
			data : [ {
				value : data.gdwx,
				name : '高度危险',
				itemStyle : {
					normal : {
						color : '#fc7e18'
					}
				}
			}, {
				value : data.zdwx,
				name : '中度危险',
				itemStyle : {
					normal : {
						color : '#FFC300'
					}
				}
			}, {
				value : data.ddwx,
				name : '低度危险',
				itemStyle : {
					normal : {
						color : '#4169E1'
					}
				}
			}, {
				value : data.jgdwx,
				name : '极高危险',
				itemStyle : {
					normal : {
						color : '#ff0000'
					}
				}
			} ],
			itemStyle : {
				emphasis : {
					shadowBlur : 10,
					shadowOffsetX : 0,
					shadowColor : 'rgba(0, 0, 0, 0.5)'
				}
			}
		} ]
	};

	charts4.setOption(option4);
	window.addEventListener("resize", function() {
		charts4.resize();
	});
};

function echarts5 (data){
	if(data == null || data == ''){return};
	var charts5 = echarts.init(document.getElementById('djfb_pie5'));
	var option5 = {
		title : {
			text : '四监区',
			x : 'center'
		},
		tooltip : {
			trigger : 'item',
			formatter : "{a} <br/>{b} : {c} ({d}%)"
		},
		// legend: {
		//     orient: 'vertical',
		//    	x: 'left',
		//     data: ['极高危险','高度危险','中度危险','低度危险','未评估']
		// },
		series : [ {
			name : '危险等级',
			type : 'pie',
			radius : '60%',
			center : [ '50%', '50%' ],
			label : {
				normal : {
					textStyle : {
						fontSize : 18
					}
				}
			},
			data : [ {
				value : data.gdwx,
				name : '高度危险',
				itemStyle : {
					normal : {
						color : '#fc7e18'
					}
				}
			}, {
				value : data.zdwx,
				name : '中度危险',
				itemStyle : {
					normal : {
						color : '#FFC300'
					}
				}
			}, {
				value : data.ddwx,
				name : '低度危险',
				itemStyle : {
					normal : {
						color : '#4169E1'
					}
				}
			}, {
				value : data.jgdwx,
				name : '极高危险',
				itemStyle : {
					normal : {
						color : '#ff0000'
					}
				}
			} ],
			itemStyle : {
				emphasis : {
					shadowBlur : 10,
					shadowOffsetX : 0,
					shadowColor : 'rgba(0, 0, 0, 0.5)'
				}
			}
		} ]
	};

	charts5.setOption(option5);
	window.addEventListener("resize", function() {
		charts5.resize();
	});
};

function echarts6 (data){
	if(data == null || data == ''){return};

	var charts6 = echarts.init(document.getElementById('djfb_pie6'));
	// var charts2 = echarts.init(document.getElementById('djfb_pie2'));
	var option6 = {
		title : {
			text : '五监区',
			x : 'center'
		},
		tooltip : {
			trigger : 'item',
			formatter : "{a} <br/>{b} : {c} ({d}%)"
		},
		// legend: {
		//     orient: 'vertical',
		//    	x: 'left',
		//     data: ['极高危险','高度危险','中度危险','低度危险','未评估']
		// },
		series : [ {
			name : '危险等级',
			type : 'pie',
			radius : '60%',
			center : [ '50%', '50%' ],
			label : {
				normal : {
					textStyle : {
						fontSize : 18
					}
				}
			},
			data : [ {
				value : data.gdwx,
				name : '高度危险',
				itemStyle : {
					normal : {
						color : '#fc7e18'
					}
				}
			}, {
				value : data.zdwx,
				name : '中度危险',
				itemStyle : {
					normal : {
						color : '#FFC300'
					}
				}
			}, {
				value : data.ddwx,
				name : '低度危险',
				itemStyle : {
					normal : {
						color : '#4169E1'
					}
				}
			}, {
				value : data.jgdwx,
				name : '极高危险',
				itemStyle : {
					normal : {
						color : '#ff0000'
					}
				}
			} ],
			itemStyle : {
				emphasis : {
					shadowBlur : 10,
					shadowOffsetX : 0,
					shadowColor : 'rgba(0, 0, 0, 0.5)'
				}
			}
		} ]
	};

	charts6.setOption(option6);
	window.addEventListener("resize", function() {
		charts6.resize();
	});
};

function echarts7 (data){
	if(data == null || data == ''){return};

	var charts7 = echarts.init(document.getElementById('djfb_pie7'));
	// var charts2 = echarts.init(document.getElementById('djfb_pie2'));
	var option7 = {
		title : {
			text : '六监区',
			x : 'center'
		},
		tooltip : {
			trigger : 'item',
			formatter : "{a} <br/>{b} : {c} ({d}%)"
		},
		// legend: {
		//     orient: 'vertical',
		//    	x: 'left',
		//     data: ['极高危险','高度危险','中度危险','低度危险','未评估']
		// },
		series : [ {
			name : '危险等级',
			type : 'pie',
			radius : '60%',
			center : [ '50%', '50%' ],
			label : {
				normal : {
					textStyle : {
						fontSize : 18
					}
				}
			},
			data : [ {
				value : data.gdwx,
				name : '高度危险',
				itemStyle : {
					normal : {
						color : '#fc7e18'
					}
				}
			}, {
				value : data.zdwx,
				name : '中度危险',
				itemStyle : {
					normal : {
						color : '#FFC300'
					}
				}
			}, {
				value : data.ddwx,
				name : '低度危险',
				itemStyle : {
					normal : {
						color : '#4169E1'
					}
				}
			}, {
				value : data.jgdwx,
				name : '极高危险',
				itemStyle : {
					normal : {
						color : '#ff0000'
					}
				}
			} ],
			itemStyle : {
				emphasis : {
					shadowBlur : 10,
					shadowOffsetX : 0,
					shadowColor : 'rgba(0, 0, 0, 0.5)'
				}
			}
		} ]
	};

	charts7.setOption(option7);
	window.addEventListener("resize", function() {
		charts7.resize();
	});
};

function echarts8 (data){
	if(data == null || data == ''){return};

	var charts8 = echarts.init(document.getElementById('djfb_pie8'));
	// var charts2 = echarts.init(document.getElementById('djfb_pie2'));
	var option8 = {
		title : {
			text : '七监区',
			x : 'center'
		},
		tooltip : {
			trigger : 'item',
			formatter : "{a} <br/>{b} : {c} ({d}%)"
		},
		// legend: {
		//     orient: 'vertical',
		//    	x: 'left',
		//     data: ['极高危险','高度危险','中度危险','低度危险','未评估']
		// },
		series : [ {
			name : '危险等级',
			type : 'pie',
			radius : '60%',
			center : [ '50%', '50%' ],
			label : {
				normal : {
					textStyle : {
						fontSize : 18
					}
				}
			},
			data : [ {
				value : data.gdwx,
				name : '高度危险',
				itemStyle : {
					normal : {
						color : '#fc7e18'
					}
				}
			}, {
				value : data.zdwx,
				name : '中度危险',
				itemStyle : {
					normal : {
						color : '#FFC300'
					}
				}
			}, {
				value : data.ddwx,
				name : '低度危险',
				itemStyle : {
					normal : {
						color : '#4169E1'
					}
				}
			} , {
				value : data.jgdwx,
				name : '极高危险',
				itemStyle : {
					normal : {
						color : '#ff0000'
					}
				}
			} ],
			itemStyle : {
				emphasis : {
					shadowBlur : 10,
					shadowOffsetX : 0,
					shadowColor : 'rgba(0, 0, 0, 0.5)'
				}
			}
		} ]
	};

	charts8.setOption(option8);
	window.addEventListener("resize", function() {
		charts8.resize();
	});
};

function echarts9 (data){
	if(data == null || data == ''){return};

	var charts9 = echarts.init(document.getElementById('djfb_pie9'));
	// var charts2 = echarts.init(document.getElementById('djfb_pie2'));
	var option9 = {
		title : {
			text : '八监区',
			x : 'center'
		},
		tooltip : {
			trigger : 'item',
			formatter : "{a} <br/>{b} : {c} ({d}%)"
		},
		// legend: {
		//     orient: 'vertical',
		//    	x: 'left',
		//     data: ['极高危险','高度危险','中度危险','低度危险','未评估']
		// },
		series : [ {
			name : '危险等级',
			type : 'pie',
			radius : '60%',
			center : [ '50%', '50%' ],

			label : {
				normal : {
					textStyle : {
						fontSize : 18
					}
				}
			},
			data : [ {
				value : data.gdwx,
				name : '高度危险',
				itemStyle : {
					normal : {
						color : '#fc7e18'
					}
				}
			}, {
				value : data.zdwx,
				name : '中度危险',
				itemStyle : {
					normal : {
						color : '#FFC300'
					}
				}
			}, {
				value : data.ddwx,
				name : '低度危险',
				itemStyle : {
					normal : {
						color : '#4169E1'
					}
				}
			} , {
				value : data.jgdwx,
				name : '极高危险',
				itemStyle : {
					normal : {
						color : '#ff0000'
					}
				}
			} ],
			itemStyle : {
				emphasis : {
					shadowBlur : 10,
					shadowOffsetX : 0,
					shadowColor : 'rgba(0, 0, 0, 0.5)'
				}
			}
		} ]
	};

	charts9.setOption(option9);
	window.addEventListener("resize", function() {
		charts9.resize();
	});
};

function echarts10 (data){
	if(data == null || data == ''){return};

	var charts10 = echarts.init(document.getElementById('djfb_pie10'));
	// var charts2 = echarts.init(document.getElementById('djfb_pie2'));
	var option10 = {
		title : {
			text : '九监区',
			x : 'center'
		},
		tooltip : {
			trigger : 'item',
			formatter : "{a} <br/>{b} : {c} ({d}%)"
		},
		// legend: {
		//     orient: 'vertical',
		//    	x: 'left',
		//     data: ['极高危险','高度危险','中度危险','低度危险','未评估']
		// },
		series : [ {
			name : '危险等级',
			type : 'pie',
			radius : '60%',
			center : [ '50%', '50%' ],
			label : {
				normal : {
					textStyle : {
						fontSize : 18
					}
				}
			},
			data : [ {
				value : data.gdwx,
				name : '高度危险',
				itemStyle : {
					normal : {
						color : '#fc7e18'
					}
				}
			}, {
				value : data.zdwx,
				name : '中度危险',
				itemStyle : {
					normal : {
						color : '#FFC300'
					}
				}
			}, {
				value : data.ddwx,
				name : '低度危险',
				itemStyle : {
					normal : {
						color : '#4169E1'
					}
				}
			} , {
				value : data.jgdwx,
				name : '极高危险',
				itemStyle : {
					normal : {
						color : '#ff0000'
					}
				}
			} ],
			itemStyle : {
				emphasis : {
					shadowBlur : 10,
					shadowOffsetX : 0,
					shadowColor : 'rgba(0, 0, 0, 0.5)'
				}
			}
		} ]
	};

	charts10.setOption(option10);
	window.addEventListener("resize", function() {
		charts10.resize();
	});
};

function echarts11 (data){
	if(data == null || data == ''){return};

	var charts11 = echarts.init(document.getElementById('djfb_pie11'));
	// var charts2 = echarts.init(document.getElementById('djfb_pie2'));
	var option11 = {
		title : {
			text : '十监区',
			x : 'center'
		},
		tooltip : {
			trigger : 'item',
			formatter : "{a} <br/>{b} : {c} ({d}%)"
		},
		// legend: {
		//     orient: 'vertical',
		//    	x: 'left',
		//     data: ['极高危险','高度危险','中度危险','低度危险','未评估']
		// },
		series : [ {
			name : '危险等级',
			type : 'pie',
			radius : '60%',
			center : [ '50%', '50%' ],
			label : {
				normal : {
					textStyle : {
						fontSize : 18
					}
				}
			},
			data : [ {
				value : data.gdwx,
				name : '高度危险',
				itemStyle : {
					normal : {
						color : '#fc7e18'
					}
				}
			}, {
				value : data.zdwx,
				name : '中度危险',
				itemStyle : {
					normal : {
						color : '#FFC300'
					}
				}
			}, {
				value : data.ddwx,
				name : '低度危险',
				itemStyle : {
					normal : {
						color : '#4169E1'
					}
				}
			} , {
				value : data.jgdwx,
				name : '极高危险',
				itemStyle : {
					normal : {
						color : '#ff0000'
					}
				}
			} ],
			itemStyle : {
				emphasis : {
					shadowBlur : 10,
					shadowOffsetX : 0,
					shadowColor : 'rgba(0, 0, 0, 0.5)'
				}
			}
		} ]
	};

	charts11.setOption(option11);
	window.addEventListener("resize", function() {
		charts11.resize();
	});
};

function echarts12 (data){
	if(data == null || data == ''){return};

	var charts12 = echarts.init(document.getElementById('djfb_pie12'));
	// var charts2 = echarts.init(document.getElementById('djfb_pie2'));
	var option12 = {
		title : {
			text : '十二监区',
			x : 'center'
		},
		tooltip : {
			trigger : 'item',
			formatter : "{a} <br/>{b} : {c} ({d}%)"
		},
		// legend: {
		//     orient: 'vertical',
		//    	x: 'left',
		//     data: ['极高危险','高度危险','中度危险','低度危险','未评估']
		// },
		series : [ {
			name : '危险等级',
			type : 'pie',
			radius : '60%',
			center : [ '50%', '50%' ],
			label : {
				normal : {
					textStyle : {
						fontSize : 18
					}
				}
			},
			data : [ {
				value : data.gdwx,
				name : '高度危险',
				itemStyle : {
					normal : {
						color : '#fc7e18'
					}
				}
			}, {
				value : data.zdwx,
				name : '中度危险',
				itemStyle : {
					normal : {
						color : '#FFC300'
					}
				}
			}, {
				value : data.ddwx,
				name : '低度危险',
				itemStyle : {
					normal : {
						color : '#4169E1'
					}
				}
			} , {
				value : data.jgdwx,
				name : '极高危险',
				itemStyle : {
					normal : {
						color : '#ff0000'
					}
				}
			} ],
			itemStyle : {
				emphasis : {
					shadowBlur : 10,
					shadowOffsetX : 0,
					shadowColor : 'rgba(0, 0, 0, 0.5)'
				}
			}
		} ]
	};

	charts12.setOption(option12);
	window.addEventListener("resize", function() {
		charts12.resize();
	});
};

function echarts13 (data){
	if(data == null || data == ''){return};
	var charts13 = echarts.init(document.getElementById('djfb_pie13'));
	// var charts2 = echarts.init(document.getElementById('djfb_pie2'));
	var option13 = {
		title : {
			text : '出监管区',
			x : 'center'
		},
		tooltip : {
			trigger : 'item',
			formatter : "{a} <br/>{b} : {c} ({d}%)"
		},
		// legend: {
		//     orient: 'vertical',
		//    	x: 'left',
		//     data: ['极高危险','高度危险','中度危险','低度危险','未评估']
		// },
		series : [ {
			name : '危险等级',
			type : 'pie',
			radius : '60%',
			center : [ '50%', '50%' ],
			label : {
				normal : {
					textStyle : {
						fontSize : 18
					}
				}
			},
			data : [ {
				value : data.gdwx,
				name : '高度危险',
				itemStyle : {
					normal : {
						color : '#fc7e18'
					}
				}
			}, {
				value : data.zdwx,
				name : '中度危险',
				itemStyle : {
					normal : {
						color : '#FFC300'
					}
				}
			}, {
				value : data.ddwx,
				name : '低度危险',
				itemStyle : {
					normal : {
						color : '#4169E1'
					}
				}
			} , {
				value : data.jgdwx,
				name : '极高危险',
				itemStyle : {
					normal : {
						color : '#ff0000'
					}
				}
			} ],
			itemStyle : {
				emphasis : {
					shadowBlur : 10,
					shadowOffsetX : 0,
					shadowColor : 'rgba(0, 0, 0, 0.5)'
				}
			}
		} ]
	};

	charts13.setOption(option13);
	window.addEventListener("resize", function() {
		charts13.resize();
	});
};

function echarts14 (data){
	if(data == null || data == ''){return};
	console.info(document.getElementById('djfb_pie14'));
	var charts14 = echarts.init(document.getElementById('djfb_pie14'));
	var option14 = {
		title : {
			text : '新犯队',
			x : 'center'
		},
		tooltip : {
			trigger : 'item',
			formatter : "{a} <br/>{b} : {c} ({d}%)"
		},
		// legend: {
		//     orient: 'vertical',
		//    	x: 'left',
		//     data: ['极高危险','高度危险','中度危险','低度危险','未评估']
		// },
		series : [ {
			name : '危险等级',
			type : 'pie',
			radius : '60%',
			center : [ '50%', '50%' ],
			label : {
				normal : {
					textStyle : {
						fontSize : 18
					}
				}
			},
			data : [ {
				value : data.gdwx,
				name : '高度危险',
				itemStyle : {
					normal : {
						color : '#fc7e18'
					}
				}
			}, {
				value : data.zdwx,
				name : '中度危险',
				itemStyle : {
					normal : {
						color : '#FFC300'
					}
				}
			}, {
				value : data.ddwx,
				name : '低度危险',
				itemStyle : {
					normal : {
						color : '#4169E1'
					}
				}
			} , {
				value : data.jgdwx,
				name : '极高危险',
				itemStyle : {
					normal : {
						color : '#ff0000'
					}
				}
			} ],
			itemStyle : {
				emphasis : {
					shadowBlur : 10,
					shadowOffsetX : 0,
					shadowColor : 'rgba(0, 0, 0, 0.5)'
				}
			}
		} ]
	};

	charts14.setOption(option14);
	window.addEventListener("resize", function() {
		charts14.resize();
	});
};

function echarts15 (data){
	if(data == null || data == ''){return};

	var charts15 = echarts.init(document.getElementById('djfb_pie15'));
	// var charts2 = echarts.init(document.getElementById('djfb_pie2'));
	var option15 = {
		title : {
			text : '医院监区',
			x : 'center'
		},
		tooltip : {
			trigger : 'item',
			formatter : "{a} <br/>{b} : {c} ({d}%)"
		},
		// legend: {
		//     orient: 'vertical',
		//    	x: 'left',
		//     data: ['极高危险','高度危险','中度危险','低度危险','未评估']
		// },
		series : [ {
			name : '危险等级',
			type : 'pie',
			radius : '60%',
			center : [ '50%', '50%' ],
			label : {
				normal : {
					textStyle : {
						fontSize : 18
					}
				}
			},
			data : [ {
				value : data.gdwx,
				name : '高度危险',
				itemStyle : {
					normal : {
						color : '#fc7e18'
					}
				}
			}, {
				value : data.zdwx,
				name : '中度危险',
				itemStyle : {
					normal : {
						color : '#FFC300'
					}
				}
			}, {
				value : data.ddwx,
				name : '低度危险',
				itemStyle : {
					normal : {
						color : '#4169E1'
					}
				}
			} , {
				value : data.jgdwx,
				name : '极高危险',
				itemStyle : {
					normal : {
						color : '#ff0000'
					}
				}
			} ],
			itemStyle : {
				emphasis : {
					shadowBlur : 10,
					shadowOffsetX : 0,
					shadowColor : 'rgba(0, 0, 0, 0.5)'
				}
			}
		} ]
	};

	charts15.setOption(option15);
	window.addEventListener("resize", function() {
		charts15.resize();
	});
};

function echarts16 (data){
	if(data == null || data == ''){return};
	var charts16 = echarts.init(document.getElementById('djfb_pie16'));
	var option16 = {
		title : {
			text : '狱政科',
			x : 'center'
		},
		tooltip : {
			trigger : 'item',
			formatter : "{a} <br/>{b} : {c} ({d}%)"
		},
		// legend: {
		//     orient: 'vertical',
		//    	x: 'left',
		//     data: ['极高危险','高度危险','中度危险','低度危险','未评估']
		// },
		series : [ {
			name : '危险等级',
			type : 'pie',
			radius : '60%',
			center : [ '50%', '50%' ],
			label : {
				normal : {
					textStyle : {
						fontSize : 18
					}
				}
			},
			data : [ {
				value : data.gdwx,
				name : '高度危险',
				itemStyle : {
					normal : {
						color : '#fc7e18'
					}
				}
			}, {
				value : data.zdwx,
				name : '中度危险',
				itemStyle : {
					normal : {
						color : '#FFC300'
					}
				}
			}, {
				value : data.ddwx,
				name : '低度危险',
				itemStyle : {
					normal : {
						color : '#4169E1'
					}
				}
			} , {
				value : data.jgdwx,
				name : '极高危险',
				itemStyle : {
					normal : {
						color : '#ff0000'
					}
				}
			} ],
			itemStyle : {
				emphasis : {
					shadowBlur : 10,
					shadowOffsetX : 0,
					shadowColor : 'rgba(0, 0, 0, 0.5)'
				}
			}
		} ]
	};

	charts16.setOption(option16);
	window.addEventListener("resize", function() {
		charts16.resize();
	});
};
