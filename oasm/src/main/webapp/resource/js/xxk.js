$(function(){
  var li = document.getElementsByClassName('option_area')[0].getElementsByTagName('li');
	var div = document.getElementsByClassName('option_table');
	for(var i=0;i<li.length;i++)
	{
		//给每个li自定义一个属性，记录下标
		li[i].setAttribute('data-i',i);

		li[i].onclick = function(){
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
});