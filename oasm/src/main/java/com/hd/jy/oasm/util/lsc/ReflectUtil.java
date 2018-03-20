package com.hd.jy.oasm.util.lsc;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.hd.jy.oasm.util.lsc.date.DateUtil;
import com.hd.jy.oasm.util.lsc.excpts.ParseException;
import com.hd.jy.oasm.util.priv.C;

public class ReflectUtil {

	/**
	 * 将map中的值反射成对象属性中的值。map中的key必须与成员属性的名称完全一致。
	 * 
	 * @param valMap
	 * @param clazz
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public static <T> T toInstance(Map<String, ?> valMap, Class<T> clazz)
			throws InstantiationException, IllegalAccessException {
		T obj = clazz.newInstance();
		RfResult rfrs = ReflectUtil.reflect(obj, true);
		for (Map.Entry<String, RfElement> ele : rfrs.getRfElementMap()
				.entrySet()) {
			ReflectUtil.setValueOfField(obj, ele.getKey(),
					valMap.get(ele.getKey()));
		}

		return obj;
	}

	/**
	 * 通过反射获取对象的属性和属性值的获取和设置方法，属性名不区分大小写
	 * 
	 * @param obj
	 * @param refSuper
	 *            是否反射获取父类的内容，不含Object
	 * @return
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public static RfResult reflect(Object obj, boolean refSuper)
			throws IllegalArgumentException, IllegalAccessException {

		RfResult result = new RfResult();
		result.obj = obj;

		List<Class<?>> clazzList = new ArrayList<>();

		Class<?> clazz = obj.getClass();
		// 获取对象相关的类
		for (; clazz != Object.class; clazz = clazz.getSuperclass()) {
			clazzList.add(clazz);
			if (!refSuper) {
				break;
			}
		}

		// 按继承顺序，遍历处理获取到的类
		for (int c = clazzList.size() - 1; c >= 0; c--) {
			try {
				clazz = clazzList.get(c);
				// 获取该类所有属性
				Field[] fields = clazz.getDeclaredFields();
				int fieldLen = fields.length;

				// 将获取的属性封装后 添加到RfResult
				for (int i = 0; i < fieldLen; i++) {
					Field field = fields[i];
					RfElement rfe = new RfElement();
					rfe.field = field;
					// 添加属性域对象
					result.addRfElement(field.getName(), rfe);
				}

				// 获取类中的方法
				Method[] methods = clazz.getDeclaredMethods();// 获取所有方法，含私有
				for (int i = 0; i < methods.length; i++) {

					Method method = methods[i];
					String name = method.getName();
					RfElement rfEle;

					if (name.startsWith("get")) {
						name = name.substring(3);

						rfEle = result.getRfElement(firstLowerCase(name));
						if (rfEle == null) {
							rfEle = result.getRfElement(name);
						}

						if (rfEle != null) {
							rfEle.getMethod = method;
						}

					} else if (name.startsWith("set")) {
						name = name.substring(3);

						rfEle = result.getRfElement(firstLowerCase(name));
						if (rfEle == null) {
							rfEle = result.getRfElement(name);
						}

						// boolean型is开头属性set方法会省略is
						if (rfEle == null) {
							rfEle = result.getRfElement("is" + name);
						}

						if (rfEle != null) {
							rfEle.setMethod = method;
						}
					} else if (name.startsWith("is")) {// boolean型is开头属性get方法会省略get
						name = name.substring(2);

						rfEle = result.getRfElement(firstLowerCase(name));
						if (rfEle == null) {
							rfEle = result.getRfElement(name);
						}

						if (rfEle == null) {
							rfEle = result.getRfElement("is" + name);// isA属性方法名一般是isA，isa则isIsa
						}
						if (rfEle != null) {
							rfEle.getMethod = method;
						}
					} else {// 非常规属性的获取和设置方法
						result.addOtherMethod(method);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		// 获取对象属性值
		for (Map.Entry<String, RfElement> e : result.getRfElementMap()
				.entrySet()) {
			e.getValue().value = getValOfField(obj, e.getValue().field);
		}

		return result;
	}

	/**
	 * 通过完整类名创建实例。该类必须非abstract,interface,必须具有无参公有构造方法
	 * 
	 * @param <T>
	 * 
	 * @param classPath
	 * @return
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public static <T> T newInstance(String classPath)
			throws ClassNotFoundException, InstantiationException,
			IllegalAccessException {

		@SuppressWarnings("unchecked")
		Class<T> clazz = (Class<T>) Class.forName(classPath);
		// Class<T> clazz =
		// (Class<T>) ReflectUtil.class.getClassLoader().loadClass(classPath);
		return clazz.newInstance();
	}

	/**
	 * 给对象值域设置值
	 * 
	 * @param obj
	 * @param field
	 * @param fieldVal
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public static void setValueOfField(Object obj, Field field, Object fieldVal)
			throws IllegalArgumentException, IllegalAccessException {

		boolean isAccessible = field.isAccessible();// 缓存访问权限

		field.setAccessible(true);// 开启访问权限
		field.set(obj, fieldVal);// 给值域设置值
		field.setAccessible(isAccessible);// 复位访问权限
	}

	/**
	 * 给对象值域设置值
	 * 
	 * @param obj
	 * @param fieldName
	 * @param fieldVal
	 *            基本数据类型和符合****(.-/年)*(.-/月)*(.-/日)[
	 *            ]*(:时)*(:分)*(.秒)*(毫秒)]格式的日期字符串，可以根据Field数据类型自动识别转化
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws NumberFormatException
	 * @throws ParseException
	 */
	public static void setValueOfField(Object obj, String fieldName,
			Object fieldVal) throws IllegalArgumentException,
			IllegalAccessException {

		RfResult rfrs = reflect(obj, true);

		RfElement rfEle = rfrs.getRfElement(fieldName);
		if (rfEle == null) {// 没有符合该名称的属性，抛异常
			throw new IllegalAccessException("field named[" + fieldName
					+ "] is not exist");
		}

		Field field = rfEle.field;

		boolean isAccessible = field.isAccessible();// 缓存访问权限
		field.setAccessible(true);// 开启访问权限

		String fieldType = field.getType().getSimpleName();
		String inputType = fieldVal == null ? null : fieldVal.getClass()
				.getSimpleName();

		// 输入值为null（没有类型）、输入值不是String型、输入值为空白字符串，
		// 或者输入值和Field都是String型，不做 字符串转基本数据类型处理
		if (inputType == null || !"String".equals(inputType)
				|| DataUtil.isEmpty(fieldVal) || "String".equals(fieldType)) {
			field.set(obj, fieldVal);
		} else {
			String fieldValStr = String.valueOf(fieldVal).trim();

			try {
				if ("int".equals(fieldType) || "Integer".equals(fieldType)) {
					field.set(obj, Integer.parseInt(fieldValStr));

				} else if ("Long".equalsIgnoreCase(fieldType)) {
					field.set(obj, Long.parseLong(fieldValStr));

				} else if ("Float".equalsIgnoreCase(fieldType)) {
					field.set(obj, Float.parseFloat(fieldValStr));

				} else if ("Double".equalsIgnoreCase(fieldType)) {
					field.set(obj, Double.parseDouble(fieldValStr));

				} else if ("Boolean".equalsIgnoreCase(fieldType)) {
					field.set(obj, Boolean.parseBoolean(fieldValStr));

				} else if ("Short".equalsIgnoreCase(fieldType)) {
					field.set(obj, Short.parseShort(fieldValStr));

				} else if ("Byte".equalsIgnoreCase(fieldType)) {
					field.set(obj, Byte.parseByte(fieldValStr));

				} else if ("Date".equals(fieldType)) {
					field.set(obj, DateUtil.toDate(fieldValStr, null));

				} else {// 未知情况
					field.set(obj, fieldVal);// 给值域设置值
				}
			} catch (NumberFormatException e) {
				throw new ParseException("string[" + fieldValStr
						+ "] parse to " + fieldType + " failed", e);
			}
		}

		field.setAccessible(isAccessible);// 复位访问权限
	}

