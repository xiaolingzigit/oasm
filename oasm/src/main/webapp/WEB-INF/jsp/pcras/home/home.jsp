<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>主页</title>

</head>
<body>

	<div class="content_home">
		<div class="left_home">
			<div class="top2_bg_home">危险等级分布</div>
			<div id="basecontent1" class="main_content_base1">
				<div id="dafxtab" class="option_table1">
					<div id='djfb_pie1' class="djfb_pie"></div>
				</div>
				<div id="jgfttab" class="option_table1">
					<div id='djfb_pie2' class="djfb_pie"></div>
				</div>
				<div id="rcgc" class="option_table1">
					<div id='djfb_pie3' class="djfb_pie"></div>
				</div>
				<div id="jgft" class="option_table1">
					<div id='djfb_pie4' class="djfb_pie"></div>
				</div>
				<div id="xlcs" class="option_table1">
					<div id='djfb_pie5' class="djfb_pie"></div>
				</div>
				<div id="zhsx" class="option_table1">

					<div id='djfb_pie6' class="djfb_pie"></div>

				</div>
				<div id="xxpc" class="option_table1">

					<div id='djfb_pie7' class="djfb_pie"></div>

				</div>
				<div id="ttpc" class="option_table1">

					<div id='djfb_pie8' class="djfb_pie"></div>

				</div>
				<div id="zfpc" class="option_table1">

					<div id='djfb_pie9' class="djfb_pie"></div>

				</div>
				<div id="zfpc2" class="option_table1">

					<div id='djfb_pie10' class="djfb_pie"></div>

				</div>
				<div id="zfpc3" class="option_table1">

					<div id='djfb_pie11' class="djfb_pie"></div>

				</div>
				<div id="ttpc1" class="option_table1">

					<div id='djfb_pie12' class="djfb_pie"></div>

				</div>
				<div id="zfpc1" class="option_table1">

					<div id='djfb_pie13' class="djfb_pie"></div>

				</div>
				<div id="zfpc21" class="option_table1">

					<div id="djfb_pie14" class="djfb_pie"></div>

				</div>
				<div id="zfpc31" class="option_table1">

					<div id='djfb_pie15' class="djfb_pie"></div>

				</div>
				<div id="zfpc32" class="option_table1">

					<div id='djfb_pie16' class="djfb_pie"></div>
				</div>
			</div>
			<div id="option1" class="option_area1">
				<ul>
					<li id="dafx" name="dafx" class="option_li_current1" style="width: 9%" data-i="0">全监狱</li>
					<li id="jgft" name="jgft" class="" style="width: 5%" data-i="1">一</li>
					<li id="rcgc" name="rcgc" class="" style="width: 5%" data-i="2">二</li>
					<li id="xlcs" name="xlcs" class="" style="width: 5%" data-i="3">三</li>
					<li id="zhsx" name="zhsx" class="" style="width: 5%" data-i="4">四</li>
					<li id="zspc" name="zspc" class="" style="width: 5%" data-i="5">五</li>
					<li id="xxpc" name="xxpc" class="" style="width: 5%" data-i="6">六</li>
					<li id="ttpc" name="ttpc" class="" style="width: 5%" data-i="7">七</li>
					<li id="zfpc" name="zfpc" class="" style="width: 5%" data-i="8">八</li>
					<li id="zfpc2" name="zfpc" class="" style="width: 5%" data-i="9">九</li>
					<li id="zfpc3" name="zfpc" class="" style="width: 5%" data-i="10">十</li>
					<li id="ttpc1" name="zfpc" class="" style="width: 6%" data-i="11">十二</li>
					<li id="zfpc5" name="zfpc" class="" style="width: 11%" data-i="12">出监管区</li>
					<li id="zfpc6" name="zfpc" class="" style="width: 9%" data-i="13">新犯队</li>
					<li id="zfpc7" name="zfpc" class="" style="width: 6%" data-i="14">医院</li>
					<li id="zfpc8" name="zfpc" class="" style="width: 9%" data-i="15">狱政科</li>
				</ul>
			</div>
		</div>

		<div class="right_home">
			<div class="top2_bg_home">极高危险等级罪犯列表</div>
			<div>
				<table width="100%">
					<colgroup>
						<col width="13%">
						<col width="15%">
						<col width="15%">
						<col width="10%">
						<col width="10%">
						<col width="10%">
						<col width="10%">
						<col width="15%">
						<col width="2%">
					</colgroup>
					<tr>
						<th>监区</th>
						<th>囚号</th>
						<th>姓名</th>
						<th>自杀</th>
						<th>行凶</th>
						<th>脱逃</th>
						<th>再犯罪</th>
						<th>评定时间</th>
						<th></th>
					</tr>
				</table>
				<div style="height: 325px; overflow-y: auto">
					<table width="100%">
						<colgroup>
							<col width="15%">
							<col width="15%">
							<col width="15%">
							<col width="10%">
							<col width="10%">
							<col width="10%">
							<col width="10%">
							<col width="15%">
						</colgroup>
						<tbody id="homeList">
							<!-- <tr style="color:red"><td>三监区</td><td>4413034630</td><td>范东渝</td><td>54</td><td>35</td><td>44</td><td>/</td><td>2017/10/9</td></tr>
