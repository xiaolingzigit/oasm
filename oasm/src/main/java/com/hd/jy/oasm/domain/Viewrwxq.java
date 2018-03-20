package com.hd.jy.oasm.domain;
/***
 * 判定总任务完成状态
 * TODO
 * @author quite
 * @data 2017年12月25日
 * @see  映射文件TestMapper.xml
 *
 */
public class Viewrwxq {
    private String parentId; //父任务编号

    private String childId; //子任务编号
    
    private String type; //子任务类型 

    private String name; //任务名字

    private Double score; //分数

    private String levl; //等级

    private Integer status; //子任务完成状态
    
    private String answer; //答题情况

    private String result; //报告记录

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }
    
    

    public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    public String getChildId() {
        return childId;
    }

    public void setChildId(String childId) {
        this.childId = childId == null ? null : childId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getLevl() {
        return levl;
    }

    public void setLevl(String levl) {
        this.levl = levl == null ? null : levl.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}