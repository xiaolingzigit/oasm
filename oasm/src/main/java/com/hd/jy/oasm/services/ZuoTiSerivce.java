package com.hd.jy.oasm.services;


import com.hd.jy.oasm.domain.BGgtft;
import com.hd.jy.oasm.domain.BGxwgc;
import com.hd.jy.oasm.domain.TestNote;

/***
 * 
 * @author quite
 *����service�ӿڣ�������������ӷ������㣬ͳ��������ѡ�����ӣ�ƥ�����ӷ�������Ŀ
 */
public interface ZuoTiSerivce {

    
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //**********ͨ��ҳ���ϵ����Ż�ȡ��ʹ�õ����õ���������������������⣬ά�ȣ����Ӻ�Ȩ�ط���*********************************************************
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
   public int autoGuize(); //ѡ����Ҫ����ƥ��ĵ����ͨ���������ƥ��,��൵������
   
   public String rjjgftQuestion(String taskId); //ͨ��ҳ���ϵ������ŷ������ṹ��̸�����б���ֶ�
   
   public String rjxwgcQuestion(String taskId); //ͨ�������ŷ��������Ϊ�۲��̸�����б�
   
   public String rcxwgcQuestion(String taskId); //ͨ�������ŵõ��ճ�������Ҫ�����Ӻ�ά��
   
   public String zqjgftQuestion(String taskId); //ͨ�������Ż�ȡ���ڽṹ��̸��Ҫ�����Ӻ�����
   
   public String zqxwgcQuestion(String taskId); //ͨ�������Ż�ȡ������Ϊ�۲���Ҫ�����Ӻ�ά��
   
   public String cjjgftQuestion(String taskId); //ͨ�������Ż�ȡ����ṹ��̸��Ҫ�����Ӻ�����
   
   public String cjxwgcQuestion(String taskId); //ͨ�������Ż�ȡ������Ϊ�۲���Ҫ�����Ӻ�ά��
   
   public int saveNote(TestNote testNote); //����TestMapper����ӷ����Ѵ���𰸼�¼������
   
   public TestNote getNote(String taskId); //���������Ų�ѯ�����¼
   
   public int saveGtfts(BGgtft record); //����ṹ��̸�����¼
	
   public int saveXwgcs(BGxwgc record); //������Ϊ�۲�����¼
   
}
