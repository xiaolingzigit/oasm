/**
 * 
 */
package com.hd.jy.oasm.domain.newDomain;

import java.util.List;

import com.hd.jy.oasm.domain.JYXX;

/**
 * ����ǰ����ʾ��Ϣ
 * @author quite
 *
 */
public class Tip {
	
	private String nullFlie; //�ǿ��ļ���ʾ
	
	private String nullFont; //�ļ������пյ��ֶ�

	private List<String> strMsg; //������ʾ
	
	private List<JYXX> jyxx; //�ɹ����ص���Ϣ

    
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
