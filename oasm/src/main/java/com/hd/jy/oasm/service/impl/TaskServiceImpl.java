package com.hd.jy.oasm.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hd.jy.oasm.action.TaskController.BasicTmp;
import com.hd.jy.oasm.annotation.DataSource;
import com.hd.jy.oasm.dao.ListLineMapper;
import com.hd.jy.oasm.dao.TaskMapper;
import com.hd.jy.oasm.dao.TestMapper;
import com.hd.jy.oasm.domain.BGwxlx;
import com.hd.jy.oasm.domain.CrimCopInfo;
import com.hd.jy.oasm.domain.ListLine;
import com.hd.jy.oasm.domain.SearchElement;
import com.hd.jy.oasm.domain.Task;
import com.hd.jy.oasm.domain.TaskRelat;
import com.hd.jy.oasm.domain.TestNote;
import com.hd.jy.oasm.model.CopaResult;
import com.hd.jy.oasm.model.Resp;
import com.hd.jy.oasm.model.SCL90Result;
import com.hd.jy.oasm.model.ScoreMap;
import com.hd.jy.oasm.model.TestNoteOut;
import com.hd.jy.oasm.module.CopaIdxHandler;
import com.hd.jy.oasm.module.CopaTestHandler;
import com.hd.jy.oasm.module.PgXlHandler;
import com.hd.jy.oasm.module.SCL90TestHandler;
import com.hd.jy.oasm.services.TaskService;
import com.hd.jy.oasm.util.Page;
import com.hd.jy.oasm.util.PageHelper;
import com.hd.jy.oasm.util.lsc.DataUtil;
import com.hd.jy.oasm.util.lsc.GsonUtil;
import com.hd.jy.oasm.util.lsc.ReflectUtil;
import com.hd.jy.oasm.util.lsc.basicmodel.BasicModel;
import com.hd.jy.oasm.util.lsc.date.DateUtil;
import com.hd.jy.oasm.util.lsc.excpts.NullException;
import com.hd.jy.oasm.util.priv.C;
import com.hd.jy.oasm.util.priv.CT;
import com.hd.jy.oasm.util.priv.PGPart;
import com.hd.jy.oasm.util.priv.TaskType;

/**
 * 
 * @ClassName: TaskServiceImpl 
 * @Description: 公用业务逻辑处理 
 * @author lsc
 * 
 */
@Service("taskServiceImpl")
@DataSource("userDataSource")
public class TaskServiceImpl implements TaskService {
	private Logger logger = Logger.getLogger(TaskServiceImpl.class);

	@Autowired
	TaskMapper taskMapper;
	@Autowired
	ListLineMapper listLineMapper;
	@Autowired
	TestMapper testMapper;