	/**
	 * 获取对象值域的值
	 * 
	 * @param data
	 * @param field
	 * @return
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public static Object getValOfField(Object obj, Field field)
			throws IllegalArgumentException, IllegalAccessException {

		boolean isFieldAccessible = field.isAccessible();
		field.setAccessible(true); // 开启访问权限
		Object val = field.get(obj);// 获取属性值
		field.setAccessible(isFieldAccessible);// 复位访问权限

		return val;
	}

	/**
	 * 获取对象值域的值
	 * 
	 * @param data
	 * @param fieldName
	 * @return
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 */
	public static Object getValOfField(Object obj, String fieldName)
			throws IllegalArgumentException, IllegalAccessException,
			SecurityException, NoSuchMethodException, InvocationTargetException {

		RfResult rfrs = reflect(obj, true);
		RfElement rfEle = rfrs.getRfElement(fieldName);
		if (rfEle == null) {
			return null;
		}

		Field field = rfEle.field;
		boolean isFieldAccessible = field.isAccessible();
		field.setAccessible(true); // 开启访问权限

		Object val = field.get(obj);// 获取属性值

		field.setAccessible(isFieldAccessible);// 复位访问权限

		return val;
	}

	/**
	 * 根据方法名执行对象中的方法
	 * 
	 * @param obj
	 * @param methodName
	 *            方法名
	 * @param paramValues
	 *            参数类型和参数值
	 * @return 无返回值则null
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public static Object invokeWithMethodName(Object obj, String methodName,
			ParamValues paramValues) throws SecurityException,
			NoSuchMethodException, IllegalArgumentException,
			IllegalAccessException, InvocationTargetException {

		Class<? extends Object> clazz = obj.getClass();

		Method method;
		Object val;

		if (paramValues == null || paramValues.getParamTypes().length == 0) {
			method = clazz.getMethod(methodName, new Class[] {});
			val = method.invoke(obj, new Object[] {});
		} else {
			method = clazz.getMethod(methodName, paramValues.getParamTypes());
			val = method.invoke(obj, paramValues.getVals());
		}

		return val;
	}

	/**
	 * 拼装javabean属性值的get/set方法名，String[0]=get/is，String[1]set。
	 * 
	 * boolean型is+大写字母开头属性的get方法省略get,set方法省略is
	 * 
	 * @param field
	 * @return
	 */
	public static String[] methodNameOfField(Field field) {
		String fieldName = field.getName();
		String fieldType = field.getType().getName();

		String methodNameGet = "get";
		String methodNameSet = "set";

		if ("boolean".equals(fieldType) && fieldName.length() > 2) {

			methodNameGet = "is";

			char[] chars = fieldName.toCharArray();
			if (chars[0] == 'i' && chars[1] == 's'
					&& Character.isUpperCase(chars[2])) {
				fieldName = fieldName.substring(2);
			}
		}

		String sub = fieldName.substring(0, 1).toUpperCase()
				+ fieldName.substring(1);

		methodNameGet += sub;
		methodNameSet += sub;

		return new String[] { methodNameGet, methodNameSet };
	}

