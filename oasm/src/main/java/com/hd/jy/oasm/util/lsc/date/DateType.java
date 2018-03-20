package com.hd.jy.oasm.util.lsc.date;

public class DateType {

	private String datePattern;

	private DateType(String datePattern) {
		this.datePattern = datePattern;
	}

	//
	// YYYYMM_DD("yyyyMMdd", false),
	//
	//
	// YYYY_MM("yyyy-MM", false),
	// YYYY_MM_DD("yyyyMMdd", false),
	// YYYY_MM_DD_HH_MM("yyyy-MM-dd HH:mm", false),
	// YYYY_MM_DD_HH_MM_SS("yyyyMMddHHmmss", false),
	//
	// YYYY_MM_EN("yyyy/MM", false),
	// YYYY_MM_DD_EN("yyyy/MM/dd", false),
	// YYYY_MM_DD_HH_MM_EN("yyyy/MM/dd HH:mm", false),
	// YYYY_MM_DD_HH_MM_SS_EN("yyyy/MM/dd HH:mm:ss", false),
	//
	// YYYY_MM_CN("yyyy年MM月", false),
	// YYYY_MM_DD_CN("yyyy年MM月dd日", false),
	// YYYY_MM_DD_HH_MM_CN("yyyy年MM月dd日 HH:mm", false),
	// YYYY_MM_DD_HH_MM_SS_CN("yyyy年MM月dd日 HH:mm:ss", false),
	//
	// HH_MM("HH:mm", true),
	// HH_MM_SS("HH:mm:ss", true),
	//
	// MM_DD("MM-dd", true),
	// MM_DD_HH_MM("MM-dd HH:mm", true),
	// MM_DD_HH_MM_SS("MM-dd HH:mm:ss", true),
	//
	// MM_DD_EN("MM/dd", true),
	// MM_DD_HH_MM_EN("MM/dd HH:mm", true),
	// MM_DD_HH_MM_SS_EN("MM/dd HH:mm:ss", true),
	//
	// MM_DD_CN("MM月dd日", true),
	// MM_DD_HH_MM_CN("MM月dd日 HH:mm", true),
	// MM_DD_HH_MM_SS_CN("MM月dd日 HH:mm:ss", true);
	//
	// private String value;
	//
}