	@Override
	public String addTask(Map<String, String> paramMap) {

		String msg = "";
		String crimNosStr = paramMap.get(CT.P_CRIM_NO);
		String[] crimNos;

		if (crimNosStr == null || (crimNos = crimNosStr.split(";")).length == 0) {
			msg = "囚号不能为空";
			logger.info(msg);
			return msg;
		}

		ArrayList<Task> taskList = new ArrayList<Task>();
		ArrayList<TaskRelat> taskRelatList = new ArrayList<TaskRelat>();
		for (String crimNo : crimNos) {
			if (DataUtil.isEmpty(crimNo)) {
				continue;
			}

			Task task = new Task();
			// task.setTaskId();
			task.setCrimNo(crimNo);
			task.setType(paramMap.get(CT.P_TASK_TYPE));
			task.setTaskBasis(paramMap.get(CT.P_TASK_BASIS));
			task.setTaskDescrib(paramMap.get(CT.P_TASK_DESCRIB));
			task.setDeadline(paramMap.get(CT.P_DEADLINE));

			String taskExcutor = paramMap.get(CT.P_EXCUTOR);
			if (DataUtil.isNothing(taskExcutor)) {
				// 默认设置专管警察作为任务执行人
				task.setCopNo1(BasicTmp.crimCop1Codes.get(crimNo));
			} else {
				String[] excutors = taskExcutor.split(";");
				if (excutors.length > 2) {
					return "任务执行人不能超过2个";
				}
				task.setCopNo1(excutors[0]);

				if (excutors.length > 1) {
					task.setCopNo2(excutors[1]);
				}
			}

			task.setCreator(paramMap.get(CT.SER_USR_NAME));
			task.setCreateTime(currDateTime());
			task.setLastModif(currDateTime());
			// task.setModifier();
			task.setStatus(CT.TS_NEW);
			task.createTaskId();// 创建任务id

			String nullField = task.getNullField(paramMap.get(CT.P_OP_CODE));
			if (!DataUtil.isNothing(nullField)) {
				logger.info(nullField + " is null");
				return nullField + "不能为空";
			}

			// 添加父任务
			putTask(taskList, task);

			String DAFX;// 档案分析
			String XWGC;// 行为观察
			String GTFT;// 个体结构性访谈
			String JTFT;// 集体访谈
			String XLSCL90;// scl90心理测试
			String XLCOPAPI;// copapPi心理测试
			String XLRJ;// 入监心理测试
			String XLCJ;// 社会适应性心理测试，出监评估报告才有

			// 添加子任务
			if (TaskType.IN_REPORT.equals(task.getType())) {
				DAFX = null;
				XWGC = null;
				GTFT = null;
				JTFT = null;
				XLSCL90 = null;
				XLCOPAPI = null;
				XLRJ = null;
				XLCJ = null;

				XWGC = putTask(taskList, mkChildTask(task, TaskType.IN_ACTION));
				GTFT = putTask(taskList, mkChildTask(task, TaskType.IN_TALK));
				XLSCL90 = putTask(taskList,
						mkChildTask(task, TaskType.MT_SCL90));
				XLCOPAPI = putTask(taskList,
						mkChildTask(task, TaskType.MT_COPA_PI));
				XLRJ = putTask(taskList,
						mkChildTask(task, TaskType.IN_MENTAL_TEST));

				putTaskRelat(taskRelatList, task.getTaskId(), PGPart.DAFX, DAFX);
				putTaskRelat(taskRelatList, task.getTaskId(), PGPart.XWGC, XWGC);
				putTaskRelat(taskRelatList, task.getTaskId(), PGPart.GTFT, GTFT);
				putTaskRelat(taskRelatList, task.getTaskId(), PGPart.JTFT, JTFT);
				putTaskRelat(taskRelatList, task.getTaskId(), PGPart.XLSCL90,
						XLSCL90);
				putTaskRelat(taskRelatList, task.getTaskId(), PGPart.XLCOPAPI,
						XLCOPAPI);
				putTaskRelat(taskRelatList, task.getTaskId(), PGPart.XLRJ, XLRJ);

			} else if (TaskType.DAILY_REPORT.equals(task.getType())) {

				DAFX = null;
				XWGC = null;
				GTFT = null;
				JTFT = null;
				XLSCL90 = null;
				XLCOPAPI = null;
				XLRJ = null;
				XLCJ = null;

				XWGC = putTask(taskList,
						mkChildTask(task, TaskType.DAILY_ACTION));

				putTaskRelat(taskRelatList, task.getTaskId(), PGPart.DAFX, DAFX);
				putTaskRelat(taskRelatList, task.getTaskId(), PGPart.XWGC, XWGC);
				putTaskRelat(taskRelatList, task.getTaskId(), PGPart.GTFT, GTFT);
				putTaskRelat(taskRelatList, task.getTaskId(), PGPart.JTFT, JTFT);
				putTaskRelat(taskRelatList, task.getTaskId(), PGPart.XLSCL90,
						XLSCL90);
				putTaskRelat(taskRelatList, task.getTaskId(), PGPart.XLCOPAPI,
						XLCOPAPI);
				putTaskRelat(taskRelatList, task.getTaskId(), PGPart.XLRJ, XLRJ);
				putTaskRelat(taskRelatList, task.getTaskId(), PGPart.XLCJ, XLCJ);

			} else if (TaskType.MID_REPORT.equals(task.getType())) {

				DAFX = null;
				XWGC = null;
				GTFT = null;
				JTFT = null;
				XLSCL90 = null;
				XLCOPAPI = null;
				XLRJ = null;
				XLCJ = null;

				XWGC = putTask(taskList, mkChildTask(task, TaskType.MID_ACTION));
				GTFT = putTask(taskList, mkChildTask(task, TaskType.MID_TALK));
				XLSCL90 = putTask(taskList,
						mkChildTask(task, TaskType.MT_SCL90));
				XLCOPAPI = putTask(taskList,
						mkChildTask(task, TaskType.MT_COPA_PI));

				putTaskRelat(taskRelatList, task.getTaskId(), PGPart.DAFX, DAFX);
				putTaskRelat(taskRelatList, task.getTaskId(), PGPart.XWGC, XWGC);
				putTaskRelat(taskRelatList, task.getTaskId(), PGPart.GTFT, GTFT);
				putTaskRelat(taskRelatList, task.getTaskId(), PGPart.JTFT, JTFT);
				putTaskRelat(taskRelatList, task.getTaskId(), PGPart.XLSCL90,
						XLSCL90);
				putTaskRelat(taskRelatList, task.getTaskId(), PGPart.XLCOPAPI,
						XLCOPAPI);
				putTaskRelat(taskRelatList, task.getTaskId(), PGPart.XLRJ, XLRJ);
				putTaskRelat(taskRelatList, task.getTaskId(), PGPart.XLCJ, XLCJ);

			} else if (TaskType.OUT_REPORT.equals(task.getType())) {

				DAFX = null;
				XWGC = null;
				GTFT = null;
				JTFT = null;
				XLSCL90 = null;
				XLCOPAPI = null;
				XLRJ = null;
				XLCJ = null;

				XWGC = putTask(taskList, mkChildTask(task, TaskType.OUT_ACTION));
				GTFT = putTask(taskList, mkChildTask(task, TaskType.OUT_TALK));

				XLSCL90 = putTask(taskList,
						mkChildTask(task, TaskType.MT_SCL90));
				XLCOPAPI = putTask(taskList,
						mkChildTask(task, TaskType.MT_COPA_PI));
				XLCJ = putTask(taskList,
						mkChildTask(task, TaskType.OUT_MENTAL_TEST));

				putTaskRelat(taskRelatList, task.getTaskId(), PGPart.DAFX, DAFX);
				putTaskRelat(taskRelatList, task.getTaskId(), PGPart.XWGC, XWGC);
				putTaskRelat(taskRelatList, task.getTaskId(), PGPart.GTFT, GTFT);
				putTaskRelat(taskRelatList, task.getTaskId(), PGPart.JTFT, JTFT);
				putTaskRelat(taskRelatList, task.getTaskId(), PGPart.XLSCL90,
						XLSCL90);
				putTaskRelat(taskRelatList, task.getTaskId(), PGPart.XLCOPAPI,
						XLCOPAPI);
				putTaskRelat(taskRelatList, task.getTaskId(), PGPart.XLRJ, XLRJ);
				putTaskRelat(taskRelatList, task.getTaskId(), PGPart.XLCJ, XLCJ);
			}
		}
		int taskAdded = -1;
		int taskRelatAdded = -1;
		try {
			// 批量发布任务
			logger.info("添加任务：" + taskList);
			taskAdded = taskMapper.batchAddTask(taskList);
			logger.info("任务数量：" + taskList.size() + ", 添加任务数量：" + taskAdded);
			// 建立父子任务关系索引
			if (taskRelatList.size() > 0) {
				logger.info("添加父子任务关系：" + taskRelatList);
				taskRelatAdded = taskMapper.batchAddTaskRelat(taskRelatList);
				logger.info("父子任务关系数量：" + taskRelatList.size()
						+ ", 添加父子任务关系数量：" + taskRelatAdded);
			}

			buildTaskRelat();
			return (taskList.size() == taskAdded && taskRelatList.size() == taskRelatAdded) ? "添加成功"
					: "添加失败";
		} catch (Exception e) {
			// duplicate
			msg = e.getMessage();
			if (msg.contains("重复") || msg.toLowerCase().contains("duplic")) {
				msg = "相同类型任务已存在，禁止频繁添加";
				logger.error(msg + "（主键重复）。任务内容：" + taskList);
			} else {
				msg = "添加任务失败";
				logger.error(msg + "。任务内容：" + taskList, e);
			}
			return msg;
		}
	}

