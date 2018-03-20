$(function() {
	function TsZfModel() {
		this.dlgId = '.sjcj-l2-dlg-t1';
		this.clsBtn = '.sjcj-l2-dlg-t1 .js-sj-qx';
	}
	// 日常观察表对话框
	TsZfModel.prototype.initRgDlg = function() {
		var dlg = $(this.dlgId);
		dlg.show();
		this.rgDlg = dlg.dialog({
			title : ' ',
			closed : true
		})
	}
	TsZfModel.prototype.initHandler = function() {
		var _this = this;
		// 日常观察按钮
		$('.js-rg-btn1').click(function() {
			_this.rgDlg.dialog('open');
		});
	}
	// 关闭对话框
	TsZfModel.prototype.closeHandler = function() {
		var _this = this;
		$(this.clsBtn).click(function() {
			_this.rgDlg.dialog('close');
		});

	}
	TsZfModel.prototype.launch = function() {
		this.initRgDlg();
		this.initHandler();
		this.closeHandler();
	}

	new TsZfModel().launch();
});

$(function() {
	function TsZfModel() {

		this.dlgId = '.sjcj-l2-dlg-t2';

		this.clsBtn = '.sjcj-l2-dlg-t2 .js-sj-qx';

	}
	// 日常观察表对话框
	TsZfModel.prototype.initRgDlg = function() {
		var dlg = $(this.dlgId);
		dlg.show();
		this.rgDlg = dlg.dialog({
			title : ' ',
			closed : true
		})
	}
	TsZfModel.prototype.initHandler = function() {
		var _this = this;
		// 日常观察按钮
		$('.js-rg-btn2').click(function() {
			_this.rgDlg.dialog('open');
		});
	}
	// 关闭对话框
	TsZfModel.prototype.closeHandler = function() {
		var _this = this;
		$(this.clsBtn).click(function() {
			_this.rgDlg.dialog('close');
		});

	}
	TsZfModel.prototype.launch = function() {
		this.initRgDlg();
		this.initHandler();
		this.closeHandler();
	}

	new TsZfModel().launch();
});

$(function() {
	function TsZfModel() {

		this.dlgId = '.sjcj-l2-dlg-t3';

		this.clsBtn = '.sjcj-l2-dlg-t3 .js-sj-qx';
	}
	// 日常观察表对话框
	TsZfModel.prototype.initRgDlg = function() {
		var dlg = $(this.dlgId);
		dlg.show();
		this.rgDlg = dlg.dialog({
			title : ' ',
			closed : true
		})
	}
	TsZfModel.prototype.initHandler = function() {
		var _this = this;
		// 日常观察按钮
		$('.js-rg-btn3').click(function() {
			_this.rgDlg.dialog('open');
		});
	}
	// 关闭对话框
	TsZfModel.prototype.closeHandler = function() {
		var _this = this;
		$(this.clsBtn).click(function() {
			_this.rgDlg.dialog('close');
		});

	}
	TsZfModel.prototype.launch = function() {
		this.initRgDlg();
		this.initHandler();
		this.closeHandler();
	}

	new TsZfModel().launch();
});

$(function() {
	function TsZfModel() {

		this.dlgId = '.sjcj-l2-dlg-t4';
		this.clsBtn = '.sjcj-l2-dlg-t4 .js-sj-qx';

	}
	// 日常观察表对话框
	TsZfModel.prototype.initRgDlg = function() {
		var dlg = $(this.dlgId);
		dlg.show();
		this.rgDlg = dlg.dialog({
			title : ' ',
			closed : true
		})
	}
	TsZfModel.prototype.initHandler = function() {
		var _this = this;
		// 日常观察按钮
		$('.js-rg-btn4').click(function() {
			_this.rgDlg.dialog('open');
		});
	}
	// 关闭对话框
	TsZfModel.prototype.closeHandler = function() {
		var _this = this;
		$(this.clsBtn).click(function() {
			_this.rgDlg.dialog('close');
		});

	}
	TsZfModel.prototype.launch = function() {
		this.initRgDlg();
		this.initHandler();
		this.closeHandler();
	}

	new TsZfModel().launch();
});

// 基于准备好的dom，初始化echarts实例
var myChart = echarts.init(document.getElementById('bar'));

