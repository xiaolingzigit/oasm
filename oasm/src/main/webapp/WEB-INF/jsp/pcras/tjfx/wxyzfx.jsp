<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>极高危险罪犯因子分析</title>
</head> 
<body>
<h3>
   <font color="#66ccff">极高危险罪犯因子分析</font>
</h3>
			<div id="option" class="option_area">
				<ul>
					<li name="wxyzzh" class="option_li_current">综合</li>
					<li  name="wxyzzs">自杀</li>
				    <li  name="wxyzxx">行凶</li>
				    <li  name="wxyztt">脱逃</li>
				    <li  name="wxyzzf">再犯罪</li>
				</ul>
			</div>
<script type="text/javascript">
$("#option li").click(function(){
	$(this).addClass("option_li_current").siblings().removeClass("option_li_current");
	var svgid=$(this).attr("name");
	$("#"+svgid).css("display","block");
	$("#"+svgid).siblings().css("display","none");
});
</script>
<div style="width:100%" class="wxyzfx">
<div id="wxyzzh" class="bubble_svg"></div>
<div id="wxyzzs" class="bubble_svg"></div>
<div id="wxyzxx" class="bubble_svg"></div>
<div id="wxyztt" class="bubble_svg"></div>
<div id="wxyzzf" class="bubble_svg"></div>
</div>
<script src="<c:url value='/resource/js/d3.js'/>" charset="utf-8"></script>  
<script>
	var width  = 800;	//SVG绘制区域的宽度
	var height = 700;	//SVG绘制区域的高度
			
	var svg1 = d3.select("#wxyzzh")			//选择<body>
			.append("svg")			//在<body>中添加<svg>
			.attr("width", width)	//设定<svg>的宽度属性
			.attr("height", height);
	
	var pack1 = d3.layout.pack()
	    	.size([ width, height ])
	    	.sort(null)
	    	.value(function(d){
	    		return d.weight;
	    	})
		.padding(2);
	
	d3.json("<c:url value='/resource/json/jgwxyz_zh.json'/>",function(error, root){

		var nodes1 = pack1.nodes(root);
		
		console.log(nodes1);
			
		var color1 = d3.scale.category20c();

		var bubbles1 = svg1.selectAll(".bubble")
			.data(nodes1.filter(function(d) { 
				return !d.children; 
			}))
			.enter()
			.append("g")
			.attr("class","bubble");

		bubbles1.append("circle")
			.style("fill",function(d,i){
				return color1(i);
			})
			.attr("cx",function(d){ return d.x; })
			.attr("cy",function(d){ return d.y; })
			.attr("r",function(d){ return d.r; });

		bubbles1.append("text")
			.attr("x",function(d){ return d.x; })
			.attr("y",function(d){ return d.y; })
			.text(function(d){
				var len= d.r/10;
				//alert(len);
				return d.name.substring(0, len);
			});
		bubbles1.append("title")  
        .text(function(d) { 
        	return d.name; 
        	});     
	});
</script>
<script>
	var svg2 = d3.select("#wxyzzs")			//选择<body>
			.append("svg")			//在<body>中添加<svg>
			.attr("width", width)	//设定<svg>的宽度属性
			.attr("height", height);
	
	var pack2 = d3.layout.pack()
	    	.size([ width, height ])
	    	.sort(null)
	    	.value(function(d){
	    		return d.weight;
	    	})
		.padding(2);
	
	d3.json("<c:url value='/resource/json/jgwxyz_zs.json'/>",function(error, root){

		var nodes2 = pack2.nodes(root);
		
		console.log(nodes2);
			
		var color2 = d3.scale.category20c();

		var bubbles2 = svg2.selectAll(".bubble")
			.data(nodes2.filter(function(d) { 
				return !d.children; 
			}))
			.enter()
			.append("g")
			.attr("class","bubble");

		bubbles2.append("circle")
			.style("fill",function(d,i){
				return color2(i);
			})
			.attr("cx",function(d){ return d.x; })
			.attr("cy",function(d){ return d.y; })
			.attr("r",function(d){ return d.r; });

		bubbles2.append("text")
			.attr("x",function(d){ return d.x; })
			.attr("y",function(d){ return d.y; })
			.text(function(d){
				var len= d.r/10;
				//alert(len);
				return d.name.substring(0, len);
			});
		bubbles2.append("title")  
        .text(function(d) { 
        	return d.name; 
        	});     
	});
