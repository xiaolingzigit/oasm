package com.hd.jy.oasm.dao;

import java.util.List;
import java.util.Map;

import com.hd.jy.oasm.domain.BGjbxx;
import com.hd.jy.oasm.domain.JYXX;
import com.hd.jy.oasm.domain.VPgbgList;
import com.hd.jy.oasm.domain.Viewgrpgbgxx;
/***
 * ��������ҵ��ӿ�
 * @author quite
 *������������ʹ��
 *���ã���VpgbgListService�е���
 */
public interface VPgbgListMapper {
    
    List<VPgbgList> getViewPgbg(Map<String,Object> map); //������Ϣ�б�
    
    BGjbxx crimInfoBycrimNo(String qh); //����������Ϣ�������ﷸ������ʾ���Ļ�����Ϣ
    
    List<VPgbgList> getGrdjbh(String qh);
    
    List<VPgbgList> getLsPgbg(String qh);
    
    List<VPgbgList> listViewPgbgAndTCzsh(Map<String,Object> map);//��ʾ���洦����١���ˡ����
    
    List<BGjbxx> selectJbxx(); //��ѯ�ﷸ������Ϣ
}