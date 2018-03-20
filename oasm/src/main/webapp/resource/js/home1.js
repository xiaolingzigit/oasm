$.ajaxSetup({
	cache: false //关闭AJAX相应的缓存
});

function HomeModel() {}
HomeModel.prototype = new Object;

HomeModel.prototype.constructor = "HomeModel";

HomeModel.prototype.launch = function () {
	this.initEcharts();
};

var j1;
var j2;
var j3;
var j4;
var j5;
var j6;
var j7;
var j8;
var j9;
var j10;
var j11;
var j12;
var j13;
var j14;
var j15;
var j16;


HomeModel.prototype.launch = function () {
	// this.initPie1();
	//home的eachars数据
	$.ajax({
		url:'/oasm/tjfxView/getListWxcd',
		dataType:'json',
		type:'get',
		async: false,
		success:function(data){
			if(data == null || data.length == 0){
				console.info("无效数据");
				return;
			}
			
//			console.info(data);
			var jg=0;
			var gd=0;
			var zd=0;
			var dd=0;
			$.each(data,function(k,v){
				switch(v.gyjqmc)
				{
				case '一监区':
					j2=JSON.stringify(v);
				
				case '二监区':
					j3=JSON.stringify(v);
				
				case '三监区':
					j4=JSON.stringify(v);
				
				case '四监区':
					j5=JSON.stringify(v);
				
				case '五监区':
					j6=JSON.stringify(v);
				
				case '六监区':
					j7=JSON.stringify(v);
				
				case '七监区':
					j8=JSON.stringify(v);
				
				case '八监区':
					j9=JSON.stringify(v);
				
				case '九监区':
					j10=JSON.stringify(v);
				
				case '十监区':
					j11=JSON.stringify(v);
				
				case '十二监区':
					j12=JSON.stringify(v);
				
				case '出监管区':
					j13=JSON.stringify(v);
				
				case '新犯队':
					j14=JSON.stringify(v);
				
				case '医院':
					j15=JSON.stringify(v);
				
				case '狱政科':
					j16=JSON.stringify(v);
				
				default:
					//'监狱':
//					console.info("--"+v.jgdwx+"--"+v.gdwx+"--"+v.zdwx+"--"+v.ddwx);
					jg+=v.jgdwx;
					gd+=v.gdwx;
					zd+=v.zdwx;
					dd+=v.ddwx;
					break;
				}
			})
			j1 = "{\"gyjqmc\": \"监狱\", \"jgdwx\": "+jg+", \"gdwx\": "+gd+", \"zdwx\": "+zd+", \"ddwx\": "+dd+"}";
//			console.info("json.string.j1: "+j1);
//			console.info(JSON.parse(j1));
			
			
			this.initPie1();
			this.initPie2();
			this.initPie3();
			this.initPie4();
			this.initPie5();
			this.initPie6();
			this.initPie7();
			this.initPie8();
			this.initPie9();
			this.initPie10();
			this.initPie11();
			this.initPie12();
			this.initPie13();
			this.initPie14();
			this.initPie15();
			this.initPie16();
		}
	});


};	

