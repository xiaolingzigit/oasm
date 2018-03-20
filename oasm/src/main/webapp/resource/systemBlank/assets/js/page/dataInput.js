//确定囚犯和量表之间的配置关系
$(function(){
          $("#data_btn_input").click(function(){
        	  Modal.confirm({
  			    msg: "是否确定囚犯和量表配置？"
  			  }).on( function (e) {
  			    if(e){
  			    	mask_fullscreen(); //加载延时加载按钮
  			    	$.ajax({
  			    		url:"/oasm/tdminAndtyz/addCrimScaleProduce",
  			    		dataType:"JSON",
  			    		type:"post",
  			    		success:function(i){
  			    			if(i==1){
  			    				mask_close_all();
  			    				alertStart();
  			    			}else{
  			    				alertStartError();
  			    			}
  			    		}
  			    	});
  			    }
  			  });
            });
       });


//使用excel导入囚犯和警察的关系
$(function(){
	$("#inputCPbtn").click(function(){
		var fileDir = getPath(document.getElementById("inputfile"));
		console.info(fileDir);
		var suffix = fileDir.substr(fileDir.lastIndexOf("."));
		if(""==fileDir){
			alert("文件名不为空!");
		}else if(".xls"!=suffix && ".xlsx"!=suffix){
			alert("文件类型必须为.xls获取.xlsx格式的文件");
		}else{
			$.ajax({
				url:"/oasm/excelView/inputCPforExcel",
				dataType:"JSON",
				type:"post",
				data:{file:fileDir},
				success:function(data){
					if(data!=null&&data!=""){
						var jsonData = JSON.parse(data);
						var a = "";
						a+="<table class='table table-bordered'>";
						a+="<caption>已成功添加或修改的警察与罪犯关系数据</caption>";
						a+="<thead><tr>";
						a+="<th>囚号</th><th>囚号姓名</th><th>警号</th><th>警察姓名</th><th>协教警号</th><th>协教姓名</th>";
						a+="</tr></thead>";
						a+="<tbody>";
						$.each(jsonData,function(k,v){
						  a+="<tr>";
						  a+="<td>"+v.qh+"</td><td>"+v.xm+"</td><td>"+v.jh+"</td><td>"+v.jhxm+"</td><td>"+v.xjbh+"</td><td>"+v.xjxm+"</td>";
						  a+="</tr>";
						});
						a+="</tbody>";
						a+="</table>";
						inputSuccess(a);
					}else{
						inputError();
					}
				}
			});
		}
		
	});
});

//封装的安全路径验证
function getPath(obj) {
	 if (obj) {
	  if (window.navigator.userAgent.indexOf("MSIE") >= 1) {
	   obj.select();
	   return document.selection.createRange().text;
	  } else if (window.navigator.userAgent.indexOf("Firefox") >= 1) {
	   if (obj.files) {
	    return obj.files.item(0).getAsDataURL();
	   }
	   return obj.value;
	  }
	  return obj.value;
	 }
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
function alertStartError(){  //保存失败
	Modal.alert(
			  {
			    msg: '启动失败,没有新增的罪犯',
			    title: '信息',
			    btnok: '确定'
	});
}

function alertStart(){ //保存成功
	Modal.alert(
			  {
			    msg: "保存成功",
			    title: '信息',
			    btnok: '确定'
	});
}

function inputError(){ //导入文件失败
	Modal.alert(
			  {
			    msg: '导入文件异常，请重试...',
			    title: '信息',
			    btnok: '确定'
	});
}

function inputSuccess(a){ //保存成功
	Modal.alert(
			  {
			    msg: a,
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

//加载层-指定元素:不自动关闭
function mask_fullscreen(){
	$.mask_fullscreen('#test_mask_2');
	
}
//关闭所有加载层
function mask_close_all(){
	$.mask_close_all();
}