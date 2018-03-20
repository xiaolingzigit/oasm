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
 * @author quite �������ӷ�������߼������
 */
@Service("zuoTiSerivceImpl")
@DataSource("userDataSource")
public class ZuoTiSerivceImpl implements ZuoTiSerivce {
	private Logger log = Logger.getLogger(ZuoTiSerivceImpl.class);

	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");

	SimpleDateFormat sdft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Autowired
	private LBKMMapper lbkDao; // ����lbk����yzbm�Ĳ�ѯ���Ӻͷ�������

	@Autowired
	private SjjgftAndxwgcDao sjftftAndxwgcDao; // ����jgft��xwgc����ĸ����¼���Ż�ȡ���ӷ���

	@Autowired
	private ViewftjgAndxwgcDao viewftjgAndxwgcDao; // ���õ���������ͼȫ��ѯ����

	@Autowired
	private AutoStartWithDa autoStarWithDa; // ʹ��ע��Ĺ���

	@Autowired
	private TdminAndtyzDao tdminAndtyzDao; // ����ά�Ⱥ�����ҵ��ӿ��������������

	@Autowired
	private TestMapper scaleTestDao; // ʹ������������ҵ��ӿ�

	@Autowired
	private TaskMapper taskDao;


	// ͨ�����������ݽ����Զ�ƥ����򣬵õ����յĽ�����---����ƥ�����
	/*
	 * time:2017-11-25 �޸� jcdaid ��������ΪString by: ljy
	 */
	@Override
	public int autoGuize() {
		// TODO Auto-generated method stub
		int i = 0;
		TestNote note = null;
		String nowDate = sdft.format(new Date()); // ���õĵ�ǰʱ��
		try {
			log.info("��ʼ���в�ѯ������������ʱ��" + DateUtil.getTime(new Date()));
			List<ViewDasjfx> seachDasjfx = viewftjgAndxwgcDao.seachDasjfxByBh(); // �õ����������б��г������ﷸ�Ļ�������
			if (seachDasjfx.size() != 0) {
				Set<String> qhSet = new TreeSet<>();
				Map<String, String> map = new HashMap<>();
				for (ViewDasjfx vd : seachDasjfx) {
					qhSet.add(vd.getBh());
					map.put(vd.getBh(), vd.getXm());

				}

				String bigsj = sdf.format(new Date()); // ������ʱ��
				for (String qh : qhSet) {

					String jcdaid = qh + "_" + TaskType.FILE_ANLYSIS + "_" + bigsj.trim(); // ���������¼����,*_inDa_*���¼����
					String[] jsonJG = autoStarWithDa.autoStartWith(qh, seachDasjfx); // ƥ�䵽�Ľ��
					if (null != jsonJG) {
						String jg = jsonJG[0]; // ���jg
						int zfs = 0;
						if (RegexUtil.isNum(jsonJG[1])) {
							zfs = Integer.parseInt(jsonJG[1]); // �ܷ��� zfs
						}
						log.info("���ܷ���" + zfs + "��");
						note = new TestNote();
						// ���뵽TestNote
						note.setTaskId(jcdaid);
						note.setAnswer(jg);
						note.setScore(zfs);
						note.setLevl(null);
						note.setResult(null);
						saveDafxs(jcdaid, jg, qh);// �����µĵ�����������
						// ִ�в������
						i = scaleTestDao.saveNote(note); // ���뵵���������

						log.info("�ɹ��������ġ������������������" + i + "����ʱ��Ϊ��" + DateUtil.getTime(new Date()));
						if (1 == i) {
							saveDafxTask(nowDate, qh, jcdaid); // ִ����ӵ�����������������
						}
					} else {
						continue;
					}
				}

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("��ӵ����������ʧ��,���������Ϊ" + i + "��������..." + e.getMessage(), e);
		}
		return i;
	}

	/**
	 * ��ȡ���������������
	 * 
	 * @auto quite
	 * @param nowDate
	 * @param qh
	 * @param jcdaida
	 *            ����5:59:03 void
	 */
	public void saveDafxTask(String nowDate, String qh, String jcdaid) {
		log.info("����ǰʱ��" + nowDate + "����������" + qh + "������������" + jcdaid + "��");
		Task task = new Task();
		task.setTaskId(jcdaid); // ������
		task.setCrimNo(qh); // ����
		task.setTaskBasis("��������");
		task.setTaskDescrib("��������");
		task.setDeadline(nowDate);
		task.setType(TaskType.FILE_ANLYSIS); // ����
		task.setCreator("ϵͳ".trim()); // Ĭ��ʹ��ϵͳ
		task.setCreateTime(nowDate);
		task.setLastModif(nowDate);
		task.setModifier("ϵͳ".trim());
		task.setStatus(4);// 4��ʾ�����Ѿ����
		int a = taskDao.addTask(task);
		log.info("�ɹ���ӵ�����������������" + a + "��");
	}

	/**
	 * ��ȡ��������������
	 * 
	 * @auto quite
	 * @param taskId
	 * @param fxjg
	 * @param qh
	 * @returna ����5:59:13 int
	 */
	public int saveDafxs(String taskId, String fxjg, String qh) {
		int i = 0;
		log.info("����������������" + taskId + "�������������" + fxjg + "����������" + qh + "��");
		try {
			log.info("��ʼʹ�����µĵ����������ݱ���ʱ��" + DateUtil.getTime(new Date()));
			DafxjgJSON daJSON = null;
			BGjcxxpg jcpg = null;
			JsonArray jsonArray = GsonUtil.toJsonArray(fxjg); // ����List��JSON����
			if (null != fxjg) {
				for (JsonElement jele : jsonArray) {
					daJSON = GsonUtil.toInstance(jele.toString(), DafxjgJSON.class); // ��ȡ������JSON�Ķ���
					jcpg = new BGjcxxpg();
					jcpg.setRwid(taskId); // ������
					jcpg.setQh(qh); // ����
					
					if(null!=daJSON.getWd()&&!"δ֪".equals(daJSON.getWd())){ //ֻ������ά�Ȳ�Ϊnull����δ֪
						jcpg.setWd(daJSON.getWd()); // ά��
						jcpg.setYz(daJSON.getYz()); // ����
						jcpg.setFs(daJSON.getFs()); // ����
						i = scaleTestDao.saveJcdafxs(jcpg);
						log.info("�ɹ�ִ�е���������������" + i + "��");
					}else{
						log.error("����δ֪ά�Ⱥ����ӻ��߷���");
					}
				}
			} else {
				log.error("ִ�е��������������Ϊnull");
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			log.error("���������������쳣��������..." + e.getMessage(), e);
		}

		return i;
	}

	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	// ************���µ���������****ͨ��ƥ�䲻ͬ����ı�Ż�ȡ������������������******
	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	/**
	 * 
	 * @ TODOͨ��ҳ���ϵ����ŷ������ṹ��̸�����б���ֶ�
	 * 
	 * @authc quite
	 * @date 2018��1��2��
	 * @see com.hd.jy.oasm.services.ZuoTiSerivce#rjjgftQuestion(java.lang.String)
	 */
	@Override
	public String rjjgftQuestion(String taskId) {
		// TODO Auto-generated method stub
		String scales = null;
		TCrimScaleRelat csr;
		try {
			if (taskId != null && taskId != "") {
				log.info("��ʼ�������ṹ��̸��������" + taskId + "����ȡ�������json���ݡ�ʱ��" + DateUtil.getTime(new Date()));
				csr = tdminAndtyzDao.crimScaleRelatByTaskId(taskId);
				JsonArray jsonArr = GsonUtil.toJsonArray(csr.getScaleConf().getConf());

				Scale scale;
				Tscale te;
				for (JsonElement ele : jsonArr) {
					scale = GsonUtil.toInstance(ele.toString(), Scale.class);
					if (0 != scale.getRjftNo().trim().length() && null != scale.getRjftNo().trim()) { // ��������ı�Ŷ�Ӧ���ֶ�
						te = tdminAndtyzDao.getScaleByScaleId(Integer.parseInt(scale.getRjftNo()));
						scales = te.getScale(); // ��ȡ�����json����
						// log.info("��ȡ�����json���ݡ�"+scales+"��");
					} else {
						return scales;
					}
				}
			} else {
				log.error("��ʼ�������ṹ��̸��������" + taskId + "����ȡ����ʧ�ܣ�������...");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("��ȡ�����json�����쳣��������..." + e.getMessage(), e);

		}

		return scales;
	}

	/**
	 * 
	 * @ TODOͨ�����ŷ��������Ϊ�۲��̸�����б�
	 * 
	 * @authc quite
	 * @date 2018��1��2��
	 * @see com.hd.jy.oasm.services.ZuoTiSerivce#rjxwgcQuestion(java.lang.String)
	 */
	@Override
	public String rjxwgcQuestion(String taskId) {
		String scales = null;
		TCrimScaleRelat csr;
		try {
			if (taskId != null && taskId != "") {
				log.info("��ʼ���������Ϊ�۲졾������" + taskId + "����ȡ�������json���ݡ�ʱ��" + DateUtil.getTime(new Date()));
				csr = tdminAndtyzDao.crimScaleRelatByTaskId(taskId);
				JsonArray jsonArr = GsonUtil.toJsonArray(csr.getScaleConf().getConf());

				Scale scale;
				Tscale te;
				for (JsonElement ele : jsonArr) {
					scale = GsonUtil.toInstance(ele.toString(), Scale.class);
					if (0 != scale.getRjgcNo().trim().length() && null != scale.getRjgcNo().trim()) {// ��������ı�Ŷ�Ӧ���ֶ�
						te = tdminAndtyzDao.getScaleByScaleId(Integer.parseInt(scale.getRjgcNo()));
						scales = te.getScale(); // ��ȡ�����json����
						// log.info("��ȡ�����json���ݡ�"+scales+"��");
					} else {
						return scales;
					}
				}
			} else {
				log.error("��ʼ���������Ϊ�۲졾������" + taskId + "����ȡ����ʧ�ܣ�������...");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("��ȡ�����json�����쳣��������..." + e.getMessage(), e);

		}

		return scales;
	}

	/**
	 * 
	 * @ TODOͨ�������ŵõ��ճ�������Ҫ�����Ӻ�ά��
	 * 
	 * @authc quite
	 * @date 2018��1��2��
	 * @see com.hd.jy.oasm.services.ZuoTiSerivce#rcxwgcQuestion(java.lang.String)
	 */
	@Override
	public String rcxwgcQuestion(String taskId) {
		// TODO Auto-generated method stub
		String scales = null;
		try {
			if (null != taskId && "" != taskId) {
				TCrimScaleRelat csr = tdminAndtyzDao.crimScaleRelatByTaskId(taskId);
				JsonArray jsonArr = GsonUtil.toJsonArray(csr.getScaleConf().getConf()); // ��list��json����תΪ����
				Scale scale;
				Tscale te;
				for (JsonElement jele : jsonArr) {
					scale = GsonUtil.toInstance(jele.toString(), Scale.class); // �ɹ�תΪObject
					if (0 != scale.getRcgcNo().trim().length() && null != scale.getRcgcNo().trim()) { // ��������ı�Ŷ�Ӧ���ֶ�
						te = tdminAndtyzDao.getScaleByScaleId(Integer.parseInt(scale.getRcgcNo().trim())); // ʹ��i���͵����ݻ�ȡ
						scales = te.getScale();
						log.info("��ʽ��֮��ġ��ճ���Ϊ�۲����Ӻ�ά�ȡ�����" + scales);
					} else {
						return scales; // Ϊnull
					}
				}
			} else {
				log.error("������Ϊ" + taskId + "����ȷ�Ϻ�����");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("�����쳣��������..." + e.getMessage(), e);
		}
		return scales;
	}

	/**
	 * 
	 * @ TODOͨ�������Ż�ȡ���ڽṹ��̸��Ҫ�����Ӻ�����
	 * 
	 * @authc quite
	 * @date 2018��1��2��
	 * @see com.hd.jy.oasm.services.ZuoTiSerivce#zqjgftQuestion(java.lang.String)
	 */
	@Override
	public String zqjgftQuestion(String taskId) {
		// TODO Auto-generated method stub
		String scales = null;
		TCrimScaleRelat csr;
		try {
			log.info("��ʼͨ����������" + taskId + "����ȡ���ڽṹ��̸�����ţ�����ƥ����ѡ����ʱ��" + DateUtil.getTime(new Date()));
			if (null != taskId && "" != taskId) { // �����Ų�Ϊ��
				csr = tdminAndtyzDao.crimScaleRelatByTaskId(taskId); // ���������Ż�ȡ����
				JsonArray jsonArr = GsonUtil.toJsonArray(csr.getScaleConf().getConf());

				Scale scale;
				Tscale te;

				for (JsonElement jele : jsonArr) {

					scale = GsonUtil.toInstance(jele.toString(), Scale.class);
					if (0 != scale.getZqftNo().trim().length() && null != scale.getZqftNo().trim()) { // �ж����ڽṹ��̸������
						te = tdminAndtyzDao.getScaleByScaleId(Integer.parseInt(scale.getZqftNo()));
						scales = te.getScale();

					} else {
						return scales;
					}
				}
			} else {
				log.error("��ȡ���ڽṹ��̸����ʧ�ܣ�ԭ��������Ϊ��" + taskId + "��");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("���ڽṹ��̸��ȡ����������쳣��������..." + e.getMessage(), e);
		}
		return scales;
	}

	/**
	 * 
	 * @ TODOͨ�������Ż�ȡ������Ϊ�۲���Ҫ�����Ӻ�ά��
	 * 
	 * @authc quite
	 * @date 2018��1��2��
	 * @see com.hd.jy.oasm.services.ZuoTiSerivce#zqxwgcQuestion(java.lang.String)
	 */
	@Override
	public String zqxwgcQuestion(String taskId) {
		// TODO Auto-generated method stub
		String scales = null;
		try {
			log.info("��ʼͨ����������" + taskId + "����ȡ������Ϊ�۲������ţ�����ƥ����ѡ����ʱ��" + DateUtil.getTime(new Date()));
			if (null != taskId && "" != taskId) {
				TCrimScaleRelat csr = tdminAndtyzDao.crimScaleRelatByTaskId(taskId);

				JsonArray jsonArr = GsonUtil.toJsonArray(csr.getScaleConf().getConf());
				Scale scale;
				Tscale te;
				for (JsonElement jele : jsonArr) {

					scale = GsonUtil.toInstance(jele.toString(), Scale.class);
					if (0 != scale.getZqgcNo().trim().length() && null != scale.getZqgcNo().trim()) {
						te = tdminAndtyzDao.getScaleByScaleId(Integer.parseInt(scale.getZqgcNo().trim()));
						scales = te.getScale(); // ���������ʹ�õ����������
					} else {
						return scales;
					}
				}
			} else {
				log.error("ƥ����ѡ�����쳣��ԭ��������Ϊ" + taskId);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("ƥ���ȡ��������Ҫ�����������������쳣��������..." + e.getMessage(), e);
		}
		return scales;
	}

	/***
	 * 
	 * @ TODOͨ�������Ż�ȡ����ṹ��̸��Ҫ�����Ӻ�����
	 * 
	 * @authc quite
	 * @date 2018��1��2��
	 * @see com.hd.jy.oasm.services.ZuoTiSerivce#cjjgftQuestion(java.lang.String)
	 */
	@Override
	public String cjjgftQuestion(String taskId) {
		// TODO Auto-generated method stub
		String scales = null;
		TCrimScaleRelat csr;
		try {
			log.info("��ʼͨ����������" + taskId + "����ȡ����ṹ��̸�����ţ�����ƥ����ѡ����ʱ��" + DateUtil.getTime(new Date()));
			if (null != taskId && "" != taskId) {
				csr = tdminAndtyzDao.crimScaleRelatByTaskId(taskId);

				JsonArray jsonArr = GsonUtil.toJsonArray(csr.getScaleConf().getConf());
				Scale scale;
				Tscale te;
				for (JsonElement jele : jsonArr) {
					scale = GsonUtil.toInstance(jele.toString(), Scale.class);

					if (0 != scale.getCjftNo().trim().length() && null != scale.getCjftNo().trim()) { // �������ṹ��̸�����ų��Ȳ�Ϊ0,��Ų�Ϊnull

						te = tdminAndtyzDao.getScaleByScaleId(Integer.parseInt(scale.getCjftNo().trim()));

						scales = te.getScale();
					} else {
						return scales;
					}
				}
			} else {
				log.error("ͨ����������" + taskId + "����ȡʹ�õĳ���ṹ��̸����ʧ�ܣ�������...");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("ͨ�������Ż�ȡƥ��ĳ���ṹ��̸�����쳣��������..." + e.getMessage(), e);
		}
		return scales;
	}

	/***
	 * ͨ�������Ż�ȡ������Ϊ�۲���Ҫ�����Ӻ�ά�� @ TODO
	 * 
	 * @authc quite
	 * @date 2018��1��2��
	 * @see com.hd.jy.oasm.services.ZuoTiSerivce#cjxwgcQuestion(java.lang.String)
	 */
	@Override
	public String cjxwgcQuestion(String taskId) {
		// TODO Auto-generated method stub
		String scales = null;
		try {
			log.info("��ʼͨ����������" + taskId + "����ȡ����ṹ��̸�����ţ�����ƥ����ѡ����ʱ��" + DateUtil.getTime(new Date()));
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
				log.error("ͨ����������" + taskId + "����ȡ������Ϊ�۲�����ʧ�ܣ�������...");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("ͨ�������Ż�ȡƥ�����������Ӻ������쳣��������..." + e.getMessage(), e);
		}
		return scales;
	}

	/***
	 * ��Ӵ����¼���Ѿ���ļ�¼�Ĵ��������¼��������� @ TODO
	 * 
	 * @authc quite
	 * @date 2018��1��2��
	 * @see com.hd.jy.oasm.services.ZuoTiSerivce#saveNote(com.hd.jy.oasm.domain.TestNote)
	 */
	@Override
	public int saveNote(TestNote testNote) {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			if (testNote != null) {
				log.info("��ʼ����Ӵ����" + testNote.toString() + "��ʱ��" + DateUtil.getTime(new Date()));
				i = scaleTestDao.saveNote(testNote);
				log.info("�ɹ���Ӵ���𰸼�¼��" + i + "������¼");
			} else {
				log.error("��Ӵ����ʧ�ܣ�ʧ��ԭ��" + testNote + "����������...");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("��Ӵ�����쳣�����Ժ�����..." + e.getMessage(), e);
		}
		return i;
	}

	/***
	 * 
	 * @ TODO���������Ų�ѯ�����¼
	 * 
	 * @authc quite
	 * @date 2018��1��2��
	 * @see com.hd.jy.oasm.services.ZuoTiSerivce#getNote(java.lang.String)
	 */
	@Override
	public TestNote getNote(String taskId) {
		// TODO Auto-generated method stub
		TestNote note = null;
		try {
			log.info("��ʼ������������" + taskId + "����ѯ�����¼ʱ��" + DateUtil.getTime(new Date()));
			if (null != taskId) {
				note = scaleTestDao.getNote(taskId);
			} else {
				log.error("���������Ų�ѯ�������¼��ʧ�ܣ�������Ϊ��" + taskId + "��");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("��ѯ�����¼�쳣�����Ժ�����" + e.getMessage(), e);
		}
		return note;
	}

	/**
	 * @ TODO����ṹ��̸�����¼
	 * 
	 * @authc quite
	 * @date 2018��1��2��
	 * @see com.hd.jy.oasm.services.ZuoTiSerivce#saveGtfts(com.hd.jy.oasm.domain.BGgtft)
	 */
	@Override
	public int saveGtfts(BGgtft record) {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			log.info("��ʼ����ṹ��̸�����¼ʱ�䡾" + DateUtil.getTime(new Date()) + "��");
			if (null != record) {
				i = scaleTestDao.saveGtfts(record);
				log.info("�ɹ�����ṹ��̸�����¼���ݡ�" + i + "����");
			} else {
				log.error("����Ķ���Ϊ��" + record + "��");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("����ṹ��̸�����¼�����쳣��������..." + e.getMessage(), e);
		}
		return i;
	}

	/**
	 * @ TODO������Ϊ�۲�����¼
	 * 
	 * @authc quite
	 * @date 2018��1��2��
	 * @see com.hd.jy.oasm.services.ZuoTiSerivce#saveXwgcs(com.hd.jy.oasm.domain.BGxwgc)
	 */
	@Override
	public int saveXwgcs(BGxwgc record) {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			log.info("��ʼ������Ϊ�۲�����¼ʱ�䡾" + DateUtil.getTime(new Date()) + "��");
			if (null != record) {
				i = scaleTestDao.saveXwgcs(record);
				log.info("�ɹ������Ϊ�۲�����¼��" + i + "��������");
			} else {
				log.error("��Ϊ�۲����Ϊ��" + record + "��");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("������Ϊ�۲�����¼�쳣��������..." + e.getMessage(), e);
		}
		return i;
	}
}
