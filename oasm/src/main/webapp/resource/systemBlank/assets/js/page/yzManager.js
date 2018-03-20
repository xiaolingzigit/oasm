$.ajaxSetup({ 
    async : false 
}); 
//封装的提示
$(function () {
	  window.Modal = function () {
	    var reg = new RegExp("\\[([^\\[\\]]*?)\\]", 'igm');
	    var alr = $("#ycf-alert");
	    var ahtml = alr.html();
	    var _alert = function (options) {
	      alr.html(ahtml);    // 复原
	      alr.find('.ok').removeClass('btn-success').addClass('btn-primary');
	      alr.find('.cancel').hide();
	      _dialog(options);

	      return {
	        on: function (callback) {
	          if (callback && callback instanceof Function) {
	            alr.find('.ok').click(function () { callback(true) });
	          }
	        }
	      };
	    };

	    var _confirm = function (options) {
	      alr.html(ahtml); // 复原
	      alr.find('.ok').removeClass('btn-primary').addClass('btn-success');
	      alr.find('.cancel').show();
	      _dialog(options);

	      return {
	        on: function (callback) {
	          if (callback && callback instanceof Function) {
	            alr.find('.ok').click(function () { callback(true) });
	            alr.find('.cancel').click(function () { callback(false) });
	          }
	        }
	      };
	    };

	    var _dialog = function (options) {
	      var ops = {
	        msg: "提示内容",
	        title: "操作提示",
	        btnok: "确定",
	        btncl: "取消"
	      };

	      $.extend(ops, options);

	      console.log(alr);

	      var html = alr.html().replace(reg, function (node, key) {
	        return {
	          Title: ops.title,
	          Message: ops.msg,
	          BtnOk: ops.btnok,
	          BtnCancel: ops.btncl
	        }[key];
	      });
	      
	      alr.html(html);
	      alr.modal({
	        width: 500,
	        backdrop: 'static'
	      });
	    }

	    return {
	      alert: _alert,
	      confirm: _confirm
	    }

	  }();
});

//验证维度名
var o = 0; //全局的自增变量
function check_dim_name(){
  var dimName=$("input[name='dimName']").val();
  var dim_flag = 0;
  if(dimName!=null&&dimName!=""){
	  $.ajax({
			 url:"/oasm/tdminAndtyz/checkDminName",
			 type:"post",
			 dataType:"JSON",
			 async:false,
			 data:{dimName:dimName},
			 success:function(i){
				 if(i==0){
					 document.getElementById("input_dimName").innerHTML="<div class='input_judge j_r'>该维度名称可用</div>";
					 //$("#check_dim_error").css("display","none");
					 //$("#check_dim_success").css("display","block");
					 return dim_flag;
				 }else{
					 document.getElementById("input_dimName").innerHTML="<div class='input_judge j_w'>维度已存在</div>"; 
					 //$("#check_dim_success").css("display","none");
					 //$("#check_dim_error").css("display","block");
					 return dim_flag=1;
				 }
			 }
		  });
  }else{
	  document.getElementById("input_dimName").innerHTML="<div class='input_judge j_w'>请输入维度名称</div>"; 
	  return dim_flag=2;
  }
  return dim_flag; //数值返回1则表示已经有存在的维度名
}
//添加维度
function add_dim_save(){
	var dim_save = check_dim_name();
	var dimName=$("input[name='dimName']").val();
	var remark = $("#dim_remark").val();
	if(dim_save!=0){
		if(dim_save==1){
			document.getElementById("input_dimName").innerHTML="<div class='input_judge j_w'>维度已存在</div>"; 
		//$("#check_dim_success").css("display","none");
		//$("#check_dim_error").css("display","block");
		}else{
			 document.getElementById("input_dimName").innerHTML="<div class='input_judge j_w'>请输入维度名称</div>"; 
		}
	}else{
		$.ajax({
			url:"/oasm/tdminAndtyz/insertTdmin",
			dataType:"JSON",
			type:"post",
			data:{dimName:dimName,remark:remark},
			success:function(i){
			  if(i==1){
				  alert("添加成功!");
				  $("input[name='dimName']").val("");
			  }else{
				  alert("管理员必须为登录状态");
			  }
			}
		});
	}
}


