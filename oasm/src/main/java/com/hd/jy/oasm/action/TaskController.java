package com.hd.jy.oasm.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hd.jy.oasm.dao.ListLineMapper;
import com.hd.jy.oasm.domain.CodeName;
import com.hd.jy.oasm.domain.CrimCopRelat;
import com.hd.jy.oasm.services.TaskService;
import com.hd.jy.oasm.util.lsc.DataUtil;
import com.hd.jy.oasm.util.priv.C;
import com.hd.jy.oasm.util.priv.CT;

@Controller
@RequestMapping("task")
public class TaskController extends BasicController {

	@Autowired
	TaskService taskService;

	@Autowired
	ListLineMapper searcher;

	/**
	 * 请求接收中心
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/op", method = { RequestMethod.POST })
	public String handleTask(HttpServletRequest request,
			HttpServletResponse response) {
		initBasicTmp(false);

		Map<String, String> paramMap = simpleRqstParamMap(request);

		String currUsr = (String) subject().getPrincipal();

		logger().info("current usr：" + currUsr);
//		 if (currUsr == null) {
//			 return new Resp(status, msg, data)
//		 }

		paramMap.put(CT.SER_USR_NAME, currUsr);
		 
		String opCode = paramMap.get(CT.P_OP_CODE);
		if (DataUtil.isEmpty(opCode)) {
			logger().info("operating code not found...");
			return C.ERROR + CT.MSG_INVAL_RQST;
		}

		switch (opCode) {
		case CT.OPV_GET_CRIM_COP_INFO:
			return taskService.getCrimCopInfo(paramMap);

		case CT.OPV_INIT_WEB:
			return "OPV_INIT_WEB";

		case CT.OPV_TASK_ADD:
			return taskService.addTask(paramMap);

		case CT.OPV_TASK_UPDATE:
			return taskService.updateStatus(paramMap);

		case CT.OPV_TASK_CANCEL:
			return "";
			
		case CT.OPV_TASK_GET_TODO:
			return taskService.getTaskToDo(paramMap);

		case CT.OPV_TASK_GET_LIST:
			return taskService.getTaskList(paramMap);

		case CT.OPV_TASK_GET_LIST_BY_LIKE:
			return taskService.getTaskListWithTypeLike(paramMap);

		case CT.OPV_TEST_SAVE:
			return taskService.saveTestNote(paramMap);

		case CT.OPV_TEST_QUERY:
			return taskService.getTestNote(paramMap);

		default:
			logger().info("invalid operating code: " + opCode);
			return CT.MSG_INVAL_RQST;
		}
	}

	public static class InitData {
		private String account;// 账号
		private String name;// 用户名
		private String role;// 角色
		private String auth;// authority

		public InitData() {

		}

		public InitData(String account, String name, String role, String auth) {
			this.account = account;
			this.name = name;
			this.role = role;
			this.auth = auth;
		}

		public String getAccount() {
			return account;
		}

		public void setAccount(String account) {
			this.account = account;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		public String getAuth() {
			return auth;
		}

		public void setAuth(String auth) {
			this.auth = auth;
		}
	}

	public static class BasicTmp {
		public static final HashMap<String, String> crimCodeNames = new HashMap<String, String>();
		public static final HashMap<String, String> copCodeNames = new HashMap<String, String>();
		public static final HashMap<String, String> crimCop1Codes = new HashMap<String, String>();
		public static final HashMap<String, String> crimCop2Codes = new HashMap<String, String>();
		public static final HashMap<String, TreeSet<String>> cop1CrimCodes = new HashMap<String, TreeSet<String>>();
		public static final HashMap<String, TreeSet<String>> cop2CrimCodes = new HashMap<String, TreeSet<String>>();

		public static boolean toInit = true;
	}

	/**
	 * 常用信息缓存
	 * 
	 * @param forceInit
	 *            是否强制刷新
	 */
	private void initBasicTmp(boolean forceInit) {
		if (!forceInit && !BasicTmp.toInit && BasicTmp.crimCodeNames != null) {
			return;
		}

		ArrayList<CodeName> crimCodeNameList = searcher.getCrimCodeName();
		for (CodeName ele : crimCodeNameList) {
			if (ele == null) {
				continue;
			}
			BasicTmp.crimCodeNames.put(ele.getCode(), ele.getName());
		}

		ArrayList<CodeName> copCodeNameList = searcher.getCopCodeName();
		for (CodeName ele : copCodeNameList) {
			if (ele == null) {
				continue;
			}
			BasicTmp.copCodeNames.put(ele.getCode(), ele.getName());
		}

		ArrayList<CrimCopRelat> crimCopRelatList = searcher.getCopCodeRelat();

		TreeSet<String> set;
		for (CrimCopRelat ele : crimCopRelatList) {
			if (ele == null) {
				continue;
			}

			BasicTmp.crimCop1Codes.put(ele.getCrimCode(), ele.getCop1Code());
			BasicTmp.crimCop2Codes.put(ele.getCrimCode(), ele.getCop2Code());
			set = BasicTmp.cop1CrimCodes.get(ele.getCop1Code());
			if (set == null) {
				set = new TreeSet<String>();
				BasicTmp.cop1CrimCodes.put(ele.getCop1Code(), set);
			}
			set.add(ele.getCrimCode());

			set = BasicTmp.cop2CrimCodes.get(ele.getCop2Code());
			if (set == null) {
				set = new TreeSet<String>();
				BasicTmp.cop2CrimCodes.put(ele.getCop2Code(), set);
			}
			set.add(ele.getCrimCode());
		}

		BasicTmp.toInit = false;
	}

}
