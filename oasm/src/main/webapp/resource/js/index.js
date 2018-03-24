/*------------------------------|
 | index.js					  	|
 |------------------------------|
 | @author Sybelle		        |
 |------------------------------*/
$.ajaxSetup({
	cache: false //关闭AJAX相应的缓存
});


$(function () {
$(".ul02 li").mouseover(function(){
	$(this).addClass('current2');
	$(".sub_menu_area").css({"display":"none"});
	var mid=$(this).attr('id');
	//console.info(mid);
	$("#"+mid+"2").css({"display":"block"});
});
$(".ul02 li").mouseout(function(){
	$(this).removeClass('current2');
	var mid=$(this).attr("id");
	$("#"+mid+"2").css({"display":"none"});
	//console.info(mid);
    var mid2=$(".current").attr("id");
    $("#"+mid2+"2").css({"display":"block"});
    });
   $(".sub_menu_area").mouseover(function(){
	   var uli=$(this).attr("id").replace("2", "");
	   $("#"+uli).addClass('current2');
	   var mid2=$(".current").attr("id");	   
	   $("#"+mid2+"2").css({"display":"none"});
	   $(this).css({"display":"block"});   
   });
   $(".sub_menu_area").mouseout(function(){
	   var uli=$(this).attr("id").replace("2", "");
	   $("#"+uli).removeClass('current2');
	   $(this).css({"display":"none"});   
	   var mid2=$(".current").attr("id");
	    $("#"+mid2+"2").css({"display":"block"});
	   
	   });

//	$("#container").load("home");
   $("#container").load("/oasm/dafxView/lr_cj");
	$('.sub_menu_li').click(function (event) {
		$('.sub_menu_li').removeClass('selected_li');
		$(this).addClass('selected_li');
		switch ($(this).attr("id")) {
                       //评估管理部分
		    case "lr_cj":
				$("#pggl").addClass('current').siblings().removeClass('current');
				$("#container").load("/oasm/dafxView/lr_cj");
			    break;
			case "bg_cj":
				$("#pggl").addClass('current').siblings().removeClass('current');
				$("#container").load("/oasm/pgbgsccxView/bg_cj");
				break;
//			case 'gzrwgl':
//				$("#pggl").addClass('current').siblings().removeClass('current');
//				$("#container").load("/oasm/gzrwglView/gzrwgl");
//				break;
//			case "pgbgsccx":
//				$("#pggl").addClass('current').siblings().removeClass('current');
//				$("#container").load("/oasm/pgbgsccxView/pgbgsccx");
//				break;
//			case "gwysgl":
//				$("#pggl").addClass('current').siblings().removeClass('current');
//				$("#container").load("/oasm/gwysglView/gwysgl");
//				break;
//			case "fyhy":
//				$("#pggl").addClass('current').siblings().removeClass('current');
//				$("#container").load("/oasm/fyhyView/fyhy");
//				break;
//				//心理矫治部分
//			case "xlcs":
//				$("#xljz").addClass('current').siblings().removeClass('current');
//				$("#container").load("/oasm/xljzView/xlcs");
//				break;
//				//专项管理部分
//			case "zdfgl":
//				$("#zxgl").addClass('current').siblings().removeClass('current');
//				$("#container").load("/oasm/zxglView/zdfgl");
//				break;
//			case "tsfgl":
//				$("#zxgl").addClass('current').siblings().removeClass('current');
//				$("#container").load("/oasm/zxglView/tsfgl");
//				break;
//			case "wwfgl":
//				$("#zxgl").addClass('current').siblings().removeClass('current');
//				$("#container").load("/oasm/zxglView/wwfgl");
//				break;
//			case "gwfgl":
//				$("#zxgl").addClass('current').siblings().removeClass('current');
//				$("#container").load("/oasm/zxglView/gwfgl");
//				break;
//			case "jgfgl":
//				$("#zxgl").addClass('current').siblings().removeClass('current');
//				$("#container").load("/oasm/zxglView/jgfgl");
//				break;
//                        //处置跟踪部分
//			case "czgz":
//				$("#czgz").addClass('current').siblings().removeClass('current');
//				$("#container").load("/oasm/czgzView/czgz");
//				break;
//			case "czdcsjk":
//				$("#czgz").addClass('current').siblings().removeClass('current');
//				$("#container").load("/oasm/czgzView/czdcsjk");
//				break;
//      			            //统计分析
//			case "wxqkbh":
//				$("#tjfx").addClass('current').siblings().removeClass('current');
//				$("#container").load("/oasm/tjfxView/wpqkbh");
//				break;
//			case "wxcdtj":
//				$("#tjfx").addClass('current').siblings().removeClass('current');
//				$("#container").load("/oasm/tjfxView/wpcdtj");
//				break;
//			case "wxlbtj":
//				$("#tjfx").addClass('current').siblings().removeClass('current');
//				$("#container").load("/oasm/tjfxView/wxlbtj");
//				break;
//			case "zxttj":
//				$("#tjfx").addClass('current').siblings().removeClass('current');
//				$("#container").load("/oasm/tjfxView/zxttj");
//				break;
//			case "cjzftj":
//				$("#tjfx").addClass('current').siblings().removeClass('current');
//				$("#container").load("/oasm/tjfxView/cjzftj");
//				break;
//			case "czqktj":
//				$("#tjfx").addClass('current').siblings().removeClass('current');
//				$("#container").load("/oasm/tjfxView/czqktj");
//				break;
//			case "pgqktj":
//				$("#tjfx").addClass('current').siblings().removeClass('current');
//				$("#container").load("/oasm/tjfxView/pgqktj");
//				break;
//			case "yjtj":
//				$("#tjfx").addClass('current').siblings().removeClass('current');
//				$("#container").load("/oasm/tjfxView/yjtj");
//				break;
//			case "glzftj":
//				$("#tjfx").addClass('current').siblings().removeClass('current');
//				$("#container").load("/oasm/tjfxView/glzftj");
//				break;
//			case "wxyzfx":
//				$("#tjfx").addClass('current').siblings().removeClass('current');
//				$("#container").load("/oasm/tjfxView/wxyzfx");
//				break;
//			//评估工具管理部分
//			case "lbfx":
//				$("#pggj").addClass('current').siblings().removeClass('current');
//				$("#container").load("/oasm/pggjglView/lbfx");
//				break;
//			case "yzfx":
//				$("#pggj").addClass('current').siblings().removeClass('current');
//				$("#container").load("/oasm/pggjglView/yzfx");
//				break;
//			case "pgbgfx":
//				$("#pggj").addClass('current').siblings().removeClass('current');
//				$("#container").load("/oasm/pggjglView/pgbgfx");
//				break;
//						//教育改造部分
//			case "zfxx":
//				$("#jygz").addClass('current').siblings().removeClass('current');
//				$("#container").load("/oasm/jygzView/zfjbxx");
//				break;
//			case "gzfagz":
//				$("#jygz").addClass('current').siblings().removeClass('current');
//				$("#container").load("/oasm/jygzView/gzfagz");
//				break;
		}
	});
	$('.ul02 li').click(function (event) {
		$('.sub_menu_li').removeClass('selected_li');
		$(this).addClass('current').siblings().removeClass('current');
		switch ($(this).attr("id")) {
//			case "home":
//				$("#container").load("home");
//				break;
			case 'pggl': //评估管理
//				$("#lr_da").addClass('selected_li');
				$("#lr_cj").addClass('selected_li');
//				$("#container").load("/oasm/dafxView/lr_da");
				$("#container").load("/oasm/dafxView/lr_cj");
				break;
			case "xljz"://心理矫治
				$("#container").load("/oasm/xljzView/xlcs");
				break;	
//			case "czgz"://处置跟踪
//				$("#czgz").addClass('selected_li');
//				$("#container").load("/oasm/czgzView/czgz");
//				break;
			case "tjfx"://统计分析
				$("#wxqkbh").addClass('selected_li');
//				$("#container").load("/oasm/tjfxView/wpqkbh");
				$("#container").load("/oasm/tjfxView/cjzftj");//改为点击进入再犯罪统计
				break;
			case "jygz"://教育改造
				$("#zfxx").addClass('selected_li');
				$("#container").load("/oasm/jygzView/zfjbxx");
				break;
//			case "pggj"://评估工具 
//				$("#container").load("/oasm/pggjglView/lbfx");
//				break;
//			case "grmb"://个人任务
//				$("#container").load("/oasm/gzrwglView/grgzmb");
//				break;
//			case "zxgl"://专项管理
//				$("#jgfgl").addClass('selected_li');
//				$("#container").load("/oasm/zxglView/jgfgl");
//				break;
		}
	});

	//container的高度自适应
	//	var windowHeight =  window.screen.availHeight;
	//	alert(windowHeight);
});