<tr style="color:red"><td>三监区</td><td>4413032687</td><td>林吉旺</td><td>55</td><td>36</td><td>45</td><td>/</td><td>2017/10/9</td></tr>
<tr style="color:red"><td>三监区</td><td>4413030694</td><td>胡伟彬</td><td>54</td><td>35</td><td>44</td><td>/</td><td>2017/10/9</td></tr>
<tr style="color:red"><td>三监区</td><td>4413028556</td><td>曾浩宽</td><td>55</td><td>36</td><td>45</td><td>/</td><td>2017/10/9</td></tr>
<tr style="color:red"><td>三监区</td><td>4413028883</td><td>黄少宝</td><td>56</td><td>37</td><td>46</td><td>/</td><td>2017/10/9</td></tr>
<tr><td>三监区</td><td>4413029477</td><td>卓报</td><td>57</td><td>38</td><td>47</td><td>/</td><td>2017/8/4</td></tr>
<tr><td>三监区</td><td>4413029047</td><td>吴剑辉</td><td>60</td><td>41</td><td>50</td><td>/</td><td>2017/8/3</td></tr>
<tr><td>三监区</td><td>4413024512</td><td>陈汉龙</td><td>54</td><td>35</td><td>44</td><td>/</td><td>2017/8/2</td></tr>
<tr><td>三监区</td><td>4413030553</td><td>王仰书</td><td>55</td><td>36</td><td>45</td><td>/</td><td>2017/8/1</td></tr>
<tr><td>三监区</td><td>4413031167</td><td>林育乔</td><td>56</td><td>37</td><td>46</td><td>/</td><td>2017/7/31</td></tr>
<tr><td>三监区</td><td>4413032831</td><td>李发银</td><td>57</td><td>38</td><td>47</td><td>/</td><td>2017/7/30</td></tr>
<tr><td>三监区</td><td>4413033619</td><td>肖建华</td><td>54</td><td>35</td><td>44</td><td>/</td><td>2017/7/29</td></tr>
<tr><td>三监区</td><td>4413033639</td><td>何志钦</td><td>55</td><td>36</td><td>45</td><td>/</td><td>2017/7/28</td></tr>
<tr><td>三监区</td><td>4413033575</td><td>陈洪辉</td><td>57</td><td>38</td><td>47</td><td>/</td><td>2017/7/27</td></tr>
<tr><td>三监区</td><td>4413034385</td><td>范舒明</td><td>60</td><td>41</td><td>50</td><td>/</td><td>2017/7/26</td></tr>
<tr><td>三监区</td><td>4413034512</td><td>周朝阳</td><td>54</td><td>35</td><td>44</td><td>/</td><td>2017/7/25</td></tr>
<tr><td>三监区</td><td>4413033453</td><td>刘杰丹</td><td>55</td><td>36</td><td>45</td><td>/</td><td>2017/7/24</td></tr>
<tr><td>三监区</td><td>4413034707</td><td>李伟雄</td><td>56</td><td>37</td><td>46</td><td>/</td><td>2017/7/23</td></tr>
<tr><td>三监区</td><td>4413032788</td><td>曾锡镇</td><td>55</td><td>36</td><td>45</td><td>/</td><td>2017/7/22</td></tr>
<tr><td>三监区</td><td>4413023675</td><td>林仅进</td><td>56</td><td>37</td><td>46</td><td>/</td><td>2017/7/21</td></tr>
<tr><td>三监区</td><td>4413025732</td><td>曾昭极</td><td>57</td><td>38</td><td>47</td><td>/</td><td>2017/7/20</td></tr>
<tr><td>三监区</td><td>4413022759</td><td>梁颖</td><td>60</td><td>41</td><td>50</td><td>/</td><td>2017/7/19</td></tr>
<tr><td>三监区</td><td>4413029113</td><td>邱加发</td><td>54</td><td>35</td><td>44</td><td>/</td><td>2017/7/18</td></tr>
<tr><td>三监区</td><td>4413029065</td><td>吴金仓</td><td>55</td><td>36</td><td>45</td><td>/</td><td>2017/7/17</td></tr>
<tr><td>三监区</td><td>4413033138</td><td>高奥林</td><td>56</td><td>37</td><td>46</td><td>/</td><td>2017/7/16</td></tr>
<tr><td>三监区</td><td>4413030880</td><td>李海鹏</td><td>55</td><td>36</td><td>45</td><td>/</td><td>2017/7/15</td></tr>
<tr><td>三监区</td><td>4413031774</td><td>陈江锐</td><td>56</td><td>37</td><td>46</td><td>/</td><td>2017/7/14</td></tr>
<tr><td>三监区</td><td>4413034610</td><td>李覃</td><td>57</td><td>38</td><td>47</td><td>/</td><td>2017/7/13</td></tr>

 -->
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript"
		src="<c:url value='/resource/js/jquery-1.7.2.min.js'/>"></script>
	<script type="text/javascript"
		src="<c:url value='/resource/easyui/jquery.easyui.min.js'/>"></script>
	<script type="text/javascript"
		src="<c:url value='/resource/echarts/echarts.min.js'/>"></script>
	<script type="text/javascript"
		src="<c:url value='/resource/js/home.js'/>"></script>
		
	<!-- Echarts图切换代码 -->
	<script>
		var lia = document.getElementsByClassName('option_area1')[0]
				.getElementsByTagName('li');
		var diva = document.getElementsByClassName('option_table1');
		for (var i = 0; i < lia.length; i++) {
			//给每个li自定义一个属性，记录下标
			lia[i].setAttribute('data-i', i);

			lia[i].onclick = function() {
				$('#childpage').css({
					'display' : 'none'
				});
				//先将所有div隐藏
				for (var j = 0; j < diva.length; j++) {
					diva[j].style.display = 'none';
					lia[j].className = '';
				}

				//将当前对应下标的div显示出来
				var index = this.getAttribute('data-i');
				diva[index].style.display = 'block';
				this.className = 'option_li_current1';
			}
		}

		function loadnext4(li) {
			if (li == 'jgwys') {
				$('#gwysgl').click();
				//$('#jgft').click();
				window.setTimeout(function() {
					$('#dafx').click()
				}, 100)
			} else if (li == 'gwys') {
				$('#gwysgl').click();
				//$('#jgft').click();
				window.setTimeout(function() {
					$('#jgft').click()
				}, 100)
			} else if (li == 'zdf') {
				$('#glzftj').click();
				//$('#jgft').click();
				window.setTimeout(function() {
					$('#rcgc').click()
				}, 100)
			} else if (li == 'wwf') {
				$('#glzftj').click();
				//$('#jgft').click();
				window.setTimeout(function() {
					$('#xlcs').click()
				}, 100)
			} else if (li == 'dbrw') {//待办任务
				$('#grmb').click();
				//$('#jgft').click();
				window.setTimeout(function() {
					$('#dbrw').click()
				}, 100)
			} else if (li == 'fbrw') {//发布任务
				$('#grmb').click();
				//$('#jgft').click();
				window.setTimeout(function() {
					$('#sdfb').click()
				}, 100)
			} else if (li == 'wjsp') {//文件审核
				$('#grmb').click();
				//$('#jgft').click();
				window.setTimeout(function() {
					$('#wjsp').click()
				}, 100)
			} else if (li == 'wjbp') {//文件报批
				$('#grmb').click();
				//$('#jgft').click();
				window.setTimeout(function() {
					$('#wjbp').click()
				}, 100)
			}
		}
	</script>

</body>
</html>