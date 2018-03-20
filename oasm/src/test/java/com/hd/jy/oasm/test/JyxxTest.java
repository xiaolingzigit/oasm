package com.hd.jy.oasm.test;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.hd.jy.oasm.dao.JYXXMapper;
import com.hd.jy.oasm.domain.GroupMan;
import com.hd.jy.oasm.domain.JYXX;
import com.hd.jy.oasm.domain.SysAdmin;
import com.hd.jy.oasm.domain.ZRole;
import com.hd.jy.oasm.services.JyxxService;
import com.hd.jy.oasm.services.SysAdminService;
import com.hd.jy.oasm.services.SystemLogService;
import com.hd.jy.oasm.util.CryptographyUtil;
import com.hd.jy.oasm.util.Page;
import com.hd.jy.oasm.util.PageHelper;
import com.hd.jy.oasm.util.domain.SystemLog;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybaits.xml"})
public class JyxxTest  {
	private Logger log = Logger.getLogger(JyxxTest.class);
	@Autowired
	private JyxxService jyxxService; //警员信息操作接口
	
	@Autowired
	private JYXXMapper jyxxDao;
	
	@Autowired
	private SystemLogService logService;
	
	@Autowired
	private SysAdminService sysAdminService; //系统日志操作接口
	
	@Autowired
	private SysAdminService SysAdminService; //后台系统操作日志
	
  @SuppressWarnings("static-access")
  @Test
  public void test1(){
	  JYXX xx = new JYXX();
	  xx.setJh("110110117");
	  xx.setZw(6);
	  xx.setMa(CryptographyUtil.MD5("123"));
	  int i = jyxxService.insertSelective(xx);
	  System.out.println("成功插入数据"+i+"条");
  }
   @Test
   public void test2(){
	   JYXX jyxx = jyxxService.selectCheck("4429000");
	   System.out.println(jyxx.getMa());
   }
   
   @Test
   public void insertAdmin(){
	   SysAdmin admin = new SysAdmin();
	   admin.setUsername("admin");
	   admin.setPassword( CryptographyUtil.MD5("123456"));
	   admin.setGmid(1);
	   int i = 0;
	try {
		i = sysAdminService.insertSelective(admin);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   assertEquals(i, 1);
   }
   
   @Test
   public void selectTest(){
	   String password = sysAdminService.checkByUsername("admin");
	   System.out.println(password);
   }
   
   @Test
   public void selectUser(){
	   SysAdmin ad = new SysAdmin();
	   ad.setUsername("admin");
	   ad.setPassword("521851cfdf3bdb5ef2d713fcf9942f0b");
	   int i = sysAdminService.selectByUser(ad);
	   System.out.println(i);
   }
   
   @Test
   public void zrole(){
	   List<ZRole> allZroll = jyxxService.selectAllZroll();
	   log.info(JSON.toJSON(allZroll));
   }
   
   @Test
   public void zroleAndgroupMan(){
	   List<ZRole> man = jyxxService.selectAllGroupMan(2); //角色关联为2的所有职务
	   log.info(JSON.toJSON(man));
   }
   
   @Test
   public void groupManadd(){
	   GroupMan gm = new GroupMan();
	   gm.setGmname("分监区长");
	   gm.setStates(1);
	   gm.setZrid(2);
	   int i = jyxxService.insertGroupMan(gm);
	   System.out.println(i);
   }
   
   @Test
   public void jyxxUpdate(){
	   JYXX jy = new JYXX();
	   jy.setJh("1234567");
//	   jy.setZw(2);
//	   jy.setXm("小七");
//	   jy.setJq("四监区");
//	   jy.setXjq("四分监区");
	   jy.setStatus(1);
	   int i = jyxxService.updateByPrimaryKeySelective(jy);
	   System.out.println(i);
   }
   
   //管理员密码修改
   @Test
   public void adminUpdate(){
	   SysAdmin ad = new SysAdmin();
	   ad.setId(7);
	   ad.setPassword( CryptographyUtil.MD5("12345".trim()));
	   int i = sysAdminService.updateByPrimaryKeySelective(ad);
	   System.out.println(i);
   }
   
   @Test
   public void adminMa(){
	   SysAdmin up = new SysAdmin();
	   up.setUsername("admin");
	   up.setPassword( CryptographyUtil.MD5("123456".trim()));
	   int i = sysAdminService.updateByCurrentUsername(up);
	   System.out.println(i);
   }
   
   @Test
   public void adminList(){
	   List<SysAdmin> byStatus = sysAdminService.selectAdminByStatus();
	   log.info(JSON.toJSON(byStatus));
   }
   
   @Test
   public void updateUer(){
	   SysAdmin up = new SysAdmin();
	   up.setId(8);
	   up.setUsername("1234567");
	   up.setPassword( CryptographyUtil.MD5("123456".trim()));
	   int i = sysAdminService.updateByPrimaryKeySelective(up);
	   System.out.println(i);
   }
   
   @Test
   public void delectAdmin(){
	   SysAdmin de = new SysAdmin();
	   de.setId(8);
	   de.setStatus(0);
	   int i = sysAdminService.updateBySuperAdminStatus(de);
	   System.out.println(i);
   }
   
   @Test
   public void bykey(){
	   List<SysAdmin> likeKey = sysAdminService.selectByAdminLikeKey("qu");
	   log.info(JSON.toJSON(likeKey));
   }
   
   @Test
   public void selectJyxx(){
	   PageHelper.startPage(1, 5);
	   List<JYXX> selectJyxx = jyxxService.selectJyxx();
	   Page page = PageHelper.endPage();
	   log.info(page.toString()+" shu "+page.getNavigatepageNums().length);
	   int[] navigatepageNums = page.getNavigatepageNums();
	   for (int jyxx : navigatepageNums) {
		System.out.println(jyxx);
	}
	   
	   
	   
   }
   
   //测试警察的个人信息
   
   @Test
   public void testInfo(){
	  JYXX jyxx = jyxxService.infoSetting("4429187");
	  System.out.println(jyxx.getZwName());
   }
   
   @Test
   public void logTest(){
	   Map<String,String> map = new HashMap<String,String>();
	   map.put("createBy", "admin");
	   List<SystemLog> info = logService.systemLogInfo(map);
	   log.info(JSON.toJSON(info));
	 
   }
   
   @Test
   public void testZW(){
	 GroupMan zw = jyxxDao.checkZW("内奸");
	   System.out.println(zw.getId());
   }
   
   //备份数据库
   @Test
   public void testDB(){
	   String db = logService.backupDB("F:\\");
	   System.out.println(db);
   }
   
   public static void main(String[] args) {
	 String a = "aab";
	 String b = "b";
	 System.out.println(!a.contains(b));
	 
}
}
