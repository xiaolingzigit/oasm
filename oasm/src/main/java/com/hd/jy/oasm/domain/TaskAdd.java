package com.hd.jy.oasm.domain;

import com.hd.jy.oasm.model.Oasm;

/** 添加任务使用的对象 */
public class TaskAdd extends Oasm {
	/** 任务id，主键(囚号_任务类型 _发布时间yyyyMMddHHmmss) */
	private String rwid;
	/** 囚号 */
	private String qh;
	/** 任务类型 */
	private String rwlx;
	/** 任务依据(为什么) */
	private String rwyj;
	/** 任务描述(做什么) */
	private String rwms;
	/** 备注说明 */
	private String bzsm;
	/** 任务完成期限yyyy-MM-dd HH:mm:ss*/
	private String wxqx;
	/** 任务执行人，格式：警号，如：123456,234567,...。说明发布时不指定任务执行人则填任务发布时囚犯的专管警察 */
	private String rwzxr;
	/**任务发布人，格式：名称,号码,如：张三(123456)*/
	private String rwfbr;
	/**任务发布时间yyyy-MM-dd HH:mm:ss*/
	private String fbsj;
	/**最后修改时间last modification*/
	private String zhxgsj;
	/**最后修改人*/
	private String zhxgr;
	/**状态：-1未发布，1未开始，2处理中(弃用)，3未完成/暂存，4已完成(不能再编辑)，10已取消*/
	private int rwzt;
	
	@Override
	public String getNullField(String s) {
		
		return null;
	}
}