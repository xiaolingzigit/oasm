//格式化时间方法
function timeStamp2String(time){  
    var datetime = new Date();  
    datetime.setTime(time);  
    var year = datetime.getFullYear();  
    var month = datetime.getMonth() + 1 < 10 ? "0" + (datetime.getMonth() + 1) : datetime.getMonth() + 1;  
    var date = datetime.getDate() < 10 ? "0" + datetime.getDate() : datetime.getDate();  
    var hour = datetime.getHours()< 10 ? "0" + datetime.getHours() : datetime.getHours();  
    var minute = datetime.getMinutes()< 10 ? "0" + datetime.getMinutes() : datetime.getMinutes();  
    var second = datetime.getSeconds()< 10 ? "0" + datetime.getSeconds() : datetime.getSeconds();  
    return year + "-" + month + "-" + date+" "+hour+":"+minute+":"+second;
}  
//****************************显示配置部分*********************************************
$(function(){
	$.ajax({
		url:"/oasm/tdminAndtyz/scaleConfList",
		dataType:"JSON",
		type:"post",
		success:function(data){
			var a = "";
			var b = "";
			$.each(data,function(k,v){
				a+="<tr>";
				a+="<td>"+(k+1)+"</td>";
				a+="<td>"+v.name+"</td>";
				var confJSON = JSON.parse(v.conf);
				$.each(confJSON,function(m,n){
				 a+="<td>"+n.rjftName+"</td>";
				 a+="<td>"+n.rjgcName+"</td>";
				 a+="<td>"+n.rcgcName+"</td>";
				 a+="<td>"+n.zqftName+"</td>";
				 a+="<td>"+n.zqgcName+"</td>";
				 a+="<td>"+n.cjftName+"</td>";
				 a+="<td>"+n.cjgcName+"</td>";
				 
				});
				a+="<td>"+timeStamp2String(v.crTime)+"</td>";
				a+="<td>"+v.creator+"</td>";
				if(v.status==1){
					
					a+="<td>暂未生效</td>";
				}else if(v.status==2){
					b+="<option value='"+v.id+"'>"+v.name+"</option>"; //要显示已经启用的
					a+="<td>已经生效</td>";
				}else if(v.status==3){
					a+="<td>已弃用</td>";
				}
			});
			$("#scale_conf_list").html(a);
			$("#currentScale").html(b);
		}
	});
});
//****************************添加配置部分**************************************
//验证配置名称
function check_confName(){
	var conf_count=0;
	var name = $("input[name='confName']").val(); //获取匹配的名字
	if(name!=null&&name!=""){
		$.ajax({
			url:"/oasm/tdminAndtyz/checkConfName",
			dataType:"JSON",
			type:"post",
			async:false,
			data:{name:name},
			success:function(i){
				console.info(i);
				if(i==1){
					 document.getElementById("input_settingName").innerHTML="< div class='input_judge j_w'>配置名已经存在</div>";
					//alert("配置名已经存在");
					return conf_count;
				}else{
					document.getElementById("input_settingName").innerHTML="<div class='input_judge j_r'>该配置名可用</div>";
					return conf_count=1;
				}
			}
		});
	}else{
		document.getElementById("input_settingName").innerHTML="<div class='input_judge j_w'>请输入配置名</div>";
		return conf_count=2;
	}
	return conf_count;
}

$(function(){
	$.ajax({
		url:"/oasm/tdminAndtyz/scaleAllList",
		dataType:"JSON",
		type:"post",
		success:function(data){
			var a = "";
			var b = "";
			var c = "";
			var d = "";
			var e = "";
			var f = "";
			var g = "";
		  $.each(data,function(k,v){
			  switch (v.type) {
			case "AA":
				a+="<option value='"+v.scaleId+"'>"+v.name+"</option>";
				break;
            case "AB":
				b+="<option value='"+v.scaleId+"'>"+v.name+"</option>";
				break;
            case "BA":
	            c+="<option value='"+v.scaleId+"'>"+v.name+"</option>";
	            break;
           case "CA":
	            d+="<option value='"+v.scaleId+"'>"+v.name+"</option>";
	          break;
           case "CB":
	            e+="<option value='"+v.scaleId+"'>"+v.name+"</option>";
	         break;
           case "DA":
	            f+="<option value='"+v.scaleId+"'>"+v.name+"</option>";
	         break;
           case "DB":
	            g+="<option value='"+v.scaleId+"'>"+v.name+"</option>";
	         break;
			default:
				break;
			}
		  });
		  
		  $("#rjft_scale_list").append(a);
		  $("#rjgc_scale_list").append(b);
		  $("#rcgc_scale_list").append(c);
		  $("#zqft_scale_list").append(d);
		  $("#zqgc_scale_list").append(e);
		  $("#cjft_scale_list").append(f);
		  $("#cjgc_scale_list").append(g);
		  
		}
	});
});