//验证因子名和维度关系
function check_yzname(){
	var name = $("input[name='fzname']").val();
	var dimId = $("#select_dim_id").val();
    if(null!=dimId&&""!=dimId){
    	var yz_flage = 0;
    	if(name!=null&&name!=""){
    		$.ajax({
    			url:"/oasm/tdminAndtyz/checkFactorName",
    			dataType:"JSON",
    			type:"post",
    			async:false,
    			data:{name:name,dimId:dimId},
    			success:function(i){
    			  if(i==0){
    				//表示因子名称可用
    				  document.getElementById("input_yz").innerHTML="<div  class='input_judge j_r'>该因子名称可用</div>";
    				  document.getElementById("input_dim").innerHTML="<div class='input_judge j_r'>维度可用</div>";
    				  return yz_flage;
    			  }else{
    				  //因子已存在
    				  document.getElementById("input_yz").innerHTML="<div class='input_judge j_w'>因子维度关系已存在</div>";
    				  //alert("因子已经存在");
    				  return yz_flage=1;
    			  }
    			}
    		});
    	  }else{
    		  //表示因子为空
    		  document.getElementById("input_yz").innerHTML="<div class='input_judge j_w'>因子名称不能为空</div>";
    		 return yz_flage=2;
    	  }
    	return yz_flage; //数值返回1则表示因子名字已经存在，不可重复添加；2表示因子名为空；0表示因子名可用	
    }else{
    	document.getElementById("input_dim").innerHTML="<span class='input_judge j_w'>请选择维度</span>";
    }	
}

//列出所有的维度
$(function(){
	$.ajax({
		url:"/oasm/tdminAndtyz/listTdmin",
		type:"post",
		dataType:"JSON",
		success:function(data){
			var s = "";
			$.each(data,function(k,v){
				s+="<option value='"+v.dimId+"'>"+v.dimName+"</option>";
			});
			$("#select_dim_id").append(s);
			$("#select_dim_question").append(s);
		}
	});
});

//保存添加的因子
function yz_name_save(){
	var yz_save = check_yzname();
	var name = $("input[name='fzname']").val();
	var fScore = $("input[name='fScore']").val();
	var dimId = $("#select_dim_id").val();
	var remark = $("#remarkname").val();
	if(yz_save!=0){
		if(yz_save==1){
		//表示因子已经存在
			document.getElementById("input_yz").innerHTML="<div  class='input_judge j_w'>因子维度关系已经存在</div>";			
	}else{
		//表示因子为空
		document.getElementById("input_yz").innerHTML="<div  class='input_judge j_w'>因子名称不能为空</div>";
	}
		}
	else{
		if(dimId!=null&&dimId!=""){ //校验维度编号不能为空
			$.ajax({
			  url:"/oasm/tdminAndtyz/addWdYzRelat",
			  dataType:"JSON",
			  type:"post",
			  data:{dimId:dimId,name:name,fScore:fScore,remark:remark},
			  success:function(i){
				  if(i==1){
					  $("input[name='fzname']").val("");
					  document.getElementById("input_yz").innerHTML="";	
				  }else{
					  alert("插入失败，请确保管理员为登录状态，请重试...");
				  }
			  }
			});
		
		}else{
			//表示维度为空
			document.getElementById("input_dim").innerHTML="<div class='input_judge j_w'>请选择维度!</div>";
			//alert("维度不能为空！");
		}
	}
}

