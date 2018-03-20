package com.hd.jy.oasm.util.lsc;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
//需要的jar包：
//commons-logging-1.2_jdk12.jar
//log4j-1.2.17.jar
//slf4j-api-1.7.14.jar
//slf4j-log4j12-1.7.7.jar

/**
 * log4j配置和Logger获取工具
 * 
 * @author ander
 * 
 */
public class Log4jUtil {
	// Log logger = LogFactory.getLog(getClass());

	// config/log4j.xml,log4j.properties
	// private static final String configfile = "conf/log4j.properties";
	private static final String configfile = "D:/testConf/log4j.xml";

	static {
		// initWithProperties(configfile, false);
		initWithXML(configfile);
	}

	public static void initWithProperties(String propertyFile, boolean inSrc) {
		if (inSrc) {
			InputStream is = Log4jUtil.class.getClassLoader()
					.getResourceAsStream(propertyFile);

			org.apache.log4j.PropertyConfigurator.configure(is);
		} else {
			org.apache.log4j.PropertyConfigurator.configure(propertyFile);
		}
	}

	public static void initWithXML(String xmlFile) {
		org.apache.log4j.xml.DOMConfigurator.configure(xmlFile);
	}

	public static Logger getLogger(Class<?> clazz) {
		return Logger.getLogger(clazz);
	}

	public static Logger getLogger(String clsName) {
		return Logger.getLogger(clsName);
	}

	public static Logger getLogger(String clsName, LoggerFactory factory) {
		return Logger.getLogger(clsName, factory);
	}

	public static Logger getRootLogger() {
		return Logger.getRootLogger();
	}

	// Map<String, MLogger><==>Map<clsName, MLogger>
	private static final Map<String, MLogger> mLoggerMap = new HashMap<String, Log4jUtil.MLogger>();
	private static final String ROOT_MLOGGER = "ROOT_MLOGGER";

	public static MLogger getMLogger(Class<?> clazz) {
		MLogger mLoggger = mLoggerMap.get(clazz.getName());
		if (mLoggger == null) {
			mLoggger = new MLogger(clazz);
			mLoggerMap.put(clazz.getName(), mLoggger);
		}
		return mLoggger;
	}

	public static MLogger getMLogger(String clsName) {
		MLogger mLoggger = mLoggerMap.get(clsName);
		if (mLoggger == null) {
			mLoggger = new MLogger(clsName);
			mLoggerMap.put(clsName, mLoggger);
		}

		return mLoggger;
	}

	public static MLogger getMLogger(String clsName, LoggerFactory factory) {
		MLogger mLoggger = mLoggerMap.get(clsName);
		if (mLoggger == null) {
			mLoggger = new MLogger(clsName, factory);
			mLoggerMap.put(clsName, mLoggger);
		}
		return mLoggger;
	}

	public static MLogger getMRootLogger() {
		MLogger mLoggger = mLoggerMap.get(ROOT_MLOGGER);
		if (mLoggger == null) {
			mLoggger = new MLogger();
			mLoggerMap.put(ROOT_MLOGGER, mLoggger);
		}
		return mLoggger;
	}

	public static class MLogger {
		boolean addThrowableMsg = true;// 是否msg+t.getMessage()
		Logger logger;

		public MLogger() {
			logger = getRootLogger();
		}

		public MLogger(Class<?> clazz) {
			logger = getLogger(clazz);
		}

		public MLogger(String clsName) {
			logger = getLogger(clsName);
		}

		public MLogger(String clsName, LoggerFactory factory) {
			logger = getLogger(clsName, factory);
		}

		/**
		 * 是否做msg+e.getMessage()消息拼接处理，默认fasle
		 * 
		 * @param addThrowableMsg
		 */
		public void setAddThrowableMsg(boolean addThrowableMsg) {
			this.addThrowableMsg = addThrowableMsg;
		}

		public void fatal(Object msg, Throwable e) {
			logger.fatal(msg(msg, e), e);
		}

		public void fatal(Object... msg) {
			logger.fatal(DataUtil.toString(msg, " ", false));
		}

		public void debug(Object msg, Throwable e) {
			logger.debug(msg(msg, e), e);
		}

		public void debug(Object... msg) {
			logger.debug(DataUtil.toString(msg, " ", false));
		}

		public void info(Object msg, Throwable e) {
			logger.info(msg(msg, e), e);
		}

		public void info(Object... msg) {
			logger.info(DataUtil.toString(msg, " ", false));
		}

		public void warn(Object msg, Throwable e) {
			logger.warn(msg(msg, e), e);
		}

		public void warn(Object... msg) {
			logger.warn(DataUtil.toString(msg, " ", false));
		}

		public void error(Object msg, Throwable e) {
			logger.error(msg(msg, e), e);
		}

		public void error(Object... msg) {
			logger.error(DataUtil.toString(msg, " ", false));
		}

		/**
		 * 异常信息拼接
		 * 
		 * @param msgs
		 * @param e
		 * @return msg string
		 */
		private Object msg(Object msg, Throwable e) {

			if (!addThrowableMsg || e == null) {
				return msg;
			}

			StringBuilder sbd = new StringBuilder();

			if (msg != null) {
				sbd.append(msg);
				sbd.append(": ");
			}

			sbd.append(e.getMessage());

			return sbd.toString();
		}

	}

}
