package com.hd.jy.oasm.domain;

import com.hd.jy.oasm.model.Oasm;

/** �������ʹ�õĶ��� */
public class TaskAdd extends Oasm {
	/** ����id������(����_�������� _����ʱ��yyyyMMddHHmmss) */
	private String rwid;
	/** ���� */
	private String qh;
	/** �������� */
	private String rwlx;
	/** ��������(Ϊʲô) */
	private String rwyj;
	/** ��������(��ʲô) */
	private String rwms;
	/** ��ע˵�� */
	private String bzsm;
	/** �����������yyyy-MM-dd HH:mm:ss*/
	private String wxqx;
	/** ����ִ���ˣ���ʽ�����ţ��磺123456,234567,...��˵������ʱ��ָ������ִ�����������񷢲�ʱ������ר�ܾ��� */
	private String rwzxr;
	/**���񷢲��ˣ���ʽ������,����,�磺����(123456)*/
	private String rwfbr;
	/**���񷢲�ʱ��yyyy-MM-dd HH:mm:ss*/
	private String fbsj;
	/**����޸�ʱ��last modification*/
	private String zhxgsj;
	/**����޸���*/
	private String zhxgr;
	/**״̬��-1δ������1δ��ʼ��2������(����)��3δ���/�ݴ棬4�����(�����ٱ༭)��10��ȡ��*/
	private int rwzt;
	
	@Override
	public String getNullField(String s) {
		
		return null;
	}
}