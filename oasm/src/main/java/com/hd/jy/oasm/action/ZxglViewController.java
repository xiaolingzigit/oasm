package com.hd.jy.oasm.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("zxglView")
public class ZxglViewController {
	
	//�ص��ﷸ�����б�
  @RequestMapping("/zdfgl")
  public String zdfgl(){
	  return "/pcras/zxgl/zdfgl";
  }
  
	//�����ﷸ����
  @RequestMapping("/tsfgl")
  public String tsfgl(){
	  return "/pcras/zxgl/tsfgl";
  }
	//Σ���ﷸ�����б�
  @RequestMapping("/wafgl")
  public String wafgl(){
	  return "/pcras/zxgl/wafgl";
  }
	//���̲��ﷸ�����б�
  @RequestMapping("/hivfgl")
  public String hivfgl(){
	  return "/pcras/zxgl/hivfgl";
  }
	//а���ﷸ�����б�
  @RequestMapping("/xjfgl")
  public String xjfgl(){
	  return "/pcras/zxgl/xjfgl";
  }
	//�⼮�ﷸ�����б�
  @RequestMapping("/wjfgl")
  public String wjfgl(){
	  return "/pcras/zxgl/wjfgl";
  }
	//�����ﷸ�����б�
  @RequestMapping("/jsbfgl")
  public String jsbfgl(){
	  return "/pcras/zxgl/jsbfgl";
  }
	//��Σ�ﷸ����
  @RequestMapping("/wwfgl")
  public String wwfgl(){
	  return "/pcras/zxgl/wwfgl";
  }
	//��Σ�ﷸ�����б�
  @RequestMapping("/wwf_xx")
  public String wwf_xx(){
	  return "/pcras/zxgl/wwf_xx";
  }
	//��Σ�ﷸ�϶�
  @RequestMapping("/wwf_add")
  public String wwf_add(){
	  return "/pcras/zxgl/wwf_add";
  }
	//��Σ�ﷸ�϶�¼��
  @RequestMapping("/wwf_addlr")
  public String wwf_addlr(){
	  return "/pcras/zxgl/wwf_addlr";
  }
	//��Σ�ﷸ�϶����
  @RequestMapping("/wwf_addrs")
  public String wwf_addrs(){
	  return "/pcras/zxgl/wwf_addrs";
  }
	//��Σ�ﷸ����
  @RequestMapping("/wwf_undo")
  public String wwf_undo(){
	  return "/pcras/zxgl/wwf_undo";
  }
  //��Σ�ﷸ����¼��
 @RequestMapping("/wwf_undolr")
 public String wwf_undolr(){
	  return "/pcras/zxgl/wwf_undolr";
 }
   //��Σ�ﷸ�������
  @RequestMapping("/wwf_undors")
  public String wwf_undors(){
	  return "/pcras/zxgl/wwf_undors";
  }

	//����Σ�ﷸ����
  @RequestMapping("/jgfgl")
  public String jgfgl(){
	  return "/pcras/zxgl/jgfgl";
  }
	//����Σ�ﷸ����¼��
  @RequestMapping("/jgf_balr")
  public String jgf_balr(){
	  return "/pcras/zxgl/jgf_balr";
  }
	//����Σ�ﷸ�������
  @RequestMapping("/jgf_bars")
  public String jgf_bars(){
	  return "/pcras/zxgl/jgf_bars";
  }
	//��Σ�ﷸ�����б�
  @RequestMapping("/gwfgl")
  public String gwfgl(){
	  return "/pcras/zxgl/gwfgl";
  }
}
