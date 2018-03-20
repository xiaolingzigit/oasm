<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<%@taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>新收押罪犯量表</title>

</head>
<body>
  <div class="return_btn" >
       <a href="#" onclick="loadnext3('/oasm/dafxView/rj_xszf')">《 返回</a>	
    </div>
     <div class="rs_table">
        <div class="rs_table_title"><h1>新收押罪犯量表</h1></div>
 		<div class="msg_div">
		   <ul  class="xx_ul">
		   <li class="xx_li01">姓<span>名</span>：</li>
		   <li class="xx_li02">韩方奕</li>
		   <li class="xx_li01">囚<span>号</span>：</li>
		   <li  class="xx_number xx_li02" onclick="loadnext3('/oasm/dafxView/criminalinfo')">1234567890</li>
		   <li class="xx_li01">录入时间：</li>
		   <li class="xx_li02">2017/11/6</li>
		   <li class="xx_li01">监<span>区</span>：</li>
		   <li class="xx_li02">三监区</li>
		   <li class="xx_li01">分监区：</li>
		   <li class="xx_li02">分监区1</li>
		   <li class="xx_li01">专管警察：</li>
		   <li class="xx_li02">王子需</li>
		   </ul>
		</div>
     <div class="lb_content_table2" >
		<table >
        <colgroup>
            <col width="4%">
            <col width="46%">
            <col width="10%">
			<col width="10%">
			<col width="10%">
			<col width="10%">
			<col width="10%">
        </colgroup>
        	<tr>
				<th>序号</th>
				<th>题目</th>
				<th>同意</th>
				<th>基本同意</th>
				<th>不确定</th>
				<th>基本不同意</th>
				<th>不同意</th>
			</tr>
			<tbody class="psychologicalTests_scale_paper">
      <tr>
        <td>1</td>
        <td class="lbf">我从没骗过别人</td>
        <td class="lb_option"><input class="common_checkbox" name="question1" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question1" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question1" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question1" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question1" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>2</td>
        <td class="lbf">要想过得好，就要靠关系和后台</td>
        <td class="lb_option"><input class="common_checkbox" name="question2" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question2" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question2" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question2" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question2" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>3</td>
        <td class="lbf">尽快花点钱找点关系，想办法早点出去</td>
        <td class="lb_option"><input class="common_checkbox" name="question3" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question3" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question3" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question3" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question3" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>4</td>
        <td class="lbf">我的心情容易受环境影响</td>
        <td class="lb_option"><input class="common_checkbox" name="question4" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question4" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question4" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question4" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question4" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>5</td>
        <td class="lbf">我容易被一些意外的小事所烦恼</td>
        <td class="lb_option"><input class="common_checkbox" name="question5" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question5" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question5" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question5" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question5" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>6</td>
        <td class="lbf">劳动改造谈不上学习技术</td>
        <td class="lb_option"><input class="common_checkbox" name="question6" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question6" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question6" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question6" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question6" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>7</td>
        <td class="lbf">牢都坐了，没必要再去拼命劳动</td>
        <td class="lb_option"><input class="common_checkbox" name="question7" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question7" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question7" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question7" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question7" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>8</td>
        <td class="lbf">我与朋友经常保持联系</td>
        <td class="lb_option"><input class="common_checkbox" name="question8" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question8" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question8" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question8" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question8" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>9</td>
        <td class="lbf">我与家人经常保持联系</td>
        <td class="lb_option"><input class="common_checkbox" name="question9" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question9" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question9" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question9" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question9" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>10</td>
        <td class="lbf">现在很想打人</td>
        <td class="lb_option"><input class="common_checkbox" name="question10" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question10" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question10" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question10" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question10" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>11</td>
        <td class="lbf">犯人组长总是喜欢小题大作</td>
        <td class="lb_option"><input class="common_checkbox" name="question11" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question11" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question11" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question11" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question11" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>12</td>
        <td class="lbf">我实在难以忍受与其他罪犯挤在一起</td>
        <td class="lb_option"><input class="common_checkbox" name="question12" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question12" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question12" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question12" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question12" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>13</td>
        <td class="lbf">我感到自己已经是个彻底的失败者</td>
        <td class="lb_option"><input class="common_checkbox" name="question13" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question13" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question13" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question13" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question13" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>14</td>
        <td class="lbf">我对今后的生活已经完全失去了希望</td>
        <td class="lb_option"><input class="common_checkbox" name="question14" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question14" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question14" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question14" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question14" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>15</td>
        <td class="lbf">谁跟我过不去，我就让谁没好日子过</td>
        <td class="lb_option"><input class="common_checkbox" name="question15" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question15" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question15" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question15" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question15" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>16</td>
        <td class="lbf">有仇不报非君子</td>
        <td class="lb_option"><input class="common_checkbox" name="question16" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question16" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question16" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question16" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question16" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>17</td>
        <td class="lbf">惊险的场面常使我兴奋不已</td>
        <td class="lb_option"><input class="common_checkbox" name="question17" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question17" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question17" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question17" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question17" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>18</td>
        <td class="lbf">我喜欢看惊险小说（或电影）</td>
        <td class="lb_option"><input class="common_checkbox" name="question18" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question18" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question18" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question18" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question18" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>19</td>
        <td class="lbf">适当的时候生一场病，对自己是件好事</td>
        <td class="lb_option"><input class="common_checkbox" name="question19" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question19" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question19" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question19" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question19" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>20</td>
        <td class="lbf">有时候多亏生病，自己才避开了很多麻烦</td>
        <td class="lb_option"><input class="common_checkbox" name="question20" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question20" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question20" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question20" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question20" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>21</td>
        <td class="lbf">我从来都不对别人的事评头论足</td>
        <td class="lb_option"><input class="common_checkbox" name="question21" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question21" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question21" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question21" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question21" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>22</td>
        <td class="lbf">人无横财不富，马无夜草不肥</td>
        <td class="lb_option"><input class="common_checkbox" name="question22" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question22" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question22" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question22" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question22" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>23</td>
        <td class="lbf">一个人只要有了权，就会很快弄到钱</td>
        <td class="lb_option"><input class="common_checkbox" name="question23" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question23" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question23" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question23" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question23" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>24</td>
        <td class="lbf">有权不用，过期作废</td>
        <td class="lb_option"><input class="common_checkbox" name="question24" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question24" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question24" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question24" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question24" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>25</td>
        <td class="lbf">遇到挫折，我不知怎么办才好</td>
        <td class="lb_option"><input class="common_checkbox" name="question25" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question25" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question25" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question25" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question25" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>26</td>
        <td class="lbf">有时明知是胡思乱想，自己却控制不住</td>
        <td class="lb_option"><input class="common_checkbox" name="question26" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question26" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question26" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question26" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question26" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>27</td>
        <td class="lbf">只要完成劳动任务就行了，再多做也没用</td>
        <td class="lb_option"><input class="common_checkbox" name="question27" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question27" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question27" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question27" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question27" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>28</td>
        <td class="lbf">服刑人员做的产品，难以保证质量</td>
        <td class="lb_option"><input class="common_checkbox" name="question28" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question28" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question28" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question28" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question28" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>29</td>
        <td class="lbf">我与家人感情一直很好，很稳定</td>
        <td class="lb_option"><input class="common_checkbox" name="question29" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question29" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question29" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question29" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question29" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>30</td>
        <td class="lbf">被捕以来，我曾得到过朋友或单位的帮助</td>
        <td class="lb_option"><input class="common_checkbox" name="question30" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question30" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question30" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question30" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question30" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>31</td>
        <td class="lbf">我很想大叫或摔东西</td>
        <td class="lb_option"><input class="common_checkbox" name="question31" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question31" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question31" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question31" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question31" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>32</td>
        <td class="lbf">看到不顺眼的人，就想教训他一顿</td>
        <td class="lb_option"><input class="common_checkbox" name="question32" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question32" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question32" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question32" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question32" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>33</td>
        <td class="lbf">我对未来感到灰心、悲观、失望，活下去感到很累</td>
        <td class="lb_option"><input class="common_checkbox" name="question33" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question33" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question33" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question33" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question33" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>34</td>
        <td class="lbf">我运气不好，也不相信今后会交好运</td>
        <td class="lb_option"><input class="common_checkbox" name="question34" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question34" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question34" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question34" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question34" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>35</td>
        <td class="lbf">做人不能太心慈手软</td>
        <td class="lb_option"><input class="common_checkbox" name="question35" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question35" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question35" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question35" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question35" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>36</td>
        <td class="lbf">曾经失去的，要加倍要回来</td>
        <td class="lb_option"><input class="common_checkbox" name="question36" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question36" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question36" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question36" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question36" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>37</td>
        <td class="lbf">能得到别人得不到的东西，冒点风险也值得</td>
        <td class="lb_option"><input class="common_checkbox" name="question37" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question37" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question37" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question37" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question37" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>38</td>
        <td class="lbf">经常冒险可以提高一个人的应变能力</td>
        <td class="lb_option"><input class="common_checkbox" name="question38" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question38" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question38" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question38" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question38" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>39</td>
        <td class="lbf">我发觉周围的病犯都过得挺好</td>
        <td class="lb_option"><input class="common_checkbox" name="question39" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question39" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question39" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question39" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question39" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>40</td>
        <td class="lbf">我曾经因为生病而避免被别人责骂</td>
        <td class="lb_option"><input class="common_checkbox" name="question40" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question40" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question40" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question40" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question40" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>41</td>
        <td class="lbf">我从不谈论别人的是非</td>
        <td class="lb_option"><input class="common_checkbox" name="question41" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question41" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question41" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question41" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question41" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>42</td>
        <td class="lbf">想在社会上混出名堂，没有哥们义气不行</td>
        <td class="lb_option"><input class="common_checkbox" name="question42" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question42" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question42" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question42" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question42" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>43</td>
        <td class="lbf">定罪量刑都是法院说了算，不服也没办法</td>
        <td class="lb_option"><input class="common_checkbox" name="question43" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question43" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question43" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question43" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question43" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>44</td>
        <td class="lbf">钱也赔了还要坐牢，真是赔了夫人又折兵</td>
        <td class="lb_option"><input class="common_checkbox" name="question44" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question44" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question44" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question44" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question44" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>45</td>
        <td class="lbf">我不知道为什么经常感到头痛头昏</td>
        <td class="lb_option"><input class="common_checkbox" name="question45" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question45" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question45" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question45" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question45" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>46</td>
        <td class="lbf">我总感到自己有病，可又说不清</td>
        <td class="lb_option"><input class="common_checkbox" name="question46" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question46" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question46" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question46" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question46" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>47</td>
        <td class="lbf">监狱劳动报酬太低了，提不起精神</td>
        <td class="lb_option"><input class="common_checkbox" name="question47" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question47" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question47" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question47" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question47" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>48</td>
        <td class="lbf">监狱劳动保护是形式，所以不必当真</td>
        <td class="lb_option"><input class="common_checkbox" name="question48" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question48" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question48" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question48" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question48" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>49</td>
        <td class="lbf">烦闷的时候，得到过警官、他犯的安慰和帮助</td>
        <td class="lb_option"><input class="common_checkbox" name="question49" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question49" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question49" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question49" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question49" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>50</td>
        <td class="lbf">遇到困难时，我会向警官寻求帮助</td>
        <td class="lb_option"><input class="common_checkbox" name="question50" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question50" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question50" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question50" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question50" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>51</td>
        <td class="lbf">看什么都不顺眼，都觉得烦</td>
        <td class="lb_option"><input class="common_checkbox" name="question51" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question51" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question51" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question51" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question51" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>52</td>
        <td class="lbf">警官处理某些事情有失公平</td>
        <td class="lb_option"><input class="common_checkbox" name="question52" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question52" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question52" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question52" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question52" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>53</td>
        <td class="lbf">管理太严太紧张了，有机会真想发泄一下</td>
        <td class="lb_option"><input class="common_checkbox" name="question53" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question53" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question53" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question53" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question53" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>54</td>
        <td class="lbf">我常幻想一个人死的方式</td>
        <td class="lb_option"><input class="common_checkbox" name="question54" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question54" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question54" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question54" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question54" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>55</td>
        <td class="lbf">我觉得自己是别人的负担，我死了别人会过得更好</td>
        <td class="lb_option"><input class="common_checkbox" name="question55" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question55" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question55" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question55" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question55" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>56</td>
        <td class="lbf">我活得太累了，总想找个机会早些自我结束</td>
        <td class="lb_option"><input class="common_checkbox" name="question56" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question56" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question56" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question56" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question56" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>57</td>
        <td class="lbf">拒绝过我的人，也要让他尝尝被拒绝的滋味</td>
        <td class="lb_option"><input class="common_checkbox" name="question57" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question57" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question57" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question57" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question57" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>58</td>
        <td class="lbf">人若犯我，我一定也会给他点颜色瞧瞧</td>
        <td class="lb_option"><input class="common_checkbox" name="question58" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question58" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question58" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question58" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question58" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>59</td>
        <td class="lbf">宁愿担些风险，也不想错过任何机会</td>
        <td class="lb_option"><input class="common_checkbox" name="question59" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question59" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question59" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question59" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question59" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>60</td>
        <td class="lbf">我对禁止的东西，特别想弄个明白</td>
        <td class="lb_option"><input class="common_checkbox" name="question60" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question60" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question60" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question60" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question60" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>61</td>
        <td class="lbf">遇到解决不了的困难时，我会突然生些莫名其妙的病</td>
        <td class="lb_option"><input class="common_checkbox" name="question61" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question61" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question61" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question61" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question61" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>62</td>
        <td class="lbf">犯人一旦生病，警官的管理和要求就会宽松多了</td>
        <td class="lb_option"><input class="common_checkbox" name="question62" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question62" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question62" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question62" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question62" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>63</td>
        <td class="lbf">我从未有过非分的念头</td>
        <td class="lb_option"><input class="common_checkbox" name="question63" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question63" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question63" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question63" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question63" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>64</td>
        <td class="lbf">劳动、训练、学习已经够累了，管别人干什么</td>
        <td class="lb_option"><input class="common_checkbox" name="question64" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question64" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question64" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question64" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question64" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>65</td>
        <td class="lbf">规矩太多了，令人不痛快</td>
        <td class="lb_option"><input class="common_checkbox" name="question65" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question65" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question65" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question65" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question65" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>66</td>
        <td class="lbf">管它是对是错，只要对自己有利就行</td>
        <td class="lb_option"><input class="common_checkbox" name="question66" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question66" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question66" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question66" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question66" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>67</td>
        <td class="lbf">我总是睡不好</td>
        <td class="lb_option"><input class="common_checkbox" name="question67" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question67" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question67" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question67" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question67" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>68</td>
        <td class="lbf">有时候我感到脑子突然一片空白，什么都想不起来</td>
        <td class="lb_option"><input class="common_checkbox" name="question68" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question68" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question68" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question68" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question68" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>69</td>
        <td class="lbf">完不成劳动产值时，跟别人买一点也行</td>
        <td class="lb_option"><input class="common_checkbox" name="question69" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question69" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question69" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question69" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question69" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>70</td>
        <td class="lbf">劳动改造与思想教育没什么关系</td>
        <td class="lb_option"><input class="common_checkbox" name="question70" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question70" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question70" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question70" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question70" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>71</td>
        <td class="lbf">我能够经常得到别人的关心和帮助</td>
        <td class="lb_option"><input class="common_checkbox" name="question71" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question71" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question71" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question71" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question71" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>72</td>
        <td class="lbf">我与周围的大多数人能够做到互相关心</td>
        <td class="lb_option"><input class="common_checkbox" name="question72" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question72" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question72" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question72" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question72" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>73</td>
        <td class="lbf">我感到烦躁或愤怒时，很想找人发泄</td>
        <td class="lb_option"><input class="common_checkbox" name="question73" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question73" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question73" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question73" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question73" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>74</td>
        <td class="lbf">当我针对你时，你的灾难就开始了</td>
        <td class="lb_option"><input class="common_checkbox" name="question74" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question74" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question74" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question74" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question74" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>75</td>
        <td class="lbf">我常想与死有关的问题</td>
        <td class="lb_option"><input class="common_checkbox" name="question75" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question75" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question75" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question75" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question75" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>76</td>
        <td class="lbf">现实的一切让我心灰意冷，内心很苦闷</td>
        <td class="lb_option"><input class="common_checkbox" name="question76" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question76" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question76" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question76" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question76" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>77</td>
        <td class="lbf">我感到前途一片黑暗、困难重重</td>
        <td class="lb_option"><input class="common_checkbox" name="question77" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question77" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question77" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question77" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question77" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>78</td>
        <td class="lbf">把得罪过我的人收拾以后，心里才感到舒服</td>
        <td class="lb_option"><input class="common_checkbox" name="question78" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question78" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question78" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question78" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question78" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>79</td>
        <td class="lbf">不收拾伤害过我的人，心里就不平衡</td>
        <td class="lb_option"><input class="common_checkbox" name="question79" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question79" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question79" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question79" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question79" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>80</td>
        <td class="lbf">为达到目的不冒险是不行的</td>
        <td class="lb_option"><input class="common_checkbox" name="question80" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question80" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question80" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question80" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question80" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>81</td>
        <td class="lbf">管它三七二十一，搏一搏再说</td>
        <td class="lb_option"><input class="common_checkbox" name="question81" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question81" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question81" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question81" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question81" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>82</td>
        <td class="lbf">我曾以头痛或肚痛为理由，避开过很多麻烦</td>
        <td class="lb_option"><input class="common_checkbox" name="question82" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question82" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question82" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question82" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question82" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>83</td>
        <td class="lbf">生了病就应该减少相应的任务和责任</td>
        <td class="lb_option"><input class="common_checkbox" name="question83" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question83" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question83" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question83" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question83" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>84</td>
        <td class="lbf">我心里从来没有过任何不好的想法</td>
        <td class="lb_option"><input class="common_checkbox" name="question84" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question84" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question84" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question84" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question84" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>85</td>
        <td class="lbf">有钱就有尊严</td>
        <td class="lb_option"><input class="common_checkbox" name="question85" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question85" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question85" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question85" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question85" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>86</td>
        <td class="lbf">宁愿用不太正当的方式谋取利益，也不愿失掉机会</td>
        <td class="lb_option"><input class="common_checkbox" name="question86" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question86" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question86" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question86" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question86" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>87</td>
        <td class="lbf">我常常感到手或脚发重</td>
        <td class="lb_option"><input class="common_checkbox" name="question87" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question87" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question87" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question87" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question87" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>88</td>
        <td class="lbf">总觉得浑身没劲，什么都不想做</td>
        <td class="lb_option"><input class="common_checkbox" name="question88" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question88" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question88" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question88" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question88" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>89</td>
        <td class="lbf">参加劳动就是为了拿成绩减刑，与思想认识无关</td>
        <td class="lb_option"><input class="common_checkbox" name="question89" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question89" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question89" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question89" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question89" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>90</td>
        <td class="lbf">参加劳动有助于掌握实用技能</td>
        <td class="lb_option"><input class="common_checkbox" name="question90" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question90" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question90" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question90" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question90" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>91</td>
        <td class="lbf">我经常参加集体活动</td>
        <td class="lb_option"><input class="common_checkbox" name="question91" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question91" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question91" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question91" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question91" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>92</td>
        <td class="lbf">我常常感到自己孤立无援</td>
        <td class="lb_option"><input class="common_checkbox" name="question92" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question92" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question92" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question92" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question92" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>93</td>
        <td class="lbf">看不顺眼的东西，要搬走或毁掉</td>
        <td class="lb_option"><input class="common_checkbox" name="question93" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question93" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question93" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question93" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question93" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>94</td>
        <td class="lbf">撑死胆大的，饿死胆小的</td>
        <td class="lb_option"><input class="common_checkbox" name="question94" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question94" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question94" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question94" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question94" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>95</td>
        <td class="lbf">我已经失去了继续活下去的勇气</td>
        <td class="lb_option"><input class="common_checkbox" name="question95" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question95" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question95" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question95" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question95" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>96</td>
        <td class="lbf">我曾想过各种自杀的场景</td>
        <td class="lb_option"><input class="common_checkbox" name="question96" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question96" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question96" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question96" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question96" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>97</td>
        <td class="lbf">谁敢惹我，我一定饶不了他</td>
        <td class="lb_option"><input class="common_checkbox" name="question97" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question97" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question97" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question97" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question97" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>98</td>
        <td class="lbf">因为胆子大，自己曾得到过别人得不到的好处</td>
        <td class="lb_option"><input class="common_checkbox" name="question98" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question98" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question98" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question98" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question98" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>99</td>
        <td class="lbf">我从不生气</td>
        <td class="lb_option"><input class="common_checkbox" name="question99" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question99" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question99" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question99" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question99" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>100</td>
        <td class="lbf">小鱼就应该被大鱼吃掉，社会也是这样</td>
        <td class="lb_option"><input class="common_checkbox" name="question100" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question100" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question100" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question100" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question100" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>101</td>
        <td class="lbf">不走捷径，难以成功</td>
        <td class="lb_option"><input class="common_checkbox" name="question101" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question101" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question101" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question101" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question101" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>102</td>
        <td class="lbf">我很难专心思考一个问题</td>
        <td class="lb_option"><input class="common_checkbox" name="question102" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question102" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question102" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question102" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question102" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>103</td>
        <td class="lbf">我总感到烦躁不安，心神不定</td>
        <td class="lb_option"><input class="common_checkbox" name="question103" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question103" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question103" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question103" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question103" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>104</td>
        <td class="lbf">服刑人员应该自觉接受劳动改造</td>
        <td class="lb_option"><input class="common_checkbox" name="question104" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question104" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question104" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question104" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question104" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>105</td>
        <td class="lbf">爱护公物、尊重劳动是应该的</td>
        <td class="lb_option"><input class="common_checkbox" name="question105" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question105" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question105" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question105" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question105" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>106</td>
        <td class="lbf">有些问题得靠武力来解决</td>
        <td class="lb_option"><input class="common_checkbox" name="question106" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question106" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question106" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question106" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question106" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>107</td>
        <td class="lbf">弱肉强食，强者为王，不能给别人骑在头上</td>
        <td class="lb_option"><input class="common_checkbox" name="question107" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question107" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question107" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question107" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question107" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>108</td>
        <td class="lbf">我实在没有勇气再去面对亲朋好友</td>
        <td class="lb_option"><input class="common_checkbox" name="question108" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question108" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question108" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question108" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question108" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>109</td>
        <td class="lbf">我现在对任何事情都失去了兴趣</td>
        <td class="lb_option"><input class="common_checkbox" name="question109" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question109" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question109" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question109" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question109" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>110</td>
        <td class="lbf">我迟早会让得罪过我的人付出代价</td>
        <td class="lb_option"><input class="common_checkbox" name="question110" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question110" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question110" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question110" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question110" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>111</td>
        <td class="lbf">假若有人伤害了我，我一定让他不好过</td>
        <td class="lb_option"><input class="common_checkbox" name="question111" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question111" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question111" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question111" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question111" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>112</td>
        <td class="lbf">富贵险中求</td>
        <td class="lb_option"><input class="common_checkbox" name="question112" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question112" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question112" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question112" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question112" type="radio" value="" /></td>
      </tr>
      <tr>
        <td>113</td>
        <td class="lbf">越惊险，感到越刺激</td>
        <td class="lb_option"><input class="common_checkbox" name="question113" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question113" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question113" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question113" type="radio" value="" /></td>
        <td class="lb_option"><input class="common_checkbox" name="question113" type="radio" value="" /></td>
      </tr>
	</tbody>
    </table>	
  <div class="paper_paging"> 
    共<span id="rows_number"></span>题
  <span id="spanFirst">第一页</span> 
  <button id="spanPre">上一页</button> 
  <button id="spanNext">下一页</button> 
  <span id="spanLast">最后一页</span> 第<span id="spanPageNum"></span>页/共<span id="spanTotalPage"></span>页
  </div>
  <div class="answer_progress">
  <ul><li class="symbol_li" id="question1_symbol">	1</li>