HomeModel.prototype.initPie1 = function (){
	var _this = this;
	
	var charts1 = echarts.init(document.getElementById('djfb_pie1'));
	// var charts2 = echarts.init(document.getElementById('djfb_pie2'));
	var a = JSON.parse(j1);
	var option1 ={
		title : {
        text: '监狱',
        x:'center'
    	},
	    tooltip : {
	        trigger: 'item',
	        formatter: "{a} <br/>{b} : {c} ({d}%)"
	    },
	    // legend: {
	    //     orient: 'vertical',
     //    	x: 'left',
	    //     data: ['极高危险','高度危险','中度危险','低度危险','未评估']
	    // },
	    series : [
	        {
	            name: '危险等级',
	            type: 'pie',
	            radius : '60%',
	            center: ['50%', '50%'],
				 label: {
					normal: {
						textStyle: {
							fontSize : 18
						}
					 }
           		},
	            data:[
	                 {value:a.gdwx, name:'高度危险',
					itemStyle:{
						normal:{color:'#fc7e18'}
					}
				},
					{value:a.zdwx, name:'中度危险',
					itemStyle:{
						normal:{color:'#FFC300'}
					}
				},
					{value:a.ddwx, name:'低度危险',
					itemStyle:{
						normal:{color:'#4169E1'}
					}
				},
				{value:a.jgdwx, name:'极高危险',
					itemStyle:{
						normal:{color:'#ff0000'}
					}
				}
	              ],
	            itemStyle: {

	                emphasis: {
	                    shadowBlur: 10,
	                    shadowOffsetX: 0,
	                    shadowColor: 'rgba(0, 0, 0, 0.5)'
	                }
	            }
	        }
	    ]
	};
	
    charts1.setOption(option1);

 	
};
HomeModel.prototype.initPie2 = function (){
	var _this = this;
	if(j2 == null || j2.length ==0){
		return;
	}
	
	var charts2 = echarts.init(document.getElementById('djfb_pie2'));
	console.info("一监区: "+JSON.parse(j2));
	var a = JSON.parse(j2);
//	console.info(a.gdwx);
	var option2 ={
		title : {
        text: '一监区',
        x:'center'
    	},
	    tooltip : {
	        trigger: 'item',
	        formatter: "{a} <br/>{b} : {c} ({d}%)"
	    },
	    // legend: {
	    //     orient: 'vertical',
     //    	x: 'left',
	    //     data: ['极高危险','高度危险','中度危险','低度危险','未评估']
	    // },
	    series : [
	        {
	            name: '危险等级',
	            type: 'pie',
	            radius : '60%',
	            center: ['50%', '50%'],
				label: {
					normal: {
						textStyle: {
							fontSize : 18
						}
					 }
           		},

	            data:[
	                  {value:a.gdwx, name:'高度危险',
					itemStyle:{
						normal:{color:'#fc7e18'}
					}
				},
					{value:a.zdwx, name:'中度危险',
					itemStyle:{
						normal:{color:'#FFC300'}
					}
				},
					{value:a.ddwx, name:'低度危险',
					itemStyle:{
						normal:{color:'#4169E1'}
					}
				},
				{value:a.jgdwx, name:'极高危险',
					itemStyle:{
						normal:{color:'#ff0000'}
					}
				}
	              ],
	            itemStyle: {
	                emphasis: {
	                    shadowBlur: 10,
	                    shadowOffsetX: 0,
	                    shadowColor: 'rgba(0, 0, 0, 0.5)'
	                }
	            }
	        }
	    ]
	};
	
    charts2.setOption(option2);
    
    
 	
};