//使用维度因子级联
$(function(){
	$("#select_dim_question").change(function(){
		var dimId = $("#select_dim_question").val();
		$.ajax({
			url:"/oasm/tdminAndtyz/listFactor",
			type:"post",
			dataType:"JSON",
			data:{dimId:dimId},
			success:function(data){
				var a = "";
				if(null!=data&&""!=data){
					var json = eval(data);
					console.info(json);
					var b = ";";
					$.each(json,function(k,v){
						a+="<option value='"+v.fId+b+v.name+"'>"+v.name+"</option>";
					});
				}else{
					a+="<option value=''>无</option>";
				}
				$("#select_factor_question").html(a);
				$("#wenti_yz_select").html("");
				o=0;//清空div里面的序号
			}
		});
	});
});
//复制因子名称进选项名称
function copy_factorname(){
	$("#input_option_content").val( $("#select_factor_question option:selected").html());
}
//清空选项内容
function resh_options(){
	$("#wenti_yz_select").html("");
	o=0;//清空div里面的序号
}

//实现问题选项预览效果
$(function(){
	$("#insert_wenti_yz").click(function(){
		if($("input[name='options']").val()!=null&&$("input[name='options']").val()!=""){
	    document.getElementById("input_options").innerHTML=" ";
		var splitfId = $("#select_factor_question").val().split(";"); //选中的因子
		var fId = splitfId[0];
		var fname = splitfId[1];
		var options = $("input[name='options']").val(); //输入的选项内容
		o++;
		
		var fo = o+"#"+options+"#"+fId+"#"+fname+"%%"; //选项编号+选项内容+因子编号+因子名称
		$("#wenti_yz_select").append(fo+"\n");
		var a = $("#wenti_yz_select").html().replace('\n','<br>');
		$("#wenti_yz_select").html(a);
		}else{
			document.getElementById("input_options").innerHTML="<div class='input_judge j_w'>请输入选项内容</div>";		}
	});
});



//保存问题
function wenti_yz_select_save(){
  var dimId = $("#select_dim_question").val(); //维度
  var orgId = $("#select_org_question").val(); //监狱代码
  var question = $("#quest_context").val();
  var type = $("input[name='type']:checked").val();
  var remark = $("#booleanTrue").val(); //判断依据
  var option = []; //存储选项
  
  
  var ops = $("#wenti_yz_select").html().split("<br>");
  for(var i = 0;i<ops.length-1;i++){ //表示获取<br>分割的数据
	  var a = ops[i];
	  option.push(a);
  }
  
  var options = option.toString();
  console.info(dimId,orgId,question,type,remark,options);
  $.ajax({
	 url:"/oasm/tdminAndtyz/addQuestion",
	 dataType:"JSON",
	 type:"post",
	 data:{dimId:dimId,orgId:orgId,question:question,type:type,remark:remark,options:options},
	 success:function(i){
		 if(i==1){
			 $("#quest_context").val("");
			 $("#booleanTrue").val("");	
			 $("#input_option_content").val("");
			 $("#wenti_yz_select").html("");
			console.info("添加问题成功!");
		 }else{
			 alert("添加问题失败，请先确认登录状态！");
		 }
	 }
  });
  
}
//点击修改因子名
function modify_fname(element) {
	var original_data= $(element).prev().html();
	var fId = $(element).attr('name');
	var controls="";
	controls+="<input type='text' class='now_fn'  name='chckFname' value='"+original_data+"' />";
	controls+="<button class='cancel' name="+fId+" onclick='cancel_modify_fn(this)'>取消</button>";
	controls+="<button class='save' name="+fId+" onclick='save_modify_fn(this)'>保存</button>";
	$(element).parent().find(".factorval").css("display","none");
	$(element).before(controls);
	$(element).remove();
	
}
//点击修改因子所绑定的维度
function modify_dafrelation(element) {
	var original_data="";
	 original_data= $(element).prev().html();
	 var dimId = $(element).attr('name'); //维度编号
	$.ajax({
		url:"/oasm/tdminAndtyz/listTdmin",
		type:"post",
		dataType:"JSON",
		success:function(data){
			var controls="";
			controls+="<select>";
			$.each(data,function(k,v){
				if(v.dimName==original_data){
				controls+="<option value='"+v.dimId+"'  selected='selected'>"+v.dimName+"</option>";
				}else{
					controls+="<option  value='"+v.dimId+"'>"+v.dimName+"</option>";
				}
			});		
			controls+="</select>";
			controls+="<button class='cancel' name="+dimId+" onclick='cancel_modify_daf(this)'>取消</button>";
			controls+="<button class='save' name="+dimId+" onclick='save_modify_daf(this)'>保存</button>";
			$(element).parent().find(".dimval").css("display","none");
			$(element).before(controls);
			$(element).remove();
		}
	});
}
//取消修改因子名
function cancel_modify_fn(element){
	var original_data="";
	original_data= $(element).parent().find(".factorval").html();
	var fId = $(element).attr('name');
	var controls="";
	controls+="<span class='factorval'>"+original_data+"</span>" ;
	controls+="<span class='modify_btn' name='"+fId+"' onclick='modify_fname(this)'>修改</span>";
	$(element).siblings().remove();
	$(element).before(controls);
	$(element).remove();
}
//取消修改因子所绑定的维度
function cancel_modify_daf(element){
	var original_data="";
	original_data= $(element).parent().find(".dimval").html();
	var dimId = $(element).attr('name'); //时刻绑定维度
	var controls="";
	controls+="<span class='dimval'>"+original_data+"</span>" ;
	controls+="<span class='modify_btn' name="+dimId+" onclick='modify_dafrelation(this)'>修改</span>";
	$(element).siblings().remove();
	$(element).before(controls);
	$(element).remove();
}

