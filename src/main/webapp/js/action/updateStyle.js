var queryStr = location.href.substring(location.href.indexOf("?") + 1);
var parameters = queryStr.split("=");
var type = parameters[1].split("_")[0];
var id = parameters[1].split("_")[1];

$(function() {
	if("suit"==type){
		doSearch("collar");
		doSearch("breastpocket");
		doSearch("pocket");
		doSearch("buff");
		doSearch("buttonnum");
		doSearch("placket");
		doSearch("back");
		doSearch("botouyan");
		doSearch("buttoneye");
		suitSearch();
	}else if("trousers"==type){
		doSearch("yaotou");
		doSearch("kujiao");
		doSearch("frontdart");
		doSearch("cekoudai");
		doSearch("houkoudai");
		doSearch("kouyan");
		trousersSearch();
	}else if("shirt"==type){
		doSearch("collar");
		doSearch("font");
		doSearch("back");
		doSearch("buff");
		doSearch("breastpocket");
		doSearch("kouyan");
		shirtSearch();
	}else if("vest"==type){
		doSearch("collar");
		doSearch("breastpocket");
		doSearch("pocket");
		doSearch("xiabai");
		doSearch("kouyan");
		vestSearch();
	}
});

$(function() {
	upload();
});


//查找西服配件款式
function doSearch(enName) {
	$.ajax({
		type : "post",
		url : "parts/getParts",
		data : {
			"type" : type,
			"enName" : enName
		},
		dataType : "json",
		async : false,
		success : function(data) {
			if (data.success) {
				var templateList = data.result;

				var tbody = $('#' + enName + 'body');
				tbody.empty();
				if (templateList.length > 0) {
					var tabhtml = '<tr><td class="lable" colspan="5"><label>'+enName+'</label></td></tr>'
					   +  '<tr>'
					   +	   '<td class="lable" >ID</td>'
					   +	   '<td class="lable" >中文名称</td>'
					   +	   '<td class="lable" >工坊名称</td>'
					   +	   '<td class="lable" >模型编号</td>'
					   +	   '<td class="lable" >备注</td>'
					   +  '</tr>';
					for (var i = 0; i < templateList.length; i++) {
						var template = templateList[i];
						var dssid = template.id;
						tabhtml += '<tr>' 
									+ '<td><input type="checkbox" name="' + enName + '" value="' + dssid + '" class="' + enName + '"/></td>' 
									+ '<td>' + template.name + '</td>' 
									+ '<td>' + template.workshopname + '</td>' 
									+ '<td>' + template.modelname + '</td>' 
									+ '<td>' + template.remark + '</td>'
								+ '</tr>'
					}
						tbody.append(tabhtml);
				}
			}
		}
	});
}
// 获取西服要修改的款式配置信息,并展示以前的配置
function suitSearch() {
	$
			.ajax({
				type : "post",
				url : "parts/getStyle",
				data : {
					"id" : id,
					"type": type
				},
				dataType : "json",
				async : false,
				success : function(data) {
					if (data.success) {
						var res = data.result[0];
						$("#styleName").val(res.stylename);
						$("#assetbundle").val(res.assetbundle);
						var collar = res.collar;
						var breastpocket = res.breastpocket;
						var pocket = res.pocket;
						var sleeve = res.sleeve;
						var buttonnum = res.buttonnum;
						var placket = res.placket;
						var back = res.back;
						var botouyan = res.botouyan;
						var buttoneye = res.buttoneye;
						
						$("#suitBom").val(res.suitbom);
						$("#insideBom").val(res.insidebom);
						$("#shirtBom").val(res.shirtbom);
						$("#tieBom").val(res.tiebom);
						$("#kouyanBom").val(res.kouyanbom);
						$("#botouyanBom").val(res.botouyanbom);
						$("#suitButton").val(res.suitbutton);
						$("#shirtButton").val(res.shirtbutton);
						$("#vestButton").val(res.vestbutton);
						$("#trousersButton").val(res.trousersbutton);
						$("#tie").val(res.tie);
						$("#cravat").val(res.cravat);
						
						var check = ( collar + breastpocket + pocket  + sleeve  + buttonnum  + placket  + back  + botouyan  + buttoneye ).split(",");
						
						//遍历所有曾被选中的ids
						for(var i = 0; i < check.length ; i++ ){
							
							var el = document.getElementsByTagName('input');
							 var len = el.length;
							 for (var j = 0; j < len; j++) {
								 if(el[j].value=='1'){
									 el[j].checked=true;
								 }
								 if ((el[j].type == "checkbox") && (el[j].value == check[i]) ){
									 el[j].checked=true;
								 }
							 }
						}
						
						var tbody = $('#imagebody');
						tbody.empty();
						var tabhtml = ""
						tabhtml += '<tr>'
						+ '<td class="lable" colspan="2"><label>SmallImage：</label></td>'
						+ '<td colspan="3"><img alt="SmallImage" src="Dress/data/json/'+type+'/'
						+ res.small_image
						+ '" style="max-width:400px "/><label class="up" for="fileToUpload1" style="width: 80px;"><input id="fileToUpload1" style="" class="bg" type="file" name="upfile"><span style="float: left; margin-left: 5px">上传图片</span></label><input type="text" id="smallimage" style="display:none;" value="'
						+ res.small_image
						+ '" /></td>'
						+ '</tr>'
						+ '<tr>'
						+ '<td class="lable" colspan="2"><label>BigImage：</label></td>'
						+ '<td colspan="3"><img alt="BigImage" src="Dress/data/json/'+type+'/'
						+ res.big_image
						+ '" style="max-width:400px "/><label class="up" for="fileToUpload2" style="width: 80px;"><input id="fileToUpload2" style="" class="bg" type="file" name="upfile"><span style="float: left; margin-left: 5px">上传图片</span></label><input type="text" id="bigimage" style="display:none;" value="'
						+ res.big_image
						+ '" /></td>'
						+ '</tr>';
						tbody.append(tabhtml);
						
					}
				}
			});
}

