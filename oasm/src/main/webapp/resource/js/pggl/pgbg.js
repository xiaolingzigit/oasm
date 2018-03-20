//最新评估报告显示页面
$.ajaxSetup({
	cache: false //关闭AJAX相应的缓存
});

function dealNull(obj){
	for(var i in obj){
	  if(null == obj[i] || 'null' == obj[i]){
	  obj[i]='';
	}else if('object' == typeof obj[i]){
	  dealNull(obj[i]);
	}
  }
}

var timesData = [];
var scoreData = [];
function lsbg(qh){
	//显示历史评估报告
	$.ajax({
		url:'/oasm/pgbgView/getLsPgbg',
		dataType:'JSON',
		type:'post',
		async: false,
 		data:{qh:'qh'},//截取囚号
//		data:{qh:qh.substring(0,10)},//截取囚号
		success:function(data){
//			console.info(data);
			if(data==null)return;
			var a = '';
			var list='';//历史报告
			var type='';
			$.each(data,function(k,v){
				switch(v.type){
				case 'inRep':
					type='入监评估报告';
					break;
				case 'dyRep':
					type='日常评估报告';
					break;
				case 'mdRep':
					type='中期评估报告';
					break;
				case 'otRep':
					type='出监评估报告';
					break;
				};
				a+="<tr>";
				a+="<td>"+v.lastModif+"</td>";
				a+="<td>"+type+"</td>";
				a+="<td>"+v.score+"</td>";
				a+="<td>"+v.levl+"</td>";
				a+="<td><a href='#' onclick=\"loadnext3('"+v.taskId+"')\">查看</a></td>";
				a+="</tr>";
				timesData.push(v.lastModif);
				scoreData.push(v.score);
			});
			$("#pgbglssj").html(a);
		}
	});
}

function aEchart(qh){
	lsbg(qh);
	var myChart = echarts.init(document.getElementById('line1'));
	var option2 = {
			title : {
				text : '危险等级变化图',
				//subtext: '【0~40 低度危险】，【41~80 中度危险】，【81~107 高度危险】，【108以上极高危险】',
				x : 'center'
			},
			tooltip : {
				trigger : 'axis',
				formatter : "{a} <br/>时间：{b} <br/>分数：{c}"
			},
			legend : {
				data : [ '危险等级' ]
			},
			grid : {
				left : '3%',
				right : '4%',
				bottom : '3%',
				containLabel : true
			},
			toolbox : {
				feature : {
					saveAsImage : {}
				}
			},
			xAxis : {
				type : 'category',
				boundaryGap : false,
//					data :["2017/10/29","2017/12/23"]
				data :timesData
			},
			yAxis : {
				name : '危险值(分)',
				type : 'value'
			},
			series : [ {
				name : '危险指数',
				type : 'line',
				stack : '总量',
//					data : [60,75]
				data : scoreData
			} ]
		};
	myChart.setOption(option2);
}

//显示入监评估报告

function loadrjbgPage(bgstu,taskId,url){
	$('#basecontent').load(url,function(){
		rjbgData(bgstu,taskId);
	});
}

