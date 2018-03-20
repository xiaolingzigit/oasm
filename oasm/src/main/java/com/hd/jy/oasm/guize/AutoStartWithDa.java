package com.hd.jy.oasm.guize;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hd.jy.oasm.dao.SjjgftAndxwgcDao;
import com.hd.jy.oasm.domain.DafxjgJSON;
import com.hd.jy.oasm.domain.LBjcdafx;
import com.hd.jy.oasm.domain.ViewDasjfx;
import com.hd.jy.oasm.util.lsc.GsonUtil;

@Component
public class AutoStartWithDa {

	private Logger log = Logger.getLogger(AutoStartWithDa.class);
	@Autowired
	private SjjgftAndxwgcDao sjjgftAndxwgcDao;

	public String[] autoStartWith(String qh,List<ViewDasjfx> seachDasjfx) {
       
		try {
			
			Set<String> xqSet = new TreeSet<>();
			Set<Integer> csrqSet = new TreeSet<>();
			Set<Integer> xfcsSet = new TreeSet<>();
			Set<String> bqwhcdSet = new TreeSet<>();
			Set<String> gtfzlxSet = new TreeSet<>();
			Set<String> tbgzlbSet = new TreeSet<>();

				for (ViewDasjfx line : seachDasjfx) {
					if (qh.equals(line.getBh())) {
						xqSet.add(line.getXq());
						xfcsSet.add((int)line.getXfcs());
						csrqSet.add(line.getCsrq());
						if(null!=line.getBqwhcd()){
							bqwhcdSet.add(line.getBqwhcd()); //��ǰ�Ļ��̶ȿ�����null,����
						}
						if(null!=line.getGtfzlx()){
							gtfzlxSet.add(line.getGtfzlx()); //��ͬ���������п���null������
						}
						if(null!=line.getTbgzlb()){
							tbgzlbSet.add(line.getTbgzlb()); //�ر��ע����п���ΪNull,����
						}
					}
				}
				// -------

				int zfs = 0; // �ܷ���
				int xq = 0; // ʣ������
				int csrq = 0; // ��������
				int bqwhcd = 0; // ��ǰ�Ļ��̶�
				int xfcs = 0; // �̷�����
				int gtfzlx = 0; // ��ͬ��������
				int tbgzlb = 0; // �ر��ע����

				DafxjgJSON da1 = new DafxjgJSON();
				DafxjgJSON da2 = new DafxjgJSON();
				DafxjgJSON da3 = new DafxjgJSON();
				DafxjgJSON da4 = new DafxjgJSON();
				DafxjgJSON da5 = new DafxjgJSON();
				DafxjgJSON da6 = new DafxjgJSON();

				List<DafxjgJSON> sjdaList = new ArrayList<>();

				for (String xqStr : xqSet) {

					if (null != xqStr) {
						if (xqStr.length() > 4) {
							xq = Integer.parseInt(xqStr.substring(0, 2)); // ʣ���������
						} else {
							xq = Integer.parseInt(xqStr);
						}
						log.info("��ʣ������" + xq + "��");
						
						// ����
						LBjcdafx syxqParam = sjjgftAndxwgcDao.selectMoreDafxParam("ʣ������", xq);
						log.info("��ȡ��ʣ�����ڡ�����:��" + syxqParam.getYz() + "��ά��:��" + syxqParam.getWd() + "������:��" + syxqParam.getFs()
								+ "��");
						da1.setWd(syxqParam.getWd());
						da1.setYz(syxqParam.getYz());
						da1.setFs(syxqParam.getFs());
					} else {
						return null;
					}
				}
				sjdaList.add(da1);
				for (Integer csrqIn : csrqSet) {
					if (csrqIn > 0) {
						csrq = csrqIn;
						log.info("������" + csrq + "��");
					}
					// ����
					LBjcdafx csrqParam = sjjgftAndxwgcDao.selectMoreDafxParam("����", csrq);
					log.info("��ȡ�����䡿����:��" + csrqParam.getYz() + "��ά��:��" + csrqParam.getWd() + "������:��" + csrqParam.getFs()
							+ "��");
					da2.setWd(csrqParam.getWd());
					da2.setYz(csrqParam.getYz());
					da2.setFs(csrqParam.getFs());
				}
				sjdaList.add(da2);

				for (Integer xfcsIn : xfcsSet) {
					if (null != xfcsIn) {
						xfcs = xfcsIn; // �õ��̷�����
						log.info("���̷�����" + xfcs + "��");
					}
					
					// �̷�����
					LBjcdafx xfcsParam = sjjgftAndxwgcDao.selectMoreDafxParam("ǰ��", xfcs);
					log.info("��ȡ���̷�������:��" + xfcsParam.getYz() + "��ά��:��" + xfcsParam.getWd() + "������:��" + xfcsParam.getFs()
							+ "��");
					da4.setWd(xfcsParam.getWd());
					da4.setYz(xfcsParam.getYz());
					da4.setFs(xfcsParam.getFs());
				}
				sjdaList.add(da4);

				for (String bqwhcdStr : bqwhcdSet) {
					if (null != bqwhcdStr) {
						bqwhcd = Integer.parseInt(bqwhcdStr.substring(0, 1)); // �õ��Ļ�����
						log.info("����ǰ�Ļ�����" + bqwhcd + "��");
					}
					// ��ǰ�Ļ�����
					LBjcdafx bqwhParam = sjjgftAndxwgcDao.selectMoreDafxParam("���ǰ�Ļ�", bqwhcd);
					log.info("��ȡ����ǰ�Ļ�������:��" + (bqwhParam==null?"δ֪":bqwhParam.getYz()) + "��ά��:��" +(bqwhParam==null?"δ֪":bqwhParam.getWd())+ "������:��" + bqwhParam.getFs()
							+ "��");
					da3.setWd(bqwhParam==null?"δ֪":bqwhParam.getWd());
					da3.setYz(bqwhParam==null?"δ֪":bqwhParam.getYz());
					da3.setFs(bqwhParam==null?null:bqwhParam.getFs());
				}
				sjdaList.add(da3);
				for (String gtfzlxStr : gtfzlxSet) {
					if (null != gtfzlxStr) {
						gtfzlx = Integer.parseInt(gtfzlxStr); // ��ͬ�������ʹ���
						log.info("����ͬ�������ʹ���" + gtfzlx + "��");
					}
					// ��ͬ�������ʹ���
					LBjcdafx zcfParam = sjjgftAndxwgcDao.selectMoreDafxParam("���ӷ�", gtfzlx);
					log.info("��ȡ����ͬ�������:��" + zcfParam.getYz() + "��ά��:��" + zcfParam.getWd() + "������:��" + zcfParam.getFs()
							+ "��");
					da5.setWd(zcfParam==null? "δ֪":zcfParam.getWd());
					da5.setYz(zcfParam == null? "δ֪":zcfParam.getYz());
					da5.setFs(zcfParam==null?null:zcfParam.getFs());
				}
				sjdaList.add(da5);

				for (String tbgzlbStr : tbgzlbSet) {
					if (null != tbgzlbStr) {
						tbgzlb = Integer.parseInt(tbgzlbStr); // �ر��ע������
						log.info("���ر��ע������" + tbgzlb + "��");
					}
					// �ر��ע������
					LBjcdafx lgfParam = sjjgftAndxwgcDao.selectMoreDafxParam("�۹߷�", tbgzlb);
					log.info("��ȡ���۹߷�������:��" + (lgfParam == null? "δ֪":lgfParam.getYz()) + "��ά��:��" + (lgfParam==null? "δ֪":lgfParam.getWd()) + "������:��" + (lgfParam==null?null:lgfParam.getFs())
							+ "��");
					da6.setWd(lgfParam==null? "δ֪":lgfParam.getWd());
					da6.setYz(lgfParam == null? "δ֪":lgfParam.getYz());
					da6.setFs(lgfParam==null?null:lgfParam.getFs());
				}
				sjdaList.add(da6);
				// OK
				
				// log.info("��ȡ��ǰ�ﷸ������"+dasjfx.getBh()+"����������"+dasjfx.getXm()+"�����������ܷ���Ϊ��"+zfs+"����");
				zfs = ((da1.getFs()==null?0:da1.getFs()) + (da2.getFs()==null?0:da2.getFs()) + (da3.getFs()==null?0:da3.getFs())+ 
						(da4.getFs()==null?0:da4.getFs()) + (da5.getFs()==null?0:da5.getFs()) + (da6.getFs()==null?0:da6.getFs())); // �ܷ���
				log.info("�����������ܷ���"+zfs+"��");
				String json = GsonUtil.toJson(sjdaList); // תΪjson���ݴ�
				String [] str = new String[] {json, String.valueOf(zfs)};
				return str;
		} catch (Exception e) {
			e.printStackTrace();
			// TODO Auto-generated catch block
			log.error("��ǰ�������������ݡ���" + e.getMessage(),e);
			 return null;
			
		}
	}
	
}
