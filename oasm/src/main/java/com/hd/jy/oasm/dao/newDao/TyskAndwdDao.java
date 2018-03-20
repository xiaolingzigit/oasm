/**
 * 
 */
package com.hd.jy.oasm.dao.newDao;

import java.util.List;
import java.util.Map;

import com.hd.jy.oasm.domain.newDomain.Twdyzgx;
import com.hd.jy.oasm.domain.newDomain.Tysk;

/**
 * @author quite
 *�޸�����ά�����DB������
 */
public interface TyskAndwdDao {
	/**
	 * @todo TODO ������ӻ���ά��
	 * @param tysk
	 * @return
	 * @auth quite
	 * @time 2018��1��12�� ����6:21:24
	 */
	int addTysk(Tysk tysk);
	/**
	 * @todo TODO ���ά�Ⱥ����ӹ�ϵ
	 * @param record
	 * @return
	 * @auth quite
	 * @time 2018��1��12�� ����6:22:25
	 */
	int addTwdyzgx(Twdyzgx record);
	/**
	 * @todo TODO �޸����ӻ���ά��
	 * @param tysk
	 * @return
	 * @auth quite
	 * @time 2018��1��12�� ����6:23:21
	 */
	int updateTysk(Tysk tysk);
	/**
	 * 
	 * @todo TODO ����һЩά��
	 * @param map
	 * @return
	 * @auth quite
	 * @time 2018��1��13�� ����3:24:08
	 *
	 */
	List<Tysk> likeSomeWdKey(Map<String,String> map);
	
	/**
	 * @todo TODO ����һЩ����
	 * @param map
	 * @return
	 * @auth quite
	 * @time 2018��1��13�� ����3:23:24
	 *
	 */
	List<Tysk> likeSomeTyskKey(Map<String,String> map);
	/**
	 * 
	 * @todo TODO �����Ӽ�����
	 * @param map
	 * @return
	 * @auth quite
	 * @time 2018��1��13�� ����3:22:16
	 *
	 */
	List<Tysk> likeTyskKey(Map<String,String> map);
	
	
}
