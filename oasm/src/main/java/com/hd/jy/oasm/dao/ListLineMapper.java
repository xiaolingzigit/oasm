package com.hd.jy.oasm.dao;

import java.util.ArrayList;
import java.util.List;

import com.hd.jy.oasm.domain.CodeName;
import com.hd.jy.oasm.domain.CrimCopRelat;
import com.hd.jy.oasm.domain.ListLine;
import com.hd.jy.oasm.domain.PgXlcsJg;
import com.hd.jy.oasm.domain.SearchElement;

public interface ListLineMapper {

	/**
	 * 获取信息列表
	 * 
	 * @param searchElement
	 * @return
	 * 
	 */
	public ArrayList<ListLine> getList(SearchElement searchElement);

	/**
	 * 模糊匹配任務類型获取信息列表
	 * 
	 * @param searchElement
	 * @return
	 */
	public ArrayList<ListLine> getListWithTypeLike(SearchElement searchElement);

	/**
	 * 模糊匹配任務類型获取信息列表
	 * 
	 * @param searchElement
	 * @return
	 */
	public ArrayList<ListLine> getTaskToDo(SearchElement searchElement);

	/**
	 * 获取所有囚号和囚犯姓名
	 * 
	 * @return
	 */
	public ArrayList<CodeName> getCrimCodeName();

	/**
	 * 
	 * 获取所有警察和警号姓名
	 * 
	 * @return
	 */
	public ArrayList<CodeName> getCopCodeName();

	/**
	 * 获取所有囚号和专管警号对应关系
	 * 
	 * @return
	 */
	public ArrayList<CrimCopRelat> getCopCodeRelat();

	/**
	 * 批量添加评估报告心理测试部分的分析结果
	 * 
	 * @param pgXlcsJgList
	 * @return
	 */
	public int batchAddPgXlcsJg(List<PgXlcsJg> pgXlcsJgList);
	
	/**
	 * 显示评估心理测试结果
	 * @auto quite
	 * @param taskId
	 * @returna
	 * 上午10:58:49
	 * List<PgXlcsJg>
	 */
	public List<PgXlcsJg> getAllPgxlcsjg(String taskId);
	
	/**
	 * 根据囚号显示已有分数的评估报告 
	 * @auto quite
	 * @param crimNo
	 * @returna
	 * 下午4:38:45
	 * List<SearchElement>
	 */
	List<SearchElement> crimInfoXL(String crimNo);
}