</script>
<script>
	var svg3 = d3.select("#wxyzxx")			//选择<body>
			.append("svg")			//在<body>中添加<svg>
			.attr("width", width)	//设定<svg>的宽度属性
			.attr("height", height);
	
	var pack3 = d3.layout.pack()
	    	.size([ width, height ])
	    	.sort(null)
	    	.value(function(d){
	    		return d.weight;
	    	})
		.padding(2);
	
	d3.json("<c:url value='/resource/json/jgwxyz_xx.json'/>",function(error, root){

		var nodes3 = pack3.nodes(root);
		
		console.log(nodes3);
			
		var color3 = d3.scale.category20c();

		var bubbles3 = svg3.selectAll(".bubble")
			.data(nodes3.filter(function(d) { 
				return !d.children; 
			}))
			.enter()
			.append("g")
			.attr("class","bubble");

		bubbles3.append("circle")
			.style("fill",function(d,i){
				return color3(i);
			})
			.attr("cx",function(d){ return d.x; })
			.attr("cy",function(d){ return d.y; })
			.attr("r",function(d){ return d.r; });

		bubbles3.append("text")
			.attr("x",function(d){ return d.x; })
			.attr("y",function(d){ return d.y; })
			.text(function(d){
				var len= d.r/10;
				//alert(len);
				return d.name.substring(0, len);
			});
		bubbles3.append("title")  
        .text(function(d) { 
        	return d.name; 
        	});     
	});
</script>
<script>
	var svg4 = d3.select("#wxyztt")			//选择<body>
			.append("svg")			//在<body>中添加<svg>
			.attr("width", width)	//设定<svg>的宽度属性
			.attr("height", height);
	
	var pack4 = d3.layout.pack()
	    	.size([ width, height ])
	    	.sort(null)
	    	.value(function(d){
	    		return d.weight;
	    	})
		.padding(2);
	
	d3.json("<c:url value='/resource/json/jgwxyz_tt.json'/>",function(error, root){

		var nodes4 = pack4.nodes(root);
		
		console.log(nodes4);
			
		var color4 = d3.scale.category20c();

		var bubbles4 = svg4.selectAll(".bubble")
			.data(nodes4.filter(function(d) { 
				return !d.children; 
			}))
			.enter()
			.append("g")
			.attr("class","bubble");

		bubbles4.append("circle")
			.style("fill",function(d,i){
				return color4(i);
			})
			.attr("cx",function(d){ return d.x; })
			.attr("cy",function(d){ return d.y; })
			.attr("r",function(d){ return d.r; });

		bubbles4.append("text")
			.attr("x",function(d){ return d.x; })
			.attr("y",function(d){ return d.y; })
			.text(function(d){
				var len= d.r/10;
				//alert(len);
				return d.name.substring(0, len);
			});
		bubbles4.append("title")  
        .text(function(d) { 
        	return d.name; 
        	});     
	});
</script><script>
	var svg5 = d3.select("#wxyzzf")			//选择<body>
			.append("svg")			//在<body>中添加<svg>
			.attr("width", width)	//设定<svg>的宽度属性
			.attr("height", height);
	
	var pack5 = d3.layout.pack()
	    	.size([ width, height ])
	    	.sort(null)
	    	.value(function(d){
	    		return d.weight;
	    	})
		.padding(2);
	
	d3.json("<c:url value='/resource/json/jgwxyz_zf.json'/>",function(error, root){

		var nodes5 = pack5.nodes(root);
		
		console.log(nodes5);
			
		var color5 = d3.scale.category20c();

		var bubbles5 = svg5.selectAll(".bubble")
			.data(nodes5.filter(function(d) { 
				return !d.children; 
			}))
			.enter()
			.append("g")
			.attr("class","bubble");

		bubbles5.append("circle")
			.style("fill",function(d,i){
				return color5(i);
			})
			.attr("cx",function(d){ return d.x; })
			.attr("cy",function(d){ return d.y; })
			.attr("r",function(d){ return d.r; });

		bubbles5.append("text")
			.attr("x",function(d){ return d.x; })
			.attr("y",function(d){ return d.y; })
			.text(function(d){
				var len= d.r/10;
				//alert(len);
				return d.name.substring(0, len);
			});
		bubbles5.append("title")  
        .text(function(d) { 
        	return d.name; 
        	});     
	});
</script>

</body>  
</html>  
