/**
 * 
 */
package com.hd.jy.oasm.domain.newDomain;

import java.util.List;

import com.hd.jy.oasm.domain.JYXX;

/**
 * 返回前端提示信息
 * @author quite
 *
 */
public class Tip {
	
	private String nullFlie; //非空文件提示
	
	private String nullFont; //文件里面有空的字段

	private List<String> strMsg; //错误提示
	
	private List<JYXX> jyxx; //成功返回的信息

    
	/**
	 * @return the strMsg
	 */
	public List<String> getStrMsg() {
		return strMsg;
	}

	/**
	 * @param strMsg the strMsg to set
	 */
	public void setStrMsg(List<String> strMsg) {
		this.strMsg = strMsg;
	}

	/**
	 * @return the nullFont
	 */
	public String getNullFont() {
		return nullFont;
	}

	/**
	 * @param nullFont the nullFont to set
	 */
	public void setNullFont(String nullFont) {
		this.nullFont = nullFont;
	}

	/**
	 * @return the nullFlie
	 */
	public String getNullFlie() {
		return nullFlie;
	}

	/**
	 * @param nullFlie the nullFlie to set
	 */
	public void setNullFlie(String nullFlie) {
		this.nullFlie = nullFlie;
	}


	/**
	 * @return the jyxx
	 */
	public List<JYXX> getJyxx() {
		return jyxx;
	}

	/**
	 * @param jyxx the jyxx to set
	 */
	public void setJyxx(List<JYXX> jyxx) {
		this.jyxx = jyxx;
	}
}