HomeModel.prototype.initPie3 = function (){
	var _this = this;
	
	var charts3 = echarts.init(document.getElementById('djfb_pie3'));
	// var charts2 = echarts.init(document.getElementById('djfb_pie2'));
	var a = JSON.parse(j3);
	var option3 ={
		title : {
        text: '二监区',
        x:'center'
    	},
	    tooltip : {
	        trigger: 'item',
	        formatter: "{a} <br/>{b} : {c} ({d}%)"
	    },
	    // legend: {
	    //     orient: 'vertical',
     //    	x: 'left',
	    //     data: ['极高危险','高度危险','中度危险','低度危险','未评估']
	    // },
	    series : [
	        {
	            name: '危险等级',
	            type: 'pie',
	            radius : '60%',
	            center: ['50%', '50%'],
				label: {
					normal: {
						textStyle: {
							fontSize : 18
						}
					 }
           		},
	            data:[
	                  {value:a.gdwx, name:'高度危险',
					itemStyle:{
						normal:{color:'#fc7e18'}
					}
				},
					{value:a.zdwx, name:'中度危险',
					itemStyle:{
						normal:{color:'#FFC300'}
					}
				},
					{value:a.ddwx, name:'低度危险',
					itemStyle:{
						normal:{color:'#4169E1'}
					}
				},
				{value:a.jgdwx, name:'极高危险',
					itemStyle:{
						normal:{color:'#ff0000'}
					}
				}
	              ],
	            itemStyle: {
	                emphasis: {
	                    shadowBlur: 10,
	                    shadowOffsetX: 0,
	                    shadowColor: 'rgba(0, 0, 0, 0.5)'
	                }
	            }
	        }
	    ]
	};
	
    charts3.setOption(option3);
 	window.addEventListener("resize",function(){
        charts3.resize();
                 });
};
HomeModel.prototype.initPie4 = function (){
	var _this = this;
	
	var charts4 = echarts.init(document.getElementById('djfb_pie4'));
	// var charts2 = echarts.init(document.getElementById('djfb_pie2'));
	var a = JSON.parse(j4);
	var option4 ={
		title : {
        text: '三监区',
        x:'center'
    	},
	    tooltip : {
	        trigger: 'item',
	        formatter: "{a} <br/>{b} : {c} ({d}%)"
	    },
	   // legend: {
	    //     orient: 'vertical',
     //    	x: 'left',
	    //     data: ['极高危险','高度危险','中度危险','低度危险','未评估']
	    // },
	    series : [
	        {
	            name: '危险等级',
	            type: 'pie',
	            radius : '60%',
	            center: ['50%', '50%'],
				label: {
					normal: {
						textStyle: {
							fontSize : 18
						}
					 }
           		},
	            data:[
	                  {value:a.gdwx, name:'高度危险',
					itemStyle:{
						normal:{color:'#fc7e18'}
					}
				},
					{value:a.zdwx, name:'中度危险',
					itemStyle:{
						normal:{color:'#FFC300'}
					}
				},
					{value:a.ddwx, name:'低度危险',
					itemStyle:{
						normal:{color:'#4169E1'}
					}
				},
				{value:a.jgdwx, name:'极高危险',
					itemStyle:{
						normal:{color:'#ff0000'}
					}
				}
	              ],
	            itemStyle: {
	                emphasis: {
	                    shadowBlur: 10,
	                    shadowOffsetX: 0,
	                    shadowColor: 'rgba(0, 0, 0, 0.5)'
	                }
	            }
	        }
	    ]
	};
	
    charts4.setOption(option4);
 	window.addEventListener("resize",function(){
        charts4.resize();
                 });
};

HomeModel.prototype.initPie5 = function (){
	var _this = this;
	
	var charts5 = echarts.init(document.getElementById('djfb_pie5'));
	// var charts2 = echarts.init(document.getElementById('djfb_pie2'));
	var a = JSON.parse(j5);
	var option5 ={
		title : {
        text: '四监区',
        x:'center'
    	},
	    tooltip : {
	        trigger: 'item',
	        formatter: "{a} <br/>{b} : {c} ({d}%)"
	    },
	    // legend: {
	    //     orient: 'vertical',
     //    	x: 'left',
	    //     data: ['极高危险','高度危险','中度危险','低度危险','未评估']
	    // },
	    series : [
	        {
	            name: '危险等级',
	            type: 'pie',
	            radius : '60%',
	            center: ['50%', '50%'],
				label: {
					normal: {
						textStyle: {
							fontSize : 18
						}
					 }
           		},
	            data:[
	                  {value:a.gdwx, name:'高度危险',
					itemStyle:{
						normal:{color:'#fc7e18'}
					}
				},
					{value:a.zdwx, name:'中度危险',
					itemStyle:{
						normal:{color:'#FFC300'}
					}
				},
					{value:a.ddwx, name:'低度危险',
					itemStyle:{
						normal:{color:'#4169E1'}
					}
				},
				{value:a.jgdwx, name:'极高危险',
					itemStyle:{
						normal:{color:'#ff0000'}
					}
				}
	              ],
	            itemStyle: {
	                emphasis: {
	                    shadowBlur: 10,
	                    shadowOffsetX: 0,
	                    shadowColor: 'rgba(0, 0, 0, 0.5)'
	                }
	            }
	        }
	    ]
	};
	
    charts5.setOption(option5);
 	window.addEventListener("resize",function(){
        charts5.resize();
                 });
};