function isHaveRelat(i){ //提示关系已经存在
	if(i==1){
		Modal.alert(
				  {
				    msg: '【该因子和维度关系已经存在'+i+'个】',
				    title: '异常',
				    btnok: '确定'
		});
	}
}

function isComfir(name,i){ //提示显示
	Modal.alert(
			  {
			    msg: '【因子:'+name+'】,已有【'+i+'个】',
			    title: '错误',
			    btnok: '确定'
	});
}

function notComfir(){ //提示信息
	Modal.alert(
			  {
			    msg: '请不要输入空因子名称!',
			    title: '警告',
			    btnok: '确定'
	});
}

function tipComfir(){ //提示信息
	Modal.alert(
			  {
			    msg: '出错了!',
			    title: '警告',
			    btnok: '确定'
	});
}
function sucComfir(i){ //修改完成
	if(i==1){
		Modal.alert({
			 msg: '修改成功',
			    title: '提示',
			    btnok: '确定'
		  }).on( function (e) {
			  showPage("/oasm/yzk/yzManager");
		  });
	}else{
		tipComfir(); //出现异常情况
	}
}
function sucYsck(i,name){//执行添加成功
	if(1==i){
//		$("#ysIdValue").val(""); //清空数据
		$("#ysmcValue").val("");
		$("#ysksmValue").val("");
		Modal.alert({
			 msg: '【'+name+'】添加成功',
			    title: '提示',
			    btnok: '确定'
		  });
	}else{
		Modal.alert({
			 msg: '添加失败，请校验...',
			    title: '提示',
			    btnok: '确定'
		  });
	}
}

//验证因子名
function save_modify_fn(element){
	var name =  $(element).parent().find('input').val().trim(); //因子名
	var fId =$(element).attr('name'); //因子
	if(null!=name&&""!=name){
		var url = "/oasm/tdminAndtyz/checkHaveFname";
		$.post(url,{name:name}).done(function(i){
			if(i==1){
				isComfir(name,i);
			}else{
				Modal.confirm({
						    msg: "确认修改【因子编号为:"+fId+"】的【因子名称为:"+name+"】？"
						  }).on( function (e) {
							    if(e){//执行修改
							    	$.post("/oasm/tdminAndtyz/updateFaName",{fId:fId,fName:name})
							    	.done(function(i){
							    		sucComfir(i); //调用修改完成方法
							    	});
							    }
						  });
			}
		}).fail(function(){ tipComfir() });
	}else{
		notComfir();
	}
}

