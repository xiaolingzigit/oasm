package com.hd.jy.oasm.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.hd.jy.oasm.annotation.DataSource;
import com.hd.jy.oasm.dao.LBKMMapper;
import com.hd.jy.oasm.dao.SjjgftAndxwgcDao;
import com.hd.jy.oasm.dao.TaskMapper;
import com.hd.jy.oasm.dao.TestMapper;
import com.hd.jy.oasm.dao.ViewftjgAndxwgcDao;
import com.hd.jy.oasm.dao.newDao.TdminAndtyzDao;
import com.hd.jy.oasm.domain.BGgtft;
import com.hd.jy.oasm.domain.BGjcxxpg;
import com.hd.jy.oasm.domain.BGxwgc;
import com.hd.jy.oasm.domain.DafxjgJSON;
import com.hd.jy.oasm.domain.Task;
import com.hd.jy.oasm.domain.TestNote;
import com.hd.jy.oasm.domain.ViewDasjfx;
import com.hd.jy.oasm.domain.newDomain.Scale;
import com.hd.jy.oasm.domain.newDomain.TCrimScaleRelat;
import com.hd.jy.oasm.domain.newDomain.Tscale;
import com.hd.jy.oasm.guize.AutoStartWithDa;
import com.hd.jy.oasm.services.ZuoTiSerivce;
import com.hd.jy.oasm.util.date.DateUtil;
import com.hd.jy.oasm.util.lsc.GsonUtil;
import com.hd.jy.oasm.util.lsc.RegexUtil;
import com.hd.jy.oasm.util.lsc.excpts.ParseException;
import com.hd.jy.oasm.util.priv.TaskType;

/***
 * 
 * @author quite 做题因子分数结果逻辑处理层
 */
@Service("zuoTiSerivceImpl")
@DataSource("userDataSource")
public class ZuoTiSerivceImpl implements ZuoTiSerivce {
	private Logger log = Logger.getLogger(ZuoTiSerivceImpl.class);

	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");

	SimpleDateFormat sdft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Autowired
	private LBKMMapper lbkDao; // 调用lbk里面yzbm的查询因子和分数方法

	@Autowired
	private SjjgftAndxwgcDao sjftftAndxwgcDao; // 调用jgft和xwgc里面的根据事件编号获取因子方法

	@Autowired
	private ViewftjgAndxwgcDao viewftjgAndxwgcDao; // 调用档案分析视图全查询方法

	@Autowired
	private AutoStartWithDa autoStarWithDa; // 使用注入的规则

	@Autowired
	private TdminAndtyzDao tdminAndtyzDao; // 调用维度和因子业务接口里面的评估部分

	@Autowired
	private TestMapper scaleTestDao; // 使用量表答题测试业务接口

	@Autowired
	private TaskMapper taskDao;


