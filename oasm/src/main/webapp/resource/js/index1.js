/*------------------------------|
 | index.js					  	|
 |------------------------------|
 | @author Vegeta		        |
 |------------------------------*/
$.ajaxSetup({
	cache: false //关闭AJAX相应的缓存
});


$(function () {
var yj1=document.getElementById('pggl');
var ej1=document.getElementById("pggl2");
var menuarea=document.getElementById("line");
yj1.onmouseover=function(){
	ej1.style.display="block";menuarea.style.height="80px";
	//xljzdh.style.display="none";xljzmenuarea.style.height="0px";
	zxgldh.style.display="none";zxglmenuarea.style.height="0px";
	tjfxdh.style.display="none";tjfxmenuarea.style.height="0px";
	//pggjdh.style.display="none";pggjmenuarea.style.height="0px";
	jygzdh.style.display="none";jygzmenuarea.style.height="0px";
}
yj1.onmouseout=function(){ej1.style.display="none";menuarea.style.height="0px";}
ej1.onmouseover=function(){ej1.style.display="block";menuarea.style.height="80px";}
// ej1.onmouseout=function(){ej1.style.display="none";menuarea.style.height="80px";}
//心理矫治移入移出部分
/*var xljzzl=document.getElementById('xljz');
var xljzdh=document.getElementById("xljz2");
var xljzmenuarea=document.getElementById("xljzline");
xljzzl.onmouseover=function(){
	xljzdh.style.display="block";xljzmenuarea.style.height="80px";
	pggjdh.style.display="none";pggjmenuarea.style.height="0px";
	zxgldh.style.display="none";zxglmenuarea.style.height="0px";
	ej1.style.display="none";menuarea.style.height="0px";
	tjfxdh.style.display="none";tjfxmenuarea.style.height="0px";
	jygzdh.style.display="none";jygzmenuarea.style.height="0px";
}
xljzzl.onmouseout=function(){xljzdh.style.display="none";xljzmenuarea.style.height="0px";}
xljzdh.onmouseover=function(){xljzdh.style.display="block";xljzmenuarea.style.height="80px";}
*/
//统计分析移入移出部分
var tjfxzl=document.getElementById('tjfx');
var tjfxdh=document.getElementById("tjfx2");
var tjfxmenuarea=document.getElementById("tjfxline");
tjfxzl.onmouseover=function(){
	tjfxdh.style.display="block";tjfxmenuarea.style.height="80px";
	//xljzdh.style.display="none";xljzmenuarea.style.height="0px";
	zxgldh.style.display="none";zxglmenuarea.style.height="0px";
	ej1.style.display="none";menuarea.style.height="0px";
	//pggjdh.style.display="none";pggjmenuarea.style.height="0px";
	jygzdh.style.display="none";jygzmenuarea.style.height="0px";
}
tjfxzl.onmouseout=function(){tjfxdh.style.display="none";tjfxmenuarea.style.height="0px";}
tjfxdh.onmouseover=function(){tjfxdh.style.display="block";tjfxmenuarea.style.height="80px";}
// tjfxdh.onmouseout=function(){tjfxdh.style.display="none";tjfxmenuarea.style.height="0px";}
//评估工具移入移出部分
/* var pggjzl=document.getElementById('pggj');
var pggjdh=document.getElementById("pggj2");
var pggjmenuarea=document.getElementById("pggjline");
pggjzl.onmouseover=function(){
	pggjdh.style.display="block";pggjmenuarea.style.height="80px";
	xljzdh.style.display="none";xljzmenuarea.style.height="0px";
	zxgldh.style.display="none";zxglmenuarea.style.height="0px";
	ej1.style.display="none";menuarea.style.height="0px";
	tjfxdh.style.display="none";tjfxmenuarea.style.height="0px";
	jygzdh.style.display="none";jygzmenuarea.style.height="0px";
}
pggjzl.onmouseout=function(){pggjdh.style.display="none";pggjmenuarea.style.height="0px";}
pggjdh.onmouseover=function(){pggjdh.style.display="block";pggjmenuarea.style.height="80px";}*/
// pggjdh.onmouseout=function(){pggjdh.style.display="none";pggjmenuarea.style.height="0px";}
//教育改造移入移出部分
var jygzzl=document.getElementById('jygz');
var jygzdh=document.getElementById("jygz2");
var jygzmenuarea=document.getElementById("jygzline");
jygzzl.onmouseover=function(){
	jygzdh.style.display="block";jygzmenuarea.style.height="80px";
	//czgzdh.style.display="none";czgzmenuarea.style.height="0px";
	zxgldh.style.display="none";zxglmenuarea.style.height="0px";
	ej1.style.display="none";menuarea.style.height="0px";
	tjfxdh.style.display="none";tjfxmenuarea.style.height="0px";
	//pggjdh.style.display="none";pggjmenuarea.style.height="0px";
	//xljzdh.style.display="none";xljzmenuarea.style.height="0px";
}
jygzzl.onmouseout=function(){jygzdh.style.display="none";jygzmenuarea.style.height="0px";}
jygzdh.onmouseover=function(){jygzdh.style.display="block";jygzmenuarea.style.height="80px";}
// jygzdh.onmouseout=function(){jygzdh.style.display="none";jygzmenuarea.style.height="0px";}
//专项管理移入移出部分
var zxglzl=document.getElementById('zxgl');
var zxgldh=document.getElementById("zxgl2");
var zxglmenuarea=document.getElementById("zxglline");
zxglzl.onmouseover=function(){
	zxgldh.style.display="block";zxglmenuarea.style.height="80px";
	jygzdh.style.display="none";jygzmenuarea.style.height="0px";
	//czgzdh.style.display="none";czgzmenuarea.style.height="0px";
	ej1.style.display="none";menuarea.style.height="0px";
	tjfxdh.style.display="none";tjfxmenuarea.style.height="0px";
	//pggjdh.style.display="none";pggjmenuarea.style.height="0px";
	//xljzdh.style.display="none";xljzmenuarea.style.height="0px";
}
zxglzl.onmouseout=function(){zxgldh.style.display="none";zxglmenuarea.style.height="0px";}
zxgldh.onmouseover=function(){zxgldh.style.display="block";zxglmenuarea.style.height="80px";}
	$("#container").load("home");
	$('.ulmenu li').click(function (event) {
		switch ($(this).attr("id")) {
                       //评估管理部分
			case "lr_rj":
				$("#pggl").addClass('current').siblings().removeClass('current');
				$("#container").load("/oasm/dafxView/lr_rj");
				break;
			case "lr_rc":
				$("#pggl").addClass('current').siblings().removeClass('current');
				$("#container").load("/oasm/dafxView/lr_rc");
				break;			
			case "lr_zq":
				$("#pggl").addClass('current').siblings().removeClass('current');
				$("#container").load("/oasm/dafxView/lr_zq");
				break;
			case "lr_cj":
				$("#pggl").addClass('current').siblings().removeClass('current');
				$("#container").load("/oasm/dafxView/lr_cj");
				break;
			case "bg_rj":
				$("#pggl").addClass('current').siblings().removeClass('current');
				$("#container").load("/oasm/pgbgsccxView/bg_rj");
				break;
			case "bg_rc":
				$("#pggl").addClass('current').siblings().removeClass('current');
				$("#container").load("/oasm/pgbgsccxView/bg_rc");
				break;			
			case "bg_zq":
				$("#pggl").addClass('current').siblings().removeClass('current');
				$("#container").load("/oasm/pgbgsccxView/bg_zq");
				break;
			case "bg_cj":
				$("#pggl").addClass('current').siblings().removeClass('current');
				$("#container").load("/oasm/pgbgsccxView/bg_cj");
				break;
			case 'gzrwgl':
				$("#pggl").addClass('current').siblings().removeClass('current');
				$("#container").load("/oasm/gzrwglView/gzrwgl");
				break;
			case "pgbgsccx":
				$("#pggl").addClass('current').siblings().removeClass('current');
				$("#container").load("/oasm/pgbgsccxView/pgbgsccx");
				break;
			case "gwysgl":
				$("#pggl").addClass('current').siblings().removeClass('current');
				$("#container").load("/oasm/gwysglView/gwysgl");
				break;
			case "fyhy":
				$("#pggl").addClass('current').siblings().removeClass('current');
				$("#container").load("/oasm/fyhyView/fyhy");
				break;
				//心理矫治部分
			case "xlcs":
				$("#xljz").addClass('current').siblings().removeClass('current');
				$("#container").load("/oasm/xljzView/xlcs");
				break;
				//专项管理部分
			case "zdfgl":
				$("#zxgl").addClass('current').siblings().removeClass('current');
				$("#container").load("/oasm/zxglView/zdfgl");
				break;
			case "tsfgl":
				$("#zxgl").addClass('current').siblings().removeClass('current');
				$("#container").load("/oasm/zxglView/tsfgl");
				break;
			case "wwfgl":
				$("#zxgl").addClass('current').siblings().removeClass('current');
				$("#container").load("/oasm/zxglView/wwfgl");
				break;
			case "gwfgl":
				$("#zxgl").addClass('current').siblings().removeClass('current');
				$("#container").load("/oasm/zxglView/gwfgl");
				break;
			case "jgfgl":
				$("#zxgl").addClass('current').siblings().removeClass('current');
				$("#container").load("/oasm/zxglView/jgfgl");
				break;
                        //处置跟踪部分
			case "czgz":
				$("#czgz").addClass('current').siblings().removeClass('current');
				$("#container").load("/oasm/czgzView/czgz");
				break;
			case "czdcsjk":
				$("#czgz").addClass('current').siblings().removeClass('current');
				$("#container").load("/oasm/czgzView/czdcsjk");
				break;
      			            //统计分析
			case "wxqkbh":
				$("#tjfx").addClass('current').siblings().removeClass('current');
				$("#container").load("/oasm/tjfxView/wpqkbh");
				break;
			case "wxcdtj":
				$("#tjfx").addClass('current').siblings().removeClass('current');
				$("#container").load("/oasm/tjfxView/wpcdtj");
				break;
			case "wxlbtj":
				$("#tjfx").addClass('current').siblings().removeClass('current');
				$("#container").load("/oasm/tjfxView/wxlbtj");
				break;
			case "pgqktj":
				$("#tjfx").addClass('current').siblings().removeClass('current');
				$("#container").load("/oasm/tjfxView/pgqktj");
				break;
			case "yjtj":
				$("#tjfx").addClass('current').siblings().removeClass('current');
				$("#container").load("/oasm/tjfxView/yjtj");
				break;
			case "glzftj":
				$("#tjfx").addClass('current').siblings().removeClass('current');
				$("#container").load("/oasm/tjfxView/glzftj");
				break;
			//评估工具管理部分
			case "lbfx":
				$("#pggj").addClass('current').siblings().removeClass('current');
				$("#container").load("/oasm/pggjglView/lbfx");
				break;
			case "yzfx":
				$("#pggj").addClass('current').siblings().removeClass('current');
				$("#container").load("/oasm/pggjglView/yzfx");
				break;
			case "pgbgfx":
				$("#pggj").addClass('current').siblings().removeClass('current');
				$("#container").load("/oasm/pggjglView/pgbgfx");
				break;
						//教育改造部分
			case "zfxx":
				$("#jygz").addClass('current').siblings().removeClass('current');
				$("#container").load("/oasm/jygzView/zfxx");
				break;
			case "gzfagz":
				$("#jygz").addClass('current').siblings().removeClass('current');
				$("#container").load("/oasm/jygzView/gzfagz");
				break;
		}
	});
	$('.ul02 li').click(function (event) {
		$(this).addClass('current').siblings().removeClass('current');
		switch ($(this).attr("id")) {
			case "home":
				$("#container").load("home");
				break;
			case 'pggl': //评估管理
				$("#container").load("/oasm/dafxView/lr_rj");
				break;
			case "xljz"://心理矫治
				$("#container").load("/oasm/xljzView/xlcs");
				break;	
			case "czgz"://处置跟踪
				$("#container").load("/oasm/czgzView/czgz");
				break;
			case "tjfx"://统计分析
				$("#container").load("/oasm/tjfxView/wpqkbh");
				break;
			case "jygz"://教育改造
				$("#container").load("/oasm/jygzView/zfxx");
				break;
			case "pggj"://评估工具 
				$("#container").load("/oasm/pggjglView/lbfx");
				break;
			case "grmb"://个人任务
				$("#container").load("/oasm/gzrwglView/grgzmb");
				break;
			case "zxgl"://专项管理
				$("#container").load("/oasm/zxglView/zdfgl");
				break;
		}
	});

	//container的高度自适应
	//	var windowHeight =  window.screen.availHeight;
	//	alert(windowHeight);
});