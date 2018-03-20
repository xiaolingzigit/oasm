
var commonUrl = "/oasm/task/op";
//initWeb
var account;//账号
var name;//用户名
var auth;// authority,权限代码字符串

/**
 * 初始化页面权限数据
 */
function init() {
	silentPost(data, function(data){
		alert(data);
	});
}

/**
 * post请求
 * 
 * @param data
 *            请求数据
 * @param onSuccess
 *            回调函数onSuccess(data)
 */
function post(data, onSuccess) {
	$.ajax({
		type : 'POST',
		url : commonUrl,
		dataType : "JSON",
		async:false,
		data : data,
		success : function(data) {
			onSuccess(data);
		},
		error : function() {
			alert("请求失败");
		}
	});
}

/**
 * 静默请求，成功时回调onSuccess
 * 
 * @param data
 * @param onSuccess  回调函数onSuccess(data)
 */
function silentPost(data, onSuccess) {
	$.ajax({
		type : 'POST',
		url : commonUrl,
		dataType : "JSON",
		data : data,
		success : function(data) {
			onSuccess(data);
		}
	});
}


/**
 * 弹窗提示响应信息的post请求
 * 
 * @param data
 *            请求数据
 */
function defPost(data) {
	post(data, function(respMsg) {
		if (!isEmpty(respMsg)) {
			alert(respMsg);
		}
	});
}



/**
 * 添加任务
 * 
 * @param crimNo
 *            囚号
 * @param taskType
 *            任务类型
 * @param taskBasis
 *            任务依据
 * @param taskDescrib
 *            任务描述
 * @param deadline
 *            完成期限
 * @param excutor
 *            任务执行人警号分号隔开，支持2人
 * @param status
 *            任务状态
 */
function addTask(crimNo, taskType, taskBasis, taskDescrib, deadline, excutor,
		status, callback) {
	post({
		op : "taskAdd",
		crimNo : crimNo,
		taskType : taskType,
		taskBasis : taskBasis,
		taskDescrib : taskDescrib,
		deadline : deadline,
		excutor : excutor,
		status : status
	}, callback);
}

/**
 * 修改任务状态
 * 
 * @param taskId
 * @param status
 */
function updateStatus(taskId, status) {
	defPost({
		op : "taskUpdate",
		taskId : taskId,
		status : status + ""
	});
}

/**
 * 取消任务
 * 
 * @param taskId
 */
function cancelTask(taskId) {
	defPost({
		op : "taskCancel",
		taskId : taskId
	});
}

/**
 * 搜索获取任务信息列表
 * 
 * @param taskType
 *            任务类型
 * @param taskId
 *            任务ID
 * @param prison
 *            监区
 * @param crimNo
 *            囚号
 * @param crimName
 *            囚犯姓名%%
 * @param copRange
 *            警察搜索范围：所有all/专管zg/协管xg/任务执行人zxr
 * @param copNo
 *            警号
 * @param copName
 *            警名
 * @param creator
 *            任务创建人
 * @param crTimeStart
 *            创建时间区间开始
 * @param crTimeEnd
 *            创建时间区间结束
 * @param deadlineStart
 *            最后完成期限区间开始
 * @param deadlineEnd
 *            最后完成期限区间结束
 * @param lastModifStart
 *            最后修改时间区间开始
 * @param lastModifEnd
 *            最后修改时间区间结束
 * @param status
 *            任务状态
 * @param taskBasis
 *            任务依据
 * @param taskDescrib
 *            任务描述
 * @param callBack
 *            回调函数
 */
function getTaskList(taskType, taskId, prison, crimNo, crimName, copRange,
		copNo, copName, creator, crTimeStart, crTimeEnd, deadlineStart,
		deadlineEnd, lastModifStart, lastModifEnd, status, taskBasis,
		taskDescrib,num,size,callBack) {
	post({
		op : "taskGetList",
		taskType : taskType,
		taskId : taskId,
		prison : prison,
		crimNo : crimNo,
		crimName : crimName,
		copRange : copRange,
		copNo : copNo,
		copName : copName,
		creator : creator,
		crTimeStart : crTimeStart,
		crTimeEnd : crTimeEnd,
		deadlineStart : deadlineStart,
		deadlineEnd : deadlineEnd,
		lastModifStart : lastModifStart,
		lastModifEnd : lastModifEnd,
		status : status + "",
		taskBasis : taskBasis,
		taskDescrib : taskDescrib,
		pageNum:num,
		pageSize:size
	}, callBack);
}

