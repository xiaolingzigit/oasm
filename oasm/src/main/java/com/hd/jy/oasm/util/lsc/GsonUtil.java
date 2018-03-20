package com.hd.jy.oasm.util.lsc;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.hd.jy.oasm.util.lsc.excpts.NullException;
import com.hd.jy.oasm.util.lsc.excpts.ParseException;

/**
 * Gson json方法封装
 * 
 * @author Anderok
 */
public class GsonUtil {
	private static Logger logger = Logger.getLogger(GsonUtil.class);
	private static JsonParser jsonParser = new JsonParser();
	private static GsonBuilder gbd = new GsonBuilder();
	// ele.isJsonNull() //ele.isJsonPrimitive()
	static {
		setConfig("yyyy-MM-dd HH:mm:ss.SSS", true, true, false);
	}

	/**
	 * 获取GsonUtil持有公用的GsonBuilder
	 * 
	 * @return
	 */
	public static GsonBuilder getGsonBuilder() {
		return gbd;
	}

	/**
	 * 设置Gson转换规则(新建一个GsonBuilder)
	 * 
	 * @param datePattern
	 *            日期格式化表达式
	 * @param serializeNulls
	 *            是否输出null值变量
	 * @param disableHtmlEscaping
	 *            是否禁止把html标签，转换为Unicode转义字符
	 * @param prettyPrinting
	 *            是否排版缩进输出
	 */
	public static void setConfig(String datePattern, boolean serializeNulls,
			boolean disableHtmlEscaping, boolean prettyPrinting) {

		gbd = new GsonBuilder();

		if (datePattern != null) {
			gbd.setDateFormat(datePattern);
		}

		if (serializeNulls) {
			gbd.serializeNulls();
		}

		if (disableHtmlEscaping) {
			gbd.disableHtmlEscaping();
		}

		if (prettyPrinting) {
			gbd.setPrettyPrinting();
		}

	}

	/**
	 * 重置Gson转换规则(新建一个GsonBuilder)
	 */
	public static void resetConf() {
		gbd = new GsonBuilder();
	}

	/**
	 * 根据对象类型，将json字符串转化成对象
	 * 
	 * @param json
	 * @param classOfT
	 * @return
	 * @throws ParseException
	 */
	public static <T> T toInstance(String json, Class<T> classOfT)
			throws ParseException {

		if (json == null) {
			return null;
		}

		try {
			// return gbd.create().fromJson(json, new TypeToken<T>()
			// {}.getType());
			return gbd.create().fromJson(json, classOfT);
		} catch (Exception e) {
			throw new ParseException("input string[" + json
					+ "] parse to Instance of class[" + classOfT.getName()
					+ "] failed", e);
		}
	}

	/**
	 * 根据对象类型，将json数组字符串转化成ArrayList对象
	 * 
	 * @param jsonArray
	 * @param classOfT
	 * @return
	 * @throws ParseException
	 */
	public static <T> ArrayList<T> toList(String jsonArray, Class<T> classOfT) {
		try {
			if (jsonArray == null) {
				return null;
			}

			ArrayList<T> list = new ArrayList<T>();
			JsonArray jsonArr = toJsonArray(jsonArray);
			for (JsonElement ele : jsonArr) {
				if (ele.isJsonNull()) {
					list.add(null);
				} else {
					list.add(toInstance(ele.toString(), classOfT));
				}
			}
			return list;
		} catch (ParseException e) {
			throw new ParseException("input string[" + jsonArray
					+ "] parse to Instance of ArrayList with element class["
					+ classOfT.getName() + "] failed", e);
		}

	}

	/**
	 * 将基本数据类型和对象等内容转化成json字符串
	 * 
	 * @param obj
	 * @return
	 */
	public static String toJson(Object obj) {
		if (obj == null) {
			return null;
		}
		// return gbd.create().toJson(obj,new TypeToken<T>() {}.getType());
		return gbd.create().toJson(obj);
	}

	/**
	 * 将字符串转化成Json元素对象
	 * 
	 * @param json
	 * @return
	 * @throws ParseException
	 */
	public static JsonElement toJsonElement(String json) throws ParseException {
		if (json == null) {
			return null;
		}

		try {
			return jsonParser.parse(json);

		} catch (Exception e) {
			throw new ParseException("input string[" + json
					+ "] parse to toJsonElement failed", e);
		}
	}

	/**
	 * 将对象转化成Json元素对象
	 * 
	 * @param obj
	 * @return
	 * @throws ParseException
	 */
	public static JsonElement objToJsonElement(Object obj)
			throws ParseException {
		return toJsonElement(toJson(obj));

	}