	private void buildTaskRelat() {
		com.hd.jy.oasm.util.lsc.ThreadUtil.singleThreadExecute(new Runnable() {
			@Override
			public void run() {
				ArrayList<TaskRelat> list = taskMapper.getChildNullTaskRelat();
				logger.info("子任务为空的父子关系列表：" + list);

				for (TaskRelat relat : list) {
					String crimNo = relat.getParentId().split("_")[0];
					logger.info("囚号：" + crimNo + ", 类型：" + relat.getChildType());
					logger.info(taskMapper.findChildTaskId(relat.getParentId(),
							crimNo, relat.getChildType()));
				}
			}
		});
	}

	/**
	 * @param taskList
	 * @param task
	 * @return 返回任务ID
	 */
	private void putTaskRelat(ArrayList<TaskRelat> taskRelatList,
			String parentId, String childType, String childId) {
		if (taskRelatList == null || parentId == null || childType == null) {
			throw new NullException("taskRelatList or parentId or childType",
					"");
		}
		taskRelatList.add(new TaskRelat(parentId, childType, childId));
	}

	/**
	 * @param taskList
	 * @param task
	 * @return 返回任务ID
	 */
	private String putTask(ArrayList<Task> taskList, Task task) {
		if (taskList == null || task == null) {
			return null;
		}
		taskList.add(task);
		return task.getTaskId();
	}