//获取裤子要修改的款式配置信息,并展示以前的配置
function trousersSearch() {
	$
			.ajax({
				type : "post",
				url : "parts/getStyle",
				data : {
					"id" : id,
					"type": type
				},
				dataType : "json",
				async : false,
				success : function(data) {
					if (data.success) {
						var res = data.result[0];
						$("#styleName").val(res.stylename);
						$("#assetbundle").val(res.assetbundle);
						var yaotou = res.yaotou;
						var kujiao = res.kujiao;
						var frontdart = res.frontdart;
						var cekoudai = res.cekoudai;
						var houkoudai = res.houkoudai;
						var kouyan = res.kouyan;
						
						$("#suitBom").val(res.suitbom);
						$("#insideBom").val(res.insidebom);
						$("#shirtBom").val(res.shirtbom);
						$("#tieBom").val(res.tiebom);
						$("#kouyanBom").val(res.kouyanbom);
						$("#botouyanBom").val(res.botouyanbom);
						$("#suitButton").val(res.suitbutton);
						$("#shirtButton").val(res.shirtbutton);
						$("#vestButton").val(res.vestbutton);
						$("#trousersButton").val(res.trousersbutton);
						$("#tie").val(res.tie);
						$("#cravat").val(res.cravat);
						
						var check = ( yaotou + kujiao + frontdart + cekoudai  + houkoudai  + kouyan ).split(",");
						
						//遍历所有曾被选中的ids
						for(var i = 0; i < check.length ; i++ ){
							
							var el = document.getElementsByTagName('input');
							 var len = el.length;
							 for (var j = 0; j < len; j++) {
								 if(el[j].value=='1'){
									 el[j].checked=true;
								 }
								 
								 if ((el[j].type == "checkbox") && (el[j].value == check[i]) ){
									 el[j].checked=true;
								 }
							 }
						}
						
						var tbody = $('#imagebody');
						tbody.empty();
						var tabhtml = ""
						tabhtml += '<tr>'
						+ '<td class="lable" colspan="2"><label>SmallImage：</label></td>'
						+ '<td colspan="3"><img alt="SmallImage" src="Dress/data/json/'+type+'/'
						+ res.small_image
						+ '" style="max-width:400px "/><label class="up" for="fileToUpload1" style="width: 80px;"><input id="fileToUpload1" style="" class="bg" type="file" name="upfile"><span style="float: left; margin-left: 5px">上传图片</span></label><input type="text" id="smallimage" style="display:none;" value="'
						+ res.small_image
						+ '" /></td>'
						+ '</tr>'
						+ '<tr>'
						+ '<td class="lable" colspan="2"><label>BigImage：</label></td>'
						+ '<td colspan="3"><img alt="BigImage" src="Dress/data/json/'+type+'/'
						+ res.big_image
						+ '" style="max-width:400px "/><label class="up" for="fileToUpload2" style="width: 80px;"><input id="fileToUpload2" style="" class="bg" type="file" name="upfile"><span style="float: left; margin-left: 5px">上传图片</span></label><input type="text" id="bigimage" style="display:none;" value="'
						+ res.big_image
						+ '" /></td>'
						+ '</tr>';
						tbody.append(tabhtml);
						
					}
				}
			});
}