<li class="symbol_li" id="question2_symbol">	2</li>
<li class="symbol_li" id="question3_symbol">	3</li>
<li class="symbol_li" id="question4_symbol">	4</li>
<li class="symbol_li" id="question5_symbol">	5</li>
<li class="symbol_li" id="question6_symbol">	6</li>
<li class="symbol_li" id="question7_symbol">	7</li>
<li class="symbol_li" id="question8_symbol">	8</li>
<li class="symbol_li" id="question9_symbol">	9</li>
<li class="symbol_li" id="question10_symbol">	10</li>
<li class="symbol_li" id="question11_symbol">	11</li>
<li class="symbol_li" id="question12_symbol">	12</li>
<li class="symbol_li" id="question13_symbol">	13</li>
<li class="symbol_li" id="question14_symbol">	14</li>
<li class="symbol_li" id="question15_symbol">	15</li>
<li class="symbol_li" id="question16_symbol">	16</li>
<li class="symbol_li" id="question17_symbol">	17</li>
<li class="symbol_li" id="question18_symbol">	18</li>
<li class="symbol_li" id="question19_symbol">	19</li>
<li class="symbol_li" id="question20_symbol">	20</li>
<li class="symbol_li" id="question21_symbol">	21</li>
<li class="symbol_li" id="question22_symbol">	22</li>
<li class="symbol_li" id="question23_symbol">	23</li>
<li class="symbol_li" id="question24_symbol">	24</li>
<li class="symbol_li" id="question25_symbol">	25</li>
<li class="symbol_li" id="question26_symbol">	26</li>
<li class="symbol_li" id="question27_symbol">	27</li>
<li class="symbol_li" id="question28_symbol">	28</li>
<li class="symbol_li" id="question29_symbol">	29</li>
<li class="symbol_li" id="question30_symbol">	30</li>
<li class="symbol_li" id="question31_symbol">	31</li>
<li class="symbol_li" id="question32_symbol">	32</li>
<li class="symbol_li" id="question33_symbol">	33</li>
<li class="symbol_li" id="question34_symbol">	34</li>
<li class="symbol_li" id="question35_symbol">	35</li>
<li class="symbol_li" id="question36_symbol">	36</li>
<li class="symbol_li" id="question37_symbol">	37</li>
<li class="symbol_li" id="question38_symbol">	38</li>
<li class="symbol_li" id="question39_symbol">	39</li>
<li class="symbol_li" id="question40_symbol">	40</li>
<li class="symbol_li" id="question41_symbol">	41</li>
<li class="symbol_li" id="question42_symbol">	42</li>
<li class="symbol_li" id="question43_symbol">	43</li>
<li class="symbol_li" id="question44_symbol">	44</li>
<li class="symbol_li" id="question45_symbol">	45</li>
<li class="symbol_li" id="question46_symbol">	46</li>
<li class="symbol_li" id="question47_symbol">	47</li>
<li class="symbol_li" id="question48_symbol">	48</li>
<li class="symbol_li" id="question49_symbol">	49</li>
<li class="symbol_li" id="question50_symbol">	50</li>
<li class="symbol_li" id="question51_symbol">	51</li>
<li class="symbol_li" id="question52_symbol">	52</li>
<li class="symbol_li" id="question53_symbol">	53</li>
<li class="symbol_li" id="question54_symbol">	54</li>
<li class="symbol_li" id="question55_symbol">	55</li>
<li class="symbol_li" id="question56_symbol">	56</li>
<li class="symbol_li" id="question57_symbol">	57</li>
<li class="symbol_li" id="question58_symbol">	58</li>
<li class="symbol_li" id="question59_symbol">	59</li>
<li class="symbol_li" id="question60_symbol">	60</li>
<li class="symbol_li" id="question61_symbol">	61</li>
<li class="symbol_li" id="question62_symbol">	62</li>
<li class="symbol_li" id="question63_symbol">	63</li>
<li class="symbol_li" id="question64_symbol">	64</li>
<li class="symbol_li" id="question65_symbol">	65</li>
<li class="symbol_li" id="question66_symbol">	66</li>
<li class="symbol_li" id="question67_symbol">	67</li>
<li class="symbol_li" id="question68_symbol">	68</li>
<li class="symbol_li" id="question69_symbol">	69</li>
<li class="symbol_li" id="question70_symbol">	70</li>
<li class="symbol_li" id="question71_symbol">	71</li>
<li class="symbol_li" id="question72_symbol">	72</li>
<li class="symbol_li" id="question73_symbol">	73</li>
<li class="symbol_li" id="question74_symbol">	74</li>
<li class="symbol_li" id="question75_symbol">	75</li>
<li class="symbol_li" id="question76_symbol">	76</li>
<li class="symbol_li" id="question77_symbol">	77</li>
<li class="symbol_li" id="question78_symbol">	78</li>
<li class="symbol_li" id="question79_symbol">	79</li>
<li class="symbol_li" id="question80_symbol">	80</li>
<li class="symbol_li" id="question81_symbol">	81</li>
<li class="symbol_li" id="question82_symbol">	82</li>
<li class="symbol_li" id="question83_symbol">	83</li>
<li class="symbol_li" id="question84_symbol">	84</li>
<li class="symbol_li" id="question85_symbol">	85</li>
<li class="symbol_li" id="question86_symbol">	86</li>
<li class="symbol_li" id="question87_symbol">	87</li>
<li class="symbol_li" id="question88_symbol">	88</li>
<li class="symbol_li" id="question89_symbol">	89</li>
<li class="symbol_li" id="question90_symbol">	90</li>
<li class="symbol_li" id="question91_symbol">	91</li>
<li class="symbol_li" id="question92_symbol">	92</li>
<li class="symbol_li" id="question93_symbol">	93</li>
<li class="symbol_li" id="question94_symbol">	94</li>
<li class="symbol_li" id="question95_symbol">	95</li>
<li class="symbol_li" id="question96_symbol">	96</li>
<li class="symbol_li" id="question97_symbol">	97</li>
<li class="symbol_li" id="question98_symbol">	98</li>
<li class="symbol_li" id="question99_symbol">	99</li>
<li class="symbol_li" id="question100_symbol">	100</li>
<li class="symbol_li" id="question101_symbol">	101</li>
<li class="symbol_li" id="question102_symbol">	102</li>
<li class="symbol_li" id="question103_symbol">	103</li>
<li class="symbol_li" id="question104_symbol">	104</li>
<li class="symbol_li" id="question105_symbol">	105</li>
<li class="symbol_li" id="question106_symbol">	106</li>
<li class="symbol_li" id="question107_symbol">	107</li>
<li class="symbol_li" id="question108_symbol">	108</li>
<li class="symbol_li" id="question109_symbol">	109</li>
<li class="symbol_li" id="question110_symbol">	110</li>
<li class="symbol_li" id="question111_symbol">	111</li>
<li class="symbol_li" id="question112_symbol">	112</li>
<li class="symbol_li" id="question113_symbol">	113</li>

</ul>
  </div>
</div> 
			<div class="end_of_paper">
			      <button style="font-size: 20px;">保存</button>
				  <button style="font-size: 20px;">提交</button>
				  <button style="font-size: 20px;">下载</button>
				  <button style="font-size: 20px;">打印</button>
                  
                </div>
                           <fieldset class="instruct">
	<legend>指导语：</legend>
	本表由一些关于认识和态度的题目组成。不同的人对这些问题的看法自然是不同的，所以你的回答并没有“对”“错”之分，请你依照你的实际情况和看法，如实回答每道问题。本表每个题目都有五个可供选择的答案（同意、基本同意、不确定、基本不同意、不同意，分别对应为答题卡上的A、B、C、D、E）。每题只能选一个答案，务必回答每一个问题，独立完成，不要有遗漏。
	</fieldset>
            </div>
<script type="text/javascript" src="<c:url value='/resource/js/xljz/paper.js'/>"></script>
</body>

</html>