//验证修改的因子和维度关系是否已经存在
function save_modify_daf(element){
	var dimId = $(element).attr('name').split("@"); 
	var da = dimId[0]; //原来的维度边编号
	var fa = dimId[1]; //原来的因子编号
	var fb = fa; //新的因子编号和原来的一致
	var db = $(element).parent().find("option:selected").val(); //修改后的维度编号
	//验证选择的因子和维度是否已经存在
	if(null!=db&&null!=fa){
		$.post("/oasm/tdminAndtyz/checkDIdFId",{dimId:db,fId:fa}).done(
			function(i){
				if(i==1){
					isHaveRelat(i); //关系已经存在了
				}else{
					//继续执行修改
					Modal.confirm({
					    msg: "确认修改因子和维度关系？"
					  }).on( function (e) {
						    if(e){//执行修改
						    	$.post("/oasm/tdminAndtyz/updateWYRelat",{da:da,fa:fa,db:db,fb:fb}).done(
						    	  function(i){
						    		  sucComfir(i); //调用修改完成
						    	  }
						    	);
						    }
					  });
				}
			}
		);
	}
}


/**********************************重新设计因子和维度*********************************************/
//添加元素
function saveYsk(){
	var ysId = $("#ysIdValue").val();//元素编号
	var ysmc = $("#ysmcValue").val();
	var ysyt = $("#ysytValue").val();
	var ystz = $("#ystzValue").val();
	var yssm = $("#ysksmValue").val();
	Modal.confirm({
	    msg: "确认添加【"+ysmc+"】？"
	  }).on( function (e) {
		    if(e){//执行添加
		    	$.post("/oasm/yzk/addTysk",{ysbh:ysId,ysmc:ysmc,sm:yssm,ytxz:ysyt,yssx:ystz}).done(
		    		function(result){
		    			sucYsck(result,ysmc);//调用添加完成提示框
		    		});
		    }
	  });
}

//分页
var pageNum=1;
var pageSize = 15;
var total = 1;//总记录数
var pages = 1;//总页数
var psize=10;//每页的数量
var clazz="";
var find="";//搜索内容

$(function(){
	$("#firstPage").click(function(){ 
		$("#prePage").addClass("ban");
	    $("#firstPage").addClass("ban"); 
		if(pageNum==1){
		}else{
	        goPage(1,psize,clazz); 
	        $("#nextPage").removeClass("ban");
	    	$("#lastPage").removeClass("ban");
		}
    });
    
    $("#lastPage").click(function(){
//		console.info("lastPage "+pageNum+"----"+pages)
        if(pageNum==pages){
        }else{
        	goPage(pages,psize,clazz); 
        	$("#nextPage").addClass("ban");    
    	    $("#lastPage").addClass("ban");
    	    $("#firstPage").removeClass("ban");    
    	    $("#prePage").removeClass("ban");
        }
    });
    
    $("#prePage").click(function(){  
    	if(pageNum>1){
    		if(pageNum-1 == 1){
    	    	$("#firstPage").addClass("ban");    
        	    $("#prePage").addClass("ban");
    	    }
	        goPage(pageNum-1,psize,clazz);    
	    	$("#nextPage").removeClass("ban");
	    	$("#lastPage").removeClass("ban");
    	}else{
    		$("#firstPage").addClass("ban");    
    	    $("#prePage").addClass("ban");
    	}
    });
    $("#nextPage").click(function(){
//     	console.info("pageNum "+pageNum+" nextPage "+pages+" psize "+psize);
    	if(pageNum<pages){
    		if(pageNum+1 == 10){
    	    	$("#nextPage").addClass("ban");    
        	    $("#lastPage").addClass("ban");
    	    }
	    	goPage(pageNum+1,psize,clazz); 
	    	$("#firstPage").removeClass("ban");    
    	    $("#prePage").removeClass("ban");
    	    
    	}else{
    		$("#nextPage").addClass("ban");    
    	    $("#lastPage").addClass("ban");
    	}
    });
});