	public Task mkChildTask(Task parent, String childType) {
		if (parent == null || childType == null) {
			throw new NullException("parent and childType");
		}

		Task child = new Task();

		// child.setTaskId();
		child.setCrimNo(parent.getCrimNo());
		child.setType(childType);
		child.setTaskBasis(parent.getTaskBasis());
		child.setTaskDescrib(parent.getTaskDescrib());
		child.setDeadline(parent.getDeadline());
		child.setCopNo1(parent.getCopNo1());
		child.setCopNo2(parent.getCopNo2());
		child.setCreator(parent.getCreator());
		child.setCreateTime(parent.getCreateTime());
		child.setLastModif(parent.getLastModif());
		child.setModifier(parent.getModifier());
		child.setStatus(parent.getStatus());
		child.createTaskId();// 创建任务id

		return child;
	}

	@Override
	public String updateStatus(Map<String, String> paramMap) {
		String msg;

		int status = DataUtil.toInt(paramMap.get(CT.P_STATUS), CT.TS_NULL);
		String taskIdPart = "。任务ID：" + paramMap.get(CT.P_TASK_ID);
		String currStatusStr = taskMapper
				.currStatus(paramMap.get(CT.P_TASK_ID));

		int currStatus;
		if (currStatusStr == null) {
			msg = "任务不存在";
			logger.info(msg + taskIdPart);
			return msg;

		} else {
			currStatus = DataUtil.toInt(currStatusStr);
		}

		if (currStatus == CT.TS_FINISHED) {
			return "任务已是完成状态，不能再修改";
		}

		if (currStatus > status) {
			msg = "修改任务状态失败：不能将任务状态从[" + CT.taskStatusName(currStatus)
					+ "]转换为[" + CT.taskStatusName(status) + "]";
			logger.info(msg + taskIdPart);
			return msg;
		}

		logger.info("更新任务状态：" + CT.taskStatusName(currStatus) + "==>"
				+ CT.taskStatusName(status) + taskIdPart);

		Task task = new Task();

		task.setTaskId(paramMap.get(CT.P_TASK_ID));
		task.setModifier(paramMap.get(CT.SER_USR_NAME));
		task.setLastModif(currDateTime());
		task.setStatus(status);

		int effect = taskMapper.updateStatus(task);
		if (effect == 1) {
			msg = "成功修改任务状态为：" + CT.taskStatusName(task.getStatus());
		} else {
			msg = "修改任务状态异常， 影响信息条数：" + effect;
		}

		logger.debug("返回前端的数据:" + msg + taskIdPart);
		return msg;
	}

	@Override
	public String cancelTask(Map<String, String> paramMap) {
		paramMap.put(CT.P_STATUS, CT.TS_CANCELED + "");
		return updateStatus(paramMap);
	}

