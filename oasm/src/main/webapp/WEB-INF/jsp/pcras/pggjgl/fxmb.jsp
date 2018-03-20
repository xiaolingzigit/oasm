<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0" />
<title>分析面板</title>
</head>
<body>
  <div id="" class="sub-block">
	    <div class="main_content">
	        <span id="fxmbfont">评估报告分析面板</span>
	    	<div class="yzfxmb">
	    		<span>阳性因子分析</span>
	    		<p>说明：阳性因子指对危险性相关明显，对罪犯危险性具有决定性的意义的因子。
	    		一旦出现即可认为某危险类型极高危险倾向或已有危险性发生，通过对因子的筛选和警报，
	    		进行即时处置，或即时进行评估。此时根据实际情况，评估工作经验，进行添加设置。</p>
	    	</div>
	    	<!--所属危险类型div-->
	    	<div class="sswxlx">
	    	   <!--左边输入框-->
	    		<div class="left_wxlbinput">
	    			<div class="wxlxselect">
	    			   <div class="wxselect_one">
	    			   	 <span>所属危险类型:&nbsp;&nbsp;</span>
	    			     <select>
	    			   	   <option>请选择...</option>
	    			     </select>
	    			   </div>
	    			   <div class="wxselect_two">
	    			   	  <select>
	    			   	    <option>请选择...</option>
	    			      </select>
	    			      <button>添加</button>
	    			   </div>
	    			</div>
	    			<div class="wxleiselect_lj">
	    				
	    			</div>
	    		</div>
	    		 <!--右边按钮-->
	    		<div class="right_yzbutton">
	    			<button onclick="loadyzPage('/oasm/pggjglView/yxyz')">查看已有阳性因子</button>
	    		</div>
	    	</div>
			 <div class="yzfxjs">
                    <span>阳性因子分析与解释</span>
                    <!--标签不能换行，否者初始化赋值会居中-->
                	<textarea  rows="3" cols="125">请输入内容...</textarea>                	
             </div>
             <div class="yzcaozuobutton">
                <button class="yzczupdate">修改</button>
                <button class="yzczsave">提交</button>
              </div>
			  <hr/>

			  <!--异常因子-->
			  <div class="yzfxmb">
	    		<span>异常因子分析</span>
	    		<p>说明：异常因子值对极高危罪犯、高度危险罪犯以及中度危险罪犯、低度危险罪犯具有区分能力的因子。
                   此处根据实际情况，评估工作经验，进行添加设置。
	    		</p>
	    	</div>
	    	<!--所属危险类型div-->
	    	<div class="sswxlx">
	    	   <!--左边输入框-->
	    		<div class="left_wxlbinput">
	    			<div class="wxlxselect">
	    			   <div class="wxselect_one">
	    			   	 <span>所属危险类型:&nbsp;&nbsp;</span>
	    			     <select>
	    			   	   <option>请选择...</option>
	    			     </select>
	    			   </div>
	    			   <div class="wxselect_two">
	    			   	  <select>
	    			   	    <option>请选择...</option>
	    			      </select>
	    			      <button>添加</button>
	    			   </div>
	    			</div>
	    			<div class="wxleiselect_lj">
	    				
	    			</div>
	    		</div>
	    		 <!--右边按钮-->
	    		<div class="right_yzbutton">
	    			<button onclick="loadyzPage('/oasm/pggjglView/ycyz')">查看已有异常因子</button>
	    		</div>
	    	</div>
			 <div class="yzfxjs">
                    <span>异常因子分析与解释</span>
                    <!--标签不能换行，否者初始化赋值会居中-->
                	<textarea  rows="3" cols="125">请输入内容...</textarea>                	
             </div>
             <div class="yzcaozuobutton">
                <button class="yzczupdate">修改</button>
                <button class="yzczsave">提交</button>
             </div>
             <div class="mbcaozuobutton">
                <button class="mbdelete">删除</button>
                <button class="mbsave">保存</button>
             </div>
	    </div>
	</div>
</body>
</html>