HomeModel.prototype.initPie6 = function (){
	var _this = this;
	
	var charts6 = echarts.init(document.getElementById('djfb_pie6'));
	// var charts2 = echarts.init(document.getElementById('djfb_pie2'));
	var a = JSON.parse(j6);
	var option6 ={
		title : {
        text: '五监区',
        x:'center'
    	},
	    tooltip : {
	        trigger: 'item',
	        formatter: "{a} <br/>{b} : {c} ({d}%)"
	    },
	   // legend: {
	    //     orient: 'vertical',
     //    	x: 'left',
	    //     data: ['极高危险','高度危险','中度危险','低度危险','未评估']
	    // },
	    series : [
	        {
	            name: '危险等级',
	            type: 'pie',
	            radius : '60%',
	            center: ['50%', '50%'],
				label: {
					normal: {
						textStyle: {
							fontSize : 18
						}
					 }
           		},
	            data:[
	                  {value:a.gdwx, name:'高度危险',
					itemStyle:{
						normal:{color:'#fc7e18'}
					}
				},
					{value:a.zdwx, name:'中度危险',
					itemStyle:{
						normal:{color:'#FFC300'}
					}
				},
					{value:a.ddwx, name:'低度危险',
					itemStyle:{
						normal:{color:'#4169E1'}
					}
				},
				{value:a.jgdwx, name:'极高危险',
					itemStyle:{
						normal:{color:'#ff0000'}
					}
				}
	              ],
	            itemStyle: {
	                emphasis: {
	                    shadowBlur: 10,
	                    shadowOffsetX: 0,
	                    shadowColor: 'rgba(0, 0, 0, 0.5)'
	                }
	            }
	        }
	    ]
	};
	
    charts6.setOption(option6);
 	window.addEventListener("resize",function(){
        charts6.resize();
                 });
};
HomeModel.prototype.initPie7 = function (){
	var _this = this;
	
	var charts7 = echarts.init(document.getElementById('djfb_pie7'));
	var a = JSON.parse(j7);
	var option7 ={
		title : {
        text: '六监区',
        x:'center'
    	},
	    tooltip : {
	        trigger: 'item',
	        formatter: "{a} <br/>{b} : {c} ({d}%)"
	    },
	    // legend: {
	    //     orient: 'vertical',
     //    	x: 'left',
	    //     data: ['极高危险','高度危险','中度危险','低度危险','未评估']
	    // },
	    series : [
	        {
	            name: '危险等级',
	            type: 'pie',
	            radius : '60%',
	            center: ['50%', '50%'],
				label: {
					normal: {
						textStyle: {
							fontSize : 18
						}
					 }
           		},
	            data:[
	                  {value:a.gdwx, name:'高度危险',
					itemStyle:{
						normal:{color:'#fc7e18'}
					}
				},
					{value:a.zdwx, name:'中度危险',
					itemStyle:{
						normal:{color:'#FFC300'}
					}
				},
					{value:a.ddwx, name:'低度危险',
					itemStyle:{
						normal:{color:'#4169E1'}
					}
				},
				{value:a.jgdwx, name:'极高危险',
					itemStyle:{
						normal:{color:'#ff0000'}
					}
				}
	              ],
	            itemStyle: {
	                emphasis: {
	                    shadowBlur: 10,
	                    shadowOffsetX: 0,
	                    shadowColor: 'rgba(0, 0, 0, 0.5)'
	                }
	            }
	        }
	    ]
	};
	
    charts7.setOption(option7);
 	window.addEventListener("resize",function(){
        charts7.resize();
                 });
};
HomeModel.prototype.initPie8 = function (){
	var _this = this;
	
	var charts8 = echarts.init(document.getElementById('djfb_pie8'));
	var a = JSON.parse(j8);
	var option8 ={
		title : {
        text: '七监区',
        x:'center'
    	},
	    tooltip : {
	        trigger: 'item',
	        formatter: "{a} <br/>{b} : {c} ({d}%)"
	    },
	   // legend: {
	    //     orient: 'vertical',
     //    	x: 'left',
	    //     data: ['极高危险','高度危险','中度危险','低度危险','未评估']
	    // },
	    series : [
	        {
	            name: '危险等级',
	            type: 'pie',
	            radius : '60%',
	            center: ['50%', '50%'],
				label: {
					normal: {
						textStyle: {
							fontSize : 18
						}
					 }
           		},
	            data:[
	                  {value:a.gdwx, name:'高度危险',
					itemStyle:{
						normal:{color:'#fc7e18'}
					}
				},
					{value:a.zdwx, name:'中度危险',
					itemStyle:{
						normal:{color:'#FFC300'}
					}
				},
					{value:a.ddwx, name:'低度危险',
					itemStyle:{
						normal:{color:'#4169E1'}
					}
				},
				{value:a.jgdwx, name:'极高危险',
					itemStyle:{
						normal:{color:'#ff0000'}
					}
				}
	              ],
	            itemStyle: {
	                emphasis: {
	                    shadowBlur: 10,
	                    shadowOffsetX: 0,
	                    shadowColor: 'rgba(0, 0, 0, 0.5)'
	                }
	            }
	        }
	    ]
	};
	
    charts8.setOption(option8);
 	window.addEventListener("resize",function(){
        charts8.resize();
                 });
};
HomeModel.prototype.initPie9 = function (){
	var _this = this;
	
	var charts9 = echarts.init(document.getElementById('djfb_pie9'));
	var a = JSON.parse(j9);
	var option9 ={
		title : {
        text: '八监区',
        x:'center'
    	},
	    tooltip : {
	        trigger: 'item',
	        formatter: "{a} <br/>{b} : {c} ({d}%)"
	    },
	    // legend: {
	    //     orient: 'vertical',
     //    	x: 'left',
	    //     data: ['极高危险','高度危险','中度危险','低度危险','未评估']
	    // },
	    series : [
	        {
	            name: '危险等级',
	            type: 'pie',
	            radius : '60%',
	            center: ['50%', '50%'],

				label: {
					normal: {
						textStyle: {
							fontSize : 18
						}
					 }
           		},
	            data:[
	                  {value:a.gdwx, name:'高度危险',
					itemStyle:{
						normal:{color:'#fc7e18'}
					}
				},
					{value:a.zdwx, name:'中度危险',
					itemStyle:{
						normal:{color:'#FFC300'}
					}
				},
					{value:a.ddwx, name:'低度危险',
					itemStyle:{
						normal:{color:'#4169E1'}
					}
				},
				{value:a.jgdwx, name:'极高危险',
					itemStyle:{
						normal:{color:'#ff0000'}
					}
				}
	              ],
	            itemStyle: {
	                emphasis: {
	                    shadowBlur: 10,
	                    shadowOffsetX: 0,
	                    shadowColor: 'rgba(0, 0, 0, 0.5)'
	                }
	            }
	        }
	    ]
	};
	
    charts9.setOption(option9);
 	window.addEventListener("resize",function(){
        charts9.resize();
                 });
};
HomeModel.prototype.initPie10 = function (){
	var _this = this;
	
	var charts10 = echarts.init(document.getElementById('djfb_pie10'));
	var a = JSON.parse(j10);
	var option10 ={
		title : {
        text: '九监区',
        x:'center'
    	},
	    tooltip : {
	        trigger: 'item',
	        formatter: "{a} <br/>{b} : {c} ({d}%)"
	    },
	    // legend: {
	    //     orient: 'vertical',
     //    	x: 'left',
	    //     data: ['极高危险','高度危险','中度危险','低度危险','未评估']
	    // },
	    series : [
	        {
	            name: '危险等级',
	            type: 'pie',
	            radius : '60%',
	            center: ['50%', '50%'],
				label: {
					normal: {
						textStyle: {
							fontSize : 18
						}
					 }
           		},
	            data:[
	                  {value:a.gdwx, name:'高度危险',
					itemStyle:{
						normal:{color:'#fc7e18'}
					}
				},
					{value:a.zdwx, name:'中度危险',
					itemStyle:{
						normal:{color:'#FFC300'}
					}
				},
					{value:a.ddwx, name:'低度危险',
					itemStyle:{
						normal:{color:'#4169E1'}
					}
				},
				{value:a.jgdwx, name:'极高危险',
					itemStyle:{
						normal:{color:'#ff0000'}
					}
				}
	              ],
	            itemStyle: {
	                emphasis: {
	                    shadowBlur: 10,
	                    shadowOffsetX: 0,
	                    shadowColor: 'rgba(0, 0, 0, 0.5)'
	                }
	            }
	        }
	    ]
	};
	
    charts10.setOption(option10);
 	window.addEventListener("resize",function(){
        charts10.resize();
                 });
};
HomeModel.prototype.initPie11 = function (){
	var _this = this;
	
	var charts11 = echarts.init(document.getElementById('djfb_pie11'));
	var a = JSON.parse(j11);
	var option11 ={
		title : {
        text: '十监区',
        x:'center'
    	},
	    tooltip : {
	        trigger: 'item',
	        formatter: "{a} <br/>{b} : {c} ({d}%)"
	    },
	    // legend: {
	    //     orient: 'vertical',
     //    	x: 'left',
	    //     data: ['极高危险','高度危险','中度危险','低度危险','未评估']
	    // },
	    series : [
	        {
	            name: '危险等级',
	            type: 'pie',
	            radius : '60%',
	            center: ['50%', '50%'],
				label: {
					normal: {
						textStyle: {
							fontSize : 18
						}
					 }
           		},
	            data:[
	                  {value:a.gdwx, name:'高度危险',
					itemStyle:{
						normal:{color:'#fc7e18'}
					}
				},
					{value:a.zdwx, name:'中度危险',
					itemStyle:{
						normal:{color:'#FFC300'}
					}
				},
					{value:a.ddwx, name:'低度危险',
					itemStyle:{
						normal:{color:'#4169E1'}
					}
				},
				{value:a.jgdwx, name:'极高危险',
					itemStyle:{
						normal:{color:'#ff0000'}
					}
				}
	              ],
	            itemStyle: {
	                emphasis: {
	                    shadowBlur: 10,
	                    shadowOffsetX: 0,
	                    shadowColor: 'rgba(0, 0, 0, 0.5)'
	                }
	            }
	        }
	    ]
	};
	
    charts11.setOption(option11);
 	window.addEventListener("resize",function(){
        charts11.resize();
                 });
};