//获取衬衫要修改的款式配置信息,并展示以前的配置
function shirtSearch() {
	$
			.ajax({
				type : "post",
				url : "parts/getStyle",
				data : {
					"id" : id,
					"type": type
				},
				dataType : "json",
				async : false,
				success : function(data) {
					if (data.success) {
						var res = data.result[0];
						$("#styleName").val(res.stylename);
						$("#assetbundle").val(res.assetbundle);
						var collar = res.collar;
						var font = res.font;
						var back = res.back;
						var sleeve = res.sleeve;
						var breastpocket = res.breastpocket;
						var kouyan = res.buttoneye;
						
						$("#suitBom").val(res.suitbom);
						$("#insideBom").val(res.insidebom);
						$("#shirtBom").val(res.shirtbom);
						$("#tieBom").val(res.tiebom);
						$("#kouyanBom").val(res.kouyanbom);
						$("#botouyanBom").val(res.botouyanbom);
						$("#suitButton").val(res.suitbutton);
						$("#shirtButton").val(res.shirtbutton);
						$("#vestButton").val(res.vestbutton);
						$("#trousersButton").val(res.trousersbutton);
						$("#tie").val(res.tie);
						$("#cravat").val(res.cravat);
						
						var check = ( collar + font + back  + sleeve  + breastpocket  + kouyan ).split(",");
						
						//遍历所有曾被选中的ids
						for(var i = 0; i < check.length ; i++ ){
							
							var el = document.getElementsByTagName('input');
							 var len = el.length;
							 for (var j = 0; j < len; j++) {
								 if(el[j].value=='1'){
									 el[j].checked=true;
								 }
								 
								 if ((el[j].type == "checkbox") && (el[j].value == check[i]) ){
									 el[j].checked=true;
								 }
							 }
						}
						
						var tbody = $('#imagebody');
						tbody.empty();
						var tabhtml = ""
						tabhtml += '<tr>'
						+ '<td class="lable" colspan="2"><label>SmallImage：</label></td>'
						+ '<td colspan="3"><img alt="SmallImage" src="Dress/data/json/'+type+'/'
						+ res.small_image
						+ '" style="max-width:400px "/><label class="up" for="fileToUpload1" style="width: 80px;"><input id="fileToUpload1" style="" class="bg" type="file" name="upfile"><span style="float: left; margin-left: 5px">上传图片</span></label><input type="text" id="smallimage" style="display:none;" value="'
						+ res.small_image
						+ '" /></td>'
						+ '</tr>'
						+ '<tr>'
						+ '<td class="lable" colspan="2"><label>BigImage：</label></td>'
						+ '<td colspan="3"><img alt="BigImage" src="Dress/data/json/'+type+'/'
						+ res.big_image
						+ '" style="max-width:400px "/><label class="up" for="fileToUpload2" style="width: 80px;"><input id="fileToUpload2" style="" class="bg" type="file" name="upfile"><span style="float: left; margin-left: 5px">上传图片</span></label><input type="text" id="bigimage" style="display:none;" value="'
						+ res.big_image
						+ '" /></td>'
						+ '</tr>';
						tbody.append(tabhtml);
						
					}
				}
			});
}

//获取马甲要修改的款式配置信息,并展示以前的配置
function vestSearch() {
	$
			.ajax({
				type : "post",
				url : "parts/getStyle",
				data : {
					"id" : id,
					"type": type
				},
				dataType : "json",
				async : false,
				success : function(data) {
					if (data.success) {
						var res = data.result[0];
						$("#styleName").val(res.stylename);
						$("#assetbundle").val(res.assetbundle);
						var collar = res.collar;
						var breastpocket = res.breastpocket;
						var pocket = res.pocket;
						var xiabai = res.xiabai;
						var kouyan = res.kouyan;
						
						$("#suitBom").val(res.suitbom);
						$("#insideBom").val(res.insidebom);
						$("#shirtBom").val(res.shirtbom);
						$("#tieBom").val(res.tiebom);
						$("#kouyanBom").val(res.kouyanbom);
						$("#botouyanBom").val(res.botouyanbom);
						$("#suitButton").val(res.suitbutton);
						$("#shirtButton").val(res.shirtbutton);
						$("#vestButton").val(res.vestbutton);
						$("#trousersButton").val(res.trousersbutton);
						$("#tie").val(res.tie);
						$("#cravat").val(res.cravat);
						
						var check = ( collar + breastpocket + pocket  + xiabai  + kouyan ).split(",");
						
						//遍历所有曾被选中的ids
						for(var i = 0; i < check.length ; i++ ){
							
							var el = document.getElementsByTagName('input');
							 var len = el.length;
							 for (var j = 0; j < len; j++) {
								 if(el[j].value=='1'){
									 el[j].checked=true;
								 }
								 
								 if ((el[j].type == "checkbox") && (el[j].value == check[i]) ){
									 el[j].checked=true;
								 }
							 }
						}
						
						var tbody = $('#imagebody');
						tbody.empty();
						var tabhtml = ""
						tabhtml += '<tr>'
						+ '<td class="lable" colspan="2"><label>SmallImage：</label></td>'
						+ '<td colspan="3"><img alt="SmallImage" src="Dress/data/json/'+type+'/'
						+ res.small_image
						+ '" style="max-width:400px "/><label class="up" for="fileToUpload1" style="width: 80px;"><input id="fileToUpload1" style="" class="bg" type="file" name="upfile"><span style="float: left; margin-left: 5px">上传图片</span></label><input type="text" id="smallimage" style="display:none;" value="'
						+ res.small_image
						+ '" /></td>'
						+ '</tr>'
						+ '<tr>'
						+ '<td class="lable" colspan="2"><label>BigImage：</label></td>'
						+ '<td colspan="3"><img alt="BigImage" src="Dress/data/json/'+type+'/'
						+ res.big_image
						+ '" style="max-width:400px "/><label class="up" for="fileToUpload2" style="width: 80px;"><input id="fileToUpload2" style="" class="bg" type="file" name="upfile"><span style="float: left; margin-left: 5px">上传图片</span></label><input type="text" id="bigimage" style="display:none;" value="'
						+ res.big_image
						+ '" /></td>'
						+ '</tr>';
						tbody.append(tabhtml);
						
					}
				}
			});
}