// 指定图表的配置项和数据
var option = {
	title : {
		text : '危险等级统计图', //标题文本内容
	},
	tooltip : {
		trigger : 'axis',
		axisPointer : { // 坐标轴指示器，坐标轴触发有效
			type : 'shadow' // 默认为直线，可选为：'line' | 'shadow'
		}
	},
	legend : {
		data : [ "极高度危险", "高度危险", "中度危险", "低度危险" ,"未测试"]
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
		data : []
	//				'一监区','二监区','三监区','四监区','五监区','六监区','七监区','八监区','九监区','十监区','十二监区','医院监区','出监管区','新犯队','狱政科'
	},
	series : []
};
myChart.showLoading();
myChart.setOption(option);
$(function() {
	//		console.info("危险等级统计页面 echarts 图数据");
	//危险等级统计页面 echarts 图数据
	// 统计分析 >>危险等级统计
	$.ajax({
		url : '/oasm/tjfxView/listVTjwxcd',
		dataType : 'json',
		type : 'post',
		success : function(data) {
//			console.info(data);
//			data = null;	
			if (data == null || data == '') {
				myChart.hideLoading(); // 隐藏加载动画
				return;
			}
			var a = '';
			var jyzrs = 0;//监狱总人数
			var jyjgd = 0;//监狱极高度
			var jygd = 0;//监狱高度
			var jyzd = 0;//监狱中度
			var jydd = 0;//监狱低度
			var jysl = 0;//监狱未测试数量

			var jq = [];//监区数组
			var jg = [];//极高危险人数
			var gd = [];//高度危险人数
			var zd = [];//中度危险人数
			var dd = [];//低度危险人数
			var sl = [];//未测试人数
			

			$.each(data, function(k, v) {
//				console.info(v.gyjqmc);

				if(v.sl == null || v.sl == ''){
					v.sl=0;
				}
				
				jq.push(v.gyjqmc);
				jg.push(v.jgdwx);
				gd.push(v.gdwx);
				zd.push(v.zdwx);
				dd.push(v.ddwx);
				sl.push(v.sl);

				//监狱数据
				jyjgd += v.jgdwx;
				jygd += v.gdwx;
				jyzd += v.zdwx;
				jydd += v.ddwx;
				jysl += v.sl;
				
				var zrs = v.jgdwx + v.gdwx + v.zdwx + v.ddwx + v.sl;//各个监区总人数
				jyzrs += zrs;
				a += "<tr>";
				a += "<td>" + v.gyjqmc + "</td>";//监区
				a += "<td>" + zrs + "</td>";//总人数
				a += "<td style='color:red'>"
						+ (v.jgdwx / zrs * 100).toFixed(2) + "%</td>";//极高度危险比例							
				a += "<td class='js-rg-btn1'><a href='#'>" + v.jgdwx
						+ "</a></td>";//极高度危险人数
				a += "<td style='color:red'>" + (v.gdwx / zrs * 100).toFixed(2)
						+ "%</td>";//高度危险比例
				a += "<td class='js-rg-btn2'><a href='#'>" + v.gdwx
						+ "</a></td>";//高度危险人数
				a += "<td style='color:red'>" + (v.zdwx / zrs * 100).toFixed(2)
						+ "%</td>";//中度危险比例
				a += "<td class='js-rg-btn3'><a href='#'>" + v.zdwx
						+ "</a></td>";//中度危险人数
				a += "<td style='color:red'>" + (v.ddwx / zrs * 100).toFixed(2)
						+ "%</td>";//低度危险比例
				a += "<td class='js-rg-btn4'><a href='#'>" + v.ddwx
						+ "</a></td>";//低度危险人数
				a += "<td style='color:red'>" +(v.sl / zrs * 100).toFixed(2)
						+ "</a></td>";//未测试比例
				a += "<td class='js-rg-btn4'><a href='#'>" + v.sl
						+ "</a></td>";//未测试人数
				a += "</tr>";
			})
			a += "<tr>";
			a += "<td>监狱</td>";
			a += "<td>" + jyzrs + "</td>";//总人数
			a += "<td style='color:red'>" + (jyjgd / jyzrs * 100).toFixed(2)
					+ "%</td>";//极高度危险比例							
			a += "<td class='js-rg-btn1'><a href='#'>" + jyjgd + "</a></td>";//极高度危险人数
			a += "<td style='color:red'>" + (jygd / jyzrs * 100).toFixed(2)
					+ "%</td>";//高度危险比例
			a += "<td class='js-rg-btn2'><a href='#'>" + jygd + "</a></td>";//高度危险人数
			a += "<td style='color:red'>" + (jyzd / jyzrs * 100).toFixed(2)
					+ "%</td>";//中度危险比例
			a += "<td class='js-rg-btn3'><a href='#'>" + jyzd + "</a></td>";//中度危险人数
			a += "<td style='color:red'>" + (jydd / jyzrs * 100).toFixed(2)
					+ "%</td>";//低度危险比例
			a += "<td class='js-rg-btn4'><a href='#'>" + jydd + "</a></td>";//低度危险人数
			a += "<td style='color:red'>" + (jysl / jyzrs * 100).toFixed(2)
					+ "%</td>";//未测试比例
			a += "<td class='js-rg-btn4'><a href='#'>" + jysl + "</a></td>";//未测试人数
			a += "</tr>";
			$("#listWxcd").html(a);

			// console.info(jq);
			// console.info(jg);
			// console.info(gd);
			// console.info(zd);
			// console.info(dd);
			myChart.hideLoading(); //隐藏加载动画
			myChart.setOption({
				xAxis : {
					type : 'category',
					data : jq
				},
				series : [ 
					{
						name : '极高度危险',
						type : 'bar',
						stack : '总量',
						label : {
							normal : {
								show : true,
								position : 'insideRight'
							}
						},
						data : jg,
						itemStyle : {
							normal : {
								color : '#FF0000'
							}
						}
					}, {
						name : '高度危险',
						type : 'bar',
						stack : '总量',
						label : {
							normal : {
								show : true,
								position : 'insideRight'
							}
						},
						data : gd,
						itemStyle : {
							normal : {
								color : '#FFA500'
							}
						}
					}, {
						name : '中度危险',
						type : 'bar',
						stack : '总量',
						label : {
							normal : {
								show : true,
								position : 'insideRight'
							}
						},
						data : zd,
						itemStyle : {
							normal : {
								color : '#FFFF00'
							}
						}
					}, {
						name : '低度危险',
						type : 'bar',
						stack : '总量',
						label : {
							normal : {
								show : true,
								position : 'insideRight'
							}
						},
						data : dd,
						itemStyle : {
							normal : {
								color : '#4169E1'
							}
						}
					} , {
						name : '未测试',
						type : 'bar',
						stack : '总量',
						label : {
							normal : {
								show : true,
								position : 'insideRight'
							}
						},
						data : sl,
						itemStyle : {
							normal : {
								color : '#666'
							}
						}
					} 
				]
			})
		}
	})
});