	/**
	 * 将字符串转化成Json对象
	 * 
	 * @param json
	 * @return
	 * @throws ParseException
	 */
	public static JsonObject toJsonObject(String json) throws ParseException {
		if (json == null) {
			return null;
		}

		JsonElement ele = null;
		try {
			ele = jsonParser.parse(json);

			if (ele == null || ele.isJsonNull()) {
				return null;
			} else {
				return ele.getAsJsonObject();
			}
		} catch (Exception e) {
			throw new ParseException("input string[" + json
					+ "] parse to jsonObject failed, jsonElement: " + ele, e);
		}
	}

	/**
	 * 将对象转化成Json对象
	 * 
	 * @param obj
	 * @return
	 * @throws ParseException
	 */
	public static JsonObject objToJsonObject(Object obj)
			throws ParseException {
		return toJsonObject(toJson(obj));

	}
	
	/**
	 * 将字符串转化成Json数组
	 * 
	 * @param json
	 * 
	 * @return
	 * @throws ParseException
	 */
	public static JsonArray toJsonArray(String json) throws ParseException {
		if (json == null) {
			return null;
		}

		JsonElement ele = null;
		try {
			ele = jsonParser.parse(json);

			if (ele == null || ele.isJsonNull()) {
				return null;
			} else {
				return ele.getAsJsonArray();
			}
		} catch (Exception e) {
			throw new ParseException("input string[" + json
					+ "] parse to jsonArray failed, jsonElement:" + ele, e);
		}
	}

	/**
	 * 将对象转化成Json数组
	 * 
	 * @param obj
	 * @return
	 * @throws ParseException
	 */
	public static JsonArray objToJsonArray(Object obj)
			throws ParseException {
		return toJsonArray(toJson(obj));
	}
	
	// TODO FLAG

	public static JsonElement getJsonElement(JsonObject jsonObject, String key) {

		if (jsonObject == null) {
			throw new NullException("jsonObject", "");
		}

		return jsonObject.get(key);
	}

	/**
	 * 从jsonObject获取JsonElement
	 * 
	 * @param jsonArray
	 * @param key
	 * @param throwElementNull
	 *            JsonElement为null时是否抛异常
	 * @param throwElementJsonNull
	 *            JsonElement为JsonNull时是否抛异常
	 * @return
	 */
	public static JsonElement getJsonElement(JsonObject jsonObject, String key,
			boolean throwElementNull, boolean throwElementJsonNull) {

		if (jsonObject == null) {
			throw new NullException("jsonObject input");
		}
		JsonElement ele = jsonObject.get(key);

		if (throwElementNull && ele == null) {
			throw new NullException("jsonElement of key[" + key + "] is null");
		}

		if (throwElementJsonNull && ele.isJsonNull()) {
			throw new NullException("jsonElement of key[" + key
					+ "] is jsonNull");
		}

		return ele;
	}

	public static JsonObject getJsonObject(JsonObject jsonObject, String key)
			throws ParseException {

		JsonElement ele = null;
		try {
			ele = getJsonElement(jsonObject, key);

			if (ele == null || ele.isJsonNull()) {
				return null;
			}

			return ele.getAsJsonObject();
		} catch (Exception e) {
			throw new ParseException("get jsonObject from jsonObject["
					+ jsonObject + "] by key[" + key + "] failed, jsonElement:"
					+ ele, e);
		}
	}

	public static JsonArray getJsonArray(JsonObject jsonObject, String key)
			throws ParseException {

		JsonElement ele = null;
		try {
			ele = getJsonElement(jsonObject, key);

			if (ele == null || ele.isJsonNull()) {
				return null;
			}

			return ele.getAsJsonArray();
		} catch (Exception e) {
			throw new ParseException("get jsonArray from jsonObject["
					+ jsonObject + "] by key[" + key + "] failed, jsonElement:"
					+ ele, e);
		}
	}

	public static short getShort(JsonObject jsonObject, String key, short defVal) {
		JsonElement ele = null;
		try {
			ele = getJsonElement(jsonObject, key, true, true);

			return ele.getAsShort();
		} catch (Exception e) {
			logger.warn("get short from jsonObject[" + jsonObject + "] by key["
					+ key + "] failed, JsonElement: " + ele
					+ ", return default value[" + defVal + "]", e);
			return defVal;
		}
	}

	public static short getShort(JsonObject jsonObject, String key)
			throws ParseException {

		JsonElement ele = null;
		try {
			ele = getJsonElement(jsonObject, key, true, true);

			return ele.getAsShort();
		} catch (Exception e) {
			throw new ParseException("get short from jsonObject[" + jsonObject
					+ "] by key[" + key + "] failed, jsonElement:" + ele, e);
		}
	}