//显示元素列表
function querySearch(ysbh,ysmc,yssx,ytxz,yzzpc,zsxgpc,ttxgpc,xxxgpc,zfzxgpc,cjsj1,cjsj2,xgsj1,xgsj2){
	$.post("/oasm/yzk/likeTyskLine",{pageSize:pageSize,pageNum:pageNum,ysbh:ysbh,ysmc:ysmc,yssx:yssx,ytxz:ytxz,yzzpc:yzzpc,zsxgpc:zsxgpc,ttxgpc:ttxgpc,xxxgpc:xxxgpc,zfzxgpc:zfzxgpc,cjsj1:cjsj1,cjsj2:cjsj2,xgsj1:xgsj1,xgsj2:xgsj2})
	.done(function(msg){
	    if(!isNull(msg)){
	    	var data = JSON.parse(msg);
	    	 var td = "";
	    	$.each(data.page.result,function(r,t){
	    		count = (pageNum-1)*pageSize+1+r;
	    		if(t.ytxz==2||t.ytxz==3){
	    			td+="<tr>";
	    			td+="<td>"+count+"</td>";
	    			td+="<td>"+t.ysbh+"</td>";
	    			td+="<td>"+t.ysmc+"</td>";
	    			td+="<td>"+t.yssx+"</td>";
	    			if(t.ytxz==2){
	    				td+="<td>作为维度</td>";
	    			}else if(t.ytxz==3){
	    				td+="<td>作为维度或因子</td>";
	    			}
	    			td+="<td>无</td>";
	    			td+="<td>无</td>";
	    			td+="<td>无</td>";
	    			td+="<td>无</td>";
	    			td+="<td>无</td>";
	    			td+="<td>"+toDateStr(t.cjsj)+"</td>";
	    			td+="<td>"+t.cjrbh+"</td>";
	    			td+="<td>"+toDateStr(t.xgsj)+"</td>";
	    			td+="<td>"+t.xgrbh+"</td>";
	    			td+="<td onclick ='updateYSK(\""+t.ysid+"\",\""+t.ysbh+"\",\""+t.ysmc+"\",\""+t.yssx+"\",\""+t.ytxz+"\")'><span class='glyphicon glyphicon-pencil'></span></td>";
	    			td+="</tr>";
	    		}else if(t.ytxz==1||t.ytxz==3){
	    			td+="<tr>";
	    			td+="<td>"+count+"</td>";
	    			td+="<td>"+t.ysbh+"</td>";
	    			td+="<td>"+t.ysmc+"</td>";
	    			td+="<td>"+t.yssx+"</td>";
	    			if(t.ytxz==1){
	    				td+="<td>作为因子</td>";
	    			}else if(t.ytxz==3){
	    				td+="<td>作为维度或因子</td>";
	    			}
	    			td+="<td>"+t.yzzpc+"</td>";
	    			td+="<td>"+t.zsxgpc+"</td>";
	    			td+="<td>"+t.xxxgpc+"</td>";
	    			td+="<td>"+t.ttxgpc+"</td>";
	    			td+="<td>"+t.zfzxgpc+"</td>";
	    			td+="<td>"+toDateStr(t.cjsj)+"</td>";
	    			td+="<td>"+t.cjrbh+"</td>";
	    			td+="<td>"+toDateStr(t.xgsj)+"</td>";
	    			td+="<td>"+t.xgrbh+"</td>";
	    			td+="<td onclick ='updateYSK(\""+t.ysid+"\",\""+t.ysbh+"\",\""+t.ysmc+"\",\""+t.yssx+"\",\""+t.ytxz+"\")'><span class='glyphicon glyphicon-pencil'></span></td>";
	    			td+="</tr>";
	    		}
	    	});
	    	$("#tyskTableData").html(td);
	    	pageSize = data.page.pageSize;
			pages = data.page.pages;
			total = data.page.total;
			$("#pageSize").html(pageSize);
		 	$("#pages").html(pages);
	    }
	});
}
function goPage(pageNum1,psize1,clazz1){
	psize=psize1;
	pageNum=pageNum1;
	clazz=clazz1;
	$("#pageNum").html(pageNum);
	
	if(clazz=="tyskPage"){
		var ysbh = $("#ysbhQuery").val();
		var ysmc = $("#ysmcQuery").val();
		var yssx = $("#yssxQuery").val();
		var ytxz = $("#ytxzQuery").val();
		var yzzpc = $("#yzzpcQuery").val();
		var zsxgpc = $("#zsxgpcQuery").val();
		var ttxgpc = $("#ttxgpcQuery").val();
		var xxxgpc = $("#xxxgpcQuery").val();
		var zfzxgpc = $("#zfzxgpcQuery").val();
		var cjsj1 = $("#cjsj1Query").val();
		var cjsj2 = $("#cjsj2Query").val();
		var xgsj1 = $("#xgsj1Query").val();
		var xgsj2 = $("#xgsj2Query").val();
		querySearch(ysbh,ysmc,yssx,ytxz,yzzpc,zsxgpc,ttxgpc,xxxgpc,zfzxgpc,cjsj1,cjsj2,xgsj1,xgsj2);
	}
	
	//记录数据
	var tempStr = "共"+total+"条记录 当前"+pageNum+"/"+pages+"页";    
    document.getElementById("barcon1").innerHTML = tempStr;    
//    console.info(tempStr);
    
    //下拉
    var tempOption="";    
    for(var i=1;i<=pages;i++)    
    {    
        tempOption+='<option value='+i+'>'+i+'</option>'    
    }    
    $("#jumpWhere").html(tempOption);    
    $("#jumpWhere").val(pageNum);  
}

