package com.hd.jy.oasm.domain;
/***
 * �ж����������״̬
 * TODO
 * @author quite
 * @data 2017��12��25��
 * @see  ӳ���ļ�TestMapper.xml
 *
 */
public class Viewrwxq {
    private String parentId; //��������

    private String childId; //��������
    
    private String type; //���������� 

    private String name; //��������

    private Double score; //����

    private String levl; //�ȼ�

    private Integer status; //���������״̬
    
    private String answer; //�������

    private String result; //�����¼

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