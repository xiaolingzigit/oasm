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
 * *********基础控制层 *******
 * @author quite
 * @data 2018年03月22日
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
	 * 获取HttpSession中属性的原始值
	 * 
	 * @param request
	 * @param name
	 * @return
	 */
	public Object sesObjAttr(HttpServletRequest request, String name) {
		return request.getSession().getAttribute(name);
	}

	/**
	 * 获取HttpSession中属性的String格式的值
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
	 * 获取SecurityUtils.getSubject().getSession()中属性的原始值
	 * 
	 * @param name
	 * @return
	 */
	public Object subjSesObjAttr(String name) {
		return subjSession().getAttribute(name);
	}

	/**
	 * 获取SecurityUtils.getSubject().getSession()中属性的String格式的值
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
	 * 将值设置到HttpSession中
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
	 * 将值设置到SecurityUtils.getSubject().getSession()中
	 * 
	 * @param request
	 * @param name
	 * @param val
	 */
	public void setSubjSessionAttr(String name, Object val) {
		subjSession().setAttribute(name, val);
	}

	/**
	 * 获取HttpServletRequest中的请求参数
	 * 
	 * @param request
	 * @param paramName
	 *            参数名
	 * @param idx
	 *            参数索引，默认0，-1则返回数组对应所有参数
	 * @param fixIdx
	 *            是否修正索引。若修正，idx超过参数值数组最大索引时修正为参数值数组最大索
	 * @param trim
	 *            是否去除请求参数两端空格
	 * @param emptyStrAsNull
	 *            是否把空白字符串当null处理
	 * @param nullStrAsNull
	 *            是否把null字符串当null处理
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
	 * 获取HttpServletRequest中的请求参数，去除请求参数两端空格，null或空白字符串当null处理
	 * 
	 * @param request
	 * @param paramName
	 *            参数名
	 * @return
	 */
	public String rqstParam(HttpServletRequest request, String paramName) {
		return rqstParam(request, paramName, -1, true, true, true, true);
	}

	/**
	 * 获取HttpServletRequest中的请求参数，去除请求参数两端空格，null字符串当null处理(不加入map)。
	 * 不适合处理参数值是数组类型的请求。因为只会获取String[0]的值
	 * 
	 * @param request
	 * @param paramName
	 *            参数名
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
	 * 使用流写出数据
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
	 * 使用流写出数据
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