	/**
	 * 首字母小写
	 * 
	 * @param s
	 * @return
	 */
	private static String firstLowerCase(String s) {
		if (s == null) {
			return null;
		}

		if (s.trim().isEmpty()) {
			return "";
		}

		return s.substring(0, 1).toLowerCase() + s.substring(1);
	}

	/**
	 * 将对象属性名和值拼接成字符串
	 * 
	 * @param obj
	 * @param fieldValLinker
	 *            属性名和属性值连接符，null则使用"="
	 * @param fieldSeparator
	 *            属性分隔符，null则使用"; "
	 * @return
	 */
	public static String fieldValString(Object obj, boolean includeSuper,
			String fieldValLinker, String fieldSeparator) {

		if (fieldValLinker == null) {
			fieldValLinker = "=";
		}

		if (fieldSeparator == null) {
			fieldSeparator = "; ";
		}

		RfResult rfrs = null;
		try {
			rfrs = ReflectUtil.reflect(obj, includeSuper);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		if (rfrs == null) {
			return null;
		}

		StringBuilder sbd = new StringBuilder();

		Map<String, RfElement> rfEleMap = rfrs.getRfElementMap();
		int mapSize = rfEleMap.size();

		int idx = 0;
		for (Map.Entry<String, RfElement> rfEle : rfrs.getRfElementMap()
				.entrySet()) {
			sbd.append(rfEle.getKey()).append(fieldValLinker)
					.append(rfEle.getValue().value);
			if (idx++ < mapSize - 1) {
				sbd.append(fieldSeparator);
			}
		}

		return sbd.toString();
	}

	/**
	 * 获取公共的父类
	 * 
	 * @param clazz1
	 * @param clazz2
	 * @return
	 */
	public static Class<?> commonClass(Class<?> clazz1, Class<?> clazz2) {
		while (true) {

			if (clazz1 == null || clazz2 == null) {
				return clazz1 == null ? clazz2 : clazz1;
			}

			if (clazz1.isAssignableFrom(clazz2)) {
				return clazz1;
			} else if (clazz2.isAssignableFrom(clazz1)) {
				return clazz2;
			} else {
				clazz1 = clazz1.getSuperclass();
				clazz2 = clazz2.getSuperclass();
			}
		}
	}

	/**
	 * 获取公共的类
	 * 
	 * @param obj1
	 * @param obj2
	 * @return
	 */
	public static Class<?> commonClass(Object obj1, Object obj2) {
		Class<?> clazz1 = obj1 == null ? null : obj1.getClass();
		Class<?> clazz2 = obj1 == null ? null : obj2.getClass();

		return commonClass(clazz1, clazz2);
	}

	/**
	 * 属性元素对象
	 * 
	 * @author admin
	 *
	 */
	public static class RfElement {
		public Field field;// 属性
		public Method setMethod;// 设置值的方法
		public Method getMethod;// 获取值的方法
		public Object value;// 属性值

		@Override
		public String toString() {
			StringBuilder sbd = new StringBuilder(getClass().getSimpleName()
					+ "{");
			sbd.append("field=").append(field).append(C.COMMOA_BANK);
			sbd.append("setMethod=").append(setMethod).append(C.COMMOA_BANK);
			sbd.append("getMethod=").append(getMethod).append(C.COMMOA_BANK);
			sbd.append("value=").append(value).append("}");
			return sbd.toString();
		}
	}

	public static class RfResult {
		private Object obj;
		private Map<String, RfElement> rfElementMap = new LinkedHashMap<String, RfElement>();
		private List<Method> otherMethodList = new ArrayList<Method>();

		public Object getObj() {
			return obj;
		}

		public void setObj(Object obj) {
			this.obj = obj;
		}

		public Map<String, RfElement> getRfElementMap() {
			return rfElementMap;
		}

		public void clearFieldMap() {
			this.rfElementMap.clear();
		}

		public RfElement getRfElement(String name) {
			return this.rfElementMap.get(name);
		}

		public void addRfElement(String name, RfElement rfElement) {
			this.rfElementMap.put(name, rfElement);
		}

		public List<Method> getOtherMethodList() {
			return otherMethodList;
		}

		public Method getOtherMethod(int idx) {
			return otherMethodList.get(idx);
		}

		public void addOtherMethod(Method otherMethod) {
			otherMethodList.add(otherMethod);
		}

		public void clearOtherMethodList(Method otherMethod) {
			this.otherMethodList.clear();
		}

		@Override
		public String toString() {

			StringBuilder sbd = new StringBuilder(getClass().getSimpleName()
					+ "{");
			sbd.append("obj=").append(obj).append(C.COMMOA_BANK);
			sbd.append("rfElementMap=").append(rfElementMap)
					.append(C.COMMOA_BANK);
			sbd.append("otherMethodList=").append(otherMethodList).append("}");

			return sbd.toString();
		}
	}

	public static class ParamValues {
		private List<Class<?>> paramTypeList = new ArrayList<Class<?>>();
		private List<Object> valList = new ArrayList<Object>();

		public ParamValues add(Class<?> clazz, Object val) {
			this.paramTypeList.add(clazz);
			this.valList.add(val);

			return this;
		}

		public ParamValues reset() {
			this.paramTypeList.clear();
			this.valList.clear();

			return this;
		}

		public Class<?>[] getParamTypes() {
			int size = paramTypeList.size();
			Class<?>[] clazzs = new Class<?>[size];
			for (int i = 0; i < size; i++) {
				clazzs[i] = paramTypeList.get(i);
			}
			return clazzs;
		}

		public Object[] getVals() {
			int size = valList.size();
			Object[] vals = new Object[size];

			for (int i = 0; i < size; i++) {
				vals[i] = valList.get(i);
			}

			return vals;
		}
	}

}

// 基本数据类型：byte、short,int,long,float,double,boolean,char
// 相应封装类型：Byte,Short,Integer,Long,Float,Double,Boolean,Character
// valueOf,parse