	public static int getInt(JsonObject jsonObject, String key, int defVal) {
		JsonElement ele = null;
		try {
			ele = getJsonElement(jsonObject, key, true, true);

			return ele.getAsInt();
		} catch (Exception e) {
			logger.warn("get int from jsonObject[" + jsonObject + "] by key["
					+ key + "] failed, JsonElement: " + ele
					+ ", return default value[" + defVal + "]", e);
			return defVal;
		}

	}

	public static int getInt(JsonObject jsonObject, String key)
			throws ParseException {

		JsonElement ele = null;
		try {
			ele = getJsonElement(jsonObject, key, true, true);

			return ele.getAsInt();
		} catch (Exception e) {
			throw new ParseException("get int from jsonObject[" + jsonObject
					+ "] by key[" + key + "] failed, jsonElement:" + ele, e);
		}
	}

	public static long getLong(JsonObject jsonObject, String key, long defVal) {

		JsonElement ele = null;
		try {
			ele = getJsonElement(jsonObject, key, true, true);

			return ele.getAsLong();
		} catch (Exception e) {
			logger.warn("get long from jsonObject[" + jsonObject + "] by key["
					+ key + "] failed, JsonElement: " + ele
					+ ", return default value[" + defVal + "]", e);
			return defVal;
		}
	}

	public static long getLong(JsonObject jsonObject, String key)
			throws ParseException {

		JsonElement ele = null;
		try {
			ele = getJsonElement(jsonObject, key, true, true);

			return ele.getAsLong();
		} catch (Exception e) {
			throw new ParseException("get long from jsonObject[" + jsonObject
					+ "] by key[" + key + "] failed, jsonElement:" + ele, e);
		}
	}

	public static float getFloat(JsonObject jsonObject, String key, float defVal) {

		JsonElement ele = null;
		try {
			ele = getJsonElement(jsonObject, key, true, true);

			ele = jsonObject.get(key);
			return ele.getAsFloat();
		} catch (Exception e) {
			logger.warn("get float from jsonObject[" + jsonObject + "] by key["
					+ key + "] failed, JsonElement: " + ele
					+ ", return default value[" + defVal + "]", e);
			return defVal;
		}
	}

	public static float getFloat(JsonObject jsonObject, String key)
			throws ParseException {

		JsonElement ele = null;
		try {
			ele = getJsonElement(jsonObject, key, true, true);

			return ele.getAsFloat();
		} catch (Exception e) {
			throw new ParseException("get float from jsonObject[" + jsonObject
					+ "] by key[" + key + "] failed, jsonElement:" + ele, e);
		}
	}

	public static double getDouble(JsonObject jsonObject, String key,
			double defVal) {

		JsonElement ele = null;
		try {
			ele = getJsonElement(jsonObject, key, true, true);

			return ele.getAsDouble();
		} catch (Exception e) {
			logger.warn("get double from jsonObject[" + jsonObject
					+ "] by key[" + key + "] failed, JsonElement: " + ele
					+ ", return default value[" + defVal + "]", e);
			return defVal;
		}
	}

	public static double getDouble(JsonObject jsonObject, String key)
			throws ParseException {

		JsonElement ele = null;
		try {
			ele = getJsonElement(jsonObject, key, true, true);

			return ele.getAsDouble();
		} catch (Exception e) {
			throw new ParseException("get double from jsonObject[" + jsonObject
					+ "] bye key[" + key + "] failed:, jsonElement:" + ele, e);
		}
	}

	public static String getString(JsonObject jsonObject, String key,
			String defVal) {

		JsonElement ele = null;
		try {
			ele = getJsonElement(jsonObject, key);

			if (ele == null || ele.isJsonNull()) {
				return null;
			}

			return ele.getAsString();
		} catch (Exception e) {
			logger.warn("get string from jsonObject[" + jsonObject
					+ "] by key[" + key + "] failed, JsonElement: " + ele
					+ ", return default value[" + defVal + "]", e);
			return defVal;
		}
	}

	public static String getString(JsonObject jsonObject, String key)
			throws ParseException {

		JsonElement ele = null;
		try {
			ele = getJsonElement(jsonObject, key);

			if (ele == null || ele.isJsonNull()) {
				return null;
			}

			return ele.getAsString();
		} catch (Exception e) {
			throw new ParseException("get string from jsonObject[" + jsonObject
					+ "] by key[" + key + "] failed, jsonElement:" + ele, e);
		}
	}