//添加量表配置
function save_scale_conf(){
	var name = $("input[name='confName']").val(); //获取匹配的名字
	var remark = $("#conf_remark_add").val(); //获取配置名字
	var status = $("input[name='status']:checked").val(); //获取配置生效状态
	
	
	var scale_AA = $("#rjft_scale_list").find("option:selected").val(); //获取量表编号
	var scaleName_AA = $("#rjft_scale_list").find("option:selected").text(); //获取量表名字
	
	var scale_AB = $("#rjgc_scale_list").find("option:selected").val();
	var scaleName_AB = $("#rjgc_scale_list").find("option:selected").text();
	
	var scale_BA = $("#rcgc_scale_list").find("option:selected").val();
	var scaleName_BA = $("#rcgc_scale_list").find("option:selected").text();
	
	var scale_CA = $("#zqft_scale_list").find("option:selected").val();
	var scaleName_CA = $("#zqft_scale_list").find("option:selected").text();
	
	var scale_CB = $("#zqgc_scale_list").find("option:selected").val();
	var scaleName_CB = $("#zqgc_scale_list").find("option:selected").text();
	
    var scale_DA = $("#cjft_scale_list").find("option:selected").val();
    var scaleName_DA = $("#cjft_scale_list").find("option:selected").text();
    
    var scale_DB = $("#cjgc_scale_list").find("option:selected").val();
    var scaleName_DB = $("#cjgc_scale_list").find("option:selected").text();
    
    var conf = scale_AA+"#"+scaleName_AA+"#"+scale_AB+"#"+scaleName_AB+"#"+scale_BA+"#"+scaleName_BA+"#"+scale_CA+"#"
      +scaleName_CA+"#"+scale_CB+"#"+scaleName_CB+"#"+scale_DA+"#"+scaleName_DA+"#"+scale_DB+"#"+scaleName_DB; //配置内容
    console.info(scaleName_AA);
    
	var checksuc = check_confName(); //判断配置名是否已经通过验证
	if(checksuc>0){
	if(checksuc==1){
		$.ajax({
			url:"/oasm/tdminAndtyz/addScaleConf",
			dataType:"JSON",
			type:"post",
			data:{name:name,remark:remark,conf:conf,status:status},
			success:function(i){
				if(i==1){
					document.getElementById("input_settingName").innerHTML="<div class='input_judge j_r'>该配置名可用</div>";

					alert("添加配置成功");
				}else{
					alert("添加配置失败，请确认管理员账号是否登录!");
				}
			}
		});
	}else{
		document.getElementById("input_settingName").innerHTML="<div class='input_judge j_w'>请输入配置名</div>";
	}
	}else{
		document.getElementById("input_settingName").innerHTML="<div class='input_judge j_w'>该配置名已存在</div>";
		//alert("配置名已经存在，请重试...");
	}
}

//保存量表配置到全局变量
function save_conf_currScale(){
	//save_crruent_toConf
	var confId = $("#currentScale").val();
	//globalId
	var globalId = $("input[name='globalId']:checked").val();
	var name = $("#currentScale").find("option:selected").text();
	Modal.confirm({
			    msg: "是否保存【"+name+"】配置？"
			  }).on( function (e) {
			    if(e==true){
			    	$.ajax({
			    		url:"/oasm/tdminAndtyz/save_crruent_toConf",
			    		dataType:"JSON",
			    		type:"post",
			    		data:{confId:confId,globalId:globalId},
			    		success:function(i){
			    			if(i==1){
			    				alertSave();
			    			}else{
			    				alertSaveError();
			    			}
			    		}
			    	});
			    }
	    });
}



//封装的alert
function alertDelete(){  //删除成功
	
	Modal.alert(
			  {
			    msg: '关闭或开启成功',
			    title: '信息',
			    btnok: '确定'
	});
}
function alertSaveError(){  //保存失败
	Modal.alert(
			  {
			    msg: '保存失败，请确认管理员登录状态',
			    title: '信息',
			    btnok: '确定'
	});
}

function alertSave(){ //保存成功
	Modal.alert(
			  {
			    msg: '保存成功',
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