HomeModel.prototype.initPie12 = function (){
	var _this = this;
	
	var charts12 = echarts.init(document.getElementById('djfb_pie12'));
	var a = JSON.parse(j12);
	var option12 ={
		title : {
        text: '十二监区',
        x:'center'
    	},
	    tooltip : {
	        trigger: 'item',
	        formatter: "{a} <br/>{b} : {c} ({d}%)"
	    },
	    // legend: {
	    //     orient: 'vertical',
     //    	x: 'left',
	    //     data: ['极高危险','高度危险','中度危险','低度危险','未评估']
	    // },
	    series : [
	        {
	            name: '危险等级',
	            type: 'pie',
	            radius : '60%',
	            center: ['50%', '50%'],
				label: {
					normal: {
						textStyle: {
							fontSize : 18
						}
					 }
           		},
	            data:[
	                  {value:a.gdwx, name:'高度危险',
					itemStyle:{
						normal:{color:'#fc7e18'}
					}
				},
					{value:a.zdwx, name:'中度危险',
					itemStyle:{
						normal:{color:'#FFC300'}
					}
				},
					{value:a.ddwx, name:'低度危险',
					itemStyle:{
						normal:{color:'#4169E1'}
					}
				},
				{value:a.jgdwx, name:'极高危险',
					itemStyle:{
						normal:{color:'#ff0000'}
					}
				}
	              ],
	            itemStyle: {
	                emphasis: {
	                    shadowBlur: 10,
	                    shadowOffsetX: 0,
	                    shadowColor: 'rgba(0, 0, 0, 0.5)'
	                }
	            }
	        }
	    ]
	};
	
    charts12.setOption(option12);
 	window.addEventListener("resize",function(){
        charts12.resize();
                 });
};
HomeModel.prototype.initPie13 = function (){
	var _this = this;
	
	var charts13 = echarts.init(document.getElementById('djfb_pie13'));
	var a = JSON.parse(j13);
	var option13 ={
		title : {
        text: '出监管区',
        x:'center'
    	},
	    tooltip : {
	        trigger: 'item',
	        formatter: "{a} <br/>{b} : {c} ({d}%)"
	    },
	    // legend: {
	    //     orient: 'vertical',
     //    	x: 'left',
	    //     data: ['极高危险','高度危险','中度危险','低度危险','未评估']
	    // },
	    series : [
	        {
	            name: '危险等级',
	            type: 'pie',
	            radius : '60%',
	            center: ['50%', '50%'],
					label: {
					normal: {
						textStyle: {
							fontSize : 18
						}
					 }
           		},
	            data:[
	                  {value:a.gdwx, name:'高度危险',
					itemStyle:{
						normal:{color:'#fc7e18'}
					}
				},
					{value:a.zdwx, name:'中度危险',
					itemStyle:{
						normal:{color:'#FFC300'}
					}
				},
					{value:a.ddwx, name:'低度危险',
					itemStyle:{
						normal:{color:'#4169E1'}
					}
				},
				{value:a.jgdwx, name:'极高危险',
					itemStyle:{
						normal:{color:'#ff0000'}
					}
				}
	              ],
	            itemStyle: {
	                emphasis: {
	                    shadowBlur: 10,
	                    shadowOffsetX: 0,
	                    shadowColor: 'rgba(0, 0, 0, 0.5)'
	                }
	            }
	        }
	    ]
	};
	
    charts13.setOption(option13);
 	window.addEventListener("resize",function(){
        charts13.resize();
                 });
};
HomeModel.prototype.initPie14 = function (){
	var _this = this;
	
	var charts14 = echarts.init(document.getElementById('djfb_pie14'));
	var a = JSON.parse(j14);
	var option14 ={
		title : {
        text: '新犯队',
        x:'center'
    	},
	    tooltip : {
	        trigger: 'item',
	        formatter: "{a} <br/>{b} : {c} ({d}%)"
	    },
	    // legend: {
	    //     orient: 'vertical',
     //    	x: 'left',
	    //     data: ['极高危险','高度危险','中度危险','低度危险','未评估']
	    // },
	    series : [
	        {
	            name: '危险等级',
	            type: 'pie',
	            radius : '60%',
	            center: ['50%', '50%'],
				label: {
					normal: {
						textStyle: {
							fontSize : 18
						}
					 }
           		},
	            data:[
	                  {value:a.gdwx, name:'高度危险',
					itemStyle:{
						normal:{color:'#fc7e18'}
					}
				},
					{value:a.zdwx, name:'中度危险',
					itemStyle:{
						normal:{color:'#FFC300'}
					}
				},
					{value:a.ddwx, name:'低度危险',
					itemStyle:{
						normal:{color:'#4169E1'}
					}
				},
				{value:a.jgdwx, name:'极高危险',
					itemStyle:{
						normal:{color:'#ff0000'}
					}
				}
	              ],
	            itemStyle: {
	                emphasis: {
	                    shadowBlur: 10,
	                    shadowOffsetX: 0,
	                    shadowColor: 'rgba(0, 0, 0, 0.5)'
	                }
	            }
	        }
	    ]
	};
	
    charts14.setOption(option14);
 	window.addEventListener("resize",function(){
        charts14.resize();
                 });
};

