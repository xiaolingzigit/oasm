<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>合议复议</title>
</head>
<body>
   <script>
	var li = document.getElementsByClassName('option_area')[0].getElementsByTagName('li');
	var div = document.getElementsByClassName('option_table');
	for(var i=0;i<li.length;i++)
	{
		//给每个li自定义一个属性，记录下标
		li[i].setAttribute('data-i',i);

		li[i].onclick = function(){
            $('#childpage').css({
	            'display':'none'
	        });
			$('#childpage').text("加载中...");
			//先将所有div隐藏
			for(var j=0;j<div.length;j++){
				div[j].style.display = 'none';
				li[j].className = '';
			}

			//将当前对应下标的div显示出来
			var index = this.getAttribute('data-i');
			div[index].style.display = 'block';
			this.className = 'option_li_current';
		}
	}
	</script>
    <script type="text/javascript">
        $(function () {

            var fcn = function () {
                $('.js-lk-1').on('click', function () {
                    var _this = $(this);
                    var o = $(this).parent().parent('.cs-tb-ul').parent('.cs-tb-lt');
                    o.find('.cs-dt-2').hide();
                    o.find('.cs-dt-3').hide();
                    $('.js-lk-2').attr('data-isdown', '');
                    $('.js-lk-3').attr('data-isdown', '');
                    if ($(this).attr('data-isdown')) {
                        o.find('.cs-dt-1').slideUp(function () {
                            _this.attr('data-isdown', '');
                            // o.removeClass('cs-b-o');
                        });
                    } else {
                        o.find('.cs-dt-1').slideDown(function () {
                            _this.attr('data-isdown', '1');
                        });
                        // o.removeClass('cs-b-o').addClass('cs-b-o');
                    }

                });
                $('.js-lk-2').on('click', function () {
                    var _this = $(this);
                    var o = $(this).parent().parent('.cs-tb-ul').parent('.cs-tb-lt');
                    o.find('.cs-dt-1').hide();
                    o.find('.cs-dt-3').hide();
                    $('.js-lk-1').attr('data-isdown', '');
                    $('.js-lk-3').attr('data-isdown', '');
                    if ($(this).attr('data-isdown')) {
                        o.find('.cs-dt-2').slideUp(function () {
                            _this.attr('data-isdown', '');
                            // o.removeClass('cs-b-o');
                        });
                    } else {
                        o.find('.cs-dt-2').slideDown(function () {
                            _this.attr('data-isdown', '1');
                        });
                        // o.removeClass('cs-b-o').addClass('cs-b-o');
                    }

                });
                $('.js-lk-3').on('click', function () {
                    var _this = $(this);
                    var o = $(this).parent().parent('.cs-tb-ul').parent('.cs-tb-lt');
                    o.find('.cs-dt-1').hide();
                    o.find('.cs-dt-2').hide();
                    $('.js-lk-1').attr('data-isdown', '');
                    $('.js-lk-2').attr('data-isdown', '');
                    if ($(this).attr('data-isdown')) {
                        o.find('.cs-dt-3').slideUp(function () {
                            _this.attr('data-isdown', '');
                            // o.removeClass('cs-b-o');
                        });
                    } else {
                        o.find('.cs-dt-3').slideDown(function () {
                            _this.attr('data-isdown', '1');
                        });
                        // o.removeClass('cs-b-o').addClass('cs-b-o');
                    }

                });
            }
            fcn();

            var fcn2 = function () {
                var t = function (a) {
                    var tt = '<div class="cs-tbb-tb-box"><div class="cs-tg-it-box"><ul>';
                    tt += '            <li class="cs-tg-it-1">' + a +
                        '</li><li class="cs-tg-it-2"><input />';
                    tt += '           </li></ul></div></div>';
                    return tt;
                }
                $('.js-new-zuy').click(function () {
                    var l = $('.cs-del-b').size() + 1;
                    var html = '<div class="cs-img-b">';
                    html += '  <div class="cs-del-b">';
                    html += '   <span>组员' + l + '</span>';
                    html += '            <a class="cs-a">删除</a>';
                    html += '        </div>';
                    html += t('警号');
                    html += t('警察姓名');
                    html += t('职责');
                    html += t('负责罪犯列表(输入囚号)');
                    html += '</div>';

                    $('.cs-ttt-box').append(html)
                });

                $('.cs-ttt-box').on('click', '.cs-del-b .cs-a', function () {
                    $(this).parent().parent().remove();
                });
            }
            fcn2();
        });
    </script>
	<!--复议与合议-->
	<div id="" class="sub-block">
		<!-- 定位栏-->
		<div class="location">
			<div class="location_left">
				<i><font color="#ffffff"><strong>您现在的位置</strong></font></i>
			</div>
			<div class="location_right">
				<strong>&nbsp;&nbsp;评估管理 >><font color="#ff3300">复议与合议</font></strong>
			</div>
		</div>
		<!-- 功能子块-->
		<div class="main_content">
			<div id="option" class="option_area">
				<ul>
					<li id="dafx" name="dafx" class="option_li_current">已反馈</li>
					<li id="jgft" name="jgft">待反馈</li>
				</ul>
			</div>
			<div id="basecontent" class="main_content_base">
				<div id="dafxtab" class="option_table">
					<h3>
						<font size="" color="#66ccff">已反馈完成罪犯评估报告</font>
					</h3>
					<br>
					<table class="content_table" width="100%">
						<tr>
							<th class="base_th" width="5%">序号</th>
							<th class="base_th" width="10%">囚号</th>
							<th class="base_th" width="10%">罪犯姓名</th>
							<th class="base_th" width="10%">评估报告名称</th>
							<th class="base_th" width="10%">评估更新时间</th>
							<th class="base_th" width="10%">具体意见</th>
						</tr>
						<tr>
							<td>1</td>
							<td>6546545454</td>
							<td>xx</td>
							<td>入监评估报告</td>
							<td>2017-07-07</td>
							<td><a href="#" onclick="loadnext2('/oasm/fyhyView/jgxftlr11')">点击查看</a>
							</td>
						</tr>
						<tr>
							<td>2</td>
							<td>6546545454</td>
							<td>xx</td>
							<td>入监评估报告</td>
							<td>2017-07-07</td>
							<td><a href="#" onclick="loadnext2('/oasm/fyhyView/jgxftlr11')">点击查看</a>
							</td>
						</tr>
					</table>
					<div class="fenye">
						<ul class="fenye-ul">
							<li>共<a style="color: red;">2</a>个记录
							</li>
							<li>共2页</li>
							<li>首页</li>
							<li>上一页</li>
							<li class="fenye-li01">1</li>
							<li class="fenye-li02">2</li>
							<li>下一页</li>
							<li>尾页</li>
							<li>转到第 <input type="text" /> 页
							</li>
						</ul>
					</div>
				</div>
				<div id="jgfttab" class="option_table">
        <div class="base_right_bom cs-yngb-box">
            <div>
                <div class="cs-item">
                    <div class="cs-item-title">
                        <span>待反馈处理罪犯评估报告</span>
                        <a class="cs-a">一键提醒选中</a>
                    </div>
                    <div class="cs-tb-w cs-tb-cl">
                        <ul class="cs-tb-ul">
                            <li class="cs-tb-tr cs-tb-tr-1"></li>
                            <li class="cs-tb-tr cs-tb-tr-2"><span>序号</span></li>
                            <li class="cs-tb-tr cs-tb-tr-3"><span>囚号</span></li>
                            <li class="cs-tb-tr cs-tb-tr-4"><span>囚犯姓名</span></li>
                            <li class="cs-tb-tr cs-tb-tr-5"><span>评估报告名称</span></li>
                            <li class="cs-tb-tr cs-tb-tr-6"><span>评估更新时间</span></li>
                            <li class="cs-tb-tr cs-tb-tr-6"><span>危险程度</span></li>
                            <li class="cs-tb-tr cs-tb-tr-7"><span>监区意见</span></li>
                            <li class="cs-tb-tr cs-tb-tr-8"><span>其他部门意见</span></li>
                        </ul>
                    </div>
                    <div class="cs-tb-w cs-tb-lt">
                        <ul class="cs-tb-ul">
                            <li class="cs-tb-tr cs-tb-tr-1"><input type="checkbox" /></li>
                            <li class="cs-tb-tr cs-tb-tr-2"><span>1</span></li>
                            <li class="cs-tb-tr cs-tb-tr-3"><span>1234567898</span></li>
                            <li class="cs-tb-tr cs-tb-tr-4"><span>张三</span></li>
                            <li class="cs-tb-tr cs-tb-tr-5"><span>入监评估报告</span></li>
                            <li class="cs-tb-tr cs-tb-tr-6"><span>2017-08-09</span></li>
                            <li class="cs-tb-tr cs-tb-tr-7"><span>低度危险</span></li>
                            <li class="cs-tb-tr cs-tb-tr-8 cs-a-bo"><span>无</span></li>
							<li class="cs-tb-tr cs-tb-tr-8 cs-a-bo"><span>同意</span></li>
                        </ul>
                        <div class="cs-dt-1 cs-b-o-2">
                            具体意见：同意
                        </div>
                        <div class="cs-dt-2 cs-b-o-2">
                            待反馈部门：罪犯危险性评估中心、心理矫治办公室、矫正与刑务办公室
                        </div>
                        <div class="cs-dt-3 cs-b-o-2">
                            不同意部门：指挥中心、指挥中心、劳动改造与安全生产办公室
                        </div>
                    </div>
                    <div class="cs-tb-w cs-tb-lt">
                        <ul class="cs-tb-ul">
                            <li class="cs-tb-tr cs-tb-tr-1"><input type="checkbox" /></li>
                            <li class="cs-tb-tr cs-tb-tr-2"><span>2</span></li>
                            <li class="cs-tb-tr cs-tb-tr-3"><span>1234567898</span></li>
                            <li class="cs-tb-tr cs-tb-tr-4"><span>xx</span></li>
                            <li class="cs-tb-tr cs-tb-tr-5"><span>入监评估报告</span></li>
                            <li class="cs-tb-tr cs-tb-tr-6"><span>2017-08-09</span></li>
                           <li class="cs-tb-tr cs-tb-tr-7"><span>低度危险</span></li>
                            <li class="cs-tb-tr cs-tb-tr-8 cs-a-bo"><span>无</span></li>
							<li class="cs-tb-tr cs-tb-tr-8 cs-a-bo"><span>同意</span></li>
                        </ul>
                        <div class="cs-dt-1 cs-b-o-2">
                            具体意见：同意
                        </div>
                        <div class="cs-dt-2 cs-b-o-2">
                            待反馈部门：罪犯危险性评估中心、心理矫治办公室、矫正与刑务办公室
                        </div>
                        <div class="cs-dt-3 cs-b-o-2">
                            不同意部门：指挥中心、指挥中心、劳动改造与安全生产办公室
                        </div>
                    </div>
                  <div class="cs-tb-w cs-tb-lt">
                        <ul class="cs-tb-ul">
                            <li class="cs-tb-tr cs-tb-tr-1"><input type="checkbox" /></li>
                            <li class="cs-tb-tr cs-tb-tr-2"><span>3</span></li>
                            <li class="cs-tb-tr cs-tb-tr-3"><span>1234567898</span></li>
                            <li class="cs-tb-tr cs-tb-tr-4"><span>xx</span></li>
                            <li class="cs-tb-tr cs-tb-tr-5"><span>入监评估报告</span></li>
                            <li class="cs-tb-tr cs-tb-tr-6"><span>2017-08-09</span></li>
                            <li class="cs-tb-tr cs-tb-tr-7"><span>低度危险</span></li>
                            <li class="cs-tb-tr cs-tb-tr-8 cs-a-bo"><span>无</span></li>
							<li class="cs-tb-tr cs-tb-tr-8 cs-a-bo"><span>同意</span></li>
                        </ul>
                        <div class="cs-dt-1 cs-b-o-2">
                            具体意见：同意
                        </div>
                        <div class="cs-dt-2 cs-b-o-2">
                            待反馈部门：罪犯危险性评估中心、心理矫治办公室、矫正与刑务办公室
                        </div>
                        <div class="cs-dt-3 cs-b-o-2">
                            不同意部门：指挥中心、指挥中心、劳动改造与安全生产办公室
                        </div>
                    </div>
                </div>
            </div>

            <div class="cs-item">
                <div class="cs-item-title">其中3份评估报告存在待反馈部门，<span class="cs-a" style="color:red;">点击一键提醒</span>部门处理</div>
                <div class="cs-item-title">1份评估报告存在不同意见，<span class="cs-a" style="color:red;">点击处理</span></div>

                <div class="cs-ynbl-it-b-1">
                    <div class="cs-tbb-tb-box">
                        <div class="cs-tg-it-box">
                            <ul>
                                <li class="cs-tg-it-1">囚号</li>
                                <li class="cs-tg-it-2">
                                    <input value="1234567898" />
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="cs-tbb-tb-box">
                        <div class="cs-tg-it-box">
                            <ul>
                                <li class="cs-tg-it-1">囚犯姓名</li>
                                <li class="cs-tg-it-2">
                                    <input value="张三" />
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="cs-tbb-tb-box">
                        <div class="cs-tg-it-box">
                            <ul>
                                <li class="cs-tg-it-1">评估报告名称</li>
                                <li class="cs-tg-it-2">
                                    <input value="入监评估报告" />
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="cs-tbb-tb-box">
                        <div class="cs-tg-it-box">
                            <ul>
                                <li class="cs-tg-it-1">评估更新时间</li>
                                <li class="cs-tg-it-2">
                                    <input value="2017-05-09" />
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="cs-tbb-tb-box">
                        <div class="cs-tg-it-box">
                            <ul>
                                <li class="cs-tg-it-1">不同意部门</li>
                                <li class="cs-tg-it-2">
                                    <input value="第一监区" />
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="cs-tbb-tb-box">
                        <div class="cs-tg-it-box">
                            <ul>
                                <li class="cs-tg-it-1">反馈意见复议信息</li>
                                <li class="cs-tg-it-2">
                                    <input value="xx" />
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="cs-tbb-tb-box">
                        <div class="cs-tg-it-box">
                            <ul>
                                <li class="cs-tg-it-1">主管部门意见信息填写</li>
                                <li class="cs-tg-it-2">
                                    <input value="xx" />
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="cs-yi-fs">
                        <span class="cs-queren-jainl">意见发送至各部门</span>
                    </div>
                </div>
            </div>
        </div>
				</div>
				                <!--子页面区 -->
				<div id="childpage" class="">
				
			    </div>

			</div>
		</div>
	</div>
</body>
</html>