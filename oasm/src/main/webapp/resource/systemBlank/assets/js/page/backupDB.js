//获取文件夹路径
$(function(){
	var filePath = "";
	$('#dirPath').bind('input propertychange', function() {
		$("input[name='endPath']").val($("#diskPath").val()+$(this).val());
		filePath = $("input[name='endPath']").val($("#diskPath").val()+$(this).val());
	});
});
//最终传回后台路径
function backupFile(){
	var inputPath = "";
	$("input[name='endPath']").val($("#diskPath").val()+$('#dirPath').val());
	inputPath = $("#diskPath").val()+$('#dirPath').val(); //输入框的路径
	var index = inputPath.lastIndexOf("\\");
	if(haveIndex(inputPath)){
		errorPath(inputPath); //调用验证俩斜杠方法
		return false;
	}else if(haveSigle(inputPath)){
		errorPath(inputPath); //调用验证正斜杠方法
		return false;
	}else if(index==inputPath.length-1){ //最后一个\斜杠的位置刚好为最后一位的时候，自动去掉
		inputPath = inputPath.substring(0,inputPath.length-1);
	}else{
		inputPath = inputPath; //返回正确路径
	}
	var savePath = inputPath+"\\";//赋值给正确路径
	Modal.confirm({
	 msg: "把数据备份到"+savePath+"?"
		  }).on( function (e) {
		    if(e){
		    	mask_fullscreen(); //加载延时加载按钮
		    	$.post("/oasm/systemAdmin/backupPackge",{savePath:savePath}).done(function(msg){
		    		mask_close_all(); //取消延时加载
		    		sucfilePath(msg);
		    		document.getElementById("tipContent").style['width']="600px";
		    	});
	}});
}

//找到\\或者/
function haveIndex(obj){
	if(obj.lastIndexOf("\\\\")>0){ //有两个连续的斜杠
		return true;
	}else{
		return false;
	}
}
function haveSigle(obj){
	if(obj.lastIndexOf("/")>0){
		return true;
	}else{
		return false;
	}
}

function errorPath(path){
	Modal.alert({
		 msg: '【选择路径'+path+'有误】',
		    title: '提示',
		    btnok: '确定'
	  });
}
function sucfilePath(str){ //备份完成
	if(null!=str){
		Modal.alert({
			 msg: "路径提示:"+str,
			    title: '提示',
			    btnok: '确定'
		  }).on( function (e) {
			  showPage("/oasm/systemAdmin/backupDB");
		  });
	}
}

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

//加载层-指定元素:不自动关闭
function mask_fullscreen(){
	$.mask_fullscreen('#test_mask_2');
	
}
//关闭所有加载层
function mask_close_all(){
	$.mask_close_all();
}