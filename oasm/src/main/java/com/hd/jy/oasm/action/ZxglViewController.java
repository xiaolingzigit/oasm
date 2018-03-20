package com.hd.jy.oasm.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("zxglView")
public class ZxglViewController {
	
	//重点罪犯名单列表
  @RequestMapping("/zdfgl")
  public String zdfgl(){
	  return "/pcras/zxgl/zdfgl";
  }
  
	//特殊罪犯管理
  @RequestMapping("/tsfgl")
  public String tsfgl(){
	  return "/pcras/zxgl/tsfgl";
  }
	//危安罪犯名单列表
  @RequestMapping("/wafgl")
  public String wafgl(){
	  return "/pcras/zxgl/wafgl";
  }
	//艾滋病罪犯名单列表
  @RequestMapping("/hivfgl")
  public String hivfgl(){
	  return "/pcras/zxgl/hivfgl";
  }
	//邪教罪犯名单列表
  @RequestMapping("/xjfgl")
  public String xjfgl(){
	  return "/pcras/zxgl/xjfgl";
  }
	//外籍罪犯名单列表
  @RequestMapping("/wjfgl")
  public String wjfgl(){
	  return "/pcras/zxgl/wjfgl";
  }
	//精神病罪犯名单列表
  @RequestMapping("/jsbfgl")
  public String jsbfgl(){
	  return "/pcras/zxgl/jsbfgl";
  }
	//顽危罪犯管理
  @RequestMapping("/wwfgl")
  public String wwfgl(){
	  return "/pcras/zxgl/wwfgl";
  }
	//顽危罪犯名单列表
  @RequestMapping("/wwf_xx")
  public String wwf_xx(){
	  return "/pcras/zxgl/wwf_xx";
  }
	//顽危罪犯认定
  @RequestMapping("/wwf_add")
  public String wwf_add(){
	  return "/pcras/zxgl/wwf_add";
  }
	//顽危罪犯认定录入
  @RequestMapping("/wwf_addlr")
  public String wwf_addlr(){
	  return "/pcras/zxgl/wwf_addlr";
  }
	//顽危罪犯认定结果
  @RequestMapping("/wwf_addrs")
  public String wwf_addrs(){
	  return "/pcras/zxgl/wwf_addrs";
  }
	//顽危罪犯撤销
  @RequestMapping("/wwf_undo")
  public String wwf_undo(){
	  return "/pcras/zxgl/wwf_undo";
  }
  //顽危罪犯撤销录入
 @RequestMapping("/wwf_undolr")
 public String wwf_undolr(){
	  return "/pcras/zxgl/wwf_undolr";
 }
   //顽危罪犯撤销结果
  @RequestMapping("/wwf_undors")
  public String wwf_undors(){
	  return "/pcras/zxgl/wwf_undors";
  }

	//极高危罪犯管理
  @RequestMapping("/jgfgl")
  public String jgfgl(){
	  return "/pcras/zxgl/jgfgl";
  }
	//极高危罪犯备案录入
  @RequestMapping("/jgf_balr")
  public String jgf_balr(){
	  return "/pcras/zxgl/jgf_balr";
  }
	//极高危罪犯备案情况
  @RequestMapping("/jgf_bars")
  public String jgf_bars(){
	  return "/pcras/zxgl/jgf_bars";
  }
	//高危罪犯名单列表
  @RequestMapping("/gwfgl")
  public String gwfgl(){
	  return "/pcras/zxgl/gwfgl";
  }
}