	/**
	 * 获取待办任务
	 */
	@Override
	public String getTaskToDo(Map<String, String> paramMap) {
		SearchElement se;
		try {
			se = ReflectUtil.toInstance(paramMap, SearchElement.class);
		} catch (Exception e) {
			logger.info("参数反射赋值异常", e);
			return errorMsg("参数反射赋值异常," + e.getMessage());
		}
		int pageNum = Integer.parseInt(paramMap.get("num"));// 当前页
		int pageSize = Integer.parseInt(paramMap.get("size"));// 每页显示数量
		PageHelper.startPage(pageNum, pageSize);
		ArrayList<ListLine> list = listLineMapper.getTaskToDo(se);
		Page<?> page = PageHelper.endPage();
		logger.debug("返回前端的page数据:" + page);
		for (ListLine line : list) {
			line.setCrimName(BasicTmp.crimCodeNames.get(line.getCrimNo()));
			line.setCop1Name(BasicTmp.copCodeNames.get(line.getCop1No()));
			line.setCop2Name(BasicTmp.copCodeNames.get(line.getCop2No()));
			line.setCreatorName(BasicTmp.copCodeNames.get(line.getCreatorNo()));
			line.setModifierName(BasicTmp.copCodeNames.get(line.getModifierNo()));

			line.setStatusName(CT.taskStatusName(DataUtil.toInt(line
					.getStatus())));
			line.setTaskType(TaskType.getName(line.getTaskType()));

		}
		String json = new Resp(200, "获取代办任务成功", list, page).toJson();
		logger.debug("返回前端的数据:" + json);
		return json;
	}

	@Override
	public String getTaskList(Map<String, String> paramMap) {
		SearchElement se;
		try {
			se = ReflectUtil.toInstance(paramMap, SearchElement.class);
		} catch (Exception e) {
			logger.info("参数反射赋值异常", e);
			return errorMsg("参数反射赋值异常," + e.getMessage());
		}
		Map<String, Object> map = new HashMap<String, Object>();
		// 分页
		PageHelper.startPage(DataUtil.toInt(paramMap.get("pageNum")),
				DataUtil.toInt(paramMap.get("pageSize")));
		List<ListLine> list = listLineMapper.getList(se);
		Page<?> page = PageHelper.endPage();

		if (list == null) {
			return "";
		}

		for (ListLine line : list) {
			line.setCrimName(BasicTmp.crimCodeNames.get(line.getCrimNo()));
			line.setCop1Name(BasicTmp.copCodeNames.get(line.getCop1No()));
			line.setCop2Name(BasicTmp.copCodeNames.get(line.getCop2No()));
			line.setCreatorName(BasicTmp.copCodeNames.get(line.getCreatorNo()));
			line.setModifierName(BasicTmp.copCodeNames.get(line.getModifierNo()));

			line.setStatusName(CT.taskStatusName(DataUtil.toInt(line
					.getStatus())));
			line.setTaskType(TaskType.getName(line.getTaskType()));
		}
		map.put("list", list);
		map.put("page", page);
		String json = GsonUtil.toJson(map);
		logger.debug("返回前端的数据:" + json);

		return json;
	}

	@Override
	public String getTaskListWithTypeLike(Map<String, String> paramMap) {
		SearchElement se;
		try {
			se = ReflectUtil.toInstance(paramMap, SearchElement.class);
		} catch (Exception e) {
			logger.info("参数反射赋值异常", e);
			return errorMsg("参数反射赋值异常," + e.getMessage());
		}

		ArrayList<ListLine> list = listLineMapper.getListWithTypeLike(se);
		if (list == null) {
			return "";
		}
		for (ListLine line : list) {
			line.setCrimName(BasicTmp.crimCodeNames.get(line.getCrimNo()));
			line.setCop1Name(BasicTmp.copCodeNames.get(line.getCop1No()));
			line.setCop2Name(BasicTmp.copCodeNames.get(line.getCop2No()));
			line.setCreatorName(BasicTmp.copCodeNames.get(line.getCreatorNo()));
			line.setModifierName(BasicTmp.copCodeNames.get(line.getModifierNo()));

			line.setStatusName(CT.taskStatusName(DataUtil.toInt(line
					.getStatus())));
			line.setTaskType(TaskType.getName(line.getTaskType()));

		}

		String json = GsonUtil.toJson(list);
		logger.debug("返回前端的数据:" + json);

		return json;
	}