/**
 * 搜索获取任务信息列表，模糊任务类型查询
 * 
 * @param taskType
 *            任务类型
 * @param taskId
 *            任务ID
 * @param prison
 *            监区
 * @param crimNo
 *            囚号
 * @param crimName
 *            囚犯姓名%%
 * @param copRange
 *            警察搜索范围：所有all/专管zg/协管xg/任务执行人zxr
 * @param copNo
 *            警号
 * @param copName
 *            警名
 * @param creator
 *            任务创建人
 * @param crTimeStart
 *            创建时间区间开始
 * @param crTimeEnd
 *            创建时间区间结束
 * @param deadlineStart
 *            最后完成期限区间开始
 * @param deadlineEnd
 *            最后完成期限区间结束
 * @param lastModifStart
 *            最后修改时间区间开始
 * @param lastModifEnd
 *            最后修改时间区间结束
 * @param status
 *            任务状态
 * @param taskBasis
 *            任务依据
 * @param taskDescrib
 *            任务描述
 * @param callBack
 *            回调函数
 */
function getTaskListWithTypeLike(taskType, taskId, prison, crimNo, crimName,
		copRange, copNo, copName, creator, crTimeStart, crTimeEnd,
		deadlineStart, deadlineEnd, lastModifStart, lastModifEnd, status,
		taskBasis, taskDescrib, callBack) {

	post({
		op : "taskGetListByTypeLike",
		taskType : taskType,
		taskId : taskId,
		prison : prison,
		crimNo : crimNo,
		crimName : crimName,
		copRange : copRange,
		copNo : copNo,
		copName : copName,
		creator : creator,
		crTimeStart : crTimeStart,
		crTimeEnd : crTimeEnd,
		deadlineStart : deadlineStart,
		deadlineEnd : deadlineEnd,
		lastModifStart : lastModifStart,
		lastModifEnd : lastModifEnd,
		status : status + "",
		taskBasis : taskBasis,
		taskDescrib : taskDescrib
	}, callBack);
}

/**
 * 保存测试记录
 * 
 * @param taskId
 * @param answer
 *            答案字符串
 * @param status
 *            保存状态
 */
function saveTestNote(taskId, answer, status) {
	defPost({
		op : "testSave",
		taskId : taskId,
		answer : answer,
		status : status
	});
}

/**
 * 获取任务/记录列表
 * 
 * @param taskId
 *            任务ID
 * @param onSuccess
 *            回调函数
 */
function getTestNote(taskId, onSuccess) {
	post({
		op : "testQuery",
		taskId : taskId,
	}, onSuccess);
}

/**
 * 设置单选按钮选中
 * 
 * @param name
 * @param idx
 */
function setRadioSelected(name, idx) {
	$("input:radio[name=" + name + "]").eq(idx).attr("checked", 'checked');
}

function isEmpty(data) {
	if (data == null || data == "_nothing" || data == "") {
		return true;
	}

	var errorIdx = data.indexOf("_error");
	if (errorIdx >= 0) {
		var msg = data.substring(errorIdx + 6);
		if (msg.length > 0) {
			alert(msg);
		} else {
			alert("获取数据失败");
		}
		return true;
	}
	return false;
}

// TODO 具体业务方法
function loadScl90List() {
	goForward("/oasm/xljzView/xlcs_scl90");
}

function loadCopaList() {
	goForward("/oasm/xljzView/xlcs_scl90");
}

// TODO 
var listData; //列表信息对象
var listArr;// 信息列表json數数组
var currIdx;// scl90当前操作索引

function setCurrIdx(idx) {
	currIdx = idx;
}

function loadScl90test(idx) {
	setCurrIdx(idx);
	goForward("/oasm/xljzView/xlcs_scl90lb");
}

