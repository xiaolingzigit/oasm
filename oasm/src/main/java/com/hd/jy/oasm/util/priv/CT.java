package com.hd.jy.oasm.util.priv;

/**
 * ����Ŀ���г���
 * 
 * @author admin
 */
public class CT {

	/** �û������� */
	public static final String SER_USR_NAME = "username";
	/** �û�ID���� */
	public static final String SER_USR_ID = "username";

	// ������� request param key
	/** �������� */
	public static final String P_TASK_TYPE = "taskType";
	/** ����ID */
	public static final String P_TASK_ID = "taskId";
	/** ���� */
	public static final String P_PRISON = "prison";
	/** ���� */
	public static final String P_CRIM_NO = "crimNo";
	/** �������� */
	public static final String P_CRIM_NAME = "crimName";
	/** ������Ϣ������Χ:����all,ר��zg/Э��xg/�����˾���zxr */
	public static final String P_COP_RANGE = "copRange";
	/** ���� */
	public static final String P_COP_NO = "copNo";
	/** ���� */
	public static final String P_COP_NAME = "copName";
	/** ����ִ���� */
	public static final String P_EXCUTOR = "excutor";
	/** ���񴴽��� */
	public static final String P_CREATOR = "creator";
	/** ���񴴽�ʱ�䷶Χ��ʼ */
	public static final String P_CR_TIME_START = "crTimeStart";
	/** ���񴴽�ʱ�䷶Χ���� */
	public static final String P_CR_TIME_END = "crTimeEnd";
	/** �������ʱ�䷶Χ���� */
	public static final String P_DEADLINE_START = "deadlineStart";
	/** �������ʱ�䷶Χ���� */
	public static final String P_DEADLINE_END = "deadlineEnd";
	/** �����޸�ʱ�䷶Χ��ʼ */
	public static final String P_LAST_MODIF_START = "lastModifStart";
	/** �����޸�ʱ�䷶Χ��ʼ */
	public static final String P_LAST_MODIF_END = "lastModifEnd";
	/** ����״̬ */
	public static final String P_STATUS = "status";
	/** �������� */
	public static final String P_TASK_BASIS = "taskBasis";
	/** ��������/���� */
	public static final String P_TASK_DESCRIB = "taskDescrib";
	/** ����������� */
	public static final String P_DEADLINE = "deadline";
	/** ���񴴽�ʱ�� */
	public static final String P_CR_TIME = "crTime";
	/** ��������޸�ʱ�� */
	public static final String P_LAST_MODIF = "lastModif";
	/** ����ִ���� */
	public static final String P_MODIFIER = "modifier";
	/** ����ѡ��� */
	public static final String P_ANSWER = "answer";
	/** �����ܳɼ� */
	public static final String P_SCORE = "score";
	/** ���Եȼ� */
	public static final String P_LEVEL = "level";
	/** ���Ա��� */
	public static final String P_RESULT = "result";
	/** �������ż��� */
	public static final String P_OP_CODE = "op";// operation

	// TODO ������
	
	
	/**��ȡ������Ա��ϵ��Ϣ*/
	public static final String  OPV_GET_CRIM_COP_INFO= "crimCopInfo";
	/**����ǰ��Ȩ����Ϣ��*/
	public static final String OPV_INIT_WEB = "initWeb";
	/** ������� */
	public static final String OPV_TASK_ADD = "taskAdd";
	/** ��������״̬ */
	public static final String OPV_TASK_UPDATE = "taskUpdate";
	/** ȡ������ */
	public static final String OPV_TASK_CANCEL = "taskCancel";
	/** ��ȡ����/��¼�б� */
	public static final String OPV_TASK_GET_LIST = "taskGetList";
	/** ��ȡ����/��¼�б� */
	public static final String OPV_TASK_GET_TODO = "taskGetTodo";
	/** ������������ƥ�䣬��ȡ����/��¼�б� */
	public static final String OPV_TASK_GET_LIST_BY_LIKE = "taskGetListByTypeLike";
	/** ������������¼ */
	public static final String OPV_TEST_SAVE = "testSave";
	/** ��ȡ���������¼�����ɼ��ͱ��棩 */
	public static final String OPV_TEST_QUERY = "testQuery";

	/** ������Ϣ������Χ������ */
	public static final String COP_RANGE_ALL = "all";
	/** ������Ϣ������Χ��ר�� */
	public static final String COP_RANGE_ZG = "zg";
	/** ������Ϣ������Χ��Э�� */
	public static final String COP_RANGE_XG = "xg";
	/** ������Ϣ������Χ������ִ����modifier */
	public static final String COP_RANGE_ZXR = "zxr";

	// TODO ����״̬��

	/** ���񲻴��� */
	public static final int TS_NULL = -100;
	/** ����ݸ�(δ����������,�ɱ༭,scratch file ) */
	public static final int TS_SCR = -1;// scratch file
	/** ���������� */
	public static final int TS_NEW = 1;
	/** �����е����� */
	public static final int TS_PEOCESSING = 2;// processing center
	/** �ݴ������ */
	public static final int TS_SAVED = 3;// processing center
	/** ��ɵ����� */
	public static final int TS_FINISHED = 4;
	/** ȡ�������� */
	public static final int TS_CANCELED = 10;

	private static final String TN_NULL = "���񲻴���";
	/** ����ݸ�(δ����������,�ɱ༭,scratch file ) */
	private static final String TN_SCR = "δ����";// scratch file
	/** ���������� */
	private static final String TN_NEW = "δ��ʼ";
	/** �����е����� */
	private static final String TN_PEOCESSING = "������";
	/** �ݴ�/δ��ɵ����� */
	private static final String TN_SAVED = "δ���";
	/** ��ɵ����� */
	private static final String TN_FINISHED = "�����";
	/** ȡ�������� */
	private static final String TN_CANCELED = "��ȡ��";
	/** δ֪������״̬ */
	private static final String TN_UNKNOWN = "δ֪";

	/**
	 * ��ȡ״̬���Ӧ����״̬����
	 * 
	 * @param status
	 *            ״̬��CT.TASK_*
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

	//������������ֲ�������
	/**��������*/
	public static final String PG_DAFX = "DAFX";
	/**��Ϊ�۲�*/
	public static final String PG_XWGC = "XWGC";
	/**�����̸*/
	public static final String PG_GTFT = "GTFT";
	/**�����̸*/
	public static final String PG_JTFT = "JTFT";
	/**SCL-90�������*/
	public static final String PG_XLSCL90 = "XLSCL90";
	/**COPA-PI�������*/
	public static final String PG_XLCOPAPI = "XLCOPAPI";
	/**����������*/
	public static final String PG_XLRJ = "XLRJ";
	/**����������ԣ������Ӧ���������*/
	public static final String PG_XLCJ = "XLCJ";
	
	
	
	
	
	
	
	// TODO ������Ϣ
	/** ��Ч�����󣬲�����Ϊ�ջ򲻴��� */
	public static final String MSG_INVAL_RQST = "������Ч";// "��Ч������"
	/** ��Ч������ID��Ϊ�ջ򲻴��� */
	public static final String MSG_INVAL_TASK_ID = "����ID��Ч";
	/** ��Ч��״̬�룬Ϊ�ջ򲻴��ڻ������ */
	public static final String MSG_INVAL_STATUS_CODE = "״̬����Ч";
	/** �û���Ϊ�գ�δ��¼ */
	public static final String MSG_TO_LOGIN = "���ȵ�¼";
}