// 保存
function save() {
	// 验证参数
	if ($("#styleName").val() == "") {
		$("#styleNameError").html("<font style='color:red'>请输入款式名!</font>");
		$("#styleName").focus();
		return false;
	}

	if ($("#styleNameError").html() != "") {
		$("#styleName").focus();
		return false;
	}

	if ($("#assetbundle").val() == "") {
		$("#assetbundleError").html("<font style='color:red'>请输入模型名!</font>");
		$("#assetbundle").focus();
		return false;
	}

	if ($("#assetbundleError").html() != "") {
		$("#assetbundle").focus();
		return false;
	}
	layer.confirm("确定修改吗？", function() {
		
		//获取附选信息
		var el = document.getElementsByTagName('input');
		var len = el.length;
		for (var i = 0; i < len; i++) {
			if ((el[i].type == "checkbox") && (el[i].name == 'checkbox')
					&& (el[i].checked)) {
				el[i].value = '1';
			}
			if ((el[i].type == "checkbox") && (el[i].name == 'checkbox')
					&& (el[i].checked==false)) {
				el[i].value = '0';
			}
		}
		
		if("suit" == type){
		// 获取选中的领子id号
		var collars = '';
//		var length = $("input[name='collar']:checked").length;
//		if (length < 1) {
//			layer.alert("请选择领子信息!", {
//				icon : 2
//			});
//			return false;
//		}
		var el = document.getElementsByTagName('input');
		var len = el.length;
		for (var i = 0; i < len; i++) {
			if ((el[i].type == "checkbox") && (el[i].name == 'collar')
					&& (el[i].checked)) {
				collars = collars + el[i].value + ",";
			}
		}

		// 获取选中的胸袋id号
		var breastPockets = '';
//		var length = $("input[name='breastPocket']:checked").length;
//		if (length < 1) {
//			layer.alert("请选择胸袋信息!", {
//				icon : 2
//			});
//			return false;
//		}
		var el = document.getElementsByTagName('input');
		var len = el.length;
		for (var i = 0; i < len; i++) {
			if ((el[i].type == "checkbox") && (el[i].name == 'breastpocket')
					&& (el[i].checked)) {
				breastPockets = breastPockets + el[i].value + ",";
			}
		}

		// 获取选中的口袋id号
		var pockets = '';
//		var length = $("input[name='pocket']:checked").length;
//		if (length < 1) {
//			layer.alert("请选择口袋信息!", {
//				icon : 2
//			});
//			return false;
//		}
		var el = document.getElementsByTagName('input');
		var len = el.length;
		for (var i = 0; i < len; i++) {
			if ((el[i].type == "checkbox") && (el[i].name == 'pocket')
					&& (el[i].checked)) {
				pockets = pockets + el[i].value + ",";
			}
		}

		// 获取选中的袖子id号
		var sleeves = '';
//		var length = $("input[name='sleeve']:checked").length;
//		if (length < 1) {
//			layer.alert("请选择袖子信息!", {
//				icon : 2
//			});
//			return false;
//		}
		var el = document.getElementsByTagName('input');
		var len = el.length;
		for (var i = 0; i < len; i++) {
			if ((el[i].type == "checkbox") && (el[i].name == 'buff')
					&& (el[i].checked)) {
				sleeves = sleeves + el[i].value + ",";
			}
		}

		// 获取选中的袖扣数量id号
		var buttonNums = '';
//		var length = $("input[name='buttonNum']:checked").length;
//		if (length < 1) {
//			layer.alert("请选择袖扣数量信息!", {
//				icon : 2
//			});
//			return false;
//		}
		var el = document.getElementsByTagName('input');
		var len = el.length;
		for (var i = 0; i < len; i++) {
			if ((el[i].type == "checkbox") && (el[i].name == 'buttonnum')
					&& (el[i].checked)) {
				buttonNums = buttonNums + el[i].value + ",";
			}
		}

		// 获取选中的门襟id号
		var plackets = '';
//		var length = $("input[name='placket']:checked").length;
//		if (length < 1) {
//			layer.alert("请选择门襟信息!", {
//				icon : 2
//			});
//			return false;
//		}
		var el = document.getElementsByTagName('input');
		var len = el.length;
		for (var i = 0; i < len; i++) {
			if ((el[i].type == "checkbox") && (el[i].name == 'placket')
					&& (el[i].checked)) {
				plackets = plackets + el[i].value + ",";
			}
		}

		// 获取选中的后片id号
		var backs = '';
//		var length = $("input[name='back']:checked").length;
//		if (length < 1) {
//			layer.alert("请选择后片信息!", {
//				icon : 2
//			});
//			return false;
//		}
		var el = document.getElementsByTagName('input');
		var len = el.length;
		for (var i = 0; i < len; i++) {
			if ((el[i].type == "checkbox") && (el[i].name == 'back')
					&& (el[i].checked)) {
				backs = backs + el[i].value + ",";
			}
		}
		
		// 获取选中的驳头眼id号
		var botouyans = '';
//		var length = $("input[name='back']:checked").length;
//		if (length < 1) {
//			layer.alert("请选择驳头眼信息!", {
//				icon : 2
//			});
//			return false;
//		}
		var el = document.getElementsByTagName('input');
		var len = el.length;
		for (var i = 0; i < len; i++) {
			if ((el[i].type == "checkbox") && (el[i].name == 'botouyan')
					&& (el[i].checked)) {
				botouyans = botouyans + el[i].value + ",";
			}
		}
		
		// 获取选中的扣眼id号
		var buttonEyes = '';
//		var length = $("input[name='buttonEye']:checked").length;
//		if (length < 1) {
//			layer.alert("请选择扣眼信息!", {
//				icon : 2
//			});
//			return false;
//		}
		var el = document.getElementsByTagName('input');
		var len = el.length;
		for (var i = 0; i < len; i++) {
			if ((el[i].type == "checkbox") && (el[i].name == 'buttoneye')
					&& (el[i].checked)) {
				buttonEyes = buttonEyes + el[i].value + ",";
			}
		}
		$.ajax({
			url : "parts/updateStyle",
			type : "post",
			dataType : "json",
			data : {
				"id" : id,
				"type" : type,
				"styleName" :$("#styleName").val(),
				"assetbundle" :$("#assetbundle").val(),
				"collar" : collars,
				"breastPocket" : breastPockets,
				"pocket" : pockets,
				"sleeve" : sleeves,
				"buttonNum" :buttonNums,
				"placket" : plackets,
				"back" : backs,
				"botouyan" : botouyans,
				"buttonEye" : buttonEyes,
				"smallimage" : $("#smallimage").val(),
				"bigimage" : $("#bigimage").val(),
				"suitbom" : $("#suitBom").val(),
				"shirtbom" : $("#shirtBom").val(),
				"insidebom" : $("#insideBom").val(),
				"kouyanbom" : $("#kouyanBom").val(),
				"botouyanbom" : $("#botouyanBom").val(),
				"tiebom" : $("#tieBom").val(),
				"suitbutton" : $("#suitButton").val(),
				"shirtbutton" : $("#shirtButton").val(),
				"vestbutton" : $("#vestButton").val(),
				"trousersbutton" : $("#trousersButton").val(),
				"tie" : $("#tie").val(),
				"cravat" : $("#cravat").val()
			},
			async : false,
			success : function(data) {
				if (data.success) {
					layer.alert("修改信息成功!", {
						icon : 1
					});
				} else {
					layer.alert("修改信息失败!", {
						icon : 2
					});
				}
				//生成JSON文件
				suitDetailToJson();
				parent.location.reload();
			},
			error : function(data) {
			}
		});
		}else if("trousers"==type){
			// 获取选中的腰头id号
			var yaotous = '';
//			var length = $("input[name='yaotou']:checked").length;
//			if (length < 1) {
//				layer.alert("请选择腰头信息!", {
//					icon : 2
//				});
//				return false;
//			}
			var el = document.getElementsByTagName('input');
			var len = el.length;
			for (var i = 0; i < len; i++) {
				if ((el[i].type == "checkbox") && (el[i].name == 'yaotou')
						&& (el[i].checked)) {
					yaotous = yaotous + el[i].value + ",";
				}
			}

			// 获取选中的裤脚id号
			var kujiaos = '';
//			var length = $("input[name='kujiao']:checked").length;
//			if (length < 1) {
//				layer.alert("请选择裤脚信息!", {
//					icon : 2
//				});
//				return false;
//			}
			var el = document.getElementsByTagName('input');
			var len = el.length;
			for (var i = 0; i < len; i++) {
				if ((el[i].type == "checkbox") && (el[i].name == 'kujiao')
						&& (el[i].checked)) {
					kujiaos = kujiaos + el[i].value + ",";
				}
			}
			
			// 获取选中的前褶id号
			var frontdarts = '';
//			var length = $("input[name='kujiao']:checked").length;
//			if (length < 1) {
//				layer.alert("请选择裤脚信息!", {
//					icon : 2
//				});
//				return false;
//			}
			var el = document.getElementsByTagName('input');
			var len = el.length;
			for (var i = 0; i < len; i++) {
				if ((el[i].type == "checkbox") && (el[i].name == 'frontdart')
						&& (el[i].checked)) {
					frontdarts = frontdarts + el[i].value + ",";
				}
			}

			// 获取选中的侧口袋id号
			var cekoudais = '';
//			var length = $("input[name='cekoudai']:checked").length;
//			if (length < 1) {
//				layer.alert("请选择侧口袋信息!", {
//					icon : 2
//				});
//				return false;
//			}
			var el = document.getElementsByTagName('input');
			var len = el.length;
			for (var i = 0; i < len; i++) {
				if ((el[i].type == "checkbox") && (el[i].name == 'cekoudai')
						&& (el[i].checked)) {
					cekoudais = cekoudais + el[i].value + ",";
				}
			}

			// 获取选中的后口袋id号
			var houkoudais = '';
//			var length = $("input[name='houkoudai']:checked").length;
//			if (length < 1) {
//				layer.alert("请选择后口袋信息!", {
//					icon : 2
//				});
//				return false;
//			}
			var el = document.getElementsByTagName('input');
			var len = el.length;
			for (var i = 0; i < len; i++) {
				if ((el[i].type == "checkbox") && (el[i].name == 'houkoudai')
						&& (el[i].checked)) {
					houkoudais = houkoudais + el[i].value + ",";
				}
			}

			// 获取选中的扣眼id号
			var kouyans = '';
//			var length = $("input[name='kouyan']:checked").length;
//			if (length < 1) {
//				layer.alert("请选择扣眼信息!", {
//					icon : 2
//				});
//				return false;
//			}
			var el = document.getElementsByTagName('input');
			var len = el.length;
			for (var i = 0; i < len; i++) {
				if ((el[i].type == "checkbox") && (el[i].name == 'kouyan')
						&& (el[i].checked)) {
					kouyans = kouyans + el[i].value + ",";
				}
			}
			
			$.ajax({
				url : "parts/updateStyle",
				type : "post",
				dataType : "json",
				data : {
					"id" : id,
					"type" : type,
					"styleName" :$("#styleName").val(),
					"assetbundle" :$("#assetbundle").val(),
					"yaotou" : yaotous,
					"kujiao" : kujiaos,
					"frontdart" : frontdarts,
					"cekoudai" : cekoudais,
					"houkoudai" : houkoudais,
					"kouyan" : kouyans,
					"smallimage" : $("#smallimage").val(),
					"bigimage" : $("#bigimage").val(),
					"suitbom" : $("#suitBom").val(),
					"shirtbom" : $("#shirtBom").val(),
					"insidebom" : $("#insideBom").val(),
					"kouyanbom" : $("#kouyanBom").val(),
					"botouyanbom" : $("#botouyanBom").val(),
					"tiebom" : $("#tieBom").val(),
					"suitbutton" : $("#suitButton").val(),
					"shirtbutton" : $("#shirtButton").val(),
					"vestbutton" : $("#vestButton").val(),
					"trousersbutton" : $("#trousersButton").val(),
					"tie" : $("#tie").val(),
					"cravat" : $("#cravat").val()
				},
				async : false,
				success : function(data) {
					if (data.success) {
						layer.alert("修改信息成功!", {
							icon : 1
						});
					} else {
						layer.alert("修改信息失败!", {});
					}
					parent.location.reload();
				},
				error : function(data) {
				}
			});
		}else if("shirt"==type){
			// 获取选中的腰头id号
			var collars = '';
//			var length = $("input[name='collar']:checked").length;
//			if (length < 1) {
//				layer.alert("请选择领子信息!", {
//					icon : 2
//				});
//				return false;
//			}
			var el = document.getElementsByTagName('input');
			var len = el.length;
			for (var i = 0; i < len; i++) {
				if ((el[i].type == "checkbox") && (el[i].name == 'collar')
						&& (el[i].checked)) {
					collars = collars + el[i].value + ",";
				}
			}

			// 获取选中的正面id号
			var fonts = '';
//			var length = $("input[name='font']:checked").length;
//			if (length < 1) {
//				layer.alert("请选择正面信息!", {
//					icon : 2
//				});
//				return false;
//			}
			var el = document.getElementsByTagName('input');
			var len = el.length;
			for (var i = 0; i < len; i++) {
				if ((el[i].type == "checkbox") && (el[i].name == 'font')
						&& (el[i].checked)) {
					fonts = fonts + el[i].value + ",";
				}
			}

			// 获取选中的背面id号
			var backs = '';
//			var length = $("input[name='back']:checked").length;
//			if (length < 1) {
//				layer.alert("请选择背面信息!", {
//					icon : 2
//				});
//				return false;
//			}
			var el = document.getElementsByTagName('input');
			var len = el.length;
			for (var i = 0; i < len; i++) {
				if ((el[i].type == "checkbox") && (el[i].name == 'back')
						&& (el[i].checked)) {
					backs = backs + el[i].value + ",";
				}
			}

			// 获取选中的袖子id号
			var sleeves = '';
//			var length = $("input[name='sleeve']:checked").length;
//			if (length < 1) {
//				layer.alert("请选择袖子信息!", {
//					icon : 2
//				});
//				return false;
//			}
			var el = document.getElementsByTagName('input');
			var len = el.length;
			for (var i = 0; i < len; i++) {
				if ((el[i].type == "checkbox") && (el[i].name == 'buff')
						&& (el[i].checked)) {
					sleeves = sleeves + el[i].value + ",";
				}
			}

			// 获取选中的胸袋id号
			var breastPockets = '';
//			var length = $("input[name='breastPocket']:checked").length;
//			if (length < 1) {
//				layer.alert("请选择胸袋信息!", {
//					icon : 2
//				});
//				return false;
//			}
			var el = document.getElementsByTagName('input');
			var len = el.length;
			for (var i = 0; i < len; i++) {
				if ((el[i].type == "checkbox") && (el[i].name == 'breastpocket')
						&& (el[i].checked)) {
					breastPockets = breastPockets + el[i].value + ",";
				}
			}
			
			// 获取选中的扣眼id号
			var kouyans = '';
//			var length = $("input[name='kouyan']:checked").length;
//			if (length < 1) {
//				layer.alert("请选择扣眼信息!", {
//					icon : 2
//				});
//				return false;
//			}
			var el = document.getElementsByTagName('input');
			var len = el.length;
			for (var i = 0; i < len; i++) {
				if ((el[i].type == "checkbox") && (el[i].name == 'kouyan')
						&& (el[i].checked)) {
					kouyans = kouyans + el[i].value + ",";
				}
			}
			
			$.ajax({
				url : "parts/updateStyle",
				type : "post",
				dataType : "json",
				data : {
					"id" : id,
					"type" : type,
					"styleName" :$("#styleName").val(),
					"assetbundle" :$("#assetbundle").val(),
					"collar" : collars,
					"font" : fonts,
					"back" : backs,
					"sleeve" : sleeves,
					"breastPocket" : breastPockets,
					"kouyan" : kouyans,
					"smallimage" : $("#smallimage").val(),
					"bigimage" : $("#bigimage").val(),
					"suitbom" : $("#suitBom").val(),
					"shirtbom" : $("#shirtBom").val(),
					"insidebom" : $("#insideBom").val(),
					"kouyanbom" : $("#kouyanBom").val(),
					"botouyanbom" : $("#botouyanBom").val(),
					"tiebom" : $("#tieBom").val(),
					"suitbutton" : $("#suitButton").val(),
					"shirtbutton" : $("#shirtButton").val(),
					"vestbutton" : $("#vestButton").val(),
					"trousersbutton" : $("#trousersButton").val(),
					"tie" : $("#tie").val(),
					"cravat" : $("#cravat").val()
				},
				async : false,
				success : function(data) {
					if (data.success) {
						layer.alert("修改信息成功!", {
							icon : 1
						});
					} else {
						layer.alert("修改信息失败!", {});
					}
					parent.location.reload();
				},
				error : function(data) {
				}
			});
		}else if("vest"==type){
			// 获取选中的领子id号
			var collars = '';
//			var length = $("input[name='collar']:checked").length;
//			if (length < 1) {
//				layer.alert("请选择领子信息!", {
//					icon : 2
//				});
//				return false;
//			}
			var el = document.getElementsByTagName('input');
			var len = el.length;
			for (var i = 0; i < len; i++) {
				if ((el[i].type == "checkbox") && (el[i].name == 'collar')
						&& (el[i].checked)) {
					collars = collars + el[i].value + ",";
				}
			}

			// 获取选中的胸袋id号
			var breastPockets = '';
//			var length = $("input[name='breastPocket']:checked").length;
//			if (length < 1) {
//				layer.alert("请选择胸袋信息!", {
//					icon : 2
//				});
//				return false;
//			}
			var el = document.getElementsByTagName('input');
			var len = el.length;
			for (var i = 0; i < len; i++) {
				if ((el[i].type == "checkbox") && (el[i].name == 'breastpocket')
						&& (el[i].checked)) {
					breastPockets = breastPockets + el[i].value + ",";
				}
			}

			// 获取选中的口袋id号
			var pockets = '';
//			var length = $("input[name='pocket']:checked").length;
//			if (length < 1) {
//				layer.alert("请选择口袋信息!", {
//					icon : 2
//				});
//				return false;
//			}
			var el = document.getElementsByTagName('input');
			var len = el.length;
			for (var i = 0; i < len; i++) {
				if ((el[i].type == "checkbox") && (el[i].name == 'pocket')
						&& (el[i].checked)) {
					pockets = pockets + el[i].value + ",";
				}
			}

			// 获取选中的下摆id号
			var xiabais = '';
//			var length = $("input[name='xiabai']:checked").length;
//			if (length < 1) {
//				layer.alert("请选择下摆信息!", {
//					icon : 2
//				});
//				return false;
//			}
			var el = document.getElementsByTagName('input');
			var len = el.length;
			for (var i = 0; i < len; i++) {
				if ((el[i].type == "checkbox") && (el[i].name == 'xiabai')
						&& (el[i].checked)) {
					xiabais = xiabais + el[i].value + ",";
				}
			}

			// 获取选中的扣眼id号
			var kouyans = '';
//			var length = $("input[name='kouyan']:checked").length;
//			if (length < 1) {
//				layer.alert("请选择扣眼信息!", {
//					icon : 2
//				});
//				return false;
//			}
			var el = document.getElementsByTagName('input');
			var len = el.length;
			for (var i = 0; i < len; i++) {
				if ((el[i].type == "checkbox") && (el[i].name == 'kouyan')
						&& (el[i].checked)) {
					kouyans = kouyans + el[i].value + ",";
				}
			}
				
			$.ajax({
				url : "parts/updateStyle",
				type : "post",
				dataType : "json",
				data : {
					"id" : id,
					"type" : type,
					"styleName" :$("#styleName").val(),
					"assetbundle" :$("#assetbundle").val(),
					"collar" : collars,
					"breastPocket" : breastPockets,
					"pocket" : pockets,
					"xiabai" : xiabais,
					"kouyan" : kouyans,
					"smallimage" : $("#smallimage").val(),
					"bigimage" : $("#bigimage").val(),
					"suitbom" : $("#suitBom").val(),
					"shirtbom" : $("#shirtBom").val(),
					"insidebom" : $("#insideBom").val(),
					"kouyanbom" : $("#kouyanBom").val(),
					"botouyanbom" : $("#botouyanBom").val(),
					"tiebom" : $("#tieBom").val(),
					"suitbutton" : $("#suitButton").val(),
					"shirtbutton" : $("#shirtButton").val(),
					"vestbutton" : $("#vestButton").val(),
					"trousersbutton" : $("#trousersButton").val(),
					"tie" : $("#tie").val(),
					"cravat" : $("#cravat").val()
				},
				async : false,
				success : function(data) {
					if (data.success) {
						layer.alert("修改信息成功!", {
							icon : 1
						});
					} else {
						layer.alert("修改信息失败!", {});
					}
					parent.location.reload();
				},
				error : function(data) {
				}
			});
		}
	});
}

