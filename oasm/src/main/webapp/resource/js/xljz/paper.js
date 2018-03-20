/*------------------------------|
 | paper.js					  	|
 |------------------------------|
 | @author Sybelle		        |
 |------------------------------*/
$.ajaxSetup({
	cache: false //关闭AJAX相应的缓存
});
//点击<td>直接选中内含radio&checkbox
$('.lb_option').click(function (event) {
	$(this).find("input").attr("checked","checked");//将<td>下的选框选中
	$(this).css("background","#ffff80");//修改其背景色
	$(this).siblings(".lb_option").css("background","#ffffff");//遍历其他同辈<td>,修改背景色
	/* $(this).siblings(".lbf").css("background"," #7accf8"); */
	tm_symbol=$(this).find("input").attr("name")+"_symbol";//拼接对应的题目小进度框的id
	$("#"+tm_symbol).addClass("has_done");//找到这个框，添加样式类
	var show_check=0;//当前显示题目完成量
	$(this).parents(".psychologicalTests_scale_paper").find("tr").each(function(){		//遍历所有题目
		if($(this).css("display")!="none"){//判断这题是否当前显示
		if($(this).find(":checked").length>=1){//判断这题是否已作答
			show_check+=1;//已作答就加1
		}
		}
	});
	if(show_check==pageSize){
		next();
	}
});
var theTable = document.getElementsByClassName("psychologicalTests_scale_paper")[0];
var totalRow= document.getElementById("rows_number");
var totalPage = document.getElementById("spanTotalPage");
var pageNum = document.getElementById("spanPageNum");


var spanPre = document.getElementById("spanPre");
var spanNext = document.getElementById("spanNext");
var spanFirst = document.getElementById("spanFirst");
var spanLast = document.getElementById("spanLast");


var numberRowsInTable = theTable.rows.length;
var pageSize = 5;
var page = 1;

totalRow.innerHTML = numberRowsInTable;

//下一页
function next() {

    hideTable();


    currentRow = pageSize * page;
    maxRow = currentRow + pageSize;
    if (maxRow > numberRowsInTable) maxRow = numberRowsInTable;
    for (var i = currentRow; i < maxRow; i++) {
        theTable.rows[i].style.display = '';
    }
    page++;


    if (maxRow == numberRowsInTable) { nextText(); lastText(); }
    showPage();
    preLink();
    firstLink();
}


//上一页
function pre() {


    hideTable();


    page--;


    currentRow = pageSize * page;
    maxRow = currentRow - pageSize;
    if (currentRow > numberRowsInTable) currentRow = numberRowsInTable;
    for (var i = maxRow; i < currentRow; i++) {
        theTable.rows[i].style.display = '';
    }




    if (maxRow == 0) { preText(); firstText(); }
    showPage();
    nextLink();
    lastLink();
}


//第一页
function first() {
    hideTable();
    page = 1;
    for (var i = 0; i < pageSize; i++) {
        theTable.rows[i].style.display = '';
    }
    showPage();


    preText();
    nextLink();
    lastLink();
}
//跳转
function jumpto() {

    hideTable();
    page--;
    //alert("recal==="+page);
   currentRow = pageSize * page;
    maxRow = currentRow + pageSize;
    //alert("nowr"+currentRow );
    //alert("maxr"+ maxRow );
    if (maxRow > numberRowsInTable) maxRow = numberRowsInTable;
    for (var i = currentRow; i < maxRow; i++) {
    	//alert("this is"+i);
        theTable.rows[i].style.display = '';
    }
    page++;
    //alert("encal==="+page);

    if (maxRow == numberRowsInTable) { nextText(); lastText(); }
    showPage();
    preLink();
    firstLink();
}
$(".symbol_li").click(function(){
	var tmno=$(this).html();
	//alert(tmno);
	var count=0;
	if (tmno % pageSize != 0){
		count = 1;
	}
   page = parseInt(tmno / pageSize) + count;
   //alert("cal==="+page);
   jumpto();
});
//最后一页
function last() {
    hideTable();
    page = pageCount();
    currentRow = pageSize * (page - 1);
    for (var i = currentRow; i < currentRow+5; i++) {
        theTable.rows[i].style.display = '';
    }
    showPage();


    preLink();
    nextText();
    firstLink();
}


function hideTable() {
    for (var i = 0; i < numberRowsInTable; i++) {
        theTable.rows[i].style.display = 'none';
    }
}


function showPage() {
    pageNum.innerHTML = page;
}


//总共页数
function pageCount() {
    var count = 0;
    if (numberRowsInTable % pageSize != 0) count = 1;
    return parseInt(numberRowsInTable / pageSize) + count;
}


//显示链接
function preLink() { spanPre.onclick = pre;}
function preText() { spanPre.onclick = ""; }


function nextLink() { spanNext.onclick = next; }
function nextText() { spanNext.onclick = "";  }


function firstLink() { spanFirst.innerHTML = "<a  onclick='first()'>第一页</a>"; }
function firstText() { spanFirst.innerHTML = "第一页"; }


function lastLink() { spanLast.innerHTML = "<a  onclick='last()'>最后一页</a>"; }
function lastText() { spanLast.innerHTML = "最后一页"; }


//隐藏表格
function hide() {
    for (var i = pageSize; i < numberRowsInTable; i++) {
        theTable.rows[i].style.display = 'none';
    }


    totalPage.innerHTML = pageCount();
    pageNum.innerHTML = '1';


    nextLink();
    lastLink();
}

hide();