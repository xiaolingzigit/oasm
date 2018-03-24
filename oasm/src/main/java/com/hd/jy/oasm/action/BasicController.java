package com.hd.jy.oasm.action;

import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import com.hd.jy.oasm.util.lsc.DataUtil;
import com.hd.jy.oasm.util.lsc.IOCloseUtil;
/***
 * *********�������Ʋ� *******
 * @author quite
 * @data 2018��03��22��
 * @see  
 *
 */
public class BasicController {
	private Logger logger;

	public Logger logger() {
		if(logger == null ){
			logger = Logger.getLogger(getClass());
		}
		return logger;
	}

	/**
	 * SecurityUtils.getSubject()
	 * 
	 * @return
	 */
	public Subject subject() {
		return SecurityUtils.getSubject();
	}

	/**
	 * SecurityUtils.getSubject().getSession()
	 * 
	 * @return
	 */
	public Session subjSession() {
		return SecurityUtils.getSubject().getSession();
	}

	/**
	 * ��ȡHttpSession�����Ե�ԭʼֵ
	 * 
	 * @param request
	 * @param name
	 * @return
	 */
	public Object sesObjAttr(HttpServletRequest request, String name) {
		return request.getSession().getAttribute(name);
	}

	/**
	 * ��ȡHttpSession�����Ե�String��ʽ��ֵ
	 * 
	 * @param request
	 * @param name
	 * @return
	 */
	public String sesStrAttr(HttpServletRequest request, String name) {
		Object obj = sesObjAttr(request, name);
		return obj == null ? null : String.valueOf(obj);
	}

	/**
	 * ��ȡSecurityUtils.getSubject().getSession()�����Ե�ԭʼֵ
	 * 
	 * @param name
	 * @return
	 */
	public Object subjSesObjAttr(String name) {
		return subjSession().getAttribute(name);
	}

	/**
	 * ��ȡSecurityUtils.getSubject().getSession()�����Ե�String��ʽ��ֵ
	 * 
	 * @param request
	 * @param name
	 * @return
	 */
	public String subSesStrAttr(String name) {
		Object obj = subjSesObjAttr(name);
		return obj == null ? null : String.valueOf(obj);
	}

	/**
	 * ��ֵ���õ�HttpSession��
	 * 
	 * @param request
	 * @param name
	 * @param val
	 */
	public void setSessionAttr(HttpServletRequest request, String name,
			Object val) {
		request.getSession().setAttribute(name, val);
	}

	/**
	 * ��ֵ���õ�SecurityUtils.getSubject().getSession()��
	 * 
	 * @param request
	 * @param name
	 * @param val
	 */
	public void setSubjSessionAttr(String name, Object val) {
		subjSession().setAttribute(name, val);
	}

	/**
	 * ��ȡHttpServletRequest�е��������
	 * 
	 * @param request
	 * @param paramName
	 *            ������
	 * @param idx
	 *            ����������Ĭ��0��-1�򷵻������Ӧ���в���
	 * @param fixIdx
	 *            �Ƿ�������������������idx��������ֵ�����������ʱ����Ϊ����ֵ���������
	 * @param trim
	 *            �Ƿ�ȥ������������˿ո�
	 * @param emptyStrAsNull
	 *            �Ƿ�ѿհ��ַ�����null����
	 * @param nullStrAsNull
	 *            �Ƿ��null�ַ�����null����
	 * @return
	 */
	public String rqstParam(HttpServletRequest request, String paramName,
			int idx, boolean fixIdx, boolean trim, boolean emptyStrAsNull,
			boolean nullStrAsNull) {

		String[] rqstVals = request.getParameterMap().get(paramName);
		if (rqstVals == null) {
			paramName = paramName + "[]";
			rqstVals = request.getParameterMap().get(paramName);
		}
		if (rqstVals == null || rqstVals.length == 0) {
			return null;
		}

		if (fixIdx) {
			idx = idx >= rqstVals.length ? rqstVals.length - 1 : idx;
		}

		String val;

		if (idx < 0) {
			if (paramName.endsWith("[]")) {
				val = DataUtil.toString(rqstVals, ",", true);
			} else {
				val = DataUtil.toString(rqstVals, ",", false);
			}
		} else {
			val = rqstVals[idx];
		}

		if (emptyStrAsNull && DataUtil.isEmpty(val)) {
			return null;
		}

		if (nullStrAsNull && DataUtil.isNull(val)) {
			return null;
		}

		return val == null ? null : (trim ? val.trim() : val);
	}

	
	/**
	 * ��ȡHttpServletRequest�е����������ȥ������������˿ո�null��հ��ַ�����null����
	 * 
	 * @param request
	 * @param paramName
	 *            ������
	 * @return
	 */
	public String rqstParam(HttpServletRequest request, String paramName) {
		return rqstParam(request, paramName, -1, true, true, true, true);
	}

	/**
	 * ��ȡHttpServletRequest�е����������ȥ������������˿ո�null�ַ�����null����(������map)��
	 * ���ʺϴ������ֵ���������͵�������Ϊֻ���ȡString[0]��ֵ
	 * 
	 * @param request
	 * @param paramName
	 *            ������
	 * @return never null
	 */
	public Map<String, String> simpleRqstParamMap(HttpServletRequest request) {

		logger().debug("------- request params -------");

		Map<String, String> paramMap = new HashMap<String, String>();
		Map<String, String[]> params = request.getParameterMap();
		boolean noRqstParam = true;
		String key;
		for (Map.Entry<String, String[]> e : params.entrySet()) {
			noRqstParam = false;
			logger().debug(e.getKey() + ": " + DataUtil.toString(e.getValue()));
			key = e.getKey();
			if (key != null && key.endsWith("[]")) {
				key = key.substring(0, key.length() - 2);
			}
			paramMap.put(key, rqstParam(request, e.getKey()));
		}

		if (noRqstParam) {
			logger().debug("no request param");
		}

		logger().debug("---------- paramMap -----------");
		logger().debug("paramMap" + paramMap);
		logger().debug("------------------------------");

		return paramMap;
	}

	/**
	 * ʹ����д������
	 * 
	 * @param resp
	 * @param output
	 * @param charset
	 *            cannot be null
	 */
	public void byteResp(HttpServletResponse resp, String output,
			Charset charset) {
		if (output == null) {
			return;
		}

		if (resp == null) {
			throw new IllegalArgumentException(
					"httpServletResponse cannot be null");
		}

		if (charset == null) {
			throw new IllegalArgumentException("charset cannot be null");
		}

		logger.info("string gonna output: " + output);
		resp.setCharacterEncoding(charset.name());
		byteResp(resp, output.getBytes(charset));
	}

	/**
	 * ʹ����д������
	 * 
	 * @param resp
	 * @param output
	 */
	public void byteResp(HttpServletResponse resp, byte[] output) {
		if (output == null) {
			return;
		}

		if (resp == null) {
			throw new IllegalArgumentException(
					"httpServletResponse cannot be null");
		}

		OutputStream os = null;

		try {
			logger.debug("get OutputStream...");
			os = resp.getOutputStream();
			logger.debug("outputStream write bytes...");
			os.write(output);
			os.flush();
			logger.debug("outputStream write bytes done");
		} catch (Exception e) {
			logger.error("outputStream write bytes failed", e);
		} finally {
			IOCloseUtil.close(os);
		}
	}
}
