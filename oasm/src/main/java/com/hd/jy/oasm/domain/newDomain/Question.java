package com.hd.jy.oasm.domain.newDomain;

import java.util.List;
/***
 * ������ Ϊ�˰Ѷ����װ��JSON��ǰ̨ʹ��
 * @author quite
 *
 */
public class Question {
	private int qId; //������
	
	private String type; //���ⵥѡ��ѡ

	private String qName; //��������
	
	private String qRemark; //��������
	
	private String orgId; //������

	private int dimId; //ά�ȱ��
	
	private String dimName; //ά������

	private List<Option> options; //ѡ���
	

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Question() {
		super();
	}

	public Question(int qId, String qName, String qRemark, String orgId, int dimId, String dimName,
			List<Option> options) {
		super();
		this.qId = qId;
		this.qName = qName;
		this.qRemark = qRemark;
		this.orgId = orgId;
		this.dimId = dimId;
		this.dimName = dimName;
		this.options = options;
	}

	public List<Option> getOptions() {
		return options;
	}

	public void setOptions(List<Option> options) {
		this.options = options;
	}

	public int getDimId() {
		return dimId;
	}

	public void setDimId(int dimId) {
		this.dimId = dimId;
	}

	public String getqRemark() {
		return qRemark;
	}

	public void setqRemark(String qRemark) {
		this.qRemark = qRemark;
	}

	public int getqId() {
		return qId;
	}

	public void setqId(int qId) {
		this.qId = qId;
	}
	
	public String getqName() {
		return qName;
	}

	public void setqName(String qName) {
		this.qName = qName;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getDimName() {
		return dimName;
	}

	public void setDimName(String dimName) {
		this.dimName = dimName;
	}

	public static class Option {
		private String opNo; //ѡ���

		private String optionContext; //ѡ������

		private String factorId; //���ӱ��

		private String factorName; //��������

		private String fscore; //���ӷ�ֵ
		
		private String qz; //���ӷ�Ȩ��

		
		public Option() {
			super();
		}


		public Option(String opNo, String optionContext, String factorId, String factorName, String fscore) {
			super();
			this.opNo = opNo;
			this.optionContext = optionContext;
			this.factorId = factorId;
			this.factorName = factorName;
			this.fscore = fscore;
		}
       
		public Option(String opNo, String optionContext, String factorId, String factorName, String fscore, String qz) {
			super();
			this.opNo = opNo;
			this.optionContext = optionContext;
			this.factorId = factorId;
			this.factorName = factorName;
			this.fscore = fscore;
			this.qz = qz;
		}


		public String getQz() {
			return qz;
		}

		public void setQz(String qz) {
			this.qz = qz;
		}

		public String getFscore() {
			return fscore;
		}


		public void setFscore(String fscore) {
			this.fscore = fscore;
		}


		public String getOpNo() {
			return opNo;
		}

		public void setOpNo(String opNo) {
			this.opNo = opNo;
		}

		public String getOptionContext() {
			return optionContext;
		}

		public void setOptionContext(String optionContext) {
			this.optionContext = optionContext;
		}

		public String getFactorId() {
			return factorId;
		}

		public void setFactorId(String factorId) {
			this.factorId = factorId;
		}

		public String getFactorName() {
			return factorName;
		}

		public void setFactorName(String factorName) {
			this.factorName = factorName;
		}

	}
}