	@Override
	public String saveTestNote(Map<String, String> paramMap) {

		TestNote tn = new TestNote();
		tn.setTaskId(paramMap.get(CT.P_TASK_ID));
		tn.setAnswer(paramMap.get(CT.P_ANSWER));
		if (tn.getTaskId() == null) {
			return errorMsg("保存失败：任务ID为空");
		}

		if (tn.getAnswer() == null) {
			return errorMsg("保存失败：没有要保存的内容");
		}

		try {
			tn.setAnswer(GsonUtil.toJsonArray(tn.getAnswer()).toString());
		} catch (Exception e) {
			return errorMsg("保存失败：提交的答案格式有误");
		}

		if (DataUtil.toInt(paramMap.get(CT.P_STATUS), CT.TS_NULL) == CT.TS_FINISHED) {
			ArrayList<Answer> list = GsonUtil.toList(tn.getAnswer(),
					Answer.class);
			ScoreMap scoreMap = new ScoreMap();
			for (Answer as : list) {
				scoreMap.addScore(as.getName().replaceAll("sclq|copaq", ""),
						DataUtil.toDouble(as.getVal()));
			}

			if (tn.getTaskId().contains(TaskType.MT_SCL90)) {
				SCL90Result rs = SCL90TestHandler.handle(scoreMap);

				tn.setScore(rs.getTotal());
				tn.setLevl(rs.getTotalYinYang());
				tn.setResult(GsonUtil.toJson(rs));
				logger.info("批量插入SCL90心理测试评估报告分析结果");
				listLineMapper.batchAddPgXlcsJg(SCL90TestHandler.toPgXlcsJg(
						tn.getTaskId(), tn.getTaskId().split("_")[0], rs));

			} else if (tn.getTaskId().contains(TaskType.MT_COPA_PI)) {
				CopaResult rs = CopaTestHandler.handle(scoreMap);
				tn.setScore(rs.getLczbh());
				if (rs.getDimResultMap().get(CopaIdxHandler.D_L).getTVal() > 3
						|| rs.getDimResultMap().get(CopaIdxHandler.D_S)
								.getTVal() > 2) {
					tn.setLevl("认真指标或说谎指标不可完全接受");
					paramMap.put(CT.P_STATUS, CT.TS_SAVED + "");
				}
				tn.setResult(GsonUtil.toJson(rs));
				logger.info("批量插入Copa-PI心理测试评估报告分析结果");
				listLineMapper.batchAddPgXlcsJg(CopaTestHandler.toPgXlcsJg(
						tn.getTaskId(), tn.getTaskId().split("_")[0], rs));

				//makeWxxpgFs(tn.getTaskId().split("_")[0], rs);

			} else {
				logger.warn("未知类型的任务：" + tn);
			}
		}

		logger.info("要保存的信息：" + tn);
		int effect = testMapper.saveNote(tn);
		if (effect == 0) {
			return "保存失败";
		}

		String msg = updateStatus(paramMap);
		makePgWxLx(tn.getTaskId());

		if (!msg.contains("成功")) {
			return errorMsg("保存失败:修改任务状态失败——" + msg);
		} else {
			return "保存成功";
		}
	}

	@Override
	public String getTestNote(Map<String, String> paramMap) {
		String taskId = paramMap.get(CT.P_TASK_ID);
		if (taskId == null) {
			return nothing();
		}

		TestNote tn = testMapper.getNote(taskId);
		if (tn == null) {
			return nothing();
		}

		TestNoteOut tnOut = new TestNoteOut();
		tnOut.setTaskId(tn.getTaskId());
		tnOut.setScore(tn.getScore());
		tnOut.setLevl(tn.getLevl());
		if (!DataUtil.isEmpty(tn.getAnswer())) {
			tnOut.setAnswer(GsonUtil.toJsonArray(tn.getAnswer()));
		}

		if (!DataUtil.isEmpty(tn.getAnswer())) {
			tnOut.setResult(GsonUtil.toJsonObject(tn.getResult()));
		}

		String json = GsonUtil.toJson(tnOut);
		logger.debug("返回前端的数据:" + json);
		return json;
	}

