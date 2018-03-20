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
	 * ��map�е�ֵ����ɶ��������е�ֵ��map�е�key�������Ա���Ե�������ȫһ�¡�
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
	 * ͨ�������ȡ��������Ժ�����ֵ�Ļ�ȡ�����÷����������������ִ�Сд
	 * 
	 * @param obj
	 * @param refSuper
	 *            �Ƿ����ȡ��������ݣ�����Object
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
		// ��ȡ������ص���
		for (; clazz != Object.class; clazz = clazz.getSuperclass()) {
			clazzList.add(clazz);
			if (!refSuper) {
				break;
			}
		}

		// ���̳�˳�򣬱��������ȡ������
		for (int c = clazzList.size() - 1; c >= 0; c--) {
			try {
				clazz = clazzList.get(c);
				// ��ȡ������������
				Field[] fields = clazz.getDeclaredFields();
				int fieldLen = fields.length;

				// ����ȡ�����Է�װ�� ��ӵ�RfResult
				for (int i = 0; i < fieldLen; i++) {
					Field field = fields[i];
					RfElement rfe = new RfElement();
					rfe.field = field;
					// ������������
					result.addRfElement(field.getName(), rfe);
				}

				// ��ȡ���еķ���
				Method[] methods = clazz.getDeclaredMethods();// ��ȡ���з�������˽��
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

						// boolean��is��ͷ����set������ʡ��is
						if (rfEle == null) {
							rfEle = result.getRfElement("is" + name);
						}

						if (rfEle != null) {
							rfEle.setMethod = method;
						}
					} else if (name.startsWith("is")) {// boolean��is��ͷ����get������ʡ��get
						name = name.substring(2);

						rfEle = result.getRfElement(firstLowerCase(name));
						if (rfEle == null) {
							rfEle = result.getRfElement(name);
						}

						if (rfEle == null) {
							rfEle = result.getRfElement("is" + name);// isA���Է�����һ����isA��isa��isIsa
						}
						if (rfEle != null) {
							rfEle.getMethod = method;
						}
					} else {// �ǳ������ԵĻ�ȡ�����÷���
						result.addOtherMethod(method);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		// ��ȡ��������ֵ
		for (Map.Entry<String, RfElement> e : result.getRfElementMap()
				.entrySet()) {
			e.getValue().value = getValOfField(obj, e.getValue().field);
		}

		return result;
	}

	/**
	 * ͨ��������������ʵ������������abstract,interface,��������޲ι��й��췽��
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
	 * ������ֵ������ֵ
	 * 
	 * @param obj
	 * @param field
	 * @param fieldVal
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public static void setValueOfField(Object obj, Field field, Object fieldVal)
			throws IllegalArgumentException, IllegalAccessException {

		boolean isAccessible = field.isAccessible();// �������Ȩ��

		field.setAccessible(true);// ��������Ȩ��
		field.set(obj, fieldVal);// ��ֵ������ֵ
		field.setAccessible(isAccessible);// ��λ����Ȩ��
	}

	/**
	 * ������ֵ������ֵ
	 * 
	 * @param obj
	 * @param fieldName
	 * @param fieldVal
	 *            �����������ͺͷ���****(.-/��)*(.-/��)*(.-/��)[
	 *            ]*(:ʱ)*(:��)*(.��)*(����)]��ʽ�������ַ��������Ը���Field���������Զ�ʶ��ת��
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
		if (rfEle == null) {// û�з��ϸ����Ƶ����ԣ����쳣
			throw new IllegalAccessException("field named[" + fieldName
					+ "] is not exist");
		}

		Field field = rfEle.field;

		boolean isAccessible = field.isAccessible();// �������Ȩ��
		field.setAccessible(true);// ��������Ȩ��

		String fieldType = field.getType().getSimpleName();
		String inputType = fieldVal == null ? null : fieldVal.getClass()
				.getSimpleName();

		// ����ֵΪnull��û�����ͣ�������ֵ����String�͡�����ֵΪ�հ��ַ�����
		// ��������ֵ��Field����String�ͣ����� �ַ���ת�����������ʹ���
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

				} else {// δ֪���
					field.set(obj, fieldVal);// ��ֵ������ֵ
				}
			} catch (NumberFormatException e) {
				throw new ParseException("string[" + fieldValStr
						+ "] parse to " + fieldType + " failed", e);
			}
		}

		field.setAccessible(isAccessible);// ��λ����Ȩ��
	}

	/**
	 * ��ȡ����ֵ���ֵ
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
		field.setAccessible(true); // ��������Ȩ��
		Object val = field.get(obj);// ��ȡ����ֵ
		field.setAccessible(isFieldAccessible);// ��λ����Ȩ��

		return val;
	}

	/**
	 * ��ȡ����ֵ���ֵ
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
		field.setAccessible(true); // ��������Ȩ��

		Object val = field.get(obj);// ��ȡ����ֵ

		field.setAccessible(isFieldAccessible);// ��λ����Ȩ��

		return val;
	}

	/**
	 * ���ݷ�����ִ�ж����еķ���
	 * 
	 * @param obj
	 * @param methodName
	 *            ������
	 * @param paramValues
	 *            �������ͺͲ���ֵ
	 * @return �޷���ֵ��null
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
	 * ƴװjavabean����ֵ��get/set��������String[0]=get/is��String[1]set��
	 * 
	 * boolean��is+��д��ĸ��ͷ���Ե�get����ʡ��get,set����ʡ��is
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
	 * ����ĸСд
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
	 * ��������������ֵƴ�ӳ��ַ���
	 * 
	 * @param obj
	 * @param fieldValLinker
	 *            ������������ֵ���ӷ���null��ʹ��"="
	 * @param fieldSeparator
	 *            ���Էָ�����null��ʹ��"; "
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
	 * ��ȡ�����ĸ���
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
	 * ��ȡ��������
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
	 * ����Ԫ�ض���
	 * 
	 * @author admin
	 *
	 */
	public static class RfElement {
		public Field field;// ����
		public Method setMethod;// ����ֵ�ķ���
		public Method getMethod;// ��ȡֵ�ķ���
		public Object value;// ����ֵ

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

// �����������ͣ�byte��short,int,long,float,double,boolean,char
// ��Ӧ��װ���ͣ�Byte,Short,Integer,Long,Float,Double,Boolean,Character
// valueOf,parse