	public static boolean getBoolean(JsonObject jsonObject, String key,
			boolean defVal) {

		JsonElement ele = null;
		try {
			ele = getJsonElement(jsonObject, key, true, true);

			return ele.getAsBoolean();
		} catch (Exception e) {
			logger.warn("get boolean from jsonObject[" + jsonObject
					+ "] by key[" + key + "] failed, JsonElement: " + ele
					+ ", return default value[" + defVal + "]", e);
			return defVal;
		}
	}

	public static boolean getBoolean(JsonObject jsonObject, String key)
			throws ParseException {

		JsonElement ele = null;
		try {
			ele = getJsonElement(jsonObject, key, true, true);

			return ele.getAsBoolean();
		} catch (Exception e) {
			throw new ParseException("get boolean from jsonObject["
					+ jsonObject + "] by key[" + key + "] failed, jsonElement:"
					+ ele, e);
		}
	}

	// TODO JsonArray

	public static JsonElement getJsonElement(JsonArray jsonArray, int index) {

		if (jsonArray == null) {
			throw new NullException("jsonArray input");
		}

		return jsonArray.get(index);
	}

	/**
	 * 从JsonArray获取JsonElement
	 * 
	 * @param jsonArray
	 * @param index
	 * @param throwElementNull
	 *            JsonElement为null时是否抛异常
	 * @param throwElementJsonNull
	 *            JsonElement为JsonNull时是否抛异常
	 * @return
	 */
	public static JsonElement getJsonElement(JsonArray jsonArray, int index,
			boolean throwElementNull, boolean throwElementJsonNull) {

		if (jsonArray == null) {
			throw new NullException("jsonObject input");
		}

		JsonElement ele = jsonArray.get(index);

		if (throwElementNull && ele == null) {
			throw new NullException("jsonElement of index[" + index
					+ "] is null");
		}

		if (throwElementJsonNull && ele.isJsonNull()) {
			throw new NullException("jsonElement of index[" + index
					+ "] is jsonNull");
		}

		return ele;
	}

	public static JsonObject getJsonObject(JsonArray jsonArray, int index)
			throws ParseException {

		JsonElement ele = null;
		try {

			ele = getJsonElement(jsonArray, index);

			if (ele == null || ele.isJsonNull()) {
				return null;
			}
			return ele.getAsJsonObject();
		} catch (Exception e) {
			throw new ParseException("get jsonObject from jsonArray["
					+ jsonArray + "] by index[" + index
					+ "] failed, jsonElement:" + ele, e);
		}
	}

	public static JsonArray getJsonArray(JsonArray jsonArray, int index)
			throws ParseException {

		JsonElement ele = null;
		try {
			ele = getJsonElement(jsonArray, index);

			if (ele == null || ele.isJsonNull()) {
				return null;
			}

			return ele.getAsJsonArray();
		} catch (Exception e) {
			throw new ParseException("get jsonArray from jsonArray["
					+ jsonArray + "] by index[" + index
					+ "] failed, jsonElement:" + ele, e);
		}
	}

	public static short getShort(JsonArray jsonArray, int index)
			throws ParseException {

		JsonElement ele = null;
		try {
			ele = getJsonElement(jsonArray, index, true, true);

			return ele.getAsShort();
		} catch (Exception e) {
			throw new ParseException("get short from jsonArray[" + jsonArray
					+ "] by index[" + jsonArray + "] failed, jsonElement:"
					+ ele, e);
		}
	}

	public static short getShort(JsonArray jsonArray, int index, short defVal) {

		JsonElement ele = null;
		try {
			ele = getJsonElement(jsonArray, index, true, true);

			return ele.getAsShort();
		} catch (Exception e) {
			logger.warn("get short from jsonArray[" + jsonArray + "] by index["
					+ index + "] failed, JsonElement: " + ele
					+ ", return default value[" + defVal + "]", e);
			return defVal;
		}
	}

	public static int getInt(JsonArray jsonArray, int index)
			throws ParseException {

		JsonElement ele = null;
		try {
			ele = getJsonElement(jsonArray, index, true, true);

			return ele.getAsInt();
		} catch (Exception e) {
			throw new ParseException("get int from jsonArray[" + jsonArray
					+ "] by index[" + jsonArray + "] failed, jsonElement:"
					+ ele, e);
		}
	}

	public static int getInt(JsonArray jsonArray, int index, int defVal) {

		JsonElement ele = null;
		try {
			ele = getJsonElement(jsonArray, index, true, true);

			return ele.getAsInt();
		} catch (Exception e) {
			logger.warn("get int from jsonArray[" + jsonArray + "] by index["
					+ index + "] failed, JsonElement: " + ele
					+ ", return default value[" + defVal + "]", e);
			return defVal;
		}
	}

