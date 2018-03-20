package com.hd.jy.oasm.util.priv;

/**
 * 本项目特有常量
 * 
 * @author admin
 */
public class CT {

	/** 用户名键名 */
	public static final String SER_USR_NAME = "username";
	/** 用户ID键名 */
	public static final String SER_USR_ID = "username";

	// 请求参数 request param key
	/** 任务类型 */
	public static final String P_TASK_TYPE = "taskType";
	/** 任务ID */
	public static final String P_TASK_ID = "taskId";
	/** 监区 */
	public static final String P_PRISON = "prison";
	/** 囚号 */
	public static final String P_CRIM_NO = "crimNo";
	/** 囚犯姓名 */
	public static final String P_CRIM_NAME = "crimName";
	/** 警察信息搜索范围:所有all,专管zg/协管xg/任务人警号zxr */
	public static final String P_COP_RANGE = "copRange";
	/** 警号 */
	public static final String P_COP_NO = "copNo";
	/** 警名 */
	public static final String P_COP_NAME = "copName";
	/** 任务执行人 */
	public static final String P_EXCUTOR = "excutor";
	/** 任务创建人 */
	public static final String P_CREATOR = "creator";
	/** 任务创建时间范围起始 */
	public static final String P_CR_TIME_START = "crTimeStart";
	/** 任务创建时间范围结束 */
	public static final String P_CR_TIME_END = "crTimeEnd";
	/** 任务完成时间范围结束 */
	public static final String P_DEADLINE_START = "deadlineStart";
	/** 任务完成时间范围结束 */
	public static final String P_DEADLINE_END = "deadlineEnd";
	/** 任务修改时间范围起始 */
	public static final String P_LAST_MODIF_START = "lastModifStart";
	/** 任务修改时间范围起始 */
	public static final String P_LAST_MODIF_END = "lastModifEnd";
	/** 任务状态 */
	public static final String P_STATUS = "status";
	/** 任务依据 */
	public static final String P_TASK_BASIS = "taskBasis";
	/** 任务内容/描述 */
	public static final String P_TASK_DESCRIB = "taskDescrib";
	/** 任务完成期限 */
	public static final String P_DEADLINE = "deadline";
	/** 任务创建时间 */
	public static final String P_CR_TIME = "crTime";
	/** 任务最后修改时间 */
	public static final String P_LAST_MODIF = "lastModif";
	/** 任务执行人 */
	public static final String P_MODIFIER = "modifier";
	/** 测试选择答案 */
	public static final String P_ANSWER = "answer";
	/** 测试总成绩 */
	public static final String P_SCORE = "score";
	/** 测试等级 */
	public static final String P_LEVEL = "level";
	/** 测试报告 */
	public static final String P_RESULT = "result";
	/** 操作代号键名 */
	public static final String P_OP_CODE = "op";// operation

	// TODO 操作码
	
	
	/**获取囚犯警员关系信息*/
	public static final String  OPV_GET_CRIM_COP_INFO= "crimCopInfo";
	/**更新前端权限信息等*/
	public static final String OPV_INIT_WEB = "initWeb";
	/** 添加任务 */
	public static final String OPV_TASK_ADD = "taskAdd";
	/** 更新任务状态 */
	public static final String OPV_TASK_UPDATE = "taskUpdate";
	/** 取消任务 */
	public static final String OPV_TASK_CANCEL = "taskCancel";
	/** 获取任务/记录列表 */
	public static final String OPV_TASK_GET_LIST = "taskGetList";
	/** 获取任务/记录列表 */
	public static final String OPV_TASK_GET_TODO = "taskGetTodo";
	/** 根据任务类型匹配，获取任务/记录列表 */
	public static final String OPV_TASK_GET_LIST_BY_LIKE = "taskGetListByTypeLike";
	/** 保存测试做题记录 */
	public static final String OPV_TEST_SAVE = "testSave";
	/** 获取测试做题记录（含成绩和报告） */
	public static final String OPV_TEST_QUERY = "testQuery";

	/** 警察信息搜索范围：所有 */
	public static final String COP_RANGE_ALL = "all";
	/** 警察信息搜索范围：专管 */
	public static final String COP_RANGE_ZG = "zg";
	/** 警察信息搜索范围：协管 */
	public static final String COP_RANGE_XG = "xg";
	/** 警察信息搜索范围：任务执行人modifier */
	public static final String COP_RANGE_ZXR = "zxr";

	// TODO 任务状态码

	/** 任务不存在 */
	public static final int TS_NULL = -100;
	/** 任务草稿(未发布的任务,可编辑,scratch file ) */
	public static final int TS_SCR = -1;// scratch file
	/** 新增的任务 */
	public static final int TS_NEW = 1;
	/** 处理中的任务 */
	public static final int TS_PEOCESSING = 2;// processing center
	/** 暂存的任务 */
	public static final int TS_SAVED = 3;// processing center
	/** 完成的任务 */
	public static final int TS_FINISHED = 4;
	/** 取消的任务 */
	public static final int TS_CANCELED = 10;

	private static final String TN_NULL = "任务不存在";
	/** 任务草稿(未发布的任务,可编辑,scratch file ) */
	private static final String TN_SCR = "未发布";// scratch file
	/** 新增的任务 */
	private static final String TN_NEW = "未开始";
	/** 处理中的任务 */
	private static final String TN_PEOCESSING = "处理中";
	/** 暂存/未完成的任务 */
	private static final String TN_SAVED = "未完成";
	/** 完成的任务 */
	private static final String TN_FINISHED = "已完成";
	/** 取消的任务 */
	private static final String TN_CANCELED = "已取消";
	/** 未知的任务状态 */
	private static final String TN_UNKNOWN = "未知";

	/**
	 * 获取状态码对应中文状态名称
	 * 
	 * @param status
	 *            状态码CT.TASK_*
	 * @return
	 */
	public static String taskStatusName(int status) {
		switch (status) {

		case TS_NEW:
			return TN_NEW;

		case TS_PEOCESSING:
			return TN_PEOCESSING;

		case TS_SAVED:
			return TN_SAVED;

		case TS_FINISHED:
			return TN_FINISHED;

		case TS_CANCELED:
			return TN_CANCELED;

		case TS_NULL:
			return TN_NULL;

		case TS_SCR:
			return TN_SCR;

		default:
			return TN_UNKNOWN;
		}
	}

	//评估报告各部分测试类型
	/**档案分析*/
	public static final String PG_DAFX = "DAFX";
	/**行为观察*/
	public static final String PG_XWGC = "XWGC";
	/**个体访谈*/
	public static final String PG_GTFT = "GTFT";
	/**集体访谈*/
	public static final String PG_JTFT = "JTFT";
	/**SCL-90心理测试*/
	public static final String PG_XLSCL90 = "XLSCL90";
	/**COPA-PI心理测试*/
	public static final String PG_XLCOPAPI = "XLCOPAPI";
	/**入监心理测试*/
	public static final String PG_XLRJ = "XLRJ";
	/**出监心理测试，社会适应性心理测试*/
	public static final String PG_XLCJ = "XLCJ";
	
	
	
	
	
	
	
	// TODO 常用信息
	/** 无效的请求，操作码为空或不存在 */
	public static final String MSG_INVAL_RQST = "请求无效";// "无效的请求"
	/** 无效的任务ID，为空或不存在 */
	public static final String MSG_INVAL_TASK_ID = "任务ID无效";
	/** 无效的状态码，为空或不存在或非整型 */
	public static final String MSG_INVAL_STATUS_CODE = "状态码无效";
	/** 用户名为空，未登录 */
	public static final String MSG_TO_LOGIN = "请先登录";
}