//验证款式名是否为空
function checkStyleName() {
	if ($("#styleName").val() != "") {
		$("#styleNameError").html("");
	} else {
		$("#styleNameError").html("<font style='color:red'>请输入款式名称!</font>");
		$("#styleName").focus();
	}
}

// 验证模型名称是否为空
function checkAssetBundle() {
	if ($("#assetbundle").val() != "") {
		$("#assetbundleError").html("");
	} else {
		$("#assetbundleError").html("<font style='color:red'>请输入模型名称!</font>");
		$("#assetbundle").focus();
	}
}
// 验证模型名称
function checkModelName() {
	if ($("#modelName").val() != "") {
		$("#modelName").val($("#modelName").val());
		$("#modelNameError").html("");
	}
	// else {
	// $("#modelNameError").html("<font style='color:red'>请输入模型名称!</font>");
	// $("#modelName").focus();
	// return;
	// }

	$.ajax({
		type : "post",
		url : "parts/checkModelName",
		data : {
			"type" : type,
			"modelName" : $("#modelName").val()
		},
		dataType : "json",
		async : false,
		success : function(data) {
			if (data.success) {
				$("#modelNameError").html("");
				return;
			} else {
				$("#modelNameError").html(
						"<font style='color:red'>模型已存在，请重新输入!</font>");
				$("#modelName").focus();
				return;
			}
		}
	});
}