function rjbgData(bgstu,taskId){
	$.ajax({
		url:"/oasm/pgbgView/pgbgDataView",
		dataType:"JSON",
		type:"post",
		data:{bgstu:bgstu,taskId:taskId},
		success:function(note){
			var daValue = "",jtValue = "",grValue = "",xwValue = "",sclValue = "",papiValue = "";
			if(null!=note&&""!=note){
				var noteJSON = JSON.parse(note);
					aEchart(taskId);
                       $.each(noteJSON,function(k,v){
						
						var xlfs=0; //心理测试总分数
						var tc = ""; //心理赋值变量
						switch (v.taskType) {
						case "DAFX":
						//档案分析
						if(undefined!=v&&null!=v.jcxxpg){
							var tb = "";
						    var dafs = parseInt(v.taskfs);
						  $.each(v.jcxxpg,function(d,a){
								tb+="<tr>";
								tb+="<td>"+a.yz+"</td>";
								tb+="<td>"+parseInt(a.fs)+"</td>";
								tb+="</tr>";
						  });
							$("#addbefore").before(tb);
							$("#dazf").html(dafs);
							}else{
								daValue=null;
							}
							break;
                        case "GTFT":
							
                        //个人访谈
        				if(undefined!=v&&null!=v.gtftpg){
        					var tb = "";
        					var ftfs = parseInt(v.taskfs);
        					$.each(v.gtftpg,function(f,t){
        						tb+="<tr>";
        						tb+="<td>"+t.yz+"</td>";
        						tb+="<td>"+t.fs+"</td>";
        						tb+="</tr>";
        					});
        					$("#ftaddbefore").before(tb);
        					$("#ftdczf").html(ftfs);
        					}else{
        						grValue=null;
        					}
                        	
							break;
                        case "XWGC":
							
                        //行为观察
        				if(undefined!=v&&null!=v.xwgcpg){
        					var tb = "";
        				    var gcfs = v.taskfs;
        				$.each(v.xwgcpg,function(g,c){
        					tb+="<tr>";
        					tb+="<td>"+c.yz+"</td>";
        					tb+="<td>"+c.fs+"</td>";
        					tb+="</tr>";
        				});
        				$("#xwgcaddbefore").before(tb);
        				$("#xwgczf").html(gcfs);
        				}else{
        					xwValue=null;
        				}
							break;
                        case "XLSCL90":
                        	
                        	if(undefined!=v&&null!=v.xlcepg){
        						var line=0;
        						var index=0;
        						xlfs+= parseInt(v.taskfs);
        						$.each(v.xlcepg,function(s,c){
        							line+=1;
        						});
        						$.each(v.xlcepg,function(s,c){
        							if(index==0){
        					        	 tc+="<tr>";
        					        	 tc+="<td rowspan='"+line+"'>"+v.taskType.substring(2)+"</td>";
        					        	 if(isEmpty(c.XLYZ)){
        					        		 tc+="<td></td>";
            					        	 tc+="<td></td>";
            					        	 tc+="<td></td>";
            					        	 tc+="<td></td>";
        					        	 }else{
        					        	    tc+="<td>"+c.XLTZ+"</td>";
        					        	    tc+="<td>"+c.XLYZ+"</td>";
        					        	    tc+="<td>"+c.PGWD+"</td>";
        					        	    tc+="<td>"+c.PGFS+"</td>";
        							    }
        					        	tc+="</tr>";
        					        	index+=1;
        					         }else{
        					        	 if(isEmpty(c.XLYZ)){
        					        		 tc+="<tr>";
        					        		 tc+="<td></td>";
            					        	 tc+="<td></td>";
            					        	 tc+="<td></td>";
            					        	 tc+="<td></td>";
            					        	 tc+="</tr>";
        					        	 }else{
        					        		 tc+="<tr>";
            					        	 tc+="<td>"+c.XLTZ+"</td>";
            					        	 tc+="<td>"+c.XLYZ+"</td>";
            					        	 tc+="<td>"+c.PGWD+"</td>";
            					        	 tc+="<td>"+c.PGFS+"</td>";
            					        	 tc+="</tr>";
        					        	 }
        					        	 index+=1;
        					         }
        						});
        					}else{
        						sclValue = null;
        					}
							
							break;
                        case "XLCOPAPI":
							
                        	//copapi
        					if(undefined!=v&&null!=v.xlcepg){
        						var line=0;
        						var index=0;
        						xlfs+= parseInt(v.taskfs);
        						$.each(v.xlcepg,function(c,o){
        							line+=1;
        						});
        						$.each(v.xlcepg,function(c,o){
        							if(index==0){
        					        	 tc+="<tr>";
        					        	 tc+="<td rowspan='"+line+"'>"+v.taskType.substring(2)+"</td>";
        					        	 if(isEmpty(o.XLYZ)){
        					        		 tc+="<td></td>";
            					        	 tc+="<td></td>";
            					        	 tc+="<td></td>";
            					        	 tc+="<td></td>";
        					        	 }else{
        					        	    tc+="<td>"+o.XLTZ+"</td>";
        					        	    tc+="<td>"+o.XLYZ+"</td>";
        					        	    tc+="<td>"+o.PGWD+"</td>";
        					        	    tc+="<td>"+o.PGFS+"</td>";
        					        	 }
        					        	 tc+="</tr>";
        					        	 index+=1;
        					         }else{
        					        	 if(isEmpty(o.XLYZ)){
        					        		 tc+="<tr>";
        					        		 tc+="<td></td>";
            					        	 tc+="<td></td>";
            					        	 tc+="<td></td>";
            					        	 tc+="<td></td>";
            					        	 tc+="</tr>";
        					        	 }else{
        					        		 tc+="<tr>";
            					        	 tc+="<td>"+o.XLTZ+"</td>";
            					        	 tc+="<td>"+o.XLYZ+"</td>";
            					        	 tc+="<td>"+o.PGWD+"</td>";
            					        	 tc+="<td>"+o.PGFS+"</td>";
            					        	 tc+="</tr>"; 
        					        	 }
        					        	 index+=1;
        					         }
        						});
        					}else{
        						papiValue = null;
        					}
                        	
							break;
						default:
							break;
						}
						$("#xlcezf").html(xlfs);
						$("#xladdbefore").before(tc);
						$("#grlsbg").html(taskId);
					});
			}else{
				alert("出现异常啦~");
			}
		}
	});
	
}


