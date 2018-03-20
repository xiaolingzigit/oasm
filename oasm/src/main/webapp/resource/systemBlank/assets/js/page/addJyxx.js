/***
 * @author quite
 */
$.ajaxSetup({
	cache: false //关闭AJAX相应的缓存
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

//查出所有的角色
$(function(){
	$.ajax({
	url:"/oasm/jyxx/selectAllZRole",
	type:"post",
	dataType:"JSON",
	success:function(data){
		var s="";
		$.each(data,function(k,v){
			s+="<option value='"+v.id+"'>"+v.zrname+"</option>";
		});
	$("#zrid").append(s); //添加警员信息使用
	$("#role_zw_add").append(s);  //添加职务使用
	$("#update_zrid").append(s); //修改警员信息使用
	},
	error: function(XMLHttpRequest, textStatus, errorThrown) {
		 alert(XMLHttpRequest.status);
		 alert(XMLHttpRequest.readyState);
		 alert(textStatus);
	}
});
});
//根据角色级联职务
$(function(){
	$("#zrid").change(function(){
		var id=$("#zrid").val();
		$.ajax({
			url:"/oasm/jyxx/selectAllGroupMan",
			type:"post",
			dataType:"JSON",
			data:{id:id},
			success:function(data){
				var a="";
				$.each(data,function(k,v){
					a+="<option value='"+v.groupMan.id+"'>"+v.groupMan.gmname+"</option>";
				});
				$("#zw_select").html(a); //添加警员使用
			},
			error: function(XMLHttpRequest, textStatus, errorThrown) {
				 alert(XMLHttpRequest.status);
				 alert(XMLHttpRequest.readyState);
				 alert(textStatus);
			}
		});
	});
});

//修改警员时使用角色查询职务
$(function(){
	$("#update_zrid").change(function(){
		var id=$("#update_zrid").val();
		$.ajax({
			url:"/oasm/jyxx/selectAllGroupMan",
			type:"post",
			dataType:"JSON",
			data:{id:id},
			success:function(data){
				var a="";
				$.each(data,function(k,v){
					a+="<option value='"+v.groupMan.id+"'>"+v.groupMan.gmname+"</option>";
				});
				$("#zw_select_update").html(a); //修改警员使用
			},
			error: function(XMLHttpRequest, textStatus, errorThrown) {
				 alert(XMLHttpRequest.status);
				 alert(XMLHttpRequest.readyState);
				 alert(textStatus);
			}
		});
	});
});

//jyxx_zw_add添加职务信息
$(function(){
	$("#jyxx_zw_add").click(function(){
		var zrid=$("#role_zw_add").val();
		var gmname=$("input[name='zwname']").val();
		alert(gmname);
		if(zrid!=null&&gmname!=null&&gmname!=""){
			$.ajax({
				url:"/oasm/jyxx/addGroupMan",
				dataType:"JSON",
				type:"post",
				data:{zrid:zrid,gmname:gmname},
				success:function(i){
					if(i==1){
						$("input[name='zwname']").val("");
					}else{
						alert("失败");
					}
				},
				error: function(XMLHttpRequest, textStatus, errorThrown) {
					 alert(XMLHttpRequest.status);
					 alert(XMLHttpRequest.readyState);
					 alert(textStatus);
				}
			});
		}else{
		 $("#role_zw_required").replaceWith("<span style='color:red'>角色和职务不为空</span>");
		}
	});
});

//添加警员信息
$(function(){
	$("#jyxx_info_add").click(function(){
		var zw=$("#zw_select").val(); //职务
		var jq=$("#add_jq_div input[name='jq']").val();
		var xjq=$("#add_xjq_div input[name='xjq']").val();
		var jh=$("#add_jh_div input[name='jh']").val();
		var xm=$("#add_xm_div input[name='xm']").val();
		var ma=$("#add_ma_div input[name='ma']").val();
		
        var uJh = /^[0-9]{7}$/;  //匹配7位数警号
		
		var uPassword = /^(\w){3,20}$/;  //匹配密码。英文、数字、下划线
		/***
		 * "zw_select_null"
		 * jq_add_null
		 * xjq_add_null
		 * jh_add_check
		 * ma_add_check
		 */
		//后续优化
		if(zw==null||zw==""){
			$("#zw_select_null").replaceWith("<span style='color:red'>请选择职务</span>");
		}else if(uJh.test(jh)==false){
			$("#jh_add_check").replaceWith("<span style='color:red'>警号格式不正确</span>");
		}else if(xm==null||xm==""){
			$("#xm_add_check").replaceWith("<span style='color:red'>姓名不为空</span>");
		}else if(uPassword.test(ma)==false){
			$("#ma_add_check").replaceWith("<span style='color:red'>密码由3-20个英文、数字、下划线组成</span>");
		}else{
			$.ajax({
				url:"/oasm/jyxx/addJyxx",
				dataType:"JSON",
				type:"post",
				data:{zw:zw,jq:jq,xjq:xjq,jh:jh,xm:xm,ma:ma},
				success:function(i){
				   if(i==1){
						$("#zw_select").val(""); //职务
						$("#add_jq_div input[name='jq']").val("");
						$("#add_xjq_div input[name='xjq']").val("");
						$("#add_jh_div input[name='jh']").val("");
						$("#add_xm_div input[name='xm']").val("");
						$("#add_ma_div input[name='ma']").val("");
				   }else{
					   alert("添加失败");
				   }
				}
			});
		}
	});
});

//修改警员信息把所有值赋值给他
function jy_update_modal(jh,xm,jq,xjq){
	$("#update_jq_data").val(jq);
	$("#update_xjq_data").val(xjq);
	$("#update_jh_data").val(jh);
	$("#update_xm_data").val(xm);
	$("#jcxx_list tr td a").attr("href","#modal-container-819013");
}
//遮幕栏里面的修改框
$(function(){
	$("#jyxx_update_btn").click(function(){
		var zw = $("#zw_select_update").val();
		var jq = $("#update_jq_data").val();
		var xjq = $("#update_xjq_data").val();
		var jh = $("#update_jh_data").val();
		var xm = $("#update_xm_data").val();
		
		//后续优化
		if(zw==null||zw==""){
			$("#zw_select_update_null").replaceWith("<span style='color:red'>请选择职务</span>");
		}else if(xm==null||xm==""){
			$("#xm_update_null").replaceWith("<span style='color:red'>姓名不为空</span>");
		}else{
			$("#jyxx_close_btn").click();
			Modal.confirm({
			    msg: "确认修改【警号"+jh+"】的警察?"
			  }).on( function (e) {
				    if(e){//执行修改
				    	$.ajax({
							url:"/oasm/jyxx/adminUpdateJyxx",
							dataType:"JSON",
							type:"post",
							data:{jh:jh,xm:xm,jq:jq,xjq:xjq,zw:zw},
							success:function(i){
								updateComfir(i); //调用修改完成结束
							}
					  });	
				  }
			  });
		}
	});
});

//封装成功修改警员信息
function updateComfir(i){
	if(i==1){
		Modal.alert({
				    msg: '修改成功!',
				    title: '提示',
				    btnok: '确定'
		}).on( function (e) {
			  showPage("/oasm/systemAdmin/jyxxSetting");
		  });
	}else{
		Modal.alert({
				    msg: '修改失败!',
				    title: '警告',
				    btnok: '确定'
		}).on( function (e) {
			  showPage("/oasm/systemAdmin/jyxxSetting");
		  });
	}
}
//封装成功删除警员信息
function delteComfir(i){ //提示信息
	if(i==1){
		Modal.alert({
				    msg: '删除成功!',
				    title: '提示',
				    btnok: '确定'
		}).on( function (e) {
			  showPage("/oasm/systemAdmin/jyxxSetting");
		  });
	}else{
		Modal.alert({
				    msg: '删除失败!',
				    title: '警告',
				    btnok: '确定'
		}).on( function (e) {
			  showPage("/oasm/systemAdmin/jyxxSetting");
		  });
	}
}

//删除警员信息
function jy_delect(jh){
	Modal.confirm({
	    msg: "确认删除【警号"+jh+"】的警察?"
	  }).on( function (e) {
		    if(e){$.ajax({
		    		url:"/oasm/jyxx/adminDeleteJyxx",
		    		dataType:"JSON",
		    		type:"post",
		    		data:{jh:jh},
		    		success:function(i){
		    			delteComfir(i); //调用删除结束提示框
		    		}
		    	});
		      }
		 });
}

function errorFile(){ //错误文件
	Modal.alert(
			  {
			    msg: '请选择文件',
			    title: '警告',
			    btnok: '确定'
	});
}
function excFile(){ //异常文件
	Modal.alert(
			  {
			    msg: '选择的文件必须为.xls或者.xlsx格式文件',
			    title: '警告',
			    btnok: '确定'
	});
}
function sucTip(msg){
	if(null!=msg){
		Modal.alert(
				  {
				    msg: msg,
				    title: '提示',
				    btnok: '确定'
		}).on( function (e) {
			  showPage("/oasm/systemAdmin/jyxxSetting");
		  });
	}
}

//excel导入警察信息
$(function(){
    $("#file").change(function(){  // 当 id 为 file 的对象发生变化时
    	var fileDir = $("#file").val();
    	var suffix = fileDir.substr(fileDir.lastIndexOf("."));
		if(""==fileDir||null==fileDir){
			$("#file_name").val(""); //清空已选择又不选择的文件
			errorFile();
		}else if(".xls"!=suffix && ".xlsx"!=suffix){
			excFile();
		}else{
			$("#file_name").val($("#file").val());  //将 #file 的值赋给 #file_name
			var filename = $("#file_name").val();
			inputFile(filename); //调用入库操作
		}
    })
});
function inputFile(name){//执行入库操作
	if(null!=name){
		$.post("/oasm/excelView/addPlice",{filename:name}).done(function(msg){
			if(!isNull(msg)){
				var jData = JSON.parse(msg);
				var m = "";
				$.each(JSON.parse(jData),function(k,v){
					m+="<div class='panel panel-info'>";
					m+="<div class='panel-heading'>";
					m+="<h3 class='panel-title'>导入EXCEL错误信息一览</h3>";
					m+="</div>";
					m+="<div class='panel-body'>";
					if(notNull(v.nullFont)){
						m+="<p>"+(k+1)+"."+v.nullFont+"</p>";
					}
					$.each(v.strMsg,function(e,r){
						if(notNull(r)){
							m+="<p>"+(e+2)+"."+r+"</p>";
						}
					});
					m+="</div>";
					m+="</div>";
					m+="<div><table class='table table-hover'>";
					m+="<caption>成功导入的警察信息数据</caption>";
					m+="<thead><th>序号</th><th>警号</th><th>姓名</th><th>职务</th><th>所在监区</th><th>所在分监区</th><th>部门</th></thead>";
					if(!isNull(v.jyxx)){
						$.each(v.jyxx,function(j,y){
							m+="<tbody><td>"+(j+1)+"</td><td>"+y.jh+"</td><td>"+y.xm+"</td><td>"+y.zwName+"</td><td>"+y.jq+"</td><td>"+y.xjq+"</td><td>"+y.bmh+"</td></tbody>";
						});
						m+="</table></div>";
					}
				});
				sucTip(m);
				document.getElementById("contentData").style['width']="600px";
			}
		})
	}
}

