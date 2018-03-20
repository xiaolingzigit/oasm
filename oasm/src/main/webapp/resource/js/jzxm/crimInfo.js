//格式化本页面时间方法
function fmtDate(time){
	if(null!=time){
		var datetime = time.substring(0,19);
		return datetime;
	}
}
//格式化图表时间
function chartsDate(time){
	if(null!=time){
		var datetime = time.substring(0,10);
		var nowDate = datetime.replace(/-/g,".");
		return nowDate;
	}
}

//先加载页面后加载ajax，避免页面和数据并行
function loadCrimInfo(crimNo,url){
	$('#basecontent').load(url,function(){
		jzgzCrimInfo(crimNo);
	});
}

//封装空数据判断方法
function isNull(obj){
	if(Array.prototype.isPrototypeOf(obj) && obj.length === 0) {
		return true;
	}else if(Object.prototype.isPrototypeOf(obj) && Object.keys(obj).length === 0) { 
		return true;
	} 
	return false;
}

function notNull(obj){
	if(null!==obj&&obj!==undefined &&obj!==''){
		return true;
	}else{
		return false;
	}
}

function jzgzCrimInfo(crimNo){
	var url="/oasm/jygzView/jz_crimInfo";
	$.post(url,{crimNo:crimNo}).done(
	   function(record){
		  var re = JSON.parse(record); //把字符串转为标准的JSON数据
		  var jdata = JSON.parse(re); //循环列表
		  //个人评估报告
		  var a = "";
		  var rqData = [];
		  var fsData = [];
		  if(!isNull(jdata.report)){
			  $.each(jdata.report,function(r,p){
				  rqData.push(chartsDate(p.crTime)); //图表时间
				  fsData.push(p.score); //图表分数
				  a+="<tr class='zfsj_tr'>";
				  a+="<td style='overflow:hidden;white-space:nowrap;text-overflow:ellipsis;' title='"+p.taskId+"'>"+p.taskId+"</td><td>"+p.score+"</td><td>"+fmtDate(p.crTime)+"</td><td><a>查看</a></td>";
				  a+="</tr>";
			  });
		  }else{
			  a+="<tr><td>无数据</td><td>...</td><td>...</td><td>暂未生成报告</td></tr>";
		  }
		  zf_grpgbhqx(rqData,fsData);//暂调用曲线图
		  $("#zf_grpgbg").html(a);
		  
		  //异常狱情部分
		  var b = "";
		  if(!isNull(jdata.ycyqpc)){
			  $.each(jdata.ycyqpc,function(y,c){
				  b+="<tr class='zfsj_tr'>";
				  b+="<td>"+c.fssj+"</td><td>"+notNull(c.yqjb)+"</td><td>"+notNull(c.yqms)+"</td><td><a>查看</a></td>";
				  b+="</tr>";
			  }); 
		  }else{
			  b+="<tr><td>无数据</td><td>...</td><td>...</td><td>无数据</td></tr>";
		  }
		  $("#zf_grycyq").html(b);
		  
		  //个人预警情况
		  var c = "<tr><td>无数据</td><td>...</td><td>...</td><td>无数据</td></tr>";
		  $("#zf_gryjqk").html(c);
		  //个人档案分析部分
		  var d = "";
		  if(!isNull(jdata.dafxjg)){
			  $.each(jdata.dafxjg,function(j,a){
				 d+="<tr class='zfsj_tr'>";
				 d+="<td style='overflow:hidden;white-space:nowrap;text-overflow:ellipsis;' title='"+a.taskId+"'>"+a.taskId+"</td><td>"+a.score+"</td><td>"+fmtDate(a.lastModif)+"</td><td><a>查看</a></td>";
				 d+="</tr>";
			  });
		  }else{
			 d+="<tr><td>无数据</td><td>...</td><td>...</td><td>无数据</td></tr>";
		  }
		  $("#zf_grjcxxpg").html(d);
		  
		  //个人结构访谈
		  var e = "";
		  if(!isNull(jdata.grft)){
			  $.each(jdata.grft,function(f,t){
				  e+="<tr class='zfsj_tr'>";
				  e+="<td style='overflow:hidden;white-space:nowrap;text-overflow:ellipsis;' title='"+t.taskId+"'>"+t.taskId+"</td><td>"+t.score+"</td><td>"+fmtDate(t.lastModif)+"</td><td><a>查看</a></td>";
				  e+="</tr>";
			  });
		  }else{
			  e+="<tr><td>无数据</td><td>...</td><td>...</td><td>无数据</td></tr>";
		  }
		  $("#zf_grjgft").html(e);
		  
		  //个人行为观察
		  var m = "";
		  if(!isNull(jdata.grgc)){
			  $.each(jdata.grgc,function(x,w){
				  m+="<tr class='zfsj_tr'>";
				  m+="<td style='overflow:hidden;white-space:nowrap;text-overflow:ellipsis;' title='"+w.taskId+"'>"+w.taskId+"</td><td>"+w.score+"</td><td>"+fmtDate(w.lastModif)+"</td><td><a>查看</a></td>";
				  m+="</tr>";
			  });
		  }else{
			  m+="<tr><td>无数据</td><td>...</td><td>...</td><td>无数据</td></tr>";
		  }
		  $("#zf_grxwgc").html(m);
		  
		  //个人心理测试报告
		  var n = "";
		  if(!isNull(jdata.element)){
			  $.each(jdata.element,function(x,l){
				  n+="<tr class='zfsj_tr'>";
				  n+="<td style='overflow:hidden;white-space:nowrap;text-overflow:ellipsis;' title='"+l.taskId+"'>"+l.taskId+"</td><td>"+l.score+"</td><td>"+fmtDate(l.lastModif)+"</td><td><a>查看</a></td>";
				  n+="</tr>";
			  });
		  }else{
			  n+="<tr><td>无数据</td><td>...</td><td>...</td><td>无数据</td></tr>";
		  }
		  $("#zf_grxlce").html(n);
		  
		  //危险报告倾向
		  var o = "";
		  if(!isNull(jdata.wxlxReport)){
			  $.each(jdata.wxlxReport,function(qin,xiang){
			switch (xiang.wxlx) {
			case "自杀倾向":
            	o+="<div class='zfxx_zs'>";
				o+="<span class='wxlx_score'>"+xiang.fs+"</span>分";
				o+="<div class='zfxx_wxqx'>"+xiang.dj+"</div>";
				o+="</div>";
				break;
			case "行凶倾向":
            	o+="<div class='zfxx_xx'>";
				o+="<span class='wxlx_score'>"+xiang.fs+"</span>分";
				o+="<div class='zfxx_wxqx'>"+xiang.dj+"</div>";
				o+="</div>";
				break;
			case "脱逃倾向":
				o+="<div class='zfxx_tt'>";
				o+="<span class='wxlx_score'>"+xiang.fs+"</span>分";
				o+="<div class='zfxx_wxqx'>"+xiang.dj+"</div>";
				o+="</div>";
				break;
            case "再犯罪倾向":
            	o+="<div class='zfxx_zf'>";
				o+="<span class='wxlx_score'>"+xiang.fs+"</span>分";
				o+="<div class='zfxx_wxqx'>"+xiang.dj+"</div>";
				o+="</div>";
				break;
			default:
				break;
			  }
		   });
		  }else{
			  o+="<div class='zfxx_zs'>";
			  o+="<span class='wxlx_score'>暂无数据</span>";
			  o+="<div class='zfxx_wxqx'>暂无数据</div>";
			  o+="</div>";
		  }
		  $("#zf_grwxlx").html(o);
		  
		   if(!isNull(jdata.pgbg)){
			   var yz = "",da="",jg="",xg="",xsc="";
			   //jcdafx
			   if(notNull(jdata.pgbg.jcxxpg)){
				   $.each(jdata.pgbg.jcxxpg,function(jc,xx){
					   da+="{\"name\":\""+xx.yz+"\",\"value\":\""+xx.fs+"\"},"; 
				   });
			   }else{
				   da="{\"name\":\"无因子信息\",\"value\":"+10+"},";
			   }
			   //jdata.pgbg.gtftpg
			   if(notNull(jdata.pgbg.gtftpg)){
				   $.each(jdata.pgbg.gtftpg,function(gt,ft){
					   jg+="{\"name\":\""+ft.yz+"\",\"value\":\""+ft.fs+"\"},"; 
					   });
			   }else{
				   jg="{\"name\":\"无因子信息\",\"value\":"+10+"},";
			   }
			   //xwgcpg
			   if(notNull(jdata.pgbg.xwgcpg)){
				   $.each(jdata.pgbg.xwgcpg,function(xw,gc){
					   xg+="{\"name\":\""+gc.yz+"\",\"value\":\""+gc.fs+"\"},"; 
				   });
			   }else{
				   xg="{\"name\":\"无因子信息\",\"value\":"+10+"},"; 
			   }
			   //sclpg
			   if(notNull(jdata.pgbg.sclpg)){
				   $.each(jdata.pgbg.sclpg,function(xl,scl){
					   xsc+="{\"name\":\""+scl.XLYZ+"\",\"value\":\""+scl.XLFS+"\"},";
					   });
			   }else{
				   xsc="{\"name\":\"无因子信息\",\"value\":"+10+"},";
			   }
			   //copapi
			   if(notNull(jdata.pgbg.xlcepg)){
				   $.each(jdata.pgbg.xlcepg,function(co,papi){
					   yz+="{\"name\":\""+papi.XLYZ+"\",\"value\":\""+papi.XLFS+"\"},";
				   });
			   }else{
				   yz="{\"name\":\"无因子信息\",\"value\":"+10+"},";
			   }
			   var pushData = "["+yz+da+jg+xg+xsc+"]";
			   var lastIndex = pushData.lastIndexOf(',');
			   if (lastIndex > -1) { 
				   pushData = pushData.substring(0, lastIndex) + pushData.substring(lastIndex + 1, pushData.length); //去掉不必要的逗号
			   }
			   zf_grwxyz(pushData);
		   }
	   }	
	);
}