function isEmpty(val){
	if (val == null || val == undefined || val == '') {
		return true;
	} 
	return false;
}

//****************************显示入监评估报告end********************************************
//显示日常评估报告
function loadrcbgPage(bgstu,taskId,url){
	$('#basecontent').load(url,function(){
		rcbgData(bgstu,taskId);
	});
}
function rcbgData(bgstu,taskId){
	$.ajax({
		url:"/oasm/pgbgView/pgbgDataView",
		dataType:"JSON",
		type:"post",
		data:{bgstu:bgstu,taskId:taskId},
		success:function(note){
			var daValue = "",jtValue = "",grValue = "",xwValue = "",sclValue = "",papiValue = "";
			if(null!=note&&""!=note){
				var noteJSON = JSON.parse(note);
					$.each(noteJSON,function(k,v){
						var xlfs=0; //心理测试总分数
						var tc = ""; //心理赋值变量
						switch (v.taskType) {
						case "DAFX":
						//档案分析
						if(undefined!=v&&null!=v.jcxxpg){
							var tb = "";
						    var dafs = parseInt(v.taskfs);
						  $.each(v.jcxxpg,function(d,a){
								tb+="<tr>";
								tb+="<td>"+a.yz+"</td>";
								tb+="<td>"+parseInt(a.fs)+"</td>";
								tb+="</tr>";
						  });
							$("#rcdaaddbefore").before(tb);
							$("#rcdafxzf").html(dafs);
							}else{
								daValue=null;
							}
							break;
                        case "GTFT":
							
                        //个人访谈
        				if(undefined!=v&&null!=v.gtftpg){
        					var tb = "";
        					var ftfs = parseInt(v.taskfs);
        					$.each(v.gtftpg,function(f,t){
        						tb+="<tr>";
        						tb+="<td>"+t.yz+"</td>";
        						tb+="<td>"+t.fs+"</td>";
        						tb+="</tr>";
        					});
        					$("#rcftdcaddbefore").before(tb);
        					$("#rcftdczf").html(ftfs);
        					}else{
        						grValue=null;
        					}
                        	
							break;
                        case "XWGC":
							
                        //行为观察
        				if(undefined!=v&&null!=v.xwgcpg){
        					var tb = "";
        				    var gcfs = v.taskfs;
        				$.each(v.xwgcpg,function(g,c){
        					tb+="<tr>";
        					tb+="<td>"+c.yz+"</td>";
        					tb+="<td>"+c.fs+"</td>";
        					tb+="</tr>";
        				});
        				$("#rcxwgcaddbefore").before(tb);
        				$("#rcxwgczf").html(gcfs);
        				}else{
        					xwValue=null;
        				}
							break;
                        case "XLSCL90":
                        	if(undefined!=v&&null!=v.xlcepg){
        						var line=0;
        						var index=0;
        						xlfs+= parseInt(v.taskfs);
        						$.each(v.xlcepg,function(s,c){
        							line+=1;
        						});
        						$.each(v.xlcepg,function(s,c){
        							if(index==0){
        					        	 tc+="<tr>";
        					        	 tc+="<td rowspan='"+line+"'>"+v.taskType.substring(2)+"</td>";
        					        	 if(isEmpty(c.XLYZ)){
        					        		 tc+="<td></td>";
            					        	 tc+="<td></td>";
            					        	 tc+="<td></td>";
            					        	 tc+="<td></td>";
        					        	 }else{
        					        	    tc+="<td>"+c.XLTZ+"</td>";
        					        	    tc+="<td>"+c.XLYZ+"</td>";
        					        	    tc+="<td>"+c.PGWD+"</td>";
        					        	    tc+="<td>"+c.PGFS+"</td>";
        							    }
        					        	tc+="</tr>";
        					        	index+=1;
        					         }else{
        					        	 if(isEmpty(c.XLYZ)){
        					        		 tc+="<tr>";
        					        		 tc+="<td></td>";
            					        	 tc+="<td></td>";
            					        	 tc+="<td></td>";
            					        	 tc+="<td></td>";
            					        	 tc+="</tr>";
        					        	 }else{
        					        		 tc+="<tr>";
            					        	 tc+="<td>"+c.XLTZ+"</td>";
            					        	 tc+="<td>"+c.XLYZ+"</td>";
            					        	 tc+="<td>"+c.PGWD+"</td>";
            					        	 tc+="<td>"+c.PGFS+"</td>";
            					        	 tc+="</tr>";
        					        	 }
        					        	 index+=1;
        					         }
        						});
        					}else{
        						sclValue = null;
        					}
							
							break;
                        case "XLCOPAPI":
                        	//copapi
        					if(undefined!=v&&null!=v.xlcepg){
        						var line=0;
        						var index=0;
        						xlfs+= parseInt(v.taskfs);
        						$.each(v.xlcepg,function(c,o){
        							line+=1;
        						});
        						$.each(v.xlcepg,function(c,o){
        							if(index==0){
        					        	 tc+="<tr>";
        					        	 tc+="<td rowspan='"+line+"'>"+v.taskType.substring(2)+"</td>";
        					        	 if(isEmpty(o.XLYZ)){
        					        		 tc+="<td></td>";
            					        	 tc+="<td></td>";
            					        	 tc+="<td></td>";
            					        	 tc+="<td></td>";
        					        	 }else{
        					        	    tc+="<td>"+o.XLTZ+"</td>";
        					        	    tc+="<td>"+o.XLYZ+"</td>";
        					        	    tc+="<td>"+o.PGWD+"</td>";
        					        	    tc+="<td>"+o.PGFS+"</td>";
        					        	 }
        					        	 tc+="</tr>";
        					        	 index+=1;
        					         }else{
        					        	 if(isEmpty(o.XLYZ)){
        					        		 tc+="<tr>";
        					        		 tc+="<td></td>";
            					        	 tc+="<td></td>";
            					        	 tc+="<td></td>";
            					        	 tc+="<td></td>";
            					        	 tc+="</tr>";
        					        	 }else{
        					        		 tc+="<tr>";
            					        	 tc+="<td>"+o.XLTZ+"</td>";
            					        	 tc+="<td>"+o.XLYZ+"</td>";
            					        	 tc+="<td>"+o.PGWD+"</td>";
            					        	 tc+="<td>"+o.PGFS+"</td>";
            					        	 tc+="</tr>"; 
        					        	 }
        					        	 index+=1;
        					        	
        					         }
        						});
        					}else{
        						papiValue = null;
        					}
                        	
							break;
						default:
							break;
						}
						$("#xlcszf").html(xlfs);
						$("#rcxladdbefore").before(tc);
//						  $("#grlsbg").html(taskId);
					});
					
			}else{
				alert("出现异常啦~");
			}
		}
	});
}
//****************************显示日常评估报告end*************************************************************
//显示中期评估报告
function loadzqbgPage(bgstu,taskId,url){
	$('#basecontent').load(url,function(){
		zqbgData(bgstu,taskId);
	});
}
function zqbgData(bgstu,taskId){
	$.ajax({
		url:"/oasm/pgbgView/pgbgDataView",
		dataType:"JSON",
		type:"post",
		data:{bgstu:bgstu,taskId:taskId},
		success:function(note){
			var daValue = "",jtValue = "",grValue = "",xwValue = "",sclValue = "",papiValue = "";
			if(null!=note&&""!=note){
				var noteJSON = JSON.parse(note);
                     $.each(noteJSON,function(k,v){
						var xlfs=0; //心理测试总分数
						var tc = ""; //心理赋值变量
						switch (v.taskType) {
						case "DAFX":
						//档案分析
						if(undefined!=v&&null!=v.jcxxpg){
							var tb = "";
						    var dafs = parseInt(v.taskfs);
						  $.each(v.jcxxpg,function(d,a){
								tb+="<tr>";
								tb+="<td>"+a.yz+"</td>";
								tb+="<td>"+parseInt(a.fs)+"</td>";
								tb+="</tr>";
						  });
							$("#zqdaaddbefore").before(tb);
							$("#zqdafxzf").html(dafs);
							}else{
								daValue=null;
							}
							break;
                        case "GTFT":
							
                        //个人访谈
        				if(undefined!=v&&null!=v.gtftpg){
        					var tb = "";
        					var ftfs = parseInt(v.taskfs);
        					$.each(v.gtftpg,function(f,t){
        						tb+="<tr>";
        						tb+="<td>"+t.yz+"</td>";
        						tb+="<td>"+t.fs+"</td>";
        						tb+="</tr>";
        					});
        					$("#zqftdcaddbefore").before(tb);
        					$("#zqftdczf").html(ftfs);
        					}else{
        						grValue=null;
        					}
                        	
							break;
                        case "XWGC":
							
                        //行为观察
        				if(undefined!=v&&null!=v.xwgcpg){
        					var tb = "";
        				    var gcfs = v.taskfs;
        				$.each(v.xwgcpg,function(g,c){
        					tb+="<tr>";
        					tb+="<td>"+c.yz+"</td>";
        					tb+="<td>"+c.fs+"</td>";
        					tb+="</tr>";
        				});
        				$("#zqxwgcaddbefore").before(tb);
        				$("#zqxwgczf").html(gcfs);
        				}else{
        					xwValue=null;
        				}
							break;
                         case "XLSCL90":
                        	
                        	if(undefined!=v&&null!=v.xlcepg){
        						var line=0;
        						var index=0;
        						xlfs+= parseInt(v.taskfs);
        						$.each(v.xlcepg,function(s,c){
        							line+=1;
        						});
        						$.each(v.xlcepg,function(s,c){
        							if(index==0){
        					        	 tc+="<tr>";
        					        	 tc+="<td rowspan='"+line+"'>"+v.taskType.substring(2)+"</td>";
        					        	 if(isEmpty(c.XLYZ)){
        					        		 tc+="<td></td>";
            					        	 tc+="<td></td>";
            					        	 tc+="<td></td>";
            					        	 tc+="<td></td>";
        					        	 }else{
        					        	    tc+="<td>"+c.XLTZ+"</td>";
        					        	    tc+="<td>"+c.XLYZ+"</td>";
        					        	    tc+="<td>"+c.PGWD+"</td>";
        					        	    tc+="<td>"+c.PGFS+"</td>";
        							    }
        					        	tc+="</tr>";
        					        	index+=1;
        					         }else{
        					        	 if(isEmpty(c.XLYZ)){
        					        		 tc+="<tr>";
        					        		 tc+="<td></td>";
            					        	 tc+="<td></td>";
            					        	 tc+="<td></td>";
            					        	 tc+="<td></td>";
            					        	 tc+="</tr>";
        					        	 }else{
        					        		 tc+="<tr>";
            					        	 tc+="<td>"+c.XLTZ+"</td>";
            					        	 tc+="<td>"+c.XLYZ+"</td>";
            					        	 tc+="<td>"+c.PGWD+"</td>";
            					        	 tc+="<td>"+c.PGFS+"</td>";
            					        	 tc+="</tr>";
        					        	 }
        					        	 index+=1;
        					         }
        						});
        					}else{
        						sclValue = null;
        					}
							
							break;
                        case "XLCOPAPI":
							
                        	//copapi
        					if(undefined!=v&&null!=v.xlcepg){
        						var line=0;
        						var index=0;
        						xlfs+= parseInt(v.taskfs);
        						$.each(v.xlcepg,function(c,o){
        							line+=1;
        						});
        						$.each(v.xlcepg,function(c,o){
        							if(index==0){
        					        	 tc+="<tr>";
        					        	 tc+="<td rowspan='"+line+"'>"+v.taskType.substring(2)+"</td>";
        					        	 if(isEmpty(o.XLYZ)){
        					        		 tc+="<td></td>";
            					        	 tc+="<td></td>";
            					        	 tc+="<td></td>";
            					        	 tc+="<td></td>";
        					        	 }else{
        					        	    tc+="<td>"+o.XLTZ+"</td>";
        					        	    tc+="<td>"+o.XLYZ+"</td>";
        					        	    tc+="<td>"+o.PGWD+"</td>";
        					        	    tc+="<td>"+o.PGFS+"</td>";
        					        	 }
        					        	 tc+="</tr>";
        					        	 index+=1;
        					         }else{
        					        	 if(isEmpty(o.XLYZ)){
        					        		 tc+="<tr>";
        					        		 tc+="<td></td>";
            					        	 tc+="<td></td>";
            					        	 tc+="<td></td>";
            					        	 tc+="<td></td>";
            					        	 tc+="</tr>";
        					        	 }else{
        					        		 tc+="<tr>";
            					        	 tc+="<td>"+o.XLTZ+"</td>";
            					        	 tc+="<td>"+o.XLYZ+"</td>";
            					        	 tc+="<td>"+o.PGWD+"</td>";
            					        	 tc+="<td>"+o.PGFS+"</td>";
            					        	 tc+="</tr>"; 
        					        	 }
        					        	 index+=1;
        					         }
        						});
        					}else{
        						papiValue = null;
        					}
                        	
							break;
						default:
							break;
						}
						$("#zqxlcezf").html(xlfs);
						$("#zqxlceaddbefore").before(tc);
//						  $("#grlsbg").html(taskId);
					});
			}else{
				alert("出现异常啦~");
			}
		}
	});
}
	