// 上传文件
function upload() {
	// 选择文件之后执行上传
	$('#fileToUpload1').on('change', function() {
		$.ajaxFileUpload({
			url : 'parts/upload1',
			type : 'post',
			data : {
				"type" : type,
				"id"   : id,
				"fileName" : $("#smallimage").val(),
				"flag"	:	"smallimage"
			},
			secureuri : false,
			fileElementId : 'fileToUpload1',// file标签的id
			dataType : 'json',// 返回数据的类型
			success : function(data) {
				$("#smallimage").val(data.name);
				setTimeout(function() {
					window.location.reload();
				}, 1500);
			},
			error : function(data, status, e) {
				layer.alert(e, {
					icon : 2
				});
			}
		});
	});

	// 选择文件之后执行上传
	$('#fileToUpload2').on('change', function() {
		$.ajaxFileUpload({
			url : 'parts/upload1',
			type : 'post',
			data : {
				"type" : type,
				"id"   : id,
				"fileName" : $("#bigimage").val(),
				"flag"	:	"bigimage"
			},
			secureuri : false,
			fileElementId : 'fileToUpload2',// file标签的id
			dataType : 'json',// 返回数据的类型
			success : function(data) {
				$("#bigimage").val(data.name);
				setTimeout(function() {
					window.location.reload();
				}, 1500);
			},
			error : function(data, status, e) {
				layer.alert(e, {
					icon : 2
				});
			}
		});
	});
}

