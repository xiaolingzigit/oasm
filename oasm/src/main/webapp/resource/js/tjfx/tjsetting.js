		$(".statistical_search_option li").click(function(){
			var index_sub=$(this).index();
			$(this).addClass("statisticaltype_now").siblings().removeClass("statisticaltype_now");
			$(".statistical_search_area").children("div").css("display","none");
			$(".statistical_search_area").children("div").eq(index_sub).css("display","block");
		});
		$("#JG input").click(function(){
			$(this).parents("td").find("*").removeClass("checked_style");
			$(this).next().addClass("checked_style");
			var theid=$(this).attr("id");
			var inputs="";
			switch ($(this).attr("id")) {
			case "China":
			    inputs="<th>请选择：</th><td>"+
			    "<span  class='sub_input_source'>省份：<select class='search_tb_select' ><option>广东省</option></select></span>"+
			    "<span  class='sub_input_source'>市：<select class='search_tb_select'><option>惠州市</option></select></span>"+
				"<span  class='sub_input_source'>镇：<select class='search_tb_select'><option>马鞍镇</option></select></span>"+
			    "</td><td></td>";
			    break;
			case "foreign":
			    inputs="<th>请选择：</th><td>"+
			    "<span  class='sub_input_source'>外籍国家：<select class='search_tb_select'><option>全部</option></select></span>"+
			    "</td><td></td>";
			    break;
				}
			$("#JG_sub").html(inputs);
		});
		$("#info_source input").click(function(){
			var theid=$(this).attr("id");
			$(this).parents("td").find("*").removeClass("checked_style");
			$(this).next().addClass("checked_style");
			var inputs="";
			switch ($(this).attr("id")) {
			case "source1":
			    inputs="<th>请选择：</th><td class='tjsetting_tb_td'>"+
			    "<div class='sub_input_source'><input type='checkbox' name='source1_sub' value='1' 	id='source1_sub_1'/>	<label for='source1_sub_1'>	首犯	</label></div>"+
			    "<div class='sub_input_source'><input type='checkbox' name='source1_sub' value='2'	id='source1_sub_2'/>	<label for='source1_sub_2'>	主犯	</label></div>"+
			    "<div class='sub_input_source'><input type='checkbox' name='source1_sub' value='3'	id='source1_sub_3'/>	<label for='source1_sub_3'>	从犯	</label></div>"+
			    "<div class='sub_input_source'><input type='checkbox' name='source1_sub' value='4'	id='source1_sub_4'/>	<label for='source1_sub_4'>	胁从犯	</label></div>"+
			    "<div class='sub_input_source'><input type='checkbox' name='source1_sub' value='5'	id='source1_sub_5'/>	<label for='source1_sub_5'>	教唆犯	</label></div>"+
			    "<div class='sub_input_source'><input type='checkbox' name='source1_sub' value='6'	id='source1_sub_6'/>	<label for='source1_sub_6'>	共同犯罪	</label></div>"+
			    "</td><td></td>";
			    break;
			case "source3":
				inputs="<th>请选择：</th><td class='tjsetting_tb_td'>"+
			    "<div class='sub_input_source'><input type='checkbox' name='source3_sub' value='2' 	id='source3_sub_2'/>	<label for='source3_sub_2'>	危害国家安全罪	</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='source3_sub' value='15'	id='source3_sub_15'/>	<label for='source3_sub_15'>	危害公共安全罪	</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='source3_sub' value='58'id='source3_sub_58'/><label for='source3_sub_58'>			破坏社会主义市场经济秩序罪	</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='source3_sub' value='161'id='source3_sub_161'/><label for='source3_sub_161'>			侵犯公民人身权利、民主权利罪	</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='source3_sub' value='199'id='source3_sub_199'/><label for='source3_sub_199'>			侵犯财产罪	</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='source3_sub' value='212'id='source3_sub_212'/><label for='source3_sub_212'>			妨害社会管理秩序罪	</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='source3_sub' value='341'id='source3_sub_341'/><label for='source3_sub_341'>			危害国防利益罪	</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='source3_sub' value='363'id='source3_sub_363'/><label for='source3_sub_363'>			贪污贿赂罪	</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='source3_sub' value='376'id='source3_sub_376'/><label for='source3_sub_376'>			渎职罪	</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='source3_sub' value='408'id='source3_sub_408'/><label for='source3_sub_408'>			军人违反职责罪	</label></div>"+
			    "</td><td></td>";
				break;
			case "source4":
				inputs="<th>请选择：</th><td class='tjsetting_tb_td'>"+
			    "<div class='sub_input_source'><input type='checkbox' name='source4_sub' value='1' 	id='source4_sub_1'/>	<label for='source4_sub_1'>	居民身份证	</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='source4_sub' value='2'	id='source4_sub_2'/>	<label for='source4_sub_2'>	临时居民身份证	</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='source4_sub' value='3'	id='source4_sub_3'/>	<label for='source4_sub_3'>	军官证	</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='source4_sub' value='4'	id='source4_sub_4'/>	<label for='source4_sub_4'>	士兵证	</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='source4_sub' value='5'	id='source4_sub_5'/>	<label for='source4_sub_5'>	武警警官证	</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='source4_sub' value='6'	id='source4_sub_6'/>	<label for='source4_sub_6'>	武警士兵证	</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='source4_sub' value='7'	id='source4_sub_7'/>	<label for='source4_sub_7'>	警官证	</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='source4_sub' value='8'	id='source4_sub_8'/>	<label for='source4_sub_8'>	港澳同胞回乡证	</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='source4_sub' value='9'	id='source4_sub_9'/>	<label for='source4_sub_9'>	港澳居民来往内地通行证	</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='source4_sub' value='10'	id='source4_sub_10'/>	<label for='source4_sub_10'>	台湾居民来往大陆通行证	</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='source4_sub' value='11'	id='source4_sub_11'/>	<label for='source4_sub_11'>	护照	</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='source4_sub' value='12'	id='source4_sub_12'/>	<label for='source4_sub_12'>	海员证	</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='source4_sub' value='99'	id='source4_sub_99'/>	<label for='source4_sub_99'>	其他证件	</label></div>"+
			    "</td><td></td>";
				break;			
			case "MZ":
				inputs="<th>请选择：</th><td class='tjsetting_tb_td'>"+
			    "<div class='sub_input_source'><input type='checkbox' name='source7_sub' value='01' 	id='source4_sub_01'/>	<label for='source4_sub_01'>	汉族	</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='source7_sub' value='02'	id='source4_sub_02'/>	<label for='source4_sub_02'>	蒙古族	</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='source7_sub' value='03'	id='source4_sub_03'/>	<label for='source4_sub_03'>	回族	</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='source7_sub' value='04'	id='source4_sub_04'/>	<label for='source4_sub_04'>	藏族	</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='source7_sub' value='05'	id='source4_sub_05'/>	<label for='source4_sub_05'>	维吾尔族	</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='source7_sub' value='06'	id='source4_sub_06'/>	<label for='source4_sub_06'>	苗族	</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='source7_sub' value='07'	id='source4_sub_07'/>	<label for='source4_sub_07'>	彝族	</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='source7_sub' value='08'	id='source4_sub_08'/>	<label for='source4_sub_08'>	壮族	</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='source7_sub' value='09'	id='source4_sub_09'/>	<label for='source4_sub_09'>	布依族	</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='source7_sub' value='10'	id='source4_sub_10'/>	<label for='source4_sub_10'>	朝鲜族	</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='source7_sub' value='11'	id='source4_sub_11'/>	<label for='source4_sub_11'>	满族	</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='source7_sub' value='12'	id='source4_sub_12'/>	<label for='source4_sub_12'>	侗族	</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='source7_sub' value='13'	id='source4_sub_13'/>	<label for='source4_sub_13'>	瑶族	</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='source7_sub' value='14'	id='source4_sub_14'/>	<label for='source4_sub_14'>	白族	</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='source7_sub' value='15'	id='source4_sub_15'/>	<label for='source4_sub_15'>	土家族	</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='source7_sub' value='16'	id='source4_sub_16'/>	<label for='source4_sub_16'>	哈尼族	</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='source7_sub' value='17'	id='source4_sub_17'/>	<label for='source4_sub_17'>	哈萨克族	</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='source7_sub' value='18'	id='source4_sub_18'/>	<label for='source4_sub_18'>	傣族	</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='source7_sub' value='19'	id='source4_sub_19'/>	<label for='source4_sub_19'>	黎族	</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='source7_sub' value='20'	id='source4_sub_20'/>	<label for='source4_sub_20'>	傈僳族	</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='source7_sub' value='21'	id='source4_sub_21'/>	<label for='source4_sub_21'>	佤族	</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='source7_sub' value='22'	id='source4_sub_22'/>	<label for='source4_sub_22'>	畲族	</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='source7_sub' value='23'	id='source4_sub_23'/>	<label for='source4_sub_23'>	高山族	</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='source7_sub' value='24'	id='source4_sub_24'/>	<label for='source4_sub_24'>	拉祜族	</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='source7_sub' value='25'	id='source4_sub_25'/>	<label for='source4_sub_25'>	水族	</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='source7_sub' value='26'	id='source4_sub_26'/>	<label for='source4_sub_26'>	东乡族	</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='source7_sub' value='27'	id='source4_sub_27'/>	<label for='source4_sub_27'>	纳西族	</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='source7_sub' value='28'	id='source4_sub_28'/>	<label for='source4_sub_28'>	景颇族	</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='source7_sub' value='29'	id='source4_sub_29'/>	<label for='source4_sub_29'>	柯尔克孜族	</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='source7_sub' value='30'	id='source4_sub_30'/>	<label for='source4_sub_30'>	土族	</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='source7_sub' value='31'	id='source4_sub_31'/>	<label for='source4_sub_31'>	达斡尔族	</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='source7_sub' value='32'	id='source4_sub_32'/>	<label for='source4_sub_32'>	仫佬族	</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='source7_sub' value='33'	id='source4_sub_33'/>	<label for='source4_sub_33'>	羌族	</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='source7_sub' value='34'	id='source4_sub_34'/>	<label for='source4_sub_34'>	布朗族	</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='source7_sub' value='35'	id='source4_sub_35'/>	<label for='source4_sub_35'>	撒拉族	</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='source7_sub' value='36'	id='source4_sub_36'/>	<label for='source4_sub_36'>	毛南族	</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='source7_sub' value='37'	id='source4_sub_37'/>	<label for='source4_sub_37'>	仡佬族	</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='source7_sub' value='38'	id='source4_sub_38'/>	<label for='source4_sub_38'>	锡伯族	</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='source7_sub' value='39'	id='source4_sub_39'/>	<label for='source4_sub_39'>	阿昌族	</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='source7_sub' value='40'	id='source4_sub_40'/>	<label for='source4_sub_40'>	普米族	</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='source7_sub' value='41'	id='source4_sub_41'/>	<label for='source4_sub_41'>	塔吉克族	</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='source7_sub' value='42'	id='source4_sub_42'/>	<label for='source4_sub_42'>	怒族	</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='source7_sub' value='43'	id='source4_sub_43'/>	<label for='source4_sub_43'>	乌孜别克族	</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='source7_sub' value='44'	id='source4_sub_44'/>	<label for='source4_sub_44'>	俄罗斯族	</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='source7_sub' value='45'	id='source4_sub_45'/>	<label for='source4_sub_45'>	鄂温克族	</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='source7_sub' value='46'	id='source4_sub_46'/>	<label for='source4_sub_46'>	德昂族	</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='source7_sub' value='47'	id='source4_sub_47'/>	<label for='source4_sub_47'>	保安族	</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='source7_sub' value='48'	id='source4_sub_48'/>	<label for='source4_sub_48'>	裕固族	</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='source7_sub' value='49'	id='source4_sub_49'/>	<label for='source4_sub_49'>	京族	</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='source7_sub' value='50'	id='source4_sub_50'/>	<label for='source4_sub_50'>	塔塔尔族	</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='source7_sub' value='51'	id='source4_sub_51'/>	<label for='source4_sub_51'>	独龙族	</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='source7_sub' value='52'	id='source4_sub_52'/>	<label for='source4_sub_52'>	鄂伦春族	</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='source7_sub' value='53'	id='source4_sub_53'/>	<label for='source4_sub_53'>	赫哲族	</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='source7_sub' value='54'	id='source4_sub_54'/>	<label for='source4_sub_54'>	门巴族	</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='source7_sub' value='55'	id='source4_sub_55'/>	<label for='source4_sub_55'>	珞巴族	</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='source7_sub' value='56'	id='source4_sub_56'/>	<label for='source4_sub_56'>	基诺族	</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='source7_sub' value='57'	id='source4_sub_57'/>	<label for='source4_sub_57'>	穿青族	</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='source7_sub' value='99'	id='source4_sub_99'/>	<label for='source4_sub_99'>	其他	</label></div>"+
			    "</td><td></td>";
				break;
			case "BQWHCD":
				inputs="<th>请选择：</th><td class='tjsetting_tb_td'>"+
			    "<div class='sub_input_source'><input type='checkbox' name='BQWHCD_sub' value='10'id='BQWHCD_sub_10'/><label for='BQWHCD_sub_10'>研究生</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='BQWHCD_sub' value='11'id='BQWHCD_sub_11'/><label for='BQWHCD_sub_11'>博士研究生毕业</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='BQWHCD_sub' value='12'id='BQWHCD_sub_12'/><label for='BQWHCD_sub_12'>博士研究生结业</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='BQWHCD_sub' value='13'id='BQWHCD_sub_13'/><label for='BQWHCD_sub_13'>博士研究生肄业</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='BQWHCD_sub' value='14'id='BQWHCD_sub_14'/><label for='BQWHCD_sub_14'>硕士研究生毕业</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='BQWHCD_sub' value='15'id='BQWHCD_sub_15'/><label for='BQWHCD_sub_15'>硕士研究生结业</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='BQWHCD_sub' value='16'id='BQWHCD_sub_16'/><label for='BQWHCD_sub_16'>硕士研究生肄业</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='BQWHCD_sub' value='17'id='BQWHCD_sub_17'/><label for='BQWHCD_sub_17'>研究生班毕业</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='BQWHCD_sub' value='18'id='BQWHCD_sub_18'/><label for='BQWHCD_sub_18'>研究生班结业</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='BQWHCD_sub' value='19'id='BQWHCD_sub_19'/><label for='BQWHCD_sub_19'>研究生班肄业</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='BQWHCD_sub' value='20'id='BQWHCD_sub_20'/><label for='BQWHCD_sub_20'>大学</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='BQWHCD_sub' value='21'id='BQWHCD_sub_21'/><label for='BQWHCD_sub_21'>大学</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='BQWHCD_sub' value='22'id='BQWHCD_sub_22'/><label for='BQWHCD_sub_22'>大学结业</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='BQWHCD_sub' value='23'id='BQWHCD_sub_23'/><label for='BQWHCD_sub_23'>大学肄业</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='BQWHCD_sub' value='28'id='BQWHCD_sub_28'/><label for='BQWHCD_sub_28'>大学普通班毕业</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='BQWHCD_sub' value='2A'id='BQWHCD_sub_2A'/><label for='BQWHCD_sub_2A'>相当大学毕业</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='BQWHCD_sub' value='30'id='BQWHCD_sub_30'/><label for='BQWHCD_sub_30'>大专</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='BQWHCD_sub' value='31'id='BQWHCD_sub_31'/><label for='BQWHCD_sub_31'>大专</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='BQWHCD_sub' value='32'id='BQWHCD_sub_32'/><label for='BQWHCD_sub_32'>大专结业</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='BQWHCD_sub' value='33'id='BQWHCD_sub_33'/><label for='BQWHCD_sub_33'>大专肄业</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='BQWHCD_sub' value='3A'id='BQWHCD_sub_3A'/><label for='BQWHCD_sub_3A'>相当大专毕业</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='BQWHCD_sub' value='40'id='BQWHCD_sub_40'/><label for='BQWHCD_sub_40'>中专、职高、技校</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='BQWHCD_sub' value='41'id='BQWHCD_sub_41'/><label for='BQWHCD_sub_41'>中专</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='BQWHCD_sub' value='42'id='BQWHCD_sub_42'/><label for='BQWHCD_sub_42'>中专结业</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='BQWHCD_sub' value='43'id='BQWHCD_sub_43'/><label for='BQWHCD_sub_43'>中专肄业</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='BQWHCD_sub' value='44'id='BQWHCD_sub_44'/><label for='BQWHCD_sub_44'>职业高中</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='BQWHCD_sub' value='45'id='BQWHCD_sub_45'/><label for='BQWHCD_sub_45'>职业高中结业</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='BQWHCD_sub' value='46'id='BQWHCD_sub_46'/><label for='BQWHCD_sub_46'>职业高中肄业</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='BQWHCD_sub' value='47'id='BQWHCD_sub_47'/><label for='BQWHCD_sub_47'>技校</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='BQWHCD_sub' value='48'id='BQWHCD_sub_48'/><label for='BQWHCD_sub_48'>技校结业</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='BQWHCD_sub' value='49'id='BQWHCD_sub_49'/><label for='BQWHCD_sub_49'>技校肄业</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='BQWHCD_sub' value='60'id='BQWHCD_sub_60'/><label for='BQWHCD_sub_60'>高中</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='BQWHCD_sub' value='61'id='BQWHCD_sub_61'/><label for='BQWHCD_sub_61'>高中</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='BQWHCD_sub' value='62'id='BQWHCD_sub_62'/><label for='BQWHCD_sub_62'>高中结业</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='BQWHCD_sub' value='63'id='BQWHCD_sub_63'/><label for='BQWHCD_sub_63'>高中肄业</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='BQWHCD_sub' value='6A'id='BQWHCD_sub_6A'/><label for='BQWHCD_sub_6A'>相当高中毕业</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='BQWHCD_sub' value='70'id='BQWHCD_sub_70'/><label for='BQWHCD_sub_70'>初中</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='BQWHCD_sub' value='71'id='BQWHCD_sub_71'/><label for='BQWHCD_sub_71'>初中</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='BQWHCD_sub' value='73'id='BQWHCD_sub_73'/><label for='BQWHCD_sub_73'>初中肄业</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='BQWHCD_sub' value='7A'id='BQWHCD_sub_7A'/><label for='BQWHCD_sub_7A'>相当初中毕业</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='BQWHCD_sub' value='80'id='BQWHCD_sub_80'/><label for='BQWHCD_sub_80'>小学</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='BQWHCD_sub' value='81'id='BQWHCD_sub_81'/><label for='BQWHCD_sub_81'>小学</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='BQWHCD_sub' value='83'id='BQWHCD_sub_83'/><label for='BQWHCD_sub_83'>小学肄业</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='BQWHCD_sub' value='8A'id='BQWHCD_sub_8A'/><label for='BQWHCD_sub_8A'>相当小学毕业</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='BQWHCD_sub' value='90'id='BQWHCD_sub_90'/><label for='BQWHCD_sub_90'>文盲/半文盲</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='BQWHCD_sub' value='91'id='BQWHCD_sub_91'/><label for='BQWHCD_sub_91'>文盲/半文盲</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='BQWHCD_sub' value='92'id='BQWHCD_sub_92'/><label for='BQWHCD_sub_92'>文盲</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='BQWHCD_sub' value='93'id='BQWHCD_sub_93'/><label for='BQWHCD_sub_93'>半文盲</label></div>"+
			    "</td><td></td>";
				break;
			case "FYLX":
				inputs="<th>请选择：</th><td class='tjsetting_tb_td'>"+
			    "<div class='sub_input_source'><input type='checkbox' name='FYLX_sub' value='1'	id='FYLX_sub_1'/>	<label for='FYLX_sub_1'>	财产型	</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='FYLX_sub' value='2'	id='FYLX_sub_2'/>	<label for='FYLX_sub_2'>	暴力型	</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='FYLX_sub' value='3'	id='FYLX_sub_3'/>	<label for='FYLX_sub_3'>	淫欲型	</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='FYLX_sub' value='4'	id='FYLX_sub_4'/>	<label for='FYLX_sub_4'>	涉毒型	</label></div>"+
				"<div class='sub_input_source'><input type='checkbox' name='FYLX_sub' value='9'	id='FYLX_sub_9'/>	<label for='FYLX_sub_9'>	其它	</label></div>"+
			    "</td><td></td>";
				break;
	case "CSRQ":
		inputs=	"<th>出生日期范围：</th><td>"+
		'<input type="text"'+
		'				class="select_time search_tb_input" id="StartTime"'+
		'				maxLength="10" onfocus="WdatePicker({dateFmt:\'yyyy-MM-dd\'})"'+
		'				class="search_tb_input" /> 至 <input type="text"'+
		'				class="select_time search_tb_input" id="EndTime"'+
		'				maxLength="10" onfocus="WdatePicker({dateFmt:\'yyyy-MM-dd\'})" />'+
	    "</td><td></td>";
			break;
	case "ZGJC":
		inputs=	"<th>警员信息：</th><td>"+
	    '<span class="sub_input_source">警察警号：'+
		'<input type="text" id="policeId" class="search_tb_input" />'+
		'</span>'+
		'<span class="sub_input_source">警察姓名：'+
		'<input type="text" id="policeName" class="search_tb_input" />'+
		'</span>'+
	    "</td><td></td>";
		break;
	case "XFCS":
		inputs="<th>取值范围：</th><td>"+
		'<span class="sub_input_source"><select class="search_tb_select"  onchange="numcompare(this)">'+
		'<option value=""></option>'+
		'<option value="equal">等于</option>'+
		'<option value="not_equal">不等于</option>'+
		'<option value="less">小于</option>'+
		'<option value="more">大于</option>'+
		'<option value="between">区间内</option>'+
		'<option value="not_between">区间外</option>'+
		'</select></span>'+
		'<span id="num_input"  class="sub_input_source"></span>'+
	    "</td><td></td>";
		break;
	case "source8":
		inputs="<th>匹配内容：</th><td>"+
	    '<span class="sub_input_source"><input type="text" class="search_tb_input"  name="char_val" id="" placeholder="请输入匹配内容···" /></span>'+
	    "</td><td></td>";
		break;
			}
		    $("#source_sub").html(inputs);
		    source_sub_click();
		});
		function numcompare(element){
			var num_input="";
			switch ($(element).val()){
			case "equal":
				num_input='<input type="text" class="search_tb_input" name="number_val1" id="" placeholder="请输入匹配值" />';
				break;
			case "not_equal":
				num_input='<input type="text" class="search_tb_input" name="number_val1" id="" placeholder="请输入排除值" />';
				break;
			case "less":
				num_input='<input type="text" class="search_tb_input" name="number_val1" id="" placeholder="请输入最大值" />';
				break;
			case "more":
				num_input='<input type="text"  class="search_tb_input" name="number_val1" id="" placeholder="请输入最小值" />';
				break;
			case "between":
				num_input='<input type="text" class="search_tb_input" name="number_val1" id="" placeholder="请输入左端点值" />'+
				'--'
				+'<input type="text" class="search_tb_input" name="number_val2" id="" placeholder="请输入右端点值" />';
				break;
			case "not_between":
				num_input='<input type="text" class="search_tb_input" name="number_val1" id="" placeholder="请输入左端点值" />'+
				'-'+
				'<input type="text" class="search_tb_input" name="number_val2" id="" placeholder="请输入右端点值" />';
				break;
			}
			$("#num_input").html(num_input);
		}
		function source_sub_click(){
			$(".sub_input_source input").click(function(){
				if($(this).is(':checked')){
					$(this).next().addClass("checked_style");
				}else{
					$(this).next().removeClass("checked_style");
				}
			});
		}