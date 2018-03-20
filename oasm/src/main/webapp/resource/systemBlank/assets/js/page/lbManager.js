function update_start(lbbh){
	Modal.confirm(
			  {
			    msg: "是否启用"+lbbh+"？"
			  })
			  .on( function (e) {
			    if(e==true){
			    	//点击确定之后继续执行
			    	$.ajax({
			    		url:"/oasm/lbk/closeOrstartLBKM",
			    		type:"post",
			    		dataType:"JSON",
			    		data:{lbbh:lbbh},
			    		success:function(i){
			    		  if(i==1){
			    			  //执行封装的alert
//			    			  alertDelete();
//			    			  window.navigate("/oasm/lbk/lbkManager"); 
			    			  $(document.body).load("");
			    		  }else{
			    			  alertDeleteError(); 
			    		  }
			    		}
			    	});
			    }else{
			    	//点击取消返回
			    	return false;
			    }
				  
		});
}

//封装的alert
function sucDel(){
	Modal.alert(
			  {
			    msg: '删除成功',
			    title: '信息',
			    btnok: '确定'
	});
}

function faiDel(){
	Modal.alert(
			  {
			    msg: '删除失败',
			    title: '信息',
			    btnok: '确定'
	});
}

function alertDelete(){  //删除成功
	
	Modal.alert(
			  {
			    msg: '关闭或开启成功',
			    title: '信息',
			    btnok: '确定'
	});
}
function alertDeleteError(){  //删除失败
	Modal.alert(
			  {
			    msg: '关闭或开启失败',
			    title: '信息',
			    btnok: '确定'
	});
}

function alertUpdate(){ //修改成功
	Modal.alert(
			  {
			    msg: '修改成功',
			    title: '信息',
			    btnok: '确定'
	});
}