HomeModel.prototype.initPie15 = function (){
	var _this = this;
	
	var charts15 = echarts.init(document.getElementById('djfb_pie15'));
	var a = JSON.parse(j15);
	var option15 ={
		title : {
        text: '医院监区',
        x:'center'
    	},
	    tooltip : {
	        trigger: 'item',
	        formatter: "{a} <br/>{b} : {c} ({d}%)"
	    },
	    // legend: {
	    //     orient: 'vertical',
     //    	x: 'left',
	    //     data: ['极高危险','高度危险','中度危险','低度危险','未评估']
	    // },
	    series : [
	        {
	            name: '危险等级',
	            type: 'pie',
	            radius : '60%',
	            center: ['50%', '50%'],
				label: {
					normal: {
						textStyle: {
							fontSize : 18
						}
					 }
           		},
	            data:[
	                  {value:a.gdwx, name:'高度危险',
					itemStyle:{
						normal:{color:'#fc7e18'}
					}
				},
					{value:a.zdwx, name:'中度危险',
					itemStyle:{
						normal:{color:'#FFC300'}
					}
				},
					{value:a.ddwx, name:'低度危险',
					itemStyle:{
						normal:{color:'#4169E1'}
					}
				},
				{value:a.jgdwx, name:'极高危险',
					itemStyle:{
						normal:{color:'#ff0000'}
					}
				}
	              ],
	            itemStyle: {
	                emphasis: {
	                    shadowBlur: 10,
	                    shadowOffsetX: 0,
	                    shadowColor: 'rgba(0, 0, 0, 0.5)'
	                }
	            }
	        }
	    ]
	};
	
    charts15.setOption(option15);
 	window.addEventListener("resize",function(){
        charts15.resize();
                 });
};
HomeModel.prototype.initPie16 = function (){
	var _this = this;
	
	var charts16 = echarts.init(document.getElementById('djfb_pie16'));
	var a = JSON.parse(j16);
	var option16 ={
		title : {
        text: '狱政科',
        x:'center'
    	},
	    tooltip : {
	        trigger: 'item',
	        formatter: "{a} <br/>{b} : {c} ({d}%)"
	    },
	    // legend: {
	    //     orient: 'vertical',
     //    	x: 'left',
	    //     data: ['极高危险','高度危险','中度危险','低度危险','未评估']
	    // },
	    series : [
	        {
	            name: '危险等级',
	            type: 'pie',
	            radius : '60%',
	            center: ['50%', '50%'],
				label: {
					normal: {
						textStyle: {
							fontSize : 18
						}
					 }
           		},
	            data:[
	                  {value:a.gdwx, name:'高度危险',
					itemStyle:{
						normal:{color:'#fc7e18'}
					}
				},
					{value:a.zdwx, name:'中度危险',
					itemStyle:{
						normal:{color:'#FFC300'}
					}
				},
					{value:a.ddwx, name:'低度危险',
					itemStyle:{
						normal:{color:'#4169E1'}
					}
				},
				{value:a.jgdwx, name:'极高危险',
					itemStyle:{
						normal:{color:'#ff0000'}
					}
				}
	              ],
	            itemStyle: {
	                emphasis: {
	                    shadowBlur: 10,
	                    shadowOffsetX: 0,
	                    shadowColor: 'rgba(0, 0, 0, 0.5)'
	                }
	            }
	        }
	    ]
	};
	
    charts16.setOption(option16);
 	window.addEventListener("resize",function(){
        charts16.resize();
                 });
};