//跳转
function jumpPage()    
{    
 var num=parseInt($("#jumpWhere").val());    
 if(num!=pageNum)    
 {    
     goPage(num,pageSize,clazz);    
 }    
}
//页面分页调用
$(function(){
	goPage(1,15,"tyskPage"); 
});

//搜索器
function queryBtn(){
 goPage(1,psize,"tyskPage"); 
}

/********************************修改************************************************/
function confirUpdate(i){
	$("#closeUpdateYSK").click();
	if(1==i){
		Modal.alert({
			 msg: '修改成功',
			    title: '提示',
			    btnok: '确定'
		  }).on( function (e) {
			  showPage("/oasm/yzk/yzManager");
		  });
	}else{
		Modal.alert({
			 msg: '修改失败',
			    title: '异常提示',
			    btnok: '确定'
		  }).on( function (e) {
			  showPage("/oasm/yzk/yzManager");
		  });
	}
}
//赋值给遮幕栏
function updateYSK(ysId,ysbh,ysmc,yssx,ytxz){
	$("#ysidUpdate").val(ysId);
	$("#ysbhUpdate").val(ysbh);
	$("#ysmcUpdate").val(ysmc);
	$("#yssxUpdate").val(yssx);
	$("#ytxzUpdate").val(ytxz);
	$("#cfzlk").click();
};
//确认修改
function saveUpdateYSK(){
	var ysid = $("#ysidUpdate").val();
	var ysbh = $("#ysbhUpdate").val();
	var ysmc = $("#ysmcUpdate").val();
	var yssx = $("#yssxUpdate").val();
	var ytxz = $("#ytxzUpdate").val();
	Modal.confirm({
	    msg: "确认修改元素为【"+ysmc+"】？"
	  }).on( function (e) {
		    if(e){//执行添加
		    $.post("/oasm/yzk/updateYsk",{ysid:ysid,ysbh:ysbh,ysmc:ysmc,yssx:yssx,ytxz:ytxz}).done(
		  	  function(i){
		  		confirUpdate(i);
		  	  }		
		  	)
		    }
	  });
}