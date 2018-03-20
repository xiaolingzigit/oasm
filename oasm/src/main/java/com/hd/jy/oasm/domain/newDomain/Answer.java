package com.hd.jy.oasm.domain.newDomain;
/***
 * 答案json类
 * @author quite
 *
 */
public class Answer {
	
   private String fId; //因子编号
   
   private String fName; //因子名称

   private String dimId; //维度编号
   
   private String dimName; //维度名称
   
   private String score; //单个因子分数
   
   private String scores; //整份试题分数

public String getfId() {
	return fId;
}

public void setfId(String fId) {
	this.fId = fId;
}

public String getfName() {
	return fName;
}

public void setfName(String fName) {
	this.fName = fName;
}

public String getDimId() {
	return dimId;
}

public void setDimId(String dimId) {
	this.dimId = dimId;
}

public String getDimName() {
	return dimName;
}

public void setDimName(String dimName) {
	this.dimName = dimName;
}

public String getScore() {
	return score;
}

public void setScore(String score) {
	this.score = score;
}

public String getScores() {
	return scores;
}

public void setScores(String scores) {
	this.scores = scores;
}
   
}