	// 通过档案的数据进行自动匹配规则，得到最终的结果入库---进入匹配规则
	/*
	 * time:2017-11-25 修改 jcdaid 数据类型为String by: ljy
	 */
	@Override
	public int autoGuize() {
		// TODO Auto-generated method stub
		int i = 0;
		TestNote note = null;
		String nowDate = sdft.format(new Date()); // 共用的当前时间
		try {
			log.info("开始进行查询档案分析数据时间" + DateUtil.getTime(new Date()));
			List<ViewDasjfx> seachDasjfx = viewftjgAndxwgcDao.seachDasjfxByBh(); // 得到档案数据列表，列出所有罪犯的基础档案
			if (seachDasjfx.size() != 0) {
				Set<String> qhSet = new TreeSet<>();
				Map<String, String> map = new HashMap<>();
				for (ViewDasjfx vd : seachDasjfx) {
					qhSet.add(vd.getBh());
					map.put(vd.getBh(), vd.getXm());

				}

				String bigsj = sdf.format(new Date()); // 大数据时间
				for (String qh : qhSet) {

					String jcdaid = qh + "_" + TaskType.FILE_ANLYSIS + "_" + bigsj.trim(); // 基础档案事件编号,*_inDa_*的事件编号
					String[] jsonJG = autoStarWithDa.autoStartWith(qh, seachDasjfx); // 匹配到的结果
					if (null != jsonJG) {
						String jg = jsonJG[0]; // 结果jg
						int zfs = 0;
						if (RegexUtil.isNum(jsonJG[1])) {
							zfs = Integer.parseInt(jsonJG[1]); // 总分数 zfs
						}
						log.info("【总分数" + zfs + "】");
						note = new TestNote();
						// 插入到TestNote
						note.setTaskId(jcdaid);
						note.setAnswer(jg);
						note.setScore(zfs);
						note.setLevl(null);
						note.setResult(null);
						saveDafxs(jcdaid, jg, qh);// 保存新的档案分析数据
						// 执行插入操作
						i = scaleTestDao.saveNote(note); // 插入档案分析结果

						log.info("成功插入或更改【档案分析结果】数据" + i + "条，时间为：" + DateUtil.getTime(new Date()));
						if (1 == i) {
							saveDafxTask(nowDate, qh, jcdaid); // 执行添加档案分析到任务里面
						}
					} else {
						continue;
					}
				}

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("添加档案分析结果失败,插入的条数为" + i + "，请重试..." + e.getMessage(), e);
		}
		return i;
	}

	/**
	 * 抽取档案分析任务添加
	 * 
	 * @auto quite
	 * @param nowDate
	 * @param qh
	 * @param jcdaida
	 *            下午5:59:03 void
	 */
	public void saveDafxTask(String nowDate, String qh, String jcdaid) {
		log.info("【当前时间" + nowDate + "】，【囚号" + qh + "】，【任务编号" + jcdaid + "】");
		Task task = new Task();
		task.setTaskId(jcdaid); // 任务编号
		task.setCrimNo(qh); // 囚号
		task.setTaskBasis("档案分析");
		task.setTaskDescrib("档案分析");
		task.setDeadline(nowDate);
		task.setType(TaskType.FILE_ANLYSIS); // 类型
		task.setCreator("系统".trim()); // 默认使用系统
		task.setCreateTime(nowDate);
		task.setLastModif(nowDate);
		task.setModifier("系统".trim());
		task.setStatus(4);// 4表示任务已经完成
		int a = taskDao.addTask(task);
		log.info("成功添加档案分析任务编号数据" + a + "条");
	}

	/**
	 * 抽取档案分析结果添加
	 * 
	 * @auto quite
	 * @param taskId
	 * @param fxjg
	 * @param qh
	 * @returna 下午5:59:13 int
	 */
	public int saveDafxs(String taskId, String fxjg, String qh) {
		int i = 0;
		log.info("档案分析【任务编号" + taskId + "】，【分析结果" + fxjg + "】，【囚号" + qh + "】");
		try {
			log.info("开始使用重新的档案分析数据保存时间" + DateUtil.getTime(new Date()));
			DafxjgJSON daJSON = null;
			BGjcxxpg jcpg = null;
			JsonArray jsonArray = GsonUtil.toJsonArray(fxjg); // 这是List的JSON数据
			if (null != fxjg) {
				for (JsonElement jele : jsonArray) {
					daJSON = GsonUtil.toInstance(jele.toString(), DafxjgJSON.class); // 获取到单个JSON的对象
					jcpg = new BGjcxxpg();
					jcpg.setRwid(taskId); // 任务编号
					jcpg.setQh(qh); // 囚号
					
					if(null!=daJSON.getWd()&&!"未知".equals(daJSON.getWd())){ //只需满足维度不为null或者未知
						jcpg.setWd(daJSON.getWd()); // 维度
						jcpg.setYz(daJSON.getYz()); // 因子
						jcpg.setFs(daJSON.getFs()); // 分数
						i = scaleTestDao.saveJcdafxs(jcpg);
						log.info("成功执行档案分析保存数据" + i + "条");
					}else{
						log.error("出现未知维度和因子或者分数");
					}
				}
			} else {
				log.error("执行档案分析结果数据为null");
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			log.error("档案分析新数据异常，请重试..." + e.getMessage(), e);
		}

		return i;
	}

	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	// ************最新的评估部分****通过匹配不同量表的编号获取量表里面的问题和因子******
	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	/**
	 * 
	 * @ TODO通过页面上的囚号返回入监结构访谈问题列表的字段
	 * 
	 * @authc quite
	 * @date 2018年1月2日
	 * @see com.hd.jy.oasm.services.ZuoTiSerivce#rjjgftQuestion(java.lang.String)
	 */
	@Override
	public String rjjgftQuestion(String taskId) {
		// TODO Auto-generated method stub
		String scales = null;
		TCrimScaleRelat csr;
		try {
			if (taskId != null && taskId != "") {
				log.info("开始根据入监结构访谈【任务编号" + taskId + "】获取【问题的json数据】时间" + DateUtil.getTime(new Date()));
				csr = tdminAndtyzDao.crimScaleRelatByTaskId(taskId);
				JsonArray jsonArr = GsonUtil.toJsonArray(csr.getScaleConf().getConf());

				Scale scale;
				Tscale te;
				for (JsonElement ele : jsonArr) {
					scale = GsonUtil.toInstance(ele.toString(), Scale.class);
					if (0 != scale.getRjftNo().trim().length() && null != scale.getRjftNo().trim()) { // 区分量表的编号对应的字段
						te = tdminAndtyzDao.getScaleByScaleId(Integer.parseInt(scale.getRjftNo()));
						scales = te.getScale(); // 获取问题的json数据
						// log.info("获取问题的json数据【"+scales+"】");
					} else {
						return scales;
					}
				}
			} else {
				log.error("开始根据入监结构访谈【任务编号" + taskId + "】获取数据失败，请重试...");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("获取问题的json数据异常，请重试..." + e.getMessage(), e);

		}

		return scales;
	}

	/**
	 * 
	 * @ TODO通过囚号返回入监行为观察访谈问题列表
	 * 
	 * @authc quite
	 * @date 2018年1月2日
	 * @see com.hd.jy.oasm.services.ZuoTiSerivce#rjxwgcQuestion(java.lang.String)
	 */
	@Override
	public String rjxwgcQuestion(String taskId) {
		String scales = null;
		TCrimScaleRelat csr;
		try {
			if (taskId != null && taskId != "") {
				log.info("开始根据入监行为观察【任务编号" + taskId + "】获取【问题的json数据】时间" + DateUtil.getTime(new Date()));
				csr = tdminAndtyzDao.crimScaleRelatByTaskId(taskId);
				JsonArray jsonArr = GsonUtil.toJsonArray(csr.getScaleConf().getConf());

				Scale scale;
				Tscale te;
				for (JsonElement ele : jsonArr) {
					scale = GsonUtil.toInstance(ele.toString(), Scale.class);
					if (0 != scale.getRjgcNo().trim().length() && null != scale.getRjgcNo().trim()) {// 区分量表的编号对应的字段
						te = tdminAndtyzDao.getScaleByScaleId(Integer.parseInt(scale.getRjgcNo()));
						scales = te.getScale(); // 获取问题的json数据
						// log.info("获取问题的json数据【"+scales+"】");
					} else {
						return scales;
					}
				}
			} else {
				log.error("开始根据入监行为观察【任务编号" + taskId + "】获取数据失败，请重试...");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("获取问题的json数据异常，请重试..." + e.getMessage(), e);

		}

		return scales;
	}

	/**
	 * 
	 * @ TODO通过任务编号得到日常答题需要的因子和维度
	 * 
	 * @authc quite
	 * @date 2018年1月2日
	 * @see com.hd.jy.oasm.services.ZuoTiSerivce#rcxwgcQuestion(java.lang.String)
	 */
	@Override
	public String rcxwgcQuestion(String taskId) {
		// TODO Auto-generated method stub
		String scales = null;
		try {
			if (null != taskId && "" != taskId) {
				TCrimScaleRelat csr = tdminAndtyzDao.crimScaleRelatByTaskId(taskId);
				JsonArray jsonArr = GsonUtil.toJsonArray(csr.getScaleConf().getConf()); // 把list的json数据转为对象
				Scale scale;
				Tscale te;
				for (JsonElement jele : jsonArr) {
					scale = GsonUtil.toInstance(jele.toString(), Scale.class); // 成功转为Object
					if (0 != scale.getRcgcNo().trim().length() && null != scale.getRcgcNo().trim()) { // 区分量表的编号对应的字段
						te = tdminAndtyzDao.getScaleByScaleId(Integer.parseInt(scale.getRcgcNo().trim())); // 使用i类型的数据获取
						scales = te.getScale();
						log.info("格式化之后的【日常行为观察因子和维度】数据" + scales);
					} else {
						return scales; // 为null
					}
				}
			} else {
				log.error("任务编号为" + taskId + "，请确认后重试");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("编译异常，请重试..." + e.getMessage(), e);
		}
		return scales;
	}

	/**
	 * 
	 * @ TODO通过任务编号获取中期结构访谈需要的因子和问题
	 * 
	 * @authc quite
	 * @date 2018年1月2日
	 * @see com.hd.jy.oasm.services.ZuoTiSerivce#zqjgftQuestion(java.lang.String)
	 */
	@Override
	public String zqjgftQuestion(String taskId) {
		// TODO Auto-generated method stub
		String scales = null;
		TCrimScaleRelat csr;
		try {
			log.info("开始通过【任务编号" + taskId + "】获取中期结构访谈量表编号，进行匹配所选量表时间" + DateUtil.getTime(new Date()));
			if (null != taskId && "" != taskId) { // 任务编号不为空
				csr = tdminAndtyzDao.crimScaleRelatByTaskId(taskId); // 传入任务编号获取量表
				JsonArray jsonArr = GsonUtil.toJsonArray(csr.getScaleConf().getConf());

				Scale scale;
				Tscale te;

				for (JsonElement jele : jsonArr) {

					scale = GsonUtil.toInstance(jele.toString(), Scale.class);
					if (0 != scale.getZqftNo().trim().length() && null != scale.getZqftNo().trim()) { // 判断中期结构访谈量表编号
						te = tdminAndtyzDao.getScaleByScaleId(Integer.parseInt(scale.getZqftNo()));
						scales = te.getScale();

					} else {
						return scales;
					}
				}
			} else {
				log.error("获取中期结构访谈量表失败，原因任务编号为【" + taskId + "】");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("中期结构访谈获取问题和因子异常，请重试..." + e.getMessage(), e);
		}
		return scales;
	}

	/**
	 * 
	 * @ TODO通过任务编号获取中期行为观察需要的因子和维度
	 * 
	 * @authc quite
	 * @date 2018年1月2日
	 * @see com.hd.jy.oasm.services.ZuoTiSerivce#zqxwgcQuestion(java.lang.String)
	 */
	@Override
	public String zqxwgcQuestion(String taskId) {
		// TODO Auto-generated method stub
		String scales = null;
		try {
			log.info("开始通过【任务编号" + taskId + "】获取中期行为观察量表编号，进行匹配所选量表时间" + DateUtil.getTime(new Date()));
			if (null != taskId && "" != taskId) {
				TCrimScaleRelat csr = tdminAndtyzDao.crimScaleRelatByTaskId(taskId);

				JsonArray jsonArr = GsonUtil.toJsonArray(csr.getScaleConf().getConf());
				Scale scale;
				Tscale te;
				for (JsonElement jele : jsonArr) {

					scale = GsonUtil.toInstance(jele.toString(), Scale.class);
					if (0 != scale.getZqgcNo().trim().length() && null != scale.getZqgcNo().trim()) {
						te = tdminAndtyzDao.getScaleByScaleId(Integer.parseInt(scale.getZqgcNo().trim()));
						scales = te.getScale(); // 输出任务所使用的量表的内容
					} else {
						return scales;
					}
				}
			} else {
				log.error("匹配所选量表异常，原因：任务编号为" + taskId);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("匹配获取任务所需要的量表的问题和因子异常，请重试..." + e.getMessage(), e);
		}
		return scales;
	}

	/***
	 * 
	 * @ TODO通过任务编号获取出监结构访谈需要的因子和问题
	 * 
	 * @authc quite
	 * @date 2018年1月2日
	 * @see com.hd.jy.oasm.services.ZuoTiSerivce#cjjgftQuestion(java.lang.String)
	 */
	@Override
	public String cjjgftQuestion(String taskId) {
		// TODO Auto-generated method stub
		String scales = null;
		TCrimScaleRelat csr;
		try {
			log.info("开始通过【任务编号" + taskId + "】获取出监结构访谈量表编号，进行匹配所选量表时间" + DateUtil.getTime(new Date()));
			if (null != taskId && "" != taskId) {
				csr = tdminAndtyzDao.crimScaleRelatByTaskId(taskId);

				JsonArray jsonArr = GsonUtil.toJsonArray(csr.getScaleConf().getConf());
				Scale scale;
				Tscale te;
				for (JsonElement jele : jsonArr) {
					scale = GsonUtil.toInstance(jele.toString(), Scale.class);

					if (0 != scale.getCjftNo().trim().length() && null != scale.getCjftNo().trim()) { // 如果出监结构访谈量表编号长度不为0,编号不为null

						te = tdminAndtyzDao.getScaleByScaleId(Integer.parseInt(scale.getCjftNo().trim()));

						scales = te.getScale();
					} else {
						return scales;
					}
				}
			} else {
				log.error("通过【任务编号" + taskId + "】获取使用的出监结构访谈量表失败，请重试...");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("通过任务编号获取匹配的出监结构访谈量表异常，请重试..." + e.getMessage(), e);
		}
		return scales;
	}

	/***
	 * 通过任务编号获取出监行为观察需要的因子和维度 @ TODO
	 * 
	 * @authc quite
	 * @date 2018年1月2日
	 * @see com.hd.jy.oasm.services.ZuoTiSerivce#cjxwgcQuestion(java.lang.String)
	 */
	@Override
	public String cjxwgcQuestion(String taskId) {
		// TODO Auto-generated method stub
		String scales = null;
		try {
			log.info("开始通过【任务编号" + taskId + "】获取出监结构访谈量表编号，进行匹配所选量表时间" + DateUtil.getTime(new Date()));
			if (null != taskId && "" != taskId) {
				TCrimScaleRelat csr = tdminAndtyzDao.crimScaleRelatByTaskId(taskId);

				JsonArray jsonArr = GsonUtil.toJsonArray(csr.getScaleConf().getConf());
				Scale scale;
				Tscale te;
				for (JsonElement jele : jsonArr) {
					scale = GsonUtil.toInstance(jele.toString(), Scale.class);
					if (0 != scale.getCjgcNo().trim().length() && null != scale.getCjgcNo().trim()) {
						te = tdminAndtyzDao.getScaleByScaleId(Integer.parseInt(scale.getCjgcNo().trim()));
						scales = te.getScale();
					} else {
						return scales;
					}
				}
			} else {
				log.error("通过【任务编号" + taskId + "】获取出监行为观察量表失败，请重试...");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("通过任务编号获取匹配的量表的因子和问题异常，请重试..." + e.getMessage(), e);
		}
		return scales;
	}

	/***
	 * 添加答题记录，把警察的记录的答题情况记录到答题表中 @ TODO
	 * 
	 * @authc quite
	 * @date 2018年1月2日
	 * @see com.hd.jy.oasm.services.ZuoTiSerivce#saveNote(com.hd.jy.oasm.domain.TestNote)
	 */
	@Override
	public int saveNote(TestNote testNote) {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			if (testNote != null) {
				log.info("开始【添加答题答案" + testNote.toString() + "】时间" + DateUtil.getTime(new Date()));
				i = scaleTestDao.saveNote(testNote);
				log.info("成功添加答题答案记录【" + i + "条】记录");
			} else {
				log.error("添加答题答案失败，失败原因" + testNote + "对象，请重试...");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("添加答题答案异常，请稍后重试..." + e.getMessage(), e);
		}
		return i;
	}

	/***
	 * 
	 * @ TODO根据任务编号查询答题记录
	 * 
	 * @authc quite
	 * @date 2018年1月2日
	 * @see com.hd.jy.oasm.services.ZuoTiSerivce#getNote(java.lang.String)
	 */
	@Override
	public TestNote getNote(String taskId) {
		// TODO Auto-generated method stub
		TestNote note = null;
		try {
			log.info("开始【根据任务编号" + taskId + "】查询做题记录时间" + DateUtil.getTime(new Date()));
			if (null != taskId) {
				note = scaleTestDao.getNote(taskId);
			} else {
				log.error("根据任务编号查询【做题记录】失败，任务编号为【" + taskId + "】");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("查询做题记录异常，请稍后重试" + e.getMessage(), e);
		}
		return note;
	}

	/**
	 * @ TODO保存结构访谈答题记录
	 * 
	 * @authc quite
	 * @date 2018年1月2日
	 * @see com.hd.jy.oasm.services.ZuoTiSerivce#saveGtfts(com.hd.jy.oasm.domain.BGgtft)
	 */
	@Override
	public int saveGtfts(BGgtft record) {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			log.info("开始保存结构访谈答题记录时间【" + DateUtil.getTime(new Date()) + "】");
			if (null != record) {
				i = scaleTestDao.saveGtfts(record);
				log.info("成功保存结构访谈答题记录数据【" + i + "】条");
			} else {
				log.error("保存的对象为【" + record + "】");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("保存结构访谈答题记录数据异常，请重试..." + e.getMessage(), e);
		}
		return i;
	}

	/**
	 * @ TODO保存行为观察答题记录
	 * 
	 * @authc quite
	 * @date 2018年1月2日
	 * @see com.hd.jy.oasm.services.ZuoTiSerivce#saveXwgcs(com.hd.jy.oasm.domain.BGxwgc)
	 */
	@Override
	public int saveXwgcs(BGxwgc record) {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			log.info("开始保存行为观察答题记录时间【" + DateUtil.getTime(new Date()) + "】");
			if (null != record) {
				i = scaleTestDao.saveXwgcs(record);
				log.info("成功添加行为观察答题记录【" + i + "】条数据");
			} else {
				log.error("行为观察对象为【" + record + "】");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("保存行为观察答题记录异常，请重试..." + e.getMessage(), e);
		}
		return i;
	}
}
