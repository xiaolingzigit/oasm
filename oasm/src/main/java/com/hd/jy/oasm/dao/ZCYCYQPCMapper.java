package com.hd.jy.oasm.dao;

import java.util.List;

import com.hd.jy.oasm.domain.ZCYCYQPC;
/***
 *�쳣����ҵ��ӿ� 
 * @author quite
 *���ɵ�LBKMSerivce
 */
public interface ZCYCYQPCMapper {
    int insert(ZCYCYQPC record);

    int insertSelective(ZCYCYQPC record);
    
    /**
     * ����String���͵����Ų�ѯ�쳣����--������Ŀ--�ﷸ��Ϣ��ѯ ��ʾ
     * �Ĵ���--��Ϊ�۲� ��ʾ
     * @auto quite
     * @param yqztbh
     * @returna
     * ����3:19:24
     * List<ZCYCYQPC>
     */
    List<ZCYCYQPC> selectYCYQ(String yqztbh); 
    
}