package com.hd.jy.oasm.util.lsc.basicmodel;

import java.nio.charset.Charset;

import com.hd.jy.oasm.util.lsc.DataUtil;
import com.hd.jy.oasm.util.lsc.GsonUtil;
import com.hd.jy.oasm.util.lsc.excpts.IllegalException;
import com.hd.jy.oasm.util.lsc.excpts.MismatchException;
import com.hd.jy.oasm.util.lsc.excpts.NullException;

public class BasicMsg extends BasicModel {
	private String flag;
	private String msgType;// 信息种类
	private String content;

	public BasicMsg() {

	}

	public BasicMsg(String flag, String msgType, Object content) {
		this.flag = flag;
		this.msgType = msgType;

		setContent(content);
	}

	public String getFlag() {
		return flag;
	}

	public String getFlag(boolean trim) {
		if (flag == null) {
			return null;
		}

		if (trim) {
			return flag.trim();
		} else {
			return flag;
		}
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getMsgType() {
		return msgType;
	}

	public String getMsgType(boolean trim) {
		if (msgType == null) {
			return null;
		}

		if (trim) {
			return msgType.trim();
		} else {
			return msgType;
		}
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(Object content) {
		if (content != null) {
			this.content = GsonUtil.toJson(content);
		} else {
			this.content = null;
		}
	}

	/**
	 * 
	 * @param data
	 *            由报文长度标志位4byte+报文内容(+其他多余数据)组成的字节数组
	 * @param charset
	 *            编码
	 * @return
	 */
	public BasicMsg fromBytes(byte[] data, Charset charset) {
		if (data == null) {
			throw new NullException("data", "");
		}

		if (data.length < 14) {
			throw new MismatchException("dataLen[" + data.length
					+ "] < 14, HexString[" + DataUtil.toHexString(data) + "]");
		}

		int contentLen = -1;

		int index = 0;
		byte[] subTmp = DataUtil.byteArrCutByIdx(data, index, index += 2);

		this.flag = new String(subTmp, charset);

		try {
			subTmp = DataUtil.byteArrCutByIdx(data, index, index += 8);
			contentLen = DataUtil.toInt(subTmp, charset);
		} catch (Exception e) {
			throw new IllegalException("get content length failed, subTmp["
					+ DataUtil.toHexString(subTmp) + "], contents["
					+ DataUtil.toHexString(data) + "]", e);
		}

		if (contentLen < 0 || data.length < contentLen + 10) {// 10=2+8
			throw new MismatchException("actualLen[" + data.length
					+ "] < requiredLen[" + contentLen + 10
					+ "], hexString of data[" + DataUtil.toHexString(data)
					+ "]");
		}

		this.msgType = new String(DataUtil.byteArrCutByIdx(data, index,
				index += 4), charset);

		this.content = new String(DataUtil.byteArrCut(data, index,
				contentLen - 4), charset);

		return this;
	}

	/**
	 * 將信息内容转化成flag(2b)contentLen(8b)content格式的字节数组
	 * 
	 * @return
	 */
	public byte[] toBytes(Charset charset) {

		byte[] contentBs = (content == null ? "" : content)
				.getBytes(charset);

		byte[] outBs = new byte[contentBs.length + 14];// 14=2+8+4

		int index = 0;
		DataUtil.arrCopy(DataUtil.fitByteLen(flag, charset, 2, false, true)
				.getBytes(charset), 0, outBs, index);

		// 类型4+内容长度
		DataUtil.arrCopy(
				DataUtil.fitByteLen((contentBs.length + 4), charset, 8, false,
						true).getBytes(charset), 0, outBs, index += 2);

		DataUtil.arrCopy(DataUtil.fitByteLen(msgType, charset, 4, false, true)
				.getBytes(charset), 0, outBs, index += 8);

		DataUtil.arrCopy(contentBs, 0, outBs, index += 4);

		return outBs;
	}

	/**
	 * 将信息内容转化成flag(2b)contentLen(8b)content格式的16进制字符
	 * 
	 * @return
	 */
	public String toHexString(Charset charset) {
		return DataUtil.toHexString(toBytes(charset));
	}

	/**
	 * 将flag(2b)contentLen(8b)content格式的16进制字符转化成BasicMsg
	 * 
	 * @param hexString
	 * @param charset
	 * @return
	 * @throws Exception
	 */
	public BasicMsg fromHexString(String hexString, Charset charset)
			throws Exception {
		return fromBytes(DataUtil.hexStr2Bytes(hexString), charset);
	}

	public String toJson() {
		return GsonUtil.toJson(this);
	}
}