//款式配置详情生成JSON文件
function suitDetailToJson() {
	var styleName = null;
	var assetbundle = null;
	var collar = null;
	var breastpocket = null;
	var pocket = null;
	var sleeve = null;
	var buttonnum = null;
	var placket = null;
	var back = null;
	var botouyan = null;
	var buttoneye = null;
	
	//查询款式配置详情
	$
	.ajax({
		type : "post",
		url : "parts/getStyle",
		data : {
			"id" : id,
			"type": type
		},
		dataType : "json",
		async : false,
		success : function(data) {
			if (data.success) {
				var res = data.result[0];
				styleName = res.stylename;
				assetbundle = res.assetbundle;
				collar = res.collar;
				breastpocket = res.breastpocket;
				pocket = res.pocket;
				sleeve = res.sleeve;
				buttonnum = res.buttonnum;
				placket = res.placket;
				back = res.back;
				botouyan = res.botouyan;
				buttoneye = res.buttoneye;
				suitbom = res.suitbom;
				insidebom = res.insidebom;
				shirtbom = res.shirtbom;
				tiebom = res.tiebom;
				button = res.suitbutton;
				tie = res.tie;
				cravat = res.cravat;
				
				//生成JSON文件
		    	 $.ajax({
		 			url : "../../parts/detailToJson",
		 			type : "post",
		 			dataType : "json",
		 			data : {
//		 				"id" : id,
						"type" : type,
						"styleName" :styleName,
						"assetbundle" :assetbundle,
						"collar" : collar,
						"breastPocket" : breastpocket,
						"pocket" : pocket,
						"sleeve" : sleeve,
						"buttonnum" : buttonnum,
						"placket" : placket,
						"back" : back,
						"botouyan" : botouyan,
						"buttoneye" : buttoneye,
						"suitbom" : suitbom,
						"insidebom" : insidebom,
						"shirtbom" : shirtbom,
						"tiebom" : tiebom,
						"tie" : tie,
						"cravat" : cravat,
						"button" : button
		 			},
		 			async : false,
		 			success : function(data) {
		 				if (data.success) {
		 					layer.alert("JSON文件生成成功！", {
		 						icon : 1
		 					});
		 				} else {
		 					layer. alert("JSON文件生成失败！",{
		 						icon :2
		 					});
		 				}
		 			},
		 		});
				
			}
		}
	});
		
		    	 
//	});
}