//罪犯个人危险因子
function zf_grwxyz(gryz){
	var gryzList = JSON.parse(gryz); //转为严格json格式数据
	var maskImage = new Image();
    var chart = echarts.init(document.getElementById('wordcloud11'));
    var  option = {
         	    backgroundColor: '#F7F7F7',
         	    tooltip: {
         	        show: true
         	    },
         	    toolbox: {
         	        feature: {
         	            saveAsImage: {
         	                iconStyle: {
         	                    normal: {
         	                        color: '#FFFFFF'
         	                    }
         	                }
         	            }
         	        }
         	    },
         	    series: [{
         	        name: '危险因子',
         	        type: 'wordCloud',
         	        left: 'center',
         	        top: 'center',
         	        width: '90%',
         	        height: '90%',
         	        right: null,
         	        bottom: null,
         	        //size: ['9%', '99%'],
         	        sizeRange: [10, 50],
         	        //textRotation: [0, 45, 90, -45],
         	        rotationRange: [-45, 90],
         	        //shape: 'circle',
         	       //maskImage: maskImage,
                   // drawOutOfBound: false,
         	        textPadding: 0,
         	        autoSize: {
         	            enable: true,
         	            minSize: 6
         	        },
         	        textStyle: {
         	            normal: {
         	                color: function() {
         	                    return 'rgb(' + [
         	                        Math.round(Math.random() * 160),
         	                        Math.round(Math.random() * 160),
         	                        Math.round(Math.random() * 160)
         	                    ].join(',') + ')';
         	                }
         	            },
         	            emphasis: {
         	                shadowBlur: 3,
         	                shadowColor: '#333'
         	            }
         	        },
         	        data: [{
         	            name: "Jayfee",
         	            value: 666
         	        }, {
         	            name: "Nancy",
         	            value: 520
         	        }]
         	    }]
         	};
         	option.series[0].data = gryzList;
             maskImage.onload = function(){
                 option.series[0].maskImage;
                 chart.setOption(option);
             }
             maskImage.src = '/oasm/resource/images/criminal.jpg';
             window.onresize = function () {
                 chart.resize();
             }
}