//*****************************显示中期评估报告end*******************************************************************************
//显示出监评估报告罪犯基础信息
function loadcjbgPage(bgstu,taskId,url){
	$('#basecontent').load(url,function(){
		cjbgData(bgstu,taskId);
	});
}
function cjbgData(bgstu,taskId){
	$.ajax({
		url:"/oasm/pgbgView/pgbgDataView",
		dataType:"JSON",
		type:"post",
		data:{bgstu:bgstu,taskId:taskId},
		success:function(note){
			var daValue = "",jtValue = "",grValue = "",xwValue = "",sclValue = "",papiValue = "";
			if(null!=note&&""!=note){
				var noteJSON = JSON.parse(note);
                      $.each(noteJSON,function(k,v){
						var xlfs=0; //心理测试总分数
						var tc = ""; //心理赋值变量
						switch (v.taskType) {
						case "DAFX":
						//档案分析
						if(undefined!=v&&null!=v.jcxxpg){
							var tb = "";
						    var dafs = parseInt(v.taskfs);
						  $.each(v.jcxxpg,function(d,a){
								tb+="<tr>";
								tb+="<td>"+a.yz+"</td>";
								tb+="<td>"+parseInt(a.fs)+"</td>";
								tb+="</tr>";
						  });
							$("#cjdafxaddbefeore").before(tb);
							$("#cjdafxzf").html(dafs);
							}else{
								daValue=null;
							}
							break;
                        case "GTFT":
							
                        //个人访谈
        				if(undefined!=v&&null!=v.gtftpg){
        					var tb = "";
        					var ftfs = parseInt(v.taskfs);
        					$.each(v.gtftpg,function(f,t){
        						tb+="<tr>";
        						tb+="<td>"+t.yz+"</td>";
        						tb+="<td>"+t.fs+"</td>";
        						tb+="</tr>";
        					});
        					$("#cjftdcaddbefore").before(tb);
        					$("#cjftdczf").html(ftfs);
        					}else{
        						grValue=null;
        					}
                        	
							break;
                        case "XWGC":
							
                        //行为观察
        				if(undefined!=v&&null!=v.xwgcpg){
        					var tb = "";
        				    var gcfs = v.taskfs;
        				$.each(v.xwgcpg,function(g,c){
        					tb+="<tr>";
        					tb+="<td>"+c.yz+"</td>";
        					tb+="<td>"+c.fs+"</td>";
        					tb+="</tr>";
        				});
        				$("#cjxwgcaddbefore").before(tb);
        				$("#cjxwgczf").html(gcfs);
        				}else{
        					xwValue=null;
        				}
							break;
                            case "XLSCL90":
                        	
                        	if(undefined!=v&&null!=v.xlcepg){
        						var line=0;
        						var index=0;
        						xlfs+= parseInt(v.taskfs);
        						$.each(v.xlcepg,function(s,c){
        							line+=1;
        						});
        						$.each(v.xlcepg,function(s,c){
        							if(index==0){
        					        	 tc+="<tr>";
        					        	 tc+="<td rowspan='"+line+"'>"+v.taskType.substring(2)+"</td>";
        					        	 if(isEmpty(c.XLYZ)){
        					        		 tc+="<td></td>";
            					        	 tc+="<td></td>";
            					        	 tc+="<td></td>";
            					        	 tc+="<td></td>";
        					        	 }else{
        					        	    tc+="<td>"+c.XLTZ+"</td>";
        					        	    tc+="<td>"+c.XLYZ+"</td>";
        					        	    tc+="<td>"+c.PGWD+"</td>";
        					        	    tc+="<td>"+c.PGFS+"</td>";
        							    }
        					        	tc+="</tr>";
        					        	index+=1;
        					         }else{
        					        	 if(isEmpty(c.XLYZ)){
        					        		 tc+="<tr>";
        					        		 tc+="<td></td>";
            					        	 tc+="<td></td>";
            					        	 tc+="<td></td>";
            					        	 tc+="<td></td>";
            					        	 tc+="</tr>";
        					        	 }else{
        					        		 tc+="<tr>";
            					        	 tc+="<td>"+c.XLTZ+"</td>";
            					        	 tc+="<td>"+c.XLYZ+"</td>";
            					        	 tc+="<td>"+c.PGWD+"</td>";
            					        	 tc+="<td>"+c.PGFS+"</td>";
            					        	 tc+="</tr>";
        					        	 }
        					        	 index+=1;
        					         }
        						});
        					}else{
        						sclValue = null;
        					}
							
							break;
                        case "XLCOPAPI":
							
                        	//copapi
        					if(undefined!=v&&null!=v.xlcepg){
        						var line=0;
        						var index=0;
        						xlfs+= parseInt(v.taskfs);
        						$.each(v.xlcepg,function(c,o){
        							line+=1;
        						});
        						$.each(v.xlcepg,function(c,o){
        							if(index==0){
        					        	 tc+="<tr>";
        					        	 tc+="<td rowspan='"+line+"'>"+v.taskType.substring(2)+"</td>";
        					        	 if(isEmpty(o.XLYZ)){
        					        		 tc+="<td></td>";
            					        	 tc+="<td></td>";
            					        	 tc+="<td></td>";
            					        	 tc+="<td></td>";
        					        	 }else{
        					        	    tc+="<td>"+o.XLTZ+"</td>";
        					        	    tc+="<td>"+o.XLYZ+"</td>";
        					        	    tc+="<td>"+o.PGWD+"</td>";
        					        	    tc+="<td>"+o.PGFS+"</td>";
        					        	 }
        					        	 tc+="</tr>";
        					        	 index+=1;
        					         }else{
        					        	 if(isEmpty(o.XLYZ)){
        					        		 tc+="<tr>";
        					        		 tc+="<td></td>";
            					        	 tc+="<td></td>";
            					        	 tc+="<td></td>";
            					        	 tc+="<td></td>";
            					        	 tc+="</tr>";
        					        	 }else{
        					        		 tc+="<tr>";
            					        	 tc+="<td>"+o.XLTZ+"</td>";
            					        	 tc+="<td>"+o.XLYZ+"</td>";
            					        	 tc+="<td>"+o.PGWD+"</td>";
            					        	 tc+="<td>"+o.PGFS+"</td>";
            					        	 tc+="</tr>"; 
        					        	 }
        					        	 index+=1;
        					         }
        						});
        					}else{
        						papiValue = null;
        					}
                        	
							break;
						default:
							break;
						}
						$("#cjxlcezf").html(xlfs);
						$("#cjxladdbefore").before(tc);
					});
			}else{
				alert("心理测试任务必须先完成~");
			}
		}
	});
}
	
//******************************显示出监评估报告end*********************************************************************
//下载
function loadImgIndex(){
	
}