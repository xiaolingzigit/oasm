package com.hd.jy.oasm.domain.newDomain;

import java.util.Date;
/***
 * 问题表
 * @author quite
 * 
 * 集成到newMapp tdminAndtyz.xml
 * 业务接口TdminAndtyzDao
 *
 */
public class TQuestion {
    private int qstId; //问题编号，主键，自增

    private int dimId; //维度表  关联编号

    private String orgId; //组织编号  标识监狱

    private String question; //问题

    private int type; //问题类型  1：单选，2：多选

    private String remark; //描述，判断依据

    private String options; //选项   有格式字符串，如：选项号,选项内容,关联因子ID,关联因子名称;...

    private String answer; //答案 可空，格式：选项号,选项号,...

    private String creator;//创建人

    private Date crTime;//创建时间

    private Date lastModif;//最后修改时间

    private String modifier;//最后修改人

    private int status;//-1未发布，1未启用，2已启用，10已弃用		
    
    private Tdmin tdmin; //问题表关联维度表
    
    public Tdmin getTdmin() {
		return tdmin;
	}

	public void setTdmin(Tdmin tdmin) {
		this.tdmin = tdmin;
	}

	public int getQstId() {
        return qstId;
    }

    public void setQstId(int qstId) {
        this.qstId = qstId;
    }

    public int getDimId() {
        return dimId;
    }

    public void setDimId(int dimId) {
        this.dimId = dimId;
    }
    
    public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question == null ? null : question.trim();
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options == null ? null : options.trim();
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public Date getCrTime() {
        return crTime;
    }

    public void setCrTime(Date crTime) {
        this.crTime = crTime;
    }

    public Date getLastModif() {
        return lastModif;
    }

    public void setLastModif(Date lastModif) {
        this.lastModif = lastModif;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}