// 基于准备好的dom，初始化echarts实例
function zf_grpgbhqx(rqData,fsData){
	var myChart = echarts.init(document.getElementById('line1'));
	var option2 = {
			backgroundColor: '#578ebe',
		    tooltip: {
		        trigger: 'axis'
		    },
		    legend: {
		        data:['危险等级']
		    },
		    grid: {
		        left: '3%',
		        right: '4%',
		        bottom: '3%',
		        containLabel: true
		    },
		    toolbox: {
		        feature: {
		            saveAsImage: {}
		        }
		    },
		    xAxis: {
		        type: 'category',
		        boundaryGap: false,
		        data: rqData,    
                //设置轴线的属性
                axisLine:{
                    lineStyle:{
                        color:'#fff',
                        width:2,//这里是为了突出显示加上的
                    }
                } 
		    },
		    yAxis: {
		        name : '危险值(分)',
		        type: 'value',    
                //设置轴线的属性
                axisLine:{
                    lineStyle:{
                        color:'#fff',
                        width:2,//这里是为了突出显示加上的
                    }
                } 
		    },
		    series: [
		        {
		            name:'危险指数',
		            type:'line',
		            stack: '总量',  
                    itemStyle : {  
                        normal : {  
                            color:'#ffff00',  
                            lineStyle:{  
                                color:'fff'  
                            }  
                        }  
                    },  
		            data:fsData
		        }
		    ]
		};
	myChart.setOption(option2);
    window.addEventListener("resize",function(){
        myChart.resize();
     });
}
