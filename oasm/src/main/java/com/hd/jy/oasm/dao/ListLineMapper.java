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
	 * ��ȡ��Ϣ�б�
	 * 
	 * @param searchElement
	 * @return
	 * 
	 */
	public ArrayList<ListLine> getList(SearchElement searchElement);

	/**
	 * ģ��ƥ���΄���ͻ�ȡ��Ϣ�б�
	 * 
	 * @param searchElement
	 * @return
	 */
	public ArrayList<ListLine> getListWithTypeLike(SearchElement searchElement);

	/**
	 * ģ��ƥ���΄���ͻ�ȡ��Ϣ�б�
	 * 
	 * @param searchElement
	 * @return
	 */
	public ArrayList<ListLine> getTaskToDo(SearchElement searchElement);

	/**
	 * ��ȡ�������ź���������
	 * 
	 * @return
	 */
	public ArrayList<CodeName> getCrimCodeName();

	/**
	 * 
	 * ��ȡ���о���;�������
	 * 
	 * @return
	 */
	public ArrayList<CodeName> getCopCodeName();

	/**
	 * ��ȡ�������ź�ר�ܾ��Ŷ�Ӧ��ϵ
	 * 
	 * @return
	 */
	public ArrayList<CrimCopRelat> getCopCodeRelat();

	/**
	 * ���������������������Բ��ֵķ������
	 * 
	 * @param pgXlcsJgList
	 * @return
	 */
	public int batchAddPgXlcsJg(List<PgXlcsJg> pgXlcsJgList);
	
	/**
	 * ��ʾ����������Խ��
	 * @auto quite
	 * @param taskId
	 * @returna
	 * ����10:58:49
	 * List<PgXlcsJg>
	 */
	public List<PgXlcsJg> getAllPgxlcsjg(String taskId);
	
	/**
	 * ����������ʾ���з������������� 
	 * @auto quite
	 * @param crimNo
	 * @returna
	 * ����4:38:45
	 * List<SearchElement>
	 */
	List<SearchElement> crimInfoXL(String crimNo);
}
