package com.hd.jy.oasm.dao.newDao;

import java.util.List;
import java.util.Map;

import com.hd.jy.oasm.domain.newDomain.Viewpggl;
/**
 * v_pggl��ͼҵ��ӿ�
 * @author quite
 * ��ViewftjgAndxwgcServiceдҵ��ӿ�
 *
 */
public interface ViewpgglMapper {
    int insert(Viewpggl record);

    int insertSelective(Viewpggl record);
    
    List<Viewpggl> rjjgftViewpggl(Map<String,Object> map); //�������ṹ��̸��¼�Ĺ������Ŷ�̬��ѯ��ͼ
    
    List<Viewpggl> rjxwgcViewpggl(Map<String,Object> map); //���������Ϊ�۲쾯�Ŷ�̬��ѯ��ͼ
    
    List<Viewpggl> rcxwgcViewpggl(Map<String,Object> map); //�ճ���Ϊ�۲춯̬��ͼ
    
    List<Viewpggl> zqjgftViewpggl(Map<String,Object> map);//���ڷ�̸��̬������ͼ
    
    List<Viewpggl> zqxwgcViewpggl(Map<String,Object> map); //���ڹ۲춯̬������ͼ
    
    List<Viewpggl> cjjgftViewpggl(Map<String,Object> map);//�����̸��̬������ͼ
    
    List<Viewpggl> cjxwgcViewpggl(Map<String,Object> map);//����۲춯̬������ͼ
    
    /**
     * ����������ʾ�ﷸ���з����Ľṹ��̸  ������Ŀ--�ﷸ��Ϣ��ѯ ��ʾ
     * @auto quite
     * @param crimNo
     * @returna
     * ����3:26:42
     * List<Viewpggl>
     */
    List<Viewpggl> crimInfoGrft(String crimNo);
    /**
     * ����������ʾ�ﷸ���з�������Ϊ�۲� ������Ŀ�����ﷸ��Ϣ��ѯ  ��ʾ
     * @auto quite
     * @param crimNo
     * @returna
     * ����3:27:44
     * List<Viewpggl>
     */
    List<Viewpggl> crimInfoGrgc(String crimNo);
}