function loadScl90report(idx) {
	setCurrIdx(idx);
	goForward("/oasm/xljzView/xlcs_scl90bg");
}

function reviewScl90test() {
	goForward("/oasm/xljzView/xlcs_scl90lb");
}

function getCrimDetails() {
	alert(listArr[currIdx].crimNo);
	goForward("/oasm/dafxView/criminalinfo");
}

function scl90save() {
	// var jh = $(".scl_jh").html().toString();// 登记干警号
	var taskId = listArr[currIdx].taskId;// 任务ID
	var answer = [];// scl答题情况
	var status = 3;// 暂存状态

	$(".lb_option input[type=radio]:checked").each(function(i, n) {
		var scltm = $(n).attr("name");
		var sclyz = $(n).val();
		answer.push("{'name':'" + scltm + "','val':'" + sclyz + "'}");
	});

	saveTestNote(taskId, answer, status);
}

function scl90submit() {

	var inputnum = $(".lb_option input[type=radio]").length;
	var inputhasck = $(".lb_option input[type=radio]:checked").length;
	var inputmck = inputnum / 5;
	if (inputhasck == inputmck && confirm("答案提交后将无法修改，是否继续提交？")) {

		var taskId = listArr[currIdx].taskId;// 任务ID
		var answer = [];// scl答题情况
		var status = 4;// 提交状态

		// 全部选中
		$(".lb_option input[type=radio]:checked").each(function(i, n) {
			var scltm = $(n).attr("name");
			var sclyz = $(n).val();
			answer.push("{'name':'" + scltm + "','val':'" + sclyz + "'}");
		});

		saveTestNote(taskId, answer, status);

	} else {
		alert("已作答" + inputhasck + "题，还有" + (inputmck - inputhasck)
				+ "题未作答，请完成所有答题后再提交。");
	}
}

// TODO COPA-PI

function loadCopaTest(idx) {	
	setCurrIdx(idx);
	goForward("/oasm/xljzView/xlcs_copalb");
}

function loadCopaReport(idx) {
	setCurrIdx(idx);
	goForward("/oasm/xljzView/xlcs_copabg");
}

function reviewCopaTest() {
	goForward("/oasm/xljzView/xlcs_copalb");
}

function copaSave() {

	var taskId = listArr[currIdx].taskId;// 任务ID
	var answer = [];// scl答题情况
	var status = 3;// 暂存状态

	$(".lb_option input[type=radio]:checked").each(function(i, n) {
		var scltm = $(n).attr("name");
		var sclyz = $(n).val();
		answer.push("{'name':'" + scltm + "','val':'" + sclyz + "'}");
	});

	saveTestNote(taskId, answer, status);
}

function copaSubmit() {

	var inputnum = $(".lb_option input[type=radio]").length;
	var inputhasck = $(".lb_option input[type=radio]:checked").length;
	var inputmck = inputnum / 2;
	if (inputhasck == inputmck && confirm("答案提交后将无法修改，是否继续提交？")) {

		var taskId = listArr[currIdx].taskId;// 任务ID
		var answer = [];// scl答题情况
		var status = 4;// 提交状态

		// 全部选中
		$(".lb_option input[type=radio]:checked").each(function(i, n) {
			var scltm = $(n).attr("name");
			var sclyz = $(n).val();
			answer.push("{'name':'" + scltm + "','val':'" + sclyz + "'}");
		});

		saveTestNote(taskId, answer, status);

	} else {
		alert("已作答" + inputhasck + "题，还有" + (inputmck - inputhasck)
				+ "题未作答，请完成所有答题后再提交。");
	}
}



//TODO 非通用的小方法

/**
 * 将空白和null转化为"---"
 * 
 * @param val
 * @returns
 */
function toShow(val) {
	return trimNoth(val, "---");
}

//TODO 公用方法

var urlStack = [];
/**
 * 向前加载
 * 
 * @param url
 */
function goForward(url) {
	if (url != null) {
		urlStack.push(url);
		if (urlStack.length > 6) {
			urlStack.shift();
		}

		loadPage(url);

	}
}
/**
 * 返回
 */
