package com.hd.jy.oasm.domain.newDomain;

import java.util.List;
/***
 * 问题类 为了把对象封装成JSON在前台使用
 * @author quite
 *
 */
public class Question {
	private int qId; //问题编号
	
	private String type; //问题单选多选

	private String qName; //问题名字
	
	private String qRemark; //问题描述
	
	private String orgId; //监狱号

	private int dimId; //维度编号
	
	private String dimName; //维度名称

	private List<Option> options; //选项号
	

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
		private String opNo; //选项号

		private String optionContext; //选项内容

		private String factorId; //因子编号

		private String factorName; //因子内容

		private String fscore; //因子分值
		
		private String qz; //因子分权重

		
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
