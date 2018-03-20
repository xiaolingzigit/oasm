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
							bqwhcdSet.add(line.getBqwhcd()); //捕前文化程度可能有null,忽略
						}
						if(null!=line.getGtfzlx()){
							gtfzlxSet.add(line.getGtfzlx()); //共同犯罪类型有可能null，忽略
						}
						if(null!=line.getTbgzlb()){
							tbgzlbSet.add(line.getTbgzlb()); //特别关注类别有可能为Null,忽略
						}
					}
				}
				// -------

				int zfs = 0; // 总分数
				int xq = 0; // 剩余刑期
				int csrq = 0; // 出生日期
				int bqwhcd = 0; // 捕前文化程度
				int xfcs = 0; // 刑罚次数
				int gtfzlx = 0; // 共同犯罪类型
				int tbgzlb = 0; // 特别关注代码

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
							xq = Integer.parseInt(xqStr.substring(0, 2)); // 剩余刑期年份
						} else {
							xq = Integer.parseInt(xqStr);
						}
						log.info("【剩余刑期" + xq + "】");
						
						// 刑期
						LBjcdafx syxqParam = sjjgftAndxwgcDao.selectMoreDafxParam("剩余刑期", xq);
						log.info("获取【剩余刑期】因子:【" + syxqParam.getYz() + "】维度:【" + syxqParam.getWd() + "】分数:【" + syxqParam.getFs()
								+ "】");
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
						log.info("【年龄" + csrq + "】");
					}
					// 年龄
					LBjcdafx csrqParam = sjjgftAndxwgcDao.selectMoreDafxParam("年龄", csrq);
					log.info("获取【年龄】因子:【" + csrqParam.getYz() + "】维度:【" + csrqParam.getWd() + "】分数:【" + csrqParam.getFs()
							+ "】");
					da2.setWd(csrqParam.getWd());
					da2.setYz(csrqParam.getYz());
					da2.setFs(csrqParam.getFs());
				}
				sjdaList.add(da2);

				for (Integer xfcsIn : xfcsSet) {
					if (null != xfcsIn) {
						xfcs = xfcsIn; // 得到刑罚次数
						log.info("【刑罚次数" + xfcs + "】");
					}
					
					// 刑罚次数
					LBjcdafx xfcsParam = sjjgftAndxwgcDao.selectMoreDafxParam("前科", xfcs);
					log.info("获取【刑罚】因子:【" + xfcsParam.getYz() + "】维度:【" + xfcsParam.getWd() + "】分数:【" + xfcsParam.getFs()
							+ "】");
					da4.setWd(xfcsParam.getWd());
					da4.setYz(xfcsParam.getYz());
					da4.setFs(xfcsParam.getFs());
				}
				sjdaList.add(da4);

				for (String bqwhcdStr : bqwhcdSet) {
					if (null != bqwhcdStr) {
						bqwhcd = Integer.parseInt(bqwhcdStr.substring(0, 1)); // 得到文化代码
						log.info("【捕前文化代码" + bqwhcd + "】");
					}
					// 捕前文化代码
					LBjcdafx bqwhParam = sjjgftAndxwgcDao.selectMoreDafxParam("入监前文化", bqwhcd);
					log.info("获取【捕前文化】因子:【" + (bqwhParam==null?"未知":bqwhParam.getYz()) + "】维度:【" +(bqwhParam==null?"未知":bqwhParam.getWd())+ "】分数:【" + bqwhParam.getFs()
							+ "】");
					da3.setWd(bqwhParam==null?"未知":bqwhParam.getWd());
					da3.setYz(bqwhParam==null?"未知":bqwhParam.getYz());
					da3.setFs(bqwhParam==null?null:bqwhParam.getFs());
				}
				sjdaList.add(da3);
				for (String gtfzlxStr : gtfzlxSet) {
					if (null != gtfzlxStr) {
						gtfzlx = Integer.parseInt(gtfzlxStr); // 共同犯罪类型代码
						log.info("【共同犯罪类型代码" + gtfzlx + "】");
					}
					// 共同犯罪类型代码
					LBjcdafx zcfParam = sjjgftAndxwgcDao.selectMoreDafxParam("主从犯", gtfzlx);
					log.info("获取【共同犯罪】因子:【" + zcfParam.getYz() + "】维度:【" + zcfParam.getWd() + "】分数:【" + zcfParam.getFs()
							+ "】");
					da5.setWd(zcfParam==null? "未知":zcfParam.getWd());
					da5.setYz(zcfParam == null? "未知":zcfParam.getYz());
					da5.setFs(zcfParam==null?null:zcfParam.getFs());
				}
				sjdaList.add(da5);

				for (String tbgzlbStr : tbgzlbSet) {
					if (null != tbgzlbStr) {
						tbgzlb = Integer.parseInt(tbgzlbStr); // 特别关注类别代码
						log.info("【特别关注类别代码" + tbgzlb + "】");
					}
					// 特别关注类别代码
					LBjcdafx lgfParam = sjjgftAndxwgcDao.selectMoreDafxParam("累惯犯", tbgzlb);
					log.info("获取【累惯犯】因子:【" + (lgfParam == null? "未知":lgfParam.getYz()) + "】维度:【" + (lgfParam==null? "未知":lgfParam.getWd()) + "】分数:【" + (lgfParam==null?null:lgfParam.getFs())
							+ "】");
					da6.setWd(lgfParam==null? "未知":lgfParam.getWd());
					da6.setYz(lgfParam == null? "未知":lgfParam.getYz());
					da6.setFs(lgfParam==null?null:lgfParam.getFs());
				}
				sjdaList.add(da6);
				// OK
				
				// log.info("获取当前罪犯【囚号"+dasjfx.getBh()+"】，姓名【"+dasjfx.getXm()+"】档案分析总分数为【"+zfs+"】分");
				zfs = ((da1.getFs()==null?0:da1.getFs()) + (da2.getFs()==null?0:da2.getFs()) + (da3.getFs()==null?0:da3.getFs())+ 
						(da4.getFs()==null?0:da4.getFs()) + (da5.getFs()==null?0:da5.getFs()) + (da6.getFs()==null?0:da6.getFs())); // 总分数
				log.info("档案分析【总分数"+zfs+"】");
				String json = GsonUtil.toJson(sjdaList); // 转为json数据传
				String [] str = new String[] {json, String.valueOf(zfs)};
				return str;
		} catch (Exception e) {
			e.printStackTrace();
			// TODO Auto-generated catch block
			log.error("当前【档案分析数据】有" + e.getMessage(),e);
			 return null;
			
		}
	}
	
}