function goBack() {
	if (urlStack == null || urlStack.length < 1) {
		alert("已返回到最后");
		return;
	}
	if (urlStack.length >= 2) {
		urlStack.pop();
		loadPage(urlStack[urlStack.length - 1]);
	} else {
		loadPage(urlStack[0]);
	}

}

function setRootPage(url) {
	if (url != null) {
		urlStack = [];
		urlStack.push(url);
		loadPage(url);
	}
}

function loadPage(url) {

	if (url == null) {
		alert("链接无效");
		return;
	}
	$('#basecontent').load(url);
}


//TODO 通用基本方法脚本


//请求模板方法
function rqstTemplete(){
	reqst("/oasm/task/init", "POST", {
		aa : "wwww",
		bb : "zzz"
	}, "Json", function(x, data) {
		alert("bf:" + data);
	}, function(x, data) {
		alert("onSuccess:" + data);
	}, function(x, data) {
		alert("complete:" + data);
	}
	, function(x, data) {
		alert("onError:" + data);
	});
}

/**
* 
* @param url
* @param rqstType
*            请求方式："POST"/"GET"
* @param rqstData
* @param respDataType
*            响应数据类型："xml", "html", "script", "json", "jsonp", "text"
* @param onBeforeSend
* @param onSuccess
* @param onComplete
* @param onError
*/
function reqst(url, rqstType, rqstData, respDataType, onBeforeSend, onSuccess,
		onComplete, onError) {
	$.ajax({
		type : rqstType, // POST GET
		url : url,
		data : rqstData,
		// "xml", "html", "script", "json", "jsonp", "text"
		dataType : respDataType,
		beforeSend : function(XMLHttpRequest, data) {
			if (onBeforeSend != null) {
				onBeforeSend(XMLHttpRequest, data);
			} else {
				console.info("post beforeSend, data:" + data);
			}
		},
		success : function(XMLHttpRequest, data) {
			if (onSuccess != null) {
				onSuccess(XMLHttpRequest, data);
			} else {
				console.info("post success, data:" + data);
			}
		},
		complete : function(XMLHttpRequest, data) {
			if (onComplete != null) {
				onComplete(XMLHttpRequest, data);
			} else {
				console.info("post complete");
			}
		},
		error : function(XMLHttpRequest, data) {
			if (onError != null) {
				onError(data);
			} else {
				console.error("post failed, data:" + data);
			}
		}
	});
}

/**
 * 格式化日期對象為字符串
 * @param date
 * @param format
 * @returns
 */
function formatDate(date, format) {
	if (!date)
		return;
	if (!format)
		format = "yyyy-MM-dd";
	switch (typeof date) {
	case "string":
		date = new Date(date.replace(/-/, "/"));
		break;
	case "number":
		date = new Date(date);
		break;
	}
	if (!date instanceof Date)
		return;
	var dict = {
		"yyyy" : date.getFullYear(),
		"M" : date.getMonth() + 1,
		"d" : date.getDate(),
		"H" : date.getHours(),
		"m" : date.getMinutes(),
		"s" : date.getSeconds(),
		"MM" : ("" + (date.getMonth() + 101)).substr(1),
		"dd" : ("" + (date.getDate() + 100)).substr(1),
		"HH" : ("" + (date.getHours() + 100)).substr(1),
		"mm" : ("" + (date.getMinutes() + 100)).substr(1),
		"ss" : ("" + (date.getSeconds() + 100)).substr(1)
	};
	return format.replace(/(yyyy|MM?|dd?|HH?|ss?|mm?)/g, function() {
		return dict[arguments[0]];
	});
}

/**
 * 将空白和null转化为指定值
 * 
 * @param val
 * @param replace
 * @returns
 */
function trimNoth(val, replace) {
	if (val == null || val.length == 0 || val.toLowerCase() == "null") {
		return replace;
	}
	return val;
}



/**
* 将json字符串转Json
* 
* @param JsonStr
* @returns
*/
function toJson(jsonStr) {
	return jQuery.parseJSON(jsonStr);
}