//封装的提示
$(function () {
	  window.Modal = function () {
	    var reg = new RegExp("\\[([^\\[\\]]*?)\\]", 'igm');
	    var alr = $("#ycf-alert");
	    var ahtml = alr.html();

	    //关闭时恢复 modal html 原样，供下次调用时 replace 用
	    //var _init = function () {
	    //    alr.on("hidden.bs.modal", function (e) {
	    //        $(this).html(ahtml);
	    //    });
	    //}();

	    /* html 复原不在 _init() 里面做了，重复调用时会有问题，直接在 _alert/_confirm 里面做 */


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

//验证量表的名字
function check_scale_name(){
	var scaleName_info = 0;
	var name = $("#scale_grow_name").val();
	if(name!=null&&name!=""){
		$.ajax({
		   url:"/oasm/tdminAndtyz/checkScaleName",
		   dataType:"JSON",
		   type:"post",
		   async:false,
		   data:{name:name},
		   success:function(i){
			   if(i==1){
				   document.getElementById("input_lbName").innerHTML="<div class='input_judge j_w'>量表名字已经存在</div>";
				  
				   //alert("量表名已经存在");
				   return scaleName_info;
			   }else{
				   document.getElementById("input_lbName").innerHTML="<div class='input_judge j_r'>量表名字可用</div>";
				   return scaleName_info=1;
			   }
		   }
		});
		
	}else{
		 document.getElementById("input_lbName").innerHTML="<div class='input_judge j_w'>请输入量表名字</div>";
		return scaleName_info=2;
	}
	return scaleName_info;
   	
}


//把选择框的值赋值给动态加载问题的选项
$(function(){
	dync_question($("#all_org_question").val()); //初始化赋值
	$("#all_org_question").change(function(){
		dync_question($("#all_org_question").val()); //选中后赋值

	});
	
});

//动态加载问题选项
function dync_question(orgId){
	$.ajax({
		url:"/oasm/tdminAndtyz/orgAllQuestion",
		type:"post",
		dataType:"JSON",
		data:{orgId:orgId},
		success:function(data){
			var queJSON = JSON.parse(data); //把后台String类型的数据获取
			var que = "";
			var opt = "";
			var zwf = "@";
			$.each(queJSON,function(k,v){
				que+="<div name='quest_choose' class='panel panel-default'>";
				que+="<div class='panel-heading'>";
				que+="<h4 class='panel-title'>";
				que+="<a title='请先设置因子分权重!'><input type='checkbox' onclick='add_quest_checkbox(this)' class='qcheckbox' disabled='disabled' value='"+v.qId+"' /></a>";
				que+="<a data-toggle='collapse' class='qcontent' href='#A"+v.qId+"'>问题:<span>"+v.qName+"</span><span style='display:none'>"+v.qRemark+"</span><span style='display:none;'>"+v.dimId+"</span> &nbsp;&nbsp维度:<span>"+v.dimName+"</span><span style='display:none'>"+v.type+"</span></a><strong style='float:right;' title='删除问题' onclick='trashQuestion("+v.qId+")' class='glyphicon glyphicon-trash'></strong>";
				que+="</h4></div>";
				que+="<div id='A"+v.qId+"' class='panel-collapse collapse'>";
				que+="<div class='panel-body'>";
				que+="<div  class='table-responsive'>";
				que+="<table style='margin-left: 50px;width: 88%' class='table table-bordered'>";
				que+="<thead><tr>";
				que+="<th>选项号</th><th>选项内容</th><th>因子名称</th><th>因子分权重</th>";
				que+="</tr></thead>";
				que+="<tbody>";
				//再执行循环把所有因子遍历出来
				$.each(v.options,function(a,b){
					que+="<tr>";
					que+="<td>"+b.opNo+"</td><td>"+b.optionContext+"</td><td>"+b.factorName+"</td><td><input type='text' name='que_eva' placeholder='请为因子设置权重'/></td><td style='display:none;'>"+b.factorId+"</td>";
					que+="</tr>";
				});
				que+="</tbody></table>";
				que+="</div></div></div></div>";
				
			});
			$("#accordion").html(que);
			setting_control();
			
		}
	});
}	
var rk_scale = ""; //入库使用
//多选框的手风琴效果
function add_quest_checkbox(a){
	$(a).parent().next("a").click();
	var d = ""; //拼接表格使用
	
	if($(a).is(":checked")){
		var qstId = $(a).attr("value"); //问题编号
		var queName = $(a).parent().next("a").children("span").eq(0).html(); //问题
		var queRemark = $(a).parent().next("a").children("span").eq(1).html(); //判断依据
		var queDimId = $(a).parent().next("a").children("span").eq(2).html(); //维度编号
		var queDim = $(a).parent().next("a").children("span").eq(3).html(); //维度
		var queType = $(a).parent().next("a").children("span").eq(4).html(); //单选多选类型
		var scale_A = qstId+"#"+queName+"#"+queRemark+"#"+queDimId+"#"+queDim+"#"+queType+"@@"; //拼接前一部分
		var scale_B="";
		//拼接表格实现预览功能  
	       //d+="<table class='table table-bordered'>";
          // d+="<thead><tr>";
           //d+=" <th>问题编号</th><th>问题名称</th><th>维度</th><th>选项号</th><th>选项内容</th><th>因子名称</th><th>权重</th>";
          // d+="</tr></thead>";
           var yzcount=$("#A"+qstId).find("tbody tr").length;
           $("#A"+qstId).find("tbody tr").each(function(){	
        	var index = $("#A"+qstId).find("tbody tr").index(this);       
			var tdArr = $(this).children();
	        var qe1 = tdArr.eq(0).html();//选项号
	        var qe2 = tdArr.eq(1).html();//选项内容
	        var qe3 = tdArr.eq(2).html();//    因子名称
	        var qe4 = tdArr.eq(3).find("input").val();			//因子分权重
	        var qe5 = tdArr.eq(4).html(); //因子编号
	        scale_B+=qe1+"#"+qe2+"#"+qe3+"#"+qe4+"#"+qe5+"%%";
	        if(index==0){
	        //d+="<tbody><tr>";
	        d+="<tr>";
	        d+="<td rowspan='"+yzcount+"'>"+qstId+"</td><td rowspan='"+yzcount+"'>"+queName+"</td><td rowspan='"+yzcount+"'>"+queDim+"</td>";
	        d+="<td>"+qe1+"</td><td>"+qe2+"</td><td>"+qe3+"</td><td>"+qe4+"</td>";
	        d+="</tr>";
	        //d+="</tr></tbody>";
	        }else{
	        	d+="<tr>";
		       	d+="<td>"+qe1+"</td><td>"+qe2+"</td><td>"+qe3+"</td><td>"+qe4+"</td>";
		        d+="</tr>";
	        }
		});
		 //d+="</table>";
        //$("#lb_browder tbody").replace(d,"");
		$("#lb_browder tbody").append(d); //把数据放到预览框中
//		$("#lb_browder span").html(n);
//		console.info(scale_A+scale_B);
		rk_scale+= scale_A+scale_B+"QQQ"; //量表内容拼成字符串返回后台
	}else{
		var qstId = $(a).attr("value"); //问题编号
		var queName = $(a).parent().next("a").children("span").eq(0).html();
		var yzcount=$("#A"+qstId).find("tbody tr").length;
		$("#lb_browder tbody").find("tr").each(function(){
			console.info($(this).find("td").eq(1).html());
			if($(this).find("td").eq(1).html()==queName){	
				console.info(yzcount);
				for(var i=0;i<yzcount-1;i++){
				$(this).next().remove();
			}
				$(this).remove();
				}
		});
		console.info("null");
	}
	
}
//设置分子权重,使问题可选
function setting_control(){
	$("input[name='que_eva']").keyup(function(){ 
		$(this).val($(this).val().replace(/[^(-?\\d+)(\\.\\d+)?$]/g,''));  
		$(this).val($(this).val().replace(/^\./g,''));
		$(this).val($(this).val().replace(/\.{2,}/g,'.')); 
		$(this).val($(this).val().replace('.','$#$').replace(/\./g,'').replace('$#$','.')); 
		$(this).val($(this).val().replace(/\-{2,}/g,'-')); 
		$(this).val($(this).val().replace('-','$#$').replace(/\-/g,'').replace('$#$','-')); 
		}).bind("paste",function(){ 
			$(this).val($(this).val().replace(/[^(-?\\d+)(\\.\\d+)?$]/g,''));  
			$(this).val($(this).val().replace(/^\./g,''));
			$(this).val($(this).val().replace(/\.{2,}/g,'.')); 
			$(this).val($(this).val().replace('.','$#$').replace(/\./g,'').replace('$#$','.')); 
			$(this).val($(this).val().replace(/\-{2,}/g,'-')); 
			$(this).val($(this).val().replace('-','$#$').replace(/\-/g,'').replace('$#$','-')); 
			}); 
$("input[name='que_eva']").bind('input propertychange', function(){	
		var input_val=0;	
		console.info($(this).val());
		$(this).parents("div[name='quest_choose']").find("input[name='que_eva']").each(
		function(){
			console.info($(this).val());
		if($(this).val()!=null&&$(this).val()!=""){
			 return input_val+=0;
		}else{
			 return input_val+=1;
		}
		});
		if (input_val==0){
			$(this).parents("div[name='quest_choose']").find("a").eq(0).attr("title","该问题可选");
			$(this).parents("div[name='quest_choose']").find("input").eq(0).removeAttr("disabled");
			//alert($(this).parents("div[name='quest_choose']").find("input").eq(0).attr("disabled"));
		}else{
			$(this).parents("div[name='quest_choose']").find("a").eq(0).attr("title","请先设置因子分权重!");
			$(this).parents("div[name='quest_choose']").find("input").eq(0).attr("disabled","disabled");
		}
	});
}
//量表预览效果
$(function(){
	$("#ylxg_lb").click(function(){
		$("#ylxg_lb").attr("href","#modal-container-768471");
	});
})
//生成量表
function btn_grow_scale(){
	 if(confirm("确认生成量表？"))
	 {
  var namecount = check_scale_name();
  var name=$("#scale_grow_name").val(); //量表名称
  var type=$("input[name='type']:checked").val(); //量表类型
  var researher = $("input[name='researher']").val(); //研制者
  var remark = $("#scale_remark_add").val(); //量表说明
//  var orgId = $("#all_org_question").val();
  var scale = rk_scale; //量表内容
  
  if(namecount>0){
	  if(namecount==1){
	  $.ajax({
		 url:"/oasm/tdminAndtyz/addTscale",
		 type:"post",
		 dataType:"JSON",
		 data:{name:name,type:type,researher:researher,remark:remark,scale:scale},
		 success:function(i){
			 if(i==1){
				 document.getElementById("input_lbName").innerHTML="<div class='input_judge j_r'>量表名字可用</div>";
				 alert("添加量表成功");
			 }else{
				 alert("添加量表失败，请确认管理员账号是否登录");
			 }
		 }
	  });
	  
  }else{
	  document.getElementById("input_lbName").innerHTML="<div class='input_judge j_w'>请输入量表名字</div>";
  }
	  }else{
	  document.getElementById("input_lbName").innerHTML="<div class='input_judge j_w'>量表名字已经存在</div>";
	 // alert("量表名字已经存在");
  }
}
}


//删除问题
function trashQuestion(qId){
	Modal.confirm(
			  {
			    msg: "是否删除编号"+qId+"的问题选项？"
			  })
			  .on( function (e) {
			    if(e==true){//按了确定
                   	$.ajax({
                   		url:"/oasm/tdminAndtyz/removeQuestion",
                   		type:"post",
                   		dataType:"JSON",
                   		data:{qId:qId},
                   		success:function(i){
                   			if(i==1){
                   				sucDel();
                   				dync_question("");
                   			}else{
                   				faiDel();
                   			}
                   		}
                   	});		    	
			    }
			  });
}

//查看量表详情
function lookupScale(scaleId){
	$(".lookupRelat").attr("href","#modal-container-768471");
	$.ajax({
		url:"/oasm/lbk/lookupScale",
		type:"post",
		dataType:"JSON",
		data:{scaleId:scaleId},
		success:function(data){
			var d = "";
			var dataJSON = JSON.parse(data);
			$.each(dataJSON,function(k,v){
				d+="<tr>"
				d+="<td rowspan="+v.options.length+">"+v.qId+"</td>";
				d+="<td rowspan="+v.options.length+">"+v.qName+"</td>";
				d+="<td rowspan="+v.options.length+">"+v.dimName+"</td>";
				$.each(v.options,function(m,n){
                 if(m==0){
					d+="<td>"+n.opNo+"</td>";
					d+="<td>"+n.optionContext+"</td>";
					d+="<td>"+n.factorName+"</td>";
					d+="<td>"+n.qz+"</td>";
					d+="</tr>";
					}else{
						d+="<tr>";
						d+="<td>"+n.opNo+"</td>";
						d+="<td>"+n.optionContext+"</td>";
						d+="<td>"+n.factorName+"</td>";
						d+="<td>"+n.qz+"</td>";
						d+="</tr>";
					}
				});
			    
			});
			$("#lb_browder table tbody").html(d);
			
		}
	});
	
}