	public static long getLong(JsonArray jsonArray, int index)
			throws ParseException {

		JsonElement ele = null;
		try {
			ele = getJsonElement(jsonArray, index, true, true);

			return ele.getAsLong();
		} catch (Exception e) {
			throw new ParseException("get long from jsonArray[" + jsonArray
					+ "] by index[" + jsonArray + "] failed, jsonElement:"
					+ ele, e);
		}
	}

	public static long getLong(JsonArray jsonArray, int index, long defVal) {

		JsonElement ele = null;
		try {
			ele = getJsonElement(jsonArray, index, true, true);

			return ele.getAsLong();
		} catch (Exception e) {
			logger.warn("get long from jsonArray[" + jsonArray + "] by index["
					+ index + "] failed, JsonElement: " + ele
					+ ", return default value[" + defVal + "]", e);
			return defVal;
		}
	}

	public static float getFloat(JsonArray jsonArray, int index)
			throws ParseException {

		JsonElement ele = null;
		try {
			ele = getJsonElement(jsonArray, index, true, true);

			return ele.getAsFloat();
		} catch (Exception e) {
			throw new ParseException("get float from jsonArray[" + jsonArray
					+ "] by index[" + jsonArray + "] failed, jsonElement:"
					+ ele, e);
		}
	}

	public static float getFloat(JsonArray jsonArray, int index, float defVal) {

		JsonElement ele = null;
		try {
			ele = getJsonElement(jsonArray, index, true, true);

			return ele.getAsFloat();
		} catch (Exception e) {
			logger.warn("get float from jsonArray[" + jsonArray + "] by index["
					+ index + "] failed, JsonElement: " + ele
					+ ", return default value[" + defVal + "]", e);
			return defVal;
		}
	}

	public static double getDouble(JsonArray jsonArray, int index)
			throws ParseException {

		JsonElement ele = null;
		try {
			ele = getJsonElement(jsonArray, index, true, true);

			return ele.getAsDouble();
		} catch (Exception e) {
			throw new ParseException("get double from jsonArray[" + jsonArray
					+ "] by index[" + jsonArray + "] failed, jsonElement:"
					+ ele, e);
		}
	}

	public static double getDouble(JsonArray jsonArray, int index, double defVal) {

		JsonElement ele = null;
		try {
			ele = getJsonElement(jsonArray, index, true, true);

			return ele.getAsDouble();
		} catch (Exception e) {
			logger.warn("get double from jsonArray[" + jsonArray
					+ "] by index[" + index + "] failed, JsonElement: " + ele
					+ ", return default value[" + defVal + "]", e);
			return defVal;
		}
	}

	public static String getString(JsonArray jsonArray, int index)
			throws ParseException {

		JsonElement ele = null;
		try {
			ele = getJsonElement(jsonArray, index);

			if (ele == null || ele.isJsonNull()) {
				return null;
			}

			return ele.getAsString();
		} catch (Exception e) {
			throw new ParseException("get string from jsonArray[" + jsonArray
					+ "] by index[" + jsonArray + "] failed, jsonElement:"
					+ ele, e);
		}
	}

	public static String getString(JsonArray jsonArray, int index, String defVal) {

		JsonElement ele = null;
		try {
			ele = getJsonElement(jsonArray, index);

			if (ele == null || ele.isJsonNull()) {
				return null;
			}

			return ele.getAsString();
		} catch (Exception e) {
			logger.warn("get string from jsonArray[" + jsonArray
					+ "] by index[" + index + "] failed, JsonElement: " + ele
					+ ", return default value[" + defVal + "]", e);
			return defVal;
		}
	}

	public static boolean getBoolean(JsonArray jsonArray, int index)
			throws ParseException {

		JsonElement ele = null;
		try {
			ele = getJsonElement(jsonArray, index, true, true);

			return ele.getAsBoolean();
		} catch (Exception e) {
			throw new ParseException("get boolean from jsonArray[" + jsonArray
					+ "] by index[" + jsonArray + "] failed, jsonElement:"
					+ ele, e);
		}
	}

	public static boolean getBoolean(JsonArray jsonArray, int index,
			boolean defVal) {

		JsonElement ele = null;
		try {
			ele = getJsonElement(jsonArray, index, true, true);

			return ele.getAsBoolean();
		} catch (Exception e) {
			logger.warn("get boolean from jsonArray[" + jsonArray
					+ "] by index[" + index + "] failed, JsonElement: " + ele
					+ ", return default value[" + defVal + "]", e);
			return defVal;
		}
	}
}