	/**
	 * 获取发布任务用的囚犯警察信息列表
	 * 
	 * @return
	 */
	@Override
	public String getCrimCopInfo(Map<String, String> paramMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		PageHelper.startPage(DataUtil.toInt(paramMap.get("pageNum")),
				DataUtil.toInt(paramMap.get("pageSize")));
		SearchElement se;
		try {
			se = ReflectUtil.toInstance(paramMap, SearchElement.class);
		} catch (Exception e) {
			logger.info("参数反射赋值异常", e);
			return errorMsg("参数反射赋值异常," + e.getMessage());
		}
		
		List<CrimCopInfo> info = taskMapper.getCrimCopInfo(se);
		// String json = GsonUtil.toJson(taskMapper.getCrimCopInfo("prison",
		// "stage"));;
		Page<?> page = PageHelper.endPage();
		map.put("info", info);
		map.put("page", page);
		String json = GsonUtil.toJson(map);
		logger.debug("返回前端的数据:" + json);
		return json;
	}
	
	/**
	 * 评估报告危险类型倾向分析
	 * 
	 * @param taskId
	 */
	public void makePgWxLx(String taskId) {
		logger.info("检查是否需要生成危险类型倾向分析结果...");

		List<String> parentTaskIds = taskMapper.getParentTaskIds(taskId);
		for (String parentTaskId : parentTaskIds) {
			List<TaskRelat> childsList = taskMapper
					.getChildTaskIdByParent(parentTaskId);

			String scl90Id = null;
			String copaId = null;
			for (TaskRelat relat : childsList) {
				if (PGPart.XLSCL90.equals(relat.getChildType())) {
					scl90Id = relat.getChildId();
				}

				if (PGPart.XLCOPAPI.equals(relat.getChildType())) {
					copaId = relat.getChildId();
				}
			}

			if (scl90Id == null || copaId == null) {
				return;
			}

			logger.info("获取心里测试：" + scl90Id + "和" + scl90Id + "的测试报告...");
			TestNote scl09TestNote = testMapper.getNote(scl90Id);
			TestNote copaTestNote = testMapper.getNote(copaId);

			if (scl09TestNote == null || scl09TestNote.getResult() == null
					|| copaTestNote == null || copaTestNote.getResult() == null) {
				logger.info("评估报告[" + parentTaskIds + "]对应的心里测试：" + scl90Id
						+ "或" + scl90Id + "的测试报告为空");
				return;
			}

			try {
				List<BGwxlx> list = testMapper.getWxlxReport(parentTaskId);
				if (list != null && list.size() > 0) {
					logger.error("评估报告[" + parentTaskId + "]危险类型已分析，忽略重复分析："
							+ list);
					continue;
				}

				List<BGwxlx> riskResultList = PgXlHandler.handle(parentTaskId,
						copaTestNote.getResult(), scl09TestNote.getResult()); // 危险性倾向评估自杀，行凶，脱逃
				logger.info("保存 分析评估报告[" + parentTaskId + "]危险倾向分析结果:"
						+ riskResultList);
				for (BGwxlx rs : riskResultList) {
					testMapper.addWxlxReport(rs);
				}
			} catch (Exception e) {
				logger.error("分析评估报告[" + parentTaskId + "]危险类型失败", e);
			}
		}

	}

	// /**
	// * 获取警察信息列表
	// * @return
	// */
	// public String getCopInfo(Map<String, String> paramMap){
	// String json = GsonUtil.toJson(taskMapper.getCrimCopInfo("prison",
	// "stage"));;
	// logger.debug("返回前端的数据:" + json);
	// return json;
	//
	// }

	// TODO logic method end

	private String currDateTime() {
		return DateUtil.currDate("yyyy-MM-dd HH:mm:ss.sss");
	}

	public static String currDate() {
		return DateUtil.currDate("yyyy-MM-dd");
	}

	public String nothing() {
		logger.debug("返回前端的数据:" + C.NOTHING);
		return C.NOTHING;
	}

	private String errorMsg(String errorMsg) {
		errorMsg = C.ERROR + (errorMsg == null ? "" : errorMsg);
		logger.debug("返回前端的数据:" + errorMsg);
		return errorMsg;
	}

	public class Answer extends BasicModel {
		private String name;
		private String val;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getVal() {
			return val;
		}

		public void setVal(String val) {
			this.val = val;
		}
	}

}
